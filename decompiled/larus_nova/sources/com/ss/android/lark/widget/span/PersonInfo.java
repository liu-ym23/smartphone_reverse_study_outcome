package com.ss.android.lark.widget.span;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0011\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u0000 )2\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0007\"\u0004\b\u0018\u0010\tR\"\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0086\u000e¢\u0006\u0010\n\u0002\u0010 \u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010!\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%¨\u0006*"}, d2 = {"Lcom/ss/android/lark/widget/span/PersonInfo;", "Lcom/ss/android/lark/widget/span/TextStyleInfo;", "<init>", "()V", "userId", "", "getUserId", "()Ljava/lang/String;", "setUserId", "(Ljava/lang/String;)V", "avatarKey", "getAvatarKey", "setAvatarKey", "showAvatar", "", "getShowAvatar", "()Z", "setShowAvatar", "(Z)V", "showName", "getShowName", "setShowName", "styleType", "getStyleType", "setStyleType", "containerPadding", "", "", "getContainerPadding", "()[Ljava/lang/Integer;", "setContainerPadding", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "avatarSize", "getAvatarSize", "()I", "setAvatarSize", "(I)V", "lineHeight", "getLineHeight", "setLineHeight", "Companion", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PersonInfo extends TextStyleInfo {
    public static final a Companion = null;
    public static final String TYPE_CAPSULE = "capsule";
    public static final String TYPE_NORMAL = "normal";
    private String avatarKey;
    private int avatarSize;
    private Integer[] containerPadding;
    private int lineHeight;
    private boolean showAvatar;
    private boolean showName;
    private String styleType;
    private String userId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public PersonInfo() {
        this.showAvatar = true;
        this.styleType = "normal";
        this.containerPadding = new Integer[]{0, 0, 0, 0};
    }

    public final String getAvatarKey() {
        return this.avatarKey;
    }

    public final int getAvatarSize() {
        return this.avatarSize;
    }

    public final Integer[] getContainerPadding() {
        return this.containerPadding;
    }

    public final int getLineHeight() {
        return this.lineHeight;
    }

    public final boolean getShowAvatar() {
        return this.showAvatar;
    }

    public final boolean getShowName() {
        return this.showName;
    }

    public final String getStyleType() {
        return this.styleType;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final void setAvatarKey(String r100) {
        this.avatarKey = r100;
    }

    public final void setAvatarSize(int r100) {
        this.avatarSize = r100;
    }

    public final void setContainerPadding(Integer[] r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.containerPadding = r100;
    }

    public final void setLineHeight(int r100) {
        this.lineHeight = r100;
    }

    public final void setShowAvatar(boolean r100) {
        this.showAvatar = r100;
    }

    public final void setShowName(boolean r100) {
        this.showName = r100;
    }

    public final void setStyleType(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.styleType = r100;
    }

    public final void setUserId(String r100) {
        this.userId = r100;
    }
}
