package com.larksuite.framework.utils;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import com.ss.android.lark.log.Log;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes24.dex */
public final class Reflect {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f285916a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f285917b;

    public static class ReflectException extends RuntimeException {
        private static final long serialVersionUID = -2243843843843438438L;

        public ReflectException() {
        }

        public ReflectException(String r100) {
            super(r100);
        }

        public ReflectException(Throwable r100) {
            super(r100);
        }

        public ReflectException(String r100, Throwable r101) {
            super(r100, r101);
        }
    }

    public static class a {
        public a() {
        }
    }

    public final Reflect c() throws ReflectException {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            r0 = 0
            java.lang.Object[] r1 = new java.lang.Object[r0]
            java.lang.Class[] r2 = new java.lang.Class[r0]
            java.lang.Class r3 = r8.k()     // Catch: java.lang.NoSuchMethodException -> L24
            java.lang.reflect.Constructor r3 = r3.getDeclaredConstructor(r2)     // Catch: java.lang.NoSuchMethodException -> L24
            java.lang.reflect.AccessibleObject r3 = b(r3)     // Catch: java.lang.Exception -> L1d
            java.lang.reflect.Constructor r3 = (java.lang.reflect.Constructor) r3     // Catch: java.lang.Exception -> L1d
            java.lang.Object r3 = r3.newInstance(r1)     // Catch: java.lang.Exception -> L1d
            com.larksuite.framework.utils.Reflect r4 = new com.larksuite.framework.utils.Reflect     // Catch: java.lang.Exception -> L1d
            r4.<init>(r3)     // Catch: java.lang.Exception -> L1d
            goto L4b
        L1d:
            r3 = move-exception
            com.larksuite.framework.utils.Reflect$ReflectException r4 = new com.larksuite.framework.utils.Reflect$ReflectException     // Catch: java.lang.NoSuchMethodException -> L24
            r4.<init>(r3)     // Catch: java.lang.NoSuchMethodException -> L24
            throw r4     // Catch: java.lang.NoSuchMethodException -> L24
        L24:
            r3 = move-exception
            java.lang.Class r4 = r8.k()
            java.lang.reflect.Constructor[] r4 = r4.getDeclaredConstructors()
            int r5 = r4.length
        L2e:
            if (r0 >= r5) goto L56
            r6 = r4[r0]
            java.lang.Class[] r7 = r6.getParameterTypes()
            boolean r7 = g(r7, r2)
            if (r7 == 0) goto L53
            java.lang.reflect.AccessibleObject r0 = b(r6)     // Catch: java.lang.Exception -> L4c
            java.lang.reflect.Constructor r0 = (java.lang.reflect.Constructor) r0     // Catch: java.lang.Exception -> L4c
            java.lang.Object r0 = r0.newInstance(r1)     // Catch: java.lang.Exception -> L4c
            com.larksuite.framework.utils.Reflect r4 = new com.larksuite.framework.utils.Reflect     // Catch: java.lang.Exception -> L4c
            r4.<init>(r0)     // Catch: java.lang.Exception -> L4c
        L4b:
            return r4
        L4c:
            r0 = move-exception
            com.larksuite.framework.utils.Reflect$ReflectException r1 = new com.larksuite.framework.utils.Reflect$ReflectException
            r1.<init>(r0)
            throw r1
        L53:
            int r0 = r0 + 1
            goto L2e
        L56:
            com.larksuite.framework.utils.Reflect$ReflectException r0 = new com.larksuite.framework.utils.Reflect$ReflectException
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.larksuite.framework.utils.Reflect.c():com.larksuite.framework.utils.Reflect");
    }

    public final int hashCode() {
        return this.f285916a.hashCode();
    }

    public final Class<?> k() {
        if (this.f285917b == false) goto L7;
        return (Class) this.f285916a;
    L7:
        return this.f285916a.getClass();
    }

    public final String toString() {
        return this.f285916a.toString();
    }

