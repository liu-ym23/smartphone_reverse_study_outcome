package com.lynx.tasm.behavior.ui.text;

import android.content.Context;
import android.graphics.RectF;
import android.text.Layout;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.ViewCompat;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyArray;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.base.LLog;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.tasm.behavior.event.EventTarget;
import com.lynx.tasm.behavior.ui.ILynxUIMeaningfulContent$MeaningfulContentStatus;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.lynx.tasm.behavior.ui.accessibility.CustomAccessibilityDelegateCompat;
import com.lynx.tasm.behavior.ui.e;
import com.lynx.tasm.behavior.ui.utils.h;
import com.lynx.tasm.event.EventsListener;
import com.lynx.tasm.service.ILynxTextService;
import java.util.ArrayList;
import java.util.Map;
import z6a.w;

/* JADX INFO: loaded from: classes32.dex */
public class UIText extends UIGroup<AndroidText> {
    private boolean mDisplayNone;
    private Map<Integer, t7a.a> mGestureHandlers;
    private w mTextUpdateBundle;
    private ILynxTextService.a mTextraPage;

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public boolean canConsumeGesture(float r100, float r101) {
        return true;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public int getMemberScrollX() {
        return 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public int getMemberScrollY() {
        return 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public int getScrollContainerDirection() {
        return 0;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public boolean isAtBorder(boolean r100) {
        return false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public void onGestureScrollBy(float r100, float r101) {
    }

    public void setColor(int r100) {
    }

    public void setColor(f6a.a r100) {
    }

    public void setTextGradient(ReadableArray r100) {
    }

    private void dispatchLayoutEventIfNeeded() {
        if (this.mContext.isLayoutInElementModeOn() == true) goto L5;
        return;
    L5:
        if (this.mTextUpdateBundle == null) goto L16;
        Map<String, EventsListener> r100 = this.mEvents;
        if (r100 != null) goto L10;
        return;
    L10:
        if (r100.containsKey("layout") == false) goto L17;
        com.lynx.tasm.behavior.shadow.text.b.c(this.mContext, getSign(), this.mTextUpdateBundle);
        return;
    L17:
        return;
    }

    private void updateSelectionChangeBinding() {
        T r100 = this.mView;
        if (r100 != 0) goto L5;
        return;
    L5:
        AndroidText r101 = (AndroidText) r100;
        Map<String, EventsListener> r102 = this.mEvents;
        if (r102 != null) goto L8;
    L10:
        boolean r103 = false;
    L11:
        r101.setBindSelectionChange(r103, getSign());
        return;
    L8:
        if (r102.containsKey("selectionchange") == false) goto L10;
        r103 = true;
        goto L11
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public ILynxUIMeaningfulContent$MeaningfulContentStatus getMeaningfulContentStatus() {
        T r100 = this.mView;
        if (r100 == 0) goto L9;
        if (((AndroidText) r100).getTextLayout() != null) goto L11;
        if (((AndroidText) this.mView).hasTextraPage() == false) goto L9;
    L11:
        return ILynxUIMeaningfulContent$MeaningfulContentStatus.PRESENTED;
    L9:
        if (this.mTextraPage != null) goto L11;
        return ILynxUIMeaningfulContent$MeaningfulContentStatus.PENDING;
    }

    public CharSequence getOriginText() {
        T r100 = this.mView;
        if (r100 != 0) goto L6;
        return "";
    L6:
        return ((AndroidText) r100).getOriginText();
    }

    public Layout getTextLayout() {
        T r100 = this.mView;
        if (r100 != 0) goto L7;
        return null;
    L7:
        return ((AndroidText) r100).getTextLayout();
    }

    @Override // com.lynx.tasm.behavior.ui.UIGroup, com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void destroy() {
        super.destroy();
        T r100 = this.mView;
        if (r100 == 0) goto L6;
        ((AndroidText) r100).release();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public void didEnsureCreateView() {
        super.didEnsureCreateView();
        T r100 = this.mView;
        if (r100 == 0) goto L5;
        ((AndroidText) r100).setDisplayNone(this.mDisplayNone);
    L5:
        ILynxTextService.a r101 = this.mTextraPage;
        if (r101 == null) goto L8;
        ((AndroidText) this.mView).setTextBundle(r101);
        updateSelectionChangeBinding();
        return;
    L8:
        w r102 = this.mTextUpdateBundle;
        if (r102 == null) goto L13;
        ((AndroidText) this.mView).setTextBundle(r102);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public CharSequence getAccessibilityLabel() {
        CharSequence r100 = super.getAccessibilityLabel();
        if (TextUtils.isEmpty(r100) == true) goto L6;
        return r100;
    L6:
        return ((AndroidText) this.mView).getText();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public Map<Integer, t7a.a> getGestureHandlers() {
        return super.getGestureHandlers();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public void initAccessibilityDelegate() {
        super.initAccessibilityDelegate();
        T r100 = this.mView;
        if (r100 == 0) goto L6;
        ViewCompat.setAccessibilityDelegate(r100, new CustomAccessibilityDelegateCompat(this));
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, p7a.a
    public void onInvalidate() {
        if (isEnableNewGesture() == true) goto L5;
        return;
    L5:
        ViewCompat.postInvalidateOnAnimation(this.mView);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onLayoutUpdated() {
        super.onLayoutUpdated();
        int r100 = this.mPaddingLeft + this.mBorderLeftWidth;
        int r101 = this.mPaddingRight + this.mBorderRightWidth;
        int r102 = this.mPaddingTop + this.mBorderTopWidth;
        int r103 = this.mPaddingBottom + this.mBorderBottomWidth;
        ((AndroidText) this.mView).setPadding(r100, r102, r101, r103);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onNodeReady() {
        super.onNodeReady();
        if (this.mContext.isLayoutInElementModeOn() == false) goto L5;
        updateExtraData(this.mContext.getLynxUIOwner().takeTextLayout(getSign()));
    L5:
        T r100 = this.mView;
        if (((AndroidText) r100).mTextUpdateBundle == null) goto L9;
        b.a(((AndroidText) r100).mTextUpdateBundle, this);
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onPropsUpdated() {
        super.onPropsUpdated();
    }

    public UIText(Context r100) {
        this((LynxContext) r100);
    }

    private void alignOverflowForTextSelection(boolean r100) {
        if (r100 == true) goto L4;
        return;
    L4:
        if (this.mContext.isTextOverflowEnabled() == true) goto L6;
        return;
    L6:
        if (this.mContext.isLayoutInElementModeOn() == true) goto L9;
        return;
    L9:
        if (getOverflow() != 3) goto L11;
        return;
    L11:
        setOverflow(0);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void copyPropFromOldUiInUpdateFlatten(LynxBaseUI r100) {
        super.copyPropFromOldUiInUpdateFlatten(r100);
        if ((r100 instanceof FlattenUIText) == true) goto L5;
        return;
    L5:
        updateExtraData(((FlattenUIText) r100).getTextBundle());
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public AndroidText createView(Context r100) {
        return new AndroidText(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI, com.lynx.tasm.behavior.ui.LynxBaseUI
    @LynxProp(name = "accessibility-label")
    public void setAccessibilityLabel(f6a.a r100) {
        super.setAccessibilityLabel(r100);
        T r101 = this.mView;
        if (r101 == 0) goto L6;
        ((AndroidText) r101).setFocusable(true);
        ((AndroidText) this.mView).setContentDescription(getAccessibilityLabel());
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setConsumeHoverEvent(boolean r100) {
        super.setConsumeHoverEvent(r100);
        T r101 = this.mView;
        if (r101 == 0) goto L6;
        ((AndroidText) r101).setConsumeHoverEvent(this.mConsumeHoverEvent);
        return;
    }

    @LynxProp(defaultBoolean = false, name = "custom-context-menu")
    public void setCustomContextMenu(boolean r100) {
        ((AndroidText) this.mView).setCustomContextMenu(r100);
    }

    @LynxProp(defaultBoolean = false, name = "custom-text-selection")
    public void setCustomTextSelection(boolean r100) {
        ((AndroidText) this.mView).setCustomTextSelection(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setDisplayNone(boolean r100) {
        super.setDisplayNone(r100);
        this.mDisplayNone = r100;
        T r101 = this.mView;
        if (r101 == 0) goto L6;
        ((AndroidText) r101).setDisplayNone(r100);
        return;
    }

    @LynxProp(defaultBoolean = false, name = "text-selection")
    public void setEnableTextSelection(boolean r100) {
        ((AndroidText) this.mView).setEnableTextSelection(r100);
        alignOverflowForTextSelection(r100);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setEvents(Map<String, EventsListener> r100) {
        super.setEvents(r100);
        if (this.mTextraPage == null) goto L6;
        updateSelectionChangeBinding();
        return;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setGestureDetectors(Map<Integer, s7a.a> r100) {
        super.setGestureDetectors(r100);
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isEmpty() == true) goto L10;
        ((AndroidText) this.mView).setGestureManager(getGestureArenaManager());
        return;
    }

    @LynxProp(defaultInt = 0, name = "selection-background-color")
    public void setSelectionBackgroundColor(int r100) {
        ((AndroidText) this.mView).updateSelectionBackgroundColor(r100);
    }

    @LynxProp(defaultInt = 0, name = "selection-handle-color")
    public void setSelectionHandleColor(int r100) {
        ((AndroidText) this.mView).updateSelectionHandleColor(r100);
    }

    @LynxProp(defaultInt = 0, name = "selection-handle-size")
    public void setSelectionHandleSize(int r100) {
        ((AndroidText) this.mView).updateSelectionHandleSize(r100);
    }

    public void setTextGradient(String r100) {
        LLog.e("UIText", "setTextGradient(String) is deprecated");
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void updateExtraData(Object r100) {
        if ((r100 instanceof w) == false) goto L9;
        w r101 = (w) r100;
        this.mTextUpdateBundle = r101;
        this.mTextraPage = null;
        ((AndroidText) this.mView).setTextBundle(r101);
        Map<String, EventsListener> r102 = this.mEvents;
        if (r102 == null) goto L7;
        ((AndroidText) this.mView).setBindSelectionChange(r102.containsKey("selectionchange"), getSign());
    L7:
        dispatchLayoutEventIfNeeded();
        return;
    L9:
        if ((r100 instanceof ILynxTextService.a) == false) goto L16;
        this.mTextUpdateBundle = null;
        ILynxTextService.a r103 = (ILynxTextService.a) r100;
        this.mTextraPage = r103;
        T r104 = this.mView;
        if (r104 == 0) goto L13;
        ((AndroidText) r104).setTextBundle(r103);
    L13:
        updateSelectionChangeBinding();
        return;
    }

    public UIText(LynxContext r100) {
        this(r100, null);
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r100) {
        return createView(r100);
    }

    public UIText(LynxContext r100, Object r101) {
        super(r100, r101);
        this.mDisplayNone = false;
        this.mAccessibilityElementStatus = 1;
        if (this.mContext.isTextOverflowEnabled() == true) goto L5;
        return;
    L5:
        if (this.mContext.isLayoutInElementModeOn() == true) goto L9;
        this.mOverflow = 3;
        return;
    }

    private JavaOnlyMap getHandleMap(ArrayList<Float> r100, RectF r101) {
        JavaOnlyMap r102 = new JavaOnlyMap();
        float r103 = getLynxContext().getScreenMetrics().density;
        r102.putDouble("x", (((r101.left + getPaddingLeft()) + getBorderLeftWidth()) + ((Float) ListProtector.get(r100, 0)).floatValue()) / r103);
        r102.putDouble("y", (((r101.top + getPaddingTop()) + getBorderTopWidth()) + ((Float) ListProtector.get(r100, 1)).floatValue()) / r103);
        r102.putDouble("radius", ((Float) ListProtector.get(r100, 2)).floatValue() / r103);
        return r102;
    }

    private JavaOnlyMap getMapFromRect(RectF r100, RectF r101) {
        JavaOnlyMap r102 = new JavaOnlyMap();
        float r103 = getLynxContext().getScreenMetrics().density;
        r102.putDouble("left", (((r100.left + getPaddingLeft()) + getBorderLeftWidth()) + r101.left) / r103);
        r102.putDouble("top", (((r100.top + getPaddingTop()) + getBorderTopWidth()) + r101.top) / r103);
        r102.putDouble("right", (((r100.left + getPaddingLeft()) + getBorderLeftWidth()) + r101.right) / r103);
        r102.putDouble("bottom", (((r100.top + getPaddingTop()) + getBorderTopWidth()) + r101.bottom) / r103);
        r102.putDouble("width", r101.width() / r103);
        r102.putDouble("height", r101.height() / r103);
        return r102;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public e convertToMeaningfulPaintingArea(int r100, int r101) {
        if (getMeaningfulContentStatus() != ILynxUIMeaningfulContent$MeaningfulContentStatus.IRRELEVANT) goto L6;
        return null;
    L6:
        e r102 = new e(r100 + getOriginLeft(), r101 + getOriginTop(), getWidth(), getHeight());
        T r103 = this.mView;
        if (r103 == 0) goto L9;
        ((AndroidText) r103).getAlpha();
    L10:
        T r104 = this.mView;
        if (r104 == 0) goto L13;
        ((AndroidText) r104).getScaleX();
    L14:
        T r105 = this.mView;
        if (r105 == 0) goto L17;
        ((AndroidText) r105).getScaleY();
    L18:
        T r106 = this.mView;
        if (r106 == 0) goto L21;
        ((AndroidText) r106).getVisibility();
    L22:
        r102.f382492e = getMeaningfulContentStatus();
        r102.f382493f = getFirstMeaningfulContentPresentedTimestampMicros();
        return r102;
    L21:
        getVisibility();
        goto L22
    L17:
        getScaleY();
        goto L18
    L13:
        getScaleX();
        goto L14
    L9:
        getAlpha();
        goto L10
    }

    @LynxUIMethod
    public void getSelectedText(ReadableMap r100, Callback r101) {
        T r102 = this.mView;
        if (r102 == 0) goto L5;
        String r103 = ((AndroidText) r102).getSelectedText();
        JavaOnlyMap r104 = new JavaOnlyMap();
        r104.put("selectedText", r103);
        r101.invoke(new Object[]{0, r104});
        return;
    L5:
        r101.invoke(new Object[]{6});
    }

    @LynxUIMethod
    public void getTextBoundingRect(ReadableMap r100, Callback r101) {
        int r102 = r100.getInt("start");     // Catch: Exception -> L17
        int r103 = r100.getInt("end");     // Catch: Exception -> L17
        if (r102 > r103) goto L15;
        if (r102 < 0) goto L15;
        if (r103 < 0) goto L15;
        T r104 = this.mView;     // Catch: Exception -> L17
        if (r104 == 0) goto L14;
        ArrayList<RectF> r105 = ((AndroidText) r104).getTextBoundingBoxes(r102, r103);     // Catch: Exception -> L17
        if (r105.size() <= 0) goto L14;
        r101.invoke(new Object[]{0, getTextBoundingRectFromBoxes(r105, r100, h.g(this, r100))});     // Catch: Exception -> L17
        return;
    L14:
        r101.invoke(new Object[]{1, "Can not find text bounding rect."});     // Catch: Exception -> L17
        return;
    L15:
        r101.invoke(new Object[]{4, "parameter is invalid"});     // Catch: Exception -> L17
        return;
    L17:
        e = move-exception;
        r101.invoke(new Object[]{1, e.getMessage()});
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public EventTarget hitTest(float r100, float r101) {
        return hitTest(r100, r101, false);
    }

    @LynxUIMethod
    public void setTextSelection(ReadableMap r210, Callback r211) {
        double r110 = getLynxContext().getScreenMetrics().density;     // Catch: Exception -> L35
        double r100 = ((r210.getDouble("startX") * r110) - ((double) getPaddingLeft())) - ((double) getBorderLeftWidth());     // Catch: Exception -> L35
        double r111 = ((r210.getDouble("startY") * r110) - ((double) getPaddingTop())) - ((double) getBorderTopWidth());     // Catch: Exception -> L35
        double r101 = ((r210.getDouble("endX") * r110) - ((double) getPaddingLeft())) - ((double) getBorderLeftWidth());     // Catch: Exception -> L35
        double r102 = ((r210.getDouble("endY") * r110) - ((double) getPaddingTop())) - ((double) getBorderTopWidth());     // Catch: Exception -> L35
        if (r210.hasKey("showStartHandle") == true) goto L6;
    L9:
        boolean r212 = true;
    L11:
        if (r210.hasKey("showEndHandle") == true) goto L13;
    L16:
        boolean r213 = true;
    L17:
        T r103 = this.mView;     // Catch: Exception -> L35
        if (r103 == 0) goto L33;
        ArrayList<RectF> r104 = ((AndroidText) r103).setTextSelection((float) r100, (float) r111, (float) r101, (float) r102, r212, r213);     // Catch: Exception -> L35
        if (r104.size() != 0) goto L22;
        r211.invoke(new Object[]{0});     // Catch: Exception -> L35
        return;
    L22:
        RectF r105 = h.g(this, r210);     // Catch: Exception -> L35
        JavaOnlyMap r106 = getTextBoundingRectFromBoxes(r104, r210, r105);     // Catch: Exception -> L35
        ArrayList<Float>[] r107 = ((AndroidText) this.mView).getHandlesInfo();     // Catch: Exception -> L35
        JavaOnlyArray r108 = new JavaOnlyArray();     // Catch: Exception -> L35
        int r109 = 0;
    L24:
        if (r109 >= r107.length) goto L26;
        r108.add(getHandleMap(r107[r109], r105));     // Catch: Exception -> L35
        r109 = r109 + 1;     // Catch: Exception -> L35
        goto L24
    L26:
        r106.putArray("handles", r108);     // Catch: Exception -> L35
        int r112 = 2;
        Object[] r113 = new Object[2];     // Catch: Exception -> L31
        r113[0] = 0;     // Catch: Exception -> L35
        r113[1] = r106;     // Catch: Exception -> L35
        r211.invoke(r113);     // Catch: Exception -> L35
        return;
    L31:
        e = e;
    L37:
        Object[] r114 = new Object[r112];
        r114[0] = 1;
        r114[1] = e.getMessage();
        r211.invoke(r114);
        return;
    L33:
        r211.invoke(new Object[]{6});     // Catch: Exception -> L35
        return;
    L13:
        if (r210.getBoolean("showEndHandle") == true) goto L16;
        r213 = false;
        goto L17
    L6:
        if (r210.getBoolean("showStartHandle") == true) goto L9;
        r212 = false;
    L35:
        e = e;
        r112 = 2;
        goto L37
    }

    private JavaOnlyMap getTextBoundingRectFromBoxes(ArrayList<RectF> r100, ReadableMap r101, RectF r102) {
        int r103 = 0;
        RectF r104 = new RectF((RectF) ListProtector.get(r100, 0));
        int r105 = 1;
    L4:
        if (r105 >= r100.size()) goto L6;
        r104.union((RectF) ListProtector.get(r100, r105));
        r105 = r105 + 1;
        goto L4
    L6:
        JavaOnlyMap r106 = new JavaOnlyMap();
        r106.putMap("boundingRect", getMapFromRect(r102, r104));
        JavaOnlyArray r107 = new JavaOnlyArray();
    L8:
        if (r103 >= r100.size()) goto L10;
        r107.add(getMapFromRect(r102, (RectF) ListProtector.get(r100, r103)));
        r103 = r103 + 1;
        goto L8
    L10:
        r106.putArray("boxes", r107);
        return r106;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI, com.lynx.tasm.behavior.event.EventTarget
    public EventTarget hitTest(float r110, float r111, boolean r112) {
        T r100 = this.mView;
        if (r100 != 0) goto L5;
        return this;
    L5:
        float r101 = r110 - (this.mPaddingLeft + this.mBorderLeftWidth);
        float r102 = r111 - (this.mPaddingTop + this.mBorderTopWidth);
        Layout r103 = ((AndroidText) r100).mTextLayout;
        AndroidText r104 = (AndroidText) r100;
        Spanned r113 = null;
        if (r104 != null) goto L9;
    L12:
        return b.c(this, r101, r102, this, r103, r113, ((AndroidText) getView()).mTextTranslateOffset, ((AndroidText) this.mView).mTextraPage, r112);
    L9:
        if ((r104.getText() instanceof Spanned) == false) goto L12;
        r113 = (Spanned) r104.getText();
        goto L12
    }
}
