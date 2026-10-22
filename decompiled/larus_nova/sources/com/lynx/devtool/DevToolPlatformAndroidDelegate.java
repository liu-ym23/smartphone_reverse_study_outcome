package com.lynx.devtool;

import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import android.widget.Toast;
import com.bytedance.android.livesdkapi.player.resolution.PlayerResolution;
import com.bytedance.ee.bear.bitable.card.model.jsmodel.common.ButtonColorBean;
import com.lynx.devtool.helper.EmulateTouchHelper;
import com.lynx.devtool.helper.LepusDebugInfoHelper;
import com.lynx.devtool.helper.ScreenCapturer;
import com.lynx.devtool.helper.ScreenCastHelper;
import com.lynx.devtool.helper.UITreeHelper;
import com.lynx.devtoolwrapper.IDevToolDelegate;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.tasm.LynxEnv;
import com.lynx.tasm.LynxView;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.base.PageReloadHelper;
import com.lynx.tasm.behavior.LynxUIOwner;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import h6a.a;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: classes32.dex */
public class DevToolPlatformAndroidDelegate {
    static final String NO_DEBUG_INFO_FOUND_BY_URL = "NO_DEBUG_INFO_FOUND_BY_URL";
    private static final String TAG = "DevToolPlatformAndroidDelegate";
    private ScreenCastHelper mCastHelper;
    private ConsoleDelegateManager mConsoleDelegateManager;
    private a mDebugInfoRecorder;
    private IDevToolDelegate mDevToolDelegate;
    private long mFacadePtr;
    private LepusDebugInfoHelper mLepusDebugInfoHelper;
    private WeakReference<LynxView> mLynxView;
    private PageReloadHelper mReloadHelper;
    private EmulateTouchHelper mTouchHelper;
    private UITreeHelper mUITreeHelper;

    private native long nativeCreateDevToolPlatformFacade();

    private native void nativeDestroyDevToolPlatformFacade(long r100);

    private native void nativeDispatchScreencastVisibilityChanged(long r100, boolean r101);

    private native String nativeGetLepusDebugInfoUrl(long r100, String r101);

    private native void nativeSendCDPEvent(long r100, String r101);

    private native void nativeSendConsoleEvent(long r100, String r101, int r102, long r103);

    private native void nativeSendLayerTreeDidChangeEvent(long r100);

    private native void nativeSendLynxScreenshotCapturedEvent(long r100, String r101);

    private native void nativeSendPageScreencastFrameEvent(long r100, String r101, float r102, float r103, float r104, float r105, float r106, float r107, float r110);

    public int[] getViewLocationOnScreen() {
        int[] r100 = {-1, -1};
        UITreeHelper r101 = this.mUITreeHelper;
        if (r101 == null) goto L5;
        r101.getViewLocationOnScreen(r100);
    L5:
        return r100;
    }

    public native void nativeFlushConsoleMessages(long r100);

    public native void nativeGetConsoleObject(long r100, String r101, boolean r102, int r103);

    public void continueCasting() {
        ScreenCastHelper r100 = this.mCastHelper;
        if (r100 == null) goto L6;
        r100.continueCasting();
        return;
    }

    public void destroy() {
        long r100 = this.mFacadePtr;
        if (r100 == 0) goto L5;
        nativeDestroyDevToolPlatformFacade(r100);
    L5:
        this.mFacadePtr = 0;
    }

    public String getLynxUITree() {
        UITreeHelper r100 = this.mUITreeHelper;
        if (r100 != null) goto L5;
        return "";
    L5:
        return r100.getLynxUITree();
    }

    public float[] getRectToWindow() {
        UITreeHelper r100 = this.mUITreeHelper;
        if (r100 == null) goto L7;
        return r100.getRectToWindow();
    L7:
        return new float[]{0.0f, 0.0f, 0.0f, 0.0f};
    }

    public long getTemplateDataPtr() {
        PageReloadHelper r100 = this.mReloadHelper;
        if (r100 != null) goto L5;
        return 0;
    L5:
        return r100.getTemplateDataPtr();
    }

