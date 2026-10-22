package com.bytedance.ee.docsdk.impl.utils.keyboard.producer;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.view.View;
import android.widget.PopupWindow;
import androidx.core.view.ViewCompat;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.ee.docsdk.impl.utils.keyboard.KeyboardHeightProviderFactory;
import com.bytedance.ee.docsdk.impl.utils.keyboard.utils.DeviceInfoUtils;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.MainLooper;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 /2\u00020\u0001:\u0002/0B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000fH\u0002J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0014J\u0006\u0010\"\u001a\u00020#J\b\u0010$\u001a\u00020\u0018H\u0016J\u000e\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u000fJ\u0010\u0010'\u001a\u00020\u00182\u0006\u0010&\u001a\u00020\u000fH\u0016J\u0010\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020#H\u0016J\u0006\u0010*\u001a\u00020\u0018J\u0010\u0010+\u001a\u00020\u00182\u0006\u0010,\u001a\u00020\u001eH\u0002J\u0006\u0010-\u001a\u00020\u0018J\b\u0010.\u001a\u00020\u0018H\u0016R\u000e\u0010\t\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/keyboard/producer/KeyboardHeightProducer;", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/producer/BaseKeyboardHeightProducer;", "activity", "Landroid/app/Activity;", "activityContentView", "Landroid/view/View;", "listener", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/producer/KeyboardHeightProducer$KeyboardHeightChangedListener;", "(Landroid/app/Activity;Landroid/view/View;Lcom/bytedance/ee/docsdk/impl/utils/keyboard/producer/KeyboardHeightProducer$KeyboardHeightChangedListener;)V", "mActivityContentView", "mHandleChanged", "", "mIsConfigurationChanged", "mIsNotifyNot0", "mLastNotifyKeyboardData", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/producer/BaseKeyboardHeightProducer$KeyboardData;", "mListener", "mNewKeyboardData", "mNotifyTask", "Ljava/lang/Runnable;", "mTask", "canNotifyWhenConfigurationChanged", "keyboard", "close", "", "configurationChanged", "newConfiguration", "Landroid/content/res/Configuration;", "handleChanged", "createPopupWindow", "Landroid/widget/PopupWindow;", "context", "Landroid/content/Context;", "contentView", "getKeyboardTop", "", "init", "notify", WikiFolderPushPlugin.DATA, "notifyFromInsert", "notifyFromInvoke", "imeHeight", "requestPopupWindowLayout", "resetPopupWindowFlags", "popupWindow", "restart", "start", "Companion", "KeyboardHeightChangedListener", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KeyboardHeightProducer extends BaseKeyboardHeightProducer {
    public static final Companion Companion = null;
    public static final int MIN_KEYBOARD_HEIGHT = 300;
    private static final long RESET_CONFIGURATION_DELAY_TIME = 1000;
    private static final String TAG = "InsetsKBH#Producer";
    private View mActivityContentView;
    private boolean mHandleChanged;
    private boolean mIsConfigurationChanged;
    private boolean mIsNotifyNot0;
    private BaseKeyboardHeightProducer.KeyboardData mLastNotifyKeyboardData;
    private final KeyboardHeightChangedListener mListener;
    private BaseKeyboardHeightProducer.KeyboardData mNewKeyboardData;
    private final Runnable mNotifyTask;
    private final Runnable mTask;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/keyboard/producer/KeyboardHeightProducer$Companion;", "", "()V", "MIN_KEYBOARD_HEIGHT", "", "RESET_CONFIGURATION_DELAY_TIME", "", "TAG", "", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/keyboard/producer/KeyboardHeightProducer$KeyboardHeightChangedListener;", "", "keyboardChanged", "", "keyboard", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/producer/BaseKeyboardHeightProducer$KeyboardData;", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface KeyboardHeightChangedListener {
        void keyboardChanged(BaseKeyboardHeightProducer.KeyboardData r1);
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void b(KeyboardHeightProducer r0) {
        mTask$lambda$0(r0);
    }

    public static /* synthetic */ void c(KeyboardHeightProducer r0) {
        mNotifyTask$lambda$2(r0);
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer
    public void close() {
        Log.i(TAG, "close");
        super.close();
        MainLooper.removeCallbacks(this.mTask);
        MainLooper.removeCallbacks(this.mNotifyTask);
        ViewCompat.setOnApplyWindowInsetsListener(getMPopupView().getRootView(), null);
        INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_keyboard_producer_KeyboardHeightProducer_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(getMPopupWindow());
        KeyboardHeightProviderFactory.removeCache(getMActivity());
    }

    public final int getKeyboardTop() {
        Rect r0 = new Rect();
        getMPopupView().getWindowVisibleDisplayFrame(r0);
        return r0.bottom;
    }

    public final void restart() {
        if (this.mActivityContentView.isAttachedToWindow() == true) goto L6;
        return;
    L6:
        if (getMPopupWindow().isShowing() == true) goto L9;
        start();
        return;
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer
    public void start() {
        Log.i(TAG, "start");
        showPopupWindow(this.mActivityContentView);
        View r0 = getMPopupWindow().getContentView();
        ViewCompat.setOnApplyWindowInsetsListener(r0.getRootView(), null);
        View r1 = r0.getRootView();
        if (r1 == null) goto L6;
        insertsImpl(r1);
        return;
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer
    public void init() {
        super.init();
        if (this.mActivityContentView.isAttachedToWindow() == false) goto L6;
        start();
        return;
    }

    public final void requestPopupWindowLayout() {
        getMPopupView().requestApplyInsets();
    }

    public static void INVOKEVIRTUAL_com_bytedance_ee_docsdk_impl_utils_keyboard_producer_KeyboardHeightProducer_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_dismiss(PopupWindow r0) {
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    }

    private final boolean canNotifyWhenConfigurationChanged(BaseKeyboardHeightProducer.KeyboardData r6) {
        Log.i(TAG, "configurationChanged: " + this.mIsConfigurationChanged + "; mHandleChanged: " + this.mHandleChanged);
        if (this.mIsConfigurationChanged == true) goto L5;
    L15:
        this.mLastNotifyKeyboardData = r6;
        return true;
    L5:
        if (this.mHandleChanged == true) goto L15;
        int r7 = r6.getImeHeight();
        BaseKeyboardHeightProducer.KeyboardData r0 = this.mLastNotifyKeyboardData;
        if (r0 == null) goto L9;
        int r1 = r0.getImeHeight();
    L11:
        if (r7 <= 300) goto L13;
        this.mIsConfigurationChanged = false;
        return true;
    L13:
        Log.i(TAG, "not notify, reason: newKeyboardHeight = " + r7 + "; lastNotifyKeyboardHeight = " + r1);
        return false;
    L9:
        r1 = 0;
        goto L11
    }

    private static final void mNotifyTask$lambda$2(KeyboardHeightProducer r3) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        BaseKeyboardHeightProducer.KeyboardData r0 = r3.mNewKeyboardData;
        if (r0 == null) goto L6;
        Log.i(TAG, "notify keyboardChanged " + r3.mNewKeyboardData);
        r3.mListener.keyboardChanged(r0);
        return;
    }

    private static final void mTask$lambda$0(KeyboardHeightProducer r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        r1.mIsConfigurationChanged = false;
    }

    private final void resetPopupWindowFlags(PopupWindow r6) {
        Log.i(TAG, "resetPopupWindowFlags!");     // Catch: Exception -> L5
        Field r1 = PopupWindow.class.getDeclaredField("mLayoutInScreen");     // Catch: Exception -> L5
        r1.setAccessible(true);     // Catch: Exception -> L5
        Boolean r3 = Boolean.TRUE;     // Catch: Exception -> L5
        r1.set(r6, r3);     // Catch: Exception -> L5
        Field r2 = PopupWindow.class.getDeclaredField("mLayoutInsetDecor");     // Catch: Exception -> L5
        r2.setAccessible(true);     // Catch: Exception -> L5
        r2.set(r6, r3);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        Log.e(TAG, String.valueOf(e));
    }

    public final void notify(BaseKeyboardHeightProducer.KeyboardData r4) {
        Intrinsics.checkNotNullParameter(r4, WikiFolderPushPlugin.DATA);
        if (getMDelayedDuration() == null) goto L7;
        this.mNewKeyboardData = r4;
        MainLooper.removeCallbacks(this.mNotifyTask);
        Long r5 = getMDelayedDuration();
        if (r5 == null) goto L9;
        long r0 = r5.longValue();
        Log.i(TAG, "notify Delayed " + getMDelayedDuration() + ' ');
        MainLooper.postDelayed(this.mNotifyTask, r0);
        return;
    L9:
        return;
    L7:
        this.mListener.keyboardChanged(r4);
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer
    public void notifyFromInsert(BaseKeyboardHeightProducer.KeyboardData r3) {
        Intrinsics.checkNotNullParameter(r3, WikiFolderPushPlugin.DATA);
        Log.i(TAG, "notifyFromInsert keyboard = " + r3);
        if (r3.getImeHeight() != 0) goto L9;
        if (this.mIsNotifyNot0 == true) goto L9;
        Log.i(TAG, "not notify, reason: mIsNotifyNot0 = false");
        return;
    L9:
        if (canNotifyWhenConfigurationChanged(r3) == true) goto L11;
        return;
    L11:
        notify(r3);
        if (r3.getImeHeight() == 0) goto L14;
        boolean r4 = true;
    L15:
        this.mIsNotifyNot0 = r4;
        return;
    L14:
        r4 = false;
        goto L15
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer
    public void notifyFromInvoke(int r5) {
        BaseKeyboardHeightProducer.KeyboardData r1 = new BaseKeyboardHeightProducer.KeyboardData(r5, DeviceInfoUtils.getNavigationBarHeight(getMActivity().getBaseContext()), 0, true);
        if (r5 >= 300) goto L5;
        r1.setVisible(false);
    L5:
        Log.i(TAG, "notifyFromInvoke keyboard = " + r1);
        notify(r1);
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer
    public void configurationChanged(Configuration r3, boolean r4) {
        super.configurationChanged(r3, r4);
        this.mHandleChanged = r4;
        this.mIsConfigurationChanged = true;
        MainLooper.postDelayed(this.mTask, 1000);
        restart();
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer
    public PopupWindow createPopupWindow(Context r2, View r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "contentView");
        PopupWindow r4 = defaultPopupWindow(r2, r3);
        resetPopupWindowFlags(r4);
        return r4;
    }

    public KeyboardHeightProducer(Activity r2, View r3, KeyboardHeightChangedListener r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "activityContentView");
        Intrinsics.checkNotNullParameter(r4, "listener");
        super(r2);
        this.mActivityContentView = r3;
        this.mListener = r4;
        this.mTask = new b(this);
        this.mNotifyTask = new c(this);
    }
}
