package gq5;

import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.VirtualNode;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.j;
import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a {
    public static final boolean c(j r1) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        if (r1.o == 1) goto L7;
        return false;
    L7:
        return true;
    }

    public static final String a(j r1, String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r1, "<this>");
        Intrinsics.checkNotNullParameter(r2, "originEvent");
        if (r3 == true) goto L5;
        return r2;
    L5:
        int r4 = r2.hashCode();
        if (r4 == (-1289167206)) goto L39;
        if (r4 == (-632085587)) goto L20;
        if (r4 == 3433103) goto L13;
    L57:
        return r2;
    L13:
        if (r2.equals(ResourceData.KEY_PAGE) == false) goto L57;
        if (TextUtils.equals("wikiroot%title_total_share_token", r1.b) == false) goto L58;
        return "view_all_shared";
    L58:
        return ResourceData.KEY_PAGE;
    L20:
        if (r2.equals("collapse") == false) goto L57;
        if (Intrinsics.areEqual(r1.b, VirtualNode.TITLE_ROOT_CLOUD_DOCUMENT.getRootToken()) == false) goto L27;
        return "collapse_pindocs";
    L27:
        if (Intrinsics.areEqual(r1.b, VirtualNode.TITLE_ROOT_SHARE.getRootToken()) == false) goto L31;
        return "collapse_shared";
    L31:
        if (Intrinsics.areEqual(r1.b, VirtualNode.TITLE_ROOT_SPACE.getRootToken()) == false) goto L35;
        return "collapse_pinwiki";
    L35:
        if (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.c.b(r1) == false) goto L57;
        return "collapse_personal";
    L39:
        if (r2.equals("expand") == false) goto L57;
        if (Intrinsics.areEqual(r1.b, VirtualNode.TITLE_ROOT_CLOUD_DOCUMENT.getRootToken()) == false) goto L46;
        return "expand_pindocs";
    L46:
        if (Intrinsics.areEqual(r1.b, VirtualNode.TITLE_ROOT_SHARE.getRootToken()) == false) goto L50;
        return "expand_shared";
    L50:
        if (Intrinsics.areEqual(r1.b, VirtualNode.TITLE_ROOT_SPACE.getRootToken()) == false) goto L54;
        return "expand_pinwiki";
    L54:
        if (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.c.b(r1) == false) goto L57;
        return "expand_personal";
    }

    public static final String b(j r3, boolean r4, String r5) {
        Intrinsics.checkNotNullParameter(r3, "<this>");
        if (r4 == true) goto L6;
        return "wiki_tree";
    L6:
        if (com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.c.a(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r3.n, 0)) == false) goto L9;
        return "sidebar_pin_docs";
    L9:
        if (TextUtils.equals("wikiroot%title_root_share_token", com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r3.n, 0)) == false) goto L12;
        return "sidebar_shared";
    L12:
        if (Intrinsics.areEqual(com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r3.n, 0), r5) == false) goto L15;
        return "sidebar_my_docs";
    L15:
        if (TextUtils.equals("wikiroot%top_wiki_token", com.bytedance.ee.bear.wikiv2.wikitreev2.widget.bean.b.c(r3.n, 0)) == false) goto L21;
        return "sidebar_pin_wiki";
    L21:
        return "wiki_tree";
    }
}
