package com.bytedance.ee.bear.bitable.fieldedit.view.edit.extendfield;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendConfig;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendConfigItem;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.FieldExtendOrigin;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0018B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u0010\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\rJ\b\u0010\u0017\u001a\u00020\u0015H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/extendfield/ExtendFieldTypeExtendFieldSelectionView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mFieldExtendOrigin", "Lcom/bytedance/ee/bear/bitable/card/model/jsmodel/common/FieldExtendOrigin;", "onItemListener", "Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/extendfield/ExtendFieldTypeExtendFieldSelectionView$OnItemListener;", "getOnItemListener", "()Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/extendfield/ExtendFieldTypeExtendFieldSelectionView$OnItemListener;", "setOnItemListener", "(Lcom/bytedance/ee/bear/bitable/fieldedit/view/edit/extendfield/ExtendFieldTypeExtendFieldSelectionView$OnItemListener;)V", "setData", "", "fieldExtendOrigin", "updateView", "OnItemListener", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExtendFieldTypeExtendFieldSelectionView extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FieldExtendOrigin f211396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public a f211397b;

    public interface a {
        void a(View r100, FieldExtendOrigin r101, FieldExtendConfig r102, FieldExtendConfigItem r103);
    }

    public final a getOnItemListener() {
        return this.f211397b;
    }

    public ExtendFieldTypeExtendFieldSelectionView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        setOrientation(1);
    }

    public final void setData(FieldExtendOrigin r100) {
        if (r100 == null) goto L5;
        ArrayList<FieldExtendConfig> r101 = r100.getConfigs();
    L7:
        if (r101 != null) goto L9;
    L12:
        boolean r102 = true;
    L13:
        if (r102 == false) goto L16;
        setVisibility(8);
        return;
    L16:
        setVisibility(0);
        this.f211396a = r100;
        removeAllViews();
        FieldExtendOrigin r103 = this.f211396a;
        if (r103 == null) goto L31;
        ArrayList<FieldExtendConfig> r104 = r103.getConfigs();
        if (r104 == null) goto L35;
        Iterator<T> r105 = r104.iterator();
    L22:
        if (r105.hasNext() == false) goto L36;
        FieldExtendConfig r106 = (FieldExtendConfig) r105.next();
        View r107 = LayoutInflater.from(getContext()).inflate(R.layout.bitable_field_type_extend_selection_view, this, false);
        ArrayList<FieldExtendConfigItem> r108 = r106.getExtendItems();
        if (r108 == null) goto L29;
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator<T> r110 = r108.iterator();
    L27:
        if (r110.hasNext() == false) goto L30;
        r109.add(new ExtendFieldListView.a((FieldExtendConfigItem) r110.next(), null));
    L30:
        ((TextView) r107.findViewById(R.id.extendScopeText)).setText(r106.getFromInfo());
        ((ExtendFieldListView) r107.findViewById(R.id.itemRoot)).setData(r109);
        ((ExtendFieldListView) r107.findViewById(R.id.itemRoot)).setOnItemListener(new b(r107, this, r106));
        addView(r107);
        goto L22
    L29:
        r109 = null;
        goto L30
    L36:
        return;
    L35:
        return;
    L31:
        return;
    L9:
        if (r101.isEmpty() == true) goto L12;
        r102 = false;
        goto L13
    L5:
        r101 = null;
        goto L7
    }

    public final void setOnItemListener(a r100) {
        this.f211397b = r100;
    }

    public ExtendFieldTypeExtendFieldSelectionView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        setOrientation(1);
    }

    public ExtendFieldTypeExtendFieldSelectionView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        setOrientation(1);
    }
}
