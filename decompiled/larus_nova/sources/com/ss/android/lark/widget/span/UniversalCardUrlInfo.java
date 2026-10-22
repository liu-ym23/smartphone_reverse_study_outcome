package com.ss.android.lark.widget.span;

import kotlin.Metadata;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0007\"\u0004\b\u0011\u0010\tR\u001a\u0010\u0012\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/ss/android/lark/widget/span/UniversalCardUrlInfo;", "Lcom/ss/android/lark/widget/span/UrlInfo;", "<init>", "()V", "mLocalTokenResId", "", "getMLocalTokenResId", "()I", "setMLocalTokenResId", "(I)V", "isColorful", "", "()Z", "setColorful", "(Z)V", "iconColor", "getIconColor", "setIconColor", "iconSize", "getIconSize", "setIconSize", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UniversalCardUrlInfo extends UrlInfo {
    private int iconColor;
    private int iconSize;
    private boolean isColorful;
    private int mLocalTokenResId;

    public UniversalCardUrlInfo() {
    }

    public final int getIconColor() {
        return this.iconColor;
    }

    public final int getIconSize() {
        return this.iconSize;
    }

    public final int getMLocalTokenResId() {
        return this.mLocalTokenResId;
    }

    public final boolean isColorful() {
        return this.isColorful;
    }

    public final void setColorful(boolean r100) {
        this.isColorful = r100;
    }

    public final void setIconColor(int r100) {
        this.iconColor = r100;
    }

    public final void setIconSize(int r100) {
        this.iconSize = r100;
    }

    public final void setMLocalTokenResId(int r100) {
        this.mLocalTokenResId = r100;
    }
}
