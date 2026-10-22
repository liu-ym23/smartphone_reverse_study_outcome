package com.bytedance.awemeopen.apps.framework.story.repo;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import r14.a0;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b)\u0010*R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R\"\u0010\u001b\u001a\u00020\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010#\u001a\n\u0012\u0004\u0012\u00020\"\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010$\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(¨\u0006+"}, d2 = {"Lcom/bytedance/awemeopen/apps/framework/story/repo/d;", "Ln14/a;", "Lr14/a0;", "logPb", "Lr14/a0;", ce.f26391f, "()Lr14/a0;", "setLogPb", "(Lr14/a0;)V", "", "statusCode", "I", "getStatusCode", "()I", "setStatusCode", "(I)V", "", "minCursor", "J", "getMinCursor", "()J", "setMinCursor", "(J)V", "maxCursor", "h", "setMaxCursor", "", "hasMore", "Z", "f", "()Z", "setHasMore", "(Z)V", "", "Lr14/c;", "awemeList", "Ljava/util/List;", "e", "()Ljava/util/List;", "setAwemeList", "(Ljava/util/List;)V", "<init>", "()V", "ao_apps_framework_release"}, k = 1, mv = {1, 7, 1})
public final class d extends n14.a {

    @SerializedName("aweme_list")
    private List<r14.c> awemeList;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("log_pb")
    private a0 logPb;

    @SerializedName("max_cursor")
    private long maxCursor;

    @SerializedName("min_cursor")
    private long minCursor;

    @SerializedName("status_code")
    private int statusCode;

    public d() {
    }

    public final List<r14.c> e() {
        return this.awemeList;
    }

    public final boolean f() {
        return this.hasMore;
    }

    public final a0 g() {
        return this.logPb;
    }

    public final long h() {
        return this.maxCursor;
    }
}
