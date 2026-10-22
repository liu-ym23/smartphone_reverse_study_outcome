package com.bytedance.dux.selection;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.dux.button.DuxButton;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001R\u0017\u0010\u0007\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\n\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/bytedance/dux/selection/DuxSelectionPanelBtnView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/bytedance/dux/button/DuxButton;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "Lcom/bytedance/dux/button/DuxButton;", "getBtnNegative", "()Lcom/bytedance/dux/button/DuxButton;", "btnNegative", "b", "getBtnPositive", "btnPositive", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxSelectionPanelBtnView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final DuxButton f205580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DuxButton f205581b;

    public DuxSelectionPanelBtnView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 6);
    }

    public DuxSelectionPanelBtnView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4);
    }

    public final DuxButton getBtnNegative() {
        return this.f205580a;
    }

    public final DuxButton getBtnPositive() {
        return this.f205581b;
    }

    public DuxSelectionPanelBtnView(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ViewGroup.inflate(r100, R.layout.dux_widget_selection_panel_btns, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        this.f205580a = (DuxButton) findViewById(R.id.btn_negative);
        this.f205581b = (DuxButton) findViewById(R.id.btn_positive);
    }
}
