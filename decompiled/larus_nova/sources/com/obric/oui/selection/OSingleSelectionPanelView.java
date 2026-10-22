package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
@Deprecated(message = "This class has been deprecated. Please use OListItemGeneral instead. For usage examples, refer to the ListItemActivity class in the example.")
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u00002\u00020\u0001:\u0001\u000bB%\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\f"}, d2 = {"Lcom/obric/oui/selection/OSingleSelectionPanelView;", "Lcom/obric/oui/selection/OSelectionPanelView;", "", "getSelectedItem", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "theme", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public class OSingleSelectionPanelView extends OSelectionPanelView {

    public interface a {
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public final boolean b() {
        return false;
    }

    @Override // com.obric.oui.selection.OSelectionPanelView
    public final void a() {
        if (getContext().getResources().getConfiguration().orientation != 2) goto L5;
        boolean r100 = true;
    L7:
        if (r100 == true) goto L13;
        if (getItemViews().size() <= 7) goto L11;
        setScrollViewHeight(d.n(this, 424));
        return;
    L11:
        setScrollViewHeight(-2);
        return;
    L13:
        if (getItemViews().size() <= 2) goto L15;
        setScrollViewHeight(d.n(this, 112));
        return;
    L15:
        setScrollViewHeight(-2);
        return;
    L5:
        r100 = false;
        goto L7
    }

    public final int getSelectedItem() {
        Iterator<T> r100 = getItemViews().iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L12;
        Object r102 = r100.next();
        int r103 = r101 + 1;
        if (r101 >= 0) goto L9;
        CollectionsKt.throwIndexOverflow();
    L9:
        if (((OSelectionPanelItemView) r102).S5() == true) goto L10;
        r101 = r103;
        goto L4
    L10:
        return r101;
    L12:
        return -1;
    }

    public OSingleSelectionPanelView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
    }
}
