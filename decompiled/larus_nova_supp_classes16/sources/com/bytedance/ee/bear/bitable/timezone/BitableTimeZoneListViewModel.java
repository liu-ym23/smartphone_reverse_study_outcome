package com.bytedance.ee.bear.bitable.timezone;

import androidx.lifecycle.ViewModel;
import com.bytedance.ee.bear.document.i5;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZoneListViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "lynxWebDelegate", "Lcom/bytedance/ee/bear/document/LynxWebDelegateImpl;", "getLynxWebDelegate", "()Lcom/bytedance/ee/bear/document/LynxWebDelegateImpl;", "setLynxWebDelegate", "(Lcom/bytedance/ee/bear/document/LynxWebDelegateImpl;)V", "pluginDelegate", "Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZonePlugin$Delegate;", "getPluginDelegate", "()Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZonePlugin$Delegate;", "setPluginDelegate", "(Lcom/bytedance/ee/bear/bitable/timezone/BitableTimeZonePlugin$Delegate;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableTimeZoneListViewModel extends ViewModel {
    private i5 lynxWebDelegate;
    private BitableTimeZonePlugin.b pluginDelegate;

    public BitableTimeZoneListViewModel() {
    }

    public final i5 getLynxWebDelegate() {
        return this.lynxWebDelegate;
    }

    public final BitableTimeZonePlugin.b getPluginDelegate() {
        return this.pluginDelegate;
    }

    public final void setLynxWebDelegate(i5 r1) {
        this.lynxWebDelegate = r1;
    }

    public final void setPluginDelegate(BitableTimeZonePlugin.b r1) {
        this.pluginDelegate = r1;
    }
}
