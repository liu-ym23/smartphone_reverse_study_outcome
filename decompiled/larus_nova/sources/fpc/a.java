package fpc;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.suite.lark.platform.component.widget_biz_tenantname.data.TenantCertificationData;
import epc.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f478395a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TenantCertificationData f478396b;

    /* JADX INFO: renamed from: fpc.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C5941a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f478397a = null;

        static {
            int[] r100 = new int[TenantCertificationData.CertificateStatus.values().length];
            r100[TenantCertificationData.CertificateStatus.CERTIFICATED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[TenantCertificationData.CertificateStatus.EXPIRED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[TenantCertificationData.CertificateStatus.UNCERTIFICATED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[TenantCertificationData.CertificateStatus.TEAM_CERTIFICATED.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f478397a = r100;
        }
    }

    public final SpannableStringBuilder a() {
        TenantCertificationData r100 = this.f478396b;     // Catch: Throwable -> L28
        if (r100 != null) goto L6;
    L27:
        return null;
    L6:
        if (Intrinsics.areEqual(r100.f461123a, Boolean.TRUE) == false) goto L27;
        Drawable r101 = UIUtils.getDrawable(this.f478395a, R.drawable.ud_icon_verify_filled);     // Catch: Throwable -> L28
        r101.setTint(UIUtils.getColor(this.f478395a, R.color.blue_04b49c));     // Catch: Throwable -> L28
        TenantCertificationData r102 = this.f478396b;     // Catch: Throwable -> L28
        if (r102 == null) goto L10;
        TenantCertificationData.CertificateStatus r103 = r102.f461124b;     // Catch: Throwable -> L28
    L11:
        if (r103 != null) goto L13;
        int r104 = -1;
    L15:
        if (r104 != 1) goto L17;
        Context r105 = this.f478395a;     // Catch: Throwable -> L28
        epc.a r106 = new epc.a(r105, r101, UIUtils.getString(r105, R.string.Lark_TenantVerified_Label), UIUtils.getColor(this.f478395a, R.color.udtoken_tag_bg_turquoise), UIUtils.getColor(this.f478395a, R.color.udtoken_tag_text_s_turquoise));     // Catch: Throwable -> L28
    L23:
        if (r106 != null) goto L25;
        return null;
    L25:
        SpannableStringBuilder r107 = new SpannableStringBuilder().append("$");     // Catch: Throwable -> L28
        r107.setSpan(new b(r106), r107.length() - 1, r107.length(), 34);     // Catch: Throwable -> L28
        return r107;
    L17:
        if (r104 != 2) goto L19;
    L21:
        Context r108 = this.f478395a;     // Catch: Throwable -> L28
        r106 = new epc.a(r108, null, UIUtils.getString(r108, R.string.Lark_TenantUnverified_Label), UIUtils.getColor(this.f478395a, R.color.udtoken_tag_neutral_bg_normal), UIUtils.getColor(this.f478395a, R.color.udtoken_tag_neutral_text_normal));     // Catch: Throwable -> L28
        goto L23
    L19:
        if (r104 == 3) goto L21;
        r106 = null;
        goto L23
    L13:
        r104 = C5941a.f478397a[r103.ordinal()];     // Catch: Throwable -> L28
        goto L15
    L10:
        r103 = null;
    L28:
        th = move-exception;
        Log.e("TenantName", "TenantCertificationBuilder#build failed", th);
        return null;
    }

    public final Context getContext() {
        return this.f478395a;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f478395a = r100;
    }
}
