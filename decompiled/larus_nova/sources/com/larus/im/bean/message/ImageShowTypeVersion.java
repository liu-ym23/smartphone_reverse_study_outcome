package com.larus.im.bean.message;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/larus/im/bean/message/ImageShowTypeVersion;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "UNSPECIFIED", "DEFAULT", "MULTI", "core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum ImageShowTypeVersion extends Enum<ImageShowTypeVersion> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ ImageShowTypeVersion[] $VALUES = null;
    public static final ImageShowTypeVersion DEFAULT = null;
    public static final ImageShowTypeVersion MULTI = null;
    public static final ImageShowTypeVersion UNSPECIFIED = null;
    public final int value;

    private static final /* synthetic */ ImageShowTypeVersion[] $values() {
        return new ImageShowTypeVersion[]{UNSPECIFIED, DEFAULT, MULTI};
    }

    public static EnumEntries<ImageShowTypeVersion> getEntries() {
        return $ENTRIES;
    }

    static {
        UNSPECIFIED = new ImageShowTypeVersion("UNSPECIFIED", 0, 0);
        DEFAULT = new ImageShowTypeVersion("DEFAULT", 1, 1);
        MULTI = new ImageShowTypeVersion("MULTI", 2, 2);
        ImageShowTypeVersion[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
    }

    public static ImageShowTypeVersion[] values() {
        return (ImageShowTypeVersion[]) $VALUES.clone();
    }

    public static ImageShowTypeVersion valueOf(String r100) {
        return (ImageShowTypeVersion) r27.a.a(ImageShowTypeVersion.class, r100);
    }

    private ImageShowTypeVersion(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
