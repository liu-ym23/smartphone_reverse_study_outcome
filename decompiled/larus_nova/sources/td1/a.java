package td1;

import com.bytedance.android.live.base.model.Extra;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoDecode;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/* JADX INFO: loaded from: classes7.dex */
public class a extends Extra {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @IgnoreProtoFieldCheck
    @IgnoreProtoDecode
    public int f545502a;

    @SerializedName("prompt_curr_count")
    public int currentPrompters;

    @SerializedName("privilege_extra_info")
    public Map<Long, b> extraInfo;

    @SerializedName("admin_max_count")
    private int maxCount;

    @SerializedName("prompt_max_count")
    public int maxPrompters;

    @SerializedName("privilege_max_count")
    private Map<Integer, Integer> privilegeQuntities;

    public a() {
    }

    public final int a() {
        return this.maxCount;
    }
}
