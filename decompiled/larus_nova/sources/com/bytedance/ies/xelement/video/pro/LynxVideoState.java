package com.bytedance.ies.xelement.video.pro;

import com.android.ttcjpaysdk.base.h5.cjjsb.constant.ErrorCode;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/bytedance/ies/xelement/video/pro/LynxVideoState;", "", ErrorCode.INIT, "CREATE", "READY", "PLAYING", "STOP", "DESTROY", "x-element-video-pro_release"}, k = 1, mv = {1, 6, 0})
public final enum LynxVideoState extends Enum<LynxVideoState> {
    public static final LynxVideoState CREATE = null;
    public static final LynxVideoState DESTROY = null;
    public static final LynxVideoState INIT = null;
    public static final LynxVideoState PLAYING = null;
    public static final LynxVideoState READY = null;
    public static final LynxVideoState STOP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ LynxVideoState[] f250396a = null;

    public static LynxVideoState valueOf(String r100) {
        return (LynxVideoState) r27.a.a(LynxVideoState.class, r100);
    }

    public static LynxVideoState[] values() {
        return (LynxVideoState[]) f250396a.clone();
    }

    static {
        LynxVideoState r100 = new LynxVideoState(ErrorCode.INIT, 0);
        INIT = r100;
        LynxVideoState r101 = new LynxVideoState("CREATE", 1);
        CREATE = r101;
        LynxVideoState r102 = new LynxVideoState("READY", 2);
        READY = r102;
        LynxVideoState r103 = new LynxVideoState("PLAYING", 3);
        PLAYING = r103;
        LynxVideoState r104 = new LynxVideoState("STOP", 4);
        STOP = r104;
        LynxVideoState r105 = new LynxVideoState("DESTROY", 5);
        DESTROY = r105;
        f250396a = new LynxVideoState[]{r100, r101, r102, r103, r104, r105};
    }

    public LynxVideoState(String r100, int r101) {
        super(r100, r101);
    }
}
