package to2;

import com.bytedance.android.livesdk.player.LivePlayerAdapter;
import com.bytedance.android.livesdkapi.model.PlayerPreProcessorConfig;
import com.bytedance.android.livesdkapi.player.preload.model.PlayerPreloadRequest;
import java.util.concurrent.Callable;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes11.dex */
public final class a {

    /* JADX INFO: renamed from: to2.a$a, reason: collision with other inner class name */
    public static final class CallableC7749a implements Callable<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final PlayerPreloadRequest f546903a;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() {
            if (this.f546903a.getStreamData().length() != 0) goto L5;
            boolean r100 = true;
        L6:
            if (r100 == true) goto L8;
            Integer r101 = PlayerPreProcessorConfig.INSTANCE.getIoPreProcessorEnable();
            String r102 = "";
            if (r101 != null) goto L13;
        L19:
            JSONObject r103 = new JSONObject();
            String r104 = this.f546903a.getResolution();
            if (r104 == null) goto L23;
            r102 = r104;
        L23:
            r103.put("resolution", r102);
            String r105 = "{\"stream_info\":" + this.f546903a.getStreamData() + ",\"extra_info\":" + r103 + '}';
            Lazy r106 = LivePlayerAdapter.f154873a;
            Intrinsics.checkNotNullParameter(r105, "streamData");
        L24:
            com.bytedance.android.live.player.utils.b.g("LivePlayerPreConnectManager", "call pre-connect succeed! reqeust:" + this.f546903a);
            return Boolean.TRUE;
        L13:
            if (r101.intValue() != 1) goto L19;
            Lazy r107 = LivePlayerAdapter.f154873a;
            String r108 = this.f546903a.getStreamData();
            String r109 = this.f546903a.getResolution();
            if (r109 == null) goto L18;
            r102 = r109;
        L18:
            Intrinsics.checkNotNullParameter(r108, "streamData");
            Intrinsics.checkNotNullParameter(r102, "resolution");
            goto L24
        L8:
            return Boolean.FALSE;
        L5:
            r100 = false;
            goto L6
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ Boolean call() {
            return call();
        }

        public CallableC7749a(PlayerPreloadRequest r100) {
            Intrinsics.checkNotNullParameter(r100, "request");
            this.f546903a = r100;
        }
    }

    public a() {
    }
}
