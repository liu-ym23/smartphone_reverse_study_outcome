package jb2;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.live.richcontent.model.style.ImageStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class c extends fk6.a implements a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ek6.b f497987d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ImageStyle f497988e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final ek6.c f497989f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f497990g;

    @Override // jb2.a
    public final b b() {
        return this.f497990g;
    }

    @Override // fk6.a
    public final ek6.c c() {
        return this.f497989f;
    }

    @Override // fk6.a
    public final ek6.b d() {
        return this.f497987d;
    }

    @Override // fk6.a
    public final ImageStyle e() {
        return this.f497988e;
    }

    public c(ek6.b r100, ImageStyle r101, ek6.c r102, b r103) {
        Intrinsics.checkNotNullParameter(r100, WsConstants.KEY_PAYLOAD);
        super(r100, r101, r102);
        this.f497987d = r100;
        this.f497988e = r101;
        this.f497989f = r102;
        this.f497990g = r103;
    }
}
