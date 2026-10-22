package com.ss.android.lark.chat.entity.tag;

import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.chat.entity.chatter.ChatChatter;
import com.ss.android.lark.chat.entity.chatter.Chatter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ss/android/lark/chat/entity/tag/TagData;", "Ljava/io/Serializable;", "tagDataItems", "", "Lcom/ss/android/lark/chat/entity/tag/TagDataItem;", "<init>", "(Ljava/util/List;)V", "getTagDataItems", "()Ljava/util/List;", "toString", "", "component1", "copy", "equals", "", "other", "", "hashCode", "", "Companion", "im-sdk-base_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TagData implements Serializable {
    public static final a Companion = null;
    private final List<TagDataItem> tagDataItems;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static TagData a(boolean r100) {
            if (r100 == false) goto L6;
            return new TagData(CollectionsKt.mutableListOf(new TagDataItem[]{new TagDataItem("Global", TagTypeEnum.RELATION_TAG, TagRelationTypeEnum.RELATION_TAG_PARTNER, 0)}));
        L6:
            return new TagData(new ArrayList());
        }

        @JvmStatic
        public static List b(TagData r100) {
            Intrinsics.checkNotNullParameter(r100, "<this>");
            ArrayList r101 = new ArrayList();
            Iterator<T> r102 = r100.getTagDataItems().iterator();
        L4:
            if (r102.hasNext() == false) goto L10;
            TagDataItem r103 = (TagDataItem) r102.next();
            if (r103.getTagType() != TagTypeEnum.TENANT_ENTITY_TAG) goto L8;
            int r104 = 4;
        L9:
            r101.add(new g08.a(r103.getText(), r104, r103.getPriority()));
            goto L4
        L8:
            r104 = r103.getRelationTagType().getValue();
            goto L9
        L10:
            return r101;
        }
    }

    static {
        Companion = new a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TagData copy$default(TagData r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.tagDataItems;
    L6:
        return r100.copy(r101);
    }

    @JvmStatic
    public static final TagData mockData(boolean r100) {
        Companion.getClass();
        return a.a(r100);
    }

    @JvmStatic
    public static final List<g08.a> parse(TagData r100) {
        Companion.getClass();
        return a.b(r100);
    }

    public final List<TagDataItem> component1() {
        return this.tagDataItems;
    }

    public final TagData copy(List<TagDataItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "tagDataItems");
        return new TagData(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TagData) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.tagDataItems, ((TagData) r100).tagDataItems) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        return this.tagDataItems.hashCode();
    }

    @JvmStatic
    public static final TagData mockData() {
        Companion.getClass();
        return a.a(true);
    }

    public String toString() {
        StringBuilder r100 = new StringBuilder("TagData(");
        Iterator<T> r101 = this.tagDataItems.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((TagDataItem) r101.next()).toString();
        goto L4
    L6:
        r100.append(Unit.INSTANCE);
        r100.append(')');
        return r100.toString();
    }

    public final List<TagDataItem> getTagDataItems() {
        return this.tagDataItems;
    }

    public TagData(List<TagDataItem> r100) {
        Intrinsics.checkNotNullParameter(r100, "tagDataItems");
        this.tagDataItems = r100;
    }

    @JvmStatic
    public static final TagData mockData(Chat r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "chat");
        return a.a(r100.isCrossTenant());
    }

    @JvmStatic
    public static final TagData mockData(ChatChatter r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "chatChatter");
        return a.a(r100.isCrossTenant());
    }

    @JvmStatic
    public static final TagData mockData(Chatter r100) {
        Companion.getClass();
        Intrinsics.checkNotNullParameter(r100, "chatter");
        return a.a(r100.isCrossTenant());
    }
}
