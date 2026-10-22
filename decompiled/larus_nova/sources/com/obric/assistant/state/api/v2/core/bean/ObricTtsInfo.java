package com.obric.assistant.state.api.v2.core.bean;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.larus.im.bean.message.Message;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0015\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\nHÆ\u0003JO\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0014\b\u0002\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\nHÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/obric/assistant/state/api/v2/core/bean/ObricTtsInfo;", "", "cvsId", "", RemoteMessageConst.MSGID, "scene", "Lcom/obric/assistant/state/api/v2/core/bean/ObricInteractionScene;", "message", "Lcom/larus/im/bean/message/Message;", "ext", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/obric/assistant/state/api/v2/core/bean/ObricInteractionScene;Lcom/larus/im/bean/message/Message;Ljava/util/Map;)V", "getCvsId", "()Ljava/lang/String;", "getMsgId", "getScene", "()Lcom/obric/assistant/state/api/v2/core/bean/ObricInteractionScene;", "getMessage", "()Lcom/larus/im/bean/message/Message;", "getExt", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricTtsInfo {
    private final String cvsId;
    private final Map<String, Object> ext;
    private final Message message;
    private final String msgId;
    private final ObricInteractionScene scene;

    public ObricTtsInfo() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ObricTtsInfo copy$default(ObricTtsInfo r100, String r101, String r102, ObricInteractionScene r103, Message r104, Map r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.cvsId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.msgId;
    L8:
        String r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.scene;
    L11:
        ObricInteractionScene r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.message;
    L14:
        Message r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.ext;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.cvsId;
    }

    public final String component2() {
        return this.msgId;
    }

    public final ObricInteractionScene component3() {
        return this.scene;
    }

    public final Message component4() {
        return this.message;
    }

    public final Map<String, Object> component5() {
        return this.ext;
    }

    public final ObricTtsInfo copy(String r100, String r101, ObricInteractionScene r110, Message r111, Map<String, ? extends Object> r112) {
        Intrinsics.checkNotNullParameter(r112, "ext");
        return new ObricTtsInfo(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ObricTtsInfo) == true) goto L8;
        return false;
    L8:
        ObricTtsInfo r101 = (ObricTtsInfo) r100;
        if (Intrinsics.areEqual(this.cvsId, r101.cvsId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.msgId, r101.msgId) == true) goto L15;
        return false;
    L15:
        if (this.scene == r101.scene) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.message, r101.message) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.ext, r101.ext) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.cvsId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.msgId;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        ObricInteractionScene r107 = this.scene;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Message r110 = this.message;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return ((r109 + r101) * 31) + this.ext.hashCode();
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "ObricTtsInfo(cvsId=" + this.cvsId + ", msgId=" + this.msgId + ", scene=" + this.scene + ", message=" + this.message + ", ext=" + this.ext + ')';
    }

    public final String getCvsId() {
        return this.cvsId;
    }

    public final Map<String, Object> getExt() {
        return this.ext;
    }

    public final Message getMessage() {
        return this.message;
    }

    public final String getMsgId() {
        return this.msgId;
    }

    public final ObricInteractionScene getScene() {
        return this.scene;
    }

    public ObricTtsInfo(String r100, String r101, ObricInteractionScene r102, Message r103, Map<String, ? extends Object> r104) {
        Intrinsics.checkNotNullParameter(r104, "ext");
        this.cvsId = r100;
        this.msgId = r101;
        this.scene = r102;
        this.message = r103;
        this.ext = r104;
    }

    public /* synthetic */ ObricTtsInfo(String r100, String r101, ObricInteractionScene r102, Message r103, Map r104, int r105, DefaultConstructorMarker r110) {
        Message r106 = null;
        if ((r105 & 1) == 0) goto L5;
        String r111 = null;
    L7:
        if ((r105 & 2) == 0) goto L9;
        String r107 = null;
    L11:
        if ((r105 & 4) == 0) goto L13;
        r102 = ObricInteractionScene.DEFAULT;
    L13:
        ObricInteractionScene r108 = r102;
        if ((r105 & 8) != 0) goto L18;
        r106 = r103;
    L18:
        if ((r105 & 16) == 0) goto L20;
        r104 = MapsKt.emptyMap();
    L20:
        this(r111, r107, r108, r106, r104);
        return;
    L9:
        r107 = r101;
        goto L11
    L5:
        r111 = r100;
        goto L7
    }
}
