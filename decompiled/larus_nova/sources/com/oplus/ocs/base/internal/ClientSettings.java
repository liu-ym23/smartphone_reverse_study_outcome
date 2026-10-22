package com.oplus.ocs.base.internal;

import com.oplus.ocs.base.common.Feature;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes34.dex */
public class ClientSettings {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f404252a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f404253b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private List<Feature> f404254c;

    public List<Feature> getList() {
        return this.f404254c;
    }

    public String getPackageName() {
        return this.f404252a;
    }

    public int getVersionCode() {
        return this.f404253b;
    }

    public ClientSettings(String r100) {
        this.f404252a = r100;
        this.f404253b = 100011;
        this.f404254c = new ArrayList();
    }

    public ClientSettings(String r100, int r101, List<Feature> r102) {
        this.f404252a = r100;
        this.f404253b = r101;
        this.f404254c = r102;
    }
}
