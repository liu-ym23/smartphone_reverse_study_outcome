package com.ss.android.lark.search.doubao.api.info;

import java.io.Serializable;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\"\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J%\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\bHÆ\u0003JC\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052$\b\u0002\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR-\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0007j\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/ss/android/lark/search/doubao/api/info/TagContent;", "Ljava/io/Serializable;", "tag", "", "content", "Lcom/ss/android/lark/search/doubao/api/info/Content;", "attributeMap", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/search/doubao/api/info/Content;Ljava/util/HashMap;)V", "getTag", "()Ljava/lang/String;", "getContent", "()Lcom/ss/android/lark/search/doubao/api/info/Content;", "getAttributeMap", "()Ljava/util/HashMap;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "search-doubao-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TagContent implements Serializable {
    private final HashMap<String, String> attributeMap;
    private final Content content;
    private final String tag;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TagContent copy$default(TagContent r100, String r101, Content r102, HashMap r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.tag;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.content;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.attributeMap;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.tag;
    }

    public final Content component2() {
        return this.content;
    }

    public final HashMap<String, String> component3() {
        return this.attributeMap;
    }

    public final TagContent copy(String r100, Content r101, HashMap<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "attributeMap");
        return new TagContent(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TagContent) == true) goto L8;
        return false;
    L8:
        TagContent r101 = (TagContent) r100;
        if (Intrinsics.areEqual(this.tag, r101.tag) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r101.content) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.attributeMap, r101.attributeMap) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        return (((this.tag.hashCode() * 31) + this.content.hashCode()) * 31) + this.attributeMap.hashCode();
    }

    public String toString() {
        return "TagContent(tag=" + this.tag + ", content=" + this.content + ", attributeMap=" + this.attributeMap + ')';
    }

    public final HashMap<String, String> getAttributeMap() {
        return this.attributeMap;
    }

    public final Content getContent() {
        return this.content;
    }

    public final String getTag() {
        return this.tag;
    }

    public TagContent(String r100, Content r101, HashMap<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "content");
        Intrinsics.checkNotNullParameter(r102, "attributeMap");
        this.tag = r100;
        this.content = r101;
        this.attributeMap = r102;
    }
}
