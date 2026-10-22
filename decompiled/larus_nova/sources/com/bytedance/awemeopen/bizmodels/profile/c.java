package com.bytedance.awemeopen.bizmodels.profile;

import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b&\u0010'R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR$\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR$\u0010\u0016\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR$\u0010\u001a\u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR$\u0010 \u001a\u0004\u0018\u00010\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\u001b\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR$\u0010#\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\u000b\u001a\u0004\b$\u0010\r\"\u0004\b%\u0010\u000f¨\u0006("}, d2 = {"Lcom/bytedance/awemeopen/bizmodels/profile/c;", "", "", "type", "I", "getType", "()I", "setType", "(I)V", "", "cardId", "Ljava/lang/String;", "getCardId", "()Ljava/lang/String;", "setCardId", "(Ljava/lang/String;)V", "gotoUrl", "b", "setGotoUrl", "title", "f", com.alipay.sdk.m.x.d.f25925o, "subtitle", "e", "setSubtitle", "Lt14/a;", "iconDark", "Lt14/a;", "c", "()Lt14/a;", "setIconDark", "(Lt14/a;)V", "iconLight", "d", "setIconLight", "cardData", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setCardData", "<init>", "()V", "ao_biz_models_release"}, k = 1, mv = {1, 7, 1})
public final class c {

    @SerializedName("card_data")
    private String cardData;

    @SerializedName("card_id")
    private String cardId;

    @SerializedName("goto_url")
    private String gotoUrl;

    @SerializedName("icon_dark")
    private t14.a iconDark;

    @SerializedName("icon_light")
    private t14.a iconLight;

    @SerializedName(BdpAppEventConstant.PARAMS_SUB_TITLE)
    private String subtitle;

    @SerializedName("title")
    private String title;

    @SerializedName("type")
    private int type;

    public c() {
    }

    public final String a() {
        return this.cardData;
    }

    public final String b() {
        return this.gotoUrl;
    }

    public final t14.a c() {
        return this.iconDark;
    }

    public final t14.a d() {
        return this.iconLight;
    }

    public final String e() {
        return this.subtitle;
    }

    public final String f() {
        return this.title;
    }

    public final int getType() {
        return this.type;
    }
}
