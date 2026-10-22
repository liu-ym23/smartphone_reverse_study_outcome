package com.larus.livetutor.api.idl;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0087\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/livetutor/api/idl/TextAction;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Append", "Overwrite", "End", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TextAction extends Enum<TextAction> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ TextAction[] $VALUES = null;

    @SerializedName("1")
    public static final TextAction Append = null;
    public static final a Companion = null;

    @SerializedName("3")
    public static final TextAction End = null;

    @SerializedName("2")
    public static final TextAction Overwrite = null;
    private final int value;

    public static final class a {
        public a() {
        }
    }

    private static final /* synthetic */ TextAction[] $values() {
        return new TextAction[]{Append, Overwrite, End};
    }

    public static EnumEntries<TextAction> getEntries() {
        return $ENTRIES;
    }

    static {
        Append = new TextAction("Append", 0, 1);
        Overwrite = new TextAction("Overwrite", 1, 2);
        End = new TextAction("End", 2, 3);
        TextAction[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new a();
    }

    public static TextAction[] values() {
        return (TextAction[]) $VALUES.clone();
    }

    public final int getValue() {
        return this.value;
    }

    @JvmStatic
    public static final TextAction findByValue(int r100) {
        Companion.getClass();
        if (r100 == 1) goto L12;
        if (r100 == 2) goto L15;
        if (r100 == 3) goto L14;
        return null;
    L14:
        return End;
    L15:
        return Overwrite;
    L12:
        return Append;
    }

    public static TextAction valueOf(String r100) {
        return (TextAction) r27.a.a(TextAction.class, r100);
    }

    private TextAction(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
