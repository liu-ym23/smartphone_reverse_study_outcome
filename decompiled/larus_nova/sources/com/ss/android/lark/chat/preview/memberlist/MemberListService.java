package com.ss.android.lark.chat.preview.memberlist;

import com.bytedance.lark.pb.url.v1.PullUrlPreviewChattersListRequest;
import com.bytedance.lark.pb.url.v1.PullUrlPreviewChattersListResponse;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.rucket.impl.sdkimpl.annotation.SdkCall;
import com.larksuite.rucket.job.RucketJob;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class MemberListService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MemberListService f416290a = null;

    public interface a {
        @SdkCall(3839)
        RucketJob<PullUrlPreviewChattersListResponse> loadMemberList(PullUrlPreviewChattersListRequest r100);
    }

    public static abstract class b<T> {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ErrorResult f416291a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof a) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f416291a, ((a) r100).f416291a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f416291a.hashCode();
            }

            public final String toString() {
                return "Error(error=" + this.f416291a + ')';
            }

            public a(ErrorResult r100) {
                Intrinsics.checkNotNullParameter(r100, "error");
                this.f416291a = r100;
            }
        }

        /* JADX INFO: renamed from: com.ss.android.lark.chat.preview.memberlist.MemberListService$b$b, reason: collision with other inner class name */
        public static final class C4872b<T> extends b<T> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final T f416292a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C4872b) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f416292a, ((C4872b) r100).f416292a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                T r100 = this.f416292a;
                if (r100 != null) goto L6;
                return 0;
            L6:
                return r100.hashCode();
            }

            public final String toString() {
                return "Success(data=" + this.f416292a + ')';
            }

            public C4872b(T r100) {
                this.f416292a = r100;
            }
        }

        public b() {
        }
    }

    static {
        f416290a = new MemberListService();
    }

    public MemberListService() {
    }

    public final Object a(String r100, String r101, String r102, Continuation<? super b<PullUrlPreviewChattersListResponse>> r103) {
        if ((r103 instanceof MemberListService$loadMemberList$1) == false) goto L7;
        MemberListService$loadMemberList$1 r104 = (MemberListService$loadMemberList$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L13;
        ResultKt.throwOnFailure(r106);
    L17:
        com.larksuite.rucket.job.base.b r109 = (com.larksuite.rucket.job.base.b) r106;
        if ((r109 instanceof com.larksuite.rucket.job.base.b.c) == false) goto L21;
        return new b.C4872b(((com.larksuite.rucket.job.base.b.c) r109).f286079b);
    L21:
        if ((r109 instanceof com.larksuite.rucket.job.base.b.C3939b) == false) goto L25;
        return new b.a(((com.larksuite.rucket.job.base.b.C3939b) r109).f286078b);
    L25:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        PullUrlPreviewChattersListRequest.Builder r110 = new PullUrlPreviewChattersListRequest.Builder();
        r110.preview_id(r100);
        r110.component_id(r101);
        r110.next_token(r102);
        PullUrlPreviewChattersListRequest r111 = r110.build();
        a r112 = (a) b38.b.f17382a.create(a.class);
        Intrinsics.checkNotNull(r111);
        RucketJob<PullUrlPreviewChattersListResponse> r113 = r112.loadMemberList(r111);
        r104.label = 1;
        r106 = r113.awaitGet(r104);
        if (r106 != r107) goto L17;
        return r107;
    L7:
        r104 = new MemberListService$loadMemberList$1(this, r103);
        goto L8
    }
}
