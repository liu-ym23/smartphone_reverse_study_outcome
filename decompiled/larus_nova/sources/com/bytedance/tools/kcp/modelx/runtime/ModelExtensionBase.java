package com.bytedance.tools.kcp.modelx.runtime;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.tools.kcp.modelx.runtime.internal.CompositeModelExtensionInfoHolder;
import com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionProcessor;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.ModelXReflections;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.g;
import com.google.gson.Gson;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.io.PrintWriter;
import java.io.Serializable;
import java.io.StringWriter;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import vh7.c;
import vh7.e;
import vh7.f;

/* JADX INFO: loaded from: classes22.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b&\u0018\u0000*\u0012\b\u0000\u0010\u0003*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u0002*\u0012\b\u0001\u0010\u0005*\u00020\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0012\u0004\u0012\u00028\u00000\u00042\u00020\u0006B\u000f\u0012\u0006\u0010&\u001a\u00028\u0000¢\u0006\u0004\b*\u0010+J<\u0010\r\u001a\u0004\u0018\u00018\u0003\"\f\b\u0002\u0010\u0007*\u0006\u0012\u0002\b\u00030\u0004\"\u0004\b\u0003\u0010\b2\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00020\u000bH\u0084\u0002¢\u0006\u0004\b\r\u0010\u000eJB\u0010\r\u001a\u00028\u0003\"\f\b\u0002\u0010\u0007*\u0006\u0012\u0002\b\u00030\u0004\"\u0004\b\u0003\u0010\b2\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b2\u0006\u0010\u000f\u001a\u00028\u0003H\u0084\u0002¢\u0006\u0004\b\r\u0010\u0010JH\u0010\r\u001a\u00028\u0003\"\f\b\u0002\u0010\u0007*\u0006\u0012\u0002\b\u00030\u0004\"\u0004\b\u0003\u0010\b2\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00030\u000bH\u0084\u0002¢\u0006\u0004\b\r\u0010\u0012JR\u0010\r\u001a\u00028\u0003\"\f\b\u0002\u0010\u0007*\u0006\u0012\u0002\b\u00030\u0004\"\u0004\b\u0003\u0010\b2\u0006\u0010\n\u001a\u00020\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00030\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00018\u0003H\u0084\u0002¢\u0006\u0004\b\r\u0010\u0013JP\u0010\u0018\u001a\u00020\u0017\"\f\b\u0002\u0010\u0007*\u0006\u0012\u0002\b\u00030\u0004\"\b\b\u0003\u0010\b*\u00020\u00012\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00142\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00020\u000b2\b\u0010\u0016\u001a\u0004\u0018\u00018\u0003H\u0084\u0002¢\u0006\u0004\b\u0018\u0010\u0019J-\u0010\u001c\u001a\u00028\u0002\"\u000e\b\u0002\u0010\u001a*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00020\u000bH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ/\u0010\u001e\u001a\u0004\u0018\u00018\u0002\"\u000e\b\u0002\u0010\u001a*\b\u0012\u0004\u0012\u00028\u00000\u00042\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00028\u00020\u000bH\u0016¢\u0006\u0004\b\u001e\u0010\u001dJ\u0013\u0010!\u001a\u00020 2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\"\u001a\u00020\tH\u0016R\u0018\u0010$\u001a\u0006\u0012\u0002\b\u00030#8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0017\u0010&\u001a\u00028\u00008\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "", "Lvh7/c;", "FLEX", "Lvh7/e;", "SELF", "Ljava/io/Serializable;", "CHILD", ExifInterface.GPS_DIRECTION_TRUE, "", "tag", "Ljava/lang/Class;", "childType", MonitorConstants.CONNECT_TYPE_GET, "(ILjava/lang/Class;)Ljava/lang/Object;", "defaultValue", "(ILjava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;", "valueType", "(ILjava/lang/Class;Ljava/lang/Class;)Ljava/lang/Object;", "(ILjava/lang/Class;Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/Object;", "", "name", "value", "", "set", "(ILjava/lang/String;Ljava/lang/Class;Ljava/lang/Object;)V", "R", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "other", "", "equals", "hashCode", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "rootInternal", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "flexInstance", "Ljava/lang/Object;", "getFlexInstance", "()Ljava/lang/Object;", "<init>", "(Ljava/lang/Object;)V", "lib-modelx"}, k = 1, mv = {1, 4, 3})
public abstract class ModelExtensionBase<FLEX extends c<FLEX>, SELF extends e<FLEX>> implements e<FLEX>, Serializable {
    private final transient FLEX flexInstance;
    private final transient FlexModelBase<?> rootInternal;

    public int hashCode() {
        return this.flexInstance.hashCode();
    }

    @Override // vh7.e
    public final FLEX getFlexInstance() {
        return this.flexInstance;
    }

    public ModelExtensionBase(FLEX r100) {
        Intrinsics.checkNotNullParameter(r100, "flexInstance");
        this.flexInstance = r100;
        if ((r100 instanceof c.a) == false) goto L5;
        FLEX r101 = ((c.a) r100).getDelegate();
    L6:
        if (r101 == null) goto L10;
        this.rootInternal = r101;
        return;
    L10:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.tools.kcp.modelx.runtime.FlexModelBase<*>");
    L5:
        r101 = r100;
        goto L6
    }

    public <R extends e<FLEX>> R castTo(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.flexInstance.castTo(r100);
    }

    public <R extends e<FLEX>> R castToOrNull(Class<R> r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return (R) this.flexInstance.castToOrNull(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if ((r100 instanceof ModelExtensionBase) == true) goto L11;
        return false;
    L11:
        ModelExtensionBase r101 = (ModelExtensionBase) r100;
        if ((true ^ Intrinsics.areEqual(r101.getClass(), getClass())) == false) goto L15;
        return false;
    L15:
        return Intrinsics.areEqual(this.flexInstance, r101.flexInstance);
    }

    public final <CHILD extends e<?>, T> T get(int r100, Class<CHILD> r101) {
        Intrinsics.checkNotNullParameter(r101, "childType");
        Map<Class<?>, Object> r102 = this.rootInternal.extensionValues.b(r100);
        if (r102 != null) goto L7;
        return null;
    L7:
        return (T) r102.get(r101);
    }

    public final <CHILD extends e<?>, T> T get(int r100, Class<CHILD> r101, Class<T> r102) {
        Intrinsics.checkNotNullParameter(r101, "childType");
        Intrinsics.checkNotNullParameter(r102, "valueType");
        Map<Class<?>, Object> r103 = this.rootInternal.extensionValues.b(r100);
        if (r103 == null) goto L5;
        T r104 = (T) r103.get(r101);
    L6:
        if (r104 == null) goto L8;
        return r104;
    L8:
        return (T) d.c(r102);
    L5:
        r104 = null;
        goto L6
    }

    public final <CHILD extends e<?>, T> T get(int r100, Class<CHILD> r101, T r102) {
        Intrinsics.checkNotNullParameter(r101, "childType");
        Map<Class<?>, Object> r103 = this.rootInternal.extensionValues.b(r100);
        if (r103 == null) goto L5;
        Object r104 = r103.get(r101);
    L6:
        if (r104 != null) goto L9;
        return r102;
    L9:
        return (T) r104;
    L5:
        r104 = null;
        goto L6
    }

    public final <CHILD extends e<?>, T> T get(int r100, Class<CHILD> r101, Class<T> r102, T r103) {
        Intrinsics.checkNotNullParameter(r101, "childType");
        Intrinsics.checkNotNullParameter(r102, "valueType");
        Map<Class<?>, Object> r104 = this.rootInternal.extensionValues.b(r100);
        if (r104 == null) goto L5;
        Object r105 = r104.get(r101);
    L6:
        if (r105 == null) goto L9;
        r103 = (T) r105;
    L9:
        if (r103 == null) goto L11;
        return r103;
    L11:
        return (T) d.c(r102);
    L5:
        r105 = null;
        goto L6
    }

    public final <CHILD extends e<?>, T> void set(int r100, String r101, Class<CHILD> r102, T r103) {
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r102, "childType");
        Map<Class<?>, Object> r104 = this.rootInternal.extensionValues.b(r100);
        if (r104 != null) goto L7;
        if (r103 != null) goto L6;
        return;
    L6:
        r104 = new HashMap();
        this.rootInternal.extensionValues.c(r100, r104);
    L7:
        if (r103 != null) goto L9;
        r104.remove(r102);
    L10:
        FLEX r105 = this.flexInstance;
        CompositeModelExtensionInfoHolder r106 = ModelExtensionProcessor.f270937a;
        Intrinsics.checkNotNullParameter(r101, "name");
        Intrinsics.checkNotNullParameter(r105, "flexInstance");
        Map<Class<?>, Map<String, g>> r107 = ModelExtensionProcessor.f270940d;     // Catch: Throwable -> L42
        Class<?> r108 = r105.getClass();     // Catch: Throwable -> L42
        ConcurrentHashMap r109 = (ConcurrentHashMap) r107;     // Catch: Throwable -> L42
        Object r110 = r109.get(r108);     // Catch: Throwable -> L42
        if (r110 != null) goto L14;
        r110 = new ConcurrentHashMap();     // Catch: Throwable -> L42
        r109.put(r108, r110);     // Catch: Throwable -> L42
    L14:
        Map r111 = (Map) r110;     // Catch: Throwable -> L42
        Object r112 = r111.get(r101);     // Catch: Throwable -> L42
        if (r112 != null) goto L21;
        g r113 = g.f270992b;     // Catch: Throwable -> L42
        Gson r114 = ModelXReflections.f270980a;     // Catch: Throwable -> L42
        Field r115 = ModelXReflections.b(r105.getClass(), r101);     // Catch: Throwable -> L42
        if (r115 != null) goto L19;
        r112 = g.f270992b;     // Catch: Throwable -> L42
    L20:
        r111.put(r101, r112);     // Catch: Throwable -> L42
        goto L21
    L19:
        r112 = new g(r115);     // Catch: Throwable -> L42
    L21:
        g r116 = (g) r112;     // Catch: Throwable -> L42
        if (r116 != g.f270992b) goto L24;
        boolean r117 = true;
    L25:
        if (r117 == false) goto L28;
        return;
    L28:
        if (r103 != null) goto L34;
        Field r118 = r116.f270993a;     // Catch: Throwable -> L42
        if (r118 == null) goto L33;
        r118.set(r105, null);     // Catch: Throwable -> L42
        return;
    L33:
        throw new IllegalStateException("field not present".toString());     // Catch: Throwable -> L42
    L34:
        Field r119 = r116.f270993a;     // Catch: Throwable -> L42
        if (r119 == null) goto L41;
        if ((r103 instanceof e) == false) goto L39;
        r103 = (T) ((e) r103).getFlexInstance();
    L39:
        r119.set(r105, r103);     // Catch: Throwable -> L42
        return;
    L41:
        throw new IllegalStateException("field not present".toString());     // Catch: Throwable -> L42
    L24:
        r117 = false;
    L42:
        th = move-exception;
        Intrinsics.checkNotNullParameter(th, "t");
        vh7.d r120 = f.f554983a;
        StringBuilder r121 = new StringBuilder("failed to set value: ");
        r121.append(th.getMessage());
        r121.append('\n');
        StringWriter r122 = new StringWriter();
        PrintWriter r123 = new PrintWriter(r122);
        th.printStackTrace(r123);
        r123.flush();
        r121.append(r122.toString());
        String r124 = r121.toString();
        if (r124 == null) goto L50;
        f.f554984b.error(r124);
        return;
    L50:
        return;
    L9:
        r104.put(r102, r103);
        goto L10
    }
}
