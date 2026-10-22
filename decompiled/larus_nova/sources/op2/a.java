package op2;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0011\u0010\u0012R0\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u000b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lop2/a;", "", "", "", "Lop2/a$a;", "config", "Ljava/util/Map;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/util/Map;", "setConfig", "(Ljava/util/Map;)V", "fallbackUrl", "Ljava/lang/String;", "getFallbackUrl", "()Ljava/lang/String;", "setFallbackUrl", "(Ljava/lang/String;)V", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("config")
    private Map<String, C7084a> config;

    @SerializedName("fallback_url")
    private String fallbackUrl;

    /* JADX INFO: renamed from: op2.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lop2/a$a;", "", "", "audienceListUrl", "Ljava/lang/String;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Ljava/lang/String;", "setAudienceListUrl", "(Ljava/lang/String;)V", "", "enableSkeleton", "Z", "b", "()Z", "setEnableSkeleton", "(Z)V", "enableStraigtOut", "c", "setEnableStraigtOut", "<init>", "()V", "liveprofit-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class C7084a {

        @SerializedName("audience_list_url")
        private String audienceListUrl;

        @SerializedName("enableSkeleton")
        private boolean enableSkeleton;

        @SerializedName("enableStraigtOut")
        private boolean enableStraigtOut;

        public C7084a() {
            this.audienceListUrl = "";
        }

        public final String a() {
            return this.audienceListUrl;
        }

        public final boolean b() {
            return this.enableSkeleton;
        }

        public final boolean c() {
            return this.enableStraigtOut;
        }
    }

    public a() {
        this.fallbackUrl = "sslocal://webcast_lynxview?url=https://lf-webcast-gr-sourcecdn.bytegecko.com/obj/byte-gurd-source-gr/webcast/mono/lynx/revenue_rank_list_douyin/pages/audience_list/template.js%3FinitialProps%3D%255B%2522current_room%2522%252C%2522current_user%2522%252C%2522linkmic%2522%252C%2522broadcast_game%2522%252C%2522setting%253Alive_audience_list_combine_config%253Alive_audience_list_combine_style%253Alive_anchor_perception_of_fans_badge_enable%253Alive_audience_list_new_rights_config%253Alive_enable_visibility_scope_share%253Alive_anchor_local_badge_enable%253Alive_commerce_room_gift%253Alive_enable_display_game_player_rank%253Aseparate_linkmic_subscribe_icon%253Alive_audience_unlogin_text_optimize%2522%255D%26include_offline%3D0&load_taro=0&gravity=bottom&type=popup&lynx_thread=2&window_floating=0&rate_height=450&horizontal_width=375&abandon_coordinate=1&enable_lynx_bg=1&engine_type=new&panel_scene=audience_list";
    }

    public final Map<String, C7084a> a() {
        return this.config;
    }
}
