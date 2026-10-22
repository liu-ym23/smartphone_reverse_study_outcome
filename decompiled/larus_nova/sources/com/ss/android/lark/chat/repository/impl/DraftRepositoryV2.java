package com.ss.android.lark.chat.repository.impl;

import com.bytedance.ies.xelement.LynxVideoManagerLite;
import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.im.v1.CreateDraftRequest;
import com.bytedance.lark.pb.im.v1.CreateDraftResponse;
import com.bytedance.lark.pb.im.v1.CreateOrDeleteChatLastDraftIdRequest;
import com.bytedance.lark.pb.im.v1.CreateOrDeleteChatLastDraftIdResponse;
import com.bytedance.lark.pb.im.v1.DeleteDraftRequest;
import com.bytedance.lark.pb.im.v1.DeleteDraftResponse;
import com.bytedance.lark.pb.im.v1.FetchChatInputDraftRequest;
import com.bytedance.lark.pb.im.v1.FetchChatInputDraftResponse;
import com.bytedance.lark.pb.im.v1.FetchMessageReplyDraftRequest;
import com.bytedance.lark.pb.im.v1.FetchMessageReplyDraftResponse;
import com.bytedance.lark.pb.im.v1.GetAllDraftsRequest;
import com.bytedance.lark.pb.im.v1.GetAllDraftsResponse;
import com.bytedance.lark.pb.im.v1.GetDraftsRequest;
import com.bytedance.lark.pb.im.v1.GetDraftsResponse;
import com.bytedance.lark.pb.im.v1.PutChatOrThreadDraftsUpdateRequest;
import com.bytedance.lark.pb.im.v1.PutChatOrThreadDraftsUpdateResponse;
import com.bytedance.lark.rustclient.api.d;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.p;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.t;
import com.bytedance.lark.rustclient.api.x;
import com.ss.android.lark.chat.service.impl.k;
import com.ss.android.lark.chat.service.impl.m;
import com.ss.android.lark.chat.service.impl.n;
import com.ss.android.lark.chat.service.impl.q;
import com.ss.android.lark.dto.draft.Draft;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import io.reactivex.functions.Consumer;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class DraftRepositoryV2 implements l6b.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f416312a;

    public static final class a {
    }

    public static final class b<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b<T> f416313a = null;

        static {
            f416313a = new b();
        }

        public b() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            x r101 = (x) r100;
            Log.i("DraftRepositoryV2", "call SDK Command=PUT_CHAT_OR_THREAD_DRAFTS_UPDATE async success");
        }
    }

    public static final class c<T> implements Consumer {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c<T> f416314a = null;

        static {
            f416314a = new c();
        }

        public c() {
        }

        @Override // io.reactivex.functions.Consumer
        public final void accept(Object r100) {
            Log.e("DraftRepositoryV2", "call SDK Command=PUT_CHAT_OR_THREAD_DRAFTS_UPDATE async failed, error=" + ((Throwable) r100).getMessage());
        }
    }

    static {
    }

    @Inject
    public DraftRepositoryV2(l r100) {
        Intrinsics.checkNotNullParameter(r100, "userClient");
        this.f416312a = r100;
    }

    @Override // l6b.a
    public final void b(DeleteDraftRequest.Builder r110) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        d r100 = new d(r110, DeleteDraftResponse.ADAPTER, Command.DELETE_DRAFT, null, null, null, null, 248);
        t.d(this.f416312a.h(r100).execute());
    }

    @Override // l6b.a
    public final void c(PutChatOrThreadDraftsUpdateRequest.Builder r110) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        d r100 = new d(r110, PutChatOrThreadDraftsUpdateResponse.ADAPTER, Command.PUT_CHAT_OR_THREAD_DRAFTS_UPDATE, null, null, null, null, 248);
        t.b(this.f416312a.h(r100).a()).subscribe(b.f416313a, c.f416314a);
    }

    @Override // l6b.a
    public final Map<String, List<Draft>> f(final Function1<? super GetAllDraftsResponse, ? extends Map<String, ? extends List<? extends Draft>>> r110) {
        Intrinsics.checkNotNullParameter(r110, "respMap");
        d r100 = new d(new GetAllDraftsRequest.Builder(), GetAllDraftsResponse.ADAPTER, Command.GET_ALL_DRAFTS, null, null, null, null, 248);
        Map<String, List<Draft>> r111 = (Map) t.c(t.e(this.f416312a.h(r100).execute(), new DraftRepositoryV2$getAllDrafts$1(r110)), null);
        if (r111 == null) goto L5;
        return r111;
    L5:
        return MapsKt.emptyMap();
    }

    @Override // l6b.a
    public final void h(CreateOrDeleteChatLastDraftIdRequest.Builder r110) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        d r100 = new d(r110, CreateOrDeleteChatLastDraftIdResponse.ADAPTER, Command.CREATE_OR_DELETE_CHAT_LAST_DRAFT_ID, null, null, null, null, 248);
        t.d(this.f416312a.h(r100).execute());
    }

    @Override // l6b.a
    public final Draft a(FetchMessageReplyDraftRequest.Builder r110, final q r111) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        d r100 = new d(r110, FetchMessageReplyDraftResponse.ADAPTER, Command.FETCH_MESSAGE_REPLY_DRAFT, null, null, null, null, 248);
        return (Draft) t.c(t.e(this.f416312a.h(r100).execute(), new DraftRepositoryV2$fetchMessageReplyDraft$1(r111)), null);
    }

    @Override // l6b.a
    public final Draft e(FetchChatInputDraftRequest.Builder r110, final n r111) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        d r100 = new d(r110, FetchChatInputDraftResponse.ADAPTER, Command.FETCH_CHAT_INPUT_DRAFT, null, null, null, null, 248);
        return (Draft) t.c(t.e(this.f416312a.h(r100).execute(), new DraftRepositoryV2$fetchChatInputDraft$1(r111)), null);
    }

    @Override // l6b.a
    public final Map g(GetDraftsRequest.Builder r110, final k r111) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        d r100 = new d(r110, GetDraftsResponse.ADAPTER, Command.GET_DRAFTS, null, null, null, null, 248);
        Map r112 = (Map) t.c(t.e(this.f416312a.h(r100).execute(), new DraftRepositoryV2$getDrafts$1(r111)), null);
        if (r112 == null) goto L5;
        return r112;
    L5:
        return MapsKt.emptyMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // l6b.a
    public final String d(CreateDraftRequest.Builder r110, com.ss.android.lark.chat.service.impl.l r111, m r112) {
        Intrinsics.checkNotNullParameter(r110, "builder");
        Intrinsics.checkNotNullParameter(r111, "respMap");
        Intrinsics.checkNotNullParameter(r112, LynxVideoManagerLite.EVENT_ON_ERROR);
        d r113 = new d(r110, CreateDraftResponse.ADAPTER, Command.CREATE_DRAFT, null, null, null, null, 248);
        s r114 = this.f416312a.h(r113).execute();
        if ((r114 instanceof x) == false) goto L6;
        return ((CreateDraftResponse) ((x) r114).f253935c).draft_id;
    L6:
        if ((r114 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L10;
        r112.invoke(p.a(((com.bytedance.lark.rustclient.api.c) r114).f253907c));
        return null;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
