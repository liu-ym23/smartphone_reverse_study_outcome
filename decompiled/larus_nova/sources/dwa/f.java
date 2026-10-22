package dwa;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.LayoutInflaterCompat;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: classes34.dex */
public final class f extends LayoutInflater {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Looper f470367e = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LayoutInflater f470368a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f470369b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile a f470370c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public volatile e f470371d;

    public static class a extends LayoutInflater {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String[] f470372b = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final f f470373a;

        static {
            f470372b = new String[]{"android.widget.", "android.webkit.", "android.app."};
        }

        @Override // android.view.LayoutInflater
        public final LayoutInflater cloneInContext(Context r100) {
            return this.f470373a.cloneInContext(r100);
        }

        public a(Context r100, f r101) {
            super(r100);
            this.f470373a = r101;
            if ((r100 instanceof AppCompatActivity) == false) goto L8;
            Object r102 = ((AppCompatActivity) r100).getDelegate();
            if ((r102 instanceof LayoutInflater.Factory2) == false) goto L9;
            LayoutInflaterCompat.setFactory2(this, (LayoutInflater.Factory2) r102);
            return;
        L9:
            return;
        }

        @Override // android.view.LayoutInflater
        public final View onCreateView(String r100, AttributeSet r101) throws ClassNotFoundException {
            String[] r102 = f470372b;
            int r103 = r102.length;
            View r104 = null;
            int r105 = 0;
        L3:
            if (r105 >= r103) goto L9;
            r104 = createView(r100, r102[r105], r101);     // Catch: ClassNotFoundException -> L12
            if (r104 != null) goto L9;
        L8:
            r105 = r105 + 1;
        L9:
            if (r104 == null) goto L11;
            return r104;
        L11:
            return super.onCreateView(r100, r101);
        }
    }

    public static class b {
        public b() {
        }
    }

    static {
        f470367e = Looper.getMainLooper();
    }

    public final void a(Context r100) {
        this.f470371d = new e(r100);
        this.f470370c = new a(this.f470371d, this);
    }

    @Override // android.view.LayoutInflater
    public final LayoutInflater cloneInContext(Context r100) {
        return new f(r100, this.f470368a.cloneInContext(r100));
    }

    public f(Context r100, LayoutInflater r101) {
        super(r100);
        this.f470368a = r101;
        this.f470369b = new b();
        if (f470367e == Looper.myLooper()) goto L6;
        a(r100);
        return;
    }

    @Override // android.view.LayoutInflater
    public final View inflate(XmlPullParser r100, ViewGroup r101) {
        return super.inflate(r100, r101);
    }

    @Override // android.view.LayoutInflater
    public final View inflate(int r100, ViewGroup r101, boolean r102) {
        if (f470367e != Looper.myLooper()) goto L5;
        boolean r103 = true;
    L6:
        View r104 = null;
        if (r103 == false) goto L14;
        b r105 = this.f470369b;
        getContext();
        r105.getClass();
        b2.b r106 = b2.c.f16976a.get(r100);
        if (r106 != null) goto L31;
    L12:
        if (r104 == null) goto L34;
        return r104;
    L34:
        return this.f470368a.inflate(r100, r101, r102);
    L31:
        r104 = r106.a();     // Catch: Exception -> L27
        goto L12
    L14:
        b r107 = this.f470369b;
        if (this.f470371d != null) goto L17;
        a(getContext());
    L17:
        r107.getClass();
        b2.b r108 = b2.c.f16976a.get(r100);
        if (r108 != null) goto L29;
    L21:
        if (r104 == null) goto L23;
        return r104;
    L23:
        if (this.f470370c != null) goto L26;
        a(getContext());
    L26:
        return this.f470370c.inflate(r100, r101, r102);
    L29:
        r104 = r108.a();     // Catch: Exception -> L28
        goto L21
    L5:
        r103 = false;
        goto L6
    }

    @Override // android.view.LayoutInflater
    public final View inflate(XmlPullParser r100, ViewGroup r101, boolean r102) {
        if (f470367e != Looper.myLooper()) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L9;
        return this.f470368a.inflate(r100, r101, r102);
    L9:
        if (this.f470370c != null) goto L12;
        a(getContext());
    L12:
        return this.f470370c.inflate(r100, r101, r102);
    L5:
        r103 = false;
        goto L6
    }
}
