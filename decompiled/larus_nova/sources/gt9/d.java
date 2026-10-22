package gt9;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0006HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/larus/settings/album/FastSendImageConfig;", "", "enableMainBot", "", "enableOtherBot", "albumSpanCount", "", "<init>", "(ZZI)V", "getEnableMainBot", "()Z", "getEnableOtherBot", "getAlbumSpanCount", "()I", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class d {

    @SerializedName("album_span_count")
    private final int albumSpanCount;

    @SerializedName("main_bot_enable")
    private final boolean enableMainBot;

    @SerializedName("other_bots_enable")
    private final boolean enableOtherBot;

    public d() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof d) == true) goto L8;
        return false;
    L8:
        d r101 = (d) r100;
        if (this.enableMainBot == r101.enableMainBot) goto L12;
        return false;
    L12:
        if (this.enableOtherBot == r101.enableOtherBot) goto L15;
        return false;
    L15:
        if (this.albumSpanCount == r101.albumSpanCount) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        int r100 = 1231;
        if (this.enableMainBot == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.enableOtherBot == true) goto L11;
        r100 = 1237;
    L11:
        return ((r102 + r100) * 31) + this.albumSpanCount;
    L5:
        r101 = 1237;
        goto L6
    }

    public final String toString() {
        return "FastSendImageConfig(enableMainBot=" + this.enableMainBot + ", enableOtherBot=" + this.enableOtherBot + ", albumSpanCount=" + this.albumSpanCount + ')';
    }

    public final int a() {
        return this.albumSpanCount;
    }

    public final boolean b() {
        return this.enableMainBot;
    }

    public final boolean c() {
        return this.enableOtherBot;
    }

    public d(int r100) {
        this.enableMainBot = true;
        this.enableOtherBot = true;
        this.albumSpanCount = 4;
    }
}
