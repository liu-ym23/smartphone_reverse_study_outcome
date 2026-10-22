package com.ss.android.lark.officesdk.minutes.service.foundation.utils.cache.file;

import com.bytedance.ee.docsdk.impl.base.DocumentType;
import com.ss.android.lark.storage.d;
import com.ss.android.lark.storage.f;
import com.ss.android.lark.vfs.VFSFile;
import com.ss.android.lark.vfs.h;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordFileHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MmRecordFileHelper f434037a = null;

    static {
        f434037a = new MmRecordFileHelper();
    }

    public MmRecordFileHelper() {
    }

    public static VFSFile g(String r100) {
        h r101 = a.f434038a;
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter("MinutesRecordingParts", "directoryName");
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter("MinutesRecordingParts", "childPath");
        h r102 = a.f434038a;
        f r103 = f.f440957d;
        return r102.D(LarkFileStorage.f(r100).b(r103, new d(new String[]{DocumentType.MINUTES_NAME})).toFile(), "MinutesRecordingParts");
    }

    public static Object b(String r100, Continuation r101) {
        if (StringsKt.isBlank(r100) == true) goto L5;
        Object r102 = BuildersKt.withContext(Dispatchers.getIO(), new MmRecordFileHelper$deleteFile$2(r100, null), r101);
        if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r102;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public static Object d(String r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MmRecordFileHelper$findLocalMeetingIds$2(r100, null), r101);
    }

    public static Object e(String r100, Continuation r101) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MmRecordFileHelper$findNativeLocalSessionKeys$2(r100, null), r101);
    }

    public static VFSFile f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "userId");
        Intrinsics.checkNotNullParameter(r101, "meetingId");
        return a.b(g(r100), r101);
    }

    public static Object c(String r100, String r101, ContinuationImpl r102) {
        if (StringsKt.isBlank(r100) == false) goto L5;
    L9:
        lvb.a.b("MmRecordFileHelper", "[deleteRecordingPartDir] invalid params: userId=" + r100 + ", recordingId=" + r101);
        return Boxing.boxBoolean(false);
    L5:
        if (StringsKt.isBlank(r101) == true) goto L9;
        return BuildersKt.withContext(Dispatchers.getIO(), new MmRecordFileHelper$deleteRecordingPartDir$2(r100, r101, null), r102);
    }

    public static Object h(String r100, String r101, Continuation r102) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MmRecordFileHelper$listRecordingPartFileNames$2(r100, r101, null), r102);
    }

    public static Object a(String r100, String r101, String r102, Continuation r103) {
        if (StringsKt.isBlank(r101) == false) goto L5;
    L13:
        lvb.a.b("MmRecordFileHelper", "[copyRecordingDirToMeetingId] invalid params: fromSessionKey=" + r101 + ", toMeetingId=" + r102);
        return Boxing.boxBoolean(false);
    L5:
        if (StringsKt.isBlank(r102) == true) goto L13;
        if (Intrinsics.areEqual(r101, r102) == false) goto L12;
        lvb.a.e("MmRecordFileHelper", "[copyRecordingDirToMeetingId] skip same dir: " + r101);
        return Boxing.boxBoolean(true);
    L12:
        return BuildersKt.withContext(Dispatchers.getIO(), new MmRecordFileHelper$copyRecordingDirToMeetingId$2(r100, r101, r102, null), r103);
    }
}
