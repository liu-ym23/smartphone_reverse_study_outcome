package com.larus.home.impl.main.side_bar.feed.cell;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.home.impl.databinding.LarusItemSideBarProjectEmptyActionBinding;
import com.larus.home.impl.main.side_bar.feed.factory.SideBarProjectEmptyAction;
import com.larus.home.impl.main.side_bar.view.adapter.x0;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import eb9.u;
import eb9.x;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class i implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LarusItemSideBarProjectEmptyActionBinding f344683a;

    public i() {
    }

    @Override // eb9.x
    public final View b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_side_bar_project_empty_action, r100, false);
        int r102 = R.id.project_empty_action_icon;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r101, R.id.project_empty_action_icon);
        if (r103 == null) goto L9;
        r102 = R.id.project_empty_action_title;
        TextView r104 = (TextView) ViewBindings.findChildViewById(r101, R.id.project_empty_action_title);
        if (r104 == null) goto L9;
        ConstraintLayout r105 = (ConstraintLayout) r101;
        this.f344683a = new LarusItemSideBarProjectEmptyActionBinding(r105, r103, r104);
        x0.c(r105, false);
        return r105;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(r102)));
    }

    @Override // eb9.x
    public final View f(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return r100;
    }

    @Override // eb9.x
    public final View i(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        return r100;
    }

    @Override // eb9.x
    public final void c(View r100, u r101) {
        x.a.c(r100, r101);
    }

    @Override // eb9.x
    public final void d(View r100, u r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        LarusItemSideBarProjectEmptyActionBinding r102 = this.f344683a;
        if (r102 == null) goto L7;
        TextView r103 = r102.f344327c;
        if (r103 == null) goto L7;
        r103.setText(null);
    L7:
        LarusItemSideBarProjectEmptyActionBinding r104 = this.f344683a;
        if (r104 == null) goto L13;
        ImageView r105 = r104.f344326b;
        if (r105 == null) goto L14;
        r105.setImageDrawable(null);
        return;
    L14:
        return;
    }

    @Override // eb9.x
    public final void g(View r100, u r101) {
        x.a.b(r100, r101);
    }

    @Override // eb9.x
    public final void a(View r100, eb9.o<?> r101, int r102, u r103) {
        x.a.a(this, r100, r101, r102, r103);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // eb9.x
    public final void e(View r100, eb9.o<?> r101, int r102, u r103) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        DATA r104 = r101.f471909c;
        if ((r104 instanceof SideBarProjectEmptyAction) == false) goto L5;
        SideBarProjectEmptyAction r105 = (SideBarProjectEmptyAction) r104;
    L6:
        if (r105 != null) goto L8;
        return;
    L8:
        LarusItemSideBarProjectEmptyActionBinding r106 = this.f344683a;
        if (r106 == null) goto L12;
        r106.f344326b.setImageResource(r105.getIconRes());
        r106.f344327c.setText(r105.getTitleRes());
        return;
    L12:
        return;
    L5:
        r105 = null;
        goto L6
    }

    @Override // eb9.x
    public final void h(eb9.o<?> r100, View r101, int r102, u r103) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
    }
}
