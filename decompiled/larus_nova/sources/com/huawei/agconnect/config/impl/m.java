package com.huawei.agconnect.config.impl;

import android.content.Context;
import com.huawei.agconnect.config.ConfigReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes23.dex */
class m implements ConfigReader {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map<String, String> f276738a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final k f276739b;

    public m(Context r100, String r101) {
        this.f276738a = new ConcurrentHashMap();
        this.f276739b = new k(r100, r101);
    }

    @Override // com.huawei.agconnect.config.ConfigReader
    public String getString(String r100, String r101) {
        String r102 = this.f276738a.get(r100);
        if (r102 == null) goto L5;
        return r102;
    L5:
        String r103 = this.f276739b.a(r100, r101);
        if (r103 != null) goto L8;
        return r101;
    L8:
        this.f276738a.put(r100, r103);
        return r103;
    }

    public String toString() {
        return "SecurityResourcesReader{mKey=, encrypt=true}";
    }
}
