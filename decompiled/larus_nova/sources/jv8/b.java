package jv8;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.google.gson.annotations.SerializedName;
import com.ss.ttvideoengine.selector.strategy.GearStrategyConsts;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0018B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0015\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0002\b\u000eJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\r2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/larus/browsertakeover/experiment/MobileBrowserScreencastSizeConfig;", "", "cloud", "Lcom/larus/browsertakeover/experiment/MobileBrowserScreencastSizeConfig$Scene;", "localPc", "<init>", "(Lcom/larus/browsertakeover/experiment/MobileBrowserScreencastSizeConfig$Scene;Lcom/larus/browsertakeover/experiment/MobileBrowserScreencastSizeConfig$Scene;)V", "getCloud", "()Lcom/larus/browsertakeover/experiment/MobileBrowserScreencastSizeConfig$Scene;", "getLocalPc", "parameters", "Lcom/larus/browsertakeover/experiment/BrowserScreencastParameters;", "isCloud", "", "parameters$impl_mainlandRelease", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "", "Scene", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("cloud")
    private final a cloud;

    @SerializedName("local_pc")
    private final a localPc;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/larus/browsertakeover/experiment/MobileBrowserScreencastSizeConfig$Scene;", "", "width", "", "height", GearStrategyConsts.EV_QUALITY, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getWidth", "()Ljava/lang/String;", "getHeight", "getQuality", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("height")
        private final String height;

        @SerializedName(GearStrategyConsts.EV_QUALITY)
        private final String quality;

        @SerializedName("width")
        private final String width;

        public a() {
            this(null, 7);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.width, r101.width) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.height, r101.height) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.quality, r101.quality) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.width;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.height;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.quality;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Scene(width=" + this.width + ", height=" + this.height + ", quality=" + this.quality + ')';
        }

        public final String a() {
            return this.height;
        }

        public final String b() {
            return this.quality;
        }

        public final String c() {
            return this.width;
        }

        public a(String r100, int r101) {
            if ((r101 & 1) == 0) goto L5;
            String r102 = "1080";
        L7:
            if ((r101 & 2) == 0) goto L9;
            String r103 = "1620";
        L11:
            if ((r101 & 4) == 0) goto L13;
            r100 = null;
        L13:
            this.width = r102;
            this.height = r103;
            this.quality = r100;
            return;
        L9:
            r103 = null;
            goto L11
        L5:
            r102 = null;
            goto L7
        }
    }

    public b() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.cloud, r101.cloud) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.localPc, r101.localPc) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        a r100 = this.cloud;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        a r104 = this.localPc;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MobileBrowserScreencastSizeConfig(cloud=" + this.cloud + ", localPc=" + this.localPc + ')';
    }

    public b(int r100) {
        a r101 = new a(BDLocationException.ERROR_INIT_LOCATION, 3);
        a r102 = new a("65", 3);
        this.cloud = r101;
        this.localPc = r102;
    }

    public final jv8.a a(boolean r110) {
        if (r110 == false) goto L4;
        a r100 = this.cloud;
    L5:
        Integer r101 = null;
        boolean r102 = true;
        if (r100 == null) goto L23;
        String r103 = r100.c();
        if (r103 == null) goto L23;
        String r104 = StringsKt.trim(r103).toString();
        if (r104 == null) goto L23;
        Integer r105 = StringsKt.toIntOrNull(r104);
        if (r105 == null) goto L23;
        int r106 = r105.intValue();
        if (480 > r106) goto L17;
        if (r106 >= 2049) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == true) goto L21;
        r105 = null;
    L21:
        if (r105 == null) goto L23;
        int r108 = r105.intValue();
    L24:
        if (r100 == null) goto L41;
        String r109 = r100.a();
        if (r109 == null) goto L41;
        String r111 = StringsKt.trim(r109).toString();
        if (r111 == null) goto L41;
        Integer r112 = StringsKt.toIntOrNull(r111);
        if (r112 == null) goto L41;
        int r113 = r112.intValue();
        if (640 > r113) goto L35;
        if (r113 >= 2049) goto L35;
        boolean r114 = true;
    L36:
        if (r114 == true) goto L39;
        r112 = null;
    L39:
        if (r112 == null) goto L41;
        int r115 = r112.intValue();
    L42:
        if (r100 == null) goto L59;
        String r116 = r100.b();
        if (r116 == null) goto L59;
        String r117 = StringsKt.trim(r116).toString();
        if (r117 == null) goto L59;
        Integer r118 = StringsKt.toIntOrNull(r117);
        if (r118 == null) goto L59;
        int r119 = r118.intValue();
        if (r119 >= 0) goto L52;
    L54:
        r102 = false;
    L55:
        if (r102 == false) goto L57;
        r101 = r118;
    L57:
        if (r101 == null) goto L59;
        int r120 = r101.intValue();
    L63:
        return new jv8.a(r108, r115, r120);
    L52:
        if (r119 >= 101) goto L54;
    L59:
        if (r110 == false) goto L61;
        r120 = 80;
        goto L63
    L61:
        r120 = 65;
    L35:
        r114 = false;
    L41:
        r115 = 1620;
    L17:
        r107 = false;
    L23:
        r108 = 1080;
        goto L24
    L4:
        r100 = this.localPc;
        goto L5
    }
}
