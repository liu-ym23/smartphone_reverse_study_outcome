package com.ss.android.lark.officesdk.minutes.ui.style;

import com.bytedance.i18n.claymore.ClaymoreServiceLoader;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.MmRecordingUILaunchMode;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import com.ss.android.lark.officesdk.minutes.ui.style.contract.h;
import com.ss.android.lark.officesdk.minutes.ui.style.provider.f;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final e f436896a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final f f436897b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<MmRecordingUILaunchMode, h> f436898c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final AtomicBoolean f436899d = null;

    public e() {
    }

    static {
        f436896a = new e();
        f436897b = new f();
        f436898c = new ConcurrentHashMap();
        f436899d = new AtomicBoolean(false);
    }

    public static void a() {
        if (f436899d.compareAndSet(false, true) == true) goto L21;
        return;
    L21:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L11
        Iterator r101 = ClaymoreServiceLoader.loadAll(h.class);     // Catch: Throwable -> L11
    L7:
        if (r101.hasNext() == false) goto L9;
        h r102 = (h) r101.next();     // Catch: Throwable -> L11
        Intrinsics.checkNotNullParameter(r102, ShortVideoSegments.KEY_PROP_PROVIDER);     // Catch: Throwable -> L11
        f436898c.compute(r102.getUiLaunchMode(), new d(r102));     // Catch: Throwable -> L11
        goto L7
    L9:
        Object r103 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r103);
        if (r104 == null) goto L16;
        int r105 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.STYLE, "ensureLoaded", "load providers failed, error=" + r104, null);
    L16:
        ConcurrentHashMap<MmRecordingUILaunchMode, h> r106 = f436898c;
        h r107 = r106.get(MmRecordingUILaunchMode.WITH_DOUBAO_UI);
        if (r107 == null) goto L24;
        r106.putIfAbsent(MmRecordingUILaunchMode.WITH_DOUBAO_UI_HARDWARE, r107);
        return;
    L24:
        return;
    L11:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L13
    }

    public static h b(MmRecordingUILaunchMode r100) {
        a();
        if (r100 != null) goto L5;
        r100 = MmRecordingUILaunchMode.UNKNOWN;
    L5:
        h r101 = f436898c.get(r100);
        if (r101 != null) goto L9;
        f r102 = f436897b;
        int r103 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.STYLE, "providerOrDefaultForResource", "use fallback, mode=" + r100, null);
        return r102;
    L9:
        return r101;
    }

    public static h c(MmRecordingUILaunchMode r100) {
        a();
        if (r100 != null) goto L5;
        r100 = MmRecordingUILaunchMode.UNKNOWN;
    L5:
        h r101 = f436898c.get(r100);
        if (r101 != null) goto L8;
        int r102 = bwb.b.f21271a;
        bwb.b.d(MmUiLogScene.STYLE, "providerOrNullForLaunch", "missing provider, mode=" + r100, null);
    L8:
        return r101;
    }
}
