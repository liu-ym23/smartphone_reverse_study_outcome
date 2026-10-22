package com.larus.init.task.imsdk;

import com.larus.im.NetworkTriggerType;
import com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: loaded from: classes4.dex */
public final class a extends BDNetworkTagContextProviderAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ com.larus.im.h f351357a;

    /* JADX INFO: renamed from: com.larus.init.task.imsdk.a$a, reason: collision with other inner class name */
    public /* synthetic */ class C4383a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f351358a = null;

        static {
            int[] r100 = new int[NetworkTriggerType.values().length];
            r100[NetworkTriggerType.User.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[NetworkTriggerType.Auto.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f351358a = r100;
        }
    }

    @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public final boolean markAsNewUser() {
        return this.f351357a.markAsNewUser();
    }

    @Override // com.ss.android.ugc.quota.BDNetworkTagContextProviderAdapter, com.ss.android.ugc.quota.IBDNetworkTagContextProvider
    public final int triggerType() {
        NetworkTriggerType r100 = this.f351357a.triggerType();
        int r101 = C4383a.f351358a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return 1;
    L5:
        if (r101 != 2) goto L8;
        return 0;
    L8:
        throw new NoWhenBranchMatchedException();
    }

    public a(com.larus.im.l r100) {
        this.f351357a = r100;
    }
}
