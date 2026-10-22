package com.bytedance.android.shopping.deepfeed.slice.view.live;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.bytedance.android.ec.adapter.api.IAdapterService;
import com.bytedance.android.ec.adapter.api.model.ECLiveMode;
import com.bytedance.android.ec.adapter.api.player.IECLivePlayerClient;
import com.bytedance.android.ec.adapter.api.player.IECPlayerViewService;
import com.bytedance.android.ec.core.utils.y0;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ecom.arch.slice.render.context.SlcTemplateContext;
import com.bytedance.android.ecom.arch.slice.render.widget.roundcorner.SlcRoundFrameLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends SlcRoundFrameLayout {
    public final SimpleDraweeView c;
    public final FrameLayout d;
    public le.b e;
    public SlcTemplateContext f;
    public com.bytedance.android.shopping.deepfeed.slice.view.e g;
    public boolean h;
    public boolean i;
    public final a j;

    public static final class a implements com.bytedance.android.shopping.deepfeed.slice.service.a {
        public final /* synthetic */ b a;

        @Override // com.bytedance.android.shopping.deepfeed.slice.service.a
        public final void onDestroy() {
            b r0 = this.a;
            r0.g();
            r0.e();
            r0.g = new com.bytedance.android.shopping.deepfeed.slice.view.e(0);
        }

        @Override // com.bytedance.android.shopping.deepfeed.slice.service.a
        public final void onPause() {
            this.a.g();
        }

        @Override // com.bytedance.android.shopping.deepfeed.slice.service.a
        public final void onResume() {
            SlcRoundFrameLayout r0 = this.a;
            r0.getClass();
            if (ViewCompat.isAttachedToWindow(r0) == true) goto L5;
            return;
        L5:
            b r1 = this.a;
            if (r1.e != null) goto L10;
            com.bytedance.android.shopping.deepfeed.slice.view.e r2 = r1.g;
            if (r2.e == false) goto L10;
            r1.c(r2);
        L10:
            b r3 = this.a;
            r3.h(r3.g);
        }

        @Override // com.bytedance.android.shopping.deepfeed.slice.service.a
        public final void onStop() {
            this.a.g();
        }

        public a(b r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.slice.view.live.b$b, reason: collision with other inner class name */
    public static final class C0057b<T> implements Observer {
        public final /* synthetic */ b a;
        public final /* synthetic */ LifecycleOwner b;

        public C0057b(b r1, LifecycleOwner r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.booleanValue() == false) goto L11;
            b r4 = this.a;
            r4.i = true;
            r4.c.setVisibility(8);
            com.bytedance.android.shopping.deepfeed.slice.service.b r5 = this.a.b();
            if (r5 == null) goto L12;
            r5.H();
            return;
        L12:
            return;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ b a;
        public final /* synthetic */ LifecycleOwner b;

        public c(b r1, LifecycleOwner r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r2) {
            Boolean r3 = (Boolean) r2;
            if (r3 != null) goto L5;
            return;
        L5:
            if (r3.booleanValue() == false) goto L11;
            b r4 = this.a;
            if (r4.i == false) goto L12;
            r4.c.setVisibility(8);
            return;
        L12:
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ b a;
        public final /* synthetic */ LifecycleOwner b;

        public d(b r1, LifecycleOwner r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            if (r2 != null) goto L5;
            return;
        L5:
            if (r2.booleanValue() == false) goto L9;
            this.a.f();
            return;
        }
    }

    public static final class e<T> implements Observer {
        public final /* synthetic */ b a;
        public final /* synthetic */ LifecycleOwner b;

        public e(b r1, LifecycleOwner r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            if (r2 != null) goto L5;
            return;
        L5:
            if (r2.booleanValue() == false) goto L9;
            this.a.f();
            return;
        }
    }

    public static final class f<T> implements Observer {
        public final /* synthetic */ b a;
        public final /* synthetic */ LifecycleOwner b;

        public f(b r1, LifecycleOwner r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            if (r2 != null) goto L5;
            return;
        L5:
            if (r2.booleanValue() == false) goto L9;
            this.a.f();
            return;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ b a;
        public final /* synthetic */ LifecycleOwner b;

        public g(b r1, LifecycleOwner r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r1) {
            Boolean r2 = (Boolean) r1;
            if (r2 != null) goto L5;
            return;
        L5:
            if (r2.booleanValue() == false) goto L9;
            this.a.f();
            return;
        }
    }

    public static final class h<T> implements Observer {
        public final /* synthetic */ b a;
        public final /* synthetic */ LifecycleOwner b;

        public h(b r1, LifecycleOwner r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r1) {
            String r2 = (String) r1;
            this.a.f();
        }
    }

    public final void f() {
        this.i = false;
        this.c.setVisibility(0);
    }

    public final com.bytedance.android.shopping.deepfeed.slice.service.b b() {
        SlcTemplateContext r0 = this.f;
        Object r1 = null;
        if (r0 == null) goto L10;
        Object r2 = r0.o(com.bytedance.android.shopping.deepfeed.slice.service.b.class);
        if ((r2 instanceof com.bytedance.android.shopping.deepfeed.slice.service.b) == false) goto L9;
        r1 = r2;
    L9:
        return (com.bytedance.android.shopping.deepfeed.slice.service.b) r1;
    L10:
        return null;
    }

    public final void d() {
        if (this.h == false) goto L5;
        return;
    L5:
        LifecycleOwner r0 = getLifeCycleOwner();
        if (r0 != null) goto L8;
        return;
    L8:
        le.b r1 = this.e;
        if (r1 == null) goto L14;
        IECLivePlayerClient r2 = r1.a();
        if (r2 == null) goto L15;
        this.h = true;
        td.e r3 = r2.getEventHub();
        r3.getFirstFrame().observe(r0, new C0057b(this, r0));
        r3.getPlayResume().observe(r0, new c(this, r0));
        r3.getStopped().observe(r0, new d(this, r0));
        r3.getReleased().observe(r0, new e(this, r0));
        r3.getPlayComplete().observe(r0, new f(this, r0));
        r3.getLiveEnd().observe(r0, new g(this, r0));
        r3.getPlayerMediaError().observe(r0, new h(this, r0));
        return;
    L15:
        return;
    }

    public final void e() {
        this.d.removeAllViews();
        le.b r0 = this.e;
        if (r0 == null) goto L7;
        IECLivePlayerClient r1 = r0.a();
        if (r1 == null) goto L7;
        r1.release();
    L7:
        this.e = null;
        this.h = false;
        this.i = false;
    }

    public final void g() {
        le.b r0 = this.e;
        if (r0 == null) goto L8;
        IECLivePlayerClient r1 = r0.a();
        if (r1 == null) goto L9;
        r1.stop();
        return;
    L9:
        return;
    }

    private final LifecycleOwner getLifeCycleOwner() {
        com.bytedance.android.shopping.deepfeed.slice.service.b r0 = b();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.k();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachedToWindow() {
        super/*android.widget.FrameLayout*/.onAttachedToWindow();
        if (this.e != null) goto L12;
        com.bytedance.android.shopping.deepfeed.slice.view.e r0 = this.g;
        if (r0.e == false) goto L12;
        if (r0.a.length() <= 0) goto L9;
        boolean r1 = true;
    L10:
        if (r1 == false) goto L12;
        c(this.g);
        goto L12
    L9:
        r1 = false;
    L12:
        h(this.g);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onDetachedFromWindow() {
        super/*android.widget.FrameLayout*/.onDetachedFromWindow();
        g();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        ViewGroup.LayoutParams r0 = null;
        super(r5, null, 6, 0);
        this.g = new com.bytedance.android.shopping.deepfeed.slice.view.e(0);
        this.j = new a(this);
        FrameLayout.inflate(r5, 2131564643, this);
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        SimpleDraweeView r6 = findViewById(2131368160);
        this.c = r6;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
        if ((r7 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r7 = null;
    L5:
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r7;
        if (r8 == null) goto L8;
        r8.topMargin = 0;
        r8.height = -1;
    L8:
        FrameLayout r9 = (FrameLayout) findViewById(2131378261);
        this.d = r9;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        if ((r10 instanceof ViewGroup.MarginLayoutParams) == false) goto L12;
        r0 = r10;
    L12:
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        if (r1 == null) goto L16;
        r1.topMargin = 0;
        r1.height = -1;
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void c(com.bytedance.android.shopping.deepfeed.slice.view.e r13) {
        if (y0.a() == true) goto L5;
        return;
    L5:
        f();
        String r14 = r13.a;
        if (r14.length() <= 0) goto L8;
        boolean r0 = true;
    L9:
        le.b r2 = null;
        if (r0 == false) goto L12;
        String r7 = r14;
    L13:
        if (r7 == null) goto L23;
        int r15 = ECSdk.a;
        IAdapterService r16 = (IAdapterService) ECSdk.a(IAdapterService.class);
        if (r16 == null) goto L19;
        IECPlayerViewService r3 = r16.getPlayerViewService();
        if (r3 == null) goto L19;
        le.b r17 = IECPlayerViewService.a.a(r3, getContext(), null, 0, r7, "ec_feed_deepfeed", false, false, 384);
    L20:
        if (r17 == null) goto L23;
        com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d r1 = (com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d) r17;
        r1.setScaleType(2);
        r1.b.setVisibility(0);
        r2 = r17;
    L19:
        r17 = null;
    L23:
        if (r2 == null) goto L26;
        this.e = r2;
        FrameLayout.LayoutParams r18 = new FrameLayout.LayoutParams(-1, -1);
        r18.gravity = 17;
        this.d.addView(((com.bytedance.android.ec.adapter.impl.adapters.reverse.player.d) r2).b, r18);
        d();
        return;
    L26:
        return;
    L12:
        r7 = null;
        goto L13
    L8:
        r0 = false;
        goto L9
    }

    public final void h(com.bytedance.android.shopping.deepfeed.slice.view.e r6) {
        if (r6.f == true) goto L5;
    L24:
        g();
        return;
    L5:
        if (r6.e == false) goto L24;
        Intrinsics.checkNotNullParameter(r6, "data");
        le.b r1 = this.e;
        if (r1 == null) goto L9;
        IECLivePlayerClient r2 = r1.a();
    L11:
        if (r6.b.length() != 0) goto L13;
        boolean r3 = true;
    L14:
        if (r3 == false) goto L17;
        return;
    L17:
        if (r6.f == true) goto L19;
        return;
    L19:
        if (r6.e == false) goto L30;
        le.a.a r4 = new le.a.a();
        String r5 = r6.b;
        Intrinsics.checkNotNullParameter(r5, "data");
        r4.a = r5;
        ECLiveMode r0 = ECLiveMode.MEDIA;
        Intrinsics.checkNotNullParameter(r0, "streamType");
        r4.c = r0;
        r4.h = r6.d;
        r4.f = true;
        le.a r7 = r4.a();
        if (r2 == null) goto L27;
        r2.stream(r7, DeepFeedSliceLiveView$stream$1.INSTANCE);
        return;
    L27:
        return;
    L30:
        return;
    L13:
        r3 = false;
        goto L14
    L9:
        r2 = null;
        goto L11
    }
}
