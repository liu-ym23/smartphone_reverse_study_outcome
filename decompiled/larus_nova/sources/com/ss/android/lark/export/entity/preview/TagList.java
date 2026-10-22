package com.ss.android.lark.export.entity.preview;

import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\n\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0019\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/TagList;", "Ljava/io/Serializable;", "mixedTags", "", "Lcom/ss/android/lark/export/entity/preview/KeyTag;", "<init>", "(Ljava/util/List;)V", "getMixedTags", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TagList implements Serializable {
    private final List<KeyTag> mixedTags;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ TagList copy$default(TagList r100, List r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.mixedTags;
    L6:
        return r100.copy(r101);
    }

    public final List<KeyTag> component1() {
        return this.mixedTags;
    }

    public final TagList copy(List<KeyTag> r100) {
        return new TagList(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof TagList) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.mixedTags, ((TagList) r100).mixedTags) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        List<KeyTag> r100 = this.mixedTags;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "TagList(mixedTags=" + this.mixedTags + ')';
    }

    public final List<KeyTag> getMixedTags() {
        return this.mixedTags;
    }

    public TagList(List<KeyTag> r100) {
        this.mixedTags = r100;
    }
}
