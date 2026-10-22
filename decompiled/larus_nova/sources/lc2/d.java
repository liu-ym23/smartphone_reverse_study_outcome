package lc2;

import com.bytedance.android.livesdk.interactivity.api.entity.f;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.i;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.o;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.rendprocessor.k;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.s;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.l;
import com.bytedance.android.livesdk.interactivity.textmessage.model.z;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f508407a = null;

    public d() {
    }

    static {
        f508407a = new d();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.o
    public final void a(f<?> r100, e52.a r101) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        Intrinsics.checkNotNullParameter(r101, "config");
        i r102 = null;
        if ((r100 instanceof z) == true) goto L5;
        f<?> r103 = null;
    L6:
        z r104 = (z) r103;
        if (r104 == null) goto L9;
        r102 = r104.H;
    L9:
        if (r102 == null) goto L11;
        boolean r105 = true;
    L12:
        if (r105 == true) goto L14;
    L18:
        if (r105 == true) goto L23;
        k<f<?>> r106 = r101.g();
        if (r106 == null) goto L24;
        r106.d(r100);
        return;
    L24:
        return;
    L23:
        return;
    L14:
        if ((r102 instanceof s) == false) goto L18;
        s r107 = (s) r102;
        r107.k().f133523a.f545243b = l.c(r101, r107);
        k<s> r108 = r101.e();
        if (r108 == 0) goto L18;
        r108.d(r102);
        goto L18
    L11:
        r105 = false;
        goto L12
    L5:
        r103 = r100;
        goto L6
    }
}
