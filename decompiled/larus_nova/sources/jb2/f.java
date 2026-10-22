package jb2;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.live.richcontent.model.style.ImageStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class f extends fk6.a implements a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f497999d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f498000e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f498001f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f498002g;

    @Override // jb2.a
    public final b b() {
        return this.f498002g;
    }

    public f(String r100, int r101, float r102, ob2.f r103, ImageStyle r104, ib2.a r105, b r106) {
        Intrinsics.checkNotNullParameter(r100, "text");
        Intrinsics.checkNotNullParameter(r103, WsConstants.KEY_PAYLOAD);
        super(r103, r104, r105);
        this.f497999d = r100;
        this.f498000e = r101;
        this.f498001f = r102;
        this.f498002g = r106;
    }
}
