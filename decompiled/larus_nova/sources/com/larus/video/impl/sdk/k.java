package com.larus.video.impl.sdk;

import com.larus.platform.api.l4;
import com.larus.utils.y;
import com.ss.ttvideoengine.model.VideoModel;
import com.ss.ttvideoengine.model.VideoRef;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes32.dex */
public final /* synthetic */ class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f375803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ l4 f375804b;

    public /* synthetic */ k(String r100, l4 r101) {
        this.f375803a = r100;
        this.f375804b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        final String r100 = this.f375803a;
        final l4 r101 = this.f375804b;
        VideoRef r102 = new VideoRef();
        r102.extractFields(new JSONObject(r100));     // Catch: Throwable -> L5
    L7:
        VideoModel r103 = new VideoModel();
        r103.setVideoRef(r102);
        final a r104 = new a(r103);
        y.c(new l(r101, r100, r104));
        return;
    L5:
        th = move-exception;
        th.printStackTrace();
        goto L7
    }
}
