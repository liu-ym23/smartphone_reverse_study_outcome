package com.bytedance.scene.group;

import com.bytedance.scene.Scene;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes19.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<GroupRecord> f268672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<Scene, GroupRecord> f268673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, GroupRecord> f268674c;

    public a() {
        this.f268672a = new ArrayList();
        this.f268673b = new HashMap();
        this.f268674c = new HashMap();
    }

    public final GroupRecord a(Scene r100) {
        return (GroupRecord) ((HashMap) this.f268673b).get(r100);
    }
}
