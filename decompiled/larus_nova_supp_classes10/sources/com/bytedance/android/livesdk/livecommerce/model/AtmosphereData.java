package com.bytedance.android.livesdk.livecommerce.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@ProtoMessage("live.AtmosphereData")
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0016\u0010\t\u001a\u00020\b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\t\u0010\nR\u001e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0004R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0012¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/model/AtmosphereData;", "", "", "img", "Ljava/lang/String;", "num", "bgColor", "borderColor", "", "leftMargin", "J", "", "bgColors", "Ljava/util/List;", "borderColors", "topImg", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2UrlPicture;", "bgImg", "Lcom/bytedance/android/livesdk/livecommerce/model/ECV2UrlPicture;", "leftIcon", "<init>", "()V", "Companion", "a", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class AtmosphereData {
    public static final a Companion = null;

    @SerializedName("bg_color")
    public String bgColor;

    @SerializedName("bg_colors")
    public List<String> bgColors;

    @SerializedName("bg_img")
    public ECV2UrlPicture bgImg;

    @SerializedName("border_color")
    public String borderColor;

    @SerializedName("border_colors")
    public List<String> borderColors;

    @SerializedName("img")
    public String img;

    @SerializedName("left_icon")
    public ECV2UrlPicture leftIcon;

    @SerializedName("left_margin")
    public long leftMargin;

    @SerializedName("num")
    public String num;

    @SerializedName("top_img")
    public String topImg;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public AtmosphereData() {
    }
}
