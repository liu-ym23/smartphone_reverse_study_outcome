package com.obric.assistant;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Toast;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.product.platform.api.pocketmode.PocketModeDetector;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.base.model.AssistantActivityExpandState;
import com.obric.assistant.reporter.IObricReporter;
import com.obric.assistant.spi.common.IObricUtilService;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\tH\u0016J \u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0016¢\u0006\u0002\u0010\u0017J\b\u0010\u0018\u001a\u00020\u0012H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\f\u0010\u001a\u001a\u00020\u0012*\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/obric/assistant/ObricUtilServiceImpl;", "Lcom/obric/assistant/spi/common/IObricUtilService;", "<init>", "()V", "pocketModeDetector", "Lcom/obric/aiagent/product/platform/api/pocketmode/PocketModeDetector;", "getLaunchMethod", "", "checkAsync", "", "isCheckPassed", "", "onUserActionBlocked", "showToastIfAppIsBackground", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "toast", "duration", "", "isImeLaunchedByApp", "viewGroup", "Landroid/view/ViewGroup;", "physicalScreenWidthPixels", "(Landroid/content/Context;)Ljava/lang/Integer;", "getPassportSdkVersion", "isDarkModeDefaultFollowSys", "getStableScreenWidth", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricUtilServiceImpl implements IObricUtilService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f385197b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PocketModeDetector f385198a;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.spi.common.IObricUtilService
    public final boolean e() {
        return true;
    }

    @Override // com.obric.assistant.spi.common.IObricUtilService
    public final int f() {
        return 60592;
    }

    @Override // com.obric.assistant.spi.common.IObricUtilService
    public final String a() {
        IObricReporter.f391335a.getClass();
        IObricReporter r100 = IObricReporter.a.a();
        if (r100 == null) goto L6;
        String r101 = r100.a();
        if (r101 == null) goto L6;
        return r101;
    L6:
        return "other";
    }

    @Override // com.obric.assistant.spi.common.IObricUtilService
    public final void b() {
        this.f385198a.b();
    }

    @Override // com.obric.assistant.spi.common.IObricUtilService
    public final boolean c() {
        return this.f385198a.c();
    }

    @Override // com.obric.assistant.spi.common.IObricUtilService
    public final void g() {
        boolean r100 = AppHost.f326268a.a().isAppBackground();
        this.f385198a.f(true, r100, new j4());
    }

    public ObricUtilServiceImpl() {
        this.f385198a = PocketModeDetector.f385009a;
    }

    @Override // com.obric.assistant.spi.common.IObricUtilService
    public final Integer h(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Object r101 = r100.getSystemService(LiveEndPageData.TAG_WINDOW);
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type android.view.WindowManager");
        Display r102 = ((WindowManager) r101).getDefaultDisplay();
        DisplayMetrics r103 = new DisplayMetrics();
        r102.getRealMetrics(r103);
        if (r102.getRotation() != 0) goto L5;
    L8:
        int r104 = r103.widthPixels;
    L10:
        return Integer.valueOf(r104);
    L5:
        if (r102.getRotation() == 2) goto L8;
        r104 = r103.heightPixels;
        goto L10
    }

    @Override // com.obric.assistant.spi.common.IObricUtilService
    public final boolean d(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "toast");
        if (AppHost.f326268a.a().isAppBackground() == false) goto L6;
        FLogger.f375446a.i("ObricUtilServiceImpl", "showToastIfAppIsBackground: app is background");
        Toast.makeText(r100, r101, 0).show();
        return true;
    L6:
        AssistantActivityExpandState r102 = IAssistantInteractionServiceKt.getInteractionStateService().getInteractionActivityExpandState();
        if (r102 != AssistantActivityExpandState.INVISIBLE) goto L10;
        FLogger.f375446a.i("ObricUtilServiceImpl", "showToastIfAppIsBackground: assistant activity is " + r102);
        Toast.makeText(r100, r101, 0).show();
        return true;
    L10:
        return false;
    }
}
