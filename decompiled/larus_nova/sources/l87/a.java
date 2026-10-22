package l87;

import android.text.TextUtils;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.push.interfaze.IAccountService;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.utils.f;
import com.ss.android.message.PushThreadHandlerManager;
import java.util.concurrent.atomic.AtomicBoolean;
import v67.u;

/* JADX INFO: loaded from: classes3.dex */
public final class a {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile a f508055f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public u f508056a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public IAccountService f508057b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f508058c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f508059d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile String f508060e;

    /* JADX INFO: renamed from: l87.a$a, reason: collision with other inner class name */
    public class C6663a implements rgc.c.d<tgc.c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f508061a;

        public C6663a(a r100) {
            this.f508061a = r100;
        }

        @Override // rgc.c.d
        public final /* bridge */ /* synthetic */ void a(tgc.c r100) {
            onCall(r100);
        }

        public void onCall(tgc.c r100) {
            a r101 = this.f508061a;
            String r102 = r100.f545919a;
            if (r101.f508056a != null) goto L6;
            r101.f508056a = PushSupporter.get();
        L6:
            if (TextUtils.equals(r102, r101.f508058c) == false) goto L8;
            r101.f508056a.getLogger().i("UidSync", "[onAccountSwitch]secUid is equals last login uid,do noting,secUid:" + r102);
            return;
        L8:
            boolean r103 = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration.optUidChangeByHostInvoke();
            r101.f508056a.getLogger().i("UidSync", "[onAccountSwitch]optUidChangeByHostInvoke:" + r103 + " secUid:" + r102);
            r101.f508058c = r102;
            if (r103 == false) goto L11;
            PushThreadHandlerManager.inst().postRunnable(new l87.b(r101, r102));
            return;
        L11:
            ThreadPlus.submitRunnable(new i87.c(r101.f508056a, "passport_switch"));
        }
    }

    public class b implements rgc.c.d<tgc.a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f508062a;

        public b(a r100) {
            this.f508062a = r100;
        }

        @Override // rgc.c.d
        public final /* bridge */ /* synthetic */ void a(tgc.a r100) {
            onCall(r100);
        }

        public void onCall(tgc.a r100) {
            a r101 = this.f508062a;
            String r102 = r100.f545918a;
            r101.f508056a.getLogger().i("UidSync", "onLogin " + r102);
            r101.f508058c = r102;
            ThreadPlus.submitRunnable(new i87.c(r101.f508056a, "passport_login"));
        }
    }

    public class c implements rgc.c.d<tgc.b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f508063a;

        public c(a r100) {
            this.f508063a = r100;
        }

        @Override // rgc.c.d
        public final /* bridge */ /* synthetic */ void a(tgc.b r100) {
            onCall(r100);
        }

        public void onCall(tgc.b r100) {
            a r101 = this.f508063a;
            r101.f508056a.getLogger().i("UidSync", "onLogout");
            r101.f508058c = "";
            ThreadPlus.submitRunnable(new i87.c(r101.f508056a, "passport_logout"));
        }
    }

    public static a a() {
        if (f508055f != null) goto L15;
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f508055f != null) goto L9;
        f508055f = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
    L15:
        return f508055f;
    }

    public a() {
        this.f508058c = null;
        this.f508059d = new AtomicBoolean(false);
    }

    public final void b(u r100, IAccountService r101) {
        f.g("UidSync", "[observerUidChangeEvent]");
        if (this.f508059d.compareAndSet(false, true) == true) goto L6;
        f.g("UidSync", "[observerUidChangeEvent]do nothing because repeat invoke");
        return;
    L6:
        this.f508056a = r100;
        this.f508057b = r101;
        this.f508058c = r101.getSecUid();
        this.f508057b.registerOnAccountSwitchListener(new C6663a(this));
        this.f508057b.registerOnLoginListener(new b(this));
        this.f508057b.registerOnLogoutListener(new c(this));
    }
}
