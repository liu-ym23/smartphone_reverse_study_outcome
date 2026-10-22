package com.bytedance.ee.bear.drive.view.preview.video.player;

import com.bytedance.ee.bear.drive.loader.download.platform.processor.VideoStreamingProcessor;
import com.ss.android.lark.playerconfig.LarkPlayerSettings;
import com.ss.ttvideoengine.TTVideoEngine;
import com.ss.ttvideoengine.utils.TTVideoEngineLog;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class v {
    static {
    }

    @JvmStatic
    public static final void a() {
        if (((Boolean) new ml5.b("debug_config").a("tt_video_log_enable", Boolean.FALSE)).booleanValue() == false) goto L6;
        tt5.a.h("TTVideoEngineManager", "TTVideoLog has open");
        TTVideoEngineLog.turnOn(1, 1);
        return;
    }

    @JvmStatic
    public static final TTVideoEngine b(e.d r10) {
        e.C0186e r0 = e.m;
        e.a r1 = e.l;
        Intrinsics.checkNotNullParameter(r0, "eventListener");
        Intrinsics.checkNotNullParameter(r10, "engineListener");
        Intrinsics.checkNotNullParameter(r1, "engineInfoListener");
        tt5.a.h("TTVideoEngineManager", "instanceTTVideoEngine ");
        LarkPlayerSettings.NonStandardEngineSetting r2 = new LarkPlayerSettings.NonStandardEngineSetting(0, 0, 0, 0, 15, null);
        r2.setEnableLooper(0);
        Unit r3 = Unit.INSTANCE;
        TTVideoEngine r4 = com.ss.android.lark.playerconfig.a.a("docs", VideoStreamingProcessor.VideoMetaInfo.VIDEO_CODE_TYPE_VALUE, r2);
        r4.setListener(r10);
        r4.setVideoEngineInfoListener(r1);
        return r4;
    }
}
