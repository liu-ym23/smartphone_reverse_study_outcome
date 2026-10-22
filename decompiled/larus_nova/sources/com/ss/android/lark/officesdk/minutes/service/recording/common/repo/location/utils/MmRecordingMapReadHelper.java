package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.location.utils;

import android.graphics.Bitmap;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes37.dex */
public final class MmRecordingMapReadHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f435006a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JSONObject f435007b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public JSONObject f435008c;

    public MmRecordingMapReadHelper() {
        this.f435006a = "MmRecordingMapReadHelper";
    }

    public final Object b(boolean r100, Continuation<? super JSONObject> r101) {
        if ((r101 instanceof MmRecordingMapReadHelper$readFromCache$1) == false) goto L7;
        MmRecordingMapReadHelper$readFromCache$1 r102 = (MmRecordingMapReadHelper$readFromCache$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L17;
        if (r106 != 1) goto L16;
        ResultKt.throwOnFailure(r104);     // Catch: Exception -> L13
    L25:
        return (JSONObject) r104;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r104);
        CoroutineDispatcher r107 = Dispatchers.getIO();     // Catch: Exception -> L13
        if (r100 == false) goto L21;
        boolean r108 = true;
    L22:
        MmRecordingMapReadHelper$readFromCache$2 r109 = new MmRecordingMapReadHelper$readFromCache$2(r108, this, null);     // Catch: Exception -> L13
        r102.label = 1;     // Catch: Exception -> L13
        r104 = BuildersKt.withContext(r107, r109, r102);     // Catch: Exception -> L13
        if (r104 != r105) goto L25;
        return r105;
    L21:
        r108 = false;
    L13:
        e = move-exception;
        lvb.a.b(this.f435006a, "readFromCache error: " + e.getMessage());
        return null;
    L7:
        r102 = new MmRecordingMapReadHelper$readFromCache$1(this, r101);
        goto L8
    }

    public static final Object a(MmRecordingMapReadHelper r100, Bitmap r101, Continuation r110) {
        r100.getClass();
        if ((r110 instanceof MmRecordingMapReadHelper$encodeBitMap$1) == false) goto L7;
        MmRecordingMapReadHelper$encodeBitMap$1 r102 = (MmRecordingMapReadHelper$encodeBitMap$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L16;
        if (r105 != 1) goto L15;
        long r106 = r102.J$0;
        ResultKt.throwOnFailure(r111);     // Catch: Exception -> L23
    L21:
        JSONObject r107 = new JSONObject();     // Catch: Exception -> L23
        r107.put("backgroundBg", (String) r111);     // Catch: Exception -> L23
        lvb.a.e(r100.f435006a, "[encodeBitMap] encoded, cost=" + (System.currentTimeMillis() - r106) + "ms");     // Catch: Exception -> L23
        return r107;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r111);
        long r108 = System.currentTimeMillis();     // Catch: Exception -> L23
        CoroutineDispatcher r112 = Dispatchers.getIO();     // Catch: Exception -> L23
        MmRecordingMapReadHelper$encodeBitMap$bitmapString$1 r109 = new MmRecordingMapReadHelper$encodeBitMap$bitmapString$1(r101, null);     // Catch: Exception -> L23
        r102.J$0 = r108;     // Catch: Exception -> L23
        r102.label = 1;     // Catch: Exception -> L23
        r111 = BuildersKt.withContext(r112, r109, r102);     // Catch: Exception -> L23
        if (r111 == r104) goto L28;
        r106 = r108;
        goto L21
    L28:
        return r104;
    L23:
        e = move-exception;
        lvb.a.b(r100.f435006a, "[encodeBitMap] error=" + e.getMessage());
        return null;
    L7:
        r102 = new MmRecordingMapReadHelper$encodeBitMap$1(r100, r110);
        goto L8
    }
}
