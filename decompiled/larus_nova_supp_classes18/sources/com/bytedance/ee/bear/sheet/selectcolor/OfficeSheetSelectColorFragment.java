package com.bytedance.ee.bear.sheet.selectcolor;

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
import com.bytedance.ee.bear.widgets.colorpicker.CommonColorSchemeView;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class OfficeSheetSelectColorFragment extends BaseFragment implements CommonColorSchemeView.a {
    public static final /* synthetic */ int i = 0;
    public String e;
    public TextView f;
    public CommonColorSchemeView g;
    public OfficeSheetSelectColorViewModel h;

    public final boolean S90() {
        T90(2130772114);
        return true;
    }

    public OfficeSheetSelectColorFragment() {
    }

    @Override // com.bytedance.ee.bear.widgets.colorpicker.CommonColorSchemeView.a
    public final void G30(String r3) {
        this.h.onSpecificColorSelected(this.e, r3);
    }

    @Override // com.bytedance.ee.bear.widgets.colorpicker.CommonColorSchemeView.a
    public final void Kr(String r3) {
        this.h.onTopicColorSelected(this.e, r3);
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        this.e = requireArguments().getString(ResourceData.KEY_ID);
        this.h = (OfficeSheetSelectColorViewModel) q.a(this, OfficeSheetSelectColorViewModel.class);
    }

    public final void onViewCreated(View r3, Bundle r4) {
        super.onViewCreated(r3, r4);
        View r5 = r3.findViewById(2131388817);
        r5.findViewById(2131363779).setOnClickListener(new c(this));
        TextView r0 = (TextView) r5.findViewById(2131388772);
        this.f = r0;
        r0.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
        this.f.getPaint().setStrokeWidth(1.0f);
        ((SheetDragView) r3.getRootView().findViewById(2131372039)).setSlideView(r5);
        CommonColorSchemeView r6 = (CommonColorSchemeView) r3.findViewById(2131367181);
        this.g = r6;
        r6.setDelegate(this);
        this.h.getSelectColorData(this.e).observe(getViewLifecycleOwner(), new a(this));
        Map<String, String> r7 = on5.b.a;
        on5.b.a(this, getFragmentManager(), null, new b(this));
    }

    public final Animation onCreateAnimation(int r1, boolean r2, int r3) {
        if (r2 == true) goto L6;
        return null;
    L6:
        return AnimationUtils.loadAnimation(getContext(), 2130772113);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131564580, r3, false);
    }
}
