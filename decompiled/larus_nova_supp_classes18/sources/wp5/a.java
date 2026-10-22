package wp5;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.offline.DocWikiInfo;
import com.bytedance.ee.bear.contract.offline.OfflineDoc;
import com.bytedance.ee.bear.contract.route.parcelable.b;
import com.bytedance.ee.bear.contract.route.parcelable.m;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.bear.wikiv2.wikitreev2.WikiTreeObserver;
import com.bytedance.ee.bear.wikiv2.wikitreev2.h;
import com.bytedance.ee.bear.wikiv2.wikitreev2.i;
import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.db.WikiDatabase;
import com.ss.android.lark.utils.p0;
import dq5.j;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import yq5.f;
import yq5.q;
import yq5.r;
import yq5.s;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a implements b {

    /* JADX INFO: renamed from: wp5.a$a, reason: collision with other inner class name */
    public static final class C0328a {
    }

    static {
    }

    public a() {
    }

    public final boolean a(m r14) {
        Intrinsics.checkNotNullParameter(r14, "entity");
        tt5.a.h("WikiDatabaseImpl", "insertOfflineDBTreeNode");
        f r0 = WikiDatabase.c().d();
        yq5.b r1 = r0.j(r14.b);
        if (r1 != null) goto L5;
        return false;
    L5:
        ArrayList<String> r3 = s.a(r1);
        if (r3 != null) goto L8;
        r3 = new ArrayList();
    L8:
        ArrayList<String> r4 = r3;
        r4.add(r14.a);
        int r5 = r.a;
        String r6 = CollectionsKt.joinToString$default(r4, ",", null, null, 0, null, null, 62, null);
        if (r6 != null) goto L11;
        r6 = "";
    L11:
        r1.l = r6;
        r14.g = r1.a;
        Intrinsics.checkNotNullParameter(r14, "<this>");
        r14.k = System.currentTimeMillis() + 8.988465674311579E307d;
        Intrinsics.checkNotNullParameter(r14, "<this>");
        yq5.b r7 = new yq5.b();
        r7.a = r14.a;
        r7.b = r14.b;
        r7.c = r14.d;
        r7.d = r14.e;
        r7.e = r14.i;
        r7.f = r14.g;
        r7.g = r14.k;
        r7.h = r14.h;
        r7.i = r14.f;
        r7.j = r14.c;
        r7.k = false;
        r7.l = null;
        r7.m = null;
        r7.n = false;
        r7.o = false;
        r7.p = false;
        r7.q = false;
        r7.r = 0;
        List r15 = CollectionsKt.listOf(r7);
        q r2 = (q) r0;
        r2.a.beginTransaction();
        q.q(r2, r1, r15);     // Catch: Throwable -> L15
        r2.a.setTransactionSuccessful();     // Catch: Throwable -> L15
        r2.a.endTransaction();
        return true;
    L15:
        th = move-exception;
        r2.a.endTransaction();
        throw th;
    }

    public final boolean b(String r3) {
        tt5.a.h("WikiDatabaseImpl", "handleSyncedUrl: url:" + p0.d(r3));
        if (TextUtils.isEmpty(r3) == false) goto L6;
        tt5.a.k("WikiDatabaseImpl", "handleSyncedUrl url is empty");
        return false;
    L6:
        if (r3 == null) goto L10;
        WikiTreeObserver.g.e(new i(r3));
        return true;
    L10:
        return true;
    }

    public final String c(ce5.a r2) {
        Intrinsics.checkNotNullParameter(r2, "userComponentAbility");
        return j.a(r2);
    }

    public final boolean handleSyncedDoc(OfflineDoc r11) {
        Intrinsics.checkNotNullParameter(r11, "offlineDoc");
        DocWikiInfo r0 = r11.getWikiInfo();
        String r12 = r11.getFakeToken();
        boolean r2 = true;
        if (r0 == null) goto L33;
        if (r12 == null) goto L33;
        String r4 = r0.getSpace_id();
        String r5 = r0.getWiki_token();
        String r6 = r0.getObj_token();
        int r7 = r0.getObj_type();
        if (r4 == null) goto L19;
        if (r5 == null) goto L19;
        if (r6 == null) goto L19;
        m.a r8 = new m.a();     // Catch: Exception -> L16
        Intrinsics.checkNotNullParameter(r4, "spaceId");     // Catch: Exception -> L16
        r8.b = r4;     // Catch: Exception -> L16
        r8.c = r4;     // Catch: Exception -> L16
        Intrinsics.checkNotNullParameter(r5, WikiFolderPushPlugin.WIKI_TOKEN);     // Catch: Exception -> L16
        r8.a = r5;     // Catch: Exception -> L16
        r8.f = r5;     // Catch: Exception -> L16
        r8.g = r0.getParent_wiki_token();     // Catch: Exception -> L16
        r8.d = r6;     // Catch: Exception -> L16
        r8.e = r7;     // Catch: Exception -> L16
        r8.j = r0.getSort_id();     // Catch: Exception -> L16
        String r9 = r0.getTitle();     // Catch: Exception -> L16
        if (r9 != null) goto L14;
        r9 = "";
    L14:
        Intrinsics.checkNotNullParameter(r9, "title");     // Catch: Exception -> L16
        r8.i = r9;     // Catch: Exception -> L16
        r8.h = r0.getWiki_node_type();     // Catch: Exception -> L16
        WikiTreeObserver.f.e(new h(r4, r12, xp5.h.a(new m(r8))));     // Catch: Exception -> L16
        return true;
    L16:
        e = move-exception;
        tt5.a.d("WikiDatabaseImpl", "handleSyncedDoc fail: " + e);
        return false;
    L19:
        StringBuilder r13 = new StringBuilder("handleSyncedDoc, spaceId is null? ");
        if (r4 != null) goto L22;
        boolean r1 = true;
    L23:
        r13.append(r1);
        r13.append(", wikiToken is null? ");
        if (r5 != null) goto L26;
        boolean r3 = true;
    L27:
        r13.append(r3);
        r13.append(", objToken is null? ");
        if (r6 == null) goto L31;
        r2 = false;
    L31:
        r13.append(r2);
        tt5.a.k("WikiDatabaseImpl", r13.toString());
        return false;
    L26:
        r3 = false;
        goto L27
    L22:
        r1 = false;
    L33:
        StringBuilder r10 = new StringBuilder("handleSyncedDoc, wikiInfo is null? ");
        if (r0 != null) goto L36;
        boolean r14 = true;
    L37:
        r10.append(r14);
        r10.append(", fakeToken is null? ");
        if (r12 == null) goto L41;
        r2 = false;
    L41:
        r10.append(r2);
        tt5.a.k("WikiDatabaseImpl", r10.toString());
        return false;
    L36:
        r14 = false;
        goto L37
    }
}
