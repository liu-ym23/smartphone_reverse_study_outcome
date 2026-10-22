package com.obric.oui.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.nova.R;
import com.obric.oui.button.OButton;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Deprecated(message = "This class has been deprecated. ")
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0015\u0010\u0016R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006R\u0017\u0010\u0010\u001a\u00020\u000b8\u0006¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/obric/oui/selection/OSelectionPanelBtnView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/obric/oui/button/OButton;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/obric/oui/button/OButton;", "getBtnNegative", "()Lcom/obric/oui/button/OButton;", "btnNegative", "b", "getBtnPositive", "btnPositive", "Landroid/view/View;", "c", "Landroid/view/View;", "getHorizontal_space", "()Landroid/view/View;", "horizontal_space", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OSelectionPanelBtnView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final OButton f402768a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final OButton f402769b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f402770c;

    public final OButton getBtnNegative() {
        return this.f402768a;
    }

    public final OButton getBtnPositive() {
        return this.f402769b;
    }

    public final View getHorizontal_space() {
        return this.f402770c;
    }

    public OSelectionPanelBtnView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public OSelectionPanelBtnView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ViewGroup.inflate(r100, R.layout.o_widget_selection_panel_btns, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f402768a = (OButton) findViewById(R.id.btn_negative);
        this.f402769b = (OButton) findViewById(R.id.btn_positive);
        this.f402770c = findViewById(R.id.horizontal_space);
    }
}
