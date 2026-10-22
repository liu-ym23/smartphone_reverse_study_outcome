package e5a;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.widget.FrameLayout;
import com.lynx.clay.embedding.engine.mutatorsstack.FlutterMutatorsStack;
import com.lynx.clay.util.d;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes32.dex */
public final class a extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public FlutterMutatorsStack f471079a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f471080b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f471081c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f471082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f471083e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f471084f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public b f471085g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.lynx.clay.embedding.android.b f471086h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ViewTreeObserverOnGlobalFocusChangeListenerC5743a f471087i;

    /* JADX INFO: renamed from: e5a.a$a, reason: collision with other inner class name */
    public class ViewTreeObserverOnGlobalFocusChangeListenerC5743a implements ViewTreeObserver.OnGlobalFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View.OnFocusChangeListener f471088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ View f471089b;

        public ViewTreeObserverOnGlobalFocusChangeListenerC5743a(View.OnFocusChangeListener r100, View r101) {
            this.f471088a = r100;
            this.f471089b = r101;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalFocusChangeListener
        public final void onGlobalFocusChanged(View r100, View r101) {
            View.OnFocusChangeListener r102 = this.f471088a;
            View r103 = this.f471089b;
            r102.onFocusChange(r103, d.b(r103, new com.lynx.clay.util.b()));
        }
    }

    public interface b {
        void a(MotionEvent r100, boolean r101);
    }

    private Matrix getPlatformViewMatrix() {
        Matrix r100 = new Matrix(this.f471079a.f380752c);
        r100.postTranslate(-this.f471080b, -this.f471081c);
        return r100;
    }

    public a(Context r100) {
        this(r100, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas r100) {
        r100.save();
        r100.concat(getPlatformViewMatrix());
        super.dispatchDraw(r100);
        r100.restore();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent r100) {
        if (this.f471084f == false) goto L5;
        boolean r101 = super.dispatchTouchEvent(r100);
        b r102 = this.f471085g;
        if (r102 == null) goto L9;
        r102.a(r100, r101);
    L9:
        return r101;
    L5:
        return super.dispatchTouchEvent(r100);
    }

    @Override // android.view.View
    public final void draw(Canvas r100) {
        r100.save();
        Iterator r101 = ((ArrayList) this.f471079a.f380751b).iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Path r102 = new Path((Path) r101.next());
        r102.offset(-this.f471080b, -this.f471081c);
        r100.clipPath(r102);
        goto L4
    L6:
        super.draw(r100);
        r100.restore();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent r100) {
        if (this.f471084f == false) goto L6;
        return false;
    L6:
        return true;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        if (this.f471084f == false) goto L7;
        return false;
    L7:
        if (this.f471086h == null) goto L18;
        Matrix r101 = new Matrix();
        int r102 = r100.getAction();
        if (r102 != 0) goto L12;
        int r103 = this.f471080b;
        this.f471082d = r103;
        int r104 = this.f471081c;
        this.f471083e = r104;
        r101.postTranslate(r103, r104);
    L17:
        return this.f471086h.d(r100, r101);
    L12:
        if (r102 == 2) goto L14;
        r101.postTranslate(this.f471080b, this.f471081c);
        goto L17
    L14:
        r101.postTranslate(this.f471082d, this.f471083e);
        this.f471082d = this.f471080b;
        this.f471083e = this.f471081c;
        goto L17
    L18:
        return super.onTouchEvent(r100);
    }

    public void setOnDescendantFocusChangeListener(View.OnFocusChangeListener r100) {
        ViewTreeObserver r101 = getViewTreeObserver();
        if (r101.isAlive() == false) goto L7;
        ViewTreeObserverOnGlobalFocusChangeListenerC5743a r102 = this.f471087i;
        if (r102 == null) goto L7;
        this.f471087i = null;
        r101.removeOnGlobalFocusChangeListener(r102);
    L7:
        ViewTreeObserver r103 = getViewTreeObserver();
        if (r103.isAlive() == true) goto L10;
        return;
    L10:
        if (this.f471087i != null) goto L14;
        ViewTreeObserverOnGlobalFocusChangeListenerC5743a r104 = new ViewTreeObserverOnGlobalFocusChangeListenerC5743a(r100, this);
        this.f471087i = r104;
        r103.addOnGlobalFocusChangeListener(r104);
        return;
    }

    public void setSystemTouchDispatchEnabled(boolean r100) {
        this.f471084f = r100;
    }

    public void setTouchDispatchResultListener(b r100) {
        this.f471085g = r100;
    }

    public a(Context r100, com.lynx.clay.embedding.android.b r101) {
        super(r100, null);
        this.f471084f = false;
        this.f471086h = r101;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestSendAccessibilityEvent(View r100, AccessibilityEvent r101) {
        View r102 = getChildAt(0);
        if (r102 == null) goto L8;
        if (r102.getImportantForAccessibility() != 4) goto L8;
        return false;
    L8:
        return super.requestSendAccessibilityEvent(r100, r101);
    }
}
