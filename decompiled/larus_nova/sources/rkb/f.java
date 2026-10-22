package rkb;

import com.bumptech.glide.request.Request;

/* JADX INFO: loaded from: classes36.dex */
public interface f {
    void begin();

    void clear();

    boolean isCleared();

    boolean isComplete();

    boolean isEquivalentTo(Request r100);

    boolean isResourceSet();

    boolean isRunning();

    void pause();
}
