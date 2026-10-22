package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingAutoTranslationCoordinator {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f435254k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f435255a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a f435256b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<String> f435257c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Boolean> f435258d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function2<h, Continuation<? super Unit>, Object> f435259e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final AtomicBoolean f435260f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StateFlowImpl f435261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public f f435262h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f435263i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f435264j;

    /* JADX INFO: renamed from: com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.MmRecordingAutoTranslationCoordinator$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", AbsMethodDelegate.TAG_INVOKE, "()Ljava/lang/Boolean;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    final class AnonymousClass1 extends Lambda implements Function0<Boolean> {
        public static final AnonymousClass1 INSTANCE = null;

        static {
            INSTANCE = new AnonymousClass1();
        }

        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Boolean invoke() {
            return invoke();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Boolean invoke() {
            return Boolean.TRUE;
        }
    }

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f435265a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f435266b = null;

        static {
            int[] r100 = new int[MmAutoTranslationStage.values().length];
            r100[MmAutoTranslationStage.TRANSLATION.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[MmAutoTranslationStage.BILINGUAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L6:
            f435265a = r100;
            int[] r101 = new int[MmAutoLanguageSettingResult.values().length];
            r101[MmAutoLanguageSettingResult.SUCCESS.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L25:
            r101[MmAutoLanguageSettingResult.FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L21:
            r101[MmAutoLanguageSettingResult.OBSOLETE.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L10:
            f435266b = r101;
        }
    }

    static {
    }

    public final boolean e() {
        if (this.f435260f.get() == false) goto L6;
        return false;
    L6:
        Function0<Boolean> r100 = this.f435258d;
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L9
        Object r102 = Result.m9449constructorimpl(r100.invoke());     // Catch: Throwable -> L9
    L11:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L14;
        lvb.a.b("MmAutoTranslation", "[isOperationActive] lifecycle failed, error=" + r103);
    L14:
        Boolean r104 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r102) == false) goto L18;
        r102 = r104;
    L18:
        return ((Boolean) r102).booleanValue();
    L9:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final void h() {
        if (this.f435260f.compareAndSet(false, true) == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this.f435255a, null, CoroutineStart.UNDISPATCHED, new MmRecordingAutoTranslationCoordinator$onRecordingInactive$1(this, null), 1, null);
    }

    public final void l() {
        e r100 = (e) this.f435261g.getValue();
        if (r100 != null) goto L5;
        return;
    L5:
        MmAutoTranslationStatus r101 = r100.f435289a;
        if (r101 != MmAutoTranslationStatus.WAITING) goto L8;
    L9:
        m(e.a(r100, MmAutoTranslationStatus.SKIPPED, null, null, 0, 0, "recording_inactive", 30));
        return;
    L8:
        if (r101 == MmAutoTranslationStatus.APPLYING) goto L9;
    }

    public final void g() {
        if (e() == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this.f435255a, null, null, new MmRecordingAutoTranslationCoordinator$onManualSettingIntent$1(this, null), 3, null);
    }

    public final e a(long r100) {
        e r101 = (e) this.f435261g.getValue();
        if (r101 != null) goto L5;
    L14:
        return null;
    L5:
        if (e() == true) goto L7;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == false) goto L14;
        return r101;
    L7:
        if (r101.f435292d != r100) goto L11;
        if (r101.f435289a != MmAutoTranslationStatus.APPLYING) goto L11;
        r102 = true;
        goto L12
    }

    public final void f(f r100) {
        Intrinsics.checkNotNullParameter(r100, "entity");
        if (e() == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this.f435255a, null, null, new MmRecordingAutoTranslationCoordinator$onLanguageEntityChanged$1(this, r100, null), 3, null);
    }

    public final void i(Boolean r100) {
        if (e() == true) goto L5;
        return;
    L5:
        BuildersKt.launch$default(this.f435255a, null, null, new MmRecordingAutoTranslationCoordinator$onSubtitleStateChanged$1(this, r100, null), 3, null);
    }

    public final void j(String r100) {
        if (r100 == null) goto L5;
        String r101 = StringsKt.trim(r100).toString();
    L6:
        if (r101 != null) goto L9;
        r101 = "";
    L9:
        if (r101.length() != 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == false) goto L14;
    L18:
        lvb.a.e("MmAutoTranslation", "[onTranslationSuggested] ignore empty or inactive");
        return;
    L14:
        if (e() == false) goto L18;
        BuildersKt.launch$default(this.f435255a, null, null, new MmRecordingAutoTranslationCoordinator$onTranslationSuggested$1(this, r101, null), 3, null);
        return;
    L11:
        r102 = false;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public final void m(e r100) {
        this.f435261g.setValue(r100);
        lvb.a.e("MmAutoTranslation", "[state] status=" + r100.f435289a + ", stage=" + r100.f435291c + ", target=" + r100.f435290b + ", operation=" + r100.f435292d + ", revision=" + r100.f435293e + ", reason=" + r100.f435294f);
    }

    public final Object b(c r210, Continuation<? super Unit> r211) {
        c r100 = r210;
        if ((r211 instanceof MmRecordingAutoTranslationCoordinator$applyBilingual$1) == false) goto L7;
        MmRecordingAutoTranslationCoordinator$applyBilingual$1 r101 = (MmRecordingAutoTranslationCoordinator$applyBilingual$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
    L53:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (c) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L23:
        MmAutoLanguageSettingResult r106 = (MmAutoLanguageSettingResult) r103;
        e r110 = a(r100.f435286a.f435292d);
        if (r110 == null) goto L26;
        int r107 = b.f435266b[r106.ordinal()];
        if (r107 == 1) goto L37;
        if (r107 != 2) goto L31;
        m(e.a(r110, MmAutoTranslationStatus.WAITING, null, MmAutoTranslationStage.BILINGUAL, 0, 0, "bilingual_failed", 26));
    L36:
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.b r108 = null;
    L48:
        if (r108 == null) goto L53;
        r101.L$0 = null;
        r101.label = 2;
        if (d(r108, r101) != r104) goto L53;
        return r104;
    L31:
        if (r107 != 3) goto L34;
        m(e.a(r110, MmAutoTranslationStatus.SKIPPED, null, null, 0, 0, "obsolete", 30));
        goto L36
    L34:
        throw new NoWhenBranchMatchedException();
    L37:
        f r109 = f.a(this.f435262h, null, null, null, null, true, false, false, 111);
        this.f435262h = r109;
        Iterator<T> r111 = r109.f435296b.iterator();
    L39:
        if (r111.hasNext() == false) goto L43;
        Object r112 = r111.next();
        if (Intrinsics.areEqual(((h) r112).f435304a, r110.f435290b) == false) goto L39;
    L44:
        h r113 = (h) r112;
        if (r113 != null) goto L47;
        r113 = new h(r110.f435290b, "");
    L47:
        e r114 = e.a(r110, MmAutoTranslationStatus.APPLIED, null, null, 0, 0, "", 30);
        m(r114);
        r108 = new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.b(r114, r113);
        goto L48
    L43:
        r112 = null;
        goto L44
    L26:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r103);
        if (e() == false) goto L19;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a r115 = this.f435256b;
        long r116 = r100.f435286a.f435293e;
        r101.L$0 = r100;
        r101.label = 1;
        r103 = r115.k0(r116, r101);
        if (r103 != r104) goto L23;
        return r104;
    L19:
        return Unit.INSTANCE;
    L7:
        r101 = new MmRecordingAutoTranslationCoordinator$applyBilingual$1(this, r211);
        goto L8
    }

    public final Object c(d r210, Continuation<? super Unit> r211) {
        d r100 = r210;
        if ((r211 instanceof MmRecordingAutoTranslationCoordinator$applyTranslation$1) == false) goto L7;
        MmRecordingAutoTranslationCoordinator$applyTranslation$1 r101 = (MmRecordingAutoTranslationCoordinator$applyTranslation$1) r211;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L16;
        if (r105 == 1) goto L15;
        if (r105 != 2) goto L14;
        ResultKt.throwOnFailure(r103);
    L43:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r100 = (d) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L23:
        MmAutoLanguageSettingResult r107 = (MmAutoLanguageSettingResult) r103;
        e r110 = a(r100.f435287a.f435292d);
        if (r110 == null) goto L26;
        int r108 = b.f435266b[r107.ordinal()];
        if (r108 == 1) goto L37;
        if (r108 != 2) goto L31;
        m(e.a(r110, MmAutoTranslationStatus.WAITING, null, null, 0, 0, "translation_failed", 30));
    L36:
        r106 = false;
    L38:
        if (r106 == false) goto L45;
        r101.L$0 = null;
        r101.label = 2;
        if (k("translation_success", r101) != r104) goto L43;
        return r104;
    L45:
        return Unit.INSTANCE;
    L31:
        if (r108 != 3) goto L34;
        m(e.a(r110, MmAutoTranslationStatus.SKIPPED, null, null, 0, 0, "obsolete", 30));
        goto L36
    L34:
        throw new NoWhenBranchMatchedException();
    L37:
        this.f435262h = f.a(this.f435262h, null, null, null, r100.f435288b, false, false, false, 119);
        m(e.a(r110, MmAutoTranslationStatus.WAITING, null, MmAutoTranslationStage.BILINGUAL, 0, 0, "", 26));
        goto L38
    L26:
        return Unit.INSTANCE;
    L16:
        ResultKt.throwOnFailure(r103);
        if (e() == false) goto L19;
        com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a r109 = this.f435256b;
        h r111 = r100.f435288b;
        long r112 = r100.f435287a.f435293e;
        r101.L$0 = r100;
        r101.label = 1;
        r103 = r109.a0(r111, r112, r101);
        if (r103 != r104) goto L23;
        return r104;
    L19:
        return Unit.INSTANCE;
    L7:
        r101 = new MmRecordingAutoTranslationCoordinator$applyTranslation$1(this, r211);
        goto L8
    }

    public final Object d(com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.b r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof MmRecordingAutoTranslationCoordinator$deliverCompletion$1) == false) goto L7;
        MmRecordingAutoTranslationCoordinator$deliverCompletion$1 r100 = (MmRecordingAutoTranslationCoordinator$deliverCompletion$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L17;
        if (r104 != 1) goto L16;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L13
    L56:
    L55:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r102);
        if (e() == false) goto L20;
        e r105 = (e) this.f435261g.getValue();
        boolean r106 = false;
        if (e() == true) goto L30;
        if (r105 != null) goto L25;
    L27:
        boolean r107 = false;
    L28:
        if (r107 == false) goto L47;
        m(e.a(r105, MmAutoTranslationStatus.SKIPPED, null, null, 0, 0, "recording_inactive", 30));
    L47:
        if (r106 == false) goto L49;
        Function2<h, Continuation<? super Unit>, Object> r108 = this.f435259e;     // Catch: Throwable -> L13
        h r109 = r110.f435285b;     // Catch: Throwable -> L13
        r100.label = 1;     // Catch: Throwable -> L13
        if (r108.invoke(r109, r100) != r103) goto L56;
        return r103;
    L49:
        return Unit.INSTANCE;
    L25:
        if (r105.f435292d != r110.f435284a.f435292d) goto L27;
        r107 = true;
        goto L28
    L30:
        if (r105 != null) goto L32;
    L34:
        boolean r112 = false;
    L35:
        if (r112 == true) goto L37;
    L40:
        if (r105 != null) goto L42;
    L44:
        boolean r113 = false;
    L45:
        if (r113 == false) goto L47;
        m(e.a(r105, MmAutoTranslationStatus.SKIPPED, null, null, 0, 0, "manual_before_feedback", 30));
        goto L47
    L42:
        if (r105.f435292d != r110.f435284a.f435292d) goto L44;
        r113 = true;
        goto L45
    L37:
        if (this.f435256b.i0() != r110.f435284a.f435293e) goto L40;
        r106 = true;
        goto L47
    L32:
        if (r105.f435292d != r110.f435284a.f435292d) goto L34;
        r112 = true;
        goto L35
    L20:
        return Unit.INSTANCE;
    L13:
        th = move-exception;
        lvb.a.b("MmAutoTranslation", "[deliverCompletion] failed, error=" + th);
    L7:
        r100 = new MmRecordingAutoTranslationCoordinator$deliverCompletion$1(this, r111);
        goto L8
    }

    public final Object k(String r110, Continuation<? super Unit> r111) {
        if (e() == false) goto L5;
        Object r100 = null;
        if (e() == true) goto L9;
        l();
    L68:
        if (r100 != null) goto L72;
        return Unit.INSTANCE;
    L72:
        if ((r100 instanceof d) == false) goto L79;
        Object r112 = c((d) r100, r111);
        if (r112 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L77;
        return r112;
    L77:
        return Unit.INSTANCE;
    L79:
        if ((r100 instanceof c) == false) goto L86;
        Object r113 = b((c) r100, r111);
        if (r113 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L84;
        return r113;
    L84:
        return Unit.INSTANCE;
    L86:
        if ((r100 instanceof com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.b) == false) goto L93;
        Object r114 = d((com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.b) r100, r111);
        if (r114 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L91;
        return r114;
    L91:
        return Unit.INSTANCE;
    L93:
        throw new NoWhenBranchMatchedException();
    L9:
        e r101 = (e) this.f435261g.getValue();
        if (r101 == null) goto L68;
        if (r101.f435289a != MmAutoTranslationStatus.WAITING) goto L68;
        if (this.f435256b.i0() == r101.f435293e) goto L19;
        m(e.a(r101, MmAutoTranslationStatus.SKIPPED, null, null, 0, 0, "manual_revision", 30));
        goto L68
    L19:
        if (StringsKt.isBlank(this.f435257c.invoke()) == false) goto L21;
    L67:
        StringBuilder r102 = new StringBuilder("[reevaluate] waiting, trigger=");
        r102.append(r110);
        r102.append(", meetingReady=");
        r102.append(!StringsKt.isBlank(this.f435257c.invoke()));
        r102.append(", subtitleOn=");
        r102.append(this.f435263i);
        r102.append(", settingsReady=");
        r102.append(this.f435262h.f435300f);
        r102.append(", listReady=");
        r102.append(this.f435262h.f435301g);
        lvb.a.e("MmAutoTranslation", r102.toString());
        goto L68
    L21:
        if (Intrinsics.areEqual(this.f435263i, Boolean.TRUE) == false) goto L67;
        f r103 = this.f435262h;
        if (r103.f435300f == false) goto L67;
        if (r103.f435301g == false) goto L67;
        int r115 = b.f435265a[r101.f435291c.ordinal()];
        if (r115 != 1) goto L30;
        String r116 = this.f435262h.f435298d.f435304a;
        if (StringsKt.isBlank(r116) == true) goto L68;
        if (Intrinsics.areEqual(r116, "source") == true) goto L56;
        m(e.a(r101, MmAutoTranslationStatus.SKIPPED, null, null, 0, 0, "translation_exists", 30));
        goto L68
    L56:
        Iterator<T> r117 = this.f435262h.f435296b.iterator();
    L58:
        if (r117.hasNext() == false) goto L62;
        Object r104 = r117.next();
        if (Intrinsics.areEqual(((h) r104).f435304a, r101.f435290b) == false) goto L58;
    L63:
        h r105 = (h) r104;
        if (r105 != null) goto L66;
        m(e.a(r101, MmAutoTranslationStatus.SKIPPED, null, null, 0, 0, "unsupported", 30));
        goto L68
    L66:
        e r118 = e.a(r101, MmAutoTranslationStatus.APPLYING, null, null, 0, 0, "", 30);
        m(r118);
        r100 = new d(r118, r105);
        goto L68
    L62:
        r104 = null;
        goto L63
    L30:
        if (r115 != 2) goto L49;
        Iterator<T> r119 = this.f435262h.f435296b.iterator();
    L33:
        if (r119.hasNext() == false) goto L37;
        Object r106 = r119.next();
        if (Intrinsics.areEqual(((h) r106).f435304a, r101.f435290b) == false) goto L33;
    L38:
        h r107 = (h) r106;
        if (r107 != null) goto L42;
        r107 = new h(r101.f435290b, "");
    L42:
        if (Intrinsics.areEqual(this.f435262h.f435298d.f435304a, r101.f435290b) == true) goto L45;
        m(e.a(r101, MmAutoTranslationStatus.SKIPPED, null, null, 0, 0, "translation_changed", 30));
        goto L68
    L45:
        if (this.f435262h.f435299e == false) goto L47;
        e r120 = e.a(r101, MmAutoTranslationStatus.APPLIED, null, null, 0, 0, "", 30);
        m(r120);
        r100 = new com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.b(r120, r107);
        goto L68
    L47:
        e r121 = e.a(r101, MmAutoTranslationStatus.APPLYING, null, null, 0, 0, "", 30);
        m(r121);
        r100 = new c(r121);
        goto L68
    L37:
        r106 = null;
        goto L38
    L49:
        throw new NoWhenBranchMatchedException();
    L5:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MmRecordingAutoTranslationCoordinator(CoroutineScope r100, com.ss.android.lark.officesdk.minutes.service.recording.common.repo.subtitle.language.a r101, Function0<String> r102, Function0<Boolean> r103, Function2<? super h, ? super Continuation<? super Unit>, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "languageOperator");
        Intrinsics.checkNotNullParameter(r102, "meetingIdProvider");
        Intrinsics.checkNotNullParameter(r103, "recordingActiveProvider");
        Intrinsics.checkNotNullParameter(r104, "onFullyApplied");
        this.f435255a = r100;
        this.f435256b = r101;
        this.f435257c = r102;
        this.f435258d = r103;
        this.f435259e = r104;
        this.f435260f = new AtomicBoolean(false);
        StateFlowImpl r105 = j1.a(null);
        this.f435261g = r105;
        this.f435262h = new f(0);
        kotlinx.coroutines.flow.e.b(r105);
    }
}
