package xk;

import com.bytedance.android.ec.model.playback.ECReplayVideo;
import com.bytedance.android.ec.model.playback.ExplainPlaybackRequest;
import com.bytedance.android.ec.model.playback.ExplainPlaybackVideoInfo;
import com.bytedance.android.ec.model.playback.ExplainReplaySubTitle;
import com.bytedance.android.ec.model.playback.ReplayCards;
import com.bytedance.android.ec.model.playback.ReplayParams;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public interface a {
    ExplainPlaybackRequest a();

    void addReplayProgressListener(Function2<? super Long, ? super Boolean, Unit> r100);

    Map<String, String> b();

    void c(int r100, ECUIPromotion r101);

    ReplayCards d();

    Map<String, String> e();

    ReplayParams f();

    void g(boolean r100);

    JSONObject getEcomLiveParams();

    void getEnterFrom();

    long getReplayProgress();

    String h();

    long i();

    void j(ECUIPromotion r100, ExplainPlaybackVideoInfo r101, ECReplayVideo r102, List<ExplainReplaySubTitle> r103);

    void removeReplayProgressListener(Function2<? super Long, ? super Boolean, Unit> r100);

    Map<String, String> reportParams();

    void seekReplayProgress(long r100);
}
