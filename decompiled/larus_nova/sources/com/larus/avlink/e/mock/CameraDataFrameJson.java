package com.larus.avlink.e.mock;

import com.bytedance.sdk.account.platform.base.OnekeyLoginConstants;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001Bs\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010!\u001a\u0004\u0018\u00010\nHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010#\u001a\u0004\u0018\u00010\nHÆ\u0003Jz\u0010$\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010%J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u0003HÖ\u0001J\t\u0010*\u001a\u00020\nHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0013\u0010\u0010R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0015\u0010\u0010R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0016\u0010\u0010R\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0019\u0010\u0010R\u0018\u0010\f\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018¨\u0006+"}, d2 = {"Lcom/larus/avlink/e/mock/CameraDataFrameJson;", "", "stage", "", "scene", "id", "type", OnekeyLoginConstants.CU_KEY_SEQ, "count", "dataBase64", "", "assId", "assDataBase64", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "getStage", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getScene", "getId", "getType", "getSeq", "getCount", "getDataBase64", "()Ljava/lang/String;", "getAssId", "getAssDataBase64", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)Lcom/larus/avlink/e/mock/CameraDataFrameJson;", "equals", "", "other", "hashCode", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraDataFrameJson {
    public static final int $stable = 0;

    @SerializedName("assDataBase64")
    private final String assDataBase64;

    @SerializedName("assId")
    private final Integer assId;

    @SerializedName("count")
    private final Integer count;

    @SerializedName("dataBase64")
    private final String dataBase64;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final Integer f291797id;

    @SerializedName("scene")
    private final Integer scene;

    @SerializedName(OnekeyLoginConstants.CU_KEY_SEQ)
    private final Integer seq;

    @SerializedName("stage")
    private final Integer stage;

    @SerializedName("type")
    private final Integer type;

    public CameraDataFrameJson() {
        this(null, null, null, null, null, null, null, null, null, 511, null);
    }

    public static /* synthetic */ CameraDataFrameJson copy$default(CameraDataFrameJson r110, Integer r111, Integer r112, Integer r113, Integer r114, Integer r115, Integer r116, String r117, Integer r118, String r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        Integer r100 = r110.stage;
    L7:
        if ((r210 & 2) == 0) goto L9;
        Integer r101 = r110.scene;
    L11:
        if ((r210 & 4) == 0) goto L13;
        Integer r102 = r110.f291797id;
    L15:
        if ((r210 & 8) == 0) goto L17;
        Integer r103 = r110.type;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Integer r104 = r110.seq;
    L23:
        if ((r210 & 32) == 0) goto L25;
        Integer r105 = r110.count;
    L27:
        if ((r210 & 64) == 0) goto L29;
        String r106 = r110.dataBase64;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Integer r107 = r110.assId;
    L35:
        if ((r210 & 256) == 0) goto L37;
        String r108 = r110.assDataBase64;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final Integer component1() {
        return this.stage;
    }

    public final Integer component2() {
        return this.scene;
    }

    public final Integer component3() {
        return this.f291797id;
    }

    public final Integer component4() {
        return this.type;
    }

    public final Integer component5() {
        return this.seq;
    }

    public final Integer component6() {
        return this.count;
    }

    public final String component7() {
        return this.dataBase64;
    }

    public final Integer component8() {
        return this.assId;
    }

    public final String component9() {
        return this.assDataBase64;
    }

    public final CameraDataFrameJson copy(Integer r110, Integer r111, Integer r112, Integer r113, Integer r114, Integer r115, String r116, Integer r117, String r210) {
        return new CameraDataFrameJson(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CameraDataFrameJson) == true) goto L8;
        return false;
    L8:
        CameraDataFrameJson r101 = (CameraDataFrameJson) r100;
        if (Intrinsics.areEqual(this.stage, r101.stage) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f291797id, r101.f291797id) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.type, r101.type) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.seq, r101.seq) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.count, r101.count) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.dataBase64, r101.dataBase64) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.assId, r101.assId) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.assDataBase64, r101.assDataBase64) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.stage;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.scene;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.f291797id;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Integer r110 = this.type;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.seq;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        Integer r116 = this.count;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        String r119 = this.dataBase64;
        if (r119 != null) goto L29;
        int r120 = 0;
    L30:
        int r121 = (r118 + r120) * 31;
        Integer r122 = this.assId;
        if (r122 != null) goto L33;
        int r123 = 0;
    L34:
        int r124 = (r121 + r123) * 31;
        String r125 = this.assDataBase64;
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

    public String toString() {
        return "CameraDataFrameJson(stage=" + this.stage + ", scene=" + this.scene + ", id=" + this.f291797id + ", type=" + this.type + ", seq=" + this.seq + ", count=" + this.count + ", dataBase64=" + this.dataBase64 + ", assId=" + this.assId + ", assDataBase64=" + this.assDataBase64 + ')';
    }

    public final String getAssDataBase64() {
        return this.assDataBase64;
    }

    public final Integer getAssId() {
        return this.assId;
    }

    public final Integer getCount() {
        return this.count;
    }

    public final String getDataBase64() {
        return this.dataBase64;
    }

    public final Integer getId() {
        return this.f291797id;
    }

    public final Integer getScene() {
        return this.scene;
    }

    public final Integer getSeq() {
        return this.seq;
    }

    public final Integer getStage() {
        return this.stage;
    }

    public final Integer getType() {
        return this.type;
    }

    public CameraDataFrameJson(Integer r100, Integer r101, Integer r102, Integer r103, Integer r104, Integer r105, String r106, Integer r107, String r108) {
        this.stage = r100;
        this.scene = r101;
        this.f291797id = r102;
        this.type = r103;
        this.seq = r104;
        this.count = r105;
        this.dataBase64 = r106;
        this.assId = r107;
        this.assDataBase64 = r108;
    }

    public /* synthetic */ CameraDataFrameJson(Integer r110, Integer r111, Integer r112, Integer r113, Integer r114, Integer r115, String r116, Integer r117, String r210, int r211, DefaultConstructorMarker r212) {
        Integer r100 = 0;
        if ((r211 & 1) == 0) goto L5;
        Integer r101 = r100;
    L7:
        if ((r211 & 2) == 0) goto L9;
        Integer r102 = r100;
    L11:
        if ((r211 & 4) == 0) goto L13;
        Integer r103 = r100;
    L15:
        if ((r211 & 8) == 0) goto L17;
        Integer r104 = r100;
    L19:
        if ((r211 & 16) == 0) goto L21;
        Integer r105 = r100;
    L23:
        if ((r211 & 32) == 0) goto L25;
        Integer r106 = r100;
    L26:
        String r107 = null;
        if ((r211 & 64) == 0) goto L29;
        String r108 = null;
    L31:
        if ((r211 & 128) != 0) goto L35;
        r100 = r117;
    L35:
        if ((r211 & 256) != 0) goto L38;
        r107 = r210;
    L38:
        this(r101, r102, r103, r104, r105, r106, r108, r100, r107);
        return;
    L29:
        r108 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L26
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
}
