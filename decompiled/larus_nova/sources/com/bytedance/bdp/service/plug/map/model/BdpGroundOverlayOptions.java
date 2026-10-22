package com.bytedance.bdp.service.plug.map.model;

import android.graphics.Bitmap;
import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001:\u0002 !BE\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0002\u0010\u0010J\u000e\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016¨\u0006\""}, d2 = {"Lcom/bytedance/bdp/service/plug/map/model/BdpGroundOverlayOptions;", "", "id", "", "src", "Landroid/graphics/Bitmap;", "bounds", "Lcom/bytedance/bdp/service/plug/map/model/BdpLatLngBounds;", "visible", "", "zIndex", "", GXTemplateKey.STYLE_OPACITY, "status", "", "Lcom/bytedance/bdp/service/plug/map/model/BdpGroundOverlayOptions$Param;", "(Ljava/lang/String;Landroid/graphics/Bitmap;Lcom/bytedance/bdp/service/plug/map/model/BdpLatLngBounds;ZDDLjava/util/Set;)V", "getBounds", "()Lcom/bytedance/bdp/service/plug/map/model/BdpLatLngBounds;", "getId", "()Ljava/lang/String;", "getOpacity", "()D", "getSrc", "()Landroid/graphics/Bitmap;", "getStatus", "()Ljava/util/Set;", "getVisible", "()Z", "getZIndex", "isUpdate", "param", "Builder", "Param", "tma-map-api_release"}, k = 1, mv = {1, 1, 18})
public final class BdpGroundOverlayOptions {
    private final BdpLatLngBounds bounds;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f201546id;
    private final double opacity;

