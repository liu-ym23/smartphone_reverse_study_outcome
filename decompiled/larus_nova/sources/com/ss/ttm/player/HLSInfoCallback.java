package com.ss.ttm.player;

/* JADX INFO: loaded from: classes40.dex */
public abstract class HLSInfoCallback extends TraitObject {
    public static final int Version0 = 0;

    public HLSInfoCallback() {
        super(7, 0, 0);
    }

    public abstract void onContentCallback(String r100);

    public abstract void onLiveDurationCallback(long r100);
}
