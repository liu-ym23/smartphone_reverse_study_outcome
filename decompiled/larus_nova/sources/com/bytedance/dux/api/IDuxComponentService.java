package com.bytedance.dux.api;

import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0007H&J\b\u0010\t\u001a\u00020\u0007H&J\b\u0010\n\u001a\u00020\u0007H&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0005H&J\b\u0010\r\u001a\u00020\u0007H&J\b\u0010\u000e\u001a\u00020\u0007H&JI\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00072!\u0010\u0015\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0017\u0012\b\b\u0018\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u00100\u0016H&J\u001c\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u001b2\u0006\u0010\f\u001a\u00020\u0005H&¨\u0006\u001c"}, d2 = {"Lcom/bytedance/dux/api/IDuxComponentService;", "", "getFoldStatus", "", "getHostGeckoAccessKey", "", "isCloseDoubleColorBallStartAfterAttachEnableFlag", "", "isCloseNewToastStyle", "isDebugMode", "isGridChangeRollbackEnable", "isOptimized", "componentId", "isPad", "readForceLTRFlag", "registerGridChangeListenerDowngrade", "", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "eventType", "performOnObserve", "listener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "pageWidth", "verifyLargeFontModeAdapt", "Lkotlin/Pair;", "dux_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface IDuxComponentService {
    int getFoldStatus();

    String getHostGeckoAccessKey();

    boolean isCloseDoubleColorBallStartAfterAttachEnableFlag();

    boolean isCloseNewToastStyle();

    boolean isDebugMode();

    boolean isGridChangeRollbackEnable();

    boolean isOptimized(String r100);

    boolean isPad();

    boolean readForceLTRFlag();

    void registerGridChangeListenerDowngrade(Fragment r100, String r101, boolean r102, Function1<? super Integer, Unit> r103);

    Pair<Boolean, Boolean> verifyLargeFontModeAdapt(String r100);
}
