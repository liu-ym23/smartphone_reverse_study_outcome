package p34;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import r14.a0;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R*\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$¨\u0006'"}, d2 = {"Lp34/a;", "Ln14/a;", "", "minCursor", "Ljava/lang/String;", "getMinCursor", "()Ljava/lang/String;", "setMinCursor", "(Ljava/lang/String;)V", "maxCursor", RXScreenCaptureService.KEY_INDEX, ce.f26396k, EffectConfiguration.KEY_CURSOR, "e", "setCursor", "", "hasMore", "Z", "f", "()Z", "setHasMore", "(Z)V", "", "Lr14/c;", "list", "Ljava/util/List;", ce.f26391f, "()Ljava/util/List;", ce.f26395j, "(Ljava/util/List;)V", "Lr14/a0;", "logPb", "Lr14/a0;", "h", "()Lr14/a0;", "setLogPb", "(Lr14/a0;)V", "<init>", "()V", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final class a extends n14.a {

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    private String cursor;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("aweme_list")
    private List<r14.c> list;

    @SerializedName("log_pb")
    private a0 logPb;

    @SerializedName("max_cursor")
    private String maxCursor;

    @SerializedName("min_cursor")
    private String minCursor;

    public final void k() {
        this.maxCursor = "0";
    }

    public a() {
    }

    public final String e() {
        return this.cursor;
    }

    public final boolean f() {
        return this.hasMore;
    }

    public final List<r14.c> g() {
        return this.list;
    }

    public final a0 h() {
        return this.logPb;
    }

    public final String i() {
        return this.maxCursor;
    }

    public final void j(List<r14.c> r100) {
        this.list = r100;
    }
}
