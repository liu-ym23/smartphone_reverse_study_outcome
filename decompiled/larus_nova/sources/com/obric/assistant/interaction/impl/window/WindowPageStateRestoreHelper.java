package com.obric.assistant.interaction.impl.window;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.ability.PageStateChangedReason;
import com.obric.assistant.data.ObricFloatChatPageData;
import com.obric.assistant.data.ObricFloatChatPageState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\b\tJ\u0017\u0010\n\u001a\u00020\u000b2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0000¢\u0006\u0002\b\fJ)\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0012\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0013R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/obric/assistant/interaction/impl/window/WindowPageStateRestoreHelper;", "", "<init>", "()V", "TAG", "", "getRestoredPageStateName", "pageState", "Lcom/obric/assistant/data/ObricFloatChatPageState;", "getRestoredPageStateName$impl_mainlandRelease", "getRestoredPageStateHeight", "", "getRestoredPageStateHeight$impl_mainlandRelease", "restorePageState", "", "pageStateAbility", "Lcom/obric/assistant/ability/IObricChatPageStateAbility;", "pageStateName", "pageStateHeight", "restorePageState$impl_mainlandRelease", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WindowPageStateRestoreHelper {
    public static final WindowPageStateRestoreHelper INSTANCE = null;
    private static final String TAG = "WindowPageStateRestoreHelper";

    static {
        INSTANCE = new WindowPageStateRestoreHelper();
    }

    private WindowPageStateRestoreHelper() {
    }

    public final int getRestoredPageStateHeight$impl_mainlandRelease(ObricFloatChatPageState r100) {
        ObricFloatChatPageData.a r101 = ObricFloatChatPageData.Companion;
        r101.getClass();
        if ((r100 instanceof vda.e) == false) goto L6;
        if (r100 != null) goto L29;
        return 0;
    L29:
        return r100.getHeight();
    L6:
        r101.getClass();
        if ((r100 instanceof vda.c) == false) goto L30;
        Integer r102 = null;
        if (r100 == null) goto L11;
        ObricFloatChatPageState r103 = r100.getPreviousState();
    L12:
        r101.getClass();
        if ((r103 instanceof vda.e) == false) goto L31;
        if (r100 == null) goto L23;
        Integer r104 = Integer.valueOf(r100.getHeight());
        if (r104.intValue() <= 0) goto L18;
        boolean r105 = true;
    L19:
        if (r105 == false) goto L21;
        r102 = r104;
    L21:
        if (r102 == null) goto L23;
        return r102.intValue();
    L18:
        r105 = false;
    L23:
        if (r100 == null) goto L33;
        ObricFloatChatPageState r106 = r100.getPreviousState();
        if (r106 != null) goto L27;
        return 0;
    L27:
        return r106.getHeight();
    L33:
        return 0;
    L31:
        return 0;
    L11:
        r103 = null;
        goto L12
    L30:
        return 0;
    }

    public final String getRestoredPageStateName$impl_mainlandRelease(ObricFloatChatPageState r100) {
        ObricFloatChatPageData.a r101 = ObricFloatChatPageData.Companion;
        r101.getClass();
        if ((r100 instanceof vda.a) == false) goto L5;
        r101.getClass();
        return ObricFloatChatPageData.access$getCHAT_WINDOW_SIMPLE_NAME$cp();
    L5:
        r101.getClass();
        if ((r100 instanceof vda.e) == false) goto L8;
        r101.getClass();
        return ObricFloatChatPageData.access$getHALF_WINDOW_SIMPLE_NAME$cp();
    L8:
        r101.getClass();
        if ((r100 instanceof vda.c) == false) goto L16;
        if (r100 == null) goto L12;
        ObricFloatChatPageState r102 = r100.getPreviousState();
    L13:
        r101.getClass();
        if ((r102 instanceof vda.e) == false) goto L16;
        r101.getClass();
        return ObricFloatChatPageData.access$getHALF_WINDOW_SIMPLE_NAME$cp();
    L12:
        r102 = null;
    L16:
        r101.getClass();
        if ((r100 instanceof vda.f) == false) goto L19;
        r101.getClass();
        return ObricFloatChatPageData.access$getLANDSCAPE_FULL_WINDOW_SIMPLE_NAME$cp();
    L19:
        r101.getClass();
        if ((r100 instanceof vda.d) == false) goto L23;
        r101.getClass();
        return ObricFloatChatPageData.access$getFULL_SCREEN_SIMPLE_NAME$cp();
    L23:
        return null;
    }

    public final void restorePageState$impl_mainlandRelease(laa.d r110, String r111, int r112) {
        if (r110 != null) goto L6;
        FLogger.f375446a.w(TAG, "restorePageState skipped, pageStateAbility is null");
        return;
    L6:
        FLogger.f375446a.i(TAG, "restorePageState: pageStateName=" + r111 + ", height=" + r112);
        ObricFloatChatPageData.Companion.getClass();
        if (Intrinsics.areEqual(r111, ObricFloatChatPageData.access$getCHAT_WINDOW_SIMPLE_NAME$cp()) == false) goto L10;
        laa.d.a.a(r110, 0.0f, true, 1);
        return;
    L10:
        if (Intrinsics.areEqual(r111, ObricFloatChatPageData.access$getHALF_WINDOW_SIMPLE_NAME$cp()) == false) goto L15;
        if (r112 <= 0) goto L13;
        laa.d.a.d(r110, false, r112, null, false, true, PageStateChangedReason.RESTORE_STATE_FROM_DISMISS, 12);
        return;
    L13:
        r110.xw(ObricFloatChatPageData.access$getHALF_WINDOW_SIMPLE_NAME$cp(), true);
        return;
    L15:
        if (Intrinsics.areEqual(r111, ObricFloatChatPageData.access$getLANDSCAPE_FULL_WINDOW_SIMPLE_NAME$cp()) == false) goto L17;
    L18:
        r110.xw(r111, true);
        return;
    L17:
        if (Intrinsics.areEqual(r111, ObricFloatChatPageData.access$getFULL_SCREEN_SIMPLE_NAME$cp()) == true) goto L18;
    }
}
