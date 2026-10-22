package com.bytedance.ee.bear.share.export;

import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.bytedance.ee.bear.share.newshare.ShareDocFragment;
import com.bytedance.ee.bear.share.newshare.ShareFolderFragment;
import com.bytedance.ee.bear.share.newshare.ShareFragmentExtend;
import com.bytedance.ee.bear.share.newshare.c0;
import com.bytedance.ee.bear.share.newshare.extension.BaseShareProvider;
import com.bytedance.ee.bear.share.view.ShareNewFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface a {
    void X9();

    com.bytedance.ee.bear.share.e Y9();

    ShareFolderFragment Z9(ShareParams r1);

    ShareDocFragment aa(ShareParams r1, Bundle r2, com.bytedance.ee.bear.document.share.a.a r3);

    void ba();

    void ca();

    com.bytedance.ee.bear.share.notification.a da();

    void ea(String r1, String r2);

    mm5.a fa(h r1);

    void ga(DialogFragment r1);

    ShareNewFragment ha(ShareParams r1, Bundle r2, BaseShareProvider r3);

    void ia(c0 r1);

    void ja();

    ShareFragmentExtend ka(ShareParams r1, Bundle r2, com.bytedance.ee.bear.bitable.share.sharepanel.a r3, com.bytedance.ee.bear.bitable.share.sharepanel.a r4);
}
