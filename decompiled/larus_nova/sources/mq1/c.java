package mq1;

import android.content.Context;
import com.bytedance.android.livesdk.chatroom.replay.cache.ui.ReplayCacheDialog;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: classes8.dex */
public interface c {
    lm1.a c();

    com.bytedance.android.livesdk.chatroom.replay.toolbar.behavior.d d(Context r100, DataCenter r101);

    void deleteCache(String r100);

    ReplayCacheDialog f(Context r100, DataCenter r101, Integer r102);

    void g(Map<String, String> r100, boolean r101);

    String getCachedVideoId(long r100);

    Map<String, Pair<String, String>> getLocalVideoPath(String r100);
}
