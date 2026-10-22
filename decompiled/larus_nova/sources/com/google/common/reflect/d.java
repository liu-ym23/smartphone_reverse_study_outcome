package com.google.common.reflect;

import com.google.common.collect.ImmutableMap;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.CheckForNull;
import kotlin.text.Typography;

/* JADX INFO: loaded from: classes23.dex */
@ElementTypesAreNonnullByDefault
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f275689a;

    public class a extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Map f275690b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Type f275691c;

        @Override // com.google.common.reflect.j
        public final void b(Class<?> r100) {
            if ((this.f275691c instanceof WildcardType) == false) goto L6;
            return;
        L6:
            throw new IllegalArgumentException("No type mapping from " + r100 + " to " + this.f275691c);
        }

        @Override // com.google.common.reflect.j
        public final void c(GenericArrayType r100) {
            Type r101 = this.f275691c;
            if ((r101 instanceof WildcardType) == false) goto L5;
            return;
        L5:
            Type r102 = Types.c(r101);
            if (r102 == null) goto L8;
            boolean r103 = true;
        L9:
            com.google.common.base.m.h(r103, "%s is not an array type.", this.f275691c);
            d.a(this.f275690b, r100.getGenericComponentType(), r102);
            return;
        L8:
            r103 = false;
            goto L9
        }

        @Override // com.google.common.reflect.j
        public final void d(ParameterizedType r100) {
            Type r101 = this.f275691c;
            if ((r101 instanceof WildcardType) == false) goto L23;
            return;
        L23:
            ParameterizedType r102 = (ParameterizedType) ParameterizedType.class.cast(r101);
            if (r100.getOwnerType() != null) goto L10;
        L12:
            com.google.common.base.m.i(r100.getRawType().equals(r102.getRawType()), "Inconsistent raw type: %s vs. %s", r100, this.f275691c);
            Type[] r103 = r100.getActualTypeArguments();
            Type[] r104 = r102.getActualTypeArguments();
            int r105 = 0;
            if (r103.length != r104.length) goto L15;
            boolean r106 = true;
        L16:
            com.google.common.base.m.i(r106, "%s not compatible with %s", r100, r102);
        L18:
            if (r105 >= r103.length) goto L20;
            d.a(this.f275690b, r103[r105], r104[r105]);
            r105 = r105 + 1;
            goto L18
        L20:
            return;
        L15:
            r106 = false;
            goto L16
        L10:
            if (r102.getOwnerType() == null) goto L12;
            d.a(this.f275690b, r100.getOwnerType(), r102.getOwnerType());
        L22:
            throw new IllegalArgumentException(r101 + " is not a " + ParameterizedType.class.getSimpleName());
        }

        @Override // com.google.common.reflect.j
        public final void e(TypeVariable<?> r100) {
            this.f275690b.put(new C3861d(r100), this.f275691c);
        }

        @Override // com.google.common.reflect.j
        public final void f(WildcardType r100) {
            Type r101 = this.f275691c;
            if ((r101 instanceof WildcardType) == true) goto L5;
            return;
        L5:
            WildcardType r102 = (WildcardType) r101;
            Type[] r103 = r100.getUpperBounds();
            Type[] r104 = r102.getUpperBounds();
            Type[] r105 = r100.getLowerBounds();
            Type[] r106 = r102.getLowerBounds();
            int r107 = 0;
            if (r103.length == r104.length) goto L8;
        L10:
            boolean r108 = false;
        L11:
            com.google.common.base.m.i(r108, "Incompatible type: %s vs. %s", r100, this.f275691c);
            int r109 = 0;
        L13:
            if (r109 >= r103.length) goto L16;
            d.a(this.f275690b, r103[r109], r104[r109]);
            r109 = r109 + 1;
        L16:
            if (r107 >= r105.length) goto L18;
            d.a(this.f275690b, r105[r107], r106[r107]);
            r107 = r107 + 1;
            goto L16
        L18:
            return;
        L8:
            if (r105.length != r106.length) goto L10;
            r108 = true;
            goto L11
        }

        public a(Map r100, Type r101) {
            this.f275690b = r100;
            this.f275691c = r101;
        }
    }

    public static final class b extends j {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<C3861d, Type> f275692b;

        public b() {
            this.f275692b = new HashMap();
        }

        @Override // com.google.common.reflect.j
        public final void b(Class<?> r100) {
            a(new Type[]{r100.getGenericSuperclass()});
            a(r100.getGenericInterfaces());
        }

        @Override // com.google.common.reflect.j
        public final void d(ParameterizedType r110) {
            Class r100 = (Class) r110.getRawType();
            TypeVariable[] r101 = r100.getTypeParameters();
            Type[] r102 = r110.getActualTypeArguments();
            if (r101.length != r102.length) goto L5;
            boolean r103 = true;
        L6:
            com.google.common.base.m.o(r103);
            int r104 = 0;
        L8:
            if (r104 >= r101.length) goto L32;
            C3861d r105 = new C3861d(r101[r104]);
            Type r106 = r102[r104];
            if (((HashMap) this.f275692b).containsKey(r105) == true) goto L31;
            Type r107 = r106;
        L13:
            if (r107 == null) goto L30;
            boolean r108 = r107 instanceof TypeVariable;
            if (r108 == false) goto L17;
            boolean r111 = r105.a((TypeVariable) r107);
        L18:
            C3861d r112 = null;
            if (r111 == true) goto L20;
            Map<C3861d, Type> r113 = this.f275692b;
            if (r108 == false) goto L29;
            r112 = new C3861d((TypeVariable) r107);
        L29:
            r107 = (Type) ((HashMap) r113).get(r112);
        L20:
            if (r106 == null) goto L31;
            Map<C3861d, Type> r109 = this.f275692b;
            if ((r106 instanceof TypeVariable) == false) goto L24;
            C3861d r114 = new C3861d((TypeVariable) r106);
        L25:
            r106 = (Type) ((HashMap) r109).remove(r114);
            goto L20
        L24:
            r114 = null;
            goto L25
        L17:
            r111 = false;
            goto L18
        L30:
            ((HashMap) this.f275692b).put(r105, r106);
        L31:
            r104 = r104 + 1;
            goto L8
        L32:
            a(new Type[]{r100});
            a(new Type[]{r110.getOwnerType()});
            return;
        L5:
            r103 = false;
            goto L6
        }

        @Override // com.google.common.reflect.j
        public final void e(TypeVariable<?> r100) {
            a(r100.getBounds());
        }

        @Override // com.google.common.reflect.j
        public final void f(WildcardType r100) {
            a(r100.getUpperBounds());
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ImmutableMap<C3861d, Type> f275693a;

        public c() {
            this.f275693a = ImmutableMap.of();
        }

        public c(ImmutableMap<C3861d, Type> r100) {
            this.f275693a = r100;
        }

        public Type a(TypeVariable r100, com.google.common.reflect.e r101) {
            Type r102 = this.f275693a.get(new C3861d(r100));
            if (r102 != null) goto L15;
            Type[] r103 = r100.getBounds();
            if (r103.length != 0) goto L7;
            return r100;
        L7:
            Type[] r104 = new d(r101).c(r103);
            if (Types.b.f275680a == false) goto L13;
            if (Arrays.equals(r103, r104) == false) goto L13;
            return r100;
        L13:
            return Types.e(r100.getGenericDeclaration(), r100.getName(), r104);
        L15:
            return new d(r101).b(r102);
        }
    }

    /* JADX INFO: renamed from: com.google.common.reflect.d$d, reason: collision with other inner class name */
    public static final class C3861d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final TypeVariable<?> f275694a;

        public final int hashCode() {
            return Arrays.hashCode(new Object[]{this.f275694a.getGenericDeclaration(), this.f275694a.getName()});
        }

        public final String toString() {
            return this.f275694a.toString();
        }

        public C3861d(TypeVariable<?> r100) {
            r100.getClass();
            this.f275694a = r100;
        }

        public final boolean a(TypeVariable<?> r100) {
            if (this.f275694a.getGenericDeclaration().equals(r100.getGenericDeclaration()) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f275694a.getName().equals(r100.getName()) == false) goto L7;
            return true;
        }

        public final boolean equals(@CheckForNull Object r100) {
            if ((r100 instanceof C3861d) == true) goto L5;
            return false;
        L5:
            return a(((C3861d) r100).f275694a);
        }
    }

    public static class e {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f275695b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f275696a;

        static {
            f275695b = new e();
        }

        public e() {
            this(new AtomicInteger());
        }

        public e(AtomicInteger r100) {
            this.f275696a = r100;
        }

        public final Type a(Type r100) {
            r100.getClass();
            if ((r100 instanceof Class) == false) goto L6;
            return r100;
        L6:
            if ((r100 instanceof TypeVariable) == false) goto L9;
            return r100;
        L9:
            if ((r100 instanceof GenericArrayType) == false) goto L13;
            return Types.d(new e(this.f275696a).a(((GenericArrayType) r100).getGenericComponentType()));
        L13:
            if ((r100 instanceof ParameterizedType) == false) goto L25;
            ParameterizedType r101 = (ParameterizedType) r100;
            Class r102 = (Class) r101.getRawType();
            TypeVariable[] r103 = r102.getTypeParameters();
            Type[] r104 = r101.getActualTypeArguments();
            int r105 = 0;
        L16:
            if (r105 >= r104.length) goto L18;
            TypeVariable r106 = r103[r105];
            r104[r105] = new f(this.f275696a, r106).a(r104[r105]);
            r105 = r105 + 1;
            goto L16
        L18:
            e r107 = new e(this.f275696a);
            Type r108 = r101.getOwnerType();
            if (r108 != null) goto L21;
            Type r109 = null;
        L23:
            return Types.f(r109, r102, r104);
        L21:
            r109 = r107.a(r108);
            goto L23
        L25:
            if ((r100 instanceof WildcardType) == false) goto L31;
            WildcardType r110 = (WildcardType) r100;
            if (r110.getLowerBounds().length == 0) goto L29;
            return r100;
        L29:
            return b(r110.getUpperBounds());
        L31:
            throw new AssertionError("must have been one of the known types");
        }

        public TypeVariable<?> b(Type[] r100) {
            return Types.e(e.class, "capture#" + this.f275696a.incrementAndGet() + "-of ? extends " + new com.google.common.base.i(String.valueOf(Typography.amp)).b(Arrays.asList(r100)), r100);
        }
    }

    public d() {
        this.f275689a = new c();
    }

    public d(c r100) {
        this.f275689a = r100;
    }

    public final Type b(Type r100) {
        r100.getClass();
        if ((r100 instanceof TypeVariable) == false) goto L7;
        c r101 = this.f275689a;
        TypeVariable r102 = (TypeVariable) r100;
        r101.getClass();
        return r101.a(r102, new com.google.common.reflect.e(r102, r101));
    L7:
        if ((r100 instanceof ParameterizedType) == false) goto L15;
        ParameterizedType r103 = (ParameterizedType) r100;
        Type r104 = r103.getOwnerType();
        if (r104 != null) goto L11;
        Type r105 = null;
    L12:
        Type r106 = b(r103.getRawType());
        Class r107 = (Class) r106;
        return Types.f(r105, r107, c(r103.getActualTypeArguments()));
    L11:
        r105 = b(r104);
        goto L12
    L15:
        if ((r100 instanceof GenericArrayType) == false) goto L19;
        return Types.d(b(((GenericArrayType) r100).getGenericComponentType()));
    L19:
        if ((r100 instanceof WildcardType) == false) goto L22;
        WildcardType r108 = (WildcardType) r100;
        Type[] r109 = r108.getLowerBounds();
        Type[] r110 = r108.getUpperBounds();
        return new Types.WildcardTypeImpl(c(r109), c(r110));
    L22:
        return r100;
    }

    public final Type[] c(Type[] r100) {
        Type[] r101 = new Type[r100.length];
        int r102 = 0;
    L4:
        if (r102 >= r100.length) goto L6;
        r101[r102] = b(r100[r102]);
        r102 = r102 + 1;
        goto L4
    L6:
        return r101;
    }

    public final d d(Map<C3861d, ? extends Type> r100) {
        c r101 = this.f275689a;
        r101.getClass();
        ImmutableMap.b r102 = ImmutableMap.builder();
        r102.h(r101.f275693a);
        Iterator<Map.Entry<C3861d, ? extends Type>> r103 = r100.entrySet().iterator();
    L4:
        if (r103.hasNext() == false) goto L11;
        Map.Entry<C3861d, ? extends Type> r104 = r103.next();
        C3861d r105 = r104.getKey();
        Type r106 = r104.getValue();
        r105.getClass();
        if ((r106 instanceof TypeVariable) == false) goto L8;
        boolean r107 = r105.a((TypeVariable) r106);
    L9:
        com.google.common.base.m.h(!r107, "Type variable %s bound to itself", r105);
        r102.e(r105, r106);
        goto L4
    L8:
        r107 = false;
        goto L9
    L11:
        return new d(new c(r102.d()));
    }

    public static void a(Map<C3861d, Type> r100, Type r101, Type r102) {
        if (r101.equals(r102) == false) goto L5;
        return;
    L5:
        new a(r100, r102).a(new Type[]{r101});
    }
}
