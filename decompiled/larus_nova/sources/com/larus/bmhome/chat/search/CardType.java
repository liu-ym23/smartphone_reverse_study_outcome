package com.larus.bmhome.chat.search;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/larus/bmhome/chat/search/CardType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "Unknown", "Text", "Video", "Image", "MixedMedia", "Companion", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum CardType extends Enum<CardType> {
    public static final a Companion = null;

    @SerializedName("3")
    public static final CardType Image = null;

    @SerializedName("4")
    public static final CardType MixedMedia = null;

    @SerializedName("1")
    public static final CardType Text = null;

    @SerializedName("0")
    public static final CardType Unknown = null;

    @SerializedName("2")
    public static final CardType Video = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ CardType[] f308597a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f308598b = null;
    public final int value;

    public static final class a {
        public a() {
        }

        public static CardType a(int r100) {
            if (r100 == 0) goto L17;
            if (r100 == 1) goto L22;
            if (r100 == 2) goto L21;
            if (r100 == 3) goto L20;
            if (r100 == 4) goto L19;
            return null;
        L19:
            return CardType.MixedMedia;
        L20:
            return CardType.Image;
        L21:
            return CardType.Video;
        L22:
            return CardType.Text;
        L17:
            return CardType.Unknown;
        }
    }

    public static EnumEntries<CardType> getEntries() {
        return f308598b;
    }

    static {
        CardType r100 = new CardType("Unknown", 0, 0);
        Unknown = r100;
        CardType r101 = new CardType("Text", 1, 1);
        Text = r101;
        CardType r102 = new CardType("Video", 2, 2);
        Video = r102;
        CardType r103 = new CardType("Image", 3, 3);
        Image = r103;
        CardType r104 = new CardType("MixedMedia", 4, 4);
        MixedMedia = r104;
        CardType[] r105 = {r100, r101, r102, r103, r104};
        f308597a = r105;
        f308598b = EnumEntriesKt.enumEntries(r105);
        Companion = new a();
    }

    public static CardType[] values() {
        return (CardType[]) f308597a.clone();
    }

    public static CardType valueOf(String r100) {
        return (CardType) r27.a.a(CardType.class, r100);
    }

    public CardType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
