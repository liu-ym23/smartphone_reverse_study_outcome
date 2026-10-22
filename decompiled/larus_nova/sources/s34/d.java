package s34;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;
import r14.a0;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Ls34/d;", "Ln14/a;", "", "status_code", "I", "h", "()I", "setStatus_code", "(I)V", "", EffectConfiguration.KEY_CURSOR, "J", "e", "()J", "setCursor", "(J)V", "", "hasMore", "Z", "f", "()Z", "setHasMore", "(Z)V", "", "Lr14/c;", "list", "Ljava/util/List;", ce.f26391f, "()Ljava/util/List;", RXScreenCaptureService.KEY_INDEX, "(Ljava/util/List;)V", "Lr14/a0;", "logPb", "Lr14/a0;", "getLogPb", "()Lr14/a0;", "setLogPb", "(Lr14/a0;)V", "<init>", "()V", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final class d extends n14.a {

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    private long cursor;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("aweme_list")
    private List<r14.c> list;

    @SerializedName("log_pb")
    private a0 logPb;

    @SerializedName("status_code")
    private int status_code;

    public final String toString() {
        return "CollectResult{, status_code=" + this.status_code + ", cursor=" + this.cursor + ", has_more=" + this.hasMore + ", aweme_list=" + this.list + ", errNo=" + a() + ", errTips='" + b() + "'}";
    }

    public d() {
    }

    public final long e() {
        return this.cursor;
    }

    public final boolean f() {
        return this.hasMore;
    }

    public final List<r14.c> g() {
        return this.list;
    }

    public final int h() {
        return this.status_code;
    }

    public final void i(List<r14.c> r100) {
        this.list = r100;
    }
}
