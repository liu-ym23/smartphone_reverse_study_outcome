package open_pkm.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum PkmFrom extends Enum<PkmFrom> implements WireEnum {
    private static final /* synthetic */ PkmFrom[] $VALUES = null;
    public static final ProtoAdapter<PkmFrom> ADAPTER = null;
    public static final PkmFrom VAR_PKM_FROM_ASYNC = null;
    public static final PkmFrom VAR_PKM_FROM_BUILTIN = null;
    public static final PkmFrom VAR_PKM_FROM_NORMAL = null;
    public static final PkmFrom VAR_PKM_FROM_PRELOAD = null;
    private final int value;

    static {
        PkmFrom r100 = new PkmFrom("VAR_PKM_FROM_NORMAL", 0, 0);
        VAR_PKM_FROM_NORMAL = r100;
        PkmFrom r101 = new PkmFrom("VAR_PKM_FROM_ASYNC", 1, 1);
        VAR_PKM_FROM_ASYNC = r101;
        PkmFrom r102 = new PkmFrom("VAR_PKM_FROM_PRELOAD", 2, 2);
        VAR_PKM_FROM_PRELOAD = r102;
        PkmFrom r103 = new PkmFrom("VAR_PKM_FROM_BUILTIN", 3, 3);
        VAR_PKM_FROM_BUILTIN = r103;
        $VALUES = new PkmFrom[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(PkmFrom.class);
    }

    public static PkmFrom[] values() {
        return (PkmFrom[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static PkmFrom fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return VAR_PKM_FROM_BUILTIN;
    L14:
        return VAR_PKM_FROM_PRELOAD;
    L16:
        return VAR_PKM_FROM_ASYNC;
    L18:
        return VAR_PKM_FROM_NORMAL;
    }

    public static PkmFrom valueOf(String r100) {
        return (PkmFrom) a.a(PkmFrom.class, r100);
    }

    private PkmFrom(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
