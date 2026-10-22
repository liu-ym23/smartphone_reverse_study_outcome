package com.ss.android.lark.widget.light;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.text.Layout;
import com.ss.android.lark.widget.select.SelectableView;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f445973a = 0;

    static {
    }

    public static void a(Canvas r100, Layout r101, Path r110, Paint r111, SelectableView.State r112) {
        Intrinsics.checkNotNullParameter(r101, "layout");
        Intrinsics.checkNotNullParameter(r112, "viewState");
        if (Build.VERSION.SDK_INT <= 33) goto L6;
        if (r100 == null) goto L8;
        r101.draw(r100, CollectionsKt.listOf(r110), CollectionsKt.listOf(r111), null, null, 0);
        return;
    L8:
        return;
    L6:
        r101.draw(r100, r110, r111, 0);
    }
}
