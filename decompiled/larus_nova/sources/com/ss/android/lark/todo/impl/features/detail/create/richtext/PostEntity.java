package com.ss.android.lark.todo.impl.features.detail.create.richtext;

import com.alipay.sdk.m.x.d;
import com.ss.android.lark.widget.richtext.RichText;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/ss/android/lark/todo/impl/features/detail/create/richtext/PostEntity;", "Ljava/io/Serializable;", "title", "", "content", "Lcom/ss/android/lark/widget/richtext/RichText;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/widget/richtext/RichText;)V", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "getContent", "()Lcom/ss/android/lark/widget/richtext/RichText;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "todo_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PostEntity implements Serializable {
    private final RichText content;
    private String title;

    public static /* synthetic */ PostEntity copy$default(PostEntity r100, String r101, RichText r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.content;
    L9:
        return r100.copy(r101, r102);
    }

    public final String component1() {
        return this.title;
    }

    public final RichText component2() {
        return this.content;
    }

    public final PostEntity copy(String r100, RichText r101) {
        return new PostEntity(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PostEntity) == true) goto L8;
        return false;
    L8:
        PostEntity r101 = (PostEntity) r100;
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public int hashCode() {
        String r100 = this.title;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        RichText r104 = this.content;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "PostEntity(title=" + this.title + ", content=" + this.content + ')';
    }

    public final RichText getContent() {
        return this.content;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public PostEntity(String r100, RichText r101) {
        this.title = r100;
        this.content = r101;
    }
}