    public String getTemplateUrl() {
        PageReloadHelper r100 = this.mReloadHelper;
        if (r100 != null) goto L5;
        LLog.w(TAG, "mReloadHelper == null");
        return "";
    L5:
        return r100.getURL();
    }

    public void onAckReceived() {
        ScreenCastHelper r100 = this.mCastHelper;
        if (r100 == null) goto L6;
        r100.onAckReceived();
        return;
    }

    public void pauseCasting() {
        ScreenCastHelper r100 = this.mCastHelper;
        if (r100 == null) goto L6;
        r100.pauseCasting();
        return;
    }

    public void sendCardPreview() {
        ScreenCastHelper r100 = this.mCastHelper;
        if (r100 == null) goto L6;
        r100.sendCardPreview(this.mDevToolDelegate);
        return;
    }

    public void sendLayerTreeDidChangeEvent() {
        long r100 = this.mFacadePtr;
        if (r100 == 0) goto L6;
        nativeSendLayerTreeDidChangeEvent(r100);
        return;
    }

    public void stopCasting() {
        ScreenCastHelper r100 = this.mCastHelper;
        if (r100 == null) goto L6;
        r100.stopCasting();
        return;
    }

    public static String getLynxVersion() {
        return LynxEnv.inst().getLynxVersion();
    }

    public long getNativePtr() {
        return this.mFacadePtr;
    }

    public DevToolPlatformAndroidDelegate(LynxView r100) {
        this.mDevToolDelegate = null;
        this.mUITreeHelper = new UITreeHelper();
        this.mConsoleDelegateManager = new ConsoleDelegateManager();
        this.mLynxView = new WeakReference(r100);
        this.mLepusDebugInfoHelper = new LepusDebugInfoHelper();
        this.mCastHelper = new ScreenCastHelper(this, r100);
        this.mFacadePtr = nativeCreateDevToolPlatformFacade();
        this.mTouchHelper = new EmulateTouchHelper(this.mLynxView);
        this.mReloadHelper = null;
        this.mDebugInfoRecorder = null;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_lynx_devtool_DevToolPlatformAndroidDelegate_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public void attach(LynxView r100) {
        this.mLynxView = new WeakReference(r100);
        if (this.mCastHelper == null) goto L6;
        this.mCastHelper.attach(r100);
    L6:
        if (this.mTouchHelper == null) goto L9;
        this.mTouchHelper.attach(r100);
        return;
    }

    public void attachLynxUIOwner(LynxUIOwner r100) {
        if (this.mUITreeHelper == null) goto L6;
        this.mUITreeHelper.attachLynxUIOwner(r100);
        return;
    }

    public void dispatchScreencastVisibilityChanged(boolean r100) {
        long r101 = this.mFacadePtr;
        if (r101 == 0) goto L6;
        nativeDispatchScreencastVisibilityChanged(r101, r100);
        return;
    }

    public void focus(final int r100) {
        LynxView r101 = this.mLynxView.get();
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getLynxContext() == null) goto L13;
        LynxUIOwner r102 = r101.getLynxContext().getLynxUIOwner();
        if (r102 != null) goto L10;
        return;
    L10:
        r102.invokeUIMethodForSelectorQuery(r100, ButtonColorBean.StateFocus, new JavaOnlyMap(), new AnonymousClass1(this, r100));
        return;
    }

    public String getDebugInfoByUrl(String r100) {
        a r101 = this.mDebugInfoRecorder;
        if (r101 == null) goto L7;
        String r102 = r101.getDebugInfo(r100);
        if (r102 == null) goto L9;
        return r102;
    L9:
        return NO_DEBUG_INFO_FOUND_BY_URL;
    L7:
        return NO_DEBUG_INFO_FOUND_BY_URL;
    }

    public String getLepusDebugInfo(String r100) {
        LepusDebugInfoHelper r101 = this.mLepusDebugInfoHelper;
        if (r101 != null) goto L5;
        return "";
    L5:
        return r101.getDebugInfo(r100);
    }

