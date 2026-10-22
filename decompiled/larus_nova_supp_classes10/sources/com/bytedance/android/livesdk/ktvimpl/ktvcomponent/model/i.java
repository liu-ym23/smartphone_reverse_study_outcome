package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u000f\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R$\u0010\u0012\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010\u001f\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/model/i;", "", "", "Lcom/bytedance/android/live/ktv/common/model/bean/d;", "songWaitingUserList", "Ljava/util/List;", "d", "()Ljava/util/List;", "setSongWaitingUserList", "(Ljava/util/List;)V", "", "hasMore", "Ljava/lang/Boolean;", "a", "()Ljava/lang/Boolean;", "setHasMore", "(Ljava/lang/Boolean;)V", "", "nextCursor", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setNextCursor", "(Ljava/lang/String;)V", "", "totalCount", "Ljava/lang/Long;", "e", "()Ljava/lang/Long;", "setTotalCount", "(Ljava/lang/Long;)V", "ownUser", "Lcom/bytedance/android/live/ktv/common/model/bean/d;", "c", "()Lcom/bytedance/android/live/ktv/common/model/bean/d;", "setOwnUser", "(Lcom/bytedance/android/live/ktv/common/model/bean/d;)V", "<init>", "()V", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class i implements vh7.h {

    @SerializedName("has_more")
    protected Boolean hasMore;

    @SerializedName("next_cursor")
    protected String nextCursor;

    @SerializedName("own_user")
    protected com.bytedance.android.live.ktv.common.model.bean.d ownUser;

    @SerializedName("users")
    protected List<com.bytedance.android.live.ktv.common.model.bean.d> songWaitingUserList;

    @SerializedName("total_count")
    protected Long totalCount;

    public i() {
        this.hasMore = Boolean.FALSE;
        this.totalCount = 0L;
    }

    public final Boolean a() {
        return this.hasMore;
    }

    public final String b() {
        return this.nextCursor;
    }

    public final com.bytedance.android.live.ktv.common.model.bean.d c() {
        return this.ownUser;
    }

    public final List<com.bytedance.android.live.ktv.common.model.bean.d> d() {
        return this.songWaitingUserList;
    }

    public final Long e() {
        return this.totalCount;
    }

    public i(am3.g r5) {
        this.songWaitingUserList = new ArrayList();
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L21;
        if (r2 != 1) goto L8;
        this.songWaitingUserList.add(new com.bytedance.android.live.ktv.common.model.bean.d(r5));
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this.hasMore = Boolean.valueOf(am3.h.a(r5));
        goto L3
    L10:
        if (r2 != 3) goto L12;
        this.nextCursor = am3.h.c(r5);
        goto L3
    L12:
        if (r2 != 4) goto L14;
        this.totalCount = Long.valueOf(r5.j());
        goto L3
    L14:
        if (r2 != 5) goto L15;
        this.ownUser = new com.bytedance.android.live.ktv.common.model.bean.d(r5);
        goto L3
    L15:
        am3.h.e(r5);
        goto L3
    L21:
        r5.d(r0);
        if (this.hasMore != null) goto L25;
        this.hasMore = Boolean.FALSE;
    L25:
        if (this.totalCount != null) goto L46;
        this.totalCount = 0L;
        return;
    }
}
