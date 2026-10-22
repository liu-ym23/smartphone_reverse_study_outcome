package zd0;

import com.bytedance.android.live.liveinteract.hamlet.HamletAvatarContext;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class d implements yd0.a {
    public d() {
    }

    @Override // yd0.a
    public final boolean a(wd0.b r100) {
        Intrinsics.checkNotNullParameter(r100, "renderContext");
        HamletAvatarContext r101 = HamletAvatarContext.Companion.getContext();
        if (r101 == null) goto L9;
        m<Boolean> r102 = r101.isStreamRending();
        if (r102 == null) goto L9;
        if (r102.getValue().booleanValue() != true) goto L9;
        return false;
    L9:
        Integer r103 = r100.f559273d;
        if (r103 != null) goto L13;
    L17:
        return true;
    L13:
        if (r103.intValue() != 28) goto L17;
        if (Intrinsics.areEqual(r100.f559274e, Boolean.TRUE) == false) goto L17;
        return false;
    }
}
