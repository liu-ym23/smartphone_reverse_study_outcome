package com.ss.android.lark.coremdbiz.facade.node;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/coremdbiz/facade/node/MarkdownAtUser;", "Ljava/io/Serializable;", "userId", "", "content", "isOutChatUser", "", "isAnonymous", "isHighLight", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZZZ)V", "getUserId", "()Ljava/lang/String;", "getContent", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "linked-emoji_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MarkdownAtUser implements Serializable {
    private final String content;
    private final boolean isAnonymous;
    private final boolean isHighLight;
    private final boolean isOutChatUser;
    private final String userId;

    public MarkdownAtUser() {
        this(null, null, false, false, false, 31, null);
    }

    public static /* synthetic */ MarkdownAtUser copy$default(MarkdownAtUser r100, String r101, String r102, boolean r103, boolean r104, boolean r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.userId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.content;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.isOutChatUser;
    L11:
        boolean r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.isAnonymous;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.isHighLight;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.userId;
    }

    public final String component2() {
        return this.content;
    }

    public final boolean component3() {
        return this.isOutChatUser;
    }

    public final boolean component4() {
        return this.isAnonymous;
    }

    public final boolean component5() {
        return this.isHighLight;
    }

    public final MarkdownAtUser copy(String r100, String r101, boolean r110, boolean r111, boolean r112) {
        return new MarkdownAtUser(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MarkdownAtUser) == true) goto L8;
        return false;
    L8:
        MarkdownAtUser r101 = (MarkdownAtUser) r100;
        if (Intrinsics.areEqual(this.userId, r101.userId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (this.isOutChatUser == r101.isOutChatUser) goto L18;
        return false;
    L18:
        if (this.isAnonymous == r101.isAnonymous) goto L21;
        return false;
    L21:
        if (this.isHighLight == r101.isHighLight) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.userId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.content;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        int r105 = (r103 + r101) * 31;
        int r106 = 1231;
        if (this.isOutChatUser == false) goto L13;
        int r107 = 1231;
    L14:
        int r108 = (r105 + r107) * 31;
        if (this.isAnonymous == false) goto L17;
        int r109 = 1231;
    L18:
        int r110 = (r108 + r109) * 31;
        if (this.isHighLight == true) goto L23;
        r106 = 1237;
    L23:
        return r110 + r106;
    L17:
        r109 = 1237;
        goto L18
    L13:
        r107 = 1237;
        goto L14
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "MarkdownAtUser(userId=" + this.userId + ", content=" + this.content + ", isOutChatUser=" + this.isOutChatUser + ", isAnonymous=" + this.isAnonymous + ", isHighLight=" + this.isHighLight + ')';
    }

    public final String getContent() {
        return this.content;
    }

    public final String getUserId() {
        return this.userId;
    }

    public final boolean isAnonymous() {
        return this.isAnonymous;
    }

    public final boolean isHighLight() {
        return this.isHighLight;
    }

    public final boolean isOutChatUser() {
        return this.isOutChatUser;
    }

    public MarkdownAtUser(String r100, String r101, boolean r102, boolean r103, boolean r104) {
        this.userId = r100;
        this.content = r101;
        this.isOutChatUser = r102;
        this.isAnonymous = r103;
        this.isHighLight = r104;
    }

    public /* synthetic */ MarkdownAtUser(String r100, String r101, boolean r102, boolean r103, boolean r104, int r105, DefaultConstructorMarker r110) {
        String r106 = null;
        if ((r105 & 1) == 0) goto L5;
        String r111 = null;
    L7:
        if ((r105 & 2) != 0) goto L11;
        r106 = r101;
    L11:
        if ((r105 & 4) == 0) goto L13;
        boolean r107 = false;
    L15:
        if ((r105 & 8) == 0) goto L17;
        boolean r108 = false;
    L19:
        if ((r105 & 16) == 0) goto L21;
        boolean r109 = false;
    L22:
        this(r111, r106, r107, r108, r109);
        return;
    L21:
        r109 = r104;
        goto L22
    L17:
        r108 = r103;
        goto L19
    L13:
        r107 = r102;
        goto L15
    L5:
        r111 = r100;
        goto L7
    }
}
