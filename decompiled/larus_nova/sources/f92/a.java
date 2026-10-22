package f92;

import androidx.camera.video.AudioStats;
import com.bytedance.android.livesdk.chatroom.model.interact.MultiAnchorLinkmicLiveCoreInfo;
import com.bytedance.android.livesdk.config.ma0;
import com.bytedance.android.livesdk.interactivity.medialink.ui.window.WindowLayoutType;
import java.util.ArrayList;
import kotlin.Unit;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends f {

    /* JADX INFO: renamed from: f92.a$a, reason: collision with other inner class name */
    public static final class C5871a {
    }

    static {
    }

    @Override // f92.f
    public final void e() {
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        i r102 = new i();
        r102.k(AudioStats.AUDIO_AMPLITUDE_NONE);
        r102.l(AudioStats.AUDIO_AMPLITUDE_NONE);
        r102.j(1.0d);
        r102.g(1.0d);
        r102.i(1);
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
        r120.j(0.6613333333333333d);
        r120.g(0.693d);
        r120.i(MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode.AnchorPushStreamMode1V3ForLargest.ordinal());
        r120.h(WindowLayoutType.EnlargeBig.ordinal());
        r119.add(r120);
        i r121 = new i();
        r121.k(0.6696666666666666d);
        r121.l(0.19d);
        r121.j(0.3303333333333333d);
        r121.g(0.22787499999999997d);
        MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode r122 = MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode.AnchorPushStreamMode1V3ForSecond;
        r121.i(r122.ordinal());
        WindowLayoutType r123 = WindowLayoutType.EnlargeSmall;
        r121.h(r123.ordinal());
        r119.add(r121);
        i r124 = new i();
        r124.k(0.6696666666666666d);
        r124.l(0.4225625d);
        r124.j(0.3303333333333333d);
        r124.g(0.22787499999999997d);
        r124.i(r122.ordinal());
        r124.h(r123.ordinal());
        r119.add(r124);
        i r125 = new i();
        r125.k(0.6696666666666666d);
        r125.l(0.655125d);
        r125.j(0.3303333333333333d);
        r125.g(0.22787499999999997d);
        r125.i(r122.ordinal());
        r125.h(r123.ordinal());
        r119.add(r125);
        h r126 = new h();
        r126.d(r119);
        r100.add(r126);
        f(r100);
        return;
    L9:
        r109 = MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode.AnchorPushStreamMode1V2ForLargest.ordinal();
        goto L10
    L5:
        r111 = MultiAnchorLinkmicLiveCoreInfo.AnchorPushStreamMode.AnchorPushStreamMode1V2ForLargest.ordinal();
        goto L6
    }

    public a() {
    }
}
