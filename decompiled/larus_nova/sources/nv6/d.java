package nv6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0005\u001a\u0004\b\n\u0010\u0007R\"\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0005\u001a\u0004\b\f\u0010\u0007R\"\u0010\r\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lnv6/d;", "", "", "", "borderColors", "Ljava/util/List;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/List;", "", "borderLocations", "getBorderLocations", "colors", "b", "locations", "c", "url", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("border_colors")
    private final List<String> borderColors;

    @SerializedName("border_locations")
    private final List<Float> borderLocations;

    @SerializedName("colors")
    private final List<String> colors;

    @SerializedName("locations")
    private final List<Float> locations;

    @SerializedName("url")
    private final String url;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.borderColors, r101.borderColors) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.borderLocations, r101.borderLocations) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.colors, r101.colors) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.locations, r101.locations) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.borderColors;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<Float> r104 = this.borderLocations;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.colors;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        List<Float> r110 = this.locations;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.url;
        if (r113 == null) goto L23;
        r101 = r113.hashCode();
    L23:
        return r112 + r101;
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "AtmosphereBackground(borderColors=" + this.borderColors + ", borderLocations=" + this.borderLocations + ", colors=" + this.colors + ", locations=" + this.locations + ", url=" + this.url + ')';
    }

    public d() {
        this.borderColors = null;
        this.borderLocations = null;
        this.colors = null;
        this.locations = null;
        this.url = "";
    }

    public final List<String> a() {
        return this.borderColors;
    }

    public final List<String> b() {
        return this.colors;
    }

    public final List<Float> c() {
        return this.locations;
    }

    public final String d() {
        return this.url;
    }
}
