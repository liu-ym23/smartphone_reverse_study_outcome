package up9;

import android.content.Context;
import com.bytedance.locallife.dito.data.DitoNode;
import com.larus.photopicker.v2.impl.j2;
import com.larus.photopicker.v2.impl.ui.MediaListAdapterV2;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class r implements g0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g0.a f551141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final g0.b f551142b;

    @Override // up9.g0
    public final void onDestroyView() {
    }

    @Override // up9.g0
    public final g0.a c() {
        return this.f551141a;
    }

    public r(g0.a r100, a r101) {
        Intrinsics.checkNotNullParameter(r100, "bottomSheetState");
        Intrinsics.checkNotNullParameter(r101, "selectionState");
        this.f551141a = r100;
        this.f551142b = r101;
    }

    /* JADX WARN: Type inference failed for: r6v0, types: [up9.q] */
    @Override // up9.g0
    public final MediaListAdapterV2 n(Context r100, int r101, int r110, j2 r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, DitoNode.LOAD_MORE);
        MediaListAdapterV2 r102 = new MediaListAdapterV2(r100, r101, r110, r111, new q(this));
        vp9.m r103 = this.f551141a.c(r100, this.f551142b);
        Intrinsics.checkNotNullParameter(r103, "state");
        r102.f364637k = r103;
        return r102;
    }
}
