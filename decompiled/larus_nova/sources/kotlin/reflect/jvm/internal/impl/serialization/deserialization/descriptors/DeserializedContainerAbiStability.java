package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes5.dex */
public final enum DeserializedContainerAbiStability extends Enum<DeserializedContainerAbiStability> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DeserializedContainerAbiStability[] $VALUES = null;
    public static final DeserializedContainerAbiStability STABLE = null;
    public static final DeserializedContainerAbiStability UNSTABLE = null;

    private static final /* synthetic */ DeserializedContainerAbiStability[] $values() {
        return new DeserializedContainerAbiStability[]{STABLE, UNSTABLE};
    }

    static {
        STABLE = new DeserializedContainerAbiStability("STABLE", 0);
        UNSTABLE = new DeserializedContainerAbiStability("UNSTABLE", 1);
        DeserializedContainerAbiStability[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static DeserializedContainerAbiStability[] values() {
        return (DeserializedContainerAbiStability[]) $VALUES.clone();
    }

    public static DeserializedContainerAbiStability valueOf(String r100) {
        return (DeserializedContainerAbiStability) a.a(DeserializedContainerAbiStability.class, r100);
    }

    private DeserializedContainerAbiStability(String r100, int r101) {
        super(r100, r101);
    }
}
