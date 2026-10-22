package pic;

import android.os.Handler;
import android.os.Looper;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.videoshop.context.VideoContext;
import com.ss.android.videoshop.mediaview.TextureVideoView;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import nic.j;
import nic.l;

/* JADX INFO: loaded from: classes40.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<tic.a, qic.a> f529427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<tic.a, TextureVideoView> f529428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Queue<tic.a> f529429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final qic.c f529430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public nic.f f529431e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public j f529432f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public nic.c f529433g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public l f529434h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public VideoContext f529435i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f529436j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Handler f529437k;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextureVideoView f529438a;

        @Override // java.lang.Runnable
        public final void run() {
            UIUtils.detachFromParent(this.f529438a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(TextureVideoView r100) {
            this.f529438a = r100;
        }
    }

    public e() {
        this.f529427a = new HashMap();
        this.f529428b = new HashMap();
        this.f529429c = new LinkedList();
        this.f529430d = new qic.c();
        this.f529431e = new oic.d();
        this.f529436j = 2;
        this.f529437k = new Handler(Looper.getMainLooper());
    }

    public final void a(tic.a r100) {
        if (r100 == null) goto L15;
        TextureVideoView r101 = b(r100);
        if (r101 == null) goto L7;
        r101.setSurfaceTextureListener(null);
    L7:
        this.f529437k.post(new a(r101));
        qic.a r102 = c(r100);
        ((LinkedList) this.f529429c).remove(r100);
        if (r102 == null) goto L16;
        ajc.b.a("VideoPrepareManager", "releasePreparedVideoController vid:" + r100.f546363a + " title:null size:" + ((LinkedList) this.f529429c).size() + " context:" + this.f529435i.getContext().getClass().getSimpleName());     // Catch: Exception -> L12
    L10:
        r102.release();
        return;
    L16:
        return;
    }

    public final TextureVideoView b(tic.a r100) {
        if (r100 == null) goto L4;
        ajc.b.c("VideoPrepareManager", "retrieveTextureVideoView vid:" + r100.f546363a + " title:null");
    L4:
        ((LinkedList) this.f529429c).remove(r100);
        return (TextureVideoView) ((HashMap) this.f529428b).remove(r100);
    }

    public final qic.a c(tic.a r100) {
        if (r100 == null) goto L4;
        ajc.b.c("VideoPrepareManager", "retrieveVideoController vid:" + r100.f546363a + " title:null");
    L4:
        ((LinkedList) this.f529429c).remove(r100);
        return (qic.a) ((HashMap) this.f529427a).remove(r100);
    }
}
