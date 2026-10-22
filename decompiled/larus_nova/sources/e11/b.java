package e11;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.livesdk.link.model.r;
import io.reactivex.Observable;

/* JADX INFO: loaded from: classes47.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f470687a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f470688a = null;

        public a() {
        }

        static {
            f470688a = new a();
        }
    }

    static {
        f470687a = a.f470688a;
    }

    Observable<ExtraResponse<r, Extra>> getLinkAnchorList(long r100, long r101, long r102, long r103, int r104, boolean r110, String r111, long r112);

    Observable<ExtraResponse<Object, Extra>> sendSignalV3(long r100, String r101, int r102);
}
