package yg7;

import android.content.Intent;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class b implements com.bytedance.timon.result.a<Pair<? extends Integer, ? extends Intent>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ xg7.a<Intent> f567508a;

    public b(xg7.a<Intent> r100) {
        this.f567508a = r100;
    }

    @Override // com.bytedance.timon.result.a
    public final void invoke(Pair<? extends Integer, ? extends Intent> r100) {
        Pair<? extends Integer, ? extends Intent> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        this.f567508a.a(r101.getFirst().intValue(), r101.getSecond(), null);
    }
}
