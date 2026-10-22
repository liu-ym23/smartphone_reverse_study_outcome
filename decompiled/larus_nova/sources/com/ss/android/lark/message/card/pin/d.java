package com.ss.android.lark.message.card.pin;

import android.view.View;
import android.widget.FrameLayout;
import com.larksuite.component.card.cardcontainer.CardImpl;
import com.larksuite.component.ui.layout.LKUIRoundableLayout;
import com.larus.nova.R;
import com.ss.android.lark.message.card.view.MaxHeightInterruptEventScrollView;

/* JADX INFO: loaded from: classes36.dex */
public final class d extends iya.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f431912i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f431913a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final bz7.a f431914b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LKUIRoundableLayout f431915c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MaxHeightInterruptEventScrollView f431916d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final FrameLayout f431917e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final FrameLayout f431918f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final View f431919g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final FrameLayout f431920h;

    public static final class a {
    }

    static {
    }

    public d(View r100, CardImpl r101) {
        this.f431913a = r100;
        this.f431914b = r101;
        this.f431915c = (LKUIRoundableLayout) r100.findViewById(R.id.root);
        this.f431916d = (MaxHeightInterruptEventScrollView) r100.findViewById(R.id.scroll_view);
        this.f431917e = (FrameLayout) r100.findViewById(R.id.header_container);
        this.f431918f = (FrameLayout) r100.findViewById(R.id.layout_content);
        this.f431919g = r100.findViewById(R.id.mask_view);
        this.f431920h = (FrameLayout) r100.findViewById(R.id.fl_lynx_parent);
    }
}
