package zk7;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes22.dex */
public class b {

    @SerializedName("cooling_path_list")
    public List<a> coldPathInfoList;

    @SerializedName("enable_cooling")
    public boolean enableCooling;

    public b() {
        this.coldPathInfoList = new ArrayList();
        this.enableCooling = false;
    }
}
