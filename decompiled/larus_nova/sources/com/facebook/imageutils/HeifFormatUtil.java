package com.facebook.imageutils;

import com.bytedance.mira.exception.PluginClassNotFoundException;
import com.facebook.common.logging.FLog;
import com.facebook.imageformat.DefaultImageFormats;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.image.EncodedImage;
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
public class HeifFormatUtil {
    private static final String TAG = "HeifFormatUtil";
    private static boolean mOptParseExif;
    private static volatile Class sHeifClass;
    private static Class sHeifDecodeClass;
    private static ImageFormat sHeifFormat;
    private static ImageFormat sHeifFormatAnimated;
    private static Method sParseMetaMethod;
    private static Method sParseMetaMethodByNativePtr;
    private static Method sParseThumbMetaMethod;
    private static Method sParseThumbMetaMethodByNativePtr;
    private static ImageFormat sVvifFormat;

    public HeifFormatUtil() {
    }

    public static /* synthetic */ Class access$000(String r100) throws ClassNotFoundException {
        return Class.forName(r100);
    }

    static {
        sHeifDecodeClass = INVOKESTATIC_com_facebook_imageutils_HeifFormatUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.fresco.heif.HeifDecoder");     // Catch: ClassNotFoundException -> L4
        return;
    L4:
        e = move-exception;
        FLog.e(TAG, "Heif init ", e);
    }

    private static synchronized Class getHeifClass() {
        monitor-enter(HeifFormatUtil.class);
    L13:
        th = move-exception;
        throw th;
    L5:
        if (sHeifClass == null) goto L16;
    L10:
        Class r100 = sHeifClass;     // Catch: Throwable -> L13
        monitor-exit(HeifFormatUtil.class);
        return r100;
    L16:
        sHeifClass = INVOKESTATIC_com_facebook_imageutils_HeifFormatUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName("com.bytedance.fresco.nativeheif.Heif");     // Catch: ClassNotFoundException -> L8 Throwable -> L13
    L8:
        e = move-exception;
        FLog.e(TAG, "Heif init ", e);     // Catch: Throwable -> L13
        goto L10
    }

