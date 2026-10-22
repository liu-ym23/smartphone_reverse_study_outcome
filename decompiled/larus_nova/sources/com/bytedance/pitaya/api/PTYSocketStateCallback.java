package com.bytedance.pitaya.api;

import com.bytedance.pitaya.jniwrapper.ReflectionCall;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u0000 \u00072\u00020\u0001:\u0002\b\tJ\u001a\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0002H&¨\u0006\n"}, d2 = {"Lcom/bytedance/pitaya/api/PTYSocketStateCallback;", "Lcom/bytedance/pitaya/jniwrapper/ReflectionCall;", "", "state", "info", "", "onSocketStateChange", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "SocketState", "pitayacore_release"}, k = 1, mv = {1, 7, 1})
public interface PTYSocketStateCallback extends ReflectionCall {
    public static final String CLOSED = "closed";
    public static final String CONNECTED = "connected";
    public static final String CONNECTING = "connecting";
    public static final a Companion = null;
    public static final String ERROR = "error";
    public static final String NONE = "none";
    public static final String UNKNOWN = "unknown";

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/bytedance/pitaya/api/PTYSocketStateCallback$SocketState;", "", "pitayacore_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.SOURCE)
    @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface SocketState {
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f266525a = null;

        static {
            f266525a = new a();
        }

        public a() {
        }
    }

    static {
        Companion = a.f266525a;
    }

    void onSocketStateChange(String r100, String r101);
}
