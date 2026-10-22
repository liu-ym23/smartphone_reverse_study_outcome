package com.larus.bmhome.chat.component.bottom.core.inputtext.mention;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionDriveContent;", "", "titleHighlighted", "", "resultMeta", "Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionDriveMeta;", "<init>", "(Ljava/lang/String;Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionDriveMeta;)V", "getTitleHighlighted", "()Ljava/lang/String;", "getResultMeta", "()Lcom/larus/bmhome/chat/component/bottom/core/inputtext/mention/MentionDriveMeta;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class f {

    @SerializedName("result_meta")
    private final g resultMeta;

    @SerializedName("title_highlighted")
    private final String titleHighlighted;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.titleHighlighted, r101.titleHighlighted) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.resultMeta, r101.resultMeta) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        String r100 = this.titleHighlighted;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        g r104 = this.resultMeta;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "MentionDriveContent(titleHighlighted=" + this.titleHighlighted + ", resultMeta=" + this.resultMeta + ')';
    }

    public f() {
        this.titleHighlighted = null;
        this.resultMeta = null;
    }

    public final g a() {
        return this.resultMeta;
    }

    public final String b() {
        return this.titleHighlighted;
    }
}
