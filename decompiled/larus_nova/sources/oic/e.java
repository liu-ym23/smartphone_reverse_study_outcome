package oic;

import com.bytedance.common.utility.NetworkUtils;
import com.ss.ttvideoengine.Resolution;
import com.ss.ttvideoengine.model.VideoInfo;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import nic.j;

/* JADX INFO: loaded from: classes40.dex */
public final class e implements j {
    public e() {
    }

    @Override // nic.j
    public final boolean interceptPlay(NetworkUtils.NetworkType r100) {
        return false;
    }

    @Override // nic.j
    public final boolean interceptPlayWhenVideoInfoReady(VideoRef r100) {
        return false;
    }

    @Override // nic.j
    public final VideoInfo selectVideoInfoToPlay(VideoModel r100) {
        return null;
    }

    @Override // nic.j
    public final VideoInfo selectVideoInfoToPlay(VideoRef r100) {
        int r101 = Resolution.Standard.getIndex();
        return fjc.c.b(r100).get(r101);
    }
}
