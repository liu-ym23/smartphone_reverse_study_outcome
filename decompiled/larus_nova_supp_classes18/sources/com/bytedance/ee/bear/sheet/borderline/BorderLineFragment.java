package com.bytedance.ee.bear.sheet.borderline;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.sheet.common.SheetDragView;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class BorderLineFragment extends BaseFragment implements BorderLinePanelView.b {
    public static final /* synthetic */ int h = 0;
    public TextView e;
    public BorderLinePanelView f;
    public BorderLineViewModel g;

    public final boolean S90() {
        T90(2130772114);
        return true;
    }

    public BorderLineFragment() {
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        BorderLineViewModel r3 = (BorderLineViewModel) q.a(this, BorderLineViewModel.class);
        this.g = r3;
        r3.isClearBorderLinePanel().observe(this, new a(this));
    }

    public final void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        View r5 = r3.findViewById(2131388817);
        r5.findViewById(2131363779).setOnClickListener(new d(this));
        ((SheetDragView) r3.getRootView().findViewById(2131372039)).setSlideView(r5);
        TextView r6 = (TextView) r5.findViewById(2131388772);
        this.e = r6;
        r6.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        this.e.getPaint().setStrokeWidth(1.0f);
        BorderLinePanelView r7 = (BorderLinePanelView) r3.findViewById(2131364342);
        this.f = r7;
        r7.setDelegate(this);
        this.g.getBorderLineData().observe(this, new b(this));
        Map<String, String> r8 = qm5.d.a;
        qm5.d.a(this, getFragmentManager(), null, new c(this));
    }

    @Override // com.bytedance.ee.bear.sheet.borderline.BorderLinePanelView.b
    public final void P30(String r2, String r3, String r4) {
        BorderLineViewModel r0 = this.g;
        if (r0 == null) goto L6;
        r0.onBorderLineSelected(r2, r3, r4);
        return;
    }

    public final Animation onCreateAnimation(int r1, boolean r2, int r3) {
        if (r2 == true) goto L6;
        return null;
    L6:
        return AnimationUtils.loadAnimation(getContext(), 2130772113);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131564526, r3, false);
    }
}
