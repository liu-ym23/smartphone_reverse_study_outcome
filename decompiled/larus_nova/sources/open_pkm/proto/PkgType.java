package open_pkm.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum PkgType extends Enum<PkgType> implements WireEnum {
    private static final /* synthetic */ PkgType[] $VALUES = null;
    public static final ProtoAdapter<PkgType> ADAPTER = null;
    public static final PkgType VAR_PKG_TYPE_COMMON = null;
    public static final PkgType VAR_PKG_TYPE_INDEPENDENT = null;
    public static final PkgType VAR_PKG_TYPE_MAIN = null;
    public static final PkgType VAR_PKG_TYPE_SUBPACKAGE = null;
    private final int value;

    static {
        PkgType r100 = new PkgType("VAR_PKG_TYPE_COMMON", 0, 0);
        VAR_PKG_TYPE_COMMON = r100;
        PkgType r101 = new PkgType("VAR_PKG_TYPE_MAIN", 1, 1);
        VAR_PKG_TYPE_MAIN = r101;
        PkgType r102 = new PkgType("VAR_PKG_TYPE_SUBPACKAGE", 2, 2);
        VAR_PKG_TYPE_SUBPACKAGE = r102;
        PkgType r103 = new PkgType("VAR_PKG_TYPE_INDEPENDENT", 3, 3);
        VAR_PKG_TYPE_INDEPENDENT = r103;
        $VALUES = new PkgType[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(PkgType.class);
    }

    public static PkgType[] values() {
        return (PkgType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static PkgType fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return VAR_PKG_TYPE_INDEPENDENT;
    L14:
        return VAR_PKG_TYPE_SUBPACKAGE;
    L16:
        return VAR_PKG_TYPE_MAIN;
    L18:
        return VAR_PKG_TYPE_COMMON;
    }

    public static PkgType valueOf(String r100) {
        return (PkgType) a.a(PkgType.class, r100);
    }

    private PkgType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
