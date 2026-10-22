package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0087\u0081\u0002\u0018\u0000 \f2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\r"}, d2 = {"Lcom/larus/livetutor/api/idl/LiveTutorQueryType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Unknown", "Text", "FixedQuery", "Image", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum LiveTutorQueryType extends Enum<LiveTutorQueryType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ LiveTutorQueryType[] $VALUES = null;
    public static final a Companion = null;

    @SerializedName("2")
    public static final LiveTutorQueryType FixedQuery = null;

    @SerializedName("3")
    public static final LiveTutorQueryType Image = null;

    @SerializedName("1")
    public static final LiveTutorQueryType Text = null;

    @SerializedName("0")
    public static final LiveTutorQueryType Unknown = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ LiveTutorQueryType[] $values() {
        return new LiveTutorQueryType[]{Unknown, Text, FixedQuery, Image};
    }

    public static EnumEntries<LiveTutorQueryType> getEntries() {
        return $ENTRIES;
    }

    static {
        Unknown = new LiveTutorQueryType("Unknown", 0, 0);
        Text = new LiveTutorQueryType("Text", 1, 1);
        FixedQuery = new LiveTutorQueryType("FixedQuery", 2, 2);
        Image = new LiveTutorQueryType("Image", 3, 3);
        LiveTutorQueryType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static LiveTutorQueryType[] values() {
        return (LiveTutorQueryType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final LiveTutorQueryType findByValue(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L15;
        if (r100 == 1) goto L19;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L17;
        return null;
    L17:
        return Image;
    L18:
        return FixedQuery;
    L19:
        return Text;
    L15:
        return Unknown;
    }

    public static LiveTutorQueryType valueOf(String r100) {
        return (LiveTutorQueryType) r27.a.a(LiveTutorQueryType.class, r100);
    }

    private LiveTutorQueryType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