    public String getLepusDebugInfoUrl(String r100) {
        long r101 = this.mFacadePtr;
        if (r101 != 0) goto L5;
        return "";
    L5:
        return nativeGetLepusDebugInfoUrl(r101, r100);
    }

    public String getUINodeInfo(int r100) {
        UITreeHelper r101 = this.mUITreeHelper;
        if (r101 != null) goto L5;
        return "";
    L5:
        return r101.getUINodeInfo(r100);
    }

    public void insertText(String r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        LynxView r101 = this.mLynxView.get();
        if (r101 != null) goto L7;
        return;
    L7:
        View r102 = r101.findFocus();
        if (r102 != null) goto L13;
        if (r101.getRootView() == null) goto L13;
        r102 = r101.getRootView().findFocus();
    L13:
        if ((r102 instanceof EditText) == true) goto L16;
        LLog.w(TAG, "Input.insertText ignored because no EditText is focused.");
        return;
    L16:
        EditText r103 = (EditText) r102;
        InputConnection r104 = r103.onCreateInputConnection(new EditorInfo());
        if (r104 != null) goto L19;
    L21:
        int r105 = r103.getSelectionStart();
        int r106 = r103.getSelectionEnd();
        if (r105 < 0) goto L27;
        if (r106 < 0) goto L27;
        int r107 = r103.getText().length();
        int r108 = Math.min(r107, Math.max(0, Math.min(r105, r106)));
        int r109 = Math.min(r107, Math.max(0, Math.max(r105, r106)));
        r103.getText().replace(r108, r109, r100);
        return;
    L27:
        r103.getText().append(r100);
        return;
    L19:
        if (r104.commitText(r100, 1) == false) goto L21;
    }

    public void navigate(String r100) {
        if (this.mReloadHelper == null) goto L6;
        this.mReloadHelper.navigate(r100);
        return;
    }

    public void onConsoleMessage(String r100) {
        ConsoleDelegateManager r101 = this.mConsoleDelegateManager;
        if (r101 == null) goto L6;
        r101.onConsoleMessage(r100);
        return;
    }

    public void scrollIntoViewFromUI(int r100) {
        IDevToolDelegate r101 = this.mDevToolDelegate;
        if (r101 == null) goto L6;
        r101.scrollIntoViewFromUI(r100);
        return;
    }

    public void sendCDPEvent(String r100) {
        long r101 = this.mFacadePtr;
        if (r101 == 0) goto L6;
        nativeSendCDPEvent(r101, r100);
        return;
    }

    public void sendCardPreviewData(String r100) {
        long r101 = this.mFacadePtr;
        if (r101 == 0) goto L6;
        nativeSendLynxScreenshotCapturedEvent(r101, r100);
        return;
    }

    public void setDebugInfoInterceptor(a r100) {
        this.mDebugInfoRecorder = r100;
    }

    public void setDevToolDelegate(IDevToolDelegate r100) {
        this.mDevToolDelegate = r100;
    }

    public void setLynxInspectorConsoleDelegate(Object r100) {
        ConsoleDelegateManager r101 = this.mConsoleDelegateManager;
        if (r101 == null) goto L8;
        long r102 = this.mFacadePtr;
        if (r102 == 0) goto L9;
        r101.setLynxInspectorConsoleDelegate(r100, this, r102);
        return;
    L9:
        return;
    }

    public void setReloadHelper(PageReloadHelper r100) {
        this.mReloadHelper = r100;
    }

    public String getTemplateJsInfo(int r100, int r101) {
        PageReloadHelper r102 = this.mReloadHelper;
        if (r102 != null) goto L5;
        return "";
    L5:
        return r102.getTemplateJsInfo(r100, r101);
    }

    public float[] getTransformValue(int r100, float[] r101) {
        IDevToolDelegate r102 = this.mDevToolDelegate;
        if (r102 == null) goto L7;
        return r102.getTransformValue(r100, r101);
    L7:
        return new float[0];
    }

