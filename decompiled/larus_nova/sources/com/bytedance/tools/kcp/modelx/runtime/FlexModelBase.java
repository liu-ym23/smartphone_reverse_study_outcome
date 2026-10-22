package com.bytedance.tools.kcp.modelx.runtime;

import am3.f;
import am3.g;
import am3.i;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.tools.kcp.modelx.runtime.internal.CompositeModelExtensionInfoHolder;
import com.bytedance.tools.kcp.modelx.runtime.internal.FlexModelDelegate;
import com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionProcessor;
import com.bytedance.tools.kcp.modelx.runtime.internal.d;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.b;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.reflect.KClass;
import vh7.a;
import vh7.c;
import vh7.e;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00022\b\u0012\u0004\u0012\u00028\u00000\u00022\u00020\u0004B\u0015\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018¢\u0006\u0004\b)\u0010*B\u0017\b\u0016\u0012\f\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000+¢\u0006\u0004\b)\u0010,J2\u0010\n\u001a\u00020\t\"\b\b\u0001\u0010\u0005*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00018\u0001H\u0081\u0002¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\f\u001a\u0004\u0018\u00018\u0001\"\b\b\u0001\u0010\u0005*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006H\u0081\u0002¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010J\u000e\u0010\u0015\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0014J+\u0010\u001a\u001a\u00028\u0001\"\u000e\b\u0001\u0010\u0017*\b\u0012\u0004\u0012\u00028\u00000\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ-\u0010\u001c\u001a\u0004\u0018\u00018\u0001\"\u000e\b\u0001\u0010\u0017*\b\u0012\u0004\u0012\u00028\u00000\u00162\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00010\u0018¢\u0006\u0004\b\u001c\u0010\u001bR(\u0010\u001e\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00160\u001d8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR*\u0010\"\u001a\u0018\u0012\u0014\u0012\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0018\u0012\u0004\u0012\u00020\u00010!0 8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R \u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010!8\u0000X\u0081\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u001a\u0010'\u001a\b\u0012\u0004\u0012\u00028\u00000\u00188\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006-"}, d2 = {"Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "", "Lvh7/c;", "SELF", "Ljava/io/Serializable;", ExifInterface.GPS_DIRECTION_TRUE, "Lvh7/a$a;", "key", "value", "", "set", "(Lvh7/a$a;Ljava/lang/Object;)V", MonitorConstants.CONNECT_TYPE_GET, "(Lvh7/a$a;)Ljava/lang/Object;", "", "tag", "Lam3/g;", "reader", "Lam3/g$a;", "decodeExtensionFields", "", "setThreadSafe", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Ljava/util/concurrent/ConcurrentHashMap;", "extensionCache", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/c;", "", "extensionValues", "Lcom/bytedance/tools/kcp/modelx/runtime/internal/c;", "", "extraMaps", "Ljava/util/Map;", "flexInterfaceType", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)V", "lib-modelx"}, k = 1, mv = {1, 4, 3})
public class FlexModelBase<SELF extends c<SELF>> implements c<SELF>, Serializable {
    public final transient ConcurrentHashMap<Class<?>, e<?>> extensionCache;
    public final transient com.bytedance.tools.kcp.modelx.runtime.internal.c<Map<Class<?>, Object>> extensionValues;
    public final transient Map<String, Object> extraMaps;
    private final transient Class<SELF> flexInterfaceType;

    public FlexModelBase(Class<SELF> r100) {
        Intrinsics.checkNotNullParameter(r100, "flexInterfaceType");
        this.flexInterfaceType = r100;
        this.extensionCache = new ConcurrentHashMap(0);
        this.extensionValues = new com.bytedance.tools.kcp.modelx.runtime.internal.c();
        this.extraMaps = new LinkedHashMap();
    }

    @Override // vh7.c
    public final <R extends e<SELF>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        R r101 = (R) castToOrNull(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        return (R) ModelExtensionProcessor.c(this, this.flexInterfaceType, r100);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // vh7.c
    public final <R extends e<SELF>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        R r101 = (R) this.extensionCache.get(r100);
        if (r101 == null) goto L5;
        return r101;
    L5:
        Class<SELF> r102 = this.flexInterfaceType;
        CompositeModelExtensionInfoHolder r103 = ModelExtensionProcessor.f270937a;
        Intrinsics.checkNotNullParameter(this, RootDescription.ROOT_ELEMENT);
        Intrinsics.checkNotNullParameter(r102, "flexType");
        Intrinsics.checkNotNullParameter(r100, "extensionType");
        ConcurrentHashMap r104 = (ConcurrentHashMap) ModelExtensionProcessor.f270939c;
        Constructor r105 = (Constructor) r104.get(r100);
        Object r106 = null;
        if (r105 == null) goto L9;
    L18:
        if (r105 == null) goto L35;
        Object[] r107 = new Object[1];
        if ((this instanceof c.a) == false) goto L27;
        Object r108 = ((c.a) this).getDelegate().actualModel;
        Object r109 = r108;
        if (r108 == null) goto L25;
    L34:
        r107[0] = r109;
        r106 = r105.newInstance(r107);
        goto L35
    L25:
        throw new NullPointerException("null cannot be cast to non-null type SELF");
    L27:
        if ((this instanceof FlexModelDelegate) == false) goto L33;
        Object r110 = ((FlexModelDelegate) this).actualModel;
        r109 = r110;
        if (r110 != null) goto L34;
        throw new NullPointerException("null cannot be cast to non-null type SELF");
    L33:
        r109 = this;
    L35:
        R r111 = (R) r106;
        if (r111 == null) goto L38;
        this.extensionCache.put((Class<?>) r100, (e<?>) r111);
    L38:
        return r111;
    L9:
        if (r100.isInterface() == false) goto L14;
        Class<?> r112 = ModelExtensionProcessor.f270937a.c(r100);
        if (r112 == 0) goto L13;
        Constructor r113 = r112.getDeclaredConstructor(new Class[]{r102});
    L15:
        r105 = r113;
    L16:
        if (r105 == null) goto L18;
        r104.put(r100, r105);
        goto L18
    L13:
        r105 = null;
        goto L16
    L14:
        r113 = r100.getDeclaredConstructor(new Class[]{r102});
        goto L15
    }

