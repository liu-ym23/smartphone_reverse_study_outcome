package com.bytedance.platform.aio.channel;

import com.bytedance.platform.aio.channel.js.model.BytesContentType;
import java.util.Map;

/* JADX INFO: loaded from: classes21.dex */
public interface b<T, R> {

    public interface a {
        void a();

        void b(boolean r100);
    }

    /* JADX INFO: renamed from: com.bytedance.platform.aio.channel.b$b, reason: collision with other inner class name */
    public interface InterfaceC3727b<R> {
        void U0(R r100);

        void a(String r100, String r101, Map<String, String> r102);

        void onClose();
    }

    void a(T r100, BytesContentType r101);

    void b();

    void c(h57.a r100);

    void close();

    void d(String r100, String r101, Map<String, String> r102, BytesContentType r103);

    void e();

    void flush();

    String getChannelId();
}
