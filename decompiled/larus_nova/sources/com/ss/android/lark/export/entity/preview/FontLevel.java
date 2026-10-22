package com.ss.android.lark.export.entity.preview;

import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\u0010\u001a\u00020\u0000J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0002J\b\u0010\u0015\u001a\u00020\u0005H\u0016J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/ss/android/lark/export/entity/preview/FontLevel;", "Ljava/io/Serializable;", "type", "Lcom/ss/android/lark/export/entity/preview/FontType;", "level", "", "<init>", "(Lcom/ss/android/lark/export/entity/preview/FontType;I)V", "getType", "()Lcom/ss/android/lark/export/entity/preview/FontType;", "setType", "(Lcom/ss/android/lark/export/entity/preview/FontType;)V", "getLevel", "()I", "setLevel", "(I)V", "clone", "equals", "", "other", "", "hashCode", "component1", "component2", "copy", "toString", "", "chat-preview-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FontLevel implements Serializable {
    private int level;
    private FontType type;

    /* JADX WARN: Multi-variable type inference failed */
    public FontLevel() {
        FontType r100 = null;
        this(r100, 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ FontLevel copy$default(FontLevel r100, FontType r101, int r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.type;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.level;
    L9:
        return r100.copy(r101, r102);
    }

    public final FontType component1() {
        return this.type;
    }

    public final int component2() {
        return this.level;
    }

    public final FontLevel copy(FontType r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return new FontLevel(r100, r101);
    }

    public String toString() {
        return "FontLevel(type=" + this.type + ", level=" + this.level + ')';
    }

    public final FontLevel clone() {
        return new FontLevel(this.type, this.level);
    }

    public int hashCode() {
        return (this.type.hashCode() * 31) + this.level;
    }

    public final int getLevel() {
        return this.level;
    }

    public final FontType getType() {
        return this.type;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof FontLevel) == true) goto L8;
        return false;
    L8:
        FontLevel r101 = (FontLevel) r100;
        if (this.type == r101.type) goto L12;
        return false;
    L12:
        if (this.level == r101.level) goto L14;
        return false;
    L14:
        return true;
    }

    public final void setLevel(int r100) {
        this.level = r100;
    }

    public final void setType(FontType r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.type = r100;
    }

    public FontLevel(FontType r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, "type");
        this.type = r100;
        this.level = r101;
    }

    public /* synthetic */ FontLevel(FontType r100, int r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L6;
        r100 = FontType.CAPTION;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = 0;
    L8:
        this(r100, r101);
    }
}
