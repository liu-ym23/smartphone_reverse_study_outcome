package com.larus.avlink.gallery.model;

import com.ss.android.download.api.config.HttpMethod;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u0000 \u000f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000e¨\u0006\u0010"}, d2 = {"Lcom/larus/avlink/gallery/model/MediaLifecycleState;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", HttpMethod.DOWNLOAD, "DOWNLOADED_TEMP", "PROCESSING", "PROCESSED", "SYNCING_TO_SYSTEM_ALBUM", "COMPLETED", "FAILED", "Companion", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MediaLifecycleState extends Enum<MediaLifecycleState> {
    public static final MediaLifecycleState COMPLETED = null;
    public static final a Companion = null;
    public static final MediaLifecycleState DOWNLOAD = null;
    public static final MediaLifecycleState DOWNLOADED_TEMP = null;
    public static final MediaLifecycleState FAILED = null;
    public static final MediaLifecycleState PROCESSED = null;
    public static final MediaLifecycleState PROCESSING = null;
    public static final MediaLifecycleState SYNCING_TO_SYSTEM_ALBUM = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MediaLifecycleState[] f292618a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f292619b = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    public static EnumEntries<MediaLifecycleState> getEntries() {
        return f292619b;
    }

    static {
        MediaLifecycleState r100 = new MediaLifecycleState(HttpMethod.DOWNLOAD, 0, 0);
        DOWNLOAD = r100;
        MediaLifecycleState r101 = new MediaLifecycleState("DOWNLOADED_TEMP", 1, 1);
        DOWNLOADED_TEMP = r101;
        MediaLifecycleState r102 = new MediaLifecycleState("PROCESSING", 2, 2);
        PROCESSING = r102;
        MediaLifecycleState r103 = new MediaLifecycleState("PROCESSED", 3, 3);
        PROCESSED = r103;
        MediaLifecycleState r104 = new MediaLifecycleState("SYNCING_TO_SYSTEM_ALBUM", 4, 4);
        SYNCING_TO_SYSTEM_ALBUM = r104;
        MediaLifecycleState r105 = new MediaLifecycleState("COMPLETED", 5, 5);
        COMPLETED = r105;
        MediaLifecycleState r110 = new MediaLifecycleState("FAILED", 6, 99);
        FAILED = r110;
        MediaLifecycleState[] r111 = {r100, r101, r102, r103, r104, r105, r110};
        f292618a = r111;
        f292619b = EnumEntriesKt.enumEntries(r111);
        Companion = new a();
    }

    public static MediaLifecycleState[] values() {
        return (MediaLifecycleState[]) f292618a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static MediaLifecycleState valueOf(String r100) {
        return (MediaLifecycleState) r27.a.a(MediaLifecycleState.class, r100);
    }

    public MediaLifecycleState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
