package ni4;

import com.bytedance.creativex.mediaimport.repository.api.BuiltInMaterialType;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class z implements ki4.s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ki4.q<ki4.r, ki4.b0> f519337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Class<Object>, Function0<Object>> f519338b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function1<? super ki4.e0, ki4.d0> f519339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ki4.n f519340d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ki4.d f519341e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ki4.i f519342f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Function0<ki4.u> f519343g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<ki4.e0> f519344h;

    @Override // ki4.s
    public final n a(Map r110) {
        Intrinsics.checkNotNullParameter(r110, "groupStrategies");
        ArrayList r100 = new ArrayList();
        Iterator<ki4.e0> r101 = this.f519342f.a().iterator();
    L4:
        if (r101.hasNext() == false) goto L17;
        ki4.e0 r102 = r101.next();
        if (r102 == BuiltInMaterialType.ALL) goto L7;
        if (r100.contains(r102) == true) goto L4;
        r100.add(r102);
        goto L4
    L7:
        Iterator<T> r103 = this.f519344h.iterator();
    L9:
        if (r103.hasNext() == false) goto L4;
        ki4.e0 r104 = (ki4.e0) r103.next();
        if (r100.contains(r104) == true) goto L9;
        r100.add(r104);
        goto L9
    L17:
        if (r100.size() != 1) goto L22;
        ki4.e0 r105 = (ki4.e0) ListProtector.get(r100, 0);
        Intrinsics.checkNotNullParameter(r105, "sourceType");
        if (r105 != BuiltInMaterialType.ALL) goto L21;
        ki4.t r106 = b(this.f519344h);
    L23:
        ki4.u r107 = this.f519343g.invoke();
        j r108 = new j(r106, true ^ this.f519338b.values().isEmpty(), r107);
        qi4.b r109 = new qi4.b(this.f519341e, r110);
        return new n(r108, this.f519340d, r109, this.f519342f, this.f519338b);
    L21:
        ki4.d0 r111 = this.f519339c.invoke(r105);
        r106 = new y(this.f519337a.a(r105, r111), r111);
        goto L23
    L22:
        r106 = b(r100);
        goto L23
    }

    public final v b(List r100) {
        Intrinsics.checkNotNullParameter(r100, "sourceTypes");
        if (r100.contains(BuiltInMaterialType.ALL) == true) goto L11;
        ArrayList r101 = new ArrayList();
        ArrayList r102 = new ArrayList();
        Iterator r103 = r100.iterator();
    L6:
        if (r103.hasNext() == false) goto L9;
        ki4.e0 r104 = (ki4.e0) r103.next();
        ki4.d0 r105 = this.f519339c.invoke(r104);
        r101.add(this.f519337a.a(r104, r105));
        r102.add(r105);
        goto L6
    L9:
        return new v(r101, r102);
    L11:
        throw new RuntimeException("AlbumSDK: materialSourceTypes contains AllMaterialSource when making combined iterator");
    }

    public z(pi4.e r100, Map r101, oi4.m r102, pi4.c r103, qi4.d r104, qi4.e r105, oi4.o r106, List r107) {
        Intrinsics.checkNotNullParameter(r100, "fetcherProvider");
        Intrinsics.checkNotNullParameter(r101, "processorBuilderMap");
        Intrinsics.checkNotNullParameter(r102, "materialRangeProvider");
        Intrinsics.checkNotNullParameter(r103, "groupStrategyProvider");
        Intrinsics.checkNotNullParameter(r104, "categoryStrategy");
        Intrinsics.checkNotNullParameter(r105, "folderStrategy");
        Intrinsics.checkNotNullParameter(r106, "broadcastSourceIndexerProvider");
        Intrinsics.checkNotNullParameter(r107, "sourceTypesInAllMaterialSource");
        this.f519337a = r100;
        this.f519338b = r101;
        this.f519339c = r102;
        this.f519340d = r103;
        this.f519341e = r104;
        this.f519342f = r105;
        this.f519343g = r106;
        this.f519344h = r107;
        AppHost.f326268a.isDebug();
    }
}
