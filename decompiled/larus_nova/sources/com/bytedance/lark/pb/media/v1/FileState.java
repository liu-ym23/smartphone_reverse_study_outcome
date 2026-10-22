package com.bytedance.lark.pb.media.v1;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes20.dex */
public final enum FileState extends Enum<FileState> implements WireEnum {
    private static final /* synthetic */ FileState[] $VALUES = null;
    public static final ProtoAdapter<FileState> ADAPTER = null;
    public static final FileState CANCEL_BY_RISK = null;
    public static final FileState COMPRESS_MEDIA_COMPLETE = null;
    public static final FileState DOWNLOADING = null;
    public static final FileState DOWNLOAD_CANCEL = null;
    public static final FileState DOWNLOAD_FAIL = null;
    public static final FileState DOWNLOAD_FAIL_BURNED = null;
    public static final FileState DOWNLOAD_FAIL_RECALL = null;
    public static final FileState DOWNLOAD_SUCCESS = null;
    public static final FileState DOWNLOAD_WAIT = null;
    public static final FileState UPLOADING = null;
    public static final FileState UPLOAD_CANCEL = null;
    public static final FileState UPLOAD_CANCEL_FOR_SWITCH = null;
    public static final FileState UPLOAD_CREATED = null;
    public static final FileState UPLOAD_FAIL = null;
    public static final FileState UPLOAD_SUCCESS = null;
    public static final FileState UPLOAD_WAIT = null;
    private final int value;

    static {
        FileState r100 = new FileState("UPLOAD_WAIT", 0, 1);
        UPLOAD_WAIT = r100;
        FileState r101 = new FileState("UPLOADING", 1, 2);
        UPLOADING = r101;
        FileState r102 = new FileState("UPLOAD_FAIL", 2, 3);
        UPLOAD_FAIL = r102;
        FileState r103 = new FileState("UPLOAD_CANCEL", 3, 4);
        UPLOAD_CANCEL = r103;
        FileState r104 = new FileState("UPLOAD_SUCCESS", 4, 5);
        UPLOAD_SUCCESS = r104;
        FileState r110 = new FileState("UPLOAD_CREATED", 5, 6);
        UPLOAD_CREATED = r110;
        FileState r111 = new FileState("DOWNLOAD_WAIT", 6, 7);
        DOWNLOAD_WAIT = r111;
        FileState r112 = new FileState("DOWNLOADING", 7, 8);
        DOWNLOADING = r112;
        FileState r113 = new FileState("DOWNLOAD_FAIL", 8, 9);
        DOWNLOAD_FAIL = r113;
        FileState r114 = new FileState("DOWNLOAD_CANCEL", 9, 10);
        DOWNLOAD_CANCEL = r114;
        FileState r115 = new FileState("DOWNLOAD_SUCCESS", 10, 11);
        DOWNLOAD_SUCCESS = r115;
        FileState r105 = new FileState("DOWNLOAD_FAIL_RECALL", 11, 12);
        DOWNLOAD_FAIL_RECALL = r105;
        FileState r106 = new FileState("DOWNLOAD_FAIL_BURNED", 12, 13);
        DOWNLOAD_FAIL_BURNED = r106;
        FileState r107 = new FileState("COMPRESS_MEDIA_COMPLETE", 13, 14);
        COMPRESS_MEDIA_COMPLETE = r107;
        FileState r108 = new FileState("UPLOAD_CANCEL_FOR_SWITCH", 14, 15);
        UPLOAD_CANCEL_FOR_SWITCH = r108;
        FileState r109 = new FileState("CANCEL_BY_RISK", 15, 16);
        CANCEL_BY_RISK = r109;
        $VALUES = new FileState[]{r100, r101, r102, r103, r104, r110, r111, r112, r113, r114, r115, r105, r106, r107, r108, r109};
        ADAPTER = ProtoAdapter.newEnumAdapter(FileState.class);
    }

    public static FileState[] values() {
        return (FileState[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static FileState fromValue(int r100) {
        switch(r100) {
            case 1: goto L36;
            case 2: goto L34;
            case 3: goto L32;
            case 4: goto L30;
            case 5: goto L28;
            case 6: goto L26;
            case 7: goto L24;
            case 8: goto L22;
            case 9: goto L20;
            case 10: goto L18;
            case 11: goto L16;
            case 12: goto L14;
            case 13: goto L12;
            case 14: goto L10;
            case 15: goto L8;
            case 16: goto L6;
            default: goto L3;
        };
    L3:
        return null;
    L6:
        return CANCEL_BY_RISK;
    L8:
        return UPLOAD_CANCEL_FOR_SWITCH;
    L10:
        return COMPRESS_MEDIA_COMPLETE;
    L12:
        return DOWNLOAD_FAIL_BURNED;
    L14:
        return DOWNLOAD_FAIL_RECALL;
    L16:
        return DOWNLOAD_SUCCESS;
    L18:
        return DOWNLOAD_CANCEL;
    L20:
        return DOWNLOAD_FAIL;
    L22:
        return DOWNLOADING;
    L24:
        return DOWNLOAD_WAIT;
    L26:
        return UPLOAD_CREATED;
    L28:
        return UPLOAD_SUCCESS;
    L30:
        return UPLOAD_CANCEL;
    L32:
        return UPLOAD_FAIL;
    L34:
        return UPLOADING;
    L36:
        return UPLOAD_WAIT;
    }

    public static FileState valueOf(String r100) {
        return (FileState) a.a(FileState.class, r100);
    }

    private FileState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
