package com.obric.assistant.agent;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.ss.android.downloadad.api.model.NativeDownloadModel;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J}\u0010\u0002\u001a\u00020\u00032%\b\u0002\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052%\b\u0002\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H&J}\u0010\u0010\u001a\u00020\u00032%\b\u0002\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052%\b\u0002\u0010\n\u001a\u001f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00052%\b\u0002\u0010\r\u001a\u001f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005H&J+\u0010\u0011\u001a\u00020\u00032!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00030\u0005H&J\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eH&J\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u000eH&¨\u0006\u001b"}, d2 = {"Lcom/obric/assistant/agent/IObricAgentApi;", "", "screenShot", "", "bitmapCallback", "Lkotlin/Function1;", "Landroid/graphics/Bitmap;", "Lkotlin/ParameterName;", "name", SimplayerImageStrategy.RESULT_BITMAP, "uriCallback", "Landroid/net/Uri;", "uri", "errorCallback", "", "error", "screenShotForScreenPerception", NativeDownloadModel.JsonKey.WEB_URL, "callback", "url", "supplyDebugItemTitle", "Landroidx/appcompat/widget/AppCompatTextView;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "messageId", "supplyDebugItemGroup", "Landroid/widget/LinearLayout;", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricAgentApi {
    void a(Function1<? super Bitmap, Unit> r100, Function1<? super Uri, Unit> r101, Function1<? super String, Unit> r102);

    LinearLayout b(Context r100, String r101);

    AppCompatTextView c(Context r100, String r101);
}
