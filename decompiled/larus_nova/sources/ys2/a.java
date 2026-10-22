package ys2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.ArrayList;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R.\u0010\n\u001a\u0016\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007j\n\u0012\u0004\u0012\u00020\b\u0018\u0001`\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lys2/a;", "", "", "enable", "Z", "b", "()Z", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "allowHostList", "Ljava/util/ArrayList;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/ArrayList;", "<init>", "()V", "live-impl-saas_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("allow_host_list")
    private final ArrayList<String> allowHostList;

    @SerializedName("enable")
    private final boolean enable;

    public a() {
        this.enable = true;
    }

    public final ArrayList<String> a() {
        return this.allowHostList;
    }

    public final boolean b() {
        return this.enable;
    }
}
