package com.ss.android.lark.statistics.chat;

import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
public final class d implements s5c.d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f440678a;

    @Override // s5c.d
    public final String getKey() {
        return "components_count";
    }

    @Override // s5c.d
    public final JSONObject toJson() {
        return s5c.d.b.c(this);
    }

    @Override // s5c.d
    public final String getValue() {
        return this.f440678a;
    }

    public d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.f440678a = r100;
    }

    @Override // s5c.d
    public final s5c.d plus(Map<String, ? extends Object> r100) {
        return s5c.d.b.a(this, r100);
    }

    @Override // s5c.d
    public final s5c.d plus(s5c.d r100) {
        return s5c.d.b.b(this, r100);
    }
}
