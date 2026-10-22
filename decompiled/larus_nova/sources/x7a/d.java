package x7a;

import com.lynx.tasm.LynxView;
import com.lynx.tasm.behavior.ui.LynxUI;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes32.dex */
public final class d implements i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakReference<f> f562856a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Stack<h> f562857b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public HashMap<String, Object> f562858c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final i f562859d;

    public class a implements w6a.h.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxView f562860a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ d f562861b;

        @Override // w6a.h.c
        public final void a() {
            f r100 = this.f562861b.b();
            if (r100 == null) goto L5;
            r100.d(this.f562860a);
        L5:
            this.f562860a.destroy();
        }

        public a(d r100, LynxView r101) {
            this.f562861b = r100;
            this.f562860a = r101;
        }
    }

    public final f b() {
        WeakReference<f> r100 = this.f562856a;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.get();
    }

    public final void c(LynxView r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        w6a.h r101 = w6a.h.a.f558471a;
        a r102 = new a(this, r100);
        r101.getClass();
        AtomicInteger r103 = new AtomicInteger(0);
        Iterator<LynxUI> r104 = r101.f558465b.keySet().iterator();
    L6:
        if (r104.hasNext() == false) goto L11;
        LynxUI r105 = r104.next();
        if (r105.getLynxContext().getUIBody().getBodyView() != r100) goto L6;
        r103.incrementAndGet();
        r105.execExitAnim(new w6a.g(r103, r102));
        goto L6
    L11:
        if (r103.get() != 0) goto L14;
        r102.a();
    L14:
        if (this.f562857b.isEmpty() == true) goto L29;
        h r106 = this.f562857b.peek();
        LynxView r107 = this.f562859d.get(r106);
        if (r107 != null) goto L18;
        return;
    L18:
        if (r107.getParent() != null) goto L22;
        f r108 = b();
        if (r108 == null) goto L31;
        String r109 = r106.f562867a;
        r108.a(r107);
        r107.addLynxViewClient(new e(r107));
        return;
    L31:
        return;
    L22:
        w6a.h.a.f558471a.b(r107);
        r107.onEnterForeground();
        return;
    }

    public d(f r100, int r101) {
        this.f562857b = new Stack();
        this.f562856a = new WeakReference(r100);
        this.f562859d = new i(r101, this);
    }

    public static void a(d r100, LynxView r101) {
        r100.getClass();
        if (r101 == null) goto L18;
        Iterator<LynxUI> r102 = w6a.h.a.f558471a.f558468e.keySet().iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        LynxUI r103 = r102.next();
        if (r103.getLynxContext().getUIBody().getBodyView() != r101) goto L7;
        r103.execPauseAnim();
        goto L7
    L11:
        r101.onEnterBackground();
        return;
    }
}
