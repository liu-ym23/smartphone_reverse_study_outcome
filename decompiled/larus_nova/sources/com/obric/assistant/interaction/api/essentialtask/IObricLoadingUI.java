package com.obric.assistant.interaction.api.essentialtask;

import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.ss.android.dypay.api.DyPayConstant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J7\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00030\rH&¢\u0006\u0002\u0010\u000eJ\b\u0010\u000f\u001a\u00020\u0003H&¨\u0006\u0010"}, d2 = {"Lcom/obric/assistant/interaction/api/essentialtask/IObricLoadingUI;", "", "hideAll", "", DyPayConstant.KEY_SHOW_LOADING, "loading", "", "showInfoWithButton", "info", "btnText", "infoImageResId", "", SendEventContainerMethodParamModel.EventKinds.onClick, "Lkotlin/Function0;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;)V", "onEssentialTaskFinish", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface IObricLoadingUI {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void showInfoWithButton$default(IObricLoadingUI r100, String r101, String r102, Integer r103, Function0 r104, int r105, Object r106) {
            if (r106 != null) goto L9;
            if ((r105 & 4) == 0) goto L6;
            r103 = null;
        L6:
            r100.showInfoWithButton(r101, r102, r103, r104);
            return;
        L9:
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showInfoWithButton");
        }
    }

    void hideAll();

    void onEssentialTaskFinish();

    void showInfoWithButton(String r100, String r101, Integer r102, Function0<Unit> r103);

    void showLoading(String r100);
}
