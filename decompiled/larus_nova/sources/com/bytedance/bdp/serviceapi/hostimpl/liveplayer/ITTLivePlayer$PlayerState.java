package com.bytedance.bdp.serviceapi.hostimpl.liveplayer;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"com/bytedance/bdp/serviceapi/hostimpl/liveplayer/ITTLivePlayer$PlayerState", "", "Lcom/bytedance/bdp/serviceapi/hostimpl/liveplayer/ITTLivePlayer$PlayerState;", ErrorCode.INIT, "FETCHING", "PREPARED", "PLAYING", "STALLING", "STOPPED", "COMPLETED", "ERROR", "STREAM_DRY_UP", "REQUEST_PLAY_URL_ERROR", "bdp-service-api_release"}, k = 1, mv = {1, 4, 0})
public final enum ITTLivePlayer$PlayerState extends Enum<ITTLivePlayer$PlayerState> {
    public static final ITTLivePlayer$PlayerState COMPLETED = null;
    public static final ITTLivePlayer$PlayerState ERROR = null;
    public static final ITTLivePlayer$PlayerState FETCHING = null;
    public static final ITTLivePlayer$PlayerState INIT = null;
    public static final ITTLivePlayer$PlayerState PLAYING = null;
    public static final ITTLivePlayer$PlayerState PREPARED = null;
    public static final ITTLivePlayer$PlayerState REQUEST_PLAY_URL_ERROR = null;
    public static final ITTLivePlayer$PlayerState STALLING = null;
    public static final ITTLivePlayer$PlayerState STOPPED = null;
    public static final ITTLivePlayer$PlayerState STREAM_DRY_UP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ITTLivePlayer$PlayerState[] f201612a = null;

    static {
        ITTLivePlayer$PlayerState r100 = new ITTLivePlayer$PlayerState(ErrorCode.INIT, 0);
        INIT = r100;
        ITTLivePlayer$PlayerState r101 = new ITTLivePlayer$PlayerState("FETCHING", 1);
        FETCHING = r101;
        ITTLivePlayer$PlayerState r102 = new ITTLivePlayer$PlayerState("PREPARED", 2);
        PREPARED = r102;
        ITTLivePlayer$PlayerState r103 = new ITTLivePlayer$PlayerState("PLAYING", 3);
        PLAYING = r103;
        ITTLivePlayer$PlayerState r104 = new ITTLivePlayer$PlayerState("STALLING", 4);
        STALLING = r104;
        ITTLivePlayer$PlayerState r105 = new ITTLivePlayer$PlayerState("STOPPED", 5);
        STOPPED = r105;
        ITTLivePlayer$PlayerState r106 = new ITTLivePlayer$PlayerState("COMPLETED", 6);
        COMPLETED = r106;
        ITTLivePlayer$PlayerState r107 = new ITTLivePlayer$PlayerState("ERROR", 7);
        ERROR = r107;
        ITTLivePlayer$PlayerState r108 = new ITTLivePlayer$PlayerState("STREAM_DRY_UP", 8);
        STREAM_DRY_UP = r108;
        ITTLivePlayer$PlayerState r109 = new ITTLivePlayer$PlayerState("REQUEST_PLAY_URL_ERROR", 9);
        REQUEST_PLAY_URL_ERROR = r109;
        f201612a = new ITTLivePlayer$PlayerState[]{r100, r101, r102, r103, r104, r105, r106, r107, r108, r109};
    }

    public static ITTLivePlayer$PlayerState valueOf(String r100) {
        return (ITTLivePlayer$PlayerState) a.a(ITTLivePlayer$PlayerState.class, r100);
    }

    public static ITTLivePlayer$PlayerState[] values() {
        return (ITTLivePlayer$PlayerState[]) f201612a.clone();
    }

    public ITTLivePlayer$PlayerState(String r100, int r101) {
        super(r100, r101);
    }
}
