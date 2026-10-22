package ab5;

import android.app.Dialog;
import androidx.fragment.app.FragmentActivity;
import bb5.g;
import com.bytedance.ee.util.ui.j;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements ab5.a {
    public final AtomicInteger a;
    public final AtomicInteger b;
    public final Map<Long, Long> c;
    public final ip5.b d;
    public final int e;
    public UDDialog f;
    public final FragmentActivity g;
    public final String h;
    public g i;
    public final Map<Integer, Float> j;
    public int k;

    public static final class a implements Runnable {
        public final /* synthetic */ d a;
        public final /* synthetic */ Ref.FloatRef b;

        public a(d r1, Ref.FloatRef r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.a.d.b((int) this.b.element);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    @Override // ab5.a
    public final void cancel() {
        Dialog r0 = this.f;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("progressDialog");
        r0 = null;
    L5:
        r0.cancel();
    }

    public d(FragmentActivity r3) {
        Intrinsics.checkNotNullParameter(r3, "activity");
        this.a = new AtomicInteger(0);
        this.b = new AtomicInteger(0);
        this.c = new ConcurrentHashMap();
        this.e = 303;
        this.g = r3;
        this.h = "VIDEO_COMPRESS";
        this.j = new LinkedHashMap();
        this.k = 9;
        this.d = new ip5.b(r3);
    }

    @Override // ab5.a
    public final void a(int r3, float r4) {
        this.j.put(Integer.valueOf(r3), Float.valueOf(r4));     // Catch: Exception -> L8
        Ref.FloatRef r5 = new Ref.FloatRef();     // Catch: Exception -> L8
        Iterator r6 = ((LinkedHashMap) this.j).entrySet().iterator();     // Catch: Exception -> L8
    L4:
        if (r6.hasNext() == false) goto L6;
        r5.element += ((Number) ((Map.Entry) r6.next()).getValue()).floatValue();     // Catch: Exception -> L8
        goto L4
    L6:
        r5.element = (r5.element * 100) / this.k;     // Catch: Exception -> L8
        j.c(new a(this, r5));     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        tt5.a.d(this.h, "updateProgress:" + e);
    }
}
