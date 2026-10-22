package d59;

import com.bytedance.dora.device.DoraDevice;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final z49.b f467075a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public List<? extends DoraDevice> f467076b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f467077c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f467078d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f467075a, r101.f467075a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f467076b, r101.f467076b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f467077c, r101.f467077c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f467078d, r101.f467078d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        z49.b r100 = this.f467075a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<? extends DoraDevice> r104 = this.f467076b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.f467077c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f467078d;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "CardContext(device=" + this.f467075a + ", historyDeviceList=" + this.f467076b + ", starling=" + this.f467077c + ", prePage=" + this.f467078d + ')';
    }

    public static b a(b r100, List r101) {
        return new b(r100.f467075a, r101, r100.f467077c, r100.f467078d);
    }

    public b(z49.b r100, List<? extends DoraDevice> r101, Map<String, String> r102, String r103) {
        this.f467075a = r100;
        this.f467076b = r101;
        this.f467077c = r102;
        this.f467078d = r103;
    }
}
