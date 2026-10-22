package com.bytedance.android.livesdk.live.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/livesdk/live/model/AnnouncementInstructionInfo;", "", "header", "Lcom/bytedance/android/livesdk/live/model/AnnouncementInstructionTitle;", "list", "", "Lcom/bytedance/android/livesdk/live/model/AnnouncementInstructionImage;", "(Lcom/bytedance/android/livesdk/live/model/AnnouncementInstructionTitle;Ljava/util/List;)V", "getHeader", "()Lcom/bytedance/android/livesdk/live/model/AnnouncementInstructionTitle;", "getList", "()Ljava/util/List;", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AnnouncementInstructionInfo {
    private final AnnouncementInstructionTitle header;
    private final List<AnnouncementInstructionImage> list;

    public final AnnouncementInstructionTitle getHeader() {
        return this.header;
    }

    public final List<AnnouncementInstructionImage> getList() {
        return this.list;
    }

    public AnnouncementInstructionInfo(AnnouncementInstructionTitle r2, List<AnnouncementInstructionImage> r3) {
        Intrinsics.checkNotNullParameter(r2, "header");
        Intrinsics.checkNotNullParameter(r3, "list");
        this.header = r2;
        this.list = r3;
    }
}
