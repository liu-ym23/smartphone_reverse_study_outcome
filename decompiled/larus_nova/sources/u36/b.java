package u36;

import android.os.Bundle;
import com.bytedance.ies.bullet.service.sdk.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f548605a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f548606b;

    @Override // t36.e
    public final String getName() {
        return this.f548606b;
    }

    public b(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "bundle");
        this.f548605a = r100;
        this.f548606b = "Bundle";
    }

    @Override // t36.e
    public final boolean b(com.bytedance.ies.bullet.service.sdk.d r100) {
        Intrinsics.checkNotNullParameter(r100, "schemaData");
        r100.e(this.f548605a);
        return true;
    }
}
