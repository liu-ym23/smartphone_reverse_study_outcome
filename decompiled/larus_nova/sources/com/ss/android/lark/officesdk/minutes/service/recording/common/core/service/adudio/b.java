package com.ss.android.lark.officesdk.minutes.service.recording.common.core.service.adudio;

import com.ss.android.lark.vfs.VFSFile;
import java.io.File;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f434360a;

    public static final class a {
    }

    static {
    }

    public b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "meetingId");
        this.f434360a = r100;
    }

    public static long c(File r100) {
        File[] r101 = r100.listFiles();
        long r102 = 0;
        if (r101 == null) goto L14;
        int r103 = r101.length;
        int r104 = 0;
    L5:
        if (r104 >= r103) goto L14;
        File r105 = r101[r104];
        if (r105.isFile() == false) goto L10;
        long r106 = r105.length();
    L12:
        r102 = r102 + r106;
    L13:
        r104 = r104 + 1;
        goto L5
    L10:
        if (r105.isDirectory() == false) goto L13;
        Intrinsics.checkNotNull(r105);
        r106 = c(r105);
    L14:
        return r102;
    }

    public static boolean d(File r100) {
        if (r100.isDirectory() == false) goto L12;
        File[] r101 = r100.listFiles();
        if (r101 == null) goto L12;
        Iterator r102 = ArrayIteratorKt.iterator(r101);
    L8:
        if (r102.hasNext() == false) goto L12;
        File r103 = (File) r102.next();
        Intrinsics.checkNotNull(r103);
        if (d(r103) == true) goto L8;
        lvb.a.e("MmAudioCacheCleanupUtil", "deleteRecursive: Failed to delete: " + r103.getAbsolutePath());
    L12:
        boolean r104 = r100.delete();
        if (r104 == true) goto L15;
        lvb.a.b("MmAudioCacheCleanupUtil", "deleteRecursive: Could not delete: " + r100.getAbsolutePath());
    L15:
        return r104;
    }

    public static final void a(b r110, VFSFile r111, long r112) {
        r110.getClass();
        lvb.a.e("MmAudioCacheCleanupUtil", "--- Cleaning by age (older than " + r112 + " days) ---");
        long r113 = TimeUnit.DAYS.toMillis(r112);
        long r100 = System.currentTimeMillis();
        File[] r114 = r111.listFiles();
        int r101 = 0;
        if (r114 == null) goto L16;
        int r102 = r114.length;
        int r103 = 0;
    L5:
        if (r101 >= r102) goto L15;
        File r104 = r114[r101];
        if ((r100 - r104.lastModified()) <= r113) goto L14;
        if (Intrinsics.areEqual(r110.f434360a, r104.getName()) == true) goto L14;
        lvb.a.e("MmAudioCacheCleanupUtil", "Deleting old file: " + r104.getAbsolutePath() + " (Last modified: " + new Date(r104.lastModified()) + ')');
        Intrinsics.checkNotNull(r104);
        if (d(r104) == false) goto L13;
        r103 = r103 + 1;
        goto L14
    L13:
        lvb.a.b("MmAudioCacheCleanupUtil", "Error: Failed to delete file: " + r104.getAbsolutePath());
    L14:
        r101 = r101 + 1;
        goto L5
    L15:
        r101 = r103;
    L16:
        lvb.a.e("MmAudioCacheCleanupUtil", "Clean by age finished: Deleted " + r101 + " files.");
    }

    public static final void b(b r110, VFSFile r111, long r112) {
        StringBuilder r100 = new StringBuilder("--- Cleaning by size (threshold: ");
        long r101 = 1048576;
        long r102 = r112 / 1048576;
        r100.append(r102);
        r100.append(" MB) ---");
        lvb.a.e("MmAudioCacheCleanupUtil", r100.toString());
        long r103 = c(r111);
        lvb.a.e("MmAudioCacheCleanupUtil", "Current directory size: " + (r103 / 1048576) + " MB (" + r103 + " bytes). Threshold: " + r102 + " MB.");
        if (r103 > r112) goto L5;
        lvb.a.e("MmAudioCacheCleanupUtil", "Directory size is within threshold, no cleanup by size needed.");
        return;
    L5:
        lvb.a.e("MmAudioCacheCleanupUtil", "Directory size exceeds threshold, attempting to delete oldest files...");
        File[] r104 = r111.listFiles();
        if (r104 == null) goto L31;
        List r105 = ArraysKt.sortedWith(r104, new c());
        if (r105 == null) goto L31;
        Iterator r106 = r105.iterator();
        int r107 = 0;
        long r108 = 0;
    L12:
        if (r106.hasNext() == false) goto L28;
        File r113 = (File) r106.next();
        lvb.a.e("MmAudioCacheCleanupUtil", "meetingId: " + r110.f434360a + ", fileToDelete.name:" + r113.getName());
        if (Intrinsics.areEqual(r110.f434360a, r113.getName()) == false) goto L17;
        Iterator r114 = r106;
    L27:
        r106 = r114;
        r101 = 1048576;
        goto L12
    L17:
        if (r103 <= r112) goto L28;
        if (r113.isFile() == false) goto L22;
        long r115 = r113.length();
    L23:
        StringBuilder r116 = new StringBuilder("Deleting file to reduce size: ");
        r116.append(r113.getAbsolutePath());
        r116.append(" (Size: ");
        r114 = r106;
        r116.append(r115 / r101);
        r116.append(" MB, Created: ");
        r116.append(new Date(r113.lastModified()));
        r116.append(')');
        lvb.a.e("MmAudioCacheCleanupUtil", r116.toString());
        Intrinsics.checkNotNull(r113);
        if (d(r113) == false) goto L26;
        r103 = r103 - r115;
        r108 = r108 + r115;
        r107 = r107 + 1;
        lvb.a.e("MmAudioCacheCleanupUtil", "Deleted. New directory size: " + (r103 / 1048576) + " MB.");
        goto L27
    L26:
        lvb.a.b("MmAudioCacheCleanupUtil", "Error: Failed to delete file: " + r113.getAbsolutePath());
        goto L27
    L22:
        Intrinsics.checkNotNull(r113);
        r115 = c(r113);
    L28:
        lvb.a.e("MmAudioCacheCleanupUtil", "Clean by size finished: Deleted " + r107 + " files. Total size reduced: " + (r108 / 1048576) + " MB.");
        if (r103 <= r112) goto L39;
        lvb.a.e("MmAudioCacheCleanupUtil", "Warning: Directory size (" + (r103 / 1048576) + " MB) still exceeds threshold after cleanup. Some files might be undeletable or too large.");
        return;
    L39:
        return;
    L31:
        lvb.a.b("MmAudioCacheCleanupUtil", "Error: Could not list files in directory for size cleanup: " + r111.getAbsolutePath());
    }
}
