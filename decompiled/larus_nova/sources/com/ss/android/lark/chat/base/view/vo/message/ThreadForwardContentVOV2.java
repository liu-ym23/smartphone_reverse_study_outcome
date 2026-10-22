package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.chatter.ChatterInfo;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.MergeForwardContent;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class ThreadForwardContentVOV2 extends f<MergeForwardContent> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Message f411939h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ChatterInfo f411940i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f411941j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f411942k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f411943l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f411944m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f411945n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<y6b.f> f411946o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f411947p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f411948q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f411949r;

    public final boolean f() {
        return ((Boolean) this.f411948q.getValue()).booleanValue();
    }

    public final boolean g() {
        return ((Boolean) this.f411947p.getValue()).booleanValue();
    }

    public ThreadForwardContentVOV2(final MergeForwardContent r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        super(r100);
        this.f411939h = new Message();
        this.f411940i = new ChatterInfo();
        this.f411941j = "";
        this.f411942k = "";
        this.f411943l = "";
        this.f411944m = true;
        this.f411947p = LazyKt.lazy(new ThreadForwardContentVOV2$isReplyInThread$2(r100));
        this.f411948q = LazyKt.lazy(new ThreadForwardContentVOV2$isInChat$2(r100));
        this.f411949r = LazyKt.lazy(new ThreadForwardContentVOV2$isPublic$2(r100));
    }

    @Override // com.ss.android.lark.chat.base.view.vo.message.f, v5b.a
    public final boolean d(v5b.a<?> r100) {
        if (r100 != null) goto L5;
    L31:
        return false;
    L5:
        if ((r100 instanceof ThreadForwardContentVOV2) == false) goto L31;
        ThreadForwardContentVOV2 r101 = (ThreadForwardContentVOV2) r100;
        if (this.f411939h.isContentSame(r101.f411939h) == true) goto L11;
        return false;
    L11:
        if (this.f411940i.isContentSame(r101.f411940i) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f411941j, r101.f411941j) == false) goto L31;
        if (Intrinsics.areEqual(this.f411942k, r101.f411942k) == false) goto L31;
        if (Intrinsics.areEqual(this.f411943l, r101.f411943l) == false) goto L31;
        if (this.f411945n != r101.f411945n) goto L31;
        if (g() != r101.g()) goto L31;
        if (f() != r101.f()) goto L31;
        if (((Boolean) this.f411949r.getValue()).booleanValue() != ((Boolean) r101.f411949r.getValue()).booleanValue()) goto L31;
        return y28.a.b(this.f411946o, r101.f411946o);
    }
}
