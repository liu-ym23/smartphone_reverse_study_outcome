package uvb;

import android.view.View;
import com.larus.nova.R;
import kotlin.jvm.JvmStatic;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f551863a = 0;

    static {
    }

    @JvmStatic
    public static final void b(View r100) {
        a(r100, R.id.userName, c.f551880k);
        a(r100, R.id.time, c.f551881l);
        a(r100, R.id.itemContent1, c.f551882m);
    }

    public static void a(View r100, int r101, c.a r102) {
        if (r100 == null) goto L4;
        View r103 = r100.findViewById(r101);
    L5:
        a.b(r103, r102);
        return;
    L4:
        r103 = null;
        goto L5
    }
}
