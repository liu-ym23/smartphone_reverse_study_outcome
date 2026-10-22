package com.bytedance.memory.upload;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.network.okhttp.GlobalNetworkGate;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes21.dex */
public final class d {

    public static class a implements Callable<c> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f265547a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ byte[] f265548b;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public c call() {
            String r100 = this.f265547a;
            byte[] r101 = this.f265548b;
            OutputStream r102 = null;
            HttpURLConnection r103 = (HttpURLConnection) d.a(new URL(r100));     // Catch: Throwable -> L23 Exception -> L25
        L46:
            r103.setConnectTimeout(5000);     // Catch: Throwable -> L20 Exception -> L22
            r103.setReadTimeout(5000);     // Catch: Throwable -> L20 Exception -> L22
            r103.setUseCaches(false);     // Catch: Throwable -> L20 Exception -> L22
            boolean r104 = true;
            r103.setDoOutput(true);     // Catch: Throwable -> L20 Exception -> L22
            r103.setRequestMethod("POST");     // Catch: Throwable -> L20 Exception -> L22
            r103.setRequestProperty("Content-Type", "application/octet-stream");     // Catch: Throwable -> L20 Exception -> L22
            r103.setFixedLengthStreamingMode(r101.length);     // Catch: Throwable -> L20 Exception -> L22
            long r105 = System.nanoTime();     // Catch: Throwable -> L20 Exception -> L22
            OutputStream r110 = r103.getOutputStream();     // Catch: Exception -> L19 Throwable -> L20
            r110.write(r101);     // Catch: Throwable -> L16 Exception -> L18
            r110.flush();     // Catch: Throwable -> L16 Exception -> L18
            r110.close();     // Catch: Throwable -> L16 Exception -> L18
            int r106 = r103.getResponseCode();     // Catch: Exception -> L19 Throwable -> L20
            long r111 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - r105);     // Catch: Exception -> L19 Throwable -> L20
            if (r106 >= 200) goto L11;
        L13:
            r104 = false;
        L14:
            c r107 = new c(r100, r111, r104);     // Catch: Exception -> L19 Throwable -> L20
        L37:
            r103.disconnect();
        L38:
            return r107;
        L11:
            if (r106 >= 300) goto L13;
        L18:
            r102 = r110;
        L16:
            th = th;
            r102 = r110;
        L39:
            if (r102 != null) goto L53;
        L43:
            if (r103 == null) goto L59;
            r103.disconnect();
            throw th;
        L59:
            throw th;
        L53:
            r102.close();     // Catch: Exception -> L42
        L28:
            if (r105 != 0) goto L30;
            long r108 = Long.MAX_VALUE;
        L31:
            r107 = new c(r100, r108, false);     // Catch: Throwable -> L20
            if (r102 != null) goto L51;
        L36:
            if (r103 == null) goto L38;
        L51:
            r102.close();     // Catch: Exception -> L35
            goto L36
        L30:
            r108 = TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - r105);     // Catch: Throwable -> L20
        L20:
            th = th;
        L26:
            r105 = 0;
        L25:
            r103 = null;
        L23:
            th = th;
            r103 = null;
            goto L39
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ c call() throws Exception {
            return call();
        }

        public a(String r100, byte[] r101) {
            this.f265547a = r100;
            this.f265548b = r101;
        }
    }

    public static class b implements Comparator<Map.Entry<String, Long>> {
        public b() {
        }

        @Override // java.util.Comparator
        public final int compare(Map.Entry<String, Long> r100, Map.Entry<String, Long> r101) {
            return r100.getValue().compareTo(r101.getValue());
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f265549a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f265550b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f265551c;

        public c(String r100, long r101, boolean r102) {
            this.f265549a = r100;
            this.f265550b = r101;
            this.f265551c = r102;
        }
    }

    @Skip({"com.obric.assistant.network.okhttp"})
    public static URLConnection a(URL r100) throws IOException {
        String r101 = r100.getHost();     // Catch: Throwable -> L8 IOException -> L12
        String r102 = r100.getPath();     // Catch: Throwable -> L8 IOException -> L12
        if (com.obric.assistant.network.okhttp.a.c(r101, r102) == false) goto L11;
        FLogger.f375446a.i("UrlConnLancet", "openConnection drop host=" + r101 + " path=" + r102);     // Catch: Throwable -> L8 IOException -> L12
        com.obric.assistant.network.okhttp.a.b(GlobalNetworkGate.a(r101, r102), r101, r102);     // Catch: Throwable -> L8 IOException -> L12
        throw new IOException("[NetGuard] dropped " + r100);     // Catch: Throwable -> L8 IOException -> L12
    L11:
        return r100.openConnection();
    L12:
        e = move-exception;
        throw e;
    L8:
        th = move-exception;
        FLogger.f375446a.e("UrlConnLancet", "openConnection intercept failed, fallback to origin: " + th.getMessage());
        goto L11
    }

    public static List<String> b(List<String> r110) {
        if (r110 != null) goto L4;
    L54:
        return r110;
    L4:
        if (r110.size() <= 1) goto L54;
        byte[] r100 = new byte[262144];
        ExecutorService r101 = PThreadExecutorsUtils.newFixedThreadPool(Math.min(r110.size(), 4), new DefaultThreadFactory("rlSpeedTester"));
        ExecutorCompletionService r102 = new ExecutorCompletionService(r101);
        Iterator<String> r103 = r110.iterator();     // Catch: Throwable -> L49
    L9:
        if (r103.hasNext() == false) goto L11;
        r102.submit(new a(r103.next(), r100));     // Catch: Throwable -> L49
        goto L9
    L11:
        long r104 = System.currentTimeMillis();     // Catch: Throwable -> L49
        LinkedHashMap r105 = new LinkedHashMap();     // Catch: Throwable -> L49
        int r106 = 0;
    L13:
        if (r106 >= r110.size()) goto L27;
        long r107 = 5000 - (System.currentTimeMillis() - r104);
        if (r107 <= 0) goto L27;
        Future r108 = r102.poll(r107, TimeUnit.MILLISECONDS);     // Catch: InterruptedException -> L55 Throwable -> L49
        if (r108 == null) goto L27;
        c r109 = (c) r108.get();     // Catch: Exception -> L26 Throwable -> L49
    L22:
        r106 = r106 + 1;
        if (r109.f265551c == false) goto L13;
        r105.put(r109.f265549a, Long.valueOf(r109.f265550b));     // Catch: Throwable -> L49
    L26:
        r106 = r106 + 1;     // Catch: Throwable -> L49
    L27:
        r101.shutdownNow();     // Catch: Throwable -> L49
        if (r105.isEmpty() == false) goto L34;
        ArrayList r111 = new ArrayList(r110);     // Catch: Throwable -> L49
        if (r101.isShutdown() == true) goto L33;
        r101.shutdownNow();
    L33:
        return r111;
    L34:
        ArrayList r112 = new ArrayList(r105.entrySet());     // Catch: Throwable -> L49
        Collections.sort(r112, new b());     // Catch: Throwable -> L49
        ArrayList r113 = new ArrayList();     // Catch: Throwable -> L49
        Iterator r114 = r112.iterator();     // Catch: Throwable -> L49
    L36:
        if (r114.hasNext() == false) goto L38;
        r113.add(((Map.Entry) r114.next()).getKey());     // Catch: Throwable -> L49
        goto L36
    L38:
        Iterator<String> r115 = r110.iterator();     // Catch: Throwable -> L49
    L40:
        if (r115.hasNext() == false) goto L46;
        String r116 = r115.next();     // Catch: Throwable -> L49
        if (r113.contains(r116) == true) goto L40;
        r113.add(r116);     // Catch: Throwable -> L49
        goto L40
    L46:
        if (r101.isShutdown() == true) goto L48;
        r101.shutdownNow();
    L48:
        return r113;
    L49:
        th = move-exception;
        if (r101.isShutdown() == true) goto L53;
        r101.shutdownNow();
    L53:
        throw th;
    }
}
