package com.ss.android.lark.officesdk.minutes.assembly.recording.common.hardware;

import com.ss.android.lark.officesdk.minutes.service.foundation.mvi.thread.MMCoroutines;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import yub.d;

/* JADX INFO: loaded from: classes37.dex */
public final class MmHardwareOfflineRecordingForegroundRetryController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final hub.a f433670a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final MmHardwareCallRecordingFloatController f433671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineScope f433672c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f433673d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, yub.a.b> f433674e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, Long> f433675f;

    public static final class a {
    }

    static {
    }

    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "recordingId");
        if (StringsKt.isBlank(r100) == false) goto L5;
        return;
    L5:
        CoroutineScope r101 = this.f433672c;
        Lazy r102 = MMCoroutines.f433826a;
        BuildersKt.launch$default(r101, Dispatchers.getMain().getImmediate(), null, new MmHardwareOfflineRecordingForegroundRetryController$unregister$1(this, r100, null), 2, null);
    }

    public MmHardwareOfflineRecordingForegroundRetryController(hub.a r100, MmHardwareCallRecordingFloatController r101, CoroutineScope r102) {
        Intrinsics.checkNotNullParameter(r100, "capacity");
        Intrinsics.checkNotNullParameter(r101, "floatController");
        Intrinsics.checkNotNullParameter(r102, "scope");
        this.f433670a = r100;
        this.f433671b = r101;
        this.f433672c = r102;
        this.f433673d = "MmHardwareOfflineRecordingForegroundRetryController_" + hashCode();
        this.f433674e = new LinkedHashMap();
        this.f433675f = new LinkedHashMap();
    }

    public static final void a(MmHardwareOfflineRecordingForegroundRetryController r100, String r101, yub.a.b r102, String r110) {
        if (((LinkedHashMap) r100.f433674e).get(r101) != r102) goto L19;
        d r103 = d.f569261a;
        if (com.ss.android.lark.appcontext.applifecycle2.api.a.b() == true) goto L8;
        lvb.a.e(r100.f433673d, "[retryWhenForeground] wait, trigger=" + r110 + ", recordingId=" + r101);
        return;
    L8:
        long r104 = System.currentTimeMillis();
        Long r105 = (Long) ((LinkedHashMap) r100.f433675f).get(r101);
        if (r105 == null) goto L11;
        long r106 = r105.longValue();
    L13:
        if ((r104 - r106) >= 10000) goto L15;
        lvb.a.e(r100.f433673d, "[retryWhenForeground] skip by interval, trigger=" + r110 + ", recordingId=" + r101);
        return;
    L15:
        r100.f433675f.put(r101, Long.valueOf(r104));
        lvb.a.e(r100.f433673d, "[retryWhenForeground] foreground confirmed, trigger=" + r110 + ", recordingId=" + r101);
        lvb.a.e(r100.f433673d, "[retryCreateRecording] trigger=" + r110 + ", recordingId=" + r101);
        r100.f433670a.ud(r101, null, new b(r100, r110, r101));
        return;
    L11:
        r106 = 0;
        goto L13
    }
}
