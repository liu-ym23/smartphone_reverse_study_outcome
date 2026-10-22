package com.bytedance.ruler.strategy.store;

import android.os.Handler;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes3.dex */
public final class StrategyStore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static List<fa7.a> f267720a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, d> f267721b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final StrategyParseModel f267722c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f267723d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lock f267724e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Lock f267725f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final Gson f267726g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static boolean f267727h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final StrategyStore f267728i = null;

    public StrategyStore() {
    }

    static {
        f267728i = new StrategyStore();
        f267721b = new LinkedHashMap();
        f267722c = StrategyParseModel.PARSE_AT_STORE;
        f267723d = "";
        ReentrantReadWriteLock r100 = new ReentrantReadWriteLock();
        f267724e = r100.readLock();
        f267725f = r100.writeLock();
        f267726g = new Gson();
    }

    public final String toString() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L8
        JsonObject r101 = new JsonObject();     // Catch: Throwable -> L8
        Gson r102 = new GsonBuilder().setPrettyPrinting().create();     // Catch: Throwable -> L8
        r101.add("strategy_set_map", r102.toJsonTree(f267720a));     // Catch: Throwable -> L8
        JsonObject r103 = new JsonObject();     // Catch: Throwable -> L8
        Iterator r104 = ((LinkedHashMap) f267721b).entrySet().iterator();     // Catch: Throwable -> L8
    L4:
        if (r104.hasNext() == false) goto L6;
        Map.Entry r105 = (Map.Entry) r104.next();     // Catch: Throwable -> L8
        r103.add((String) r105.getKey(), (JsonElement) r102.fromJson(((d) r105.getValue()).toString(), JsonObject.class));     // Catch: Throwable -> L8
        goto L4
    L6:
        r101.add("strategy_set", r103);     // Catch: Throwable -> L8
        r101.add("signature", new JsonPrimitive(f267723d));     // Catch: Throwable -> L8
    L14:
        return r101.toString();
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Throwable r107 = Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(ResultKt.createFailure(th)));
        if (r107 == null) goto L12;
        r107.printStackTrace();
    L12:
        r101 = new JsonObject();
        goto L14
    }

    public static List b(final String r100) {
        return (List) d(new StrategyStore$getStrategyMapRules$1(r100));
    }

    public static d c(final String r100) {
        return (d) d(new StrategyStore$getStrategyScene$1(r100));
    }

    public static Object d(Function0 r100) {
        Lock r101 = f267724e;     // Catch: InterruptedException -> L12
        if (r101.tryLock() == true) goto L13;
        return null;
    L13:
        Object r102 = r100.invoke();     // Catch: Throwable -> L7
        r101.unlock();     // Catch: InterruptedException -> L12
        return r102;
    L7:
        th = move-exception;
        f267724e.unlock();     // Catch: InterruptedException -> L12
        throw th;     // Catch: InterruptedException -> L12
    L16:
        return null;
    }

    public static void e(final List r100) {
        Function0<Unit> r101 = new StrategyStore$updateStrategies$1(r100);
        Lock r102 = f267725f;     // Catch: Throwable -> L12
        r102.lock();     // Catch: Throwable -> L12
        r101.invoke();     // Catch: Throwable -> L12
        r102.unlock();
        f267727h = true;
        com.bytedance.ruler.a r103 = com.bytedance.ruler.d.f267678b;
        if (r103 == null) goto L9;
        Long r104 = r103.f267615a;
        if (r104 == null) goto L9;
        long r105 = r104.longValue();
    L10:
        Handler r106 = com.bytedance.ruler.utils.a.f267757a;
        com.bytedance.ruler.utils.a.a(new StrategyStore$updateStrategies$$inlined$runInBackground$1(), r105);
        return;
    L9:
        r105 = 0;
    L12:
        th = move-exception;
        f267725f.unlock();
        throw th;
    }

    public static fa7.c a(final String r100, final String r101) {
        return (fa7.c) d(new StrategyStore$getRulesWithGroupName$1(r100, r101));
    }
}
