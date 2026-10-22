package ef0;

import com.bytedance.android.live.broadcastgame.api.xplay.g;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.android.livehostapi.business.depend.xplay.IByteRtcVideoFrame;
import com.bytedance.live.datacontext.m;
import jc1.k;
import kotlin.jvm.internal.Intrinsics;
import rj0.d;
import uf2.d0;

/* JADX INFO: loaded from: classes46.dex */
public final class b extends bf0.a<g> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f472410b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f472411c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f472412d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f472413e;

    public b() {
        this.f472410b = "kColorSpaceYCbCrBT601LimitedRange";
        this.f472411c = "kColorSpaceYCbCrBT601FullRange";
        this.f472412d = "kColorSpaceYCbCrBT709LimitedRange";
        this.f472413e = "kColorSpaceYCbCrBT709FullRange";
    }

    @Override // bf0.a
    public final g b(Object r100) {
        g r101 = (g) r100;
        Intrinsics.checkNotNullParameter(r101, "frame");
        IInteractService r102 = (IInteractService) k.f(IInteractService.class);
        if (r102 == null) goto L7;
        d r103 = r102.getCommonService();
        if (r103 == null) goto L7;
        com.bytedance.android.live.pushstream.d r104 = r103.getLiveStream();
    L8:
        if (r104 == null) goto L39;
        HamletAvatarContext r105 = HamletAvatarContext.Companion.getContext();
        if (r105 == null) goto L17;
        m<Boolean> r106 = r105.isStreamRending();
        if (r106 == null) goto L17;
        Boolean r107 = r106.getValue();
        if (r107 == null) goto L17;
        boolean r108 = r107.booleanValue();
    L19:
        if (gh0.a.d() == false) goto L39;
        if (r108 == false) goto L39;
        IByteRtcVideoFrame r109 = r101.b();
        if (com.bytedance.android.live.broadcastgame.api.xplay.a.b(r109) == true) goto L24;
        String r110 = r101.b().getColorSpace();
        if (Intrinsics.areEqual(r110, this.f472410b) == false) goto L31;
    L36:
        d0 r111 = r104.getLiveCore();
        if (r111 == null) goto L39;
        r101.a();
        r109.getWidth();
        r109.getHeight();
        r109.getTimestampUs();
        r111.j();
        goto L39
    L31:
        if (Intrinsics.areEqual(r110, this.f472412d) == true) goto L36;
        if (Intrinsics.areEqual(r110, this.f472411c) == true) goto L36;
        Intrinsics.areEqual(r110, this.f472413e);
        goto L36
    L24:
        if (r109.getTextureId() <= 0) goto L39;
        d0 r112 = r104.getLiveCore();
        if (r112 == null) goto L39;
        r109.getTextureId();
        Intrinsics.checkNotNullParameter(r109, "$this$isTextureOes");
        Intrinsics.areEqual(r109.getPixelFormat(), IByteRtcVideoFrame.PixelFormat.TEXTURE_OES.getStringValue());
        r109.getWidth();
        r109.getHeight();
        r109.getRotation();
        r109.getTextureMatrix();
        r109.getTimestampUs();
        r112.n();
    L17:
        r108 = false;
    L39:
        return r101;
    L7:
        r104 = null;
        goto L8
    }
}
