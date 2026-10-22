package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.move.apply.ApplyMoveSpaceType;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetMoveNodeAuthorizedUserInfoPuller;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e {
    public final FragmentManager a;
    public final GetMoveNodeAuthorizedUserInfoPuller.Result b;
    public final String c;
    public final String d;
    public final boolean e;
    public final ApplyMoveSpaceType f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L8;
        return false;
    L8:
        e r6 = (e) r5;
        if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.c, r6.c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.d, r6.d) == true) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r0 = ((((((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31;
        if (this.e == false) goto L5;
        int r1 = 1231;
    L7:
        return ((r0 + r1) * 31) + this.f.hashCode();
    L5:
        r1 = 1237;
        goto L7
    }

    public final String toString() {
        return "ShowApplyMovWiki2SpaceParam(fragmentManager=" + this.a + ", user=" + this.b + ", wikiToken=" + this.c + ", spaceFolderToken=" + this.d + ", moveToOwnerSpace=" + this.e + ", applyType=" + this.f + ')';
    }

    public e(FragmentManager r2, GetMoveNodeAuthorizedUserInfoPuller.Result r3, String r4, String r5, boolean r6, ApplyMoveSpaceType r7) {
        Intrinsics.checkNotNullParameter(r2, "fragmentManager");
        Intrinsics.checkNotNullParameter(r3, "user");
        Intrinsics.checkNotNullParameter(r4, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r5, "spaceFolderToken");
        Intrinsics.checkNotNullParameter(r7, "applyType");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
