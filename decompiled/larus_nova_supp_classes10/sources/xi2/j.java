package xi2;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.bdlocation.trace.TraceCons;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0003\f9\u0018B\u0007¢\u0006\u0004\b:\u0010;R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R*\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R*\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\"\u0010\u001d\u001a\u0004\b#\u0010\u001f\"\u0004\b$\u0010!R\"\u0010%\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006\"\u0004\b'\u0010\bR$\u0010)\u001a\u0004\u0018\u00010(8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u00020/8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b0\u00101\u001a\u0004\b2\u00103\"\u0004\b4\u00105R\u001a\u00106\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b6\u0010\u0004\u001a\u0004\b7\u0010\u0006R\u001a\u00108\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b8\u0010\u0004\u001a\u0004\b9\u0010\u0006¨\u0006<"}, d2 = {"Lxi2/j;", "", "", LocationMonitorConst.TYPE, "I", "getType", "()I", "setType", "(I)V", "Lxi2/j$a;", TraceCons.METRIC_BACKGROUND, "Lxi2/j$a;", "a", "()Lxi2/j$a;", "setBackground", "(Lxi2/j$a;)V", "Lcom/bytedance/android/ec/model/live/t;", "showTrackInfo", "Lcom/bytedance/android/ec/model/live/t;", "i", "()Lcom/bytedance/android/ec/model/live/t;", "setShowTrackInfo", "(Lcom/bytedance/android/ec/model/live/t;)V", "clickTrackInfo", "c", "setClickTrackInfo", "", "Lcom/bytedance/android/ec/model/live/b;", "leftContent", "Ljava/util/List;", "e", "()Ljava/util/List;", "setLeftContent", "(Ljava/util/List;)V", "rightContent", "h", "setRightContent", "orientation", "g", "setOrientation", "Lxi2/j$c;", "normalJump", "Lxi2/j$c;", "f", "()Lxi2/j$c;", "setNormalJump", "(Lxi2/j$c;)V", "", "displayBottomInCategoryTab", "Z", "d", "()Z", "setDisplayBottomInCategoryTab", "(Z)V", "topMargin", "j", "bottomMargin", "b", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName(TraceCons.METRIC_BACKGROUND)
    private a background;

    @SerializedName("bottom_margin")
    private final int bottomMargin;

    @SerializedName("click_track_info")
    private com.bytedance.android.ec.model.live.t clickTrackInfo;

    @SerializedName("display_in_category_tab")
    private boolean displayBottomInCategoryTab;

    @SerializedName("left_content_v2")
    private List<com.bytedance.android.ec.model.live.b> leftContent;

    @SerializedName("normal_jump")
    private c normalJump;

    @SerializedName("orientation")
    private int orientation;

    @SerializedName("right_content_v2")
    private List<com.bytedance.android.ec.model.live.b> rightContent;

    @SerializedName("show_track_info")
    private com.bytedance.android.ec.model.live.t showTrackInfo;

    @SerializedName("top_margin")
    private final int topMargin;

    @SerializedName(LocationMonitorConst.TYPE)
    private int type;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lxi2/j$a;", "", "", "bgUrl", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setBgUrl", "(Ljava/lang/String;)V", "", "width", "I", "getWidth", "()I", "setWidth", "(I)V", "height", "getHeight", "setHeight", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("bg_url")
        private String bgUrl;

        @SerializedName("height")
        private int height;

        @SerializedName("width")
        private int width;

        public a() {
        }

        public final float b() {
            int r0 = this.width;
            if (r0 <= 0) goto L8;
            int r1 = this.height;
            if (r1 > 0) goto L7;
            return 1.0f;
        L7:
            return r1 / r0;
        L8:
            return 1.0f;
        }

        public final String a() {
            return this.bgUrl;
        }
    }

    public static final class b {
        public static final /* synthetic */ int a = 0;

        static {
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016¨\u0006\u001c"}, d2 = {"Lxi2/j$c;", "", "", "jumpTargetType", "I", "a", "()I", "setJumpTargetType", "(I)V", "", "showSmallWindow", "Z", "d", "()Z", "setShowSmallWindow", "(Z)V", "", "linkUrl", "Ljava/lang/String;", "b", "()Ljava/lang/String;", "setLinkUrl", "(Ljava/lang/String;)V", "schemaParamsType", "c", "setSchemaParamsType", "<init>", "()V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class c {

        @SerializedName("jump_target_type")
        private int jumpTargetType;

        @SerializedName("link_url")
        private String linkUrl;

        @SerializedName("schema_params_type")
        private String schemaParamsType;

        @SerializedName("show_small_window")
        private boolean showSmallWindow;

        public c() {
        }

        public final int a() {
            return this.jumpTargetType;
        }

        public final String b() {
            return this.linkUrl;
        }

        public final String c() {
            return this.schemaParamsType;
        }

        public final boolean d() {
            return this.showSmallWindow;
        }
    }

    public j() {
        this.topMargin = -1;
        this.bottomMargin = -1;
    }

    public final a a() {
        return this.background;
    }

    public final int b() {
        return this.bottomMargin;
    }

    public final com.bytedance.android.ec.model.live.t c() {
        return this.clickTrackInfo;
    }

    public final boolean d() {
        return this.displayBottomInCategoryTab;
    }

    public final List<com.bytedance.android.ec.model.live.b> e() {
        return this.leftContent;
    }

    public final c f() {
        return this.normalJump;
    }

    public final int g() {
        return this.orientation;
    }

    public final int getType() {
        return this.type;
    }

    public final List<com.bytedance.android.ec.model.live.b> h() {
        return this.rightContent;
    }

    public final com.bytedance.android.ec.model.live.t i() {
        return this.showTrackInfo;
    }

    public final int j() {
        return this.topMargin;
    }
}
