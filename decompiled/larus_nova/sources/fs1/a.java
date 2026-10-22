package fs1;

import android.content.Context;
import com.bytedance.android.scope.o;
import nm1.n;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements n, o {
    public a() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // nm1.n
    public final com.bytedance.android.livesdk.chorusconcert.descriptor.a d() {
        return new com.bytedance.android.livesdk.chorusconcert.descriptor.a();
    }

    @Override // nm1.n
    public final void c(long r100) {
        es1.a.f473681j.a(r100);
    }

    @Override // nm1.n
    public final boolean a(Long r100, Context r101) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L15;
        es1.a r102 = es1.a.f473681j.c(r100.longValue(), r101, false);
        if (r102 != null) goto L9;
        return false;
    L9:
        if (r102.f473684c != true) goto L14;
        return true;
    L14:
        return false;
    L15:
        return false;
    L12:
        return false;
    }
}
