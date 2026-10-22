package uf3;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.socialbase.downloader.segment.Segment;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Luf3/c;", "", "", "statusCode", "I", "getStatusCode", "()I", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "Luf3/e;", "tabDiscountInfo", "Luf3/e;", "getTabDiscountInfo", "()Luf3/e;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-shopping-api_release"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName("msg")
    private final String message;

    @SerializedName(Segment.JsonKey.START)
    private final int statusCode;

    @SerializedName("data")
    private final e tabDiscountInfo;

    public static final class a {
    }

    static {
    }

    public c() {
        this.statusCode = -1;
        this.message = null;
        this.tabDiscountInfo = null;
    }
}
