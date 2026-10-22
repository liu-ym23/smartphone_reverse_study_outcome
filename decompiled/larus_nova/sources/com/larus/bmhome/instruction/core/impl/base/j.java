package com.larus.bmhome.instruction.core.impl.base;

import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class j extends d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f311943b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final bq8.a f311944c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof j) == true) goto L8;
        return false;
    L8:
        j r101 = (j) r100;
        if (Intrinsics.areEqual(this.f311943b, r101.f311943b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f311944c, r101.f311944c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f311943b.hashCode() * 31) + this.f311944c.hashCode();
    }

    public final String toString() {
        return "InstructionMusicTemplatePromptEvent(sourceWidgetId=" + this.f311943b + ", template=" + this.f311944c + ')';
    }

    @Override // com.larus.bmhome.instruction.core.impl.base.d
    public final String a() {
        return this.f311943b;
    }

    public j(String r100, bq8.a r101) {
        Intrinsics.checkNotNullParameter(r100, "sourceWidgetId");
        Intrinsics.checkNotNullParameter(r101, ThumbGlideUrl.SOURCE_TEMPLATE);
        super("InstructionMusicTemplatePromptEvent");
        this.f311943b = r100;
        this.f311944c = r101;
    }
}
