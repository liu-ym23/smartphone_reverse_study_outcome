package io.ktor.websocket;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes41.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"io/ktor/websocket/FrameParser$State", "", "Lio/ktor/websocket/FrameParser$State;", "HEADER0", "LENGTH", "MASK_KEY", "BODY", "ktor-websockets"}, k = 1, mv = {1, 8, 0})
public final enum FrameParser$State extends Enum<FrameParser$State> {
    public static final FrameParser$State BODY = null;
    public static final FrameParser$State HEADER0 = null;
    public static final FrameParser$State LENGTH = null;
    public static final FrameParser$State MASK_KEY = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ FrameParser$State[] f492156a = null;

    public static FrameParser$State valueOf(String r100) {
        return (FrameParser$State) r27.a.a(FrameParser$State.class, r100);
    }

    public static FrameParser$State[] values() {
        return (FrameParser$State[]) f492156a.clone();
    }

    static {
        FrameParser$State r100 = new FrameParser$State("HEADER0", 0);
        HEADER0 = r100;
        FrameParser$State r101 = new FrameParser$State("LENGTH", 1);
        LENGTH = r101;
        FrameParser$State r102 = new FrameParser$State("MASK_KEY", 2);
        MASK_KEY = r102;
        FrameParser$State r103 = new FrameParser$State("BODY", 3);
        BODY = r103;
        f492156a = new FrameParser$State[]{r100, r101, r102, r103};
    }

    public FrameParser$State(String r100, int r101) {
        super(r100, r101);
    }
}
