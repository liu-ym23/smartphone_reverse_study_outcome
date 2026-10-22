package nv2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lnv2/e;", "", "", "type", "I", "getType", "()I", "", "caption", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "", "showTime", "J", "b", "()J", "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("caption")
    private final String caption;

    @SerializedName("show_time")
    private final long showTime;

    @SerializedName("type")
    private final int type;

    public e() {
        this(0);
    }

    public final boolean c() {
        if (this.type <= 0) goto L15;
        String r100 = this.caption;
        if (r100 != null) goto L7;
        return false;
    L7:
        if (r100.length() <= 0) goto L9;
        boolean r101 = true;
    L10:
        if (r101 == true) goto L12;
        return false;
    L12:
        if (this.showTime <= 0) goto L18;
        return true;
    L18:
        return false;
    L9:
        r101 = false;
        goto L10
    L15:
        return false;
    }

    public final String toString() {
        return "RecTipsConfig(type=" + this.type + ", caption='" + this.caption + "', showTime=" + this.showTime + ')';
    }

    public final String a() {
        return this.caption;
    }

    public final long b() {
        return this.showTime;
    }

    public final int getType() {
        return this.type;
    }

    public e(int r100) {
        this.type = 0;
        this.caption = "";
        this.showTime = 0;
    }
}
