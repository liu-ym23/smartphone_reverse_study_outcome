package yg7;

import android.content.Intent;
import android.net.Uri;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class c implements com.bytedance.timon.result.a<Pair<? extends Integer, ? extends Intent>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ xg7.a<Intent> f567509a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Uri f567510b;

    @Override // com.bytedance.timon.result.a
    public final void invoke(Pair<? extends Integer, ? extends Intent> r100) {
        Pair<? extends Integer, ? extends Intent> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        if (r101.getSecond() == null) goto L8;
        Intent r102 = r101.getSecond();
        Intrinsics.checkNotNull(r102);
        if (r102.filterEquals(new Intent()) == true) goto L8;
        this.f567509a.a(r101.getFirst().intValue(), r101.getSecond(), null);
        return;
    L8:
        Intent r103 = new Intent();
        r103.putExtra("android.intent.extra.STREAM", this.f567510b);
        this.f567509a.a(r101.getFirst().intValue(), r103, null);
    }

    public c(xg7.a<Intent> r100, Uri r101) {
        this.f567509a = r100;
        this.f567510b = r101;
    }
}
