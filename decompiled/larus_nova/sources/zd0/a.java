package zd0;

import com.bytedance.android.live.liveinteract.aimv.LiveLinkmicAIMVContext;
import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class a implements yd0.a {
    public a() {
    }

    @Override // yd0.a
    public final boolean a(wd0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "renderContext");
        IVoiceLiveTheme r101 = r100.f559275f;
        boolean r102 = false;
        if (r101 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        LiveLinkmicAIMVContext r104 = LiveLinkmicAIMVContext.Companion.getContext();
        if (r104 == null) goto L15;
        m<Boolean> r105 = r104.isPlaying();
        if (r105 == null) goto L15;
        if (r105.getValue().booleanValue() != true) goto L15;
        r102 = true;
    L15:
        if (r102 == false) goto L17;
        return r103;
    L17:
        return true;
    L5:
        if (r101.getImageType() != 3) goto L7;
        r103 = true;
        goto L8
    }
}
