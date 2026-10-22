package com.obric.assistant.performance;

import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.security.android.aopcheck.PolarisFileInputStreamWrapper;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.ObricThresholdItemConfig;
import com.ss.android.agilelogger.ALog;
import com.ss.android.lark.widget.codeblock.entity.LineContent;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: classes33.dex */
public final class ObricMemoryUploadFileHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricMemoryUploadFileHelper f390998a = null;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(((File) r100).getName(), ((File) r101).getName());
        }
    }

    static {
        f390998a = new ObricMemoryUploadFileHelper();
    }

    public ObricMemoryUploadFileHelper() {
    }

    public static String b(long r100) {
        Debug.MemoryInfo r101 = new Debug.MemoryInfo();
        Debug.getMemoryInfo(r101);
        if (Build.VERSION.SDK_INT < 23) goto L5;
        Map r102 = MapsKt.toSortedMap(r101.getMemoryStats());
    L6:
        Runtime r103 = Runtime.getRuntime();
        StringBuilder r104 = new StringBuilder();
        StringBuilder r105 = new StringBuilder("Uptime=");
        f390998a.getClass();
        r105.append(d(r100));
        r105.append('}');
        r104.append(r105.toString());
        r104.append('\n');
        r104.append("** MEMINFO in pid " + Process.myPid() + " [" + AppHost.f326268a.getApplication().getPackageName() + "] **");
        r104.append('\n');
        StringBuilder r106 = new StringBuilder("total_pss=");
        r106.append(r101.getTotalPss());
        r104.append(r106.toString());
        r104.append('\n');
        r104.append("dalvik_pss=" + r101.dalvikPss);
        r104.append('\n');
        r104.append("native_pss=" + r101.nativePss);
        r104.append('\n');
        r104.append("other_pss=" + r101.otherPss);
        r104.append('\n');
        r104.append("total_private_dirty=" + r101.getTotalPrivateDirty());
        r104.append('\n');
        r104.append("total_shared_dirty=" + r101.getTotalSharedDirty());
        r104.append('\n');
        r104.append("total_swappable_pss=" + r101.getTotalSwappablePss());
        r104.append('\n');
        r104.append("native_heap_allocated=" + Debug.getNativeHeapAllocatedSize());
        r104.append('\n');
        r104.append("java_heap_used=" + (r103.totalMemory() - r103.freeMemory()));
        r104.append('\n');
        r104.append("java_heap_total=" + r103.totalMemory());
        r104.append('\n');
        r104.append("java_heap_max=" + r103.maxMemory());
        r104.append('\n');
        if ((!r102.isEmpty()) == false) goto L13;
        r104.append("memory_stats=\n");
        Iterator r107 = r102.entrySet().iterator();
    L10:
        if (r107.hasNext() == false) goto L13;
        Map.Entry r108 = (Map.Entry) r107.next();
        r104.append(LineContent.FOUR_SPACE + ((String) r108.getKey()) + com.alipay.sdk.m.n.a.f25612h + ((String) r108.getValue()));
        r104.append('\n');
    L13:
        return r104.toString();
    L5:
        r102 = MapsKt.emptyMap();
        goto L6
    }

    public static String d(long r100) {
        String r101 = new SimpleDateFormat("yyyyMMdd.HHmmss", Locale.getDefault()).format(new Date(r100));     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L4
        return r101;
    L4:
        th = move-exception;
        FLogger.f375446a.e("ObricMemoryUploadFileHelper", "formatFileTime error, timestamp=" + r100, th);
        return String.valueOf(r100);
    }

    public static int a(ZipOutputStream r100, List r110, ObricThresholdItemConfig r111) {
        Intrinsics.checkNotNullParameter(r100, BdpAppEventConstant.PARAMS_OUTPUT);
        Intrinsics.checkNotNullParameter(r110, "alogFiles");
        Intrinsics.checkNotNullParameter(r111, "config");
        if (r111.getEnableAlog() == true) goto L6;
        return 0;
    L6:
        if (r110.isEmpty() == false) goto L9;
        FLogger.f375446a.i("ObricMemoryUploadFileHelper", "appendAlog skipped, no recent alog files");
        return 0;
    L9:
        Iterator r112 = r110.iterator();
        int r101 = 0;
    L11:
        if (r112.hasNext() == false) goto L42;
        File r102 = (File) r112.next();
        String r103 = "alog/" + r102.getName();
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L31
        r100.putNextEntry(new ZipEntry(r103));     // Catch: Throwable -> L31
        InputStream r105 = new PolarisFileInputStreamWrapper(r102);     // Catch: Throwable -> L31
        if ((r105 instanceof BufferedInputStream) == false) goto L17;
        BufferedInputStream r106 = (BufferedInputStream) r105;     // Catch: Throwable -> L31
    L46:
        ByteStreamsKt.copyTo$default(r106, r100, 0, 2, null);     // Catch: Throwable -> L26
        CloseableKt.closeFinally(r106, null);     // Catch: Throwable -> L31
        r100.closeEntry();     // Catch: Throwable -> L31
        int r107 = r101 + 1;
        Object r108 = Result.m9449constructorimpl(Integer.valueOf(r101));     // Catch: Throwable -> L24
    L34:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L41;
        r100.closeEntry();     // Catch: Throwable -> L38
        Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L38
    L40:
        FLogger.f375446a.e("ObricMemoryUploadFileHelper", "appendAlog failed, path=" + r102.getAbsolutePath(), r109);
    L38:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    L41:
        r101 = r107;
    L24:
        Throwable th10 = th;
    L33:
        Result.Companion r114 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
        goto L34
    L26:
        th = move-exception;
        throw th;     // Catch: Throwable -> L28
    L28:
        th = move-exception;
        CloseableKt.closeFinally(r106, th);     // Catch: Throwable -> L31
        throw th;     // Catch: Throwable -> L31
    L17:
        r106 = new BufferedInputStream(r105, 8192);     // Catch: Throwable -> L31
    L31:
        th = move-exception;
        r107 = r101;
        th10 = th;
        goto L33
    L42:
        FLogger.f375446a.i("ObricMemoryUploadFileHelper", "appendAlog finished, count=" + r101 + ", total=" + r110.size());
        return r101;
    }

    public final Object c(long r100, ObricThresholdItemConfig r101, Continuation<? super List<? extends File>> r110) {
        if ((r110 instanceof ObricMemoryUploadFileHelper$collectRecentAlogFiles$1) == false) goto L7;
        ObricMemoryUploadFileHelper$collectRecentAlogFiles$1 r102 = (ObricMemoryUploadFileHelper$collectRecentAlogFiles$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        long r106 = r102.J$1;
        long r107 = r102.J$0;
        ResultKt.throwOnFailure(r111);     // Catch: Throwable -> L14
    L27:
        long r108 = 1000;
        List<String> r109 = ALog.getALogFiles(r106 / r108, r107 / r108);     // Catch: Throwable -> L14
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r109, 10));     // Catch: Throwable -> L14
        Iterator<T> r113 = r109.iterator();     // Catch: Throwable -> L14
    L30:
        if (r113.hasNext() == false) goto L32;
        r112.add(new PolarisFileWrapper((String) r113.next()));     // Catch: Throwable -> L14
        goto L30
    L32:
        HashSet r114 = new HashSet();     // Catch: Throwable -> L14
        ArrayList r115 = new ArrayList();     // Catch: Throwable -> L14
        Iterator r116 = r112.iterator();     // Catch: Throwable -> L14
    L34:
        if (r116.hasNext() == false) goto L38;
        Object r117 = r116.next();     // Catch: Throwable -> L14
        if (r114.add(((File) r117).getAbsolutePath()) == false) goto L34;
        r115.add(r117);     // Catch: Throwable -> L14
        goto L34
    L38:
        ArrayList r118 = new ArrayList();     // Catch: Throwable -> L14
        Iterator r119 = r115.iterator();     // Catch: Throwable -> L14
    L40:
        if (r119.hasNext() == false) goto L49;
        Object r120 = r119.next();     // Catch: Throwable -> L14
        File r121 = (File) r120;     // Catch: Throwable -> L14
        if (r121.exists() == true) goto L44;
    L46:
        boolean r122 = false;
    L47:
        if (r122 == false) goto L40;
        r118.add(r120);     // Catch: Throwable -> L14
        goto L40
    L44:
        if (r121.isFile() == false) goto L46;
        r122 = true;
        goto L47
    L49:
        Object r123 = Result.m9449constructorimpl(CollectionsKt.sortedWith(r118, new a()));     // Catch: Throwable -> L14
    L54:
        Throwable r124 = Result.m9452exceptionOrNullimpl(r123);
        if (r124 == null) goto L57;
        FLogger.f375446a.e("ObricMemoryUploadFileHelper", "collectRecentAlogFiles failed, endTimeMs=" + r107, r124);
    L57:
        List r125 = CollectionsKt.emptyList();
        if (Result.m9455isFailureimpl(r123) == true) goto L60;
        return r123;
    L60:
        return r125;
    L14:
        Throwable th10 = th;
    L53:
        Result.Companion r126 = Result.Companion;
        r123 = Result.m9449constructorimpl(ResultKt.createFailure(th10));
        goto L54
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r111);
        if (r101.getEnableAlog() == false) goto L21;
        long r127 = RangesKt.coerceAtLeast(r100 - RangesKt.coerceAtLeast(r101.getRecentAlogMs(), 0), 0);
        Result.Companion r128 = Result.Companion;     // Catch: Throwable -> L51
        ALog.asyncFlush();     // Catch: Throwable -> L51
        r102.J$0 = r100;     // Catch: Throwable -> L51
        r102.J$1 = r127;     // Catch: Throwable -> L51
        r102.label = 1;     // Catch: Throwable -> L51
        if (DelayKt.delay(1000, r102) != r104) goto L26;
        return r104;
    L26:
        r107 = r100;
        r106 = r127;
    L51:
        th = move-exception;
        r107 = r100;
        th10 = th;
        goto L53
    L21:
        return CollectionsKt.emptyList();
    L7:
        r102 = new ObricMemoryUploadFileHelper$collectRecentAlogFiles$1(this, r110);
        goto L8
    }
}
