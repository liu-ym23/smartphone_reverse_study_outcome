package e7a;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.ui.list.ListViewHolder;
import com.lynx.tasm.behavior.ui.list.UIList;
import com.lynx.tasm.behavior.ui.view.UIComponent;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes32.dex */
public final class b implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final EventEmitter f471210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Handler f471211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RunnableC5751b f471212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LinkedList<a> f471213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LinkedList<a> f471214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f471215f;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ListViewHolder f471216a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f471217b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f471218c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f471219d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f471220e;

        public final String toString() {
            return "{type='" + this.f471217b + "', position=" + this.f471218c + ", key='" + this.f471219d + "'}";
        }

        public a(ListViewHolder r100, String r101) {
            this.f471216a = r100;
            this.f471217b = r101;
            this.f471218c = r100.getLayoutPosition();
            UIComponent r102 = r100.f382620a.f382623b;
            if (r102 == null) goto L6;
            this.f471219d = r102.f383173b;
            this.f471220e = r102.getSign();
            return;
        }
    }

    /* JADX INFO: renamed from: e7a.b$b, reason: collision with other inner class name */
    public static class RunnableC5751b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final WeakReference<b> f471221a;

        public final void a() {
            b r100 = this.f471221a.get();
            if (r100 != null) goto L5;
            return;
        L5:
            r100.f471212c = null;
            int r101 = UIList.L0;
        L7:
            if (r100.f471213d.size() <= 0) goto L45;
            a r102 = r100.f471213d.removeFirst();
            if (r100.g(r102) == false) goto L7;
            Iterator<a> r103 = r100.f471213d.iterator();
        L12:
            boolean r104 = true;
            boolean r105 = false;
            if (r103.hasNext() == false) goto L17;
            a r106 = r103.next();
            if (r100.e(r102, r106) == false) goto L12;
            r100.f471213d.remove(r106);
            boolean r107 = true;
        L18:
            if (r107 == true) goto L7;
            Iterator<a> r108 = r100.f471214e.iterator();
        L22:
            if (r108.hasNext() == false) goto L26;
            a r109 = r108.next();
            if (r100.e(r102, r109) == false) goto L22;
            r100.f471214e.remove(r109);
        L27:
            if (r104 == true) goto L7;
            if (r100.g(r102) == false) goto L40;
            UIComponent r110 = r102.f471216a.f382620a.f382623b;
            if (r110 == null) goto L38;
            if (r110.getEvents() == null) goto L38;
            r105 = r110.getEvents().containsKey(r102.f471217b);
        L38:
            if (r100.f471215f == false) goto L40;
            r105 = "nodedisappear".equals(r102.f471217b);
        L40:
            if (r105 == false) goto L7;
            if (r100.g(r102) == false) goto L7;
            int r111 = UIList.L0;
            m7a.d r112 = new m7a.d(r102.f471220e, r102.f471217b);
            r112.a("position", Integer.valueOf(r102.f471218c));
            r112.a("key", r102.f471219d);
            r100.f471210a.sendCustomEvent(r112);
            goto L7
        L26:
            r104 = r107;
            goto L27
        L17:
            r107 = false;
            goto L18
        L45:
            r100.f471213d = r100.f471214e;
            r100.f471214e = new LinkedList();
            if (r100.f471213d.size() <= 0) goto L68;
            r100.f();
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public RunnableC5751b(b r100) {
            this.f471221a = new WeakReference(r100);
        }
    }

    @Override // e7a.d
    public final void b() {
    }

    @Override // e7a.d
    public final void dispose() {
    }

    public final void f() {
        if (this.f471212c == null) goto L5;
        return;
    L5:
        RunnableC5751b r100 = new RunnableC5751b(this);
        this.f471212c = r100;
        this.f471211b.postDelayed(r100, 50);
    }

    public b(EventEmitter r100) {
        this.f471215f = false;
        this.f471210a = r100;
        Handler r101 = new Handler(Looper.getMainLooper());
        this.f471211b = r101;
        this.f471214e = new LinkedList();
        this.f471213d = new LinkedList();
        RunnableC5751b r102 = new RunnableC5751b(this);
        this.f471212c = r102;
        r101.postDelayed(r102, 500);
    }

    @Override // e7a.d
    public final void a(ListViewHolder r100) {
        int r101 = UIList.L0;
        this.f471214e.push(new a(r100, "nodedisappear"));
        f();
    }

    @Override // e7a.d
    public final void c(ListViewHolder r100) {
        int r101 = UIList.L0;
        this.f471214e.push(new a(r100, "nodeappear"));
        f();
    }

    @Override // e7a.d
    public final void d(ListViewHolder r100) {
        Iterator<a> r101 = this.f471213d.iterator();
    L4:
        if (r101.hasNext() == false) goto L10;
        a r102 = r101.next();
        if (r102.f471216a != r100) goto L4;
        UIComponent r103 = r100.f382620a.f382623b;
        if (r103 == null) goto L4;
        r102.f471219d = r103.f383173b;
        goto L4
    L10:
        Iterator<a> r104 = this.f471214e.iterator();
    L12:
        if (r104.hasNext() == false) goto L16;
        a r105 = r104.next();
        if (r105.f471216a != r100) goto L12;
        r105.f471219d = r100.f382620a.f382623b.f383173b;
        goto L12
    }

    public final boolean g(a r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        if (r100.f471216a.f382620a.f382623b != null) goto L12;
        if (this.f471215f == true) goto L10;
        return false;
    L10:
        return "nodedisappear".equals(r100.f471217b);
    L12:
        if (r100.f471217b == null) goto L16;
        return true;
    L16:
        return false;
    }

    public final boolean e(a r100, a r101) {
        if (this.f471215f == true) goto L5;
    L9:
        String r102 = r100.f471219d;
        if (r102 != null) goto L19;
        if (r101.f471219d != null) goto L19;
        if (r100.f471218c != r101.f471218c) goto L20;
        return true;
    L20:
        return false;
    L19:
        return TextUtils.equals(r102, r101.f471219d);
    L5:
        if (TextUtils.isEmpty(r100.f471217b) == true) goto L9;
        if (r100.f471217b.equals(r101.f471217b) == true) goto L9;
        return false;
    }
}
