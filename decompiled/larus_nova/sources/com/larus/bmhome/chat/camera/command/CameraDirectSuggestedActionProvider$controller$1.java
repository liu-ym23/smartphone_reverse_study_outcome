package com.larus.bmhome.chat.camera.command;

import com.larus.im.bean.bot.BotModel;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes25.dex */
public final class CameraDirectSuggestedActionProvider$controller$1 implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f297574a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i f297575b;

    @Override // com.larus.bmhome.chat.camera.command.l
    public final boolean c1() {
        return false;
    }

    @Override // com.larus.bmhome.chat.camera.command.l
    public final BotModel a() {
        i r100 = this.f297575b;
        BotModel r101 = r100.f297597c.a();
        if (r101 == null) goto L5;
        return r101;
    L5:
        return r100.f297598d;
    }

    @Override // com.larus.bmhome.chat.camera.command.l
    public final CoroutineScope getScope() {
        return this.f297574a;
    }

    public CameraDirectSuggestedActionProvider$controller$1(i r100) {
        this.f297575b = r100;
        this.f297574a = r100.f297595a;
    }

    @Override // com.larus.bmhome.chat.camera.command.l
    public final Object b(Continuation<? super BotModel> r100) {
        if ((r100 instanceof CameraDirectSuggestedActionProvider$controller$1$awaitBot$1) == false) goto L7;
        CameraDirectSuggestedActionProvider$controller$1$awaitBot$1 r101 = (CameraDirectSuggestedActionProvider$controller$1$awaitBot$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L17:
        BotModel r106 = (BotModel) r103;
        this.f297575b.f297598d = r106;
        return r103;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        Deferred<BotModel> r107 = this.f297575b.f297596b;
        r101.label = 1;
        r103 = r107.await(r101);
        if (r103 != r104) goto L17;
        return r104;
    L7:
        r101 = new CameraDirectSuggestedActionProvider$controller$1$awaitBot$1(this, r100);
        goto L8
    }
}
