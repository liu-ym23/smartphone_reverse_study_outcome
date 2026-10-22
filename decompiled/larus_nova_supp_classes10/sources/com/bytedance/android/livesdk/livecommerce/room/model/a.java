package com.bytedance.android.livesdk.livecommerce.room.model;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a extends ql.a {
    public String a;
    public String b;

    public final String getCover() {
        String r0 = this.a;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public final String getTitle() {
        return this.b;
    }

    public final void setCover(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cover");
        this.a = r2;
    }

    public final void setTitle(String r1) {
        this.b = r1;
    }

    public a(String r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
