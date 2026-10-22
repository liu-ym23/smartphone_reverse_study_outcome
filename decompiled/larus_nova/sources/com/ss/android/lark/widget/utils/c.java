package com.ss.android.lark.widget.utils;

import com.ss.android.lark.videosend.checker.raw.VideoPreCheckRawService;
import com.ss.android.lark.videosend.compress.VideoPreCompressManager;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements VideoPreCheckRawService.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List<String> f449078a;

    @Override // com.ss.android.lark.videosend.checker.raw.VideoPreCheckRawService.a
    public final void onFinish() {
        Iterator<String> r100 = this.f449078a.iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        String r101 = r100.next();
        VideoPreCompressManager.compress(new VideoPreCompressManager.a(VideoPreCompressManager.Scene.OPEN_ALBUM, r101, false, null));
        goto L4
    }

    public c(List<String> r100) {
        this.f449078a = r100;
    }
}
