package com.larus.bmhome.chat.api;

import com.bytedance.ai.widget.view.WidgetBoxView;
import java.util.Map;

/* JADX INFO: loaded from: classes25.dex */
public interface r {
    WidgetBoxView a();

    int getBoxType();

    void sendEvent(String r100, Map<String, ? extends Object> r101);

    void updateData(String r100);
}
