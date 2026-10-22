package com.bytedance.awemeopen.apps.framework.card.video;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.awemeopen.apps.framework.comment.write.viewmodel.CommentInputContentViewModel;
import com.bytedance.awemeopen.infra.base.log.AoLogger;
import com.bytedance.awemeopen.infra.util.ToastUtils;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i extends com.bytedance.awemeopen.apps.framework.comment.write.a {
    public final /* synthetic */ FeedVideoItemView a;

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.a, com.bytedance.awemeopen.apps.framework.comment.write.e
    public final void a() {
        AoLogger.b("FeedViewItemView", new Object[]{"FeedVideoItemView onKeyboardViewDismiss"});
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.a();
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.a, com.bytedance.awemeopen.apps.framework.comment.write.e
    public final void b() {
        AoLogger.b("FeedViewItemView", new Object[]{"FeedVideoItemView onKeyboardViewShow"});
        com.bytedance.awemeopen.apps.framework.feed.pages.recommend.helper.d.b();
    }

    public i(FeedVideoItemView r1) {
        this.a = r1;
    }

    @Override // com.bytedance.awemeopen.apps.framework.comment.write.e
    public final void c(o14.b r6) {
        Intrinsics.checkNotNullParameter(r6, "result");
        ToastUtils.b(this.a.a, 2131894304);
        CommentInputContentViewModel.a r0 = CommentInputContentViewModel.Companion;
        ViewModelStoreOwner r1 = this.a.a;
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type androidx.lifecycle.ViewModelStoreOwner");
        r0.getClass();
        CommentInputContentViewModel r2 = CommentInputContentViewModel.a.a(r1);
        List r3 = null;
        if (r2 == null) goto L5;
        MutableLiveData<Integer> r4 = r2.getPublishSuccessLiveData();
    L6:
        boolean r5 = true;
        if (r4 == null) goto L17;
        if (r2 == null) goto L15;
        MutableLiveData<Integer> r7 = r2.getPublishSuccessLiveData();
        if (r7 == null) goto L15;
        Integer r8 = (Integer) r7.getValue();
        if (r8 == null) goto L15;
        Integer r9 = Integer.valueOf(r8.intValue() + 1);
    L16:
        r4.setValue(r9);
    L15:
        r9 = null;
    L17:
        if (r2 == null) goto L19;
        MutableLiveData<List<o14.a>> r10 = r2.getPublishContentLiveData();
    L20:
        if (r10 == null) goto L22;
        r3 = (List) r10.getValue();
    L22:
        List r11 = r3;
        if (r11 != null) goto L25;
    L28:
        if (r5 == false) goto L32;
        if (r10 == null) goto L32;
        r10.setValue(new ArrayList());
    L32:
        o14.c r12 = r6.e();
        if (r12 == null) goto L41;
        o14.a r13 = r12.a();
        if (r13 == null) goto L42;
        if (r10 == null) goto L43;
        List r14 = (List) r10.getValue();
        if (r14 == null) goto L44;
        r14.add(r13);
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
        if (r11.isEmpty() == true) goto L28;
        r5 = false;
        goto L28
    L19:
        r10 = null;
        goto L20
    L5:
        r4 = null;
        goto L6
    }
}
