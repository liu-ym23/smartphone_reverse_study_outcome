package open_pkm.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum PkmStrategy extends Enum<PkmStrategy> implements WireEnum {
    private static final /* synthetic */ PkmStrategy[] $VALUES = null;
    public static final ProtoAdapter<PkmStrategy> ADAPTER = null;
    public static final PkmStrategy VAR_PKM_STRATEGY_FORCE_REMOTE = null;
    public static final PkmStrategy VAR_PKM_STRATEGY_TRY_REMOTE_AND_UPDATE_ASYNC = null;
    public static final PkmStrategy VAR_PKM_STRATEGY_USE_LOCAL = null;
    private final int value;

    static {
        PkmStrategy r100 = new PkmStrategy("VAR_PKM_STRATEGY_TRY_REMOTE_AND_UPDATE_ASYNC", 0, 0);
        VAR_PKM_STRATEGY_TRY_REMOTE_AND_UPDATE_ASYNC = r100;
        PkmStrategy r101 = new PkmStrategy("VAR_PKM_STRATEGY_FORCE_REMOTE", 1, 1);
        VAR_PKM_STRATEGY_FORCE_REMOTE = r101;
        PkmStrategy r102 = new PkmStrategy("VAR_PKM_STRATEGY_USE_LOCAL", 2, 2);
        VAR_PKM_STRATEGY_USE_LOCAL = r102;
        $VALUES = new PkmStrategy[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(PkmStrategy.class);
    }

    public static PkmStrategy[] values() {
        return (PkmStrategy[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static PkmStrategy fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return VAR_PKM_STRATEGY_USE_LOCAL;
    L12:
        return VAR_PKM_STRATEGY_FORCE_REMOTE;
    L14:
        return VAR_PKM_STRATEGY_TRY_REMOTE_AND_UPDATE_ASYNC;
    }

    public static PkmStrategy valueOf(String r100) {
        return (PkmStrategy) a.a(PkmStrategy.class, r100);
    }

    private PkmStrategy(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
