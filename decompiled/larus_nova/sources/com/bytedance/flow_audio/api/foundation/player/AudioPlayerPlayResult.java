package com.bytedance.flow_audio.api.foundation.player;

import com.larus.platform.model.upload.ResourceUploadError;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u001d\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\tj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0012"}, d2 = {"Lcom/bytedance/flow_audio/api/foundation/player/AudioPlayerPlayResult;", "", "eventType", "", "error", "Lcom/bytedance/flow_audio/api/foundation/player/AudioPlayerError;", "<init>", "(Ljava/lang/String;ILjava/lang/String;Lcom/bytedance/flow_audio/api/foundation/player/AudioPlayerError;)V", "getEventType", "()Ljava/lang/String;", "getError", "()Lcom/bytedance/flow_audio/api/foundation/player/AudioPlayerError;", "Unknown", "Played", "Canceled", "Failed", "description", "getDescription", "flow_audio_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AudioPlayerPlayResult extends Enum<AudioPlayerPlayResult> {
    public static final AudioPlayerPlayResult Canceled = null;
    public static final AudioPlayerPlayResult Failed = null;
    public static final AudioPlayerPlayResult Played = null;
    public static final AudioPlayerPlayResult Unknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AudioPlayerPlayResult[] f243701a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f243702b = null;
    private final AudioPlayerError error;
    private final String eventType;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f243703a = null;

        static {
            int[] r100 = new int[AudioPlayerPlayResult.values().length];
            r100[AudioPlayerPlayResult.Unknown.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r100[AudioPlayerPlayResult.Played.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r100[AudioPlayerPlayResult.Canceled.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r100[AudioPlayerPlayResult.Failed.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            f243703a = r100;
        }
    }

    public static EnumEntries<AudioPlayerPlayResult> getEntries() {
        return f243702b;
    }

    static {
        AudioPlayerPlayResult r100 = new AudioPlayerPlayResult("Unknown", 0, "unknown", null, 2, null);
        Unknown = r100;
        AudioPlayerPlayResult r101 = new AudioPlayerPlayResult("Played", 1, "played", null, 2, null);
        Played = r101;
        AudioPlayerPlayResult r102 = new AudioPlayerPlayResult("Canceled", 2, ResourceUploadError.CANCELED, null, 2, null);
        Canceled = r102;
        AudioPlayerPlayResult r103 = new AudioPlayerPlayResult("Failed", 3, "failed", new AudioPlayerError("unknown"));
        Failed = r103;
        AudioPlayerPlayResult[] r104 = {r100, r101, r102, r103};
        f243701a = r104;
        f243702b = EnumEntriesKt.enumEntries(r104);
    }

    public static AudioPlayerPlayResult[] values() {
        return (AudioPlayerPlayResult[]) f243701a.clone();
    }

    public final String getDescription() {
        int r100 = a.f243703a[ordinal()];
        if (r100 != 1) goto L5;
        return "unknown";
    L5:
        if (r100 != 2) goto L7;
        return "played";
    L7:
        if (r100 != 3) goto L9;
        return ResourceUploadError.CANCELED;
    L9:
        if (r100 != 4) goto L18;
        AudioPlayerError r101 = this.error;
        if (r101 == null) goto L13;
        String r102 = r101.getMessage();
    L14:
        if (r102 != null) goto L23;
        r102 = "";
    L23:
        return "failed ".concat(r102);
    L13:
        r102 = null;
        goto L14
    L18:
        throw new NoWhenBranchMatchedException();
    }

    public final AudioPlayerError getError() {
        return this.error;
    }

    public final String getEventType() {
        return this.eventType;
    }

    public static AudioPlayerPlayResult valueOf(String r100) {
        return (AudioPlayerPlayResult) r27.a.a(AudioPlayerPlayResult.class, r100);
    }

    public AudioPlayerPlayResult(String r100, int r101, String r102, AudioPlayerError r103) {
        super(r100, r101);
        this.eventType = r102;
        this.error = r103;
    }

    public /* synthetic */ AudioPlayerPlayResult(String r100, int r101, String r102, AudioPlayerError r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 2) == 0) goto L5;
        r103 = null;
    L5:
        this(r100, r101, r102, r103);
    }
}
