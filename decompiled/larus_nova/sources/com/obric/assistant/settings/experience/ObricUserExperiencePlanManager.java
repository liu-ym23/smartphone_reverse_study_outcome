package com.obric.assistant.settings.experience;

import com.larus.account.base.api.ILoginService;
import com.obric.assistant.t1;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.sync.MutexImpl;
import n38.j;

/* JADX INFO: loaded from: classes4.dex */
public final class ObricUserExperiencePlanManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricUserExperiencePlanManager f392033a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f392034b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final MutexImpl f392035c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final StateFlowImpl f392036d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final StateFlowImpl f392037e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static volatile boolean f392038f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final c f392039g = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f392040a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f392041b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f392042c;

        public a() {
            boolean r100 = false;
            this(r100, r100, 7);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f392040a == r101.f392040a) goto L12;
            return false;
        L12:
            if (this.f392041b == r101.f392041b) goto L15;
            return false;
        L15:
            if (this.f392042c == r101.f392042c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f392040a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f392041b == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (r102 + r103) * 31;
            if (this.f392042c == true) goto L15;
            r100 = 1237;
        L15:
            return r104 + r100;
        L9:
            r103 = 1237;
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "State(voiceEnabled=" + this.f392040a + ", modelEnabled=" + this.f392041b + ", remoteSynced=" + this.f392042c + ')';
        }

        public final boolean b() {
            if (this.f392040a == false) goto L5;
        L8:
            return true;
        L5:
            if (this.f392041b == true) goto L8;
            return false;
        }

        public /* synthetic */ a(boolean r100, boolean r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r100 = false;
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = false;
        L8:
            this(r100, r101, false);
        }

        public a(boolean r100, boolean r101, boolean r102) {
            this.f392040a = r100;
            this.f392041b = r101;
            this.f392042c = r102;
        }

        public static a a(a r100, boolean r101, boolean r102, int r103) {
            if ((r103 & 1) == 0) goto L6;
            r101 = r100.f392040a;
        L6:
            if ((r103 & 2) == 0) goto L9;
            r102 = r100.f392041b;
        L9:
            if ((r103 & 4) == 0) goto L11;
            boolean r104 = r100.f392042c;
        L12:
            r100.getClass();
            return new a(r101, r102, r104);
        L11:
            r104 = false;
            goto L12
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f392043a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f392044b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final a f392045c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f392043a == r101.f392043a) goto L12;
            return false;
        L12:
            if (this.f392044b == r101.f392044b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f392045c, r101.f392045c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f392043a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f392044b == true) goto L11;
            r100 = 1237;
        L11:
            return ((r102 + r100) * 31) + this.f392045c.hashCode();
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "UpdateResult(voiceSucceeded=" + this.f392043a + ", modelSucceeded=" + this.f392044b + ", state=" + this.f392045c + ')';
        }

        public b(boolean r100, boolean r101, a r102) {
            Intrinsics.checkNotNullParameter(r102, "state");
            this.f392043a = r100;
            this.f392044b = r101;
            this.f392045c = r102;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class c implements j {
        public c() {
        }

        @Override // n38.j
        public final void a(n38.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            StateFlowImpl r101 = ObricUserExperiencePlanManager.f392036d;
            ObricUserExperiencePlanManager r102 = ObricUserExperiencePlanManager.f392033a;
            r101.setValue(ObricUserExperiencePlanManager.e());
        }

        @Override // n38.j
        public final void b(n38.a r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            ObricUserExperiencePlanManager r101 = ObricUserExperiencePlanManager.f392033a;
            ObricUserExperiencePlanManager.g();
        }
    }

    public ObricUserExperiencePlanManager() {
    }

    static {
        f392033a = new ObricUserExperiencePlanManager();
        f392034b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f392035c = kotlinx.coroutines.sync.b.a();
        StateFlowImpl r100 = j1.a(e());
        f392036d = r100;
        f392037e = r100;
        f392039g = new c();
    }

    public static String a() {
        q38.a r100 = ILoginService.f286097a.getAccountInfo();
        String r101 = r100.f531530c;
        if (r100.f531528a == true) goto L6;
        r101 = null;
    L6:
        if (r101 != null) goto L9;
        return "";
    L9:
        return r101;
    }

    public static a b() {
        return (a) f392036d.getValue();
    }

    public static a e() {
        t1 r100 = t1.f393353a;
        return new a(r100.x0(), r100.J0(), 4);
    }

    public static void g() {
        BuildersKt.launch$default(f392034b, null, null, new ObricUserExperiencePlanManager$refreshInBackground$1(null), 3, null);
    }

    public static a d() {
        a r100 = e();
        f392036d.setValue(r100);
        return r100;
    }

    public static boolean c(String r100) {
        q38.a r101 = ILoginService.f286097a.getAccountInfo();
        if (r101.f531528a == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(r101.f531530c, r100) == false) goto L7;
        return true;
    }

    public final Object f(Continuation<? super a> r100) {
        if ((r100 instanceof ObricUserExperiencePlanManager$refresh$1) == false) goto L7;
        ObricUserExperiencePlanManager$refresh$1 r101 = (ObricUserExperiencePlanManager$refresh$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L20;
        if (r105 == 1) goto L19;
        if (r105 != 2) goto L18;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L15
    L27:
        a r107 = (a) r103;     // Catch: Throwable -> L15
        r106.unlock(null);
        return r107;
    L15:
        th = th;
        kotlinx.coroutines.sync.a r108 = r106;
    L32:
        r108.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r108 = (kotlinx.coroutines.sync.a) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L36:
        r101.L$0 = r108;     // Catch: Throwable -> L31
        r101.label = 2;     // Catch: Throwable -> L31
        r103 = SupervisorKt.supervisorScope(new ObricUserExperiencePlanManager$refreshLocked$2(null), r101);     // Catch: Throwable -> L31
        if (r103 != r104) goto L26;
        return r104;
    L26:
        r106 = r108;
    L31:
        th = th;
        goto L32
    L20:
        ResultKt.throwOnFailure(r103);
        r108 = f392035c;
        r101.L$0 = r108;
        r101.label = 1;
        if (r108.a(null, r101) != r104) goto L36;
        return r104;
    L7:
        r101 = new ObricUserExperiencePlanManager$refresh$1(this, r100);
        goto L8
    }

    public final Object h(boolean r100, Continuation<? super b> r101) {
        if ((r101 instanceof ObricUserExperiencePlanManager$setEnabled$1) == false) goto L7;
        ObricUserExperiencePlanManager$setEnabled$1 r102 = (ObricUserExperiencePlanManager$setEnabled$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L20;
        if (r106 == 1) goto L19;
        if (r106 != 2) goto L18;
        kotlinx.coroutines.sync.a r107 = (kotlinx.coroutines.sync.a) r102.L$0;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L15
    L27:
        b r108 = (b) r104;     // Catch: Throwable -> L15
        r107.unlock(null);
        return r108;
    L15:
        Throwable th10 = th;
        kotlinx.coroutines.sync.a r109 = r107;
    L33:
        r109.unlock(null);
        throw th10;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r100 = r102.Z$0;
        r109 = (kotlinx.coroutines.sync.a) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L35:
        r102.L$0 = r109;     // Catch: Throwable -> L31
        r102.label = 2;     // Catch: Throwable -> L31
        r104 = SupervisorKt.supervisorScope(new ObricUserExperiencePlanManager$setEnabledLocked$2(r100, null), r102);     // Catch: Throwable -> L31
        if (r104 != r105) goto L26;
        return r105;
    L26:
        r107 = r109;
    L31:
        th = move-exception;
        th10 = th;
        goto L33
    L20:
        ResultKt.throwOnFailure(r104);
        r109 = f392035c;
        r102.L$0 = r109;
        r102.Z$0 = r100;
        r102.label = 1;
        if (r109.a(null, r102) != r105) goto L35;
        return r105;
    L7:
        r102 = new ObricUserExperiencePlanManager$setEnabled$1(this, r101);
        goto L8
    }

    public final Object i(boolean r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof ObricUserExperiencePlanManager$setModelEnabled$1) == false) goto L7;
        ObricUserExperiencePlanManager$setModelEnabled$1 r100 = (ObricUserExperiencePlanManager$setModelEnabled$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = false;
        if (r103 == 0) goto L20;
        if (r103 == 1) goto L19;
        if (r103 != 2) goto L18;
        r110 = r100.Z$0;
        String r105 = (String) r100.L$1;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L15
    L34:
        boolean r113 = ((Boolean) r112).booleanValue();     // Catch: Throwable -> L15
        if (c(r105) == true) goto L37;
        d();     // Catch: Throwable -> L15
    L46:
        Boolean r114 = Boxing.boxBoolean(r104);     // Catch: Throwable -> L15
        r106.unlock(null);
        return r114;
    L37:
        if (r113 == false) goto L43;
        t1 r107 = t1.f393353a;     // Catch: Throwable -> L15
        if (r110 == false) goto L41;
        boolean r115 = true;
    L42:
        r107.q0(r115);     // Catch: Throwable -> L15
        goto L43
    L41:
        r115 = false;
    L43:
        f392036d.setValue(e());     // Catch: Throwable -> L15
        if (r113 == false) goto L46;
        r104 = true;
    L15:
        th = th;
        kotlinx.coroutines.sync.a r108 = r106;
    L51:
        r108.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r110 = r100.Z$0;
        r108 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L55:
        String r116 = a();     // Catch: Throwable -> L50
        if (StringsKt.isBlank(r116) == false) goto L26;
        r106 = r108;
        goto L46
    L26:
        CoroutineDispatcher r109 = Dispatchers.getIO();     // Catch: Throwable -> L50
        if (r110 == false) goto L29;
        boolean r117 = true;
    L30:
        ObricUserExperiencePlanManager$setModelEnabled$2$succeeded$1 r118 = new ObricUserExperiencePlanManager$setModelEnabled$2$succeeded$1(r117, null);     // Catch: Throwable -> L50
        r100.L$0 = r108;     // Catch: Throwable -> L50
        r100.L$1 = r116;     // Catch: Throwable -> L50
        r100.Z$0 = r110;     // Catch: Throwable -> L50
        r100.label = 2;     // Catch: Throwable -> L50
        Object r119 = BuildersKt.withContext(r109, r118, r100);     // Catch: Throwable -> L50
        if (r119 != r102) goto L33;
        return r102;
    L33:
        r105 = r116;
        r112 = r119;
        r106 = r108;
        goto L34
    L29:
        r117 = false;
    L50:
        th = th;
        goto L51
    L20:
        ResultKt.throwOnFailure(r112);
        r108 = f392035c;
        r100.L$0 = r108;
        r100.Z$0 = r110;
        r100.label = 1;
        if (r108.a(null, r100) != r102) goto L55;
        return r102;
    L7:
        r100 = new ObricUserExperiencePlanManager$setModelEnabled$1(this, r111);
        goto L8
    }

    public final Object j(boolean r110, Continuation<? super Boolean> r111) {
        if ((r111 instanceof ObricUserExperiencePlanManager$setVoiceEnabled$1) == false) goto L7;
        ObricUserExperiencePlanManager$setVoiceEnabled$1 r100 = (ObricUserExperiencePlanManager$setVoiceEnabled$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = false;
        if (r103 == 0) goto L20;
        if (r103 == 1) goto L19;
        if (r103 != 2) goto L18;
        r110 = r100.Z$0;
        String r105 = (String) r100.L$1;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L15
    L34:
        boolean r113 = ((Boolean) r112).booleanValue();     // Catch: Throwable -> L15
        if (c(r105) == true) goto L37;
        d();     // Catch: Throwable -> L15
    L46:
        Boolean r114 = Boxing.boxBoolean(r104);     // Catch: Throwable -> L15
        r106.unlock(null);
        return r114;
    L37:
        if (r113 == false) goto L43;
        t1 r107 = t1.f393353a;     // Catch: Throwable -> L15
        if (r110 == false) goto L41;
        boolean r115 = true;
    L42:
        r107.i1(r115);     // Catch: Throwable -> L15
        goto L43
    L41:
        r115 = false;
    L43:
        f392036d.setValue(e());     // Catch: Throwable -> L15
        if (r113 == false) goto L46;
        r104 = true;
    L15:
        th = th;
        kotlinx.coroutines.sync.a r108 = r106;
    L51:
        r108.unlock(null);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r110 = r100.Z$0;
        r108 = (kotlinx.coroutines.sync.a) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L55:
        String r116 = a();     // Catch: Throwable -> L50
        if (StringsKt.isBlank(r116) == false) goto L26;
        r106 = r108;
        goto L46
    L26:
        CoroutineDispatcher r109 = Dispatchers.getIO();     // Catch: Throwable -> L50
        if (r110 == false) goto L29;
        boolean r117 = true;
    L30:
        ObricUserExperiencePlanManager$setVoiceEnabled$2$succeeded$1 r118 = new ObricUserExperiencePlanManager$setVoiceEnabled$2$succeeded$1(r117, null);     // Catch: Throwable -> L50
        r100.L$0 = r108;     // Catch: Throwable -> L50
        r100.L$1 = r116;     // Catch: Throwable -> L50
        r100.Z$0 = r110;     // Catch: Throwable -> L50
        r100.label = 2;     // Catch: Throwable -> L50
        Object r119 = BuildersKt.withContext(r109, r118, r100);     // Catch: Throwable -> L50
        if (r119 != r102) goto L33;
        return r102;
    L33:
        r105 = r116;
        r112 = r119;
        r106 = r108;
        goto L34
    L29:
        r117 = false;
    L50:
        th = th;
        goto L51
    L20:
        ResultKt.throwOnFailure(r112);
        r108 = f392035c;
        r100.L$0 = r108;
        r100.Z$0 = r110;
        r100.label = 1;
        if (r108.a(null, r100) != r102) goto L55;
        return r102;
    L7:
        r100 = new ObricUserExperiencePlanManager$setVoiceEnabled$1(this, r111);
        goto L8
    }
}
