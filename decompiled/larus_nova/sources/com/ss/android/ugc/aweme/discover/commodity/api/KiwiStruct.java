package com.ss.android.ugc.aweme.discover.commodity.api;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.mixfeed.DynamicPatch;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b&\b\u0086\b\u0018\u00002\u00020\u0001Bo\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u000b¢\u0006\u0004\b/\u00100J\u0017\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002HÆ\u0003J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0012\u0010\f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000e\u0010\rJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0004\b\u000f\u0010\rJ\t\u0010\u0010\u001a\u00020\u000bHÆ\u0003J\t\u0010\u0011\u001a\u00020\u000bHÆ\u0003Jx\u0010\u001a\u001a\u00020\u00002\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\u0018\u001a\u00020\u000b2\b\b\u0002\u0010\u0019\u001a\u00020\u000bHÆ\u0001¢\u0006\u0004\b\u001a\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001d\u001a\u00020\u0006HÖ\u0001J\u0013\u0010\u001f\u001a\u00020\u000b2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÖ\u0003R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010#\u001a\u0004\b$\u0010\bR\u001c\u0010\u0014\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010%\u001a\u0004\b&\u0010'R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010(\u001a\u0004\b\u0015\u0010\rR\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010(\u001a\u0004\b)\u0010\rR\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010(\u001a\u0004\b\u0017\u0010\rR\u001a\u0010\u0018\u001a\u00020\u000b8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010*\u001a\u0004\b\u0018\u0010+R\u0017\u0010\u0019\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b,\u0010*\u001a\u0004\b\u0019\u0010+R\u0013\u0010.\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b-\u0010\b¨\u00061"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/api/KiwiStruct;", "Ljava/io/Serializable;", "", "", "", "component1", "", "component2", "()Ljava/lang/Integer;", "Lcom/ss/android/ugc/aweme/discover/mixfeed/DynamicPatch;", "component3", "", "component4", "()Ljava/lang/Boolean;", "component5", "component6", "component7", "component8", "logInfo", "customMaxHeight", "dynamicPatch", "isAutoPlay", "needPlayFinish", "isWrapHeight", "isNativeReportShow", "isAladdin", "copy", "(Ljava/util/Map;Ljava/lang/Integer;Lcom/ss/android/ugc/aweme/discover/mixfeed/DynamicPatch;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;ZZ)Lcom/ss/android/ugc/aweme/discover/commodity/api/KiwiStruct;", "toString", "hashCode", "other", "equals", "Ljava/util/Map;", "getLogInfo", "()Ljava/util/Map;", "Ljava/lang/Integer;", "getCustomMaxHeight", "Lcom/ss/android/ugc/aweme/discover/mixfeed/DynamicPatch;", "getDynamicPatch", "()Lcom/ss/android/ugc/aweme/discover/mixfeed/DynamicPatch;", "Ljava/lang/Boolean;", "getNeedPlayFinish", "Z", "()Z", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "getLynxShowHeight", "lynxShowHeight", "<init>", "(Ljava/util/Map;Ljava/lang/Integer;Lcom/ss/android/ugc/aweme/discover/mixfeed/DynamicPatch;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;ZZ)V", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class KiwiStruct implements Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient boolean f450032a;

    @SerializedName("custom_max_height")
    private final Integer customMaxHeight;

    @SerializedName("kiwi_dynamic")
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

    public KiwiStruct() {
        this(null, null, null, null, null, null, false, false, 255, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KiwiStruct copy$default(KiwiStruct r100, Map r110, Integer r111, DynamicPatch r112, Boolean r113, Boolean r114, Boolean r115, boolean r116, boolean r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        Map r101 = r100.logInfo;
    L7:
        if ((r118 & 2) == 0) goto L9;
        Integer r102 = r100.customMaxHeight;
    L11:
        if ((r118 & 4) == 0) goto L13;
        DynamicPatch r103 = r100.dynamicPatch;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Boolean r104 = r100.isAutoPlay;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Boolean r105 = r100.needPlayFinish;
    L23:
        if ((r118 & 32) == 0) goto L25;
        Boolean r106 = r100.isWrapHeight;
    L27:
        if ((r118 & 64) == 0) goto L29;
        boolean r107 = r100.isNativeReportShow;
    L31:
        if ((r118 & 128) == 0) goto L33;
        boolean r108 = r100.f450032a;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
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

    public final boolean component8() {
        return this.f450032a;
    }

    public final KiwiStruct copy(Map<String, ? extends Object> r110, Integer r111, DynamicPatch r112, Boolean r113, Boolean r114, Boolean r115, boolean r116, boolean r117) {
        return new KiwiStruct(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof KiwiStruct) == false) goto L22;
        KiwiStruct r101 = (KiwiStruct) r100;
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
        if (this.isNativeReportShow == r101.isNativeReportShow) goto L20;
        return false;
    L20:
        if (this.f450032a == r101.f450032a) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v16, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
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
        ?? r119 = 1;
        ?? r120 = r118;
        if (r118 == false) goto L28;
        r120 = 1;
    L28:
        int r121 = (r117 + r120) * 31;
        boolean r122 = this.f450032a;
        if (r122 == true) goto L33;
        r119 = r122;
    L33:
        return r121 + r119;
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
        return "KiwiStruct(logInfo=" + this.logInfo + ", customMaxHeight=" + this.customMaxHeight + ", dynamicPatch=" + this.dynamicPatch + ", isAutoPlay=" + this.isAutoPlay + ", needPlayFinish=" + this.needPlayFinish + ", isWrapHeight=" + this.isWrapHeight + ", isNativeReportShow=" + this.isNativeReportShow + ", isAladdin=" + this.f450032a + ")";
    }

    public final Integer getLynxShowHeight() {
        Integer r100 = this.customMaxHeight;
        if (r100 != null) goto L7;
        return null;
    L7:
        return Integer.valueOf(MathKt.roundToInt(TypedValue.applyDimension(1, r100.floatValue(), INVOKEVIRTUAL_com_ss_android_ugc_aweme_discover_commodity_api_KiwiStruct_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources.getSystem()))));
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

    public final boolean isAladdin() {
        return this.f450032a;
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

    public static DisplayMetrics INVOKEVIRTUAL_com_ss_android_ugc_aweme_discover_commodity_api_KiwiStruct_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public KiwiStruct(Map<String, ? extends Object> r100, Integer r101, DynamicPatch r102, Boolean r103, Boolean r104, Boolean r105, boolean r106, boolean r107) {
        this.logInfo = r100;
        this.customMaxHeight = r101;
        this.dynamicPatch = r102;
        this.isAutoPlay = r103;
        this.needPlayFinish = r104;
        this.isWrapHeight = r105;
        this.isNativeReportShow = r106;
        this.f450032a = r107;
    }

    public /* synthetic */ KiwiStruct(Map r110, Integer r111, DynamicPatch r112, Boolean r113, Boolean r114, Boolean r115, boolean r116, boolean r117, int r118, DefaultConstructorMarker r119) {
        Boolean r100 = null;
        if ((r118 & 1) == 0) goto L5;
        Map r101 = null;
    L6:
        boolean r102 = false;
        if ((r118 & 2) == 0) goto L9;
        Integer r103 = 0;
    L11:
        if ((r118 & 4) == 0) goto L13;
        DynamicPatch r104 = null;
    L15:
        if ((r118 & 8) == 0) goto L17;
        Boolean r105 = null;
    L19:
        if ((r118 & 16) == 0) goto L21;
        Boolean r106 = null;
    L23:
        if ((r118 & 32) != 0) goto L27;
        r100 = r115;
    L27:
        if ((r118 & 64) == 0) goto L29;
        boolean r107 = false;
    L31:
        if ((r118 & 128) != 0) goto L34;
        r102 = r117;
    L34:
        this(r101, r103, r104, r105, r106, r100, r107, r102);
        return;
    L29:
        r107 = r116;
        goto L31
    L21:
        r106 = r114;
        goto L23
    L17:
        r105 = r113;
        goto L19
    L13:
        r104 = r112;
        goto L15
    L9:
        r103 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L6
    }
}
