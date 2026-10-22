package s25;

import com.bytedance.ee.util.ui.j;
import com.bytedance.lark.pb.basic.v1.DocFeed;
import com.bytedance.lark.pb.basic.v1.Entity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements com.ss.android.lark.sdk.g.b {
    public final /* synthetic */ e a;

    public f(e r1) {
        this.a = r1;
    }

    public final void a(byte[] r6) {
        Entity r7 = (Entity) Entity.ADAPTER.decode(r6);     // Catch: IOException -> L9
        tt5.a.h("DocFeedPushPreloadStrategy", "push suite doc feeds, size = " + r7.doc_feeds.size());     // Catch: IOException -> L9
        ArrayList r1 = new ArrayList();     // Catch: IOException -> L9
        Iterator r8 = r7.doc_feeds.values().iterator();     // Catch: IOException -> L9
    L5:
        if (r8.hasNext() == false) goto L7;
        r1.add(((DocFeed) r8.next()).doc_url);     // Catch: IOException -> L9
        goto L5
    L7:
        e r9 = this.a;     // Catch: IOException -> L9
        r9.getClass();     // Catch: IOException -> L9
        j.d(new g(r1, r9), r9.a.getDocs_feed_push_preload_delay());     // Catch: IOException -> L9
        return;
    L9:
        e = move-exception;
        tt5.a.e("DocFeedPushPreloadStrategy", "decode docFeedPush entity failed", e, false);
    }
}
