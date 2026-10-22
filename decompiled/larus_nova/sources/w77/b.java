package w77;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes21.dex */
public class b {

    @SerializedName("allow_branch_scene_list")
    public List<String> allowBranchScene;

    @SerializedName("allow_loop_branch_scene_list")
    public List<String> allowLoopBranchScene;

    @SerializedName("allow_loop_scene_list")
    public List<String> allowLoopScene;

    @SerializedName("allow_scene_list")
    public List<String> allowScene;

    @SerializedName("background_min_interval_in_mill")
    public long backgroundMinIntervalInMill;

    @SerializedName("foreground_min_interval_in_mill")
    public long foregroundMinIntervalInMill;

    public b() {
        this.backgroundMinIntervalInMill = 5000;
        this.foregroundMinIntervalInMill = 5000;
        this.allowScene = new ArrayList();
        this.allowBranchScene = new ArrayList();
        this.allowLoopScene = new ArrayList();
        this.allowLoopBranchScene = new ArrayList();
    }
}
