package com.larus.avlink.env.diary.detail;

import android.graphics.Rect;
import android.view.View;
import com.larus.bmhome.chat.api.SelectionRangeType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class x implements com.larus.bmhome.chat.api.d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f292052a;

    @Override // com.larus.bmhome.chat.api.d0
    public final void b(SelectionRangeType r100, int r101, int r102, boolean r103, boolean r104, Rect r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "rangeType");
        Intrinsics.checkNotNullParameter(r106, "selectedText");
    }

    public x(w r100) {
        this.f292052a = r100;
    }

    @Override // com.larus.bmhome.chat.api.d0
    public final void a(View r100, int r101, int r102) {
        if (r102 != 1) goto L9;
        w r103 = this.f292052a;
        if (r103.f292048g == false) goto L7;
        r103.f292047f = true;
        r103.b(false, true);
        return;
    L7:
        r103.f292047f = false;
        r103.onShow();
        return;
    }
}
