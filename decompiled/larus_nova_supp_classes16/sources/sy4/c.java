package sy4;

import android.view.View;
import com.bytedance.ee.util.ui.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public abstract class c implements d {
    public final List<b> a;

    public class a implements Runnable {
        public final /* synthetic */ View a;
        public final /* synthetic */ sy4.b b;

        @Override // java.lang.Runnable
        public final void run() {
            View r0 = this.a;     // Catch: Throwable -> L12
            if (r0 != null) goto L5;
            return;
        L5:
            if (r0.isAttachedToWindow() == false) goto L19;
            View r1 = this.a;     // Catch: Throwable -> L12
            if (((f) this.b).a == false) goto L9;
            int r2 = 0;
        L10:
            r1.setVisibility(r2);     // Catch: Throwable -> L12
            return;
        L9:
            r2 = 8;
            goto L10
        L19:
            return;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }

        public a(View r1, sy4.b r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public interface b {
        boolean a(sy4.b r1);
    }

    public abstract View c();

    public c() {
        this.a = new ArrayList();
    }

    @Override // sy4.d
    public void a(sy4.b r5) {
        if ((r5 instanceof f) == false) goto L15;
        View r0 = c();
        int r1 = ((ArrayList) this.a).size();
    L5:
        r1 = r1 - 1;
        if (r1 < 0) goto L10;
        if (((b) ListProtector.get(this.a, r1)).a(r5) == false) goto L5;
        return;
    L10:
        j.d(new a(r0, r5), 100);
        return;
    }

    public final void b(b r2) {
        if (((ArrayList) this.a).contains(r2) == false) goto L5;
        return;
    L5:
        ((ArrayList) this.a).add(r2);
    }
}
