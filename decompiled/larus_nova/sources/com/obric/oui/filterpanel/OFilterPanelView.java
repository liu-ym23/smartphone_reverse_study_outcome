package com.obric.oui.filterpanel;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.obric.oui.button.OButton;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import pla.d;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tJ\u0006\u0010\r\u001a\u00020\f¨\u0006\u0014"}, d2 = {"Lcom/obric/oui/filterpanel/OFilterPanelView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "count", "", "setMaxSelectCount", "Lcom/obric/oui/button/OButton;", "getResetBtn", "getConfirmBtn", "", "Lcom/obric/oui/filterpanel/OFilterGroupView;", "getFilterGroupViewSet", "Landroid/widget/LinearLayout;", "getFilterGroupContainer", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OFilterPanelView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinearLayout f400844a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OButton f400845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final OButton f400846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Set<OFilterGroupView> f400847d;

    public final void setMaxSelectCount(int r100) {
    }

    public final OButton getConfirmBtn() {
        return this.f400846c;
    }

    public final LinearLayout getFilterGroupContainer() {
        return this.f400844a;
    }

    public final Set<OFilterGroupView> getFilterGroupViewSet() {
        return this.f400847d;
    }

    public final OButton getResetBtn() {
        return this.f400845b;
    }

    public OFilterPanelView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public OFilterPanelView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.f400847d = new LinkedHashSet();
        ViewGroup.inflate(r100, R.layout.o_layout_filter_panel_view, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, d.n(this, 400)));
        this.f400844a = (LinearLayout) findViewById(R.id.filter_group_container);
        LinearLayout r102 = (LinearLayout) findViewById(R.id.btn_container);
        this.f400845b = (OButton) findViewById(R.id.btn_reset);
        this.f400846c = (OButton) findViewById(R.id.btn_confirm);
    }
}
