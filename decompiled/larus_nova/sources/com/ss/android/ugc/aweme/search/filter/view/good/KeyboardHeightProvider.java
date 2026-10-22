package com.ss.android.ugc.aweme.search.filter.view.good;

import android.app.Activity;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.PopupWindow;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/good/KeyboardHeightProvider;", "Landroid/widget/PopupWindow;", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "KeyboardHeightListener", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class KeyboardHeightProvider extends PopupWindow implements ViewTreeObserver.OnGlobalLayoutListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f453246a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public KeyboardHeightListener f453247b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f453248c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Activity f453249d;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\bf\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/view/good/KeyboardHeightProvider$KeyboardHeightListener;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public interface KeyboardHeightListener {
        void b(int r100);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        Rect r100 = new Rect();
        View r101 = this.f453246a;
        if (r101 == null) goto L5;
        r101.getWindowVisibleDisplayFrame(r100);
    L5:
        int r102 = r100.bottom;
        if (r102 <= this.f453248c) goto L8;
        this.f453248c = r102;
    L8:
        int r103 = this.f453248c - r102;
        KeyboardHeightListener r104 = this.f453247b;
        if (r104 == null) goto L12;
        Intrinsics.checkNotNull(r104);
        r104.b(r103);
        return;
    }

    public KeyboardHeightProvider(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "mActivity");
        super(r100);
        this.f453249d = r100;
        View r101 = new View(r100);
        this.f453246a = r101;
        setContentView(r101);
        setBackgroundDrawable(new ColorDrawable(0));
        setWidth(0);
        setHeight(-1);
        setSoftInputMode(16);
        setInputMethodMode(1);
    }
}
