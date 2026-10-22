package iq5;

import android.view.View;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final View f495370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f495371b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f495372c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f495373d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f495374e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f495375f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f495370a, r101.f495370a) == true) goto L12;
        return false;
    L12:
        if (this.f495371b == r101.f495371b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f495372c, r101.f495372c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f495373d, r101.f495373d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f495374e, r101.f495374e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f495375f, r101.f495375f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        View r100 = this.f495370a;
        if (r100 != null) goto L5;
        int r101 = 0;
    L7:
        return (((((((((r101 * 31) + this.f495371b) * 31) + this.f495372c.hashCode()) * 31) + this.f495373d.hashCode()) * 31) + this.f495374e.hashCode()) * 31) + this.f495375f.hashCode();
    L5:
        r101 = r100.hashCode();
        goto L7
    }

    public final String toString() {
        return "SelectorWikiClickBean(view=" + this.f495370a + ", position=" + this.f495371b + ", wikiToken=" + this.f495372c + ", title=" + this.f495373d + ", spaceId=" + this.f495374e + ", spaceName=" + this.f495375f + ')';
    }

    public o(View r100, int r101, String r102, String r103, String r104, String r105) {
        Intrinsics.checkNotNullParameter(r102, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r103, "title");
        Intrinsics.checkNotNullParameter(r104, "spaceId");
        Intrinsics.checkNotNullParameter(r105, "spaceName");
        this.f495370a = r100;
        this.f495371b = r101;
        this.f495372c = r102;
        this.f495373d = r103;
        this.f495374e = r104;
        this.f495375f = r105;
    }
}
