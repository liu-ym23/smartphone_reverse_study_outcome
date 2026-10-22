package vsb;

import android.graphics.Bitmap;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import e0c.k;
import f0c.g;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends c0c.b implements rsb.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ rsb.a f557165b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f557166c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<rsb.a> f557167d;

    @Override // rsb.a
    @Deprecated(message = "replace with [getReactionOrEmojiBitmap]")
    public final Bitmap Hb(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f557165b.Hb(r100, r101);
    }

    @Override // rsb.a
    @Deprecated(message = "replace with [getReactionOrEmojiText]")
    public final String K9(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f557165b.K9(r100, r101);
    }

    @Override // rsb.a
    public final ConcurrentHashMap<String, qsb.a> Q1() {
        return this.f557165b.Q1();
    }

    @Override // rsb.a
    public final int U9() {
        return this.f557165b.U9();
    }

    @Override // rsb.a
    public final void V8(Set<? extends qsb.a> r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "set");
        this.f557165b.V8(r100, r101);
    }

    @Override // rsb.a
    public final qsb.a Yd(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reactionKey");
        return this.f557165b.Yd(r100);
    }

    @Override // rsb.a
    public final qsb.a b0(String r100) {
        Intrinsics.checkNotNullParameter(r100, "emojiKey");
        return this.f557165b.b0(r100);
    }

    @Override // rsb.a
    public final void c9(rsb.a.InterfaceC7530a r100) {
        this.f557165b.c9(r100);
    }

    @Override // rsb.a
    public final String df(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f557165b.df(r100);
    }

    @Override // rsb.a
    public final void f3() {
        this.f557165b.f3();
    }

    @Override // rsb.a
    public final void ge(String r100, boolean r101, IGetDataCallback<Boolean> r102, IGetDataCallback<Boolean> r103) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f557165b.ge(r100, r101, r102, r103);
    }

    @Override // rsb.a
    public final ConcurrentHashMap<String, String> h2() {
        return this.f557165b.h2();
    }

    @Override // rsb.a
    public final boolean i7(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f557165b.i7(r100);
    }

    @Override // rsb.a
    /* JADX INFO: renamed from: if */
    public final boolean mo8648if(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f557165b.mo8648if(r100);
    }

    @Override // rsb.a
    public final boolean l4(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f557165b.l4(r100);
    }

    @Override // rsb.a
    @Deprecated(message = "replace with [requestBitmap(String)]")
    public final void sb(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f557165b.sb(r100);
    }

    @Override // rsb.a
    public final String ub(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f557165b.ub(r100);
    }

    @Override // rsb.a
    public final Bitmap v1(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        return this.f557165b.v1(r100);
    }

    public c(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<rsb.a> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), rsb.a.class), rsb.a.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "proxy");
        super(r100);
        this.f557165b = r103.b();
        this.f557166c = r101;
        this.f557167d = r103;
    }

    @Override // c0c.b
    public final void pf(g r100, f0c.b r101) {
        Intrinsics.checkNotNullParameter(r101, "toState");
        v r102 = this.f557166c;
        g r103 = r101.a();
        if (r103 == null) goto L6;
        UserSession r104 = r103.f475034b;
        if (r104 == null) goto L6;
    L7:
        rsb.a r105 = (rsb.a) k.b(r102.c(r104), rsb.a.class);
        this.f557167d.e(r105);
        return;
    L6:
        r104 = ContainerConstsKt.a();
        goto L7
    }
}
