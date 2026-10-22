package com.larus.avlink.simulInterpret.page.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/model/TextType;", "", "<init>", "(Ljava/lang/String;I)V", "ORIGINAL", "TRANSLATION", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum TextType extends Enum<TextType> {
    public static final TextType ORIGINAL = null;
    public static final TextType TRANSLATION = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ TextType[] f294489a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f294490b = null;

    public static EnumEntries<TextType> getEntries() {
        return f294490b;
    }

    static {
        TextType r100 = new TextType("ORIGINAL", 0);
        ORIGINAL = r100;
        TextType r101 = new TextType("TRANSLATION", 1);
        TRANSLATION = r101;
        TextType[] r102 = {r100, r101};
        f294489a = r102;
        f294490b = EnumEntriesKt.enumEntries(r102);
    }

    public static TextType[] values() {
        return (TextType[]) f294489a.clone();
    }

    public static TextType valueOf(String r100) {
        return (TextType) r27.a.a(TextType.class, r100);
    }

    public TextType(String r100, int r101) {
        super(r100, r101);
    }
}
