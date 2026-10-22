package nd6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public class e implements a<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f518793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f518794b;

    @Override // nd6.a
    public final Boolean getDefaultValue() {
        return Boolean.valueOf(this.f518794b);
    }

    @Override // nd6.a
    public final String getKey() {
        return this.f518793a;
    }

    public e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        this.f518793a = r100;
        this.f518794b = true;
    }
}
