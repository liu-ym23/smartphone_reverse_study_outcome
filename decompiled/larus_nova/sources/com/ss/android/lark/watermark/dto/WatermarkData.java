package com.ss.android.lark.watermark.dto;

import android.os.Parcel;
import android.os.Parcelable;
import com.larksuite.framework.utils.DevEnvUtil;
import com.ss.android.lark.utils.LarkContext;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b&\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000 =2\u00020\u0001:\u0001=Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b¢\u0006\u0004\b\u0012\u0010\u0013J\u0006\u0010$\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020\u0005J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0005HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010*\u001a\u00020\tHÆ\u0003J\t\u0010+\u001a\u00020\u000bHÆ\u0003J\t\u0010,\u001a\u00020\u000bHÆ\u0003J\t\u0010-\u001a\u00020\u000eHÆ\u0003J\t\u0010.\u001a\u00020\u000eHÆ\u0003J\t\u0010/\u001a\u00020\u000bHÆ\u0003J\t\u00100\u001a\u00020\u000bHÆ\u0003Jy\u00101\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\u000b2\b\b\u0002\u0010\u0011\u001a\u00020\u000bHÆ\u0001J\u0006\u00102\u001a\u00020\u000eJ\u0013\u00103\u001a\u00020\u00032\b\u00104\u001a\u0004\u0018\u000105HÖ\u0003J\t\u00106\u001a\u00020\u000eHÖ\u0001J\t\u00107\u001a\u00020\u0005HÖ\u0001J\u0016\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020;2\u0006\u0010<\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0011\u0010\u0011\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001d¨\u0006>"}, d2 = {"Lcom/ss/android/lark/watermark/dto/WatermarkData;", "Landroid/os/Parcelable;", "obviousEnabled", "", "text", "", "mysteriousEnabled", "imageUrl", "refreshInterval", "", "alpha", "", "alphaDarkMode", "fontSize", "", "rotateAngleInDegree", "horizontalInterval", "verticalInterval", "<init>", "(ZLjava/lang/String;ZLjava/lang/String;JFFIIFF)V", "getObviousEnabled", "()Z", "getText", "()Ljava/lang/String;", "getMysteriousEnabled", "getImageUrl", "getRefreshInterval", "()J", "getAlpha", "()F", "getAlphaDarkMode", "getFontSize", "()I", "getRotateAngleInDegree", "getHorizontalInterval", "getVerticalInterval", "shouldRefresh", "getInfo", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "watermark-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WatermarkData implements Parcelable {
    public static final Parcelable.Creator<WatermarkData> CREATOR = null;
    public static final Companion Companion = null;
    private static final WatermarkData EMPTY = null;
    private final float alpha;
    private final float alphaDarkMode;
    private final int fontSize;
    private final float horizontalInterval;
    private final String imageUrl;
    private final boolean mysteriousEnabled;
    private final boolean obviousEnabled;
    private final long refreshInterval;
    private final int rotateAngleInDegree;
    private final String text;
    private final float verticalInterval;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/watermark/dto/WatermarkData$Companion;", "", "<init>", "()V", "EMPTY", "Lcom/ss/android/lark/watermark/dto/WatermarkData;", "getEMPTY", "()Lcom/ss/android/lark/watermark/dto/WatermarkData;", "watermark-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final WatermarkData getEMPTY() {
            return WatermarkData.access$getEMPTY$cp();
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<WatermarkData> {
        public Creator() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WatermarkData createFromParcel(Parcel r110) {
            Intrinsics.checkNotNullParameter(r110, "parcel");
            boolean r100 = false;
            if (r110.readInt() == 0) goto L5;
            boolean r101 = true;
        L6:
            String r102 = r110.readString();
            if (r110.readInt() == 0) goto L10;
            r100 = true;
        L10:
            return new WatermarkData(r101, r102, r100, r110.readString(), r110.readLong(), r110.readFloat(), r110.readFloat(), r110.readInt(), r110.readInt(), r110.readFloat(), r110.readFloat());
        L5:
            r101 = false;
            goto L6
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WatermarkData createFromParcel(Parcel r100) {
            return createFromParcel(r100);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public final WatermarkData[] newArray(int r100) {
            return new WatermarkData[r100];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ WatermarkData[] newArray(int r100) {
            return newArray(r100);
        }
    }

    public static /* synthetic */ WatermarkData copy$default(WatermarkData r110, boolean r111, String r112, boolean r113, String r114, long r115, float r210, float r211, int r212, int r213, float r214, float r215, int r216, Object r217) {
        if ((r216 & 1) == 0) goto L5;
        boolean r100 = r110.obviousEnabled;
    L7:
        if ((r216 & 2) == 0) goto L9;
        String r101 = r110.text;
    L11:
        if ((r216 & 4) == 0) goto L13;
        boolean r102 = r110.mysteriousEnabled;
    L15:
        if ((r216 & 8) == 0) goto L17;
        String r103 = r110.imageUrl;
    L19:
        if ((r216 & 16) == 0) goto L21;
        long r104 = r110.refreshInterval;
    L23:
        if ((r216 & 32) == 0) goto L25;
        float r105 = r110.alpha;
    L27:
        if ((r216 & 64) == 0) goto L29;
        float r106 = r110.alphaDarkMode;
    L31:
        if ((r216 & 128) == 0) goto L33;
        int r116 = r110.fontSize;
    L35:
        if ((r216 & 256) == 0) goto L37;
        int r117 = r110.rotateAngleInDegree;
    L39:
        if ((r216 & 512) == 0) goto L41;
        float r118 = r110.horizontalInterval;
    L43:
        if ((r216 & 1024) == 0) goto L45;
        float r107 = r110.verticalInterval;
    L47:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r116, r117, r118, r107);
    L45:
        r107 = r215;
        goto L47
    L41:
        r118 = r214;
        goto L43
    L37:
        r117 = r213;
        goto L39
    L33:
        r116 = r212;
        goto L35
    L29:
        r106 = r211;
        goto L31
    L25:
        r105 = r210;
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

    public final boolean component1() {
        return this.obviousEnabled;
    }

    public final float component10() {
        return this.horizontalInterval;
    }

    public final float component11() {
        return this.verticalInterval;
    }

    public final String component2() {
        return this.text;
    }

    public final boolean component3() {
        return this.mysteriousEnabled;
    }

    public final String component4() {
        return this.imageUrl;
    }

    public final long component5() {
        return this.refreshInterval;
    }

    public final float component6() {
        return this.alpha;
    }

    public final float component7() {
        return this.alphaDarkMode;
    }

    public final int component8() {
        return this.fontSize;
    }

    public final int component9() {
        return this.rotateAngleInDegree;
    }

    public final WatermarkData copy(boolean r110, String r111, boolean r112, String r113, long r114, float r210, float r211, int r212, int r213, float r214, float r215) {
        Intrinsics.checkNotNullParameter(r111, "text");
        return new WatermarkData(r110, r111, r112, r113, r114, r210, r211, r212, r213, r214, r215);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof WatermarkData) == true) goto L8;
        return false;
    L8:
        WatermarkData r101 = (WatermarkData) r100;
        if (this.obviousEnabled == r101.obviousEnabled) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.text, r101.text) == true) goto L15;
        return false;
    L15:
        if (this.mysteriousEnabled == r101.mysteriousEnabled) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.imageUrl, r101.imageUrl) == true) goto L21;
        return false;
    L21:
        if (this.refreshInterval == r101.refreshInterval) goto L24;
        return false;
    L24:
        if (Float.compare(this.alpha, r101.alpha) == 0) goto L27;
        return false;
    L27:
        if (Float.compare(this.alphaDarkMode, r101.alphaDarkMode) == 0) goto L30;
        return false;
    L30:
        if (this.fontSize == r101.fontSize) goto L33;
        return false;
    L33:
        if (this.rotateAngleInDegree == r101.rotateAngleInDegree) goto L36;
        return false;
    L36:
        if (Float.compare(this.horizontalInterval, r101.horizontalInterval) == 0) goto L39;
        return false;
    L39:
        if (Float.compare(this.verticalInterval, r101.verticalInterval) == 0) goto L41;
        return false;
    L41:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.obviousEnabled == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = ((r101 * 31) + this.text.hashCode()) * 31;
        if (this.mysteriousEnabled == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        String r104 = this.imageUrl;
        if (r104 != null) goto L13;
        int r105 = 0;
    L14:
        int r106 = (r103 + r105) * 31;
        long r107 = this.refreshInterval;
        return ((((((((((((r106 + ((int) (r107 ^ (r107 >>> 32)))) * 31) + Float.floatToIntBits(this.alpha)) * 31) + Float.floatToIntBits(this.alphaDarkMode)) * 31) + this.fontSize) * 31) + this.rotateAngleInDegree) * 31) + Float.floatToIntBits(this.horizontalInterval)) * 31) + Float.floatToIntBits(this.verticalInterval);
    L13:
        r105 = r104.hashCode();
        goto L14
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "WatermarkData(obviousEnabled=" + this.obviousEnabled + ", text=" + this.text + ", mysteriousEnabled=" + this.mysteriousEnabled + ", imageUrl=" + this.imageUrl + ", refreshInterval=" + this.refreshInterval + ", alpha=" + this.alpha + ", alphaDarkMode=" + this.alphaDarkMode + ", fontSize=" + this.fontSize + ", rotateAngleInDegree=" + this.rotateAngleInDegree + ", horizontalInterval=" + this.horizontalInterval + ", verticalInterval=" + this.verticalInterval + ')';
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "dest");
        r100.writeInt(this.obviousEnabled ? 1 : 0);
        r100.writeString(this.text);
        r100.writeInt(this.mysteriousEnabled ? 1 : 0);
        r100.writeString(this.imageUrl);
        r100.writeLong(this.refreshInterval);
        r100.writeFloat(this.alpha);
        r100.writeFloat(this.alphaDarkMode);
        r100.writeInt(this.fontSize);
        r100.writeInt(this.rotateAngleInDegree);
        r100.writeFloat(this.horizontalInterval);
        r100.writeFloat(this.verticalInterval);
    }

    static {
        Companion = new Companion(null);
        CREATOR = new Creator();
        EMPTY = new WatermarkData(false, "", false, null, 0, 0.0f, 0.0f, 0, 0, 0.0f, 0.0f, 2044, null);
    }

    public final boolean shouldRefresh() {
        if (this.refreshInterval == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String getInfo() {
        if (DevEnvUtil.isDebugMode(LarkContext.getApplication()) == true) goto L17;
        if (DevEnvUtil.isDevelopPackage(LarkContext.getApplication()) == true) goto L17;
        StringBuilder r100 = new StringBuilder("WatermarkData(obviousEnabled=");
        r100.append(this.obviousEnabled);
        r100.append(", text.length=");
        r100.append(this.text.length());
        r100.append(", mysteriousEnabled=");
        r100.append(this.mysteriousEnabled);
        r100.append(", imageUrl.isExit=");
        String r101 = this.imageUrl;
        if (r101 != null) goto L10;
    L13:
        boolean r102 = true;
    L14:
        r100.append(!r102);
        r100.append(", refreshInterval=");
        r100.append(this.refreshInterval);
        r100.append(", alpha=");
        r100.append(this.alpha);
        r100.append(", alphaDarkMode=");
        r100.append(this.alphaDarkMode);
        r100.append(", fontSize=");
        r100.append(this.fontSize);
        r100.append(", rotateAngleInDegree=");
        r100.append(this.rotateAngleInDegree);
        r100.append(", density=");
        r100.append(this.horizontalInterval);
        r100.append(')');
        return r100.toString();
    L10:
        if (r101.length() == 0) goto L13;
        r102 = false;
    L17:
        return "WatermarkData(obviousEnabled=" + this.obviousEnabled + ", text=" + this.text + ", mysteriousEnabled=" + this.mysteriousEnabled + ", imageUrl=" + this.imageUrl + ", refreshInterval=" + this.refreshInterval + ", alpha=" + this.alpha + ", alphaDarkMode=" + this.alphaDarkMode + ", fontSize=" + this.fontSize + ", rotateAngleInDegree=" + this.rotateAngleInDegree + ", density=" + this.horizontalInterval + ')';
    }

    public static final /* synthetic */ WatermarkData access$getEMPTY$cp() {
        return EMPTY;
    }

    public final float getAlpha() {
        return this.alpha;
    }

    public final float getAlphaDarkMode() {
        return this.alphaDarkMode;
    }

    public final int getFontSize() {
        return this.fontSize;
    }

    public final float getHorizontalInterval() {
        return this.horizontalInterval;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final boolean getMysteriousEnabled() {
        return this.mysteriousEnabled;
    }

    public final boolean getObviousEnabled() {
        return this.obviousEnabled;
    }

    public final long getRefreshInterval() {
        return this.refreshInterval;
    }

    public final int getRotateAngleInDegree() {
        return this.rotateAngleInDegree;
    }

    public final String getText() {
        return this.text;
    }

    public final float getVerticalInterval() {
        return this.verticalInterval;
    }

    public WatermarkData(boolean r100, String r101, boolean r102, String r103, long r104, float r105, float r106, int r110, int r111, float r112, float r113) {
        Intrinsics.checkNotNullParameter(r101, "text");
        this.obviousEnabled = r100;
        this.text = r101;
        this.mysteriousEnabled = r102;
        this.imageUrl = r103;
        this.refreshInterval = r104;
        this.alpha = r105;
        this.alphaDarkMode = r106;
        this.fontSize = r110;
        this.rotateAngleInDegree = r111;
        this.horizontalInterval = r112;
        this.verticalInterval = r113;
    }

    public /* synthetic */ WatermarkData(boolean r110, String r111, boolean r112, String r113, long r210, float r211, float r212, int r213, int r214, float r215, float r216, int r217, DefaultConstructorMarker r218) {
        if ((r217 & 1) == 0) goto L5;
        boolean r100 = true;
    L7:
        if ((r217 & 4) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r217 & 8) == 0) goto L13;
        String r102 = null;
    L15:
        if ((r217 & 16) == 0) goto L17;
        long r103 = TimeUnit.SECONDS.toMillis(0);
    L19:
        if ((r217 & 32) == 0) goto L21;
        float r104 = 0.12f;
    L23:
        if ((r217 & 64) == 0) goto L25;
        float r114 = 0.08f;
    L27:
        if ((r217 & 128) == 0) goto L29;
        int r115 = 14;
    L31:
        if ((r217 & 256) == 0) goto L33;
        int r116 = -15;
    L35:
        if ((r217 & 512) == 0) goto L37;
        float r117 = WatermarkDensity.MID_DENSITY.getHorizontalInterval();
    L39:
        if ((r217 & 1024) == 0) goto L41;
        float r118 = WatermarkDensity.MID_DENSITY.getVerticalInterval();
    L42:
        this(r100, r111, r101, r102, r103, r104, r114, r115, r116, r117, r118);
        return;
    L41:
        r118 = r216;
        goto L42
    L37:
        r117 = r215;
        goto L39
    L33:
        r116 = r214;
        goto L35
    L29:
        r115 = r213;
        goto L31
    L25:
        r114 = r212;
        goto L27
    L21:
        r104 = r211;
        goto L23
    L17:
        r103 = r210;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
