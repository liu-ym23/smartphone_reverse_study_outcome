package com.larus.avlink.env.diary.detail;

import android.app.Activity;
import android.content.Context;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import androidx.fragment.app.Fragment;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.bmhome.view.screenmenu.CommonMenu;
import com.larus.bmhome.view.textview.impl.CustomMarkdownTextView;
import com.larus.chat.common.databinding.LarusLayoutMessageMenuNewBinding;
import com.larus.nova.R;
import com.larus.platform.api.creation.TplType;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.skydoves.balloon.Balloon;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class w implements sr9.e0, st8.b.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Fragment f292042a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CustomMarkdownTextView f292043b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f292044c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Balloon f292045d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f292046e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f292047f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f292048g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f292049h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f292050i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final y f292051j;

    public static final class a {
    }

    static {
    }

    @Override // sr9.e0
    public final void l0(CommonMenu r100) {
        Intrinsics.checkNotNullParameter(r100, TplType.MENU);
    }

    public final void d() {
        CustomMarkdownTextView r100 = this.f292043b;
        r100.getClass();
        Context r101 = r100.getContext();
        final View r102 = null;
        if ((r101 instanceof Activity) == false) goto L5;
        Activity r103 = (Activity) r101;
    L6:
        if (r103 == null) goto L14;
        Window r104 = r103.getWindow();
        if (r104 == null) goto L14;
        r102 = r104.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L14;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r105 = ThreadMethodProxy.currentThread();
        if (r105 == com.larus.home.impl.utils.c.f346341a) goto L14;
        com.larus.home.impl.utils.c.a(r105, "getDecorView");
    L14:
        if (r102 == null) goto L17;
        r102.post(new r(this, r102));
        return;
    L17:
        return;
    L5:
        r103 = null;
        goto L6
    }

    @Override // st8.b.c
    public final void onShow() {
        if (this.f292047f == false) goto L5;
        return;
    L5:
        this.f292048g = true;
        FLogger.f375446a.i("DiaryMenuTrigger", SendEventContainerMethodParamModel.EventKinds.onShow);
        c(this.f292043b.getContext());
        d();
    }

    @Override // st8.b.c
    public final void a(boolean r100) {
        b(r100, false);
    }

    public final void c(Context r100) {
        LarusLayoutMessageMenuNewBinding r101 = LarusLayoutMessageMenuNewBinding.a(LayoutInflater.from(r100));
        e1.x(r101.f324024f);
        e1.o(r101.f324026h);
        e1.o(r101.f324027i);
        this.f292043b.A(this.f292051j);
        this.f292043b.x(this.f292051j);
        Balloon r102 = this.f292045d;
        if (r102 == null) goto L5;
        r102.h();
    L5:
        tt8.b r103 = this.f292043b.m8544getTextSelector();
        if (r103 == null) goto L9;
        r103.E = this;
        return;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(ot8.a r100) {
        ot8.a r101 = r100;
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        int r102 = r101.getId();
        if (r102 != R.string.larus_message_long_press_copy) goto L9;
        CustomMarkdownTextView r103 = this.f292043b;     // Catch: Exception -> L7
        r103.G3(r103.getMarkdownContent(), true);     // Catch: Exception -> L7
        CustomMarkdownTextView r104 = this.f292043b;     // Catch: Exception -> L7
        r104.getClass();     // Catch: Exception -> L7
        r104.clearFocus();     // Catch: Exception -> L7
        t19.s r105 = t19.s.f544207a;     // Catch: Exception -> L7
        Context r106 = this.f292042a.getContext();     // Catch: Exception -> L7
        r105.getClass();     // Catch: Exception -> L7
        t19.s.o(r106, R.string.larus_text_copied_tip, false);     // Catch: Exception -> L7
        this.f292044c.invoke();     // Catch: Exception -> L7
    L21:
        return Unit.INSTANCE;
    L7:
        t19.s r107 = t19.s.f544207a;
        Context r108 = this.f292042a.getContext();
        r107.getClass();
        t19.s.s(r108, R.string.larus_text_copied_tip);
        goto L21
    L9:
        if (r102 != R.string.larus_message_long_press_select_text) goto L21;
        this.f292044c.invoke();
        Context r109 = this.f292042a.getContext();
        if (r109 == null) goto L21;
        c(r109);
        tt8.b r110 = this.f292043b.m8544getTextSelector();
        if (r110 == null) goto L16;
        r110.f551672s = (x) this.f292050i.getValue();
    L16:
        tt8.b r111 = this.f292043b.m8544getTextSelector();
        if (r111 == null) goto L19;
        r111.r((int) this.f292043b.getClickX(), (int) this.f292043b.getClickY(), 2, false);
    L19:
        d();
        goto L21
    }

    public final void b(boolean r100, boolean r101) {
        if (r100 == true) goto L12;
        if (r101 == true) goto L12;
        long r102 = SystemClock.elapsedRealtime();
        if ((r102 - this.f292049h) <= 300) goto L12;
        this.f292049h = r102;
        Balloon r103 = this.f292045d;
        boolean r104 = false;
        if (r103 != null) goto L9;
    L11:
        this.f292048g = r104;
        goto L12
    L9:
        if (r103.f406024g != true) goto L11;
        r104 = true;
    L12:
        FLogger.f375446a.i("DiaryMenuTrigger", "onDismiss");
        Balloon r105 = this.f292045d;
        if (r105 == null) goto L15;
        r105.h();
    L15:
        this.f292045d = null;
    }

    public w(Fragment r100, CustomMarkdownTextView r101, z r102) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        Intrinsics.checkNotNullParameter(r101, "markdownView");
        Intrinsics.checkNotNullParameter(r102, "onDismiss");
        this.f292042a = r100;
        this.f292043b = r101;
        this.f292044c = r102;
        this.f292048g = true;
        this.f292050i = LazyKt.lazy(new q(this));
        this.f292051j = new y(this);
    }
}
