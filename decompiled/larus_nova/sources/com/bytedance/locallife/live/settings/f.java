package com.bytedance.locallife.live.settings;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/bytedance/locallife/live/settings/f;", "", "Lcom/bytedance/locallife/live/settings/a;", "confirmDynamicUrl", "Lcom/bytedance/locallife/live/settings/a;", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "()Lcom/bytedance/locallife/live/settings/a;", "locallife-live-impl_release"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("confirm_dynmamic_url")
    private final a confirmDynamicUrl;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof f) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.confirmDynamicUrl, ((f) r100).confirmDynamicUrl) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        a r100 = this.confirmDynamicUrl;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public final String toString() {
        return "PoiOrderSettingEntity(confirmDynamicUrl=" + this.confirmDynamicUrl + ')';
    }

    public f() {
        this.confirmDynamicUrl = null;
    }

    public final a a() {
        return this.confirmDynamicUrl;
    }
}
