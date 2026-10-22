package com.larus.drive.sdk.impl.view.preview;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class DrivePreviewFragment$initFloatChatContainer$1 extends FunctionReferenceImpl implements Function0<Bundle> {
    public DrivePreviewFragment$initFloatChatContainer$1(Object r100) {
        super(0, r100, DrivePreviewFragment.class, "getParamsBundle", "getParamsBundle()Landroid/os/Bundle;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Bundle invoke() {
        return com.larus.utils.f.c(new Pair[]{TuplesKt.to("conversation_id", ((DrivePreviewFragment) this.receiver).f342293i), TuplesKt.to("argPreviousPage", "ai_space_list")});
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Bundle invoke() {
        return invoke();
    }
}
