package com.ss.android.lark.feed.molten.serializer;

import com.google.gson.JsonObject;
import com.ss.android.lark.feed.app.entity.DigestElement;
import com.ss.android.lark.feed.app.entity.EmojiProperty;
import com.ss.android.lark.feed.app.entity.TextProperty;
import com.ss.android.lark.feed.app.entity.TextWithEmojiProperty;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/DigestElementTypeAdapter;", "Lcom/ss/android/lark/feed/molten/serializer/JsonTreeTypeAdapter;", "Lcom/ss/android/lark/feed/app/entity/DigestElement;", "<init>", "()V", "writeJsonObject", "Lcom/google/gson/JsonObject;", "value", "readJsonObject", "json", "Kind", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DigestElementTypeAdapter extends JsonTreeTypeAdapter<DigestElement> {

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/feed/molten/serializer/DigestElementTypeAdapter$Kind;", "", "value", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "TEXT_PROPERTY", "EMOJI_PROPERTY", "TEXT_WITH_EMOJI_PROPERTY", "feed-molten_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Kind extends Enum<Kind> {
        public static final Kind EMOJI_PROPERTY = null;
        public static final Kind TEXT_PROPERTY = null;
        public static final Kind TEXT_WITH_EMOJI_PROPERTY = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Kind[] f421075a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f421076b = null;
        private final String value;

        public static EnumEntries<Kind> getEntries() {
            return f421076b;
        }

        static {
            Kind r100 = new Kind("TEXT_PROPERTY", 0, "TextProperty");
            TEXT_PROPERTY = r100;
            Kind r101 = new Kind("EMOJI_PROPERTY", 1, "EmojiProperty");
            EMOJI_PROPERTY = r101;
            Kind r102 = new Kind("TEXT_WITH_EMOJI_PROPERTY", 2, "TextWithEmojiProperty");
            TEXT_WITH_EMOJI_PROPERTY = r102;
            Kind[] r103 = {r100, r101, r102};
            f421075a = r103;
            f421076b = EnumEntriesKt.enumEntries(r103);
        }

        public static Kind[] values() {
            return (Kind[]) f421075a.clone();
        }

        public final String getValue() {
            return this.value;
        }

        public static Kind valueOf(String r100) {
            return (Kind) r27.a.a(Kind.class, r100);
        }

        public Kind(String r100, int r101, String r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    public DigestElementTypeAdapter() {
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final DigestElement a(JsonObject r100) {
        Intrinsics.checkNotNullParameter(r100, "json");
        String r101 = a.l(r100, "type");
        String r102 = "";
        if (Intrinsics.areEqual(r101, Kind.TEXT_PROPERTY.getValue()) == false) goto L10;
        String r103 = a.l(r100, "content");
        if (r103 == null) goto L8;
        r102 = r103;
    L8:
        DigestElement r104 = new TextProperty(r102);
    L28:
        return r104;
    L10:
        if (Intrinsics.areEqual(r101, Kind.EMOJI_PROPERTY.getValue()) == false) goto L17;
        String r105 = a.l(r100, "emojiKey");
        if (r105 == null) goto L15;
        r102 = r105;
    L15:
        r104 = new EmojiProperty(r102, a.l(r100, "defaultContent"));
        goto L28
    L17:
        if (Intrinsics.areEqual(r101, Kind.TEXT_WITH_EMOJI_PROPERTY.getValue()) == false) goto L23;
        String r106 = a.l(r100, "content");
        if (r106 == null) goto L22;
        r102 = r106;
    L22:
        r104 = new TextWithEmojiProperty(r102);
        goto L28
    L23:
        String r107 = a.l(r100, "content");
        if (r107 == null) goto L27;
        r102 = r107;
    L27:
        r104 = new TextProperty(r102);
        goto L28
    }

    @Override // com.ss.android.lark.feed.molten.serializer.JsonTreeTypeAdapter
    public final JsonObject b(DigestElement r100) {
        DigestElement r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "value");
        JsonObject r102 = new JsonObject();
        if ((r101 instanceof TextProperty) == false) goto L6;
        a.j(r102, "type", Kind.TEXT_PROPERTY.getValue());
        a.j(r102, "content", ((TextProperty) r101).getContent());
    L11:
        return r102;
    L6:
        if ((r101 instanceof EmojiProperty) == false) goto L9;
        a.j(r102, "type", Kind.EMOJI_PROPERTY.getValue());
        EmojiProperty r103 = (EmojiProperty) r101;
        a.j(r102, "emojiKey", r103.getEmojiKey());
        a.j(r102, "defaultContent", r103.getDefaultContent());
        goto L11
    L9:
        if ((r101 instanceof TextWithEmojiProperty) == false) goto L13;
        a.j(r102, "type", Kind.TEXT_WITH_EMOJI_PROPERTY.getValue());
        a.j(r102, "content", ((TextWithEmojiProperty) r101).getContent());
        goto L11
    L13:
        throw new NoWhenBranchMatchedException();
    }
}
