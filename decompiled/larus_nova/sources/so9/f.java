package so9;

import com.larus.office.OfficeInputParam;
import com.larus.office.plugins.inputv2.coordinator.runtime.integration.i;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.larus.office.plugins.inputv2.adapter.g f542800a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<OfficeInputParam> f542801b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.larus.office.plugins.inputv2.coordinator.document.c f542802c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function1<String, Unit> f542803d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f542800a, r101.f542800a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f542801b, r101.f542801b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f542802c, r101.f542802c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f542803d, r101.f542803d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        return (((((this.f542800a.hashCode() * 31) + this.f542801b.hashCode()) * 31) + this.f542802c.hashCode()) * 31) + this.f542803d.hashCode();
    }

    public final String toString() {
        return "OfficeChatIntegrationPlatformComponentParams(adapter=" + this.f542800a + ", inputParamsProvider=" + this.f542801b + ", answerStateCoordinator=" + this.f542802c + ", onExpandRequired=" + this.f542803d + ')';
    }

    public f(com.larus.office.plugins.inputv2.adapter.g r100, Function0 r101, com.larus.office.plugins.inputv2.coordinator.document.c r102, i r103) {
        Intrinsics.checkNotNullParameter(r100, "adapter");
        Intrinsics.checkNotNullParameter(r101, "inputParamsProvider");
        Intrinsics.checkNotNullParameter(r102, "answerStateCoordinator");
        Intrinsics.checkNotNullParameter(r103, "onExpandRequired");
        this.f542800a = r100;
        this.f542801b = r101;
        this.f542802c = r102;
        this.f542803d = r103;
    }
}
