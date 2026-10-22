package com.bytedance.locallife.groupon.struct;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\b\u0087\b\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001cB+\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0019\u0010\u001aJ\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0005\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003J4\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\r\u001a\u00020\u0006HÖ\u0001J\t\u0010\u000e\u001a\u00020\u0002HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0013\u001a\u0004\b\u0014\u0010\u0004R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0013\u001a\u0004\b\u0015\u0010\u0004R\u001c\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001d"}, d2 = {"Lcom/bytedance/locallife/groupon/struct/NearbyUnderTakeBubbleStruct;", "Ljava/io/Serializable;", "", "component1", "()Ljava/lang/Integer;", "component2", "", "component3", "bubbleType", "triggerType", "bubbleStruct", "copy", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/bytedance/locallife/groupon/struct/NearbyUnderTakeBubbleStruct;", "toString", "hashCode", "", "other", "", "equals", "Ljava/lang/Integer;", "getBubbleType", "getTriggerType", "Ljava/lang/String;", "getBubbleStruct", "()Ljava/lang/String;", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class NearbyUnderTakeBubbleStruct implements Serializable {
    public static final int BUBBLE_TYPE_AFTER_PAY = 27;
    public static final a Companion = null;
    public static final int TRIGGER_TYPE_DIRECTLY_SHOW = 1;
    public static final int TRIGGER_TYPE_SHOW_AFTER_DIAMOND_HIGHLIGHT = 4;
    public static final int TRIGGER_TYPE_SHOW_AFTER_HALF_DIALOG = 3;

    @SerializedName("bubble_struct")
    private final String bubbleStruct;

    @SerializedName("bubble_type")
    private final Integer bubbleType;

    @SerializedName("trigger_type")
    private final Integer triggerType;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public NearbyUnderTakeBubbleStruct() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ NearbyUnderTakeBubbleStruct copy$default(NearbyUnderTakeBubbleStruct r100, Integer r101, Integer r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.bubbleType;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.triggerType;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.bubbleStruct;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final Integer component1() {
        return this.bubbleType;
    }

    public final Integer component2() {
        return this.triggerType;
    }

    public final String component3() {
        return this.bubbleStruct;
    }

    public final NearbyUnderTakeBubbleStruct copy(Integer r100, Integer r101, String r102) {
        return new NearbyUnderTakeBubbleStruct(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof NearbyUnderTakeBubbleStruct) == true) goto L8;
        return false;
    L8:
        NearbyUnderTakeBubbleStruct r101 = (NearbyUnderTakeBubbleStruct) r100;
        if (Intrinsics.areEqual(this.bubbleType, r101.bubbleType) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.triggerType, r101.triggerType) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.bubbleStruct, r101.bubbleStruct) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.bubbleType;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.triggerType;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.bubbleStruct;
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

    public String toString() {
        return "NearbyUnderTakeBubbleStruct(bubbleType=" + this.bubbleType + ", triggerType=" + this.triggerType + ", bubbleStruct=" + this.bubbleStruct + ')';
    }

    public final String getBubbleStruct() {
        return this.bubbleStruct;
    }

    public final Integer getBubbleType() {
        return this.bubbleType;
    }

    public final Integer getTriggerType() {
        return this.triggerType;
    }

    public NearbyUnderTakeBubbleStruct(Integer r100, Integer r101, String r102) {
        this.bubbleType = r100;
        this.triggerType = r101;
        this.bubbleStruct = r102;
    }

    public /* synthetic */ NearbyUnderTakeBubbleStruct(Integer r100, Integer r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
