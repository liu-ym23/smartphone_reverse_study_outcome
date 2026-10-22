package com.bytedance.ies.stark.framework.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.bytedance.ies.stark.framework.HybridDevTool;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.apm.impl.protector.RunnableProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.officesdk.api.init.OfficeSDKRequestTag;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0003,-.B'\b\u0007\u0012\u0006\u0010&\u001a\u00020%\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010'\u0012\b\b\u0002\u0010)\u001a\u00020\u0007¢\u0006\u0004\b*\u0010+J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0007J\u0010\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016R\"\u0010\u0011\u001a\u00020\n8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0018\u001a\u00020\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R.\u0010!\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@FX\u0086\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006/"}, d2 = {"Lcom/bytedance/ies/stark/framework/ui/StarkFloatingView;", "Landroid/widget/FrameLayout;", "Lcom/bytedance/ies/stark/framework/a;", "starkMagnetViewListener", "", "setCurrentStarkMagnetViewListener", "setStarkMagnetViewListener", "", RemoteMessageConst.Notification.VISIBILITY, "setVisibility", "", OfficeSDKRequestTag.KEY_NEW_USER, "Z", "getAutoToEdge", "()Z", "setAutoToEdge", "(Z)V", "autoToEdge", "o", "I", "getLayoutGravity", "()I", "setLayoutGravity", "(I)V", "layoutGravity", "Landroid/view/View;", "value", "p", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "contentView", "getMStarkMagnetViewListener", "()Lcom/bytedance/ies/stark/framework/a;", "mStarkMagnetViewListener", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "c", "stark-api_release"}, k = 1, mv = {1, 7, 1})
public class StarkFloatingView extends FrameLayout {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final /* synthetic */ int f248628q = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<Integer, com.bytedance.ies.stark.framework.a> f248629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public float f248630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f248631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f248632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public float f248633e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f248634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f248635g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f248636h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public int f248637i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f248638j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f248639k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f248640l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final int f248641m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f248642n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f248643o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f248644p;

    public static final class a {
    }

    public final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f248645a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ StarkFloatingView f248646b;

        @Override // java.lang.Runnable
        public final void run() {
            this.f248646b.a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(StarkFloatingView r100) {
            this.f248646b = r100;
            this.f248645a = new Handler(Looper.getMainLooper());
        }
    }

    public final class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Handler f248647a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public float f248648b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public float f248649c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public long f248650d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ StarkFloatingView f248651e;

        public final void a() {
            if (this.f248651e.getRootView() != null) goto L5;
            return;
        L5:
            if (this.f248651e.getRootView().getParent() == null) goto L13;
            float r100 = Math.min(1.0f, (System.currentTimeMillis() - this.f248650d) / 400.0f);
            float r101 = (this.f248648b - this.f248651e.getX()) * r100;
            float r102 = (this.f248649c - this.f248651e.getY()) * r100;
            StarkFloatingView r103 = this.f248651e;
            int r104 = StarkFloatingView.f248628q;
            r103.setX(r103.getX() + r101);
            r103.setY(r103.getY() + r102);
            if (r100 >= 1.0f) goto L12;
            this.f248647a.post(this);
            return;
        L12:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(StarkFloatingView r100) {
            this.f248651e = r100;
            this.f248647a = new Handler(Looper.getMainLooper());
        }
    }

    static {
    }