    public static ImageFormat getHeifFormat() {
        ImageFormat r100 = sHeifFormat;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Class r101 = sHeifDecodeClass;
        if (r101 != null) goto L18;
        return null;
    L18:
        sHeifFormat = (ImageFormat) r101.getDeclaredField("HEIF_FORMAT").get(null);     // Catch: Exception -> L10 IllegalAccessException -> L12 NoSuchFieldException -> L14
    L17:
        return sHeifFormat;
    L12:
        e = move-exception;
        FLog.e(TAG, "HeifFormat init ", e);
    L14:
        e = move-exception;
        FLog.e(TAG, "HeifFormat init ", e);
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static ImageFormat getHeifFormatAnimated() {
        ImageFormat r100 = sHeifFormatAnimated;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Class r101 = sHeifDecodeClass;
        if (r101 != null) goto L18;
        return null;
    L18:
        sHeifFormatAnimated = (ImageFormat) r101.getDeclaredField("HEIF_FORMAT_ANIMATED").get(null);     // Catch: Exception -> L10 IllegalAccessException -> L12 NoSuchFieldException -> L14
    L17:
        return sHeifFormatAnimated;
    L12:
        e = move-exception;
        FLog.e(TAG, "HEIF_FORMAT_ANIMATED init ", e);
    L14:
        e = move-exception;
        FLog.e(TAG, "HEIF_FORMAT_ANIMATED init ", e);
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    public static ImageFormat getVvifFormat() {
        ImageFormat r100 = sVvifFormat;
        if (r100 == null) goto L5;
        return r100;
    L5:
        Class r101 = sHeifDecodeClass;
        if (r101 != null) goto L18;
        return null;
    L18:
        sVvifFormat = (ImageFormat) r101.getDeclaredField("VVIC_FORMAT").get(null);     // Catch: Exception -> L10 IllegalAccessException -> L12 NoSuchFieldException -> L14
    L17:
        return sVvifFormat;
    L12:
        e = move-exception;
        FLog.e(TAG, "VvifFormat init ", e);
    L14:
        e = move-exception;
        FLog.e(TAG, "VvifFormat init ", e);
    L10:
        e = move-exception;
        e.printStackTrace();
        goto L17
    }

    @Skip({"com.larus.mirabridge.impl.lancet+", "com.bytedance.mira.hook.delegate.DyMiraClassLoader", "com.bytedance.mira.hook.delegate.MiraClassLoader", "com.bytedance.ies.stark.util.NReflectUtils", "-com.bytedance.mira.core.PluginClassLoader", "com.bytedance.common.jato.util.DeviceInfoUtils", "com.bytedance.mira.helper.ClassLoaderHelper", "com.bytedance.mira.core.opt.res+"})
    public static Class INVOKESTATIC_com_facebook_imageutils_HeifFormatUtil_com_larus_mirabridge_impl_lancet_MiraReflectLancet_forName(String r100) throws ClassNotFoundException {
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

    public static boolean canParseThumbDataAndSet(EncodedImage r110) {
        if (r110 != null) goto L5;
    L22:
        return false;
    L5:
        if (DefaultImageFormats.isHeifFormat(r110.getImageFormat()) == false) goto L22;
        int r100 = r110.getInputStream().available();     // Catch: IOException -> L20
        if (EncodedImage.isOptHeifParse() == false) goto L10;
        int[] r101 = readHeifThumbData(r110.getNativePtr(), r110.getSize());     // Catch: IOException -> L20
    L11:
        if (r101 == null) goto L22;
        if (r101.length < 8) goto L22;
        if (r101[5] != 1) goto L22;
        FLog.d(TAG, "fresco_parseThumbData available len:" + r100 + " thumb:" + (r101[6] + r101[7]));     // Catch: IOException -> L20
        if ((r101[6] + r101[7]) >= r100) goto L19;
        r110.setIsDecodeThumb(true);     // Catch: IOException -> L20
        r110.setThumbWidth(r101[0]);     // Catch: IOException -> L20
        r110.setThumbHeight(r101[1]);     // Catch: IOException -> L20
    L19:
        return true;
    L10:
        r101 = readHeifThumbData(r110.getInputStream());     // Catch: IOException -> L20
    L20:
        e = move-exception;
        FLog.e(TAG, "canParseThumbData ", e);
        goto L22
    }

    public static int[] readHeifFormatImageSizeForSimple(InputStream r100) throws IOException {
        int r101 = r100.available();
        byte[] r102 = new byte[r101];
        r100.reset();
        if (r100.read(r102, 0, r101) == (-1)) goto L8;
        int[] r103 = parseSimpleMeta(r102, r101);
        if (r103 != null) goto L7;
    L7:
        return r103;
    L8:
        return null;
    }

    public static int[] readHeifThumbData(InputStream r100) throws IOException {
        if (r100 != null) goto L5;
        return null;
    L5:
        int r101 = r100.available();
        byte[] r102 = new byte[r101];
        r100.reset();
        if (r100.read(r102, 0, r101) != (-1)) goto L8;
        return null;
    L8:
        return parseThumbMeta(r102, r101);
    }

    public static void setOptParseExif(boolean r100) {
        mOptParseExif = r100;
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
            java.lang.Class r0 = getHeifClass()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            java.lang.reflect.Method r2 = com.facebook.imageutils.HeifFormatUtil.sParseMetaMethod     // Catch: java.lang.Exception -> L48 java.lang.reflect.InvocationTargetException -> L4d java.lang.IllegalAccessException -> L52 java.lang.NoSuchMethodException -> L57
            r3 = 2
            r4 = 0
            r5 = 3
            r6 = 1
            if (r2 != 0) goto L26
            java.lang.String r2 = "parseSimpleMeta"
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch: java.lang.Exception -> L48 java.lang.reflect.InvocationTargetException -> L4d java.lang.IllegalAccessException -> L52 java.lang.NoSuchMethodException -> L57
            java.lang.Class<byte[]> r8 = byte[].class
            r7[r4] = r8     // Catch: java.lang.Exception -> L48 java.lang.reflect.InvocationTargetException -> L4d java.lang.IllegalAccessException -> L52 java.lang.NoSuchMethodException -> L57
            java.lang.Class r8 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L48 java.lang.reflect.InvocationTargetException -> L4d java.lang.IllegalAccessException -> L52 java.lang.NoSuchMethodException -> L57
            r7[r6] = r8     // Catch: java.lang.Exception -> L48 java.lang.reflect.InvocationTargetException -> L4d java.lang.IllegalAccessException -> L52 java.lang.NoSuchMethodException -> L57
            java.lang.Class r8 = java.lang.Boolean.TYPE     // Catch: java.lang.Exception -> L48 java.lang.reflect.InvocationTargetException -> L4d java.lang.IllegalAccessException -> L52 java.lang.NoSuchMethodException -> L57
            r7[r3] = r8     // Catch: java.lang.Exception -> L48 java.lang.reflect.InvocationTargetException -> L4d java.lang.IllegalAccessException -> L52 java.lang.NoSuchMethodException -> L57
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r2, r7)     // Catch: java.lang.Exception -> L48 java.lang.reflect.InvocationTargetException -> L4d java.lang.IllegalAccessException -> L52 java.lang.NoSuchMethodException -> L57
            com.facebook.imageutils.HeifFormatUtil.sParseMetaMethod = r0     // Catch: java.lang.Exception -> L48 java.lang.reflect.InvocationTargetException -> L4d java.lang.IllegalAccessException -> L52 java.lang.NoSuchMethodException -> L57
        L26:
            java.lang.reflect.Method r0 = com.facebook.imageutils.HeifFormatUtil.sParseMetaMethod     // Catch: java.lang.Exception -> L48 java.lang.reflect.InvocationTargetException -> L4d java.lang.IllegalAccessException -> L52 java.lang.NoSuchMethodException -> L57
            if (r0 == 0) goto L5b
            r0.setAccessible(r6)     // Catch: java.lang.Exception -> L48 java.lang.reflect.InvocationTargetException -> L4d java.lang.IllegalAccessException -> L52 java.lang.NoSuchMethodException -> L57
            java.lang.reflect.Method r0 = com.facebook.imageutils.HeifFormatUtil.sParseMetaMethod     // Catch: java.lang.Exception -> L48 java.lang.reflect.InvocationTargetException -> L4d java.lang.IllegalAccessException -> L52 java.lang.NoSuchMethodException -> L57
            java.lang.Object[] r2 = new java.lang.Object[r5]     // Catch: java.lang.Exception -> L48 java.lang.reflect.InvocationTargetException -> L4d java.lang.IllegalAccessException -> L52 java.lang.NoSuchMethodException -> L57
            r2[r4] = r9     // Catch: java.lang.Exception -> L48 java.lang.reflect.InvocationTargetException -> L4d java.lang.IllegalAccessException -> L52 java.lang.NoSuchMethodException -> L57
            java.lang.Integer r9 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Exception -> L48 java.lang.reflect.InvocationTargetException -> L4d java.lang.IllegalAccessException -> L52 java.lang.NoSuchMethodException -> L57
            r2[r6] = r9     // Catch: java.lang.Exception -> L48 java.lang.reflect.InvocationTargetException -> L4d java.lang.IllegalAccessException -> L52 java.lang.NoSuchMethodException -> L57
            boolean r9 = com.facebook.imageutils.HeifFormatUtil.mOptParseExif     // Catch: java.lang.Exception -> L48 java.lang.reflect.InvocationTargetException -> L4d java.lang.IllegalAccessException -> L52 java.lang.NoSuchMethodException -> L57
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)     // Catch: java.lang.Exception -> L48 java.lang.reflect.InvocationTargetException -> L4d java.lang.IllegalAccessException -> L52 java.lang.NoSuchMethodException -> L57
            r2[r3] = r9     // Catch: java.lang.Exception -> L48 java.lang.reflect.InvocationTargetException -> L4d java.lang.IllegalAccessException -> L52 java.lang.NoSuchMethodException -> L57
            java.lang.Object r9 = r0.invoke(r1, r2)     // Catch: java.lang.Exception -> L48 java.lang.reflect.InvocationTargetException -> L4d java.lang.IllegalAccessException -> L52 java.lang.NoSuchMethodException -> L57
            int[] r9 = (int[]) r9     // Catch: java.lang.Exception -> L48 java.lang.reflect.InvocationTargetException -> L4d java.lang.IllegalAccessException -> L52 java.lang.NoSuchMethodException -> L57
            return r9
        L48:
            r9 = move-exception
            r9.printStackTrace()
            goto L5b
        L4d:
            r9 = move-exception
            r9.printStackTrace()
            goto L5b
        L52:
            r9 = move-exception
            r9.printStackTrace()
            goto L5b
        L57:
            r9 = move-exception
            r9.printStackTrace()
        L5b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imageutils.HeifFormatUtil.parseSimpleMeta(byte[], int):int[]");
    }

    public static int[] parseSimpleMetaByNativePtr(long r100, int r110) {
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
            java.lang.Class r0 = getHeifClass()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            java.lang.reflect.Method r2 = com.facebook.imageutils.HeifFormatUtil.sParseMetaMethodByNativePtr     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 != 0) goto L21
            java.lang.String r2 = "parseSimpleMetaByNativePtr"
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            java.lang.Class r7 = java.lang.Long.TYPE     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            r6[r3] = r7     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            r6[r5] = r7     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r2, r6)     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            com.facebook.imageutils.HeifFormatUtil.sParseMetaMethodByNativePtr = r0     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
        L21:
            java.lang.reflect.Method r0 = com.facebook.imageutils.HeifFormatUtil.sParseMetaMethodByNativePtr     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            if (r0 == 0) goto L52
            r0.setAccessible(r5)     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            java.lang.reflect.Method r0 = com.facebook.imageutils.HeifFormatUtil.sParseMetaMethodByNativePtr     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            r2[r3] = r8     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            r2[r5] = r8     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            java.lang.Object r8 = r0.invoke(r1, r2)     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            int[] r8 = (int[]) r8     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            return r8
        L3f:
            r8 = move-exception
            r8.printStackTrace()
            goto L52
        L44:
            r8 = move-exception
            r8.printStackTrace()
            goto L52
        L49:
            r8 = move-exception
            r8.printStackTrace()
            goto L52
        L4e:
            r8 = move-exception
            r8.printStackTrace()
        L52:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imageutils.HeifFormatUtil.parseSimpleMetaByNativePtr(long, int):int[]");
    }

    public static int[] parseThumbMeta(byte[] r100, int r101) {
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
            java.lang.Class r0 = getHeifClass()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            java.lang.reflect.Method r2 = com.facebook.imageutils.HeifFormatUtil.sParseThumbMetaMethod     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 != 0) goto L21
            java.lang.String r2 = "parseThumbMeta"
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            java.lang.Class<byte[]> r7 = byte[].class
            r6[r3] = r7     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            r6[r5] = r7     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r2, r6)     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            com.facebook.imageutils.HeifFormatUtil.sParseThumbMetaMethod = r0     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
        L21:
            java.lang.reflect.Method r0 = com.facebook.imageutils.HeifFormatUtil.sParseThumbMetaMethod     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            if (r0 == 0) goto L4e
            r0.setAccessible(r5)     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            java.lang.reflect.Method r0 = com.facebook.imageutils.HeifFormatUtil.sParseThumbMetaMethod     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            r2[r3] = r8     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            java.lang.Integer r8 = java.lang.Integer.valueOf(r9)     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            r2[r5] = r8     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            java.lang.Object r8 = r0.invoke(r1, r2)     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            int[] r8 = (int[]) r8     // Catch: java.lang.Exception -> L3b java.lang.reflect.InvocationTargetException -> L40 java.lang.IllegalAccessException -> L45 java.lang.NoSuchMethodException -> L4a
            return r8
        L3b:
            r8 = move-exception
            r8.printStackTrace()
            goto L4e
        L40:
            r8 = move-exception
            r8.printStackTrace()
            goto L4e
        L45:
            r8 = move-exception
            r8.printStackTrace()
            goto L4e
        L4a:
            r8 = move-exception
            r8.printStackTrace()
        L4e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imageutils.HeifFormatUtil.parseThumbMeta(byte[], int):int[]");
    }

    public static int[] parseThumbMetaByNativePtr(long r100, int r110) {
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
            java.lang.Class r0 = getHeifClass()
            r1 = 0
            if (r0 != 0) goto L8
            return r1
        L8:
            java.lang.reflect.Method r2 = com.facebook.imageutils.HeifFormatUtil.sParseThumbMetaMethodByNativePtr     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            r3 = 0
            r4 = 2
            r5 = 1
            if (r2 != 0) goto L21
            java.lang.String r2 = "parseThumbMetaByNativePtr"
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            java.lang.Class r7 = java.lang.Long.TYPE     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            r6[r3] = r7     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            java.lang.Class r7 = java.lang.Integer.TYPE     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            r6[r5] = r7     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r2, r6)     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            com.facebook.imageutils.HeifFormatUtil.sParseThumbMetaMethodByNativePtr = r0     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
        L21:
            java.lang.reflect.Method r0 = com.facebook.imageutils.HeifFormatUtil.sParseThumbMetaMethodByNativePtr     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            if (r0 == 0) goto L52
            r0.setAccessible(r5)     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            java.lang.reflect.Method r0 = com.facebook.imageutils.HeifFormatUtil.sParseThumbMetaMethodByNativePtr     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            java.lang.Object[] r2 = new java.lang.Object[r4]     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            r2[r3] = r8     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            java.lang.Integer r8 = java.lang.Integer.valueOf(r10)     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            r2[r5] = r8     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            java.lang.Object r8 = r0.invoke(r1, r2)     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            int[] r8 = (int[]) r8     // Catch: java.lang.Exception -> L3f java.lang.reflect.InvocationTargetException -> L44 java.lang.IllegalAccessException -> L49 java.lang.NoSuchMethodException -> L4e
            return r8
        L3f:
            r8 = move-exception
            r8.printStackTrace()
            goto L52
        L44:
            r8 = move-exception
            r8.printStackTrace()
            goto L52
        L49:
            r8 = move-exception
            r8.printStackTrace()
            goto L52
        L4e:
            r8 = move-exception
            r8.printStackTrace()
        L52:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.imageutils.HeifFormatUtil.parseThumbMetaByNativePtr(long, int):int[]");
    }

    public static int[] readHeifFormatImageSizeForSimple(long r100, int r101) {
        int[] r102 = parseSimpleMetaByNativePtr(r100, r101);
        if (r102 != null) goto L5;
    L5:
        return r102;
    }

    public static int[] readHeifThumbData(long r100, int r101) {
        return parseThumbMetaByNativePtr(r100, r101);
    }
}
