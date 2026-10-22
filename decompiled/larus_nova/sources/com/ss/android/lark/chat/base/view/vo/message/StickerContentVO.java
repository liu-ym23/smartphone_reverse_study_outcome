package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.StickerContent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class StickerContentVO extends v5b.a<StickerContent> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f411932b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f411933c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f411934d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f411935e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f411936f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f411937g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Message f411938h;

    public final int e() {
        return ((Number) this.f411934d.getValue()).intValue();
    }

    public final String f() {
        return (String) this.f411932b.getValue();
    }

    public final int g() {
        return ((Number) this.f411933c.getValue()).intValue();
    }

    public final boolean h() {
        return ((Boolean) this.f411935e.getValue()).booleanValue();
    }

    public StickerContentVO(final StickerContent r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        super(r100);
        this.f411932b = LazyKt.lazy(new StickerContentVO$key$2(r100));
        this.f411933c = LazyKt.lazy(new StickerContentVO$width$2(r100));
        this.f411934d = LazyKt.lazy(new StickerContentVO$height$2(r100));
        this.f411935e = LazyKt.lazy(new StickerContentVO$isAdded$2(r100));
        this.f411936f = LazyKt.lazy(new StickerContentVO$stickerId$2(r100));
        this.f411937g = LazyKt.lazy(new StickerContentVO$stickerSetId$2(r100));
    }

    @Override // v5b.a
    public final boolean d(v5b.a<?> r100) {
        if (super.d(r100) == true) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if ((r100 instanceof StickerContentVO) == false) goto L17;
        StickerContentVO r101 = (StickerContentVO) r100;
        if (g() == r101.g()) goto L11;
        return false;
    L11:
        if (e() == r101.e()) goto L13;
        return false;
    L13:
        if (h() != r101.h()) goto L20;
        return true;
    L20:
        return false;
    L17:
        return false;
    }
}
