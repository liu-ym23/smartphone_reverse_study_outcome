package com.larus.platform.model.action;

import com.huawei.hms.support.feature.result.CommonConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import t1a.b;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0017\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\nHÆ\u0003J\t\u0010 \u001a\u00020\fHÆ\u0003Js\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\"\u001a\u00020\f2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u001f\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u001f\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lcom/larus/platform/model/action/DirectSendData;", "", CommonConstant.KEY_DISPLAY_NAME, "", "enterMethod", "msgExtMap", "", "sceneForText", "eventExtra", "vContext", "Lcom/larus/ui/arch/context/external/VContext;", "needPrepareNestedFileMsg", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/util/Map;Lcom/larus/ui/arch/context/external/VContext;Z)V", "getDisplayName", "()Ljava/lang/String;", "getEnterMethod", "getMsgExtMap", "()Ljava/util/Map;", "getSceneForText", "getEventExtra", "getVContext", "()Lcom/larus/ui/arch/context/external/VContext;", "getNeedPrepareNestedFileMsg", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DirectSendData {
    private final String displayName;
    private final String enterMethod;
    private final Map<String, String> eventExtra;
    private final Map<String, String> msgExtMap;
    private final boolean needPrepareNestedFileMsg;
    private final String sceneForText;
    private final b vContext;

    public DirectSendData() {
        this(null, null, null, null, null, null, false, 127, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ DirectSendData copy$default(DirectSendData r100, String r101, String r102, Map r103, String r104, Map r110, b r111, boolean r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.displayName;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.enterMethod;
    L8:
        String r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.msgExtMap;
    L11:
        Map r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.sceneForText;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.eventExtra;
    L17:
        Map r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.vContext;
    L20:
        b r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.needPrepareNestedFileMsg;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.displayName;
    }

    public final String component2() {
        return this.enterMethod;
    }

    public final Map<String, String> component3() {
        return this.msgExtMap;
    }

    public final String component4() {
        return this.sceneForText;
    }

    public final Map<String, String> component5() {
        return this.eventExtra;
    }

    public final b component6() {
        return this.vContext;
    }

    public final boolean component7() {
        return this.needPrepareNestedFileMsg;
    }

    public final DirectSendData copy(String r110, String r111, Map<String, String> r112, String r113, Map<String, String> r114, b r115, boolean r116) {
        return new DirectSendData(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DirectSendData) == true) goto L8;
        return false;
    L8:
        DirectSendData r101 = (DirectSendData) r100;
        if (Intrinsics.areEqual(this.displayName, r101.displayName) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.msgExtMap, r101.msgExtMap) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.sceneForText, r101.sceneForText) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.eventExtra, r101.eventExtra) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.vContext, r101.vContext) == true) goto L27;
        return false;
    L27:
        if (this.needPrepareNestedFileMsg == r101.needPrepareNestedFileMsg) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        String r100 = this.displayName;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.enterMethod;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, String> r107 = this.msgExtMap;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.sceneForText;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, String> r113 = this.eventExtra;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        b r116 = this.vContext;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        int r117 = (r115 + r101) * 31;
        if (this.needPrepareNestedFileMsg == false) goto L29;
        int r118 = 1231;
    L31:
        return r117 + r118;
    L29:
        r118 = 1237;
        goto L31
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
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
        return "DirectSendData(displayName=" + this.displayName + ", enterMethod=" + this.enterMethod + ", msgExtMap=" + this.msgExtMap + ", sceneForText=" + this.sceneForText + ", eventExtra=" + this.eventExtra + ", vContext=" + this.vContext + ", needPrepareNestedFileMsg=" + this.needPrepareNestedFileMsg + ')';
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final Map<String, String> getEventExtra() {
        return this.eventExtra;
    }

    public final Map<String, String> getMsgExtMap() {
        return this.msgExtMap;
    }

    public final boolean getNeedPrepareNestedFileMsg() {
        return this.needPrepareNestedFileMsg;
    }

    public final String getSceneForText() {
        return this.sceneForText;
    }

    public final b getVContext() {
        return this.vContext;
    }

    public DirectSendData(String r100, String r101, Map<String, String> r102, String r103, Map<String, String> r104, b r105, boolean r106) {
        this.displayName = r100;
        this.enterMethod = r101;
        this.msgExtMap = r102;
        this.sceneForText = r103;
        this.eventExtra = r104;
        this.vContext = r105;
        this.needPrepareNestedFileMsg = r106;
    }

    public /* synthetic */ DirectSendData(String r100, String r101, Map r102, String r103, Map r110, b r111, boolean r112, int r113, DefaultConstructorMarker r114) {
        b r104 = null;
        if ((r113 & 1) == 0) goto L5;
        String r115 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r105 = null;
    L11:
        if ((r113 & 4) == 0) goto L13;
        Map r106 = null;
    L15:
        if ((r113 & 8) == 0) goto L17;
        String r107 = null;
    L19:
        if ((r113 & 16) == 0) goto L21;
        Map r108 = null;
    L23:
        if ((r113 & 32) != 0) goto L27;
        r104 = r111;
    L27:
        if ((r113 & 64) == 0) goto L29;
        boolean r116 = true;
    L30:
        this(r115, r105, r106, r107, r108, r104, r116);
        return;
    L29:
        r116 = r112;
        goto L30
    L21:
        r108 = r110;
        goto L23
    L17:
        r107 = r103;
        goto L19
    L13:
        r106 = r102;
        goto L15
    L9:
        r105 = r101;
        goto L11
    L5:
        r115 = r100;
        goto L7
    }
}