    /* JADX INFO: renamed from: src, reason: collision with root package name */
    private final Bitmap f201547src;
    private final Set<Param> status;
    private final boolean visible;
    private final double zIndex;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b¢\u0006\u0002\u0010\rJ\u000e\u0010\u0006\u001a\u00020\u00002\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010(\u001a\u00020)J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003J\t\u0010,\u001a\u00020\u0007HÆ\u0003J\t\u0010-\u001a\u00020\tHÆ\u0003J\t\u0010.\u001a\u00020\u000bHÆ\u0003J\t\u0010/\u001a\u00020\u000bHÆ\u0003JE\u00100\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000bHÆ\u0001J\u0013\u00101\u001a\u00020\t2\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\u000e\u0010\u0002\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\t\u00105\u001a\u00020\u0003HÖ\u0001J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001e\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020 0\u001fj\b\u0012\u0004\u0012\u00020 `!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0017\"\u0004\b'\u0010\u0019¨\u00066"}, d2 = {"Lcom/bytedance/bdp/service/plug/map/model/BdpGroundOverlayOptions$Builder;", "", "id", "", "src", "Landroid/graphics/Bitmap;", "bounds", "Lcom/bytedance/bdp/service/plug/map/model/BdpLatLngBounds;", "visible", "", "zIndex", "", GXTemplateKey.STYLE_OPACITY, "(Ljava/lang/String;Landroid/graphics/Bitmap;Lcom/bytedance/bdp/service/plug/map/model/BdpLatLngBounds;ZDD)V", "getBounds", "()Lcom/bytedance/bdp/service/plug/map/model/BdpLatLngBounds;", "setBounds", "(Lcom/bytedance/bdp/service/plug/map/model/BdpLatLngBounds;)V", "getId", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "getOpacity", "()D", "setOpacity", "(D)V", "getSrc", "()Landroid/graphics/Bitmap;", "setSrc", "(Landroid/graphics/Bitmap;)V", "status", "Ljava/util/HashSet;", "Lcom/bytedance/bdp/service/plug/map/model/BdpGroundOverlayOptions$Param;", "Lkotlin/collections/HashSet;", "getVisible", "()Z", "setVisible", "(Z)V", "getZIndex", "setZIndex", "build", "Lcom/bytedance/bdp/service/plug/map/model/BdpGroundOverlayOptions;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "tma-map-api_release"}, k = 1, mv = {1, 1, 18})
    public static final class Builder {
        private BdpLatLngBounds bounds;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private String f201548id;
        private double opacity;

        /* JADX INFO: renamed from: src, reason: collision with root package name */
        private Bitmap f201549src;
        private final HashSet<Param> status;
        private boolean visible;
        private double zIndex;

        public static /* synthetic */ Builder copy$default(Builder r100, String r110, Bitmap r111, BdpLatLngBounds r112, boolean r113, double r114, double r115, int r116, Object r117) {
            if ((r116 & 1) == 0) goto L5;
            String r101 = r100.f201548id;
        L7:
            if ((r116 & 2) == 0) goto L9;
            Bitmap r102 = r100.f201549src;
        L11:
            if ((r116 & 4) == 0) goto L13;
            BdpLatLngBounds r103 = r100.bounds;
        L15:
            if ((r116 & 8) == 0) goto L17;
            boolean r104 = r100.visible;
        L19:
            if ((r116 & 16) == 0) goto L21;
            double r105 = r100.zIndex;
        L23:
            if ((r116 & 32) == 0) goto L25;
            double r106 = r100.opacity;
        L27:
            return r100.copy(r101, r102, r103, r104, r105, r106);
        L25:
            r106 = r115;
            goto L27
        L21:
            r105 = r114;
            goto L23
        L17:
            r104 = r113;
            goto L19
        L13:
            r103 = r112;
            goto L15
        L9:
            r102 = r111;
            goto L11
        L5:
            r101 = r110;
            goto L7
        }

        public final String component1() {
            return this.f201548id;
        }

        public final Bitmap component2() {
            return this.f201549src;
        }

        public final BdpLatLngBounds component3() {
            return this.bounds;
        }

        public final boolean component4() {
            return this.visible;
        }

        public final double component5() {
            return this.zIndex;
        }

        public final double component6() {
            return this.opacity;
        }

        public final Builder copy(String r110, Bitmap r111, BdpLatLngBounds r112, boolean r113, double r114, double r115) {
            return new Builder(r110, r111, r112, r113, r114, r115);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof Builder) == false) goto L18;
            Builder r101 = (Builder) r100;
            if (Intrinsics.areEqual(this.f201548id, r101.f201548id) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f201549src, r101.f201549src) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.bounds, r101.bounds) == true) goto L12;
            return false;
        L12:
            if (this.visible == r101.visible) goto L14;
            return false;
        L14:
            if (Double.compare(this.zIndex, r101.zIndex) == 0) goto L16;
            return false;
        L16:
            if (Double.compare(this.opacity, r101.opacity) == 0) goto L28;
            return false;
        L28:
            return true;
        L18:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v12 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        public int hashCode() {
            String r100 = this.f201548id;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Bitmap r104 = this.f201549src;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            BdpLatLngBounds r107 = this.bounds;
            if (r107 == null) goto L13;
            r101 = r107.hashCode();
        L13:
            int r108 = (r106 + r101) * 31;
            boolean r109 = this.visible;
            ?? r110 = r109;
            if (r109 == false) goto L16;
            r110 = 1;
        L16:
            int r111 = (r108 + r110) * 31;
            long r112 = Double.doubleToLongBits(this.zIndex);
            int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
            long r114 = Double.doubleToLongBits(this.opacity);
            return r113 + ((int) (r114 ^ (r114 >>> 32)));
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public String toString() {
            return "Builder(id=" + this.f201548id + ", src=" + this.f201549src + ", bounds=" + this.bounds + ", visible=" + this.visible + ", zIndex=" + this.zIndex + ", opacity=" + this.opacity + ")";
        }

        public final BdpGroundOverlayOptions build() {
            return new BdpGroundOverlayOptions(this.f201548id, this.f201549src, this.bounds, this.visible, this.zIndex, this.opacity, this.status, null);
        }

        public final BdpLatLngBounds getBounds() {
            return this.bounds;
        }

        public final String getId() {
            return this.f201548id;
        }

        public final double getOpacity() {
            return this.opacity;
        }

        public final Bitmap getSrc() {
            return this.f201549src;
        }

        public final boolean getVisible() {
            return this.visible;
        }

        public final double getZIndex() {
            return this.zIndex;
        }

        public final Builder bounds(BdpLatLngBounds r100) {
            this.bounds = r100;
            return this;
        }

        public final Builder id(String r100) {
            this.f201548id = r100;
            return this;
        }

        public final Builder opacity(double r100) {
            this.opacity = r100;
            this.status.add(Param.OPACITY);
            return this;
        }

        public final void setBounds(BdpLatLngBounds r100) {
            this.bounds = r100;
        }

        public final void setId(String r100) {
            this.f201548id = r100;
        }

        public final void setOpacity(double r100) {
            this.opacity = r100;
        }

        public final void setSrc(Bitmap r100) {
            this.f201549src = r100;
        }

        public final void setVisible(boolean r100) {
            this.visible = r100;
        }

        public final void setZIndex(double r100) {
            this.zIndex = r100;
        }

        public final Builder src(Bitmap r100) {
            this.f201549src = r100;
            return this;
        }

        public final Builder visible(boolean r100) {
            this.visible = r100;
            this.status.add(Param.VISIBLE);
            return this;
        }

        public final Builder zIndex(double r100) {
            this.zIndex = r100;
            this.status.add(Param.Z_INDEX);
            return this;
        }

        public Builder(String r100, Bitmap r101, BdpLatLngBounds r102, boolean r103, double r104, double r105) {
            this.f201548id = r100;
            this.f201549src = r101;
            this.bounds = r102;
            this.visible = r103;
            this.zIndex = r104;
            this.opacity = r105;
            this.status = new HashSet();
        }

        public /* synthetic */ Builder(String r110, Bitmap r111, BdpLatLngBounds r112, boolean r113, double r114, double r115, int r116, DefaultConstructorMarker r210) {
            if ((r116 & 8) == 0) goto L5;
            boolean r100 = true;
        L7:
            if ((r116 & 16) == 0) goto L9;
            double r101 = 1.0d;
        L11:
            if ((r116 & 32) == 0) goto L13;
            double r102 = 1.0d;
        L14:
            this(r110, r111, r112, r100, r101, r102);
            return;
        L13:
            r102 = r115;
            goto L14
        L9:
            r101 = r114;
            goto L11
        L5:
            r100 = r113;
            goto L7
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/bytedance/bdp/service/plug/map/model/BdpGroundOverlayOptions$Param;", "", "(Ljava/lang/String;I)V", "VISIBLE", "Z_INDEX", "OPACITY", "tma-map-api_release"}, k = 1, mv = {1, 1, 18})
    public static final enum Param extends Enum<Param> {
        private static final /* synthetic */ Param[] $VALUES = null;
        public static final Param OPACITY = null;
        public static final Param VISIBLE = null;
        public static final Param Z_INDEX = null;

        static {
            Param r100 = new Param("VISIBLE", 0);
            VISIBLE = r100;
            Param r101 = new Param("Z_INDEX", 1);
            Z_INDEX = r101;
            Param r102 = new Param("OPACITY", 2);
            OPACITY = r102;
            $VALUES = new Param[]{r100, r101, r102};
        }

        public static Param valueOf(String r100) {
            return (Param) a.a(Param.class, r100);
        }

        public static Param[] values() {
            return (Param[]) $VALUES.clone();
        }

        private Param(String r100, int r101) {
            super(r100, r101);
        }
    }

    public final BdpLatLngBounds getBounds() {
        return this.bounds;
    }

    public final String getId() {
        return this.f201546id;
    }

    public final double getOpacity() {
        return this.opacity;
    }

    public final Bitmap getSrc() {
        return this.f201547src;
    }

    public final Set<Param> getStatus() {
        return this.status;
    }

    public final boolean getVisible() {
        return this.visible;
    }

    public final double getZIndex() {
        return this.zIndex;
    }

    public final boolean isUpdate(Param r100) {
        return this.status.contains(r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private BdpGroundOverlayOptions(String r100, Bitmap r101, BdpLatLngBounds r102, boolean r103, double r104, double r105, Set<? extends Param> r106) {
        this.f201546id = r100;
        this.f201547src = r101;
        this.bounds = r102;
        this.visible = r103;
        this.zIndex = r104;
        this.opacity = r105;
        this.status = r106;
    }

    public /* synthetic */ BdpGroundOverlayOptions(String r100, Bitmap r101, BdpLatLngBounds r102, boolean r103, double r104, double r105, Set r106, DefaultConstructorMarker r110) {
        this(r100, r101, r102, r103, r104, r105, r106);
    }
}
