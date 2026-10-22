package com.bytedance.ee.bear.bitable.lynx;

import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bitable.common.BTJson;
import com.bytedance.ee.bear.bitable.plugin.BitableBasePlugin;
import com.bytedance.ee.bear.bitable.uikit.ActionPayload;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.io.NonProguard;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tb5.i;
import tb5.m;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/ee/bear/bitable/lynx/BitableAnniexBizLynxPlugin;", "Lcom/bytedance/ee/bear/bitable/plugin/BitableBasePlugin;", "<init>", "()V", "LynxPanelData", "ModalBizLynxPanelHandler", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class BitableAnniexBizLynxPlugin extends BitableBasePlugin {

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/bytedance/ee/bear/bitable/lynx/BitableAnniexBizLynxPlugin$LynxPanelData;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "action", "", "getAction", "()Ljava/lang/Integer;", "setAction", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "closeAction", "Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "getCloseAction", "()Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;", "setCloseAction", "(Lcom/bytedance/ee/bear/bitable/uikit/ActionPayload;)V", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
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
        public final int f214608a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f214609b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public BitableModalLynxFragment f214610c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public m f214611d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public ActionPayload f214612e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ BitableAnniexBizLynxPlugin f214613f;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public a(BitableAnniexBizLynxPlugin r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "bridge");
            this.f214613f = r100;
            this.f214608a = 3;
            this.f214609b = r101;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r100, m r101) {
            String r102 = (String) r100;
            if (r101 == null) goto L5;
            this.f214611d = r101;
        L5:
            LynxPanelData r103 = (LynxPanelData) GsonProtectorUtils.fromJson(BTJson.f209798c.f209799a, r102, LynxPanelData.class);
            this.f214612e = r103.getCloseAction();
            Integer r104 = r103.getAction();
            if (r104 != null) goto L9;
        L17:
            Integer r105 = r103.getAction();
            if (r105 != null) goto L21;
        L31:
            BitableModalLynxFragment r106 = this.f214610c;
            if (r106 == null) goto L40;
            m r107 = this.f214611d;
            r106.f214622J.setValue(r102);
            r106.L = r107;
            return;
        L40:
            return;
        L21:
            if (r105.intValue() != 2) goto L31;
            BitableModalLynxFragment r108 = this.f214610c;
            if (r108 != null) goto L36;
        L30:
            this.f214610c = null;
            goto L31
        L36:
            r108.dismissAllowingStateLoss();     // Catch: Exception -> L26
        L26:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r109 = DialogFragmentLancet.sLastShowStack;
            if (r109 == null) goto L30;
            com.bytedance.crash.d.d(r109, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L30
        L9:
            if (r104.intValue() != 1) goto L17;
            if (this.f214610c != null) goto L31;
            BitableModalLynxFragment r110 = new BitableModalLynxFragment(this.f214608a, this.f214609b, new com.bytedance.ee.bear.bitable.lynx.a(this));
            BitableAnniexBizLynxPlugin r111 = this.f214613f;
            this.f214610c = r110;
            FragmentManager r112 = BitableAnniexBizLynxPlugin.access$getFragmentManager(r111);
            LandscapeRestrictionOperation r113 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r110, "SearchConfig", r113);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r112, r110, r113) == true) goto L31;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L35
        L16:
            r110.show(r112, "SearchConfig");
            goto L31
        }
    }

    @Override // com.bytedance.ee.bear.bitable.plugin.BitableBasePlugin, com.bytedance.ee.bear.document.DocumentPlugin, com.bytedance.ee.bear.browser.BaseWebPlugin, com.bytedance.ee.bear.browser.plugin.BasePlugin, com.bytedance.ee.bear.browser.plugin.f
    public /* bridge */ /* synthetic */ void onPause(PluginHost r100) {
    }

    public BitableAnniexBizLynxPlugin() {
    }

    public static final /* synthetic */ FragmentManager access$getFragmentManager(BitableAnniexBizLynxPlugin r100) {
        return r100.getFragmentManager();
    }
}
