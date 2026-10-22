package iq5;

import android.view.View;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class o {
    public final View a;
    public final int b;
    public final String c;
    public final String d;
    public final String e;
    public final String f;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o) == true) goto L8;
        return false;
    L8:
        o r6 = (o) r5;
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
        if (Intrinsics.areEqual(this.f, r6.f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        View r0 = this.a;
        if (r0 != null) goto L5;
        int r1 = 0;
    L7:
        return (((((((((r1 * 31) + this.b) * 31) + this.c.hashCode()) * 31) + this.d.hashCode()) * 31) + this.e.hashCode()) * 31) + this.f.hashCode();
    L5:
        r1 = r0.hashCode();
        goto L7
    }

    public final String toString() {
        return "SelectorWikiClickBean(view=" + this.a + ", position=" + this.b + ", wikiToken=" + this.c + ", title=" + this.d + ", spaceId=" + this.e + ", spaceName=" + this.f + ')';
    }

    public o(View r2, int r3, String r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, WikiFolderPushPlugin.WIKI_TOKEN);
        Intrinsics.checkNotNullParameter(r5, "title");
        Intrinsics.checkNotNullParameter(r6, "spaceId");
        Intrinsics.checkNotNullParameter(r7, "spaceName");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
