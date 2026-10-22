package com.lynx.xelement.viewpager.viewpager;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.caijing.sdk.infra.base.api.face.FaceService;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.lynx.react.bridge.Callback;
import com.lynx.react.bridge.JavaOnlyMap;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.EventEmitter;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.LynxUIMethod;
import com.lynx.xelement.viewpager.Pager;
import com.lynx.xelement.viewpager.childitem.LynxViewpagerItem;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttvideoengine.model.SubInfo;
import java.util.Arrays;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 F2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001GB\u001b\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010B\u0012\b\u0010(\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\bC\u0010DB\u0013\b\u0016\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010B¢\u0006\u0004\bC\u0010EJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\b\u0010\u0010\u001a\u00020\u0006H\u0016J\u0012\u0010\u0011\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014J\u0018\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\bH\u0016J/\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0016\u0010\u0019\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00180\u0017\"\u0004\u0018\u00010\u0018H\u0014¢\u0006\u0004\b\u001a\u0010\u001bJ\u0010\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\nH\u0007J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\nH\u0007J\u0010\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\nH\u0007J\u0010\u0010!\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\nH\u0007J\u0010\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\nH\u0007J\u0010\u0010%\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\bH\u0007J\u0010\u0010&\u001a\u00020\u00062\u0006\u0010\u001c\u001a\u00020\nH\u0007J\u001a\u0010+\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)H\u0017J\u0010\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\bH\u0016J\u001a\u0010.\u001a\u00020\u00062\u0006\u0010(\u001a\u00020'2\b\u0010*\u001a\u0004\u0018\u00010)H\u0007J\b\u0010/\u001a\u00020\u0006H\u0016J\b\u00100\u001a\u00020\u0006H\u0016J\u000e\u00102\u001a\u00020\u00062\u0006\u00101\u001a\u00020\u0015J \u00105\u001a\u00020\u00062\u0006\u00103\u001a\u00020\u00152\u0006\u0010\t\u001a\u00020\b2\u0006\u00104\u001a\u00020\u0015H\u0016J\u0010\u00106\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\b\u00107\u001a\u00020\nH\u0016R\u0016\u00108\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00109R\u0016\u0010:\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b<\u00109R\u0016\u0010=\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b=\u00109R\u0016\u0010>\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0016\u0010@\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b@\u0010?R\u0016\u0010A\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bA\u00109¨\u0006H"}, d2 = {"Lcom/lynx/xelement/viewpager/viewpager/LynxUIViewPager;", "Lcom/lynx/xelement/viewpager/viewpager/BaseLynxViewPager;", "Lcom/lynx/xelement/viewpager/viewpager/CustomViewPager;", "Lcom/lynx/xelement/viewpager/viewpager/a;", "", "positionOffset", "", "recognizeGestureWhenScroll", "", "index", "", "dragged", "sendTabWillChangeEvent", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "createView", "onNodeReload", "initListener", "Lcom/lynx/xelement/viewpager/childitem/LynxViewpagerItem;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "addPagerChildItem", "", SubInfo.KEY_FORMAT, "", "", "args", "handleFormatStr", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;", "enable", "setPageChangeAnimation", "setForceCanScroll", "setSinglePageTouch", "isAlwaysOverScroll", "setAndroidAlwaysOverscroll", "isDistinguish", "setDistinguishSwipeTap", "selectIndex", "setInitialSelect", "setEnableScroll", "Lcom/lynx/react/bridge/ReadableMap;", "params", "Lcom/lynx/react/bridge/Callback;", "callback", "selectTab", "overflow", "setOverflow", "setDragGesture", "initViewPagerChangeListener", "onNodeReady", "offset", "sendOffsetChangeEvent", "tag", "scene", "sendTabChangeEvent", "selectIndexIsSet", "isScrollContainer", "mDragged", "Z", "mLastOffset", FaceService.girlLabel, "mDistinguishTapSwap", "mSinglePageTouch", "mIndexSelectedWhileIdle", "I", "mInitialSelectIndex", "mDraggingDetectedByDraggingAndActionUp", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;Ljava/lang/Object;)V", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "ViewPager_release"}, k = 1, mv = {1, 6, 0})
public class LynxUIViewPager extends BaseLynxViewPager<CustomViewPager, com.lynx.xelement.viewpager.viewpager.a> {
    public static final String BIND_ON_WILL_CHANGED = "willchange";
    public static final a Companion = null;
    public static final int INVALID_VIEW_PAGER_INDEX = -1;
    private boolean mDistinguishTapSwap;
    private boolean mDragged;
    private boolean mDraggingDetectedByDraggingAndActionUp;
    private int mIndexSelectedWhileIdle;
    private int mInitialSelectIndex;
    private float mLastOffset;
    private boolean mSinglePageTouch;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements CustomViewPager.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LynxUIViewPager f384349a;

