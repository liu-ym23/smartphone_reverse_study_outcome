package io.opentelemetry.api.internal;

import io.opentelemetry.api.common.AttributeType;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes41.dex */
public final class i<T> implements itc.f<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AttributeType f492675a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f492676b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f492677c;

    @Override // itc.f
    public final String getKey() {
        return this.f492676b;
    }

    @Override // itc.f
    public AttributeType getType() {
        return this.f492675a;
    }

    public final int hashCode() {
        return this.f492677c;
    }

    public final String toString() {
        return this.f492676b;
    }

    public final boolean equals(@Nullable Object r100) {
        if (r100 != this) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == false) goto L14;
        i r101 = (i) r100;
        if (this.f492675a.equals(r101.getType()) == true) goto L10;
    L12:
        return false;
    L10:
        if (this.f492676b.equals(r101.f492676b) == false) goto L12;
        return true;
    L14:
        return false;
    }

    public i(AttributeType r100, String r101) {
        if (r100 == null) goto L7;
        this.f492675a = r100;
        this.f492676b = r101;
        this.f492677c = ((r100.hashCode() ^ 1000003) * 1000003) ^ r101.hashCode();
        return;
    L7:
        throw new NullPointerException("Null type");
    }

    public static i a(@Nullable String r100, AttributeType r101) {
        if (r100 != null) goto L7;
        r100 = "";
    L7:
        return new i(r101, r100);
    }
}
