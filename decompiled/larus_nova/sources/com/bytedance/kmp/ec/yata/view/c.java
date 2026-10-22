package com.bytedance.kmp.ec.yata.view;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.lifecycle.Lifecycle;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.error.YataErrorManager;
import com.bytedance.kmp.ec.yata.common.platform.e;
import com.bytedance.kmp.ec.yata.common.platform.h;
import com.bytedance.kmp.ec.yata.view.render.delegate.g;
import com.bytedance.kmp.ec.yata.view.render.screenmanager.main.MainScreenManager;
import com.bytedance.kmp.ec.yata.view.render.screenmanager.popup.PopupScreenManager;
import com.bytedance.kmp.ec.yata.view.render.tree.RenderTreeManager;
import com.ss.android.lark.utils.statistics.PerfLog;
import ha6.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c implements com.bytedance.kmp.ec.yata.common.utils.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f251818a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f251819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.common.init.c f251820c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final YataErrorManager f251821d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.view.render.delegate.v2.a f251822e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final fa6.a f251823f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f251824g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final e f251825h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lifecycle f251826i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f251827j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final com.bytedance.kmp.ec.yata.view.render.slicewidget.yata.a f251828k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f251829l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public PopupScreenManager f251830m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f251831n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ha6.c f251832o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f251833p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f251834q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f251835r;

    public final List<ga6.c> b() {
        PopupScreenManager r100 = this.f251830m;
        if (r100 == null) goto L9;
        List<ga6.a> r101 = r100.f252040e;
        ArrayList r102 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator r103 = ((ArrayList) r101).iterator();
    L6:
        if (r103.hasNext() == false) goto L11;
        r102.add(((ga6.a) r103.next()).getConfig());
        goto L6
    L11:
        return r102;
    L9:
        return CollectionsKt.emptyList();
    }

    public final com.bytedance.kmp.ec.yata.view.render.screenmanager.popup.b c() {
        return (com.bytedance.kmp.ec.yata.view.render.screenmanager.popup.b) this.f251833p.getValue();
    }

    public final g d() {
        return (g) this.f251834q.getValue();
    }

    public final int e() {
        if (this.f251832o != null) goto L5;
        int r100 = d.f484384a;
        this.f251832o = d.a(this.f251818a);
    L5:
        ha6.c r101 = this.f251832o;
        if (r101 != null) goto L10;
        int r102 = d.f484384a;
        r101 = d.a(this.f251818a);
    L10:
        return r101.f484383b;
    }

    @Deprecated(message = "Popup相关事件需要使用该API")
    public final String f() {
        PopupScreenManager r100 = this.f251830m;
        if (r100 == null) goto L9;
        ga6.a r101 = (ga6.a) CollectionsKt.lastOrNull(r100.f252040e);
        if (r101 == null) goto L9;
        ga6.c r102 = r101.getConfig();
        if (r102 == null) goto L9;
        return r102.a();
    L9:
        return null;
    }

    @Override // com.bytedance.kmp.ec.yata.common.utils.b
    @Deprecated(message = "SDK内部API")
    public final boolean a() {
        return this.f251835r;
    }

    public final void g(String r100, LinearLayout r101, com.bytedance.kmp.ec.yata.view.render.controller.common.a<LinearLayout> r102, com.bytedance.kmp.ec.yata.view.render.controller.manager.exposure.e r103) {
        Intrinsics.checkNotNullParameter(r100, "position");
        Intrinsics.checkNotNullParameter(r101, "layout");
        Intrinsics.checkNotNullParameter(r103, "exposureCheckConfig");
        ((RenderTreeManager) ((MainScreenManager) this.f251829l.getValue()).f252034b.getValue()).c(r100, r101, r102, r103);
    }

    public c(Context r100, String r101, com.bytedance.kmp.ec.yata.common.init.c r102, YataErrorManager r103, com.bytedance.kmp.ec.yata.view.render.delegate.v2.a r104, AndroidYaTaInstance.a r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bizCode");
        Intrinsics.checkNotNullParameter(r102, "switchConfig");
        Intrinsics.checkNotNullParameter(r103, "errorManager");
        Intrinsics.checkNotNullParameter(r105, "protocolAdapter");
        this.f251818a = r100;
        this.f251819b = r101;
        this.f251820c = r102;
        this.f251821d = r103;
        this.f251822e = r104;
        this.f251823f = r105;
        int r106 = h.f251540a;
        this.f251825h = new e();
        int r107 = ha6.h.f484393a;
        this.f251826i = ha6.h.c(r100);
        this.f251827j = LazyKt.lazy(new YataViewWrapper$renderDelegateManager$2(this));
        this.f251828k = new com.bytedance.kmp.ec.yata.view.render.slicewidget.yata.a();
        this.f251829l = LazyKt.lazy(new YataViewWrapper$mainScreenManager$2(this));
        this.f251831n = LazyKt.lazy(YataViewWrapper$findViewHelper$2.INSTANCE);
        this.f251833p = LazyKt.lazy(YataViewWrapper$popupCallbackManager$2.INSTANCE);
        this.f251834q = LazyKt.lazy(YataViewWrapper$renderCallbackManager$2.INSTANCE);
    }
}
