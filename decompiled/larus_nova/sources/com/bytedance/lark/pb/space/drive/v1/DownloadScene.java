package com.bytedance.lark.pb.space.drive.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum DownloadScene extends Enum<DownloadScene> implements WireEnum {
    private static final /* synthetic */ DownloadScene[] $VALUES = null;
    public static final ProtoAdapter<DownloadScene> ADAPTER = null;
    public static final DownloadScene drive = null;
    public static final DownloadScene large_email = null;
    public static final DownloadScene unknown = null;
    public static final DownloadScene wiki = null;
    private final int value;

    static {
        DownloadScene r100 = new DownloadScene("drive", 0, 0);
        drive = r100;
        DownloadScene r101 = new DownloadScene("large_email", 1, 1);
        large_email = r101;
        DownloadScene r102 = new DownloadScene("unknown", 2, 2);
        unknown = r102;
        DownloadScene r103 = new DownloadScene("wiki", 3, 3);
        wiki = r103;
        $VALUES = new DownloadScene[]{r100, r101, r102, r103};
        ADAPTER = ProtoAdapter.newEnumAdapter(DownloadScene.class);
    }

    public static DownloadScene[] values() {
        return (DownloadScene[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static DownloadScene fromValue(int r100) {
        if (r100 == 0) goto L18;
        if (r100 == 1) goto L16;
        if (r100 == 2) goto L14;
        if (r100 == 3) goto L12;
        return null;
    L12:
        return wiki;
    L14:
        return unknown;
    L16:
        return large_email;
    L18:
        return drive;
    }

    public static DownloadScene valueOf(String r100) {
        return (DownloadScene) a.a(DownloadScene.class, r100);
    }

    private DownloadScene(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
