package com.bytedance.awemeopen.apps.framework.feed.collect;

import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.comment.write.viewmodel.CommentInputContentViewModel;
import com.bytedance.awemeopen.infra.util.ToastUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class e extends com.bytedance.awemeopen.apps.framework.comment.write.a {
    public final /* synthetic */ AosUserCollectFeedFragment a;

    public e(AosUserCollectFeedFragment r1) {
        this.a = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.e
    public final void c(o14.b r6) {
        Intrinsics.checkNotNullParameter(r6, "result");
        AosUserCollectFeedFragment r0 = this.a;
        int r1 = AosUserCollectFeedFragment.K;
        ToastUtils.b(r0.V90().getContext(), 2131894304);
        CommentInputContentViewModel.a r2 = CommentInputContentViewModel.Companion;
        AosUserCollectFeedFragment r3 = this.a;
        r2.getClass();
        CommentInputContentViewModel r4 = CommentInputContentViewModel.a.a(r3);
        List r5 = null;
        if (r4 == null) goto L5;
        MutableLiveData<Integer> r7 = r4.getPublishSuccessLiveData();
    L6:
        boolean r8 = true;
        if (r7 == null) goto L17;
        if (r4 == null) goto L15;
        MutableLiveData<Integer> r9 = r4.getPublishSuccessLiveData();
        if (r9 == null) goto L15;
        Integer r10 = (Integer) r9.getValue();
        if (r10 == null) goto L15;
        Integer r11 = Integer.valueOf(r10.intValue() + 1);
    L16:
        r7.setValue(r11);
    L15:
        r11 = null;
    L17:
        if (r4 == null) goto L19;
        MutableLiveData<List<o14.a>> r12 = r4.getPublishContentLiveData();
    L20:
        if (r12 == null) goto L22;
        r5 = (List) r12.getValue();
    L22:
        List r13 = r5;
        if (r13 != null) goto L25;
    L28:
        if (r8 == false) goto L32;
        if (r12 == null) goto L32;
        r12.setValue(new ArrayList());
    L32:
        o14.c r14 = r6.e();
        if (r14 == null) goto L41;
        o14.a r15 = r14.a();
        if (r15 == null) goto L42;
        if (r12 == null) goto L43;
        List r16 = (List) r12.getValue();
        if (r16 == null) goto L44;
        r16.add(r15);
        return;
    L44:
        return;
    L43:
        return;
    L42:
        return;
    L41:
        return;
    L25:
        if (r13.isEmpty() == true) goto L28;
        r8 = false;
        goto L28
    L19:
        r12 = null;
        goto L20
    L5:
        r7 = null;
        goto L6
    }
}
