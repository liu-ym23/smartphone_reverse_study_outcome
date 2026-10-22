package okb;

import android.app.Activity;
import com.bytedance.lark.pb.basic.v1.Chat;

/* JADX INFO: loaded from: classes36.dex */
public interface b extends ikb.b {
    boolean a();

    boolean b(String r100);

    int getUnifiedStorageLimitErrorCode();

    boolean isCalendarAbbrHighlightEnabled(String r100, Chat r101);

    boolean isFeatureGatingEnable(String r100);

    boolean isHitStorageQuotaLimit(int r100);

    boolean isInterceptSendCallback(int r100);

    boolean showQuotaLimitDialog(Activity r100, int r101);

    void showUnifiedStorageLimitCTADialog(Activity r100);
}
