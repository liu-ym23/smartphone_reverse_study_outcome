package com.larus.uaigc.createpage.bussiness.remove.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.viewbinding.ViewBindings;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.uaigc.createpage.bussiness.remove.i;
import com.larus.uaigc.impl.databinding.LarusWidgetImageEditPaletteControllerBinding;
import com.ss.android.lark.utils.statistics.PerfLog;
import jz9.d;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n*\u0001\u0013\u0018\u0000 \u001f2\u00020\u0001:\u0002\u001e\u001fB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\f\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0011J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0011J\u0006\u0010\u001a\u001a\u00020\u0007J\b\u0010\u001b\u001a\u00020\u0016H\u0014J\b\u0010\u001c\u001a\u00020\u0016H\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006 "}, d2 = {"Lcom/larus/uaigc/createpage/bussiness/remove/widget/PaletteControllerView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusWidgetImageEditPaletteControllerBinding;", "config", "Lcom/larus/uaigc/createpage/bussiness/remove/widget/PaletteControllerView$Config;", "longUndoHandler", "Landroid/os/Handler;", "isRepeatingUndo", "", "repeatUndoRunnable", "com/larus/uaigc/createpage/bussiness/remove/widget/PaletteControllerView$repeatUndoRunnable$1", "Lcom/larus/uaigc/createpage/bussiness/remove/widget/PaletteControllerView$repeatUndoRunnable$1;", "setConfig", "", "refreshUndo", "enable", "refreshRedo", "currentProgress", "onDetachedFromWindow", "startRepeatUndo", "stopRepeatUndo", "Config", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PaletteControllerView extends LinearLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f371505f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusWidgetImageEditPaletteControllerBinding f371506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f371507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Handler f371508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f371509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f371510e;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PaintSizeControllerView.b f371511a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Function0<Unit> f371512b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function0<Unit> f371513c;

        public b(PaintSizeControllerView.b r100, com.larus.uaigc.createpage.bussiness.remove.a r101, i r102) {
            this.f371511a = r100;
            this.f371512b = r101;
            this.f371513c = r102;
        }
    }

    public static final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ PaletteControllerView f371514a;

        @Override // java.lang.Runnable
        public final void run() {
            PaletteControllerView r100 = this.f371514a;     // Catch: Throwable -> L15
            if (r100.f371509d == true) goto L5;
        L13:
            PaletteControllerView r101 = this.f371514a;     // Catch: Throwable -> L15
            r101.f371509d = false;     // Catch: Throwable -> L15
            r101.f371508c.removeCallbacks(r101.f371510e);     // Catch: Throwable -> L15
            return;
        L5:
            if (r100.f371506a.f373264d.isEnabled() == false) goto L13;
            b r102 = this.f371514a.f371507b;     // Catch: Throwable -> L15
            if (r102 == null) goto L12;
            Function0<Unit> r103 = r102.f371512b;     // Catch: Throwable -> L15
            if (r103 == null) goto L12;
            r103.invoke();     // Catch: Throwable -> L15
        L12:
            this.f371514a.f371508c.postDelayed(this, 100);     // Catch: Throwable -> L15
            return;
        L15:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L21;
            throw th;
        }

        public c(PaletteControllerView r100) {
            this.f371514a = r100;
        }
    }

    static {
    }

    public PaletteControllerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public PaletteControllerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f371509d = false;
        this.f371508c.removeCallbacks(this.f371510e);
        super.onDetachedFromWindow();
    }

    public final void setConfig(b r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f371507b = r100;
        PaintSizeControllerView.b r101 = r100.f371511a;
        if (r101 == null) goto L6;
        this.f371506a.f373262b.setConfig(r101);
        return;
    }

    public PaletteControllerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        LayoutInflater.from(r100).inflate(R.layout.larus_widget_image_edit_palette_controller, this);
        int r103 = R.id.paint_size_seekbar;
        PaintSizeControllerView r104 = (PaintSizeControllerView) ViewBindings.findChildViewById(this, R.id.paint_size_seekbar);
        if (r104 == null) goto L11;
        r103 = R.id.redo_btn;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.redo_btn);
        if (r105 == null) goto L11;
        r103 = R.id.undo_btn;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(this, R.id.undo_btn);
        if (r106 == null) goto L11;
        this.f371506a = new LarusWidgetImageEditPaletteControllerBinding(this, r104, r105, r106);
        this.f371508c = new Handler(Looper.getMainLooper());
        this.f371510e = new c(this);
        r106.setOnClickListener(new jz9.a(this));
        r106.setOnLongClickListener(new jz9.b(this));
        r106.setOnTouchListener(new jz9.c(this));
        r105.setOnClickListener(new d(this));
        return;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r103)));
    }

    public /* synthetic */ PaletteControllerView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
