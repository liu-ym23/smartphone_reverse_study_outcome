package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.WikiAction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public final FragmentActivity a;
    public final WikiAction b;
    public final Throwable c;
    public final String d;
    public final String e;
    public final boolean f;
    public final int g;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.e, r6.e) == true) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        FragmentActivity r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L6:
        int r2 = ((((((((r1 * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31;
        if (this.f == false) goto L9;
        int r3 = 1231;
    L11:
        return ((r2 + r3) * 31) + this.g;
    L9:
        r3 = 1237;
        goto L11
    L5:
        r1 = r0.hashCode();
        goto L6
    }

    public final String toString() {
        return "DelErrorInfo(context=" + this.a + ", wikiAction=" + this.b + ", throwable=" + this.c + ", wikiToken=" + this.d + ", spaceId=" + this.e + ", isDeleteWithSub=" + this.f + ", defaultErrRes=" + this.g + ')';
    }

    public final FragmentActivity getContext() {
        return this.a;
    }

    public a(FragmentActivity r10, WikiAction r11, Throwable r12, String r13, String r14, boolean r15) {
        Intrinsics.checkNotNullParameter(r11, "wikiAction");
        Intrinsics.checkNotNullParameter(r12, "throwable");
        Intrinsics.checkNotNullParameter(r13, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r14, "spaceId");
        this(r10, r11, r12, r13, r14, r15, 2131887463);
    }

    public a(FragmentActivity r2, WikiAction r3, Throwable r4, String r5, String r6, boolean r7, int r8) {
        Intrinsics.checkNotNullParameter(r3, "wikiAction");
        Intrinsics.checkNotNullParameter(r4, "throwable");
        Intrinsics.checkNotNullParameter(r5, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r6, "spaceId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
        this.g = r8;
    }
}
