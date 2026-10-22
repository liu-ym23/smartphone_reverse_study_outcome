package com.bytedance.ee.bear.wikiv2.wikitreev2.widget.view;

import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.api.GetMoveNodeAuthorizedUserInfoPuller;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentManager f242464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final GetMoveNodeAuthorizedUserInfoPuller.Result f242465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f242466c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f242467d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f242468e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f242469f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f242470g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L8;
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(this.f242464a, r101.f242464a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f242465b, r101.f242465b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f242466c, r101.f242466c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f242467d, r101.f242467d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f242468e, r101.f242468e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f242469f, r101.f242469f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f242470g, r101.f242470g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        return (((((((((((this.f242464a.hashCode() * 31) + this.f242465b.hashCode()) * 31) + this.f242466c.hashCode()) * 31) + this.f242467d.hashCode()) * 31) + this.f242468e.hashCode()) * 31) + this.f242469f.hashCode()) * 31) + this.f242470g.hashCode();
    }

    public final String toString() {
        return "ShowApplyWiki2WikiParam(fragmentManager=" + this.f242464a + ", user=" + this.f242465b + ", wikiToken=" + this.f242466c + ", srcSpaceId=" + this.f242467d + ", srcParentToken=" + this.f242468e + ", desSpaceId=" + this.f242469f + ", destParentToken=" + this.f242470g + ')';
    }

    public f(FragmentManager r100, GetMoveNodeAuthorizedUserInfoPuller.Result r101, String r102, String r103, String r104, String r105, String r106) {
        Intrinsics.checkNotNullParameter(r100, "fragmentManager");
        Intrinsics.checkNotNullParameter(r101, "user");
        Intrinsics.checkNotNullParameter(r102, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r103, "srcSpaceId");
        Intrinsics.checkNotNullParameter(r104, "srcParentToken");
        Intrinsics.checkNotNullParameter(r105, "desSpaceId");
        Intrinsics.checkNotNullParameter(r106, "destParentToken");
        this.f242464a = r100;
        this.f242465b = r101;
        this.f242466c = r102;
        this.f242467d = r103;
        this.f242468e = r104;
        this.f242469f = r105;
        this.f242470g = r106;
    }
}
