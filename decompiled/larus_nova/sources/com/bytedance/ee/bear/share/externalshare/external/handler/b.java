package com.bytedance.ee.bear.share.externalshare.external.handler;

import android.content.Context;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.share.export.ShareParams;
import com.bytedance.ee.util.info.AppInfoUtils;
import com.bytedance.supervisor.token.Token;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f237076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ShareParams f237077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final BaseOpenTencentHandler f237078c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f237079d;

    public static final class a {
    }

    static {
    }

    public final Context getContext() {
        return this.f237076a;
    }

    public final String b(int r100) {
        return this.f237076a.getString(r100);
    }

    public final void a(boolean r100, String r101) {
        if (this.f237077b.getType() == 3) goto L5;
    L9:
        BaseOpenTencentHandler r102 = this.f237078c;
        if (r102 == null) goto L12;
        String r103 = r102.g();
    L13:
        if (r103 != null) goto L15;
        r103 = "";
    L15:
        s45.i r104 = s45.i.f540569a;
        int r105 = this.f237077b.getType();
        boolean r106 = Intrinsics.areEqual(AppInfoUtils.f(), Boolean.TRUE);
        r104.getClass();
        String r107 = s45.i.b(r103, r105, r106);
        if (r100 == false) goto L33;
        HashMap r108 = new HashMap();
        r108.put("APP_DISPLAY_NAME", b(R.string.Lark_App_Name));
        r108.put("link", r107);
        r108.put("password", r101);
        r107 = xo5.a.d(this.f237076a, R.string.Doc_Facade_LinkAndPasswordText, r108);
    L33:
        boolean r109 = ((fu5.a) org.koin.java.a.c(fu5.a.class, null, null, 6)).n(r107, false, new Token("LARK-PSDA-ccm_android_share_dialog_copy_link"));     // Catch: Exception -> L21
    L23:
        if (r109 == false) goto L30;
        if (r100 == false) goto L26;
        Toast.showSuccessText(this.f237076a, b(R.string.Doc_Facade_CopyLinkAndPasswordSuccess), 0);
    L31:
        this.f237079d.invoke();
        return;
    L26:
        int r110 = n.f237111a;
        if (n.e(this.f237077b) == false) goto L29;
        Toast.showSuccessText(this.f237076a, b(R.string.LarkCCM_Docx_VersionMgmt_Share_Copied_Toast), 0);
        goto L31
    L29:
        Toast.showSuccessText(this.f237076a, b(R.string.Doc_Facade_CopyLinkSuccess), 0);
        goto L31
    L30:
        Toast.showFailureText(this.f237076a, b(R.string.Doc_Facade_CopyLinkFailed), 0);
    L21:
        e = move-exception;
        tt5.a.f("BaseCopyLinkHandler", e, false);
        r109 = false;
    L12:
        r103 = null;
        goto L13
    L5:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("ccm.android.sheet_share_url_extra_params_enabled") == false) goto L9;
        BaseOpenTencentHandler r111 = this.f237078c;
        if (r111 == null) goto L12;
        r103 = r111.e();
        goto L13
    }

    public b(Context r100, ShareParams r101, BaseOpenTencentHandler r102, Function0<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r103, "dismiss");
        this.f237076a = r100;
        this.f237077b = r101;
        this.f237078c = r102;
        this.f237079d = r103;
    }
}
