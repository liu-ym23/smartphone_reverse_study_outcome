package dj3;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.amap.api.col.s.ce;
import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.livesdk.gift.model.n;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b*\u0010+R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0018\u0010\u0010\u001a\u0004\b\u0019\u0010\u0012R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u0004\u001a\u0004\b\u001b\u0010\u0006R\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001c\u0010\t\u001a\u0004\b\u001d\u0010\u000bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001f\u0010\u0012R\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$R\u001c\u0010&\u001a\u0004\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)¨\u0006,"}, d2 = {"Ldj3/e;", "", "", "height", "Ljava/lang/Double;", "c", "()Ljava/lang/Double;", "", "text", "Ljava/lang/String;", ce.f26395j, "()Ljava/lang/String;", "textColor", ce.f26396k, "", "fontSize", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "Lcom/bytedance/android/ec/model/ECUrlModel;", "image", "Lcom/bytedance/android/ec/model/ECUrlModel;", "d", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "position", "f", GXTemplateKey.FLEXBOX_MARGIN, "e", n.KEY_SUB_TEXT, ce.f26391f, "subTextMargin", "h", "Ldj3/l;", "subTextStyle", "Ldj3/l;", RXScreenCaptureService.KEY_INDEX, "()Ldj3/l;", "Ldj3/h;", "containerMargins", "Ldj3/h;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ldj3/h;", "<init>", "()V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("container_margins")
    private final h containerMargins;

    @SerializedName("font_size")
    private final Integer fontSize;

    @SerializedName("height")
    private final Double height;

    @SerializedName("image")
    private final ECUrlModel image;

    @SerializedName(GXTemplateKey.FLEXBOX_MARGIN)
    private final Double margin;

    @SerializedName("position")
    private final Integer position;

    @SerializedName("sub_text")
    private final String subText;

    @SerializedName("sub_text_margin")
    private final Integer subTextMargin;

    @SerializedName("sub_text_style")
    private final l subTextStyle;

    @SerializedName("text")
    private final String text;

    @SerializedName("text_color")
    private final String textColor;

    public e() {
    }

    public final h a() {
        return this.containerMargins;
    }

    public final Integer b() {
        return this.fontSize;
    }

    public final Double c() {
        return this.height;
    }

    public final ECUrlModel d() {
        return this.image;
    }

    public final Double e() {
        return this.margin;
    }

    public final Integer f() {
        return this.position;
    }

    public final String g() {
        return this.subText;
    }

    public final Integer h() {
        return this.subTextMargin;
    }

    public final l i() {
        return this.subTextStyle;
    }

    public final String j() {
        return this.text;
    }

    public final String k() {
        return this.textColor;
    }
}
