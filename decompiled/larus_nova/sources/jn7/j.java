package jn7;

import android.app.Activity;
import android.content.Context;
import com.bytedance.ug.sdk.share.api.entity.ShareContent;

/* JADX INFO: loaded from: classes3.dex */
public interface j {
    boolean hasPermission(Context r100, String r101);

    void requestPermissions(Activity r100, String[] r101, ShareContent r102, in7.g r103);
}
