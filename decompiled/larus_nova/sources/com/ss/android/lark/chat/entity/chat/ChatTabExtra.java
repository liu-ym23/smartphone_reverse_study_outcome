package com.ss.android.lark.chat.entity.chat;

import com.bytedance.android.service.manager.alliance.IAllianceService;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/chat/entity/chat/ChatTabExtra;", "Ljava/io/Serializable;", IAllianceService.CONTENT_TYPE_BADGE, "", "count", "<init>", "(II)V", "getBadge", "()I", "setBadge", "(I)V", "getCount", "setCount", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ChatTabExtra implements Serializable {
    public static final a Companion = null;
    private int badge;
    private int count;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public ChatTabExtra() {
        int r100 = 0;
        this(r100, r100, 3, null);
    }

    @JvmStatic
    public static final boolean badgeValid(int r100) {
        Companion.getClass();
        if (r100 == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public static /* synthetic */ ChatTabExtra copy$default(ChatTabExtra r100, int r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.badge;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.count;
    L9:
        return r100.copy(r101, r102);
    }

    @JvmStatic
    public static final boolean countValid(int r100) {
        Companion.getClass();
        if (r100 <= (-1)) goto L5;
        return true;
    L5:
        return false;
    }

    public final int component1() {
        return this.badge;
    }

    public final int component2() {
        return this.count;
    }

    public final ChatTabExtra copy(int r100, int r101) {
        return new ChatTabExtra(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ChatTabExtra) == true) goto L8;
        return false;
    L8:
        ChatTabExtra r101 = (ChatTabExtra) r100;
        if (this.badge == r101.badge) goto L12;
        return false;
    L12:
        if (this.count == r101.count) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        return (this.badge * 31) + this.count;
    }

    public String toString() {
        return "ChatTabExtra(badge=" + this.badge + ", count=" + this.count + ')';
    }

    public final int getBadge() {
        return this.badge;
    }

    public final int getCount() {
        return this.count;
    }

    public final void setBadge(int r100) {
        this.badge = r100;
    }

    public final void setCount(int r100) {
        this.count = r100;
    }

    public ChatTabExtra(int r100, int r101) {
        this.badge = r100;
        this.count = r101;
    }

    public /* synthetic */ ChatTabExtra(int r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = 0;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
