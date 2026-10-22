package com.bytedance.ee.bear.bitable.card.view.cell.formgrid;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.bitable.common.widgets.HighlightModel;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridCellData;
import com.bytedance.ee.bear.bitable.infoarch.nativeview.grid.GridSetting;
import com.bytedance.ee.bear.bitable.m;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u001bH\u0002JX\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2H\b\u0002\u0010 \u001aB\u0012\u0004\u0012\u00020\u0017\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\"0\u000bj\b\u0012\u0004\u0012\u00020\"`\r\u0018\u00010!j \u0012\u0004\u0012\u00020\u0017\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\"0\u000bj\b\u0012\u0004\u0012\u00020\"`\r\u0018\u0001`#R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR*\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000bj\b\u0012\u0004\u0012\u00020\f`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R*\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00020\u00130\u000bj\b\u0012\u0004\u0012\u00020\u0013`\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011¨\u0006$"}, d2 = {"Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/FormGridUIData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "addButton", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "getAddButton", "()Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "setAddButton", "(Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;)V", "fieldsHeader", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/FieldModel;", "Lkotlin/collections/ArrayList;", "getFieldsHeader", "()Ljava/util/ArrayList;", "setFieldsHeader", "(Ljava/util/ArrayList;)V", "records", "Lcom/bytedance/ee/bear/bitable/card/view/cell/formgrid/FormGridRecord;", "getRecords", "setRecords", "getRecordCount", "", "getFormGridSetting", "Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/grid/GridSetting;", "getWidth", "", "appendErrorMap", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "map", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FormGridUIData implements NonProguard {
    private SimpleItemModel addButton;
    private ArrayList<FieldModel> fieldsHeader;
    private ArrayList<FormGridRecord> records;

    private final int[] getWidth() {
        if (this.fieldsHeader.size() == 1) goto L5;
        ArrayList<FieldModel> r100 = this.fieldsHeader;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L8:
        if (r102.hasNext() == false) goto L15;
        Float r103 = ((FieldModel) r102.next()).getFieldWidth();
        if (r103 == null) goto L12;
        int r104 = (int) r103.floatValue();
    L13:
        r101.add(Integer.valueOf(n.d(r104)));
        goto L8
    L12:
        r104 = 0;
        goto L13
    L15:
        return CollectionsKt.toIntArray(r101);
    L5:
        return new int[]{-1};
    }

    public final GridSetting getFormGridSetting() {
        GridSetting r100 = new GridSetting();
        r100.setForceColWidth(getWidth());
        return r100;
    }

    public final int getRecordCount() {
        return this.records.size();
    }

    public FormGridUIData() {
        this.fieldsHeader = new ArrayList();
        this.records = new ArrayList();
    }

    public final SimpleItemModel getAddButton() {
        return this.addButton;
    }

    public final ArrayList<FieldModel> getFieldsHeader() {
        return this.fieldsHeader;
    }

    public final ArrayList<FormGridRecord> getRecords() {
        return this.records;
    }

    public final void setAddButton(SimpleItemModel r100) {
        this.addButton = r100;
    }

    public final void setFieldsHeader(ArrayList<FieldModel> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.fieldsHeader = r100;
    }

    public final void setRecords(ArrayList<FormGridRecord> r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.records = r100;
    }

    public final void appendErrorMap(Context r110, HashMap<Integer, ArrayList<String>> r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (r111 == null) goto L24;
        Set<Integer> r100 = r111.keySet();
        if (r100 == null) goto L36;
        Iterator<T> r101 = r100.iterator();
    L8:
        if (r101.hasNext() == false) goto L37;
        Integer r102 = (Integer) r101.next();
        ArrayList<String> r103 = r111.get(r102);
        ArrayList<FormGridRecord> r104 = this.records;
        Intrinsics.checkNotNull(r102);
        FormGridRecord r105 = (FormGridRecord) m.j(r104, r102.intValue(), null);
        if (r105 == null) goto L8;
        ArrayList<GridCellData> r106 = r105.getFields();
        if (r106 == null) goto L8;
        Iterator<T> r107 = r106.iterator();
    L15:
        if (r107.hasNext() == false) goto L8;
        GridCellData r108 = (GridCellData) r107.next();
        if (r103 != null) goto L19;
    L21:
        boolean r109 = false;
    L22:
        if (r109 == false) goto L15;
        HighlightModel r112 = new HighlightModel();
        StringCompanionObject r113 = StringCompanionObject.INSTANCE;
        String r114 = String.format("#%08X", Arrays.copyOf(new Object[]{Integer.valueOf(ContextCompat.getColor(r110, R.color.function_danger_fill_solid_01))}, 1));
        r112.setColorList(CollectionsKt.arrayListOf(new String[]{"#" + r114.substring(3, 9) + r114.substring(1, 3)}));
        r108.setHighlightColorV2(r112);
        goto L15
    L19:
        if (r103.contains(r108.getFieldId()) != true) goto L21;
        r109 = true;
        goto L22
    L37:
        return;
    L36:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void appendErrorMap$default(FormGridUIData r100, Context r101, HashMap r102, int r103, Object r104) {
        if ((r103 & 2) == 0) goto L5;
        r102 = null;
    L5:
        r100.appendErrorMap(r101, r102);
    }
}
