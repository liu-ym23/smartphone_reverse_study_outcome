package com.larus.livetutor.api.idl;

import com.android.ttcjpaysdk.outer.pay.view.OuterPayLoginWrapper;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/livetutor/api/idl/WaitStrategyType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", OuterPayLoginWrapper.LOGIN_STYLE_V1, "V2", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum WaitStrategyType extends Enum<WaitStrategyType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ WaitStrategyType[] $VALUES = null;
    public static final a Companion = null;

    @SerializedName("0")
    public static final WaitStrategyType Unknown = null;

    @SerializedName("1")
    public static final WaitStrategyType V1 = null;

    @SerializedName("2")
    public static final WaitStrategyType V2 = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ WaitStrategyType[] $values() {
        return new WaitStrategyType[]{Unknown, V1, V2};
    }

    public static EnumEntries<WaitStrategyType> getEntries() {
        return $ENTRIES;
    }

    static {
        Unknown = new WaitStrategyType("Unknown", 0, 0);
        V1 = new WaitStrategyType(OuterPayLoginWrapper.LOGIN_STYLE_V1, 1, 1);
        V2 = new WaitStrategyType("V2", 2, 2);
        WaitStrategyType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static WaitStrategyType[] values() {
        return (WaitStrategyType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final WaitStrategyType findByValue(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L12;
        if (r100 == 1) goto L15;
        if (r100 == 2) goto L14;
        return null;
    L14:
        return V2;
    L15:
        return V1;
    L12:
        return Unknown;
    }

    public static WaitStrategyType valueOf(String r100) {
        return (WaitStrategyType) r27.a.a(WaitStrategyType.class, r100);
    }

    private WaitStrategyType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
