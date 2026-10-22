package ph3;

import com.google.gson.annotations.SerializedName;
import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Lph3/a;", "", "", "id", "Ljava/lang/String;", "getId", "()Ljava/lang/String;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "getModel", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private final String f529258id;

    @SerializedName(DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL)
    private final String model;

    public a() {
        this(null, null);
    }

    public a(String r100, String r101) {
        this.f529258id = r100;
        this.model = r101;
    }
}
