package com.lynx.jsbridge;

import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes32.dex */
public final class a implements IModuleCreator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ConcurrentHashMap<String, LynxModuleWrapper> f381353a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile b f381354b;

    public a(b r100) {
        this.f381353a = new ConcurrentHashMap();
        this.f381354b = r100;
    }
}
