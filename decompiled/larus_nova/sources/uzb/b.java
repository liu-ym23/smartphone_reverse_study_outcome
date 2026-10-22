package uzb;

import android.app.Activity;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.ss.android.lark.flow.passport.ui.widget.layout.CommonContainerLayout;
import com.ss.android.lark.passport.utils.ImeObserver$3;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f552237f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f552238a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f552239b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C7950b f552240c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final MutableLiveData<C7950b> f552241d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final MutableLiveData f552242e;

    public static final class a {
    }

    /* JADX INFO: renamed from: uzb.b$b, reason: collision with other inner class name */
    public static final class C7950b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f552243a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f552244b;

        public C7950b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7950b) == true) goto L8;
            return false;
        L8:
            C7950b r101 = (C7950b) r100;
            if (this.f552243a == r101.f552243a) goto L12;
            return false;
        L12:
            if (this.f552244b == r101.f552244b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f552243a == false) goto L5;
            int r100 = 1231;
        L7:
            return (r100 * 31) + this.f552244b;
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "ImeInfo(isShowing=" + this.f552243a + ", imeHeight=" + this.f552244b + ')';
        }

        public C7950b(int r100) {
            this.f552243a = false;
            this.f552244b = 0;
        }
    }

    static {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(CommonContainerLayout r100) {
        C7950b r101 = new C7950b(0);
        this.f552240c = r101;
        MutableLiveData<C7950b> r102 = new MutableLiveData(r101);
        this.f552241d = r102;
        this.f552242e = r102;
        ViewCompat.setOnApplyWindowInsetsListener(r100, new uzb.a(this));
        if (r100.isAttachedToWindow() == false) goto L5;
        WindowInsetsCompat r103 = ViewCompat.getRootWindowInsets(r100);
    L6:
        Activity r104 = qyb.d.a(r100);
        if (r103 != null) goto L10;
        if (r104 == 0) goto L12;
        f.a(r104);
    L12:
        if ((r104 instanceof LifecycleOwner) == false) goto L14;
        ((LifecycleOwner) r104).getLifecycle().addObserver(new ImeObserver$3(this));
    L14:
        if (r103 == null) goto L17;
        a(r103);
        return;
    L17:
        return;
    L10:
        a(r103);
        goto L12
    L5:
        r103 = null;
        goto L6
    }

    public final void a(WindowInsetsCompat r100) {
        int r101 = 0;
        if (r100.getSystemWindowInsetBottom() <= r100.getStableInsetBottom()) goto L5;
        boolean r102 = true;
    L6:
        this.f552238a = r102;
        if (this.f552238a == false) goto L9;
        r101 = r100.getSystemWindowInsetBottom() - r100.getStableInsetBottom();
    L9:
        this.f552239b = r101;
        boolean r103 = this.f552238a;
        int r104 = this.f552239b;
        C7950b r105 = this.f552240c;
        if (r105.f552243a == r103) goto L12;
    L13:
        r105.f552243a = r103;
        r105.f552244b = r104;
        this.f552241d.setValue(r105);
        return;
    L12:
        if (r105.f552244b != r104) goto L13;
        return;
    L5:
        r102 = false;
        goto L6
    }
}
