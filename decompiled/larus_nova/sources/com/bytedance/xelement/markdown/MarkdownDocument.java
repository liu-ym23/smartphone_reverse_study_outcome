package com.bytedance.xelement.markdown;

import a7a.f;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.facebook.drawee.drawable.ScalingUtils;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.shadow.NativeLayoutNodeRef;
import com.lynx.tasm.behavior.shadow.ShadowNode;
import com.lynx.tasm.behavior.shadow.text.g;
import com.lynx.tasm.behavior.ui.LynxBaseUI;
import com.lynx.tasm.fontface.FontFaceManager;
import com.lynx.tasm.utils.GradientUtils;
import com.lynx.tasm.utils.UIThreadUtils;
import com.lynx.textra.TTTextUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import kr7.b;
import kr7.i;
import kr7.m;
import kr7.p;
import kr7.q;
import kr7.r;
import kr7.s;
import lr7.c;
import lr7.d;
import lr7.e;
import y6a.j;
import y6a.k;
import y6a.n;

/* JADX INFO: loaded from: classes22.dex */
public class MarkdownDocument {
    public static final int SELECTION_RANGE_CHAR = 0;
    public static final int SELECTION_RANGE_PARAGRAPH = 3;
    public static final int SELECTION_RANGE_SENTENCE = 2;
    public static final int SELECTION_RANGE_WORD = 1;
    private static final int TOUCH_EVENT_CANCEL = 4;
    private static final int TOUCH_EVENT_DOWN = 1;
    private static final int TOUCH_EVENT_MOVE = 2;
    private static final int TOUCH_EVENT_UNKNOWN = 0;
    private static final int TOUCH_EVENT_UP = 3;
    public static final int TOUCH_STATE_NONE = 0;
    public static final int TOUCH_STATE_ON_SCROLL = 1;
    private boolean mDrawDestroyed;
    private long mInstance;
    private boolean mLayoutDestroyed;
    private kr7.a mLoader;
    private d mResourceManager;
    private MarkdownShadowNode mShadowNode;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f272659a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f272660b;

