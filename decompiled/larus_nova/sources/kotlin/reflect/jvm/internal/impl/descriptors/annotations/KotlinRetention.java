package kotlin.reflect.jvm.internal.impl.descriptors.annotations;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum KotlinRetention extends Enum<KotlinRetention> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ KotlinRetention[] $VALUES = null;
    public static final KotlinRetention BINARY = null;
    public static final KotlinRetention RUNTIME = null;
    public static final KotlinRetention SOURCE = null;

    private static final /* synthetic */ KotlinRetention[] $values() {
        return new KotlinRetention[]{RUNTIME, BINARY, SOURCE};
    }

    static {
        RUNTIME = new KotlinRetention("RUNTIME", 0);
        BINARY = new KotlinRetention("BINARY", 1);
        SOURCE = new KotlinRetention("SOURCE", 2);
        KotlinRetention[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static KotlinRetention[] values() {
        return (KotlinRetention[]) $VALUES.clone();
    }

    public static KotlinRetention valueOf(String r100) {
        return (KotlinRetention) a.a(KotlinRetention.class, r100);
    }

    private KotlinRetention(String r100, int r101) {
        super(r100, r101);
    }
}
