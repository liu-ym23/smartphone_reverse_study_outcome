package com.larus.bmhome.chat.camera.command;

import com.larus.feishu.office.im.impl.base.q0;
import com.larus.platform.model.action.SuggestedAction;
import com.larus.platform.model.action.SuggestedActionData;
import com.larus.platform.model.action.SuggestedActionScene;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class s implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final s f297607a = null;

    static {
        f297607a = new s();
    }

    public s() {
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void G8(q0 r100) {
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void c(String r100, iq9.e r101) {
        Intrinsics.checkNotNullParameter(r100, "bizScene");
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void d(SuggestedActionData r100) {
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final boolean d3() {
        return false;
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void preload(String r100) {
        Intrinsics.checkNotNullParameter(r100, "source");
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final List<SuggestedAction> r4(SuggestedActionScene r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r101, "bizScene");
        return CollectionsKt.emptyList();
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void b(SuggestedActionScene r100, String r101, boolean r102, Function1<? super List<SuggestedAction>, Unit> r103) {
        Intrinsics.checkNotNullParameter(r101, "bizScene");
        Intrinsics.checkNotNullParameter(r103, "callback");
        r103.invoke(CollectionsKt.emptyList());
    }

    @Override // com.larus.bmhome.chat.camera.command.p
    public final void a(SuggestedActionScene r100, String r101, boolean r102, String r103, Function1<? super List<SuggestedAction>, Unit> r104) {
        Intrinsics.checkNotNullParameter(r101, "bizScene");
        Intrinsics.checkNotNullParameter(r104, "callback");
        r104.invoke(CollectionsKt.emptyList());
    }
}
