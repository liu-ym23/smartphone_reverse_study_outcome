package ru;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Looper;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.widget.TextView;
import com.bytedance.android.gamecp.common.monitor.SafetyGuard;
import com.bytedance.android.gamecp.common.permission.PermissionFragment;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: classes44.dex */
public final class j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final TokenCert f539228a = null;

    public static abstract class a implements uu.a {
        public a() {
        }

        @Override // uu.a
        public final void a(Activity r110, final uu.b r111, String[] r112) {
            cv.d.f465478b = new e();
            ContextThemeWrapper r100 = new ContextThemeWrapper(r110, R.style.gamecp_CommonBottomDialog);
            LayoutInflater r101 = (LayoutInflater) r100.getSystemService("layout_inflater");
            String r102 = r110.getString(R.string.gamecp_permissions_dialog_title);
            String r113 = r110.getString(R.string.gamecp_permissions_dialog_neverask_message, new Object[]{ru.c.a(r110, r112)});
            String r103 = r110.getString(R.string.gamecp_setting);
            DialogInterface.OnClickListener r104 = new f(this, r111);
            String r114 = r110.getString(R.string.gamecp_cancel);
            DialogInterface.OnClickListener r105 = new g();
            DialogInterface.OnKeyListener r106 = new h();
            DialogInterface.OnCancelListener r107 = new i(this, r111);
            cv.d r115 = new cv.d(r100);
            cv.a r108 = r115.f465479a;
            if (r102 == null) goto L7;
            r108.f465452d = r102;
            TextView r109 = r108.f465466r;
            if (r109 == null) goto L7;
            r109.setText(r102);
        L7:
            if (r113 == null) goto L11;
            r108.f465453e = r113;
            TextView r116 = r108.f465467s;
            if (r116 == null) goto L11;
            r116.setText(r113);
        L11:
            if (r103 == null) goto L13;
            r108.b(-1, r103, r104);
        L13:
            if (r114 == null) goto L15;
            r108.b(-2, r114, r105);
        L15:
            r115.setCancelable(false);
            r115.setOnCancelListener(r107);
            r115.setOnDismissListener(null);
            r115.setOnKeyListener(r106);
            if (DialogLancet.shouldBlockDialogShow(r115) == false) goto L22;
            DialogLancet.handleBlockedDialogShow(r115);
            return;
        L22:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
        L19:
            DialogLancet.beforeDialogShow(r115);
            r115.show();
            DialogLancet.afterDialogShow(r115);
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f539229a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f539230b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public uu.a f539231c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final l f539232d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final l f539233e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f539234f;

        public b(Activity r100) {
            this.f539230b = new c();
            this.f539231c = new d();
            this.f539232d = new l();
            this.f539233e = new l();
            this.f539234f = true;
            this.f539229a = r100;
        }

        public final void a(final uu.d r110, final Cert r111, final String... r112) {
            Activity r100 = this.f539229a;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.isFinishing() == false) goto L18;
            return;
        L18:
            yr.b.b(6, "LivePermissionsRequest", "start to request permissions");     // Catch: Exception -> L10
            PermissionFragment.e(this.f539229a, r110, this.f539232d, this.f539230b, this.f539231c, this.f539233e, r111, r112);     // Catch: Exception -> L10
            yr.b.b(6, "LivePermissionsRequest", "finish to request permissions");     // Catch: Exception -> L10
            return;
        L10:
            e = move-exception;
            SafetyGuard.a(e, "Permission request error");
            if ((e instanceof IllegalStateException) == true) goto L14;
        L16:
            yr.b.d("LivePermissionsRequest", e.toString(), new Throwable());
            return;
        L14:
            if (this.f539234f == false) goto L16;
            new Handler(Looper.getMainLooper()).post(new k(this, r110, r111, r112));
            this.f539234f = false;
            yr.b.b(6, "LivePermissionsRequest", "try request in handler post");
            goto L16
        }
    }

    public static class c implements uu.a {
        public c() {
        }

        @Override // uu.a
        public final void a(Activity r100, uu.b r101, String[] r102) {
            r101.execute();
        }
    }

    public static class d extends a {
        public d() {
        }
    }

    static {
        f539228a = TokenCert.with("bpea-permissionfragment_request_permission");
    }
}
