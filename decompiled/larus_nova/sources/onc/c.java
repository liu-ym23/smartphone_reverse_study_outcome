package onc;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class c implements com.suite.lark.component.navroute.api.c<Bundle> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f524447a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f524448b;

    @Override // com.suite.lark.component.navroute.api.c
    public final Bundle B() {
        return this.f524447a;
    }

    @Override // com.suite.lark.component.navroute.api.c
    public final Bundle a() {
        return this.f524447a;
    }

    @Override // com.suite.lark.component.navroute.api.c
    public final String getRoute() {
        return this.f524448b;
    }

    public c(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        this.f524447a = r100;
        this.f524448b = "ccm_fold_list";
    }
}
