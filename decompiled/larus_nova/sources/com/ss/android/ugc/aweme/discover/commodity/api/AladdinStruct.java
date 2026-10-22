package com.ss.android.ugc.aweme.discover.commodity.api;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.aweme.discover.mixfeed.DynamicPatch;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\b\u0018\u00002\u00020\u0001Bc\u0012\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000b¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u001d\u001a\u00020\u001eJ\u0017\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0003HÆ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0011J\u000b\u0010!\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010#\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0015J\u0010\u0010$\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u0010%\u001a\u00020\u000bHÆ\u0003Jl\u0010&\u001a\u00020\u00002\u0016\b\u0002\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000bHÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u000b2\b\u0010)\u001a\u0004\u0018\u00010\u0005HÖ\u0003J\t\u0010*\u001a\u00020\u0007HÖ\u0001J\t\u0010+\u001a\u00020\u0004HÖ\u0001R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0012\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\n\u0010\u0015R\u0016\u0010\u000e\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0017R\u001a\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\r\u0010\u0015R$\u0010\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0011R\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u001c\u0010\u0015¨\u0006,"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/AladdinStruct;", "Ljava/io/Serializable;", "logInfo", "", "", "", "customMaxHeight", "", "dynamicPatch", "Lcom/ss/android/ugc/aweme/discover/mixfeed/DynamicPatch;", "isAutoPlay", "", "needPlayFinish", "isWrapHeight", "isNativeReportShow", "(Ljava/util/Map;Ljava/lang/Integer;Lcom/ss/android/ugc/aweme/discover/mixfeed/DynamicPatch;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Z)V", "getCustomMaxHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getDynamicPatch", "()Lcom/ss/android/ugc/aweme/discover/mixfeed/DynamicPatch;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "()Z", "getLogInfo", "()Ljava/util/Map;", "lynxShowHeight", "getLynxShowHeight", "getNeedPlayFinish", "asKiwiStruct", "Lcom/ss/android/ugc/aweme/discover/commodity/api/KiwiStruct;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/util/Map;Ljava/lang/Integer;Lcom/ss/android/ugc/aweme/discover/mixfeed/DynamicPatch;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Z)Lcom/ss/android/ugc/aweme/discover/commodity/api/AladdinStruct;", "equals", "other", "hashCode", "toString", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AladdinStruct implements Serializable {

    @SerializedName("custom_max_height")
    private final Integer customMaxHeight;

    @SerializedName("dynamic_patch")
    private final DynamicPatch dynamicPatch;

    @SerializedName("is_auto_play")
    private final Boolean isAutoPlay;

    @SerializedName("is_native_report_show")
    private final boolean isNativeReportShow;

    @SerializedName("is_wrap_height")
    private final Boolean isWrapHeight;

    @SerializedName("log_info")
    private final Map<String, Object> logInfo;

    @SerializedName("need_play_finish")
    private final Boolean needPlayFinish;

    public AladdinStruct() {
        this(null, null, null, null, null, null, false, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AladdinStruct copy$default(AladdinStruct r100, Map r101, Integer r102, DynamicPatch r103, Boolean r104, Boolean r110, Boolean r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.logInfo;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.customMaxHeight;
    L8:
        Integer r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.dynamicPatch;
    L11:
        DynamicPatch r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.isAutoPlay;
    L14:
        Boolean r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.needPlayFinish;
    L17:
        Boolean r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.isWrapHeight;
    L20:
        Boolean r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.isNativeReportShow;
    L23:
        Map r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final Map<String, Object> component1() {
        return this.logInfo;
    }

    public final Integer component2() {
        return this.customMaxHeight;
    }

    public final DynamicPatch component3() {
        return this.dynamicPatch;
    }

    public final Boolean component4() {
        return this.isAutoPlay;
    }

    public final Boolean component5() {
        return this.needPlayFinish;
    }

    public final Boolean component6() {
        return this.isWrapHeight;
    }

    public final boolean component7() {
        return this.isNativeReportShow;
    }

    public final AladdinStruct copy(Map<String, ? extends Object> r110, Integer r111, DynamicPatch r112, Boolean r113, Boolean r114, Boolean r115, boolean r116) {
        return new AladdinStruct(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AladdinStruct) == false) goto L20;
        AladdinStruct r101 = (AladdinStruct) r100;
        if (Intrinsics.areEqual(this.logInfo, r101.logInfo) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.customMaxHeight, r101.customMaxHeight) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.dynamicPatch, r101.dynamicPatch) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.isAutoPlay, r101.isAutoPlay) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.needPlayFinish, r101.needPlayFinish) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.isWrapHeight, r101.isWrapHeight) == true) goto L18;
        return false;
    L18:
        if (this.isNativeReportShow == r101.isNativeReportShow) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        Map<String, Object> r100 = this.logInfo;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.customMaxHeight;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        DynamicPatch r107 = this.dynamicPatch;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Boolean r110 = this.isAutoPlay;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Boolean r113 = this.needPlayFinish;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        Boolean r116 = this.isWrapHeight;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        int r117 = (r115 + r101) * 31;
        boolean r118 = this.isNativeReportShow;
        ?? r119 = r118;
        if (r118 == false) goto L29;
        r119 = 1;
    L29:
        return r117 + r119;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public String toString() {
        return "AladdinStruct(logInfo=" + this.logInfo + ", customMaxHeight=" + this.customMaxHeight + ", dynamicPatch=" + this.dynamicPatch + ", isAutoPlay=" + this.isAutoPlay + ", needPlayFinish=" + this.needPlayFinish + ", isWrapHeight=" + this.isWrapHeight + ", isNativeReportShow=" + this.isNativeReportShow + ")";
    }

    public final KiwiStruct asKiwiStruct() {
        return new KiwiStruct(this.logInfo, this.customMaxHeight, this.dynamicPatch, this.isAutoPlay, this.needPlayFinish, this.isWrapHeight, this.isNativeReportShow, true);
    }

    public final Integer getLynxShowHeight() {
        Integer r100 = this.customMaxHeight;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(1, r100.floatValue(), INVOKEVIRTUAL_com_ss_android_ugc_aweme_discover_commodity_api_AladdinStruct_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
    }

    public final Integer getCustomMaxHeight() {
        return this.customMaxHeight;
    }

    public final DynamicPatch getDynamicPatch() {
        return this.dynamicPatch;
    }

    public final Map<String, Object> getLogInfo() {
        return this.logInfo;
    }

    public final Boolean getNeedPlayFinish() {
        return this.needPlayFinish;
    }

    public final Boolean isAutoPlay() {
        return this.isAutoPlay;
    }

    public final boolean isNativeReportShow() {
        return this.isNativeReportShow;
    }

    public final Boolean isWrapHeight() {
        return this.isWrapHeight;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_android_ugc_aweme_discover_commodity_api_AladdinStruct_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public AladdinStruct(Map<String, ? extends Object> r100, Integer r101, DynamicPatch r102, Boolean r103, Boolean r104, Boolean r105, boolean r106) {
        this.logInfo = r100;
        this.customMaxHeight = r101;
        this.dynamicPatch = r102;
        this.isAutoPlay = r103;
        this.needPlayFinish = r104;
        this.isWrapHeight = r105;
        this.isNativeReportShow = r106;
    }

    public /* synthetic */ AladdinStruct(Map r100, Integer r101, DynamicPatch r102, Boolean r110, Boolean r111, Boolean r112, boolean r113, int r114, DefaultConstructorMarker r115) {
        Boolean r103 = null;
        if ((r114 & 1) == 0) goto L5;
        Map r116 = null;
    L7:
        if ((r114 & 2) == 0) goto L9;
        r101 = 0;
    L9:
        Integer r104 = r101;
        if ((r114 & 4) == 0) goto L12;
        DynamicPatch r105 = null;
    L14:
        if ((r114 & 8) == 0) goto L16;
        Boolean r106 = null;
    L18:
        if ((r114 & 16) == 0) goto L20;
        Boolean r107 = null;
    L22:
        if ((r114 & 32) != 0) goto L26;
        r103 = r112;
    L26:
        if ((r114 & 64) == 0) goto L28;
        boolean r117 = false;
    L29:
        this(r116, r104, r105, r106, r107, r103, r117);
        return;
    L28:
        r117 = r113;
        goto L29
    L20:
        r107 = r111;
        goto L22
    L16:
        r106 = r110;
        goto L18
    L12:
        r105 = r102;
        goto L14
    L5:
        r116 = r100;
        goto L7
    }
}
