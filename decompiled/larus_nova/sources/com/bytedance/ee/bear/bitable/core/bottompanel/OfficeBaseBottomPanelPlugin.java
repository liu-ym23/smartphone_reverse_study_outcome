package com.bytedance.ee.bear.bitable.core.bottompanel;

import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.OfficeDocumentPlugin;
import com.bytedance.ee.util.ui.n;
import com.larus.nova.R;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.chameleonv2.container.webcontainer.util.ContainerType;
import ew4.x;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u0013\u0018\u0000 (2\u00020\u0001:\u0001(B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0018\u0010\u001e\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0012\u0010\u001f\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0010\u0010 \u001a\u00020\u00182\u0006\u0010!\u001a\u00020\u000bH\u0002J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u000bH\u0002J\b\u0010$\u001a\u00020\u0018H\u0002J\u0012\u0010%\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0002J\b\u0010&\u001a\u00020\u0018H\u0002J\b\u0010'\u001a\u00020\u0018H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0012\u0010\r\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0014¨\u0006)"}, d2 = {"Lcom/bytedance/ee/bear/bitable/core/bottompanel/OfficeBaseBottomPanelPlugin;", "Lcom/bytedance/ee/bear/document/OfficeDocumentPlugin;", "<init>", "()V", "ability", "Lcom/bytedance/ee/bear/bitable/core/bottompanel/OfficeBaseBottomPanelAbilityImpl;", "fabConfig", "Lcom/bytedance/ee/bear/config/IBitableFabConfig;", "bottomContainer", "Landroid/view/ViewGroup;", "originalBottomHeight", "", "Ljava/lang/Integer;", "originalBottomVisibility", "originalBottomBackground", "Landroid/graphics/drawable/Drawable;", "keyboardObserver", "Lcom/bytedance/ee/bear/bitable/core/bottompanel/OfficeBaseBottomPanelKeyboardObserver;", "hostHeightListener", "com/bytedance/ee/bear/bitable/core/bottompanel/OfficeBaseBottomPanelPlugin$hostHeightListener$1", "Lcom/bytedance/ee/bear/bitable/core/bottompanel/OfficeBaseBottomPanelPlugin$hostHeightListener$1;", "getPluginId", "", "onAttachToHost", "", "host", "Lcom/ss/android/lark/chameleon/pluginapi/ChameleonPluginHost;", "onAttachToUIContainer", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "onDetachFromUIContainer", "onDetachFromHost", "applyBottomContainerHeight", "height", "applyBottomContainerBackgroundColor", "color", "restoreBottomContainer", "detachAbility", "stopObservingKeyboard", "stopObservingHostHeight", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeBaseBottomPanelPlugin extends OfficeDocumentPlugin {
    public static final a Companion = null;
    private static final int MAX_BOTTOM_HEIGHT_DP = 200;
    public static final String PLUGIN_ID = "OfficeBaseBottomPanelPlugin";
    private static final String TAG = "OfficeBaseBottomPanelPlugin";
    private com.bytedance.ee.bear.bitable.core.bottompanel.b ability;
    private ViewGroup bottomContainer;
    private x fabConfig;
    private final b hostHeightListener;
    private c keyboardObserver;
    private Drawable originalBottomBackground;
    private Integer originalBottomHeight;
    private Integer originalBottomVisibility;

    public static final class a {
        public a() {
        }
    }

    public static final class b implements ew4.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ OfficeBaseBottomPanelPlugin f210143a;

        public b(OfficeBaseBottomPanelPlugin r100) {
            this.f210143a = r100;
        }

        @Override // ew4.a
        public final void a(int r100) {
            com.bytedance.ee.bear.bitable.core.bottompanel.b r101 = OfficeBaseBottomPanelPlugin.access$getAbility$p(this.f210143a);
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.f210153j == true) goto L10;
            r101.f210148e = RangesKt.coerceAtLeast(r100, 0);
            r101.a(true);
            return;
        }

        @Override // ew4.a
        public final void b(boolean r100) {
            com.bytedance.ee.bear.bitable.core.bottompanel.b r101 = OfficeBaseBottomPanelPlugin.access$getAbility$p(this.f210143a);
            if (r101 != null) goto L5;
            return;
        L5:
            if (r101.f210153j == false) goto L7;
            return;
        L7:
            if (r101.f210150g == r100) goto L16;
            r101.f210150g = r100;
            Iterator<ew4.a> r102 = r101.f210146c.iterator();
        L11:
            if (r102.hasNext() == false) goto L17;
            r102.next().b(r100);
            goto L11
        L17:
            return;
        }
    }

    static {
        Companion = new a();
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin
    public String getPluginId() {
        return "OfficeBaseBottomPanelPlugin";
    }

    @Override // com.bytedance.ee.bear.document.OfficeDocumentPlugin, com.ss.android.lark.chameleon.AbsChameleonPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    private final void restoreBottomContainer() {
        ViewGroup r100 = this.bottomContainer;
        if (r100 != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L11;
        Integer r102 = this.originalBottomHeight;
        if (r102 == null) goto L10;
        r101.height = r102.intValue();
    L10:
        r100.setLayoutParams(r101);
    L11:
        Integer r103 = this.originalBottomVisibility;
        if (r103 == null) goto L14;
        r100.setVisibility(r103.intValue());
    L14:
        r100.setBackground(this.originalBottomBackground);
        this.bottomContainer = null;
        this.originalBottomHeight = null;
        this.originalBottomVisibility = null;
        this.originalBottomBackground = null;
    }

    private final void stopObservingHostHeight() {
        x r100 = this.fabConfig;
        if (r100 == null) goto L5;
        r100.g1(this.hostHeightListener);
    L5:
        this.fabConfig = null;
    }

    private final void stopObservingKeyboard() {
        c r100 = this.keyboardObserver;
        if (r100 != null) goto L5;
    L10:
        this.keyboardObserver = null;
        return;
    L5:
        if (r100.f210160c == false) goto L10;
        r100.f210160c = false;
        r100.f210158a.b(r100);
        com.bytedance.ee.bear.bitable.core.bottompanel.a.InterfaceC3024a r101 = r100.f210161d;
        r100.f210161d = null;
        if (r101 == null) goto L10;
        r101.close();
        goto L10
    }

    public OfficeBaseBottomPanelPlugin() {
        this.hostHeightListener = new b(this);
    }

    public static final /* synthetic */ com.bytedance.ee.bear.bitable.core.bottompanel.b access$getAbility$p(OfficeBaseBottomPanelPlugin r100) {
        return r100.ability;
    }

    private final void applyBottomContainerBackgroundColor(int r100) {
        ViewGroup r101 = this.bottomContainer;
        if (r101 == null) goto L6;
        r101.setBackgroundColor(r100);
        return;
    }

    private final void applyBottomContainerHeight(int r100) {
        ViewGroup r101 = this.bottomContainer;
        if (r101 != null) goto L5;
        return;
    L5:
        int r102 = 0;
        int r103 = RangesKt.coerceIn(r100, 0, n.f(r101.getContext(), 200));
        ViewGroup.LayoutParams r104 = r101.getLayoutParams();
        if (r104 != null) goto L8;
        return;
    L8:
        if (r103 > 0) goto L12;
        r102 = 8;
    L12:
        if (r104.height == r103) goto L14;
    L16:
        r104.height = r103;
        r101.setLayoutParams(r104);
        r101.setVisibility(r102);
        return;
    L14:
        if (r101.getVisibility() != r102) goto L16;
    }

    private final void detachAbility(ChameleonPluginHost r100) {
        stopObservingKeyboard();
        stopObservingHostHeight();
        com.bytedance.ee.bear.bitable.core.bottompanel.b r101 = this.ability;
        if (r101 == null) goto L7;
        r101.f210153j = true;
        r101.f210147d.clear();
        r101.f210146c.clear();
        r101.f210151h = null;
        if (r100 == null) goto L7;
        r100.unregisterHostAbility(r101);
    L7:
        this.ability = null;
    }

    public void onAttachToHost(ChameleonPluginHost r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        super.onAttachToHost(r100);
        detachAbility(r100);
        com.bytedance.ee.bear.bitable.core.bottompanel.b r101 = new com.bytedance.ee.bear.bitable.core.bottompanel.b(new OfficeBaseBottomPanelPlugin$onAttachToHost$currentAbility$1(this), new OfficeBaseBottomPanelPlugin$onAttachToHost$currentAbility$2(this));
        this.ability = r101;
        r100.registerHostAbility(r101);
    }

    public void onDetachFromHost(ChameleonPluginHost r100) {
        stopObservingKeyboard();
        restoreBottomContainer();
        detachAbility(r100);
        super.onDetachFromHost(r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((ChameleonPluginHost) r100);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r100) {
        onDetachFromHost((ChameleonPluginHost) r100);
    }

    public static final /* synthetic */ void access$applyBottomContainerBackgroundColor(OfficeBaseBottomPanelPlugin r100, int r101) {
        r100.applyBottomContainerBackgroundColor(r101);
    }

    public static final /* synthetic */ void access$applyBottomContainerHeight(OfficeBaseBottomPanelPlugin r100, int r101) {
        r100.applyBottomContainerHeight(r101);
    }

    public void onAttachToUIContainer(ChameleonPluginHost r100, t r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "uiContainer");
        super.onAttachToUIContainer(r100, r101);
        stopObservingKeyboard();
        restoreBottomContainer();
        stopObservingHostHeight();
        com.bytedance.ee.bear.bitable.core.basemain.ability.b r102 = (com.bytedance.ee.bear.bitable.core.basemain.ability.b) r100.getHostAbilityOrNull(com.bytedance.ee.bear.bitable.core.basemain.ability.b.class);
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L9:
        if (r103 == false) goto L12;
        tt5.a.h("OfficeBaseBottomPanelPlugin", "skip Bottom slot for Base embedded in another document");
        return;
    L12:
        ViewGroup r104 = r100.getContainer(ContainerType.Bottom.getValue());
        if (r104 != null) goto L16;
        tt5.a.d("OfficeBaseBottomPanelPlugin", "attach failed, Bottom container not found");
        return;
    L16:
        this.bottomContainer = r104;
        ViewGroup.LayoutParams r105 = r104.getLayoutParams();
        Unit r106 = null;
        if (r105 == null) goto L19;
        Integer r107 = Integer.valueOf(r105.height);
    L20:
        this.originalBottomHeight = r107;
        this.originalBottomVisibility = Integer.valueOf(r104.getVisibility());
        this.originalBottomBackground = r104.getBackground();
        com.bytedance.ee.bear.bitable.core.bottompanel.b r108 = this.ability;
        if (r108 == null) goto L30;
        int r109 = ContextCompat.getColor(r104.getContext(), R.color.bg_body);
        if (r108.f210153j == true) goto L30;
        Integer r110 = r108.f210151h;
        if (r110 == null) goto L28;
        r109 = r110.intValue();
    L29:
        r108.f210145b.invoke(Integer.valueOf(r109));
        goto L30
    L28:
        r108.f210151h = Integer.valueOf(r109);
    L30:
        com.bytedance.ee.bear.bitable.core.bottompanel.b r111 = this.ability;
        if (r111 == null) goto L44;
        c r112 = new c(pcb.a.AbstractC7181a.b(r100.getActivity()), r111);
        if (r112.f210160c == true) goto L43;
        r112.f210160c = true;
        r112.f210158a.d(r112);
        if (r112.f210158a.getVisibleKeyboardHeight() > 0) goto L38;
        com.bytedance.ee.bear.bitable.core.bottompanel.a.InterfaceC3024a r113 = r112.f210161d;
        r112.f210161d = null;
        if (r113 == null) goto L43;
        r113.close();
        goto L43
    L38:
        if (r112.f210161d != null) goto L43;
        r112.f210161d = r112.f210159b.Yc("Keyboard");
    L43:
        this.keyboardObserver = r112;
    L44:
        x r114 = (x) r100.getUserComponent().a(x.class);
        this.fabConfig = r114;
        if (r114 == null) goto L54;
        r114.j(this.hostHeightListener);
        com.bytedance.ee.bear.bitable.core.bottompanel.b r115 = this.ability;
        if (r115 == null) goto L53;
        int r116 = r114.s();
        if (r115.f210153j == true) goto L52;
        r115.f210148e = RangesKt.coerceAtLeast(r116, 0);
        r115.a(true);
    L52:
        r106 = Unit.INSTANCE;
    L53:
        if (r106 == null) goto L54;
        return;
    L54:
        applyBottomContainerHeight(0);
        return;
    L19:
        r107 = null;
        goto L20
    L5:
        if (r102.D3() != true) goto L7;
        r103 = true;
        goto L9
    }

    public void onDetachFromUIContainer(ChameleonPluginHost r100, t r101) {
        Intrinsics.checkNotNullParameter(r100, "host");
        Intrinsics.checkNotNullParameter(r101, "uiContainer");
        stopObservingHostHeight();
        stopObservingKeyboard();
        restoreBottomContainer();
        super.onDetachFromUIContainer(r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r100, t r101) {
        onAttachToUIContainer((ChameleonPluginHost) r100, r101);
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onDetachFromUIContainer(PluginHost r100, t r101) {
        onDetachFromUIContainer((ChameleonPluginHost) r100, r101);
    }
}