        public a() {
        }
    }

    public static native void initial();

    private native void nativeAddTextMarkAttachment(long r100, byte[] r101);

    private native void nativeAllowBreakAroundPunctuation(long r100, boolean r101);

    private native int nativeCharOffsetToMarkdownOffset(long r100, int r101);

    private native void nativeClearTextMarkAttachment(long r100);

    private native long nativeCreateInstance();

    private native void nativeDestroyInstance(long r100);

    private native byte[] nativeDraw(long r100);

    private native byte[] nativeDrawExtraContent(long r100, int r101);

    private native byte[] nativeDrawRegion(long r100, int r101);

    private native byte[] nativeDrawTypewriterRegion(long r100, int r101, int r102, boolean r103);

    private native byte[] nativeDrawWithCursor(long r100, int r101, boolean r102);

    private native int nativeGetCharIndexByLineIndex(long r100, int r101);

    private native int[] nativeGetCharRangeByPoint(long r100, float r101, float r102, int r103);

    private native String nativeGetContentByCharRange(long r100, int r101, int r102);

    private native float[] nativeGetCursorPosition(long r100, int r101, boolean r102);

    private native int nativeGetExtraContentCount(long r100);

    private native float[] nativeGetExtraContentRect(long r100, int r101);

    private native String nativeGetImageByTouchPosition(long r100, float r101, float r102);

    private native String[] nativeGetImages(long r100);

    private native float[] nativeGetInlineViewOrigin(long r100, String r101);

    private native int nativeGetLineCount(long r100);

    private native int nativeGetLineIndexByCharIndex(long r100, int r101);

    private native String[] nativeGetLinkByPosition(long r100, float r101, float r102);

    private native float[] nativeGetLinkRects(long r100);

    private native String[] nativeGetLinks(long r100);

    private native int nativeGetPageCharCount(long r100);

    private native int nativeGetRegionCount(long r100);

    private native float[] nativeGetRegionRect(long r100, int r101);

    private native float[] nativeGetSelectionRectByCharPos(long r100, long r101, long r102);

    private native int[] nativeGetShowedExtraContent(long r100, float r101, float r102);

    private native int[] nativeGetShowedRegion(long r100, float r101, float r102);

    private native int[] nativeGetSyntaxRange(long r100, String r101);

    private native String nativeGetTextClickByPoint(long r100, float r101, float r102);

    private native int[] nativeGetTypewriterChangedViews(long r100, int r101, int r102);

    private native String[] nativeGetVisibleViews(long r100, int r101, boolean r102);

    private native void nativeInheritState(long r100, long r101);

    private native float[] nativeLayout(long r100, float r101, float r102, int r103);

    private native int nativeMarkdownOffsetToChar(long r100, int r101);

    private native int nativeOnTouchEvent(long r100, int r101, float r102, float r103);

    private native void nativeParse(long r100, String r101, int r102, int r103, float r104);

    public static native void nativeSetDensity(float r100, float r101, float r102);

    private native void nativeSetStyle(long r100, byte[] r101);

    private native boolean nativeTouchPointCanScroll(long r100, float r101, float r102, float r103);

    public synchronized void destroy() {
        monitor-enter(this);
        long r100 = this.mInstance;     // Catch: Throwable -> L8
        if (r100 == 0) goto L6;
        this.mInstance = 0;     // Catch: Throwable -> L8
        nativeDestroyInstance(r100);     // Catch: Throwable -> L8
    L6:
        monitor-exit(this);
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized void destroyDrawData() {
        monitor-enter(this);
        this.mDrawDestroyed = true;     // Catch: Throwable -> L9
        if (this.mLayoutDestroyed == false) goto L7;
        destroy();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public synchronized void destroyLayoutData() {
        monitor-enter(this);
        this.mLayoutDestroyed = true;     // Catch: Throwable -> L9
        if (this.mDrawDestroyed == false) goto L7;
        destroy();     // Catch: Throwable -> L9
    L7:
        monitor-exit(this);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public void clearTextMarkAttachment() {
        long r100 = this.mInstance;
        if (r100 != 0) goto L5;
        return;
    L5:
        nativeClearTextMarkAttachment(r100);
    }

    public int getExtraContentCount() {
        long r100 = this.mInstance;
        if (r100 != 0) goto L7;
        return 0;
    L7:
        return nativeGetExtraContentCount(r100);
    }

    public String[] getImages() {
        long r100 = this.mInstance;
        if (r100 != 0) goto L7;
        return new String[0];
    L7:
        return nativeGetImages(r100);
    }

    public int getLineCount() {
        long r100 = this.mInstance;
        if (r100 != 0) goto L7;
        return 0;
    L7:
        return nativeGetLineCount(r100);
    }

    public ArrayList<s> getLinks() {
        ArrayList<s> r100 = new ArrayList();
        long r101 = this.mInstance;
        if (r101 != 0) goto L5;
        return r100;
    L5:
        String[] r102 = nativeGetLinks(r101);
        float[] r103 = nativeGetLinkRects(this.mInstance);
        if (r102 == null) goto L21;
        if (r103 == null) goto L21;
        int r104 = r103.length / 4;
        int r105 = r104 * 2;
        int r106 = 0;
        if (r102.length != r105) goto L12;
        boolean r107 = true;
    L13:
        if (r107 == false) goto L20;
        if (r102.length == r105) goto L17;
        return r100;
    L17:
        if (r106 >= r104) goto L21;
        int r108 = r106 * 4;
        int r109 = r106 * 2;
        s r110 = new s();
        r110.f505837c = r106;
        r110.f505835a = r102[r109];
        r110.f505836b = r102[r109 + 1];
        r110.f505838d = new RectF(TTTextUtils.Dp2Px(r103[r108]), TTTextUtils.Dp2Px(r103[r108 + 1]), TTTextUtils.Dp2Px(r103[r108 + 2]), TTTextUtils.Dp2Px(r103[r108 + 3]));
        r100.add(r110);
        r106 = r106 + 1;
        goto L17
    L20:
        throw new AssertionError();
    L12:
        r107 = false;
    L21:
        return r100;
    }

    public int getMaxTypewriterStep() {
        long r100 = this.mInstance;
        if (r100 != 0) goto L7;
        return 0;
    L7:
        return nativeGetPageCharCount(r100);
    }

    public int getPageCharCount() {
        long r100 = this.mInstance;
        if (r100 != 0) goto L7;
        return 0;
    L7:
        return nativeGetPageCharCount(r100);
    }

    public int getRegionCount() {
        long r100 = this.mInstance;
        if (r100 != 0) goto L7;
        return 0;
    L7:
        return nativeGetRegionCount(r100);
    }

    public d getResourceManager() {
        return this.mResourceManager;
    }

    public void addTextMarkAttachment(ReadableArray r100) {
        if (this.mInstance != 0) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        return;
    L7:
        b r101 = new b();
        r101.a(r100.asArrayList());     // Catch: IOException -> L10
        nativeAddTextMarkAttachment(this.mInstance, r101.f505723a.toByteArray());     // Catch: IOException -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public void allowBreakAroundPunctuation(boolean r100) {
        long r101 = this.mInstance;
        if (r101 != 0) goto L5;
        return;
    L5:
        nativeAllowBreakAroundPunctuation(r101, r100);
    }

    public int charOffsetToMarkdownOffset(int r100) {
        long r101 = this.mInstance;
        if (r101 != 0) goto L7;
        return 0;
    L7:
        return nativeCharOffsetToMarkdownOffset(r101, r100);
    }

    public void draw(e r100) {
        long r101 = this.mInstance;
        if (r101 != 0) goto L5;
        return;
    L5:
        r100.a(nativeDraw(r101));
    }

    public int getCharIndexByLineIndex(int r100) {
        long r101 = this.mInstance;
        if (r101 != 0) goto L7;
        return 0;
    L7:
        return nativeGetCharIndexByLineIndex(r101, r100);
    }

    public float[] getExtraContentRect(int r100) {
        long r101 = this.mInstance;
        if (r101 == 0) goto L5;
        float[] r102 = nativeGetExtraContentRect(r101, r100);
        r102[0] = TTTextUtils.Dp2Px(r102[0]);
        r102[1] = TTTextUtils.Dp2Px(r102[1]);
        r102[2] = TTTextUtils.Dp2Px(r102[2]);
        r102[3] = TTTextUtils.Dp2Px(r102[3]);
        return r102;
    L5:
        return new float[4];
    }

    public float[] getInlineViewOrigin(String r100) {
        long r101 = this.mInstance;
        if (r101 == 0) goto L5;
        float[] r102 = nativeGetInlineViewOrigin(r101, r100);
        r102[0] = TTTextUtils.Dp2Px(r102[0]);
        r102[1] = TTTextUtils.Dp2Px(r102[1]);
        return r102;
    L5:
        return new float[2];
    }

    public int getLineIndexByCharIndex(int r100) {
        long r101 = this.mInstance;
        if (r101 != 0) goto L7;
        return 0;
    L7:
        return nativeGetLineIndexByCharIndex(r101, r100);
    }

    public float[] getRegionRect(int r100) {
        long r101 = this.mInstance;
        if (r101 == 0) goto L5;
        float[] r102 = nativeGetRegionRect(r101, r100);
        r102[0] = TTTextUtils.Dp2Px(r102[0]);
        r102[1] = TTTextUtils.Dp2Px(r102[1]);
        r102[2] = TTTextUtils.Dp2Px(r102[2]);
        r102[3] = TTTextUtils.Dp2Px(r102[3]);
        return r102;
    L5:
        return new float[4];
    }

    public float[] getRunDelegateSize(int r100) {
        c r101 = this.mResourceManager.b(r100);
        float[] r102 = {0.0f, 0.0f, 0.0f};
        if (r101 != null) goto L5;
        return r102;
    L5:
        r102[0] = TTTextUtils.Px2Dp(r101.b());
        r102[1] = TTTextUtils.Px2Dp(r101.c());
        r102[2] = TTTextUtils.Px2Dp(r101.a());
        return r102;
    }

    public ArrayList<a> getSyntaxRanges(String r100) {
        long r101 = this.mInstance;
        if (r101 != 0) goto L6;
        return null;
    L6:
        int[] r102 = nativeGetSyntaxRange(r101, r100);
        int r103 = r102.length / 2;
        ArrayList<a> r104 = new ArrayList();
        int r105 = 0;
    L7:
        if (r105 >= r103) goto L9;
        a r106 = new a();
        int r107 = r105 * 2;
        r106.f272659a = r102[r107];
        r106.f272660b = r102[r107 + 1];
        r104.add(r106);
        r105 = r105 + 1;
        goto L7
    L9:
        return r104;
    }

    public void inheritState(MarkdownDocument r100) {
        long r101 = this.mInstance;
        if (r101 == 0) goto L9;
        long r102 = r100.mInstance;
        if (r102 == 0) goto L10;
        nativeInheritState(r101, r102);
        return;
    L10:
        return;
    }

    public int markdownOffsetToChar(int r100) {
        long r101 = this.mInstance;
        if (r101 != 0) goto L7;
        return 0;
    L7:
        return nativeMarkdownOffsetToChar(r101, r100);
    }

    public void onTextOverflow(String r100) {
        MarkdownShadowNode r101 = this.mShadowNode;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101 != null) goto L7;
        return;
    L7:
        if (r101.E("overflow") == false) goto L12;
        m7a.a r102 = new m7a.a(r101.f382203b, "overflow");
        r102.a("type", r100);
        UIThreadUtils.runOnUiThread(new i(r101, r102));
        return;
    }

    public void setStyle(ReadableMap r100) {
        long r101 = this.mInstance;
        if (r101 != 0) goto L5;
        return;
    L5:
        if (r100 != null) goto L7;
        nativeSetStyle(r101, null);
        return;
    L7:
        b r102 = new b();
        r102.b(r100.asHashMap());     // Catch: IOException -> L10
        nativeSetStyle(this.mInstance, r102.f505723a.toByteArray());     // Catch: IOException -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
    }

    public MarkdownDocument(kr7.a r100, MarkdownShadowNode r101) {
        this.mLoader = r100;
        this.mInstance = nativeCreateInstance();
        this.mResourceManager = new d();
        this.mShadowNode = r101;
        this.mLayoutDestroyed = false;
        this.mDrawDestroyed = false;
    }

    public void drawExtraContent(e r100, int r101) {
        long r102 = this.mInstance;
        if (r102 != 0) goto L5;
        return;
    L5:
        r100.a(nativeDrawExtraContent(r102, r101));
    }

    public void drawRegion(e r100, int r101) {
        long r102 = this.mInstance;
        if (r102 != 0) goto L5;
        return;
    L5:
        r100.a(nativeDrawRegion(r102, r101));
    }

    public float[] findCursorPosition(int r100, boolean r101) {
        long r102 = this.mInstance;
        if (r102 == 0) goto L5;
        float[] r103 = nativeGetCursorPosition(r102, r100, r101);
        r103[0] = TTTextUtils.Dp2Px(r103[0]);
        r103[1] = TTTextUtils.Dp2Px(r103[1]);
        r103[3] = TTTextUtils.Dp2Px(r103[3]);
        return r103;
    L5:
        return new float[4];
    }

    public String getContentByCharRange(int r100, int r101) {
        long r102 = this.mInstance;
        if (r102 != 0) goto L7;
        return "";
    L7:
        return nativeGetContentByCharRange(r102, r100, r101);
    }

    public String getImageByTouchPosition(float r100, float r101) {
        long r102 = this.mInstance;
        if (r102 != 0) goto L7;
        return null;
    L7:
        return nativeGetImageByTouchPosition(r102, TTTextUtils.Px2Dp(r100), TTTextUtils.Px2Dp(r101));
    }

    public String[] getLinkByTouchPosition(float r100, float r101) {
        long r102 = this.mInstance;
        if (r102 != 0) goto L7;
        return null;
    L7:
        return nativeGetLinkByPosition(r102, TTTextUtils.Px2Dp(r100), TTTextUtils.Px2Dp(r101));
    }

    public ArrayList<RectF> getSelectionRectByCharPos(long r100, long r110) {
        long r101 = this.mInstance;
        if (r101 == 0) goto L5;
        float[] r102 = nativeGetSelectionRectByCharPos(r101, r100, r110);
        int r103 = 0;
        if (r102 != null) goto L9;
        int r111 = 0;
    L10:
        ArrayList<RectF> r112 = new ArrayList(r111);
    L11:
        if (r103 >= r111) goto L13;
        int r104 = r103 * 4;
        r112.add(new RectF(TTTextUtils.Dp2Px(r102[r104]), TTTextUtils.Dp2Px(r102[r104 + 1]), TTTextUtils.Dp2Px(r102[r104 + 2]), TTTextUtils.Dp2Px(r102[r104 + 3])));
        r103 = r103 + 1;
        goto L11
    L13:
        return r112;
    L9:
        r111 = r102.length / 4;
        goto L10
    L5:
        return new ArrayList();
    }

    public int[] getShowedExtraContent(float r100, float r101) {
        long r102 = this.mInstance;
        if (r102 != 0) goto L7;
        return new int[2];
    L7:
        return nativeGetShowedExtraContent(r102, TTTextUtils.Px2Dp(r100), TTTextUtils.Px2Dp(r101));
    }

    public int[] getShowedRegion(float r100, float r101) {
        long r102 = this.mInstance;
        if (r102 != 0) goto L7;
        return new int[2];
    L7:
        return nativeGetShowedRegion(r102, TTTextUtils.Px2Dp(r100), TTTextUtils.Px2Dp(r101));
    }

    public String getTextClickByPoint(float r100, float r101) {
        long r102 = this.mInstance;
        if (r102 != 0) goto L7;
        return null;
    L7:
        return nativeGetTextClickByPoint(r102, TTTextUtils.Px2Dp(r100), TTTextUtils.Px2Dp(r101));
    }

    public int[] getTypewriterChangedRegions(int r100, int r101) {
        long r102 = this.mInstance;
        if (r102 != 0) goto L7;
        return new int[]{0, -1};
    L7:
        return nativeGetTypewriterChangedViews(r102, r100, r101);
    }

    public String[] getVisibleInlineViews(int r100, boolean r101) {
        long r102 = this.mInstance;
        if (r102 != 0) goto L7;
        return new String[0];
    L7:
        return nativeGetVisibleViews(r102, r100, r101);
    }

    public int loadFont(String r100, int r101) {
        kr7.a r102 = this.mLoader;
        if (r102 != null) goto L5;
        return 0;
    L5:
        MarkdownShadowNode r103 = (MarkdownShadowNode) r102;
        if (r101 <= 400) goto L8;
        int r104 = 1;
    L9:
        if (r100 != null) goto L11;
    L14:
        Typeface r105 = Typeface.defaultFromStyle(r104);
    L15:
        if (r105 != null) goto L17;
    L19:
        if (r100 != null) goto L21;
    L24:
        if (r105 == null) goto L28;
        d r106 = this.mResourceManager;
        r106.getClass();
        return r106.f510436c.CreateOrRegisterTypeface(r105, r100, 400, false).mIndex;
    L28:
        return 0;
    L21:
        if (r100.isEmpty() == true) goto L24;
        if (r105 != null) goto L24;
        FontFaceManager.g.f383410a.g(r103.getContext(), r100, r104, new MarkdownShadowNode.c(r103));
        goto L24
    L17:
        if (Build.VERSION.SDK_INT < 28) goto L19;
        r105 = Typeface.create(r105, r101, false);
        goto L19
    L11:
        if (r100.isEmpty() == true) goto L14;
        r105 = g.d(r103.getContext(), r100, r104);
        goto L15
    L8:
        r104 = 0;
        goto L9
    }

    public void drawWithCursor(e r100, int r101, boolean r102) {
        long r103 = this.mInstance;
        if (r103 != 0) goto L5;
        return;
    L5:
        r100.a(nativeDrawWithCursor(r103, r101, r102));
    }

    public int[] getCharRangeByPoint(float r100, float r101, int r102) {
        long r103 = this.mInstance;
        if (r103 != 0) goto L7;
        return new int[2];
    L7:
        return nativeGetCharRangeByPoint(r103, TTTextUtils.Px2Dp(r100), TTTextUtils.Px2Dp(r101), r102);
    }

    public float[] layoutMarkdown(float r100, float r101, int r110) {
        long r102 = this.mInstance;
        if (r102 == 0) goto L5;
        float[] r103 = nativeLayout(r102, TTTextUtils.Px2Dp(r100), TTTextUtils.Px2Dp(r101), r110);
        if (r103 == null) goto L14;
        if (r103.length < 2) goto L14;
        r103[0] = TTTextUtils.Dp2Px(r103[0]);
        r103[1] = TTTextUtils.Dp2Px(r103[1]);
        return r103;
    L14:
        return new float[2];
    L5:
        return new float[2];
    }

    public int loadGradient(String r110, float r111, float r112) {
        kr7.a r100 = this.mLoader;
        if (r100 != null) goto L5;
        return 0;
    L5:
        MarkdownShadowNode r101 = (MarkdownShadowNode) r100;
        if (TextUtils.isEmpty(r110) == true) goto L18;
        DisplayMetrics r102 = r101.getContext().getScreenMetrics();
        float r103 = r102.widthPixels;
        com.lynx.react.bridge.mapbuffer.e r113 = GradientUtils.a(r110, r103, r112, r111, r103, r102.heightPixels);
        if (r113 == null) goto L18;
        long r114 = r113.getLong(0);
        if (r114 != 2) goto L13;
        m r115 = new m(new f(r113.getArray(1)));
    L20:
        return this.mResourceManager.a(r115);
    L13:
        if (r114 != 3) goto L16;
        r115 = new m(new a7a.i(r113.getArray(1)));
        goto L20
    L16:
        if (r114 != 4) goto L18;
        r115 = new m(new a7a.a(r113.getArray(1)));
    L18:
        r115 = null;
        goto L20
    }

    public int measureInlineView(String r110, float r111, float r112) {
        kr7.a r100 = this.mLoader;
        if (r100 != null) goto L5;
        return 0;
    L5:
        float r113 = TTTextUtils.Dp2Px(r111);
        float r114 = TTTextUtils.Dp2Px(r112);
        MarkdownShadowNode r101 = (MarkdownShadowNode) r100;
        int r102 = 0;
    L7:
        if (r102 >= r101.l()) goto L47;
        ShadowNode r103 = r101.k(r102);
        if ((r103 instanceof NativeLayoutNodeRef) == false) goto L46;
        NativeLayoutNodeRef r104 = (NativeLayoutNodeRef) r103;
        String r105 = r104.f382216z;
        if (r105 == null) goto L46;
        if (r105.equals(r110) == false) goto L46;
        j r106 = new j();
        if (r113 > 0.0f) goto L18;
        r113 = r101.U.f566410a;
    L18:
        r106.f566410a = r113;
        if (r114 > 0.0f) goto L22;
        r114 = r101.U.f566412c;
    L22:
        r106.f566412c = r114;
        j r115 = r101.U;
        r106.f566411b = r115.f566411b;
        r106.f566413d = r115.f566413d;
        k r116 = r104.E(r101.V, r106);
        n r117 = r104.f382221n;
        LynxBaseUI r118 = r101.getContext().getLynxUIOwner().findLynxUIBySign(r103.f382203b);
        float[] r119 = r116.f566414a;
        r r107 = new r((int) r119[0], (int) r119[1], (int) r119[2], r110, r118);
        if (r117 == null) goto L49;
        int r120 = r117.f566415a;
        float r121 = r117.f566416b;
        float r122 = r101.f272668k1;
        if (r120 != 9) goto L28;
        r107.f505831c = r121;
        goto L49
    L28:
        if (r120 != 11) goto L30;
    L45:
        r107.f505831c = ((r107.f505840b + (r122 * 0.68f)) / 2.0f) - r107.f505832d;
        goto L49
    L30:
        if (r120 == 6) goto L45;
        if (r120 != 4) goto L35;
    L44:
        r107.f505831c = (r122 * 0.92f) - r107.f505832d;
        goto L49
    L35:
        if (r120 == 5) goto L44;
        if (r120 != 7) goto L40;
    L43:
        r107.f505831c = (r107.f505840b - r107.f505832d) - (r122 * 0.24f);
        goto L49
    L40:
        if (r120 == 8) goto L43;
        r107.f505831c = 0.0f;
    L49:
        return this.mResourceManager.a(r107);
    L46:
        r102 = r102 + 1;
        goto L7
    L47:
        r107 = null;
        goto L49
    }

    public int onTouchEvent(int r100, float r101, float r102) {
        long r103 = this.mInstance;
        if (r103 != 0) goto L5;
        return 0;
    L5:
        int r104 = 1;
        if (r100 == 0) goto L16;
        if (r100 == 1) goto L14;
        r104 = 2;
        if (r100 == 2) goto L16;
        if (r100 == 3) goto L13;
        r104 = 0;
        goto L16
    L13:
        r104 = 4;
        goto L16
    L14:
        r104 = 3;
    L16:
        return nativeOnTouchEvent(r103, r104, TTTextUtils.Px2Dp(r101), TTTextUtils.Px2Dp(r102));
    }

    public boolean touchPointCanScroll(float r100, float r101, float r102) {
        long r103 = this.mInstance;
        if (r103 != 0) goto L7;
        return false;
    L7:
        return nativeTouchPointCanScroll(r103, TTTextUtils.Px2Dp(r100), TTTextUtils.Px2Dp(r101), TTTextUtils.Px2Dp(r102));
    }

    public void drawTypewriterRegion(e r100, int r101, int r102, boolean r110) {
        long r103 = this.mInstance;
        if (r103 != 0) goto L5;
        return;
    L5:
        r100.a(nativeDrawTypewriterRegion(r103, r101, r102, r110));
    }

    public void parseMarkdown(String r100, int r101, int r110, float r111) {
        long r102 = this.mInstance;
        if (r102 == 0) goto L8;
        if (r100 == null) goto L9;
        nativeParse(r102, r100, r101, r110, TTTextUtils.Px2Dp(r111));
        return;
    L9:
        return;
    }

    public int loadImage(String r110, float r111, float r112, float r113, float r114) {
        kr7.a r100 = this.mLoader;
        if (r100 != null) goto L6;
        return 0;
    L6:
        float r115 = TTTextUtils.Dp2Px(r111);
        float r116 = TTTextUtils.Dp2Px(r112);
        float r117 = TTTextUtils.Dp2Px(r113);
        float r118 = TTTextUtils.Dp2Px(r114);
        MarkdownShadowNode r101 = (MarkdownShadowNode) r100;
        p r102 = (p) ((HashMap) r101.T1).get(r110);
        if (r102 != null) goto L10;
        r102 = new p(r110, r101.getContext(), r101.D, ScalingUtils.ScaleType.FIT_CENTER, r101.V0, r101.f272664b1);
        ((HashMap) r101.T1).put(r110, r102);
    L10:
        if (r102.f505822d == false) goto L35;
        float r119 = r102.f505819a;
        float r103 = r102.f505820b;
        if (r115 > 0.0f) goto L14;
    L16:
        if (r115 <= 0.0f) goto L19;
        r116 = (r103 * r115) / r119;
    L23:
        if (r117 > 0.0f) goto L25;
    L27:
        r117 = r115;
    L29:
        if (r118 > 0.0f) goto L31;
    L33:
        r118 = r116;
    L34:
        q r120 = new q(r102, (int) r117, (int) r118);
    L37:
        return this.mResourceManager.a(r120);
    L31:
        if (r116 <= r118) goto L33;
        r117 = r117 * (r118 / r116);
        goto L34
    L25:
        if (r115 <= r117) goto L27;
        r116 = r116 * (r117 / r115);
        goto L29
    L19:
        if (r116 <= 0.0f) goto L21;
        r115 = (r119 * r116) / r103;
        goto L23
    L21:
        r115 = r119;
        r116 = r103;
        goto L23
    L14:
        if (r116 <= 0.0f) goto L16;
    L35:
        r120 = null;
        goto L37
    }
}
