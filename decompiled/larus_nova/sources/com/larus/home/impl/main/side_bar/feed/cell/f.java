package com.larus.home.impl.main.side_bar.feed.cell;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.larus.common_ui.widget.RedDotTextView;
import com.larus.home.api.feed.FlowFeedActionScene;
import com.larus.home.impl.databinding.LarusItemConversationGroupHeaderBinding;
import com.larus.home.impl.main.side_bar.view.adapter.x0;
import com.larus.nova.R;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.android.lark.utils.statistics.PerfLog;
import eb9.u;
import eb9.x;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class f implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final fb9.c f344675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<List<eb9.d>> f344676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<com.larus.home.impl.main.side_bar.view.group.render.l, Unit> f344677c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<Unit> f344678d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function1<com.larus.home.impl.main.side_bar.view.group.render.l, Unit> f344679e;

    @Override // eb9.x
    public final View b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        LarusItemConversationGroupHeaderBinding r101 = LarusItemConversationGroupHeaderBinding.a(LayoutInflater.from(r100.getContext()), r100);
        x0.c(r101.f344274a, false);
        r101.f344274a.setTag(r101);
        return r101.f344274a;
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
        Object r102 = r100.getTag();
        if ((r102 instanceof LarusItemConversationGroupHeaderBinding) == false) goto L5;
        LarusItemConversationGroupHeaderBinding r103 = (LarusItemConversationGroupHeaderBinding) r102;
    L6:
        if (r103 != null) goto L8;
        return;
    L8:
        r103.f344279f.setOnClickListener(null);
        r100.setOnClickListener(null);
        r100.setOnLongClickListener(null);
        return;
    L5:
        r103 = null;
        goto L6
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
    public final void e(View r100, final eb9.o<?> r110, int r111, u r112) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r110, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r113 = r100.getTag();
        final com.larus.home.impl.main.side_bar.view.group.render.l r101 = null;
        if ((r113 instanceof LarusItemConversationGroupHeaderBinding) == false) goto L5;
        final LarusItemConversationGroupHeaderBinding r102 = (LarusItemConversationGroupHeaderBinding) r113;
    L6:
        if (r102 != null) goto L8;
        return;
    L8:
        DATA r114 = r110.f471909c;
        if ((r114 instanceof com.larus.home.impl.main.side_bar.view.group.render.l) == false) goto L11;
        r101 = (com.larus.home.impl.main.side_bar.view.group.render.l) r114;
    L11:
        if (r101 != null) goto L13;
        return;
    L13:
        r102.f344281h.setText(r101.f345675b.a(r100.getContext()));
        Context r115 = r100.getContext();
        if (r101.f345676c == false) goto L16;
        int r116 = R.string.larus_accessibility_collapse;
    L17:
        r100.setContentDescription(r115.getString(r116));
        final List<eb9.d> r103 = this.f344676b.invoke();
        boolean r117 = true;
        final boolean r104 = !r103.isEmpty();
        boolean r118 = r101.f345676c;
        int r105 = 0;
        if (r118 == false) goto L20;
    L22:
        boolean r106 = false;
    L23:
        ImageView r107 = r102.f344276c;
        if ((!r118) == false) goto L26;
        int r119 = 0;
    L27:
        r107.setVisibility(r119);
        RedDotTextView r120 = r102.f344280g;
        if (r106 == false) goto L30;
        int r108 = r101.f345677d;
    L31:
        r120.z(r108);
        FrameLayout r121 = r102.f344275b;
        if (r106 == true) goto L36;
        if (r104 == true) goto L36;
        boolean r109 = false;
    L37:
        if (r109 == false) goto L39;
        int r122 = 0;
    L40:
        r121.setVisibility(r122);
        ImageView r123 = r102.f344279f;
        if (r104 == false) goto L44;
        if (r106 == true) goto L44;
    L45:
        if (r117 == true) goto L48;
        r105 = 8;
    L48:
        r123.setVisibility(r105);
        r102.f344279f.setOnClickListener(new c(this, r102, r110, r103));
        r100.setOnLongClickListener(new d(r104, this, r102, r110, r103));
        r100.setOnClickListener(new e(this, r101));
        return;
    L44:
        r117 = false;
        goto L45
    L39:
        r122 = 8;
    L36:
        r109 = true;
        goto L37
    L30:
        r108 = 0;
        goto L31
    L26:
        r119 = 8;
        goto L27
    L20:
        if (r101.f345677d <= 0) goto L22;
        r106 = true;
        goto L23
    L16:
        r116 = R.string.larus_accessibility_expand;
        goto L17
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // eb9.x
    public final void h(eb9.o<?> r100, View r101, int r102, u r103) {
        Intrinsics.checkNotNullParameter(r100, BrowserDependency.UrlClickType.CARD);
        Intrinsics.checkNotNullParameter(r101, "view");
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        DATA r104 = r100.f471909c;
        if ((r104 instanceof com.larus.home.impl.main.side_bar.view.group.render.l) == false) goto L5;
        com.larus.home.impl.main.side_bar.view.group.render.l r105 = (com.larus.home.impl.main.side_bar.view.group.render.l) r104;
    L6:
        if (r105 != null) goto L8;
        return;
    L8:
        this.f344679e.invoke(r105);
        return;
    L5:
        r105 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(fb9.c r100, Function0<? extends List<? extends eb9.d>> r101, Function1<? super com.larus.home.impl.main.side_bar.view.group.render.l, Unit> r102, Function0<Unit> r103, Function1<? super com.larus.home.impl.main.side_bar.view.group.render.l, Unit> r104) {
        Intrinsics.checkNotNullParameter(r100, "actionAbility");
        Intrinsics.checkNotNullParameter(r101, "actionItems");
        Intrinsics.checkNotNullParameter(r102, "onToggle");
        Intrinsics.checkNotNullParameter(r103, "onActionMenuShow");
        Intrinsics.checkNotNullParameter(r104, "onShown");
        this.f344675a = r100;
        this.f344676b = r101;
        this.f344677c = r102;
        this.f344678d = r103;
        this.f344679e = r104;
    }

    public static final boolean j(LarusItemConversationGroupHeaderBinding r100, f r101, eb9.o<?> r102, List<? extends eb9.d> r103, FlowFeedActionScene r104) {
        int r105 = r100.f344279f.getVisibility();
        r100.f344279f.setVisibility(4);
        boolean r106 = fb9.c.a.a(r101.f344675a, r100.f344274a, r102, r104, r103);     // Catch: Throwable -> L6
        r100.f344279f.setVisibility(r105);
        return r106;
    L6:
        th = move-exception;
        r100.f344279f.setVisibility(r105);
        throw th;
    }
}
