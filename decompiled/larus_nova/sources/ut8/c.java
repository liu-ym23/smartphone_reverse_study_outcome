package ut8;

import android.view.MotionEvent;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes26.dex */
public final class c implements i.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f551685a;

    public c(b r100) {
        this.f551685a = r100;
    }

    @Override // ut8.i.a
    public final void b(i r100, MotionEvent r101) {
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("startCursor onOutsideTouched, hasInterceptor=");
        if (this.f551685a.f551674u == null) goto L5;
        boolean r104 = true;
    L6:
        r103.append(r104);
        r102.i("BaseWordSelector", r103.toString());
        f r105 = this.f551685a.f551674u;
        if (r105 != null) goto L9;
    L12:
        b.c(this.f551685a, r100, r101, true);
        return;
    L9:
        if (r105.b(r101) == true) goto L12;
        r102.i("BaseWordSelector", "startCursor onOutsideTouched intercepted as keep-show, call onTouchOutside directly");
        this.f551685a.j();
        return;
    L5:
        r104 = false;
        goto L6
    }

    @Override // ut8.i.a
    public final void a(boolean r100, boolean r101, int r102, int r103) {
        b r104 = this.f551685a;
        if (r104.f551662i != (-1)) goto L5;
        r104.f551662i = r103;
    L5:
        b.a(r104, r100, r101, r102, r103);
        ArrayList r105 = new ArrayList(this.f551685a.f551670q);
        this.f551685a.f551661h.getClass();
        int r106 = r105.size();
        int r107 = 0;
    L6:
        if (r107 >= r106) goto L8;
        st8.c r108 = (st8.c) ListProtector.get(r105, r107);
        b r109 = this.f551685a;
        r108.a(r109.f551661h, r101, r103, r109.f551662i);
        r107 = r107 + 1;
        goto L6
    L8:
        b r110 = this.f551685a;
        r110.f551662i = r103;
        b.b(r110, r101, r100);
    }
}
