package com.bytedance.ee.bear.sheet.searchbar;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.PluginInfoExtractException;
import com.bytedance.ee.bear.browser.plugin.q;
import com.bytedance.ee.bear.document.search.SearchToolbarFragment;
import com.bytedance.ee.bear.document.y3;
import com.bytedance.ee.bear.domain.BearUrl;
import com.bytedance.ee.bear.widgets.universedesign.SpaceEditText;
import com.bytedance.ee.util.ui.n;
import hn5.a;
import hn5.h;
import rcb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public class SheetSearchToolbarFragment extends SearchToolbarFragment {
    public boolean A;
    public SheetSearchViewModel B;
    public a t;
    public int u;
    public LinearLayout v;
    public LinearLayout w;
    public LinearLayout x;
    public View y;
    public SpaceEditText z;

    public final boolean Z90() {
        SheetSearchViewModel r0 = this.B;
        if (r0 != null) goto L5;
        return true;
    L5:
        if (r0.getShouldDisableLandscapeInVc() == true) goto L7;
        return true;
    L7:
        if (this.u != 2) goto L13;
        return false;
    L13:
        return true;
    }

    public SheetSearchToolbarFragment() {
        this.A = false;
    }

    public final Class<SheetSearchViewModel> W90() {
        return SheetSearchViewModel.class;
    }

    public static void ca0(View r2) {
        if (r2 == null) goto L7;
        ViewParent r0 = r2.getParent();
        if ((r0 instanceof ViewGroup) == false) goto L8;
        ((ViewGroup) r0).removeView(r2);
        return;
    L8:
        return;
    }

    public final void ba0(int r5) {
        Boolean r0 = Boolean.FALSE;
        SheetSearchViewModel r1 = this.B;
        if (r1 == null) goto L5;
        r0 = (Boolean) r1.getFocusStatus().getValue();
    L5:
        getResources().getConfiguration();
        if (r5 != 2) goto L8;
        ((SearchToolbarFragment) this).e.setVisibility(8);
        this.v.removeView(this.w);
        this.v.removeView(((SearchToolbarFragment) this).j);
        this.x.setPadding(n.d(4), 0, n.d(4), 0);
        this.x.removeView(this.y);
        LinearLayout r6 = this.x;
        LinearLayout r2 = this.w;
        ca0(r2);
        r6.addView(r2, 0);
        LinearLayout r7 = this.x;
        TextView r3 = ((SearchToolbarFragment) this).j;
        ca0(r3);
        r7.addView(r3);
        ((LinearLayout.LayoutParams) ((SearchToolbarFragment) this).l.getLayoutParams()).setMargins(n.d(24), 0, n.d(16), 0);
    L12:
        if (Boolean.TRUE.equals(r0) == false) goto L15;
        c.h(((SearchToolbarFragment) this).h, null);
        return;
    L15:
        return;
    L8:
        getResources().getConfiguration();
        if (r5 != 1) goto L12;
        ((SearchToolbarFragment) this).e.setVisibility(0);
        this.x.setPadding(0, 0, 0, 0);
        this.x.removeView(this.w);
        this.x.removeView(((SearchToolbarFragment) this).j);
        LinearLayout r8 = this.x;
        View r4 = this.y;
        ca0(r4);
        r8.addView(r4, 0);
        LinearLayout r9 = this.v;
        LinearLayout r10 = this.w;
        ca0(r10);
        r9.addView(r10);
        LinearLayout r11 = this.v;
        TextView r12 = ((SearchToolbarFragment) this).j;
        ca0(r12);
        r11.addView(r12);
        ((LinearLayout.LayoutParams) ((SearchToolbarFragment) this).l.getLayoutParams()).setMargins(n.d(32), 0, n.d(12), 0);
        goto L12
    }

    public final void onClick(View r3) {
        if (r3.getId() != 2131385558) goto L6;
        this.t.c(true);
    L11:
        super.onClick(r3);
        return;
    L6:
        if (r3.getId() != 2131385545) goto L9;
        this.t.c(false);
        goto L11
    L9:
        if (r3.getId() != 2131385374) goto L11;
        this.t.b();
        goto L11
    }

    public final void onConfigurationChanged(Configuration r2) {
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        int r3 = r2.orientation;
        if (this.u == r3) goto L10;
        ba0(r3);
        this.u = r3;
        if (r3 == 1) goto L7;
        return;
    L7:
        if (this.A == false) goto L12;
        this.A = false;
        c.h(((SearchToolbarFragment) this).h, null);
        return;
    L12:
        return;
    }

    public final void onCreate(Bundle r4) {
        super.onCreate(r4);
        y3 r5 = PluginHost.fromFragment(this).getHostAbilityOrNull(y3.class);     // Catch: PluginInfoExtractException -> L7
        if (r5 == null) goto L9;
        BearUrl r6 = r5.getBearUrl();     // Catch: PluginInfoExtractException -> L7
    L10:
        this.t.a(r6);
        if (getActivity() == null) goto L16;
        SheetSearchViewModel r7 = q.a(this, SheetSearchViewModel.class);
        this.B = r7;
        this.A = r7.getShouldDisableLandscapeInVc();
        return;
    L16:
        return;
    L9:
        r6 = null;
    L7:
        e = move-exception;
        tt5.a.e("SheetSearchToolbarFragment", "analyticUrl, e: ", e, false);
        goto L9
    }

    public final void onViewCreated(View r1, Bundle r2) {
        super.onViewCreated(r1, r2);
        this.v = (LinearLayout) r1.findViewById(2131369354);
        this.w = (LinearLayout) r1.findViewById(2131369353);
        this.x = (LinearLayout) r1.findViewById(2131369355);
        this.y = r1.findViewById(2131382383);
        this.z = (SpaceEditText) r1.findViewById(2131385429);
        int r3 = getResources().getConfiguration().orientation;
        this.u = r3;
        if (r3 != 2) goto L5;
        ba0(r3);
    L5:
        this.z.setOnFocusChangeListener(new h(this));
    }
}
