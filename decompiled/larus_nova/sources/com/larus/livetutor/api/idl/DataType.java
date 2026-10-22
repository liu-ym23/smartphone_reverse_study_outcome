package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0087\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lcom/larus/livetutor/api/idl/DataType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Text", "Image", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum DataType extends Enum<DataType> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ DataType[] $VALUES = null;
    public static final a Companion = null;

    @SerializedName("1")
    public static final DataType Image = null;

    @SerializedName("0")
    public static final DataType Text = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ DataType[] $values() {
        return new DataType[]{Text, Image};
    }

    public static EnumEntries<DataType> getEntries() {
        return $ENTRIES;
    }

    static {
        Text = new DataType("Text", 0, 0);
        Image = new DataType("Image", 1, 1);
        DataType[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static DataType[] values() {
        return (DataType[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final DataType findByValue(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L9;
        if (r100 == 1) goto L11;
        return null;
    L11:
        return Image;
    L9:
        return Text;
    }

    public static DataType valueOf(String r100) {
        return (DataType) r27.a.a(DataType.class, r100);
    }

    private DataType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
