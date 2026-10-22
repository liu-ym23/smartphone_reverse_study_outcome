package open_pkm.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum LoadStatus extends Enum<LoadStatus> implements WireEnum {
    private static final /* synthetic */ LoadStatus[] $VALUES = null;
    public static final ProtoAdapter<LoadStatus> ADAPTER = null;
    public static final LoadStatus VAR_LOAD_STATUS_DOWNLOADING = null;
    public static final LoadStatus VAR_LOAD_STATUS_FINISHED = null;
    public static final LoadStatus VAR_LOAD_STATUS_INITIAL = null;
    private final int value;

    static {
        LoadStatus r100 = new LoadStatus("VAR_LOAD_STATUS_INITIAL", 0, 0);
        VAR_LOAD_STATUS_INITIAL = r100;
        LoadStatus r101 = new LoadStatus("VAR_LOAD_STATUS_DOWNLOADING", 1, 1);
        VAR_LOAD_STATUS_DOWNLOADING = r101;
        LoadStatus r102 = new LoadStatus("VAR_LOAD_STATUS_FINISHED", 2, 2);
        VAR_LOAD_STATUS_FINISHED = r102;
        $VALUES = new LoadStatus[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(LoadStatus.class);
    }

    public static LoadStatus[] values() {
        return (LoadStatus[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static LoadStatus fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return VAR_LOAD_STATUS_FINISHED;
    L12:
        return VAR_LOAD_STATUS_DOWNLOADING;
    L14:
        return VAR_LOAD_STATUS_INITIAL;
    }

    public static LoadStatus valueOf(String r100) {
        return (LoadStatus) a.a(LoadStatus.class, r100);
    }

    private LoadStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
