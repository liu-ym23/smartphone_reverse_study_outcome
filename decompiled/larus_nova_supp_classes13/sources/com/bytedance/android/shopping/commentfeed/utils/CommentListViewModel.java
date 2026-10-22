package com.bytedance.android.shopping.commentfeed.utils;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.ec.core.utils.s0;
import com.bytedance.android.ec.model.response.PromotionProductCommentDTO;
import com.bytedance.android.ec.model.response.r0;
import com.bytedance.android.shopping.commentfeed.model.CommentListResponse;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zb3.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0018\u0018\u0000 /2\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b-\u0010.J\u0014\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002J\u000e\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J&\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\n2\u0016\b\u0002\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0005\u0018\u00010\fR#\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R)\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00170\u00150\u00108\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0012\u001a\u0004\b\u0018\u0010\u0014R\"\u0010\u001a\u001a\u00020\u00198\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\"\u0010 \u001a\u00020\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u00168\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u0016\u0010,\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010'¨\u00061"}, d2 = {"Lcom/bytedance/android/shopping/commentfeed/utils/CommentListViewModel;", "Landroidx/lifecycle/ViewModel;", "", "Lcom/bytedance/android/ec/model/response/PromotionProductCommentDTO;", "comments", "", "setCommentModel", "Lzb3/d;", "requestParam", "loadCommentList", "Lzb3/b;", "requestParams", "Lkotlin/Function1;", "Lzb3/a;", "resultCallBack", "diggCommentAction", "Landroidx/lifecycle/MutableLiveData;", "commentList", "Landroidx/lifecycle/MutableLiveData;", "getCommentList", "()Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "", "", "isRequestSucceed", "", "commentCursor", "J", "getCommentCursor", "()J", "setCommentCursor", "(J)V", "firstEnterCommentIndex", "I", "getFirstEnterCommentIndex", "()I", "setFirstEnterCommentIndex", "(I)V", "hasMoreComment", "Z", "getHasMoreComment", "()Z", "setHasMoreComment", "(Z)V", "isLoadingComment", "<init>", "()V", "Companion", "a", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentListViewModel extends ViewModel {
    public static final a Companion = null;
    private long commentCursor;
    private final MutableLiveData<List<PromotionProductCommentDTO>> commentList;
    private int firstEnterCommentIndex;
    private boolean hasMoreComment;
    private boolean isLoadingComment;
    private final MutableLiveData<Pair<Boolean, Integer>> isRequestSucceed;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements Observer<r0> {
        public final /* synthetic */ CommentListViewModel a;
        public final /* synthetic */ zb3.b b;
        public final /* synthetic */ Function1 c;

        public final void onComplete() {
        }

        public final void onError(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
        }

        public final void onNext(Object r14) {
            r0 r15 = (r0) r14;
            Intrinsics.checkNotNullParameter(r15, "t");
            if (this.b.b != 1) goto L5;
            boolean r0 = true;
        L7:
            if (r15.a() != 0) goto L34;
            zb3.b r16 = this.b;
            if (r0 == false) goto L11;
            long r6 = r16.c + 1;
        L12:
            long r4 = r6;
            Function1 r1 = this.c;
            if (r1 == null) goto L15;
            Unit r17 = (Unit) r1.invoke(new zb3.a(String.valueOf(r16.a), r0, r4, 8));
        L15:
            List r18 = (List) this.a.getCommentList().getValue();
            if (r18 == null) goto L33;
            Iterator r19 = r18.iterator();
        L19:
            if (r19.hasNext() == false) goto L29;
            Object r2 = r19.next();
            Long r7 = ((PromotionProductCommentDTO) r2).getId();
            long r8 = this.b.a;
            if (r7 != null) goto L24;
        L26:
            boolean r9 = false;
        L27:
            if (r9 == false) goto L19;
        L30:
            PromotionProductCommentDTO r3 = (PromotionProductCommentDTO) r2;
            if (r3 == null) goto L33;
            r3.setLiked(Boolean.valueOf(r0));
            r3.setLikes(Long.valueOf(r4));
            goto L33
        L24:
            if (r7.longValue() != r8) goto L26;
            r9 = true;
            goto L27
        L29:
            r2 = null;
        L33:
            s0.a(new vb3.a(this.b.a, r0, r4));
            return;
        L11:
            r6 = r16.c - 1;
            goto L12
        L34:
            Function1 r110 = this.c;
            if (r110 == null) goto L44;
            Unit r111 = (Unit) r110.invoke(new zb3.a(String.valueOf(this.b.a), !r0, this.b.c, 8));
            return;
        L44:
            return;
        L5:
            r0 = false;
            goto L7
        }

        public b(CommentListViewModel r1, zb3.b r2, Function1 r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    public static final class c implements Observer<CommentListResponse> {
        public final /* synthetic */ CommentListViewModel a;

        public final void onComplete() {
        }

        public final void onSubscribe(Disposable r2) {
            Intrinsics.checkNotNullParameter(r2, "d");
        }

        public c(CommentListViewModel r1) {
            this.a = r1;
        }

        public final void onError(Throwable r2) {
            Intrinsics.checkNotNullParameter(r2, "e");
            CommentListViewModel.access$setLoadingComment$p(this.a, false);
        }

        public final void onNext(Object r5) {
            CommentListResponse r6 = (CommentListResponse) r5;
            Intrinsics.checkNotNullParameter(r6, "t");
            if (r6.getStatusCode() != 0) goto L11;
            xb3.c r0 = xb3.c.e;
            int r2 = r6.getCursor();
            r0.getClass();
            xb3.c.d = r2;
            ArrayList r1 = new ArrayList();
            List r3 = (List) this.a.getCommentList().getValue();
            if (r3 == null) goto L7;
            r1.addAll(r3);
        L7:
            List<PromotionProductCommentDTO> r4 = r6.getComments();
            if (r4 == null) goto L10;
            r1.addAll(r4);
        L10:
            this.a.getCommentList().postValue(r1);
            this.a.setHasMoreComment(r6.getHasMore());
            this.a.isRequestSucceed().postValue(new Pair(Boolean.TRUE, Integer.valueOf(r1.size())));
        L12:
            CommentListViewModel.access$setLoadingComment$p(this.a, false);
            return;
        L11:
            this.a.isRequestSucceed().postValue(new Pair(Boolean.FALSE, 0));
            goto L12
        }
    }

    static {
        Companion = new a();
    }

    public CommentListViewModel() {
        this.commentList = new MutableLiveData();
        this.isRequestSucceed = new MutableLiveData();
        this.hasMoreComment = true;
    }

    public final long getCommentCursor() {
        return this.commentCursor;
    }

    public final MutableLiveData<List<PromotionProductCommentDTO>> getCommentList() {
        return this.commentList;
    }

    public final int getFirstEnterCommentIndex() {
        return this.firstEnterCommentIndex;
    }

    public final boolean getHasMoreComment() {
        return this.hasMoreComment;
    }

    public final MutableLiveData<Pair<Boolean, Integer>> isRequestSucceed() {
        return this.isRequestSucceed;
    }

    public static final /* synthetic */ boolean access$isLoadingComment$p(CommentListViewModel r0) {
        return r0.isLoadingComment;
    }

    public final void loadCommentList(d r3) {
        Intrinsics.checkNotNullParameter(r3, "requestParam");
        this.isLoadingComment = true;
        xb3.c.e.getClass();
        Intrinsics.checkNotNullParameter(r3, "requestParam");
        xb3.c.b.a(r3).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c(this));
    }

    public final void setCommentCursor(long r1) {
        this.commentCursor = r1;
    }

    public final void setCommentModel(List<PromotionProductCommentDTO> r2) {
        Intrinsics.checkNotNullParameter(r2, "comments");
        this.commentList.postValue(r2);
    }

    public final void setFirstEnterCommentIndex(int r1) {
        this.firstEnterCommentIndex = r1;
    }

    public final void setHasMoreComment(boolean r1) {
        this.hasMoreComment = r1;
    }

    public static final /* synthetic */ void access$setLoadingComment$p(CommentListViewModel r0, boolean r1) {
        r0.isLoadingComment = r1;
    }

    public final void diggCommentAction(zb3.b r3, Function1<? super zb3.a, Unit> r4) {
        Intrinsics.checkNotNullParameter(r3, "requestParams");
        xb3.c.e.getClass();
        xb3.c.a(r3).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(this, r3, r4));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void diggCommentAction$default(CommentListViewModel r0, zb3.b r1, Function1 r2, int r3, Object r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        r0.diggCommentAction(r1, r2);
    }
}
