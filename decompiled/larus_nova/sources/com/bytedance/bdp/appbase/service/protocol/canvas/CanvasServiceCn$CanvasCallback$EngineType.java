package com.bytedance.bdp.appbase.service.protocol.canvas;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0003H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"com/bytedance/bdp/appbase/service/protocol/canvas/CanvasServiceCn$CanvasCallback$EngineType", "", "Lcom/bytedance/bdp/appbase/service/protocol/canvas/CanvasServiceCn$CanvasCallback$EngineType;", "", "toString", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "SONIC", "HELIUM", "bdp-appbase-ext_release"}, k = 1, mv = {1, 4, 0})
public final enum CanvasServiceCn$CanvasCallback$EngineType extends Enum<CanvasServiceCn$CanvasCallback$EngineType> {
    public static final CanvasServiceCn$CanvasCallback$EngineType HELIUM = null;
    public static final CanvasServiceCn$CanvasCallback$EngineType SONIC = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CanvasServiceCn$CanvasCallback$EngineType[] f200962a = null;
    private final String type;

    static {
        CanvasServiceCn$CanvasCallback$EngineType r100 = new CanvasServiceCn$CanvasCallback$EngineType("SONIC", 0, "sonic");
        SONIC = r100;
        CanvasServiceCn$CanvasCallback$EngineType r101 = new CanvasServiceCn$CanvasCallback$EngineType("HELIUM", 1, "helium");
        HELIUM = r101;
        f200962a = new CanvasServiceCn$CanvasCallback$EngineType[]{r100, r101};
    }

    public static CanvasServiceCn$CanvasCallback$EngineType valueOf(String r100) {
        return (CanvasServiceCn$CanvasCallback$EngineType) a.a(CanvasServiceCn$CanvasCallback$EngineType.class, r100);
    }

    public static CanvasServiceCn$CanvasCallback$EngineType[] values() {
        return (CanvasServiceCn$CanvasCallback$EngineType[]) f200962a.clone();
    }

    public final String getType() {
        return this.type;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.type;
    }

    public CanvasServiceCn$CanvasCallback$EngineType(String r100, int r101, String r102) {
        super(r100, r101);
        this.type = r102;
    }
}
