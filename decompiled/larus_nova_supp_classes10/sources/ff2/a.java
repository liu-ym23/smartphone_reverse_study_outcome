package ff2;

import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b%\u0010&R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR$\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR$\u0010\u0015\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR$\u0010\u0018\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001c\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010\"\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!¨\u0006'"}, d2 = {"Lff2/a;", "", "", "version", "Ljava/lang/String;", "getVersion", "()Ljava/lang/String;", "setVersion", "(Ljava/lang/String;)V", "targetUserId", "getTargetUserId", "g", "targetInteractId", "getTargetInteractId", "e", "targetInteractIdStr", "getTargetInteractIdStr", "f", "senderUserId", "getSenderUserId", "d", "senderInteractId", "a", "setSenderInteractId", "senderInteractIdStr", "b", "c", "", "priority", "I", "getPriority", "()I", "setPriority", "(I)V", LocationMonitorConst.TYPE, "getType", "h", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class a {

    @SerializedName("priority")
    private int priority;

    @SerializedName("send_uid")
    private String senderInteractId;

    @SerializedName("send_uid_str")
    private String senderInteractIdStr;

    @SerializedName("send_id")
    private String senderUserId;

    @SerializedName("target_uid")
    private String targetInteractId;

    @SerializedName("target_uid_str")
    private String targetInteractIdStr;

    @SerializedName("target_id")
    private String targetUserId;

    @SerializedName(LocationMonitorConst.TYPE)
    private int type;

    @SerializedName("ver")
    private String version;

    /* JADX INFO: renamed from: ff2.a$a, reason: collision with other inner class name */
    public static final class C0139a {
    }

    static {
    }

    public final void e() {
        this.targetInteractId = BDLocationException.ERROR_TIMEOUT;
    }

    public final void f() {
        this.targetInteractIdStr = BDLocationException.ERROR_TIMEOUT;
    }

    public final void g() {
        this.targetUserId = BDLocationException.ERROR_TIMEOUT;
    }

    public a() {
        this.version = "1";
        this.priority = 1;
    }

    public final String a() {
        return this.senderInteractId;
    }

    public final String b() {
        return this.senderInteractIdStr;
    }

    public final int getType() {
        return this.type;
    }

    public final void c(String r1) {
        this.senderInteractIdStr = r1;
    }

    public final void d(String r1) {
        this.senderUserId = r1;
    }

    public final void h(int r1) {
        this.type = r1;
    }
}
