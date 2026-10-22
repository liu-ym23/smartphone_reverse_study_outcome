package com.ss.android.lark.officesdk.minutes.service.recording.common.repo.endwindow;

import com.ss.android.lark.officesdk.minutes.service.recording.common.repo.cta.MmUnavailableReason;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes37.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<String> f434953a = null;

    static {
        f434953a = SetsKt.setOf(new String[]{"5h", "7d"});
    }

    public static final MmEndWindowUnavailableReason a(MmUnavailableReason r100) {
        if (r100 == null) goto L10;
        Integer r101 = r100.getReasonCode();
        if (r101 == null) goto L10;
        if (r101.intValue() != 2) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == false) goto L16;
        if (CollectionsKt.contains(f434953a, r100.getWindowLimitType()) == false) goto L16;
        return new MmEndWindowUnavailableReason(2, r100.getWindowLimitType());
    L16:
        return new MmEndWindowUnavailableReason(0, null, 3, null);
    L10:
        r102 = false;
        goto L11
    }
}
