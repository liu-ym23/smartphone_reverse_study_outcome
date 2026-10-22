package r14;

import com.bytedance.awemeopen.bizmodels.feed.FeedListExtraInfoAsStringAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@JsonAdapter(FeedListExtraInfoAsStringAdapter.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lr14/v;", "", "Lr14/x;", "hostExtraInfo", "Lr14/x;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lr14/x;", "b", "(Lr14/x;)V", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f535655a;

    @SerializedName("ao_host_extra_info")
    private x hostExtraInfo;

    public final boolean c() {
        Integer r100 = this.f535655a;
        if (r100 != null) goto L6;
    L8:
        return false;
    L6:
        if (r100.intValue() != 1) goto L8;
        return true;
    }

    public v() {
    }

    public final x a() {
        return this.hostExtraInfo;
    }

    public final void b(x r100) {
        this.hostExtraInfo = r100;
    }
}
