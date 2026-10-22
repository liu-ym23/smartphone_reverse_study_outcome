package com.ss.android.lark.security.compliance.api.model.filepolicy;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/ss/android/lark/security/compliance/api/model/filepolicy/InteractionType;", "", "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "HIDDEN", "security-compliance-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum InteractionType extends Enum<InteractionType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ InteractionType[] $VALUES = null;

    @SerializedName("DEFAULT")
    public static final InteractionType DEFAULT = null;

    @SerializedName("HIDDEN")
    public static final InteractionType HIDDEN = null;

    private static final /* synthetic */ InteractionType[] $values() {
        return new InteractionType[]{DEFAULT, HIDDEN};
    }

    public static EnumEntries<InteractionType> getEntries() {
        return $ENTRIES;
    }

    static {
        DEFAULT = new InteractionType("DEFAULT", 0);
        HIDDEN = new InteractionType("HIDDEN", 1);
        InteractionType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static InteractionType[] values() {
        return (InteractionType[]) $VALUES.clone();
    }

    public static InteractionType valueOf(String r100) {
        return (InteractionType) r27.a.a(InteractionType.class, r100);
    }

    private InteractionType(String r100, int r101) {
        super(r100, r101);
    }
}