        public b(LynxUIViewPager r100) {
            this.f384349a = r100;
        }

        @Override // com.lynx.xelement.viewpager.viewpager.CustomViewPager.a
        public final void onTouch(MotionEvent r100) {
            if (r100 == null) goto L4;
            Integer r101 = Integer.valueOf(r100.getActionMasked());
        L6:
            if (r101 != null) goto L9;
        L14:
            if (r101 != null) goto L17;
            return;
        L17:
            if (r101.intValue() == 3) goto L19;
            return;
        L19:
            if (LynxUIViewPager.access$getMDraggingDetectedByDraggingAndActionUp$p(this.f384349a) == false) goto L21;
            LynxUIViewPager r102 = this.f384349a;
            LynxUIViewPager.access$sendTabWillChangeEvent(r102, r102.getMPager().getMViewPager().getCurrentItem(), true);
        L21:
            LynxUIViewPager.access$setMDraggingDetectedByDraggingAndActionUp$p(this.f384349a, false);
            return;
        L9:
            if (r101.intValue() != 1) goto L14;
            if (LynxUIViewPager.access$getMDraggingDetectedByDraggingAndActionUp$p(this.f384349a) == false) goto L13;
            LynxUIViewPager r103 = this.f384349a;
            LynxUIViewPager.access$sendTabWillChangeEvent(r103, r103.getMPager().getMViewPager().getCurrentItem(), true);
        L13:
            LynxUIViewPager.access$setMDraggingDetectedByDraggingAndActionUp$p(this.f384349a, false);
            return;
        L4:
            r101 = null;
            goto L6
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public boolean isScrollContainer() {
        return true;
    }

    @Override // com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager
    public void initViewPagerChangeListener() {
        getMPager().getMViewPager().addOnPageChangeListener(new AnonymousClass1(this));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onNodeReady() {
        super.onNodeReady();
        if (this.mFirstRender == false) goto L13;
        int r100 = this.mInitialSelectIndex;
        if (r100 == (-1)) goto L13;
        if (r100 < 0) goto L13;
        PagerAdapter r101 = getMPager().getMViewPager().getAdapter();
        if (r101 == null) goto L10;
        int r102 = r101.getCount();
    L11:
        if (r100 >= r102) goto L13;
        getMPager().setCurrentSelectIndex(this.mInitialSelectIndex);
        this.mIndexSelectedWhileIdle = getMPager().getMViewPager().getCurrentItem();
        goto L13
    L10:
        r102 = 0;
    L13:
        this.mFirstRender = false;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void onNodeReload() {
        super.onNodeReload();
        getMPager().f384326a.setCurrentItem(0, false);
    }

    public LynxUIViewPager(LynxContext r100) {
        this(r100, null);
    }

    public static final /* synthetic */ boolean access$getMDraggingDetectedByDraggingAndActionUp$p(LynxUIViewPager r100) {
        return r100.mDraggingDetectedByDraggingAndActionUp;
    }

    public static final /* synthetic */ int access$getMIndexSelectedWhileIdle$p(LynxUIViewPager r100) {
        return r100.mIndexSelectedWhileIdle;
    }

    public static final /* synthetic */ boolean access$getMSinglePageTouch$p(LynxUIViewPager r100) {
        return r100.mSinglePageTouch;
    }

    private final void recognizeGestureWhenScroll(float r100) {
        if (this.mDistinguishTapSwap == true) goto L5;
        return;
    L5:
        if (this.mLastOffset != r100) goto L7;
        boolean r101 = true;
    L8:
        if (r101 == true) goto L12;
        recognizeGesturere();
        this.mLastOffset = r100;
        return;
    L12:
        return;
    L7:
        r101 = false;
        goto L8
    }

    @Override // com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager, com.lynx.tasm.behavior.ui.LynxUI
    public com.lynx.xelement.viewpager.viewpager.a createView(Context r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        setMPager(new com.lynx.xelement.viewpager.viewpager.a(r100));
        initListener(r100);
        return getMPager();
    }

    @Override // com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager
    public void initListener(Context r100) {
        super.initListener(r100);
        getMPager().getMViewPager().setMTouchHandler(new b(this));
    }

    @Override // com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager
    public void selectIndexIsSet(int r100) {
        if (this.mIndexSelectedWhileIdle == r100) goto L6;
        this.mIndexSelectedWhileIdle = r100;
        sendTabChangeEvent("", r100, "");
        return;
    }

    public final void sendOffsetChangeEvent(String r100) {
        Intrinsics.checkNotNullParameter(r100, "offset");
        EventEmitter r101 = getLynxContext().getEventEmitter();
        m7a.a r102 = new m7a.a(getSign(), BaseLynxViewPager.BIND_OFFSET_CHANGE);
        r102.a("offset", r100);
        r101.sendCustomEvent(r102);
    }

    @LynxProp(defaultBoolean = false, name = "android-always-overscroll")
    public final void setAndroidAlwaysOverscroll(boolean r100) {
        getMPager().setViewPagerOverScrollMode(r100);
    }

    @LynxProp(defaultBoolean = true, name = "android-distinguish-swipe-tap")
    public final void setDistinguishSwipeTap(boolean r100) {
        this.mDistinguishTapSwap = r100;
    }

    @LynxProp(name = "enable-scroll")
    public final void setEnableScroll(boolean r100) {
        getMPager().setAllowHorizontalGesture(r100);
    }

    @LynxProp(name = "android-force-can-scroll")
    public final void setForceCanScroll(boolean r100) {
        getMPager().setForceCanScroll(r100);
    }

    @LynxProp(name = "initial-select-index")
    public final void setInitialSelect(int r100) {
        this.mInitialSelectIndex = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxBaseUI
    public void setOverflow(int r100) {
        super.setOverflow(r100);
        boolean r101 = true;
        if (r100 == 1) goto L6;
        r101 = false;
    L6:
        getMPager().setClipChildren(r101);
        getMPager().getMViewPager().setClipChildren(r101);
    }

    @LynxProp(name = "page-change-animation")
    public final void setPageChangeAnimation(boolean r100) {
        getMPager().setPagerChangeAnimation(r100);
    }

    @LynxProp(name = "single-page-touch")
    public final void setSinglePageTouch(boolean r100) {
        this.mSinglePageTouch = r100;
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ View createView(Context r100) {
        return createView(r100);
    }

    @Override // com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager, com.lynx.tasm.behavior.ui.LynxUI
    public /* bridge */ /* synthetic */ Pager createView(Context r100) {
        return createView(r100);
    }

    public LynxUIViewPager(LynxContext r100, Object r101) {
        super(r100, r101);
        this.mDistinguishTapSwap = true;
        this.mInitialSelectIndex = -1;
    }

    public static final /* synthetic */ void access$recognizeGestureWhenScroll(LynxUIViewPager r100, float r101) {
        r100.recognizeGestureWhenScroll(r101);
    }

    public static final /* synthetic */ void access$setMDragged$p(LynxUIViewPager r100, boolean r101) {
        r100.mDragged = r101;
    }

    public static final /* synthetic */ void access$setMDraggingDetectedByDraggingAndActionUp$p(LynxUIViewPager r100, boolean r101) {
        r100.mDraggingDetectedByDraggingAndActionUp = r101;
    }

    public static final /* synthetic */ void access$setMIndexSelectedWhileIdle$p(LynxUIViewPager r100, int r101) {
        r100.mIndexSelectedWhileIdle = r101;
    }

    private final void sendTabWillChangeEvent(int r100, boolean r101) {
        EventEmitter r102 = getLynxContext().getEventEmitter();
        m7a.a r103 = new m7a.a(getSign(), BIND_ON_WILL_CHANGED);
        r103.a("isDragged", Boolean.valueOf(r101));
        r103.a("index", Integer.valueOf(r100));
        r102.sendCustomEvent(r103);
    }

    @Override // com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager
    public void addPagerChildItem(LynxViewpagerItem r100, int r101) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        com.lynx.xelement.viewpager.viewpager.a r102 = getMPager();
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        r102.setMChanged(true);
        if (r101 >= 0) goto L5;
    L8:
        r102.getMPendingChildren().add(r100);
        return;
    L5:
        if (r101 > r102.getMPendingChildren().size()) goto L8;
        ListProtector.add(r102.getMPendingChildren(), r101, r100);
    }

    @Override // com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager
    public String handleFormatStr(String r100, Object... r101) {
        Intrinsics.checkNotNullParameter(r100, SubInfo.KEY_FORMAT);
        Intrinsics.checkNotNullParameter(r101, "args");
        StringCompanionObject r102 = StringCompanionObject.INSTANCE;
        return String.format(Locale.ENGLISH, r100, Arrays.copyOf(new Object[]{r101}, 1));
    }

    @Override // com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager
    @LynxUIMethod
    public void selectTab(ReadableMap r110, Callback r111) {
        Intrinsics.checkNotNullParameter(r110, "params");
        JavaOnlyMap r100 = new JavaOnlyMap();
        r100.put("success", Boolean.FALSE);
        if (r110.hasKey("index") == false) goto L25;
        int r101 = r110.getInt("index");
        if (r101 < 0) goto L22;
        PagerAdapter r102 = getMPager().getMViewPager().getAdapter();
        if (r102 == null) goto L9;
        int r103 = r102.getCount();
    L10:
        if (r101 >= r103) goto L22;
        sendTabWillChangeEvent(r101, false);
        if (r110.hasKey("smooth") == false) goto L18;
        boolean r112 = r110.getBoolean("smooth", true);
        getMPager().f384326a.setCurrentItem(r101, r112);
        if (r112 == false) goto L16;
    L19:
        r100.put("success", Boolean.TRUE);
        if (r111 == null) goto L29;
        r111.invoke(new Object[]{0, r100});
        return;
    L29:
        return;
    L16:
        if (this.mIndexSelectedWhileIdle == getMPager().getMViewPager().getCurrentItem()) goto L19;
        int r113 = getMPager().getMViewPager().getCurrentItem();
        this.mIndexSelectedWhileIdle = r113;
        sendTabChangeEvent("", r113, "");
        goto L19
    L18:
        getMPager().f384326a.setCurrentItem(r101, true);
        goto L19
    L9:
        r103 = 0;
    L22:
        r100.put("msg", "index out of bounds");
        if (r111 == null) goto L31;
        r111.invoke(new Object[]{4, r100});
        return;
    L31:
        return;
    L25:
        r100.put("msg", "no index key");
        if (r111 == null) goto L33;
        r111.invoke(new Object[]{4, r100});
        return;
    }

    @LynxUIMethod
    public final void setDragGesture(ReadableMap r100, Callback r101) {
        Intrinsics.checkNotNullParameter(r100, "params");
        JavaOnlyMap r102 = new JavaOnlyMap();
        r102.put("success", Boolean.FALSE);
        if (r100.hasKey("canDrag") == false) goto L5;
        setAllowHorizontalGesture(r100.getBoolean("canDrag"));
    L5:
        if (r101 == null) goto L8;
        r101.invoke(new Object[]{0, r102});
        return;
    }

    public static final /* synthetic */ void access$sendTabWillChangeEvent(LynxUIViewPager r100, int r101, boolean r102) {
        r100.sendTabWillChangeEvent(r101, r102);
    }

    @Override // com.lynx.xelement.viewpager.viewpager.BaseLynxViewPager
    public void sendTabChangeEvent(String r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r102, "scene");
        EventEmitter r103 = getLynxContext().getEventEmitter();
        m7a.a r104 = new m7a.a(getSign(), "change");
        r104.a("isDragged", Boolean.valueOf(this.mDragged));
        r104.a("index", Integer.valueOf(r101));
        r103.sendCustomEvent(r104);
    }
}
