package com.lynx.tasm.behavior.ui.text;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.RemoteException;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.bytedance.bpea.entry.common.DataType;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.larus.platform.service.g;
import com.larus.utils.logger.FLogger;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.service.ILynxTextService;
import com.lynx.tasm.utils.UIThreadUtils;
import i8a.h;
import i8a.n;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import me.ele.lancet.base.annotations.Skip;
import x6a.d;
import z6a.w;

/* JADX INFO: loaded from: classes32.dex */
public class AndroidText extends com.lynx.tasm.behavior.ui.view.a implements ActionMode.Callback {
    private static final int DEFAULT_TEXT_HANDLE_COLOR = -16614661;
    private static final int DEFAULT_TEXT_HANDLE_SIZE = 15;
    private static final int DEFAULT_TEXT_SELECTION_COLOR = 1714664933;
    private static final int ID_COPY = 65534;
    private static final int ID_SELECT_ALL = 65533;
    private static final float RESPONSE_TOUCH_RADIUS = 50.0f;
    protected static final String SELECTION_CHANGE_EVENT = "selectionchange";
    private static WeakReference<AndroidText> sWeakSelectingAndroidText;
    private ActionMode mActionMode;
    private a mCheckForLongPress;
    private int mDefaultHandlePlatformLength;
    private boolean mDisplayNone;
    private boolean mEnableCustomContextMenu;
    private boolean mEnableCustomTextSelection;
    private boolean mEnableTextSelection;
    private final PointF mEndHandlerPos;
    private int mHandleSize;
    protected boolean mHasImage;
    private Paint mHighlightPaint;
    private Path mHighlightPath;
    private boolean mIsAdjustEndPos;
    private boolean mIsAdjustStartPos;
    private boolean mIsBindSelectionChange;
    private boolean mIsForward;
    private boolean mIsInSelection;
    protected boolean mIsJustify;
    private boolean mIsShowEndHandle;
    private boolean mIsShowStartHandle;
    private int mLastSelectEnd;
    private int mLastSelectStart;
    private boolean mNeedDrawStroke;
    private CharSequence mOriginText;
    private int mOverflow;
    private Picture mOverflowPicture;
    private boolean mOverflowPictureDirty;
    private int mSelectEnd;
    private final PointF mSelectEndPos;
    private int mSelectStart;
    private final PointF mSelectStartPos;
    private Drawable mSelectionLeftCursor;
    private Drawable mSelectionRightCursor;
    private boolean mShouldResponseMove;
    private int mSign;
    private final PointF mStartHandlerPos;
    protected Layout mTextLayout;
    private int mTextSelectionColor;
    private int mTextSelectionHandleColor;
    private final ArrayList<RectF> mTextServiceSelectionBoxes;
    private int mTextServiceSelectionEnd;
    private int mTextServiceSelectionStart;
    private int mTextServiceTextLength;
    protected PointF mTextTranslateOffset;
    protected w mTextUpdateBundle;
    protected ILynxTextService.a mTextraPage;

    public final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f383075a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f383076b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ AndroidText f383077c;

        public final void a() {
            int r100 = AndroidText.access$000(this.f383077c, this.f383075a, this.f383076b);
            if (r100 >= 0) goto L6;
            AndroidText.access$102(this.f383077c, null);
            return;
        L6:
            AndroidText.access$202(this.f383077c, true);
            AndroidText.access$300(this.f383077c).set(this.f383075a, this.f383076b);
            AndroidText.access$400(this.f383077c).set(this.f383075a, this.f383076b);
            AndroidText r101 = this.f383077c;
            AndroidText.access$502(r101, AndroidText.access$602(r101, r100));
            AndroidText.access$702(this.f383077c, true);
            this.f383077c.requestDisallowInterceptTouchEvent(true);
            AndroidText.access$102(this.f383077c, null);
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(AndroidText r100, float r101, float r102) {
            this.f383077c = r100;
            this.f383075a = r101;
            this.f383076b = r102;
        }
    }

