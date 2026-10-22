package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.message.content.ShareGroupChatContent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ShareGroupChatContentVO extends v5b.a<ShareGroupChatContent> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f411928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f411929c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f411930d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f411931e;

    public ShareGroupChatContentVO(final ShareGroupChatContent r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        super(r100);
        this.f411928b = LazyKt.lazy(new ShareGroupChatContentVO$chat$2(r100));
        this.f411929c = LazyKt.lazy(new ShareGroupChatContentVO$joinToken$2(r100));
        this.f411930d = LazyKt.lazy(new ShareGroupChatContentVO$expireTime$2(r100));
        this.f411931e = LazyKt.lazy(new ShareGroupChatContentVO$joinChatErrState$2(r100));
    }

    @Override // v5b.a
    public final boolean d(v5b.a<?> r100) {
        if (super.d(r100) == true) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if ((r100 instanceof ShareGroupChatContentVO) == false) goto L15;
        ShareGroupChatContentVO r101 = (ShareGroupChatContentVO) r100;
        if (((Number) this.f411930d.getValue()).longValue() == ((Number) r101.f411930d.getValue()).longValue()) goto L11;
        return false;
    L11:
        if (((ShareGroupChatContent.GroupState) this.f411931e.getValue()) != ((ShareGroupChatContent.GroupState) r101.f411931e.getValue())) goto L17;
        return true;
    L17:
        return false;
    L15:
        return false;
    }
}
