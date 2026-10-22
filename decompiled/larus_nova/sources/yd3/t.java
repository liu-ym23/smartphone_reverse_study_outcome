package yd3;

import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R:\u0010\u0015\u001a\"\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u0013j\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e\u0018\u0001`\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lyd3/t;", "", "Lcom/bytedance/android/ec/model/ECUrlModel;", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "", "text", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "color", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "", "textSize", "Ljava/lang/Integer;", "d", "()Ljava/lang/Integer;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", GXTemplateKey.FLEXBOX_MARGIN, "Ljava/util/HashMap;", "getMargin", "()Ljava/util/HashMap;", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class t {

    @SerializedName("color")
    private final String color;

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName(GXTemplateKey.FLEXBOX_MARGIN)
    private final HashMap<String, Integer> margin;

    @SerializedName("text")
    private final String text;

    @SerializedName("text_size")
    private final Integer textSize;

    public t() {
    }

    public final Integer e() {
        HashMap<String, Integer> r100 = this.margin;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get("left");
    }

    public final Integer f() {
        HashMap<String, Integer> r100 = this.margin;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get("right");
    }

    public final String a() {
        return this.color;
    }

    public final ECUrlModel b() {
        return this.icon;
    }

    public final String c() {
        return this.text;
    }

    public final Integer d() {
        return this.textSize;
    }
}
