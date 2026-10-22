package jb2;

import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.live.richcontent.model.style.ImageStyle;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e extends fk6.a implements a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f497995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f497996e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final int f497997f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final b f497998g;

    @Override // jb2.a
    public final b b() {
        return this.f497998g;
    }

    public final int getType() {
        return this.f497995d;
    }

    public e(int r100, String r101, int r102, ek6.b r103, ImageStyle r104, ib2.a r105, b r106) {
        Intrinsics.checkNotNullParameter(r101, "text");
        Intrinsics.checkNotNullParameter(r103, WsConstants.KEY_PAYLOAD);
        super(r103, r104, r105);
        this.f497995d = r100;
        this.f497996e = r101;
        this.f497997f = r102;
        this.f497998g = r106;
    }
}
