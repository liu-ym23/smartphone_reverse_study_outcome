package com.ss.android.ugc.aweme.search.common.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostAppInfo;
import com.ss.android.ugc.aweme.search.hostapi.ITradeSearchHostService;
import com.ss.android.ugc.aweme.search.service.TradeSearch;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0004B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/utils/KeyboardUtils;", "", "<init>", "()V", "ClearCursorDecorator", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class KeyboardUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final KeyboardUtils f452258a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<ClearCursorDecorator> f452259b = null;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H\u0007¨\u0006\u0004"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/utils/KeyboardUtils$ClearCursorDecorator;", "Landroidx/lifecycle/LifecycleObserver;", "", LiveCommonConstants.REASON_ON_DEDTROY, "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
    public static final class ClearCursorDecorator implements LifecycleObserver {
        @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
        public final void onDestroy() {
            ((ArrayList) KeyboardUtils.f452259b).remove(this);
        }
    }

    private KeyboardUtils() {
    }

    static {
        f452258a = new KeyboardUtils();
        f452259b = new ArrayList(2);
        new ArrayList(2);
        DimenExtensionsKt.a(25);
    }

    public static void a(View r100) {
        ITradeSearchHostService r101 = TradeSearch.c(TradeSearch.f453393a);
        if (r101 == null) goto L17;
        ITradeSearchHostAppInfo r102 = r101.getITradeSearchHostAppInfo();
        if (r102 == null) goto L18;
        Context r103 = r102.getApplicationContext();
        if (r103 == null) goto L21;
        if (r100 == null) goto L19;
        Object r104 = r103.getSystemService("input_method");
        if ((r104 instanceof InputMethodManager) == false) goto L13;
        InputMethodManager r105 = (InputMethodManager) r104;
    L14:
        if (r105 == null) goto L20;
        r105.hideSoftInputFromWindow(r100.getWindowToken(), 0);
        return;
    L20:
        return;
    L13:
        r105 = null;
        goto L14
    L19:
        return;
    L21:
        return;
    L18:
        return;
    }
}
