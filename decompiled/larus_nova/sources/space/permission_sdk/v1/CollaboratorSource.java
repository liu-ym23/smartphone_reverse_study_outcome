package space.permission_sdk.v1;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum CollaboratorSource extends Enum<CollaboratorSource> implements WireEnum {
    private static final /* synthetic */ CollaboratorSource[] $VALUES = null;
    public static final ProtoAdapter<CollaboratorSource> ADAPTER = null;
    public static final CollaboratorSource container = null;
    public static final CollaboratorSource default_source = null;
    public static final CollaboratorSource single_page = null;
    private final int value;

    static {
        CollaboratorSource r100 = new CollaboratorSource("default_source", 0, 0);
        default_source = r100;
        CollaboratorSource r101 = new CollaboratorSource(KtvSubElement.CONTAINER, 1, 1);
        container = r101;
        CollaboratorSource r102 = new CollaboratorSource("single_page", 2, 2);
        single_page = r102;
        $VALUES = new CollaboratorSource[]{r100, r101, r102};
        ADAPTER = ProtoAdapter.newEnumAdapter(CollaboratorSource.class);
    }

    public static CollaboratorSource[] values() {
        return (CollaboratorSource[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static CollaboratorSource fromValue(int r100) {
        if (r100 == 0) goto L14;
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L10;
        return null;
    L10:
        return single_page;
    L12:
        return container;
    L14:
        return default_source;
    }

    public static CollaboratorSource valueOf(String r100) {
        return (CollaboratorSource) a.a(CollaboratorSource.class, r100);
    }

    private CollaboratorSource(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
