package com.bytedance.ee.bear.middleground.comment.uitls;

import com.alibaba.fastjson.JSON;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.export.bean.DataEntity;
import com.bytedance.ee.bear.middleground.comment.widget.CommentEditText;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static DataEntity.Entity.BodyEntity b(String r2) {
        Intrinsics.checkNotNullParameter(r2, WikiFolderPushPlugin.DATA);
        return ((DataEntity) JSON.parseObject(r2, DataEntity.class)).getData().getBody();
    L5:
        tt5.a.d("CommentTo", "data format error: " + r2);
        return null;
    }

    public static void c(CommentBean r5) {
        List<CommentBean.CommentDetail> r0 = r5.getComment_list();
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L10;
        CommentBean.CommentDetail r2 = (CommentBean.CommentDetail) r1.next();
        r2.setComment_id(r5.getComment_id());
        HashMap<String, Integer> r3 = s.a;
        Intrinsics.checkNotNull(r2);
        s.c(r2, r2.getReaction(), r2.getReaction_type(), r2.getReferKey());
        goto L6
    L10:
        return;
    }

    public static void d(DataEntity.Entity.BodyEntity.ResultEntity.Comments r2) {
        List<CommentBean> r0 = r2.getComments();
        if (r0 == null) goto L8;
        Iterator<T> r1 = r0.iterator();
    L6:
        if (r1.hasNext() == false) goto L8;
        CommentBean r3 = (CommentBean) r1.next();
        Intrinsics.checkNotNull(r3);
        c(r3);
    L8:
        List<CommentBean> r4 = r2.getFinishComments();
        if (r4 == null) goto L14;
        Iterator<T> r5 = r4.iterator();
    L12:
        if (r5.hasNext() == false) goto L17;
        CommentBean r6 = (CommentBean) r5.next();
        Intrinsics.checkNotNull(r6);
        c(r6);
        goto L12
    L17:
        return;
    }

    @JvmStatic
    public static final List<CommentBean> e(List<CommentBean> r6) {
        if (r6 == null) goto L15;
        if (r6.isEmpty() == true) goto L15;
        Iterator<T> r0 = r6.iterator();
    L8:
        if (r0.hasNext() == false) goto L13;
        Iterator<T> r1 = ((CommentBean) r0.next()).getComment_list().iterator();
    L11:
        if (r1.hasNext() == false) goto L8;
        CommentBean.CommentDetail r2 = (CommentBean.CommentDetail) r1.next();
        HashMap<String, Integer> r3 = s.a;
        Intrinsics.checkNotNull(r2);
        s.c(r2, r2.getReaction(), r2.getReaction_type(), r2.getReferKey());
        goto L11
    L13:
        return r6;
    L15:
        return new ArrayList();
    }

    @JvmStatic
    public static final String f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "content");
        return StringsKt.trim(StringsKt.trim(r3).toString(), new char[]{'\n'});
    }

    public static Disposable a(CommentEditText r1, Function1 r2) {
        Intrinsics.checkNotNullParameter(r2, "text");
        if (r1 == null) goto L11;
        Single<String> r3 = r1.getRichText();
        if (r3 == null) goto L11;
        Single r4 = r3.subscribeOn(fo5.d.a());
        if (r4 == null) goto L11;
        Single r5 = r4.observeOn(fo5.d.d());
        if (r5 == null) goto L11;
        return r5.subscribe(new l(r2), m.a);
    L11:
        return null;
    }
}
