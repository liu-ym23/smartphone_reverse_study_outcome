package fs9;

import com.google.gson.annotations.SerializedName;
import com.larus.bmhome.music.applet.MusicAppletPage;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u000bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003JQ\u0010\"\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\f\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006)"}, d2 = {"Lcom/larus/profile/api/bean/ContentFromChat;", "", "messageId", "", "imageContent", "Lcom/larus/profile/api/bean/ImageContentFromChat;", "musicContent", "Lcom/larus/profile/api/bean/MusicContentFromChat;", "avatarContent", "Lcom/larus/profile/api/bean/UserAvatarContentFromChat;", "aiBeatifyContent", "Lcom/larus/profile/api/bean/AiBeatifyContentFromChat;", "videoContent", "Lcom/larus/profile/api/bean/VideoContentFromChat;", "<init>", "(Ljava/lang/String;Lcom/larus/profile/api/bean/ImageContentFromChat;Lcom/larus/profile/api/bean/MusicContentFromChat;Lcom/larus/profile/api/bean/UserAvatarContentFromChat;Lcom/larus/profile/api/bean/AiBeatifyContentFromChat;Lcom/larus/profile/api/bean/VideoContentFromChat;)V", "getMessageId", "()Ljava/lang/String;", "getImageContent", "()Lcom/larus/profile/api/bean/ImageContentFromChat;", "getMusicContent", "()Lcom/larus/profile/api/bean/MusicContentFromChat;", "getAvatarContent", "()Lcom/larus/profile/api/bean/UserAvatarContentFromChat;", "getAiBeatifyContent", "()Lcom/larus/profile/api/bean/AiBeatifyContentFromChat;", "getVideoContent", "()Lcom/larus/profile/api/bean/VideoContentFromChat;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    @SerializedName("ai_beautify_content")
    private final a aiBeatifyContent;

    @SerializedName("user_avatar_content")
    private final z avatarContent;

    @SerializedName("image_content")
    private final j imageContent;

    @SerializedName(MusicAppletPage.KEY_MESSAGE_ID)
    private final String messageId;

    @SerializedName(MusicAppletPage.KEY_MUSIC_CONTENT)
    private final l musicContent;

    @SerializedName("video_content")
    private final c0 videoContent;

    public e() {
        this(null, null, null, null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.messageId, r101.messageId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.imageContent, r101.imageContent) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.musicContent, r101.musicContent) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.avatarContent, r101.avatarContent) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.aiBeatifyContent, r101.aiBeatifyContent) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.videoContent, r101.videoContent) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        String r100 = this.messageId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        j r104 = this.imageContent;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        l r107 = this.musicContent;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        z r110 = this.avatarContent;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        a r113 = this.aiBeatifyContent;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        c0 r116 = this.videoContent;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "ContentFromChat(messageId=" + this.messageId + ", imageContent=" + this.imageContent + ", musicContent=" + this.musicContent + ", avatarContent=" + this.avatarContent + ", aiBeatifyContent=" + this.aiBeatifyContent + ", videoContent=" + this.videoContent + ')';
    }

    public e(String r100, j r101, l r102, z r103, a r104, c0 r105, int r106) {
        if ((r106 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r106 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r106 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r106 & 8) == 0) goto L15;
        r103 = null;
    L15:
        if ((r106 & 16) == 0) goto L18;
        r104 = null;
    L18:
        if ((r106 & 32) == 0) goto L20;
        r105 = null;
    L20:
        this.messageId = r100;
        this.imageContent = r101;
        this.musicContent = r102;
        this.avatarContent = r103;
        this.aiBeatifyContent = r104;
        this.videoContent = r105;
    }
}
