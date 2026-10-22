package com.ss.ttvideoengine.selector;

import com.ss.ttvideoengine.model.IVideoModel;
import java.util.Map;

/* JADX INFO: loaded from: classes34.dex */
public interface Selector {
    public static final String TAG = "Selector";

    SelectedInfo select(IVideoModel r100, Map<Integer, Object> r101);
}
