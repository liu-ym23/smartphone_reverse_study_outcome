package com.bytedance.ee.bear.middleground.comment.bitablediscuss;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class b implements ye5.a {
    public final Function0<ye5.a> a;

    @Override // ye5.a
    public final LiveData<Boolean> getCommentAble() {
        ye5.a r0 = (ye5.a) this.a.invoke();
        if (r0 == null) goto L7;
        LiveData<Boolean> r1 = r0.getCommentAble();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new MutableLiveData(Boolean.FALSE);
    }

    @Override // ye5.a
    public final LiveData<List<String>> getCurrentDiscussIds() {
        ye5.a r0 = (ye5.a) this.a.invoke();
        if (r0 == null) goto L7;
        LiveData<List<String>> r1 = r0.getCurrentDiscussIds();
        if (r1 == null) goto L7;
        return r1;
    L7:
        return new MutableLiveData();
    }

    @Override // ye5.a
    public final String getCurrentRecordId() {
        ye5.a r0 = (ye5.a) this.a.invoke();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurrentRecordId();
    }

    @Override // ye5.a
    public final String getCurrentTableId() {
        ye5.a r0 = (ye5.a) this.a.invoke();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getCurrentTableId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function0<? extends ye5.a> r2) {
        Intrinsics.checkNotNullParameter(r2, "getDiscussFunction");
        this.a = r2;
    }

    @Override // ye5.a
    public final void deleteMainDiscuss(String r2) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        ye5.a r0 = (ye5.a) this.a.invoke();
        if (r0 == null) goto L6;
        r0.deleteMainDiscuss(r2);
        return;
    }

    @Override // ye5.a
    public final boolean needCallReplyAfterScroll(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "commentId");
        ye5.a r0 = (ye5.a) this.a.invoke();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.needCallReplyAfterScroll(r2, r3);
    }

    @Override // ye5.a
    public final void createNewDiscuss(String r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "tableId");
        Intrinsics.checkNotNullParameter(r4, "recordId");
        ye5.a r5 = (ye5.a) this.a.invoke();
        if (r5 == null) goto L6;
        r5.createNewDiscuss(r2, "", r4);
        return;
    }

    @Override // ye5.a
    public final void onDiscussShareClick(String r8, String r9, String r10, String r11, String r12) {
        Intrinsics.checkNotNullParameter(r8, "tableId");
        Intrinsics.checkNotNullParameter(r10, "recordId");
        Intrinsics.checkNotNullParameter(r11, "commentId");
        ye5.a r1 = (ye5.a) this.a.invoke();
        if (r1 == null) goto L6;
        r1.onDiscussShareClick(r8, r9, r10, r11, r12);
        return;
    }
}
