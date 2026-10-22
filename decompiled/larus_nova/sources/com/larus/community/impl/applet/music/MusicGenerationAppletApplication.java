package com.larus.community.impl.applet.music;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import com.bytedance.ai.applet.app.AppletApplication;
import com.bytedance.ai.applet.app.NativeAppletApplication;
import com.bytedance.ai.applet.app.base.RouteOptions;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.platform.service.z2;
import com.larus.uaigc.applet.IMusicAppletPageProvider;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import ir8.c;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@NativeAppletApplication
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016¨\u0006\u0011"}, d2 = {"Lcom/larus/community/impl/applet/music/MusicGenerationAppletApplication;", "Lcom/bytedance/ai/applet/app/AppletApplication;", "<init>", "()V", "onCreateView", "Landroidx/fragment/app/Fragment;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "url", "", "options", "Lcom/bytedance/ai/applet/app/base/RouteOptions;", "onTaskBackground", "", "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicGenerationAppletApplication extends AppletApplication {

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public static Bundle f328887p;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f328888a = null;

        static {
            int[] r100 = new int[MusicAppletPage.values().length];
            r100[MusicAppletPage.TEMPLATE_LIST.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[MusicAppletPage.TEMPLATE_DETAIL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[MusicAppletPage.CHAT_MUSIC_DETAIL.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f328888a = r100;
        }
    }

    static {
    }

    @Override // com.bytedance.ai.applet.app.AppletApplication
    public final void onDestroy() {
        FLogger.f375446a.i("MusicGenerationAppletApplication", LiveCommonConstants.REASON_ON_DEDTROY);
        super.onDestroy();
        ir8.a.f495491a.clear();
        c.f495501a.clear();
        c.f495502b.clear();
    }

    public MusicGenerationAppletApplication() {
    }

    @Override // com.bytedance.ai.applet.app.AppletApplication
    public final void C(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        FLogger.f375446a.i("MusicGenerationAppletApplication", "onTaskBackground");
        CopyOnWriteArraySet<c.a> r101 = c.f495501a;
        Intrinsics.checkNotNullParameter(MusicAppletPage.APP_ID, "appId");
        Iterator<c.a> r102 = c.f495501a.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().a();
        goto L4
    L6:
        super.C(r100);
    }

    @Override // com.bytedance.ai.applet.app.AppletApplication
    public final void u(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        FLogger.f375446a.i("MusicGenerationAppletApplication", "onDestroyView");
        super.u(r100);
        ir8.a.f495491a.clear();
        c.f495501a.clear();
        c.f495502b.clear();
    }

    @Override // com.bytedance.ai.applet.app.AppletApplication
    public final Fragment t(Context r100, String r101, RouteOptions r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "url");
        FLogger r103 = FLogger.f375446a;
        r103.i("MusicGenerationAppletApplication", "onCreateView url=" + r101);
        if (z2.f365865a.V3() == true) goto L6;
        r103.i("MusicGenerationAppletApplication", "onCreateView ignored by experiment");
        f328887p = null;
        return null;
    L6:
        Bundle r104 = f328887p;
        if (r104 == null) goto L9;
        f328887p = null;
    L10:
        MusicAppletPage r105 = MusicAppletPage.Companion.a(r101, r104);
        if (r104 != null) goto L23;
        int r106 = b.f328888a[r105.ordinal()];
        if (r106 != 1) goto L15;
        r104 = IMusicAppletPageProvider.f370282a.a();
        goto L23
    L15:
        if (r106 != 2) goto L17;
    L21:
        r104 = null;
        goto L23
    L17:
        if (r106 == 3) goto L21;
        throw new NoWhenBranchMatchedException();
    L23:
        if (r104 != null) goto L27;
        r103.e("MusicGenerationAppletApplication", "onCreateView launch arguments are null, page=" + r105.getValue());
        return null;
    L27:
        return IMusicAppletPageProvider.f370282a.b(r101, r104);
    L9:
        r104 = null;
        goto L10
    }
}
