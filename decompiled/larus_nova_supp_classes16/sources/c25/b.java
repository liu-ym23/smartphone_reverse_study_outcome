package c25;

import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocActivity;
import com.bytedance.ee.bear.document.DocViewModel;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.m;
import com.bytedance.ee.bear.more.moreprotocol.IBaseMoreItem;
import com.ss.android.lark.log.Log;
import sbb.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class b extends c25.a<DocumentPluginHost> {

    public class a implements sj5.c {
        public final /* synthetic */ FragmentActivity a;
        public final /* synthetic */ b b;

        public final void a() {
            if (this.b.d(this.a) == null) goto L6;
            Log.i("MULTITASK-MultitaskHelper", "dropIntoBasket isInitialized = false");
            return;
        }

        public final boolean b() {
            msb.a r0 = this.b.d(this.a);
            if (r0 == null) goto L5;
            r0.c();
            return true;
        L5:
            return false;
        }

        public final boolean c() {
            b r0 = this.b;
            FragmentActivity r1 = this.a;
            r0.getClass();
            if ((r1 instanceof DocActivity) == false) goto L5;
        L8:
            return true;
        L5:
            if ((r1 instanceof m) == true) goto L8;
            return false;
        }

        public final void terminate() {
            msb.a r0 = this.b.d(this.a);
            if (r0 == null) goto L6;
            r0.e();
            return;
        }

        public a(b r1, FragmentActivity r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public b() {
    }

    @Override // c25.a
    public final c b(PluginHost r12) {
        DocumentPluginHost r13 = (DocumentPluginHost) r12;
        int r0 = e.e.b;
        if (r13 == null) goto L10;
        DocViewModel r14 = r13.a();
        if (r14 == null) goto L10;
        String r1 = r14.getOriginUrl();
        String r2 = r14.getToken();
        if (ForsetiHelper.u() == false) goto L9;
        r2 = r14.getOriginBearUrl().b;
    L9:
        int r3 = r14.getDocumentTypeValue();
        boolean r4 = r14.isType(e.n);
        String r10 = r14.getDocTitle();
        String r5 = r1;
        String r6 = r2;
        int r7 = r3;
        boolean r9 = r4;
    L12:
        return new c(r5, r6, r7, "", r9, r10);
    L10:
        r5 = "";
        r6 = r5;
        r10 = r6;
        r7 = r0;
        r9 = false;
        goto L12
    }

    public final IBaseMoreItem c(FragmentActivity r2) {
        a r0 = new a(this, r2);
        return ((com.bytedance.ee.bear.more.b) org.koin.java.a.a(com.bytedance.ee.bear.more.b.class)).F(r0);
    }

    public final msb.a d(FragmentActivity r4) {
        boolean r0 = r4 instanceof DocActivity;
        if (r0 == false) goto L5;
    L8:
        boolean r1 = true;
    L10:
        if (r1 == true) goto L12;
        return null;
    L12:
        if (r0 == false) goto L16;
        return ((DocActivity) r4).c;
    L16:
        if ((r4 instanceof m) == true) goto L18;
        return null;
    L18:
        return ((m) r4).Z();
    L5:
        if ((r4 instanceof m) == true) goto L8;
        r1 = false;
        goto L10
    }
}
