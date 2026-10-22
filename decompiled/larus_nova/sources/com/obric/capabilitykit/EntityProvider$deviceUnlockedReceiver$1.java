package com.obric.capabilitykit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.obric.capabilitykit.logger.Logger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"com/obric/capabilitykit/EntityProvider$deviceUnlockedReceiver$1", "Landroid/content/BroadcastReceiver;", "capabilitykit_release"}, k = 1, mv = {1, 7, 1})
public final class EntityProvider$deviceUnlockedReceiver$1 extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f396120a = 0;

    public EntityProvider$deviceUnlockedReceiver$1() {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context r100, Intent r101) {
        Logger.INSTANCE.d(EntityProvider.TAG, "user unlocked");
        IndexTaskManager.INSTANCE.postTask("checkIfFirstRunOrDataClean", new wia.m());
    }
}
