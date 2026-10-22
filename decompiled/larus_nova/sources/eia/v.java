package eia;

import android.content.Context;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class v {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f472819a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f472820b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f472821c;

    public static final class a {
    }

    static {
    }

    public abstract void a();

    public final boolean b() {
        laa.d r100 = (laa.d) this.f472819a.getValue();
        ObricFloatChatPageState r101 = null;
        if (r100 == null) goto L5;
        ObricFloatChatPageState r102 = r100.getPageState();
    L7:
        if (r102 == null) goto L14;
        FLogger.f375446a.i("BaseViewStrategy", "isLandscapeToPortrait: " + r102);
        ObricFloatChatPageData.a r103 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r104 = r102.getPreviousState();
        r103.getClass();
        if ((r104 instanceof vda.f) == false) goto L14;
        if ((r102 instanceof vda.f) == true) goto L14;
        boolean r105 = true;
    L15:
        FLogger r106 = FLogger.f375446a;
        r106.i("BaseViewStrategy", "isLandscapeToPortrait: " + r105);
        if (r105 == true) goto L31;
        laa.d r107 = (laa.d) this.f472819a.getValue();
        if (r107 == null) goto L21;
        r101 = r107.getPageState();
    L21:
        if (r101 == null) goto L28;
        r106.i("BaseViewStrategy", "isPortraitToLandscape: " + r101);
        ObricFloatChatPageData.a r108 = ObricFloatChatPageData.Companion;
        ObricFloatChatPageState r109 = r101.getPreviousState();
        r108.getClass();
        if ((r109 instanceof vda.f) == true) goto L28;
        if ((r101 instanceof vda.f) == false) goto L28;
        boolean r110 = true;
    L29:
        r106.i("BaseViewStrategy", "isPortraitToLandscape: " + r110);
        if (r110 == true) goto L31;
        return false;
    L28:
        r110 = false;
    L31:
        return true;
    L14:
        r105 = false;
        goto L15
    L5:
        r102 = null;
        goto L7
    }

    public v(Context r100, final t1a.b r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "vContext");
        this.f472819a = LazyKt.lazy(new s(r101));
        this.f472820b = LazyKt.lazy(new t(r101));
        this.f472821c = LazyKt.lazy(new u(this));
    }
}
