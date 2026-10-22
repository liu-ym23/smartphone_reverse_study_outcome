package qf1;

import com.bytedance.android.livesdk.castscreen.leboController.bytecast.ui.LiveByteCastUIManager;
import com.bytedance.android.livesdk.castscreen.views.CastScreenViewModel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.live.datacontext.m;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class a {
    public static final boolean a(DataCenter r100) {
        CastScreenViewModel.Companion.getClass();
        CastScreenViewModel r101 = CastScreenViewModel.a.b(r100);
        if (r101 == null) goto L9;
        m<Boolean> r102 = r101.getCastScreenMode();
        if (r102 == null) goto L9;
        if (r102.getValue().booleanValue() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final boolean b(DataCenter r100) {
        CastScreenViewModel.Companion.getClass();
        CastScreenViewModel r101 = CastScreenViewModel.a.b(r100);
        if (r101 == null) goto L9;
        m<Boolean> r102 = r101.getMirrorScreenMode();
        if (r102 == null) goto L9;
        if (r102.getValue().booleanValue() != true) goto L9;
        return true;
    L9:
        return false;
    }

    public static final void c(DataCenter r100, boolean r101) {
        CastScreenViewModel.Companion.getClass();
        CastScreenViewModel r102 = CastScreenViewModel.a.b(r100);
        if (r102 == null) goto L7;
        m<Boolean> r103 = r102.getCastScreenMode();
        if (r103 == null) goto L7;
        r103.setValue(Boolean.valueOf(r101));
    L7:
        CastScreenViewModel r104 = CastScreenViewModel.a.b(r100);
        if (r104 == null) goto L23;
        m<Boolean> r105 = r104.getCastOrMirrorScreenMode();
        if (r105 == null) goto L23;
        boolean r106 = true;
        if (r101 == true) goto L21;
        CastScreenViewModel r107 = CastScreenViewModel.a.b(r100);
        if (r107 == null) goto L20;
        m<Boolean> r108 = r107.getMirrorScreenMode();
        if (r108 == null) goto L20;
        if (r108.getValue().booleanValue() == true) goto L21;
    L20:
        r106 = false;
    L21:
        r105.setValue(Boolean.valueOf(r106));
    L23:
        if (r101 == false) goto L25;
        String r109 = LiveByteCastUIManager.f104549a;
        Intrinsics.checkNotNullParameter("linking", "<set-?>");
        LiveByteCastUIManager.f104549a = "linking";
        return;
    L25:
        String r110 = LiveByteCastUIManager.f104549a;
        Intrinsics.checkNotNullParameter("not_in_casting", "<set-?>");
        LiveByteCastUIManager.f104549a = "not_in_casting";
    }

    public static final void d(DataCenter r100, boolean r101) {
        CastScreenViewModel.Companion.getClass();
        CastScreenViewModel r102 = CastScreenViewModel.a.b(r100);
        if (r102 == null) goto L7;
        m<Boolean> r103 = r102.getMirrorScreenMode();
        if (r103 == null) goto L7;
        r103.setValue(Boolean.valueOf(r101));
    L7:
        CastScreenViewModel r104 = CastScreenViewModel.a.b(r100);
        if (r104 == null) goto L23;
        m<Boolean> r105 = r104.getCastOrMirrorScreenMode();
        if (r105 == null) goto L23;
        boolean r106 = true;
        if (r101 == true) goto L21;
        CastScreenViewModel r107 = CastScreenViewModel.a.b(r100);
        if (r107 == null) goto L20;
        m<Boolean> r108 = r107.getCastScreenMode();
        if (r108 == null) goto L20;
        if (r108.getValue().booleanValue() == true) goto L21;
    L20:
        r106 = false;
    L21:
        r105.setValue(Boolean.valueOf(r106));
    L23:
        if (r101 == false) goto L25;
        String r109 = LiveByteCastUIManager.f104549a;
        Intrinsics.checkNotNullParameter("linking", "<set-?>");
        LiveByteCastUIManager.f104549a = "linking";
        return;
    L25:
        String r110 = LiveByteCastUIManager.f104549a;
        Intrinsics.checkNotNullParameter("not_in_casting", "<set-?>");
        LiveByteCastUIManager.f104549a = "not_in_casting";
    }
}
