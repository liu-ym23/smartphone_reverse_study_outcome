package com.obric.sva.sdk.data;

import com.obric.sva.sdk.ipc.TrackerManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001\u001a\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"SUSPECT_CRED", "", "DOUBLE_CHECK_CRED", "TRUSTED_CRED", "fromCredibility", "Lcom/obric/sva/sdk/data/CredibilityType;", "credibility", "trackCredibilityType", "", "credibilityType", "libs_mainlandRelease"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CredibilityTypeKt {
    public static final int DOUBLE_CHECK_CRED = 10;
    public static final int SUSPECT_CRED = 0;
    public static final int TRUSTED_CRED = 100;

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[CredibilityType.values().length];
            r100[CredibilityType.SUSPECT.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[CredibilityType.DOUBLE_CHECK.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            $EnumSwitchMapping$0 = r100;
        }
    }

    public static final CredibilityType fromCredibility(int r100) {
        if (r100 == 0) goto L12;
        if (r100 == 10) goto L14;
        if (r100 != 100) goto L9;
        return CredibilityType.TRUSTED;
    L9:
        throw new IllegalArgumentException("given bad credibility value of " + r100);
    L14:
        return CredibilityType.DOUBLE_CHECK;
    L12:
        return CredibilityType.SUSPECT;
    }

    public static final void trackCredibilityType(CredibilityType r100) {
        Intrinsics.checkNotNullParameter(r100, "credibilityType");
        int r101 = WhenMappings.$EnumSwitchMapping$0[r100.ordinal()];
        if (r101 != 1) goto L5;
        int r102 = 101;
    L9:
        TrackerManager.INSTANCE.onTrackEvent(r102, null);
        return;
    L5:
        if (r101 == 2) goto L7;
        r102 = 103;
        goto L9
    L7:
        r102 = 102;
        goto L9
    }
}
