package com.story.ai.biz.comment.contracts;

import android.app.Activity;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.platform.model.comment.UserInfo;
import com.story.ai.biz.comment.model.BaseComment;
import com.story.ai.biz.comment.model.ExpandAndCollapseCommentItem;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public abstract class CommentEvent implements com.story.ai.base.components.mvi.f {

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J)\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018HÖ\u0003J\t\u0010\u0019\u001a\u00020\bHÖ\u0001J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/story/ai/biz/comment/contracts/CommentEvent$OnItemLongClick;", "Lcom/story/ai/biz/comment/contracts/CommentEvent;", "Ljava/io/Serializable;", "activity", "Landroid/app/Activity;", "comment", "Lcom/story/ai/biz/comment/model/BaseComment;", "position", "", "<init>", "(Landroid/app/Activity;Lcom/story/ai/biz/comment/model/BaseComment;I)V", "getActivity", "()Landroid/app/Activity;", "getComment", "()Lcom/story/ai/biz/comment/model/BaseComment;", "getPosition", "()I", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class OnItemLongClick extends CommentEvent implements Serializable {
        private final Activity activity;
        private final BaseComment comment;
        private final int position;

        public static /* synthetic */ OnItemLongClick copy$default(OnItemLongClick r100, Activity r101, BaseComment r102, int r103, int r104, Object r105) {
            if ((r104 & 1) == 0) goto L6;
            r101 = r100.activity;
        L6:
            if ((r104 & 2) == 0) goto L9;
            r102 = r100.comment;
        L9:
            if ((r104 & 4) == 0) goto L12;
            r103 = r100.position;
        L12:
            return r100.copy(r101, r102, r103);
        }

        public final Activity component1() {
            return this.activity;
        }

        public final BaseComment component2() {
            return this.comment;
        }

        public final int component3() {
            return this.position;
        }

        public final OnItemLongClick copy(Activity r100, BaseComment r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "comment");
            return new OnItemLongClick(r100, r101, r102);
        }

        public boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof OnItemLongClick) == true) goto L8;
            return false;
        L8:
            OnItemLongClick r101 = (OnItemLongClick) r100;
            if (Intrinsics.areEqual(this.activity, r101.activity) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.comment, r101.comment) == true) goto L15;
            return false;
        L15:
            if (this.position == r101.position) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            Activity r100 = this.activity;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (((r101 * 31) + this.comment.hashCode()) * 31) + this.position;
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public String toString() {
            return "OnItemLongClick(activity=" + this.activity + ", comment=" + this.comment + ", position=" + this.position + ')';
        }

        public final Activity getActivity() {
            return this.activity;
        }

        public final BaseComment getComment() {
            return this.comment;
        }

        public final int getPosition() {
            return this.position;
        }

        public OnItemLongClick(Activity r100, BaseComment r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "comment");
            super(null);
            this.activity = r100;
            this.comment = r101;
            this.position = r102;
        }
    }

    public static final class a extends CommentEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ExpandAndCollapseCommentItem f459859a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f459860b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f459859a, r101.f459859a) == true) goto L12;
            return false;
        L12:
            if (this.f459860b == r101.f459860b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f459859a.hashCode() * 31) + this.f459860b;
        }

        public final String toString() {
            return "CollapseComment(comment=" + this.f459859a + ", position=" + this.f459860b + ')';
        }

        public a(ExpandAndCollapseCommentItem r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "comment");
            super(null);
            this.f459859a = r100;
            this.f459860b = r101;
        }
    }

    public static final class b extends CommentEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ExpandAndCollapseCommentItem f459861a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f459862b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f459861a, r101.f459861a) == true) goto L12;
            return false;
        L12:
            if (this.f459862b == r101.f459862b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f459861a.hashCode() * 31) + this.f459862b;
        }

        public final String toString() {
            return "ExpandComment(comment=" + this.f459861a + ", position=" + this.f459862b + ')';
        }

        public b(ExpandAndCollapseCommentItem r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "comment");
            super(null);
            this.f459861a = r100;
            this.f459862b = r101;
        }
    }

    public static final class c extends CommentEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f459863a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f459863a, ((c) r100).f459863a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f459863a.hashCode();
        }

        public final String toString() {
            return "InputContentChange(content=" + this.f459863a + ')';
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "content");
            super(null);
            this.f459863a = r100;
        }
    }

    public static final class d extends CommentEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BaseComment f459864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f459865b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f459864a, r101.f459864a) == true) goto L12;
            return false;
        L12:
            if (this.f459865b == r101.f459865b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f459864a.hashCode() * 31) + this.f459865b;
        }

        public final String toString() {
            return "LikeComment(comment=" + this.f459864a + ", position=" + this.f459865b + ')';
        }

        public d(BaseComment r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "comment");
            super(null);
            this.f459864a = r100;
            this.f459865b = r101;
        }
    }

    public static final class e extends CommentEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f459866a = null;

        static {
            f459866a = new e();
        }

        public e() {
            super(null);
        }
    }

    public static final class f extends CommentEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BaseComment f459867a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f459868b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.f459867a, r101.f459867a) == true) goto L12;
            return false;
        L12:
            if (this.f459868b == r101.f459868b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f459867a.hashCode() * 31) + this.f459868b;
        }

        public final String toString() {
            return "OnCommentClick(comment=" + this.f459867a + ", position=" + this.f459868b + ')';
        }

        public f(BaseComment r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "comment");
            super(null);
            this.f459867a = r100;
            this.f459868b = r101;
        }
    }

    public static final class g extends CommentEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Fragment f459869a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BaseComment f459870b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.f459869a, r101.f459869a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f459870b, r101.f459870b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f459869a.hashCode() * 31) + this.f459870b.hashCode();
        }

        public final String toString() {
            return "OnHeadClick(fragment=" + this.f459869a + ", comment=" + this.f459870b + ')';
        }

        public g(Fragment r100, BaseComment r101) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            Intrinsics.checkNotNullParameter(r101, "comment");
            super(null);
            this.f459869a = r100;
            this.f459870b = r101;
        }
    }

    public static final class h extends CommentEvent {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            ((h) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(null, null) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final Context getContext() {
            return null;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "OnLoginEvent(context=null, source=null)";
        }
    }

    public static final class i extends CommentEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Fragment f459871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final UserInfo f459872b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L8;
            return false;
        L8:
            i r101 = (i) r100;
            if (Intrinsics.areEqual(this.f459871a, r101.f459871a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f459872b, r101.f459872b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f459871a.hashCode() * 31) + this.f459872b.hashCode();
        }

        public final String toString() {
            return "OnUserNameClick(fragment=" + this.f459871a + ", userInfo=" + this.f459872b + ')';
        }

        public i(Fragment r100, UserInfo r101) {
            Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
            Intrinsics.checkNotNullParameter(r101, "userInfo");
            super(null);
            this.f459871a = r100;
            this.f459872b = r101;
        }
    }

    public static final class j extends CommentEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final a f459873a;

        public static final class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final BaseComment f459874a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final int f459875b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L8;
                return false;
            L8:
                a r101 = (a) r100;
                if (Intrinsics.areEqual(this.f459874a, r101.f459874a) == true) goto L12;
                return false;
            L12:
                if (this.f459875b == r101.f459875b) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                BaseComment r100 = this.f459874a;
                if (r100 != null) goto L5;
                int r101 = 0;
            L7:
                return (r101 * 31) + this.f459875b;
            L5:
                r101 = r100.hashCode();
                goto L7
            }

            public final String toString() {
                return "Params(replyComment=" + this.f459874a + ", bgColor=" + this.f459875b + ')';
            }

            public a(BaseComment r100, int r101) {
                this.f459874a = r100;
                this.f459875b = r101;
            }
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f459873a, ((j) r100).f459873a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f459873a.hashCode();
        }

        public final String toString() {
            return "OpenCommentInputDialog(params=" + this.f459873a + ')';
        }

        public j(a r100) {
            Intrinsics.checkNotNullParameter(r100, "params");
            super(null);
            this.f459873a = r100;
        }
    }

    public static final class k extends CommentEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f459876a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final BaseComment f459877b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k) == true) goto L8;
            return false;
        L8:
            k r101 = (k) r100;
            if (Intrinsics.areEqual(this.f459876a, r101.f459876a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f459877b, r101.f459877b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f459876a.hashCode() * 31;
            BaseComment r101 = this.f459877b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "PublishComment(content=" + this.f459876a + ", replyComment=" + this.f459877b + ')';
        }

        public k(String r100, BaseComment r101) {
            Intrinsics.checkNotNullParameter(r100, "content");
            super(null);
            this.f459876a = r100;
            this.f459877b = r101;
        }
    }

    public static final class l extends CommentEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f459878a = null;

        static {
            f459878a = new l();
        }

        public l() {
            super(null);
        }
    }

    public static final class m extends CommentEvent {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final BaseComment f459879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f459880b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m) == true) goto L8;
            return false;
        L8:
            m r101 = (m) r100;
            if (Intrinsics.areEqual(this.f459879a, r101.f459879a) == true) goto L12;
            return false;
        L12:
            if (this.f459880b == r101.f459880b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f459879a.hashCode() * 31) + this.f459880b;
        }

        public final String toString() {
            return "RetryComment(comment=" + this.f459879a + ", position=" + this.f459880b + ')';
        }

        public m(BaseComment r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "comment");
            super(null);
            this.f459879a = r100;
            this.f459880b = r101;
        }
    }

    private CommentEvent() {
    }

    public /* synthetic */ CommentEvent(DefaultConstructorMarker r100) {
        this();
    }
}
