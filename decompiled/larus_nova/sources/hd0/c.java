package hd0;

import android.os.Looper;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.utils.MainThreadPostUtils;
import com.bytedance.android.live.liveinteract.plantform.utils.x;
import com.bytedance.android.livesdk.app.dataholder.Observer;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes46.dex */
public final class c extends ge1.a<Integer> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static c f484572i;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f484573d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f484574e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f484575f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f484576g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final MutableLiveData<Boolean> f484577h;

    /* JADX WARN: Type inference failed for: r0v1, types: [T, java.lang.Integer] */
    public final void l() {
        this.f481009b = 0;
        this.f484573d = 0;
        this.f484574e = 0;
        this.f484575f = 0;
        this.f484577h.setValue(Boolean.FALSE);
    }

    public static c f() {
        if (f484572i != null) goto L9;
        f484572i = new c();
        if (MainThreadPostUtils.a() == false) goto L7;
        f484572i.f484577h.setValue(Boolean.FALSE);
        goto L9
    L7:
        f484572i.f484577h.postValue(Boolean.FALSE);
    L9:
        return f484572i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean g() {
        if (((Integer) this.f481009b).intValue() != 0) goto L5;
        return true;
    L5:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean h() {
        if (((Integer) this.f481009b).intValue() != 2) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean i() {
        Boolean r100 = this.f484577h.getValue();
        if (r100 != null) goto L6;
        return false;
    L6:
        return r100.booleanValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean j() {
        if (((Integer) this.f481009b).intValue() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [T, java.lang.Integer] */
    public c() {
        this.f484577h = new MutableLiveData();
        this.f481009b = 0;
    }

    public static String m(StackTraceElement[] r100) {
        if (r100 != null) goto L4;
        return "";
    L4:
        if (r100.length == 0) goto L14;
        StringBuilder r101 = new StringBuilder();
        int r102 = r100.length;
        int r103 = 0;
    L7:
        if (r103 >= r102) goto L10;
        StackTraceElement r104 = r100[r103];
        r101.append(" at ");
        r101.append(r104);
        r101.append("\n");
        r103 = r103 + 1;
        goto L7
    L10:
        return r101.toString();
    L14:
        return "";
    }

    @Override // ge1.a
    public final void e(Observer<Integer> r100) {
        if (Looper.myLooper() == Looper.getMainLooper()) goto L6;
        x.a0("removeObserver", m(ThreadMethodProxy.currentThread().getStackTrace()));
        return;
    L6:
        super.e(r100);
    }

    public final void k(Integer r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.intValue() >= 0) goto L6;
        return;
    L6:
        if (r100.intValue() <= 2) goto L9;
        return;
    L9:
        if (Looper.myLooper() == Looper.getMainLooper()) goto L12;
        x.a0("postValue", m(ThreadMethodProxy.currentThread().getStackTrace()));
        return;
    L12:
        d(r100);
    }
}
