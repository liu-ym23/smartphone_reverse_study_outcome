package onc;

import android.os.Bundle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
public final class y implements com.suite.lark.component.navroute.api.c<Bundle> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Bundle f524499a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f524500b;

    @Override // com.suite.lark.component.navroute.api.c
    public final Bundle B() {
        return this.f524499a;
    }

    @Override // com.suite.lark.component.navroute.api.c
    public final Bundle a() {
        return this.f524499a;
    }

    @Override // com.suite.lark.component.navroute.api.c
    public final String getRoute() {
        return this.f524500b;
    }

    public y(Bundle r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        this.f524499a = r100;
        this.f524500b = "todo_assignee_display";
    }
}
