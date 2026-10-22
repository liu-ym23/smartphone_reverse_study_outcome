package com.bytedance.ee.bear.bitable.ddui;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModel;
import bs4.c;
import bs4.d;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
public final class a implements bs4.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final d f211071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, c> f211072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public mr4.a f211073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, DDUIModel> f211074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, m> f211075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final b f211076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final com.bytedance.ee.bear.bitable.ddui.b f211077g;

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.ddui.a$a, reason: collision with other inner class name */
    public static final class C3028a {
    }

    public final class b implements bs4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f211078a;

        @Override // bs4.b
        public final FragmentManager getPluginFragmentManager() {
            return this.f211078a.f211071a.getPluginFragmentManager();
        }

        @Override // bs4.b
        public final DocumentPluginHost getPluginHost() {
            return this.f211078a.f211071a.getPluginHost();
        }

        @Override // bs4.b
        public final mr4.a o() {
            return this.f211078a.f211073c;
        }

        public b(a r100) {
            this.f211078a = r100;
        }

        @Override // bs4.b
        public final <T extends ViewModel> T getViewModel(Class<T> r100) {
            Intrinsics.checkNotNullParameter(r100, "clazz");
            return (T) this.f211078a.f211071a.getViewModel(r100);
        }

        @Override // bs4.b
        public final void handleOrientationState(boolean r100) {
            this.f211078a.f211071a.handleOrientationState(r100);
        }

        @Override // bs4.b
        public final void p(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "componentType");
            m r102 = (m) ((LinkedHashMap) this.f211078a.f211075e).get(r100);
            if (r102 == null) goto L6;
            r102.onCallBack(r101);
            return;
        }

        @Override // bs4.b
        public final void q(String r100, String r101, Map<String, Object> r102) {
            Intrinsics.checkNotNullParameter(r100, "componentType");
            if (r101 != null) goto L6;
            tt5.a.h("DDUIChannel", "callbackId is null, type " + r100);
            return;
        L6:
            m r103 = (m) ((LinkedHashMap) this.f211078a.f211075e).get(r100);
            if (r103 == null) goto L17;
            JSONObject r104 = new JSONObject();
            r104.put2("callbackId", r101);
            if (r102 == null) goto L14;
            Iterator<Map.Entry<String, Object>> r105 = r102.entrySet().iterator();
        L12:
            if (r105.hasNext() == false) goto L14;
            Map.Entry<String, Object> r106 = r105.next();
            r104.put2(r106.getKey(), r106.getValue());
        L14:
            r103.b(r104);
            return;
        }
    }

    static {
    }

    @Override // bs4.a
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "componentType");
        c r101 = (c) ((LinkedHashMap) this.f211072b).get(r100);
        if (r101 == null) goto L10;
        DDUIModel r102 = (DDUIModel) ((LinkedHashMap) this.f211074d).get(r100);
        if (r102 == null) goto L7;
        String r103 = r102.getPayload();
    L8:
        r101.ML(r103);
        return;
    L7:
        r103 = null;
        goto L8
    }

    @Override // bs4.a
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "componentType");
        DDUIModel r101 = (DDUIModel) ((LinkedHashMap) this.f211074d).get(r100);
        if (r101 == null) goto L5;
        String r102 = r101.getOnUnmounted();
    L6:
        this.f211076f.q(r100, r102, null);
        Intrinsics.checkNotNullParameter(r100, "componentType");
        this.f211072b.remove(r100);
        this.f211075e.remove(r100);
        this.f211074d.remove(r100);
        return;
    L5:
        r102 = null;
        goto L6
    }

    public a(Context r100, d r101) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        Intrinsics.checkNotNullParameter(r101, "pluginDelegate");
        this.f211071a = r101;
        this.f211072b = new LinkedHashMap();
        this.f211074d = new LinkedHashMap();
        this.f211075e = new LinkedHashMap();
        b r102 = new b(this);
        this.f211076f = r102;
        this.f211077g = new com.bytedance.ee.bear.bitable.ddui.b(r100, r102, this);
    }
}
