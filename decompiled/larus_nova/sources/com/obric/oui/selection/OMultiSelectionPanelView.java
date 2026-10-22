package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
@Deprecated(message = "This class has been deprecated. Please use OListItemGeneral instead. For usage examples, refer to the ListItemActivity class in the example.")
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0001\fB%\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\r"}, d2 = {"Lcom/obric/oui/selection/OMultiSelectionPanelView;", "Lcom/obric/oui/selection/OSelectionPanelView;", "", "", "getSelectedItems", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "theme", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OMultiSelectionPanelView extends OSelectionPanelView {

    public interface a {
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public final boolean b() {
        return true;
    }

    public final List<Integer> getSelectedItems() {
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = getItemViews().iterator();
        int r102 = 0;
    L4:
        if (r101.hasNext() == false) goto L12;
        Object r103 = r101.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((OSelectionPanelItemView) r103).S5() == false) goto L11;
        r100.add(Integer.valueOf(r102));
    L11:
        r102 = r104;
        goto L4
    L12:
        return r100;
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public final void a() {
        if (getItemViews().size() <= 7) goto L5;
        setScrollViewHeight(d.n(this, 424));
        return;
    L5:
        setScrollViewHeight(-2);
    }

    public OMultiSelectionPanelView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }
}
