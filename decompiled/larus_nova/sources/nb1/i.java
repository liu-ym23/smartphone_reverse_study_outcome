package nb1;

import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b2\u00103R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R$\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R$\u0010/\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010\b¨\u00064"}, d2 = {"Lnb1/i;", "", "", "id", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setId", "(Ljava/lang/String;)V", "", "minVersion", "J", "getMinVersion", "()J", "setMinVersion", "(J)V", "Lnb1/e;", "lyrics", "Lnb1/e;", "c", "()Lnb1/e;", "setLyrics", "(Lnb1/e;)V", "Lnb1/g;", KtvSubElement.MIDI, "Lnb1/g;", "d", "()Lnb1/g;", "setMidi", "(Lnb1/g;)V", "Lnb1/j;", "singer", "Lnb1/j;", "e", "()Lnb1/j;", "setSinger", "(Lnb1/j;)V", "title", "f", com.alipay.sdk.m.x.d.f25925o, "Lnb1/c;", "background", "Lnb1/c;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lnb1/c;", "setBackground", "(Lnb1/c;)V", "coverUrl", "getCoverUrl", "setCoverUrl", "<init>", "()V", "soloktv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class i {

    @SerializedName("background")
    private c background;

    @SerializedName("cover_url")
    private String coverUrl;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName(ILiveRoomPlayFragmentConstant.EXTRA_ENTER_TEMPLATE_ID)
    private String f518495id;

    @SerializedName(KtvSubElement.LYRIC)
    private e lyrics;

    @SerializedName(KtvSubElement.MIDI)
    private g midi;

    @SerializedName("min_version")
    private long minVersion;

    @SerializedName("singer")
    private j singer;

    @SerializedName("title")
    private j title;

    public i() {
        this.f518495id = "";
    }

    public final c a() {
        return this.background;
    }

    public final String b() {
        return this.f518495id;
    }

    public final e c() {
        return this.lyrics;
    }

    public final g d() {
        return this.midi;
    }

    public final j e() {
        return this.singer;
    }

    public final j f() {
        return this.title;
    }
}
