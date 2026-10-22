package com.bytedance.awemeopen.domain.series;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\"\u0010#R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\r\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0014\u001a\u00020\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006$"}, d2 = {"Lcom/bytedance/awemeopen/domain/series/r;", "Ln14/a;", "", "logId", "Ljava/lang/String;", "getLogId", "()Ljava/lang/String;", "setLogId", "(Ljava/lang/String;)V", "extra", "getExtra", "setExtra", "", "hasMore", "Z", "getHasMore", "()Z", "setHasMore", "(Z)V", "", EffectConfiguration.KEY_CURSOR, "J", "getCursor", "()J", "setCursor", "(J)V", "", "Lcom/bytedance/awemeopen/domain/series/e;", "homeInfo", "Ljava/util/List;", "getHomeInfo", "()Ljava/util/List;", "setHomeInfo", "(Ljava/util/List;)V", "<init>", "()V", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final class r extends n14.a {

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    private long cursor;

    @SerializedName("extra")
    private String extra;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("home_page")
    private List<e> homeInfo;

    @SerializedName("log_id")
    private String logId;

    public r() {
        this.logId = "";
        this.extra = "";
    }
}
