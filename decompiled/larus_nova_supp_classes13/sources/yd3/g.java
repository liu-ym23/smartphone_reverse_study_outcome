package yd3;

import com.bytedance.android.ec.model.ECUrlModel;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001d\u0010\u001eR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R:\u0010\u0017\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR:\u0010\u001b\u001a\"\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u0015j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0010\u0018\u0001`\u00168\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001a¨\u0006\u001f"}, d2 = {"Lyd3/g;", "", "", "link", "Ljava/lang/String;", "c", "()Ljava/lang/String;", "text", "d", "Lcom/bytedance/android/ec/model/ECUrlModel;", "icon", "Lcom/bytedance/android/ec/model/ECUrlModel;", "b", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "color", "a", "", "textSize", "Ljava/lang/Integer;", "e", "()Ljava/lang/Integer;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "margin", "Ljava/util/HashMap;", "getMargin", "()Ljava/util/HashMap;", "textMargin", "getTextMargin", "<init>", "()V", "ec-biz-inner-flow-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class g {

    @SerializedName("color")
    private final String color;

    @SerializedName("icon")
    private final ECUrlModel icon;

    @SerializedName("link")
    private final String link;

    @SerializedName("icon_margin")
    private final HashMap<String, Integer> margin;

    @SerializedName("text")
    private final String text;

    @SerializedName("text_margin")
    private final HashMap<String, Integer> textMargin;

    @SerializedName("text_size")
    private final Integer textSize;

    public g() {
    }

    public final Integer f() {
        HashMap<String, Integer> r0 = this.margin;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get("left");
    }

    public final Integer g() {
        HashMap<String, Integer> r0 = this.margin;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get("right");
    }

    public final Integer h() {
        HashMap<String, Integer> r0 = this.textMargin;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get("left");
    }

    public final Integer i() {
        HashMap<String, Integer> r0 = this.textMargin;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.get("right");
    }

    public final String a() {
        return this.color;
    }

    public final ECUrlModel b() {
        return this.icon;
    }

    public final String c() {
        return this.link;
    }

    public final String d() {
        return this.text;
    }

    public final Integer e() {
        return this.textSize;
    }
}
