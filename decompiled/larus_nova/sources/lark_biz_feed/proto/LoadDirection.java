package lark_biz_feed.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum LoadDirection extends Enum<LoadDirection> implements WireEnum {
    private static final /* synthetic */ LoadDirection[] $VALUES = null;
    public static final ProtoAdapter<LoadDirection> ADAPTER = null;
    public static final LoadDirection VAR_LOAD_DIRECTION_NEXT = null;
    public static final LoadDirection VAR_LOAD_DIRECTION_PREVIOUS = null;
    private final int value;

    static {
        LoadDirection r100 = new LoadDirection("VAR_LOAD_DIRECTION_NEXT", 0, 0);
        VAR_LOAD_DIRECTION_NEXT = r100;
        LoadDirection r101 = new LoadDirection("VAR_LOAD_DIRECTION_PREVIOUS", 1, 1);
        VAR_LOAD_DIRECTION_PREVIOUS = r101;
        $VALUES = new LoadDirection[]{r100, r101};
        ADAPTER = ProtoAdapter.newEnumAdapter(LoadDirection.class);
    }

    public static LoadDirection[] values() {
        return (LoadDirection[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static LoadDirection fromValue(int r100) {
        if (r100 == 0) goto L10;
        if (r100 == 1) goto L8;
        return null;
    L8:
        return VAR_LOAD_DIRECTION_PREVIOUS;
    L10:
        return VAR_LOAD_DIRECTION_NEXT;
    }

    public static LoadDirection valueOf(String r100) {
        return (LoadDirection) a.a(LoadDirection.class, r100);
    }

    private LoadDirection(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
