package vic;

import android.content.Context;
import android.view.OrientationEventListener;
import com.bytedance.android.shopping.store.hybrid.jsbcheck.ECStoreJsbErrorCode;
import com.bytedance.common.utility.Logger;
import com.bytedance.common.utility.collection.WeakContainer;
import fjc.f;
import java.util.Iterator;

/* JADX INFO: loaded from: classes40.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final WeakContainer<d> f555396a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f555397b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f555398c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f555399d;

    public class a extends OrientationEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f555400a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ e f555401b;

        @Override // android.view.OrientationEventListener
        public final void onOrientationChanged(int r100) {
            if (r100 >= 0) goto L4;
            return;
        L4:
            if (r100 >= 360) goto L33;
            this.f555401b.getClass();
            int r101 = 9;
            if (r100 <= 9) goto L21;
            int r102 = 360 - r100;
            this.f555401b.getClass();
            if (r102 <= 9) goto L21;
            int r103 = Math.abs(r100 - 90);
            this.f555401b.getClass();
            if (r103 > 9) goto L14;
            r101 = 8;
        L23:
            if (this.f555400a != r101) goto L25;
            return;
        L25:
            if (r101 == (-1)) goto L32;
            this.f555400a = r101;
            ajc.b.a("ScreenOrientationHelper", "onOrientationChanged:" + f.a(r101));
            Iterator<d> r104 = this.f555401b.f555396a.iterator();
        L28:
            if (r104.hasNext() == false) goto L34;
            r104.next().a(r101);
            goto L28
        L34:
            return;
        L32:
            return;
        L14:
            int r105 = Math.abs(r100 - 180);
            this.f555401b.getClass();
            if (r105 <= 9) goto L23;
            int r106 = Math.abs(r100 + ECStoreJsbErrorCode.PATTERN_EXCEPTION);
            this.f555401b.getClass();
            if (r106 > 9) goto L20;
            r101 = 0;
            goto L23
        L20:
            r101 = -1;
        L21:
            r101 = 1;
            goto L23
        }

        public a(e r100, Context r101) {
            this.f555401b = r100;
            super(r101);
            this.f555400a = -1;
        }
    }

    public e(Context r100) {
        this.f555396a = new WeakContainer();
        Context r101 = r100.getApplicationContext();
        this.f555398c = r101;
        this.f555397b = new a(this, r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Logger.throwException(e);
    }
}