    public StarkFloatingView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public StarkFloatingView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final com.bytedance.ies.stark.framework.a getMStarkMagnetViewListener() {
        Map<Integer, com.bytedance.ies.stark.framework.a> r100 = this.f248629a;
        s46.a r101 = (s46.a) HybridDevTool.f248625a.getValue();
        if (r101 == null) goto L5;
        Activity r102 = r101.a();
    L6:
        if (r102 == null) goto L8;
        int r103 = r102.hashCode();
    L9:
        LinkedHashMap r104 = (LinkedHashMap) r100;
        return (com.bytedance.ies.stark.framework.a) r104.get(Integer.valueOf(r103));
    L8:
        r103 = 0;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    public final void a() {
        com.bytedance.ies.stark.framework.a r100 = getMStarkMagnetViewListener();
        if (r100 == null) goto L6;
        r100.a();
        return;
    }

    public final void c() {
        Context r100 = getContext();
        int r101 = -1;
        if (r100 != null) goto L20;
    L12:
        int r102 = -1;
    L13:
        this.f248636h = r102 - getWidth();
        Resources r103 = getContext().getResources();     // Catch: Exception -> L16
        r101 = WindowDisplayMetricsOverride.apply(r103, r103.getDisplayMetrics()).heightPixels;     // Catch: Exception -> L16
    L18:
        this.f248637i = r101;
        return;
    L16:
        e = move-exception;
        e.printStackTrace();
        goto L18
    L20:
        Resources r104 = r100.getResources();     // Catch: Exception -> L10
        if (r104 == null) goto L12;
        DisplayMetrics r105 = WindowDisplayMetricsOverride.apply(r104, r104.getDisplayMetrics());     // Catch: Exception -> L10
        if (r105 == null) goto L12;
        r102 = r105.widthPixels;     // Catch: Exception -> L10
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L12
    }

    public final boolean getAutoToEdge() {
        return this.f248642n;
    }

    public final View getContentView() {
        return this.f248644p;
    }

    public final int getLayoutGravity() {
        return this.f248643o;
    }

    public final void b(boolean r100) {
        int r101 = 0;
        if (r100 == true) goto L6;
        r101 = this.f248636h + 0;
    L6:
        float r102 = r101;
        c r103 = this.f248635g;
        Intrinsics.checkNotNull(r103);
        float r104 = getY();
        r103.f248648b = r102;
        r103.f248649c = r104;
        r103.f248650d = System.currentTimeMillis();
        r103.f248647a.post(r103);
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration r100) {
        super.onConfigurationChanged(r100);
        c();
        if (this.f248642n == false) goto L6;
        b(this.f248639k);
        return;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        boolean r101 = false;
        if (isClickable() == false) goto L41;
        if (r100 == null) goto L41;
        int r102 = r100.getAction();
        if (r102 != 0) goto L9;
        this.f248632d = getX();
        this.f248633e = getY();
        this.f248630b = r100.getRawX();
        this.f248631c = r100.getRawY();
        this.f248634f = System.currentTimeMillis();
        b r103 = this.f248640l;
        r103.f248645a.postDelayed(r103, ViewConfiguration.getLongPressTimeout());
        c();
        c r104 = this.f248635g;
        if (r104 == null) goto L40;
        r104.f248647a.removeCallbacks(r104);
    L40:
        return true;
    L9:
        if (r102 == 1) goto L23;
        if (r102 != 2) goto L40;
        setX((this.f248632d + r100.getRawX()) - this.f248630b);
        float r105 = (this.f248633e + r100.getRawY()) - this.f248631c;
        float r106 = this.f248638j;
        if (r105 >= r106) goto L15;
        r105 = r106;
    L15:
        float r107 = this.f248637i;
        if (r105 <= r107) goto L18;
        r105 = r107;
    L18:
        setY(r105);
        if (Math.abs(r100.getRawX() - this.f248630b) <= this.f248641m) goto L21;
    L22:
        b r108 = this.f248640l;
        r108.f248645a.removeCallbacks(r108);
        goto L40
    L21:
        if (Math.abs(r100.getRawY() - this.f248631c) <= this.f248641m) goto L40;
    L23:
        b r109 = this.f248640l;
        r109.f248645a.removeCallbacks(r109);
        if (this.f248642n == false) goto L31;
        if (getX() >= (this.f248636h / 2)) goto L28;
        boolean r110 = true;
    L29:
        this.f248639k = r110;
        b(r110);
        goto L31
    L28:
        r110 = false;
    L31:
        if ((System.currentTimeMillis() - this.f248634f) >= 150) goto L33;
        r101 = true;
    L33:
        if (r101 == false) goto L40;
        com.bytedance.ies.stark.framework.a r111 = getMStarkMagnetViewListener();
        if (r111 == null) goto L40;
        r111.onClick();
    L41:
        return false;
    }

    public final void setAutoToEdge(boolean r100) {
        this.f248642n = r100;
    }

    public final void setContentView(View r100) {
        removeAllViews();
        ViewGroup r101 = null;
        if (r100 == null) goto L5;
        ViewParent r102 = r100.getParent();
    L7:
        if ((r102 instanceof ViewGroup) == false) goto L9;
        r101 = (ViewGroup) r102;
    L9:
        if (r101 == null) goto L11;
        r101.removeAllViews();
    L11:
        addView(r100);
        this.f248644p = r100;
        return;
    L5:
        r102 = null;
        goto L7
    }

    @Deprecated(message = "we fix setStarkMagnetViewListener's bug", replaceWith = @ReplaceWith(expression = "setStarkMagnetViewListener", imports = {}))
    public final void setCurrentStarkMagnetViewListener(com.bytedance.ies.stark.framework.a r100) {
        setStarkMagnetViewListener(r100);
    }

    public final void setLayoutGravity(int r100) {
        this.f248643o = r100;
    }

    public final void setStarkMagnetViewListener(com.bytedance.ies.stark.framework.a r100) {
        s46.a r101 = (s46.a) HybridDevTool.f248625a.getValue();
        if (r101 == null) goto L5;
        Activity r102 = r101.a();
    L6:
        if (r102 == null) goto L9;
        this.f248629a.put(Integer.valueOf(r102.hashCode()), r100);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // android.view.View
    public void setVisibility(int r100) {
        super.setVisibility(0);
        int r101 = getChildCount();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L5;
        getChildAt(r102).setVisibility(0);
        r102 = r102 + 1;
        goto L3
    }

    public StarkFloatingView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        new LinkedHashMap();
        super(r100, r101, r102);
        this.f248629a = new LinkedHashMap();
        this.f248639k = true;
        this.f248640l = new b(this);
        this.f248641m = ViewConfiguration.get(r100).getScaledTouchSlop();
        this.f248642n = true;
        this.f248643o = 3;
        this.f248635g = new c(this);
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r103 = r100.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (r103 <= 0) goto L5;
        int r104 = r100.getResources().getDimensionPixelSize(r103);
    L6:
        this.f248638j = r104;
        setClickable(true);
        setLongClickable(true);
        c();
        return;
    L5:
        r104 = 0;
        goto L6
    }

    public /* synthetic */ StarkFloatingView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
