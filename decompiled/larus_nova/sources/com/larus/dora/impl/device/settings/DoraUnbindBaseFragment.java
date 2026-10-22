package com.larus.dora.impl.device.settings;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.dora.impl.device.DoraBaseFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0005\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0016R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u000e"}, d2 = {"Lcom/larus/dora/impl/device/settings/DoraUnbindBaseFragment;", "Lcom/larus/dora/impl/device/DoraBaseFragment;", "<init>", "()V", "mBroadcastReceiver", "com/larus/dora/impl/device/settings/DoraUnbindBaseFragment$mBroadcastReceiver$1", "Lcom/larus/dora/impl/device/settings/DoraUnbindBaseFragment$mBroadcastReceiver$1;", "onViewCreated", "", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", LiveCommonConstants.REASON_ON_DEDTROY, "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DoraUnbindBaseFragment extends DoraBaseFragment {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final DoraUnbindBaseFragment$mBroadcastReceiver$1 f334272f;

    /* JADX WARN: Type inference failed for: r0v0, types: [com.larus.dora.impl.device.settings.DoraUnbindBaseFragment$mBroadcastReceiver$1] */
    public DoraUnbindBaseFragment() {
        this.f334272f = new DoraUnbindBaseFragment$mBroadcastReceiver$1(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        Context r100 = getContext();
        if (r100 == null) goto L6;
        LocalBroadcastManager.getInstance(r100).unregisterReceiver(this.f334272f);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Context r102 = getContext();
        if (r102 == null) goto L6;
        LocalBroadcastManager.getInstance(r102).registerReceiver(this.f334272f, new IntentFilter("action.DEVICE_UNBIND"));
        return;
    }
}
