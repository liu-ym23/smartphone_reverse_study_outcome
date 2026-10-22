package com.bytedance.ies.argus.aspect.eventCenter;

import android.webkit.WebView;
import com.bytedance.ies.argus.api.params.WebLoadPageType;
import com.bytedance.ies.argus.api.params.WebLoadUrlParams;
import com.bytedance.ies.argus.bean.ArgusVerifyAction;
import com.bytedance.ies.argus.util.JSONUtilsKt;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class i extends b<WebView> {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Pair<WebLoadUrlParams, ? extends com.bytedance.ies.argus.bean.i<?>> f245872j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public WebLoadUrlParams f245873k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public WebLoadUrlParams f245874l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Set<String> f245875m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Map<String, Boolean> f245876n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public ArgusVerifyAction f245877o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Map<String, ArgusVerifyAction> f245878p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Pair<? extends dr7.c, String> f245879q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f245880r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f245881s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final c f245882t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public List<String> f245883u;

    public final boolean i() {
        Collection r100 = ((LinkedHashMap) this.f245876n).values();
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator r101 = r100.iterator();
    L9:
        if (r101.hasNext() == false) goto L18;
        if (((Boolean) r101.next()).booleanValue() == false) goto L9;
        return true;
    L18:
        return false;
    L5:
        if (r100.isEmpty() == false) goto L7;
        return false;
    }

    public i() {
        this.f245875m = new LinkedHashSet();
        this.f245876n = new LinkedHashMap();
        this.f245878p = new LinkedHashMap();
        this.f245882t = new c();
        new ConcurrentHashMap();
        this.f245883u = new ArrayList();
        new ArrayList();
    }

    @Override // com.bytedance.ies.argus.strategy.b
    public final JSONObject d(ArgusVerifyAction r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        JSONObject r101 = new JSONObject();
        JSONUtilsKt.d(r101, "view_class", this.f245835f);
        JSONUtilsKt.e(r101, "view_trace_id", e());
        return r101;
    }

    public final void j(WebLoadUrlParams r100, com.bytedance.ies.argus.bean.i<?> r101) {
        Intrinsics.checkNotNullParameter(r100, "urlParams");
        String r102 = r100.f245701c;
        Map<String, Boolean> r103 = this.f245876n;
        boolean r104 = false;
        if (r100.f245707i == false) goto L12;
        WebLoadPageType r105 = r100.f245709k;
        if (r105 == null) goto L12;
        if (r105 != WebLoadPageType.WHITE_INNER) goto L9;
        boolean r106 = true;
    L10:
        if (r106 == true) goto L12;
        r104 = true;
        goto L12
    L9:
        r106 = false;
    L12:
        r103.put(r102, Boolean.valueOf(r104));
        WebLoadUrlParams r107 = this.f245874l;
        if (r107 != null) goto L17;
        if (r107 != null) goto L17;
        this.f245874l = r100;
        r100.f245708j = true;
    L17:
        if (r100.f245707i == false) goto L22;
        if (r101 != null) goto L20;
        this.f245873k = r100;
        return;
    L20:
        this.f245872j = new Pair(r100, r101);
        return;
    }
}
