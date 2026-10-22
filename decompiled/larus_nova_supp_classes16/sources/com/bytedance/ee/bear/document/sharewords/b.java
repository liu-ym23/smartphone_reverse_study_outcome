package com.bytedance.ee.bear.document.sharewords;

import com.ss.android.lark.forwardv2.dto.ForwardTarget;
import com.ss.android.lark.widget.richtext.RichText;
import io.reactivex.Flowable;
import java.util.List;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public interface b {
    Flowable<Boolean> a(String r1, List<? extends ForwardTarget> r2, RichText r3);
}
