package com.ss.android.lark.newemoji.emojioptions;

import android.view.View;
import android.view.ViewParent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;

/* JADX INFO: loaded from: classes36.dex */
public final class f implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OptionsSelectPopupMenu<Object> f433013a;

    public f(OptionsSelectPopupMenu<Object> r100) {
        this.f433013a = r100;
    }

    public final void a() {
        OptionsSelectPopupMenu<Object> r100 = this.f433013a;
        r100.f432972i = true;
        View r101 = r100.f432971h;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("targetView");
        r101 = null;
    L5:
        ViewParent r102 = r101.getParent();
        if (r102 == null) goto L8;
        r102.requestDisallowInterceptTouchEvent(true);
    L8:
        int[] r103 = new int[2];
        View r104 = r100.f432982s.get(r100.f432966c);
        if (r104 == null) goto L15;
        Log.i("OptionsPopupMenu", "handleActionDown: selectedView is not null , compute location");
        r104.getLocationOnScreen(r103);
        ((LinkedHashMap) r100.f432978o).clear();
        Iterator<Map.Entry<Object, View>> r105 = r100.f432982s.entrySet().iterator();
    L13:
        if (r105.hasNext() == false) goto L17;
        Map.Entry<Object, View> r106 = r105.next();
        Object r107 = r106.getKey();
        View r108 = r106.getValue();
        int[] r109 = new int[2];
        r108.getLocationOnScreen(r109);
        Map<Object, IntRange> r110 = r100.f432978o;
        int r111 = r109[0];
        r110.put(r107, new IntRange(r111, r108.getWidth() + r111));
        goto L13
    L17:
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
}
