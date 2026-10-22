package com.ss.android.lark.officesdk.minutes.ui.record.notification;

import bwb.b;
import com.obric.sva.sdk.utils.InteractConst;
import com.ss.android.lark.officesdk.minutes.service.recording.common.core.data.RecordingSessionType;
import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.notification.MmRecordingNotificationRepo;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes37.dex */
public final class MmDoubaoRecordingNotificationProcessor implements ewb.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a f435918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Job f435919b;

    @Override // ewb.a
    public final void clearAll() {
        Job r100 = this.f435919b;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f435919b = null;
        a r101 = this.f435918a;
        r101.getClass();
        int r102 = b.f21271a;
        b.g(MmUiLogScene.NOTIFICATION, "clearAll", "brand=doubao, size=" + r101.f435921a.size(), null, 8);
        ((LinkedHashMap) r101.f435921a).clear();
    }

    public MmDoubaoRecordingNotificationProcessor() {
        this.f435918a = new a();
    }

    @Override // ewb.a
    public final void a(ewb.b r100, MmRecordingNotificationRepo r101, RecordingSessionType r110, CoroutineScope r111) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "notificationRepo");
        Intrinsics.checkNotNullParameter(r110, InteractConst.WAKEUP_SESSION_TYPE);
        Intrinsics.checkNotNullParameter(r111, "scope");
        Job r102 = this.f435919b;
        if (r102 == null) goto L5;
        Job.DefaultImpls.cancel$default(r102, null, 1, null);
    L5:
        this.f435919b = BuildersKt.launch$default(r111, null, null, new MmDoubaoRecordingNotificationProcessor$start$1(r101, this, null), 3, null);
    }
}
