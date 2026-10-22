package vmb;

import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.lark.rustclient.api.l;
import com.ss.android.lark.feed.shared.page.s;
import com.ss.android.lark.flow.feed.page.FlowMixedFeedFragment;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.container.OfficeSDKSPIKtxKt;
import com.ss.android.lark.officesdk.container.OfficeSDKUserComponent;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import f0c.g;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends c0c.b implements vmb.a, chb.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArraySet<Function0<Unit>> f556358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CopyOnWriteArraySet<Function0<Unit>> f556359c;

    public static final class a {
    }

    static {
    }

    public static vmb.a rf() {
        OfficeSDKUserComponent r100 = OfficeSDKManager.getOfficeSDKUserComponent();     // Catch: Throwable -> L6
        if (r100 == null) goto L8;
        return (vmb.a) OfficeSDKSPIKtxKt.spiByDwarf(r100, vmb.a.class);
    L8:
        return null;
    L6:
        th = move-exception;
        Log.e("UserFeedBundleProxy", "spiByDwarf(IUserFeedBundle) failed", th);
        goto L8
    }

    @Override // vmb.a
    public final com.ss.android.lark.flow.feed.data.a Q() {
        vmb.a r100 = rf();
        if (r100 != null) goto L7;
        Log.w("UserFeedBundleProxy", "[FlowFeedLog] provideDoubaoFeedMigrateStatus skipped: delegate not ready");
        return null;
    L7:
        return r100.Q();
    }

    @Override // vmb.a
    public final String t() {
        vmb.a r100 = rf();
        if (r100 != null) goto L7;
        Log.w("UserFeedBundleProxy", "[FlowFeedLog] provideCurrentUserId skipped: delegate not ready");
        return null;
    L7:
        return r100.t();
    }

    @Override // vmb.a
    public final l w() {
        vmb.a r100 = rf();
        if (r100 != null) goto L7;
        Log.w("UserFeedBundleProxy", "[FlowFeedLog] provideRustClient skipped: delegate not ready");
        return null;
    L7:
        return r100.w();
    }

    public c(j r100) {
        Intrinsics.checkNotNullParameter(r100, "passport");
        super(r100);
        this.f556358b = new CopyOnWriteArraySet();
        this.f556359c = new CopyOnWriteArraySet();
    }

    @Override // vmb.a
    public final s M(FlowMixedFeedFragment r100) {
        Intrinsics.checkNotNullParameter(r100, "storeOwner");
        vmb.a r101 = rf();
        if (r101 != null) goto L7;
        Log.w("UserFeedBundleProxy", "[FlowFeedLog] createMixedFeedViewModel skipped: delegate not ready");
        return null;
    L7:
        return r101.M(r100);
    }

    @Override // chb.a
    public final void Nb(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f556359c.add(r100);
    }

    @Override // chb.a
    public final void ce(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f556359c.remove(r100);
    }

    @Override // chb.a
    public final void i8(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f556358b.add(r100);
        UserSession r101 = this.f21992a.b();
        if (r101 != null) goto L6;
        r101 = ContainerConstsKt.a();
    L6:
        if (r101 == ContainerConstsKt.a()) goto L8;
        boolean r102 = true;
    L9:
        if (r102 == false) goto L12;
        r100.invoke();
        return;
    L12:
        return;
    L8:
        r102 = false;
        goto L9
    }

    @Override // chb.a
    public final void k3(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.f556358b.remove(r100);
    }

    @Override // c0c.b
    public final void mf(g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        Log.i("UserFeedBundleProxy", "[FlowFeedLog] destroy, sessionKey = " + r100.f475034b.f438137a);
        Iterator<T> r101 = this.f556359c.iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        Function0 r102 = (Function0) r101.next();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        r102.invoke();     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L4;
        Log.e("UserFeedBundleProxy", "[FlowFeedLog] onUserNotReady listener err", r105);
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // c0c.b
    public final void of(g r100) {
        Intrinsics.checkNotNullParameter(r100, "user");
        Intrinsics.checkNotNullParameter(r100, "user");
        Log.i("UserFeedBundleProxy", "[FlowFeedLog] onPrepared, sessionKey = " + r100.f475034b.f438137a);
        Iterator<T> r101 = this.f556358b.iterator();
    L4:
        if (r101.hasNext() == false) goto L13;
        Function0 r102 = (Function0) r101.next();
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L8
        r102.invoke();     // Catch: Throwable -> L8
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L8
    L10:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L4;
        Log.e("UserFeedBundleProxy", "[FlowFeedLog] onUserReady listener err", r105);
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // vmb.a
    public final s t0(ViewModelStoreOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "storeOwner");
        vmb.a r101 = rf();
        if (r101 != null) goto L7;
        Log.w("UserFeedBundleProxy", "[FlowFeedLog] createSidebarFeedViewModel skipped: delegate not ready");
        return null;
    L7:
        return r101.t0(r100);
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        StringBuilder r102 = new StringBuilder("[FlowFeedLog] preparing, from=");
        String r103 = null;
        if (r100 == null) goto L7;
        UserSession r104 = r100.f475034b;
        if (r104 == null) goto L7;
        String r105 = r104.f438137a;
    L8:
        r102.append(r105);
        r102.append(", to=");
        if (r101 == null) goto L13;
        UserSession r106 = r101.f475034b;
        if (r106 == null) goto L13;
        r103 = r106.f438137a;
    L13:
        r102.append(r103);
        r102.append(", hasDelegate=");
        if (rf() == null) goto L16;
        boolean r107 = true;
    L17:
        r102.append(r107);
        Log.i("UserFeedBundleProxy", r102.toString());
        return;
    L16:
        r107 = false;
    L7:
        r105 = null;
        goto L8
    }
}
