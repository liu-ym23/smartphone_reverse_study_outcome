package com.bytedance.ee.bear.tts.impl;

import com.bytedance.ee.bear.contract.c0;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\u0010\u0000\u001a(\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u0001 \u0003*\u0012\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u0002\u0018\u00010\u00040\u0001*\u00020\u0005H\n"}, d2 = {"<anonymous>", "", "Lcom/bytedance/ee/bear/tts/playback/TtsPlaybackBean;", "kotlin.jvm.PlatformType", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.TtsAlbumViewModel$reloadAlbum$2$playbackBeanList$1", f = "TtsAlbumViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class TtsAlbumViewModel$reloadAlbum$2$playbackBeanList$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super List<so5.a>>, Object> {
    int label;

    public TtsAlbumViewModel$reloadAlbum$2$playbackBeanList$1(Continuation<? super TtsAlbumViewModel$reloadAlbum$2$playbackBeanList$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new TtsAlbumViewModel$reloadAlbum$2$playbackBeanList$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super List<so5.a>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L9;
        ResultKt.throwOnFailure(r3);
        List r4 = ((c0) org.koin.java.a.c(c0.class, null, null, 6)).k0();
        if (r4 == null) goto L10;
        tt5.a.h("TtsAlbumViewModel", "reloadAlbum, load DB, result: " + r4);
        return r4;
    L10:
        return null;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
