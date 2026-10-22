package com.obric.assistant.agent;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.android.ttcjpaysdk.bdpay.counter.outer.fallback.event.OuterPayFallbackReport;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003Jw\u0010\t\u001a\u00020\n2#\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\f2#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010\f2#\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\fH\u0016Jw\u0010\u0017\u001a\u00020\n2#\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\f2#\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\n\u0018\u00010\f2#\u0010\u0014\u001a\u001f\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\fH\u0016J+\u0010\u0018\u001a\u00020\n2!\u0010\u0019\u001a\u001d\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\n0\fH\u0016J\u001a\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0015H\u0016J\u001a\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0015H\u0016R\u001d\u0010\u0004\u001a\u0004\u0018\u00010\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\""}, d2 = {"Lcom/obric/assistant/agent/ObricAgentService;", "Lcom/obric/assistant/agent/IObricAgentApi;", "<init>", "()V", OuterPayFallbackReport.RETAIN_ACTION_IMP, "getImp", "()Lcom/obric/assistant/agent/IObricAgentApi;", "imp$delegate", "Lkotlin/Lazy;", "screenShot", "", "bitmapCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", SimplayerImageStrategy.RESULT_BITMAP, "uriCallback", "Landroid/net/Uri;", "uri", "errorCallback", "", "error", "screenShotForScreenPerception", NativeDownloadModel.JsonKey.WEB_URL, "callback", "url", "supplyDebugItemGroup", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "messageId", "supplyDebugItemTitle", "Landroidx/appcompat/widget/AppCompatTextView;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAgentService implements IObricAgentApi {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ObricAgentService f385580a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f385581b = null;

    private ObricAgentService() {
    }

    static {
        f385580a = new ObricAgentService();
        f385581b = LazyKt.lazy(new a());
    }

    @Override // com.obric.assistant.agent.IObricAgentApi
    public final LinearLayout b(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "messageId");
        IObricAgentApi r102 = (IObricAgentApi) f385581b.getValue();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.b(r100, r101);
    }

    @Override // com.obric.assistant.agent.IObricAgentApi
    public final AppCompatTextView c(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "messageId");
        IObricAgentApi r102 = (IObricAgentApi) f385581b.getValue();
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.c(r100, r101);
    }

    @Override // com.obric.assistant.agent.IObricAgentApi
    public final void a(Function1<? super Bitmap, Unit> r100, Function1<? super Uri, Unit> r101, Function1<? super String, Unit> r102) {
        IObricAgentApi r103 = (IObricAgentApi) f385581b.getValue();
        if (r103 == null) goto L6;
        r103.a(r100, r101, r102);
        return;
    }
}
