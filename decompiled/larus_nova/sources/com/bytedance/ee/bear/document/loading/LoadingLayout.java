package com.bytedance.ee.bear.document.loading;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.ee.bear.connection.NetworkType;
import com.bytedance.ee.bear.document.j5;
import com.bytedance.ee.bear.document.s1;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEmptyState;
import com.larksuite.component.universe_design.button.UDButton;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes16.dex */
public class LoadingLayout extends FrameLayout implements View.OnTouchListener, com.bytedance.ee.bear.document.loading.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c f220201a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f220202b;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f220203a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f220204b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f220205c;

        public a() {
        }
    }

    public interface b {
    }

    public interface c {
        void onFailedRetry(int r100);
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r100, MotionEvent r101) {
        return true;
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public final void show() {
        throw null;
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public final void hide() {
        setVisibility(8);
    }

    public final void e() {
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

    public static boolean d(int r100) {
        if (r100 != (-2)) goto L5;
        return true;
    L5:
        if (r100 != (-600)) goto L7;
        return true;
    L7:
        if (r100 != (-50)) goto L9;
        return true;
    L9:
        if (j5.a() == false) goto L48;
        int r101 = s1.b.f221496a;
        if (r100 != 999) goto L14;
    L49:
        boolean r102 = true;
    L50:
        if (r102 == true) goto L57;
        return false;
    L57:
        return true;
    L14:
        if (r100 == 100) goto L49;
        if (r100 == 101) goto L49;
        if (r100 == 400) goto L49;
        if (r100 == 501) goto L49;
        if (r100 == 502) goto L49;
        if (r100 == 503) goto L49;
        if (r100 == 504) goto L49;
        if (r100 == 505) goto L49;
        if (r100 == 506) goto L49;
        if (r100 == 507) goto L49;
        if (r100 == 601) goto L49;
        if (r100 == 602) goto L49;
        if (r100 == 603) goto L49;
        if (r100 == 604) goto L49;
        if (r100 == 605) goto L49;
        if (r100 == 606) goto L49;
        if (r100 == 607) goto L49;
    L48:
        r102 = false;
        goto L50
    }

    public final a c(int r100) {
        a r101 = new a();
        r101.f220205c = false;
        if (r100 != (-1)) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        r101.f220203a = R.drawable.ccm_empty_negative_no_wifi;
        r101.f220204b = getResources().getString(R.string.Doc_Facade_NetworkInterrutedRetry);
    L54:
        return r101;
    L12:
        if (d(r100) == false) goto L18;
        r101.f220203a = R.drawable.ccm_empty_negative_load_failed;
        if (j5.a() == false) goto L16;
        r101.f220204b = getResources().getString(R.string.LarkCCM_Docs_Error_LoadOT_Mob);
        goto L54
    L16:
        r101.f220204b = getResources().getString(R.string.Doc_Facade_LoadOverTime);
        goto L54
    L18:
        if (r100 != (-100001)) goto L20;
        boolean r103 = true;
    L21:
        if (r103 == false) goto L24;
        r101.f220203a = R.drawable.ccm_ccm_empty_neutral_400_403;
        r101.f220204b = getResources().getString(R.string.CreationMobile_ECM_SiteUnavailableDesc);
        goto L54
    L24:
        if (tp5.b.c(r100) == false) goto L27;
        r101.f220203a = R.drawable.ccm_empty_neutral_no_content;
        r101.f220204b = getResources().getString(R.string.CreationMobile_Wiki_PageDeleted_Toast);
        goto L54
    L27:
        if (r100 != (-55)) goto L29;
        boolean r104 = true;
    L30:
        if (r104 == false) goto L33;
        r101.f220203a = R.drawable.ccm_vc_empty_neutral_recycle_bin;
        r101.f220204b = getResources().getString(R.string.CreationMobile_ECM_DocsDeletedDesc);
        goto L54
    L33:
        if (r100 != (-58)) goto L35;
        boolean r105 = true;
    L36:
        if (r105 == false) goto L39;
        r101.f220203a = R.drawable.ccm_empty_neutral_no_content;
        r101.f220204b = getResources().getString(R.string.LarkCCM_Docx_VersionMgmt_DocNonExist_Mob);
        r101.f220205c = true;
        goto L54
    L39:
        if (r100 != (-57)) goto L41;
        boolean r106 = true;
    L42:
        if (r106 == false) goto L45;
        r101.f220203a = R.drawable.ccm_empty_neutral_no_content;
        r101.f220204b = getResources().getString(R.string.LarkCCM_Docx_VersionMgmt_Deleted);
        r101.f220205c = true;
        goto L54
    L45:
        if (r100 != (-56)) goto L47;
        boolean r107 = true;
    L48:
        if (r107 == false) goto L50;
        r101.f220203a = R.drawable.ccm_ccm_empty_neutral_document_key_unavailable;
        r101.f220204b = getResources().getString(R.string.CreationDoc_Docs_KeyInvalidCanNotRead);
        goto L54
    L50:
        r101.f220203a = R.drawable.ccm_empty_negative_load_failed;
        if (j5.a() == false) goto L53;
        r101.f220204b = getResources().getString(R.string.LarkCCM_Docs_LoadError_Mob);
        goto L54
    L53:
        r101.f220204b = String.format("%s(%s)", new Object[]{getResources().getString(R.string.Doc_Facade_LoadFailed), Integer.valueOf(r100)});
        goto L54
    L47:
        r107 = false;
        goto L48
    L41:
        r106 = false;
        goto L42
    L35:
        r105 = false;
        goto L36
    L29:
        r104 = false;
        goto L30
    L20:
        r103 = false;
        goto L21
    L5:
        if (fw4.d.b(getContext()) == NetworkType.NETWORK_NO) goto L8;
        r102 = false;
        goto L9
    }

    @Override // android.view.View
    public void setClickable(boolean r100) {
        super.setClickable(r100);
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public void setOnBackSourceDocListener(b r100) {
        this.f220202b = r100;
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public void setOnRetryListener(c r100) {
        this.f220201a = r100;
    }

    public LoadingLayout(Context r100, AttributeSet r101) {
        this(r100, r101, -1);
    }

    @Override // com.bytedance.ee.bear.document.loading.c
    public final void a(int r110, String r111) {
        if (findViewById(R.id.ll_loading) == null) goto L5;
        findViewById(R.id.ll_loading).setVisibility(8);
    L5:
        boolean r100 = true;
        if (j5.a() == false) goto L48;
        SpaceEmptyState r112 = (SpaceEmptyState) findViewById(R.id.facade_no_data_empty_state);
        r112.setVisibility(0);
        TextView r101 = (TextView) findViewById(R.id.err_code);
        a r102 = c(r110);
        r112.setImageRes(Integer.valueOf(r102.f220203a));
        Context r103 = getContext();
        StringBuilder r104 = new StringBuilder();
        if (d(r110) == false) goto L10;
        String r105 = ExifInterface.GPS_MEASUREMENT_IN_PROGRESS;
    L11:
        r104.append(r105);
        r104.append(r110);
        r101.setText(xo5.a.c(r103, R.string.LarkCCM_Docs_ErrorCode_Mob, "code", r104.toString()));
        r112.setDesc(String.format("%s", new Object[]{r102.f220204b}));
        if (r110 != (-57)) goto L14;
        boolean r106 = true;
    L16:
        if (r106 == false) goto L19;
        r112.setPrimaryText(getResources().getString(R.string.LarkCCM_Docx_VersionMgmt_View_Back2Ori_Button));
    L36:
        if (r110 != (-55)) goto L38;
        boolean r107 = true;
    L39:
        if (r107 == true) goto L47;
        if (r110 == (-56)) goto L43;
        r100 = false;
    L43:
        if (r100 == true) goto L47;
        if (tp5.b.c(r110) == true) goto L47;
        r101.setVisibility(0);
    L47:
        r112.setPrimaryClickListener(new h(this, r102, r101, r110));
        return;
    L38:
        r107 = false;
        goto L39
    L19:
        if (r110 != (-58)) goto L21;
        boolean r108 = true;
    L22:
        if (r108 == true) goto L35;
        if (r110 != (-55)) goto L25;
        boolean r109 = true;
    L26:
        if (r109 == true) goto L35;
        if (r110 != (-56)) goto L29;
        boolean r113 = true;
    L30:
        if (r113 == true) goto L35;
        if (tp5.b.c(r110) == true) goto L35;
        r112.setPrimaryText(getResources().getString(R.string.LarkCCM_Docs_ErrorRefresh_Button_Mob));
        goto L36
    L29:
        r113 = false;
        goto L30
    L25:
        r109 = false;
    L35:
        r112.setPrimaryText(null);
        goto L36
    L21:
        r108 = false;
        goto L22
    L14:
        r106 = false;
        goto L16
    L10:
        r105 = "";
        goto L11
    L48:
        SpaceEmptyState r114 = (SpaceEmptyState) findViewById(R.id.facade_no_data_empty_state);
        r114.setVisibility(0);
        a r115 = c(r110);
        r114.setImageRes(Integer.valueOf(r115.f220203a));
        r114.setDesc(String.format("%s", new Object[]{r115.f220204b}));
        if (r115.f220205c == true) goto L51;
        setOnClickListener(new g(this, r110));
        return;
    L51:
        UDButton r116 = (UDButton) findViewById(R.id.btn_back_source_doc);
        if (r110 == (-57)) goto L55;
        r100 = false;
    L55:
        if (r100 == false) goto L57;
        r116.setVisibility(0);
        r116.setOnClickListener(new f(this));
    L58:
        setClickable(false);
        setFocusable(false);
        return;
    L57:
        r116.setVisibility(8);
        goto L58
    }

    public LoadingLayout(Context r100, int r101, String r102) {
        super(r100);
        FrameLayout.inflate(getContext(), R.layout.doc_empty_layout, this);
        a(r101, r102);
    }

    public LoadingLayout(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        FrameLayout.inflate(getContext(), R.layout.doc_empty_layout, this);
        e();
    }
}
