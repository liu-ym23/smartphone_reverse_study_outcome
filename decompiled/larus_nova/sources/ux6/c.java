package ux6;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.crash.d;
import com.bytedance.locallife.photo.internal.photodraweeview.DismissAnimationType;
import com.bytedance.locallife.photo.internal.photodraweeview.IIndicatorView;
import com.bytedance.locallife.photo.internal.photodraweeview.PhotoViewerDialog$3;
import com.bytedance.locallife.photo.internal.photodraweeview.PhotoViewerDialog$initAdapter$2;
import com.bytedance.locallife.photo.internal.photodraweeview.transition.TransitionPagerAdapter;
import com.bytedance.locallife.photo.photodraweeview.PoiPhotoTransitionPagerAdapter;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes21.dex */
public class c extends Dialog {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f552003i = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TransitionPagerAdapter<?> f552004a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final RecyclerView f552005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final FrameLayout f552006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public ux6.a f552007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f552008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ArrayList<IIndicatorView> f552009f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f552010g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f552011h;

    public static final class a implements DialogInterface.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f552012a;

        public a(c r100) {
            this.f552012a = r100;
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r100, int r101, KeyEvent r102) {
            if (r101 == 4) goto L5;
        L7:
            return false;
        L5:
            if (r102.getAction() != 1) goto L7;
            this.f552012a.onBackPressed();
            return true;
        }
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        if (isShowing() == false) goto L24;
        this.f552004a.onDestroy();
        ux6.a r100 = this.f552007d;
        if (r100 == null) goto L7;
        r100.a();
    L7:
        Handler r101 = DialogLancet.resolveDialogHandler(this);
        if (r101 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(this);
        return;
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L17:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r102 == null) goto L21;
        d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        goto L21
    L10:
        if (Looper.myLooper() == r101.getLooper()) goto L12;
        r101.post(DialogLancet.createDismissRunnable(this));
        return;
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        Handler r100 = DialogLancet.resolveDialogHandler(this);
        if (r100 != null) goto L5;
    L7:
        DialogLancet.beforeDialogDismiss(this);
        dismiss();     // Catch: Throwable -> L10 Exception -> L12
    L16:
        DialogLancet.afterDialogDismiss(this);
        return;
    L12:
        e = move-exception;
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
        Throwable r101 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
        if (r101 == null) goto L16;
        d.d(r101, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L5:
        if (Looper.myLooper() == r100.getLooper()) goto L7;
        r100.post(DialogLancet.createDismissRunnable(this));
    }

    public static View a(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void b(IIndicatorView r100) {
        Intrinsics.checkNotNullParameter(r100, "indicatorView");
        this.f552009f.add(r100);
        this.f552006c.addView((View) r100);
        r100.onAttach(this.f552008e, this.f552004a);
    }

    public final void c(boolean r100) {
        Iterator<T> r101 = this.f552009f.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        IIndicatorView r102 = (IIndicatorView) r101.next();
        r102.onPageSelected(this.f552008e);
        r102.onPageSelected(this.f552008e, r100);
        goto L4
    }

    public final void d(int r100) {
        if (isShowing() == true) goto L18;
        int r101 = RangesKt.coerceIn(r100, 0, Math.max(0, this.f552004a.getItemCount() - 1));
        this.f552008e = r101;
        this.f552004a.getClass();
        this.f552005b.scrollToPosition(r101);
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L16;
        DialogLancet.handleBlockedDialogShow(this);
    L9:
        Drawable r102 = this.f552006c.getBackground();
        if (r102 == null) goto L13;
        r102.setAlpha(255);
    L13:
        this.f552011h = 1.0f;
        c(false);
        return;
    L16:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L15
    L8:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L9
    }

    @Override // android.app.Dialog
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        Window r101 = getWindow();
        if (r101 == null) goto L5;
        r101.requestFeature(1);
    L5:
        setContentView(this.f552006c);
        Window r102 = getWindow();
        if (r102 != null) goto L8;
        return;
    L8:
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r102.setLayout(-1, -1);
        r102.setBackgroundDrawable(new ColorDrawable(0));
        r102.clearFlags(2);
        int r104 = Build.VERSION.SDK_INT;
        r102.addFlags(Integer.MIN_VALUE);
        a(r102).setSystemUiVisibility(1280);
        if (r104 <= 28) goto L11;
        r103.layoutInDisplayCutoutMode = 1;
    L11:
        this.f552006c.setBackgroundColor(getContext().getResources().getColor(R.color.black));
        if (this.f552010g == false) goto L18;
        Drawable r105 = this.f552006c.getBackground();
        if (r105 == null) goto L17;
        r105.setAlpha(0);
    L17:
        this.f552011h = 0.0f;
    L18:
        a(r102).setPadding(0, 0, 0, 0);
        setOnKeyListener(new a(this));
    }

    public c(Context r100, PoiPhotoTransitionPagerAdapter r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "transitionAdapter");
        super(r100);
        this.f552004a = r101;
        FrameLayout r102 = new FrameLayout(r100);
        r102.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f552006c = r102;
        DismissAnimationType r103 = DismissAnimationType.BG_ALPHA_IMG_ALPHA;
        new Rect();
        this.f552009f = new ArrayList();
        this.f552011h = 1.0f;
        RecyclerView r104 = new RecyclerView(r100);
        r104.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f552005b = r104;
        LinearLayoutManager r105 = new LinearLayoutManager(r100);
        r105.setOrientation(0);
        r104.setLayoutManager(r105);
        new PagerSnapHelper().attachToRecyclerView(r104);
        r102.addView(r104, 0);
        r104.addOnScrollListener(new PhotoViewerDialog$3(this));
        r104.setAdapter(r101);
        r101.f262040a = new b(this);
        r101.registerAdapterDataObserver(new PhotoViewerDialog$initAdapter$2(this));
    }
}
