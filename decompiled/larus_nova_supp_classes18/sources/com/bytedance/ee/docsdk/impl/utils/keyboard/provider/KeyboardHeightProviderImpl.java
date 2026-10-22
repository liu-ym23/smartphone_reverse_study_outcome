package com.bytedance.ee.docsdk.impl.utils.keyboard.provider;

import android.R;
import android.app.Activity;
import android.content.res.Configuration;
import android.view.View;
import com.bytedance.ee.docsdk.impl.utils.keyboard.KeyboardHeightObserver;
import com.bytedance.ee.docsdk.impl.utils.keyboard.producer.BaseKeyboardHeightProducer;
import com.bytedance.ee.docsdk.impl.utils.keyboard.producer.KeyboardHeightProducer;
import com.bytedance.ee.docsdk.impl.utils.keyboard.storage.KeyboardHeightSaver;
import com.bytedance.ee.docsdk.impl.utils.keyboard.utils.DeviceInfoUtils;
import com.bytedance.ee.docsdk.impl.utils.keyboard.utils.WindowModeUtils;
import com.ss.android.lark.chameleon.idependency.Log;
import com.ss.android.lark.chameleon.util.MainLooper;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\u0018\u0000 F2\u00020\u0001:\u0001FB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010)\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u001dH\u0016J\u0006\u0010*\u001a\u00020'J\u0010\u0010+\u001a\u00020\f2\u0006\u0010,\u001a\u00020\u0003H\u0016J\b\u0010-\u001a\u00020 H\u0016J\b\u0010.\u001a\u00020 H\u0002J\b\u0010/\u001a\u00020 H\u0016J\u000e\u00100\u001a\u00020'2\u0006\u00101\u001a\u00020\u0010J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020 H\u0016J\u0010\u00105\u001a\u00020 2\u0006\u00106\u001a\u00020 H\u0016J\u0010\u00107\u001a\u00020'2\u0006\u00108\u001a\u00020 H\u0002J\u0010\u00109\u001a\u00020'2\u0006\u00108\u001a\u00020 H\u0002J\u001a\u0010:\u001a\u00020'2\b\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u000203H\u0016J\u0012\u0010>\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010?\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010@\u001a\u00020'H\u0016J\u0017\u0010A\u001a\u00020'2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016¢\u0006\u0002\u0010DJ\u000e\u0010E\u001a\u00020'2\u0006\u00106\u001a\u00020 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001d0\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006G"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/keyboard/provider/KeyboardHeightProviderImpl;", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/provider/KeyboardHeightProvider;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "getActivity", "()Landroid/app/Activity;", "keyboardHeightProducer", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/producer/KeyboardHeightProducer;", "keyboardHeightSaver", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/storage/KeyboardHeightSaver;", "mActivityContentView", "Landroid/view/View;", "mAttachStateChangeListener", "Landroid/view/View$OnAttachStateChangeListener;", "mKeyboardData", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/producer/BaseKeyboardHeightProducer$KeyboardData;", "getMKeyboardData", "()Lcom/bytedance/ee/docsdk/impl/utils/keyboard/producer/BaseKeyboardHeightProducer$KeyboardData;", "setMKeyboardData", "(Lcom/bytedance/ee/docsdk/impl/utils/keyboard/producer/BaseKeyboardHeightProducer$KeyboardData;)V", "mNotifyKHChangedTask", "Ljava/lang/Runnable;", "getMNotifyKHChangedTask", "()Ljava/lang/Runnable;", "setMNotifyKHChangedTask", "(Ljava/lang/Runnable;)V", "mObserverList", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lcom/bytedance/ee/docsdk/impl/utils/keyboard/KeyboardHeightObserver;", "mObserverNoDelayList", "mOrientation", "", "getMOrientation", "()I", "setMOrientation", "(I)V", "mRealScreenHeight", "addKeyboardHeightObserver", "", "observer", "addKeyboardHeightObserverNoDelay", "close", "createContentView", "mActivity", "getKeyboardTop", "getMinSaveHeight", "getVisibleKeyboardHeight", "handleKeyboardHeightChanged", "keyboard", "isKeyboardShowing", "", "keyBoardRawHeight", "keyBoardRawHeightWithOrientation", "orientation", "notifyKeyboardHeightChanged", "height", "notifyKeyboardHeightChangedNoDelay", "onConfigurationChanged", "newConfiguration", "Landroid/content/res/Configuration;", "handleChanged", "removeKeyboardHeightObserver", "removeKeyboardHeightObserverNoDelay", "restart", "setDelayedDuration", "during", "", "(Ljava/lang/Long;)V", "setOrientation", "Companion", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class KeyboardHeightProviderImpl implements KeyboardHeightProvider {
    public static final Companion Companion = null;
    private static final int HARD_KEYBOARD_HEIGHT = 1;
    private static final long NOTIFY_DELAY_MIN_TIME = 60;
    private static final String TAG = "InsetsBseKBH#Provider";
    private final Activity activity;
    private KeyboardHeightProducer keyboardHeightProducer;
    private final KeyboardHeightSaver keyboardHeightSaver;
    private View mActivityContentView;
    private View.OnAttachStateChangeListener mAttachStateChangeListener;
    private BaseKeyboardHeightProducer.KeyboardData mKeyboardData;
    private Runnable mNotifyKHChangedTask;
    private final CopyOnWriteArrayList<KeyboardHeightObserver> mObserverList;
    private final CopyOnWriteArrayList<KeyboardHeightObserver> mObserverNoDelayList;
    private int mOrientation;
    private int mRealScreenHeight;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/bytedance/ee/docsdk/impl/utils/keyboard/provider/KeyboardHeightProviderImpl$Companion;", "", "()V", "HARD_KEYBOARD_HEIGHT", "", "NOTIFY_DELAY_MIN_TIME", "", "TAG", "", "docs-sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(KeyboardHeightProviderImpl r0) {
        mNotifyKHChangedTask$lambda$0(r0);
    }

    private final int getMinSaveHeight() {
        if (this.mOrientation != 2) goto L5;
        return 200;
    L5:
        return 250;
    }

    public final void close() {
        MainLooper.removeCallbacks(this.mNotifyKHChangedTask);
        this.keyboardHeightProducer.close();
        this.mKeyboardData = null;
        this.mObserverList.clear();
        this.mObserverNoDelayList.clear();
        this.mActivityContentView.removeOnAttachStateChangeListener(this.mAttachStateChangeListener);
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider
    public int getKeyboardTop() {
        return this.keyboardHeightProducer.getKeyboardTop();
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider
    public int getVisibleKeyboardHeight() {
        BaseKeyboardHeightProducer.KeyboardData r0 = this.mKeyboardData;
        if (r0 != null) goto L7;
        return 0;
    L7:
        return r0.getImeHeight();
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider
    public boolean isKeyboardShowing() {
        BaseKeyboardHeightProducer.KeyboardData r0 = this.mKeyboardData;
        if (r0 == null) goto L10;
        if (r0 == null) goto L6;
        int r1 = r0.getImeHeight();
    L7:
        if (r1 <= 0) goto L11;
        return true;
    L11:
        return false;
    L6:
        r1 = 0;
        goto L7
    L10:
        return false;
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider
    public int keyBoardRawHeight() {
        return keyBoardRawHeightWithOrientation(this.mOrientation);
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider
    public void restart() {
        this.keyboardHeightProducer.restart();
    }

    public final Activity getActivity() {
        return this.activity;
    }

    public final BaseKeyboardHeightProducer.KeyboardData getMKeyboardData() {
        return this.mKeyboardData;
    }

    public final Runnable getMNotifyKHChangedTask() {
        return this.mNotifyKHChangedTask;
    }

    public final int getMOrientation() {
        return this.mOrientation;
    }

    public KeyboardHeightProviderImpl(Activity r5) {
        Intrinsics.checkNotNullParameter(r5, "activity");
        this.activity = r5;
        KeyboardHeightSaver r0 = new KeyboardHeightSaver(r5);
        this.keyboardHeightSaver = r0;
        this.mOrientation = 1;
        this.mObserverList = new CopyOnWriteArrayList();
        this.mObserverNoDelayList = new CopyOnWriteArrayList();
        this.mNotifyKHChangedTask = new a(this);
        this.mRealScreenHeight = DeviceInfoUtils.getVariableRealScreenHeight(r5);
        this.mActivityContentView = createContentView(r5);
        KeyboardHeightProducer r1 = new KeyboardHeightProducer(r5, this.mActivityContentView, new AnonymousClass1(this));
        this.keyboardHeightProducer = r1;
        r1.init();
        r0.setScreenHeight(this.mRealScreenHeight);
        this.mOrientation = r5.getResources().getConfiguration().orientation;
        View.OnAttachStateChangeListener r6 = new AnonymousClass2(this);
        this.mAttachStateChangeListener = r6;
        this.mActivityContentView.addOnAttachStateChangeListener(r6);
    }

    public static final /* synthetic */ KeyboardHeightProducer access$getKeyboardHeightProducer$p(KeyboardHeightProviderImpl r0) {
        return r0.keyboardHeightProducer;
    }

    private static final void mNotifyKHChangedTask$lambda$0(KeyboardHeightProviderImpl r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        if (r4.activity.isDestroyed() == false) goto L5;
    L13:
        Log.i(TAG, "mNotifyKHChangedTask err = activity isDestroyed or isFinishing");
        return;
    L5:
        if (r4.activity.isFinishing() == true) goto L13;
        BaseKeyboardHeightProducer.KeyboardData r0 = r4.mKeyboardData;
        if (r0 == null) goto L10;
        int r1 = r0.getImeHeight();
    L11:
        Log.i(TAG, "mNotifyKHChangedTask run imeHeight = " + r1);
        r4.notifyKeyboardHeightChanged(r1);
        return;
    L10:
        r1 = 0;
        goto L11
    }

    private final void notifyKeyboardHeightChanged(int r4) {
        Log.i(TAG, "keyboard height provider notify: " + r4 + ", " + this.mOrientation);
        Iterator<KeyboardHeightObserver> r0 = this.mObserverList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        KeyboardHeightObserver r1 = r0.next();
        if (r1 == null) goto L4;
        r1.onKeyboardHeightChanged(this, r4, this.mOrientation);
        goto L4
    }

    private final void notifyKeyboardHeightChangedNoDelay(int r4) {
        Log.i(TAG, "keyboard height provider notify: " + r4 + ", " + this.mOrientation);
        Iterator<KeyboardHeightObserver> r0 = this.mObserverNoDelayList.iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        KeyboardHeightObserver r1 = r0.next();
        if (r1 == null) goto L4;
        r1.onKeyboardHeightChanged(this, r4, this.mOrientation);
        goto L4
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider
    public void addKeyboardHeightObserver(KeyboardHeightObserver r2) {
        if (this.mObserverList.contains(r2) == true) goto L6;
        this.mObserverList.add(r2);
        return;
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider
    public void addKeyboardHeightObserverNoDelay(KeyboardHeightObserver r2) {
        if (this.mObserverNoDelayList.contains(r2) == true) goto L6;
        this.mObserverNoDelayList.add(r2);
        return;
    }

    public View createContentView(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "mActivity");
        return r2.findViewById(R.id.content);
    }

    public final void handleKeyboardHeightChanged(BaseKeyboardHeightProducer.KeyboardData r5) {
        Intrinsics.checkNotNullParameter(r5, "keyboard");
        this.mKeyboardData = r5;
        int r0 = r5.getImeHeight();
        MainLooper.postDelayed(this.mNotifyKHChangedTask, NOTIFY_DELAY_MIN_TIME);
        notifyKeyboardHeightChangedNoDelay(r0);
        if (r5.isVisible() == true) goto L5;
        return;
    L5:
        if (r0 <= getMinSaveHeight()) goto L9;
        this.keyboardHeightSaver.saveKeyboardHeight(r0, this.mOrientation);
        return;
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider
    public int keyBoardRawHeightWithOrientation(int r5) {
        int r6 = this.keyboardHeightSaver.loadKeyboardHeight(r5);
        if (r6 <= 1) goto L5;
        return r6;
    L5:
        if (WindowModeUtils.INSTANCE.isInFreeFromMode() == true) goto L7;
        return r6;
    L7:
        return (int) (((double) this.mRealScreenHeight) * 0.3d);
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider
    public void removeKeyboardHeightObserver(KeyboardHeightObserver r2) {
        this.mObserverList.remove(r2);
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider
    public void removeKeyboardHeightObserverNoDelay(KeyboardHeightObserver r2) {
        this.mObserverNoDelayList.remove(r2);
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider
    public void setDelayedDuration(Long r2) {
        this.keyboardHeightProducer.setMDelayedDuration(r2);
    }

    public final void setMKeyboardData(BaseKeyboardHeightProducer.KeyboardData r1) {
        this.mKeyboardData = r1;
    }

    public final void setMNotifyKHChangedTask(Runnable r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mNotifyKHChangedTask = r2;
    }

    public final void setMOrientation(int r1) {
        this.mOrientation = r1;
    }

    public final void setOrientation(int r1) {
        this.mOrientation = r1;
    }

    @Override // com.bytedance.ee.docsdk.impl.utils.keyboard.provider.KeyboardHeightProvider
    public void onConfigurationChanged(Configuration r2, boolean r3) {
        this.keyboardHeightProducer.configurationChanged(r2, r3);
        int r4 = DeviceInfoUtils.getVariableRealScreenHeight(this.activity);
        this.mRealScreenHeight = r4;
        this.keyboardHeightSaver.setScreenHeight(r4);
        if (r2 == null) goto L5;
        int r5 = r2.orientation;
    L6:
        setOrientation(r5);
        return;
    L5:
        r5 = 1;
        goto L6
    }
}
