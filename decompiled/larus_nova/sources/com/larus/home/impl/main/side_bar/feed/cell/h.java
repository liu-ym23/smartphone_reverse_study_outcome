package com.larus.home.impl.main.side_bar.feed.cell;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.home.impl.databinding.LarusItemSideBarProjectConversationBinding;
import com.larus.home.impl.main.side_bar.data.j0;
import com.larus.home.impl.main.side_bar.view.adapter.x0;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import eb9.u;
import eb9.x;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class h implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<Unit> f344681a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public LarusItemSideBarProjectConversationBinding f344682b;

    public h(Function0<Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, SendEventContainerMethodParamModel.EventKinds.onClick);
        this.f344681a = r100;
    }

    @Override // eb9.x
    public final View b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.larus_item_side_bar_project_conversation, r100, false);
        TextView r102 = (TextView) ViewBindings.findChildViewById(r101, R.id.tv_project_conversation_title);
        if (r102 == null) goto L7;
        FrameLayout r103 = (FrameLayout) r101;
        this.f344682b = new LarusItemSideBarProjectConversationBinding(r103, r102);
        x0.c(r103, false);
        return r103;
    L7:
        throw new NullPointerException("Missing required view with ID: ".concat(r101.getResources().getResourceName(R.id.tv_project_conversation_title)));
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
        r100.setOnClickListener(null);
        LarusItemSideBarProjectConversationBinding r102 = this.f344682b;
        if (r102 == null) goto L8;
        TextView r103 = r102.f344324b;
        if (r103 == null) goto L9;
        r103.setText(null);
        return;
    L9:
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
        if ((r104 instanceof j0) == false) goto L5;
        j0 r105 = (j0) r104;
    L6:
        if (r105 != null) goto L8;
        return;
    L8:
        e1.d(r100, new g(this));
        LarusItemSideBarProjectConversationBinding r106 = this.f344682b;
        if (r106 == null) goto L14;
        TextView r107 = r106.f344324b;
        if (r107 == null) goto L15;
        r107.setText(r105.f344511f);
        r107.setTextColor(ContextCompat.getColor(r100.getContext(), v19.c.b(R.attr.larus_neutral_50, r100.getContext(), R.color.larus_neutral_50)));
        return;
    L15:
        return;
    L14:
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
