package ra1;

import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\f\u0010\rR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lra1/a;", "", "", "rowData", "Ljava/lang/String;", "getRowData", "()Ljava/lang/String;", "setRowData", "(Ljava/lang/String;)V", "groupId", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "c", "<init>", "()V", "livesearchimpl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f536802d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f536803a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public JsonObject f536804b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Room f536805c;

    @SerializedName("group_id")
    private String groupId;

    @SerializedName("rawdata")
    private String rowData;

    /* JADX INFO: renamed from: ra1.a$a, reason: collision with other inner class name */
    public static final class C7452a {
    }

    static {
    }

    public final Room b() {
        if (this.f536805c != null) goto L8;
        Room r100 = (Room) GsonProtectorUtils.fromJson(GsonHelper.get(), this.rowData, Room.class);
        this.f536805c = r100;
        if (r100 == null) goto L8;
        r100.setRequestId(this.f536803a);
    L8:
        return this.f536805c;
    }

    public a() {
        this.rowData = "";
        this.groupId = "";
        this.f536803a = "";
        this.f536804b = new JsonObject();
    }

    public final String a() {
        return this.groupId;
    }

    public final void c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.groupId = r100;
    }
}
