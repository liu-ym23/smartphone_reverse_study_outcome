package s76;

import com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.PlayMode;
import com.tencent.qqmusic.third.api.contract.Keys;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class b {

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f540930a = null;

        static {
            int[] r100 = new int[PlayMode.values().length];
            r100[PlayMode.SINGLE_LOOP.ordinal()] = 1;
            r100[PlayMode.LIST_LOOP.ordinal()] = 2;
            f540930a = r100;
        }
    }

    static {
    }

    public static com.bytedance.ies.xelement.defaultimpl.player.engine.api.queue.a a(PlayMode r100) {
        Intrinsics.checkNotNullParameter(r100, Keys.API_EVENT_KEY_PLAY_MODE);
        int r101 = a.f540930a[r100.ordinal()];
        if (r101 == 1) goto L9;
        if (r101 == 2) goto L11;
        return new c();
    L11:
        return new s76.a();
    L9:
        return new d();
    }
}
