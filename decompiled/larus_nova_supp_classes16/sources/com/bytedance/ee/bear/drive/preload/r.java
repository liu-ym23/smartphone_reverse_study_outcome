package com.bytedance.ee.bear.drive.preload;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ee.bear.drive.cache.t;
import com.bytedance.ee.bear.drive.loader.download.platform.processor.VideoStreamingProcessor;
import com.bytedance.ee.bear.drive.view.preview.video.player.v;
import com.ss.ttvideoengine.IPreLoaderItemCallBackListener;
import com.ss.ttvideoengine.PreloaderURLItem;
import com.ss.ttvideoengine.TTVideoEngine;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class r {
    public static void b(a95.a r3) {
        v.a();     // Catch: Exception -> L5
        Application r1 = eu5.b.a;     // Catch: Exception -> L5
        String r4 = z75.b.g(t.g(), r3.b);     // Catch: Exception -> L5
        Intrinsics.checkNotNullParameter(r4, "preloadDir");     // Catch: Exception -> L5
        tt5.a.h("TTVideoEngineManager", "prepareForVideoPreload, ");     // Catch: Exception -> L5
        com.ss.android.lark.playerconfig.a.b("docs", VideoStreamingProcessor.VideoMetaInfo.VIDEO_CODE_TYPE_VALUE);     // Catch: Exception -> L5
        TTVideoEngine.setStringValue(0, r4);     // Catch: Exception -> L5
        TTVideoEngine.setIntValue(1, 104857600);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        tt5.a.f("TTVideoEngineWrapper", e, false);
    }

    public static void a(Map<String, String> r7, String r8, String r9, long r10, IPreLoaderItemCallBackListener r12) {
        PreloaderURLItem r6 = new PreloaderURLItem(r8, null, r10, new String[]{r9});
        if (hu5.a.e(r7) == true) goto L13;
        Iterator<Map.Entry<String, String>> r11 = r7.entrySet().iterator();
    L7:
        if (r11.hasNext() == false) goto L13;
        Map.Entry<String, String> r13 = r11.next();
        if (TextUtils.isEmpty(r13.getKey()) == true) goto L7;
        if (TextUtils.isEmpty(r13.getValue()) == true) goto L7;
        r6.setCustomHeader(r13.getKey(), r13.getValue());
    L13:
        r6.setCallBackListener(r12);
        TTVideoEngine.addTask(r6);
    }
}
