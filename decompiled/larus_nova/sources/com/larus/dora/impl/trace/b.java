package com.larus.dora.impl.trace;

import java.text.SimpleDateFormat;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import org.json.JSONArray;
import p69.c;
import p69.e;

/* JADX INFO: loaded from: classes27.dex */
public final class b {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lazy<b> f338085f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f338086g = 0;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f338087h = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f338088a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, JSONArray> f338089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f338090c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f338091d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final SimpleDateFormat f338092e;

    public static final class a {
    }

    static {
        f338085f = LazyKt.lazy(new c());
        f338086g = 1;
        f338087h = 2;
    }

    public b() {
        this.f338088a = LazyKt.lazy(new e());
        this.f338089b = new ConcurrentHashMap();
        this.f338092e = new SimpleDateFormat("HH:mm:ss.SSS");
    }
}
