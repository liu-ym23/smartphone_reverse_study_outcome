package com.ss.android.lark.chat.base.model.dispatch;

import android.net.Uri;
import android.text.TextUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class c extends PreprocessParams {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f411763d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Uri f411764e;

    @Override // com.ss.android.lark.chat.base.model.dispatch.PreprocessParams
    public final boolean a() {
        if (TextUtils.isEmpty(this.f411763d) == false) goto L5;
    L8:
        return true;
    L5:
        if (this.f411764e != null) goto L8;
        return false;
    }

    public final int hashCode() {
        String r100 = this.f411763d;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Uri r104 = this.f411764e;
        if (r104 == null) goto L10;
        r101 = r104.hashCode();
    L10:
        return r103 + r101;
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "{ fileType: " + getType() + ", hashedPath: " + ((String) this.f411721c.getValue()) + ", " + this.f411720b + " }";
    }

    @Override // com.ss.android.lark.chat.base.model.dispatch.PreprocessParams
    public final String b() {
        return c();
    }

    public final String c() {
        if (a() == true) goto L6;
        return null;
    L6:
        Uri r100 = this.f411764e;
        if (r100 == null) goto L11;
        String r101 = r100.getPath();
        if (r101 == null) goto L11;
        return r101;
    L11:
        return this.f411763d;
    }

    public final boolean equals(Object r100) {
        if ((r100 instanceof c) == false) goto L5;
        c r101 = (c) r100;
    L6:
        if (r101 != null) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(c(), r101.c());
    L5:
        r101 = null;
        goto L6
    }

    public c(ResourceType r100, String r101, f r102) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(r102, "preUploadParams");
        super(r100, r102);
        this.f411763d = r101;
        this.f411764e = null;
    }
}
