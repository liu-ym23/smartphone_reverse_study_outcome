package com.ss.android.lark.search.ui.result;

import android.util.Size;
import android.widget.RelativeLayout;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class e implements v3c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SearchResultView f440307a;

    @Override // v3c.d
    public final Size getContentViewSize() {
        RelativeLayout r100 = this.f440307a.f440269n;
        RelativeLayout r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchRsultRelatelayout");
        r100 = null;
    L5:
        int r102 = r100.getWidth();
        RelativeLayout r103 = this.f440307a.f440269n;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchRsultRelatelayout");
        r103 = null;
    L8:
        int r104 = r102 - r103.getPaddingLeft();
        RelativeLayout r105 = this.f440307a.f440269n;
        if (r105 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchRsultRelatelayout");
        r105 = null;
    L11:
        int r106 = r104 - r105.getPaddingRight();
        RelativeLayout r107 = this.f440307a.f440269n;
        if (r107 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchRsultRelatelayout");
        r107 = null;
    L14:
        int r108 = r107.getHeight();
        RelativeLayout r109 = this.f440307a.f440269n;
        if (r109 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchRsultRelatelayout");
        r109 = null;
    L17:
        int r110 = r108 - r109.getPaddingTop();
        RelativeLayout r111 = this.f440307a.f440269n;
        if (r111 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("mSearchRsultRelatelayout");
    L22:
        return new Size(r106, r110 - r101.getPaddingBottom());
    L20:
        r101 = r111;
        goto L22
    }

    public e(SearchResultView r100) {
        this.f440307a = r100;
    }
}
