package com.ss.android.lark.widget.card.audio;

import com.larksuite.framework.utils.UIUtils;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.widget.span.TextStyleInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b#\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\u001a\u0010\u0019\u001a\u00020\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\tR\u001a\u0010\"\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0007\"\u0004\b$\u0010\tR\u001a\u0010%\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0007\"\u0004\b'\u0010\tR\u001a\u0010(\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0007\"\u0004\b*\u0010\tR\u001a\u0010+\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0007\"\u0004\b-\u0010\tR\u001a\u0010.\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR\u001a\u00101\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0007\"\u0004\b3\u0010\t¨\u00064"}, d2 = {"Lcom/ss/android/lark/widget/card/audio/CardAudioInfo;", "Lcom/ss/android/lark/widget/span/TextStyleInfo;", "<init>", "()V", "audioDuration", "", "getAudioDuration", "()I", "setAudioDuration", "(I)V", "contentID", "", "getContentID", "()Ljava/lang/String;", "setContentID", "(Ljava/lang/String;)V", "loadingAnim", "", "getLoadingAnim", "()Z", "setLoadingAnim", "(Z)V", "bgColor", "getBgColor", "setBgColor", "showTime", "getShowTime", "setShowTime", "iconResId", "getIconResId", "setIconResId", "iconColor", "getIconColor", "setIconColor", "iconSize", "getIconSize", "setIconSize", "originalTextSize", "getOriginalTextSize", "setOriginalTextSize", "iconTextGap", "getIconTextGap", "setIconTextGap", "bgHeight", "getBgHeight", "setBgHeight", "bgPaddingLeft", "getBgPaddingLeft", "setBgPaddingLeft", "bgPaddingRight", "getBgPaddingRight", "setBgPaddingRight", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardAudioInfo extends TextStyleInfo {
    private int audioDuration;
    private int bgColor;
    private int bgHeight;
    private int bgPaddingLeft;
    private int bgPaddingRight;
    private String contentID;
    private int iconColor;
    private int iconResId;
    private int iconSize;
    private int iconTextGap;
    private boolean loadingAnim;
    private int originalTextSize;
    private boolean showTime;

    public CardAudioInfo() {
        this.contentID = "";
        this.iconSize = UIUtils.dp2px(LarkContext.getApplication(), 12.0f);
        this.originalTextSize = UIUtils.dp2px(LarkContext.getApplication(), 14.0f);
        this.iconTextGap = UIUtils.dp2px(LarkContext.getApplication(), 2.0f);
        this.bgHeight = UIUtils.dp2px(LarkContext.getApplication(), 18.0f);
        this.bgPaddingLeft = UIUtils.dp2px(LarkContext.getApplication(), 6.0f);
        this.bgPaddingRight = UIUtils.dp2px(LarkContext.getApplication(), 9.0f);
    }

    public final int getAudioDuration() {
        return this.audioDuration;
    }

    public final int getBgColor() {
        return this.bgColor;
    }

    public final int getBgHeight() {
        return this.bgHeight;
    }

    public final int getBgPaddingLeft() {
        return this.bgPaddingLeft;
    }

    public final int getBgPaddingRight() {
        return this.bgPaddingRight;
    }

    public final String getContentID() {
        return this.contentID;
    }

    public final int getIconColor() {
        return this.iconColor;
    }

    public final int getIconResId() {
        return this.iconResId;
    }

    public final int getIconSize() {
        return this.iconSize;
    }

    public final int getIconTextGap() {
        return this.iconTextGap;
    }

    public final boolean getLoadingAnim() {
        return this.loadingAnim;
    }

    public final int getOriginalTextSize() {
        return this.originalTextSize;
    }

    public final boolean getShowTime() {
        return this.showTime;
    }

    public final void setAudioDuration(int r100) {
        this.audioDuration = r100;
    }

    public final void setBgColor(int r100) {
        this.bgColor = r100;
    }

    public final void setBgHeight(int r100) {
        this.bgHeight = r100;
    }

    public final void setBgPaddingLeft(int r100) {
        this.bgPaddingLeft = r100;
    }

    public final void setBgPaddingRight(int r100) {
        this.bgPaddingRight = r100;
    }

    public final void setContentID(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.contentID = r100;
    }

    public final void setIconColor(int r100) {
        this.iconColor = r100;
    }

    public final void setIconResId(int r100) {
        this.iconResId = r100;
    }

    public final void setIconSize(int r100) {
        this.iconSize = r100;
    }

    public final void setIconTextGap(int r100) {
        this.iconTextGap = r100;
    }

    public final void setLoadingAnim(boolean r100) {
        this.loadingAnim = r100;
    }

    public final void setOriginalTextSize(int r100) {
        this.originalTextSize = r100;
    }

    public final void setShowTime(boolean r100) {
        this.showTime = r100;
    }
}
