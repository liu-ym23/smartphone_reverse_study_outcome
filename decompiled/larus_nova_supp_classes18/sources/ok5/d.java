package ok5;

import android.app.Application;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.ee.bear.bitable.jsapi.common.CommonAttachmentPanel;
import com.bytedance.ee.bear.fileselector.bean.FileBean;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.LarkContext;
import ew4.l;
import ew4.m;
import ew4.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import na8.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements CommonAttachmentPanel.c {
    public final /* synthetic */ gk5.a a;
    public final /* synthetic */ c b;

    public static final class a implements m {
        public final /* synthetic */ za5.a a;
        public final /* synthetic */ gk5.a b;
        public final /* synthetic */ c c;

        public final void a() {
        }

        public final void b() {
        }

        public final void onCancel() {
            za5.a r0 = this.a;
            if (r0 == null) goto L6;
            r0.b();
            return;
        }

        public final void onSuccess(List<l> r20) {
            Intrinsics.checkNotNullParameter(r20, "files");
            za5.a r2 = this.a;     // Catch: Exception -> L11
            if (r2 == null) goto L17;
            List<l> r0 = r20;     // Catch: Exception -> L11
            c r3 = this.c;     // Catch: Exception -> L11
            ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));     // Catch: Exception -> L11
            Iterator<T> r1 = r0.iterator();     // Catch: Exception -> L11
        L7:
            if (r1.hasNext() == false) goto L9;
            l r5 = (l) r1.next();     // Catch: Exception -> L11
            int r6 = c.a;     // Catch: Exception -> L11
            r3.getClass();     // Catch: Exception -> L11
            FileBean r7 = new FileBean(0, r5.a, r5.b, 0, r5.c, r5.d, r5.e);     // Catch: Exception -> L11
            r7.setCompressPath(r5.f);     // Catch: Exception -> L11
            r7.setOrigin(r5.g);     // Catch: Exception -> L11
            r4.add(r7);     // Catch: Exception -> L11
            goto L7
        L9:
            r2.c(r4);     // Catch: Exception -> L11
            return;
        L17:
            return;
        L11:
            e = move-exception;
            nk5.b.c(this.b, e);
        }

        public a(za5.a r1, gk5.a r2, c r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public d(p r1, c r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a(FragmentActivity r5, boolean r6, boolean r7, za5.a r8) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        com.bytedance.ee.bear.appsetting.c r0 = com.bytedance.ee.bear.appsetting.c.a.a;     // Catch: Exception -> L5
        Application r1 = LarkContext.getApplication();     // Catch: Exception -> L5
        r0.getClass();     // Catch: Exception -> L5
        UserSession r2 = ((com.ss.android.lark.passportc.convention.a) e0c.k.a(r1, com.ss.android.lark.passportc.convention.a.class)).b();     // Catch: Exception -> L5
        ((y) e0c.k.b(((v) e0c.k.a(r1, v.class)).c(r2), y.class)).openCamera(r5, new ew4.k(null, r6, r7, 1), new a(r8, this.a, this.b));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        nk5.b.c(this.a, e);
    }
}
