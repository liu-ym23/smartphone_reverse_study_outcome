package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.message.content.AudioContent;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class AudioContentVO extends f<AudioContent> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public e f411838h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f411839i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f411840j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f411841k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f411842l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f411843m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f411844n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f411845o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f411846p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f411847q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f411848r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public AudioContent.a f411849s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public String f411850t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f411851u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public byte[] f411852v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f411853w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public List<String> f411854x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public List<String> f411855y;

    public final long f() {
        return ((Number) this.f411847q.getValue()).longValue();
    }

    public final int g() {
        return ((Number) this.f411841k.getValue()).intValue();
    }

    public final String h() {
        return (String) this.f411839i.getValue();
    }

    public final String i() {
        return (String) this.f411843m.getValue();
    }

    public final boolean j() {
        return ((Boolean) this.f411848r.getValue()).booleanValue();
    }

    public final boolean k() {
        return ((Boolean) this.f411842l.getValue()).booleanValue();
    }

    public final boolean l() {
        return ((Boolean) this.f411846p.getValue()).booleanValue();
    }

    public AudioContentVO(final AudioContent r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        super(r100);
        this.f411839i = LazyKt.lazy(new AudioContentVO$key$2(r100));
        this.f411840j = LazyKt.lazy(new AudioContentVO$size$2(r100));
        this.f411841k = LazyKt.lazy(new AudioContentVO$duration$2(r100));
        this.f411842l = LazyKt.lazy(new AudioContentVO$isNeedHideText$2(r100));
        this.f411843m = LazyKt.lazy(new AudioContentVO$recognizedText$2(r100));
        this.f411844n = LazyKt.lazy(new AudioContentVO$recognizedRichText$2(r100));
        this.f411845o = LazyKt.lazy(new AudioContentVO$copyText$2(r100));
        this.f411846p = LazyKt.lazy(new AudioContentVO$isRecognizeFinished$2(r100));
        this.f411847q = LazyKt.lazy(new AudioContentVO$audio2TextStartTime$2(r100));
        this.f411848r = LazyKt.lazy(new AudioContentVO$isAudioWithText$2(r100));
        this.f411849s = r100.getFileState();
    }

    @Override // com.ss.android.lark.chat.base.view.vo.message.f, v5b.a
    public final boolean d(v5b.a<?> r100) {
        if (super.d(r100) == true) goto L6;
        return false;
    L6:
        if ((r100 instanceof AudioContentVO) == false) goto L37;
        AudioContentVO r101 = (AudioContentVO) r100;
        if (y28.a.a(h(), r101.h()) == true) goto L10;
        return false;
    L10:
        if (((Number) this.f411840j.getValue()).longValue() == ((Number) r101.f411840j.getValue()).longValue()) goto L12;
        return false;
    L12:
        if (g() == r101.g()) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f411849s, r101.f411849s) == true) goto L16;
        return false;
    L16:
        if (k() == r101.k()) goto L18;
        return false;
    L18:
        if (y28.a.a(i(), r101.i()) == true) goto L20;
        return false;
    L20:
        if (l() == r101.l()) goto L22;
        return false;
    L22:
        if (f() == r101.f()) goto L24;
        return false;
    L24:
        if (j() == r101.j()) goto L26;
        return false;
    L26:
        if (this.f411853w == r101.f411853w) goto L28;
        return false;
    L28:
        if (this.f411851u == r101.f411851u) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f411850t, r101.f411850t) == true) goto L32;
        return false;
    L32:
        if (Intrinsics.areEqual(this.f411854x, r101.f411854x) == true) goto L34;
        return false;
    L34:
        if (Intrinsics.areEqual(this.f411855y, r101.f411855y) == false) goto L51;
        return true;
    L51:
        return false;
    L37:
        return false;
    }
}