    public Reflect(Class<?> r100) {
        this.f285916a = r100;
        this.f285917b = true;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r103 = Class.forName(r100);     // Catch: Throwable -> L8
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L8
    L7:
        return r103;
    L8:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b(r100);
    L12:
        throw th;
    L34:
        Class<?> r104 = Class.forName(r100);     // Catch: Throwable -> L17
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a(r100);     // Catch: Throwable -> L17
    L16:
        return r104;
    L17:
        th = move-exception;
        if (r102 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b(r100);
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName(r100);
    }

    public static <T extends AccessibleObject> T b(T r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if ((r100 instanceof Member) == false) goto L13;
        Member r101 = (Member) r100;
        if (Modifier.isPublic(r101.getModifiers()) == false) goto L13;
        if (Modifier.isPublic(r101.getDeclaringClass().getModifiers()) == false) goto L13;
        return r100;
    L13:
        if (r100.isAccessible() == true) goto L15;
        r100.setAccessible(true);
    L15:
        return r100;
    }

    public static Class<?> l(Class<?> r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.isPrimitive() == true) goto L8;
        return r100;
    L8:
        if (Boolean.TYPE != r100) goto L12;
        return Boolean.class;
    L12:
        if (Integer.TYPE != r100) goto L16;
        return Integer.class;
    L16:
        if (Long.TYPE != r100) goto L20;
        return Long.class;
    L20:
        if (Short.TYPE != r100) goto L24;
        return Short.class;
    L24:
        if (Byte.TYPE != r100) goto L28;
        return Byte.class;
    L28:
        if (Double.TYPE != r100) goto L32;
        return Double.class;
    L32:
        if (Float.TYPE != r100) goto L36;
        return Float.class;
    L36:
        if (Character.TYPE != r100) goto L40;
        return Character.class;
    L40:
        if (Void.TYPE != r100) goto L44;
        return Void.class;
    L44:
        return r100;
    }

