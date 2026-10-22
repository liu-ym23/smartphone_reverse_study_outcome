package com.larus.bmhome.chat.api;

import com.larus.bmhome.ability.ContainerExceptionType;
import com.larus.bmhome.ability.MessageMonitorItemType;
import kotlin.Deprecated;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
@Deprecated(message = "do not use appreciable trace outside chat core")
public interface t {

    public static final class a {
        public static /* synthetic */ void a(t r100, String r101, ContainerExceptionType r102, String r103, JSONObject r110) {
            r100.a(r101, r102, r103, r110, null);
        }
    }

    void a(String r100, ContainerExceptionType r101, String r102, JSONObject r103, Long r104);

    void b(String r100, Object r101);

    long c(MessageMonitorItemType r100);

    boolean d(MessageMonitorItemType r100);

    void e(String r100, MessageMonitorItemType r101);

    void f(String r100, Object r101);

    void g(String r100, String r101, String r102, String r103);

    void h(String r100, String r101, String r102, String r103);
}
