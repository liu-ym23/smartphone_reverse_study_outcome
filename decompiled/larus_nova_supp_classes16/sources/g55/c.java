package g55;

import android.widget.FrameLayout;
import com.bytedance.ee.bear.drive.biz.feed.DriveFeedPlugin;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageBean;
import com.bytedance.ee.bear.middleground.feed.export.bean.MessageResultBean;
import com.larksuite.framework.utils.CollectionUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class c extends com.bytedance.ee.bear.drive.biz.feed.a {
    public final List<String> g;

    public class a implements com.bytedance.ee.bear.middleground.feed.export.bean.i {
        public final /* synthetic */ c a;

        public final void b(boolean r1, boolean r2) {
        }

        public final boolean d(String r1) {
            return false;
        }

        public final void e(MessageBean r1) {
        }

        public final void f(String r1) {
        }

        public final void g(List<String> r1) {
        }

        public final void h(int r1) {
        }

        public final void i(int r1) {
        }

        public final void j(boolean r1) {
        }

        public final /* synthetic */ void k() {
        }

        public a(c r1) {
            this.a = r1;
        }

        public final void a(String r2) {
            this.a.i(r2);
        }

        public final void c(MessageResultBean r5) {
            tt5.a.h("DriveFeedManager", " dataChange " + r5);
            if (r5 != null) goto L5;
            return;
        L5:
            MessageResultBean.Data r6 = r5.getData();
            if (r6 != null) goto L8;
            return;
        L8:
            List r7 = r6.getMessage();
            if (r7 != null) goto L11;
            return;
        L11:
            ArrayList r0 = new ArrayList(r7);
            ((ArrayList) this.a.g).clear();
            Iterator r8 = r0.iterator();
        L13:
            if (r8.hasNext() == false) goto L18;
            MessageBean r1 = (MessageBean) r8.next();
            if (r1.getReadStatus() != 1) goto L13;
            ((ArrayList) this.a.g).add(r1.getMessageId());
            goto L13
        L18:
            if (CollectionUtils.isEmpty(this.a.g) == true) goto L26;
            tt5.a.h("DriveFeedManager", "clear all badge size=" + ((ArrayList) this.a.g).size());
            c r9 = this.a;
            r9.b.e(r9.g);
            return;
        }
    }

    @Override // com.bytedance.ee.bear.drive.biz.feed.c
    public final void c() {
    }

    @Override // com.bytedance.ee.bear.drive.biz.feed.c
    public final void f() {
    }

    @Override // com.bytedance.ee.bear.drive.biz.feed.c
    public final void detach() {
        tt5.a.h("DriveFeedManager", "ClearBadgeFeedManager detach");
        com.bytedance.ee.bear.middleground.feed.a r0 = this.b;     // Catch: Exception -> L7
        if (r0 == null) goto L12;
        r0.a();     // Catch: Exception -> L7
        return;
    L12:
        return;
    L7:
        e = move-exception;
        tt5.a.f("DriveFeedManager", e, false);
    }

    @Override // com.bytedance.ee.bear.drive.biz.feed.c
    public final void attach() {
        detach();
        if (k() == false) goto L6;
        tt5.a.h("DriveFeedManager", "ClearBadgeFeedManager attach");
        j((u55.b) this.e.livePerm().getValue(), new a(this));
        return;
    }

    public c(DriveFeedPlugin.c r1, FrameLayout r2) {
        super(r1, r2);
        this.g = new ArrayList();
    }
}
