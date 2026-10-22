package sy4;

import android.view.View;
import com.bytedance.ee.util.ui.j;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes16.dex */
public abstract class c implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<b> f543880a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f543881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ sy4.b f543882b;

        @Override // java.lang.Runnable
        public final void run() {
            View r100 = this.f543881a;     // Catch: Throwable -> L12
            if (r100 != null) goto L5;
            return;
        L5:
            if (r100.isAttachedToWindow() == false) goto L19;
            View r101 = this.f543881a;     // Catch: Throwable -> L12
            if (((f) this.f543882b).f543885a == false) goto L9;
            int r102 = 0;
        L10:
            r101.setVisibility(r102);     // Catch: Throwable -> L12
            return;
        L9:
            r102 = 8;
            goto L10
        L19:
            return;
        L12:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L20;
            throw th;
        }

        public a(View r100, sy4.b r101) {
            this.f543881a = r100;
            this.f543882b = r101;
        }
    }

    public interface b {
        boolean a(sy4.b r100);
    }

    public abstract View c();

    public c() {
        this.f543880a = new ArrayList();
    }

    @Override // sy4.d
    public void a(sy4.b r100) {
        if ((r100 instanceof f) == false) goto L15;
        View r101 = c();
        int r102 = ((ArrayList) this.f543880a).size();
    L5:
        r102 = r102 - 1;
        if (r102 < 0) goto L10;
        if (((b) ListProtector.get(this.f543880a, r102)).a(r100) == false) goto L5;
        return;
    L10:
        j.d(new a(r101, r100), 100);
        return;
    }

    public final void b(b r100) {
        if (((ArrayList) this.f543880a).contains(r100) == false) goto L5;
        return;
    L5:
        ((ArrayList) this.f543880a).add(r100);
    }
}
