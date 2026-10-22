package open_pkm.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum PkmPrepareStep extends Enum<PkmPrepareStep> implements WireEnum {
    private static final /* synthetic */ PkmPrepareStep[] $VALUES = null;
    public static final ProtoAdapter<PkmPrepareStep> ADAPTER = null;
    public static final PkmPrepareStep VAR_PKM_PREPARE_STEP_LOAD_META_COMPLETE = null;
    public static final PkmPrepareStep VAR_PKM_PREPARE_STEP_LOAD_META_PROGRESS = null;
    public static final PkmPrepareStep VAR_PKM_PREPARE_STEP_LOAD_META_START = null;
    public static final PkmPrepareStep VAR_PKM_PREPARE_STEP_LOAD_PKG_COMPLETE = null;
    public static final PkmPrepareStep VAR_PKM_PREPARE_STEP_LOAD_PKG_PROGRESS = null;
    public static final PkmPrepareStep VAR_PKM_PREPARE_STEP_LOAD_PKG_READY = null;
    public static final PkmPrepareStep VAR_PKM_PREPARE_STEP_LOAD_PKG_START = null;
    public static final PkmPrepareStep VAR_PKM_PREPARE_STEP_META_FAILED = null;
    public static final PkmPrepareStep VAR_PKM_PREPARE_STEP_PKG_FAILED = null;
    public static final PkmPrepareStep VAR_PKM_PREPARE_STEP_SUCCESS = null;
    private final int value;

    static {
        PkmPrepareStep r100 = new PkmPrepareStep("VAR_PKM_PREPARE_STEP_LOAD_META_START", 0, 0);
        VAR_PKM_PREPARE_STEP_LOAD_META_START = r100;
        PkmPrepareStep r101 = new PkmPrepareStep("VAR_PKM_PREPARE_STEP_LOAD_META_PROGRESS", 1, 1);
        VAR_PKM_PREPARE_STEP_LOAD_META_PROGRESS = r101;
        PkmPrepareStep r102 = new PkmPrepareStep("VAR_PKM_PREPARE_STEP_LOAD_META_COMPLETE", 2, 2);
        VAR_PKM_PREPARE_STEP_LOAD_META_COMPLETE = r102;
        PkmPrepareStep r103 = new PkmPrepareStep("VAR_PKM_PREPARE_STEP_LOAD_PKG_START", 3, 3);
        VAR_PKM_PREPARE_STEP_LOAD_PKG_START = r103;
        PkmPrepareStep r104 = new PkmPrepareStep("VAR_PKM_PREPARE_STEP_LOAD_PKG_PROGRESS", 4, 4);
        VAR_PKM_PREPARE_STEP_LOAD_PKG_PROGRESS = r104;
        PkmPrepareStep r105 = new PkmPrepareStep("VAR_PKM_PREPARE_STEP_LOAD_PKG_READY", 5, 5);
        VAR_PKM_PREPARE_STEP_LOAD_PKG_READY = r105;
        PkmPrepareStep r110 = new PkmPrepareStep("VAR_PKM_PREPARE_STEP_LOAD_PKG_COMPLETE", 6, 6);
        VAR_PKM_PREPARE_STEP_LOAD_PKG_COMPLETE = r110;
        PkmPrepareStep r111 = new PkmPrepareStep("VAR_PKM_PREPARE_STEP_META_FAILED", 7, 7);
        VAR_PKM_PREPARE_STEP_META_FAILED = r111;
        PkmPrepareStep r112 = new PkmPrepareStep("VAR_PKM_PREPARE_STEP_PKG_FAILED", 8, 8);
        VAR_PKM_PREPARE_STEP_PKG_FAILED = r112;
        PkmPrepareStep r113 = new PkmPrepareStep("VAR_PKM_PREPARE_STEP_SUCCESS", 9, 9);
        VAR_PKM_PREPARE_STEP_SUCCESS = r113;
        $VALUES = new PkmPrepareStep[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        ADAPTER = ProtoAdapter.newEnumAdapter(PkmPrepareStep.class);
    }

    public static PkmPrepareStep[] values() {
        return (PkmPrepareStep[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static PkmPrepareStep fromValue(int r100) {
        switch(r100) {
            case 0: goto L24;
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return VAR_PKM_PREPARE_STEP_SUCCESS;
    L8:
        return VAR_PKM_PREPARE_STEP_PKG_FAILED;
    L10:
        return VAR_PKM_PREPARE_STEP_META_FAILED;
    L12:
        return VAR_PKM_PREPARE_STEP_LOAD_PKG_COMPLETE;
    L14:
        return VAR_PKM_PREPARE_STEP_LOAD_PKG_READY;
    L16:
        return VAR_PKM_PREPARE_STEP_LOAD_PKG_PROGRESS;
    L18:
        return VAR_PKM_PREPARE_STEP_LOAD_PKG_START;
    L20:
        return VAR_PKM_PREPARE_STEP_LOAD_META_COMPLETE;
    L22:
        return VAR_PKM_PREPARE_STEP_LOAD_META_PROGRESS;
    L24:
        return VAR_PKM_PREPARE_STEP_LOAD_META_START;
    }

    public static PkmPrepareStep valueOf(String r100) {
        return (PkmPrepareStep) a.a(PkmPrepareStep.class, r100);
    }

    private PkmPrepareStep(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
