package com.ss.android.lark.chat.service.impl.mediaplay.depend;

import android.content.Context;
import com.bytedance.i18n.claymore.ClaymoreImpl;
import com.ss.android.lark.player.player.c;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.videosend.tools.l;
import com.suite.lark.platform.component.storage.file.dirs.h;
import com.suite.lark.platform.component.storage.file.dirs.m;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@ClaymoreImpl(c.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lcom/ss/android/lark/chat/service/impl/mediaplay/depend/VideoPlayerDependency;", "Lcom/ss/android/lark/player/player/IPlayerDependency;", "<init>", "()V", "getPreloadCacheDir", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "im-sdk-service_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VideoPlayerDependency implements c {
    public VideoPlayerDependency() {
    }

    public String getPreloadCacheDir(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r101 = l.f445018a;
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        int r102 = h.f460642c;
        h r103 = h.a.a(r100);
        r103.c(l.b());
        return r103.b(new m()).getRealPath();
    }
}
