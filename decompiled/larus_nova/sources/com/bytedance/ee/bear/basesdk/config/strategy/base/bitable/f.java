package com.bytedance.ee.bear.basesdk.config.strategy.base.bitable;

import com.bytedance.ee.bear.bitable.chameleon.BitableSubType;
import com.bytedance.ee.bear.document.SubStrategyType;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes15.dex */
public final class f {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f206607a = null;

        static {
            int[] r100 = new int[SubStrategyType.values().length];
            r100[SubStrategyType.BaseAdd.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[SubStrategyType.BaseRecord.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[SubStrategyType.BaseApp.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[SubStrategyType.BaseMain.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f206607a = r100;
        }
    }

    public static final BitableSubType a(SubStrategyType r100) {
        int r101 = a.f206607a[r100.ordinal()];
        if (r101 == 1) goto L16;
        if (r101 == 2) goto L19;
        if (r101 == 3) goto L18;
        if (r101 != 4) goto L12;
        return BitableSubType.BaseMain;
    L12:
        throw new NoWhenBranchMatchedException();
    L18:
        return BitableSubType.BaseApp;
    L19:
        return BitableSubType.BaseRecord;
    L16:
        return BitableSubType.BaseAdd;
    }
}
