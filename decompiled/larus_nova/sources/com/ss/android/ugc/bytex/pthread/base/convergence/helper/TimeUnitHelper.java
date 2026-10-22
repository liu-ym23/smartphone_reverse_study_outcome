package com.ss.android.ugc.bytex.pthread.base.convergence.helper;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/ss/android/ugc/bytex/pthread/base/convergence/helper/TimeUnitHelper;", "", "()V", "C0", "", "C1", "C2", "excessNanos", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "d", "m", "threadpool-plugin-base_release"}, k = 1, mv = {1, 1, 13})
public final class TimeUnitHelper {
    private static final long C0 = 1;
    private static final long C1 = 1000;
    private static final long C2 = 1000000;
    public static final TimeUnitHelper INSTANCE = null;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 13})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[TimeUnit.values().length];
            $EnumSwitchMapping$0 = r100;
            r100[TimeUnit.NANOSECONDS.ordinal()] = 1;
            r100[TimeUnit.MICROSECONDS.ordinal()] = 2;
        }
    }

    static {
        INSTANCE = new TimeUnitHelper();
    }

    private TimeUnitHelper() {
    }

    public final int excessNanos(TimeUnit r100, long r101, long r102) {
        int r103 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        if (r103 != 1) goto L5;
        Long.signum(r102);
    L10:
        return (int) (r101 - (r102 * 1000000));
    L5:
        if (r103 == 2) goto L7;
        return 0;
    L7:
        r101 = r101 * 1000;
        goto L10
    }
}
