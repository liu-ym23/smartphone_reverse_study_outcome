package ob2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements ek6.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f522599a;

    @Override // ek6.b
    public final void a() {
    }

    public final String toString() {
        return "LiveLottieResource[" + this.f522599a + ']';
    }

    public e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "assetFilePath");
        this.f522599a = r100;
    }
}
