package com.bytedance.ee.docsdk.impl.document.plugins.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larksuite.component.ud.button.UDButton;
import com.ss.android.lark.chameleon.util.NetworkCheck;
import com.ss.android.lark.chameleon.util.NetworkType;
import com.ss.android.lark.chameleon.util.UIHelper;
import com.ss.android.lark.chameleon.widget.emptyview.SpaceEmptyState;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class LoadingLayout extends FrameLayout implements View.OnTouchListener {
    private static final String TAG = "LoadingLayout";
    private OnBackSourceDocListener mOnBackSourceDocListener;
    private OnRetryListener mOnRetryListener;

    public class EmptyShowInfo {
        int failRes;
        String failString;
        boolean isEditionErr;
        final /* synthetic */ LoadingLayout this$0;

        public EmptyShowInfo(LoadingLayout r1) {
            this.this$0 = r1;
        }
    }

    public interface OnBackSourceDocListener {
        void onBackSourceDoc();
    }

    public interface OnRetryListener {
        void onFailedRetry(int r1);
    }

    public static /* synthetic */ void a(LoadingLayout r0, View r1) {
        r0.lambda$showStatusView$0(r1);
    }

    private boolean isDocDeleteError(int r2) {
        if (r2 != (-55)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isDocumentLoadOvertime(int r2) {
        if (r2 != 999) goto L5;
    L40:
        return true;
    L5:
        if (r2 == 100) goto L40;
        if (r2 == 101) goto L40;
        if (r2 == 400) goto L40;
        if (r2 == 501) goto L40;
        if (r2 == 502) goto L40;
        if (r2 == 503) goto L40;
        if (r2 == 504) goto L40;
        if (r2 == 505) goto L40;
        if (r2 == 506) goto L40;
        if (r2 == 507) goto L40;
        if (r2 == 601) goto L40;
        if (r2 == 602) goto L40;
        if (r2 == 603) goto L40;
        if (r2 == 604) goto L40;
        if (r2 == 605) goto L40;
        if (r2 == 606) goto L40;
        if (r2 == 607) goto L40;
        return false;
    }

    private boolean isEditionDocDeleteError(int r2) {
        if (r2 != (-57)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isEditionDocNotFoundError(int r2) {
        if (r2 != (-58)) goto L5;
        return true;
    L5:
        return false;
    }

    private boolean isKeyDeleteError(int r2) {
        if (r2 != (-56)) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r1, MotionEvent r2) {
        return true;
    }

    public void show() {
        setVisibility(0);
    }

    public void hide() {
        setVisibility(8);
    }

    private void init() {
        FrameLayout.inflate(getContext(), 2131560079, this);
    }

    public void loading() {
        findViewById(2131378741).setVisibility(0);
        findViewById(2131372043).setVisibility(8);
        setOnClickListener(null);
        TextView r0 = (TextView) findViewById(2131371737);
        if (r0 == null) goto L6;
        r0.setVisibility(8);
        return;
    }

    public LoadingLayout(Context r2) {
        this(r2, null);
    }

    public static /* synthetic */ OnRetryListener access$000(LoadingLayout r0) {
        return r0.mOnRetryListener;
    }

    public static /* synthetic */ OnBackSourceDocListener access$100(LoadingLayout r0) {
        return r0.mOnBackSourceDocListener;
    }

    private EmptyShowInfo getEmptyShowInfoByCode(int r6) {
        EmptyShowInfo r0 = new EmptyShowInfo(this);
        r0.isEditionErr = false;
        if (isNetError(r6) == false) goto L6;
        r0.failRes = 2131232585;
        r0.failString = getResources().getString(2131887782);
    L21:
        return r0;
    L6:
        if (isOvertimeError(r6) == false) goto L9;
        r0.failRes = 2131232584;
        r0.failString = getResources().getString(2131889053);
        goto L21
    L9:
        if (isDocDeleteError(r6) == false) goto L12;
        r0.failRes = 2131232587;
        r0.failString = getResources().getString(2131887257);
        goto L21
    L12:
        if (isEditionDocNotFoundError(r6) == false) goto L15;
        r0.failRes = 2131232586;
        r0.failString = getResources().getString(2131889365);
        r0.isEditionErr = true;
        goto L21
    L15:
        if (isEditionDocDeleteError(r6) == false) goto L18;
        r0.failRes = 2131232586;
        r0.failString = getResources().getString(2131889364);
        r0.isEditionErr = true;
        goto L21
    L18:
        if (isKeyDeleteError(r6) == false) goto L20;
        r0.failRes = 2131232583;
        r0.failString = getResources().getString(2131887106);
        goto L21
    L20:
        r0.failRes = 2131232584;
        r0.failString = getResources().getString(2131889107);
        goto L21
    }

    private String getErrorDomain(int r1) {
        if (isOvertimeError(r1) == false) goto L6;
        return "A";
    L6:
        return "";
    }

    private boolean isNetError(int r2) {
        if (r2 != (-1)) goto L5;
    L8:
        return true;
    L5:
        if (NetworkCheck.getNetworkState(getContext()) == NetworkType.NETWORK_NO) goto L8;
        return false;
    }

    private boolean isOvertimeError(int r2) {
        if (r2 != (-2)) goto L5;
    L12:
        return true;
    L5:
        if (r2 == (-600)) goto L12;
        if (r2 == (-50)) goto L12;
        if (isDocumentLoadOvertime(r2) == true) goto L12;
        return false;
    }

    private /* synthetic */ void lambda$showStatusView$0(View r1) {
        OnBackSourceDocListener r2 = this.mOnBackSourceDocListener;
        if (r2 == null) goto L6;
        r2.onBackSourceDoc();
        return;
    }

    private void showStatusView(final int r6) {
        SpaceEmptyState r0 = findViewById(2131372043);
        r0.setVisibility(0);
        EmptyShowInfo r2 = getEmptyShowInfoByCode(r6);
        r0.setImageRes(Integer.valueOf(r2.failRes));
        r0.setDesc(String.format("%s", new Object[]{r2.failString}));
        if (r2.isEditionErr == true) goto L5;
        setOnClickListener(new AnonymousClass1(this, r6));
        return;
    L5:
        UDButton r1 = findViewById(2131364651);
        if (isEditionDocDeleteError(r6) == false) goto L8;
        r1.setVisibility(0);
        r1.setOnClickListener(new c(this));
    L9:
        setClickable(false);
        setFocusable(false);
        return;
    L8:
        r1.setVisibility(8);
        goto L9
    }

    private void showStatusViewWithNewErrorOpt(final int r9) {
        SpaceEmptyState r0 = findViewById(2131372043);
        r0.setVisibility(0);
        final TextView r2 = (TextView) findViewById(2131371737);
        final EmptyShowInfo r3 = getEmptyShowInfoByCode(r9);
        r0.setImageRes(Integer.valueOf(r3.failRes));
        r2.setText(UIHelper.mustacheFormat(getContext(), 2131889051, "code", getErrorDomain(r9) + r9));
        r0.setDesc(String.format("%s", new Object[]{r3.failString}));
        if (isEditionDocDeleteError(r9) == false) goto L6;
        r0.setPrimaryText(getResources().getString(2131889376));
    L15:
        if (isDocDeleteError(r9) == false) goto L17;
    L19:
        r0.setPrimaryClickListener(new AnonymousClass2(this, r3, r2, r9));
        return;
    L17:
        if (isKeyDeleteError(r9) == true) goto L19;
        r2.setVisibility(0);
        goto L19
    L6:
        if (isEditionDocNotFoundError(r9) == false) goto L8;
    L13:
        r0.setPrimaryText(null);
        goto L15
    L8:
        if (isDocDeleteError(r9) == true) goto L13;
        if (isKeyDeleteError(r9) == true) goto L13;
        r0.setPrimaryText(getResources().getString(2131889052));
        goto L15
    }

    @Override // android.view.View
    public void setClickable(boolean r1) {
        super.setClickable(r1);
    }

    public void setOnBackSourceDocListener(OnBackSourceDocListener r1) {
        this.mOnBackSourceDocListener = r1;
    }

    public void setOnRetryListener(OnRetryListener r1) {
        this.mOnRetryListener = r1;
    }

    public LoadingLayout(Context r2, AttributeSet r3) {
        this(r2, r3, -1);
    }

    public void fail(int r2, String r3) {
        if (findViewById(2131378741) == null) goto L5;
        findViewById(2131378741).setVisibility(8);
    L5:
        showStatusViewWithNewErrorOpt(r2);
    }

    public LoadingLayout(Context r1, int r2, String r3) {
        super(r1);
        init();
        fail(r2, r3);
    }

    public LoadingLayout(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        init();
        loading();
    }
}
