package com.ss.android.lark.edit.keyboard.producer;

import android.app.Activity;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.view.ViewCompat;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.ss.android.lark.log.Log;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import rcb.e;

/* JADX INFO: loaded from: classes35.dex */
public final class b extends BaseKeyboardHeightProducer {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final View f420594e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final InterfaceC4957b f420595f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public BaseKeyboardHeightProducer.b f420596g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f420597h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f420598i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f420599j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public BaseKeyboardHeightProducer.b f420600k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f420601l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f420602m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final d f420603n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final c f420604o;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.ss.android.lark.edit.keyboard.producer.b$b, reason: collision with other inner class name */
    public interface InterfaceC4957b {
        void a(BaseKeyboardHeightProducer.b r100);
    }

    static {
    }

    public final void c() {
        Log.i("InsetsKBH#Producer", "start");
        View r100 = this.f420594e;
        Intrinsics.checkNotNullParameter(r100, BaseSwitches.V);
        if (a().isShowing() == true) goto L20;
        a().setBackgroundDrawable(new ColorDrawable(0));
        PopupWindow r101 = a();     // Catch: Throwable -> L18
        if (PopupWindowLancet.hasSubWindowToken(r100) == false) goto L9;
    L24:
        goto L20
    L9:
        if ((r101 instanceof PopupWindow) == true) goto L11;
    L13:
        OverlaySource r102 = PopupWindowLancet.resolveSource(r100);     // Catch: Throwable -> L18
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r101, r100, r102, 0, 0, 0) == true) goto L24;
        r101.showAtLocation(r100, 0, 0, 0);     // Catch: Throwable -> L18
        PopupWindowLancet.trackAfterShow(r101, r102, r100);     // Catch: Throwable -> L18
        goto L24
    L11:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r101) == false) goto L13;
        r101.showAtLocation(r100, 0, 0, 0);     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        Log.e("BaseBaseKBH#Producer", "showPopupWindow err =" + th.getMessage() + ';');
    L20:
        View r103 = a().getContentView();
        ViewCompat.setOnApplyWindowInsetsListener(r103.getRootView(), null);
        View r104 = r103.getRootView();
        if (r104 == null) goto L27;
        Intrinsics.checkNotNullParameter(r104, "insertsView");
        ViewCompat.setOnApplyWindowInsetsListener(r104, new com.ss.android.lark.edit.keyboard.producer.a(this));
        return;
    }

    public final void b(BaseKeyboardHeightProducer.b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (this.f420588d == null) goto L7;
        this.f420600k = r100;
        e.f537198a.removeCallbacks(this.f420604o);
        Long r101 = this.f420588d;
        if (r101 == null) goto L9;
        long r102 = r101.longValue();
        Log.i("InsetsKBH#Producer", "notify Delayed " + this.f420588d + ' ');
        e.a(this.f420604o, r102);
        return;
    L9:
        return;
    L7:
        this.f420595f.a(r100);
    }

    public b(Activity r100, View r101, pcb.b.a r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "activityContentView");
        Intrinsics.checkNotNullParameter(r102, "listener");
        super(r100);
        this.f420594e = r101;
        this.f420595f = r102;
        this.f420602m = LazyKt.lazy(KeyboardHeightProducer$fgOnNotifyNot0$2.INSTANCE);
        this.f420603n = new d(this);
        this.f420604o = new c(this);
    }
}
