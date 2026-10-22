package com.bytedance.ee.bear.tts.impl;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.ee.bear.tts.TtsDataSource;
import com.bytedance.ee.bear.tts.TtsLoadScene;
import com.bytedance.ee.bear.tts.TtsResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/bytedance/ee/bear/tts/TtsResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.ee.bear.tts.impl.TtsAlbumViewModel$reloadAlbum$2", f = "TtsAlbumViewModel.kt", i = {}, l = {90}, m = "invokeSuspend", n = {}, s = {})
final class TtsAlbumViewModel$reloadAlbum$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super TtsResult>, Object> {
    final /* synthetic */ boolean $clearFirst;
    int label;
    final /* synthetic */ TtsAlbumViewModel this$0;

    public static final class a implements mo5.b {
        public final /* synthetic */ TtsAlbumViewModel a;
        public final /* synthetic */ mo5.g b;

        public a(TtsAlbumViewModel r1, mo5.g r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // mo5.b
        public final void a(TtsResult r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            TtsAlbumViewModel r3 = this.a;
            int r0 = TtsAlbumViewModel.j;
            ((MutableLiveData) r3.c.getValue()).setValue(this.b);
        }
    }

    public TtsAlbumViewModel$reloadAlbum$2(boolean r1, TtsAlbumViewModel r2, Continuation<? super TtsAlbumViewModel$reloadAlbum$2> r3) {
        this.$clearFirst = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new TtsAlbumViewModel$reloadAlbum$2(this.$clearFirst, this.this$0, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super TtsResult> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v11, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        List r3 = null;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L14:
        List r9 = (List) r8;
        if (r9 == null) goto L25;
        ?? r2 = new ArrayList();
        Iterator r10 = r9.iterator();
    L18:
        if (r10.hasNext() == false) goto L26;
        so5.a r4 = (so5.a) r10.next();
        if (r4 != null) goto L22;
        TtsViewModel r5 = null;
    L23:
        if (r5 == null) goto L18;
        r2.add(r5);
        goto L18
    L22:
        TtsDataSource r6 = TtsDataSource.UNKNOWN;
        r5 = new TtsViewModel(r4.a, r4.b, null, r4);
    L26:
        tt5.a.h("TtsAlbumViewModel", "reloadAlbum, create viewModelList, size: " + r2.size());
        List r11 = TtsAlbumViewModel.r(this.this$0, r2);
        if ((!r11.isEmpty()) == false) goto L29;
        r3 = r11;
    L29:
        if (r3 == null) goto L42;
        TtsAlbumViewModel r12 = this.this$0;
        MutableLiveData r7 = (MutableLiveData) r12.b.getValue();
        List<mo5.g> r13 = r12.u();
        monitor-enter(r13);
        ArrayList r14 = new ArrayList(r12.u());     // Catch: Throwable -> L38
        monitor-exit(r13);
        r7.setValue(r14);
        Iterator r15 = r3.iterator();
    L36:
        if (r15.hasNext() == false) goto L42;
        mo5.g r16 = (mo5.g) r15.next();
        tt5.a.h("TtsAlbumViewModel", "reloadAlbum, viewModel added, will preload it: " + r16);
        r16.s(TtsLoadScene.DEFAULT, new a(r12, r16));
    L38:
        th = move-exception;
        throw th;
    L42:
        return TtsResult.d;
    L25:
        r2 = CollectionsKt.emptyList();
        goto L26
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        if (this.$clearFirst == false) goto L11;
        TtsAlbumViewModel r17 = this.this$0;
        int r18 = TtsAlbumViewModel.j;
        r17.t();
    L11:
        CoroutineDispatcher r19 = Dispatchers.getIO();
        TtsAlbumViewModel$reloadAlbum$2$playbackBeanList$1 r20 = new TtsAlbumViewModel$reloadAlbum$2$playbackBeanList$1(null);
        this.label = 1;
        r8 = BuildersKt.withContext(r19, r20, this);
        if (r8 != r0) goto L14;
        return r0;
    }
}
