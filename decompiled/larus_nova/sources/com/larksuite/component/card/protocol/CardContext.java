package com.larksuite.component.card.protocol;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larksuite.component.card.monitor.UniversalCardMonitorData;
import com.larksuite.component.card.protocol.context.ActionContext;
import com.larksuite.component.card.protocol.context.BizContext;
import com.larksuite.component.card.protocol.context.CardStyle;
import com.larksuite.component.card.protocol.context.ICardDependency;
import com.larksuite.component.card.protocol.context.StreamingState;
import com.larksuite.component.card.protocol.data.action.CardActionDependencyData;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b \u0018\u0000 82\u00020\u0001:\u00018Bw\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0006\u0010\f\u001a\u00020\u0003\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\u0013\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001dR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u00069"}, d2 = {"Lcom/larksuite/component/card/protocol/CardContext;", "Ljava/io/Serializable;", "key", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", WidgetService.PARAM_FRAGMENT, "Landroidx/fragment/app/Fragment;", "bizContext", "Lcom/larksuite/component/card/protocol/context/BizContext;", "actionContext", "Lcom/larksuite/component/card/protocol/context/ActionContext;", "host", "monitorData", "Lcom/larksuite/component/card/monitor/UniversalCardMonitorData;", "deliveryType", "cardActionDependencyData", "Lcom/larksuite/component/card/protocol/data/action/CardActionDependencyData;", "dependency", "Lcom/larksuite/component/card/protocol/context/ICardDependency;", "cardStyle", "Lcom/larksuite/component/card/protocol/context/CardStyle;", "renderTrace", "Lcom/ss/android/lark/opmonitor/trace/OPTrace;", "streamingState", "Lcom/larksuite/component/card/protocol/context/StreamingState;", "<init>", "(Ljava/lang/String;Landroid/content/Context;Landroidx/fragment/app/Fragment;Lcom/larksuite/component/card/protocol/context/BizContext;Lcom/larksuite/component/card/protocol/context/ActionContext;Ljava/lang/String;Lcom/larksuite/component/card/monitor/UniversalCardMonitorData;Ljava/lang/String;Lcom/larksuite/component/card/protocol/data/action/CardActionDependencyData;Lcom/larksuite/component/card/protocol/context/ICardDependency;Lcom/larksuite/component/card/protocol/context/CardStyle;Lcom/ss/android/lark/opmonitor/trace/OPTrace;Lcom/larksuite/component/card/protocol/context/StreamingState;)V", "getKey", "()Ljava/lang/String;", "getContext", "()Landroid/content/Context;", "getFragment", "()Landroidx/fragment/app/Fragment;", "getBizContext", "()Lcom/larksuite/component/card/protocol/context/BizContext;", "getActionContext", "()Lcom/larksuite/component/card/protocol/context/ActionContext;", "getHost", "getMonitorData", "()Lcom/larksuite/component/card/monitor/UniversalCardMonitorData;", "getDeliveryType", "getCardActionDependencyData", "()Lcom/larksuite/component/card/protocol/data/action/CardActionDependencyData;", "getDependency", "()Lcom/larksuite/component/card/protocol/context/ICardDependency;", "getCardStyle", "()Lcom/larksuite/component/card/protocol/context/CardStyle;", "getRenderTrace", "()Lcom/ss/android/lark/opmonitor/trace/OPTrace;", "setRenderTrace", "(Lcom/ss/android/lark/opmonitor/trace/OPTrace;)V", "getStreamingState", "()Lcom/larksuite/component/card/protocol/context/StreamingState;", "setStreamingState", "(Lcom/larksuite/component/card/protocol/context/StreamingState;)V", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardContext implements Serializable {
    public static final a Companion = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient Context f283861a;
    private final ActionContext actionContext;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final transient Fragment f283862b;
    private final BizContext bizContext;
    private final CardActionDependencyData cardActionDependencyData;
    private final CardStyle cardStyle;
    private final String deliveryType;
    private final ICardDependency dependency;
    private final String host;
    private final String key;
    private final UniversalCardMonitorData monitorData;
    private OPTrace renderTrace;
    private StreamingState streamingState;

    public static final class a {

        /* JADX INFO: renamed from: com.larksuite.component.card.protocol.CardContext$a$a, reason: collision with other inner class name */
        public static final class C3903a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f283863a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public OPTrace f283864b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public Context f283865c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public Fragment f283866d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public UniversalCardMonitorData f283867e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public BizContext f283868f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public ActionContext f283869g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public String f283870h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public String f283871i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public CardActionDependencyData f283872j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public ICardDependency f283873k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public CardStyle f283874l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public StreamingState f283875m;

            public final CardContext a() {
                String r100 = this.f283863a;
                Context r101 = this.f283865c;
                if (r101 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException(PerfLog.PARAM_KEY_CONTEXT_ID);
                Context r102 = null;
            L6:
                Fragment r103 = this.f283866d;
                BizContext r104 = this.f283868f;
                if (r104 != null) goto L9;
                Intrinsics.throwUninitializedPropertyAccessException("bizContext");
                BizContext r105 = null;
            L10:
                ActionContext r106 = this.f283869g;
                String r107 = this.f283870h;
                UniversalCardMonitorData r108 = this.f283867e;
                if (r108 != null) goto L13;
                Intrinsics.throwUninitializedPropertyAccessException("monitorData");
                UniversalCardMonitorData r109 = null;
            L14:
                String r110 = this.f283871i;
                CardActionDependencyData r111 = this.f283872j;
                if (r111 != null) goto L17;
                Intrinsics.throwUninitializedPropertyAccessException("cardActionDependencyData");
                CardActionDependencyData r112 = null;
            L18:
                ICardDependency r113 = this.f283873k;
                if (r113 != null) goto L21;
                Intrinsics.throwUninitializedPropertyAccessException("dependency");
                ICardDependency r114 = null;
            L22:
                CardStyle r115 = this.f283874l;
                if (r115 != null) goto L25;
                Intrinsics.throwUninitializedPropertyAccessException("cardStyle");
                CardStyle r116 = null;
            L26:
                OPTrace r117 = this.f283864b;
                if (r117 != null) goto L29;
                Intrinsics.throwUninitializedPropertyAccessException("renderTrace");
                OPTrace r118 = null;
            L31:
                return new CardContext(r100, r102, r103, r105, r106, r107, r109, r110, r112, r114, r116, r118, this.f283875m, null);
            L29:
                r118 = r117;
                goto L31
            L25:
                r116 = r115;
                goto L26
            L21:
                r114 = r113;
                goto L22
            L17:
                r112 = r111;
                goto L18
            L13:
                r109 = r108;
                goto L14
            L9:
                r105 = r104;
                goto L10
            L5:
                r102 = r101;
                goto L6
            }

            public C3903a() {
                this.f283863a = "";
                this.f283870h = "";
                this.f283871i = "";
            }
        }

        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final ActionContext getActionContext() {
        return this.actionContext;
    }

    public final BizContext getBizContext() {
        return this.bizContext;
    }

    public final CardActionDependencyData getCardActionDependencyData() {
        return this.cardActionDependencyData;
    }

    public final CardStyle getCardStyle() {
        return this.cardStyle;
    }

    public final Context getContext() {
        return this.f283861a;
    }

    public final String getDeliveryType() {
        return this.deliveryType;
    }

    public final ICardDependency getDependency() {
        return this.dependency;
    }

    public final Fragment getFragment() {
        return this.f283862b;
    }

    public final String getHost() {
        return this.host;
    }

    public final String getKey() {
        return this.key;
    }

    public final UniversalCardMonitorData getMonitorData() {
        return this.monitorData;
    }

    public final OPTrace getRenderTrace() {
        return this.renderTrace;
    }

    public final StreamingState getStreamingState() {
        return this.streamingState;
    }

    public final void setRenderTrace(OPTrace r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.renderTrace = r100;
    }

    public final void setStreamingState(StreamingState r100) {
        this.streamingState = r100;
    }

    public CardContext(String r100, Context r101, Fragment r102, BizContext r103, ActionContext r104, String r105, UniversalCardMonitorData r106, String r107, CardActionDependencyData r108, ICardDependency r110, CardStyle r111, OPTrace r112, StreamingState r113, DefaultConstructorMarker r114) {
        this.key = r100;
        this.f283861a = r101;
        this.f283862b = r102;
        this.bizContext = r103;
        this.actionContext = r104;
        this.host = r105;
        this.monitorData = r106;
        this.deliveryType = r107;
        this.cardActionDependencyData = r108;
        this.dependency = r110;
        this.cardStyle = r111;
        this.renderTrace = r112;
        this.streamingState = r113;
    }
}
