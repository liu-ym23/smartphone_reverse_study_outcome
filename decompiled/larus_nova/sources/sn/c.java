package sn;

import com.bytedance.android.ec.model.ECUrlModel;
import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.discover.model.CommodityText;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\"R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\u000f\u0010\rR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001d8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!¨\u0006#"}, d2 = {"Lsn/c;", "", "", "type", "Ljava/lang/String;", "getType", "()Ljava/lang/String;", "setType", "(Ljava/lang/String;)V", "", "width", "Ljava/lang/Integer;", "getWidth", "()Ljava/lang/Integer;", "height", "getHeight", "backgroundColor", "getBackgroundColor", "Lsn/a;", "cornerRadius", "Lsn/a;", "getCornerRadius", "()Lsn/a;", "", "Lsn/e;", SlcCommonAction.KEY_ACTIONS, "Ljava/util/List;", "getActions", "()Ljava/util/List;", "Lsn/c$a;", "extra", "Lsn/c$a;", "getExtra", "()Lsn/c$a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class c {

    @SerializedName(SlcCommonAction.KEY_ACTIONS)
    private final List<e> actions;

    @SerializedName("background_color")
    private final String backgroundColor;

    @SerializedName("corner_radius")
    private final sn.a cornerRadius;

    @SerializedName("extra")
    private final a extra;

    @SerializedName("height")
    private final Integer height;

    @SerializedName("config_type")
    private String type;

    @SerializedName("width")
    private final Integer width;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b#\u0010\u000f\u001a\u0004\b$\u0010\u0011R\u001c\u0010%\u001a\u0004\u0018\u00010\u001e8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"R\u001c\u0010'\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b'\u0010\u0004\u001a\u0004\b(\u0010\u0006¨\u0006)"}, d2 = {"Lsn/c$a;", "", "", "verticalPadding", "Ljava/lang/Integer;", "getVerticalPadding", "()Ljava/lang/Integer;", "setVerticalPadding", "(Ljava/lang/Integer;)V", "marginToTarget", "getMarginToTarget", "marginToEdge", "getMarginToEdge", "", "clickOutDismiss", "Ljava/lang/Boolean;", "getClickOutDismiss", "()Ljava/lang/Boolean;", "arrowHeight", "getArrowHeight", "Lcom/bytedance/android/ec/model/ECUrlModel;", "imageUrl", "Lcom/bytedance/android/ec/model/ECUrlModel;", "getImageUrl", "()Lcom/bytedance/android/ec/model/ECUrlModel;", "Lsn/a;", "imageCornerRadius", "Lsn/a;", "getImageCornerRadius", "()Lsn/a;", "", "text", "Ljava/lang/String;", "getText", "()Ljava/lang/String;", CommodityText.BOLD, "getBold", "textColor", "getTextColor", "textSizeDp", "getTextSizeDp", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
    public static final class a {

        @SerializedName("arrow_height")
        private final Integer arrowHeight;

        @SerializedName(CommodityText.BOLD)
        private final Boolean bold;

        @SerializedName("click_out_dismiss")
        private final Boolean clickOutDismiss;

        @SerializedName("image_corner_radius")
        private final sn.a imageCornerRadius;

        @SerializedName("image")
        private final ECUrlModel imageUrl;

        @SerializedName("margin_to_edge")
        private final Integer marginToEdge;

        @SerializedName("margin_to_target")
        private final Integer marginToTarget;

        @SerializedName("text")
        private final String text;

        @SerializedName("text_color")
        private final String textColor;

        @SerializedName("text_size")
        private final Integer textSizeDp;

        @SerializedName("vertical_padding")
        private Integer verticalPadding;
    }

    public c() {
        this.type = null;
        this.width = null;
        this.height = null;
        this.backgroundColor = null;
        this.cornerRadius = null;
        this.actions = null;
        this.extra = null;
    }

    public final String getType() {
        return this.type;
    }
}
