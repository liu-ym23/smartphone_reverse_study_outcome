package com.obric.sva.sdk.effectplatform;

import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\r\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Lcom/obric/sva/sdk/effectplatform/UpdateTrackerType;", "", RXScreenCaptureService.KEY_INDEX, "", "<init>", "(Ljava/lang/String;II)V", "getI", "()I", "DOWNLOAD_REQUEST", "DOWNLOAD_START", "DOWNLOAD_SUCCESS", "DOWNLOAD_FAILED", "MODEL_UPDATING", "MODEL_UPDATE_SUCCESS", "MODEL_UPDATE_FAIL", "MODEL_UPDATE_IGNORE", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UpdateTrackerType extends Enum<UpdateTrackerType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ UpdateTrackerType[] $VALUES = null;
    public static final UpdateTrackerType DOWNLOAD_FAILED = null;
    public static final UpdateTrackerType DOWNLOAD_REQUEST = null;
    public static final UpdateTrackerType DOWNLOAD_START = null;
    public static final UpdateTrackerType DOWNLOAD_SUCCESS = null;
    public static final UpdateTrackerType MODEL_UPDATE_FAIL = null;
    public static final UpdateTrackerType MODEL_UPDATE_IGNORE = null;
    public static final UpdateTrackerType MODEL_UPDATE_SUCCESS = null;
    public static final UpdateTrackerType MODEL_UPDATING = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f403889i;

    private static final /* synthetic */ UpdateTrackerType[] $values() {
        return new UpdateTrackerType[]{DOWNLOAD_REQUEST, DOWNLOAD_START, DOWNLOAD_SUCCESS, DOWNLOAD_FAILED, MODEL_UPDATING, MODEL_UPDATE_SUCCESS, MODEL_UPDATE_FAIL, MODEL_UPDATE_IGNORE};
    }

    public static EnumEntries<UpdateTrackerType> getEntries() {
        return $ENTRIES;
    }

    static {
        DOWNLOAD_REQUEST = new UpdateTrackerType("DOWNLOAD_REQUEST", 0, 401);
        DOWNLOAD_START = new UpdateTrackerType("DOWNLOAD_START", 1, 402);
        DOWNLOAD_SUCCESS = new UpdateTrackerType("DOWNLOAD_SUCCESS", 2, 403);
        DOWNLOAD_FAILED = new UpdateTrackerType("DOWNLOAD_FAILED", 3, 404);
        MODEL_UPDATING = new UpdateTrackerType("MODEL_UPDATING", 4, 405);
        MODEL_UPDATE_SUCCESS = new UpdateTrackerType("MODEL_UPDATE_SUCCESS", 5, 406);
        MODEL_UPDATE_FAIL = new UpdateTrackerType("MODEL_UPDATE_FAIL", 6, 407);
        MODEL_UPDATE_IGNORE = new UpdateTrackerType("MODEL_UPDATE_IGNORE", 7, 408);
        UpdateTrackerType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static UpdateTrackerType[] values() {
        return (UpdateTrackerType[]) $VALUES.clone();
    }

    public final int getI() {
        return this.f403889i;
    }

    public static UpdateTrackerType valueOf(String r100) {
        return (UpdateTrackerType) r27.a.a(UpdateTrackerType.class, r100);
    }

    private UpdateTrackerType(String r100, int r101, int r102) {
        super(r100, r101);
        this.f403889i = r102;
    }
}
