package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.move.apply.ApplyMoveSpaceType;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetMoveNodeAuthorizedUserInfoPuller;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentManager f242454a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GetMoveNodeAuthorizedUserInfoPuller.Result f242455b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f242456c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f242457d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f242458e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ApplyMoveSpaceType f242459f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f242454a, r101.f242454a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f242455b, r101.f242455b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f242456c, r101.f242456c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f242457d, r101.f242457d) == true) goto L21;
        return false;
    L21:
        if (this.f242458e == r101.f242458e) goto L24;
        return false;
    L24:
        if (this.f242459f == r101.f242459f) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        int r100 = ((((((this.f242454a.hashCode() * 31) + this.f242455b.hashCode()) * 31) + this.f242456c.hashCode()) * 31) + this.f242457d.hashCode()) * 31;
        if (this.f242458e == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.f242459f.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public final String toString() {
        return "ShowApplyMovWiki2SpaceParam(fragmentManager=" + this.f242454a + ", user=" + this.f242455b + ", wikiToken=" + this.f242456c + ", spaceFolderToken=" + this.f242457d + ", moveToOwnerSpace=" + this.f242458e + ", applyType=" + this.f242459f + ')';
    }

    public e(FragmentManager r100, GetMoveNodeAuthorizedUserInfoPuller.Result r101, String r102, String r103, boolean r104, ApplyMoveSpaceType r105) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        Intrinsics.checkNotNullParameter(r101, "user");
        Intrinsics.checkNotNullParameter(r102, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r103, "spaceFolderToken");
        Intrinsics.checkNotNullParameter(r105, "applyType");
        this.f242454a = r100;
        this.f242455b = r101;
        this.f242456c = r102;
        this.f242457d = r103;
        this.f242458e = r104;
        this.f242459f = r105;
    }
}
