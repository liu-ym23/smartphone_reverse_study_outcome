package com.ss.android.lark.widget.recyclerview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.inputmethod.InputMethodManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.doubao.relax.profile.edit.ProfileEditRelaxPage;
import com.larksuite.framework.utils.DevEnvUtil;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.desktopmode.utils.DesktopUtil;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.statistics.PerfLog;
import et3.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import rcc.d;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0015\b\u0016\u0018\u0000 >2\u00020\u0001:\u0002>?B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0014J\b\u0010#\u001a\u00020!H\u0014J\b\u0010$\u001a\u00020!H\u0002J\n\u0010%\u001a\u0004\u0018\u00010\u000fH\u0016J\u000e\u0010&\u001a\u00020!2\u0006\u0010'\u001a\u00020\u000fJ\u001a\u0010(\u001a\u00020!2\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020+0*J\u0006\u0010,\u001a\u00020!J\b\u0010-\u001a\u00020!H\u0002J\u000e\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020\u001bJ\u0006\u00100\u001a\u00020!J\n\u00101\u001a\u0004\u0018\u00010\u0018H\u0002J\u000e\u00102\u001a\u00020!2\u0006\u00103\u001a\u00020\rJ\u000e\u00104\u001a\u00020!2\u0006\u00105\u001a\u00020\rJ(\u00106\u001a\u00020!2\u0006\u00107\u001a\u00020\n2\u0006\u00108\u001a\u00020\n2\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\nH\u0014J\u0010\u0010;\u001a\u00020!2\u0006\u0010<\u001a\u00020\u001eH\u0007J\u0010\u0010=\u001a\u00020!2\u0006\u0010<\u001a\u00020\u001eH\u0007R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u001e0\u001dj\b\u0012\u0004\u0012\u00020\u001e`\u001fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/ss/android/lark/widget/recyclerview/CommonRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mMonitorFps", "", "mSceneTag", "", "mFpsTracer", "Lcom/bytedance/apm/trace/fps/FpsTracer;", "mExtra", "Lorg/json/JSONObject;", "mScrollStopped", "mOnKeyboardDismissingScrollListener", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "mInputMethodManager", "Landroid/view/inputmethod/InputMethodManager;", "mIsHideKeyBoardOnScroll", "mFpsCallback", "Lcom/ss/android/lark/widget/recyclerview/CommonRecyclerView$IFpsCallback;", "onSizeChangedListeners", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/widget/listener/OnSizeChangeListener;", "Lkotlin/collections/ArrayList;", "initOnKeyboardDismissingListener", "", "onAttachedToWindow", "onDetachedFromWindow", "initFpsTrace", "getSceneTag", "setSceneTag", "sceneTag", "addExtra", "map", "", "", "setupScrollBar", "initFastScroller", "setFpsCallback", "fpsCallback", ProfileEditRelaxPage.METHOD_HIDE_KEYBOARD, "getInputMethodManager", "hideKeyBoardOnScroll", "isEnable", "setMonitorFps", "monitorFps", "onSizeChanged", "w", "h", "oldw", "oldh", "addOnSizeChangedListener", "listener", "removeOnSizeChangedListener", "Companion", "IFpsCallback", "widget_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class CommonRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f448116a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f448117b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public c f448118c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public JSONObject f448119d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f448120e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CommonRecyclerView$initOnKeyboardDismissingListener$1 f448121f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public InputMethodManager f448122g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f448123h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public b f448124i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ArrayList<d> f448125j;

    public static final class a {
    }

    public interface b {
        void a(double r100);
    }

    static {
    }

    private final InputMethodManager getInputMethodManager() {
        if (this.f448122g != null) goto L6;
        this.f448122g = (InputMethodManager) getContext().getSystemService("input_method");
    L6:
        return this.f448122g;
    }

    public String getSceneTag() {
        String r100 = this.f448117b;
        if (r100 == null) goto L5;
        return r100;
    L5:
        String r101 = null;
        Resources r102 = getResources();     // Catch: Exception -> L8
        ViewParent r103 = getParent();     // Catch: Exception -> L8
        Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type android.view.ViewGroup");     // Catch: Exception -> L8
        String r104 = r102.getResourceEntryName(((ViewGroup) r103).getId());     // Catch: Exception -> L8
    L27:
        r101 = getResources().getResourceEntryName(getId());     // Catch: Exception -> L11
    L13:
        if (TextUtils.isEmpty(r104) == true) goto L18;
        if (TextUtils.isEmpty(r101) == true) goto L18;
        r104 = r104 + '/' + r101;
    L20:
        this.f448117b = r104;
        if (TextUtils.isEmpty(r104) == false) goto L24;
        this.f448117b = "CommonRecyclerView";
    L24:
        return this.f448117b;
    L18:
        if (TextUtils.isEmpty(r104) == false) goto L20;
        r104 = r101;
    L8:
        r104 = null;
        goto L27
    }

    public final void hideKeyboard() {
        InputMethodManager r100 = getInputMethodManager();     // Catch: IllegalArgumentException -> L7
        if (r100 == null) goto L5;
        r100.hideSoftInputFromWindow(getWindowToken(), 0);     // Catch: IllegalArgumentException -> L7
    L5:
        clearFocus();     // Catch: IllegalArgumentException -> L7
        return;
    L7:
        e = move-exception;
        Log.e("CommonRecyclerView", "hide keyboard exception:" + e.getMessage());
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.f448116a == true) goto L5;
    L11:
        CommonRecyclerView$initOnKeyboardDismissingListener$1 r100 = this.f448121f;
        if (r100 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mOnKeyboardDismissingScrollListener");
        r100 = null;
    L14:
        addOnScrollListener(r100);
        return;
    L5:
        if (this.f448118c != null) goto L11;
        this.f448118c = new c(getSceneTag(), DevEnvUtil.isDevelopPackage(getContext()), this.f448119d);
        WeakReference r101 = new WeakReference(this);
        WeakReference r102 = new WeakReference(this.f448124i);
        WeakReference r103 = new WeakReference(getContext());
        c r104 = this.f448118c;
        if (r104 == null) goto L10;
        r104.c(new com.ss.android.lark.widget.recyclerview.a(r102, r101, r103));
    L10:
        addOnScrollListener(new CommonRecyclerView$initFpsTrace$onScrollChangeListener$1(this));
        goto L11
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CommonRecyclerView$initOnKeyboardDismissingListener$1 r100 = this.f448121f;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mOnKeyboardDismissingScrollListener");
        r100 = null;
    L5:
        removeOnScrollListener(r100);
    }

    public final void t() {
        if (DesktopUtil.a(getContext()) == true) goto L5;
        return;
    L5:
        Drawable r100 = UIUtils.getDrawable(getContext(), R.drawable.thumb_drawable);
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type android.graphics.drawable.StateListDrawable");
        StateListDrawable r101 = (StateListDrawable) r100;
        Drawable r102 = UIUtils.getDrawable(getContext(), R.drawable.line_drawable);
        Resources r103 = getContext().getResources();
        Intrinsics.checkNotNull(r102);
        new FastScroller(this, r101, r102, r101, r102, UIUtils.dp2px(getContext(), 5.0f), r103.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), r103.getDimensionPixelOffset(R.dimen.fastscroll_margin));
    }

    public CommonRecyclerView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void r(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        if (this.f448119d != null) goto L5;
        this.f448119d = new JSONObject();
    L5:
        Iterator<Map.Entry<String, ? extends Object>> r101 = r100.entrySet().iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        Map.Entry<String, ? extends Object> r102 = r101.next();
        JSONObject r103 = this.f448119d;
        if (r103 == null) goto L7;
        r103.put(r102.getKey(), r102.getValue());
        goto L7
    }

    public final void setFpsCallback(b r100) {
        Intrinsics.checkNotNullParameter(r100, "fpsCallback");
        this.f448124i = r100;
    }

    public final void setMonitorFps(boolean r100) {
        this.f448116a = r100;
    }

    public final void setSceneTag(String r100) {
        Intrinsics.checkNotNullParameter(r100, "sceneTag");
        this.f448117b = r100;
    }

    public CommonRecyclerView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 0);
    }

    /* JADX WARN: Type inference failed for: r2v3, types: [com.ss.android.lark.widget.recyclerview.CommonRecyclerView$initOnKeyboardDismissingListener$1] */
    public CommonRecyclerView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f448116a = true;
        this.f448120e = true;
        this.f448123h = true;
        this.f448125j = new ArrayList();
        this.f448121f = new CommonRecyclerView$initOnKeyboardDismissingListener$1(this);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onSizeChanged(int r100, int r101, int r102, int r103) {
        super.onSizeChanged(r100, r101, r102, r103);
        Iterator<d> r104 = this.f448125j.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r104.next().a(r100, r102, r103);
        goto L4
    }
}