    public final <T> T get(a.InterfaceC8006a<T> r100) {
        Intrinsics.checkNotNullParameter(r100, "key");
        T r101 = (T) this.extraMaps.get(r100.getName());
        if ((r101 instanceof Object) == true) goto L6;
        return null;
    L6:
        return r101;
    }

    public final void setThreadSafe(boolean r100) {
        this.extensionValues.f270956b = r100;
    }

    public FlexModelBase(KClass<SELF> r100) {
        Intrinsics.checkNotNullParameter(r100, "flexInterfaceType");
        this(JvmClassMappingKt.getJavaClass(r100));
    }

    public final g.a decodeExtensionFields(int r210, g r211) {
        g r100 = r211;
        Intrinsics.checkNotNullParameter(r100, "reader");
        Class<SELF> r101 = this.flexInterfaceType;
        Map<Class<?>, Object> r102 = this.extensionValues.b(r210);
        CompositeModelExtensionInfoHolder r103 = ModelExtensionProcessor.f270937a;
        Intrinsics.checkNotNullParameter(r101, "flexType");
        Intrinsics.checkNotNullParameter(r100, "reader");
        List<d> r104 = ModelExtensionProcessor.f270937a.b(r101);
        g.a r105 = null;
        if (r104.isEmpty() == false) goto L5;
        Pair r106 = TuplesKt.to(null, null);
    L57:
        Map<Class<?>, Object> r107 = (Map) r106.component1();
        g.a r108 = (g.a) r106.component2();
        if (r107 == null) goto L60;
        this.extensionValues.c(r210, r107);
    L60:
        return r108;
    L5:
        if (r102 != null) goto L7;
        r102 = new HashMap(r104.size());
    L7:
        int r109 = 1;
        if (r100.f4375j == true) goto L13;
        f r110 = r100.f4367b;
        if ((r110 instanceof am3.d) == false) goto L12;
        r100.f4367b = new i((am3.d) r110);
    L12:
        r100.f4375j = true;
    L13:
        g r111 = new g(r100);
        Iterator<d> r112 = r104.iterator();
        long r113 = -1;
    L15:
        if (r112.hasNext() == false) goto L56;
        d r114 = r112.next();
        Object r115 = r114.f270962e.a(r114.f270960c, r210, r111);
        if (r115 == null) goto L53;
        if ((r115 instanceof com.bytedance.tools.kcp.modelx.runtime.internal.decode.c) == false) goto L25;
        Class<?> r116 = r114.f270959b;
        Object r117 = r102.get(r116);
        if (r117 != null) goto L23;
        r117 = new LinkedHashMap(2);
        r102.put(r116, r117);
    L23:
        com.bytedance.tools.kcp.modelx.runtime.internal.decode.c r118 = (com.bytedance.tools.kcp.modelx.runtime.internal.decode.c) r115;
        TypeIntrinsics.asMutableMap(r117).put(r118.f270978a, r118.f270979b);
    L38:
        long r119 = r111.f4368c;
        long r120 = r119 - r100.f4368c;
        if (r113 <= 0) goto L49;
        if (r120 != r113) goto L43;
        boolean r121 = true;
    L44:
        if (r121 == true) goto L53;
        throw new IllegalStateException(("different byte count read for flexType: " + r101 + ", tag: " + r210).toString());
    L43:
        r121 = false;
        goto L44
    L49:
        if (r120 <= 0) goto L53;
        r105 = new g.a(r119, r111.f4369d, r111.f4370e, r111.f4371f, r111.f4372g, r111.f4373h, r111.f4374i);
        r113 = r120;
        goto L53
    L25:
        if ((r115 instanceof b) == false) goto L37;
        Class<?> r122 = r114.f270959b;
        Object r123 = r102.get(r122);
        if (r123 != null) goto L36;
        b r124 = (b) r115;
        int r125 = r124.f270977b;
        if (r125 == r109) goto L34;
        if (r125 != 2) goto L33;
        r123 = new LinkedHashSet(2);
    L35:
        r102.put(r122, r123);
        goto L36
    L33:
        throw new IllegalStateException(("failed to create collection for ListEntry type: " + r124.f270977b).toString());
    L34:
        r123 = new ArrayList(r109);
    L36:
        TypeIntrinsics.asMutableCollection(r123).add(((b) r115).f270976a);
        goto L38
    L37:
        r102.put(r114.f270959b, r115);
    L53:
        if (r112.hasNext() == false) goto L55;
        r111.f4367b.a();
        g.a r126 = r111.f4366a;
        r111.f4368c = r126.f4376a;
        r111.f4369d = r126.f4377b;
        r111.f4370e = r126.f4378c;
        r111.f4371f = r126.f4379d;
        r111.f4372g = r126.f4380e;
        r111.f4373h = r126.f4381f;
        r111.f4374i = r126.f4382g;
    L55:
        r100 = r211;
        r101 = r101;
        r109 = 1;
        goto L15
    L56:
        r106 = TuplesKt.to(r102, r105);
        goto L57
    }

    public final <T> void set(a.InterfaceC8006a<T> r100, T r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (r101 == null) goto L6;
        this.extraMaps.put(r100.getName(), r101);
        return;
    }
}
