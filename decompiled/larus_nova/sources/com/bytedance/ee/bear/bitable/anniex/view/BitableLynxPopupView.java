package com.bytedance.ee.bear.bitable.anniex.view;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.ecom.arch.slice.slices.template.TemplateNodeType;
import com.bytedance.ee.bear.bitable.panel.Icon;
import com.bytedance.ee.bear.lynx.impl.xbridge.method.view.SendEventContainerMethodParamModel;
import com.bytedance.ee.util.ui.ColorUtils;
import com.larksuite.component.universe_design.menu.PositionAlign;
import com.larksuite.component.universe_design.menu.g;
import com.larus.nova.R;
import com.larus.platform.api.creation.TplType;
import com.lynx.react.bridge.ReadableArray;
import com.lynx.react.bridge.ReadableMap;
import com.lynx.tasm.behavior.LynxContext;
import com.lynx.tasm.behavior.LynxProp;
import com.lynx.tasm.behavior.ui.UIGroup;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 .2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0004./01B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0014J\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0007J\u0012\u0010\u0018\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0007J\u0012\u0010\u0019\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u0007J\u0012\u0010\u001a\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u001bH\u0007J\u0010\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\bH\u0002J\u0010\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001fH\u0002J\u0018\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u000f2\u0006\u0010\"\u001a\u00020#H\u0002J\b\u0010$\u001a\u00020\u0016H\u0002J\u0010\u0010%\u001a\u00020#2\u0006\u0010&\u001a\u00020\nH\u0002J\u0010\u0010'\u001a\u00020(2\u0006\u0010&\u001a\u00020\nH\u0002J\u0012\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e*\u00020\u001bH\u0002J\u0014\u0010*\u001a\u00020\n*\u00020+2\u0006\u0010,\u001a\u00020\nH\u0002J\u0016\u0010-\u001a\u0004\u0018\u00010\n*\u00020+2\u0006\u0010,\u001a\u00020\nH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/bytedance/ee/bear/bitable/anniex/view/BitableLynxPopupView;", "Lcom/lynx/tasm/behavior/ui/UIGroup;", "Landroid/widget/FrameLayout;", "lynxContext", "Lcom/lynx/tasm/behavior/LynxContext;", "<init>", "(Lcom/lynx/tasm/behavior/LynxContext;)V", "popupView", "Lcom/bytedance/ee/bear/bitable/anniex/view/BitableLynxPopupView$PopupAnchorLayout;", "popupType", "", "placement", "trigger", "items", "", "Lcom/bytedance/ee/bear/bitable/anniex/view/BitableLynxPopupView$PopupItemModel;", TplType.MENU, "Lcom/larksuite/component/universe_design/menu/UDMenu;", "createView", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "setPopupType", "", "value", "setPlacement", "setTrigger", "setItems", "Lcom/lynx/react/bridge/ReadableArray;", "bindTrigger", "anchor", "showPopup", "Landroid/view/View;", "emitItemClick", MapController.ITEM_LAYER_TAG, "index", "", "dismissMenu", "toGravity", TemplateNodeType.RAW, "toAlign", "Lcom/larksuite/component/universe_design/menu/PositionAlign;", "toPopupItems", "getStringOrEmpty", "Lcom/lynx/react/bridge/ReadableMap;", "key", "getOptionalString", "Companion", "PopupItemModel", "PopupAnchorLayout", "PopupMenuItem", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableLynxPopupView extends UIGroup<FrameLayout> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f206776g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public b f206777a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f206778b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f206779c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f206780d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<c> f206781e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.larksuite.component.universe_design.menu.c f206782f;

    public static final class a {
    }

    public static final class b extends FrameLayout {
        public b(Context r100) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            super(r100);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f206783a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f206784b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f206785c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f206786d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f206787e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f206783a, r101.f206783a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f206784b, r101.f206784b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f206785c, r101.f206785c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f206786d, r101.f206786d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f206787e, r101.f206787e) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f206783a.hashCode() * 31) + this.f206784b.hashCode()) * 31;
            String r101 = this.f206785c;
            int r102 = 0;
            if (r101 != null) goto L5;
            int r103 = 0;
        L6:
            int r104 = (r100 + r103) * 31;
            String r105 = this.f206786d;
            if (r105 != null) goto L9;
            int r106 = 0;
        L10:
            int r107 = (r104 + r106) * 31;
            String r108 = this.f206787e;
            if (r108 == null) goto L15;
            r102 = r108.hashCode();
        L15:
            return r107 + r102;
        L9:
            r106 = r105.hashCode();
            goto L10
        L5:
            r103 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "PopupItemModel(itemId=" + this.f206783a + ", text=" + this.f206784b + ", textColor=" + this.f206785c + ", iconKey=" + this.f206786d + ", iconTintColor=" + this.f206787e + ')';
        }

        public c(String r100, String r101, String r102, String r103, String r104) {
            Intrinsics.checkNotNullParameter(r100, "itemId");
            Intrinsics.checkNotNullParameter(r101, "text");
            this.f206783a = r100;
            this.f206784b = r101;
            this.f206785c = r102;
            this.f206786d = r103;
            this.f206787e = r104;
        }
    }

    public static final class d implements g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Context f206788a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c f206789b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Function0<Unit> f206790c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final Icon f206791d;

        @Override // com.larksuite.component.universe_design.menu.g
        public final int c() {
            return R.color.icon_n2;
        }

        @Override // com.larksuite.component.universe_design.menu.g
        public final /* synthetic */ void getDescription() {
        }

        @Override // com.larksuite.component.universe_design.menu.g
        public final /* synthetic */ boolean isEnabled() {
            return true;
        }

        @Override // com.larksuite.component.universe_design.menu.g
        public final void a() {
            this.f206790c.invoke();
        }

        @Override // com.larksuite.component.universe_design.menu.g
        public final int b() {
            String r100 = this.f206789b.f206787e;
            if (r100 == null) goto L20;
            Object r101 = null;
            if ((!StringsKt.isBlank(r100)) == true) goto L8;
            r100 = null;
        L8:
            if (r100 == null) goto L20;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
            Object r103 = Result.m9449constructorimpl(Integer.valueOf(ColorUtils.h(r100)));     // Catch: Throwable -> L11
        L14:
            if (Result.m9455isFailureimpl(r103) == true) goto L17;
            r101 = r103;
        L17:
            Integer r104 = (Integer) r101;
            if (r104 == null) goto L20;
            return r104.intValue();
        L11:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L20:
            return 0;
        }

        @Override // com.larksuite.component.universe_design.menu.g
        public final int getIcon() {
            Integer r100 = this.f206791d.getImgRes(this.f206788a);
            if (r100 != null) goto L7;
            return R.drawable.ud_icon_bitableunknow_outlined;
        L7:
            return r100.intValue();
        }

        @Override // com.larksuite.component.universe_design.menu.g
        public final String getName() {
            return this.f206789b.f206784b;
        }

        @Override // com.larksuite.component.universe_design.menu.g
        public final int getTextColor() {
            String r100 = this.f206789b.f206785c;
            if (r100 == null) goto L20;
            Object r101 = null;
            if ((!StringsKt.isBlank(r100)) == true) goto L8;
            r100 = null;
        L8:
            if (r100 == null) goto L20;
            Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L11
            Object r103 = Result.m9449constructorimpl(Integer.valueOf(ColorUtils.h(r100)));     // Catch: Throwable -> L11
        L14:
            if (Result.m9455isFailureimpl(r103) == true) goto L17;
            r101 = r103;
        L17:
            Integer r104 = (Integer) r101;
            if (r104 == null) goto L20;
            return r104.intValue();
        L11:
            th = move-exception;
            Result.Companion r105 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L20:
            return 0;
        }

        public d(Context r100, c r101, Function0<Unit> r102) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
            Intrinsics.checkNotNullParameter(r102, SendEventContainerMethodParamModel.EventKinds.onClick);
            this.f206788a = r100;
            this.f206789b = r101;
            this.f206790c = r102;
            Icon r103 = new Icon();
            r103.setUdKey(r101.f206786d);
            r103.setIconTintColor(r101.f206787e);
            this.f206791d = r103;
        }
    }

    public static final class e implements View.OnLongClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableLynxPopupView f206792a;

        public e(BitableLynxPopupView r100) {
            this.f206792a = r100;
        }

        @Override // android.view.View.OnLongClickListener
        public final boolean onLongClick(View r100) {
            BitableLynxPopupView r101 = this.f206792a;
            Intrinsics.checkNotNull(r100);
            BitableLynxPopupView.M(r101, r100);
            return true;
        }
    }

    public static final class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BitableLynxPopupView f206793a;

        public f(BitableLynxPopupView r100) {
            this.f206793a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            BitableLynxPopupView r101 = this.f206793a;
            Intrinsics.checkNotNull(r100);
            BitableLynxPopupView.M(r101, r100);
        }
    }

    static {
    }

    public BitableLynxPopupView(LynxContext r100) {
        Intrinsics.checkNotNullParameter(r100, "lynxContext");
        super(r100);
        this.f206778b = "Popup";
        this.f206779c = "Bottom";
        this.f206780d = "Click";
        this.f206781e = CollectionsKt.emptyList();
    }

    public final void N(b r100) {
        r100.setOnClickListener(null);
        r100.setOnLongClickListener(null);
        if (Intrinsics.areEqual(this.f206780d, "LongPress") == false) goto L5;
        r100.setClickable(false);
        r100.setLongClickable(true);
        r100.setOnLongClickListener(new e(this));
        return;
    L5:
        r100.setLongClickable(false);
        r100.setClickable(true);
        r100.setOnClickListener(new f(this));
    }

    @Override // com.lynx.tasm.behavior.ui.LynxUI
    public final View createView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        b r101 = new b(r100);
        this.f206777a = r101;
        N(r101);
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List<com.bytedance.ee.bear.bitable.anniex.view.BitableLynxPopupView$c>] */
    /* JADX WARN: Type inference failed for: r0v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4, types: [java.util.ArrayList] */
    @LynxProp(name = "items")
    public final void setItems(ReadableArray r110) {
        ?? r100 = 0;
        if (r110 == null) goto L37;
        ArrayList r101 = new ArrayList(r110.size());
        ArrayList<Object> r111 = r110.asArrayList();
        Intrinsics.checkNotNull(r111);
        Iterator r112 = r111.iterator();
        int r102 = 0;
    L6:
        if (r112.hasNext() == false) goto L26;
        Object r103 = r112.next();
        int r104 = r102 + 1;
        if (r102 >= 0) goto L11;
        CollectionsKt.throwIndexOverflow();
    L11:
        if ((r103 instanceof ReadableMap) == false) goto L13;
        ReadableMap r105 = (ReadableMap) r103;
    L14:
        if (r105 == null) goto L25;
        String r106 = O(r105, "itemId");
        if (r106 != null) goto L19;
        String r107 = "";
    L20:
        String r108 = O(r105, "text");
        if (r108 != null) goto L23;
        String r109 = "";
    L24:
        r101.add(new c(r107, r109, O(r105, "textColor"), O(r105, "iconKey"), O(r105, "iconTintColor")));
        goto L25
    L23:
        r109 = r108;
        goto L24
    L19:
        r107 = r106;
    L25:
        r102 = r104;
        goto L6
    L13:
        r105 = null;
        goto L14
    L26:
        r100 = new ArrayList();
        Iterator r113 = r101.iterator();
    L28:
        if (r113.hasNext() == false) goto L37;
        Object r114 = r113.next();
        c r115 = (c) r114;
        boolean r116 = true;
        if ((!StringsKt.isBlank(r115.f206783a)) == false) goto L32;
    L35:
        if (r116 == false) goto L28;
        r100.add(r114);
        goto L28
    L32:
        if ((!StringsKt.isBlank(r115.f206784b)) == true) goto L35;
        r116 = false;
    L37:
        if (r100 != 0) goto L39;
        r100 = CollectionsKt.emptyList();
    L39:
        this.f206781e = r100;
    }

    @LynxProp(name = "placement")
    public final void setPlacement(String r100) {
        if (r100 != null) goto L4;
    L8:
        r100 = "Bottom";
    L9:
        this.f206779c = r100;
        return;
    L4:
        if ((!StringsKt.isBlank(r100)) == true) goto L7;
        r100 = null;
    L7:
        if (r100 != null) goto L9;
        goto L8
    }

    @LynxProp(name = "popuptype")
    public final void setPopupType(String r100) {
        if (r100 != null) goto L4;
    L8:
        r100 = "Popup";
    L9:
        this.f206778b = r100;
        return;
    L4:
        if ((!StringsKt.isBlank(r100)) == true) goto L7;
        r100 = null;
    L7:
        if (r100 != null) goto L9;
        goto L8
    }

    @LynxProp(name = "trigger")
    public final void setTrigger(String r100) {
        if (r100 != null) goto L4;
    L8:
        r100 = "Click";
    L9:
        this.f206780d = r100;
        b r101 = this.f206777a;
        if (r101 == null) goto L13;
        N(r101);
        return;
    L13:
        return;
    L4:
        if ((!StringsKt.isBlank(r100)) == true) goto L7;
        r100 = null;
    L7:
        if (r100 != null) goto L9;
        goto L8
    }

    public static final void M(final BitableLynxPopupView r100, View r101) {
        if (Intrinsics.areEqual(r100.f206778b, "Menu") == false) goto L6;
        tt5.a.k("BitableLynxPopupView", "PopupType.Menu is not supported yet, fallback to Popup");
    L6:
        if (r100.f206781e.isEmpty() == false) goto L8;
        tt5.a.k("BitableLynxPopupView", "showPopup ignored: items is empty");
        return;
    L8:
        com.larksuite.component.universe_design.menu.c r102 = r100.f206782f;
        if (r102 == null) goto L11;
        r102.a();
    L11:
        r100.f206782f = null;
        List<c> r103 = r100.f206781e;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
        final int r106 = 0;
    L13:
        if (r105.hasNext() == false) goto L18;
        Object r107 = r105.next();
        int r108 = r106 + 1;
        if (r106 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        final c r109 = (c) r107;
        r104.add(new d(r101.getContext(), r109, new BitableLynxPopupView$showPopup$menuItems$1$1(r100, r109, r106)));
        r106 = r108;
        goto L13
    L18:
        String r110 = r100.f206779c;
        int r111 = r110.hashCode();
        if (r111 == (-913702425)) goto L32;
        if (r111 == 84277) goto L29;
        if (r111 == 524532444) goto L26;
    L33:
        int r112 = 80;
    L35:
        String r113 = r100.f206779c;
        switch(r113.hashCode()) {
            case -1371445831: goto L67;
            case -913702425: goto L64;
            case -674586318: goto L60;
            case 2364455: goto L57;
            case 78959100: goto L54;
            case 310672626: goto L51;
            case 524532444: goto L48;
            case 766044999: goto L45;
            case 1046577809: goto L42;
            case 1720086446: goto L39;
            default: goto L70;
        };
    L70:
        PositionAlign r114 = PositionAlign.CENTER;
    L71:
        com.larksuite.component.universe_design.menu.c.f r115 = new com.larksuite.component.universe_design.menu.c.f();
        r115.c(r112);
        r115.b(r114);
        r115.f(r104);
        r115.d(new com.bytedance.ee.bear.bitable.anniex.view.a(r100));
        com.larksuite.component.universe_design.menu.c r116 = r115.a();
        r100.f206782f = r116;
        Intrinsics.checkNotNullParameter(r101, "anchorView");
        r116.c(r101);
        return;
    L39:
        if (r113.equals("LeftTop") == false) goto L70;
    L62:
        r114 = PositionAlign.START;
        goto L71
    L42:
        if (r113.equals("BottomRight") == false) goto L70;
    L69:
        r114 = PositionAlign.END;
        goto L71
    L45:
        if (r113.equals("RightBottom") == true) goto L69;
    L48:
        if (r113.equals("TopLeft") == true) goto L62;
    L51:
        if (r113.equals("BottomLeft") == true) goto L62;
    L54:
        if (r113.equals("Right") == true) goto L69;
    L57:
        if (r113.equals("Left") == true) goto L62;
    L60:
        if (r113.equals("LeftBottom") == true) goto L62;
    L64:
        if (r113.equals("TopRight") == true) goto L69;
    L67:
        if (r113.equals("RightTop") == true) goto L69;
    L26:
        if (r110.equals("TopLeft") == false) goto L33;
    L34:
        r112 = 48;
        goto L35
    L29:
        if (r110.equals("Top") == true) goto L34;
    L32:
        if (r110.equals("TopRight") == true) goto L34;
        goto L33
    }

    public static String O(ReadableMap r100, String r101) {
        Object r102 = r100.asHashMap().get(r101);     // Catch: Throwable -> L6
        if ((r102 instanceof String) == false) goto L8;
        return (String) r102;
    L8:
        return null;
    L6:
        th = move-exception;
        tt5.a.l("BitableLynxPopupView", "getOptionalString failed: key=".concat(r101), th);
        goto L8
    }
}
