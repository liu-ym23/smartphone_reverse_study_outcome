package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.chat.entity.message.content.BaseFileContent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class BaseFileContentVO<T extends BaseFileContent<T>> extends v5b.a<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f411856b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f411857c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f411858d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f411859e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f411860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f411861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f411862h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f411863i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f411864j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f411865k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f411866l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f411867m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f411868n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public String f411869o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public Message.SourceType f411870p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Message.FileDeletedStatus f411871q;

    public final String e() {
        return (String) this.f411856b.getValue();
    }

    public final String f() {
        return (String) this.f411857c.getValue();
    }

    public final boolean g() {
        return ((Boolean) this.f411862h.getValue()).booleanValue();
    }

    public final boolean h() {
        return ((Boolean) this.f411864j.getValue()).booleanValue();
    }

    public final boolean i() {
        return ((Boolean) this.f411865k.getValue()).booleanValue();
    }

    public BaseFileContentVO(final T r100) {
        Intrinsics.checkNotNullParameter(r100, "content");
        super(r100);
        this.f411856b = LazyKt.lazy(new BaseFileContentVO$key$2(r100));
        this.f411857c = LazyKt.lazy(new BaseFileContentVO$name$2(r100));
        this.f411858d = LazyKt.lazy(new BaseFileContentVO$size$2(r100));
        this.f411859e = LazyKt.lazy(new BaseFileContentVO$nameSpace$2(r100));
        this.f411860f = LazyKt.lazy(new BaseFileContentVO$source$2(r100));
        this.f411861g = LazyKt.lazy(new BaseFileContentVO$saveToDrive$2(r100));
        this.f411862h = LazyKt.lazy(new BaseFileContentVO$isFromDrive$2(r100));
        this.f411863i = LazyKt.lazy(new BaseFileContentVO$isInMyNutStore$2(r100));
        this.f411864j = LazyKt.lazy(new BaseFileContentVO$isLanTrans$2(r100));
        this.f411865k = LazyKt.lazy(new BaseFileContentVO$isSender$2(r100));
        this.f411866l = LazyKt.lazy(new BaseFileContentVO$isLanTransferring$2(r100));
        this.f411867m = LazyKt.lazy(new BaseFileContentVO$lanTransStatus$2(r100));
        this.f411869o = "";
        this.f411870p = Message.SourceType.TYPE_FROM_UNKONWN;
        this.f411871q = Message.FileDeletedStatus.NORMAL;
    }

    @Override // v5b.a
    public boolean d(v5b.a<?> r100) {
        if (super.d(r100) == true) goto L5;
        return false;
    L5:
        if (r100 != null) goto L7;
        return false;
    L7:
        if ((r100 instanceof BaseFileContentVO) == false) goto L27;
        BaseFileContentVO r101 = (BaseFileContentVO) r100;
        if (((Number) this.f411861g.getValue()).intValue() == ((Number) r101.f411861g.getValue()).intValue()) goto L11;
        return false;
    L11:
        if (g() == r101.g()) goto L13;
        return false;
    L13:
        if (this.f411868n == r101.f411868n) goto L15;
        return false;
    L15:
        if (((Boolean) this.f411863i.getValue()).booleanValue() == ((Boolean) r101.f411863i.getValue()).booleanValue()) goto L17;
        return false;
    L17:
        if (this.f411871q == r101.f411871q) goto L19;
        return false;
    L19:
        if (h() == r101.h()) goto L21;
        return false;
    L21:
        if (i() == r101.i()) goto L23;
        return false;
    L23:
        if (((Number) this.f411867m.getValue()).intValue() != ((Number) r101.f411867m.getValue()).intValue()) goto L35;
        return true;
    L35:
        return false;
    L27:
        return false;
    }
}
