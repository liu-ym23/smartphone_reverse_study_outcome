package com.bytedance.ee.bear.bitable.lynx;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.ee.bear.bitable.common.BTJson;
import com.bytedance.ee.bear.bitable.lynx.pro.BitableProLynxPlugin;
import com.bytedance.ee.bear.bitable.plugin.BitableBasePlugin;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.s;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.i5;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.bear.lynx.api.CCMLynxCardView;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;
import vv4.k;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/bitable/lynx/BitableCCMLynxPlugin;", "Lcom/bytedance/ee/bear/bitable/plugin/BitableBasePlugin;", "<init>", "()V", "delegate", "Lcom/bytedance/ee/bear/document/LynxWebDelegateImpl;", "getDelegate", "()Lcom/bytedance/ee/bear/document/LynxWebDelegateImpl;", "setDelegate", "(Lcom/bytedance/ee/bear/document/LynxWebDelegateImpl;)V", "onAttachToHost", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "isViewImmersive", "", "LynxPanelData", "CommonBizLynxPanelHandler", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BitableCCMLynxPlugin extends BitableBasePlugin {
    private i5 delegate;

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/lynx/BitableCCMLynxPlugin$LynxPanelData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "action", "", "getAction", "()Ljava/lang/Integer;", "setAction", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "closeAction", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "getCloseAction", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "setCloseAction", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LynxPanelData implements NonProguard {
        private Integer action;
        private ActionPayload closeAction;

        public LynxPanelData() {
        }

        public final Integer getAction() {
            return this.action;
        }

        public final ActionPayload getCloseAction() {
            return this.closeAction;
        }

        public final void setAction(Integer r100) {
            this.action = r100;
        }

        public final void setCloseAction(ActionPayload r100) {
            this.closeAction = r100;
        }
    }

    public final class a implements i<String> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f214614a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f214615b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f214616c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public BitableAbsCCMLynxFragment f214617d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final s f214618e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public m f214619f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public ActionPayload f214620g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ BitableCCMLynxPlugin f214621h;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public final void a() {
            if (this.f214621h.getHostAbilityOrNull(com.bytedance.ee.bear.bitable.core.basemain.ability.b.class) == null) goto L5;
            boolean r100 = true;
        L7:
            if (com.bytedance.ee.bear.bitable.c.x() == false) goto L10;
            if (r100 == false) goto L10;
            BitableCCMLynxPlugin.access$getUIContainer(this.f214621h).d(this.f214621h);
        L13:
            i5 r101 = this.f214621h.getDelegate();
            if (r101 == null) goto L16;
            String r102 = this.f214614a;
            Intrinsics.checkNotNullParameter(r102, "bridgeName");
            r101.f219953b.remove(r102);
        L16:
            this.f214617d = null;
            if (this.f214615b != 8) goto L29;
            int r103 = BitableAbsCCMLynxFragment.f214598l;
            tt5.a.h("BitableAbsLynxFragment", "members page closed: send exposure event to pro page");
            BitableProLynxPlugin r104 = (BitableProLynxPlugin) BitableCCMLynxPlugin.access$findPlugin(this.f214621h, BitableProLynxPlugin.class);
            if (r104 == null) goto L30;
            Fragment r105 = BitableCCMLynxPlugin.access$getUIContainer(this.f214621h).l(r104);
            if ((r105 instanceof BitableAbsCCMLynxFragment) == false) goto L23;
            BitableAbsCCMLynxFragment r106 = (BitableAbsCCMLynxFragment) r105;
        L24:
            if (r106 == null) goto L31;
            CCMLynxCardView r107 = r106.f214604j;
            if (r107 == null) goto L32;
            r107.sendEvent("bitable.exposure", null);
            return;
        L32:
            return;
        L31:
            return;
        L23:
            r106 = null;
            goto L24
        L30:
            return;
        L29:
            return;
        L10:
            BitableAbsCCMLynxFragment r108 = this.f214617d;
            if (r108 == null) goto L13;
            r108.T90(R.anim.facade_slide_right_out);
            goto L13
        L5:
            r100 = false;
            goto L7
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r110, m r111) {
            String r112 = (String) r110;
            int r100 = BitableAbsCCMLynxFragment.f214598l;
            StringBuilder r101 = new StringBuilder("handle: bridge=");
            r101.append(this.f214614a);
            r101.append(", viewType=");
            r101.append(this.f214615b);
            r101.append(", dataLength=");
            if (r112 == null) goto L5;
            int r102 = r112.length();
        L6:
            r101.append(r102);
            tt5.a.h("BitableAbsLynxFragment", r101.toString());
            if (r111 == null) goto L12;
            i5 r103 = this.f214621h.getDelegate();
            if (r103 == null) goto L11;
            r103.c(this.f214614a, r111);
        L11:
            this.f214619f = r111;
        L12:
            LynxPanelData r113 = (LynxPanelData) GsonProtectorUtils.fromJson(BTJson.f209798c.f209799a, r112, LynxPanelData.class);
            this.f214620g = r113.getCloseAction();
            Integer r104 = r113.getAction();
            if (r104 == null) goto L33;
            boolean r105 = true;
            if (r104.intValue() != 1) goto L33;
            if (this.f214617d != null) goto L39;
            t r114 = BitableCCMLynxPlugin.access$getUIContainer(this.f214621h);
            FragmentTransaction r106 = r114.getFragmentManager().beginTransaction();
            BitableAbsCCMLynxFragment r107 = new BitableAbsCCMLynxFragment(this.f214614a, this.f214615b, this.f214616c, this.f214621h.getDelegate(), new b(this));
            BitableCCMLynxPlugin r108 = this.f214621h;
            if (r108.getHostAbilityOrNull(com.bytedance.ee.bear.bitable.core.basemain.ability.b.class) != null) goto L24;
            r105 = false;
        L24:
            if (com.bytedance.ee.bear.bitable.c.x() == false) goto L27;
            if (r105 == false) goto L27;
            r114.e(r108, r107, s.a(R.anim.facade_slide_right_in_300, R.anim.facade_slide_right_out, 0, 0));
        L32:
            this.f214617d = r107;
        L27:
            s r115 = this.f214618e;
            r106.setCustomAnimations(r115.f216644a, r115.f216645b, r115.f216646c, r115.f216647d);
            String r116 = this.f214614a;
            if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r106, r107, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r116, R.id.pluginUIContainer) == true) goto L31;
            r106.add(R.id.pluginUIContainer, r107, r116);
        L31:
            r106.commitAllowingStateLoss();
        L39:
            BitableAbsCCMLynxFragment r117 = this.f214617d;
            if (r117 == null) goto L43;
            r117.f214605k.setValue(r112);
            return;
        L43:
            return;
        L33:
            Integer r118 = r113.getAction();
            if (r118 == null) goto L39;
            if (r118.intValue() != 2) goto L39;
            a();
            goto L39
        L5:
            r102 = 0;
            goto L6
        }

        public a(BitableCCMLynxPlugin r100, String r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r101, "bridge");
            this.f214621h = r100;
            this.f214614a = r101;
            this.f214615b = r102;
            this.f214616c = r103;
            this.f214618e = s.a(R.anim.facade_slide_right_in_300, R.anim.facade_slide_left_out, R.anim.facade_slide_left_in, R.anim.facade_slide_right_out);
        }
    }

    @Override // com.bytedance.ee.bear.bitable.plugin.BitableBasePlugin, com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public boolean isViewImmersive() {
        return com.bytedance.ee.bear.bitable.c.x();
    }

    public BitableCCMLynxPlugin() {
    }

    public final i5 getDelegate() {
        return this.delegate;
    }

    public static final /* synthetic */ t access$getUIContainer(BitableCCMLynxPlugin r100) {
        return r100.getUIContainer();
    }

    public void onAttachToHost(DocumentPluginHost r100) {
        super.onAttachToHost(r100);
        k r101 = getWeb();
        if (r101 == null) goto L6;
        this.delegate = new i5(r101);
        return;
    }

    public final void setDelegate(i5 r100) {
        this.delegate = r100;
    }

    @Override // com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r100) {
        onAttachToHost((DocumentPluginHost) r100);
    }

    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$findPlugin(BitableCCMLynxPlugin r100, Class r101) {
        return r100.findPlugin(r101);
    }
}
