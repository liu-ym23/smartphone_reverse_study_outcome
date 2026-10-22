package o14;

import com.amap.api.col.s.ce;
import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.effectmanager.EffectConfiguration;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u00100R*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\u0019\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR$\u0010 \u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u001a\u001a\u0004\b'\u0010\u001c\"\u0004\b(\u0010\u001eR\"\u0010)\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010\u001a\u001a\u0004\b*\u0010\u001c\"\u0004\b+\u0010\u001eR\"\u0010,\u001a\u00020\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b,\u0010\u001a\u001a\u0004\b-\u0010\u001c\"\u0004\b.\u0010\u001e¨\u00061"}, d2 = {"Lo14/f;", "Ln14/a;", "", "Lo14/a;", "items", "Ljava/util/List;", ce.f26391f, "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "", EffectConfiguration.KEY_CURSOR, "J", "e", "()J", "setCursor", "(J)V", "", "hasMore", "Z", "f", "()Z", RXScreenCaptureService.KEY_INDEX, "(Z)V", "", "total", "I", "h", "()I", "setTotal", "(I)V", "", "hotsoonText", "Ljava/lang/String;", "getHotsoonText", "()Ljava/lang/String;", "setHotsoonText", "(Ljava/lang/String;)V", "hotsoonHasMore", "getHotsoonHasMore", "setHotsoonHasMore", "hotsoonFilteredCount", "getHotsoonFilteredCount", "setHotsoonFilteredCount", "replyStyle", "getReplyStyle", "setReplyStyle", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class f extends n14.a {

    @SerializedName(EffectConfiguration.KEY_CURSOR)
    private long cursor;

    @SerializedName("has_more")
    private boolean hasMore;

    @SerializedName("hotsoon_filtered_count")
    private int hotsoonFilteredCount;

    @SerializedName("hotsoon_has_more")
    private int hotsoonHasMore;

    @SerializedName("hotsoon_text")
    private String hotsoonText;

    @SerializedName("comments")
    private List<a> items;

    @SerializedName("reply_style")
    private int replyStyle;

    @SerializedName("total")
    private int total;

    public final void i() {
        this.hasMore = false;
    }

    public f() {
    }

    public final long e() {
        return this.cursor;
    }

    public final boolean f() {
        return this.hasMore;
    }

    public final List<a> g() {
        return this.items;
    }

    public final int h() {
        return this.total;
    }
}
