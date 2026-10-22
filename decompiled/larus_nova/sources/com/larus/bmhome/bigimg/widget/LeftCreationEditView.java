package com.larus.bmhome.bigimg.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.ee.bear.bitable.common.analytic.BitableAnalytic;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.network.http.HttpExtKt;
import com.larus.nova.R;
import com.larus.platform.service.z2;
import com.larus.utils.e1;
import com.larus.utils.j0;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 E2\u00020\u0001:\u0002DEB'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010(\u001a\u00020)H\u0002J\f\u0010*\u001a\u00020)*\u00020+H\u0002J\b\u0010,\u001a\u00020)H\u0002J]\u0010-\u001a\u00020)2\u0006\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u00010 2\b\b\u0002\u00101\u001a\u00020 2\b\b\u0002\u00102\u001a\u00020 2\b\b\u0002\u00103\u001a\u00020 2\b\b\u0002\u00104\u001a\u00020 2\b\b\u0002\u00105\u001a\u00020 2\n\b\u0002\u00106\u001a\u0004\u0018\u000107¢\u0006\u0002\u00108J\u0018\u00109\u001a\u00020)2\u0006\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020 J\u0016\u0010=\u001a\u00020)2\u0006\u0010:\u001a\u00020;2\u0006\u0010>\u001a\u00020 JS\u0010?\u001a\u00020)2\n\b\u0002\u00100\u001a\u0004\u0018\u00010 2\b\b\u0002\u00101\u001a\u00020 2\b\b\u0002\u00102\u001a\u00020 2\b\b\u0002\u00103\u001a\u00020 2\b\b\u0002\u00104\u001a\u00020 2\u0006\u00105\u001a\u00020 2\b\u00106\u001a\u0004\u0018\u000107H\u0002¢\u0006\u0002\u0010@J\u001c\u0010A\u001a\u00020 2\b\u0010B\u001a\u0004\u0018\u00010C2\b\u00106\u001a\u0004\u0018\u000107H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0017\u001a\u0004\u0018\u00010\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0010\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001c\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0010\u001a\u0004\b\u001d\u0010\u001aR\u0014\u0010\u001f\u001a\u00020 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010!R#\u0010\"\u001a\n $*\u0004\u0018\u00010#0#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010\u0010\u001a\u0004\b%\u0010&¨\u0006F"}, d2 = {"Lcom/larus/bmhome/bigimg/widget/LeftCreationEditView;", "Landroid/widget/LinearLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "moreView", "Lcom/larus/bmhome/bigimg/widget/LeftCreationEditItemView;", "shareView", "getShareView", "()Lcom/larus/bmhome/bigimg/widget/LeftCreationEditItemView;", "shareView$delegate", "Lkotlin/Lazy;", "imageEditView", "gotoVideoEdiView", "videoExtendView", "sharpnessEditView", "expandEditView", "eraseEditView", "remoteFunctionConfig", "Lcom/larus/platform/model/creation/EditFunctionArea;", "getRemoteFunctionConfig", "()Lcom/larus/platform/model/creation/EditFunctionArea;", "remoteFunctionConfig$delegate", "localFunctionConfig", "getLocalFunctionConfig", "localFunctionConfig$delegate", "isBeautyDowngrade", "", "()Z", "cache", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getCache", "()Lcom/bytedance/keva/Keva;", "cache$delegate", "handleRedVersion", "", "removeFromParent", "Landroid/view/View;", "clearViews", "onBindView", "actionListener", "Lcom/larus/bmhome/bigimg/widget/ICreationEditActionListener;", "isShowMore", "hasCreateImageAbility", "hasDetailImageEditAbility", "hasCreateVideoAbility", "hasExtendVideoAbility", "isShowShare", "functionVisibleConfig", "Lcom/larus/bmhome/bigimg/widget/LeftCreationEditView$FunctionVisibleConfig;", "(Lcom/larus/bmhome/bigimg/widget/ICreationEditActionListener;Ljava/lang/Boolean;ZZZZZLcom/larus/bmhome/bigimg/widget/LeftCreationEditView$FunctionVisibleConfig;)V", "updateImageEditPanelAlpha", "alpha", "", "ignoreShareIcon", "updateSharpnessState", "enabled", "initEditFunctionList", "(Ljava/lang/Boolean;ZZZZZLcom/larus/bmhome/bigimg/widget/LeftCreationEditView$FunctionVisibleConfig;)V", "isFunctionVisible", "functionName", "", "FunctionVisibleConfig", "Companion", "image_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LeftCreationEditView extends LinearLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f296105l = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public LeftCreationEditItemView f296106a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f296107b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public LeftCreationEditItemView f296108c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LeftCreationEditItemView f296109d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LeftCreationEditItemView f296110e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LeftCreationEditItemView f296111f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LeftCreationEditItemView f296112g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LeftCreationEditItemView f296113h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f296114i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f296115j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f296116k;

    public static final class a {
        public static b a() {
            int r100 = LeftCreationEditView.f296105l;
            return new b(true, true, true, false, true, false);
        }

        public a() {
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f296117a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f296118b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f296119c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f296120d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f296121e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f296122f;

        public b() {
            this(false, false, false, false, false, false);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f296117a == r101.f296117a) goto L12;
            return false;
        L12:
            if (this.f296118b == r101.f296118b) goto L15;
            return false;
        L15:
            if (this.f296119c == r101.f296119c) goto L18;
            return false;
        L18:
            if (this.f296120d == r101.f296120d) goto L21;
            return false;
        L21:
            if (this.f296121e == r101.f296121e) goto L24;
            return false;
        L24:
            if (this.f296122f == r101.f296122f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f296117a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f296118b == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (r102 + r103) * 31;
            if (this.f296119c == false) goto L13;
            int r105 = 1231;
        L14:
            int r106 = (r104 + r105) * 31;
            if (this.f296120d == false) goto L17;
            int r107 = 1231;
        L18:
            int r108 = (r106 + r107) * 31;
            if (this.f296121e == false) goto L21;
            int r109 = 1231;
        L22:
            int r110 = (r108 + r109) * 31;
            if (this.f296122f == true) goto L27;
            r100 = 1237;
        L27:
            return r110 + r100;
        L21:
            r109 = 1237;
            goto L22
        L17:
            r107 = 1237;
            goto L18
        L13:
            r105 = 1237;
            goto L14
        L9:
            r103 = 1237;
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "FunctionVisibleConfig(toVideo=" + this.f296117a + ", imageEdit=" + this.f296118b + ", sharpness=" + this.f296119c + ", expand=" + this.f296120d + ", erase=" + this.f296121e + ", videoExtend=" + this.f296122f + ')';
        }

        public b(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, boolean r105) {
            this.f296117a = r100;
            this.f296118b = r101;
            this.f296119c = r102;
            this.f296120d = r103;
            this.f296121e = r104;
            this.f296122f = r105;
        }
    }

    static {
        new a();
    }

    public LeftCreationEditView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LeftCreationEditView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final Keva getCache() {
        return (Keva) this.f296116k.getValue();
    }

    private final sq9.r getLocalFunctionConfig() {
        return (sq9.r) this.f296115j.getValue();
    }

    private final sq9.r getRemoteFunctionConfig() {
        return (sq9.r) this.f296114i.getValue();
    }

    private final LeftCreationEditItemView getShareView() {
        return (LeftCreationEditItemView) this.f296107b.getValue();
    }

    public final void b() {
        sq9.r r100 = getRemoteFunctionConfig();
        getCache().storeString("creation_edit_function_list", GsonProtectorUtils.toJson(HttpExtKt.f360123f, r100));
    }

    public static sq9.r a(LeftCreationEditView r100) {
        String r101 = r100.getCache().getString("creation_edit_function_list", "");
        if (r101 == null) goto L7;
        sq9.r r102 = (sq9.r) GsonProtectorUtils.fromJson(HttpExtKt.f360123f, r101, sq9.r.class);
        if (r102 == null) goto L7;
        return r102;
    L7:
        return new sq9.r(null, null);
    }

    public static void e(LeftCreationEditItemView r100) {
        ViewParent r101 = r100.getParent();
        if ((r101 instanceof ViewGroup) == false) goto L5;
        ViewGroup r102 = (ViewGroup) r101;
    L6:
        if (r102 == null) goto L9;
        r102.removeView(r100);
        return;
    L9:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public static boolean c(String r100, b r101) {
        if (r101 != null) goto L5;
        return true;
    L5:
        if (r100 != null) goto L7;
        return true;
    L7:
        switch(r100.hashCode()) {
            case -1571105471: goto L29;
            case -1443226002: goto L25;
            case -1431798345: goto L22;
            case -1289167206: goto L18;
            case -392382626: goto L14;
            case 96768678: goto L10;
            default: goto L40;
        };
    L40:
        return true;
    L10:
        if (r100.equals("erase") == true) goto L34;
        return true;
    L34:
        return r101.f296121e;
    L14:
        if (r100.equals("video_extend") == true) goto L35;
        return true;
    L35:
        return r101.f296122f;
    L18:
        if (r100.equals(BitableAnalytic.LinkSceneClickType.EXPAND) == true) goto L36;
        return true;
    L36:
        return r101.f296120d;
    L22:
        if (r100.equals("to_video") == true) goto L38;
        return true;
    L38:
        return r101.f296117a;
    L25:
        if (r100.equals("image_edit") == true) goto L39;
        return true;
    L39:
        return r101.f296118b;
    L29:
        if (r100.equals("sharpness") == true) goto L32;
        return true;
    L32:
        return r101.f296119c;
    }

    public final void f(float r100, boolean r101) {
        LeftCreationEditItemView r102 = this.f296108c;
        View r103 = null;
        if (r102 == null) goto L5;
        Object r104 = r102.getParent();
    L7:
        if ((r104 instanceof View) == false) goto L9;
        View r105 = (View) r104;
    L10:
        if (r105 == null) goto L12;
        r105.setAlpha(r100);
    L12:
        LeftCreationEditItemView r106 = this.f296112g;
        if (r106 == null) goto L15;
        Object r107 = r106.getParent();
    L17:
        if ((r107 instanceof View) == false) goto L19;
        View r108 = (View) r107;
    L20:
        if (r108 == null) goto L22;
        r108.setAlpha(r100);
    L22:
        LeftCreationEditItemView r109 = this.f296109d;
        if (r109 == null) goto L25;
        Object r110 = r109.getParent();
    L27:
        if ((r110 instanceof View) == false) goto L29;
        View r111 = (View) r110;
    L30:
        if (r111 == null) goto L32;
        r111.setAlpha(r100);
    L32:
        LeftCreationEditItemView r112 = this.f296110e;
        if (r112 == null) goto L35;
        Object r113 = r112.getParent();
    L37:
        if ((r113 instanceof View) == false) goto L39;
        View r114 = (View) r113;
    L40:
        if (r114 == null) goto L42;
        r114.setAlpha(r100);
    L42:
        LeftCreationEditItemView r115 = this.f296111f;
        if (r115 == null) goto L45;
        Object r116 = r115.getParent();
    L47:
        if ((r116 instanceof View) == false) goto L49;
        View r117 = (View) r116;
    L50:
        if (r117 == null) goto L52;
        r117.setAlpha(r100);
    L52:
        LeftCreationEditItemView r118 = this.f296113h;
        if (r118 == null) goto L55;
        Object r119 = r118.getParent();
    L57:
        if ((r119 instanceof View) == false) goto L59;
        View r120 = (View) r119;
    L60:
        if (r120 == null) goto L62;
        r120.setAlpha(r100);
    L62:
        if (r101 == false) goto L64;
        getShareView().f296104a.f350942d.setAlpha(r100);
        return;
    L64:
        LeftCreationEditItemView r121 = getShareView();
        if (r121 == null) goto L67;
        ViewParent r122 = r121.getParent();
    L69:
        if ((r122 instanceof View) == false) goto L71;
        r103 = (View) r122;
    L71:
        if (r103 == null) goto L75;
        r103.setAlpha(r100);
        return;
    L75:
        return;
    L67:
        r122 = null;
        goto L69
    L59:
        r120 = null;
        goto L60
    L55:
        r119 = null;
        goto L57
    L49:
        r117 = null;
        goto L50
    L45:
        r116 = null;
        goto L47
    L39:
        r114 = null;
        goto L40
    L35:
        r113 = null;
        goto L37
    L29:
        r111 = null;
        goto L30
    L25:
        r110 = null;
        goto L27
    L19:
        r108 = null;
        goto L20
    L15:
        r107 = null;
        goto L17
    L9:
        r105 = null;
        goto L10
    L5:
        r104 = null;
        goto L7
    }

    public LeftCreationEditView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f296107b = LazyKt.lazy(new u(r100));
        this.f296114i = LazyKt.lazy(new v());
        this.f296115j = LazyKt.lazy(new l(this));
        this.f296116k = LazyKt.lazy(new m());
        setOrientation(1);
    }

    public /* synthetic */ LeftCreationEditView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public static void d(final LeftCreationEditView r110, final j r111, Boolean r112, boolean r210, boolean r211, boolean r212, boolean r213, boolean r214, b r215, int r216) {
        if ((r216 & 2) == 0) goto L5;
        Boolean r100 = Boolean.FALSE;
    L6:
        int r101 = 0;
        if ((r216 & 4) == 0) goto L9;
        boolean r102 = false;
    L11:
        if ((r216 & 8) == 0) goto L13;
        boolean r103 = r102;
    L15:
        if ((r216 & 16) == 0) goto L17;
        boolean r104 = false;
    L19:
        if ((r216 & 32) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r216 & 64) == 0) goto L25;
        boolean r106 = true;
    L26:
        AttributeSet r113 = null;
        if ((r216 & 128) == 0) goto L29;
        b r107 = null;
    L30:
        r110.getClass();
        Intrinsics.checkNotNullParameter(r111, "actionListener");
        LeftCreationEditItemView r114 = r110.f296106a;
        if (r114 == null) goto L33;
        e(r114);
    L33:
        e(r110.getShareView());
        LeftCreationEditItemView r115 = r110.f296108c;
        if (r115 == null) goto L36;
        e(r115);
    L36:
        LeftCreationEditItemView r116 = r110.f296109d;
        if (r116 == null) goto L39;
        e(r116);
    L39:
        LeftCreationEditItemView r117 = r110.f296110e;
        if (r117 == null) goto L42;
        e(r117);
    L42:
        LeftCreationEditItemView r118 = r110.f296111f;
        if (r118 == null) goto L45;
        e(r118);
    L45:
        LeftCreationEditItemView r119 = r110.f296112g;
        if (r119 == null) goto L48;
        e(r119);
    L48:
        LeftCreationEditItemView r120 = r110.f296113h;
        if (r120 == null) goto L51;
        e(r120);
    L51:
        r110.removeAllViews();
        int r121 = 6;
        if (Intrinsics.areEqual(r100, Boolean.TRUE) == false) goto L54;
        LeftCreationEditItemView r108 = new LeftCreationEditItemView(r110.getContext(), r113, r121, r101);
        r108.S5(R.drawable.larus_ic_creation_ellipsis_stroked, null, Boolean.FALSE);
        int r122 = j0.f375426a;
        r108.setContentDescription(j0.d(R.string.larus_accessibility_icon_moreMenu));
        r110.f296106a = r108;
        FrameLayout r109 = new FrameLayout(r110.getContext());
        LeftCreationEditItemView r123 = r110.f296106a;
        FrameLayout.LayoutParams r124 = new FrameLayout.LayoutParams(-2, i5.c0());
        r124.gravity = 17;
        Unit r125 = Unit.INSTANCE;
        r109.addView(r123, r124);
        r110.addView(r109);
    L54:
        if (r106 == false) goto L56;
        FrameLayout r126 = new FrameLayout(r110.getContext());
        r126.addView(r110.getShareView(), new FrameLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams r127 = new LinearLayout.LayoutParams(-2, -2);
        r127.topMargin = 0;
        r127.gravity = 17;
        Unit r128 = Unit.INSTANCE;
        r110.addView(r126, r127);
    L56:
        if (r105 == true) goto L58;
        sq9.r r129 = z2.f365865a.getCreationEditControlConfig().a();
        if (r129 == null) goto L245;
        List<sq9.s> r130 = r129.a();
        if (r130 == null) goto L245;
        Iterator<T> r131 = r130.iterator();
    L67:
        if (r131.hasNext() == false) goto L244;
        sq9.s r132 = (sq9.s) r131.next();
        if (c(r132.a(), r107) == false) goto L243;
        String r133 = r132.a();
        if (r133 == null) goto L243;
        switch(r133.hashCode()) {
            case -1571105471: goto L238;
            case -1443226002: goto L198;
            case -1431798345: goto L159;
            case -1289167206: goto L119;
            case 96768678: goto L77;
            default: goto L243;
        };
    L77:
        if (r133.equals("erase") == false) goto L243;
        if (r102 == false) goto L243;
        LeftCreationEditItemView r134 = new LeftCreationEditItemView(r110.getContext(), null, r121, r101);
        Integer r135 = Integer.valueOf(R.string.larus_imageDetail_btn_remove);
        sq9.r r136 = r110.getRemoteFunctionConfig();
        if (r136 == null) goto L97;
        List<sq9.s> r137 = r136.a();
        if (r137 == null) goto L97;
        Iterator<T> r138 = r137.iterator();
    L86:
        if (r138.hasNext() == false) goto L91;
        Object r139 = r138.next();
        if (Intrinsics.areEqual(((sq9.s) r139).a(), "erase") == false) goto L86;
    L92:
        sq9.s r140 = (sq9.s) r139;
        if (r140 == null) goto L97;
        Integer r141 = r140.b();
        if (r141 == null) goto L97;
        int r142 = r141.intValue();
    L98:
        List<sq9.s> r143 = r110.getLocalFunctionConfig().a();
        if (r143 == null) goto L113;
        Iterator<T> r144 = r143.iterator();
    L102:
        if (r144.hasNext() == false) goto L107;
        Object r145 = r144.next();
        if (Intrinsics.areEqual(((sq9.s) r145).a(), "erase") == false) goto L102;
    L108:
        sq9.s r146 = (sq9.s) r145;
        if (r146 == null) goto L113;
        Integer r147 = r146.b();
        if (r147 == null) goto L113;
        int r148 = r147.intValue();
    L114:
        if (r142 <= r148) goto L116;
        boolean r149 = true;
    L117:
        r134.S5(R.drawable.larus_ic_creation_eraser_new, r135, Boolean.valueOf(r149));
        r110.f296113h = r134;
        FrameLayout r150 = new FrameLayout(r110.getContext());
        LeftCreationEditItemView r151 = r110.f296113h;
        FrameLayout.LayoutParams r152 = new FrameLayout.LayoutParams(-2, -2);
        r152.gravity = 17;
        Unit r153 = Unit.INSTANCE;
        r150.addView(r151, r152);
        LinearLayout.LayoutParams r154 = new LinearLayout.LayoutParams(-2, -2);
        r154.topMargin = i5.j0();
        r154.gravity = 17;
        r110.addView(r150, r154);
        goto L243
    L116:
        r149 = false;
        goto L117
    L107:
        r145 = null;
    L113:
        r148 = 0;
        goto L114
    L91:
        r139 = null;
    L97:
        r142 = 0;
        goto L98
    L119:
        if (r133.equals(BitableAnalytic.LinkSceneClickType.EXPAND) == false) goto L243;
        if (r102 == false) goto L243;
        LeftCreationEditItemView r155 = new LeftCreationEditItemView(r110.getContext(), null, 6, 0);
        Integer r156 = Integer.valueOf(R.string.larus_imageDetail_btn_outpaint);
        sq9.r r157 = r110.getRemoteFunctionConfig();
        if (r157 == null) goto L138;
        List<sq9.s> r158 = r157.a();
        if (r158 == null) goto L138;
        Iterator<T> r159 = r158.iterator();
    L128:
        if (r159.hasNext() == false) goto L132;
        Object r160 = r159.next();
        if (Intrinsics.areEqual(((sq9.s) r160).a(), BitableAnalytic.LinkSceneClickType.EXPAND) == false) goto L128;
    L133:
        sq9.s r161 = (sq9.s) r160;
        if (r161 == null) goto L138;
        Integer r162 = r161.b();
        if (r162 == null) goto L138;
        int r163 = r162.intValue();
    L139:
        List<sq9.s> r164 = r110.getLocalFunctionConfig().a();
        if (r164 == null) goto L153;
        Iterator<T> r165 = r164.iterator();
    L143:
        if (r165.hasNext() == false) goto L147;
        Object r166 = r165.next();
        if (Intrinsics.areEqual(((sq9.s) r166).a(), BitableAnalytic.LinkSceneClickType.EXPAND) == false) goto L143;
    L148:
        sq9.s r167 = (sq9.s) r166;
        if (r167 == null) goto L153;
        Integer r168 = r167.b();
        if (r168 == null) goto L153;
        int r169 = r168.intValue();
    L154:
        if (r163 <= r169) goto L156;
        boolean r170 = true;
    L157:
        r155.S5(R.drawable.larus_ic_creation_enlarge, r156, Boolean.valueOf(r170));
        r110.f296112g = r155;
        FrameLayout r171 = new FrameLayout(r110.getContext());
        LeftCreationEditItemView r172 = r110.f296112g;
        FrameLayout.LayoutParams r173 = new FrameLayout.LayoutParams(-2, -2);
        r173.gravity = 17;
        Unit r174 = Unit.INSTANCE;
        r171.addView(r172, r173);
        LinearLayout.LayoutParams r175 = new LinearLayout.LayoutParams(-2, -2);
        r175.topMargin = i5.j0();
        r175.gravity = 17;
        r110.addView(r171, r175);
        goto L243
    L156:
        r170 = false;
        goto L157
    L147:
        r166 = null;
    L153:
        r169 = 0;
        goto L154
    L132:
        r160 = null;
    L138:
        r163 = 0;
        goto L139
    L159:
        if (r133.equals("to_video") == false) goto L243;
        if (r104 == false) goto L243;
        sq9.r r176 = r110.getRemoteFunctionConfig();
        if (r176 == null) goto L177;
        List<sq9.s> r177 = r176.a();
        if (r177 == null) goto L177;
        Iterator<T> r178 = r177.iterator();
    L167:
        if (r178.hasNext() == false) goto L171;
        Object r179 = r178.next();
        if (Intrinsics.areEqual(((sq9.s) r179).a(), "to_video") == false) goto L167;
    L172:
        sq9.s r180 = (sq9.s) r179;
        if (r180 == null) goto L177;
        Integer r181 = r180.b();
        if (r181 == null) goto L177;
        int r182 = r181.intValue();
    L178:
        List<sq9.s> r183 = r110.getLocalFunctionConfig().a();
        if (r183 == null) goto L192;
        Iterator<T> r184 = r183.iterator();
    L182:
        if (r184.hasNext() == false) goto L186;
        Object r185 = r184.next();
        if (Intrinsics.areEqual(((sq9.s) r185).a(), "to_video") == false) goto L182;
    L187:
        sq9.s r186 = (sq9.s) r185;
        if (r186 == null) goto L192;
        Integer r187 = r186.b();
        if (r187 == null) goto L192;
        int r188 = r187.intValue();
    L193:
        if (r182 <= r188) goto L195;
        boolean r189 = true;
    L196:
        LeftCreationEditItemView r190 = new LeftCreationEditItemView(r110.getContext(), null, 6, 0);
        r190.S5(R.drawable.larus_ic_creation_video, Integer.valueOf(R.string.larus_imageDetail_btn_video), Boolean.valueOf(r189));
        r110.f296109d = r190;
        FrameLayout r191 = new FrameLayout(r110.getContext());
        r191.addView(r110.f296109d, new FrameLayout.LayoutParams(-2, -2));
        LinearLayout.LayoutParams r192 = new LinearLayout.LayoutParams(-2, -2);
        r192.topMargin = i5.j0();
        r192.gravity = 17;
        Unit r193 = Unit.INSTANCE;
        r110.addView(r191, r192);
        goto L243
    L195:
        r189 = false;
        goto L196
    L186:
        r185 = null;
    L192:
        r188 = 0;
        goto L193
    L171:
        r179 = null;
    L177:
        r182 = 0;
        goto L178
    L198:
        if (r133.equals("image_edit") == false) goto L243;
        if (r103 == false) goto L243;
        LeftCreationEditItemView r194 = new LeftCreationEditItemView(r110.getContext(), null, 6, 0);
        Integer r195 = Integer.valueOf(R.string.larus_imageDetail_btn_edit);
        sq9.r r196 = r110.getRemoteFunctionConfig();
        if (r196 == null) goto L217;
        List<sq9.s> r197 = r196.a();
        if (r197 == null) goto L217;
        Iterator<T> r198 = r197.iterator();
    L207:
        if (r198.hasNext() == false) goto L211;
        Object r199 = r198.next();
        if (Intrinsics.areEqual(((sq9.s) r199).a(), "image_edit") == false) goto L207;
    L212:
        sq9.s r1100 = (sq9.s) r199;
        if (r1100 == null) goto L217;
        Integer r1101 = r1100.b();
        if (r1101 == null) goto L217;
        int r1102 = r1101.intValue();
    L218:
        List<sq9.s> r1103 = r110.getLocalFunctionConfig().a();
        if (r1103 == null) goto L232;
        Iterator<T> r1104 = r1103.iterator();
    L222:
        if (r1104.hasNext() == false) goto L226;
        Object r1105 = r1104.next();
        if (Intrinsics.areEqual(((sq9.s) r1105).a(), "image_edit") == false) goto L222;
    L227:
        sq9.s r1106 = (sq9.s) r1105;
        if (r1106 == null) goto L232;
        Integer r200 = r1106.b();
        if (r200 == null) goto L232;
        int r201 = r200.intValue();
    L233:
        if (r1102 <= r201) goto L235;
        boolean r1107 = true;
    L236:
        r194.S5(R.drawable.larus_ic_creation_photo_editer, r195, Boolean.valueOf(r1107));
        r110.f296108c = r194;
        FrameLayout r202 = new FrameLayout(r110.getContext());
        LeftCreationEditItemView r203 = r110.f296108c;
        FrameLayout.LayoutParams r204 = new FrameLayout.LayoutParams(-2, -2);
        r204.gravity = 17;
        Unit r1108 = Unit.INSTANCE;
        r202.addView(r203, r204);
        LinearLayout.LayoutParams r205 = new LinearLayout.LayoutParams(-2, -2);
        r205.topMargin = i5.j0();
        r205.gravity = 17;
        r110.addView(r202, r205);
        goto L243
    L235:
        r1107 = false;
        goto L236
    L226:
        r1105 = null;
    L232:
        r201 = 0;
        goto L233
    L211:
        r199 = null;
    L217:
        r1102 = 0;
        goto L218
    L238:
        if (r133.equals("sharpness") == false) goto L243;
        if (r102 == false) goto L243;
        LeftCreationEditItemView r206 = new LeftCreationEditItemView(r110.getContext(), null, 6, 0);
        r206.S5(R.drawable.larus_ic_creation_image_hd, Integer.valueOf(R.string.larus_imageDetail_btn_upscale), Boolean.FALSE);
        r110.f296111f = r206;
        FrameLayout r207 = new FrameLayout(r110.getContext());
        LeftCreationEditItemView r208 = r110.f296111f;
        FrameLayout.LayoutParams r1109 = new FrameLayout.LayoutParams(-2, -2);
        r1109.gravity = 17;
        Unit r1110 = Unit.INSTANCE;
        r207.addView(r208, r1109);
        LinearLayout.LayoutParams r209 = new LinearLayout.LayoutParams(-2, -2);
        r209.topMargin = i5.j0();
        r209.gravity = 17;
        r110.addView(r207, r209);
    L243:
        r101 = 0;
        r121 = 6;
        goto L67
    L244:
        Unit r217 = Unit.INSTANCE;
    L245:
        e1.d(r110.getShareView(), new k(r111));
        LeftCreationEditItemView r218 = r110.f296108c;
        if (r218 == null) goto L248;
        e1.d(r218, new n(r111, r110));
    L248:
        LeftCreationEditItemView r219 = r110.f296109d;
        if (r219 == null) goto L251;
        e1.d(r219, new o(r111, r110));
    L251:
        LeftCreationEditItemView r220 = r110.f296110e;
        if (r220 == null) goto L254;
        e1.d(r220, new p(r111));
    L254:
        LeftCreationEditItemView r221 = r110.f296111f;
        if (r221 == null) goto L257;
        e1.d(r221, new q(r110, r111));
    L257:
        LeftCreationEditItemView r222 = r110.f296112g;
        if (r222 == null) goto L260;
        e1.d(r222, new r(r110, r111));
    L260:
        LeftCreationEditItemView r223 = r110.f296113h;
        if (r223 == null) goto L263;
        e1.d(r223, new s(r110, r111));
    L263:
        LeftCreationEditItemView r224 = r110.f296106a;
        if (r224 == null) goto L292;
        e1.d(r224, new t(r111));
        return;
    L292:
        return;
    L58:
        if (c("video_extend", r107) == false) goto L60;
        LeftCreationEditItemView r225 = new LeftCreationEditItemView(r110.getContext(), null, r121, r101);
        r225.S5(R.drawable.larus_ic_creation_extend_video, Integer.valueOf(R.string.larus_extendVideo_label_btn_extend), Boolean.FALSE);
        r110.f296110e = r225;
        FrameLayout r226 = new FrameLayout(r110.getContext());
        LeftCreationEditItemView r227 = r110.f296110e;
        FrameLayout.LayoutParams r228 = new FrameLayout.LayoutParams(-2, -2);
        r228.gravity = 17;
        Unit r229 = Unit.INSTANCE;
        r226.addView(r227, r228);
        LinearLayout.LayoutParams r230 = new LinearLayout.LayoutParams(-2, -2);
        r230.topMargin = i5.j0();
        r230.gravity = 17;
        r110.addView(r226, r230);
    L60:
        Unit r231 = Unit.INSTANCE;
        goto L245
    L29:
        r107 = r215;
        goto L30
    L25:
        r106 = r214;
        goto L26
    L21:
        r105 = r213;
        goto L23
    L17:
        r104 = r212;
        goto L19
    L13:
        r103 = r211;
        goto L15
    L9:
        r102 = r210;
        goto L11
    L5:
        r100 = r112;
        goto L6
    }
}
