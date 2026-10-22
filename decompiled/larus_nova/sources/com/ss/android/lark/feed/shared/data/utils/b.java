package com.ss.android.lark.feed.shared.data.utils;

import com.bytedance.lark.pb.feed.v1.AtInfo;
import com.bytedance.lark.pb.feed.v1.DraftPreview;
import com.bytedance.lark.pb.feed.v1.UrgentInfo;
import com.ss.android.lark.biz.im.api.FeedPreviewInfo;
import com.ss.android.lark.biz.im.api.MuteUrgentInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes35.dex */
public final class b {
    public static FeedPreviewInfo.a a(DraftPreview r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        FeedPreviewInfo.a r101 = new FeedPreviewInfo.a();
        r101.f409865a = r100.content;
        r101.f409866b = r100.cloud_draft_content;
        r101.f409867c = r100.attachment_snapshot;
        return r101;
    }

    public static List<FeedPreviewInfo.AtInfo> b(List<AtInfo> r100) {
        ArrayList r101 = new ArrayList();
        if (r100 != null) goto L5;
        return r101;
    L5:
        Iterator<AtInfo> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        r101.add(c(r102.next()));
        goto L7
    L9:
        return r101;
    }

    public static FeedPreviewInfo.AtInfo c(AtInfo r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        FeedPreviewInfo.AtInfo r101 = new FeedPreviewInfo.AtInfo();
        r101.f409854b = FeedPreviewInfo.AtInfo.AtType.getSource(r100.type.getValue());
        r101.f409853a = r100.user_id;
        r101.f409857e = r100.avatar_key;
        r101.f409855c = r100.localized_user_name;
        r101.f409856d = r100.channel_id;
        Long r102 = r100.at_display_time;
        if (r102 == null) goto L8;
        long r103 = TimeUnit.SECONDS.toMillis(r102.longValue());
    L9:
        r101.f409859g = r103;
        r101.f409858f = r100.at_rank_time.longValue();
        r101.f409860h = r100.at_content;
        return r101;
    L8:
        r103 = 0;
        goto L9
    }

    public static MuteUrgentInfo d(UrgentInfo r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        Long r101 = r100.rank_time;
        Long r102 = r100.display_time;
        if (r102 == null) goto L8;
        long r103 = TimeUnit.SECONDS.toMillis(r102.longValue());
    L10:
        return new MuteUrgentInfo(r101, Long.valueOf(r103), r100.urgent_content);
    L8:
        r103 = 0;
        goto L10
    }
}
