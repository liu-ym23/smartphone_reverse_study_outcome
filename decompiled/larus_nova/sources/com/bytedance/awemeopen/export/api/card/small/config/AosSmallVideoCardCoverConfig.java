package com.bytedance.awemeopen.export.api.card.small.config;

import com.bytedance.awemeopen.export.api.card.base.config.AosBaseVideoCardCoverConfig;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/bytedance/awemeopen/export/api/card/small/config/AosSmallVideoCardCoverConfig;", "Lcom/bytedance/awemeopen/export/api/card/base/config/AosBaseVideoCardCoverConfig;", "()V", "bottomShadowStartColor", "", "getBottomShadowStartColor", "()I", "setBottomShadowStartColor", "(I)V", "ao_apps_export_api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AosSmallVideoCardCoverConfig extends AosBaseVideoCardCoverConfig {
    private int bottomShadowStartColor;

    public AosSmallVideoCardCoverConfig() {
        Intrinsics.checkNotNullParameter("#80000000", "<this>");
        this.bottomShadowStartColor = ColorProtector.parseColor("#80000000");
    }

    public final int getBottomShadowStartColor() {
        return this.bottomShadowStartColor;
    }

    public final void setBottomShadowStartColor(int r100) {
        this.bottomShadowStartColor = r100;
    }
}
