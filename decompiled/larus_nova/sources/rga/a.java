package rga;

import com.obric.assistant.spi.miniapp.ObricIntentWidgetUpdateMode;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ObricIntentWidgetUpdateMode f537738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f537739b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Integer f537740c;

    public a() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (this.f537738a == r101.f537738a) goto L12;
        return false;
    L12:
        if (this.f537739b == r101.f537739b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f537740c, r101.f537740c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f537738a.hashCode() * 31;
        if (this.f537739b == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = (r100 + r101) * 31;
        Integer r103 = this.f537740c;
        if (r103 != null) goto L9;
        int r104 = 0;
    L11:
        return r102 + r104;
    L9:
        r104 = r103.hashCode();
        goto L11
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "ObricIntentWidgetPolicy(updateMode=" + this.f537738a + ", requiresHostSurfaceCompatibility=" + this.f537739b + ", minimumHeightDp=" + this.f537740c + ')';
    }

    public /* synthetic */ a(int r100) {
        this(ObricIntentWidgetUpdateMode.DEFAULT, false, null);
    }

    public a(ObricIntentWidgetUpdateMode r100, boolean r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, "updateMode");
        this.f537738a = r100;
        this.f537739b = r101;
        this.f537740c = r102;
    }
}
