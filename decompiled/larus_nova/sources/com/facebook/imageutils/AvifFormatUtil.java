package com.facebook.imageutils;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.facebook.common.logging.FLog;
import com.facebook.datasource.FrescoOptUtil;
import com.facebook.imageformat.ImageFormat;
import com.larus.mirabridge.impl.lancet.FastClassNotFoundHandler;
import com.larus.mirabridge.impl.lancet.MiraPluginFix;
import el9.a;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class AvifFormatUtil {
    private static final String TAG = "AvifFormatUtil";
    private static Class sAvifDecodeClass;
    private static ImageFormat sAvifFormat;
    private static ImageFormat sAvifFormatAnimated;
    private static Method sParseMetaMethod;

    public AvifFormatUtil() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        sAvifDecodeClass = INVOKESTATIC_com_facebook_imageutils_AvifFormatUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.fresco.avif.AvifDecoder");     // Catch: Throwable -> L4
        return;
    L4:
        FLog.e(TAG, "No AvifDecoder class");
    }

    public static ImageFormat getAvifFormat() {
        ImageFormat r100 = sAvifFormat;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Class r101 = sAvifDecodeClass;
        if (r101 == null) goto L8;
        sAvifFormat = (ImageFormat) r101.getDeclaredField("AVIF_FORMAT").get(null);     // Catch: Throwable -> L11 IllegalAccessException -> L12 NoSuchFieldException -> L13
    L15:
        return sAvifFormat;
    L12:
        FLog.e(TAG, "IllegalAccessException happened when invoke getAvifFormat");
    L13:
        FLog.e(TAG, "No AVIF_FORMAT field In AvifDecoder");
    L11:
        FLog.e(TAG, "Exception happened when invoke getAvifFormat");
        goto L15
    L8:
        return ImageFormat.UNKNOWN;
    }

    public static ImageFormat getAvifFormatAnimated() {
        ImageFormat r100 = sAvifFormatAnimated;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Class r101 = sAvifDecodeClass;
        if (r101 == null) goto L8;
        sAvifFormatAnimated = (ImageFormat) r101.getDeclaredField("AVIF_FORMAT_ANIMATED").get(null);     // Catch: Throwable -> L11 IllegalAccessException -> L12 NoSuchFieldException -> L13
    L15:
        return sAvifFormatAnimated;
    L12:
        FLog.e(TAG, "IllegalAccessException happened when invoke getAvifFormatAnimated");
    L13:
        FLog.e(TAG, "No AVIF_FORMAT_ANIMATED field In AvifDecoder");
    L11:
        FLog.e(TAG, "Exception happened when invoke getAvifFormatAnimated");
        goto L15
    L8:
        return ImageFormat.UNKNOWN;
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_facebook_imageutils_AvifFormatUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
        ConcurrentHashMap<String, FastClassNotFoundHandler.Status> r101 = FastClassNotFoundHandler.f359329a;
        FastClassNotFoundHandler.Status r102 = FastClassNotFoundHandler.Status.STATUS_NOTING;
        if (a.a() == true) goto L34;
        Class r103 = access$000(r100);     // Catch: Throwable -> L8
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
        Class r104 = access$000(r100);     // Catch: Throwable -> L17
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

    public static int[] readAvifImageSize(InputStream r100) throws IOException {
        int r101 = r100.available();
        if (FrescoOptUtil.getAvifParseLimit() > 0) goto L5;
    L7:
        byte[] r102 = new byte[r101];
        r100.reset();
        if (r100.read(r102, 0, r101) != (-1)) goto L10;
        return null;
    L10:
        return parseSimpleMeta(r102, r101);
    L5:
        if (r101 <= FrescoOptUtil.getAvifParseLimit()) goto L7;
        r101 = FrescoOptUtil.getAvifParseLimit();
        goto L7
    }

    public static int[] parseSimpleMeta(byte[] r100, int r110) {
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
            java.lang.String r0 = "AvifFormatUtil"
            java.lang.Class r1 = com.facebook.imageutils.AvifFormatUtil.sAvifDecodeClass
            r2 = 0
            if (r1 != 0) goto L8
            return r2
        L8:
            java.lang.reflect.Method r3 = com.facebook.imageutils.AvifFormatUtil.sParseMetaMethod     // Catch: java.lang.Throwable -> L3b java.lang.reflect.InvocationTargetException -> L41 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L4d
            r4 = 0
            r5 = 2
            r6 = 1
            if (r3 != 0) goto L21
            java.lang.String r3 = "parseSimpleMeta"
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch: java.lang.Throwable -> L3b java.lang.reflect.InvocationTargetException -> L41 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L4d
            java.lang.Class<byte[]> r8 = byte[].class
            r7[r4] = r8     // Catch: java.lang.Throwable -> L3b java.lang.reflect.InvocationTargetException -> L41 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L4d
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch: java.lang.Throwable -> L3b java.lang.reflect.InvocationTargetException -> L41 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L4d
            r7[r6] = r8     // Catch: java.lang.Throwable -> L3b java.lang.reflect.InvocationTargetException -> L41 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L4d
            java.lang.reflect.Method r1 = r1.getDeclaredMethod(r3, r7)     // Catch: java.lang.Throwable -> L3b java.lang.reflect.InvocationTargetException -> L41 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L4d
            com.facebook.imageutils.AvifFormatUtil.sParseMetaMethod = r1     // Catch: java.lang.Throwable -> L3b java.lang.reflect.InvocationTargetException -> L41 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L4d
        L21:
            java.lang.reflect.Method r1 = com.facebook.imageutils.AvifFormatUtil.sParseMetaMethod     // Catch: java.lang.Throwable -> L3b java.lang.reflect.InvocationTargetException -> L41 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L4d
            if (r1 == 0) goto L52
            r1.setAccessible(r6)     // Catch: java.lang.Throwable -> L3b java.lang.reflect.InvocationTargetException -> L41 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L4d
            java.lang.reflect.Method r1 = com.facebook.imageutils.AvifFormatUtil.sParseMetaMethod     // Catch: java.lang.Throwable -> L3b java.lang.reflect.InvocationTargetException -> L41 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L4d
            java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L3b java.lang.reflect.InvocationTargetException -> L41 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L4d
            r3[r4] = r9     // Catch: java.lang.Throwable -> L3b java.lang.reflect.InvocationTargetException -> L41 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L4d
            java.lang.Integer r9 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Throwable -> L3b java.lang.reflect.InvocationTargetException -> L41 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L4d
            r3[r6] = r9     // Catch: java.lang.Throwable -> L3b java.lang.reflect.InvocationTargetException -> L41 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L4d
            java.lang.Object r9 = r1.invoke(r2, r3)     // Catch: java.lang.Throwable -> L3b java.lang.reflect.InvocationTargetException -> L41 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L4d
            int[] r9 = (int[]) r9     // Catch: java.lang.Throwable -> L3b java.lang.reflect.InvocationTargetException -> L41 java.lang.IllegalAccessException -> L47 java.lang.NoSuchMethodException -> L4d
            return r9
        L3b:
            java.lang.String r9 = "Exception happened when invoke parseSimpleMeta"
            com.facebook.common.logging.FLog.e(r0, r9)
            goto L52
        L41:
            java.lang.String r9 = "InvocationTargetException happened when invoke parseSimpleMeta"
            com.facebook.common.logging.FLog.e(r0, r9)
            goto L52
        L47:
            java.lang.String r9 = "IllegalAccessException happened when invoke parseSimpleMeta"
            com.facebook.common.logging.FLog.e(r0, r9)
            goto L52
        L4d:
            java.lang.String r9 = "No parseSimpleMeta method AvifDecoder"
            com.facebook.common.logging.FLog.e(r0, r9)
        L52:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imageutils.AvifFormatUtil.parseSimpleMeta(byte[], int):int[]");
    }
}
