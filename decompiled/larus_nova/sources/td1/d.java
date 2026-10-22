package td1;

import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoDecode;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.google.gson.annotations.SerializedName;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes7.dex */
public class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @IgnoreProtoFieldCheck
    @IgnoreProtoDecode
    public boolean f545503a;

    @SerializedName("privileges")
    public List<Integer> adminPrivileges;

    @SerializedName("in_room")
    public boolean isInRoom;

    @SerializedName("is_anchor_assign")
    public boolean mIsAnchorAssign;

    @SerializedName("user_info")
    public User mUser;

    @SerializedName("prompt_total_score")
    public String promptTotalScore;

    @SerializedName("total_score")
    public int totalScore;

    @SerializedName("visit_status")
    public String visitStatus;

    public final boolean a() {
        List<Integer> r100 = this.adminPrivileges;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.contains(2) == false) goto L7;
        return true;
    }

    public d() {
        this.f545503a = true;
    }

    public static void b(List<Integer> r100, boolean r101) {
        if (r101 == true) goto L5;
    L7:
        if (r101 == false) goto L9;
        return;
    L9:
        if (r100.contains(2) == false) goto L14;
        r100.removeAll(Collections.singletonList(2));
        return;
    L14:
        return;
    L5:
        if (r100.contains(2) == true) goto L7;
        r100.add(2);
    }
}
