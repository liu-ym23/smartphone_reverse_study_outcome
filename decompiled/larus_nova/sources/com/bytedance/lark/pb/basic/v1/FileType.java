package com.bytedance.lark.pb.basic.v1;

import com.bytedance.ee.bear.document.offline.sync.PreloadConfigModel;
import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum FileType extends Enum<FileType> implements WireEnum {
    private static final /* synthetic */ FileType[] $VALUES = null;
    public static final ProtoAdapter<FileType> ADAPTER = null;
    public static final FileType AI = null;
    public static final FileType DEFAULT = null;
    public static final FileType DOC = null;
    public static final FileType PDF = null;
    public static final FileType PPT = null;
    public static final FileType PSD = null;
    public static final FileType SKETCH = null;
    public static final FileType XLS = null;
    public static final FileType ZIP = null;
    private final int value;

    static {
        FileType r100 = new FileType("DEFAULT", 0, 1);
        DEFAULT = r100;
        FileType r101 = new FileType(PreloadConfigModel.VERSION_CHECK_TYPE_DOC, 1, 2);
        DOC = r101;
        FileType r102 = new FileType("PDF", 2, 3);
        PDF = r102;
        FileType r103 = new FileType("PPT", 3, 4);
        PPT = r103;
        FileType r104 = new FileType("XLS", 4, 5);
        XLS = r104;
        FileType r110 = new FileType("ZIP", 5, 6);
        ZIP = r110;
        FileType r111 = new FileType("PSD", 6, 7);
        PSD = r111;
        FileType r112 = new FileType("AI", 7, 8);
        AI = r112;
        FileType r113 = new FileType("SKETCH", 8, 9);
        SKETCH = r113;
        $VALUES = new FileType[]{r100, r101, r102, r103, r104, r110, r111, r112, r113};
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
        switch(r100) {
            case 1: goto L22;
            case 2: goto L20;
            case 3: goto L18;
            case 4: goto L16;
            case 5: goto L14;
            case 6: goto L12;
            case 7: goto L10;
            case 8: goto L8;
            case 9: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return SKETCH;
    L8:
        return AI;
    L10:
        return PSD;
    L12:
        return ZIP;
    L14:
        return XLS;
    L16:
        return PPT;
    L18:
        return PDF;
    L20:
        return DOC;
    L22:
        return DEFAULT;
    }

    public static FileType valueOf(String r100) {
        return (FileType) a.a(FileType.class, r100);
    }

    private FileType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
