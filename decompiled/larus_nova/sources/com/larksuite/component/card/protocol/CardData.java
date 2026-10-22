package com.larksuite.component.card.protocol;

import com.larksuite.component.card.protocol.data.CardContent;
import com.larksuite.component.card.protocol.data.CardTranslateInfo;
import com.larksuite.component.card.protocol.data.ComponentStatus;
import com.larksuite.component.card.protocol.data.StreamingConfig;
import com.larksuite.component.card.protocol.data.action.ActionInfo;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\u0018\u0000 52\u00020\u0001:\u00015B\u0093\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015\u0012\u0006\u0010\u0016\u001a\u00020\u0017\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010#R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010+R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0015¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0016\u001a\u00020\u0017¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0011\u0010\u0018\u001a\u00020\u0019¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u001e¨\u00066"}, d2 = {"Lcom/larksuite/component/card/protocol/CardData;", "Ljava/io/Serializable;", "cardID", "", "universalCardID", "version", "universalCardVersion", "cardContent", "Lcom/larksuite/component/card/protocol/data/CardContent;", "translateContent", "translateInfo", "Lcom/larksuite/component/card/protocol/data/CardTranslateInfo;", "componentStatus", "Lcom/larksuite/component/card/protocol/data/ComponentStatus;", "actionInfo", "Lcom/larksuite/component/card/protocol/data/action/ActionInfo;", "isStreamingMode", "", "streamingConfig", "Lcom/larksuite/component/card/protocol/data/StreamingConfig;", "cardDataSource", "Lcom/larksuite/component/card/protocol/CardDataSource;", "actionDataSource", "Lcom/larksuite/component/card/protocol/CardActionDataSource;", "parseDataTrace", "Lcom/ss/android/lark/opmonitor/trace/OPTrace;", "hostCardId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/larksuite/component/card/protocol/data/CardContent;Lcom/larksuite/component/card/protocol/data/CardContent;Lcom/larksuite/component/card/protocol/data/CardTranslateInfo;Lcom/larksuite/component/card/protocol/data/ComponentStatus;Lcom/larksuite/component/card/protocol/data/action/ActionInfo;ZLcom/larksuite/component/card/protocol/data/StreamingConfig;Lcom/larksuite/component/card/protocol/CardDataSource;Lcom/larksuite/component/card/protocol/CardActionDataSource;Lcom/ss/android/lark/opmonitor/trace/OPTrace;Ljava/lang/String;)V", "getCardID", "()Ljava/lang/String;", "getUniversalCardID", "getVersion", "getUniversalCardVersion", "getCardContent", "()Lcom/larksuite/component/card/protocol/data/CardContent;", "getTranslateContent", "getTranslateInfo", "()Lcom/larksuite/component/card/protocol/data/CardTranslateInfo;", "getComponentStatus", "()Lcom/larksuite/component/card/protocol/data/ComponentStatus;", "getActionInfo", "()Lcom/larksuite/component/card/protocol/data/action/ActionInfo;", "()Z", "getStreamingConfig", "()Lcom/larksuite/component/card/protocol/data/StreamingConfig;", "getCardDataSource", "()Lcom/larksuite/component/card/protocol/CardDataSource;", "getActionDataSource", "()Lcom/larksuite/component/card/protocol/CardActionDataSource;", "getParseDataTrace", "()Lcom/ss/android/lark/opmonitor/trace/OPTrace;", "getHostCardId", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CardData implements Serializable {
    public static final a Companion = null;
    public static final String TAG = "CardData";
    private final CardActionDataSource actionDataSource;
    private final ActionInfo actionInfo;
    private final CardContent cardContent;
    private final CardDataSource cardDataSource;
    private final String cardID;
    private final ComponentStatus componentStatus;
    private final String hostCardId;
    private final boolean isStreamingMode;
    private final OPTrace parseDataTrace;
    private final StreamingConfig streamingConfig;
    private final CardContent translateContent;
    private final CardTranslateInfo translateInfo;
    private final String universalCardID;
    private final String universalCardVersion;
    private final String version;

    public static final class a {

        /* JADX INFO: renamed from: com.larksuite.component.card.protocol.CardData$a$a, reason: collision with other inner class name */
        public static final class C3904a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public String f283876a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public String f283877b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            public String f283878c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            public String f283879d;

            /* JADX INFO: renamed from: e, reason: collision with root package name */
            public CardContent f283880e;

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            public CardContent f283881f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public ComponentStatus f283882g;

            /* JADX INFO: renamed from: h, reason: collision with root package name */
            public CardTranslateInfo f283883h;

            /* JADX INFO: renamed from: i, reason: collision with root package name */
            public ActionInfo f283884i;

            /* JADX INFO: renamed from: j, reason: collision with root package name */
            public boolean f283885j;

            /* JADX INFO: renamed from: k, reason: collision with root package name */
            public StreamingConfig f283886k;

            /* JADX INFO: renamed from: l, reason: collision with root package name */
            public CardDataSource f283887l;

            /* JADX INFO: renamed from: m, reason: collision with root package name */
            public CardActionDataSource f283888m;

            /* JADX INFO: renamed from: n, reason: collision with root package name */
            public final OPTrace f283889n;

            /* JADX INFO: renamed from: o, reason: collision with root package name */
            public String f283890o;

            public final CardData a() {
                if (this.f283880e == null) goto L10;
                String r100 = this.f283876a;
                if (r100 != null) goto L7;
                Intrinsics.throwUninitializedPropertyAccessException("cardID");
                r100 = null;
            L7:
                String r101 = this.f283877b;
                String r102 = this.f283878c;
                String r103 = this.f283879d;
                CardContent r104 = this.f283880e;
                Intrinsics.checkNotNull(r104);
                return new CardData(r100, r101, r102, r103, r104, this.f283881f, this.f283883h, this.f283882g, this.f283884i, this.f283885j, this.f283886k, this.f283887l, this.f283888m, this.f283889n, this.f283890o);
            L10:
                throw new Exception("card content is null");
            }

            public C3904a() {
                this.f283888m = CardActionDataSource.IM_CONTENT;
                this.f283889n = gyb.a.a().subTrace();
            }
        }

        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final CardActionDataSource getActionDataSource() {
        return this.actionDataSource;
    }

    public final ActionInfo getActionInfo() {
        return this.actionInfo;
    }

    public final CardContent getCardContent() {
        return this.cardContent;
    }

    public final CardDataSource getCardDataSource() {
        return this.cardDataSource;
    }

    public final String getCardID() {
        return this.cardID;
    }

    public final ComponentStatus getComponentStatus() {
        return this.componentStatus;
    }

    public final String getHostCardId() {
        return this.hostCardId;
    }

    public final OPTrace getParseDataTrace() {
        return this.parseDataTrace;
    }

    public final StreamingConfig getStreamingConfig() {
        return this.streamingConfig;
    }

    public final CardContent getTranslateContent() {
        return this.translateContent;
    }

    public final CardTranslateInfo getTranslateInfo() {
        return this.translateInfo;
    }

    public final String getUniversalCardID() {
        return this.universalCardID;
    }

    public final String getUniversalCardVersion() {
        return this.universalCardVersion;
    }

    public final String getVersion() {
        return this.version;
    }

    public final boolean isStreamingMode() {
        return this.isStreamingMode;
    }

    public CardData(String r100, String r101, String r102, String r110, CardContent r111, CardContent r112, CardTranslateInfo r113, ComponentStatus r114, ActionInfo r115, boolean r116, StreamingConfig r117, CardDataSource r118, CardActionDataSource r119, OPTrace r210, String r211) {
        Intrinsics.checkNotNullParameter(r100, "cardID");
        Intrinsics.checkNotNullParameter(r111, "cardContent");
        Intrinsics.checkNotNullParameter(r119, "actionDataSource");
        Intrinsics.checkNotNullParameter(r210, "parseDataTrace");
        this.cardID = r100;
        this.universalCardID = r101;
        this.version = r102;
        this.universalCardVersion = r110;
        this.cardContent = r111;
        this.translateContent = r112;
        this.translateInfo = r113;
        this.componentStatus = r114;
        this.actionInfo = r115;
        this.isStreamingMode = r116;
        this.streamingConfig = r117;
        this.cardDataSource = r118;
        this.actionDataSource = r119;
        this.parseDataTrace = r210;
        this.hostCardId = r211;
    }
}
