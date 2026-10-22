package com.ss.android.lark.chat.preview.entity.component.property;

import com.bytedance.lark.pb.basic.v1.ComponentAttribute;
import com.ss.android.lark.export.entity.preview.BaseProperty;
import com.ss.android.lark.export.entity.preview.KeyTag;
import com.ss.android.lark.export.entity.preview.PreviewData;
import com.ss.android.lark.export.entity.preview.StringList;
import com.ss.android.lark.export.entity.preview.TagList;
import com.ss.android.lark.export.entity.preview.Type;
import com.ss.android.lark.export.entity.preview.UrlPreviewPropertyData;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B7\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\bH\u0016R$\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/ss/android/lark/chat/preview/entity/component/property/TagListProperty;", "Lcom/ss/android/lark/export/entity/preview/BaseProperty;", "tagString", "", "", "mixedTags", "Lcom/ss/android/lark/export/entity/preview/KeyTag;", "numberOfLines", "", "<init>", "(Ljava/util/List;Ljava/util/List;I)V", "getTagString", "()Ljava/util/List;", "setTagString", "(Ljava/util/List;)V", "getMixedTags", "setMixedTags", "getNumberOfLines", "()I", "setNumberOfLines", "(I)V", "patchData", "", "urlPreviewPropertyData", "Lcom/ss/android/lark/export/entity/preview/UrlPreviewPropertyData;", "equals", "", "other", "", "hashCode", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TagListProperty extends BaseProperty {
    private List<KeyTag> mixedTags;
    private int numberOfLines;
    private List<String> tagString;

    public TagListProperty() {
        this(null, null, 0, 7, null);
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public int hashCode() {
        int r100 = super.hashCode() * 31;
        List<String> r101 = this.tagString;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final List<KeyTag> getMixedTags() {
        return this.mixedTags;
    }

    public final int getNumberOfLines() {
        return this.numberOfLines;
    }

    public final List<String> getTagString() {
        return this.tagString;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty, com.ss.android.lark.tangram.base.props.Props
    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TagListProperty) == true) goto L9;
        return false;
    L9:
        if (super.equals(r100) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.tagString, ((TagListProperty) r100).tagString) == true) goto L14;
        return false;
    L14:
        return true;
    }

    @Override // com.ss.android.lark.export.entity.preview.BaseProperty
    public void patchData(UrlPreviewPropertyData r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        Iterator<Map.Entry<Integer, PreviewData>> r101 = r100.getPreviewPropertyData().entrySet().iterator();
    L6:
        if (r101.hasNext() == false) goto L32;
        Map.Entry<Integer, PreviewData> r102 = r101.next();
        int r103 = r102.getKey().intValue();
        List<String> r104 = null;
        List<KeyTag> r105 = null;
        r105 = null;
        r104 = null;
        if (r103 == ComponentAttribute.tags.getValue()) goto L9;
        if (r103 == ComponentAttribute.mixed_tags.getValue()) goto L17;
        if (r103 != ComponentAttribute.number_of_lines.getValue()) goto L6;
        PreviewData r106 = r102.getValue();
        if (r106 == null) goto L30;
        Integer r107 = r106.getInt();
        if (r107 == null) goto L30;
        int r108 = r107.intValue();
    L31:
        this.numberOfLines = r108;
    L30:
        r108 = 1;
        goto L31
    L17:
        PreviewData r109 = r102.getValue();
        if (r109 == null) goto L22;
        TagList r110 = r109.getTagList();
        if (r110 == null) goto L22;
        r105 = r110.getMixedTags();
    L22:
        this.mixedTags = r105;
        goto L6
    L9:
        PreviewData r111 = r102.getValue();
        if (r111 == null) goto L14;
        StringList r112 = r111.getStringList();
        if (r112 == null) goto L14;
        r104 = r112.getStringList();
    L14:
        this.tagString = r104;
        goto L6
    }

    public final void setMixedTags(List<KeyTag> r100) {
        this.mixedTags = r100;
    }

    public final void setNumberOfLines(int r100) {
        this.numberOfLines = r100;
    }

    public final void setTagString(List<String> r100) {
        this.tagString = r100;
    }

    public TagListProperty(List<String> r100, List<KeyTag> r101, int r102) {
        super(Type.TAG_LIST);
        this.tagString = r100;
        this.mixedTags = r101;
        this.numberOfLines = r102;
    }

    public /* synthetic */ TagListProperty(List r100, List r101, int r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = 1;
    L11:
        this(r100, r101, r102);
    }
}
