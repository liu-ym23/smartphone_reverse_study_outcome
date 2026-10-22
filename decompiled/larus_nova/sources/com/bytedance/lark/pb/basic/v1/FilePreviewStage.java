package com.bytedance.lark.pb.basic.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum FilePreviewStage extends Enum<FilePreviewStage> implements WireEnum {
    private static final /* synthetic */ FilePreviewStage[] $VALUES = null;
    public static final ProtoAdapter<FilePreviewStage> ADAPTER = null;
    public static final FilePreviewStage Encrypted = null;
    public static final FilePreviewStage Normal = null;
    public static final FilePreviewStage NotSupportedSize = null;
    public static final FilePreviewStage NotSupportedType = null;
    public static final FilePreviewStage UnknownStage = null;
    private final int value;

    static {
        FilePreviewStage r100 = new FilePreviewStage("UnknownStage", 0, 0);
        UnknownStage = r100;
        FilePreviewStage r101 = new FilePreviewStage("Normal", 1, 1);
        Normal = r101;
        FilePreviewStage r102 = new FilePreviewStage("Encrypted", 2, 2);
        Encrypted = r102;
        FilePreviewStage r103 = new FilePreviewStage("NotSupportedType", 3, 3);
        NotSupportedType = r103;
        FilePreviewStage r104 = new FilePreviewStage("NotSupportedSize", 4, 4);
        NotSupportedSize = r104;
        $VALUES = new FilePreviewStage[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(FilePreviewStage.class);
    }

    public static FilePreviewStage[] values() {
        return (FilePreviewStage[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FilePreviewStage fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return NotSupportedSize;
    L16:
        return NotSupportedType;
    L18:
        return Encrypted;
    L20:
        return Normal;
    L22:
        return UnknownStage;
    }

    public static FilePreviewStage valueOf(String r100) {
        return (FilePreviewStage) a.a(FilePreviewStage.class, r100);
    }

    private FilePreviewStage(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
