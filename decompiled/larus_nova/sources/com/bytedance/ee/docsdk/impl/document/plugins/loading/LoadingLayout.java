package com.bytedance.ee.docsdk.impl.document.plugins.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.larksuite.component.ud.button.UDButton;
import com.larus.nova.R;
import com.ss.android.lark.chameleon.util.NetworkCheck;
import com.ss.android.lark.chameleon.util.NetworkType;
import com.ss.android.lark.chameleon.util.UIHelper;
import com.ss.android.lark.chameleon.widget.emptyview.SpaceEmptyState;

/* JADX INFO: loaded from: classes18.dex */
public class LoadingLayout extends FrameLayout implements View.OnTouchListener {
    private static final String TAG = "LoadingLayout";
    private OnBackSourceDocListener mOnBackSourceDocListener;
    private OnRetryListener mOnRetryListener;

    public class EmptyShowInfo {
        int failRes;
        String failString;
        boolean isEditionErr;
        final /* synthetic */ LoadingLayout this$0;

        public EmptyShowInfo(LoadingLayout r100) {
            this.this$0 = r100;
        }
    }

    public interface OnBackSourceDocListener {
        void onBackSourceDoc();
    }

    public interface OnRetryListener {
        void onFailedRetry(int r100);
    }

    public static /* synthetic */ void a(LoadingLayout r100, View r101) {
        r100.lambda$showStatusView$0(r101);
    }

