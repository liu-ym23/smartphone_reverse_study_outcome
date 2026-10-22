package com.bytedance.helios.api.config;

import com.amap.api.col.s.ce;
import com.bytedance.android.live.uikit.util.RTLUtil;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.ss.ttvideoengine.superresolution.SRStrategy;
import gz5.o;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0003%&\rR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R \u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001a\u0010\u0011\u001a\u00020\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0016\u001a\u00020\u00158\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u001b\u0010\u000bR \u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001d\u0010\u000bR \u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\t\u001a\u0004\b\u001f\u0010\u000bR \u0010 \u001a\b\u0012\u0004\u0012\u00020\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010\t\u001a\u0004\b!\u0010\u000bR \u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\t\u001a\u0004\b$\u0010\u000b¨\u0006'"}, d2 = {"Lcom/bytedance/helios/api/config/AnchorInfoModel;", "", "", "anchorType", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "", "anchorPages", "Ljava/util/List;", "b", "()Ljava/util/List;", "anchorLifeCycles", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "resourceIds", RXScreenCaptureService.KEY_INDEX, "", "anchorTimeDelay", "J", "c", "()J", "", "maxAnchorCheckCount", "I", ce.f26391f, "()I", "resourcePages", ce.f26395j, "removeAnchorLifecycles", "h", "skipAnchorActions", ce.f26396k, "exemptFragments", "f", "Lgz5/o;", "checkFragments", "e", "AnchorStage", "AnchorType", "api_release"}, k = 1, mv = {1, 4, 0})
public final class AnchorInfoModel {

    @SerializedName("anchor_lifecycles")
    private final List<String> anchorLifeCycles;

    @SerializedName("anchor_pages")
    private final List<String> anchorPages;

    @SerializedName("anchor_time_delay")
    private final long anchorTimeDelay;

    @SerializedName("anchor_type")
    private final String anchorType;

    @SerializedName("check_fragments")
    private final List<o> checkFragments;

    @SerializedName("exempt_fragments")
    private final List<String> exemptFragments;

    @SerializedName("max_anchor_check_count")
    private final int maxAnchorCheckCount;

    @SerializedName("remove_anchor_lifecycles")
    private final List<String> removeAnchorLifecycles;

    @SerializedName(EffectConfiguration.KEY_RESOURCE_IDS)
    private final List<String> resourceIds;

    @SerializedName("resource_pages")
    private final List<String> resourcePages;

    @SerializedName("skip_anchor_actions")
    private final List<String> skipAnchorActions;

