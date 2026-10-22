package com.ss.android.lark.chatwindow.launcher.transform;

import com.ss.android.lark.biz.im.api.bundle.v2.base.output.ChatBundleV2;
import com.ss.android.lark.chat.entity.chat.Chat;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatBundleV2 f416987a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Chat f416988b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (Intrinsics.areEqual(this.f416987a, r101.f416987a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f416988b, r101.f416988b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f416987a.hashCode() * 31;
        Chat r101 = this.f416988b;
        if (r101 != null) goto L5;
        int r102 = 0;
    L7:
        return r100 + r102;
    L5:
        r102 = r101.hashCode();
        goto L7
    }

    public final String toString() {
        return "TransformResult(chatBundle=" + this.f416987a + ", chat=" + this.f416988b + ')';
    }

    public d(ChatBundleV2 r100, Chat r101) {
        Intrinsics.checkNotNullParameter(r100, "chatBundle");
        this.f416987a = r100;
        this.f416988b = r101;
    }
}
