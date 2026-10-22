package org.nanohttpd.protocols.http;

import java.net.Socket;
import java.util.Map;

/* JADX INFO: loaded from: classes42.dex */
public interface c {
    String a();

    Socket b();

    Map<String, String> getHeaders();

    String getUri();
}
