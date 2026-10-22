package com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.core.os.HandlerCompat;
import com.ss.android.lark.utils.s0;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public final class AudioPopupWindowImpl implements com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f429943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f429944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final FrameLayout f429945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.a f429946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Drawable f429947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f429948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f429949h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Runnable f429950i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Handler f429951j;

    public static final class a {
    }

    public static final class b extends ViewGroup {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f429952a;

        public static final class a extends ViewGroup.LayoutParams {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final int f429953a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f429954b;

            public a(int r100, int r101, int r102, int r103) {
                super(r100, r101);
                this.f429953a = r102;
                this.f429954b = r103;
            }
        }

        @Override // android.view.ViewGroup
        public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
            return new a(-1, -2, 0, 0);
        }

        public b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
            this.f429952a = new int[2];
        }

        @Override // android.view.View
        public final void onMeasure(int r100, int r101) {
            measureChildren(r100, r101);
            super.onMeasure(r100, r101);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
            int r105 = getChildCount();
            int r106 = 0;
        L3:
            if (r106 >= r105) goto L19;
            View r107 = getChildAt(r106);
            if (r107 == null) goto L18;
            if (8 == r107.getVisibility()) goto L18;
            ViewGroup.LayoutParams r108 = r107.getLayoutParams();
            Intrinsics.checkNotNull(r108, "null cannot be cast to non-null type com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.AudioPopupWindowImpl.PopupDecorView.LayoutConfig");
            a r109 = (a) r108;
            if ((r109.f429953a & 112) == 80) goto L13;
            int r110 = r109.f429954b;
        L17:
            r107.layout(0, r110, r107.getMeasuredWidth(), r107.getMeasuredHeight() + r110);
            goto L18
        L13:
            if (r109.f429954b != 0) goto L15;
            r110 = (r104 - r102) - r107.getMeasuredHeight();
            goto L17
        L15:
            getLocationInWindow(this.f429952a);
            r110 = ((r104 - this.f429952a[1]) - r107.getMeasuredHeight()) - r109.f429954b;
        L18:
            r106 = r106 + 1;
            goto L3
        }
    }

    static {
    }

    public final void a() {
        this.f429948g = true;
        com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.a r100 = this.f429946e;
        if (r100 == null) goto L6;
        r100.t5(new AudioPopupWindowImpl$dismiss$1(this));
        return;
    }

    public final void c() {
        this.f429951j.removeCallbacksAndMessages(null);
        this.f429948g = false;
        this.f429949h = true;
        c r100 = new c(this);
        this.f429950i = r100;
        this.f429951j.post(new s0.a(r100));
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b
    public final boolean isShown() {
        if (this.f429944c.getParent() == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.b
    public final b s7() {
        return this.f429944c;
    }

    public final void b(com.ss.android.lark.keyboard.plugin.tool.voice.audio2.popup.abs.a r100) {
        Intrinsics.checkNotNullParameter(r100, "audioPopupView");
        if (isShown() == true) goto L6;
        this.f429946e = r100;
        return;
    }

    public AudioPopupWindowImpl(Context r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "containerProvider");
        this.f429943b = r101;
        b r102 = new b(r100);
        this.f429944c = r102;
        this.f429945d = new FrameLayout(r102.getContext());
        this.f429951j = HandlerCompat.createAsync(Looper.getMainLooper());
    }
}
