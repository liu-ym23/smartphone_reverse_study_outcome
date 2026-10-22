package com.bytedance.tools.kcp.modelx.runtime.internal.decode;

import am3.g;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.tools.kcp.modelx.runtime.internal.CompositeModelExtensionInfoHolder;
import com.bytedance.tools.kcp.modelx.runtime.internal.ModelExtensionProcessor;
import com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import vh7.f;

/* JADX INFO: loaded from: classes22.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.bytedance.tools.kcp.modelx.runtime.internal.decode.a$a, reason: collision with other inner class name */
    public static final class C3795a {

        /* JADX INFO: renamed from: com.bytedance.tools.kcp.modelx.runtime.internal.decode.a$a$a, reason: collision with other inner class name */
        public static final class C3796a implements ParameterizedType {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public static final Map<Class<? extends Object>, Class<? extends Object>> f270973c = null;

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Class<?> f270974a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final Type[] f270975b;

            /* JADX INFO: renamed from: com.bytedance.tools.kcp.modelx.runtime.internal.decode.a$a$a$a, reason: collision with other inner class name */
            public static final class C3797a {
            }

            @Override // java.lang.reflect.ParameterizedType
            public final Type getOwnerType() {
                return null;
            }

            static {
                f270973c = MapsKt.mapOf(new Pair[]{TuplesKt.to(Integer.TYPE, Integer.class), TuplesKt.to(Long.TYPE, Long.class), TuplesKt.to(Boolean.TYPE, Boolean.class), TuplesKt.to(Byte.TYPE, Byte.class), TuplesKt.to(Character.TYPE, Character.class), TuplesKt.to(Float.TYPE, Float.class), TuplesKt.to(Double.TYPE, Double.class), TuplesKt.to(Short.TYPE, Short.class), TuplesKt.to(Void.TYPE, Void.class)});
            }

            @Override // java.lang.reflect.ParameterizedType
            public final Type[] getActualTypeArguments() {
                return this.f270975b;
            }

            @Override // java.lang.reflect.ParameterizedType
            public final Type getRawType() {
                return this.f270974a;
            }

            public static Class a(Class r100) {
                if (r100.isPrimitive() == true) goto L5;
                return r100;
            L5:
                Class<? extends Object> r101 = f270973c.get(r100);
                if (r101 == null) goto L9;
                return r101;
            L9:
                throw new IllegalStateException(("failed to find object type for primitive type: " + r100).toString());
            }

            public C3796a(Class<?> r100, List<? extends Class<?>> r101) {
                Intrinsics.checkNotNullParameter(r100, "rawType");
                Intrinsics.checkNotNullParameter(r101, "arguments");
                this.f270974a = a(r100);
                int r102 = r101.size();
                Type[] r103 = new Type[r102];
                int r104 = 0;
            L3:
                if (r104 >= r102) goto L5;
                r103[r104] = a((Class) ListProtector.get(r101, r104));
                r104 = r104 + 1;
                goto L3
            L5:
                this.f270975b = r103;
            }
        }

        @JvmStatic
        public static b e(Object r100) {
            Intrinsics.checkNotNullParameter(r100, "$this$toListEntry");
            return new b(r100);
        }

        @JvmStatic
        public static Object a(Class r100, g r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "reader");
            CompositeModelExtensionInfoHolder r102 = ModelExtensionProcessor.f270937a;
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "reader");
            Object r103 = ModelExtensionProcessor.b(r100, r101);
            if (r103 != null) goto L8;
            am3.c r104 = f.f554983a.a(r100);
            if (r104 == null) goto L7;
            r103 = r104.decode(r101);
            goto L8
        L7:
            r103 = null;
        L8:
            if (r103 == null) goto L10;
            return r103;
        L10:
            return d.c(r100);
        }

        @JvmStatic
        public static Object b(Class r100, g r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "reader");
            return ModelExtensionProcessor.a(r100, r101);
        }

        @JvmStatic
        public static Pair c(Class r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "name");
            CompositeModelExtensionInfoHolder r102 = ModelExtensionProcessor.f270937a;
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "name");
            com.bytedance.tools.kcp.modelx.runtime.internal.d r103 = ModelExtensionProcessor.f270937a.a(r100);
            if (r103 != null) goto L6;
            return ModelExtensionProcessor.f270938b;
        L6:
            return r103.f270962e.b(r103.f270960c, r101);
        }

        @JvmStatic
        public static C3796a d(Class r100, List r101) {
            Intrinsics.checkNotNullParameter(r100, "rawType");
            Intrinsics.checkNotNullParameter(r101, "arguments");
            return new C3796a(r100, r101);
        }
    }

    static {
    }

    public a() {
    }

    public abstract Object a(int r100, int r101, g r102);

    public abstract Pair<Integer, Type> b(int r100, String r101);
}
