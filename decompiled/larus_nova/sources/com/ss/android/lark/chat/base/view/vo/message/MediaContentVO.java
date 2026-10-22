package com.ss.android.lark.chat.base.view.vo.message;

import android.text.TextUtils;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.FileState;
import com.ss.android.lark.chat.entity.message.content.MediaContent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class MediaContentVO extends v5b.a<MediaContent> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f411912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f411913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f411914d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f411915e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f411916f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f411917g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f411918h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f411919i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f411920j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f411921k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f411922l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f411923m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f411924n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public Message.SourceType f411925o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f411926p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Message.FileDeletedStatus f411927q;

    public final long e() {
        return ((Number) this.f411917g.getValue()).longValue();
    }

    public final String f() {
        if (TextUtils.isEmpty((String) this.f411919i.getValue()) == true) goto L6;
        return (String) this.f411919i.getValue();
    L6:
        return (String) this.f411920j.getValue();
    }

    public MediaContentVO(final MediaContent r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        super(r100);
        this.f411912b = LazyKt.lazy(new MediaContentVO$key$2(r100));
        this.f411913c = LazyKt.lazy(new MediaContentVO$name$2(r100));
        this.f411914d = LazyKt.lazy(new MediaContentVO$mime$2(r100));
        this.f411915e = LazyKt.lazy(new MediaContentVO$source$2(r100));
        this.f411916f = LazyKt.lazy(new MediaContentVO$imageSet$2(r100));
        this.f411917g = LazyKt.lazy(new MediaContentVO$duration$2(r100));
        this.f411918h = LazyKt.lazy(new MediaContentVO$progress$2(r100));
        this.f411919i = LazyKt.lazy(new MediaContentVO$originPath$2(r100));
        this.f411920j = LazyKt.lazy(new MediaContentVO$filePath$2(r100));
        this.f411921k = LazyKt.lazy(new MediaContentVO$compressPath$2(r100));
        this.f411922l = LazyKt.lazy(new MediaContentVO$fileState$2(r100));
        this.f411923m = LazyKt.lazy(new MediaContentVO$url$2(r100));
        this.f411924n = "";
        this.f411925o = Message.SourceType.TYPE_FROM_UNKONWN;
        this.f411927q = Message.FileDeletedStatus.NORMAL;
    }

    @Override // v5b.a
    public final boolean d(v5b.a<?> r100) {
        if (super.d(r100) == true) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if ((r100 instanceof MediaContentVO) == false) goto L21;
        MediaContentVO r101 = (MediaContentVO) r100;
        if (e() == r101.e()) goto L11;
        return false;
    L11:
        if (((Number) this.f411918h.getValue()).intValue() == ((Number) r101.f411918h.getValue()).intValue()) goto L13;
        return false;
    L13:
        if (((FileState) this.f411922l.getValue()) == ((FileState) r101.f411922l.getValue())) goto L15;
        return false;
    L15:
        if (this.f411926p == r101.f411926p) goto L17;
        return false;
    L17:
        if (y28.a.a(f(), r101.f()) == false) goto L26;
        return true;
    L26:
        return false;
    L21:
        return false;
    }
}
