package com.bytedance.salamander.anniex;

import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes20.dex */
public final class l4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public CoreViewType f268210a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f268211b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public ClientComponent f268212c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f268213d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f268214e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public long f268215f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Map<String, String> f268216g;

    public l4() {
        this.f268210a = CoreViewType.AnnieXCard;
        this.f268211b = "default_bid";
        this.f268213d = "__hybrid_default";
        this.f268214e = -1;
        this.f268215f = -1;
        this.f268216g = new LinkedHashMap();
    }

    public final Map<String, String> getContext() {
        return this.f268216g;
    }
}
