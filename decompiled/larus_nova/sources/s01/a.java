package s01;

import ca0.s;
import com.bytedance.android.livesdk.gift.platform.business.sendGift.f;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final g50.b f540011a;

    public a(g50.b r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f540011a = r100;
    }

    @Override // ca0.s
    public final void j(f r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        this.f540011a.a(new g50.a(r100.f130109a, r100.f130111c));
    }
}
