package com.lynx.clay.embedding.engine.loader;

/* JADX INFO: loaded from: classes32.dex */
public abstract class ResourceLoader {
    public ResourceLoader() {
    }

    public abstract void cancelAll(boolean r100);

    public void load(int r100, String r101, ResourceLoaderCallback r102, boolean r103, boolean r104) {
    }

    private void load(int r100, String r101, long r102, boolean r110, boolean r111) {
        load(r100, r101, new ResourceLoaderCallback(r102), r110, r111);
    }
}
