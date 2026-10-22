package ks5;

import android.content.Context;
import com.alipay.sdk.m.p.e;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.lark.nativecomponent.service.NativeRenderType;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import js5.g;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import ts5.f;

/* JADX INFO: loaded from: classes19.dex */
public final class b implements ks5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f505916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<f> f505917b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f505918c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f505919d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final NativeRenderType f505920e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final js5.b f505921f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public os5.a f505922g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final ArrayList<JSONObject> f505923h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ArrayList<C6603b> f505924i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f505925j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f505926k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public JSONObject f505927l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public qs5.c f505928m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, g> f505929n;

    public static final class a {
    }

    /* JADX INFO: renamed from: ks5.b$b, reason: collision with other inner class name */
    public static final class C6603b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f505930a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final JSONObject f505931b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final com.bytedance.ee.lark.nativecomponent.core.bridge.b f505932c;

        public C6603b(String r100, JSONObject r101, com.bytedance.ee.lark.nativecomponent.core.bridge.b r102) {
            Intrinsics.checkNotNullParameter(r100, e.f25671s);
            Intrinsics.checkNotNullParameter(r101, "data");
            Intrinsics.checkNotNullParameter(r102, "callback");
            this.f505930a = r100;
            this.f505931b = r101;
            this.f505932c = r102;
        }
    }

    static {
    }

    @Override // ks5.a
    public final void onRemove() {
        this.f505926k = true;
    }

    public final Context getContext() {
        return this.f505916a.getContext();
    }

    @Override // ks5.a
    public final rxb.c getLogger() {
        return this.f505916a.f505935c;
    }

    @Override // ks5.a
    public final pxb.a getWebView() {
        return this.f505916a.f505934b;
    }

    @Override // ks5.a
    public final void i() {
        this.f505916a.f505935c.b("AbstractNativeComponent", this.f505918c, "postCreateView viewCreated set to true");
        this.f505925j = true;
        Iterator<JSONObject> r100 = this.f505923h.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        JSONObject r101 = r100.next();
        this.f505916a.f505935c.b("AbstractNativeComponent", this.f505918c, "post create view, apply pending updates");
        this.f505921f.a();
        goto L4
    L6:
        this.f505923h.clear();
        Iterator<C6603b> r102 = this.f505924i.iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        C6603b r103 = r102.next();
        this.f505916a.f505935c.b("AbstractNativeComponent", this.f505918c, "post create view, apply pending actions");
        this.f505921f.c(r103.f505930a, r103.f505931b, r103.f505932c);
        goto L8
    L10:
        this.f505924i.clear();
    }

    @Override // js5.e
    public final Map<String, g> a() {
        return this.f505929n;
    }

    @Override // ks5.a
    public final js5.b g() {
        return this.f505921f;
    }

    @Override // js5.e
    public final qs5.c getContainer() {
        return this.f505928m;
    }

    @Override // ks5.a
    public final JSONObject getData() {
        return this.f505927l;
    }

    @Override // js5.e
    public final String getViewId() {
        return this.f505918c;
    }

    public final void b(qs5.a r100) {
        Intrinsics.checkNotNullParameter(r100, KtvSubElement.CONTAINER);
        this.f505928m = r100;
    }

    public final void c(os5.a r100) {
        if (r100.a() == null) goto L5;
        this.f505922g = r100;
        this.f505927l = r100.a();
        return;
    L5:
        this.f505916a.f505935c.a("AbstractNativeComponent", this.f505918c, "component model data is invalid");
    }

    @Override // ks5.a
    public final void h(JSONObject r100) {
        os5.a r101 = this.f505922g;
        if (r101 == null) goto L5;
        r101.b(r100);
    L5:
        this.f505927l = r100;
        if (this.f505925j == true) goto L8;
        this.f505916a.f505935c.b("AbstractNativeComponent", this.f505918c, "update data view not created, add to pending list");
        this.f505923h.add(r100);
        return;
    L8:
        this.f505921f.a();
    }

    @Override // ks5.a
    public final void j(String r100, JSONObject r101, com.bytedance.ee.lark.nativecomponent.core.bridge.b r102) {
        Intrinsics.checkNotNullParameter(r100, e.f25671s);
        Intrinsics.checkNotNullParameter(r101, "data");
        Intrinsics.checkNotNullParameter(r102, "callback");
        if (this.f505925j == true) goto L5;
        this.f505916a.f505935c.b("AbstractNativeComponent", this.f505918c, "performAction: " + r100 + " view not created, add to pending list");
        this.f505924i.add(new C6603b(r100, r101, r102));
        return;
    L5:
        this.f505921f.c(r100, r101, r102);
    }

    public b(c r100, List r101, String r102, String r103, OPTrace r104, NativeRenderType r105, js5.b r106) {
        Intrinsics.checkNotNullParameter(r100, "nativeComponentContext");
        Intrinsics.checkNotNullParameter(r102, "viewId");
        Intrinsics.checkNotNullParameter(r103, "viewType");
        Intrinsics.checkNotNullParameter(r104, "opTrace");
        Intrinsics.checkNotNullParameter(r105, "renderType");
        Intrinsics.checkNotNullParameter(r106, "component");
        this.f505916a = r100;
        this.f505917b = r101;
        this.f505918c = r102;
        this.f505919d = r103;
        this.f505920e = r105;
        this.f505921f = r106;
        this.f505923h = new ArrayList();
        this.f505924i = new ArrayList();
        if (r101 != null) goto L5;
        LinkedHashMap r107 = null;
    L9:
        this.f505929n = r107;
        return;
    L5:
        r100.f505935c.i("AbstractNativeComponent", "createSubComponents: " + r101);
        r107 = new LinkedHashMap();
        Iterator r108 = r101.iterator();
    L7:
        if (r108.hasNext() == false) goto L9;
        this.f505921f.e((f) r108.next());
        goto L7
    }
}
