package com.bytedance.ies.xelement.live;

import androidx.lifecycle.Observer;
import com.bytedance.android.livesdkapi.roomplayer.ILivePlayerScene;
import com.bytedance.android.livesdkapi.xlive.IXLivePlayerView;
import java.util.HashMap;

/* JADX INFO: loaded from: classes19.dex */
public interface a {
    void a(IXLivePlayerView r100);

    void b(HashMap r100);

    void c(IXLivePlayerView r100, com.bytedance.ies.xelement.live.impl.i r101);

    void d();

    void e(IXLivePlayerView r100, Observer<ILivePlayerScene> r101);

    void isShared();
}