    public Reflect call(String r100) throws ReflectException {
        return call(r100, null, new Object[0]);
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof Reflect) == true) goto L5;
        return false;
    L5:
        return this.f285916a.equals(((Reflect) r100).f285916a);
    }

    public Reflect(Object r100) {
        this.f285916a = r100;
        this.f285917b = false;
    }

    public static boolean g(Class[] r100, Class[] r101) {
        if (r100.length != r101.length) goto L16;
        int r102 = 0;
    L6:
        if (r102 >= r101.length) goto L14;
        if (r101[r102] == a.class) goto L12;
        if (l(r100[r102]).isAssignableFrom(l(r101[r102])) == true) goto L12;
        return false;
    L12:
        r102 = r102 + 1;
        goto L6
    L14:
        return true;
    L16:
        return false;
    }

    public final Method d(String r110, Class... r111) throws NoSuchMethodException {
        String r100 = r110;
        Class<?> r101 = k();
        return r101.getMethod(r100, r111);
    L25:
        return r101.getDeclaredMethod(r100, r111);
    L7:
        r101 = r101.getSuperclass();
        if (r101 != null) goto L25;
        Class<?> r102 = k();
        Method[] r103 = r102.getMethods();
        int r104 = r103.length;
        int r105 = 0;
    L10:
        if (r105 >= r104) goto L21;
        Method r106 = r103[r105];
        if (r100.equals(r106.getName()) == false) goto L19;
        Class<?>[] r107 = r106.getParameterTypes();
        int r108 = r107.length;
        int r112 = 0;
        int r113 = 1;
    L14:
        if (r112 >= r108) goto L17;
        Log.d("Plugin", "Reflect type = " + r102 + " method = " + r100 + " paramTypes " + r113 + " = " + r107[r112].getName());
        r113 = r113 + 1;
        r112 = r112 + 1;
        goto L14
    L17:
        if (r107.length != r111.length) goto L19;
        return r106;
    L19:
        r105 = r105 + 1;
        goto L10
    L21:
        throw new NoSuchMethodException();
    }

    public final Reflect e(String r100, Class<?>... r101) throws ReflectException {
        return new Reflect(f(r100, r101).get(this.f285916a));
    L4:
        e = move-exception;
        throw new ReflectException(e);
    }

    public final Field f(String r100, Class<?>... r110) throws ReflectException {
        Class<?> r101 = k();
        if (r110.length <= 0) goto L35;
    L31:
        Field[] r102 = r101.getDeclaredFields();     // Catch: Exception -> L15
        int r103 = r102.length;     // Catch: Exception -> L15
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L16;
        Field r105 = r102[r104];     // Catch: Exception -> L15
        Class<?> r106 = r105.getType();     // Catch: Exception -> L15
        if (r106 == null) goto L14;
        if (r106.getName().equals(r110[0].getName()) == false) goto L14;
        if (r105.getName().equals(r100) == false) goto L14;
        return (Field) b(r105);
    L14:
        r104 = r104 + 1;
    L16:
        r101 = r101.getSuperclass();
        if (r101 != null) goto L31;
        throw new ReflectException("NoSuchFieldException");
    L35:
        return r101.getField(r100);
    L23:
        e = move-exception;
    L33:
        return (Field) b(r101.getDeclaredField(r100));
    L26:
        r101 = r101.getSuperclass();
        if (r101 != null) goto L33;
        throw new ReflectException(e);
    }

    public final void i(String r100, Object r101) throws ReflectException {
        Field r102 = f(r100, new Class[0]);     // Catch: Exception -> L8
        Object r103 = this.f285916a;     // Catch: Exception -> L8
        if ((r101 instanceof Reflect) == false) goto L6;
        r101 = ((Reflect) r101).f285916a;     // Catch: Exception -> L8
    L6:
        r102.set(r103, r101);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        throw new ReflectException(e);
    }

    public final Method j(String r100, Class<?>[] r110) throws NoSuchMethodException {
        Class<?> r101 = k();
        Method[] r102 = r101.getMethods();
        int r103 = r102.length;
        int r104 = 0;
    L3:
        boolean r105 = true;
        if (r104 >= r103) goto L14;
        Method r106 = r102[r104];
        if (r106.getName().equals(r100) == true) goto L8;
    L10:
        r105 = false;
    L11:
        if (r105 == true) goto L12;
        r104 = r104 + 1;
        goto L3
    L12:
        return r106;
    L8:
        if (g(r106.getParameterTypes(), r110) == false) goto L10;
    L14:
        Method[] r107 = r101.getDeclaredMethods();
        int r108 = r107.length;
        int r109 = 0;
    L15:
        if (r109 >= r108) goto L25;
        Method r111 = r107[r109];
        if (r111.getName().equals(r100) == true) goto L19;
    L21:
        boolean r112 = false;
    L22:
        if (r112 == true) goto L23;
        r109 = r109 + 1;
        goto L15
    L23:
        return r111;
    L19:
        if (g(r111.getParameterTypes(), r110) == false) goto L21;
        r112 = true;
        goto L22
    L25:
        r101 = r101.getSuperclass();
        if (r101 != null) goto L14;
        throw new NoSuchMethodException("No similar method " + r100 + " with params " + Arrays.toString(r110) + " could be found on type " + k() + ".");
    }

    public static Reflect h(Method r100, Object r101, Object... r102) throws ReflectException {
        b(r100);     // Catch: Exception -> L8
        if (r100.getReturnType() != Void.TYPE) goto L7;
        r100.invoke(r101, r102);     // Catch: Exception -> L8
        return new Reflect(r101);
    L7:
        return new Reflect(r100.invoke(r101, r102));
    L8:
        e = move-exception;
        throw new ReflectException(e);
    }

    public Reflect call(String r100, Class<?>[] r101, Object... r102) throws ReflectException {
        return h(d(r100, r101), this.f285916a, r102);
    L4:
        return h(j(r100, r101), this.f285916a, r102);
    L6:
        e = move-exception;
        throw new ReflectException(e);
    }
}
