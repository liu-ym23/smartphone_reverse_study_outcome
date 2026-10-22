package com.bytedance.android.shopping.api.mall.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b<\b\u0087\b\u0018\u00002\u00020\u0001Bí\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0016\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u0016¢\u0006\u0002\u0010\u001eJ\u000b\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010@\u001a\u0004\u0018\u00010\u000eHÆ\u0003J\u000b\u0010A\u001a\u0004\u0018\u00010\u0010HÆ\u0003J\u0010\u0010B\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00104J\u000b\u0010C\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0016HÆ\u0003¢\u0006\u0002\u00107J\u0011\u0010F\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0018HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u001aHÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\t\u0010I\u001a\u00020\u0016HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010K\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010L\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010M\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010N\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010O\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010P\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00104J\u0010\u0010Q\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u00104Jö\u0001\u0010R\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u0016HÆ\u0001¢\u0006\u0002\u0010SJ\u0013\u0010T\u001a\u00020\u00162\b\u0010U\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010V\u001a\u00020\u000bHÖ\u0001J\t\u0010W\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\"R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\"R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u001c8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001a\u0010\u001d\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010-\"\u0004\b.\u0010/R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\"R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\"R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u001a\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b3\u00104R\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00168\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00108\u001a\u0004\b6\u00107R\u001e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b;\u00104R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b<\u0010\"R\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u00105\u001a\u0004\b=\u00104R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010\"¨\u0006X"}, d2 = {"Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTab;", "", "moduleId", "", "componentId", "tabId", "dockedId", "name", "title", "link", "tabType", "", "nativeContainerType", "iconConf", "Lcom/bytedance/android/shopping/api/mall/model/TabIcon;", "animation", "Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabAnimation;", "tabContainerType", "customizedMallBgSkin", "Lcom/bytedance/android/shopping/api/mall/model/CustomizedMallBgSkin;", "btmCode", "pageDisableRefresh", "", "supportResource", "", "guideIcon", "Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabGuideIcon;", "guide", "Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabBubble;", "isCacheData", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/model/TabIcon;Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabAnimation;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/model/CustomizedMallBgSkin;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabGuideIcon;Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabBubble;Z)V", "getAnimation", "()Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabAnimation;", "getBtmCode", "()Ljava/lang/String;", "getComponentId", "getCustomizedMallBgSkin", "()Lcom/bytedance/android/shopping/api/mall/model/CustomizedMallBgSkin;", "getDockedId", "getGuide", "()Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabBubble;", "getGuideIcon", "()Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabGuideIcon;", "getIconConf", "()Lcom/bytedance/android/shopping/api/mall/model/TabIcon;", "()Z", "setCacheData", "(Z)V", "getLink", "getModuleId", "getName", "getNativeContainerType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPageDisableRefresh", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getSupportResource", "()Ljava/util/List;", "getTabContainerType", "getTabId", "getTabType", "getTitle", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/model/TabIcon;Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabAnimation;Ljava/lang/Integer;Lcom/bytedance/android/shopping/api/mall/model/CustomizedMallBgSkin;Ljava/lang/String;Ljava/lang/Boolean;Ljava/util/List;Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabGuideIcon;Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTabBubble;Z)Lcom/bytedance/android/shopping/api/mall/model/MallCategoryTab;", "equals", "other", "hashCode", "toString", "mall-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class MallCategoryTab {

    @SerializedName("animation")
    private final MallCategoryTabAnimation animation;

    @SerializedName("btm_code")
    private final String btmCode;

    @SerializedName("component_id")
    private final String componentId;

    @SerializedName("customized_mall_bg_skin")
    private final CustomizedMallBgSkin customizedMallBgSkin;

    @SerializedName("docked_id")
    private final String dockedId;

    @SerializedName("bubble")
    private final MallCategoryTabBubble guide;

    @SerializedName("guide_icon")
    private final MallCategoryTabGuideIcon guideIcon;

    @SerializedName("icon_conf")
    private final TabIcon iconConf;
    private boolean isCacheData;

    @SerializedName("link")
    private final String link;

    @SerializedName("module_id")
    private final String moduleId;

    @SerializedName("name")
    private final String name;

    @SerializedName("native_container_type")
    private final Integer nativeContainerType;

    @SerializedName("page_disable_refresh")
    private final Boolean pageDisableRefresh;

    @SerializedName("support_resource")
    private final List<Integer> supportResource;

    @SerializedName("tab_container_type")
    private final Integer tabContainerType;

    @SerializedName("tab_id")
    private final String tabId;

    @SerializedName("tab_type")
    private final Integer tabType;

    @SerializedName("title")
    private final String title;

    public MallCategoryTab() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, false, 524287, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MallCategoryTab copy$default(MallCategoryTab r17, String r18, String r19, String r20, String r21, String r22, String r23, String r24, Integer r25, Integer r26, TabIcon r27, MallCategoryTabAnimation r28, Integer r29, CustomizedMallBgSkin r30, String r31, Boolean r32, List r33, MallCategoryTabGuideIcon r34, MallCategoryTabBubble r35, boolean r36, int r37, Object r38) {
        if ((r37 & 1) == 0) goto L5;
        String r2 = r17.moduleId;
    L7:
        if ((r37 & 2) == 0) goto L9;
        String r3 = r17.componentId;
    L11:
        if ((r37 & 4) == 0) goto L13;
        String r4 = r17.tabId;
    L15:
        if ((r37 & 8) == 0) goto L17;
        String r5 = r17.dockedId;
    L19:
        if ((r37 & 16) == 0) goto L21;
        String r6 = r17.name;
    L23:
        if ((r37 & 32) == 0) goto L25;
        String r7 = r17.title;
    L27:
        if ((r37 & 64) == 0) goto L29;
        String r8 = r17.link;
    L31:
        if ((r37 & 128) == 0) goto L33;
        Integer r9 = r17.tabType;
    L35:
        if ((r37 & 256) == 0) goto L37;
        Integer r10 = r17.nativeContainerType;
    L39:
        if ((r37 & 512) == 0) goto L41;
        TabIcon r11 = r17.iconConf;
    L43:
        if ((r37 & 1024) == 0) goto L45;
        MallCategoryTabAnimation r12 = r17.animation;
    L47:
        if ((r37 & 2048) == 0) goto L49;
        Integer r13 = r17.tabContainerType;
    L51:
        if ((r37 & 4096) == 0) goto L53;
        CustomizedMallBgSkin r14 = r17.customizedMallBgSkin;
    L55:
        if ((r37 & 8192) == 0) goto L57;
        String r15 = r17.btmCode;
    L58:
        String r39 = r15;
        if ((r37 & 16384) == 0) goto L61;
        Boolean r16 = r17.pageDisableRefresh;
    L62:
        Boolean r310 = r16;
        if ((r37 & 32768) == 0) goto L65;
        List r110 = r17.supportResource;
    L66:
        List r311 = r110;
        if ((r37 & 65536) == 0) goto L69;
        MallCategoryTabGuideIcon r111 = r17.guideIcon;
    L70:
        MallCategoryTabGuideIcon r312 = r111;
        if ((r37 & 131072) == 0) goto L73;
        MallCategoryTabBubble r112 = r17.guide;
    L75:
        if ((r37 & 262144) == 0) goto L77;
        boolean r1 = r17.isCacheData;
    L79:
        return r17.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r39, r310, r311, r312, r112, r1);
    L77:
        r1 = r36;
        goto L79
    L73:
        r112 = r35;
        goto L75
    L69:
        r111 = r34;
        goto L70
    L65:
        r110 = r33;
        goto L66
    L61:
        r16 = r32;
        goto L62
    L57:
        r15 = r31;
        goto L58
    L53:
        r14 = r30;
        goto L55
    L49:
        r13 = r29;
        goto L51
    L45:
        r12 = r28;
        goto L47
    L41:
        r11 = r27;
        goto L43
    L37:
        r10 = r26;
        goto L39
    L33:
        r9 = r25;
        goto L35
    L29:
        r8 = r24;
        goto L31
    L25:
        r7 = r23;
        goto L27
    L21:
        r6 = r22;
        goto L23
    L17:
        r5 = r21;
        goto L19
    L13:
        r4 = r20;
        goto L15
    L9:
        r3 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }

    public final String component1() {
        return this.moduleId;
    }

    public final TabIcon component10() {
        return this.iconConf;
    }

    public final MallCategoryTabAnimation component11() {
        return this.animation;
    }

    public final Integer component12() {
        return this.tabContainerType;
    }

    public final CustomizedMallBgSkin component13() {
        return this.customizedMallBgSkin;
    }

    public final String component14() {
        return this.btmCode;
    }

    public final Boolean component15() {
        return this.pageDisableRefresh;
    }

    public final List<Integer> component16() {
        return this.supportResource;
    }

    public final MallCategoryTabGuideIcon component17() {
        return this.guideIcon;
    }

    public final MallCategoryTabBubble component18() {
        return this.guide;
    }

    public final boolean component19() {
        return this.isCacheData;
    }

    public final String component2() {
        return this.componentId;
    }

    public final String component3() {
        return this.tabId;
    }

    public final String component4() {
        return this.dockedId;
    }

    public final String component5() {
        return this.name;
    }

    public final String component6() {
        return this.title;
    }

    public final String component7() {
        return this.link;
    }

    public final Integer component8() {
        return this.tabType;
    }

    public final Integer component9() {
        return this.nativeContainerType;
    }

    public final MallCategoryTab copy(String r22, String r23, String r24, String r25, String r26, String r27, String r28, Integer r29, Integer r30, TabIcon r31, MallCategoryTabAnimation r32, Integer r33, CustomizedMallBgSkin r34, String r35, Boolean r36, List<Integer> r37, MallCategoryTabGuideIcon r38, MallCategoryTabBubble r39, boolean r40) {
        return new MallCategoryTab(r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof MallCategoryTab) == false) goto L44;
        MallCategoryTab r4 = (MallCategoryTab) r3;
        if (Intrinsics.areEqual(this.moduleId, r4.moduleId) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.componentId, r4.componentId) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.tabId, r4.tabId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.dockedId, r4.dockedId) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.name, r4.name) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.title, r4.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.link, r4.link) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.tabType, r4.tabType) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.nativeContainerType, r4.nativeContainerType) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.iconConf, r4.iconConf) == true) goto L26;
        return false;
    L26:
        if (Intrinsics.areEqual(this.animation, r4.animation) == true) goto L28;
        return false;
    L28:
        if (Intrinsics.areEqual(this.tabContainerType, r4.tabContainerType) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.customizedMallBgSkin, r4.customizedMallBgSkin) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.btmCode, r4.btmCode) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.pageDisableRefresh, r4.pageDisableRefresh) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.supportResource, r4.supportResource) == true) goto L38;
        return false;
    L38:
        if (Intrinsics.areEqual(this.guideIcon, r4.guideIcon) == true) goto L40;
        return false;
    L40:
        if (Intrinsics.areEqual(this.guide, r4.guide) == true) goto L42;
        return false;
    L42:
        if (this.isCacheData == r4.isCacheData) goto L67;
        return false;
    L67:
        return true;
    L44:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v38, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v6 */
    public int hashCode() {
        String r0 = this.moduleId;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.componentId;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        String r7 = this.tabId;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        String r10 = this.dockedId;
        if (r10 == null) goto L17;
        int r11 = r10.hashCode();
    L18:
        int r12 = (r9 + r11) * 31;
        String r13 = this.name;
        if (r13 == null) goto L21;
        int r14 = r13.hashCode();
    L22:
        int r15 = (r12 + r14) * 31;
        String r16 = this.title;
        if (r16 == null) goto L25;
        int r17 = r16.hashCode();
    L26:
        int r18 = (r15 + r17) * 31;
        String r19 = this.link;
        if (r19 == null) goto L29;
        int r20 = r19.hashCode();
    L30:
        int r21 = (r18 + r20) * 31;
        Integer r22 = this.tabType;
        if (r22 == null) goto L33;
        int r23 = r22.hashCode();
    L34:
        int r24 = (r21 + r23) * 31;
        Integer r25 = this.nativeContainerType;
        if (r25 == null) goto L37;
        int r26 = r25.hashCode();
    L38:
        int r27 = (r24 + r26) * 31;
        TabIcon r28 = this.iconConf;
        if (r28 == null) goto L41;
        int r29 = r28.hashCode();
    L42:
        int r30 = (r27 + r29) * 31;
        MallCategoryTabAnimation r31 = this.animation;
        if (r31 == null) goto L45;
        int r32 = r31.hashCode();
    L46:
        int r33 = (r30 + r32) * 31;
        Integer r34 = this.tabContainerType;
        if (r34 == null) goto L49;
        int r35 = r34.hashCode();
    L50:
        int r36 = (r33 + r35) * 31;
        CustomizedMallBgSkin r37 = this.customizedMallBgSkin;
        if (r37 == null) goto L53;
        int r38 = r37.hashCode();
    L54:
        int r39 = (r36 + r38) * 31;
        String r40 = this.btmCode;
        if (r40 == null) goto L57;
        int r41 = r40.hashCode();
    L58:
        int r42 = (r39 + r41) * 31;
        Boolean r43 = this.pageDisableRefresh;
        if (r43 == null) goto L61;
        int r44 = r43.hashCode();
    L62:
        int r45 = (r42 + r44) * 31;
        List<Integer> r46 = this.supportResource;
        if (r46 == null) goto L65;
        int r47 = r46.hashCode();
    L66:
        int r48 = (r45 + r47) * 31;
        MallCategoryTabGuideIcon r49 = this.guideIcon;
        if (r49 == null) goto L69;
        int r50 = r49.hashCode();
    L70:
        int r51 = (r48 + r50) * 31;
        MallCategoryTabBubble r52 = this.guide;
        if (r52 == null) goto L73;
        r1 = r52.hashCode();
    L73:
        int r53 = (r51 + r1) * 31;
        boolean r54 = this.isCacheData;
        ?? r55 = r54;
        if (r54 == false) goto L77;
        r55 = 1;
    L77:
        return r53 + r55;
    L69:
        r50 = 0;
        goto L70
    L65:
        r47 = 0;
        goto L66
    L61:
        r44 = 0;
        goto L62
    L57:
        r41 = 0;
        goto L58
    L53:
        r38 = 0;
        goto L54
    L49:
        r35 = 0;
        goto L50
    L45:
        r32 = 0;
        goto L46
    L41:
        r29 = 0;
        goto L42
    L37:
        r26 = 0;
        goto L38
    L33:
        r23 = 0;
        goto L34
    L29:
        r20 = 0;
        goto L30
    L25:
        r17 = 0;
        goto L26
    L21:
        r14 = 0;
        goto L22
    L17:
        r11 = 0;
        goto L18
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "MallCategoryTab(moduleId=" + this.moduleId + ", componentId=" + this.componentId + ", tabId=" + this.tabId + ", dockedId=" + this.dockedId + ", name=" + this.name + ", title=" + this.title + ", link=" + this.link + ", tabType=" + this.tabType + ", nativeContainerType=" + this.nativeContainerType + ", iconConf=" + this.iconConf + ", animation=" + this.animation + ", tabContainerType=" + this.tabContainerType + ", customizedMallBgSkin=" + this.customizedMallBgSkin + ", btmCode=" + this.btmCode + ", pageDisableRefresh=" + this.pageDisableRefresh + ", supportResource=" + this.supportResource + ", guideIcon=" + this.guideIcon + ", guide=" + this.guide + ", isCacheData=" + this.isCacheData + ")";
    }

    public final MallCategoryTabAnimation getAnimation() {
        return this.animation;
    }

    public final String getBtmCode() {
        return this.btmCode;
    }

    public final String getComponentId() {
        return this.componentId;
    }

    public final CustomizedMallBgSkin getCustomizedMallBgSkin() {
        return this.customizedMallBgSkin;
    }

    public final String getDockedId() {
        return this.dockedId;
    }

    public final MallCategoryTabBubble getGuide() {
        return this.guide;
    }

    public final MallCategoryTabGuideIcon getGuideIcon() {
        return this.guideIcon;
    }

    public final TabIcon getIconConf() {
        return this.iconConf;
    }

    public final String getLink() {
        return this.link;
    }

    public final String getModuleId() {
        return this.moduleId;
    }

    public final String getName() {
        return this.name;
    }

    public final Integer getNativeContainerType() {
        return this.nativeContainerType;
    }

    public final Boolean getPageDisableRefresh() {
        return this.pageDisableRefresh;
    }

    public final List<Integer> getSupportResource() {
        return this.supportResource;
    }

    public final Integer getTabContainerType() {
        return this.tabContainerType;
    }

    public final String getTabId() {
        return this.tabId;
    }

    public final Integer getTabType() {
        return this.tabType;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isCacheData() {
        return this.isCacheData;
    }

    public final void setCacheData(boolean r1) {
        this.isCacheData = r1;
    }

    public MallCategoryTab(String r3, String r4, String r5, String r6, String r7, String r8, String r9, Integer r10, Integer r11, TabIcon r12, MallCategoryTabAnimation r13, Integer r14, CustomizedMallBgSkin r15, String r16, Boolean r17, List<Integer> r18, MallCategoryTabGuideIcon r19, MallCategoryTabBubble r20, boolean r21) {
        this.moduleId = r3;
        this.componentId = r4;
        this.tabId = r5;
        this.dockedId = r6;
        this.name = r7;
        this.title = r8;
        this.link = r9;
        this.tabType = r10;
        this.nativeContainerType = r11;
        this.iconConf = r12;
        this.animation = r13;
        this.tabContainerType = r14;
        this.customizedMallBgSkin = r15;
        this.btmCode = r16;
        this.pageDisableRefresh = r17;
        this.supportResource = r18;
        this.guideIcon = r19;
        this.guide = r20;
        this.isCacheData = r21;
    }

    public /* synthetic */ MallCategoryTab(String r21, String r22, String r23, String r24, String r25, String r26, String r27, Integer r28, Integer r29, TabIcon r30, MallCategoryTabAnimation r31, Integer r32, CustomizedMallBgSkin r33, String r34, Boolean r35, List r36, MallCategoryTabGuideIcon r37, MallCategoryTabBubble r38, boolean r39, int r40, DefaultConstructorMarker r41) {
        if ((r40 & 1) == 0) goto L5;
        String r1 = null;
    L7:
        if ((r40 & 2) == 0) goto L9;
        String r3 = null;
    L11:
        if ((r40 & 4) == 0) goto L13;
        String r4 = null;
    L15:
        if ((r40 & 8) == 0) goto L17;
        String r5 = null;
    L19:
        if ((r40 & 16) == 0) goto L21;
        String r6 = null;
    L23:
        if ((r40 & 32) == 0) goto L25;
        String r7 = null;
    L27:
        if ((r40 & 64) == 0) goto L29;
        String r8 = null;
    L31:
        if ((r40 & 128) == 0) goto L33;
        Integer r9 = null;
    L35:
        if ((r40 & 256) == 0) goto L37;
        Integer r10 = null;
    L39:
        if ((r40 & 512) == 0) goto L41;
        TabIcon r11 = null;
    L43:
        if ((r40 & 1024) == 0) goto L45;
        MallCategoryTabAnimation r12 = null;
    L47:
        if ((r40 & 2048) == 0) goto L49;
        Integer r13 = null;
    L51:
        if ((r40 & 4096) == 0) goto L53;
        CustomizedMallBgSkin r14 = null;
    L55:
        if ((r40 & 8192) == 0) goto L57;
        String r15 = null;
    L59:
        if ((r40 & 16384) == 0) goto L61;
        Boolean r2 = null;
    L63:
        if ((r40 & 32768) == 0) goto L65;
        List r16 = null;
    L67:
        if ((r40 & 65536) == 0) goto L69;
        MallCategoryTabGuideIcon r17 = null;
    L71:
        if ((r40 & 131072) == 0) goto L73;
        MallCategoryTabBubble r18 = null;
    L75:
        if ((r40 & 262144) == 0) goto L77;
        boolean r0 = false;
    L78:
        this(r1, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r2, r16, r17, r18, r0);
        return;
    L77:
        r0 = r39;
        goto L78
    L73:
        r18 = r38;
        goto L75
    L69:
        r17 = r37;
        goto L71
    L65:
        r16 = r36;
        goto L67
    L61:
        r2 = r35;
        goto L63
    L57:
        r15 = r34;
        goto L59
    L53:
        r14 = r33;
        goto L55
    L49:
        r13 = r32;
        goto L51
    L45:
        r12 = r31;
        goto L47
    L41:
        r11 = r30;
        goto L43
    L37:
        r10 = r29;
        goto L39
    L33:
        r9 = r28;
        goto L35
    L29:
        r8 = r27;
        goto L31
    L25:
        r7 = r26;
        goto L27
    L21:
        r6 = r25;
        goto L23
    L17:
        r5 = r24;
        goto L19
    L13:
        r4 = r23;
        goto L15
    L9:
        r3 = r22;
        goto L11
    L5:
        r1 = r21;
        goto L7
    }
}
