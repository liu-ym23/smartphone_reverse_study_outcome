package com.bytedance.ee.docsdk.impl.utils.keyboard;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider;
import com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProviderImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000b\u001a\u00020\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/keyboard/SharePopupKHProviderSelector;", "", "activity", "Landroid/app/Activity;", "sharedPopupWindow", "Landroid/widget/PopupWindow;", "sharedPopupWindowContentView", "Landroid/view/ViewGroup;", "(Landroid/app/Activity;Landroid/widget/PopupWindow;Landroid/view/ViewGroup;)V", "getActivity", "()Landroid/app/Activity;", "getProvider", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/provider/KeyboardHeightProvider;", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SharePopupKHProviderSelector {
    private final Activity activity;
    private final PopupWindow sharedPopupWindow;
    private final ViewGroup sharedPopupWindowContentView;

    public final KeyboardHeightProvider getProvider() {
        return new KeyboardHeightProviderImpl(this.activity);
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public SharePopupKHProviderSelector(Activity r100, PopupWindow r101, ViewGroup r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "sharedPopupWindow");
        Intrinsics.checkNotNullParameter(r102, "sharedPopupWindowContentView");
        this.activity = r100;
        this.sharedPopupWindow = r101;
        this.sharedPopupWindowContentView = r102;
    }
}
