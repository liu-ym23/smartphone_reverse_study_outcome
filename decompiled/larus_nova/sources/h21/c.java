package h21;

import com.bytedance.android.live.revlink.impl.multianchor.constants.PlayMode;

/* JADX INFO: loaded from: classes47.dex */
public final class c {
    public static final PlayMode a(Integer r100) {
        if (r100 != null) goto L5;
    L7:
        if (r100 == null) goto L13;
        if (r100.intValue() != 2) goto L13;
        return PlayMode.TEAM_PK;
    L13:
        return PlayMode.PERSONAL_PK;
    L5:
        if (r100.intValue() != 1) goto L7;
        return PlayMode.PERSONAL_PK;
    }
}
