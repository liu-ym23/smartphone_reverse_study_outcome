package com.bytedance.dux.infopanel.content;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import em4.n;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\u0006"}, d2 = {"Lcom/bytedance/dux/infopanel/content/DuxInfoPanelContentEntranceView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "", "text", "", "setEntranceText", "dux_release"}, k = 1, mv = {1, 7, 1})
public final class DuxInfoPanelContentEntranceView extends ConstraintLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f205238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ViewGroup f205239b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DuxInfoPanelContentEntranceView f205240a;

        public a(DuxInfoPanelContentEntranceView r100) {
            this.f205240a = r100;
        }

        public final void a() {
            DuxInfoPanelContentEntranceView r100 = this.f205240a;
            int r101 = r100.f205239b.getWidth();
            float r102 = 44;
            Resources r103 = Resources.getSystem();
            n.b(r100, r101, MathKt.roundToInt(TypedValue.applyDimension(1, r102, WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()))), true);
            ViewGroup r104 = this.f205240a.f205239b;
            int r105 = r104.getWidth();
            Resources r106 = Resources.getSystem();
            n.b(r104, r105, MathKt.roundToInt(TypedValue.applyDimension(1, r102, WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()))), true);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public DuxInfoPanelContentEntranceView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null, 6);
    }

    public DuxInfoPanelContentEntranceView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        post(new a(this));
    }

    public final void setEntranceText(CharSequence r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f205238a.setText(r100);
    }

    public DuxInfoPanelContentEntranceView(Context r100, AttributeSet r101, int r102) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        ViewGroup.inflate(r100, R.layout.dux_info_panel_content_entrance_view, this);
        ViewGroup.MarginLayoutParams r103 = new ViewGroup.MarginLayoutParams(-1, -2);
        Resources r104 = Resources.getSystem();
        int r105 = MathKt.roundToInt(TypedValue.applyDimension(1, 8, WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics())));
        Resources r106 = Resources.getSystem();
        r103.setMargins(0, r105, 0, MathKt.roundToInt(TypedValue.applyDimension(1, 12, WindowDisplayMetricsOverride.apply(r106, r106.getDisplayMetrics()))));
        setLayoutParams(r103);
        this.f205238a = (TextView) findViewById(R.id.tv_title);
        ImageView r107 = (ImageView) findViewById(R.id.iv_arrow);
        this.f205239b = (ViewGroup) findViewById(R.id.entrance_container);
    }
}
