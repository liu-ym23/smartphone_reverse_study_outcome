package com.ss.android.ugc.aweme.discover.model.commodity.select;

import com.bytedance.android.livesdkapi.depend.model.LocalSubStickerItem;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastFloatProtector;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\fJ.\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00042\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectStatusHelper;", "", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectInfo;", "data", "", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/RenderLine;", "changedRenderLines", "", "", "changedDataIds", "", "update", "Companion", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SelectStatusHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<RenderLine> f450560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Map<String, BusinessItem> f450561b;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0010\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/commodity/select/SelectStatusHelper$Companion;", "", "()V", "BY_ADDRESS", "", "BY_BANNER", "BY_CALENDER", "BY_CATEGORY", "BY_CITY", "BY_HOTEL_FILTER", "BY_RANK", "BY_SCOPE", "BY_SPECIFY_ADDRESS", "BY_SPEED", LocalSubStickerItem.BEAUTY_TYPE_FILTER, "HAS_DELIVERY", "HAS_GOODS", "ROOT_DATA_ID", "SORT", "TAG", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(int r100) {
            this();
        }
    }

    static {
        new Companion(0);
    }

    public static String a(Float r100) {
        if (r100 != null) goto L10;
        return "";
    L10:
        String r101 = String.valueOf(r100.floatValue());     // Catch: Exception -> L9
        float r102 = CastFloatProtector.parseFloat(r101);     // Catch: Exception -> L9
        if ((r102 % 1) != 0.0f) goto L12;
        return String.valueOf((int) r102);
    L12:
        return r101;
    L9:
        return "";
    }

    public static void d(SelectItemStatus r100) {
        if ((r100 instanceof SelectListStatus) == false) goto L9;
        Iterator<T> r101 = ((SelectListStatus) r100).getSubSelectItemList().iterator();
        if (r101.hasNext() == false) goto L9;
        d((SelectItemStatus) r101.next());
        throw null;
    L9:
        String r102 = r100.getTextType();
        if (r102 != null) goto L13;
        r102 = "";
    L13:
        if (r100.getDataId() != null) goto L15;
        r100.getMutex();
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L15:
        if (Intrinsics.areEqual(r102, SelectInfo.VAL) == false) goto L20;
        r100.getStatusPath();
        throw null;
    L20:
        throw null;
    }

    public final void b(List<String> r110, SelectListStatus r111, SelectItemStatus r112) {
        Intrinsics.checkNotNullParameter(r110, "dataIdList");
        Intrinsics.checkNotNullParameter(r111, "parentSelectList");
        Intrinsics.checkNotNullParameter(r112, "selectItemStatus");
        if (r110.isEmpty() == false) goto L5;
        return;
    L5:
        int r100 = 0;
        String r101 = (String) ListProtector.remove(r110, 0);
        if (r110.isEmpty() == false) goto L8;
        SelectItemStatus r102 = r112;
    L157:
        r102.setParentSelectList(r111);
        r111.getSubSelectItemList().add(r102);
        if (r102.getMutex() == null) goto L160;
        throw null;
    L160:
        if ((r102 instanceof SelectListStatus) == false) goto L176;
        b(r110, (SelectListStatus) r102, r112);
        return;
    L176:
        return;
    L8:
        boolean r103 = !r110.isEmpty();
        Intrinsics.checkNotNullParameter(r101, "dataId");
        Map<String, BusinessItem> r104 = this.f450561b;
        if (r104 == null) goto L11;
        BusinessItem r105 = r104.get(r101);
    L12:
        if (r103 == false) goto L14;
        r102 = new SelectListStatus();
    L15:
        r102.setDataId(r101);
        if (r105 == null) goto L18;
        String r106 = r105.getText();
    L19:
        r102.setText(r106);
        if (r105 == null) goto L22;
        String r107 = r105.getNeedMutex();
    L23:
        r102.setMutex(r107);
        if (r105 == null) goto L26;
        String r108 = r105.getStatusPath();
    L27:
        r102.setStatusPath(r108);
        if (r105 == null) goto L30;
        String r109 = r105.getTextType();
    L31:
        r102.setTextType(r109);
        if (r105 == null) goto L34;
        String r113 = r105.getType();
    L35:
        r102.setType(r113);
        if (r105 == null) goto L38;
        String r114 = r105.getLogText();
    L39:
        r102.setLogText(r114);
        if (r105 == null) goto L42;
        String r115 = r105.getConditionField();
    L43:
        r102.setConditionField(r115);
        if (r105 == null) goto L46;
        String r116 = r105.getConditionValue();
    L47:
        r102.setConditionValue(r116);
        if (r105 == null) goto L50;
        Long r117 = r105.getMinInterval();
    L51:
        r102.setMinInterval(r117);
        if (r105 == null) goto L54;
        Long r118 = r105.getMaxInterval();
    L55:
        r102.setMaxInterval(r118);
        if (r105 == null) goto L58;
        String r119 = r105.getExtraData();
    L59:
        r102.setExtraData(r119);
        if (r105 == null) goto L62;
        Map<String, Object> r120 = r105.getExtraInfo();
    L63:
        r102.setExtraInfo(r120);
        if (r105 == null) goto L66;
        Map<String, Object> r121 = r105.getLogInfo();
    L67:
        r102.setLogInfo(r121);
        Intrinsics.checkNotNullParameter(r101, "dataId");
        List<RenderLine> r122 = this.f450560a;
        if (r122 == null) goto L88;
        Iterator<T> r123 = r122.iterator();
    L71:
        if (r123.hasNext() == false) goto L88;
        List<RenderItem> r124 = ((RenderLine) r123.next()).getRenderItemList();
        if (r124 == null) goto L71;
        Iterator<T> r125 = r124.iterator();
    L76:
        if (r125.hasNext() == false) goto L71;
        RenderItem r126 = (RenderItem) r125.next();
        if (Intrinsics.areEqual(r101, r126.getDataId()) == true) goto L79;
        List<RenderItem> r127 = r126.getChildrenComponent();
        if (r127 == null) goto L76;
        Iterator<T> r128 = r127.iterator();
    L84:
        if (r128.hasNext() == false) goto L76;
        RenderItem r129 = (RenderItem) r128.next();
        if (Intrinsics.areEqual(r101, r129.getDataId()) == false) goto L84;
        String r130 = r129.getEndTime();
    L89:
        r102.setEndTime(r130);
        if (r105 == null) goto L92;
        String r131 = r105.getComponentId();
    L93:
        r102.setComponentId(r131);
        if (r102.getText() != null) goto L144;
        if (r105 == null) goto L97;
        Long r132 = r105.getMinInterval();
    L98:
        if (r132 != null) goto L104;
        if (r105 == null) goto L101;
        Long r133 = r105.getMaxInterval();
    L102:
        if (r133 == null) goto L144;
    L101:
        r133 = null;
    L104:
        if (r105 == null) goto L108;
        Long r134 = r105.getMinInterval();
        if (r134 == null) goto L108;
        Float r135 = Float.valueOf(r134.longValue() / 100);
    L109:
        if (r105 == null) goto L113;
        Long r136 = r105.getMaxInterval();
        if (r136 == null) goto L113;
        Float r137 = Float.valueOf(r136.longValue() / 100);
    L114:
        if (r135 == null) goto L116;
        Integer r138 = Integer.valueOf((int) (r135.floatValue() * 100));
    L117:
        if (r137 == null) goto L119;
        Object r139 = Integer.valueOf((int) (r137.floatValue() * 100));
    L120:
        StringBuilder r140 = new StringBuilder();
        if (r138 == null) goto L123;
        int r141 = r138.intValue();
    L124:
        r140.append(r141);
        r140.append('-');
        if (r139 != null) goto L127;
        Object r142 = "";
    L128:
        r140.append(r142);
        r102.setConditionField(r140.toString());
        StringBuilder r143 = new StringBuilder();
        if (r138 == null) goto L131;
        r100 = r138.intValue();
    L131:
        r143.append(r100);
        r143.append('-');
        if (r139 != null) goto L134;
        r139 = "";
    L134:
        r143.append(r139);
        r102.setLogText(r143.toString());
        if (r135 != null) goto L138;
        if (r137 == null) goto L138;
        String r144 = a(r137) + "以下";
    L142:
        r102.setText(r144);
    L138:
        if (r135 == null) goto L141;
        if (r137 != null) goto L141;
        r144 = a(r135) + "以上";
    L141:
        r144 = a(r135) + '-' + a(r137);
        goto L142
    L127:
        r142 = r139;
        goto L128
    L123:
        r141 = 0;
        goto L124
    L119:
        r139 = null;
        goto L120
    L116:
        r138 = null;
    L113:
        r137 = null;
    L108:
        r135 = null;
        goto L109
    L97:
        r132 = null;
    L144:
        if (r102.getText() != null) goto L157;
        if (r105 == null) goto L147;
        String r145 = r105.getText();
    L148:
        if (r145 != null) goto L150;
    L151:
        r100 = 1;
    L152:
        if (r100 != 0) goto L157;
        if (r105 == null) goto L155;
        String r146 = r105.getText();
    L156:
        r102.setText(r146);
        goto L157
    L155:
        r146 = null;
        goto L156
    L150:
        if (r145.length() != 0) goto L152;
    L147:
        r145 = null;
        goto L148
    L92:
        r131 = null;
        goto L93
    L79:
        r130 = r126.getEndTime();
    L88:
        r130 = null;
        goto L89
    L66:
        r121 = null;
        goto L67
    L62:
        r120 = null;
        goto L63
    L58:
        r119 = null;
        goto L59
    L54:
        r118 = null;
        goto L55
    L50:
        r117 = null;
        goto L51
    L46:
        r116 = null;
        goto L47
    L42:
        r115 = null;
        goto L43
    L38:
        r114 = null;
        goto L39
    L34:
        r113 = null;
        goto L35
    L30:
        r109 = null;
        goto L31
    L26:
        r108 = null;
        goto L27
    L22:
        r107 = null;
        goto L23
    L18:
        r106 = null;
        goto L19
    L14:
        r102 = new SelectItemStatus();
        goto L15
    L11:
        r105 = null;
        goto L12
    }

    public final void update(SelectInfo r100, Set<RenderLine> r101, List<String> r102) {
        Intrinsics.checkNotNullParameter(r100, "data");
        this.f450560a = r100.getRenderInfo();
        this.f450561b = r100.getBusinessInfo();
        r100.updateChangedRenderLines(r101, this);
        if (r101 == null) goto L17;
        Iterator<RenderLine> r103 = r101.iterator();
    L6:
        if (r103.hasNext() == false) goto L17;
        List<RenderItem> r104 = r103.next().getRenderItemList();
        if (r104 == null) goto L6;
        Iterator<RenderItem> r105 = r104.iterator();
    L11:
        if (r105.hasNext() == false) goto L6;
        RenderItem r106 = r105.next();
        if (Intrinsics.areEqual(r106.getStyleId(), "quick_filter_style") == false) goto L11;
        r106.getNeedMutex();
        throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
    L17:
        if (r102 != null) goto L20;
        return;
    L20:
        throw null;
    }

    public final boolean c(List<String> r100, SelectListStatus r101, SelectItemStatus r102, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "dataIdList");
        Intrinsics.checkNotNullParameter(r101, "parentSelectList");
        if (r100.isEmpty() == false) goto L5;
        return false;
    L5:
        String r103 = (String) ListProtector.get(r100, 0);
        Iterator<T> r104 = r101.getSubSelectItemList().iterator();
    L7:
        if (r104.hasNext() == false) goto L11;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((SelectItemStatus) r105).getDataId(), r103) == false) goto L7;
    L12:
        SelectItemStatus r106 = (SelectItemStatus) r105;
        if (r106 != null) goto L18;
        if (r102 == null) goto L17;
        b(r100, r101, r102);
        return true;
    L17:
        return false;
    L18:
        ListProtector.remove(r100, 0);
        if (r102 != null) goto L26;
        if (r100.isEmpty() == false) goto L26;
        Intrinsics.checkNotNullParameter(r106, "selectItemStatus");
        d(r106);
        throw null;
    L26:
        if ((!r100.isEmpty()) == true) goto L28;
        if (r102 != null) goto L34;
    L36:
        if (r102 == null) goto L40;
        if (r110 == false) goto L40;
        Objects.toString(r102.getExtraInfo());
        r106.setText(r102.getText());
        r106.setType(r102.getType());
        r106.setLogText(r102.getLogText());
        r106.setConditionField(r102.getConditionField());
        r106.setConditionValue(r102.getConditionValue());
        r106.setExtraData(r102.getExtraData());
        r106.setExtraInfo(r102.getExtraInfo());
        r106.setLogInfo(r102.getLogInfo());
        r106.setMutex(r102.getMutex());
    L40:
        if (r102 == null) goto L42;
        r102.getComponentId();
    L42:
        return false;
    L34:
        if ((!Intrinsics.areEqual(r102.getConditionField(), r106.getConditionField())) == false) goto L36;
        r101.getSubSelectItemList().remove(r106);
        r101.getSubSelectItemList().add(r102);
        r102.setParentSelectList(r101);
        goto L40
    L28:
        if ((r106 instanceof SelectListStatus) == true) goto L31;
        return false;
    L31:
        return c(r100, (SelectListStatus) r106, r102, false);
    L11:
        r105 = null;
        goto L12
    }
}
