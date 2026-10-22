package com.bytedance.ee.bear.bitable.timezone;

import androidx.lifecycle.ViewModel;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes16.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZoneViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "pluginDelegate", "Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZonePlugin$Delegate;", "getPluginDelegate", "()Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZonePlugin$Delegate;", "setPluginDelegate", "(Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZonePlugin$Delegate;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableTimeZoneViewModel extends ViewModel {
    private BitableTimeZonePlugin.b pluginDelegate;

    public BitableTimeZoneViewModel() {
    }

    public final BitableTimeZonePlugin.b getPluginDelegate() {
        return this.pluginDelegate;
    }

    public final void setPluginDelegate(BitableTimeZonePlugin.b r100) {
        this.pluginDelegate = r100;
    }
}
