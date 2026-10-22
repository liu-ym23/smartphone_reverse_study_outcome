package com.ss.android.ugc.aweme.discover.model.commodity.select;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.google.gson.annotations.SerializedName;
import com.obric.miniapp.alarm.AccountType;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u0000 J2\u00020\u0001:\u0001JB\u0007¢\u0006\u0004\bH\u0010IJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J \u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u0002J\u001e\u0010\u000e\u001a\u00020\u00042\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\bR\"\u0010\u0013\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR0\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020!\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R0\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020(\u0018\u00010 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010#\u001a\u0004\b*\u0010%\"\u0004\b+\u0010'R$\u0010-\u001a\u0004\u0018\u00010,8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R$\u00103\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0014\u001a\u0004\b4\u0010\u0016\"\u0004\b5\u0010\u0018R$\u0010=\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010D\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b>\u0010?\u001a\u0004\b@\u0010A\"\u0004\bB\u0010CR\"\u0010F\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u0010?\u001a\u0004\bF\u0010A\"\u0004\bG\u0010C¨\u0006K"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectInfo;", "Ljava/io/Serializable;", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectStatusHelper;", "selectStatusHelper", "", "injectData", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderItem;", "renderItem", "", "statusPath", "recursiveInject", "", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderLine;", "changedRenderLines", "updateChangedRenderLines", "replaceFilterComponent", "componentId", "", "hasComponentData", "dataType", "Ljava/lang/String;", "getDataType", "()Ljava/lang/String;", "setDataType", "(Ljava/lang/String;)V", "", "renderInfo", "Ljava/util/List;", "getRenderInfo", "()Ljava/util/List;", "setRenderInfo", "(Ljava/util/List;)V", "", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/BusinessItem;", "businessInfo", "Ljava/util/Map;", "getBusinessInfo", "()Ljava/util/Map;", "setBusinessInfo", "(Ljava/util/Map;)V", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/StyleItem;", "styleInfo", "getStyleInfo", "setStyleInfo", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/WordInfo;", "wordInfo", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/WordInfo;", "getWordInfo", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/select/WordInfo;", "setWordInfo", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/select/WordInfo;)V", "passThrough", "getPassThrough", "setPassThrough", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/CardTitle;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/CardTitle;", "getCardTitle", "()Lcom/ss/android/ugc/aweme/discover/model/commodity/select/CardTitle;", "setCardTitle", "(Lcom/ss/android/ugc/aweme/discover/model/commodity/select/CardTitle;)V", "cardTitle", "b", "Z", "getShowSmallHBar", "()Z", "setShowSmallHBar", "(Z)V", "showSmallHBar", "c", "isPreChunkData", "setPreChunkData", "<init>", "()V", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SelectInfo implements Serializable {
    public static final String ALL = "all";
    public static final String BRIEF = "brief";
    public static final Companion Companion = null;
    public static final String PATCH = "patch";
    public static final String PLACEHOLDER = "place_holder";
    public static final String VAL = "VAL";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient CardTitle f450546a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public transient boolean f450547b;

    @SerializedName("business_info")
    private Map<String, BusinessItem> businessInfo;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public transient boolean f450548c;

    @SerializedName("data_type")
    private String dataType;

    @SerializedName("pass_through")
    private String passThrough;

    @SerializedName("render_info")
    private List<RenderLine> renderInfo;

    @SerializedName("style_info")
    private Map<String, StyleItem> styleInfo;

    @SerializedName("recommended_words_info")
    private WordInfo wordInfo;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectInfo$Companion;", "", "()V", AccountType.ALL, "", "BRIEF", "PATCH", "PLACEHOLDER", SelectInfo.VAL, "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        Companion = new Companion(0);
    }

    public SelectInfo() {
        this.dataType = "all";
    }

    public final Map<String, BusinessItem> getBusinessInfo() {
        return this.businessInfo;
    }

    public final CardTitle getCardTitle() {
        return this.f450546a;
    }

    public final String getDataType() {
        return this.dataType;
    }

    public final String getPassThrough() {
        return this.passThrough;
    }

    public final List<RenderLine> getRenderInfo() {
        return this.renderInfo;
    }

    public final boolean getShowSmallHBar() {
        return this.f450547b;
    }

    public final Map<String, StyleItem> getStyleInfo() {
        return this.styleInfo;
    }

    public final WordInfo getWordInfo() {
        return this.wordInfo;
    }

    public final boolean isPreChunkData() {
        return this.f450548c;
    }

    public final boolean hasComponentData(String r100) {
        Intrinsics.checkNotNullParameter(r100, "componentId");
        List<RenderLine> r101 = this.renderInfo;
        if (r101 == null) goto L20;
        Iterator<T> r102 = r101.iterator();
        int r103 = 0;
    L6:
        if (r102.hasNext() == false) goto L20;
        Object r104 = r102.next();
        int r105 = r103 + 1;
        if (r103 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        List<RenderItem> r106 = ((RenderLine) r104).getRenderItemList();
        if (r106 == null) goto L19;
        Iterator<T> r107 = r106.iterator();
    L14:
        if (r107.hasNext() == false) goto L19;
        if (Intrinsics.areEqual(((RenderItem) r107.next()).getComponentId(), r100) == false) goto L14;
        return true;
    L19:
        r103 = r105;
    L20:
        return false;
    }

    public final void injectData(SelectStatusHelper r110) {
        Intrinsics.checkNotNullParameter(r110, "selectStatusHelper");
        List<RenderLine> r100 = this.renderInfo;
        if (r100 != null) goto L5;
        return;
    L5:
        Intrinsics.checkNotNull(r100);
        int r101 = r100.size();
        int r102 = 0;
    L6:
        if (r102 >= r101) goto L22;
        List<RenderLine> r103 = this.renderInfo;
        Intrinsics.checkNotNull(r103);
        RenderLine r104 = (RenderLine) ListProtector.get(r103, r102);
        WordInfo r105 = this.wordInfo;
        if (r105 == null) goto L10;
        String r106 = r105.getQueryId();
    L11:
        r104.setQueryId(r106);
        WordInfo r107 = this.wordInfo;
        if (r107 == null) goto L14;
        String r108 = r107.getImprId();
    L15:
        r104.setImprId(r108);
        if (r104.getRenderItemList() == null) goto L21;
        List<RenderItem> r109 = r104.getRenderItemList();
        Intrinsics.checkNotNull(r109);
        int r111 = r109.size();
        int r112 = 0;
    L19:
        if (r112 >= r111) goto L21;
        List<RenderItem> r113 = r104.getRenderItemList();
        Intrinsics.checkNotNull(r113);
        RenderItem r114 = (RenderItem) ListProtector.get(r113, r112);
        r114.setFilterOptionRow(String.valueOf(r102));
        r114.setFilterOptionRank(String.valueOf(r112));
        recursiveInject(r114, null, r110);
        r112 = r112 + 1;
    L21:
        r102 = r102 + 1;
        goto L6
    L14:
        r108 = null;
        goto L15
    L10:
        r106 = null;
        goto L11
    }

    public final void setBusinessInfo(Map<String, BusinessItem> r100) {
        this.businessInfo = r100;
    }

    public final void setCardTitle(CardTitle r100) {
        this.f450546a = r100;
    }

    public final void setDataType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.dataType = r100;
    }

    public final void setPassThrough(String r100) {
        this.passThrough = r100;
    }

    public final void setPreChunkData(boolean r100) {
        this.f450548c = r100;
    }

    public final void setRenderInfo(List<RenderLine> r100) {
        this.renderInfo = r100;
    }

    public final void setShowSmallHBar(boolean r100) {
        this.f450547b = r100;
    }

    public final void setStyleInfo(Map<String, StyleItem> r100) {
        this.styleInfo = r100;
    }

    public final void setWordInfo(WordInfo r100) {
        this.wordInfo = r100;
    }

    public final void replaceFilterComponent(RenderItem r100, SelectStatusHelper r101) {
        Intrinsics.checkNotNullParameter(r100, "renderItem");
        Intrinsics.checkNotNullParameter(r101, "selectStatusHelper");
        recursiveInject(r100, null, r101);
    }

    public final void updateChangedRenderLines(Set<RenderLine> r100, SelectStatusHelper r101) {
        Intrinsics.checkNotNullParameter(r101, "selectStatusHelper");
        if (r100 == null) goto L13;
        Iterator<RenderLine> r102 = r100.iterator();
    L6:
        if (r102.hasNext() == false) goto L19;
        List<RenderItem> r103 = r102.next().getRenderItemList();
        if (r103 == null) goto L6;
        Iterator<RenderItem> r104 = r103.iterator();
    L11:
        if (r104.hasNext() == false) goto L6;
        recursiveInject(r104.next(), null, r101);
        goto L11
    L19:
        return;
    }

    public final void recursiveInject(RenderItem r210, String r211, SelectStatusHelper r212) {
        Intrinsics.checkNotNullParameter(r210, "renderItem");
        Intrinsics.checkNotNullParameter(r212, "selectStatusHelper");
        WordInfo r100 = this.wordInfo;
        if (r100 == null) goto L5;
        String r101 = r100.getImprId();
    L6:
        r210.setImprId(r101);
        WordInfo r102 = this.wordInfo;
        if (r102 == null) goto L9;
        String r103 = r102.getQueryId();
    L10:
        r210.setQueryId(r103);
        if (r210.getDataId() == null) goto L257;
        if (r211 != null) goto L14;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == false) goto L19;
        String r105 = r211 + '#' + r210.getDataId();
    L20:
        r210.setStatusPath(r105);
        Map<String, BusinessItem> r106 = this.businessInfo;
        Object r107 = "";
        if (r106 == null) goto L44;
        BusinessItem r108 = r106.get(r210.getDataId());
        if (r108 == null) goto L44;
        Set<RenderItem> r109 = r108.getRenderItemList();
        if (r109 == null) goto L44;
        Iterator<T> r110 = r109.iterator();
    L28:
        if (r110.hasNext() == false) goto L40;
        Object r111 = r110.next();
        RenderItem r112 = (RenderItem) r111;
        if (Intrinsics.areEqual(r112.getDataId(), r210.getDataId()) == false) goto L37;
        String r113 = r112.getTextType();
        if (r113 != null) goto L35;
        r113 = "";
    L35:
        if ((!Intrinsics.areEqual(r113, VAL)) == false) goto L37;
        boolean r114 = true;
    L38:
        if (r114 == false) goto L28;
    L41:
        RenderItem r115 = (RenderItem) r111;
        if (r115 == null) goto L44;
        r210.setStatusPath(r115.getStatusPath());
        Unit r116 = Unit.INSTANCE;
    L37:
        r114 = false;
        goto L38
    L40:
        r111 = null;
    L44:
        Map<String, BusinessItem> r117 = this.businessInfo;
        if (r117 == null) goto L49;
        BusinessItem r118 = r117.get(r210.getDataId());
        if (r118 == null) goto L49;
        r118.getRenderItemList().add(r210);
        r118.setNeedMutex(r210.getNeedMutex());
        r118.setText(r210.getText());
        r118.setStatusPath(r210.getStatusPath());
        r118.setTextType(r210.getTextType());
        r118.setComponentId(r210.getComponentId());
        Unit r119 = Unit.INSTANCE;
    L50:
        r210.setBusinessItem(r118);
        if (Intrinsics.areEqual(r210.isDefaultSelect(), Boolean.TRUE) == false) goto L53;
    L70:
        r212.getClass();
        Intrinsics.checkNotNullParameter(r210, "renderItem");
        if (r210.getChildrenComponent() == null) goto L73;
        SelectItemStatus r120 = new SelectListStatus();
    L74:
        Map<String, BusinessItem> r121 = r212.f450561b;
        if (r121 == null) goto L77;
        BusinessItem r122 = r121.get(r210.getDataId());
    L78:
        r120.setDataId(r210.getDataId());
        r120.setText(r210.getText());
        r120.setOptionType(r210.getComponentType());
        r120.setPostscriptText(r210.getPostscriptText());
        r120.setMutex(r210.getNeedMutex());
        r120.setStatusPath(r210.getStatusPath());
        r120.setTextType(r210.getTextType());
        r120.setSelectedParentText(r210.getSelectedParentText());
        if (r122 == null) goto L81;
        String r123 = r122.getType();
    L82:
        r120.setType(r123);
        if (r122 == null) goto L85;
        String r124 = r122.getLogText();
    L86:
        r120.setLogText(r124);
        if (r122 == null) goto L89;
        String r125 = r122.getConditionField();
    L90:
        r120.setConditionField(r125);
        if (r122 == null) goto L93;
        String r126 = r122.getConditionValue();
    L94:
        r120.setConditionValue(r126);
        if (r122 == null) goto L97;
        Long r127 = r122.getMinInterval();
    L98:
        r120.setMinInterval(r127);
        if (r122 == null) goto L101;
        Long r128 = r122.getMaxInterval();
    L102:
        r120.setMaxInterval(r128);
        if (r122 == null) goto L105;
        String r129 = r122.getExtraData();
    L106:
        r120.setExtraData(r129);
        List<RenderItem> r130 = r210.getChildrenComponent();
        if (r130 == null) goto L116;
        Iterator<RenderItem> r131 = r130.iterator();
        int r132 = 0;
    L110:
        if (r131.hasNext() == false) goto L115;
        if (Intrinsics.areEqual(r131.next().getDataId(), r210.getDataId()) == true) goto L117;
        r132 = r132 + 1;
    L117:
        r120.setOptionRank(Integer.valueOf(r132));
        r120.setEndTime(r210.getEndTime());
        RenderItem r133 = r210.getParentRenderItem();
        if (r133 == null) goto L129;
        List<RenderItem> r134 = r133.getChildrenComponent();
        if (r134 == null) goto L129;
        Iterator<RenderItem> r135 = r134.iterator();
        int r136 = 0;
    L123:
        if (r135.hasNext() == false) goto L128;
        if (Intrinsics.areEqual(r135.next().getDataId(), r210.getDataId()) == true) goto L130;
        r136 = r136 + 1;
    L130:
        r120.setPosition(Integer.valueOf(r136));
        r120.setComponentId(r210.getComponentId());
        if (r120.getText() != null) goto L183;
        if (r122 == null) goto L134;
        Long r137 = r122.getMinInterval();
    L135:
        if (r137 != null) goto L141;
        if (r122 == null) goto L138;
        Long r138 = r122.getMaxInterval();
    L139:
        if (r138 == null) goto L183;
    L138:
        r138 = null;
    L141:
        if (r122 == null) goto L145;
        Long r139 = r122.getMinInterval();
        if (r139 == null) goto L145;
        Float r140 = Float.valueOf(r139.longValue() / 100);
    L146:
        if (r122 == null) goto L150;
        Long r141 = r122.getMaxInterval();
        if (r141 == null) goto L150;
        Float r142 = Float.valueOf(r141.longValue() / 100);
    L151:
        if (r140 == null) goto L153;
        Integer r143 = Integer.valueOf((int) (r140.floatValue() * 100));
    L154:
        if (r142 == null) goto L156;
        Integer r144 = Integer.valueOf((int) (r142.floatValue() * 100));
    L157:
        StringBuilder r145 = new StringBuilder();
        if (r143 == null) goto L160;
        int r146 = r143.intValue();
    L161:
        r145.append(r146);
        r145.append('-');
        if (r144 != null) goto L164;
        Object r147 = "";
    L165:
        r145.append(r147);
        r120.setConditionField(r145.toString());
        StringBuilder r148 = new StringBuilder();
        if (r143 == null) goto L168;
        int r149 = r143.intValue();
    L169:
        r148.append(r149);
        r148.append('-');
        if (r144 == null) goto L173;
        r107 = r144;
    L173:
        r148.append(r107);
        r120.setLogText(r148.toString());
        if (r140 != null) goto L177;
        if (r142 == null) goto L177;
        String r150 = SelectStatusHelper.a(r142) + "以下";
    L181:
        r120.setText(r150);
    L198:
        List<RenderItem> r151 = r210.getChildrenComponent();
        if (r151 != null) goto L201;
    L204:
        boolean r152 = true;
    L205:
        if (r152 == true) goto L207;
    L209:
        int r153 = 0;
    L210:
        r120.setManualSelect(r153);
        if (r122 == null) goto L213;
        Map<String, Object> r154 = r122.getLogInfo();
    L214:
        r120.setLogInfo(r154);
        if (r122 == null) goto L217;
        Map<String, Object> r155 = r122.getExtraInfo();
    L218:
        r120.setExtraInfo(r155);
        r210.setCurrentStatus(r120);
        SelectItemStatus r156 = r210.getCurrentStatus();
        int r157 = r210.getPriceSortType();
        if (r157 != 1) goto L221;
        String r158 = r210.getDataId() + "_asc";
    L225:
        Map<String, BusinessItem> r159 = r212.f450561b;
        if (r159 == null) goto L241;
        BusinessItem r160 = r159.get(r158);
        if (r160 == null) goto L241;
        if (r156 == null) goto L231;
        r156.setType(r160.getType());
    L231:
        if (r156 == null) goto L233;
        r156.setLogText(r160.getLogText());
    L233:
        if (r156 == null) goto L235;
        r156.setConditionField(r160.getConditionField());
    L235:
        if (r156 == null) goto L237;
        r156.setConditionValue(r160.getConditionValue());
    L237:
        if (r156 == null) goto L239;
        r156.setMinInterval(r160.getMinInterval());
    L239:
        if (r156 == null) goto L241;
        r156.setMaxInterval(r160.getMaxInterval());
    L241:
        String r161 = r210.getStatusPath();
        SelectItemStatus r162 = r210.getCurrentStatus();
        Objects.toString(r162);
        if (r161 != null) goto L244;
    L247:
        boolean r163 = true;
    L248:
        if (r163 == true) goto L252;
        List r164 = StringsKt.split$default(r161, new String[]{"#"}, false, 0, 6, null);
        if (r164.isEmpty() == true) goto L252;
        StyleItem r165 = null;
        if (r212.c(CollectionsKt.toMutableList(r164), null, r162, false) == false) goto L259;
        throw null;
    L259:
        if (r210.getStyleId() == null) goto L266;
        Map<String, StyleItem> r166 = this.styleInfo;
        if (r166 == null) goto L263;
        StyleItem r167 = r166.get(r210.getStyleId());
    L264:
        r210.setStyleItem(r167);
        goto L266
    L263:
        r167 = r165;
    L266:
        if (r210.getChildrenComponent() == null) goto L282;
        List<RenderItem> r168 = r210.getChildrenComponent();
        Intrinsics.checkNotNull(r168);
        int r169 = r168.size();
        int r170 = 0;
    L268:
        if (r170 >= r169) goto L295;
        List<RenderItem> r171 = r210.getChildrenComponent();
        Intrinsics.checkNotNull(r171);
        RenderItem r172 = (RenderItem) ListProtector.get(r171, r170);
        r172.setParentRenderItem(r210);
        r172.setFilterOptionRow(r210.getFilterOptionRow());
        if (r210.getDataId() != null) goto L276;
        String r173 = r210.getComponentId();
        if (r173 == null) goto L276;
        if (r173.equals("c_select_board") != true) goto L276;
        String r174 = String.valueOf(r170);
    L277:
        r172.setFilterOptionRank(r174);
        if (r210.getStatusPath() == null) goto L280;
        String r175 = r210.getStatusPath();
    L281:
        recursiveInject(r172, r175, r212);
        r170 = r170 + 1;
        goto L268
    L280:
        r175 = r211;
    L276:
        r174 = r210.getFilterOptionRank();
        goto L277
    L295:
        return;
    L282:
        return;
    L252:
        r165 = null;
        goto L259
    L244:
        if (r161.length() == 0) goto L247;
        r163 = false;
        goto L248
    L221:
        if (r157 != 2) goto L241;
        r158 = r210.getDataId() + "_desc";
        goto L225
    L217:
        r155 = null;
        goto L218
    L213:
        r154 = null;
        goto L214
    L207:
        if (r210.isManualSelected() == false) goto L209;
        r153 = 1;
        goto L210
    L201:
        if (r151.isEmpty() == true) goto L204;
        r152 = false;
    L177:
        if (r140 == null) goto L180;
        if (r142 != null) goto L180;
        r150 = SelectStatusHelper.a(r140) + "以上";
    L180:
        r150 = SelectStatusHelper.a(r140) + '-' + SelectStatusHelper.a(r142);
        goto L181
    L168:
        r149 = 0;
        goto L169
    L164:
        r147 = r144;
        goto L165
    L160:
        r146 = 0;
        goto L161
    L156:
        r144 = null;
        goto L157
    L153:
        r143 = null;
    L150:
        r142 = null;
    L145:
        r140 = null;
        goto L146
    L134:
        r137 = null;
    L183:
        if (r120.getText() != null) goto L198;
        if (r122 == null) goto L186;
        String r176 = r122.getLogText();
    L187:
        if (r176 != null) goto L189;
    L192:
        boolean r177 = true;
    L193:
        if (r177 == true) goto L198;
        if (r122 == null) goto L196;
        String r178 = r122.getLogText();
    L197:
        r120.setText(r178);
        goto L198
    L196:
        r178 = null;
        goto L197
    L189:
        if (r176.length() == 0) goto L192;
        r177 = false;
        goto L193
    L186:
        r176 = null;
        goto L187
    L128:
        r136 = -1;
    L129:
        r136 = 0;
        goto L130
    L115:
        r132 = -1;
        goto L117
    L116:
        r132 = 0;
        goto L117
    L105:
        r129 = null;
        goto L106
    L101:
        r128 = null;
        goto L102
    L97:
        r127 = null;
        goto L98
    L93:
        r126 = null;
        goto L94
    L89:
        r125 = null;
        goto L90
    L85:
        r124 = null;
        goto L86
    L81:
        r123 = null;
        goto L82
    L77:
        r122 = null;
        goto L78
    L73:
        r120 = new SelectItemStatus();
        goto L74
    L53:
        if (r210.getPriceSortType() == 1) goto L70;
        if (r210.getPriceSortType() == 2) goto L70;
        String r179 = r210.getStatusPath();
        r212.getClass();
        if (r179 != null) goto L60;
    L63:
        boolean r180 = true;
    L64:
        if (r180 == false) goto L67;
    L68:
        r210.setCurrentStatus(null);
        goto L257
    L67:
        if (StringsKt.split$default(r179, new String[]{"#"}, false, 0, 6, null).isEmpty() == true) goto L68;
        throw null;
    L60:
        if (r179.length() == 0) goto L63;
        r180 = false;
    L49:
        r118 = null;
        goto L50
    L19:
        r105 = r210.getDataId();
        goto L20
    L14:
        if (r211.length() <= 0) goto L16;
        r104 = true;
    L257:
        r165 = null;
        goto L259
    L9:
        r103 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }
}
