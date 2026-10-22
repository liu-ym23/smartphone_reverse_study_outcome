package com.larus.bmhome.chat.list.cell.text;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/list/cell/text/TextCellCutType;", "", "cutType", "", "<init>", "(Ljava/lang/String;II)V", "getCutType", "()I", "NewTextCell", "NewCutThreeTextCell", "DeepThinkCutMultipleCell", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TextCellCutType extends Enum<TextCellCutType> {
    public static final a Companion = null;
    public static final TextCellCutType DeepThinkCutMultipleCell = null;
    public static final TextCellCutType NewCutThreeTextCell = null;
    public static final TextCellCutType NewTextCell = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TextCellCutType[] f306005a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f306006b = null;
    private final int cutType;

    public static final class a {
        public a() {
        }

        public static TextCellCutType a(int r100) {
            TextCellCutType[] r101 = TextCellCutType.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L11;
            TextCellCutType r104 = r101[r103];
            if (r104.getCutType() != r100) goto L7;
            boolean r105 = true;
        L8:
            if (r105 == true) goto L12;
            r103 = r103 + 1;
        L12:
            if (r104 == null) goto L14;
            return r104;
        L14:
            return TextCellCutType.NewTextCell;
        L7:
            r105 = false;
            goto L8
        L11:
            r104 = null;
            goto L12
        }
    }

    public static EnumEntries<TextCellCutType> getEntries() {
        return f306006b;
    }

    static {
        TextCellCutType r100 = new TextCellCutType("NewTextCell", 0, 1);
        NewTextCell = r100;
        TextCellCutType r101 = new TextCellCutType("NewCutThreeTextCell", 1, 2);
        NewCutThreeTextCell = r101;
        TextCellCutType r102 = new TextCellCutType("DeepThinkCutMultipleCell", 2, 3);
        DeepThinkCutMultipleCell = r102;
        TextCellCutType[] r103 = {r100, r101, r102};
        f306005a = r103;
        f306006b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static TextCellCutType[] values() {
        return (TextCellCutType[]) f306005a.clone();
    }

    public final int getCutType() {
        return this.cutType;
    }

    public static TextCellCutType valueOf(String r100) {
        return (TextCellCutType) r27.a.a(TextCellCutType.class, r100);
    }

    public TextCellCutType(String r100, int r101, int r102) {
        super(r100, r101);
        this.cutType = r102;
    }
}
