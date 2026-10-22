package com.ss.android.lark.chat.chatwindow.biz.component.banner;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f411976a;

    public b(a r100) {
        this.f411976a = r100;
    }

    public final void a() {
        a r100 = this.f411976a;
        r100.getClass();
        Log.i("BannerController", "traverseBannerVisibility");
        ArrayList r101 = new ArrayList(((LinkedHashMap) r100.f411972c).values());
        CollectionsKt.sortWith(r101, d.f411979a);
        boolean r102 = false;
        r100.f411973d = 0;
        r100.f411970a.removeAllViews();
        Iterator r103 = r101.iterator();
        int r104 = 0;
    L4:
        if (r103.hasNext() == false) goto L21;
        wya.b r105 = (wya.b) r103.next();
        if (r105.isShown() == false) goto L19;
        if (r105.isEnabled() == false) goto L19;
        if ((r105.e() & r104) != 0) goto L4;
        View r106 = r105.getBanner();
        if (r106 != null) goto L15;
    L18:
        r100.f411970a.addView(r106);
        r100.f411973d |= r105.getType();
        r104 = r104 | (r105.e() | r105.getType());
        Log.d("BannerController", "traverse visible:" + r105.getType() + '/' + r100.f411973d);
        r102 = true;
        goto L4
    L15:
        if (r106.getParent() == null) goto L18;
        ViewParent r107 = r106.getParent();
        Intrinsics.checkNotNull(r107, "null cannot be cast to non-null type android.view.ViewGroup");
        ((ViewGroup) r107).removeView(r106);
    L19:
        r100.f411970a.removeView(r105.getBanner());
        r100.f411973d &= ~r105.getType();
        Log.d("BannerController", "traverse not visible:" + r105.getType() + '/' + r100.f411973d);
        goto L4
    L21:
        if (r100.f411974e == r102) goto L26;
        if (r102 == false) goto L24;
        r100.f411971b.onShow();
    L25:
        r100.f411974e = r102;
        return;
    L24:
        r100.f411971b.b();
        goto L25
    L26:
        if (r102 == false) goto L39;
        r100.f411971b.a();
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
