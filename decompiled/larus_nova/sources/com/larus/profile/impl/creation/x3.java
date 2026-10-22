package com.larus.profile.impl.creation;

import com.bytedance.sdk.bridge.annotation.BridgePrivilege;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class x3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f366399a = 0;

    static {
    }

    public static String a(Integer r100) {
        String r101 = ProfileCreationListFragmentV2.class.getName();
        if (r100 != null) goto L6;
    L8:
        if (r100 != null) goto L11;
    L13:
        if (r100 != null) goto L16;
    L18:
        Intrinsics.checkNotNull(r101);
        return r101;
    L16:
        if (r100.intValue() != 0) goto L18;
        return r101.concat("mix");
    L11:
        if (r100.intValue() != 1) goto L13;
        return r101.concat("public");
    L6:
        if (r100.intValue() != 2) goto L8;
        return r101.concat(BridgePrivilege.PRIVATE);
    }
}
