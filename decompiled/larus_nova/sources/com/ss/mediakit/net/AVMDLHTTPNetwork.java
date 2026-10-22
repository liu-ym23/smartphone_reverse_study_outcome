package com.ss.mediakit.net;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes40.dex */
public class AVMDLHTTPNetwork extends AVMDLNetClient {
    private static final int HTTP_TIME_OUT = 10;
    public static final MediaType JSON = null;
    private static OkHttpClient mClient;
    private Call mCall;

    static {
        JSON = MediaType.parse("application/json");
    }

    @Override // com.ss.mediakit.net.AVMDLNetClient
    public void cancel() {
        Call r100 = this.mCall;
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isCanceled() == true) goto L9;
        this.mCall.cancel();
        return;
    }

    public AVMDLHTTPNetwork() {
    }

    @Override // com.ss.mediakit.net.AVMDLNetClient
    public void startTask(String r100, Map<String, String> r101, final AVMDLNetClient.CompletionListener r102) {
        monitor-enter(AVMDLHTTPNetwork.class);
    L16:
        th = move-exception;
        throw th;
    L5:
        if (mClient != null) goto L7;
        OkHttpClient.Builder r103 = new OkHttpClient().newBuilder();     // Catch: Throwable -> L16
        TimeUnit r104 = TimeUnit.SECONDS;     // Catch: Throwable -> L16
        mClient = r103.connectTimeout(10, r104).writeTimeout(10, r104).readTimeout(10, r104).build();     // Catch: Throwable -> L16
    L7:
        monitor-exit(AVMDLHTTPNetwork.class);     // Catch: Throwable -> L16
        Request.Builder r105 = new Request.Builder().url(r100);
        if (r101 == null) goto L14;
        Iterator<String> r106 = r101.keySet().iterator();
    L12:
        if (r106.hasNext() == false) goto L14;
        String r107 = r106.next();
        r105.header(r107, r101.get(r107));
    L14:
        Request r108 = r105.build();
        Call r109 = mClient.newCall(r108);
        this.mCall = r109;
        r109.enqueue(new AnonymousClass1(this, r102));
    }

    @Override // com.ss.mediakit.net.AVMDLNetClient
    public void startTask(String r100, Map<String, String> r101, JSONObject r102, int r103, final AVMDLNetClient.CompletionListener r110) {
        monitor-enter(AVMDLHTTPNetwork.class);
    L21:
        th = move-exception;
        throw th;
    L5:
        if (mClient != null) goto L7;
        OkHttpClient.Builder r104 = new OkHttpClient().newBuilder();     // Catch: Throwable -> L21
        TimeUnit r105 = TimeUnit.SECONDS;     // Catch: Throwable -> L21
        mClient = r104.connectTimeout(10, r105).writeTimeout(10, r105).readTimeout(10, r105).build();     // Catch: Throwable -> L21
    L7:
        monitor-exit(AVMDLHTTPNetwork.class);     // Catch: Throwable -> L21
        Request.Builder r106 = new Request.Builder().url(r100);
        if (r101 == null) goto L17;
        if (r101.size() <= 0) goto L17;
        Iterator<String> r107 = r101.keySet().iterator();
    L14:
        if (r107.hasNext() == false) goto L17;
        String r108 = r107.next();
        r106.addHeader(r108, r101.get(r108));
    L17:
        if (r103 != 1) goto L19;
        r106.post(RequestBody.create(JSON, String.valueOf(r102)));
    L19:
        Call r109 = mClient.newCall(r106.build());
        this.mCall = r109;
        r109.enqueue(new AnonymousClass2(this, r110));
    }
}
