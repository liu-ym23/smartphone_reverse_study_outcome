package com.larus.bmhome.chat.camera.command;

import com.larus.camera.impl.result.CameraResultFirstFlow;
import com.larus.feishu.office.im.impl.base.q0;
import com.larus.im.bean.bot.BotModel;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionData;
import com.larus.platform.model.action.SuggestedActionScene;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes25.dex */
public final class i implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f297595a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Deferred<BotModel> f297596b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f297597c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public BotModel f297598d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CameraSuggestedActionDataController f297599e;

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void G8(q0 r100) {
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void d(SuggestedActionData r100) {
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final boolean d3() {
        BotModel r100 = this.f297597c.a();
        if (r100 != null) goto L5;
        r100 = this.f297598d;
    L5:
        if (r100 != null) goto L11;
        if (this.f297596b.isCompleted() == true) goto L11;
        return true;
    L11:
        return this.f297599e.d3();
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void preload(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void c(String r100, iq9.e r101) {
        Intrinsics.checkNotNullParameter(r100, "bizScene");
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.larus.bmhome.chat.camera.command.g] */
    public i(CoroutineScope r100, CompletableDeferred r101, CameraResultFirstFlow.a.c r102) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        Intrinsics.checkNotNullParameter(r101, "botDeferred");
        Intrinsics.checkNotNullParameter(r102, "commandContext");
        this.f297595a = r100;
        this.f297596b = r101;
        this.f297597c = r102;
        CameraSuggestedActionDataController r103 = new CameraSuggestedActionDataController(new CameraDirectSuggestedActionProvider$controller$1(this), new o(new g(this), 2));
        this.f297599e = r103;
        r103.preload("o_result_first");
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final List<SuggestedAction> r4(SuggestedActionScene r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "bizScene");
        if (d3() == true) goto L7;
        return null;
    L7:
        return this.f297599e.r4(r100, r101, r102);
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void b(SuggestedActionScene r100, String r101, boolean r102, final Function1<? super List<SuggestedAction>, Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "bizScene");
        Intrinsics.checkNotNullParameter(r103, "callback");
        this.f297599e.b(r100, r101, r102, new h(r103, this));
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void a(SuggestedActionScene r100, String r101, boolean r102, String r103, Function1<? super List<SuggestedAction>, Unit> r104) {
        Intrinsics.checkNotNullParameter(r101, "bizScene");
        Intrinsics.checkNotNullParameter(r104, "callback");
        b(r100, r101, r102, r104);
    }
}
