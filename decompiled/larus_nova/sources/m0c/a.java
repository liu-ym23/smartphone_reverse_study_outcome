package m0c;

import com.ss.android.lark.log.Log;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes37.dex */
@Singleton
public final class a extends com.ss.android.lark.log.a {
    @Inject
    public a() {
    }

    @Override // com.ss.android.lark.log.a, com.ss.android.lark.log.c
    public final void d(String r100, String r101) {
        if (r101 != null) goto L4;
        r101 = "";
    L4:
        Log.d(r100, r101);
    }

    @Override // com.ss.android.lark.log.a, com.ss.android.lark.log.c
    public final void e(String r100, String r101) {
        if (r101 != null) goto L4;
        r101 = "";
    L4:
        Log.e(r100, r101);
    }

    @Override // com.ss.android.lark.log.a, com.ss.android.lark.log.c
    public final void i(String r100, String r101) {
        if (r101 != null) goto L4;
        r101 = "";
    L4:
        Log.i(r100, r101);
    }

    @Override // com.ss.android.lark.log.a, com.ss.android.lark.log.c
    public final void v(String r100, String r101) {
        if (r101 != null) goto L4;
        r101 = "";
    L4:
        Log.v(r100, r101);
    }

    @Override // com.ss.android.lark.log.a, com.ss.android.lark.log.c
    public final void w(String r100, String r101) {
        if (r101 != null) goto L4;
        r101 = "";
    L4:
        Log.w(r100, r101);
    }
}
