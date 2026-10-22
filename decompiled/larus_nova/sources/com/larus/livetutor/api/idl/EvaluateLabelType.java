package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/livetutor/api/idl/EvaluateLabelType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "Common", "Custom", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum EvaluateLabelType extends Enum<EvaluateLabelType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ EvaluateLabelType[] $VALUES = null;

    @SerializedName("1")
    public static final EvaluateLabelType Common = null;
    public static final a Companion = null;

    @SerializedName("2")
    public static final EvaluateLabelType Custom = null;

    @SerializedName("0")
    public static final EvaluateLabelType Unknown = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ EvaluateLabelType[] $values() {
        return new EvaluateLabelType[]{Unknown, Common, Custom};
    }

    public static EnumEntries<EvaluateLabelType> getEntries() {
        return $ENTRIES;
    }

    static {
        Unknown = new EvaluateLabelType("Unknown", 0, 0);
        Common = new EvaluateLabelType("Common", 1, 1);
        Custom = new EvaluateLabelType("Custom", 2, 2);
        EvaluateLabelType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static EvaluateLabelType[] values() {
        return (EvaluateLabelType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final EvaluateLabelType findByValue(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L12;
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L14;
        return null;
    L14:
        return Custom;
    L15:
        return Common;
    L12:
        return Unknown;
    }

    public static EvaluateLabelType valueOf(String r100) {
        return (EvaluateLabelType) r27.a.a(EvaluateLabelType.class, r100);
    }

    private EvaluateLabelType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
