package goc;

import com.byted.cast.linkcommon.cybergarage.soap.SOAP;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.crash.dumper.Scraps;
import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.chat.core.dependency.BrowserDependency;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import com.ss.ttvideoengine.model.VideoThumbInfo;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\b\u0000\u0018\u00002\u00020\u0001:\f\u0010\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001bB)\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse;", "", "code", "", "message", "", "data", "Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Data;", "<init>", "(ILjava/lang/String;Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Data;)V", "getCode", "()I", "getMessage", "()Ljava/lang/String;", "getData", "()Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Data;", "Data", "ExtraInfo", "Content", SOAP.BODY, "Button", "Image", "Text", "Field", TTVideoEngineInterface.PLAY_API_KEY_ACTION, "Card", "Price", "Benefit", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class b {

    @SerializedName("code")
    private final int code;

    @SerializedName("data")
    private final g data;

    @SerializedName("message")
    private final String message;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Action;", "", "url", "", "<init>", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("url")
        private final String url;

        public a() {
            this("");
        }

        public final String a() {
            return this.url;
        }

        public a(String r100) {
            this.url = r100;
        }
    }

    /* JADX INFO: renamed from: goc.b$b, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Benefit;", "", "icon", "", "description", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getIcon", "()Ljava/lang/String;", "getDescription", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class C6046b {

        @SerializedName("description")
        private final String description;

        @SerializedName("icon")
        private final String icon;

        public C6046b() {
            this.icon = "";
            this.description = "";
        }

        public final String a() {
            return this.description;
        }

        public final String b() {
            return this.icon;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005\u0012\u0012\b\u0002\u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u0005¢\u0006\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u0007\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u0010"}, d2 = {"Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Body;", "", "image", "Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Image;", "texts", "", "Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Text;", BrowserDependency.UrlClickType.CARD, "Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Card;", "<init>", "(Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Image;Ljava/util/List;Ljava/util/List;)V", "getImage", "()Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Image;", "getTexts", "()Ljava/util/List;", "getCard", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c {

        @SerializedName(BrowserDependency.UrlClickType.CARD)
        private final List<e> card;

        @SerializedName("img")
        private final j image;

        @SerializedName("text")
        private final List<l> texts;

        public c() {
            this(null, 7);
        }

        public final List<e> a() {
            return this.card;
        }

        public final j b() {
            return this.image;
        }

        public final List<l> c() {
            return this.texts;
        }

        public c(List r100, int r101) {
            if ((r101 & 2) == 0) goto L5;
            r100 = CollectionsKt.emptyList();
        L5:
            this.image = null;
            this.texts = r100;
            this.card = null;
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014BK\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Button;", "", "tag", "", "type", "style", "content", "action", "Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Action;", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Action;Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "getType", "getStyle", "getContent", "getAction", "()Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Action;", "getIcon", "Companion", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class d {

        @SerializedName("action")
        private final a action;

        @SerializedName("content")
        private final String content;

        @SerializedName("icon")
        private final String icon;

        @SerializedName("style")
        private final String style;

        @SerializedName("tag")
        private final String tag;

        @SerializedName("type")
        private final String type;

        public static final class a {
        }

        static {
        }

        public final a a() {
            return this.action;
        }

        public final String b() {
            return this.content;
        }

        public final String c() {
            return this.icon;
        }

        public final String d() {
            return this.style;
        }

        public final String e() {
            return this.tag;
        }

        public final String getType() {
            return this.type;
        }

        public d(String r100, a r101) {
            this.tag = "i_know";
            this.type = "button";
            this.style = "default";
            this.content = r100;
            this.action = r101;
            this.icon = null;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\u0012\b\u0002\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\"\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010$\u001a\u00020%H\u0016R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0017R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0016\u0010\t\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR \u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015¨\u0006&"}, d2 = {"Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Card;", "", "tag", "", "title", "isInUse", "", "introduction", "selectable", "selected", "licensePlanKey", "price", "Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Price;", "benefits", "", "Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Benefit;", "url", "icon", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;ZZLjava/lang/String;Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Price;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getTag", "()Ljava/lang/String;", "getTitle", "()Z", "getIntroduction", "getSelectable", "getSelected", "getLicensePlanKey", "getPrice", "()Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Price;", "getBenefits", "()Ljava/util/List;", "getUrl", "getIcon", "equals", "other", "hashCode", "", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class e {

        @SerializedName("benefits")
        private final List<C6046b> benefits;

        @SerializedName("icon")
        private final String icon;

        @SerializedName("introduction")
        private final String introduction;

        @SerializedName("is_in_use")
        private final boolean isInUse;

        @SerializedName("license_plan_key")
        private final String licensePlanKey;

        @SerializedName("price")
        private final k price;

        @SerializedName("selectable")
        private final boolean selectable;

        @SerializedName("selected")
        private final boolean selected;

        @SerializedName("tag")
        private final String tag;

        @SerializedName("title")
        private final String title;

        @SerializedName("url")
        private final String url;

        public final int hashCode() {
            String r100 = this.tag;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            String r104 = this.title;
            if (r104 == null) goto L9;
            int r105 = r104.hashCode();
        L10:
            int r106 = (r103 + r105) * 31;
            int r107 = 1231;
            if (this.isInUse == false) goto L13;
            int r108 = 1231;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.introduction;
            if (r110 == null) goto L17;
            int r111 = r110.hashCode();
        L18:
            int r112 = (r109 + r111) * 31;
            if (this.selectable == false) goto L21;
            int r113 = 1231;
        L22:
            int r114 = (r112 + r113) * 31;
            if (this.selected == true) goto L26;
            r107 = 1237;
        L26:
            int r115 = (r114 + r107) * 31;
            String r116 = this.licensePlanKey;
            if (r116 == null) goto L29;
            int r117 = r116.hashCode();
        L30:
            int r118 = (r115 + r117) * 31;
            k r119 = this.price;
            if (r119 == null) goto L33;
            int r120 = r119.hashCode();
        L34:
            int r121 = (r118 + r120) * 31;
            List<C6046b> r122 = this.benefits;
            if (r122 == null) goto L37;
            int r123 = r122.hashCode();
        L38:
            int r124 = (r121 + r123) * 31;
            String r125 = this.url;
            if (r125 == null) goto L41;
            int r126 = r125.hashCode();
        L42:
            int r127 = (r124 + r126) * 31;
            String r128 = this.icon;
            if (r128 == null) goto L46;
            r101 = r128.hashCode();
        L46:
            return r127 + r101;
        L41:
            r126 = 0;
            goto L42
        L37:
            r123 = 0;
            goto L38
        L33:
            r120 = 0;
            goto L34
        L29:
            r117 = 0;
            goto L30
        L21:
            r113 = 1237;
            goto L22
        L17:
            r111 = 0;
            goto L18
        L13:
            r108 = 1237;
            goto L14
        L9:
            r105 = 0;
            goto L10
        L5:
            r102 = 0;
            goto L6
        }

        public e() {
            List<C6046b> r100 = CollectionsKt.emptyList();
            this.tag = "";
            this.title = "";
            this.isInUse = false;
            this.introduction = "";
            this.selectable = false;
            this.selected = false;
            this.licensePlanKey = "";
            this.price = null;
            this.benefits = r100;
            this.url = null;
            this.icon = null;
        }

        public final List<C6046b> a() {
            return this.benefits;
        }

        public final String b() {
            return this.icon;
        }

        public final String c() {
            return this.introduction;
        }

        public final String d() {
            return this.licensePlanKey;
        }

        public final k e() {
            return this.price;
        }

        public final boolean f() {
            return this.selectable;
        }

        public final boolean g() {
            return this.selected;
        }

        public final String h() {
            return this.title;
        }

        public final boolean i() {
            return this.isInUse;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(e.class, r101) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.suite.lark.platform.component.cta.entity.StuckSpotResponse.Card");
            e r102 = (e) r100;
            if (Intrinsics.areEqual(this.tag, r102.tag) == true) goto L16;
            return false;
        L16:
            if (Intrinsics.areEqual(this.title, r102.title) == true) goto L19;
            return false;
        L19:
            if (this.isInUse == r102.isInUse) goto L22;
            return false;
        L22:
            if (Intrinsics.areEqual(this.introduction, r102.introduction) == true) goto L25;
            return false;
        L25:
            if (this.selectable == r102.selectable) goto L28;
            return false;
        L28:
            if (this.selected == r102.selected) goto L31;
            return false;
        L31:
            if (Intrinsics.areEqual(this.licensePlanKey, r102.licensePlanKey) == true) goto L34;
            return false;
        L34:
            if (Intrinsics.areEqual(this.price, r102.price) == true) goto L37;
            return false;
        L37:
            if (Intrinsics.areEqual(this.benefits, r102.benefits) == true) goto L40;
            return false;
        L40:
            if (Intrinsics.areEqual(this.url, r102.url) == true) goto L43;
            return false;
        L43:
            if (Intrinsics.areEqual(this.icon, r102.icon) == true) goto L45;
            return false;
        L45:
            return true;
        L8:
            r101 = null;
            goto L10
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t¢\u0006\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R \u0010\b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\n\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Content;", "", "type", "", "title", "Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Text;", ContainerPosition.BODY, "Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Body;", ContainerPosition.FOOTER, "", "Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Button;", "<init>", "(Ljava/lang/String;Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Text;Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Body;Ljava/util/List;)V", "getType", "()Ljava/lang/String;", "getTitle", "()Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Text;", "getBody", "()Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Body;", "getFooter", "()Ljava/util/List;", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class f {

        @SerializedName(ContainerPosition.BODY)
        private final c body;

        @SerializedName(ContainerPosition.FOOTER)
        private final List<d> footer;

        @SerializedName("title")
        private final l title;

        @SerializedName("type")
        private final String type;

        public f() {
            this(null, null, null, 15);
        }

        public final c a() {
            return this.body;
        }

        public final List<d> b() {
            return this.footer;
        }

        public final l c() {
            return this.title;
        }

        public final String getType() {
            return this.type;
        }

        public f(l r100, c r101, List r102, int r103) {
            if ((r103 & 1) == 0) goto L5;
            String r104 = "";
        L7:
            if ((r103 & 2) == 0) goto L10;
            r100 = null;
        L10:
            if ((r103 & 4) == 0) goto L13;
            r101 = null;
        L13:
            if ((r103 & 8) == 0) goto L15;
            r102 = null;
        L15:
            this.type = r104;
            this.title = r100;
            this.body = r101;
            this.footer = r102;
            return;
        L5:
            r104 = null;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Data;", "", "extraInfo", "Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$ExtraInfo;", "content", "Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Content;", "<init>", "(Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$ExtraInfo;Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Content;)V", "getExtraInfo", "()Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$ExtraInfo;", "getContent", "()Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Content;", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class g {

        @SerializedName("content")
        private final f content;

        @SerializedName("extra_info")
        private final h extraInfo;

        public g() {
            this(null, 3);
        }

        public final f a() {
            return this.content;
        }

        public final h b() {
            return this.extraInfo;
        }

        public g(f r100, int r101) {
            if ((r101 & 1) == 0) goto L5;
            h r102 = new h(0);
        L7:
            if ((r101 & 2) == 0) goto L9;
            r100 = new f(null, null, null, 15);
        L9:
            this.extraInfo = r102;
            this.content = r100;
            return;
        L5:
            r102 = null;
            goto L7
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B3\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\b\u0010\tR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\rR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$ExtraInfo;", "", "functionCategory", "", "adminFlag", "", "isSingleSku", "viewType", "<init>", "(Ljava/lang/String;ZZLjava/lang/String;)V", "getFunctionCategory", "()Ljava/lang/String;", "getAdminFlag", "()Z", "getViewType", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class h {

        @SerializedName("admin_flag")
        private final boolean adminFlag;

        @SerializedName("function_category")
        private final String functionCategory;

        @SerializedName("is_single_sku")
        private final boolean isSingleSku;

        @SerializedName(BytedCertConstant.IntentKey.VIEW_TYPE)
        private final String viewType;

        public h() {
            this(0);
        }

        public final boolean a() {
            return this.adminFlag;
        }

        public final String b() {
            return this.functionCategory;
        }

        public final String c() {
            return this.viewType;
        }

        public final boolean d() {
            return this.isSingleSku;
        }

        public h(int r100) {
            this.functionCategory = "";
            this.adminFlag = false;
            this.isSingleSku = false;
            this.viewType = "";
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0000\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B7\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\n\"\u0004\b\u000e\u0010\fR \u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\n\"\u0004\b\u0010\u0010\fR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Field;", "", "key", "", "type", "content", "actionUrl", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getKey", "()Ljava/lang/String;", "setKey", "(Ljava/lang/String;)V", "getType", "setType", "getContent", "setContent", "getActionUrl", "setActionUrl", "Companion", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class i {

        @SerializedName("action_url")
        private String actionUrl;

        @SerializedName("content")
        private String content;

        @SerializedName("key")
        private String key;

        @SerializedName("type")
        private String type;

        public static final class a {
        }

        static {
        }

        public i() {
            this.key = "";
            this.type = "";
            this.content = "";
            this.actionUrl = "";
        }

        public final String a() {
            return this.actionUrl;
        }

        public final String b() {
            return this.content;
        }

        public final String c() {
            return this.key;
        }

        public final String getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\t"}, d2 = {"Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Image;", "", "imageUrl", "", "<init>", "(Ljava/lang/String;)V", "getImageUrl", "()Ljava/lang/String;", "setImageUrl", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class j {

        @SerializedName(VideoThumbInfo.KEY_IMG_URL)
        private String imageUrl;

        public j() {
            this.imageUrl = "";
        }

        public final String a() {
            return this.imageUrl;
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\f"}, d2 = {"Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Price;", "", "symbol", "", "count", Scraps.INNER_UNIT, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSymbol", "()Ljava/lang/String;", "getCount", "getUnit", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class k {

        @SerializedName("count")
        private final String count;

        @SerializedName("symbol")
        private final String symbol;

        @SerializedName(Scraps.INNER_UNIT)
        private final String unit;

        public k() {
            this.symbol = "";
            this.count = "";
            this.unit = "";
        }

        public final String a() {
            return this.count;
        }

        public final String b() {
            return this.symbol;
        }

        public final String c() {
            return this.unit;
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B'\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR(\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Text;", "", "content", "", SlcCommonAction.KEY_PARAMS, "", "Lcom/suite/lark/platform/component/cta/entity/StuckSpotResponse$Field;", "<init>", "(Ljava/lang/String;Ljava/util/List;)V", "getContent", "()Ljava/lang/String;", "setContent", "(Ljava/lang/String;)V", "getFields", "()Ljava/util/List;", "setFields", "(Ljava/util/List;)V", "cta_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class l {

        @SerializedName("content")
        private String content;

        @SerializedName(SlcCommonAction.KEY_PARAMS)
        private List<i> fields;

        public l() {
            this(null, 3);
        }

        public final String a() {
            return this.content;
        }

        public final List<i> b() {
            return this.fields;
        }

        public l(String r100, int r101) {
            if ((r101 & 1) == 0) goto L6;
            r100 = "";
        L6:
            if ((r101 & 2) == 0) goto L8;
            List<i> r102 = CollectionsKt.emptyList();
        L9:
            this.content = r100;
            this.fields = r102;
            return;
        L8:
            r102 = null;
            goto L9
        }
    }

    public b() {
        this(null, 7);
    }

    public final int a() {
        return this.code;
    }

    public final g b() {
        return this.data;
    }

    public final String c() {
        return this.message;
    }

    public b(g r100, int r101) {
        if ((r101 & 2) == 0) goto L5;
        String r102 = "";
    L7:
        if ((r101 & 4) == 0) goto L9;
        r100 = null;
    L9:
        this.code = 0;
        this.message = r102;
        this.data = r100;
        return;
    L5:
        r102 = null;
        goto L7
    }
}
