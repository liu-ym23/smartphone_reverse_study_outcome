package skc;

import com.lark.kmp.containerization.d;
import com.lark.kmp.logger.LarkLogger;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.dwarf.lifecycle.ComponentLifecycleAware;
import gy7.q;
import gy7.s;
import iy7.b;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import tt7.c;

/* JADX INFO: loaded from: classes40.dex */
@UserScope
public final class a implements ComponentLifecycleAware {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UserSession f542438a;

    /* JADX INFO: renamed from: skc.a$a, reason: collision with other inner class name */
    public static final class C7626a {
    }

    static {
    }

    @Override // dagger.hilt.dwarf.lifecycle.ComponentLifecycleAware
    public final void onComponentCreate() {
        q r100 = a("bind");
        if (r100 != null) goto L13;
        return;
    L13:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L7
        c.a(r100);     // Catch: Throwable -> L7
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L15;
        LarkLogger r104 = LarkLogger.f278603a;
        LarkLogger.b("OfficeSDKKmpUserContainerLifecycle", "bind user container failed, userId=" + r100.f483350b + ": " + r103.getMessage());
        return;
    L15:
        return;
    L7:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L9
    }

    @Override // dagger.hilt.dwarf.lifecycle.ComponentLifecycleAware
    public final void onComponentDestroy() {
        q r100 = a("remove");
        if (r100 != null) goto L17;
        return;
    L17:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r100, "userSession");     // Catch: Throwable -> L11
        int r102 = iy7.a.f496568a;     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r100, "userSession");     // Catch: Throwable -> L11
        q r103 = s.a(r100);     // Catch: Throwable -> L11
        if (r103 != null) goto L8;
        LarkLogger r104 = LarkLogger.f278603a;     // Catch: Throwable -> L11
        LarkLogger.b("UserScopeComponent", "session is null");     // Catch: Throwable -> L11
    L9:
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L19;
        LarkLogger r107 = LarkLogger.f278603a;
        LarkLogger.b("OfficeSDKKmpUserContainerLifecycle", "remove user container failed, userId=" + r100.f483350b + ": " + r106.getMessage());
        return;
    L19:
        return;
    L8:
        Map<d<?>, com.lark.kmp.containerization.c<?>> r108 = com.lark.kmp.containerization.a.f278584a;     // Catch: Throwable -> L11
        com.lark.kmp.containerization.c r109 = com.lark.kmp.containerization.a.a(b.f496570b);     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r103, "id");     // Catch: Throwable -> L11
        r109.f278586b.remove(r103);     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    @Inject
    public a(UserSession r100) {
        Intrinsics.checkNotNullParameter(r100, "userSession");
        this.f542438a = r100;
    }

    public final q a(String r100) {
        if (StringsKt.isBlank(this.f542438a.f438138b) == false) goto L5;
    L9:
        LarkLogger r101 = LarkLogger.f278603a;
        LarkLogger.b("OfficeSDKKmpUserContainerLifecycle", r100.concat(" user container skipped: user session is unavailable"));
        return null;
    L5:
        if (StringsKt.isBlank(this.f542438a.f438137a) == true) goto L9;
        UserSession r102 = this.f542438a;
        return new q(r102.f438138b, r102.f438137a);
    }
}
