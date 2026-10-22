package jla;

import android.os.SystemClock;
import android.util.ArrayMap;
import android.view.Choreographer;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final ThreadLocal<a> f499559g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayMap<b, Long> f499560a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<b> f499561b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final C6452a f499562c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public d f499563d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f499564e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f499565f;

    /* JADX INFO: renamed from: jla.a$a, reason: collision with other inner class name */
    public class C6452a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f499566a;

        public C6452a(a r100) {
            this.f499566a = r100;
        }
    }

    public interface b {
        boolean doAnimationFrame(long r100);
    }

    public static abstract class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final C6452a f499567a;

        public c(C6452a r100) {
            this.f499567a = r100;
        }
    }

    public static class d extends c {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Choreographer f499568b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final ChoreographerFrameCallbackC6453a f499569c;

        /* JADX INFO: renamed from: jla.a$d$a, reason: collision with other inner class name */
        public class ChoreographerFrameCallbackC6453a implements Choreographer.FrameCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ d f499570a;

            public ChoreographerFrameCallbackC6453a(d r100) {
                this.f499570a = r100;
            }

            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long r110) {
                C6452a r111 = this.f499570a.f499567a;
                r111.f499566a.f499564e = SystemClock.uptimeMillis();
                a r112 = r111.f499566a;
                long r100 = r112.f499564e;
                long r101 = SystemClock.uptimeMillis();
                int r102 = 0;
            L4:
                if (r102 >= r112.f499561b.size()) goto L20;
                b r103 = (b) ListProtector.get(r112.f499561b, r102);
                if (r103 == null) goto L18;
                Long r104 = r112.f499560a.get(r103);
                if (r104 != null) goto L12;
            L14:
                boolean r105 = true;
            L16:
                if (r105 == false) goto L18;
                r103.doAnimationFrame(r100);
                goto L18
            L12:
                if (r104.longValue() >= r101) goto L15;
                r112.f499560a.remove(r103);
                goto L14
            L15:
                r105 = false;
            L18:
                r102 = r102 + 1;
                goto L4
            L20:
                if (r112.f499565f == false) goto L29;
                int r106 = r112.f499561b.size();
            L22:
                r106 = r106 - 1;
                if (r106 < 0) goto L27;
                if (ListProtector.get(r112.f499561b, r106) != null) goto L22;
                ListProtector.remove(r112.f499561b, r106);
                goto L22
            L27:
                r112.f499565f = false;
            L29:
                if (r111.f499566a.f499561b.size() <= 0) goto L44;
                a r113 = r111.f499566a;
                if (r113.f499563d != null) goto L33;
                r113.f499563d = new d(r113.f499562c);
            L33:
                d r114 = r113.f499563d;
                r114.f499568b.postFrameCallback(r114.f499569c);
                return;
            }
        }

        public d(C6452a r100) {
            super(r100);
            this.f499568b = Choreographer.getInstance();
            this.f499569c = new ChoreographerFrameCallbackC6453a(this);
        }
    }

    static {
        f499559g = new ThreadLocal();
    }

    public a() {
        this.f499560a = new ArrayMap();
        this.f499561b = new ArrayList();
        this.f499562c = new C6452a(this);
        this.f499564e = 0;
        this.f499565f = false;
    }
}
