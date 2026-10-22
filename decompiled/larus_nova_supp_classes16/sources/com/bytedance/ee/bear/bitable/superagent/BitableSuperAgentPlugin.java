package com.bytedance.ee.bear.bitable.superagent;

import android.text.Editable;
import android.text.SpannableString;
import android.webkit.ValueCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bytedance.ee.bear.bitable.card.view.cell.text.BitableAtEditText;
import com.bytedance.ee.bear.bitable.plugin.BitableBasePlugin;
import com.bytedance.ee.bear.bitable.superagent.conversationmanager.ConversationManagerPanel;
import com.bytedance.ee.bear.bitable.superagent.subconversation.SubConversationPanel;
import com.bytedance.ee.bear.bitable.superagent.voice.BitableSuperAgentVoiceStateButton;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.bytedance.ee.bear.document.orientation.BaseUnspecifiedOrientationPlugin;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerV2$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00172\u00020\u0001:\u0006\u0012\u0013\u0014\u0015\u0016\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u0007H\u0016J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0018"}, d2 = {"Lcom/bytedance/ee/bear/bitable/superagent/BitableSuperAgentPlugin;", "Lcom/bytedance/ee/bear/bitable/plugin/BitableBasePlugin;", "<init>", "()V", "getBridgeHandlers", "", "handlersHolder", "", "", "Lcom/bytedance/ee/bear/jsbridge/BridgeHandlerV2;", "onAttachToHost", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "onDetachFromHost", "delegate", "Lcom/bytedance/ee/bear/bitable/superagent/IBitableSuperAgentDelegate;", "getDelegate", "()Lcom/bytedance/ee/bear/bitable/superagent/IBitableSuperAgentDelegate;", "PanelHandler", "ConversationHandler", "SubConversationHandler", "ConversationManagerHandler", "VoiceInputHandler", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableSuperAgentPlugin extends BitableBasePlugin {
    private static final String BITABLE_SUPER_AGENT_CONVERSATION = "bitable.super.agent.conversation";
    private static final String BITABLE_SUPER_AGENT_CONVERSATION_MANAGER = "bitable.super.agent.conversationManager";
    private static final String BITABLE_SUPER_AGENT_SUBCONVERSATION = "bitable.super.agent.subConversation";
    private static final String BITABLE_SUPER_AGENT_VOICE_INPUT = "bitable.super.agent.voiceInput";
    public static final a Companion = null;
    public static final String TAG = "BitableSuperAgentPlugin";
    private final r delegate;

    public static final class a {
        public a() {
        }
    }

    public final class b extends d {
        @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentPlugin.d
        public final BitableSuperAgentBasePanel a() {
            return new BitableSuperAgentPanel();
        }

        public b(BitableSuperAgentPlugin r3) {
            super(r3, "ConversationHandler", "BitableSuperAgentPanel");
        }
    }

    public final class c extends d {
        @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentPlugin.d
        public final BitableSuperAgentBasePanel a() {
            return new ConversationManagerPanel();
        }

        public c(BitableSuperAgentPlugin r3) {
            super(r3, "ConversationManagerHandler", "ConversationManagerPanel");
        }
    }

    public abstract class d implements tb5.i<String> {
        public final String a;
        public final String b;
        public final /* synthetic */ BitableSuperAgentPlugin c;

        public /* synthetic */ class a {
            public static final /* synthetic */ int[] a = null;

            static {
                int[] r0 = new int[MobileSuperAgentOperation.values().length];
                r0[MobileSuperAgentOperation.ENTER.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
            L13:
                r0[MobileSuperAgentOperation.UPDATE_ALL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
            L19:
                r0[MobileSuperAgentOperation.UPDATE_PATCH.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
            L15:
                r0[MobileSuperAgentOperation.EXIT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
            L7:
                a = r0;
            }
        }

        public abstract BitableSuperAgentBasePanel a();

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r10, tb5.m r11) {
            String r12 = (String) r10;
            if (r12 == null) goto L89;
            FragmentManager r0 = BitableSuperAgentPlugin.access$getFragmentManager(this.c);
            if (r0 != null) goto L9;
            return;
        L9:
            if (r0.isStateSaved() == true) goto L91;
            JSONObject r1 = new JSONObject(r12);     // Catch: Exception -> L66
            MobileSuperAgentOperation.a r13 = MobileSuperAgentOperation.Companion;
            Integer r2 = Integer.valueOf(r1.optInt("operation"));
            r13.getClass();
            Iterator r14 = MobileSuperAgentOperation.getEntries().iterator();
        L13:
            boolean r4 = false;
            BitableSuperAgentBasePanel r6 = null;
            if (r14.hasNext() == false) goto L24;
            Object r3 = r14.next();
            int r7 = ((MobileSuperAgentOperation) r3).getI();
            if (r2 != null) goto L19;
        L21:
            boolean r8 = false;
        L22:
            if (r8 == false) goto L13;
        L25:
            MobileSuperAgentOperation r5 = (MobileSuperAgentOperation) r3;
            if (r5 != null) goto L28;
            tt5.a.h(BitableSuperAgentPlugin.TAG, this.a + ": operation is null");
            return;
        L28:
            String r16 = r1.optString("baseId");
            String r9 = "";
            if (r16 != null) goto L31;
            r16 = "";
        L31:
            String r17 = r1.optString("lifecycleId");
            if (r17 == null) goto L35;
            r9 = r17;
        L35:
            Fragment r18 = r0.findFragmentByTag(this.b);
            if ((r18 instanceof BitableSuperAgentBasePanel) == false) goto L38;
            r6 = (BitableSuperAgentBasePanel) r18;
        L38:
            StringBuilder r19 = new StringBuilder();
            r19.append(this.a);
            r19.append(": ");
            r19.append(r5.name());
            r19.append(", existing=");
            if (r6 == null) goto L41;
            r4 = true;
        L41:
            r19.append(r4);
            tt5.a.h(BitableSuperAgentPlugin.TAG, r19.toString());
            int r110 = a.a[r5.ordinal()];
            if (r110 != 1) goto L44;
            if (r6 != null) goto L87;
            BitableSuperAgentBasePanel r111 = a();
            r111.ga0(new p(r16, r9, this.c.getDelegate()));
            r111.da0(r1);
            String r112 = this.b;
            LandscapeRestrictionOperation r20 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r111, r112, r20);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r0, r111, r20) == true) goto L93;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L69
        L65:
            r111.show(r0, r112);
            return;
        L93:
            return;
        L87:
            return;
        L44:
            if (r110 != 2) goto L46;
        L58:
            if (r6 == null) goto L85;
            r6.da0(r1);
            return;
        L85:
            return;
        L46:
            if (r110 == 3) goto L58;
            if (r110 != 4) goto L57;
            if (r6 == null) goto L82;
            r6.dismissAllowingStateLoss();     // Catch: Exception -> L52
            return;
        L52:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r113 = DialogFragmentLancet.sLastShowStack;
            if (r113 == null) goto L83;
            com.bytedance.crash.d.d(r113, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            return;
        L83:
            return;
        L82:
            return;
        L57:
            throw new NoWhenBranchMatchedException();
        L19:
            if (r7 != r2.intValue()) goto L21;
            r8 = true;
            goto L22
        L24:
            r3 = null;
        L66:
            e = move-exception;
            tt5.a.l(BitableSuperAgentPlugin.TAG, this.a + ": parse json failed", e);
            return;
        L91:
            return;
        }

        public d(BitableSuperAgentPlugin r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "logName");
            Intrinsics.checkNotNullParameter(r4, "panelTag");
            this.c = r2;
            this.a = r3;
            this.b = r4;
        }
    }

    public final class e extends d {
        @Override // com.bytedance.ee.bear.bitable.superagent.BitableSuperAgentPlugin.d
        public final BitableSuperAgentBasePanel a() {
            return new SubConversationPanel();
        }

        public e(BitableSuperAgentPlugin r3) {
            super(r3, "SubConversationHandler", "SubConversationPanel");
        }
    }

    public final class f implements tb5.i<String> {
        public final /* synthetic */ BitableSuperAgentPlugin a;

        @Override // tb5.i, tb5.o
        public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
            return BridgeHandlerV2$CC.$default$authType(this);
        }

        public f(BitableSuperAgentPlugin r1) {
            this.a = r1;
        }

        @Override // tb5.i, tb5.o
        public final void handle(Object r11, tb5.m r12) {
            String r13 = (String) r11;
            if (r13 == null) goto L116;
            FragmentManager r14 = BitableSuperAgentPlugin.access$getFragmentManager(this.a);
            if (r14 != null) goto L9;
            return;
        L9:
            if (r14.isStateSaved() == true) goto L118;
            BitableSuperAgentPanel r16 = r14.findFragmentByTag("BitableSuperAgentPanel");
            if ((r16 instanceof BitableSuperAgentPanel) == false) goto L14;
            BitableSuperAgentPanel r17 = r16;
        L15:
            if (r17 == null) goto L119;
            JSONObject r0 = new JSONObject(r13);     // Catch: Exception -> L107
            if (r17.getView() == null) goto L120;
            JSONObject r18 = r0.optJSONObject("state");
            if (r18 == null) goto L121;
            String r1 = r18.optString("status");
            boolean r4 = true;
            if (Intrinsics.areEqual(r1, "starting") == false) goto L27;
        L32:
            boolean r3 = true;
        L34:
            if (r3 == r17.v) goto L40;
            r17.v = r3;
            BitableAtEditText r5 = r17.ea0().d.c;
            if (r17.v == false) goto L38;
            rcb.c.d(r5);
            r5.clearFocus();
            r5.setFocusableAndClickable(false);
        L39:
            r17.ka0();
            goto L40
        L38:
            r5.setFocusableAndClickable(true);
        L40:
            Intrinsics.checkNotNull(r1);
            BitableSuperAgentVoiceStateButton r6 = r17.ea0().d.f;
            int r8 = r1.hashCode();
            if (r8 == 993558001) goto L55;
            if (r8 == 1316806720) goto L52;
            if (r8 == 1715648628) goto L48;
        L56:
            BitableSuperAgentVoiceStateButton.Mode r2 = BitableSuperAgentVoiceStateButton.Mode.IDLE;
        L58:
            r6.setMode(r2);
            double r7 = r18.optDouble("level", Double.NaN);
            if (Double.isNaN(r7) == true) goto L61;
            r17.ea0().d.f.setLevel((float) r7);
        L61:
            JSONArray r19 = r18.optJSONArray("contentJson");
            if (r19 == null) goto L122;
            BitableAtEditText r9 = r17.ea0().d.c;
            Result.Companion r10 = Result.Companion;     // Catch: Throwable -> L67
            String r110 = r19.toString();     // Catch: Throwable -> L67
            int r20 = com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.a.a;     // Catch: Throwable -> L67
            Object r111 = Result.constructor-impl(com.bytedance.ee.bear.bitable.card.model.jsmodel.cellvalue.a.d(r110, new Pair(Boolean.FALSE, "")));     // Catch: Throwable -> L67
        L70:
            if (Result.isFailure-impl(r111) == false) goto L72;
            r111 = null;
        L72:
            db5.a r112 = (db5.a) r111;
            if (r112 == null) goto L123;
            r9.getPresenter().x(r112);
            if (r17.v == false) goto L92;
            BitableAtEditText r113 = r17.ea0().d.c;
            Editable r21 = r113.getEditableText();
            if (r21 != null) goto L81;
            return;
        L81:
            if (r21.length() == 0) goto L84;
            r4 = false;
        L84:
            ev4.a r22 = r17.z;
            if (r22 == null) goto L87;
            r22.a = r4;
        L88:
            r17.z = r22;
            if (r21.getSpanStart(r22) >= 0) goto L91;
            SpannableString r114 = new SpannableString(" ");
            r114.setSpan(r22, 0, r114.length(), 33);
            r21.append(r114);
        L91:
            r22.e.start();
            return;
        L87:
            r22 = new ev4.a(r113.getContext(), r4);
            goto L88
        L92:
            ev4.a r115 = r17.z;
            if (r115 == null) goto L125;
            r115.e.stop();
            Editable r23 = r17.ea0().d.c.getEditableText();
            if (r23 == null) goto L106;
            int r24 = r23.getSpanStart(r115);
            int r26 = r23.getSpanEnd(r115);
            r23.removeSpan(r115);
            if (r24 < 0) goto L101;
            if (r24 >= r26) goto L101;
        L102:
            if (r4 == false) goto L106;
            if (r26 > r23.length()) goto L106;
            r23.delete(r24, r26);
        L101:
            r4 = false;
        L106:
            r17.z = null;
            return;
        L125:
            return;
        L123:
            return;
        L67:
            th = move-exception;
            Result.Companion r27 = Result.Companion;
            r111 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L70
        L122:
            return;
        L48:
            if (r1.equals("stopping") == false) goto L56;
            r2 = BitableSuperAgentVoiceStateButton.Mode.STOPPING;
            goto L58
        L52:
            if (r1.equals("starting") == false) goto L56;
            r2 = BitableSuperAgentVoiceStateButton.Mode.STARTING;
            goto L58
        L55:
            if (r1.equals("recording") == false) goto L56;
            r2 = BitableSuperAgentVoiceStateButton.Mode.RECORDING;
            goto L58
        L27:
            if (Intrinsics.areEqual(r1, "recording") == true) goto L32;
            if (Intrinsics.areEqual(r1, "stopping") == true) goto L32;
            r3 = false;
            goto L34
        L121:
            return;
        L120:
            return;
        L107:
            e = move-exception;
            tt5.a.l(BitableSuperAgentPlugin.TAG, "VoiceInputHandler: parse json failed", e);
            return;
        L119:
            return;
        L14:
            r17 = null;
            goto L15
        L118:
            return;
        }
    }

    public static final class g implements r {
        public final /* synthetic */ BitableSuperAgentPlugin a;

        @Override // com.bytedance.ee.bear.bitable.superagent.r
        public final void b() {
            BaseUnspecifiedOrientationPlugin r0 = (BaseUnspecifiedOrientationPlugin) BitableSuperAgentPlugin.access$findPlugin(this.a, BaseUnspecifiedOrientationPlugin.class);
            if (r0 == null) goto L6;
            r0.toggleDeviceOrientation();
            return;
        }

        @Override // com.bytedance.ee.bear.bitable.superagent.r
        public final void forcePortrait() {
            BaseUnspecifiedOrientationPlugin r0 = (BaseUnspecifiedOrientationPlugin) BitableSuperAgentPlugin.access$findPlugin(this.a, BaseUnspecifiedOrientationPlugin.class);
            if (r0 == null) goto L6;
            r0.forcePortrait();
            return;
        }

        @Override // com.bytedance.ee.bear.bitable.superagent.r
        public final void forcePortraitAndLock() {
            BaseUnspecifiedOrientationPlugin r0 = (BaseUnspecifiedOrientationPlugin) BitableSuperAgentPlugin.access$findPlugin(this.a, BaseUnspecifiedOrientationPlugin.class);
            if (r0 == null) goto L6;
            r0.forcePortraitAndLock();
            return;
        }

        public g(BitableSuperAgentPlugin r1) {
            this.a = r1;
        }

        public final void a(String r2, com.alibaba.fastjson.JSONObject r3, ValueCallback<String> r4) {
            Intrinsics.checkNotNullParameter(r2, "funcName");
            BitableSuperAgentPlugin.access$execJS(this.a, r2, r3, r4);
        }
    }

    static {
        Companion = new a();
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public BitableSuperAgentPlugin() {
        this.delegate = new g(this);
    }

    public final r getDelegate() {
        return this.delegate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentManager access$getFragmentManager(BitableSuperAgentPlugin r0) {
        return r0.getFragmentManager();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void getBridgeHandlers(Map<String, tb5.i<?>> r3) {
        Intrinsics.checkNotNullParameter(r3, "handlersHolder");
        super/*com.bytedance.ee.bear.document.DocumentPlugin*/.getBridgeHandlers(r3);
        r3.put(BITABLE_SUPER_AGENT_CONVERSATION, new b(this));
        r3.put(BITABLE_SUPER_AGENT_SUBCONVERSATION, new e(this));
        r3.put(BITABLE_SUPER_AGENT_CONVERSATION_MANAGER, new c(this));
        r3.put(BITABLE_SUPER_AGENT_VOICE_INPUT, new f(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onAttachToHost(DocumentPluginHost r2) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToHost(r2);
        tt5.a.h(TAG, "onAttachToHost");
    }

    public void onDetachFromHost(DocumentPluginHost r2) {
        super.onDetachFromHost(r2);
        tt5.a.h(TAG, "onDetachFromHost");
    }

    public /* bridge */ /* synthetic */ void onAttachToHost(PluginHost r1) {
        onAttachToHost((DocumentPluginHost) r1);
    }

    public /* bridge */ /* synthetic */ void onDetachFromHost(PluginHost r1) {
        onDetachFromHost((DocumentPluginHost) r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ com.bytedance.ee.bear.browser.plugin.f access$findPlugin(BitableSuperAgentPlugin r0, Class r1) {
        return r0.findPlugin(r1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ void access$execJS(BitableSuperAgentPlugin r0, String r1, com.alibaba.fastjson.JSONObject r2, ValueCallback r3) {
        r0.execJS(r1, r2, r3);
    }
}
