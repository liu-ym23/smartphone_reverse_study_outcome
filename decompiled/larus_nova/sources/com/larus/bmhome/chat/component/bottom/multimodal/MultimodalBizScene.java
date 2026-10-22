package com.larus.bmhome.chat.component.bottom.multimodal;

import com.tencent.open.SocialConstants;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b!\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#¨\u0006$"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/multimodal/MultimodalBizScene;", "", SocialConstants.PARAM_APP_DESC, "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDesc", "()Ljava/lang/String;", "ChatInputAlbum", "ChatInputFastAlbum", "ChatInputFastAlbumGuideCamera", "ChatInputActionEntranceAlbum", "ChatInputCameraActionEntranceAlbum", "OuterChatInputAlbum", "OuterChatInputActionEntranceAlbum", "ChatInputCamera", "ChatLatestPhoto", "ChatInputFile", "ChatInputActionEntranceFile", "OuterChatInputActionEntranceFile", "OuterChatInputFile", "ChatPasteUri", "ChatReceiveUri", "ImportedImageRoute", "PodcastFile", "SuggestedActionFile", "SuggestedActionAlbum", "PromptCellAlbum", "InstructionDocumentRead", "ChatAttachmentPanelMoreFile", "ChatAttachmentPanelMoreAudioFile", "ChatAttachmentPanelMoreAlbum", "ChatSendImagePreviewPage", "ChatInputDriveFile", "ObricSpecialType", "PhotoPickerAttachmentPanel", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum MultimodalBizScene extends Enum<MultimodalBizScene> {
    public static final MultimodalBizScene ChatAttachmentPanelMoreAlbum = null;
    public static final MultimodalBizScene ChatAttachmentPanelMoreAudioFile = null;
    public static final MultimodalBizScene ChatAttachmentPanelMoreFile = null;
    public static final MultimodalBizScene ChatInputActionEntranceAlbum = null;
    public static final MultimodalBizScene ChatInputActionEntranceFile = null;
    public static final MultimodalBizScene ChatInputAlbum = null;
    public static final MultimodalBizScene ChatInputCamera = null;
    public static final MultimodalBizScene ChatInputCameraActionEntranceAlbum = null;
    public static final MultimodalBizScene ChatInputDriveFile = null;
    public static final MultimodalBizScene ChatInputFastAlbum = null;
    public static final MultimodalBizScene ChatInputFastAlbumGuideCamera = null;
    public static final MultimodalBizScene ChatInputFile = null;
    public static final MultimodalBizScene ChatLatestPhoto = null;
    public static final MultimodalBizScene ChatPasteUri = null;
    public static final MultimodalBizScene ChatReceiveUri = null;
    public static final MultimodalBizScene ChatSendImagePreviewPage = null;
    public static final MultimodalBizScene ImportedImageRoute = null;
    public static final MultimodalBizScene InstructionDocumentRead = null;
    public static final MultimodalBizScene ObricSpecialType = null;
    public static final MultimodalBizScene OuterChatInputActionEntranceAlbum = null;
    public static final MultimodalBizScene OuterChatInputActionEntranceFile = null;
    public static final MultimodalBizScene OuterChatInputAlbum = null;
    public static final MultimodalBizScene OuterChatInputFile = null;
    public static final MultimodalBizScene PhotoPickerAttachmentPanel = null;
    public static final MultimodalBizScene PodcastFile = null;
    public static final MultimodalBizScene PromptCellAlbum = null;
    public static final MultimodalBizScene SuggestedActionAlbum = null;
    public static final MultimodalBizScene SuggestedActionFile = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ MultimodalBizScene[] f299682a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f299683b = null;
    private final String desc;

    public static EnumEntries<MultimodalBizScene> getEntries() {
        return f299683b;
    }

    static {
        MultimodalBizScene r100 = new MultimodalBizScene("ChatInputAlbum", 0, "ChatInputAlbum");
        ChatInputAlbum = r100;
        MultimodalBizScene r101 = new MultimodalBizScene("ChatInputFastAlbum", 1, "ChatInputFastAlbum");
        ChatInputFastAlbum = r101;
        MultimodalBizScene r102 = new MultimodalBizScene("ChatInputFastAlbumGuideCamera", 2, "ChatInputFastAlbumGuideCamera");
        ChatInputFastAlbumGuideCamera = r102;
        MultimodalBizScene r103 = new MultimodalBizScene("ChatInputActionEntranceAlbum", 3, "ChatInputActionEntranceAlbum");
        ChatInputActionEntranceAlbum = r103;
        MultimodalBizScene r104 = new MultimodalBizScene("ChatInputCameraActionEntranceAlbum", 4, "ChatInputCameraActionEntranceAlbum");
        ChatInputCameraActionEntranceAlbum = r104;
        MultimodalBizScene r105 = new MultimodalBizScene("OuterChatInputAlbum", 5, "OuterChatInputAlbum");
        OuterChatInputAlbum = r105;
        MultimodalBizScene r110 = new MultimodalBizScene("OuterChatInputActionEntranceAlbum", 6, "OuterChatInputActionEntranceAlbum");
        OuterChatInputActionEntranceAlbum = r110;
        MultimodalBizScene r111 = new MultimodalBizScene("ChatInputCamera", 7, "ChatInputCamera");
        ChatInputCamera = r111;
        MultimodalBizScene r112 = new MultimodalBizScene("ChatLatestPhoto", 8, "ChatLatestPhoto");
        ChatLatestPhoto = r112;
        MultimodalBizScene r113 = new MultimodalBizScene("ChatInputFile", 9, "ChatLatestPhoto");
        ChatInputFile = r113;
        MultimodalBizScene r114 = new MultimodalBizScene("ChatInputActionEntranceFile", 10, "ChatInputActionEntranceFile");
        ChatInputActionEntranceFile = r114;
        MultimodalBizScene r115 = new MultimodalBizScene("OuterChatInputActionEntranceFile", 11, "OuterChatInputActionEntranceFile");
        OuterChatInputActionEntranceFile = r115;
        MultimodalBizScene r106 = new MultimodalBizScene("OuterChatInputFile", 12, "OuterChatInputFile");
        OuterChatInputFile = r106;
        MultimodalBizScene r107 = new MultimodalBizScene("ChatPasteUri", 13, "ChatPasteUri");
        ChatPasteUri = r107;
        MultimodalBizScene r108 = new MultimodalBizScene("ChatReceiveUri", 14, "ChatReceiveUri");
        ChatReceiveUri = r108;
        MultimodalBizScene r109 = new MultimodalBizScene("ImportedImageRoute", 15, "ImportedImageRoute");
        ImportedImageRoute = r109;
        MultimodalBizScene r116 = new MultimodalBizScene("PodcastFile", 16, "PodcastFile");
        PodcastFile = r116;
        MultimodalBizScene r117 = new MultimodalBizScene("SuggestedActionFile", 17, "SuggestedActionFile");
        SuggestedActionFile = r117;
        MultimodalBizScene r118 = new MultimodalBizScene("SuggestedActionAlbum", 18, "SuggestedActionAlbum");
        SuggestedActionAlbum = r118;
        MultimodalBizScene r119 = new MultimodalBizScene("PromptCellAlbum", 19, "PromptCellAlbum");
        PromptCellAlbum = r119;
        MultimodalBizScene r120 = new MultimodalBizScene("InstructionDocumentRead", 20, "InstructionDocumentRead");
        InstructionDocumentRead = r120;
        MultimodalBizScene r121 = new MultimodalBizScene("ChatAttachmentPanelMoreFile", 21, "ChatAttachmentPanelMoreFile");
        ChatAttachmentPanelMoreFile = r121;
        MultimodalBizScene r122 = new MultimodalBizScene("ChatAttachmentPanelMoreAudioFile", 22, "ChatAttachmentPanelMoreAudioFile");
        ChatAttachmentPanelMoreAudioFile = r122;
        MultimodalBizScene r123 = new MultimodalBizScene("ChatAttachmentPanelMoreAlbum", 23, "ChatAttachmentPanelMoreAlbum");
        ChatAttachmentPanelMoreAlbum = r123;
        MultimodalBizScene r124 = new MultimodalBizScene("ChatSendImagePreviewPage", 24, "ChatSendImagePreviewPage");
        ChatSendImagePreviewPage = r124;
        MultimodalBizScene r125 = new MultimodalBizScene("ChatInputDriveFile", 25, "ChatInputDriveFile");
        ChatInputDriveFile = r125;
        MultimodalBizScene r126 = new MultimodalBizScene("ObricSpecialType", 26, "Obric");
        ObricSpecialType = r126;
        MultimodalBizScene r127 = new MultimodalBizScene("PhotoPickerAttachmentPanel", 27, "PhotoPickerAttachmentPanel");
        PhotoPickerAttachmentPanel = r127;
        MultimodalBizScene[] r128 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115, r106, r107, r108, r109, r116, r117, r118, r119, r120, r121, r122, r123, r124, r125, r126, r127};
        f299682a = r128;
        f299683b = EnumEntriesKt.enumEntries(r128);
    }

    public static MultimodalBizScene[] values() {
        return (MultimodalBizScene[]) f299682a.clone();
    }

    public final String getDesc() {
        return this.desc;
    }

    public static MultimodalBizScene valueOf(String r100) {
        return (MultimodalBizScene) r27.a.a(MultimodalBizScene.class, r100);
    }

    public MultimodalBizScene(String r100, int r101, String r102) {
        super(r100, r101);
        this.desc = r102;
    }
}
