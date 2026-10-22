package im.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum EntityType extends Enum<EntityType> implements WireEnum {
    private static final /* synthetic */ EntityType[] $VALUES = null;
    public static final ProtoAdapter<EntityType> ADAPTER = null;
    public static final EntityType ENTITY_TYPE_DEFAULT = null;
    public static final EntityType ENTITY_TYPE_DOC = null;
    public static final EntityType ENTITY_TYPE_MESSAGE = null;
    public static final EntityType ENTITY_TYPE_WIKI = null;
    private final int value;

    static {
        EntityType r100 = new EntityType("ENTITY_TYPE_DEFAULT", 0, 0);
        ENTITY_TYPE_DEFAULT = r100;
        EntityType r101 = new EntityType("ENTITY_TYPE_DOC", 1, 1);
        ENTITY_TYPE_DOC = r101;
        EntityType r102 = new EntityType("ENTITY_TYPE_WIKI", 2, 2);
        ENTITY_TYPE_WIKI = r102;
        EntityType r103 = new EntityType("ENTITY_TYPE_MESSAGE", 3, 3);
        ENTITY_TYPE_MESSAGE = r103;
        $VALUES = new EntityType[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(EntityType.class);
    }

    public static EntityType[] values() {
        return (EntityType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static EntityType fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return ENTITY_TYPE_MESSAGE;
    L14:
        return ENTITY_TYPE_WIKI;
    L16:
        return ENTITY_TYPE_DOC;
    L18:
        return ENTITY_TYPE_DEFAULT;
    }

    public static EntityType valueOf(String r100) {
        return (EntityType) a.a(EntityType.class, r100);
    }

    private EntityType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
