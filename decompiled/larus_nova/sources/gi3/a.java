package gi3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.ControlRule;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR(\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lgi3/a;", "", "", "url", "Ljava/lang/String;", "e", "()Ljava/lang/String;", "", "initData", "Ljava/util/Map;", "c", "()Ljava/util/Map;", "logData", "d", ControlRule.KEY_EXTRA_DATA, "b", "Lcom/bytedance/android/ec/core/btm/a;", "btmFields", "Lcom/bytedance/android/ec/core/btm/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/android/ec/core/btm/a;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f481351b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f481352a;

    @SerializedName("btm_fields")
    private final com.bytedance.android.ec.core.btm.a btmFields;

    @SerializedName("extra_data")
    private final Map<String, Object> extraData;

    @SerializedName("init_data")
    private final Map<String, Object> initData;

    @SerializedName("log_data")
    private final Map<String, Object> logData;

    @SerializedName("url")
    private final String url;

    /* JADX INFO: renamed from: gi3.a$a, reason: collision with other inner class name */
    public static final class C6026a {
    }

    static {
    }

    public a() {
        this(null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof a) == false) goto L18;
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.url, r101.url) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f481352a, r101.f481352a) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.initData, r101.initData) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.logData, r101.logData) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.extraData, r101.extraData) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.btmFields, r101.btmFields) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.url;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f481352a;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.initData;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, Object> r110 = this.logData;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, Object> r113 = this.extraData;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        com.bytedance.android.ec.core.btm.a r116 = this.btmFields;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "HybridDialogParam(url=" + this.url + ", settingsKey=" + this.f481352a + ", initData=" + this.initData + ", logData=" + this.logData + ", extraData=" + this.extraData + ", btmFields=" + this.btmFields + ")";
    }

    public final com.bytedance.android.ec.core.btm.a a() {
        return this.btmFields;
    }

    public final Map<String, Object> b() {
        return this.extraData;
    }

    public final Map<String, Object> c() {
        return this.initData;
    }

    public final Map<String, Object> d() {
        return this.logData;
    }

    public final String e() {
        return this.url;
    }

    public a(String r100, String r101, Map<String, ? extends Object> r102, Map<String, ? extends Object> r103, Map<String, ? extends Object> r104, com.bytedance.android.ec.core.btm.a r105) {
        this.url = r100;
        this.f481352a = r101;
        this.initData = r102;
        this.logData = r103;
        this.extraData = r104;
        this.btmFields = r105;
    }
}
