package com.larus.dora.impl.feedback;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/larus/dora/impl/feedback/ImageState;", "", "<init>", "(Ljava/lang/String;I)V", "IDLE", "ON_COMPRESS", "COMPRESS_DONE", "ON_UPLOAD", "READY", "FAILED", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ImageState extends Enum<ImageState> {
    public static final ImageState COMPRESS_DONE = null;
    public static final ImageState FAILED = null;
    public static final ImageState IDLE = null;
    public static final ImageState ON_COMPRESS = null;
    public static final ImageState ON_UPLOAD = null;
    public static final ImageState READY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ImageState[] f335597a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f335598b = null;

    public static EnumEntries<ImageState> getEntries() {
        return f335598b;
    }

    static {
        ImageState r100 = new ImageState("IDLE", 0);
        IDLE = r100;
        ImageState r101 = new ImageState("ON_COMPRESS", 1);
        ON_COMPRESS = r101;
        ImageState r102 = new ImageState("COMPRESS_DONE", 2);
        COMPRESS_DONE = r102;
        ImageState r103 = new ImageState("ON_UPLOAD", 3);
        ON_UPLOAD = r103;
        ImageState r104 = new ImageState("READY", 4);
        READY = r104;
        ImageState r105 = new ImageState("FAILED", 5);
        FAILED = r105;
        ImageState[] r110 = {r100, r101, r102, r103, r104, r105};
        f335597a = r110;
        f335598b = EnumEntriesKt.enumEntries(r110);
    }

    public static ImageState[] values() {
        return (ImageState[]) f335597a.clone();
    }

    public static ImageState valueOf(String r100) {
        return (ImageState) r27.a.a(ImageState.class, r100);
    }

    public ImageState(String r100, int r101) {
        super(r100, r101);
    }
}
