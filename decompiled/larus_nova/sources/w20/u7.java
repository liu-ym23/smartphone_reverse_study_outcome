package w20;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u0003\f\u001a\u0013B\u0007¢\u0006\u0004\b/\u00100R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR$\u0010\u001e\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR$\u0010!\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR$\u0010$\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0019\u001a\u0004\b%\u0010\u001b\"\u0004\b&\u0010\u001dR*\u0010)\u001a\n\u0012\u0004\u0012\u00020(\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.¨\u00061"}, d2 = {"Lw20/u7;", "", "", "imageUrl", "Ljava/lang/String;", "d", "()Ljava/lang/String;", "setImageUrl", "(Ljava/lang/String;)V", "Lw20/u7$a;", "giftCellFrame", "Lw20/u7$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lw20/u7$a;", "setGiftCellFrame", "(Lw20/u7$a;)V", "Lw20/u7$b;", "giftToolbarFrame", "Lw20/u7$b;", "c", "()Lw20/u7$b;", "setGiftToolbarFrame", "(Lw20/u7$b;)V", "", "giftId", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setGiftId", "(Ljava/lang/Integer;)V", "mainTitle", "e", "setMainTitle", "subTitle", "h", "setSubTitle", "price", com.amap.api.col.s.ce.f26391f, "setPrice", "", "Lw20/u7$c;", "pluginList", "Ljava/util/List;", "f", "()Ljava/util/List;", "setPluginList", "(Ljava/util/List;)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u7 {

    @SerializedName("giftCellFrame")
    private a giftCellFrame;

    @SerializedName("giftId")
    private Integer giftId;

    @SerializedName("giftToolbarFrame")
    private b giftToolbarFrame;

    @SerializedName("imageUrl")
    private String imageUrl;

    @SerializedName("mainTitle")
    private String mainTitle;

    @SerializedName("pluginList")
    private List<c> pluginList;

    @SerializedName("price")
    private Integer price;

    @SerializedName("subTitle")
    private String subTitle;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lw20/u7$a;", "", "", "x", "Ljava/lang/Float;", "c", "()Ljava/lang/Float;", com.amap.api.col.s.ce.f26391f, "(Ljava/lang/Float;)V", "y", "d", "h", "width", "b", "f", "height", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "e", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("height")
        private Float height;

        @SerializedName("width")
        private Float width;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @SerializedName("x")
        private Float f557974x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        @SerializedName("y")
        private Float f557975y;

        public a() {
        }

        public final Float a() {
            return this.height;
        }

        public final Float b() {
            return this.width;
        }

        public final Float c() {
            return this.f557974x;
        }

        public final Float d() {
            return this.f557975y;
        }

        public final void e(Float r100) {
            this.height = r100;
        }

        public final void f(Float r100) {
            this.width = r100;
        }

        public final void g(Float r100) {
            this.f557974x = r100;
        }

        public final void h(Float r100) {
            this.f557975y = r100;
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR$\u0010\f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR$\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0014"}, d2 = {"Lw20/u7$b;", "", "", "x", "Ljava/lang/Float;", "c", "()Ljava/lang/Float;", com.amap.api.col.s.ce.f26391f, "(Ljava/lang/Float;)V", "y", "d", "h", "width", "b", "f", "height", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "e", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class b {

        @SerializedName("height")
        private Float height;

        @SerializedName("width")
        private Float width;

        /* JADX INFO: renamed from: x, reason: collision with root package name */
        @SerializedName("x")
        private Float f557976x;

        /* JADX INFO: renamed from: y, reason: collision with root package name */
        @SerializedName("y")
        private Float f557977y;

        public b() {
        }

        public final Float a() {
            return this.height;
        }

        public final Float b() {
            return this.width;
        }

        public final Float c() {
            return this.f557976x;
        }

        public final Float d() {
            return this.f557977y;
        }

        public final void e(Float r100) {
            this.height = r100;
        }

        public final void f(Float r100) {
            this.width = r100;
        }

        public final void g(Float r100) {
            this.f557976x = r100;
        }

        public final void h(Float r100) {
            this.f557977y = r100;
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0012\u0010\u0013R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bRB\u0010\f\u001a\"\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lw20/u7$c;", "", "", "pluginId", "Ljava/lang/Integer;", "b", "()Ljava/lang/Integer;", "setPluginId", "(Ljava/lang/Integer;)V", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "itemPotentialValueHint", "Ljava/util/HashMap;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/HashMap;", "setItemPotentialValueHint", "(Ljava/util/HashMap;)V", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("itemPotentialValueHint")
        private HashMap<String, String> itemPotentialValueHint;

        @SerializedName("pluginId")
        private Integer pluginId;

        public c() {
        }

        public final HashMap<String, String> a() {
            return this.itemPotentialValueHint;
        }

        public final Integer b() {
            return this.pluginId;
        }
    }

    public u7() {
    }

    public final a a() {
        return this.giftCellFrame;
    }

    public final Integer b() {
        return this.giftId;
    }

    public final b c() {
        return this.giftToolbarFrame;
    }

    public final String d() {
        return this.imageUrl;
    }

    public final String e() {
        return this.mainTitle;
    }

    public final List<c> f() {
        return this.pluginList;
    }

    public final Integer g() {
        return this.price;
    }

    public final String h() {
        return this.subTitle;
    }
}
