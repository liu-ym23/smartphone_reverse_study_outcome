package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.ies.bullet.service.base.bridge.IBridgeMethod;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
public final class BridgeScope implements IBridgeScope {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f246538e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f246539a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, IBridgeScope> f246540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, com.bytedance.ies.bullet.service.base.bridge.a> f246541c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Function1<? super com.bytedance.ies.bullet.service.base.bridge.a, Unit> f246542d;

    public static final class a {
        public static BridgeScope a(g r100, m16.b r101) {
            Intrinsics.checkNotNullParameter(r100, "scopeProviderFactory");
            Intrinsics.checkNotNullParameter(r101, "contextProviderFactory");
            String r102 = r100.getName();
            LinkedHashMap r103 = new LinkedHashMap();
            Iterator<T> r104 = r100.b().invoke(r101).iterator();
        L4:
            if (r104.hasNext() == false) goto L6;
            g r105 = (g) r104.next();
            String r106 = r105.getName();
            int r107 = BridgeScope.f246538e;
            r103.put(r106, a(r105, r101));
            goto L4
        L6:
            LinkedHashMap r108 = new LinkedHashMap();
            Iterator<T> r109 = r100.a().invoke(r101).iterator();
        L8:
            if (r109.hasNext() == false) goto L10;
            com.bytedance.ies.bullet.service.base.bridge.a r110 = (com.bytedance.ies.bullet.service.base.bridge.a) r109.next();
            r108.put(r110.getName(), r110);
            goto L8
        L10:
            Unit r111 = Unit.INSTANCE;
            return new BridgeScope(r102, r103, r108);
        }
    }

    static {
    }

    @Override // com.bytedance.ies.bullet.service.base.i0
    public final void release() {
        Iterator<Map.Entry<String, IBridgeScope>> r100 = this.f246540b.entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        r100.next().getValue().release();
        goto L4
    L6:
        Iterator<Map.Entry<String, com.bytedance.ies.bullet.service.base.bridge.a>> r101 = this.f246541c.entrySet().iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        r101.next().getValue().release();
        goto L8
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeScope
    public final Map<String, IBridgeScope> B80() {
        return this.f246540b;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeScope
    public final Map<String, com.bytedance.ies.bullet.service.base.bridge.a> W60() {
        return this.f246541c;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeScope
    public final String getName() {
        return this.f246539a;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeScope
    public final void e80(final Function2<? super List<? extends IBridgeScope>, ? super com.bytedance.ies.bullet.service.base.bridge.a, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        Iterator<Map.Entry<String, IBridgeScope>> r101 = this.f246540b.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        r101.next().getValue().e80(new BridgeScope$iterate$1$1(r100, this));
        goto L4
    L6:
        Iterator<Map.Entry<String, com.bytedance.ies.bullet.service.base.bridge.a>> r102 = this.f246541c.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, com.bytedance.ies.bullet.service.base.bridge.a> r103 = r102.next();
        r100.invoke(CollectionsKt.listOf(this), r103.getValue());
        goto L8
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeScope
    public final void RA(IBridgeScope r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "otherScope");
        Iterator<Map.Entry<String, com.bytedance.ies.bullet.service.base.bridge.a>> r102 = r100.W60().entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L14;
        Map.Entry<String, com.bytedance.ies.bullet.service.base.bridge.a> r103 = r102.next();
        if (this.f246541c.containsKey(r103.getKey()) == true) goto L7;
        this.f246541c.put(r103.getKey(), r103.getValue());
        goto L4
    L7:
        if (r101 == true) goto L8;
        r103.getValue().release();
        goto L4
    L8:
        com.bytedance.ies.bullet.service.base.bridge.a r104 = this.f246541c.get(r103.getKey());
        if (r104 == null) goto L11;
        r104.release();
    L11:
        this.f246541c.put(r103.getKey(), r103.getValue());
        goto L4
    L14:
        Iterator<Map.Entry<String, IBridgeScope>> r105 = r100.B80().entrySet().iterator();
    L16:
        if (r105.hasNext() == false) goto L23;
        Map.Entry<String, IBridgeScope> r106 = r105.next();
        if (this.f246540b.containsKey(r106.getKey()) == true) goto L19;
        this.f246540b.put(r106.getKey(), r106.getValue());
        goto L16
    L19:
        IBridgeScope r107 = this.f246540b.get(r106.getKey());
        if (r107 == null) goto L16;
        r107.RA(r106.getValue(), r101);
        goto L16
    }

    public BridgeScope(String r100, Map r101, Map r102) {
        this.f246539a = r100;
        this.f246540b = r101;
        this.f246541c = r102;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.IBridgeScope
    public final void Yc(List<String> r100, Object r101, com.bytedance.ies.bullet.service.base.bridge.a.InterfaceC3543a r102, Function1<? super Throwable, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "scopeNames");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r103, "reject");
        int r104 = r100.size();
        if (r104 != 0) goto L5;
        r103.invoke(new IBridgeScope.BridgeNotFoundException("[unknown]"));
        return;
    L5:
        if (r104 == 1) goto L10;
        String r105 = (String) CollectionsKt.first(r100);
        IBridgeScope r106 = this.f246540b.get(r105);
        if (r106 != null) goto L9;
        r103.invoke(new IBridgeScope.BridgeNotFoundException(r105));
        return;
    L9:
        this.f246542d = this.f246542d;
        r106.Yc(r100.subList(1, r100.size()), r101, r102, r103);
        return;
    L10:
        String r107 = (String) CollectionsKt.first(r100);
        com.bytedance.ies.bullet.service.base.bridge.a r108 = this.f246541c.get(r107);
        if (r108 != null) goto L14;
        r103.invoke(new IBridgeScope.BridgeNotFoundException(r107));
        return;
    L14:
        if ((r108 instanceof IBridgeMethod) == false) goto L19;
        Function1<? super com.bytedance.ies.bullet.service.base.bridge.a, Unit> r109 = this.f246542d;
        if (r109 == null) goto L18;
        r109.invoke(r108);
    L18:
        ((IBridgeMethod) r108).b70((JSONObject) r101, (IBridgeMethod.a) r102);
        return;
    L19:
        boolean r110 = r108 instanceof i;
        if (r110 == false) goto L35;
        Function1<? super com.bytedance.ies.bullet.service.base.bridge.a, Unit> r111 = this.f246542d;
        if (r111 == null) goto L24;
        r111.invoke(r108);
    L24:
        if (r110 == false) goto L26;
        i r112 = (i) r108;
    L27:
        if (r112 == null) goto L36;
        d.a(r112, r101, (i.a) r102);
        return;
    L36:
        return;
    L26:
        r112 = null;
        goto L27
    }
}
