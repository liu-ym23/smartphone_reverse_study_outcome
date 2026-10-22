package com.bytedance.lark.lark_markdown_render_android;

import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import r27.a;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u0000 \u00112\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0011B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u0006\u0010\t\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0012"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/AttachmentTypeId;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "into", "Llark_markdown_render/proto/AttachmentTypeId;", "intoInt", "LegacyCodeBlockCopyIcon", "ImageGallery", "DataSlot", "DocCanvas", "Image", "CodeBlockCopyIcon", "ImUrlPreviewIcon", "Companion", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
public final enum AttachmentTypeId extends Enum<AttachmentTypeId> {
    private static final /* synthetic */ EnumEntries $ENTRIES = null;
    private static final /* synthetic */ AttachmentTypeId[] $VALUES = null;
    public static final AttachmentTypeId CodeBlockCopyIcon = null;
    public static final Companion Companion = null;
    public static final AttachmentTypeId DataSlot = null;
    public static final AttachmentTypeId DocCanvas = null;
    public static final AttachmentTypeId ImUrlPreviewIcon = null;
    public static final AttachmentTypeId Image = null;
    public static final AttachmentTypeId ImageGallery = null;
    public static final AttachmentTypeId LegacyCodeBlockCopyIcon = null;
    private final int value;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/bytedance/lark/lark_markdown_render_android/AttachmentTypeId$Companion;", "", "()V", "fromInt", "Lcom/bytedance/lark/lark_markdown_render_android/AttachmentTypeId;", "value", "", "lark_markdown_render_android_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        @JvmStatic
        public final AttachmentTypeId fromInt(int r100) {
            if (r100 == 1000) goto L14;
            switch(r100) {
                case 99: goto L20;
                case 100: goto L19;
                case 101: goto L18;
                case 102: goto L17;
                case 103: goto L16;
                case 104: goto L15;
                default: goto L6;
            };
        L6:
            throw new RuntimeException("Unmatched primitive enum value: AttachmentTypeId with ");
        L15:
            return AttachmentTypeId.CodeBlockCopyIcon;
        L16:
            return AttachmentTypeId.Image;
        L17:
            return AttachmentTypeId.DocCanvas;
        L18:
            return AttachmentTypeId.DataSlot;
        L19:
            return AttachmentTypeId.ImageGallery;
        L20:
            return AttachmentTypeId.LegacyCodeBlockCopyIcon;
        L14:
            return AttachmentTypeId.ImUrlPreviewIcon;
        }
    }

    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r100 = new int[AttachmentTypeId.values().length];
            r100[AttachmentTypeId.LegacyCodeBlockCopyIcon.ordinal()] = 1;     // Catch: NoSuchFieldError -> L12
        L21:
            r100[AttachmentTypeId.ImageGallery.ordinal()] = 2;     // Catch: NoSuchFieldError -> L13
        L31:
            r100[AttachmentTypeId.DataSlot.ordinal()] = 3;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[AttachmentTypeId.DocCanvas.ordinal()] = 4;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[AttachmentTypeId.Image.ordinal()] = 5;     // Catch: NoSuchFieldError -> L16
        L19:
            r100[AttachmentTypeId.CodeBlockCopyIcon.ordinal()] = 6;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[AttachmentTypeId.ImUrlPreviewIcon.ordinal()] = 7;     // Catch: NoSuchFieldError -> L18
        L10:
            $EnumSwitchMapping$0 = r100;
        }
    }

    private static final /* synthetic */ AttachmentTypeId[] $values() {
        return new AttachmentTypeId[]{LegacyCodeBlockCopyIcon, ImageGallery, DataSlot, DocCanvas, Image, CodeBlockCopyIcon, ImUrlPreviewIcon};
    }

    @JvmStatic
    public static final AttachmentTypeId fromInt(int r100) {
        return Companion.fromInt(r100);
    }

    public static EnumEntries<AttachmentTypeId> getEntries() {
        return $ENTRIES;
    }

    public static AttachmentTypeId valueOf(String r100) {
        return (AttachmentTypeId) a.a(AttachmentTypeId.class, r100);
    }

    public static AttachmentTypeId[] values() {
        return (AttachmentTypeId[]) $VALUES.clone();
    }

    static {
        LegacyCodeBlockCopyIcon = new AttachmentTypeId("LegacyCodeBlockCopyIcon", 0, 99);
        ImageGallery = new AttachmentTypeId("ImageGallery", 1, 100);
        DataSlot = new AttachmentTypeId("DataSlot", 2, 101);
        DocCanvas = new AttachmentTypeId("DocCanvas", 3, 102);
        Image = new AttachmentTypeId("Image", 4, 103);
        CodeBlockCopyIcon = new AttachmentTypeId("CodeBlockCopyIcon", 5, 104);
        ImUrlPreviewIcon = new AttachmentTypeId("ImUrlPreviewIcon", 6, 1000);
        AttachmentTypeId[] r100 = $values();
        $VALUES = r100;
        $ENTRIES = EnumEntriesKt.enumEntries(r100);
        Companion = new Companion(null);
    }

    public final lark_markdown_render.proto.AttachmentTypeId into() {
        switch(WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1: goto L13;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            default: goto L5;
        };
    L5:
        throw new NoWhenBranchMatchedException();
    L14:
        return lark_markdown_render.proto.AttachmentTypeId.VAR_ATTACHMENT_TYPE_ID_IM_URL_PREVIEW_ICON;
    L15:
        return lark_markdown_render.proto.AttachmentTypeId.VAR_ATTACHMENT_TYPE_ID_CODE_BLOCK_COPY_ICON;
    L16:
        return lark_markdown_render.proto.AttachmentTypeId.VAR_ATTACHMENT_TYPE_ID_IMAGE;
    L17:
        return lark_markdown_render.proto.AttachmentTypeId.VAR_ATTACHMENT_TYPE_ID_DOC_CANVAS;
    L18:
        return lark_markdown_render.proto.AttachmentTypeId.VAR_ATTACHMENT_TYPE_ID_DATA_SLOT;
    L19:
        return lark_markdown_render.proto.AttachmentTypeId.VAR_ATTACHMENT_TYPE_ID_IMAGE_GALLERY;
    L13:
        return lark_markdown_render.proto.AttachmentTypeId.VAR_ATTACHMENT_TYPE_ID_LEGACY_CODE_BLOCK_COPY_ICON;
    }

    public final int intoInt() {
        switch(WhenMappings.$EnumSwitchMapping$0[ordinal()]) {
            case 1: goto L12;
            case 2: goto L11;
            case 3: goto L10;
            case 4: goto L9;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L6;
            default: goto L5;
        };
    L6:
        return 1000;
    L7:
        return 104;
    L8:
        return 103;
    L9:
        return 102;
    L10:
        return 101;
    L11:
        return 100;
    L12:
        return 99;
    L5:
        throw new NoWhenBranchMatchedException();
    }

    public final int getValue() {
        return this.value;
    }

    private AttachmentTypeId(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