    /* JADX INFO: loaded from: classes19.dex */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/helios/api/config/AnchorInfoModel$AnchorStage;", "", "api_release"}, k = 1, mv = {1, 1, 16})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface AnchorStage {
    }

    /* JADX INFO: loaded from: classes19.dex */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/helios/api/config/AnchorInfoModel$AnchorType;", "", "api_release"}, k = 1, mv = {1, 1, 16})
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface AnchorType {
    }

    /* JADX INFO: loaded from: classes19.dex */
    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof AnchorInfoModel) == false) goto L28;
        AnchorInfoModel r101 = (AnchorInfoModel) r100;
        if (Intrinsics.areEqual(this.anchorType, r101.anchorType) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.anchorPages, r101.anchorPages) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.anchorLifeCycles, r101.anchorLifeCycles) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.resourceIds, r101.resourceIds) == true) goto L14;
        return false;
    L14:
        if (this.anchorTimeDelay == r101.anchorTimeDelay) goto L16;
        return false;
    L16:
        if (this.maxAnchorCheckCount == r101.maxAnchorCheckCount) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.resourcePages, r101.resourcePages) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.removeAnchorLifecycles, r101.removeAnchorLifecycles) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.skipAnchorActions, r101.skipAnchorActions) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.exemptFragments, r101.exemptFragments) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.checkFragments, r101.checkFragments) == true) goto L43;
        return false;
    L43:
        return true;
    L28:
        return false;
    }

    public final int hashCode() {
        String r100 = this.anchorType;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        List<String> r104 = this.anchorPages;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        List<String> r107 = this.anchorLifeCycles;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        List<String> r110 = this.resourceIds;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        long r113 = this.anchorTimeDelay;
        int r114 = (((r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31) + this.maxAnchorCheckCount) * 31;
        List<String> r115 = this.resourcePages;
        if (r115 == null) goto L21;
        int r116 = r115.hashCode();
    L22:
        int r117 = (r114 + r116) * 31;
        List<String> r118 = this.removeAnchorLifecycles;
        if (r118 == null) goto L25;
        int r119 = r118.hashCode();
    L26:
        int r120 = (r117 + r119) * 31;
        List<String> r121 = this.skipAnchorActions;
        if (r121 == null) goto L29;
        int r122 = r121.hashCode();
    L30:
        int r123 = (r120 + r122) * 31;
        List<String> r124 = this.exemptFragments;
        if (r124 == null) goto L33;
        int r125 = r124.hashCode();
    L34:
        int r126 = (r123 + r125) * 31;
        List<o> r127 = this.checkFragments;
        if (r127 == null) goto L38;
        r101 = r127.hashCode();
    L38:
        return r126 + r101;
    L33:
        r125 = 0;
        goto L34
    L29:
        r122 = 0;
        goto L30
    L25:
        r119 = 0;
        goto L26
    L21:
        r116 = 0;
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

    public final String toString() {
        return "AnchorInfoModel(anchorType=" + this.anchorType + ", anchorPages=" + this.anchorPages + ", anchorLifeCycles=" + this.anchorLifeCycles + ", resourceIds=" + this.resourceIds + ", anchorTimeDelay=" + this.anchorTimeDelay + ", maxAnchorCheckCount=" + this.maxAnchorCheckCount + ", resourcePages=" + this.resourcePages + ", removeAnchorLifecycles=" + this.removeAnchorLifecycles + ", skipAnchorActions=" + this.skipAnchorActions + ", exemptFragments=" + this.exemptFragments + ", checkFragments=" + this.checkFragments + ")";
    }

    public AnchorInfoModel() {
        List<String> r100 = CollectionsKt.emptyList();
        List<String> r101 = CollectionsKt.listOf("onActivityStop");
        List<String> r102 = CollectionsKt.listOf(new String[]{SRStrategy.KEY_CURRENT_RESOLUTION, RTLUtil.ARABIA_LANG, "nar"});
        List<String> r103 = CollectionsKt.emptyList();
        List<String> r104 = CollectionsKt.listOf(new String[]{"onActivityStart", "onActivityResume"});
        List<String> r105 = CollectionsKt.emptyList();
        List<String> r106 = CollectionsKt.emptyList();
        List<o> r107 = CollectionsKt.emptyList();
        this.anchorType = "multiple_page";
        this.anchorPages = r100;
        this.anchorLifeCycles = r101;
        this.resourceIds = r102;
        this.anchorTimeDelay = 3000;
        this.maxAnchorCheckCount = 3;
        this.resourcePages = r103;
        this.removeAnchorLifecycles = r104;
        this.skipAnchorActions = r105;
        this.exemptFragments = r106;
        this.checkFragments = r107;
    }

    public final List<String> a() {
        return this.anchorLifeCycles;
    }

    public final List<String> b() {
        return this.anchorPages;
    }

    public final long c() {
        return this.anchorTimeDelay;
    }

    public final String d() {
        return this.anchorType;
    }

    public final List<o> e() {
        return this.checkFragments;
    }

    public final List<String> f() {
        return this.exemptFragments;
    }

    public final int g() {
        return this.maxAnchorCheckCount;
    }

    public final List<String> h() {
        return this.removeAnchorLifecycles;
    }

    public final List<String> i() {
        return this.resourceIds;
    }

    public final List<String> j() {
        return this.resourcePages;
    }

    public final List<String> k() {
        return this.skipAnchorActions;
    }
}
