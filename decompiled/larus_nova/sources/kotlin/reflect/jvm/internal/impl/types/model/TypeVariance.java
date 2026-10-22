package kotlin.reflect.jvm.internal.impl.types.model;

import com.byted.cast.linkcommon.cybergarage.upnp.Argument;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum TypeVariance extends Enum<TypeVariance> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TypeVariance[] $VALUES = null;
    public static final TypeVariance IN = null;
    public static final TypeVariance INV = null;
    public static final TypeVariance OUT = null;
    private final String presentation;

    private static final /* synthetic */ TypeVariance[] $values() {
        return new TypeVariance[]{IN, OUT, INV};
    }

    static {
        IN = new TypeVariance("IN", 0, "in");
        OUT = new TypeVariance("OUT", 1, Argument.OUT);
        INV = new TypeVariance("INV", 2, "");
        TypeVariance[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static TypeVariance[] values() {
        return (TypeVariance[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.presentation;
    }

    public static TypeVariance valueOf(String r100) {
        return (TypeVariance) a.a(TypeVariance.class, r100);
    }

    private TypeVariance(String r100, int r101, String r102) {
        super(r100, r101);
        this.presentation = r102;
    }
}
