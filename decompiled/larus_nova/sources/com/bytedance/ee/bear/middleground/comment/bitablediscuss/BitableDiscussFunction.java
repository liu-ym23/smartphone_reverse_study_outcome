package com.bytedance.ee.bear.middleground.comment.bitablediscuss;

import android.app.Dialog;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.lifecycle.LiveData;
import com.bytedance.ee.bear.middleground.comment.control.t;
import com.bytedance.ee.bear.middleground.comment.control.z;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import com.bytedance.ee.bear.middleground.comment.uitls.p;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class BitableDiscussFunction extends com.bytedance.ee.bear.middleground.comment.control.a implements ye5.a {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final /* synthetic */ ye5.a f230675o;

    @Override // ye5.a
    public final void createNewDiscuss(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tableId");
        Intrinsics.checkNotNullParameter(r102, "recordId");
        this.f230675o.createNewDiscuss(r100, "", r102);
    }

    @Override // ye5.a
    public final void deleteMainDiscuss(String r100) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        this.f230675o.deleteMainDiscuss(r100);
    }

    @Override // ye5.a
    public final LiveData<Boolean> getCommentAble() {
        return this.f230675o.getCommentAble();
    }

    @Override // ye5.a
    public final LiveData<List<String>> getCurrentDiscussIds() {
        return this.f230675o.getCurrentDiscussIds();
    }

    @Override // ye5.a
    public final String getCurrentRecordId() {
        return this.f230675o.getCurrentRecordId();
    }

    @Override // ye5.a
    public final String getCurrentTableId() {
        return this.f230675o.getCurrentTableId();
    }

    @Override // ye5.a
    public final boolean needCallReplyAfterScroll(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        return this.f230675o.needCallReplyAfterScroll(r100, r101);
    }

    @Override // ye5.a
    public final void onDiscussShareClick(String r100, String r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "tableId");
        Intrinsics.checkNotNullParameter(r110, "recordId");
        Intrinsics.checkNotNullParameter(r111, "commentId");
        this.f230675o.onDiscussShareClick(r100, r101, r110, r111, r112);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.CommentFunction, com.bytedance.ee.bear.middleground.comment.control.y
    public final void w(CommentBean.CommentDetail r100, String r101, View r102) {
        Intrinsics.checkNotNullParameter(r100, "commentDetail");
        Intrinsics.checkNotNullParameter(r101, "replyId");
        String r103 = r100.getComment_id();
        if (r103 != null) goto L5;
        r103 = "";
    L5:
        Dialog r104 = this.f231101j;
        if (r104 == null) goto L24;
        Handler r105 = DialogLancet.resolveDialogHandler(r104);
        if (r105 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r104);
        r104.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r104);
        goto L24
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r104);
        throw th;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r106 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r106 == null) goto L21;
        com.bytedance.crash.d.d(r106, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        goto L21
    L10:
        if (Looper.myLooper() == r105.getLooper()) goto L12;
        r105.post(DialogLancet.createDismissRunnable(r104));
    L24:
        List<CommentBean> r107 = this.f231094c.I().getValue();
        CommentBean r108 = null;
        Object r109 = null;
        if (r107 == null) goto L34;
        Iterator<T> r110 = r107.iterator();
    L28:
        if (r110.hasNext() == false) goto L32;
        Object r111 = r110.next();
        if (TextUtils.equals(((CommentBean) r111).getComment_id(), r103) == false) goto L28;
        r109 = r111;
    L32:
        r108 = (CommentBean) r109;
    L34:
        if (r108 == null) goto L40;
        List<CommentBean.CommentDetail> r112 = r108.getComment_list();
        if (r112 == null) goto L40;
        boolean r113 = true;
        if ((!r112.isEmpty()) != true) goto L40;
    L41:
        if (r113 == false) goto L43;
        TextUtils.equals(((CommentBean.CommentDetail) ListProtector.get(r108.getComment_list(), 0)).getReply_id(), r101);
    L43:
        int r114 = com.bytedance.ee.bear.middleground.comment.cell.e.f231049a;
        this.f231101j = com.bytedance.ee.bear.middleground.comment.cell.e.a(this.f231092a, this.f231094c, r100, r101, null, 48);
        return;
    L40:
        r113 = false;
        goto L41
    }

    public BitableDiscussFunction(p r100, z r101, t r102, b r103) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "commentListeners");
        Intrinsics.checkNotNullParameter(r102, "dataControl");
        Intrinsics.checkNotNullParameter(r103, "bitableDiscussFunctionProxy");
        super(r100, r101, r102);
        this.f230675o = r103;
    }
}
