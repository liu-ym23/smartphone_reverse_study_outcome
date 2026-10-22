package com.bytedance.ee.bear.sheet.panel.operation;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment;
import com.bytedance.ee.bear.sheet.panel.BaseCellPanelViewModel;
import com.bytedance.ee.bear.sheet.panel.SheetItem;
import com.bytedance.ee.bear.sheet.panel.oppanel.FabPanelViewModel;
import en5.a;
import java.util.Map;
import qm5.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class FreezeFragment extends BaseCellPanelFragment<SheetItem> {
    public static final /* synthetic */ int h = 0;

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final String Y90() {
        return "freezeSheet";
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void da0() {
        T90(0);
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final BaseCellPanelViewModel<SheetItem> Z90() {
        return q.a(this, FabPanelViewModel.class);
    }

    public final boolean S90() {
        T90(2130772114);
        return true;
    }

    public FreezeFragment() {
    }

    @Override // com.bytedance.ee.bear.sheet.panel.BaseCellPanelFragment
    public final void onViewCreated(View r2, Bundle r3) {
        super.onViewCreated(r2, r3);
        fa0(Z90().getPanelTitle("freezeSheet"));
        Map<String, String> r4 = d.a;
        d.a(this, getFragmentManager(), null, new a(this));
    }

    public final Animation onCreateAnimation(int r1, boolean r2, int r3) {
        if (r2 == true) goto L6;
        return null;
    L6:
        return AnimationUtils.loadAnimation(getContext(), 2130772113);
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        return r2.inflate(2131564568, r3, false);
    }
}
