package com.bytedance.kmp.ec.yata.view.render.controller.manager.exposure;

import android.view.View;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.kmp.ec.yata.common.log.YaTaLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class AbsExposureHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f251847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.view.c f251848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f251849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final g f251850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f251851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Boolean f251852f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<String> f251853g;

    public abstract Map<String, View> b(String r100);

    public final void a(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        if (this.f251851e == true) goto L6;
        d(new AbsExposureHelper$checkExposure$1(r100));
        return;
    L6:
        final Map<String, View> r101 = b(r100);
        if (com.bytedance.kmp.ec.yata.common.init.b.b() == false) goto L9;
        final List r102 = CollectionsKt.toMutableList(this.f251853g);
        d(new AbsExposureHelper$checkExposure$2(r101, r102));
    L9:
        Iterator<Map.Entry<String, View>> r103 = r101.entrySet().iterator();
    L11:
        if (r103.hasNext() == false) goto L15;
        Map.Entry<String, View> r104 = r103.next();
        final String r105 = r104.getKey();
        View r106 = r104.getValue();
        if (((ArrayList) this.f251853g).contains(r105) == true) goto L11;
        d(new AbsExposureHelper$checkExposure$3$1(r100, r105));
        this.f251850d.b(r105, r106);
        goto L11
    L15:
        Iterator r107 = ((ArrayList) this.f251853g).iterator();
    L17:
        if (r107.hasNext() == false) goto L21;
        final String r108 = (String) r107.next();
        if (r101.containsKey(r108) == true) goto L17;
        d(new AbsExposureHelper$checkExposure$4$1(r100, r108));
        this.f251850d.a(r108);
        goto L17
    L21:
        ((ArrayList) this.f251853g).clear();
        List<String> r109 = this.f251853g;
        ArrayList r110 = (ArrayList) r109;
        r110.addAll(r101.keySet());
    }

    public final void d(final Function0<String> r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        String r101 = YaTaLog.f251436a;
        YaTaLog.c("AbsExposureHelper", new AbsExposureHelper$printLog$1(this, r100));
    }

    public final void c(Map<String, View> r100, String r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Intrinsics.checkNotNullParameter(r101, "nodeKey");
        Intrinsics.checkNotNullParameter(r102, "view");
        int r103 = ha6.h.f484393a;
        if (ha6.h.a(r102, this.f251848b.f251820c.f251430f) == false) goto L19;
        r100.put(r101, r102);
        com.bytedance.kmp.ec.yata.store.node.b r104 = this.f251848b.f251823f.a(r101);
        if ((r104 instanceof ba6.f) == false) goto L7;
        ba6.f r105 = (ba6.f) r104;
    L8:
        if (r105 != null) goto L10;
        return;
    L10:
        Iterator r106 = ((LinkedHashMap) r105.i().e()).entrySet().iterator();
    L12:
        if (r106.hasNext() == false) goto L26;
        Iterator r107 = ((Iterable) ((Map.Entry) r106.next()).getValue()).iterator();
    L15:
        if (r107.hasNext() == false) goto L12;
        String r108 = (String) r107.next();
        com.bytedance.kmp.ec.yata.view.c r109 = this.f251848b;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r108, "nodeKey");
        View r110 = ((com.bytedance.kmp.ec.yata.view.render.tree.b) r109.f251831n.getValue()).c(r108);
        if (r110 == null) goto L15;
        c(r100, r108, r110);
        goto L15
    L26:
        return;
    L7:
        r105 = null;
        goto L8
    }

    public AbsExposureHelper(String r100, com.bytedance.kmp.ec.yata.view.c r101, e r102, View r103, ViewExposureManager.a r104) {
        Intrinsics.checkNotNullParameter(r100, "logTag");
        Intrinsics.checkNotNullParameter(r101, "viewWrapper");
        Intrinsics.checkNotNullParameter(r102, "exposureCheckConfig");
        Intrinsics.checkNotNullParameter(r103, KtvSubElement.CONTAINER);
        Intrinsics.checkNotNullParameter(r104, "listener");
        this.f251847a = r100;
        this.f251848b = r101;
        this.f251849c = r103;
        this.f251850d = r104;
        this.f251853g = new ArrayList();
        if (r102.f251878a == false) goto L6;
        r103.getViewTreeObserver().addOnScrollChangedListener(new a(this));
    L6:
        if (r102.f251879b == false) goto L9;
        r103.getViewTreeObserver().addOnGlobalLayoutListener(new b(this));
    L12:
        if (r102.f251881d == false) goto L15;
        r103.addOnAttachStateChangeListener(new AnonymousClass4(this));
        return;
    L15:
        return;
    L9:
        if (r102.f251880c == false) goto L12;
        r103.getViewTreeObserver().addOnGlobalLayoutListener(new c(this));
        goto L12
    }
}
