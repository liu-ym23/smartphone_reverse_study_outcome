package com.bytedance.locallife.poi.poidetail.container.plugin.perf;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes21.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f264171a = 0;

    static {
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

    public static Bitmap c(View r110) {
        if (r110.getWidth() == 0) goto L12;
        if (r110.getHeight() == 0) goto L12;
        if (ViewCompat.isLaidOut(r110) == false) goto L12;
        Bitmap.Config r100 = Bitmap.Config.ARGB_8888;
        Intrinsics.checkNotNullParameter(r110, "<this>");
        Intrinsics.checkNotNullParameter(r100, "config");
        Bitmap r101 = Bitmap.createBitmap(r110.getWidth(), r110.getHeight(), r100);
        Canvas r102 = new Canvas(r101);
        r102.translate(-r110.getScrollX(), -r110.getScrollY());
        r110.draw(r102);
        Matrix r103 = new Matrix();
        r103.postRotate(90.0f);
        return Bitmap.createBitmap(r101, 0, 0, r101.getWidth(), r101.getHeight(), r103, true);
    L12:
        return Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888);
    }

    public static View d(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "viewGroup");
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r100.getClass()).getQualifiedName(), "com.bytedance.locallife.tempo2.TempoView") == false) goto L5;
        return r100;
    L5:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r100.getClass()).getQualifiedName(), "com.lynx.tasm.LynxView") == true) goto L30;
        int r101 = r100.getChildCount();
        int r102 = 0;
    L8:
        if (r102 >= r101) goto L21;
        View r103 = r100.getChildAt(r102);
        if ((r103 instanceof ViewGroup) == false) goto L15;
        View r104 = d((ViewGroup) r103);
        if (r104 == null) goto L19;
        return r104;
    L19:
        r102 = r102 + 1;
        goto L8
    L15:
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r103.getClass()).getQualifiedName(), "com.bytedance.locallife.tempo2.TempoView") == true) goto L20;
        if (Intrinsics.areEqual(Reflection.getOrCreateKotlinClass(r103.getClass()).getQualifiedName(), "com.lynx.tasm.LynxView") == false) goto L19;
    L20:
        return r103;
    L21:
        return null;
    L30:
        return r100;
    }

    public static List e(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (g(r100) == true) goto L8;
        return null;
    L8:
        String r101 = r100.getSharedPreferences("ShotComparePrefs", 0).getString("compare_node_tags_1", null);
        if (r101 == null) goto L38;
        List r102 = StringsKt.split$default(r101, new String[]{","}, false, 0, 6, null);
        if (r102 == null) goto L39;
        List r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L14:
        if (r105.hasNext() == false) goto L20;
        String r106 = (String) r105.next();
        if (r106 == null) goto L19;
        r104.add(StringsKt.trim(r106).toString());
        goto L14
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L20:
        ArrayList r107 = new ArrayList();
        Iterator r108 = r104.iterator();
    L22:
        if (r108.hasNext() == false) goto L30;
        Object r109 = r108.next();
        if (((String) r109).length() <= 0) goto L26;
        boolean r110 = true;
    L27:
        if (r110 == false) goto L22;
        r107.add(r109);
        goto L22
    L26:
        r110 = false;
        goto L27
    L30:
        return r107;
    L39:
        return null;
    L38:
        return null;
    }

    public static List f(Context r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (g(r100) == true) goto L8;
        return null;
    L8:
        String r101 = r100.getSharedPreferences("ShotComparePrefs", 0).getString("compare_node_tags_2", null);
        if (r101 == null) goto L38;
        List r102 = StringsKt.split$default(r101, new String[]{","}, false, 0, 6, null);
        if (r102 == null) goto L39;
        List r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator r105 = r103.iterator();
    L14:
        if (r105.hasNext() == false) goto L20;
        String r106 = (String) r105.next();
        if (r106 == null) goto L19;
        r104.add(StringsKt.trim(r106).toString());
        goto L14
    L19:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
    L20:
        ArrayList r107 = new ArrayList();
        Iterator r108 = r104.iterator();
    L22:
        if (r108.hasNext() == false) goto L30;
        Object r109 = r108.next();
        if (((String) r109).length() <= 0) goto L26;
        boolean r110 = true;
    L27:
        if (r110 == false) goto L22;
        r107.add(r109);
        goto L22
    L26:
        r110 = false;
        goto L27
    L30:
        return r107;
    L39:
        return null;
    L38:
        return null;
    }

    public static boolean g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        return r100.getSharedPreferences("ShotComparePrefs", 0).getBoolean("enable_saved_data", true);
    }

    public static ImageView b(Context r100, Bitmap r101, ViewGroup.LayoutParams r102, Float r103) {
        ImageView r104 = new ImageView(r100);
        r104.setImageBitmap(r101);
        r104.setLayoutParams(r102);
        r104.setAdjustViewBounds(true);
        if (r103 == null) goto L5;
        r104.setAlpha(r103.floatValue());
    L5:
        return r104;
    }
}
