package com.obric.audio.continuous_talk.session.impl.plugin;

import kotlinx.coroutines.flow.MutableSharedFlow;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes33.dex */
public interface b extends com.larus.audio.call.arch.e {
    void B0(com.obric.audio.continuous_talk.i r100);

    void H1(float[] r100);

    boolean I0(JSONObject r100);

    MutableSharedFlow s();
}