    private void resetSelectionState() {
        this.mLastSelectEnd = -1;
        this.mLastSelectStart = -1;
        this.mSelectEnd = -1;
        this.mSelectStart = -1;
        this.mShouldResponseMove = false;
        this.mIsAdjustEndPos = false;
        this.mIsAdjustStartPos = false;
        this.mIsInSelection = false;
        this.mIsShowEndHandle = true;
        this.mIsShowStartHandle = true;
        this.mSelectStartPos.set(-1.0f, -1.0f);
        this.mSelectEndPos.set(-1.0f, -1.0f);
        invalidateTextServiceSelectionBoxes();
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void applyRendererClipBounds(boolean r100, Rect r101) {
        d.a(this, r100, r101);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void applyRendererOpacity(float r100) {
        d.b(this, r100);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void applyRendererTransform(float[] r100) {
        d.c(this, r100);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ PointF convertPointInRendererHostToScreen(PointF r100) {
        return d.d(this, r100);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostHeight() {
        return d.e(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollX() {
        return d.f(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostScrollY() {
        return d.g(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ int getRendererHostWidth() {
        return d.h(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void invalidateForRenderer() {
        d.i(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ boolean invokeUIMethod(String r100, ReadableMap r101, Callback r102) {
        return false;
    }

    @Override // android.view.ActionMode.Callback
    public void onDestroyActionMode(ActionMode r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void requestLayoutForRenderer() {
        d.j(this);
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setClipChildrenForRenderer(boolean r100) {
        d.k(this, r100);
    }

    public void setTextGradient(ReadableArray r100) {
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, x6a.e
    public /* bridge */ /* synthetic */ void setWillNotDrawForRenderer(boolean r100) {
        d.l(this, r100);
    }

    private void clearOtherSelection() {
        if (this.mEnableCustomTextSelection == false) goto L5;
        return;
    L5:
        WeakReference<AndroidText> r100 = sWeakSelectingAndroidText;
        if (r100 == null) goto L11;
        AndroidText r101 = r100.get();
        if (r101 == null) goto L11;
        if (r101 == this) goto L11;
        r101.clearSelection();
        r101.invalidate();
    L11:
        sWeakSelectingAndroidText = new WeakReference(this);
    }

    private void dispatchDetachImageSpan() {
        if (this.mHasImage == true) goto L5;
        return;
    L5:
        if ((getText() instanceof Spanned) == false) goto L11;
        Spanned r100 = (Spanned) getText();
        int r101 = 0;
        com.lynx.tasm.behavior.ui.text.a[] r102 = (com.lynx.tasm.behavior.ui.text.a[]) r100.getSpans(0, r100.length(), com.lynx.tasm.behavior.ui.text.a.class);
        int r103 = r102.length;
    L7:
        if (r101 >= r103) goto L12;
        com.lynx.tasm.behavior.ui.text.a r104 = r102[r101];
        r104.f();
        r104.j(null);
        r101 = r101 + 1;
        goto L7
    L12:
        return;
    }

    private void drawOverflowPicture() {
        if (this.mOverflowPictureDirty == true) goto L5;
        return;
    L5:
        if (this.mTextLayout == null) goto L20;
        Picture r100 = this.mOverflowPicture;
        if (r100 != null) goto L10;
        this.mOverflowPicture = new Picture();
    L11:
        Canvas r101 = this.mOverflowPicture.beginRecording(this.mTextLayout.getWidth(), this.mTextLayout.getHeight());
        r101.save();
        if (getClipBounds() == null) goto L14;
        r101.clipRect(getClipBounds());
    L14:
        drawTextOnCanvas(r101);
        if (this.mNeedDrawStroke == false) goto L17;
        com.lynx.tasm.behavior.shadow.text.b.g(this.mTextLayout, r101);
    L17:
        r101.restore();
        this.mOverflowPicture.endRecording();
        this.mOverflowPictureDirty = false;
        return;
    L10:
        r100.endRecording();
        goto L11
    }

    private boolean hasTextSelectionContent() {
        if (this.mTextLayout == null) goto L5;
    L10:
        return true;
    L5:
        if (this.mTextraPage != null) goto L7;
    L9:
        return false;
    L7:
        if (this.mTextServiceTextLength <= 0) goto L9;
        goto L9
    }

    private void hideToolbar() {
        if (this.mEnableCustomContextMenu == true) goto L9;
        ActionMode r100 = this.mActionMode;
        if (r100 == null) goto L10;
        r100.finish();
        this.mActionMode = null;
        return;
    L10:
        return;
    }

    private void invalidateTextServiceSelectionBoxes() {
        this.mTextServiceSelectionBoxes.clear();
        this.mTextServiceSelectionStart = -1;
        this.mTextServiceSelectionEnd = -1;
    }

    private void onSelectionChange() {
        if (this.mIsBindSelectionChange == true) goto L5;
        return;
    L5:
        if ((getContext() instanceof LynxContext) == false) goto L13;
        m7a.a r100 = new m7a.a(this.mSign, SELECTION_CHANGE_EVENT);
        r100.a("start", Integer.valueOf(this.mSelectStart));
        r100.a("end", Integer.valueOf(this.mSelectEnd));
        if (this.mIsForward == false) goto L9;
        String r101 = "forward";
    L10:
        r100.a("direction", r101);
        ((LynxContext) getContext()).getEventEmitter().sendCustomEvent(r100);
        return;
    L9:
        r101 = "backward";
        goto L10
    }

    private void performCopy() {
        if (this.mTextraPage == null) goto L7;
        String r100 = getSelectedText();
        if (r100.isEmpty() == true) goto L14;
        copyToClipboard(r100);
    L14:
        clearSelection();
        return;
    L7:
        int r101 = this.mSelectStart;
        if (r101 < 0) goto L14;
        int r102 = this.mSelectEnd;
        if (r102 <= r101) goto L14;
        if (r102 > this.mTextLayout.getText().length()) goto L14;
        copyToClipboard(this.mTextLayout.getText().subSequence(this.mSelectStart, this.mSelectEnd));
        goto L14
    }

    private void performSelectAll() {
        if (this.mTextraPage == null) goto L9;
        int r100 = this.mTextServiceTextLength;
        if (r100 > 0) goto L7;
        return;
    L7:
        updateSelectionRange(0, r100);
        updateSelectStartEnd();
        return;
    L9:
        updateSelectionRange(0, this.mTextLayout.getText().length());
        updateSelectStartEnd();
    }

    private void removeCheckLongPressCallback() {
        a r100 = this.mCheckForLongPress;
        if (r100 != null) goto L5;
        return;
    L5:
        removeCallbacks(r100);
        this.mCheckForLongPress = null;
    }

    private void showToolbar() {
        if (this.mEnableCustomContextMenu == false) goto L5;
        return;
    L5:
        if (hasTextSelectionContent() == true) goto L8;
        return;
    L8:
        if (Build.VERSION.SDK_INT < 23) goto L10;
        startActionMode(this, 1);
        return;
    L10:
        startActionMode(this);
    }

    private void updateSelectStartEnd() {
        int r100 = Math.min(this.mSelectStart, this.mSelectEnd);
        this.mSelectEnd = Math.max(this.mSelectStart, this.mSelectEnd);
        this.mSelectStart = r100;
        onSelectionChange();
        if (this.mTextraPage == null) goto L6;
        updateSelectionHandlePositionFromBoxes(this.mSelectStart, this.mSelectEnd);
        return;
    L6:
        this.mSelectStartPos.set(getBottomPositionForOffset(this.mSelectStart, true));
        this.mSelectEndPos.set(getBottomPositionForOffset(this.mSelectEnd, false));
    }

    private void updateSelectionStyle() {
        Drawable r100 = this.mSelectionLeftCursor;
        int r101 = this.mHandleSize;
        r100.setBounds(0, 0, r101, r101);
        Drawable r102 = this.mSelectionRightCursor;
        int r103 = this.mHandleSize;
        r102.setBounds(0, 0, r103, r103);
        this.mSelectionLeftCursor.setTint(this.mTextSelectionHandleColor);
        this.mSelectionRightCursor.setTint(this.mTextSelectionHandleColor);
        this.mHighlightPaint.setColor(this.mTextSelectionColor);
    }

    public ArrayList<Float>[] getHandlesInfo() {
        if (this.mIsInSelection == false) goto L5;
        ArrayList<Float> r100 = new ArrayList();
        r100.add(Float.valueOf(this.mStartHandlerPos.x));
        r100.add(Float.valueOf(this.mStartHandlerPos.y));
        r100.add(Float.valueOf(50.0f));
        ArrayList<Float> r101 = new ArrayList();
        r101.add(Float.valueOf(this.mEndHandlerPos.x));
        r101.add(Float.valueOf(this.mEndHandlerPos.y));
        r101.add(Float.valueOf(50.0f));
        return new ArrayList[]{r100, r101};
    L5:
        return new ArrayList[0];
    }

    public String getSelectedText() {
        ILynxTextService.a r100 = this.mTextraPage;
        if (r100 == null) goto L10;
        int r101 = this.mSelectStart;
        if (r101 < 0) goto L10;
        int r102 = this.mSelectEnd;
        if (r102 <= r101) goto L10;
        return r100.b(r101, r102);
    L10:
        Layout r103 = this.mTextLayout;
        if (r103 == null) goto L21;
        int r104 = this.mSelectStart;
        if (r104 < 0) goto L23;
        int r105 = this.mSelectEnd;
        if (r105 <= 0) goto L24;
        if (r105 > r104) goto L18;
        return "";
    L18:
        if (r105 <= r103.getText().length()) goto L20;
        return "";
    L20:
        return this.mTextLayout.getText().subSequence(this.mSelectStart, this.mSelectEnd).toString();
    L24:
        return "";
    L23:
        return "";
    L21:
        return "";
    }

    public CharSequence getText() {
        Layout r100 = this.mTextLayout;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getText();
    }

    public boolean hasTextraPage() {
        if (this.mTextraPage == null) goto L5;
        return true;
    L5:
        return false;
    }

    public void release() {
        if (this.mHasImage == true) goto L5;
        return;
    L5:
        if ((getText() instanceof Spanned) == false) goto L9;
        com.lynx.tasm.behavior.ui.text.a.i((Spanned) getText(), null);
        return;
    }

    private void clearSelection() {
        removeCheckLongPressCallback();
        this.mIsAdjustStartPos = false;
        this.mIsAdjustEndPos = false;
        this.mSelectStartPos.set(-1.0f, -1.0f);
        this.mSelectEndPos.set(-1.0f, -1.0f);
        this.mSelectStart = -1;
        this.mSelectEnd = -1;
        this.mLastSelectStart = -1;
        this.mLastSelectEnd = -1;
        invalidateTextServiceSelectionBoxes();
        if (this.mIsInSelection == false) goto L5;
        onSelectionChange();
    L5:
        this.mIsInSelection = false;
        updateSelectionRange(this.mSelectStart, this.mSelectEnd);
        hideToolbar();
        this.mShouldResponseMove = false;
        this.mIsShowEndHandle = true;
        this.mIsShowStartHandle = true;
        Path r100 = this.mHighlightPath;
        if (r100 == null) goto L9;
        r100.reset();
        return;
    }

    private float getTextDrawOffsetX() {
        float r100 = getPaddingLeft();
        PointF r101 = this.mTextTranslateOffset;
        if (r101 == null) goto L5;
        float r102 = r101.x;
    L7:
        return r100 + r102;
    L5:
        r102 = 0.0f;
        goto L7
    }

    private float getTextDrawOffsetY() {
        float r100 = getPaddingTop();
        PointF r101 = this.mTextTranslateOffset;
        if (r101 == null) goto L5;
        float r102 = r101.y;
    L7:
        return r100 + r102;
    L5:
        r102 = 0.0f;
        goto L7
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.mHasImage == true) goto L5;
        return;
    L5:
        if ((getText() instanceof Spanned) == false) goto L9;
        com.lynx.tasm.behavior.ui.text.a.i((Spanned) getText(), this);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        dispatchDetachImageSpan();
    }

    @Override // android.view.View
    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.mHasImage == true) goto L5;
        return;
    L5:
        if ((getText() instanceof Spanned) == false) goto L11;
        Spanned r100 = (Spanned) getText();
        int r101 = 0;
        com.lynx.tasm.behavior.ui.text.a[] r102 = (com.lynx.tasm.behavior.ui.text.a[]) r100.getSpans(0, r100.length(), com.lynx.tasm.behavior.ui.text.a.class);
        int r103 = r102.length;
    L7:
        if (r101 >= r103) goto L12;
        r102[r101].g();
        r101 = r101 + 1;
        goto L7
    L12:
        return;
    }

    @Override // android.view.View
    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.mHasImage == true) goto L5;
        return;
    L5:
        if ((getText() instanceof Spanned) == false) goto L11;
        Spanned r100 = (Spanned) getText();
        int r101 = 0;
        com.lynx.tasm.behavior.ui.text.a[] r102 = (com.lynx.tasm.behavior.ui.text.a[]) r100.getSpans(0, r100.length(), com.lynx.tasm.behavior.ui.text.a.class);
        int r103 = r102.length;
    L7:
        if (r101 >= r103) goto L12;
        r102[r101].h();
        r101 = r101 + 1;
        goto L7
    L12:
        return;
    }

    public CharSequence getOriginText() {
        return this.mOriginText;
    }

    public Layout getTextLayout() {
        return this.mTextLayout;
    }

    public AndroidText(Context r100) {
        super(r100);
        this.mTextServiceTextLength = 0;
        this.mNeedDrawStroke = false;
        this.mIsBindSelectionChange = false;
        this.mSign = 0;
        this.mIsForward = true;
        this.mEnableTextSelection = false;
        this.mEnableCustomContextMenu = false;
        this.mEnableCustomTextSelection = false;
        this.mActionMode = null;
        this.mSelectStart = -1;
        this.mSelectEnd = -1;
        this.mLastSelectStart = -1;
        this.mLastSelectEnd = -1;
        this.mSelectStartPos = new PointF(-1.0f, -1.0f);
        this.mSelectEndPos = new PointF(-1.0f, -1.0f);
        this.mStartHandlerPos = new PointF(-1.0f, -1.0f);
        this.mEndHandlerPos = new PointF(-1.0f, -1.0f);
        this.mIsInSelection = false;
        this.mIsAdjustStartPos = false;
        this.mIsAdjustEndPos = false;
        this.mCheckForLongPress = null;
        this.mShouldResponseMove = false;
        this.mIsShowStartHandle = true;
        this.mIsShowEndHandle = true;
        this.mDisplayNone = false;
        this.mTextServiceSelectionBoxes = new ArrayList();
        this.mTextServiceSelectionStart = -1;
        this.mTextServiceSelectionEnd = -1;
        this.mOverflowPicture = new Picture();
        this.mOverflow = 0;
        this.mOverflowPictureDirty = true;
        setFocusable(true);
        setWillNotDraw(false);
        this.mTextSelectionColor = DEFAULT_TEXT_SELECTION_COLOR;
        this.mTextSelectionHandleColor = DEFAULT_TEXT_HANDLE_COLOR;
        int r101 = Math.round(((LynxContext) r100).getScreenMetrics().density * 15.0f);
        this.mDefaultHandlePlatformLength = r101;
        this.mHandleSize = r101;
    }

    public static /* synthetic */ PointF access$300(AndroidText r100) {
        return r100.mSelectStartPos;
    }

    public static /* synthetic */ PointF access$400(AndroidText r100) {
        return r100.mSelectEndPos;
    }

    private void copyToClipboard(CharSequence r100) {
        ClipData r101 = ClipData.newPlainText("Lynx-clipboard", r100);
        h r102 = (h) n.c().a(h.class);
        if (r102 == null) goto L9;
        r102.a(r101);     // Catch: RemoteException -> L6
        return;
    L6:
        e = move-exception;
        LLog.e("AndroidText", "A RemoteException was encountered while calling systemInvokeService. " + e.getMessage());
        return;
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L11;
        ClipboardManager r103 = (ClipboardManager) getContext().getSystemService(ClipboardManager.class);
    L12:
        INVOKEVIRTUAL_com_lynx_tasm_behavior_ui_text_AndroidText_com_larus_home_impl_utils_ClipboardManagerLancet_setPrimaryClip(r103, r101);
        return;
    L11:
        r103 = (ClipboardManager) getContext().getSystemService(DataType.CLIPBOARD);
        goto L12
    }

    private void drawHighlight(Canvas r100) {
        if (this.mIsInSelection == true) goto L5;
        return;
    L5:
        if (this.mHighlightPath != null) goto L7;
        return;
    L7:
        if (this.mHighlightPaint == null) goto L26;
        int r101 = Math.min(this.mSelectStart, this.mSelectEnd);
        int r102 = Math.max(this.mSelectStart, this.mSelectEnd);
        if (this.mTextraPage == null) goto L16;
        ArrayList<RectF> r103 = getTextServiceSelectionBoxes(r101, r102);
        int r104 = 0;
    L13:
        if (r104 >= r103.size()) goto L27;
        r100.drawRect((RectF) ListProtector.get(r103, r104), this.mHighlightPaint);
        r104 = r104 + 1;
        goto L13
    L27:
        return;
    L16:
        if (this.mTextLayout == null) goto L24;
        this.mHighlightPath.reset();
        this.mTextLayout.getSelectionPath(r101, r102, this.mHighlightPath);
        if (this.mHighlightPath.isEmpty() == true) goto L25;
        r100.drawPath(this.mHighlightPath, this.mHighlightPaint);
        return;
    L25:
        return;
    L24:
        return;
    }

    private void drawHighlightWithTextOffset(Canvas r100) {
        r100.save();
        r100.translate(getTextDrawOffsetX(), getTextDrawOffsetY());
        drawHighlight(r100);
        r100.restore();
    }

    private void drawSelectEndCursor(Canvas r100) {
        r100.save();
        r100.translate(this.mEndHandlerPos.x - (this.mSelectionRightCursor.getBounds().width() / 2.0f), this.mEndHandlerPos.y - (this.mSelectionRightCursor.getBounds().height() / 2.0f));
        this.mSelectionRightCursor.draw(r100);
        r100.restore();
    }

    private void drawSelectHandle(Canvas r100) {
        if (this.mIsShowStartHandle == false) goto L6;
        drawSelectStartCursor(r100);
    L6:
        if (this.mIsShowEndHandle == false) goto L9;
        drawSelectEndCursor(r100);
        return;
    }

    private void drawSelectStartCursor(Canvas r100) {
        r100.save();
        r100.translate(this.mStartHandlerPos.x - (this.mSelectionLeftCursor.getBounds().width() / 2.0f), this.mStartHandlerPos.y - (this.mSelectionLeftCursor.getBounds().height() / 2.0f));
        this.mSelectionLeftCursor.draw(r100);
        r100.restore();
    }

    private void drawText(Canvas r100) {
        drawHighlight(r100);
        drawTextOnCanvas(r100);
        if (this.mNeedDrawStroke == false) goto L5;
        com.lynx.tasm.behavior.shadow.text.b.g(this.mTextLayout, r100);
    L5:
        com.lynx.tasm.behavior.shadow.text.b.e(r100, this.mTextLayout);
    }

    private void drawTextOnCanvas(Canvas r100) {
        if (this.mIsJustify == true) goto L5;
    L7:
        this.mTextLayout.draw(r100);
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        com.lynx.tasm.behavior.shadow.text.b.f(r100, this.mTextLayout, (getWidth() - getPaddingLeft()) - getPaddingRight());
    }

    private void drawTextServiceSelectHandle(Canvas r100) {
        if (this.mIsInSelection == true) goto L5;
        return;
    L5:
        if (this.mSelectionLeftCursor != null) goto L7;
        return;
    L7:
        if (this.mSelectionRightCursor == null) goto L13;
        r100.save();
        r100.translate(getTextDrawOffsetX(), getTextDrawOffsetY());
        drawSelectHandle(r100);
        r100.restore();
        return;
    }

    private PointF getCenterPositionForOffset(int r100) {
        if (r100 < 0) goto L9;
        if (r100 > this.mTextLayout.getText().length()) goto L9;
        int r101 = this.mTextLayout.getLineForOffset(r100);
        return new PointF(this.mTextLayout.getPrimaryHorizontal(r100), (this.mTextLayout.getLineTop(r101) + this.mTextLayout.getLineBottom(r101)) / 2.0f);
    L9:
        return new PointF(0.0f, 0.0f);
    }

    private int getLineAtCoordinate(float r100) {
        return this.mTextLayout.getLineForVertical((int) Math.min(getHeight() - 1, Math.max(0.0f, r100)));
    }

    private void initSelectionCursor(Context r100) {
        this.mSelectionLeftCursor = r100.getResources().getDrawable(R.drawable.lynx_text_select_handle_left_material);
        this.mSelectionRightCursor = r100.getResources().getDrawable(R.drawable.lynx_text_select_handle_right_material);
        Paint r101 = new Paint();
        this.mHighlightPaint = r101;
        r101.setStyle(Paint.Style.FILL);
        this.mHighlightPath = new Path();
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas r100) {
        if (this.mDisplayNone == false) goto L5;
        return;
    L5:
        super.dispatchDraw(r100);
        if (this.mTextraPage == null) goto L10;
        drawTextServiceSelectHandle(r100);
        return;
    L10:
        if (super.getRenderer() == null) goto L13;
        return;
    L13:
        if (this.mIsInSelection == false) goto L21;
        Path r101 = this.mHighlightPath;
        if (r101 != null) goto L17;
        return;
    L17:
        if (r101.isEmpty() == true) goto L23;
        r100.save();
        r100.translate(getPaddingLeft() + this.mTextTranslateOffset.x, getPaddingTop() + this.mTextTranslateOffset.y);
        drawSelectHandle(r100);
        r100.restore();
        return;
    L23:
        return;
    }

    public Layout generateTextLayout(w r100) {
        return r100.f570621c;
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable r100) {
        if (UIThreadUtils.isOnUiThread() == true) goto L6;
        return;
    L6:
        if (this.mTextraPage != null) goto L21;
        if (r100 == null) goto L21;
        if (this.mHasImage == true) goto L12;
    L19:
        super.invalidateDrawable(r100);
        return;
    L12:
        if ((getText() instanceof Spanned) == false) goto L19;
        Spanned r101 = (Spanned) getText();
        int r102 = 0;
        com.lynx.tasm.behavior.ui.text.a[] r103 = (com.lynx.tasm.behavior.ui.text.a[]) r101.getSpans(0, r101.length(), com.lynx.tasm.behavior.ui.text.a.class);
        int r104 = r103.length;
    L14:
        if (r102 >= r104) goto L19;
        if (r103[r102].c() != r100) goto L18;
        invalidate();
        this.mOverflowPictureDirty = true;
    L18:
        r102 = r102 + 1;
    L21:
        invalidate();
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.View
    public void onDraw(Canvas r100) {
        if (this.mDisplayNone == false) goto L6;
        return;
    L6:
        if (super.getRenderer() == null) goto L12;
        super.getRenderer().g(r100);
        if (this.mTextraPage == null) goto L26;
        drawHighlightWithTextOffset(r100);
        return;
    L26:
        return;
    L12:
        if (this.mTextraPage == null) goto L19;
        int r101 = getPaddingLeft();
        int r102 = getPaddingRight();
        int r103 = getPaddingTop();
        int r104 = getPaddingBottom();
        r100.save();
        if (this.mOverflow != 0) goto L16;
        r100.clipRect(r101, r103, getWidth() - r102, getHeight() - r104);
    L16:
        r100.translate(r101, r103);
        drawHighlight(r100);
        this.mTextraPage.d(r100, this);
        r100.restore();
        return;
    L19:
        if (this.mTextLayout == null) goto L27;
        r100.save();
        r100.translate(getPaddingLeft() + this.mTextTranslateOffset.x, getPaddingTop() + this.mTextTranslateOffset.y);
        if (this.mOverflow == 0) goto L23;
        drawHighlight(r100);
        drawOverflowPicture();
        r100.drawPicture(this.mOverflowPicture);
    L24:
        r100.restore();
        return;
    L23:
        drawText(r100);
        goto L24
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.View
    public boolean onTouchEvent(MotionEvent r100) {
        if (hasTextSelectionContent() == false) goto L25;
        if (this.mEnableTextSelection == false) goto L25;
        if (this.mEnableCustomTextSelection == true) goto L25;
        float r101 = r100.getX() - getPaddingLeft();
        float r102 = r100.getY() - getPaddingTop();
        if (r100.getAction() != 0) goto L13;
        performBeginSelection(r101, r102);
    L22:
        invalidate();
        return true;
    L13:
        if (r100.getAction() != 2) goto L16;
        performMovingSelection(r101, r102);
        goto L22
    L16:
        if (r100.getAction() != 1) goto L19;
        performEndSelection(r101, r102);
        goto L22
    L19:
        if (this.mShouldResponseMove == false) goto L21;
        performEndSelection(r101, r102);
        goto L22
    L21:
        removeCheckLongPressCallback();
    L25:
        return super.onTouchEvent(r100);
    }

    public void setCustomContextMenu(boolean r100) {
        this.mEnableCustomContextMenu = r100;
    }

    public void setCustomTextSelection(boolean r100) {
        this.mEnableCustomTextSelection = r100;
    }

    public void setDisplayNone(boolean r100) {
        this.mDisplayNone = r100;
    }

    public void setEnableTextSelection(boolean r100) {
        this.mEnableTextSelection = r100;
    }

    public void setOverflow(int r100) {
        this.mOverflow = r100;
    }

    public void setTextBundle(w r100) {
        dispatchDetachImageSpan();
        this.mTextraPage = null;
        this.mTextServiceTextLength = 0;
        this.mTextUpdateBundle = r100;
        this.mTextLayout = generateTextLayout(r100);
        this.mTextTranslateOffset = r100.f570623e;
        boolean r101 = r100.f570619a;
        this.mHasImage = r101;
        this.mNeedDrawStroke = r100.f570624f;
        this.mIsJustify = r100.f570620b;
        this.mOriginText = r100.f570625g;
        if (r101 == false) goto L8;
        if ((getText() instanceof Spanned) == false) goto L8;
        com.lynx.tasm.behavior.ui.text.a.i((Spanned) getText(), this);
    L8:
        if (this.mIsInSelection == false) goto L10;
        clearSelection();
    L11:
        setContentDescription(this.mTextLayout.getText());
        invalidate();
        this.mOverflowPictureDirty = true;
        return;
    L10:
        resetSelectionState();
        goto L11
    }

    public void setTextGradient(String r100) {
        LLog.e("text-gradient", "setTextGradient(String) is deprecated, call this function has no effect");
    }

    public void updateSelectionBackgroundColor(int r100) {
        if (r100 != 0) goto L4;
        r100 = DEFAULT_TEXT_SELECTION_COLOR;
    L4:
        this.mTextSelectionColor = r100;
    }

    public void updateSelectionHandleColor(int r100) {
        if (r100 != 0) goto L4;
        r100 = DEFAULT_TEXT_HANDLE_COLOR;
    L4:
        this.mTextSelectionHandleColor = r100;
    }

    public void updateSelectionHandleSize(int r100) {
        if (r100 > 0) goto L4;
        r100 = this.mDefaultHandlePlatformLength;
    L4:
        this.mHandleSize = r100;
    }

    @Override // android.view.View
    public boolean verifyDrawable(Drawable r100) {
        if (this.mHasImage == false) goto L14;
        if ((getText() instanceof Spanned) == false) goto L14;
        Spanned r101 = (Spanned) getText();
        int r102 = 0;
        com.lynx.tasm.behavior.ui.text.a[] r103 = (com.lynx.tasm.behavior.ui.text.a[]) r101.getSpans(0, r101.length(), com.lynx.tasm.behavior.ui.text.a.class);
        int r104 = r103.length;
    L7:
        if (r102 >= r104) goto L14;
        if (r103[r102].c() == r100) goto L10;
        r102 = r102 + 1;
        goto L7
    L10:
        return true;
    L14:
        return super.verifyDrawable(r100);
    }

    public void setTextBundle(ILynxTextService.a r100) {
        dispatchDetachImageSpan();
        this.mTextraPage = r100;
        if (r100 == null) goto L5;
        int r101 = r100.a();
    L6:
        this.mTextServiceTextLength = r101;
        this.mTextUpdateBundle = null;
        this.mTextLayout = null;
        this.mTextTranslateOffset = new PointF();
        this.mHasImage = false;
        this.mNeedDrawStroke = false;
        this.mIsJustify = false;
        this.mOriginText = null;
        if (this.mIsInSelection == false) goto L9;
        clearSelection();
    L10:
        setContentDescription(null);
        invalidate();
        this.mOverflowPictureDirty = true;
        return;
    L9:
        resetSelectionState();
        goto L10
    L5:
        r101 = 0;
        goto L6
    }

    @Skip({"com.bytedance.timonbase.clipboard.ClipboardMonitorManager", "com.bytedance.timon.clipboard.suite.TimonClipboardSuite", "com.bytedance.timon.clipboard.suite.TimonClipboardSuiteKt"})
    public static void INVOKEVIRTUAL_com_lynx_tasm_behavior_ui_text_AndroidText_com_larus_home_impl_utils_ClipboardManagerLancet_setPrimaryClip(ClipboardManager r100, ClipData r101) {
        Intrinsics.checkNotNullParameter(r101, "clip");
        FLogger.f375446a.i("ClipboardManagerLancet", "hook setPrimaryClip");     // Catch: Exception -> L5
        com_lynx_tasm_behavior_ui_text_AndroidText_android_content_ClipboardManager_setPrimaryClip(r100, r101);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        g.f365738a.ensureNotReachHere(e, "setPrimaryClip Exception:");
        FLogger.f375446a.e("ClipboardManagerLancet", "setPrimaryClip Exception: " + e.getMessage());
    }

    public static /* synthetic */ a access$102(AndroidText r100, a r101) {
        r100.mCheckForLongPress = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$202(AndroidText r100, boolean r101) {
        r100.mIsInSelection = r101;
        return r101;
    }

    public static /* synthetic */ int access$502(AndroidText r100, int r101) {
        r100.mSelectEnd = r101;
        return r101;
    }

    public static /* synthetic */ int access$602(AndroidText r100, int r101) {
        r100.mSelectStart = r101;
        return r101;
    }

    public static /* synthetic */ boolean access$702(AndroidText r100, boolean r101) {
        r100.mIsAdjustEndPos = r101;
        return r101;
    }

    private void adjustEndPosition(float r100, float r101) {
        this.mIsAdjustEndPos = true;
        int r102 = getOffsetForPosition(r100, r101);
        if (r102 >= 0) goto L6;
        return;
    L6:
        if (r102 == this.mSelectStart) goto L8;
    L16:
        updateSelectionRange(this.mSelectStart, r102);
        return;
    L8:
        if (this.mTextraPage != null) goto L12;
        if (r102 != this.mTextLayout.getText().length()) goto L12;
    L14:
        r102 = r102 - 1;
    L12:
        if (r100 >= this.mSelectStartPos.x) goto L15;
        if (r102 > 0) goto L14;
    L15:
        r102 = r102 + 1;
        goto L16
    }

    private void adjustStartPosition(float r100, float r101) {
        this.mIsAdjustStartPos = true;
        int r102 = getOffsetForPosition(r100, r101);
        if (r102 >= 0) goto L6;
        return;
    L6:
        if (this.mSelectEnd == r102) goto L8;
    L16:
        updateSelectionRange(r102, this.mSelectEnd);
        return;
    L8:
        if (this.mTextraPage != null) goto L12;
        if (r102 != this.mTextLayout.getText().length()) goto L12;
    L14:
        r102 = r102 - 1;
    L12:
        if (r100 >= this.mSelectEndPos.x) goto L15;
        if (r102 > 0) goto L14;
    L15:
        r102 = r102 + 1;
        goto L16
    }

    private static void com_lynx_tasm_behavior_ui_text_AndroidText_android_content_ClipboardManager_setPrimaryClip(ClipboardManager r110, ClipData r111) {
        ArrayList r100 = new ArrayList();
        Object[] r101 = {r111};
        f06.b r112 = new f06.b();
        g06.a r102 = ApiHookConfig.f245611b.get(101807);
        if (r102 == null) goto L5;
        f06.a[] r103 = r102.f479473i;
    L6:
        f06.a[] r113 = r103;
        int r104 = r113.length;
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L15;
        f06.a r106 = r113[r105];
        int r114 = r105;
        int r115 = r104;
        f06.d r107 = r106.preInvoke(101807, "android/content/ClipboardManager", "setPrimaryClip", r110, r101, "void", r112);     // Catch: Exception -> L21
        if (r107.f474982a == true) goto L17;
        r100.add(r106);     // Catch: Exception -> L21
    L17:
        if (r107.f474982a == false) goto L19;
        return;
    L19:
        r110.setPrimaryClip(r111);
        return;
    L14:
        r105 = r114 + 1;
        r104 = r115;
        goto L8
    L15:
        r107 = new f06.d(false, null);
        goto L17
    L5:
        r103 = ApiHookConfig.f245613d;
        goto L6
    }

    private PointF getBottomPositionForOffset(int r100, boolean r101) {
        float r102 = this.mTextLayout.getPrimaryHorizontal(r100);
        int r103 = this.mTextLayout.getLineForOffset(r100);
        float r104 = this.mTextLayout.getLineBottom(r103);
        if (r100 != this.mTextLayout.getLineStart(r103)) goto L8;
        if (r103 <= 0) goto L8;
        if (r101 == true) goto L8;
        r102 = this.mTextLayout.getWidth();
        r104 = this.mTextLayout.getLineBottom(r103 - 1);
    L8:
        return new PointF(r102, r104);
    }

    private int getOffsetAtCoordinate(int r110, float r111) {
        int r100 = this.mTextLayout.getOffsetForHorizontal(r110, Math.min(getWidth() - 1, Math.max(0.0f, r111)));
        float r101 = this.mTextLayout.getSecondaryHorizontal(r100);
        if (r111 > (((double) r101) + (((double) (this.mTextLayout.getLineRight(r110) - r101)) / 2.0d))) goto L5;
        return r100;
    L5:
        return this.mTextLayout.getLineEnd(r110);
    }

    private int getOffsetForPosition(float r100, float r101) {
        ILynxTextService.a r102 = this.mTextraPage;
        if (r102 == null) goto L7;
        return r102.f(r100, r101);
    L7:
        if (this.mTextLayout != null) goto L11;
        return -1;
    L11:
        return getOffsetAtCoordinate(getLineAtCoordinate(r101), r100);
    }

    private ArrayList<RectF> getTextServiceSelectionBoxes(int r100, int r101) {
        if (r100 > r101) goto L26;
        if (r100 < 0) goto L26;
        if (this.mTextraPage == null) goto L26;
        if (this.mTextServiceSelectionStart == r100) goto L10;
    L13:
        this.mTextServiceSelectionBoxes.clear();
        this.mTextServiceSelectionStart = r100;
        this.mTextServiceSelectionEnd = r101;
        float[] r102 = this.mTextraPage.c(r100, r101);
        if (r102 == null) goto L25;
        if ((r102.length % 4) != 0) goto L25;
        int r103 = 0;
    L20:
        if (r103 >= r102.length) goto L23;
        ArrayList<RectF> r104 = this.mTextServiceSelectionBoxes;
        float r105 = r102[r103];
        float r106 = r102[r103 + 1];
        r104.add(new RectF(r105, r106, r102[r103 + 2] + r105, r102[r103 + 3] + r106));
        r103 = r103 + 4;
        goto L20
    L23:
        return this.mTextServiceSelectionBoxes;
    L25:
        return this.mTextServiceSelectionBoxes;
    L10:
        if (this.mTextServiceSelectionEnd != r101) goto L13;
        return this.mTextServiceSelectionBoxes;
    L26:
        invalidateTextServiceSelectionBoxes();
        return this.mTextServiceSelectionBoxes;
    }

    private void performBeginSelection(float r100, float r101) {
        hideToolbar();
        if (this.mIsInSelection == false) goto L12;
        this.mShouldResponseMove = true;
        if (distanceBetweenPoints(this.mStartHandlerPos, r100, r101) >= 50.0d) goto L8;
        adjustStartPosition(r100, r101);
        requestDisallowInterceptTouchEvent(true);
        goto L12
    L8:
        if (distanceBetweenPoints(this.mEndHandlerPos, r100, r101) >= 50.0d) goto L10;
        adjustEndPosition(r100, r101);
        requestDisallowInterceptTouchEvent(true);
        goto L12
    L10:
        this.mShouldResponseMove = false;
    L12:
        if (this.mIsAdjustEndPos == false) goto L14;
        return;
    L14:
        if (this.mIsAdjustStartPos == true) goto L18;
        removeCheckLongPressCallback();
        a r102 = new a(this, r100, r101);
        this.mCheckForLongPress = r102;
        postDelayed(r102, ViewConfiguration.getLongPressTimeout());
        return;
    }

    private void performEndSelection(float r100, float r101) {
        requestDisallowInterceptTouchEvent(false);
        if (this.mIsInSelection == true) goto L6;
        removeCheckLongPressCallback();
        return;
    L6:
        boolean r102 = this.mIsAdjustEndPos;
        if (r102 == true) goto L13;
        if (this.mIsAdjustStartPos == true) goto L13;
        clearSelection();
        return;
    L13:
        if (this.mIsAdjustStartPos == false) goto L15;
        adjustStartPosition(r100, r101);
        updateSelectStartEnd();
    L17:
        showToolbar();
        this.mIsAdjustStartPos = false;
        this.mIsAdjustEndPos = false;
        return;
    L15:
        if (r102 == false) goto L17;
        adjustEndPosition(r100, r101);
        updateSelectStartEnd();
        goto L17
    }

    private void performMovingSelection(float r100, float r101) {
        a r102 = this.mCheckForLongPress;
        if (r102 == null) goto L10;
        if (Math.abs(r100 - r102.f383075a) <= 1.0f) goto L7;
    L8:
        removeCheckLongPressCallback();
        goto L10
    L7:
        if (Math.abs(r101 - this.mCheckForLongPress.f383076b) > 1.0f) goto L8;
    L10:
        if (this.mIsAdjustStartPos == false) goto L13;
        adjustStartPosition(r100, r101);
        return;
    L13:
        if (this.mIsAdjustEndPos == false) goto L17;
        adjustEndPosition(r100, r101);
        return;
    }

    private void updateSelectionHandlePositionFromBoxes(int r100, int r101) {
        if (this.mTextraPage == null) goto L5;
        ArrayList<RectF> r102 = getTextServiceSelectionBoxes(r100, r101);
    L7:
        if (r102.isEmpty() == false) goto L9;
        return;
    L9:
        RectF r103 = (RectF) ListProtector.get(r102, 0);
        RectF r104 = (RectF) ListProtector.get(r102, r102.size() - 1);
        this.mSelectStartPos.set(r103.left, r103.bottom);
        this.mSelectEndPos.set(r104.right, r104.bottom);
        this.mStartHandlerPos.set(this.mSelectStartPos.x - (this.mSelectionLeftCursor.getBounds().width() / 2.0f), this.mSelectStartPos.y + (this.mSelectionLeftCursor.getBounds().height() / 2.0f));
        this.mEndHandlerPos.set(this.mSelectEndPos.x + (this.mSelectionRightCursor.getBounds().width() / 2.0f), this.mSelectEndPos.y + (this.mSelectionRightCursor.getBounds().height() / 2.0f));
        return;
    L5:
        r102 = getTextBoundingBoxes(r100, r101);
        goto L7
    }

    private void updateSelectionRange(int r100, int r101) {
        if (this.mSelectionLeftCursor != null) goto L5;
        initSelectionCursor(getContext());
    L5:
        updateSelectionStyle();
        int r102 = this.mLastSelectStart;
        if (r102 != (-1)) goto L10;
        if (r101 > r100) goto L13;
    L9:
        boolean r103 = false;
    L14:
        this.mIsForward = r103;
        this.mLastSelectStart = this.mSelectStart;
        this.mLastSelectEnd = this.mSelectEnd;
        this.mSelectStart = r100;
        this.mSelectEnd = r101;
        if (this.mTextraPage == null) goto L20;
        if (r100 < 0) goto L35;
        if (r101 < 0) goto L36;
        updateSelectionHandlePositionFromBoxes(Math.min(r100, r101), Math.max(this.mSelectStart, this.mSelectEnd));
        clearOtherSelection();
        return;
    L36:
        return;
    L35:
        return;
    L20:
        if (r100 < 0) goto L32;
        if (r100 > this.mTextLayout.getText().length()) goto L32;
        int r104 = this.mSelectEnd;
        if (r104 < 0) goto L32;
        if (r104 > this.mTextLayout.getText().length()) goto L32;
        if ((this.mTextLayout.getText() instanceof Spannable) == false) goto L30;
        Selection.setSelection((Spannable) this.mTextLayout.getText(), Math.min(this.mSelectStart, this.mSelectEnd), Math.max(this.mSelectStart, this.mSelectEnd));
    L30:
        this.mSelectStartPos.set(getBottomPositionForOffset(Math.min(this.mSelectStart, this.mSelectEnd), true));
        this.mSelectEndPos.set(getBottomPositionForOffset(Math.max(this.mSelectStart, this.mSelectEnd), false));
        this.mStartHandlerPos.set(this.mSelectStartPos.x - (this.mSelectionLeftCursor.getBounds().width() / 2.0f), this.mSelectStartPos.y + (this.mSelectionLeftCursor.getBounds().height() / 2.0f));
        this.mEndHandlerPos.set(this.mSelectEndPos.x + (this.mSelectionRightCursor.getBounds().width() / 2.0f), this.mSelectEndPos.y + (this.mSelectionRightCursor.getBounds().height() / 2.0f));
        clearOtherSelection();
        return;
    L32:
        if ((this.mTextLayout.getText() instanceof Spannable) == false) goto L38;
        Selection.removeSelection((Spannable) this.mTextLayout.getText());
        return;
    L38:
        return;
    L13:
        r103 = true;
        goto L14
    L10:
        if (r102 < r100) goto L13;
        if (this.mLastSelectEnd >= r101) goto L9;
        goto L9
    }

    public ArrayList<RectF> getTextBoundingBoxes(int r100, int r110) {
        ArrayList<RectF> r101 = new ArrayList();
        if (r100 > r110) goto L24;
        if (r100 < 0) goto L24;
        if (this.mTextraPage != null) goto L9;
        Layout r102 = this.mTextLayout;
        if (r102 == null) goto L24;
        if (r102.getText().length() < r110) goto L24;
        if (r100 != r110) goto L17;
        int r103 = this.mTextLayout.getLineForOffset(r100);
        r101.add(new RectF(0.0f, 0.0f, 0.0f, this.mTextLayout.getLineBottom(r103) - this.mTextLayout.getLineTop(r103)));
        goto L24
    L17:
        int r104 = this.mTextLayout.getLineForOffset(r100);
        int r105 = this.mTextLayout.getLineForOffset(r110);
        int r106 = r104;
    L18:
        if (r106 > r105) goto L24;
        Rect r107 = new Rect();
        this.mTextLayout.getLineBounds(r106, r107);
        if (r106 == r104) goto L22;
        if (r106 == r105) goto L22;
    L23:
        float r108 = r107.left;
        PointF r109 = this.mTextTranslateOffset;
        float r111 = r109.x;
        r107.left = (int) (r108 - r111);
        r107.right = (int) (r107.right - r111);
        float r112 = r107.top;
        float r113 = r109.y;
        r107.top = (int) (r112 - r113);
        r107.bottom = (int) (r107.bottom - r113);
        r101.add(new RectF(r107));
        r106 = r106 + 1;
    L22:
        r107.left = (int) Math.max(r107.left, this.mTextLayout.getSecondaryHorizontal(r100));
        r107.right = (int) Math.min(r107.right, this.mTextLayout.getSecondaryHorizontal(r110));
        goto L23
    L9:
        return new ArrayList(getTextServiceSelectionBoxes(r100, r110));
    L24:
        return r101;
    }

    @Override // android.view.ActionMode.Callback
    public boolean onActionItemClicked(ActionMode r100, MenuItem r101) {
        if (r101.getItemId() != ID_COPY) goto L6;
        performCopy();
    L8:
        invalidate();
        return true;
    L6:
        if (r101.getItemId() != ID_SELECT_ALL) goto L8;
        performSelectAll();
        goto L8
    }

    @Override // android.view.ActionMode.Callback
    public boolean onCreateActionMode(ActionMode r100, Menu r101) {
        r101.add(0, ID_COPY, 0, R.string.copy);
        r101.add(0, ID_SELECT_ALL, 1, R.string.selectAll);
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.View
    public void onMeasure(int r100, int r101) {
        setMeasuredDimension(View.MeasureSpec.getSize(r100), View.MeasureSpec.getSize(r101));
    }

    @Override // android.view.ActionMode.Callback
    public boolean onPrepareActionMode(ActionMode r100, Menu r101) {
        this.mActionMode = r100;
        return false;
    }

    public void setBindSelectionChange(boolean r100, int r101) {
        this.mIsBindSelectionChange = r100;
        this.mSign = r101;
    }

    public static /* synthetic */ int access$000(AndroidText r100, float r101, float r102) {
        return r100.getOffsetForPosition(r101, r102);
    }

    private double distanceBetweenPoints(PointF r100, float r101, float r102) {
        return Math.sqrt(Math.pow(r100.x - r101, 2.0d) + Math.pow(r100.y - r102, 2.0d));
    }

    @Override // com.lynx.tasm.behavior.ui.view.a, android.view.ViewGroup, android.view.View
    public void onLayout(boolean r100, int r101, int r102, int r103, int r104) {
        if (super.getRenderer() != null) goto L5;
        return;
    L5:
        if (super.getRenderer().f562747h == null) goto L7;
        super.getRenderer().f562747h.measure();
    L7:
        super.getRenderer().h();
    }

    private ArrayList<RectF> setTextServiceTextSelection(float r100, float r101, float r102, float r103, boolean r104, boolean r105) {
        invalidate();
        if (r100 >= 0.0f) goto L5;
    L28:
        clearSelection();
        return new ArrayList();
    L5:
        if (r101 < 0.0f) goto L28;
        if (r102 < 0.0f) goto L28;
        if (r103 < 0.0f) goto L28;
        int r106 = getOffsetForPosition(r100, r101);
        int r107 = getOffsetForPosition(r102, r103);
        if (r106 < 0) goto L26;
        if (r107 < 0) goto L26;
        if (r106 != r107) goto L20;
        r107 = r107 + 1;
        if (getTextBoundingBoxes(r106, r107).isEmpty() == false) goto L20;
        if (r106 <= 0) goto L20;
        r106 = r106 - 1;
        r107 = r107 - 1;
    L20:
        ArrayList<RectF> r108 = getTextBoundingBoxes(Math.min(r106, r107), Math.max(r106, r107));
        if (r108.isEmpty() == false) goto L24;
        clearSelection();
        return r108;
    L24:
        this.mIsShowStartHandle = r104;
        this.mIsShowEndHandle = r105;
        this.mIsInSelection = true;
        updateSelectionRange(r106, r107);
        updateSelectStartEnd();
        return r108;
    L26:
        clearSelection();
        return new ArrayList();
    }

    public ArrayList<RectF> setTextSelection(float r100, float r101, float r102, float r103, boolean r104, boolean r105) {
        if (this.mTextraPage != null) goto L5;
        invalidate();
        if (r100 >= 0.0f) goto L9;
    L32:
        clearSelection();
        return new ArrayList();
    L9:
        if (r101 < 0.0f) goto L32;
        if (r102 < 0.0f) goto L32;
        if (r103 < 0.0f) goto L32;
        int r106 = getOffsetForPosition(r100, r101);
        int r107 = getOffsetForPosition(r102, r103);
        if (r106 < 0) goto L30;
        if (r107 < 0) goto L30;
        if (r106 != r107) goto L28;
        PointF r108 = getCenterPositionForOffset(r106);
        if (r106 == this.mTextLayout.getText().length()) goto L27;
        if (r106 > 0) goto L24;
    L26:
        r107 = r107 + 1;
        goto L28
    L24:
        if (r100 >= r108.x) goto L26;
    L27:
        r106 = r106 - 1;
    L28:
        this.mIsShowStartHandle = r104;
        this.mIsShowEndHandle = r105;
        this.mIsInSelection = true;
        updateSelectionRange(r106, r107);
        updateSelectStartEnd();
        return getTextBoundingBoxes(this.mSelectStart, this.mSelectEnd);
    L30:
        clearSelection();
        return new ArrayList();
    L5:
        return setTextServiceTextSelection(r100, r101, r102, r103, r104, r105);
    }
}
