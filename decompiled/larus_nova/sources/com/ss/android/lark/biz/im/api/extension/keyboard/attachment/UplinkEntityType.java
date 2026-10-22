package com.ss.android.lark.biz.im.api.extension.keyboard.attachment;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\f"}, d2 = {"Lcom/ss/android/lark/biz/im/api/extension/keyboard/attachment/UplinkEntityType;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "EntityTypeUnknown", "EntityTypeFile", "EntityTypeImage", "Companion", "im-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UplinkEntityType extends Enum<UplinkEntityType> {
    public static final a Companion = null;
    public static final UplinkEntityType EntityTypeFile = null;
    public static final UplinkEntityType EntityTypeImage = null;
    public static final UplinkEntityType EntityTypeUnknown = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UplinkEntityType[] f410138a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f410139b = null;
    private final int value;

    public static EnumEntries<UplinkEntityType> getEntries() {
        return f410139b;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkEntityType$a] */
    static {
        UplinkEntityType r100 = new UplinkEntityType("EntityTypeUnknown", 0, 0);
        EntityTypeUnknown = r100;
        UplinkEntityType r101 = new UplinkEntityType("EntityTypeFile", 1, 1);
        EntityTypeFile = r101;
        UplinkEntityType r102 = new UplinkEntityType("EntityTypeImage", 2, 2);
        EntityTypeImage = r102;
        UplinkEntityType[] r103 = {r100, r101, r102};
        f410138a = r103;
        f410139b = EnumEntriesKt.enumEntries(r103);
        Companion = new a();
    }

    public static UplinkEntityType[] values() {
        return (UplinkEntityType[]) f410138a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static UplinkEntityType valueOf(String r100) {
        return (UplinkEntityType) r27.a.a(UplinkEntityType.class, r100);
    }

    public UplinkEntityType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
