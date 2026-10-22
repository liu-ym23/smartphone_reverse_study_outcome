package com.bytedance.sdk.open.aweme.share;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* JADX INFO: loaded from: classes22.dex */
public interface IShareApplier {
    void addIntentFlags(Context r100, Intent r101);

    void fillBundle(Context r100, Share.Request r101, Bundle r102);

    String getClientKey();

    String getComponentClassName();

    String getPackageName();
}
