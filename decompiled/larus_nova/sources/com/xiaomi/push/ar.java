package com.xiaomi.push;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f463150a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public String f248a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, String> f249a;

    public String toString() {
        return String.format("resCode = %1$d, headers = %2$s, response = %3$s", new Object[]{Integer.valueOf(this.f463150a), this.f249a.toString(), this.f248a});
    }

    public ar() {
        this.f249a = new HashMap();
    }

    public String a() {
        return this.f248a;
    }
}
