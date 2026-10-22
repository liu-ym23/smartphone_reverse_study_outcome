package com.ss.android.lark.widget.richtext.json;

import com.bytedance.android.ecom.arch.slice.render.SlcElement;
import com.facebook.keyframes.model.KFAnimation;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001+B\u0081\u0001\u0012\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\b\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0004HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0003J\u000f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00040\bHÆ\u0003J\t\u0010$\u001a\u00020\u000eHÆ\u0003J\u0083\u0001\u0010%\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00042\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u000e\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\b\b\u0002\u0010\r\u001a\u00020\u000eHÆ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010)\u001a\u00020\u000eHÖ\u0001J\t\u0010*\u001a\u00020\u0004HÖ\u0001R\"\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001c\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/ss/android/lark/widget/richtext/json/RichTextBean;", "", SlcElement.KEY_ELEMENTS, "", "", "Lcom/ss/android/lark/widget/richtext/json/RichTextBean$RichTextElementBean;", "innerText", "imageIds", "", "elementIds", "atIds", "anchorIds", "markdownIds", "richTextVersion", "", "<init>", "(Ljava/util/Map;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;I)V", "getElements", "()Ljava/util/Map;", "getInnerText", "()Ljava/lang/String;", "getImageIds", "()Ljava/util/List;", "getElementIds", "getAtIds", "getAnchorIds", "getMarkdownIds", "getRichTextVersion", "()I", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "toString", "RichTextElementBean", "richtext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("anchorIds")
    private final List<String> anchorIds;

    @SerializedName("atIds")
    private final List<String> atIds;

    @SerializedName("elementIds")
    private final List<String> elementIds;

    @SerializedName(SlcElement.KEY_ELEMENTS)
    private final Map<String, C5428a> elements;

    @SerializedName("imageIds")
    private final List<String> imageIds;

    @SerializedName("innerText")
    private final String innerText;

    @SerializedName("markdownIds")
    private final List<String> markdownIds;

    @SerializedName("richTextVersion")
    private final int richTextVersion;

    /* JADX INFO: renamed from: com.ss.android.lark.widget.richtext.json.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u0015\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nHÆ\u0003JC\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\nHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\bHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\"\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/ss/android/lark/widget/richtext/json/RichTextBean$RichTextElementBean;", "", "tag", "", KFAnimation.PROPERTY_TYPE_JSON_FIELD, "Lcom/google/gson/JsonObject;", "childIds", "", "", "style", "", "<init>", "(ILcom/google/gson/JsonObject;Ljava/util/List;Ljava/util/Map;)V", "getTag", "()I", "getProperty", "()Lcom/google/gson/JsonObject;", "getChildIds", "()Ljava/util/List;", "getStyle", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "richtext_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C5428a {

        @SerializedName("childIds")
        private final List<String> childIds;

        @SerializedName(KFAnimation.PROPERTY_TYPE_JSON_FIELD)
        private final JsonObject property;

        @SerializedName("style")
        private final Map<String, String> style;

        @SerializedName("tag")
        private final int tag;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5428a) == true) goto L8;
            return false;
        L8:
            C5428a r101 = (C5428a) r100;
            if (this.tag == r101.tag) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.property, r101.property) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.childIds, r101.childIds) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.style, r101.style) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.tag * 31) + this.property.hashCode()) * 31) + this.childIds.hashCode()) * 31) + this.style.hashCode();
        }

        public final String toString() {
            return "RichTextElementBean(tag=" + this.tag + ", property=" + this.property + ", childIds=" + this.childIds + ", style=" + this.style + ')';
        }

        public C5428a() {
            JsonObject r100 = new JsonObject();
            List<String> r101 = CollectionsKt.emptyList();
            Map<String, String> r102 = MapsKt.emptyMap();
            Intrinsics.checkNotNullParameter(r100, KFAnimation.PROPERTY_TYPE_JSON_FIELD);
            Intrinsics.checkNotNullParameter(r101, "childIds");
            Intrinsics.checkNotNullParameter(r102, "style");
            this.tag = 0;
            this.property = r100;
            this.childIds = r101;
            this.style = r102;
        }
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.elements, r101.elements) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.innerText, r101.innerText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.imageIds, r101.imageIds) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.elementIds, r101.elementIds) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.atIds, r101.atIds) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.anchorIds, r101.anchorIds) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.markdownIds, r101.markdownIds) == true) goto L30;
        return false;
    L30:
        if (this.richTextVersion == r101.richTextVersion) goto L32;
        return false;
    L32:
        return true;
    }

    public final int hashCode() {
        return (((((((((((((this.elements.hashCode() * 31) + this.innerText.hashCode()) * 31) + this.imageIds.hashCode()) * 31) + this.elementIds.hashCode()) * 31) + this.atIds.hashCode()) * 31) + this.anchorIds.hashCode()) * 31) + this.markdownIds.hashCode()) * 31) + this.richTextVersion;
    }

    public final String toString() {
        return "RichTextBean(elements=" + this.elements + ", innerText=" + this.innerText + ", imageIds=" + this.imageIds + ", elementIds=" + this.elementIds + ", atIds=" + this.atIds + ", anchorIds=" + this.anchorIds + ", markdownIds=" + this.markdownIds + ", richTextVersion=" + this.richTextVersion + ')';
    }

    public a() {
        Map<String, C5428a> r100 = MapsKt.emptyMap();
        List<String> r101 = CollectionsKt.emptyList();
        List<String> r102 = CollectionsKt.emptyList();
        List<String> r103 = CollectionsKt.emptyList();
        List<String> r104 = CollectionsKt.emptyList();
        List<String> r105 = CollectionsKt.emptyList();
        Intrinsics.checkNotNullParameter(r100, SlcElement.KEY_ELEMENTS);
        Intrinsics.checkNotNullParameter("", "innerText");
        Intrinsics.checkNotNullParameter(r101, "imageIds");
        Intrinsics.checkNotNullParameter(r102, "elementIds");
        Intrinsics.checkNotNullParameter(r103, "atIds");
        Intrinsics.checkNotNullParameter(r104, "anchorIds");
        Intrinsics.checkNotNullParameter(r105, "markdownIds");
        this.elements = r100;
        this.innerText = "";
        this.imageIds = r101;
        this.elementIds = r102;
        this.atIds = r103;
        this.anchorIds = r104;
        this.markdownIds = r105;
        this.richTextVersion = 0;
    }
}
