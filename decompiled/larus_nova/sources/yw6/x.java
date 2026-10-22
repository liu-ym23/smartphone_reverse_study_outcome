package yw6;

import com.google.gson.annotations.SerializedName;
import com.ss.android.lark.passport.signinsdk_api.base.log.UniContext;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lyw6/x;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "", "bizCode", "I", "getBizCode", "()I", "", "localTime", "J", "getLocalTime", "()J", "locallife-pdp-impl_release"}, k = 1, mv = {1, 4, 3})
public class x {

    @SerializedName(UniContext.KEY_OF_BIZ_CODE)
    private final int bizCode;

    @SerializedName("local_time")
    private final long localTime;

    @SerializedName("type")
    private final String type;

    public x() {
        this(null, 7);
    }

    public final String getType() {
        return this.type;
    }

    public x(String r100, int r101) {
        if ((r101 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r101 & 2) == 0) goto L8;
        int r102 = 1092;
    L10:
        if ((r101 & 4) == 0) goto L12;
        long r103 = System.currentTimeMillis();
    L13:
        this.type = r100;
        this.bizCode = r102;
        this.localTime = r103;
        return;
    L12:
        r103 = 0;
        goto L13
    L8:
        r102 = 0;
        goto L10
    }
}
