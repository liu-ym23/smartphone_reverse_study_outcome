package nf8;

import android.net.Uri;
import com.larus.bmhome.chat.trace.multimodal.AttachmentAreaType;
import com.larus.bmhome.chat.trace.multimodal.MultimodalSendCostTrace;
import java.util.UUID;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: classes25.dex */
public final class c implements z19.k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f518967a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ wc9.e f518968b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Pair<Uri, Uri> f518969c;

    @Override // z19.k
    public final void b() {
        wc9.e r100 = this.f518968b;
        int r101 = MultimodalSendCostTrace.f310239a;
        MultimodalSendCostTrace.b(this.f518967a, null, r100.f559198a, null, AttachmentAreaType.NO_CLEAR, null, null, null);
    }

    @Override // z19.k
    public final void a(boolean r100) {
        if (r100 == true) goto L5;
        int r101 = MultimodalSendCostTrace.f310239a;
        MultimodalSendCostTrace.e(this.f518967a, String.valueOf(this.f518969c.getFirst()), null, "onboarding_avatar", false, MapsKt.mapOf(TuplesKt.to("onboarding_type", "big")));
        return;
    }

    @Override // z19.k
    public final void onFailure(Throwable r100) {
        int r101 = com.larus.bmhome.chat.trace.multimodal.a.f310241a;
        com.larus.bmhome.chat.trace.multimodal.a.a(this.f518967a, null, "[image_load_failed]: err:" + r100, String.valueOf(this.f518969c.getFirst()), "onboarding_avatar", false, MapsKt.mapOf(TuplesKt.to("onboarding_type", "big")));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(wc9.e r100, Pair<? extends Uri, ? extends Uri> r101) {
        this.f518968b = r100;
        this.f518969c = r101;
        this.f518967a = UUID.randomUUID().toString();
    }
}
