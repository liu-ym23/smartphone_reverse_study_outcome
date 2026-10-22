package com.larus.avlink.gallery.executor;

import android.media.ExifInterface;
import android.os.Build;
import androidx.camera.video.AudioStats;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.avlink.gallery.business.MediaLifecycleStateManager;
import com.larus.avlink.gallery.database.AlbumDataBaseHelper;
import com.larus.avlink.gallery.model.MediaMetadata;
import com.larus.platform.model.GeoLocationInfo;
import com.larus.utils.logger.FLogger;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import org.slf4j.Marker;

/* JADX INFO: loaded from: classes25.dex */
public final class MediaProcessingExecutor {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f292540k = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f292541a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MediaLifecycleStateManager f292542b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Channel<b> f292543c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Channel<b> f292544d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f292545e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Set<String> f292546f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final AtomicBoolean f292547g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final AtomicInteger f292548h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Job f292549i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Job f292550j;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f292551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f292552b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f292551a, r101.f292551a) == true) goto L12;
            return false;
        L12:
            if (this.f292552b == r101.f292552b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f292551a.hashCode() * 31;
            if (this.f292552b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "ProcessingTask(uniqId=" + this.f292551a + ", isRecovery=" + this.f292552b + ')';
        }

        public final String a() {
            return this.f292551a;
        }

        public final boolean b() {
            return this.f292552b;
        }

        public b(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "uniqId");
            this.f292551a = r100;
            this.f292552b = r101;
        }
    }

    static {
    }

    public final void g() {
        if (this.f292547g.compareAndSet(false, true) == true) goto L6;
        FLogger.f375446a.w("MediaProcessingExecutor", "Processing queue already running, skipping start");
        return;
    L6:
        FLogger r100 = FLogger.f375446a;
        r100.i("MediaProcessingExecutor", "Starting processing queue");
        if (this.f292543c != null) goto L10;
        this.f292543c = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    L10:
        if (this.f292544d != null) goto L12;
        this.f292544d = ChannelKt.Channel$default(Integer.MAX_VALUE, null, null, 6, null);
    L12:
        Job r101 = this.f292549i;
        if (r101 == null) goto L15;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);
    L15:
        this.f292549i = BuildersKt.launch$default(this.f292541a, null, null, new MediaProcessingExecutor$startImageProcessingWorker$1(this, null), 3, null);
        Job r102 = this.f292550j;
        if (r102 == null) goto L18;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L18:
        this.f292550j = BuildersKt.launch$default(this.f292541a, null, null, new MediaProcessingExecutor$startVideoProcessingWorker$1(this, null), 3, null);
        r100.i("MediaProcessingExecutor", "Processing queue started");
    }

    public MediaProcessingExecutor(CoroutineScope r100) {
        Intrinsics.checkNotNullParameter(r100, "scope");
        this.f292541a = r100;
        this.f292542b = MediaLifecycleStateManager.f292361b.a();
        this.f292545e = new LinkedHashSet();
        this.f292546f = new LinkedHashSet();
        this.f292547g = new AtomicBoolean(false);
        this.f292548h = new AtomicInteger(0);
        g();
    }

    public static String c(long r100) {
        int r101 = TimeZone.getDefault().getOffset(r100) / 60000;
        if (r101 < 0) goto L5;
        String r102 = Marker.ANY_NON_NULL_MARKER;
    L6:
        if (r101 >= 0) goto L9;
        r101 = -r101;
    L9:
        StringCompanionObject r103 = StringCompanionObject.INSTANCE;
        return String.format(Locale.US, "%s%02d:%02d", Arrays.copyOf(new Object[]{r102, Integer.valueOf(r101 / 60), Integer.valueOf(r101 % 60)}, 3));
    L5:
        r102 = "-";
        goto L6
    }

    public static boolean d(PolarisFileWrapper r110, PolarisFileWrapper r111) {
        if (r110.exists() == true) goto L6;
        FLogger.f375446a.e("MediaProcessingExecutor", "Processed source file does not exist: " + r110.getAbsolutePath());
        return false;
    L6:
        File r100 = r111.getParentFile();
        if (r100 == null) goto L10;
        r100.mkdirs();
    L10:
        if (r111.exists() == false) goto L16;
        if (r111.delete() == true) goto L16;
        FLogger.f375446a.e("MediaProcessingExecutor", "Failed to delete existing processed target: " + r111.getAbsolutePath());
        return false;
    L16:
        if (r110.renameTo(r111) == false) goto L26;
        return true;
    L26:
        FilesKt.copyTo$default(r110, r111, true, 0, 4, null);     // Catch: Exception -> L23
        if (r110.delete() == true) goto L22;
        FLogger.f375446a.w("MediaProcessingExecutor", "Failed to delete source file after copy: " + r110.getAbsolutePath());     // Catch: Exception -> L23
    L22:
        return true;
    L23:
        e = move-exception;
        FLogger.f375446a.e("MediaProcessingExecutor", "Failed to move processed file from " + r110.getAbsolutePath() + " to " + r111.getAbsolutePath() + ": " + e.getMessage(), e);
        return false;
    }

    public final void a(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "uniqId");
        BuildersKt.launch$default(this.f292541a, null, null, new MediaProcessingExecutor$enqueueTask$1(r100, this, r101, null), 3, null);
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached with updateSeq = 32021. Try increasing type updates limit count.
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:79)
        */
    public final java.lang.Object b(com.larus.avlink.gallery.executor.MediaProcessingExecutor.b r52, kotlin.coroutines.Continuation<? super kotlin.Unit> r53) {
        /*  JADX ERROR: Simple mode code generation failed
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0004: CONST_STR (r3v0 ?? I:java.lang.String) = "[" A[DECLARE_VAR] (LINE:33554436) in method: com.larus.avlink.gallery.executor.MediaProcessingExecutor.b(com.larus.avlink.gallery.executor.MediaProcessingExecutor$b, kotlin.coroutines.Continuation<? super kotlin.Unit>):java.lang.Object, file: classes25.dex
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:348)
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
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.ArgType.getPrimitiveType()" because "type" is null
            	at jadx.core.codegen.ClassGen.useType(ClassGen.java:564)
            	at jadx.core.codegen.InsnGen.useType(InsnGen.java:269)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:166)
            	at jadx.core.codegen.InsnGen.declareVar(InsnGen.java:159)
            	at jadx.core.codegen.InsnGen.assignVar(InsnGen.java:152)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:299)
            	... 31 more
            */
        /*
            Method dump skipped, instruction units count: 3202
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.larus.avlink.gallery.executor.MediaProcessingExecutor.b(com.larus.avlink.gallery.executor.MediaProcessingExecutor$b, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object h(String r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof MediaProcessingExecutor$triggerMediaSync$1) == false) goto L7;
        MediaProcessingExecutor$triggerMediaSync$1 r100 = (MediaProcessingExecutor$triggerMediaSync$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L20;
        if (r103 == 1) goto L17;
        if (r103 != 2) goto L16;
        r110 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L32
    L29:
        FLogger.f375446a.i("MediaProcessingExecutor", "Sync completed for media: " + r110);     // Catch: Exception -> L32
    L35:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r110 = (String) r100.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Exception -> L32
    L24:
        MediaMetadata r113 = (MediaMetadata) r112;     // Catch: Exception -> L32
        if (r113 == null) goto L30;
        FLogger.f375446a.i("MediaProcessingExecutor", "Auto-syncing media to system album: " + r110);     // Catch: Exception -> L32
        MediaSyncExecutor r104 = MediaSyncExecutor.f292553a;     // Catch: Exception -> L32
        r100.L$0 = r110;     // Catch: Exception -> L32
        r100.label = 2;     // Catch: Exception -> L32
        if (r104.f(r113, r100) != r102) goto L29;
        return r102;
    L30:
        FLogger.f375446a.w("MediaProcessingExecutor", "Skip sync due to updatedMetadata is null: " + r110);     // Catch: Exception -> L32
        goto L35
    L20:
        ResultKt.throwOnFailure(r112);
        AlbumDataBaseHelper r114 = AlbumDataBaseHelper.f292393a;     // Catch: Exception -> L32
        r100.L$0 = r110;     // Catch: Exception -> L32
        r100.label = 1;     // Catch: Exception -> L32
        r112 = r114.o(r110, r100);     // Catch: Exception -> L32
        if (r112 != r102) goto L24;
        return r102;
    L32:
        e = move-exception;
        FLogger.f375446a.e("MediaProcessingExecutor", "Error auto-syncing media " + r110 + ": " + e.getMessage(), e);
    L7:
        r100 = new MediaProcessingExecutor$triggerMediaSync$1(this, r111);
        goto L8
    }

    public static String e(MediaMetadata r110, String r111, String r112) {
        String r100 = r110.getDownloadFilePath();
        File r101 = null;
        if (r100 == null) goto L5;
        PolarisFileWrapper r102 = new PolarisFileWrapper(r100);
    L7:
        if (r102 != null) goto L9;
    L25:
        File r103 = new PolarisFileWrapper(r110.getFilePath()).getParentFile();
        if (r103 == null) goto L40;
        File[] r104 = r103.listFiles();
        if (r104 == null) goto L40;
        int r105 = r104.length;
        int r106 = 0;
    L30:
        if (r106 >= r105) goto L40;
        File r107 = r104[r106];
        if (StringsKt.contains$default(r107.getName(), "_" + r112 + '_', false, 2, null) == true) goto L34;
    L36:
        boolean r108 = false;
    L37:
        if (r108 == true) goto L38;
        r106 = r106 + 1;
        goto L30
    L38:
        r101 = r107;
        goto L40
    L34:
        if (StringsKt.endsWith(r107.getName(), ".pack", true) == false) goto L36;
        r108 = true;
    L40:
        if (r101 != null) goto L42;
    L45:
        FLogger.f375446a.w("MediaProcessingExecutor", "[" + r111 + "] Pack file not found, using metadata.filePath");
        return r110.getFilePath();
    L42:
        if (r101.exists() == false) goto L45;
        FLogger.f375446a.d("MediaProcessingExecutor", "[" + r111 + "] Found fallback pack file: " + r101.getAbsolutePath());
        return r101.getAbsolutePath();
    L9:
        if (r102.exists() == false) goto L25;
        if (StringsKt.endsWith(r102.getName(), ".zip", true) == false) goto L23;
        String r113 = r110.getUnpackDirPath();
        if (r113 == null) goto L18;
        PolarisFileWrapper r109 = new PolarisFileWrapper(r113);
        if (r109.exists() == false) goto L18;
        int r114 = com.larus.avlink.gallery.processor.e.f292674a;
        r101 = com.larus.avlink.gallery.processor.e.a.b(r109);
    L18:
        if (r101 == null) goto L21;
        FLogger.f375446a.d("MediaProcessingExecutor", "[" + r111 + "] Found live photo inner pack file: " + r101.getAbsolutePath());
        return r101.getAbsolutePath();
    L21:
        FLogger.f375446a.w("MediaProcessingExecutor", "[" + r111 + "] Live photo inner pack file not found, using metadata.filePath");
        return r110.getFilePath();
    L23:
        FLogger.f375446a.d("MediaProcessingExecutor", "[" + r111 + "] Found pack file: " + r100);
        return r100;
    L5:
        r102 = null;
        goto L7
    }

    public static void f(File r100, long r110, MediaMetadata r111) {
        int r101 = Build.VERSION.SDK_INT;     // Catch: Exception -> L25
        if (r101 >= 24) goto L6;
        return;
    L6:
        ExifInterface r102 = new ExifInterface(r100.getAbsolutePath());     // Catch: Exception -> L25
        long r112 = r110 * ((long) 1000);     // Catch: Exception -> L25
        String r103 = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.ROOT).format(new Date(r112));     // Catch: Exception -> L25
        r102.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_DATETIME, r103);     // Catch: Exception -> L25
        if (r101 < 24) goto L10;
        r102.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_DATETIME_ORIGINAL, r103);     // Catch: Exception -> L25
        r102.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_DATETIME_DIGITIZED, r103);     // Catch: Exception -> L25
    L10:
        if (r101 < 30) goto L12;
        String r113 = c(r112);     // Catch: Exception -> L25
        r102.setAttribute("OffsetTime", r113);     // Catch: Exception -> L25
        r102.setAttribute("OffsetTimeOriginal", r113);     // Catch: Exception -> L25
        r102.setAttribute("OffsetTimeDigitized", r113);     // Catch: Exception -> L25
    L12:
        GeoLocationInfo r114 = r111.getGeoLocationInfo();     // Catch: Exception -> L25
        if (r114 == null) goto L23;
        double r115 = r114.getLatitude();     // Catch: Exception -> L25
        double r104 = r114.getLongitude();     // Catch: Exception -> L25
        if (r115 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L17;
        String r105 = "N";
    L18:
        r102.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE_REF, r105);     // Catch: Exception -> L25
        if (r104 < AudioStats.AUDIO_AMPLITUDE_NONE) goto L21;
        String r106 = androidx.exifinterface.media.ExifInterface.LONGITUDE_EAST;
    L22:
        r102.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE_REF, r106);     // Catch: Exception -> L25
        r102.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LATITUDE, com.larus.avlink.gallery.c.c(r115));     // Catch: Exception -> L25
        r102.setAttribute(androidx.exifinterface.media.ExifInterface.TAG_GPS_LONGITUDE, com.larus.avlink.gallery.c.c(r104));     // Catch: Exception -> L25
        goto L23
    L21:
        r106 = androidx.exifinterface.media.ExifInterface.LONGITUDE_WEST;
        goto L22
    L17:
        r105 = androidx.exifinterface.media.ExifInterface.LATITUDE_SOUTH;
    L23:
        r102.saveAttributes();     // Catch: Exception -> L25
        FLogger.f375446a.d("MediaProcessingExecutor", "Successfully set EXIF date for " + r100.getName() + " to: " + r103);     // Catch: Exception -> L25
        return;
    L25:
        e = move-exception;
        FLogger.f375446a.e("MediaProcessingExecutor", "Failed to set EXIF date for " + r100.getName() + ": " + e.getMessage(), e);
    }
}
