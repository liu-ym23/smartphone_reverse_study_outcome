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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class BitableDiscussFunction extends com.bytedance.ee.bear.middleground.comment.control.a implements ye5.a {
    public final /* synthetic */ ye5.a o;

    @Override // ye5.a
    public final void createNewDiscuss(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "tableId");
        Intrinsics.checkNotNullParameter(r4, "recordId");
        this.o.createNewDiscuss(r2, "", r4);
    }

    @Override // ye5.a
    public final void deleteMainDiscuss(String r2) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        this.o.deleteMainDiscuss(r2);
    }

    @Override // ye5.a
    public final LiveData<Boolean> getCommentAble() {
        return this.o.getCommentAble();
    }

    @Override // ye5.a
    public final LiveData<List<String>> getCurrentDiscussIds() {
        return this.o.getCurrentDiscussIds();
    }

    @Override // ye5.a
    public final String getCurrentRecordId() {
        return this.o.getCurrentRecordId();
    }

    @Override // ye5.a
    public final String getCurrentTableId() {
        return this.o.getCurrentTableId();
    }

    @Override // ye5.a
    public final boolean needCallReplyAfterScroll(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        return this.o.needCallReplyAfterScroll(r2, r3);
    }

    @Override // ye5.a
    public final void onDiscussShareClick(String r8, String r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "tableId");
        Intrinsics.checkNotNullParameter(r10, "recordId");
        Intrinsics.checkNotNullParameter(r11, "commentId");
        this.o.onDiscussShareClick(r8, r9, r10, r11, r12);
    }

    @Override // com.bytedance.ee.bear.middleground.comment.control.CommentFunction, com.bytedance.ee.bear.middleground.comment.control.y
    public final void w(CommentBean.CommentDetail r7, String r8, View r9) {
        Intrinsics.checkNotNullParameter(r7, "commentDetail");
        Intrinsics.checkNotNullParameter(r8, "replyId");
        String r10 = r7.getComment_id();
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        Dialog r0 = this.j;
        if (r0 == null) goto L24;
        Handler r1 = DialogLancet.resolveDialogHandler(r0);
        if (r1 != null) goto L10;
    L12:
        DialogLancet.beforeDialogDismiss(r0);
        r0.dismiss();     // Catch: Throwable -> L15 Exception -> L17
    L21:
        DialogLancet.afterDialogDismiss(r0);
        goto L24
    L15:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r0);
        throw th;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L15
        Throwable r2 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L15
        if (r2 == null) goto L21;
        com.bytedance.crash.d.d(r2, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L15
        goto L21
    L10:
        if (Looper.myLooper() == r1.getLooper()) goto L12;
        r1.post(DialogLancet.createDismissRunnable(r0));
    L24:
        List r3 = (List) this.c.I().getValue();
        CommentBean r4 = null;
        Object r5 = null;
        if (r3 == null) goto L34;
        Iterator r6 = r3.iterator();
    L28:
        if (r6.hasNext() == false) goto L32;
        Object r11 = r6.next();
        if (TextUtils.equals(((CommentBean) r11).getComment_id(), r10) == false) goto L28;
        r5 = r11;
    L32:
        r4 = (CommentBean) r5;
    L34:
        if (r4 == null) goto L40;
        List<CommentBean.CommentDetail> r12 = r4.getComment_list();
        if (r12 == null) goto L40;
        boolean r13 = true;
        if ((!r12.isEmpty()) != true) goto L40;
    L41:
        if (r13 == false) goto L43;
        TextUtils.equals(((CommentBean.CommentDetail) ListProtector.get(r4.getComment_list(), 0)).getReply_id(), r8);
    L43:
        int r14 = com.bytedance.ee.bear.middleground.comment.cell.e.a;
        this.j = com.bytedance.ee.bear.middleground.comment.cell.e.a(this.a, this.c, r7, r8, null, 48);
        return;
    L40:
        r13 = false;
        goto L41
    }

    public BitableDiscussFunction(p r2, z r3, t r4, b r5) {
        Intrinsics.checkNotNullParameter(r2, "config");
        Intrinsics.checkNotNullParameter(r3, "commentListeners");
        Intrinsics.checkNotNullParameter(r4, "dataControl");
        Intrinsics.checkNotNullParameter(r5, "bitableDiscussFunctionProxy");
        super(r2, r3, r4);
        this.o = r5;
    }
}
