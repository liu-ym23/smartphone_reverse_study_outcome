package com.bytedance.awemeopen.apps.framework.comment.write.emojichoose.choose;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import m44.c;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0004\u0010\u0005R\u0016\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0005R\u0016\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0005R\u0016\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\b\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0005R\u0016\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\n\u0010\u0005R\u0016\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\u0005R\u0016\u0010\f\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0005R\u0016\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\r\u0010\u0005R\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0015\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0015\u0010\u0005R\u0016\u0010\u0016\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0016\u0010\u0005R\u0016\u0010\u0017\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0017\u0010\u0005R\u0016\u0010\u0018\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0018\u0010\u0005R\u0016\u0010\u0019\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0019\u0010\u0005R\u0016\u0010\u001a\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u0005¨\u0006\u001d"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/comment/write/emojichoose/choose/EmojiChooseParams;", "Lm44/c;", "Ljava/io/Serializable;", "", "isBuildSmallEmojis", "Z", "isBuildSelfEmojis", "enableSmallEmojiSendBtn", "enableShowSearchTab", "hasChatWallpaperSet", "isLandscape", "showLastEmoji", "initOpt", "showSearchEmoji", "", "", "commentRecEmoji", "Ljava/util/List;", "Lcom/bytedance/awemeopen/apps/framework/comment/write/emojichoose/choose/EmojiExtParams;", "extParams", "Lcom/bytedance/awemeopen/apps/framework/comment/write/emojichoose/choose/EmojiExtParams;", "lightDarkMode", "canModifyDarkColor", "isOnlySmallSelfGif", "isEnableSendAndDeleteButtonToBigEmoji", "isCommentChoosePanel", "isEnableEmojiTabLayout", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class EmojiChooseParams extends c implements Serializable {
    public boolean canModifyDarkColor;
    public List<Object> commentRecEmoji;
    public boolean enableShowSearchTab;
    public boolean enableSmallEmojiSendBtn;
    public EmojiExtParams extParams;
    public boolean hasChatWallpaperSet;
    public boolean initOpt;
    public boolean isBuildSelfEmojis;
    public boolean isBuildSmallEmojis;
    public boolean isCommentChoosePanel;
    public boolean isEnableEmojiTabLayout;
    public boolean isEnableSendAndDeleteButtonToBigEmoji;
    public boolean isLandscape;
    public boolean isOnlySmallSelfGif;
    public boolean lightDarkMode;
    public boolean showLastEmoji;
    public boolean showSearchEmoji;

    public EmojiChooseParams() {
        this.isEnableEmojiTabLayout = true;
    }
}
