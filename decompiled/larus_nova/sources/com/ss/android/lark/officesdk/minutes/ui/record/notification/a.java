package com.ss.android.lark.officesdk.minutes.ui.record.notification;

import bwb.b;
import com.ss.android.lark.officesdk.minutes.api.recording.common.data.notification.MmRecordingNotificationType;
import com.ss.android.lark.officesdk.minutes.ui.record.MmUiLogScene;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<MmRecordingNotificationType, Long> f435921a;

    public a() {
        this.f435921a = new LinkedHashMap();
    }

    public final void a(MmRecordingNotificationType r110, String r111, jub.a r112) {
        Intrinsics.checkNotNullParameter(r110, "type");
        Intrinsics.checkNotNullParameter(r111, "content");
        Intrinsics.checkNotNullParameter(r112, "config");
        int r100 = b.f21271a;
        MmUiLogScene r101 = MmUiLogScene.NOTIFICATION;
        b.g(r101, "show", "brand=doubao, type=" + r110 + ", throttle=" + r112.f500509d, null, 8);
        long r102 = 0;
        if (r112.f500509d <= 0) goto L12;
        Long r103 = (Long) ((LinkedHashMap) this.f435921a).get(r110);
        if (r103 == null) goto L7;
        r102 = r103.longValue();
    L7:
        long r104 = System.currentTimeMillis();
        long r105 = r104 - r102;
        if (r105 >= r112.f500509d) goto L11;
        b.g(r101, "show", "brand=doubao, type=" + r110 + ", throttled=" + r105 + "ms", null, 8);
        return;
    L11:
        this.f435921a.put(r110, Long.valueOf(r104));
    L12:
        com.ss.android.lark.officesdk.minutes.service.foundation.utils.b.g(r111);
    }
}
