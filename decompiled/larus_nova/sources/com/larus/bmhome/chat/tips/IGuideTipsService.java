package com.larus.bmhome.chat.tips;

import android.content.Context;
import android.view.View;
import com.bytedance.android.livesdkapi.app.AppConstants;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.larus.bmhome.actionbar.model.z0;
import com.larus.common_ui.popupwindow.AutoOffsetPopupWindow;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\bH&Jñ\u0001\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\u0016\b\u0002\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00182\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u001f\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\n\b\u0002\u0010%\u001a\u0004\u0018\u00010\bH&¢\u0006\u0002\u0010&J\u001e\u0010'\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018H&J\u0010\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020+H&J\u0012\u0010,\u001a\u00020\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH&J\n\u0010-\u001a\u0004\u0018\u00010.H&J\b\u0010/\u001a\u00020\u0005H&J\u0012\u00100\u001a\u00020\u00052\b\b\u0001\u0010\u0007\u001a\u00020\bH&J\u0012\u00101\u001a\u00020\u00032\b\b\u0001\u0010\u0007\u001a\u00020\bH&J\b\u00102\u001a\u00020\u0003H&¨\u00063"}, d2 = {"Lcom/larus/bmhome/chat/tips/IGuideTipsService;", "", "enableTips", "", "enable", "", "canShowTip", "tipType", "", "showTip", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", AppConstants.BUNDLE_TIP, "Lcom/larus/bmhome/chat/tips/GuideTip;", "anchorView", "Landroid/view/View;", "startMargin", "endMargin", "indicatorSpace", "windowGravity", "Lcom/larus/common_ui/popupwindow/AutoOffsetPopupWindow$WindowGravity;", "shadowSpace", "popYOff", SendEventContainerMethodParamModel.EventKinds.onShow, "Lkotlin/Function0;", "onDismiss", "Lkotlin/Function1;", "indicatorMarginLeft", "indicatorMarginRight", "onContentClick", "absoluteVerticalDistance", "isCloseCenter", "isRemoveDescMargin", "textColorString", "", "forceShow", "needIndicator", "descTvMaxWidth", "(Landroid/content/Context;Lcom/larus/bmhome/chat/tips/GuideTip;Landroid/view/View;IIILcom/larus/common_ui/popupwindow/AutoOffsetPopupWindow$WindowGravity;IILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;IILkotlin/jvm/functions/Function0;Ljava/lang/Integer;ZZLjava/lang/String;ZZLjava/lang/Integer;)Z", "showDialog", "showDialogAction", "getGuideTipType", "data", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "setGuideTipsShown", "getDebugGuideTipRepo", "Lcom/bytedance/keva/Keva;", "getDebugColdLaunchActionBarHasShowTip", "isGuideTipShown", "dismissTip", "clearMemoryGuideRedDot", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IGuideTipsService {

    public static final class a {
        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ boolean a(GuideTipsDelegate r210, Context r211, com.larus.bmhome.chat.tips.a r212, View r213, int r214, int r310, int r311, AutoOffsetPopupWindow.WindowGravity r312, int r313, int r314, Function1 r315, String r316, boolean r317, Integer r318, int r319) {
            if ((r319 & 256) == 0) goto L5;
            int r110 = 0;
        L7:
            if ((r319 & 1024) == 0) goto L9;
            Function1 r111 = null;
        L11:
            if ((131072 & r319) == 0) goto L13;
            String r215 = "";
        L15:
            if ((262144 & r319) == 0) goto L17;
            boolean r216 = false;
        L19:
            if ((524288 & r319) == 0) goto L21;
            boolean r217 = true;
        L23:
            if ((r319 & 1048576) == 0) goto L25;
            Integer r218 = null;
        L27:
            return r210.a(r211, r212, r213, r214, r310, r311, r312, r313, r110, null, r111, 0, 0, null, null, false, false, r215, r216, r217, r218);
        L25:
            r218 = r318;
            goto L27
        L21:
            r217 = false;
            goto L23
        L17:
            r216 = r317;
            goto L19
        L13:
            r215 = r316;
            goto L15
        L9:
            r111 = r315;
            goto L11
        L5:
            r110 = r314;
            goto L7
        }
    }

    boolean a(Context r100, com.larus.bmhome.chat.tips.a r101, View r102, int r103, int r104, int r105, AutoOffsetPopupWindow.WindowGravity r106, int r107, int r108, Function0<Unit> r110, Function1<? super Boolean, Unit> r111, int r112, int r113, Function0<Unit> r114, Integer r115, boolean r116, boolean r117, String r118, boolean r119, boolean r210, Integer r211);

    void b(@GuideTipType int r100);

    boolean c(@GuideTipType int r100);

    void d();

    void e(boolean r100);

    boolean f(@GuideTipType int r100);

    boolean g(com.larus.bmhome.chat.tips.a r100, Function0<Unit> r101);

    int h(z0 r100);
}
