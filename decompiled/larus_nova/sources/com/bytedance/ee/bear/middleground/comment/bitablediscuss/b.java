package com.bytedance.ee.bear.middleground.comment.bitablediscuss;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements ye5.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Function0<ye5.a> f230713a;

    @Override // ye5.a
    public final LiveData<Boolean> getCommentAble() {
        ye5.a r100 = this.f230713a.invoke();
        if (r100 == null) goto L7;
        LiveData<Boolean> r101 = r100.getCommentAble();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new MutableLiveData(Boolean.FALSE);
    }

    @Override // ye5.a
    public final LiveData<List<String>> getCurrentDiscussIds() {
        ye5.a r100 = this.f230713a.invoke();
        if (r100 == null) goto L7;
        LiveData<List<String>> r101 = r100.getCurrentDiscussIds();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return new MutableLiveData();
    }

    @Override // ye5.a
    public final String getCurrentRecordId() {
        ye5.a r100 = this.f230713a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCurrentRecordId();
    }

    @Override // ye5.a
    public final String getCurrentTableId() {
        ye5.a r100 = this.f230713a.invoke();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getCurrentTableId();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Function0<? extends ye5.a> r100) {
        Intrinsics.checkNotNullParameter(r100, "getDiscussFunction");
        this.f230713a = r100;
    }

    @Override // ye5.a
    public final void deleteMainDiscuss(String r100) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        ye5.a r101 = this.f230713a.invoke();
        if (r101 == null) goto L6;
        r101.deleteMainDiscuss(r100);
        return;
    }

    @Override // ye5.a
    public final boolean needCallReplyAfterScroll(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "commentId");
        ye5.a r102 = this.f230713a.invoke();
        if (r102 != null) goto L7;
        return false;
    L7:
        return r102.needCallReplyAfterScroll(r100, r101);
    }

    @Override // ye5.a
    public final void createNewDiscuss(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tableId");
        Intrinsics.checkNotNullParameter(r102, "recordId");
        ye5.a r103 = this.f230713a.invoke();
        if (r103 == null) goto L6;
        r103.createNewDiscuss(r100, "", r102);
        return;
    }

    @Override // ye5.a
    public final void onDiscussShareClick(String r100, String r101, String r110, String r111, String r112) {
        Intrinsics.checkNotNullParameter(r100, "tableId");
        Intrinsics.checkNotNullParameter(r110, "recordId");
        Intrinsics.checkNotNullParameter(r111, "commentId");
        ye5.a r102 = this.f230713a.invoke();
        if (r102 == null) goto L6;
        r102.onDiscussShareClick(r100, r101, r110, r111, r112);
        return;
    }
}
