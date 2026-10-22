package doc;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Build;
import com.bytedance.bpea.entry.common.DataType;
import com.larksuite.framework.thread.CoreThreadPool;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.entity.UserState;
import com.ss.android.lark.utils.LarkContext;
import com.suite.lark.emm.impl.clipboard.SCClipboardScene;
import javax.inject.Inject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class f implements d, com.ss.android.lark.passportc.api.g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.ss.android.lark.passportc.api.j f469534a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.audit.userscope.auth.j f469535b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f469536c;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f469537a = null;

        static {
            f469537a = new a();
        }

        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            Object r100 = LarkContext.getApplication().getSystemService(DataType.CLIPBOARD);     // Catch: Throwable -> L4
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.content.ClipboardManager");     // Catch: Throwable -> L4
            com.suite.lark.emm.impl.clipboard.utils.d.a((ClipboardManager) r100);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserChanged(f0c.g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "currentState");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOffline(f0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void afterUserOnline(f0c.f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOffline(f0c.e r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserOnline(f0c.f r100) {
        Intrinsics.checkNotNullParameter(r100, "state");
    }

    @Override // doc.b
    public final boolean E6() {
        return this.f469536c.E6();
    }

    @Override // doc.b
    public final void L3() {
        this.f469536c.L3();
    }

    @Override // doc.b
    public final ClipData Ma() {
        return this.f469536c.Ma();
    }

    @Override // doc.e
    public final boolean Q7() {
        return this.f469536c.Q7();
    }

    @Override // doc.b
    public final void Sd() {
        this.f469536c.Sd();
    }

    @Override // doc.b
    public final int Ua() {
        return this.f469536c.Ua();
    }

    @Override // doc.d
    public final boolean X4() {
        coc.f.f24672a.f24670c.a();
        if (this.f469534a.d().f475024b.f475035a == UserState.ONLINE) goto L7;
        Log.i("SCClipboardManager", "user not login");
        return false;
    L7:
        if (this.f469535b.isInit() == true) goto L10;
        Log.i("SCClipboardManager", "AuditManager not init");
        return false;
    L10:
        int r100 = this.f469535b.c(21);
        Log.i("SCClipboardManager", "auditPermission: " + r100);
        if (o3(r100) != 1) goto L15;
        return true;
    L15:
        return false;
    }

    @Override // doc.b
    public final void wa() {
        this.f469536c.wa();
    }

    @Override // doc.d
    public final boolean L0() {
        if (X4() == true) goto L6;
        return false;
    L6:
        coc.f.f24672a.f24669b.b();
        return true;
    }

    @Override // com.ss.android.lark.passportc.api.g
    public final com.ss.android.lark.passportc.api.j getPassport() {
        return this.f469534a;
    }

    @Override // doc.e
    public final void Ob(SCClipboardScene r100) {
        this.f469536c.Ob(r100);
    }

    @Override // doc.b
    public final void Ze(ClipData r100) {
        Intrinsics.checkNotNullParameter(r100, "clipData");
        this.f469536c.Ze(r100);
    }

    @Override // doc.e
    public final void d(ClipboardManager.OnPrimaryClipChangedListener r100) {
        this.f469536c.d(r100);
    }

    @Override // doc.e
    public final void e(ClipboardManager.OnPrimaryClipChangedListener r100) {
        this.f469536c.e(r100);
    }

    @Override // doc.e
    public final int o3(int r100) {
        return this.f469536c.o3(r100);
    }

    @Override // doc.b
    public final int xb(ClipData r100) {
        return this.f469536c.xb(r100);
    }

    @Override // com.ss.android.lark.passportc.api.n
    public final void onUserChanged(f0c.g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "currentState");
        Intrinsics.checkNotNullParameter(r101, "currentState");
    L8:
        e = move-exception;
        Log.e("SCClipboardManager", "onUserChanged forceReportWebviewClipChanged failed: " + e);
        return;
    L4:
        if (Build.VERSION.SDK_INT >= 28) goto L6;
        CoreThreadPool.getDefault().getUIExecutor().execute(a.f469537a);     // Catch: Exception -> L8
    L11:
        return;
    L6:
        Object r102 = LarkContext.getApplication().getSystemService(DataType.CLIPBOARD);     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type android.content.ClipboardManager");     // Catch: Exception -> L8
        com.suite.lark.emm.impl.clipboard.utils.d.a((ClipboardManager) r102);     // Catch: Exception -> L8
        goto L11
    }

    @Inject
    public f(com.ss.android.lark.passportc.api.j r100, c r101, com.ss.android.lark.audit.userscope.auth.j r102) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "fgGlobalInternal");
        Intrinsics.checkNotNullParameter(r102, "authorizationManager");
        this.f469534a = r100;
        this.f469535b = r102;
        this.f469536c = (e) e0c.k.a(LarkContext.getApplication(), e.class);
        r100.e(this);
    }
}
