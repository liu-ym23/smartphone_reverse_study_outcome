package m60;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.android.live.browser.jsbridge.newmethods.y3;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.monitor.SafetyGuard;
import com.bytedance.android.live.core.permission.PermissionFragment;
import com.bytedance.android.live.core.setting.SettingKey;
import com.bytedance.android.live.uikit.dialog.AlertDialog;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import com.larus.nova.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ru.l;

/* JADX INFO: loaded from: classes45.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final SettingKey<Boolean> f512260a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final TokenCert f512261b = null;

    public static abstract class a implements o60.a {
        public a() {
        }

        @Override // o60.a
        public final void a(Activity r110, final o60.b r111, String[] r112) {
            AlertDialog.setNightMode(new y3());
            AlertDialog.Builder r100 = new AlertDialog.Builder(r110).setTitle(r110.getString(R.string.ttlive_permissions_dialog_title));
            if (i.f512260a.getValue().booleanValue() == false) goto L22;
            Object[] r101 = new Object[1];
            Map<String, Integer> r102 = m60.c.f512253a;
            HashMap r103 = new HashMap(m60.c.f512253a);
            r103.put("android.permission.WRITE_EXTERNAL_STORAGE", Integer.valueOf(R.string.ttlive_permissions_external_storage));
            ArrayList r104 = new ArrayList();
            int r105 = r112.length;
            int r106 = 0;
        L5:
            if (r106 >= r105) goto L14;
            String r113 = r112[r106];
            if (m60.c.d(r110, new String[]{r113}) == true) goto L13;
            if (r103.containsKey(r113) == false) goto L13;
            Integer r114 = (Integer) r103.get(r113);
            if (r104.contains(r114) == true) goto L13;
            r104.add(r114);
        L13:
            r106 = r106 + 1;
            goto L5
        L14:
            StringBuilder r115 = new StringBuilder();
            Iterator r107 = r104.iterator();
        L16:
            if (r107.hasNext() == false) goto L21;
            Integer r108 = (Integer) r107.next();
            if (r115.length() <= 0) goto L20;
            r115.append(", ");
        L20:
            r115.append(r110.getString(r108.intValue()));
            goto L16
        L21:
            r101[0] = r115.toString();
            String r116 = r110.getString(R.string.ttlive_permissions_dialog_neverask_message, r101);
        L38:
            r100.setMessage(r116).setPositiveButton(r110.getString(R.string.ttlive_setting), new e(this, r111)).setNegativeButton(r110.getString(R.string.ttlive_cancel), new f()).setOnKeyListener(new g()).setCancelable(false).setOnCancelListener(new h(this, r111)).show();
            return;
        L22:
            Object[] r109 = new Object[1];
            Map<String, Integer> r117 = m60.c.f512253a;
            ArrayList r118 = new ArrayList();
            int r119 = r112.length;
            int r120 = 0;
        L23:
            if (r120 >= r119) goto L30;
            String r121 = r112[r120];
            HashMap r122 = (HashMap) m60.c.f512253a;
            if (r122.containsKey(r121) == false) goto L29;
            Integer r123 = (Integer) r122.get(r121);
            if (r118.contains(r123) == true) goto L29;
            r118.add(r123);
        L29:
            r120 = r120 + 1;
            goto L23
        L30:
            StringBuilder r124 = new StringBuilder();
            Iterator r125 = r118.iterator();
        L32:
            if (r125.hasNext() == false) goto L37;
            Integer r126 = (Integer) r125.next();
            if (r124.length() <= 0) goto L36;
            r124.append(", ");
        L36:
            r124.append(r110.getString(r126.intValue()));
            goto L32
        L37:
            r109[0] = r124.toString();
            r116 = r110.getString(R.string.ttlive_permissions_dialog_neverask_message, r109);
            goto L38
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Activity f512262a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f512263b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public o60.a f512264c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public Runnable f512265d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public Runnable f512266e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f512267f;

        public b(Activity r100) {
            this.f512263b = new c();
            this.f512264c = new d();
            this.f512265d = new l();
            this.f512266e = new l();
            this.f512267f = true;
            this.f512262a = r100;
        }

        public final void a(o60.e r100, TokenCert r101, List r102) {
            b(r100, null, r101, (String[]) r102.toArray(new String[r102.size()]));
        }

        public final void b(final o60.e r110, o60.d r111, final Cert r112, final String... r113) {
            Activity r100 = this.f512262a;
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.isFinishing() == true) goto L20;
            ALogger.e("LivePermissionsRequest", "start to request permissions");     // Catch: Exception -> L9
            PermissionFragment.f(this.f512262a, r110, r111, this.f512265d, this.f512263b, this.f512264c, this.f512266e, r112, r113);     // Catch: Exception -> L9
            ALogger.e("LivePermissionsRequest", "finish to request permissions");     // Catch: Exception -> L9
            return;
        L9:
            e = move-exception;
            SafetyGuard.a(null, e, "Permission request error");
            if ((e instanceof IllegalStateException) == true) goto L13;
        L15:
            ALogger.e("LivePermissionsRequest", e.toString(), new Throwable());
            return;
        L13:
            if (this.f512267f == false) goto L15;
            new Handler(Looper.getMainLooper()).post(new j(this, r110, r112, r113));
            this.f512267f = false;
            ALogger.e("LivePermissionsRequest", "try request in handler post");
            goto L15
        }
    }

    public static class c implements o60.a {
        public c() {
        }

        @Override // o60.a
        public final void a(Activity r100, o60.b r101, String[] r102) {
            r101.execute();
        }
    }

    public static class d extends a {
        public d() {
        }
    }

    static {
        Boolean r100 = Boolean.TRUE;
        f512260a = new SettingKey("change_hotsoon_permission_request_never_ask_dialog_message", "火山neverAskDialog权限弹窗文案修复", r100, r100);
        f512261b = TokenCert.with("bpea-permissionfragment_request_permission");
    }
}
