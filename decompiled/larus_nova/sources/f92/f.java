package f92;

import com.bytedance.android.livesdk.interactivity.medialink.widget.mixer.WindowsPosition;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lf92/f;", "", "", "Lf92/h;", "micConfig", "Ljava/util/List;", "getMicConfig", "()Ljava/util/List;", "f", "(Ljava/util/List;)V", "<init>", "()V", "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class f {

    @SerializedName("mic_config")
    private List<h> micConfig;

    public void e() {
    }

    public f() {
        this.micConfig = new ArrayList();
        e();
    }

    public final h a(int r100) {
        int r101 = 4;
        if (r100 > 4) goto L7;
        r101 = r100;
    L7:
        if (r100 >= 1) goto L9;
        r101 = 1;
    L9:
        List<h> r102 = this.micConfig;
        if (r102 == null) goto L14;
        h r103 = (h) CollectionsKt.getOrNull(r102, r101 - 1);
        if (r103 == null) goto L14;
        return r103;
    L14:
        return new h();
    }

    public final h b(WindowsPosition r100) {
        Intrinsics.checkNotNullParameter(r100, "windowsPosition");
        h r101 = null;
        switch(e.f475960b[r100.ordinal()]) {
            case 1: goto L14;
            case 2: goto L11;
            case 3: goto L11;
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L8;
            case 7: goto L5;
            case 8: goto L5;
            case 9: goto L5;
            case 10: goto L5;
            default: goto L17;
        };
    L5:
        List<h> r102 = this.micConfig;
        if (r102 == null) goto L17;
        r101 = (h) CollectionsKt.getOrNull(r102, 3);
        goto L17
    L8:
        List<h> r103 = this.micConfig;
        if (r103 == null) goto L17;
        r101 = (h) CollectionsKt.getOrNull(r103, 2);
        goto L17
    L11:
        List<h> r104 = this.micConfig;
        if (r104 == null) goto L17;
        r101 = (h) CollectionsKt.getOrNull(r104, 1);
        goto L17
    L14:
        List<h> r105 = this.micConfig;
        if (r105 == null) goto L17;
        r101 = (h) CollectionsKt.getOrNull(r105, 0);
    L17:
        if (r101 == null) goto L19;
        return r101;
    L19:
        return new h();
    }

    public final i c(WindowsPosition r100) {
        Intrinsics.checkNotNullParameter(r100, "position");
        i r101 = null;
        switch(e.f475959a[r100.ordinal()]) {
            case 1: goto L68;
            case 2: goto L61;
            case 3: goto L54;
            case 4: goto L47;
            case 5: goto L40;
            case 6: goto L33;
            case 7: goto L26;
            case 8: goto L19;
            case 9: goto L12;
            case 10: goto L5;
            default: goto L75;
        };
    L5:
        List<h> r102 = this.micConfig;
        if (r102 == null) goto L75;
        h r103 = (h) CollectionsKt.getOrNull(r102, 3);
        if (r103 == null) goto L75;
        List<i> r104 = r103.a();
        if (r104 == null) goto L75;
        r101 = (i) CollectionsKt.getOrNull(r104, 3);
        goto L75
    L12:
        List<h> r105 = this.micConfig;
        if (r105 == null) goto L75;
        h r106 = (h) CollectionsKt.getOrNull(r105, 3);
        if (r106 == null) goto L75;
        List<i> r107 = r106.a();
        if (r107 == null) goto L75;
        r101 = (i) CollectionsKt.getOrNull(r107, 2);
        goto L75
    L19:
        List<h> r108 = this.micConfig;
        if (r108 == null) goto L75;
        h r109 = (h) CollectionsKt.getOrNull(r108, 3);
        if (r109 == null) goto L75;
        List<i> r110 = r109.a();
        if (r110 == null) goto L75;
        r101 = (i) CollectionsKt.getOrNull(r110, 1);
        goto L75
    L26:
        List<h> r111 = this.micConfig;
        if (r111 == null) goto L75;
        h r112 = (h) CollectionsKt.getOrNull(r111, 3);
        if (r112 == null) goto L75;
        List<i> r113 = r112.a();
        if (r113 == null) goto L75;
        r101 = (i) CollectionsKt.getOrNull(r113, 0);
        goto L75
    L33:
        List<h> r114 = this.micConfig;
        if (r114 == null) goto L75;
        h r115 = (h) CollectionsKt.getOrNull(r114, 2);
        if (r115 == null) goto L75;
        List<i> r116 = r115.a();
        if (r116 == null) goto L75;
        r101 = (i) CollectionsKt.getOrNull(r116, 2);
        goto L75
    L40:
        List<h> r117 = this.micConfig;
        if (r117 == null) goto L75;
        h r118 = (h) CollectionsKt.getOrNull(r117, 2);
        if (r118 == null) goto L75;
        List<i> r119 = r118.a();
        if (r119 == null) goto L75;
        r101 = (i) CollectionsKt.getOrNull(r119, 1);
        goto L75
    L47:
        List<h> r120 = this.micConfig;
        if (r120 == null) goto L75;
        h r121 = (h) CollectionsKt.getOrNull(r120, 2);
        if (r121 == null) goto L75;
        List<i> r122 = r121.a();
        if (r122 == null) goto L75;
        r101 = (i) CollectionsKt.getOrNull(r122, 0);
        goto L75
    L54:
        List<h> r123 = this.micConfig;
        if (r123 == null) goto L75;
        h r124 = (h) CollectionsKt.getOrNull(r123, 1);
        if (r124 == null) goto L75;
        List<i> r125 = r124.a();
        if (r125 == null) goto L75;
        r101 = (i) CollectionsKt.getOrNull(r125, 1);
        goto L75
    L61:
        List<h> r126 = this.micConfig;
        if (r126 == null) goto L75;
        h r127 = (h) CollectionsKt.getOrNull(r126, 1);
        if (r127 == null) goto L75;
        List<i> r128 = r127.a();
        if (r128 == null) goto L75;
        r101 = (i) CollectionsKt.getOrNull(r128, 0);
        goto L75
    L68:
        List<h> r129 = this.micConfig;
        if (r129 == null) goto L75;
        h r130 = (h) CollectionsKt.getOrNull(r129, 0);
        if (r130 == null) goto L75;
        List<i> r131 = r130.a();
        if (r131 == null) goto L75;
        r101 = (i) CollectionsKt.getOrNull(r131, 0);
    L75:
        if (r101 == null) goto L77;
        return r101;
    L77:
        return new i();
    }

    public final double d(int r100) {
        return Double.valueOf(a(RangesKt.coerceAtLeast(r100, 2)).b()).doubleValue();
    }

    public final void f(List<h> r100) {
        this.micConfig = r100;
    }
}
