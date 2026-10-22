package com.larksuite.component.blockit.entity.richtext;

import com.alipay.sdk.m.x.d;
import com.ss.android.lark.doc.entity.Doc;
import com.ss.android.lark.widget.richtext.RichText;
import java.io.Serializable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0017\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J9\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0016\b\u0002\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001e"}, d2 = {"Lcom/larksuite/component/blockit/entity/richtext/PostEntity;", "Ljava/io/Serializable;", "title", "", "content", "Lcom/ss/android/lark/widget/richtext/RichText;", "docEntity", "", "Lcom/ss/android/lark/doc/entity/Doc;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/widget/richtext/RichText;Ljava/util/Map;)V", "getTitle", "()Ljava/lang/String;", d.f25925o, "(Ljava/lang/String;)V", "getContent", "()Lcom/ss/android/lark/widget/richtext/RichText;", "getDocEntity", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "blockit_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PostEntity implements Serializable {
    private final RichText content;
    private final Map<String, Doc> docEntity;
    private String title;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ PostEntity copy$default(PostEntity r100, String r101, RichText r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.title;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.content;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.docEntity;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.title;
    }

    public final RichText component2() {
        return this.content;
    }

    public final Map<String, Doc> component3() {
        return this.docEntity;
    }

    public final PostEntity copy(String r100, RichText r101, Map<String, ? extends Doc> r102) {
        return new PostEntity(r100, r101, r102);
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
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.docEntity, r101.docEntity) == true) goto L17;
        return false;
    L17:
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
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Doc> r107 = this.docEntity;
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
        return "PostEntity(title=" + this.title + ", content=" + this.content + ", docEntity=" + this.docEntity + ')';
    }

    public final RichText getContent() {
        return this.content;
    }

    public final Map<String, Doc> getDocEntity() {
        return this.docEntity;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public PostEntity(String r100, RichText r101, Map<String, ? extends Doc> r102) {
        this.title = r100;
        this.content = r101;
        this.docEntity = r102;
    }
}
