package com.bytedance.ee.bear.bitable.infoarch.nativeview.container.datadrill;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.ee.bear.bitable.databinding.BitableDataDrillDownTablistLayoutBinding;
import com.bytedance.ee.bear.bitable.uikit.simpleitem.SimpleItemModel;
import com.larksuite.component.universe_design.tab.UDTabLayout;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import gv4.b;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00050\u0002B'\b\u0007\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ.\u0010&\u001a\u00020!2\u001a\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J$\u0010*\u001a\u00020+2\u001a\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\u0002R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R.\u0010\u0014\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\"\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020!\u0018\u00010 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006,"}, d2 = {"Lcom/bytedance/ee/bear/bitable/infoarch/nativeview/container/datadrill/TableTabList;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ee/bear/bitable/uikit/BitableUIKit;", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/bitable/uikit/simpleitem/SimpleItemModel;", "Lkotlin/collections/ArrayList;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/bytedance/ee/bear/bitable/databinding/BitableDataDrillDownTablistLayoutBinding;", "getBinding", "()Lcom/bytedance/ee/bear/bitable/databinding/BitableDataDrillDownTablistLayoutBinding;", "setBinding", "(Lcom/bytedance/ee/bear/bitable/databinding/BitableDataDrillDownTablistLayoutBinding;)V", "cache", "getCache", "()Ljava/util/ArrayList;", "setCache", "(Ljava/util/ArrayList;)V", "selectTableId", "", "getSelectTableId", "()Ljava/lang/String;", "setSelectTableId", "(Ljava/lang/String;)V", "selectCallback", "Lkotlin/Function0;", "", "getSelectCallback", "()Lkotlin/jvm/functions/Function0;", "setSelectCallback", "(Lkotlin/jvm/functions/Function0;)V", "setData", "data", "handler", "Lcom/bytedance/ee/bear/bitable/uikit/ActionHandler;", "needUpdate", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TableTabList extends FrameLayout implements b<ArrayList<SimpleItemModel>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public BitableDataDrillDownTablistLayoutBinding f213434a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ArrayList<SimpleItemModel> f213435b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f213436c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function0<Unit> f213437d;

    public TableTabList(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public TableTabList(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final BitableDataDrillDownTablistLayoutBinding getBinding() {
        return this.f213434a;
    }

    public final ArrayList<SimpleItemModel> getCache() {
        return this.f213435b;
    }

    public final Function0<Unit> getSelectCallback() {
        return this.f213437d;
    }

    public final String getSelectTableId() {
        return this.f213436c;
    }

    public final void setBinding(BitableDataDrillDownTablistLayoutBinding r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.f213434a = r100;
    }

    public final void setCache(ArrayList<SimpleItemModel> r100) {
        this.f213435b = r100;
    }

    public final void setSelectCallback(Function0<Unit> r100) {
        this.f213437d = r100;
    }

    public final void setSelectTableId(String r100) {
        this.f213436c = r100;
    }

    public TableTabList(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        View r103 = LayoutInflater.from(r100).inflate(R.layout.bitable_data_drill_down_tablist_layout, this, false);
        addView(r103);
        if (r103 == null) goto L7;
        UDTabLayout r104 = (UDTabLayout) r103;
        this.f213434a = new BitableDataDrillDownTablistLayoutBinding(r104, r104);
        return;
    L7:
        throw new NullPointerException("rootView");
    }

    public /* synthetic */ TableTabList(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
