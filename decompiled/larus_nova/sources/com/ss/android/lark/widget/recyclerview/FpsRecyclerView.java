package com.ss.android.lark.widget.recyclerview;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.larksuite.framework.callback.UICallbackExecutor;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Objects;

/* JADX INFO: loaded from: classes38.dex */
public class FpsRecyclerView extends RecyclerView {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f448162h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f448163a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public et3.c f448164b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public et3.c f448165c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f448166d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public zdc.b f448167e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public InputMethodManager f448168f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f448169g;

    public class a extends RecyclerView.OnScrollListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FpsRecyclerView f448170a;

        public a(FpsRecyclerView r100) {
            this.f448170a = r100;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public final void onScrollStateChanged(RecyclerView r100, int r101) {
            if (r101 == 0) goto L7;
            FpsRecyclerView r102 = this.f448170a;
            if (r102.f448163a == 1) goto L10;
            r102.r();
            r102.f448163a = 1;
            r102.f448165c.f();
            UICallbackExecutor.removeCallbacks(r102.f448169g);
            r102.f448164b.d();
            return;
        L10:
            return;
        L7:
            FpsRecyclerView r103 = this.f448170a;
            int r104 = FpsRecyclerView.f448162h;
            r103.t();
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FpsRecyclerView f448171a;

        @Override // java.lang.Runnable
        public final void run() {
            et3.c r100 = this.f448171a.f448165c;     // Catch: Throwable -> L7
            if (r100 == null) goto L10;
            r100.f();     // Catch: Throwable -> L7
            this.f448171a.f448165c.d();     // Catch: Throwable -> L7
            UICallbackExecutor.executeDelayed(this.f448171a.f448169g, 60000);     // Catch: Throwable -> L7
            return;
        L10:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L14;
            throw th;
        }

        public b(FpsRecyclerView r100) {
            this.f448171a = r100;
        }
    }

    public interface c {
    }

    public InputMethodManager getInputMethodManager() {
        if (this.f448168f != null) goto L6;
        this.f448168f = (InputMethodManager) getContext().getSystemService("input_method");
    L6:
        return this.f448168f;
    }

    public String getSceneTag() {
        String r100 = this.f448166d;
        if (r100 == null) goto L5;
        return r100;
    L5:
        String r101 = null;
        String r102 = getResources().getResourceEntryName(((ViewGroup) getParent()).getId());     // Catch: Exception -> L8
    L28:
        r101 = getResources().getResourceEntryName(getId());     // Catch: Exception -> L11
    L13:
        if (TextUtils.isEmpty(r102) == true) goto L18;
        if (TextUtils.isEmpty(r101) == true) goto L18;
        this.f448166d = r102 + HTTP.URL_DEFAULT + r101;
    L22:
        if (TextUtils.isEmpty(this.f448166d) == false) goto L25;
        this.f448166d = "FpsRecyclerView";
    L25:
        return this.f448166d;
    L18:
        if (TextUtils.isEmpty(r102) == false) goto L20;
        r102 = r101;
    L20:
        this.f448166d = r102;
    L8:
        r102 = null;
        goto L28
    }

    public final void r() {
        if (this.f448164b == null) goto L5;
        return;
    L5:
        this.f448164b = new et3.c(getSceneTag());
        this.f448165c = new et3.c(getSceneTag() + "_idle");
        addOnScrollListener(new a(this));
        t();
    }

    public final void t() {
        if (this.f448163a != 2) goto L5;
        return;
    L5:
        r();
        this.f448163a = 2;
        this.f448165c.f();
        this.f448164b.f();
        UICallbackExecutor.removeCallbacks(this.f448169g);
        this.f448169g.run();
    }

    public final void u() {
        if (this.f448163a != 3) goto L5;
        return;
    L5:
        this.f448163a = 3;
        UICallbackExecutor.removeCallbacks(this.f448169g);
        et3.c r100 = this.f448164b;
        if (r100 == null) goto L8;
        r100.f();
    L8:
        et3.c r101 = this.f448165c;
        if (r101 == null) goto L12;
        r101.f();
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        r();
        addOnScrollListener(this.f448167e);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeOnScrollListener(this.f448167e);
        u();
    }

    public FpsRecyclerView(Context r100) {
        this(r100, null);
    }

    @Override // android.view.View
    public final void onDisplayHint(int r100) {
        super.onDisplayHint(r100);
        if (r100 != 0) goto L5;
        t();
        return;
    L5:
        u();
    }

    @Override // android.view.View
    public final void onWindowVisibilityChanged(int r100) {
        super.onWindowVisibilityChanged(r100);
        if (r100 != 0) goto L5;
        t();
        return;
    L5:
        u();
    }

    public void setFpsCallback(c r100) {
        et3.c r101 = this.f448164b;
        if (r101 == null) goto L6;
        Objects.requireNonNull(r100);
        r101.c(new zdc.a());
        return;
    }

    public final void setSceneTag(String r100) {
        this.f448166d = r100;
    }

    public FpsRecyclerView(Context r100, AttributeSet r101) {
        this(r100, r101, 0);
    }

    public FpsRecyclerView(Context r100, AttributeSet r101, int r102) {
        super(r100, r101, r102);
        this.f448163a = -1;
        this.f448164b = null;
        this.f448165c = null;
        this.f448166d = null;
        this.f448169g = new b(this);
        this.f448167e = new zdc.b(this);
    }
}
