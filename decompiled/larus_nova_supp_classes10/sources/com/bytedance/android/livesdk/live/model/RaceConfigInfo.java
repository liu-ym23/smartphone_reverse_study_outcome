package com.bytedance.android.livesdk.live.model;

import com.bytedance.android.live.base.model.user.n0;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.common.utility.collection.CollectionUtils;
import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class RaceConfigInfo {

    @SerializedName("top_bg_url")
    public List<String> bgUrls;

    @SerializedName("race_anchor_ids")
    public List<Long> raceAnchorIds;

    public static class a {
        public static final RaceConfigInfo a = null;

        static {
            a = new RaceConfigInfo();
        }
    }

    public RaceConfigInfo() {
    }

    public static RaceConfigInfo getDefaultInstance() {
        return a.a;
    }

    public boolean isGameRaceRoom(Room r7) {
        if (r7 != null) goto L4;
    L14:
        return false;
    L4:
        if (CollectionUtils.isEmpty(this.raceAnchorIds) == true) goto L14;
        Iterator<Long> r0 = this.raceAnchorIds.iterator();
    L8:
        if (r0.hasNext() == false) goto L14;
        Long r1 = r0.next();
        if (r1 == null) goto L8;
        long r2 = r1.longValue();
        r7.getOwnerUserIdString();
        n0.d();
        if (r2 != 0) goto L8;
        return true;
    }
}
