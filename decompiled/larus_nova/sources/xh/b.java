package xh;

import com.google.gson.annotations.SerializedName;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\u0018\u00002\u00020\u0001:\u0005\u0010\u000b\u0007\u0014\u0015B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0016"}, d2 = {"Lxh/b;", "", "", EventConstant.Key.MODULE, "Ljava/lang/String;", "getModule", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "event", "getEvent", "b", "data", "Ljava/lang/Object;", "getData", "()Ljava/lang/Object;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/lang/Object;)V", "<init>", "()V", "d", "e", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("data")
    private Object data;

    @SerializedName("event")
    private String event;

    @SerializedName(EventConstant.Key.MODULE)
    private String module;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Lxh/b$a;", "", "", "host", "Ljava/lang/String;", "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "path", "getPath", "b", com.alipay.sdk.m.p.e.f25671s, "getMethod", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("host")
        private String host;

        @SerializedName(com.alipay.sdk.m.p.e.f25671s)
        private String method;

        @SerializedName("path")
        private String path;

        public a() {
        }

        public final void a(String r100) {
            this.method = r100;
        }

        public final void b(String r100) {
            this.path = r100;
        }
    }

    /* JADX INFO: renamed from: xh.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\b¨\u0006\u001e"}, d2 = {"Lxh/b$b;", "", "", "host", "Ljava/lang/String;", "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "path", "getPath", "c", "logId", "getLogId", "b", "", "errorCode", "Ljava/lang/Integer;", "getErrorCode", "()Ljava/lang/Integer;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/lang/Integer;)V", "statusCode", "getStatusCode", "d", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "getStatusMsg", "e", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C8238b {

        @SerializedName("error_code")
        private Integer errorCode;

        @SerializedName("host")
        private String host;

        @SerializedName("log_id")
        private String logId;

        @SerializedName("path")
        private String path;

        @SerializedName("status_code")
        private Integer statusCode;

        @SerializedName("status_msg")
        private String statusMsg;

        public C8238b() {
        }

        public final void a(Integer r100) {
            this.errorCode = r100;
        }

        public final void b(String r100) {
            this.logId = r100;
        }

        public final void c(String r100) {
            this.path = r100;
        }

        public final void d(Integer r100) {
            this.statusCode = r100;
        }

        public final void e(String r100) {
            this.statusMsg = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u001b"}, d2 = {"Lxh/b$c;", "", "", "host", "Ljava/lang/String;", "getHost", "()Ljava/lang/String;", "setHost", "(Ljava/lang/String;)V", "path", "getPath", "b", "logId", "getLogId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "statusCode", "Ljava/lang/Integer;", "getStatusCode", "()Ljava/lang/Integer;", "c", "(Ljava/lang/Integer;)V", com.bytedance.android.ec.core.event.a.KEY_STATUS_MSG, "getStatusMsg", "d", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("host")
        private String host;

        @SerializedName("log_id")
        private String logId;

        @SerializedName("path")
        private String path;

        @SerializedName("status_code")
        private Integer statusCode;

        @SerializedName("status_msg")
        private String statusMsg;

        public c() {
        }

        public final void a(String r100) {
            this.logId = r100;
        }

        public final void b(String r100) {
            this.path = r100;
        }

        public final void c(Integer r100) {
            this.statusCode = r100;
        }

        public final void d(String r100) {
            this.statusMsg = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0018\u0010\u0019R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lxh/b$d;", "", "", RemoteMessageConst.MSGID, "Ljava/lang/String;", "getMsgId", "()Ljava/lang/String;", "c", "(Ljava/lang/String;)V", "targetRoomId", "getTargetRoomId", "d", "", "isFromVirtualChannel", "Z", "()Z", "b", "(Z)V", "content", "Ljava/lang/Object;", "getContent", "()Ljava/lang/Object;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/lang/Object;)V", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class d {

        @SerializedName("content")
        private Object content;

        @SerializedName("is_from_virtual_channel")
        private boolean isFromVirtualChannel;

        @SerializedName("msg_id")
        private String msgId;

        @SerializedName("target_room_id")
        private String targetRoomId;

        public d() {
        }

        public final void a(Object r100) {
            this.content = r100;
        }

        public final void b(boolean r100) {
            this.isFromVirtualChannel = r100;
        }

        public final void c(String r100) {
            this.msgId = r100;
        }

        public final void d(String r100) {
            this.targetRoomId = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lxh/b$e;", "", "", "schema", "Ljava/lang/String;", "getSchema", "()Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "(Ljava/lang/String;)V", "<init>", "()V", "ec-core_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class e {

        @SerializedName("schema")
        private String schema;

        public e() {
        }

        public final void a(String r100) {
            this.schema = r100;
        }
    }

    public b() {
    }

    public final void a(Object r100) {
        this.data = r100;
    }

    public final void b(String r100) {
        this.event = r100;
    }

    public final void c(String r100) {
        this.module = r100;
    }
}
