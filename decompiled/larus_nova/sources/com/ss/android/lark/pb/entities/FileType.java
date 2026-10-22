package com.ss.android.lark.pb.entities;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
public final enum FileType extends Enum<FileType> implements WireEnum {
    private static final /* synthetic */ FileType[] $VALUES = null;
    public static final ProtoAdapter<FileType> ADAPTER = null;
    public static final FileType FILE_AUDIO = null;
    public static final FileType FILE_IMAGE = null;
    public static final FileType FILE_OTHER = null;
    public static final FileType FILE_PDF = null;
    public static final FileType FILE_VIDEO = null;
    private final int value;

    static {
        FileType r100 = new FileType("FILE_VIDEO", 0, 1);
        FILE_VIDEO = r100;
        FileType r101 = new FileType("FILE_AUDIO", 1, 2);
        FILE_AUDIO = r101;
        FileType r102 = new FileType("FILE_IMAGE", 2, 3);
        FILE_IMAGE = r102;
        FileType r103 = new FileType("FILE_PDF", 3, 4);
        FILE_PDF = r103;
        FileType r104 = new FileType("FILE_OTHER", 4, 99);
        FILE_OTHER = r104;
        $VALUES = new FileType[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(FileType.class);
    }

    public static FileType[] values() {
        return (FileType[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FileType fromValue(int r100) {
        if (r100 == 1) goto L23;
        if (r100 == 2) goto L21;
        if (r100 == 3) goto L19;
        if (r100 == 4) goto L17;
        if (r100 == 99) goto L15;
        return null;
    L15:
        return FILE_OTHER;
    L17:
        return FILE_PDF;
    L19:
        return FILE_IMAGE;
    L21:
        return FILE_AUDIO;
    L23:
        return FILE_VIDEO;
    }

    public static FileType valueOf(String r100) {
        return (FileType) a.a(FileType.class, r100);
    }

    private FileType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
