package ymc;

import android.text.TextUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.videoarch.liveplayer.h;
import com.ss.videoarch.liveplayer.log.LiveError;
import com.ss.videoarch.liveplayer.model.LiveStreamInfo;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ExecutorService f568429a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h f568430b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Future f568431c;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f568432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f568433b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ b f568434c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ c f568435d;

        /* JADX INFO: renamed from: ymc.c$a$a, reason: collision with other inner class name */
        public class C8359a implements e.a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ a f568436a;

            public C8359a(a r100) {
                this.f568436a = r100;
            }

            @Override // ymc.e.a
            public void onCompletion(JSONObject r100) {
                LiveStreamInfo r101 = new LiveStreamInfo(r100.optJSONObject("Result"));
                this.f568436a.f568434c.onCompletion(r101);
            }

            @Override // ymc.e.a
            public void onError(LiveError r100) {
                this.f568436a.f568434c.onError(r100);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            com_ss_videoarch_liveplayer_network_LiveDataFetcher$1_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_ss_videoarch_liveplayer_network_LiveDataFetcher$1__run$___twin___() {
            e.doRequest(c.access$000(this.f568435d), this.f568432a, this.f568433b, new C8359a(this));
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_ss_videoarch_liveplayer_network_LiveDataFetcher$1_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_ss_videoarch_liveplayer_network_LiveDataFetcher$1__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(c r100, String r101, String r102, b r103) {
            this.f568435d = r100;
            this.f568432a = r101;
            this.f568433b = r102;
            this.f568434c = r103;
        }
    }

    public interface b {
        void onCompletion(LiveStreamInfo r100);

        void onError(LiveError r100);
    }

    public void cancel() {
        Future r100 = this.f568431c;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isDone() == true) goto L9;
        this.f568431c.cancel(true);
        this.f568431c = null;
        return;
    }

    public static /* synthetic */ h access$000(c r100) {
        return r100.f568430b;
    }

    public c(ExecutorService r100, h r101) {
        this.f568429a = r100;
        this.f568430b = r101;
    }

    public void startFetch(String r100, String r101, b r102) {
        if (TextUtils.isEmpty(r101) == true) goto L15;
        if (r102 != null) goto L7;
        return;
    L7:
        if (this.f568429a == null) goto L14;
        cancel();
        if (this.f568429a.isShutdown() == false) goto L11;
        return;
    L11:
        this.f568431c = this.f568429a.submit(new a(this, r100, r101, r102));
        return;
    L14:
        throw new IllegalStateException("mExecutor should not be null");
    }
}
