package lark_markdown_render.proto;

import com.squareup.wire.ProtoAdapter;
import com.squareup.wire.WireEnum;
import r27.a;

/* JADX INFO: loaded from: classes42.dex */
public final enum AttachmentTypeId extends Enum<AttachmentTypeId> implements WireEnum {
    private static final /* synthetic */ AttachmentTypeId[] $VALUES = null;
    public static final ProtoAdapter<AttachmentTypeId> ADAPTER = null;
    public static final AttachmentTypeId VAR_ATTACHMENT_TYPE_ID_CODE_BLOCK_COPY_ICON = null;
    public static final AttachmentTypeId VAR_ATTACHMENT_TYPE_ID_DATA_SLOT = null;
    public static final AttachmentTypeId VAR_ATTACHMENT_TYPE_ID_DOC_CANVAS = null;
    public static final AttachmentTypeId VAR_ATTACHMENT_TYPE_ID_IMAGE = null;
    public static final AttachmentTypeId VAR_ATTACHMENT_TYPE_ID_IMAGE_GALLERY = null;
    public static final AttachmentTypeId VAR_ATTACHMENT_TYPE_ID_IM_URL_PREVIEW_ICON = null;
    public static final AttachmentTypeId VAR_ATTACHMENT_TYPE_ID_LEGACY_CODE_BLOCK_COPY_ICON = null;
    private final int value;

    static {
        AttachmentTypeId r100 = new AttachmentTypeId("VAR_ATTACHMENT_TYPE_ID_LEGACY_CODE_BLOCK_COPY_ICON", 0, 99);
        VAR_ATTACHMENT_TYPE_ID_LEGACY_CODE_BLOCK_COPY_ICON = r100;
        AttachmentTypeId r101 = new AttachmentTypeId("VAR_ATTACHMENT_TYPE_ID_IMAGE_GALLERY", 1, 100);
        VAR_ATTACHMENT_TYPE_ID_IMAGE_GALLERY = r101;
        AttachmentTypeId r102 = new AttachmentTypeId("VAR_ATTACHMENT_TYPE_ID_DATA_SLOT", 2, 101);
        VAR_ATTACHMENT_TYPE_ID_DATA_SLOT = r102;
        AttachmentTypeId r103 = new AttachmentTypeId("VAR_ATTACHMENT_TYPE_ID_DOC_CANVAS", 3, 102);
        VAR_ATTACHMENT_TYPE_ID_DOC_CANVAS = r103;
        AttachmentTypeId r104 = new AttachmentTypeId("VAR_ATTACHMENT_TYPE_ID_IMAGE", 4, 103);
        VAR_ATTACHMENT_TYPE_ID_IMAGE = r104;
        AttachmentTypeId r105 = new AttachmentTypeId("VAR_ATTACHMENT_TYPE_ID_CODE_BLOCK_COPY_ICON", 5, 104);
        VAR_ATTACHMENT_TYPE_ID_CODE_BLOCK_COPY_ICON = r105;
        AttachmentTypeId r110 = new AttachmentTypeId("VAR_ATTACHMENT_TYPE_ID_IM_URL_PREVIEW_ICON", 6, 1000);
        VAR_ATTACHMENT_TYPE_ID_IM_URL_PREVIEW_ICON = r110;
        $VALUES = new AttachmentTypeId[]{r100, r101, r102, r103, r104, r105, r110};
        ADAPTER = ProtoAdapter.newEnumAdapter(AttachmentTypeId.class);
    }

    public static AttachmentTypeId[] values() {
        return (AttachmentTypeId[]) $VALUES.clone();
    }

    @Override // com.squareup.wire.WireEnum
    public final int getValue() {
        return this.value;
    }

    public static AttachmentTypeId fromValue(int r100) {
        if (r100 == 1000) goto L20;
        switch(r100) {
            case 99: goto L18;
            case 100: goto L16;
            case 101: goto L14;
            case 102: goto L12;
            case 103: goto L10;
            case 104: goto L8;
            default: goto L5;
        };
    L5:
        return null;
    L8:
        return VAR_ATTACHMENT_TYPE_ID_CODE_BLOCK_COPY_ICON;
    L10:
        return VAR_ATTACHMENT_TYPE_ID_IMAGE;
    L12:
        return VAR_ATTACHMENT_TYPE_ID_DOC_CANVAS;
    L14:
        return VAR_ATTACHMENT_TYPE_ID_DATA_SLOT;
    L16:
        return VAR_ATTACHMENT_TYPE_ID_IMAGE_GALLERY;
    L18:
        return VAR_ATTACHMENT_TYPE_ID_LEGACY_CODE_BLOCK_COPY_ICON;
    L20:
        return VAR_ATTACHMENT_TYPE_ID_IM_URL_PREVIEW_ICON;
    }

    public static AttachmentTypeId valueOf(String r100) {
        return (AttachmentTypeId) a.a(AttachmentTypeId.class, r100);
    }

    private AttachmentTypeId(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
