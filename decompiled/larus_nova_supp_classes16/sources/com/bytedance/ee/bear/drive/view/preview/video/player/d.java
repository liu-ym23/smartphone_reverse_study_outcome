package com.bytedance.ee.bear.drive.view.preview.video.player;

import android.content.Context;
import com.ss.ttvideoengine.TTVideoEngine;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d extends e {
    public d(Context r3) {
        super(r3);
        tt5.a.h("TTM3U8Player", "initM3U8Options");
        TTVideoEngine r0 = this.a;
        if (r0 != null) goto L5;
        tt5.a.h("TTM3U8Player", "initM3U8Options, videoEngine is null.");
        return;
    L5:
        r0.setIntOption(46003, 1);
        r0.setIntOption(46033, 1);
    }
}
