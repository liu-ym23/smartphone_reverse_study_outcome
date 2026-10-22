package com.larus.uaigc.music.template;

import com.larus.utils.logger.FLogger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

/* JADX INFO: loaded from: classes31.dex */
public final class MusicTemplateRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MusicTemplateRepository f373769a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableSharedFlow<Integer> f373770b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f373771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static MusicTemplateModel f373772d;

    public MusicTemplateRepository() {
    }

    static {
        f373769a = new MusicTemplateRepository();
        f373770b = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
    }

    public static void a(long r100) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new MusicTemplateRepository$countMusicTemplateUse$1(r100, null), 3, null);
    }

    public final Object c(Continuation<? super Unit> r100) {
        if ((r100 instanceof MusicTemplateRepository$prefetch$1) == false) goto L7;
        MusicTemplateRepository$prefetch$1 r101 = (MusicTemplateRepository$prefetch$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        MusicTemplateModel r106 = (MusicTemplateModel) r101.L$0;
        ResultKt.throwOnFailure(r103);
    L22:
        f373772d = r106;
        f373771c = false;
    L24:
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        FLogger.f375446a.i("MusicTemplateRepository", "try preFetch template list ");
        if (f373771c == false) goto L17;
    L18:
        MusicTemplateModel r107 = new MusicTemplateModel();
        r101.L$0 = r107;
        r101.label = 1;
        if (r107.b(r101) != r104) goto L21;
        return r104;
    L21:
        r106 = r107;
        goto L22
    L17:
        if (f373772d != null) goto L24;
    L7:
        r101 = new MusicTemplateRepository$prefetch$1(this, r100);
        goto L8
    }

    public final Object b(boolean r100, Continuation<? super MusicTemplateModel> r101) {
        if ((r101 instanceof MusicTemplateRepository$obtain$1) == false) goto L7;
        MusicTemplateRepository$obtain$1 r102 = (MusicTemplateRepository$obtain$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        r100 = r102.Z$0;
        MusicTemplateModel r107 = (MusicTemplateModel) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L20:
        f373772d = r107;
        MusicTemplateModel r108 = r107;
    L21:
        if (r100 == false) goto L23;
        f373771c = true;
    L23:
        return r108;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r108 = f373772d;
        if (r108 != null) goto L21;
        MusicTemplateModel r109 = new MusicTemplateModel();
        r102.L$0 = r109;
        r102.Z$0 = r100;
        r102.label = 1;
        if (r109.b(r102) != r105) goto L19;
        return r105;
    L19:
        r107 = r109;
    L7:
        r102 = new MusicTemplateRepository$obtain$1(this, r101);
        goto L8
    }
}
