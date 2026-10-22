package com.larus.media;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tj\u0002\b\u0004j\u0002\b\u0005¨\u0006\n"}, d2 = {"Lcom/larus/media/PlayScenario;", "", "<init>", "(Ljava/lang/String;I)V", "MEDIA", "VOICE_COMMUNICATION", "toStreamType", "Lcom/larus/media/PlayStreamType;", "toUsageType", "Lcom/larus/media/PlayUsageType;", "OApp.flowSDK.baseSDK.common.avsdk-media"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum PlayScenario extends Enum<PlayScenario> {
    public static final PlayScenario MEDIA = null;
    public static final PlayScenario VOICE_COMMUNICATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PlayScenario[] f358966a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f358967b = null;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f358968a = null;

        static {
            int[] r100 = new int[PlayScenario.values().length];
            r100[PlayScenario.MEDIA.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[PlayScenario.VOICE_COMMUNICATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f358968a = r100;
        }
    }

    public static EnumEntries<PlayScenario> getEntries() {
        return f358967b;
    }

    static {
        PlayScenario r100 = new PlayScenario("MEDIA", 0);
        MEDIA = r100;
        PlayScenario r101 = new PlayScenario("VOICE_COMMUNICATION", 1);
        VOICE_COMMUNICATION = r101;
        PlayScenario[] r102 = {r100, r101};
        f358966a = r102;
        f358967b = EnumEntriesKt.enumEntries(r102);
    }

    public static PlayScenario[] values() {
        return (PlayScenario[]) f358966a.clone();
    }

    public final PlayStreamType toStreamType() {
        int r100 = a.f358968a[ordinal()];
        if (r100 == 1) goto L10;
        if (r100 != 2) goto L8;
        return PlayStreamType.STREAM_VOICE_CALL;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return PlayStreamType.STREAM_MUSIC;
    }

    public final PlayUsageType toUsageType() {
        int r100 = a.f358968a[ordinal()];
        if (r100 == 1) goto L10;
        if (r100 != 2) goto L8;
        return PlayUsageType.VOICE_COMMUNICATION;
    L8:
        throw new NoWhenBranchMatchedException();
    L10:
        return PlayUsageType.MEDIA;
    }

    public static PlayScenario valueOf(String r100) {
        return (PlayScenario) r27.a.a(PlayScenario.class, r100);
    }

    public PlayScenario(String r100, int r101) {
        super(r100, r101);
    }
}
