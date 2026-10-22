package space.permission_sdk.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes41.dex */
public final enum EntityDomain extends Enum<EntityDomain> implements WireEnum {
    private static final /* synthetic */ EntityDomain[] $VALUES = null;
    public static final ProtoAdapter<EntityDomain> ADAPTER = null;
    public static final EntityDomain ED_CALENDAR = null;
    public static final EntityDomain ED_CCM = null;
    public static final EntityDomain ED_IM = null;
    public static final EntityDomain ED_MAIL = null;
    public static final EntityDomain ED_ORM = null;
    public static final EntityDomain ED_PASSPORT = null;
    public static final EntityDomain ED_TODO = null;
    public static final EntityDomain ED_UNKNOW = null;
    public static final EntityDomain ED_VC = null;
    private final int value;

    static {
        EntityDomain r100 = new EntityDomain("ED_UNKNOW", 0, 0);
        ED_UNKNOW = r100;
        EntityDomain r101 = new EntityDomain("ED_CCM", 1, 1);
        ED_CCM = r101;
        EntityDomain r102 = new EntityDomain("ED_IM", 2, 2);
        ED_IM = r102;
        EntityDomain r103 = new EntityDomain("ED_MAIL", 3, 3);
        ED_MAIL = r103;
        EntityDomain r104 = new EntityDomain("ED_VC", 4, 4);
        ED_VC = r104;
        EntityDomain r105 = new EntityDomain("ED_TODO", 5, 5);
        ED_TODO = r105;
        EntityDomain r110 = new EntityDomain("ED_CALENDAR", 6, 6);
        ED_CALENDAR = r110;
        EntityDomain r111 = new EntityDomain("ED_PASSPORT", 7, 7);
        ED_PASSPORT = r111;
        EntityDomain r112 = new EntityDomain("ED_ORM", 8, 8);
        ED_ORM = r112;
        $VALUES = new EntityDomain[]{r100, r101, r102, r103, r104, r105, r110, r111, r112};
        ADAPTER = ProtoAdapter.newEnumAdapter(EntityDomain.class);
    }

    public static EntityDomain[] values() {
        return (EntityDomain[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static EntityDomain fromValue(int r100) {
        switch(r100) {
            case 0: goto L22;
            case 1: goto L20;
            case 2: goto L18;
            case 3: goto L16;
            case 4: goto L14;
            case 5: goto L12;
            case 6: goto L10;
            case 7: goto L8;
            case 8: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return ED_ORM;
    L8:
        return ED_PASSPORT;
    L10:
        return ED_CALENDAR;
    L12:
        return ED_TODO;
    L14:
        return ED_VC;
    L16:
        return ED_MAIL;
    L18:
        return ED_IM;
    L20:
        return ED_CCM;
    L22:
        return ED_UNKNOW;
    }

    public static EntityDomain valueOf(String r100) {
        return (EntityDomain) a.a(EntityDomain.class, r100);
    }

    private EntityDomain(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
