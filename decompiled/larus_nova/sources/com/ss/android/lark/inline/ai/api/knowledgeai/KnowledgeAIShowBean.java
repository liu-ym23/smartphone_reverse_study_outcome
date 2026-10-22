package com.ss.android.lark.inline.ai.api.knowledgeai;

import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes36.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b#\b\u0086\b\u0018\u00002\u00020\u0001B©\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b\u0012(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010#\u001a\u00020\u00032\b\u0010$\u001a\u0004\u0018\u00010\u0007H\u0096\u0002J\b\u0010%\u001a\u00020\u000fH\u0016J\t\u0010&\u001a\u00020\u0003HÆ\u0003J)\u0010'\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0003J)\u0010(\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bHÆ\u0003J\u000b\u0010)\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\u0010\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001dJ\u0010\u0010-\u001a\u0004\u0018\u00010\u000fHÆ\u0003¢\u0006\u0002\u0010 J\u000b\u0010.\u001a\u0004\u0018\u00010\u0006HÆ\u0003J²\u0001\u0010/\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032(\b\u0002\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2(\b\u0002\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\f\u001a\u00020\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u00100J\t\u00101\u001a\u00020\u0006HÖ\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R4\u0010\u0004\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R4\u0010\t\u001a\"\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\bX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0016\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u0014\u0010\f\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0014R\u0018\u0010\r\u001a\u0004\u0018\u00010\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\u001e\u001a\u0004\b\u001c\u0010\u001dR\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0019¨\u00062"}, d2 = {"Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIShowBean;", "Lcom/ss/android/lark/inline/ai/api/knowledgeai/IKnowledgeAIShow;", "show", "", "bizParams", "Ljava/util/HashMap;", "", "", "Lkotlin/collections/HashMap;", "trackerParams", "query", "quote", "sendRequest", "disableScopeItem", "scene", "", "topicId", "<init>", "(ZLjava/util/HashMap;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)V", "getShow", "()Z", "getBizParams", "()Ljava/util/HashMap;", "getTrackerParams", "getQuery", "()Ljava/lang/String;", "getQuote", "getSendRequest", "getDisableScopeItem", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTopicId", "equals", "other", "hashCode", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(ZLjava/util/HashMap;Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/String;)Lcom/ss/android/lark/inline/ai/api/knowledgeai/KnowledgeAIShowBean;", "toString", "inline-ai-api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KnowledgeAIShowBean implements IKnowledgeAIShow {
    private final HashMap<String, Object> bizParams;
    private final Boolean disableScopeItem;
    private final String query;
    private final String quote;
    private final Integer scene;
    private final boolean sendRequest;
    private final boolean show;
    private final String topicId;
    private final HashMap<String, Object> trackerParams;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KnowledgeAIShowBean copy$default(KnowledgeAIShowBean r110, boolean r111, HashMap r112, HashMap r113, String r114, String r115, boolean r116, Boolean r117, Integer r118, String r119, int r210, Object r211) {
        if ((r210 & 1) == 0) goto L5;
        boolean r100 = r110.show;
    L7:
        if ((r210 & 2) == 0) goto L9;
        HashMap r101 = r110.bizParams;
    L11:
        if ((r210 & 4) == 0) goto L13;
        HashMap r102 = r110.trackerParams;
    L15:
        if ((r210 & 8) == 0) goto L17;
        String r103 = r110.query;
    L19:
        if ((r210 & 16) == 0) goto L21;
        String r104 = r110.quote;
    L23:
        if ((r210 & 32) == 0) goto L25;
        boolean r105 = r110.sendRequest;
    L27:
        if ((r210 & 64) == 0) goto L29;
        Boolean r106 = r110.disableScopeItem;
    L31:
        if ((r210 & 128) == 0) goto L33;
        Integer r107 = r110.scene;
    L35:
        if ((r210 & 256) == 0) goto L37;
        String r108 = r110.topicId;
    L39:
        return r110.copy(r100, r101, r102, r103, r104, r105, r106, r107, r108);
    L37:
        r108 = r119;
        goto L39
    L33:
        r107 = r118;
        goto L35
    L29:
        r106 = r117;
        goto L31
    L25:
        r105 = r116;
        goto L27
    L21:
        r104 = r115;
        goto L23
    L17:
        r103 = r114;
        goto L19
    L13:
        r102 = r113;
        goto L15
    L9:
        r101 = r112;
        goto L11
    L5:
        r100 = r111;
        goto L7
    }

    public final boolean component1() {
        return this.show;
    }

    public final HashMap<String, Object> component2() {
        return this.bizParams;
    }

    public final HashMap<String, Object> component3() {
        return this.trackerParams;
    }

    public final String component4() {
        return this.query;
    }

    public final String component5() {
        return this.quote;
    }

    public final boolean component6() {
        return this.sendRequest;
    }

    public final Boolean component7() {
        return this.disableScopeItem;
    }

    public final Integer component8() {
        return this.scene;
    }

    public final String component9() {
        return this.topicId;
    }

    public final KnowledgeAIShowBean copy(boolean r110, HashMap<String, Object> r111, HashMap<String, Object> r112, String r113, String r114, boolean r115, Boolean r116, Integer r117, String r210) {
        return new KnowledgeAIShowBean(r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    public String toString() {
        return "KnowledgeAIShowBean(show=" + this.show + ", bizParams=" + this.bizParams + ", trackerParams=" + this.trackerParams + ", query=" + this.query + ", quote=" + this.quote + ", sendRequest=" + this.sendRequest + ", disableScopeItem=" + this.disableScopeItem + ", scene=" + this.scene + ", topicId=" + this.topicId + ')';
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public /* bridge */ /* synthetic */ Map getBizParams() {
        return getBizParams();
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public /* bridge */ /* synthetic */ Map getTrackerParams() {
        return getTrackerParams();
    }

    public int hashCode() {
        return super.hashCode();
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public Boolean getDisableScopeItem() {
        return this.disableScopeItem;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public String getQuery() {
        return this.query;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public String getQuote() {
        return this.quote;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public Integer getScene() {
        return this.scene;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public boolean getSendRequest() {
        return this.sendRequest;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public boolean getShow() {
        return this.show;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public String getTopicId() {
        return this.topicId;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public HashMap<String, Object> getBizParams() {
        return this.bizParams;
    }

    @Override // com.ss.android.lark.inline.ai.api.knowledgeai.IKnowledgeAIShow
    public HashMap<String, Object> getTrackerParams() {
        return this.trackerParams;
    }

    public boolean equals(Object r100) {
        return super.equals(r100);
    }

    public KnowledgeAIShowBean(boolean r100, HashMap<String, Object> r101, HashMap<String, Object> r102, String r103, String r104, boolean r105, Boolean r106, Integer r107, String r108) {
        this.show = r100;
        this.bizParams = r101;
        this.trackerParams = r102;
        this.query = r103;
        this.quote = r104;
        this.sendRequest = r105;
        this.disableScopeItem = r106;
        this.scene = r107;
        this.topicId = r108;
    }

    public /* synthetic */ KnowledgeAIShowBean(boolean r110, HashMap r111, HashMap r112, String r113, String r114, boolean r115, Boolean r210, Integer r211, String r212, int r213, DefaultConstructorMarker r214) {
        if ((r213 & 1) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r213 & 2) == 0) goto L9;
        HashMap r101 = null;
    L11:
        if ((r213 & 4) == 0) goto L13;
        HashMap r102 = null;
    L15:
        if ((r213 & 8) == 0) goto L17;
        String r103 = null;
    L19:
        if ((r213 & 16) == 0) goto L21;
        String r104 = null;
    L23:
        if ((r213 & 32) == 0) goto L25;
        boolean r105 = false;
    L27:
        if ((r213 & 64) == 0) goto L29;
        Boolean r116 = null;
    L31:
        if ((r213 & 256) == 0) goto L33;
        String r117 = null;
    L34:
        this(r100, r101, r102, r103, r104, r105, r116, r211, r117);
        return;
    L33:
        r117 = r212;
        goto L34
    L29:
        r116 = r210;
        goto L31
    L25:
        r105 = r115;
        goto L27
    L21:
        r104 = r114;
        goto L23
    L17:
        r103 = r113;
        goto L19
    L13:
        r102 = r112;
        goto L15
    L9:
        r101 = r111;
        goto L11
    L5:
        r100 = r110;
        goto L7
    }
}
