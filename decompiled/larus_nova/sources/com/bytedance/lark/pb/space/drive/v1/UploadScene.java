package com.bytedance.lark.pb.space.drive.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum UploadScene extends Enum<UploadScene> implements WireEnum {
    private static final /* synthetic */ UploadScene[] $VALUES = null;
    public static final ProtoAdapter<UploadScene> ADAPTER = null;
    public static final UploadScene DRIVE = null;
    public static final UploadScene LARGE_EMAIL = null;
    public static final UploadScene UNKNOWN = null;
    public static final UploadScene WIKI = null;
    public static final UploadScene WORKSPACE = null;
    private final int value;

    static {
        UploadScene r100 = new UploadScene("DRIVE", 0, 0);
        DRIVE = r100;
        UploadScene r101 = new UploadScene("LARGE_EMAIL", 1, 1);
        LARGE_EMAIL = r101;
        UploadScene r102 = new UploadScene("UNKNOWN", 2, 2);
        UNKNOWN = r102;
        UploadScene r103 = new UploadScene("WIKI", 3, 3);
        WIKI = r103;
        UploadScene r104 = new UploadScene("WORKSPACE", 4, 4);
        WORKSPACE = r104;
        $VALUES = new UploadScene[]{r100, r101, r102, r103, r104};
        ADAPTER = ProtoAdapter.newEnumAdapter(UploadScene.class);
    }

    public static UploadScene[] values() {
        return (UploadScene[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static UploadScene fromValue(int r100) {
        if (r100 == 0) goto L22;
        if (r100 == 1) goto L20;
        if (r100 == 2) goto L18;
        if (r100 == 3) goto L16;
        if (r100 == 4) goto L14;
        return null;
    L14:
        return WORKSPACE;
    L16:
        return WIKI;
    L18:
        return UNKNOWN;
    L20:
        return LARGE_EMAIL;
    L22:
        return DRIVE;
    }

    public static UploadScene valueOf(String r100) {
        return (UploadScene) a.a(UploadScene.class, r100);
    }

    private UploadScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
