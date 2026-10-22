package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.message.MessageIdentity;
import com.ss.android.lark.chat.entity.message.content.ImageContent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ImageContentVO extends f<ImageContent> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f411901h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f411902i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f411903j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f411904k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f411905l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f411906m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public MessageIdentity f411907n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final int f411908o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f411909p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f411910q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f411911r;

    @Override // com.ss.android.lark.chat.base.view.vo.message.f
    public final boolean e() {
        int r100 = this.f411956f;
        if (r100 == 1) goto L8;
        if (r100 == 0) goto L8;
        if (this.f411957g == null) goto L8;
        return true;
    L8:
        return false;
    }

    public ImageContentVO(final ImageContent r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        super(r100);
        this.f411901h = LazyKt.lazy(new ImageContentVO$key$2(r100));
        this.f411902i = LazyKt.lazy(new ImageContentVO$origin$2(r100));
        this.f411903j = LazyKt.lazy(new ImageContentVO$originKey$2(r100));
        this.f411904k = LazyKt.lazy(new ImageContentVO$thumbnail$2(r100));
        this.f411905l = LazyKt.lazy(new ImageContentVO$middle$2(r100));
        this.f411906m = LazyKt.lazy(new ImageContentVO$inlinePreview$2(r100));
        r100.getImageTranslateProperty();
        this.f411908o = r100.getProgress();
        this.f411909p = LazyKt.lazy(new ImageContentVO$isOriginSource$2(r100));
        this.f411910q = LazyKt.lazy(new ImageContentVO$originSize$2(r100));
        this.f411911r = LazyKt.lazy(new ImageContentVO$isFromMe$2(r100));
    }

    @Override // com.ss.android.lark.chat.base.view.vo.message.f, v5b.a
    public final boolean d(v5b.a<?> r100) {
        if (super.d(r100) == true) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if ((r100 instanceof ImageContentVO) == false) goto L15;
        ImageContentVO r101 = (ImageContentVO) r100;
        if (y28.a.a(this.f411907n, r101.f411907n) == true) goto L11;
        return false;
    L11:
        if (this.f411908o != r101.f411908o) goto L17;
        return true;
    L17:
        return false;
    L15:
        return false;
    }
}
