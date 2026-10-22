package com.larus.camera.api.params;

import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u001c\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0086\b\u0018\u0000 .2\u00020\u0001:\u0001.Bc\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\t\u0010 \u001a\u00020\u0005HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0005HÆ\u0003J\u0010\u0010#\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\u0010\u0010$\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010%\u001a\u00020\fHÆ\u0003J\u0015\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000eHÆ\u0003Jn\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000b\u001a\u00020\f2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000eHÆ\u0001¢\u0006\u0002\u0010(J\u0013\u0010)\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010+HÖ\u0003J\t\u0010,\u001a\u00020\tHÖ\u0001J\t\u0010-\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00050\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e¨\u0006/"}, d2 = {"Lcom/larus/camera/api/params/CameraResultOutOpenParams;", "Ljava/io/Serializable;", "imgPath", "", "supportMultiImages", "", "markTipsRest", "disableCaptureDetect", "enterAnim", "", "exitAnim", "openPageTriggerTimeMs", "", "intentBooleanExtras", "", "<init>", "(Ljava/lang/String;ZZZLjava/lang/Integer;Ljava/lang/Integer;JLjava/util/Map;)V", "getImgPath", "()Ljava/lang/String;", "getSupportMultiImages", "()Z", "getMarkTipsRest", "getDisableCaptureDetect", "getEnterAnim", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExitAnim", "getOpenPageTriggerTimeMs", "()J", "getIntentBooleanExtras", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(Ljava/lang/String;ZZZLjava/lang/Integer;Ljava/lang/Integer;JLjava/util/Map;)Lcom/larus/camera/api/params/CameraResultOutOpenParams;", "equals", "other", "", "hashCode", "toString", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CameraResultOutOpenParams implements Serializable {
    public static final a Companion = null;
    private static final long serialVersionUID = 1;
    private final boolean disableCaptureDetect;
    private final Integer enterAnim;
    private final Integer exitAnim;
    private final String imgPath;
    private final Map<String, Boolean> intentBooleanExtras;
    private final boolean markTipsRest;
    private final long openPageTriggerTimeMs;
    private final boolean supportMultiImages;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CameraResultOutOpenParams copy$default(CameraResultOutOpenParams r110, String r111, boolean r112, boolean r113, boolean r114, Integer r115, Integer r116, long r117, Map r118, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        String r100 = r110.imgPath;
    L7:
        if ((r210 & 2) == 0) goto L9;
        boolean r101 = r110.supportMultiImages;
    L11:
        if ((r210 & 4) == 0) goto L13;
        boolean r102 = r110.markTipsRest;
    L15:
        if ((r210 & 8) == 0) goto L17;
        boolean r103 = r110.disableCaptureDetect;
    L19:
        if ((r210 & 16) == 0) goto L21;
        Integer r104 = r110.enterAnim;
    L23:
        if ((r210 & 32) == 0) goto L25;
        Integer r105 = r110.exitAnim;
    L27:
        if ((r210 & 64) == 0) goto L29;
        long r106 = r110.openPageTriggerTimeMs;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Map r107 = r110.intentBooleanExtras;
    L35:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107);
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

    public final String component1() {
        return this.imgPath;
    }

    public final boolean component2() {
        return this.supportMultiImages;
    }

    public final boolean component3() {
        return this.markTipsRest;
    }

    public final boolean component4() {
        return this.disableCaptureDetect;
    }

    public final Integer component5() {
        return this.enterAnim;
    }

    public final Integer component6() {
        return this.exitAnim;
    }

    public final long component7() {
        return this.openPageTriggerTimeMs;
    }

    public final Map<String, Boolean> component8() {
        return this.intentBooleanExtras;
    }

    public final CameraResultOutOpenParams copy(String r110, boolean r111, boolean r112, boolean r113, Integer r114, Integer r115, long r116, Map<String, Boolean> r210) {
        Intrinsics.checkNotNullParameter(r110, "imgPath");
        Intrinsics.checkNotNullParameter(r210, "intentBooleanExtras");
        return new CameraResultOutOpenParams(r110, r111, r112, r113, r114, r115, r116, r210);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CameraResultOutOpenParams) == true) goto L8;
        return false;
    L8:
        CameraResultOutOpenParams r101 = (CameraResultOutOpenParams) r100;
        if (Intrinsics.areEqual(this.imgPath, r101.imgPath) == true) goto L12;
        return false;
    L12:
        if (this.supportMultiImages == r101.supportMultiImages) goto L15;
        return false;
    L15:
        if (this.markTipsRest == r101.markTipsRest) goto L18;
        return false;
    L18:
        if (this.disableCaptureDetect == r101.disableCaptureDetect) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.enterAnim, r101.enterAnim) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.exitAnim, r101.exitAnim) == true) goto L27;
        return false;
    L27:
        if (this.openPageTriggerTimeMs == r101.openPageTriggerTimeMs) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.intentBooleanExtras, r101.intentBooleanExtras) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        int r100 = this.imgPath.hashCode() * 31;
        int r101 = 1231;
        if (this.supportMultiImages == false) goto L5;
        int r102 = 1231;
    L6:
        int r103 = (r100 + r102) * 31;
        if (this.markTipsRest == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        if (this.disableCaptureDetect == true) goto L14;
        r101 = 1237;
    L14:
        int r106 = (r105 + r101) * 31;
        Integer r107 = this.enterAnim;
        int r108 = 0;
        if (r107 != null) goto L17;
        int r109 = 0;
    L18:
        int r110 = (r106 + r109) * 31;
        Integer r111 = this.exitAnim;
        if (r111 == null) goto L22;
        r108 = r111.hashCode();
    L22:
        long r112 = this.openPageTriggerTimeMs;
        return ((((r110 + r108) * 31) + ((int) (r112 ^ (r112 >>> 32)))) * 31) + this.intentBooleanExtras.hashCode();
    L17:
        r109 = r107.hashCode();
        goto L18
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = 1237;
        goto L6
    }

    public String toString() {
        return "CameraResultOutOpenParams(imgPath=" + this.imgPath + ", supportMultiImages=" + this.supportMultiImages + ", markTipsRest=" + this.markTipsRest + ", disableCaptureDetect=" + this.disableCaptureDetect + ", enterAnim=" + this.enterAnim + ", exitAnim=" + this.exitAnim + ", openPageTriggerTimeMs=" + this.openPageTriggerTimeMs + ", intentBooleanExtras=" + this.intentBooleanExtras + ')';
    }

    public final boolean getDisableCaptureDetect() {
        return this.disableCaptureDetect;
    }

    public final Integer getEnterAnim() {
        return this.enterAnim;
    }

    public final Integer getExitAnim() {
        return this.exitAnim;
    }

    public final String getImgPath() {
        return this.imgPath;
    }

    public final Map<String, Boolean> getIntentBooleanExtras() {
        return this.intentBooleanExtras;
    }

    public final boolean getMarkTipsRest() {
        return this.markTipsRest;
    }

    public final long getOpenPageTriggerTimeMs() {
        return this.openPageTriggerTimeMs;
    }

    public final boolean getSupportMultiImages() {
        return this.supportMultiImages;
    }

    public CameraResultOutOpenParams(String r100, boolean r101, boolean r102, boolean r103, Integer r104, Integer r105, long r106, Map<String, Boolean> r110) {
        Intrinsics.checkNotNullParameter(r100, "imgPath");
        Intrinsics.checkNotNullParameter(r110, "intentBooleanExtras");
        this.imgPath = r100;
        this.supportMultiImages = r101;
        this.markTipsRest = r102;
        this.disableCaptureDetect = r103;
        this.enterAnim = r104;
        this.exitAnim = r105;
        this.openPageTriggerTimeMs = r106;
        this.intentBooleanExtras = r110;
    }

    public /* synthetic */ CameraResultOutOpenParams(String r110, boolean r111, boolean r112, boolean r113, Integer r114, Integer r115, long r210, Map r211, int r212, DefaultConstructorMarker r213) {
        if ((r212 & 4) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r212 & 8) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r212 & 16) == 0) goto L13;
        Integer r102 = null;
    L15:
        if ((r212 & 32) == 0) goto L17;
        Integer r103 = null;
    L19:
        if ((r212 & 64) == 0) goto L21;
        long r116 = System.currentTimeMillis();
    L23:
        if ((r212 & 128) == 0) goto L25;
        Map r117 = MapsKt.emptyMap();
    L26:
        this(r110, r111, r100, r101, r102, r103, r116, r117);
        return;
    L25:
        r117 = r211;
        goto L26
    L21:
        r116 = r210;
        goto L23
    L17:
        r103 = r115;
        goto L19
    L13:
        r102 = r114;
        goto L15
    L9:
        r101 = r113;
        goto L11
    L5:
        r100 = r112;
        goto L7
    }
}
