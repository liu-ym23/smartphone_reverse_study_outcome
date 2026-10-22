package com.larksuite.component.blockit.entity.richtext;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tB\u0013\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\nB\u0013\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\u000bB\u0013\b\u0016\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\fB\u001d\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\b\u0010\rJ\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J-\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\nR\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u000bR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\f¨\u0006#"}, d2 = {"Lcom/larksuite/component/blockit/entity/richtext/MessageContentEntity;", "Ljava/io/Serializable;", "commonEntity", "Lcom/larksuite/component/blockit/entity/richtext/CommonEntity;", "textEntity", "Lcom/larksuite/component/blockit/entity/richtext/TextEntity;", "postEntity", "Lcom/larksuite/component/blockit/entity/richtext/PostEntity;", "<init>", "(Lcom/larksuite/component/blockit/entity/richtext/CommonEntity;Lcom/larksuite/component/blockit/entity/richtext/TextEntity;Lcom/larksuite/component/blockit/entity/richtext/PostEntity;)V", "(Lcom/larksuite/component/blockit/entity/richtext/CommonEntity;)V", "(Lcom/larksuite/component/blockit/entity/richtext/TextEntity;)V", "(Lcom/larksuite/component/blockit/entity/richtext/PostEntity;)V", "(Lcom/larksuite/component/blockit/entity/richtext/CommonEntity;Lcom/larksuite/component/blockit/entity/richtext/TextEntity;)V", "getCommonEntity", "()Lcom/larksuite/component/blockit/entity/richtext/CommonEntity;", "setCommonEntity", "getTextEntity", "()Lcom/larksuite/component/blockit/entity/richtext/TextEntity;", "setTextEntity", "getPostEntity", "()Lcom/larksuite/component/blockit/entity/richtext/PostEntity;", "setPostEntity", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "blockit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MessageContentEntity implements Serializable {
    private CommonEntity commonEntity;
    private PostEntity postEntity;
    private TextEntity textEntity;

    public static /* synthetic */ MessageContentEntity copy$default(MessageContentEntity r100, CommonEntity r101, TextEntity r102, PostEntity r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.commonEntity;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.textEntity;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.postEntity;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final CommonEntity component1() {
        return this.commonEntity;
    }

    public final TextEntity component2() {
        return this.textEntity;
    }

    public final PostEntity component3() {
        return this.postEntity;
    }

    public final MessageContentEntity copy(CommonEntity r100, TextEntity r101, PostEntity r102) {
        return new MessageContentEntity(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof MessageContentEntity) == true) goto L8;
        return false;
    L8:
        MessageContentEntity r101 = (MessageContentEntity) r100;
        if (Intrinsics.areEqual(this.commonEntity, r101.commonEntity) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.textEntity, r101.textEntity) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.postEntity, r101.postEntity) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        CommonEntity r100 = this.commonEntity;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        TextEntity r104 = this.textEntity;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        PostEntity r107 = this.postEntity;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "MessageContentEntity(commonEntity=" + this.commonEntity + ", textEntity=" + this.textEntity + ", postEntity=" + this.postEntity + ')';
    }

    public final CommonEntity getCommonEntity() {
        return this.commonEntity;
    }

    public final PostEntity getPostEntity() {
        return this.postEntity;
    }

    public final TextEntity getTextEntity() {
        return this.textEntity;
    }

    public MessageContentEntity(CommonEntity r100) {
        this(r100, null, null);
    }

    public final void setCommonEntity(CommonEntity r100) {
        this.commonEntity = r100;
    }

    public final void setPostEntity(PostEntity r100) {
        this.postEntity = r100;
    }

    public final void setTextEntity(TextEntity r100) {
        this.textEntity = r100;
    }

    public MessageContentEntity(PostEntity r100) {
        this(null, null, r100);
    }

    public MessageContentEntity(TextEntity r100) {
        this(null, r100, null);
    }

    public MessageContentEntity(CommonEntity r100, TextEntity r101) {
        this(r100, r101, null);
    }

    public MessageContentEntity(CommonEntity r100, TextEntity r101, PostEntity r102) {
        this.commonEntity = r100;
        this.textEntity = r101;
        this.postEntity = r102;
    }
}
