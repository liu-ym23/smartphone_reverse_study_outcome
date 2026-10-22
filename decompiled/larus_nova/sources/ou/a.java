package ou;

import com.bytedance.android.gamecp.base.network.response.RequestError;
import com.google.gson.annotations.SerializedName;

/* JADX INFO: loaded from: classes44.dex */
public class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient RequestError f526719a;

    @SerializedName("data")
    public T data;

    @SerializedName("extra")
    public Object extra;

    @SerializedName("status_code")
    public int statusCode;

    public a() {
    }
}
