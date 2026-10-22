package com.bytedance.android.shopping.deepfeed.slice.action;

import android.view.View;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.deepfeed.slice.DeepFeedSlcCardContainer;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public interface v {
    void a(v r1);

    void b(Map r1);

    void c(DeepFeedSlcCardContainer r1);

    void dispose();

    boolean m(IAction r1, View r2);
}
