package com.bytedance.interaction.game.base.settings.model;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/bytedance/interaction/game/base/settings/model/d;", "", "", "openJsPredefine", "Ljava/lang/Boolean;", "b", "()Ljava/lang/Boolean;", "setOpenJsPredefine", "(Ljava/lang/Boolean;)V", "decodeUrl", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "setDecodeUrl", "<init>", "()V", "interaction-base_release"}, k = 1, mv = {1, 4, 0})
public final class d {

    @SerializedName("decode_url")
    private Boolean decodeUrl;

    @SerializedName("open_js_predefine")
    private Boolean openJsPredefine;

    public d() {
    }

    public final Boolean a() {
        return this.decodeUrl;
    }

    public final Boolean b() {
        return this.openJsPredefine;
    }
}
