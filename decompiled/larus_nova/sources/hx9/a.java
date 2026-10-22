package hx9;

import com.larus.bmhome.chat.component.bottom.bottommenu.f1;
import com.larus.bmhome.chat.component.cvs.y;
import com.larus.bmhome.chat.component.list.u7;
import com.larus.im.bean.message.Message;
import com.larus.platform.service.AccountService;
import com.larus.utils.o0;
import java.util.List;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import va8.o;

/* JADX INFO: loaded from: classes31.dex */
public final class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final k f487548a;

    /* JADX INFO: renamed from: hx9.a$a, reason: collision with other inner class name */
    public static final class C6209a implements Function0<Unit> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ kotlinx.coroutines.i<Unit> f487549a;

        public C6209a(kotlinx.coroutines.j r100) {
            this.f487549a = r100;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            if (this.f487549a.isActive() == false) goto L6;
            kotlinx.coroutines.i<Unit> r100 = this.f487549a;
            Result.Companion r101 = Result.Companion;
            r100.resumeWith(Result.m9449constructorimpl(Unit.INSTANCE));
        L6:
            return Unit.INSTANCE;
        }
    }

    @Override // hx9.l
    public final wc9.e O8() {
        y r100 = this.f487548a.d();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.h();
    }

    @Override // hx9.l
    public final long b() {
        de8.c r100 = this.f487548a.c();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.f468098n;
    }

    @Override // hx9.l
    public final List<Message> c() {
        return this.f487548a.e();
    }

    @Override // hx9.l
    public final boolean d() {
        return AccountService.f365697a.a();
    }

    @Override // hx9.l
    public final String e() {
        k r100 = this.f487548a;
        de8.c r101 = r100.c();
        String r102 = null;
        if (r101 == null) goto L11;
        String r103 = r101.f();
        if (r103 == null) goto L11;
        if (o0.d(r103) == true) goto L10;
        r103 = null;
    L10:
        if (r103 == null) goto L11;
        return r103;
    L11:
        y r104 = r100.d();
        if (r104 == null) goto L18;
        String r105 = r104.getBotId();
        if (r105 == null) goto L18;
        if (o0.d(r105) == false) goto L18;
        r102 = r105;
    L18:
        if (r102 != null) goto L21;
        return "";
    L21:
        return r102;
    }

    @Override // hx9.l
    public final boolean f() {
        o r100 = (o) this.f487548a.f487563f.getValue();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.w() != true) goto L7;
        return true;
    }

    @Override // hx9.l
    public final List<Message> g() {
        return this.f487548a.a();
    }

    @Override // hx9.l
    public final String getConversationId() {
        k r100 = this.f487548a;
        de8.c r101 = r100.c();
        String r102 = null;
        if (r101 == null) goto L11;
        String r103 = r101.h();
        if (r103 == null) goto L11;
        if (o0.d(r103) == true) goto L10;
        r103 = null;
    L10:
        if (r103 == null) goto L11;
        return r103;
    L11:
        y r104 = r100.d();
        if (r104 == null) goto L14;
        r102 = r104.Y1();
    L14:
        if (r102 != null) goto L17;
        return "";
    L17:
        return r102;
    }

    @Override // hx9.l
    public final de8.c h() {
        return this.f487548a.c();
    }

    @Override // hx9.l
    public final boolean j() {
        hy9.e r100 = (hy9.e) this.f487548a.f487567j.getValue();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.b30() != true) goto L7;
        return true;
    }

    @Override // hx9.l
    public final boolean k() {
        com.larus.bmhome.chat.component.bottom.core.speaker.l r100 = (com.larus.bmhome.chat.component.bottom.core.speaker.l) this.f487548a.f487564g.getValue();
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.m0() != true) goto L7;
        return true;
    }

    @Override // hx9.l
    public final boolean l() {
        f1 r100 = (f1) this.f487548a.f487558a.getAbility(f1.class);
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.sL() != true) goto L7;
        return true;
    }

    @Override // hx9.l
    public final void x4() {
        u7 r100 = (u7) this.f487548a.f487565h.getValue();
        if (r100 == null) goto L6;
        r100.C90();
        return;
    }

    public a(k r100) {
        Intrinsics.checkNotNullParameter(r100, "environment");
        this.f487548a = r100;
    }

    @Override // hx9.l
    public final Object i(Continuation<? super Unit> r100) {
        kotlinx.coroutines.j r101 = new kotlinx.coroutines.j(IntrinsicsKt.intercepted(r100), 1);
        r101.C();
        u7 r102 = (u7) this.f487548a.f487565h.getValue();
        if (r102 == null) goto L13;
        r102.PI(new C6209a(r101));
        Object r103 = r101.B();
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        DebugProbesKt.probeCoroutineSuspended(r100);
    L8:
        if (r103 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L11;
        return r103;
    L11:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("Required value was null.".toString());
    }
}
