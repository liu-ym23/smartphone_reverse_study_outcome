package com.bytedance.frameworks.baselib.network.http;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class BaseRequestContext {
    public a authCredentials;
    public boolean byPassProxy;
    public boolean bypassCookie;
    public boolean bypass_network_status_check;
    public int commonParamLevel;
    public boolean enable_http_cache;
    public JSONObject extraInfo;
    public boolean followRedirectInternal;
    public boolean force_handle_response;
    public boolean force_use_okhttp;
    public boolean ignoreCheckMinInputStreamBufferSize;
    public int input_stream_buffer_size;
    public boolean isCustomizedCookie;
    public boolean is_need_monitor_in_cancel;
    public b okHttpRequestClientBuilderHook;
    public int output_stream_buffer_size;
    public int priorityLevel;
    public long protect_timeout;
    public boolean read_error_response;
    public String remoteIp;
    public int request_flag;
    public int request_type_flags;
    public List<c> rotationHostRetryInfoList;
    public long socket_connect_timeout;
    public long socket_read_timeout;
    public long socket_write_timeout;
    public int status;
    public boolean streaming_force_return_response;
    public long throttle_net_speed;
    public long timeout_connect;
    public long timeout_read;
    public long timeout_write;

    /* JADX INFO: loaded from: classes19.dex */
    public static class a {
    }

    /* JADX INFO: loaded from: classes19.dex */
    public interface b {
    }

    /* JADX INFO: loaded from: classes19.dex */
    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f244666a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f244667b;

        public final Object clone() throws CloneNotSupportedException {
            return new c(this.f244666a, this.f244667b);
        }

        public c(String r100, String r101) {
            this.f244666a = r100;
            this.f244667b = r101;
        }
    }

    public BaseRequestContext() {
        this.force_use_okhttp = false;
        this.request_type_flags = 0;
        this.bypass_network_status_check = true;
        this.followRedirectInternal = true;
        this.enable_http_cache = false;
        this.is_need_monitor_in_cancel = true;
        this.bypassCookie = false;
        this.isCustomizedCookie = false;
        this.byPassProxy = false;
        this.extraInfo = new JSONObject();
        this.priorityLevel = -999;
        this.commonParamLevel = -1;
    }
}
