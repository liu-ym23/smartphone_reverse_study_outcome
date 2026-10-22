package ll7;

import com.android.ttcjpaysdk.base.CJPayConstant;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes22.dex */
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f509704a;

    @SerializedName("android_allow_list")
    private ArrayList<String> allowList;

    @SerializedName("bg_color")
    private String bgColor;

    @SerializedName("android_block_list")
    private ArrayList<String> blockList;

    @SerializedName("button_text")
    private String button;

    @SerializedName("button_bg_color")
    private ArrayList<String> buttonBgColor;

    @SerializedName("button_bg_url")
    private String buttonBgUrl;

    @SerializedName("callback_url")
    private String callbackUrl;

    @SerializedName("cycle_id")
    private int cid;

    @SerializedName("close_color")
    private String closeColor;

    @SerializedName("extra")
    private String extra;

    @SerializedName("forbid_landscape")
    private boolean forbidLandscape;

    @SerializedName("forbidden_cold_request")
    private boolean forbiddenColdRequest;

    @SerializedName("hide_close_btn")
    private boolean hideCloseBtn;

    @SerializedName("is_cold_start")
    private boolean isColdStart;

    @SerializedName("force_popup")
    private int isForce;

    @SerializedName("is_tinypopup")
    private boolean isTinyPopup;

    @SerializedName(CJPayConstant.CJ_PAY_RETAIN_INFO_V2_SCHEMA_KEY)
    private String lynxSchema;

    @SerializedName("not_show_once")
    private boolean notShowOnce;

    @SerializedName("pic_url")
    private String picUrl;

    @SerializedName("popup_id")
    private long popupId;

    @SerializedName("popup_key")
    private String popupKey;

    @SerializedName("popup_type")
    private int popupType;

    @SerializedName("pos_url")
    private ArrayList<String> posUrl;

    @SerializedName("position")
    private int position;

    @SerializedName("priority")
    private int priority;

    @SerializedName("resource_id")
    private String resourceId;

    @SerializedName("reward")
    private a reward;

    @SerializedName("scene")
    private String scene;

    @SerializedName("schema")
    private String schema;

    @SerializedName("activity_name")
    private String stageName;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    private String subTitle;

    @SerializedName("tiny_enqueue")
    private boolean tinyEnqueue;

    @SerializedName("title")
    private String title;

    @SerializedName("ts_expire_ms")
    private long tsExpireMs;

    @SerializedName("ts_show_ms")
    private long tsShowMs;

    public static class a {

        @SerializedName("amount_text")
        private String amount;

        @SerializedName("unit_text")
        private String unit;

        public a() {
        }
    }

    public final void k() {
        this.popupType = 3;
    }

    public f() {
        this.f509704a = "";
    }

    public final int a() {
        return this.cid;
    }

    public final String b() {
        return this.extra;
    }

    public final int c() {
        return this.isForce;
    }

    public final long d() {
        return this.popupId;
    }

    public final String e() {
        return this.popupKey;
    }

    public final String f() {
        return this.stageName;
    }

    public final String g() {
        return this.title;
    }

    public final void h(int r100) {
        this.isForce = r100;
    }

    public final void i(boolean r100) {
        this.isTinyPopup = r100;
    }

    public final void j(String r100) {
        this.lynxSchema = r100;
    }

    public final void l(int r100) {
        this.priority = r100;
    }

    public final void m(boolean r100) {
        this.tinyEnqueue = r100;
    }

    public final void n(long r100) {
        this.tsExpireMs = r100;
    }

    public final void o(long r100) {
        this.tsShowMs = r100;
    }
}
