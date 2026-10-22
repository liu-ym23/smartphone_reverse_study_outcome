package f92;

import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiAnchorLinkmicLiveCoreInfo;
import com.bytedance.android.livesdk.config.ma0;
import java.util.ArrayList;
import kotlin.Unit;

/* JADX INFO: loaded from: classes9.dex */
public final class g extends f {
    @Override // f92.f
    public final void e() {
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        i r102 = new i();
        r102.k(AudioStats.AUDIO_AMPLITUDE_NONE);
        r102.l(AudioStats.AUDIO_AMPLITUDE_NONE);
        r102.j(1.0d);
        r102.g(1.0d);
        r102.i(0);
        Unit r103 = Unit.INSTANCE;
        r101.add(r102);
        h r104 = new h();
        r104.d(r101);
        r100.add(r104);
        ArrayList r105 = new ArrayList();
        i r106 = new i();
        r106.k(AudioStats.AUDIO_AMPLITUDE_NONE);
        int r107 = c.f475949i;
        r106.l(0.19d);
        r106.j(0.49583333333333335d);
        r106.g(0.40286458333333336d);
        ma0 r110 = ma0.f120739a;
        if (r110.getValue().booleanValue() == false) goto L5;
        int r111 = MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode.AnchorPushStreamMode1V1.ordinal();
    L6:
        r106.i(r111);
        r105.add(r106);
        i r108 = new i();
        r108.k(0.5041666666666667d);
        r108.l(0.19d);
        r108.j(0.49583333333333335d);
        r108.g(0.40286458333333336d);
        if (r110.getValue().booleanValue() == false) goto L9;
        int r109 = MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode.AnchorPushStreamMode1V1.ordinal();
    L10:
        r108.i(r109);
        r105.add(r108);
        h r112 = new h();
        r112.d(r105);
        r100.add(r112);
        ArrayList r113 = new ArrayList();
        i r114 = new i();
        r114.k(AudioStats.AUDIO_AMPLITUDE_NONE);
        r114.l(0.19d);
        r114.j(0.49583333333333335d);
        r114.g(0.49583333333333335d);
        r114.i(MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode.AnchorPushStreamMode1V2ForLargest.ordinal());
        r113.add(r114);
        i r115 = new i();
        r115.k(0.5041666666666667d);
        r115.l(0.19d);
        r115.j(0.49583333333333335d);
        r115.g(0.24557291666666667d);
        MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode r116 = MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode.AnchorPushStreamMode2V2Equal;
        r115.i(r116.ordinal());
        r113.add(r115);
        i r117 = new i();
        r117.k(0.5041666666666667d);
        r117.l(0.44026041666666665d);
        r117.j(0.49583333333333335d);
        r117.g(0.24557291666666667d);
        r117.i(r116.ordinal());
        r113.add(r117);
        h r118 = new h();
        r118.d(r113);
        r100.add(r118);
        ArrayList r119 = new ArrayList();
        i r120 = new i();
        r120.k(AudioStats.AUDIO_AMPLITUDE_NONE);
        r120.l(0.19d);
        r120.j(0.49583333333333335d);
        r120.g(0.24557291666666667d);
        r120.i(r116.ordinal());
        r119.add(r120);
        i r121 = new i();
        r121.k(0.5041666666666667d);
        r121.l(0.19d);
        r121.j(0.49583333333333335d);
        r121.g(0.24557291666666667d);
        r121.i(r116.ordinal());
        r119.add(r121);
        i r122 = new i();
        r122.k(0.5041666666666667d);
        r122.l(0.4402604166666667d);
        r122.j(0.49583333333333335d);
        r122.g(0.24557291666666667d);
        r122.i(r116.ordinal());
        r119.add(r122);
        i r123 = new i();
        r123.k(AudioStats.AUDIO_AMPLITUDE_NONE);
        r123.l(0.4402604166666667d);
        r123.j(0.49583333333333335d);
        r123.g(0.24557291666666667d);
        r123.i(r116.ordinal());
        r119.add(r123);
        h r124 = new h();
        r124.d(r119);
        r100.add(r124);
        f(r100);
        return;
    L9:
        r109 = MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode.AnchorPushStreamMode1V2ForLargest.ordinal();
        goto L10
    L5:
        r111 = MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode.AnchorPushStreamMode1V2ForLargest.ordinal();
        goto L6
    }

    public g() {
    }
}
