package v49;

import android.widget.OverScroller;
import androidx.camera.video.AudioStats;
import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes27.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Class<?> f553136a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static Method f553137b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static Method f553138c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static boolean f553139d;

    static {
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class a() throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r100 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r101 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (el9.a.a() == true) goto L34;
        Class<?> r102 = Class.forName("android.widget.OverScroller");     // Catch: Throwable -> L8
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L7;
        FastClassNotFoundHandler.a("android.widget.OverScroller");     // Catch: Throwable -> L8
    L7:
        return r102;
    L8:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L12;
        FastClassNotFoundHandler.b("android.widget.OverScroller");
    L12:
        throw th;
    L34:
        Class<?> r103 = Class.forName("android.widget.OverScroller");     // Catch: Throwable -> L17
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L16;
        FastClassNotFoundHandler.a("android.widget.OverScroller");     // Catch: Throwable -> L17
    L16:
        return r103;
    L17:
        th = move-exception;
        if (r101 != FastClassNotFoundHandler.Status.STATUS_NEED_CHECK) goto L22;
        FastClassNotFoundHandler.b("android.widget.OverScroller");
    L22:
        if ((th instanceof PluginClassNotFoundException) == false) goto L24;
        throw th;
    L24:
        if ((th instanceof ClassNotFoundException) == true) goto L30;
        if ((th instanceof NoClassDefFoundError) == true) goto L30;
        throw th;
    L30:
        return MiraPluginFix.forName("android.widget.OverScroller");
    }

    public static int b(g r100, int r101) {
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
            java.lang.String r0 = "ScrollerExt"
            java.lang.String r1 = "overScroller"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r1)
            r1 = 0
            r2 = 1
            java.lang.reflect.Method r3 = v49.f.f553138c     // Catch: java.lang.Exception -> L28
            if (r3 != 0) goto L1e
            java.lang.Class<android.widget.OverScroller> r3 = android.widget.OverScroller.class
            java.lang.String r4 = "disableDynamicScroll"
            java.lang.Class[] r5 = new java.lang.Class[r1]     // Catch: java.lang.Exception -> L28
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r5)     // Catch: java.lang.Exception -> L28
            v49.f.f553138c = r3     // Catch: java.lang.Exception -> L28
            if (r3 == 0) goto L1e
            r3.setAccessible(r2)     // Catch: java.lang.Exception -> L28
        L1e:
            java.lang.reflect.Method r3 = v49.f.f553138c     // Catch: java.lang.Exception -> L28
            if (r3 == 0) goto L2e
            java.lang.Object[] r4 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> L28
            r3.invoke(r6, r4)     // Catch: java.lang.Exception -> L28
            goto L2e
        L28:
            r3 = move-exception
            java.lang.String r4 = "disableDynamicScroll, failed"
            g49.d.c(r0, r4, r3)     // Catch: java.lang.Exception -> L4c
        L2e:
            java.lang.reflect.Method r3 = v49.f.f553137b     // Catch: java.lang.Exception -> L4c
            if (r3 == 0) goto L3f
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: java.lang.Exception -> L4c
            java.lang.Integer r4 = java.lang.Integer.valueOf(r7)     // Catch: java.lang.Exception -> L4c
            r2[r1] = r4     // Catch: java.lang.Exception -> L4c
            java.lang.Object r6 = r3.invoke(r6, r2)     // Catch: java.lang.Exception -> L4c
            goto L40
        L3f:
            r6 = 0
        L40:
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Double"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r6, r2)     // Catch: java.lang.Exception -> L4c
            java.lang.Double r6 = (java.lang.Double) r6     // Catch: java.lang.Exception -> L4c
            double r2 = r6.doubleValue()     // Catch: java.lang.Exception -> L4c
            goto L67
        L4c:
            r6 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "reflectGetSplineFlingDistance, velocity: "
            r2.<init>(r3)
            r2.append(r7)
            java.lang.String r3 = ", error"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            g49.d.c(r0, r2, r6)
            v49.f.f553139d = r1
            r2 = 0
        L67:
            if (r7 != 0) goto L6e
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
            goto L7a
        L6e:
            if (r7 <= 0) goto L75
            java.lang.Double r6 = java.lang.Double.valueOf(r2)
            goto L7a
        L75:
            double r6 = -r2
            java.lang.Double r6 = java.lang.Double.valueOf(r6)
        L7a:
            int r6 = r6.intValue()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: v49.f.b(v49.g, int):int");
    }

    public static void c(g r110, int r111, int r112, int r113, int r210, int r211, int r212) {
        g r100 = r110;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        if (f553139d == true) goto L5;
        g49.d.b("ScrollerExt", "calculateSnapVelocity, reflect failed, use original velocityY: " + r113);
        int r101 = r113;
    L47:
        r110.fling(0, r112, 0, r101, 0, 0, r210, r211, 0, r212);
        return;
    L5:
        if (r113 == 0) goto L45;
        float r102 = r112;
        float r103 = r111;
        float r104 = b(r100, r113) + r102;
        double r105 = r104 / r103;
        float r106 = ((float) Math.floor(r105)) * r103;
        float r107 = ((float) Math.ceil(r105)) * r103;
        if (Math.abs(r104 - r106) < Math.abs(r107 - r104)) goto L10;
        r106 = r107;
    L10:
        if (r113 <= 0) goto L12;
        byte r108 = 1;
    L13:
        int r109 = 0;
        if (r113 <= 0) goto L16;
        int r114 = 0;
        int r115 = 40000;
    L17:
        float r116 = Float.MAX_VALUE;
        int r117 = r113;
    L19:
        if (r109 >= 20) goto L46;
        int r118 = (r114 + r115) / 2;
        float r119 = b(r100, r118) + r102;
        float r120 = r119 - r106;
        if (Math.abs(r120) >= r116) goto L23;
        r116 = Math.abs(r120);
        r117 = r118;
    L23:
        g49.d.d("ScrollerExt", "calculateSnapVelocity, iteration: " + r109 + ", mid: " + r118 + ", low: " + r114 + ", high: " + r115 + ", diff: " + r120 + ", dist: " + r119 + ", targetDistance: " + r106 + ", bestDiff: " + r116 + ", bestVelocity: " + r117 + ", velocityY: " + r113 + ", currentOffset: " + r102);
        if (r108 <= 0) goto L31;
        if (r120 >= 0.0f) goto L28;
    L35:
        if (r108 <= 0) goto L40;
        if (r120 > 0.0f) goto L42;
    L41:
        r114 = r118 + 1;
    L43:
        if (r114 > r115) goto L46;
        r109 = r109 + 1;
        r100 = r110;
    L42:
        r115 = r118 - 1;
        goto L43
    L40:
        if (r120 >= 0.0f) goto L42;
    L28:
        if (Math.abs(r120) > 0.3f) goto L35;
    L31:
        if (r120 > 0.0f) goto L35;
        if (Math.abs(r120) > 0.3f) goto L35;
    L46:
        r101 = r117;
        goto L47
    L16:
        r114 = -40000;
        r115 = 0;
        goto L17
    L12:
        r108 = -1;
        goto L13
    L45:
        r117 = r113;
        goto L46
    }
}
