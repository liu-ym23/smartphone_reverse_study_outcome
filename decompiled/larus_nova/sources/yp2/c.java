package yp2;

import com.bytedance.android.livesdkapi.depend.model.Sticker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes11.dex */
public final class c implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Sticker f568698a;

    @Override // yp2.b
    public final String a() {
        return this.f568698a.getStickerPanel();
    }

    public final String b() {
        return this.f568698a.getUnzipPath();
    }

    @Override // yp2.b
    public final long getId() {
        return this.f568698a.getId();
    }

    public c(Sticker r100) {
        Intrinsics.checkNotNullParameter(r100, "delegate");
        this.f568698a = r100;
    }
}
