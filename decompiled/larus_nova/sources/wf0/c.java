package wf0;

import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.live.extension.plugin.api.livepusher.ILiveWrappedLivePusher;
import com.bytedance.live.datacontext.j;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes46.dex */
public final class c implements qz.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f559460a = 0;

    public static final class a {
    }

    static {
    }

    public c() {
        ILiveWrappedLivePusher.Companion.getClass();
        ILiveWrappedLivePusher r100 = ILiveWrappedLivePusher.a.b();
        if (r100 == null) goto L5;
        r100.getRendererCommon();
    L5:
        j<com.bytedance.android.live.pushstream.d> r101 = m.i().getLiveStream();
        if (r101 == null) goto L8;
        com.bytedance.android.live.pushstream.d r102 = r101.getValue();
    L9:
        new WeakReference(r102);
        return;
    L8:
        r102 = null;
        goto L9
    }
}
