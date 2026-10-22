package dx6;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u001c\u0010+\u001a\u0004\u0018\u00010*8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.¨\u0006/"}, d2 = {"Ldx6/j;", "", "", "voType", "Ljava/lang/Integer;", RXScreenCaptureService.KEY_INDEX, "()Ljava/lang/Integer;", "Ldx6/i;", "type1VO", "Ldx6/i;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ldx6/i;", "Ldx6/l;", "type2VO", "Ldx6/l;", "b", "()Ldx6/l;", "Ldx6/n;", "type3VO", "Ldx6/n;", "c", "()Ldx6/n;", "Ldx6/h;", "type4VO", "Ldx6/h;", "d", "()Ldx6/h;", "Ldx6/b;", "type5VO", "Ldx6/b;", "e", "()Ldx6/b;", "Ldx6/o;", "type6VO", "Ldx6/o;", "f", "()Ldx6/o;", "Ldx6/m;", "type7VO", "Ldx6/m;", ce.f26391f, "()Ldx6/m;", "Ldx6/f;", "type8VO", "Ldx6/f;", "h", "()Ldx6/f;", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("type1VO")
    private final i type1VO;

    @SerializedName("type2VO")
    private final l type2VO;

    @SerializedName("type3VO")
    private final n type3VO;

    @SerializedName("type4VO")
    private final h type4VO;

    @SerializedName("type5VO")
    private final b type5VO;

    @SerializedName("type6VO")
    private final o type6VO;

    @SerializedName("type7VO")
    private final m type7VO;

    @SerializedName("type8VO")
    private final f type8VO;

    @SerializedName("voType")
    private final Integer voType;

    public j() {
        this.voType = 0;
        this.type1VO = null;
        this.type2VO = null;
        this.type3VO = null;
        this.type4VO = null;
        this.type5VO = null;
        this.type6VO = null;
        this.type7VO = null;
        this.type8VO = null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.voType, r101.voType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.type1VO, r101.type1VO) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.type2VO, r101.type2VO) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.type3VO, r101.type3VO) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.type4VO, r101.type4VO) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.type5VO, r101.type5VO) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.type6VO, r101.type6VO) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.type7VO, r101.type7VO) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.type8VO, r101.type8VO) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        Integer r100 = this.voType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        i r104 = this.type1VO;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        l r107 = this.type2VO;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        n r110 = this.type3VO;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        h r113 = this.type4VO;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        b r116 = this.type5VO;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        o r119 = this.type6VO;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        m r122 = this.type7VO;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        f r125 = this.type8VO;
        if (r125 == null) goto L39;
        r101 = r125.hashCode();
    L39:
        return r124 + r101;
    L33:
        r123 = r122.hashCode();
        goto L34
    L29:
        r120 = r119.hashCode();
        goto L30
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
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
        return "SingleCommonContentData(voType=" + this.voType + ", type1VO=" + this.type1VO + ", type2VO=" + this.type2VO + ", type3VO=" + this.type3VO + ", type4VO=" + this.type4VO + ", type5VO=" + this.type5VO + ", type6VO=" + this.type6VO + ", type7VO=" + this.type7VO + ", type8VO=" + this.type8VO + ')';
    }

    public final i a() {
        return this.type1VO;
    }

    public final l b() {
        return this.type2VO;
    }

    public final n c() {
        return this.type3VO;
    }

    public final h d() {
        return this.type4VO;
    }

    public final b e() {
        return this.type5VO;
    }

    public final o f() {
        return this.type6VO;
    }

    public final m g() {
        return this.type7VO;
    }

    public final f h() {
        return this.type8VO;
    }

    public final Integer i() {
        return this.voType;
    }
}
