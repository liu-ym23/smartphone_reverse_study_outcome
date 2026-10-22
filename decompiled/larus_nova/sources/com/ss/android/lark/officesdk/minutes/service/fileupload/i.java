package com.ss.android.lark.officesdk.minutes.service.fileupload;

import com.ss.android.lark.officesdk.minutes.api.fileupload.MmMinutesFileUploadErrorCode;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingSource;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f433765a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f433766b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final MmMinutesFileUploadErrorCode f433767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f433768b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f433767a == r101.f433767a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f433768b, r101.f433768b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f433767a.hashCode() * 31) + this.f433768b.hashCode();
        }

        public final String toString() {
            return "PreCheckResult(code=" + this.f433767a + ", message=" + this.f433768b + ')';
        }

        public final MmMinutesFileUploadErrorCode a() {
            return this.f433767a;
        }

        public final String b() {
            return this.f433768b;
        }

        public a(MmMinutesFileUploadErrorCode r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "code");
            Intrinsics.checkNotNullParameter(r101, "message");
            this.f433767a = r100;
            this.f433768b = r101;
        }
    }

    public i() {
    }

    static {
        f433765a = new i();
        f433766b = SetsKt.setOf(new String[]{"wav", TTVideoEngineInterface.FORMAT_TYPE_MP3, "m4a", "aac", "ogg", "og9", "wma", "avi", "wmv", "mov", "mp4", "m4v", "mpeg", "flv"});
    }

    public static a a(eub.f r110, boolean r111) {
        Intrinsics.checkNotNullParameter(r110, "param");
        MmRecordingSource r100 = r110.f474154b;
        if (r100 != MmRecordingSource.FEISHU_HARDWARE_RECORDER) goto L5;
    L10:
        boolean r101 = true;
    L12:
        if (r110.f474155c.isEmpty() == true) goto L14;
        if (r101 == false) goto L17;
    L20:
        Iterator<T> r102 = r110.f474155c.iterator();
        long r103 = 0;
        long r104 = 0;
        long r112 = 0;
    L22:
        if (r102.hasNext() == false) goto L66;
        eub.d r113 = (eub.d) r102.next();
        f433765a.getClass();
        if (r113.f474142a.length() != 0) goto L26;
        boolean r105 = true;
    L27:
        if (r105 == false) goto L85;
        boolean r106 = false;
    L37:
        if (r106 == true) goto L48;
        MmMinutesFileUploadErrorCode r114 = MmMinutesFileUploadErrorCode.PRE_FILE_NOT_EXIST;
        StringBuilder r115 = new StringBuilder("file not exist, fileName=");
        r115.append(r113.f474144c);
        r115.append(", localPathEmpty=");
        if (r113.f474142a.length() != 0) goto L41;
        boolean r107 = true;
    L42:
        r115.append(r107);
        r115.append(", uriEmpty=");
        if (r113.f474143b.length() != 0) goto L45;
        boolean r108 = true;
    L46:
        r115.append(r108);
        a r109 = new a(r114, r115.toString());
    L63:
        if (r109 != null) goto L64;
        r104 = r104 + r113.f474145d;
        r112 = r112 + r113.f474146e;
        r103 = 0;
        goto L22
    L64:
        return r109;
    L45:
        r108 = false;
        goto L46
    L41:
        r107 = false;
        goto L42
    L48:
        if (r113.f474144c.length() != 0) goto L50;
        boolean r116 = true;
    L51:
        if (r116 == false) goto L53;
        r109 = new a(MmMinutesFileUploadErrorCode.FILE_READ_FAIL, "file name empty");
        goto L63
    L53:
        String r117 = StringsKt.substringAfterLast(r113.f474144c, '.', "").toLowerCase(Locale.ROOT);
        if (f433766b.contains(r117) == true) goto L56;
        r109 = new a(MmMinutesFileUploadErrorCode.FILE_TYPE_ERROR, "file type invalid, fileName=" + r113.f474144c + ", extension=" + r117);
        goto L63
    L56:
        if (r101 == true) goto L58;
    L62:
        r109 = null;
        goto L63
    L58:
        if (r113.f474145d > r103) goto L60;
    L61:
        r109 = new a(MmMinutesFileUploadErrorCode.FILE_READ_FAIL, "hardware file size or duration invalid, fileName=" + r113.f474144c + ", fileSize=" + r113.f474145d + ", fileDuration=" + r113.f474146e);
        goto L63
    L60:
        if (r113.f474146e > r103) goto L62;
    L50:
        r116 = false;
        goto L51
    L85:
        Result.Companion r118 = Result.Companion;     // Catch: Throwable -> L31
        com.ss.android.lark.vfs.h r119 = com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.f434038a;     // Catch: Throwable -> L31
        Object r120 = Result.m9449constructorimpl(Boolean.valueOf(com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file.a.c(r113.f474142a).exists()));     // Catch: Throwable -> L31
    L33:
        Boolean r121 = Boolean.FALSE;
        if (Result.m9455isFailureimpl(r120) == false) goto L36;
        r120 = r121;
    L36:
        r106 = ((Boolean) r120).booleanValue();
    L31:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L33
    L26:
        r105 = false;
        goto L27
    L66:
        if (r101 == true) goto L77;
        if (r111 == true) goto L77;
        if (r104 < 6442450944L) goto L73;
        return new a(MmMinutesFileUploadErrorCode.FILE_SIZE_ERROR, "file size exceeded, totalFileSize=" + r104);
    L73:
        if (r112 < 21600000) goto L77;
        return new a(MmMinutesFileUploadErrorCode.MEDIA_DURATION_ERROR, "file duration exceeded, totalFileDuration=" + r112);
    L77:
        if (r104 <= 0) goto L84;
        if (r112 <= 0) goto L84;
        lvb.a.e("MmMinutesFileUploadPreCheckHelper", "preCheck success: taskId=" + r110.f474153a + ", isHardware=" + r101 + ", fileCount=" + r110.f474155c.size() + ", totalFileSize=" + r104 + ", totalFileDuration=" + r112 + ", skipSizeDurationCheck=" + r111);
        return new a(MmMinutesFileUploadErrorCode.SUCCESS, "");
    L84:
        return new a(MmMinutesFileUploadErrorCode.FILE_READ_FAIL, "file size or duration invalid, totalFileSize=" + r104 + ", totalFileDuration=" + r112);
    L17:
        if (r110.f474155c.size() <= 9) goto L20;
        return new a(MmMinutesFileUploadErrorCode.PRE_FILE_COUNT_EXCEEDED, "file count exceeded, count=" + r110.f474155c.size());
    L14:
        return new a(MmMinutesFileUploadErrorCode.PRE_FILE_COUNT_EMPTY, "files empty");
    L5:
        if (r100 == MmRecordingSource.FEISHU_HARDWARE_D1204) goto L10;
        if (r100 == MmRecordingSource.FEISHU_HARDWARE_D1204_CASE) goto L10;
        r101 = false;
        goto L12
    }
}
