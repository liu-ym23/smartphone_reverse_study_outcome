package p67;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class a {

    @SerializedName("rs_list")
    public List<String> filterPkgList;

    @SerializedName("rs_value")
    public int filterValue;

    @SerializedName("min_install_time")
    public long minInstallTime;

    @SerializedName("white_pkg_list")
    public List<String> whitePkgList;

    public a() {
        this.minInstallTime = -1;
    }
}
