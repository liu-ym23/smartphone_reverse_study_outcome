package com.ss.ttvideoengine;

import com.ss.texturerender.VideoSurface;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes34.dex */
public final /* synthetic */ class d implements VideoSurface.SaveFrameCallback, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SnapshotListener f457058a;

    public /* synthetic */ d(SnapshotListener r100) {
        this.f457058a = r100;
    }

    @Override // com.ss.texturerender.VideoSurface.SaveFrameCallback
    public final int onFrame(ByteBuffer r100, int r101, int r102) {
        return TTVideoEngineImpl.k(this.f457058a, r100, r101, r102);
    }
}
