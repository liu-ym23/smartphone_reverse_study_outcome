package com.bytedance.awemeopen.apps.framework.feed.layout;

import android.app.Activity;
import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.awemeopen.apps.framework.comment.write.viewmodel.CommentInputContentViewModel;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.util.ToastUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q extends com.bytedance.awemeopen.apps.framework.comment.write.a {
    public final /* synthetic */ AosRecommendFeedLayout a;

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.a, com.bytedance.awemeopen.apps.framework.comment.write.e
    public final void a() {
        AoLogger.b("AosRecommendFeedLayout", new Object[]{" onKeyboardViewDismiss"});
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.a();
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.a, com.bytedance.awemeopen.apps.framework.comment.write.e
    public final void b() {
        AoLogger.b("AosRecommendFeedLayout", new Object[]{"onKeyboardViewShow"});
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.b();
    }

    public q(AosRecommendFeedLayout r1) {
        this.a = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.e
    public final void c(o14.b r6) {
        Intrinsics.checkNotNullParameter(r6, "result");
        Context r0 = this.a.getContext();
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.Activity");
        ToastUtils.b((Activity) r0, 2131894304);
        CommentInputContentViewModel.a r1 = CommentInputContentViewModel.Companion;
        AosRecommendFeedLayout r2 = this.a;
        r1.getClass();
        CommentInputContentViewModel r3 = CommentInputContentViewModel.a.a(r2);
        List r4 = null;
        if (r3 == null) goto L5;
        MutableLiveData<Integer> r5 = r3.getPublishSuccessLiveData();
    L6:
        boolean r7 = true;
        if (r5 == null) goto L17;
        if (r3 == null) goto L15;
        MutableLiveData<Integer> r8 = r3.getPublishSuccessLiveData();
        if (r8 == null) goto L15;
        Integer r9 = (Integer) r8.getValue();
        if (r9 == null) goto L15;
        Integer r10 = Integer.valueOf(r9.intValue() + 1);
    L16:
        r5.setValue(r10);
    L15:
        r10 = null;
    L17:
        if (r3 == null) goto L19;
        MutableLiveData<List<o14.a>> r11 = r3.getPublishContentLiveData();
    L20:
        if (r11 == null) goto L22;
        r4 = (List) r11.getValue();
    L22:
        List r12 = r4;
        if (r12 != null) goto L25;
    L28:
        if (r7 == false) goto L32;
        if (r11 == null) goto L32;
        r11.setValue(new ArrayList());
    L32:
        o14.c r13 = r6.e();
        if (r13 == null) goto L41;
        o14.a r14 = r13.a();
        if (r14 == null) goto L42;
        if (r11 == null) goto L43;
        List r15 = (List) r11.getValue();
        if (r15 == null) goto L44;
        r15.add(r14);
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
        if (r12.isEmpty() == true) goto L28;
        r7 = false;
        goto L28
    L19:
        r11 = null;
        goto L20
    L5:
        r5 = null;
        goto L6
    }
}
