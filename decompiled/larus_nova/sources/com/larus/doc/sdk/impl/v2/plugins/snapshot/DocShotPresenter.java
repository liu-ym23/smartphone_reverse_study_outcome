package com.larus.doc.sdk.impl.v2.plugins.snapshot;

import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.google.gson.JsonObject;
import com.larus.utils.logger.FLogger;
import com.larus.utils.t0;
import com.ss.android.lark.chameleon.util.SafeJSExecutor;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n39.h;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 :2\u00020\u0001:\u000389:B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dJ\u000e\u0010 \u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001bJ\u001a\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020\u000b2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\b\u0010%\u001a\u00020\u000bH\u0016J\b\u0010&\u001a\u00020\u000fH\u0016J\u0012\u0010'\u001a\u00020\u000f2\b\u0010(\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010)\u001a\u00020\u000fH\u0002J\b\u0010*\u001a\u00020\u000fH\u0016J\u001c\u0010+\u001a\u00020\u000f2\b\u0010,\u001a\u0004\u0018\u00010-2\b\u0010#\u001a\u0004\u0018\u00010$H\u0016J\u0012\u0010.\u001a\u00020\u000f2\b\u0010/\u001a\u0004\u0018\u00010-H\u0016J\b\u00100\u001a\u00020\u000fH\u0016J\b\u00101\u001a\u00020\u000fH\u0016J\u001a\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010\u0012H\u0003J\b\u00104\u001a\u00020\u000fH\u0002J\u0010\u00105\u001a\u00020\u000f2\u0006\u00106\u001a\u000207H\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotPresenter;", "Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/IDocShotPresenter;", "mActivity", "Landroidx/fragment/app/FragmentActivity;", "mInputViewHeight", "", "<init>", "(Landroidx/fragment/app/FragmentActivity;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "mIsActive", "Landroidx/lifecycle/MutableLiveData;", "", "mH5QuitShotTimeoutRunnable", "Ljava/lang/Runnable;", "setIsActive", "", "isActive", "mWebView", "Landroid/webkit/WebView;", "mLastScrollY", "isBackPressed", "()Z", "setBackPressed", "(Z)V", "mJsReadyTime", "", "mSnapshotResultListener", "Lcom/larus/doc/sdk/api/IDocSnapshotResultListener;", "mOnBackPressListener", "Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotPresenter$OnBackPressListener;", "setOnBackPressListener", "listener", "setSnapShotResultListener", "docShotReady", "success", "docShotModel", "Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotModel;", "onBackPressed", "docShotH5Exit", "startDocShot", "webView", "scrollToLastPosition", "docShotNotSupport", "docShotFail", "errorInfo", "", "docShotSuccess", "path", "shareDocShot", "saveDocShot", "notifyJScreenShot", "state", "onShareDoc", "onSaveDocBitmap", "callback", "Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotPresenter$ISaveDocCallback;", "ISaveDocCallback", "OnBackPressListener", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocShotPresenter implements IDocShotPresenter {
    public static final Companion Companion = null;
    public static final int SCREEN_SHOT_END = 1;
    public static final int SCREEN_SHOT_START = 0;
    private static final String TAG = "DocShotPresenter";
    private boolean isBackPressed;
    private final FragmentActivity mActivity;
    private Runnable mH5QuitShotTimeoutRunnable;
    private final Integer mInputViewHeight;
    private final MutableLiveData<Boolean> mIsActive;
    private long mJsReadyTime;
    private int mLastScrollY;
    private OnBackPressListener mOnBackPressListener;
    private h mSnapshotResultListener;
    private WebView mWebView;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotPresenter$Companion;", "", "<init>", "()V", "TAG", "", "SCREEN_SHOT_START", "", "SCREEN_SHOT_END", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotPresenter$ISaveDocCallback;", "", "onSaveDocFinished", "", "success", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface ISaveDocCallback {
        void onSaveDocFinished(boolean r100);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lcom/larus/doc/sdk/impl/v2/plugins/snapshot/DocShotPresenter$OnBackPressListener;", "", com.alipay.sdk.m.x.d.f25924n, "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface OnBackPressListener {
        void onBack();
    }

    static {
        Companion = new Companion(null);
    }

    @Override // com.larus.doc.sdk.impl.v2.plugins.snapshot.IDocShotPresenter
    public void docShotNotSupport() {
        setIsActive(false);
        scrollToLastPosition();
        notifyJScreenShot(1, this.mWebView);
    }

    @Override // com.larus.doc.sdk.impl.v2.plugins.snapshot.IDocShotPresenter
    public boolean onBackPressed() {
        setIsActive(false);
        FLogger.f375446a.i(TAG, "onBackPressed()...");
        this.isBackPressed = true;
        notifyJScreenShot(1, this.mWebView);
        OnBackPressListener r100 = this.mOnBackPressListener;
        if (r100 == null) goto L5;
        r100.onBack();
    L5:
        return false;
    }

    private final void onShareDoc() {
        FLogger.f375446a.d(TAG, "onShareDoc()...");
    }

    private final void scrollToLastPosition() {
        WebView r100 = this.mWebView;
        if (r100 == null) goto L6;
        r100.scrollTo(0, this.mLastScrollY);
        return;
    }

    @Override // com.larus.doc.sdk.impl.v2.plugins.snapshot.IDocShotPresenter
    public void docShotH5Exit() {
        Runnable r100 = this.mH5QuitShotTimeoutRunnable;
        if (r100 == null) goto L5;
        t0.f375468a.removeCallbacks(r100);
    L5:
        this.mH5QuitShotTimeoutRunnable = null;
    }

    @Override // com.larus.doc.sdk.impl.v2.plugins.snapshot.IDocShotPresenter
    public void saveDocShot() {
        onSaveDocBitmap(new AnonymousClass1());
    }

    public final boolean isBackPressed() {
        return this.isBackPressed;
    }

    @Override // com.larus.doc.sdk.impl.v2.plugins.snapshot.IDocShotPresenter
    public void shareDocShot() {
        onShareDoc();
    }

    private final void onSaveDocBitmap(ISaveDocCallback r100) {
        FLogger.f375446a.i(TAG, "onSaveDocBitmap()....");
        new ArrayList().add("android.permission.WRITE_EXTERNAL_STORAGE");
    }

    private final void setIsActive(boolean r100) {
        this.mIsActive.setValue(Boolean.valueOf(r100));
    }

    @Override // com.larus.doc.sdk.impl.v2.plugins.snapshot.IDocShotPresenter
    public void docShotSuccess(String r100) {
        scrollToLastPosition();
        FLogger.f375446a.i(TAG, "docShotSuccess()..");
        notifyJScreenShot(1, this.mWebView);
        if (r100 == null) goto L8;
        h r101 = this.mSnapshotResultListener;
        if (r101 == null) goto L9;
        r101.onSnapshotSuccess(r100);
        return;
    L9:
        return;
    }

    public final void setBackPressed(boolean r100) {
        this.isBackPressed = r100;
    }

    public final void setOnBackPressListener(OnBackPressListener r100) {
        this.mOnBackPressListener = r100;
    }

    public final void setSnapShotResultListener(h r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.mSnapshotResultListener = r100;
    }

    @Override // com.larus.doc.sdk.impl.v2.plugins.snapshot.IDocShotPresenter
    public void startDocShot(WebView r100) {
        setIsActive(true);
        this.isBackPressed = false;
        if (r100 == null) goto L6;
        this.mLastScrollY = r100.getScrollY();
        notifyJScreenShot(0, r100);
        r100.scrollTo(0, 0);
        return;
    }

    public DocShotPresenter(FragmentActivity r100, Integer r101) {
        Intrinsics.checkNotNullParameter(r100, "mActivity");
        this.mActivity = r100;
        this.mInputViewHeight = r101;
        this.mIsActive = new MutableLiveData();
    }

    private final void notifyJScreenShot(int r100, WebView r101) {
        if (r101 == null) goto L5;
        JsonObject r102 = new JsonObject();
        r102.addProperty("state", Integer.valueOf(r100));
        SafeJSExecutor.execJS(r101, "javascript:window.native.screenshot", r102, null);
        this.mWebView = r101;
        return;
    }

    @Override // com.larus.doc.sdk.impl.v2.plugins.snapshot.IDocShotPresenter
    public void docShotFail(String r100, DocShotModel r101) {
        FLogger.f375446a.i(TAG, "docShotFail, errorInfo=" + r100);
        setIsActive(false);
        scrollToLastPosition();
        h r102 = this.mSnapshotResultListener;
        if (r102 == null) goto L7;
        if (r100 != null) goto L6;
        r100 = "Unknown fail reason";
    L6:
        r102.onSnapshotFail(r100);
    L7:
        notifyJScreenShot(1, this.mWebView);
    }

    @Override // com.larus.doc.sdk.impl.v2.plugins.snapshot.IDocShotPresenter
    public void docShotReady(boolean r100, DocShotModel r101) {
        this.mJsReadyTime = System.currentTimeMillis();
        FLogger r102 = FLogger.f375446a;
        r102.i(TAG, "docShotReady()...success = " + r100 + ", backPressed = " + this.isBackPressed);
        if (this.isBackPressed == false) goto L6;
        r102.i(TAG, "docShotReady()... has back pressed");
        return;
    L6:
        docShotFail("client-side long screenshot is no longer supported", r101);
    }
}
