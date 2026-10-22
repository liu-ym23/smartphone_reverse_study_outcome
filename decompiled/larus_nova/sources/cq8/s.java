package cq8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class s extends y {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f464952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f464953c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof s) == true) goto L8;
        return false;
    L8:
        s r101 = (s) r100;
        if (Intrinsics.areEqual(this.f464952b, r101.f464952b) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f464953c, r101.f464953c) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f464952b.hashCode() * 31;
        Long r101 = this.f464953c;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "ImageListTemplatePromptAction(widgetId=" + this.f464952b + ", styleId=" + this.f464953c + ')';
    }

    @Override // cq8.y
    public final String a() {
        return this.f464952b;
    }

    public s(String r100, Long r101) {
        Intrinsics.checkNotNullParameter(r100, "widgetId");
        super("ImageListTemplatePromptAction");
        this.f464952b = r100;
        this.f464953c = r101;
    }
}
