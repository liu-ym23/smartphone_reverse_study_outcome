package com.bytedance.badger.v;

import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f199343a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0 f199344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ v f199345c;

    public e(v r100, String r101, Function0 r102) {
        this.f199345c = r100;
        this.f199343a = r101;
        this.f199344b = r102;
    }

    public abstract Object b(JSONObject r100, String r101, Object r102);

    public final Object a() {
        Object r100 = this.f199344b.invoke();
        ((d) this.f199345c).getClass();
        JSONObject r101 = d.f199313b;
        if (r101 == null) goto L8;
        Object r102 = b(r101, this.f199343a, r100);
        if (r102 != null) goto L7;
        return r100;
    L7:
        return r102;
    L8:
        return r100;
    }
}