    private boolean isDocDeleteError(int r100) {
        if (r100 != (-55)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isDocumentLoadOvertime(int r100) {
        if (r100 != 999) goto L5;
    L40:
        return true;
    L5:
        if (r100 == 100) goto L40;
        if (r100 == 101) goto L40;
        if (r100 == 400) goto L40;
        if (r100 == 501) goto L40;
        if (r100 == 502) goto L40;
        if (r100 == 503) goto L40;
        if (r100 == 504) goto L40;
        if (r100 == 505) goto L40;
        if (r100 == 506) goto L40;
        if (r100 == 507) goto L40;
        if (r100 == 601) goto L40;
        if (r100 == 602) goto L40;
        if (r100 == 603) goto L40;
        if (r100 == 604) goto L40;
        if (r100 == 605) goto L40;
        if (r100 == 606) goto L40;
        if (r100 == 607) goto L40;
        return false;
    }

    private boolean isEditionDocDeleteError(int r100) {
        if (r100 != (-57)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isEditionDocNotFoundError(int r100) {
        if (r100 != (-58)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isKeyDeleteError(int r100) {
        if (r100 != (-56)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r100, MotionEvent r101) {
        return true;
    }

    public void show() {
        setVisibility(0);
    }

    public void hide() {
        setVisibility(8);
    }

    private void init() {
        FrameLayout.inflate(getContext(), R.layout.doc_empty_layout, this);
    }

    public void loading() {
        findViewById(R.id.ll_loading).setVisibility(0);
        findViewById(R.id.facade_no_data_empty_state).setVisibility(8);
        setOnClickListener(null);
        TextView r100 = (TextView) findViewById(R.id.err_code);
        if (r100 == null) goto L6;
        r100.setVisibility(8);
        return;
    }

    public LoadingLayout(Context r100) {
        this(r100, null);
    }

    public static /* synthetic */ OnRetryListener access$000(LoadingLayout r100) {
        return r100.mOnRetryListener;
    }

    public static /* synthetic */ OnBackSourceDocListener access$100(LoadingLayout r100) {
        return r100.mOnBackSourceDocListener;
    }

    private EmptyShowInfo getEmptyShowInfoByCode(int r100) {
        EmptyShowInfo r101 = new EmptyShowInfo(this);
        r101.isEditionErr = false;
        if (isNetError(r100) == false) goto L6;
        r101.failRes = R.drawable.chameleonv1_illustration_empty_negative_no_wifi;
        r101.failString = getResources().getString(R.string.Doc_Facade_NetworkInterrutedRetry);
    L21:
        return r101;
    L6:
        if (isOvertimeError(r100) == false) goto L9;
        r101.failRes = R.drawable.chameleonv1_illustration_empty_negative_load_failed;
        r101.failString = getResources().getString(R.string.LarkCCM_Docs_Error_LoadOT_Mob);
        goto L21
    L9:
        if (isDocDeleteError(r100) == false) goto L12;
        r101.failRes = R.drawable.chameleonv1_illustration_vc_empty_neutral_recycle_bin;
        r101.failString = getResources().getString(R.string.CreationMobile_ECM_DocsDeletedDesc);
        goto L21
    L12:
        if (isEditionDocNotFoundError(r100) == false) goto L15;
        r101.failRes = R.drawable.chameleonv1_illustration_empty_neutral_no_content;
        r101.failString = getResources().getString(R.string.LarkCCM_Docx_VersionMgmt_DocNonExist_Mob);
        r101.isEditionErr = true;
        goto L21
    L15:
        if (isEditionDocDeleteError(r100) == false) goto L18;
        r101.failRes = R.drawable.chameleonv1_illustration_empty_neutral_no_content;
        r101.failString = getResources().getString(R.string.LarkCCM_Docx_VersionMgmt_Deleted);
        r101.isEditionErr = true;
        goto L21
    L18:
        if (isKeyDeleteError(r100) == false) goto L20;
        r101.failRes = R.drawable.chameleonv1_illustration_ccm_empty_neutral_document_key_unavailable;
        r101.failString = getResources().getString(R.string.CreationDoc_Docs_KeyInvalidCanNotRead);
        goto L21
    L20:
        r101.failRes = R.drawable.chameleonv1_illustration_empty_negative_load_failed;
        r101.failString = getResources().getString(R.string.LarkCCM_Docs_LoadError_Mob);
        goto L21
    }

    private String getErrorDomain(int r100) {
        if (isOvertimeError(r100) == false) goto L6;
        return ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
    L6:
        return "";
    }

    private boolean isNetError(int r100) {
        if (r100 != (-1)) goto L5;
    L8:
        return true;
    L5:
        if (NetworkCheck.getNetworkState(getContext()) == NetworkType.NETWORK_NO) goto L8;
        return false;
    }

    private boolean isOvertimeError(int r100) {
        if (r100 != (-2)) goto L5;
    L12:
        return true;
    L5:
        if (r100 == (-600)) goto L12;
        if (r100 == (-50)) goto L12;
        if (isDocumentLoadOvertime(r100) == true) goto L12;
        return false;
    }

    private /* synthetic */ void lambda$showStatusView$0(View r100) {
        OnBackSourceDocListener r101 = this.mOnBackSourceDocListener;
        if (r101 == null) goto L6;
        r101.onBackSourceDoc();
        return;
    }

    private void showStatusView(final int r100) {
        SpaceEmptyState r101 = (SpaceEmptyState) findViewById(R.id.facade_no_data_empty_state);
        r101.setVisibility(0);
        EmptyShowInfo r102 = getEmptyShowInfoByCode(r100);
        r101.setImageRes(Integer.valueOf(r102.failRes));
        r101.setDesc(String.format("%s", new Object[]{r102.failString}));
        if (r102.isEditionErr == true) goto L5;
        setOnClickListener(new AnonymousClass1(this, r100));
        return;
    L5:
        UDButton r103 = (UDButton) findViewById(R.id.btn_back_source_doc);
        if (isEditionDocDeleteError(r100) == false) goto L8;
        r103.setVisibility(0);
        r103.setOnClickListener(new c(this));
    L9:
        setClickable(false);
        setFocusable(false);
        return;
    L8:
        r103.setVisibility(8);
        goto L9
    }

    private void showStatusViewWithNewErrorOpt(final int r100) {
        SpaceEmptyState r101 = (SpaceEmptyState) findViewById(R.id.facade_no_data_empty_state);
        r101.setVisibility(0);
        final TextView r102 = (TextView) findViewById(R.id.err_code);
        final EmptyShowInfo r103 = getEmptyShowInfoByCode(r100);
        r101.setImageRes(Integer.valueOf(r103.failRes));
        r102.setText(UIHelper.mustacheFormat(getContext(), R.string.LarkCCM_Docs_ErrorCode_Mob, "code", getErrorDomain(r100) + r100));
        r101.setDesc(String.format("%s", new Object[]{r103.failString}));
        if (isEditionDocDeleteError(r100) == false) goto L6;
        r101.setPrimaryText(getResources().getString(R.string.LarkCCM_Docx_VersionMgmt_View_Back2Ori_Button));
    L15:
        if (isDocDeleteError(r100) == false) goto L17;
    L19:
        r101.setPrimaryClickListener(new AnonymousClass2(this, r103, r102, r100));
        return;
    L17:
        if (isKeyDeleteError(r100) == true) goto L19;
        r102.setVisibility(0);
        goto L19
    L6:
        if (isEditionDocNotFoundError(r100) == false) goto L8;
    L13:
        r101.setPrimaryText(null);
        goto L15
    L8:
        if (isDocDeleteError(r100) == true) goto L13;
        if (isKeyDeleteError(r100) == true) goto L13;
        r101.setPrimaryText(getResources().getString(R.string.LarkCCM_Docs_ErrorRefresh_Button_Mob));
        goto L15
    }

    @Override // android.view.View
    public void setClickable(boolean r100) {
        super.setClickable(r100);
    }

    public void setOnBackSourceDocListener(OnBackSourceDocListener r100) {
        this.mOnBackSourceDocListener = r100;
    }

    public void setOnRetryListener(OnRetryListener r100) {
        this.mOnRetryListener = r100;
    }

    public LoadingLayout(Context r100, AttributeSet r101) {
        this(r100, r101, -1);
    }

    public void fail(int r100, String r101) {
        if (findViewById(R.id.ll_loading) == null) goto L5;
        findViewById(R.id.ll_loading).setVisibility(8);
    L5:
        showStatusViewWithNewErrorOpt(r100);
    }

    public LoadingLayout(Context r100, int r101, String r102) {
        super(r100);
        init();
        fail(r101, r102);
    }

    public LoadingLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        init();
        loading();
    }
}
