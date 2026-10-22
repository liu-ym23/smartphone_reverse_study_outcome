package r14;

import com.amap.api.col.s.ce;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.cert.manager.constants.EventConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import com.tencent.open.SocialConstants;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b3\u00104R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0013\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR$\u0010\u001c\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u0004\u001a\u0004\b\u001d\u0010\u0006\"\u0004\b\u001e\u0010\bR*\u0010 \u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R$\u0010&\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010\bR\"\u0010*\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010+\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\"\u00100\u001a\u00020)8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u0010+\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/¨\u00065"}, d2 = {"Lr14/w;", "", "", "title", "Ljava/lang/String;", RXScreenCaptureService.KEY_INDEX, "()Ljava/lang/String;", com.alipay.sdk.m.x.d.f25925o, "(Ljava/lang/String;)V", SocialConstants.PARAM_APP_DESC, BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDesc", "link", "d", "setLink", com.bytedance.android.ec.core.event.a.KEY_SCORE, "getScore", "setScore", "", "id", "J", "b", "()J", "setId", "(J)V", "type", "getType", "setType", "rawData", "f", "setRawData", "", "imgUrls", "Ljava/util/List;", "c", "()Ljava/util/List;", "setImgUrls", "(Ljava/util/List;)V", "suffix", "h", "setSuffix", "", "style", "I", ce.f26391f, "()I", ce.f26396k, "(I)V", "position", "e", ce.f26395j, "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public transient String f535656a;

    @SerializedName(SocialConstants.PARAM_APP_DESC)
    private String desc;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    @SerializedName("id")
    private long f535657id;

    @SerializedName("imgs")
    private List<String> imgUrls;

    @SerializedName("link")
    private String link;

    @SerializedName(BdpAppEventConstant.PARAMS_CLICK_POSITION)
    private int position;

    @SerializedName(EventConstant.Key.RAW_DATA)
    private String rawData;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_SCORE)
    private String score;

    @SerializedName("card_style")
    private int style;

    @SerializedName("suffix")
    private String suffix;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private String type;

    public w() {
    }

    public final String a() {
        return this.desc;
    }

    public final long b() {
        return this.f535657id;
    }

    public final List<String> c() {
        return this.imgUrls;
    }

    public final String d() {
        return this.link;
    }

    public final int e() {
        return this.position;
    }

    public final String f() {
        return this.rawData;
    }

    public final int g() {
        return this.style;
    }

    public final String getType() {
        return this.type;
    }

    public final String h() {
        return this.suffix;
    }

    public final String i() {
        return this.title;
    }

    public final void j(int r100) {
        this.position = r100;
    }

    public final void k(int r100) {
        this.style = r100;
    }
}
