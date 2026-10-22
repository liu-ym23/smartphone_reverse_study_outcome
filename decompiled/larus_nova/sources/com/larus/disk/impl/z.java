package com.larus.disk.impl;

import com.bytedance.apm.agent.instrumentation.SQLiteInstrumentation;
import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.bytedance.ee.docsdk.impl.export.ExportFileExtension;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.image.entity.LoadParams;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes27.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f330830a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f330831b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Set<String> f330832c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<String> f330833d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Set<String> f330834e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Set<String> f330835f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Set<String> f330836g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Set<String> f330837h = null;

    static {
        f330830a = SetsKt.setOf(new String[]{"avif", "bmp", "gif", "heic", "heif", LoadParams.ImageFormat.JPEG, "jpg", LoadParams.ImageFormat.PNG, "webp"});
        f330831b = SetsKt.setOf(new String[]{"3gp", "avi", "flv", "m4v", "mkv", "mov", "mp4", "mpeg", "mpg", "webm"});
        f330832c = SetsKt.setOf(new String[]{"aac", "amr", "flac", "m4a", TTVideoEngineInterface.FORMAT_TYPE_MP3, "ogg", "opus", "pcm", "wav"});
        f330833d = SetsKt.setOf(new String[]{"csv", "doc", DocumentType.DOCX_NAME, "html", "md", ExportFileExtension.PDF, "ppt", ExportFileExtension.PPTX, "rtf", "txt", "xls", "xlsx"});
        f330834e = SetsKt.setOf(new String[]{"7z", "apk", "bz2", "gz", "rar", "tar", "tgz", "zip", "zst"});
        f330835f = SetsKt.setOf(new String[]{"db", "db-shm", "db-wal", SQLiteInstrumentation.SQLITE, "sqlite3"});
        f330836g = SetsKt.setOf(new String[]{CloudControlInf.ALOG, "log", "trace"});
        f330837h = SetsKt.setOf(new String[]{"external/files/update", "internal/files/plugins", "internal/files/update"});
    }

    public static boolean a(String r100, String... r101) {
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L11;
        if (b(r100, r101[r103]) == true) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return true;
    L11:
        return false;
    }

    public static boolean b(String r100, String r101) {
        List r102 = StringsKt.split$default(r100, new char[]{'/'}, false, 0, 6, null);
        if ((r102 instanceof Collection) == true) goto L5;
    L7:
        Iterator r103 = r102.iterator();
    L9:
        if (r103.hasNext() == false) goto L19;
        String r104 = (String) r103.next();
        if (Intrinsics.areEqual(r104, r101) == false) goto L13;
    L16:
        boolean r105 = true;
    L17:
        if (r105 == false) goto L9;
        return true;
    L13:
        if (StringsKt.startsWith$default(r104, r101 + '_', false, 2, null) == true) goto L16;
        r105 = false;
    L19:
        return false;
    L5:
        if (r102.isEmpty() == false) goto L7;
        goto L7
    }
}
