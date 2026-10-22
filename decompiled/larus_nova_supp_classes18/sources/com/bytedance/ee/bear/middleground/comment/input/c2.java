package com.bytedance.ee.bear.middleground.comment.input;

import android.app.Application;
import android.text.TextUtils;
import com.bytedance.ee.bear.facade.common.widget.Toast;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentAreaMark;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.ss.android.lark.utils.UIHelper;
import io.reactivex.functions.Predicate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class c2<T> implements Predicate {
    public final /* synthetic */ List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> a;
    public final /* synthetic */ b2 b;

    /* JADX WARN: Multi-variable type inference failed */
    public c2(List<? extends CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r1, b2 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final boolean test(Object r5) {
        String r6 = (String) r5;
        Intrinsics.checkNotNullParameter(r6, "it");
        if (TextUtils.isEmpty(r6) == false) goto L8;
        if (this.a.isEmpty() == false) goto L8;
        tt5.a.d("Comment#InputViewModel", "comment content is empty!");
        return false;
    L8:
        if (r6.length() <= 10000) goto L10;
        Application r7 = eu5.b.a;
        Toast.showFailureText(r7, com.bytedance.ee.util.ui.n.x(r7, 2131887633), 0);
        return false;
    L10:
        b2 r8 = this.b;
        List<CommentBean.CommentDetail.ExtraEntity.CommentImageEntity> r0 = this.a;
        r8.getClass();
        Intrinsics.checkNotNullParameter(r0, "images");
        Iterator<T> r9 = r0.iterator();
        int r1 = 0;
    L12:
        if (r9.hasNext() == false) goto L18;
        ArrayList<CommentAreaMark> r3 = ((CommentBean.CommentDetail.ExtraEntity.CommentImageEntity) r9.next()).getAreaMark();
        if (r3 == null) goto L16;
        int r4 = r3.size();
    L17:
        r1 = r1 + r4;
        goto L12
    L16:
        r4 = 0;
        goto L17
    L18:
        tt5.a.h("Comment#InputViewModel", "getAreaMarkCount: " + r1);
        if (r1 <= 100) goto L21;
        Toast.showFailureText(eu5.b.a, UIHelper.mustacheFormat(2131888902, "num", "100"), 0);
        return false;
    L21:
        return true;
    }
}
