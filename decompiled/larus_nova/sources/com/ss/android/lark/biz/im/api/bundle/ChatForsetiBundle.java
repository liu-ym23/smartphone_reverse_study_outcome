package com.ss.android.lark.biz.im.api.bundle;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes34.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\b\"\u0004\b\u000b\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/ss/android/lark/biz/im/api/bundle/ChatForsetiBundle;", "Ljava/io/Serializable;", "clearTop", "", "isOpenChatFullScreenStyle", "<init>", "(ZZ)V", "getClearTop", "()Z", "setClearTop", "(Z)V", "setOpenChatFullScreenStyle", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "", "Companion", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatForsetiBundle implements Serializable {
    public static final a Companion = null;
    public static final String TAG = "ChatForsetiBundle";
    private boolean clearTop;
    private boolean isOpenChatFullScreenStyle;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ChatForsetiBundle() {
        boolean r100 = false;
        this(r100, r100, 3, null);
    }

    public static /* synthetic */ ChatForsetiBundle copy$default(ChatForsetiBundle r100, boolean r101, boolean r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.clearTop;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.isOpenChatFullScreenStyle;
    L9:
        return r100.copy(r101, r102);
    }

    public final boolean component1() {
        return this.clearTop;
    }

    public final boolean component2() {
        return this.isOpenChatFullScreenStyle;
    }

    public final ChatForsetiBundle copy(boolean r100, boolean r101) {
        return new ChatForsetiBundle(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatForsetiBundle) == true) goto L8;
        return false;
    L8:
        ChatForsetiBundle r101 = (ChatForsetiBundle) r100;
        if (this.clearTop == r101.clearTop) goto L12;
        return false;
    L12:
        if (this.isOpenChatFullScreenStyle == r101.isOpenChatFullScreenStyle) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.clearTop == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.isOpenChatFullScreenStyle == true) goto L11;
        r100 = 1237;
    L11:
        return r102 + r100;
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "ChatForsetiBundle(clearTop=" + this.clearTop + ", isOpenChatFullScreenStyle=" + this.isOpenChatFullScreenStyle + ')';
    }

    public final boolean getClearTop() {
        return this.clearTop;
    }

    public final boolean isOpenChatFullScreenStyle() {
        return this.isOpenChatFullScreenStyle;
    }

    public final void setClearTop(boolean r100) {
        this.clearTop = r100;
    }

    public final void setOpenChatFullScreenStyle(boolean r100) {
        this.isOpenChatFullScreenStyle = r100;
    }

    public ChatForsetiBundle(boolean r100, boolean r101) {
        this.clearTop = r100;
        this.isOpenChatFullScreenStyle = r101;
    }

    public /* synthetic */ ChatForsetiBundle(boolean r100, boolean r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = false;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = false;
    L8:
        this(r100, r101);
    }
}
