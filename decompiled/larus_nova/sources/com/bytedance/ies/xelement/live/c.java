package com.bytedance.ies.xelement.live;

import android.view.View;
import com.bytedance.android.livesdkapi.xlive.IXLivePlayerView;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public interface c {
    boolean a(HashMap r100);

    IXLivePlayerView b();

    void c();

    com.bytedance.ies.xelement.live.impl.h config();

    View createPlayerView();

    boolean d();

    void destroy();

    void onAttach();

    void onDetach();

    void onListCellAppear(String r100);

    void onListCellDisAppear(String r100);

    void onListCellPrepareForReuse(String r100);

    void onPropsUpdated();

    void pause();

    void play();

    View playerView();

    void sendCustomEvents(String r100, Map<String, ? extends Object> r101);

    void stop();
}