    public void onConsoleObject(String r100, int r101) {
        ConsoleDelegateManager r102 = this.mConsoleDelegateManager;
        if (r102 == null) goto L6;
        r102.onConsoleObject(r100, r101);
        return;
    }

    public void onReceiveTemplateFragment(String r100, boolean r101) {
        if (this.mReloadHelper == null) goto L6;
        this.mReloadHelper.onReceiveTemplateFragment(r100, r101);
        return;
    }

    public int findNodeIdForLocationFromUI(float r100, float r101, String r102) {
        IDevToolDelegate r103 = this.mDevToolDelegate;
        if (r103 != null) goto L5;
        return 0;
    L5:
        return r103.getNodeForLocation(r100, r101, r102);
    }

    public void getConsoleObject(String r100, boolean r101, Callback r110) {
        ConsoleDelegateManager r102 = this.mConsoleDelegateManager;
        if (r102 == null) goto L8;
        long r103 = this.mFacadePtr;
        if (r103 == 0) goto L9;
        r102.getConsoleObject(r100, r101, r110, this, r103);
        return;
    L9:
        return;
    }

    public void sendConsoleEvent(String r100, int r101, long r110) {
        long r102 = this.mFacadePtr;
        if (r102 == 0) goto L6;
        nativeSendConsoleEvent(r102, r100, r101, r110);
        return;
    }

    public void sendEventToVM(String r100, String r101, String r102) {
        if (this.mDevToolDelegate != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L16;
        JavaOnlyMap r103 = new JavaOnlyMap();
        r103.putString("type", r101);
        if (r102 != null) goto L12;
        r102 = "";
    L12:
        r103.putString("data", r102);
        r103.putString(PlayerResolution.SDKKEY.ORIGIN, "Devtool");
        r103.putString(PickerReporterConstants.KEY.TARGET, r100);
        this.mDevToolDelegate.onDispatchMessageEvent(r103);
        return;
    }

    public int setUIStyle(int r100, String r101, String r102) {
        UITreeHelper r103 = this.mUITreeHelper;
        if (r103 != null) goto L5;
        return -1;
    L5:
        return r103.setUIStyle(r100, r101, r102);
    }

    public void sendScreenCast(String r110, ScreenCapturer.ScreenMetadata r111, float r112, float r113) {
        if (r110 == null) goto L9;
        if (r111 == null) goto L11;
        long r100 = this.mFacadePtr;
        if (r100 == 0) goto L10;
        nativeSendPageScreencastFrameEvent(r100, r110, r111.mOffsetTop, r112, r111.mDeviceWidth, r111.mDeviceHeight, r111.mScrollOffsetX, r111.mScrollOffsetY, r111.mTimestamp);
        return;
    L10:
        return;
    L11:
        return;
    }

    public void startCasting(int r100, int r101, int r102, String r110) {
        ScreenCastHelper r103 = this.mCastHelper;
        if (r103 == null) goto L6;
        r103.startCasting(r100, r101, r102, r110, this.mDevToolDelegate);
        return;
    }

    public void pageReload(boolean r100, String r101, boolean r110, int r111, String r112) {
        if (this.mReloadHelper == null) goto L9;
        LynxView r102 = this.mLynxView.get();
        if (r102 == null) goto L7;
        Toast.makeText(r102.getContext(), "Start to download & reload...", 0).show();
    L7:
        this.mReloadHelper.reload(r100, r101, r110, r111, r112);
        return;
    }

    public void emulateTouch(String r110, int r111, int r112, float r113, float r114, String r115) {
        if (this.mTouchHelper != null) goto L5;
        return;
    L5:
        LynxView r100 = this.mLynxView.get();
        if (r100 == null) goto L9;
        float r101 = INVOKEVIRTUAL_com_lynx_devtool_DevToolPlatformAndroidDelegate_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getLynxContext().getResources()).density;
        this.mTouchHelper.emulateTouch(r110, (int) ((r111 * r101) + 0.5f), (int) ((r112 * r101) + 0.5f), (r113 * r101) + 0.5f, (r114 * r101) + 0.5f, r115, this.mDevToolDelegate);
        return;
    }
}
