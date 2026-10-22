package pp2;

import com.bytedance.android.livesdk.rank.jsbridge.HourRankStateChangedResultModel;
import com.bytedance.ies.web.jsbridge2.PermissionGroup;
import pp2.d;

/* JADX INFO: loaded from: classes11.dex */
public abstract class a<P extends d, R extends HourRankStateChangedResultModel> extends com.bytedance.ies.web.jsbridge2.g<P, R> {
    public a() {
    }

    @Override // com.bytedance.ies.web.jsbridge2.d
    public final PermissionGroup getPermissionGroup() {
        return PermissionGroup.PROTECTED;
    }
}
