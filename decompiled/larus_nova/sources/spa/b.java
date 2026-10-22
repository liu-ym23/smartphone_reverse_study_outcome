package spa;

import android.content.Context;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes34.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class<?> f542915a;

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("com.relax.relaxclay.RelaxClayInitiator");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("com.relax.relaxclay.RelaxClayInitiator");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("com.relax.relaxclay.RelaxClayInitiator");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("com.relax.relaxclay.RelaxClayInitiator");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("com.relax.relaxclay.RelaxClayInitiator");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("com.relax.relaxclay.RelaxClayInitiator");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("com.relax.relaxclay.RelaxClayInitiator");
    }

    public static synchronized void b(Context r100, String r101) {
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
            java.lang.Class<spa.b> r0 = spa.b.class
            monitor-enter(r0)
            java.lang.Class<?> r1 = spa.b.f542915a     // Catch: java.lang.Throwable -> L2d java.lang.NoSuchMethodException -> L2f java.lang.IllegalAccessException -> L47 java.lang.reflect.InvocationTargetException -> L5f java.lang.ClassNotFoundException -> L77
            if (r1 != 0) goto Ld
            java.lang.Class r1 = a()     // Catch: java.lang.Throwable -> L2d java.lang.NoSuchMethodException -> L2f java.lang.IllegalAccessException -> L47 java.lang.reflect.InvocationTargetException -> L5f java.lang.ClassNotFoundException -> L77
            spa.b.f542915a = r1     // Catch: java.lang.Throwable -> L2d java.lang.NoSuchMethodException -> L2f java.lang.IllegalAccessException -> L47 java.lang.reflect.InvocationTargetException -> L5f java.lang.ClassNotFoundException -> L77
        Ld:
            java.lang.Class<?> r1 = spa.b.f542915a     // Catch: java.lang.Throwable -> L2d java.lang.NoSuchMethodException -> L2f java.lang.IllegalAccessException -> L47 java.lang.reflect.InvocationTargetException -> L5f java.lang.ClassNotFoundException -> L77
            java.lang.String r2 = "init"
            r3 = 2
            java.lang.Class[] r4 = new java.lang.Class[r3]     // Catch: java.lang.Throwable -> L2d java.lang.NoSuchMethodException -> L2f java.lang.IllegalAccessException -> L47 java.lang.reflect.InvocationTargetException -> L5f java.lang.ClassNotFoundException -> L77
            java.lang.Class<android.content.Context> r5 = android.content.Context.class
            r6 = 0
            r4[r6] = r5     // Catch: java.lang.Throwable -> L2d java.lang.NoSuchMethodException -> L2f java.lang.IllegalAccessException -> L47 java.lang.reflect.InvocationTargetException -> L5f java.lang.ClassNotFoundException -> L77
            java.lang.Class<java.lang.String> r5 = java.lang.String.class
            r7 = 1
            r4[r7] = r5     // Catch: java.lang.Throwable -> L2d java.lang.NoSuchMethodException -> L2f java.lang.IllegalAccessException -> L47 java.lang.reflect.InvocationTargetException -> L5f java.lang.ClassNotFoundException -> L77
            java.lang.reflect.Method r1 = r1.getMethod(r2, r4)     // Catch: java.lang.Throwable -> L2d java.lang.NoSuchMethodException -> L2f java.lang.IllegalAccessException -> L47 java.lang.reflect.InvocationTargetException -> L5f java.lang.ClassNotFoundException -> L77
            java.lang.Object[] r2 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L2d java.lang.NoSuchMethodException -> L2f java.lang.IllegalAccessException -> L47 java.lang.reflect.InvocationTargetException -> L5f java.lang.ClassNotFoundException -> L77
            r2[r6] = r8     // Catch: java.lang.Throwable -> L2d java.lang.NoSuchMethodException -> L2f java.lang.IllegalAccessException -> L47 java.lang.reflect.InvocationTargetException -> L5f java.lang.ClassNotFoundException -> L77
            r2[r7] = r9     // Catch: java.lang.Throwable -> L2d java.lang.NoSuchMethodException -> L2f java.lang.IllegalAccessException -> L47 java.lang.reflect.InvocationTargetException -> L5f java.lang.ClassNotFoundException -> L77
            r8 = 0
            r1.invoke(r8, r2)     // Catch: java.lang.Throwable -> L2d java.lang.NoSuchMethodException -> L2f java.lang.IllegalAccessException -> L47 java.lang.reflect.InvocationTargetException -> L5f java.lang.ClassNotFoundException -> L77
            goto L8f
        L2d:
            r8 = move-exception
            goto L91
        L2f:
            r8 = move-exception
            java.lang.Boolean r9 = i6a.a.f488445a     // Catch: java.lang.Throwable -> L2d
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L2d
            if (r9 == 0) goto L8f
            java.lang.Boolean r9 = i6a.a.f488446b     // Catch: java.lang.Throwable -> L2d
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L2d
            if (r9 != 0) goto L41
            goto L8f
        L41:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L2d
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2d
            throw r9     // Catch: java.lang.Throwable -> L2d
        L47:
            r8 = move-exception
            java.lang.Boolean r9 = i6a.a.f488445a     // Catch: java.lang.Throwable -> L2d
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L2d
            if (r9 == 0) goto L8f
            java.lang.Boolean r9 = i6a.a.f488446b     // Catch: java.lang.Throwable -> L2d
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L2d
            if (r9 != 0) goto L59
            goto L8f
        L59:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L2d
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2d
            throw r9     // Catch: java.lang.Throwable -> L2d
        L5f:
            r8 = move-exception
            java.lang.Boolean r9 = i6a.a.f488445a     // Catch: java.lang.Throwable -> L2d
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L2d
            if (r9 == 0) goto L8f
            java.lang.Boolean r9 = i6a.a.f488446b     // Catch: java.lang.Throwable -> L2d
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L2d
            if (r9 != 0) goto L71
            goto L8f
        L71:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L2d
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2d
            throw r9     // Catch: java.lang.Throwable -> L2d
        L77:
            r8 = move-exception
            java.lang.Boolean r9 = i6a.a.f488445a     // Catch: java.lang.Throwable -> L2d
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L2d
            if (r9 == 0) goto L8f
            java.lang.Boolean r9 = i6a.a.f488446b     // Catch: java.lang.Throwable -> L2d
            boolean r9 = r9.booleanValue()     // Catch: java.lang.Throwable -> L2d
            if (r9 != 0) goto L89
            goto L8f
        L89:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException     // Catch: java.lang.Throwable -> L2d
            r9.<init>(r8)     // Catch: java.lang.Throwable -> L2d
            throw r9     // Catch: java.lang.Throwable -> L2d
        L8f:
            monitor-exit(r0)
            return
        L91:
            monitor-exit(r0)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: spa.b.b(android.content.Context, java.lang.String):void");
    }
}
