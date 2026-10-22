package com.larus.bmhome.chat;

import com.larus.im.bean.message.NestedFileContent;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001c\u001a\u00020\bHÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\t\u0010\u001e\u001a\u00020\bHÆ\u0003J\t\u0010\u001f\u001a\u00020\bHÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0003HÆ\u0003Ja\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\"\u001a\u00020\b2\b\u0010#\u001a\u0004\u0018\u00010$HÖ\u0003J\t\u0010%\u001a\u00020&HÖ\u0001J\t\u0010'\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0014R\u0011\u0010\t\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\n\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010¨\u0006("}, d2 = {"Lcom/larus/bmhome/chat/CustomMultiAttachmentInfo;", "Ljava/io/Serializable;", "fromScene", "", "enterMethod", "nestedFileContent", "Lcom/larus/im/bean/message/NestedFileContent;", "isSkipUpload", "", "preHandleV2Check", "onlyRegisterCheck", "overrideSinceId", "localMsgId", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/larus/im/bean/message/NestedFileContent;ZZZZLjava/lang/String;)V", "getFromScene", "()Ljava/lang/String;", "getEnterMethod", "getNestedFileContent", "()Lcom/larus/im/bean/message/NestedFileContent;", "()Z", "getPreHandleV2Check", "getOnlyRegisterCheck", "getOverrideSinceId", "getLocalMsgId", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "", "hashCode", "", "toString", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CustomMultiAttachmentInfo implements Serializable {
    private final String enterMethod;
    private final String fromScene;
    private final boolean isSkipUpload;
    private final String localMsgId;
    private final NestedFileContent nestedFileContent;
    private final boolean onlyRegisterCheck;
    private final boolean overrideSinceId;
    private final boolean preHandleV2Check;

    public static /* synthetic */ CustomMultiAttachmentInfo copy$default(CustomMultiAttachmentInfo r100, String r110, String r111, NestedFileContent r112, boolean r113, boolean r114, boolean r115, boolean r116, String r117, int r118, Object r119) {
        if ((r118 & 1) == 0) goto L5;
        String r101 = r100.fromScene;
    L7:
        if ((r118 & 2) == 0) goto L9;
        String r102 = r100.enterMethod;
    L11:
        if ((r118 & 4) == 0) goto L13;
        NestedFileContent r103 = r100.nestedFileContent;
    L15:
        if ((r118 & 8) == 0) goto L17;
        boolean r104 = r100.isSkipUpload;
    L19:
        if ((r118 & 16) == 0) goto L21;
        boolean r105 = r100.preHandleV2Check;
    L23:
        if ((r118 & 32) == 0) goto L25;
        boolean r106 = r100.onlyRegisterCheck;
    L27:
        if ((r118 & 64) == 0) goto L29;
        boolean r107 = r100.overrideSinceId;
    L31:
        if ((r118 & 128) == 0) goto L33;
        String r108 = r100.localMsgId;
    L35:
        return r100.copy(r101, r102, r103, r104, r105, r106, r107, r108);
    L33:
        r108 = r117;
        goto L35
    L29:
        r107 = r116;
        goto L31
    L25:
        r106 = r115;
        goto L27
    L21:
        r105 = r114;
        goto L23
    L17:
        r104 = r113;
        goto L19
    L13:
        r103 = r112;
        goto L15
    L9:
        r102 = r111;
        goto L11
    L5:
        r101 = r110;
        goto L7
    }

    public final String component1() {
        return this.fromScene;
    }

    public final String component2() {
        return this.enterMethod;
    }

    public final NestedFileContent component3() {
        return this.nestedFileContent;
    }

    public final boolean component4() {
        return this.isSkipUpload;
    }

    public final boolean component5() {
        return this.preHandleV2Check;
    }

    public final boolean component6() {
        return this.onlyRegisterCheck;
    }

    public final boolean component7() {
        return this.overrideSinceId;
    }

    public final String component8() {
        return this.localMsgId;
    }

    public final CustomMultiAttachmentInfo copy(String r110, String r111, NestedFileContent r112, boolean r113, boolean r114, boolean r115, boolean r116, String r117) {
        return new CustomMultiAttachmentInfo(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CustomMultiAttachmentInfo) == true) goto L8;
        return false;
    L8:
        CustomMultiAttachmentInfo r101 = (CustomMultiAttachmentInfo) r100;
        if (Intrinsics.areEqual(this.fromScene, r101.fromScene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enterMethod, r101.enterMethod) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.nestedFileContent, r101.nestedFileContent) == true) goto L18;
        return false;
    L18:
        if (this.isSkipUpload == r101.isSkipUpload) goto L21;
        return false;
    L21:
        if (this.preHandleV2Check == r101.preHandleV2Check) goto L24;
        return false;
    L24:
        if (this.onlyRegisterCheck == r101.onlyRegisterCheck) goto L27;
        return false;
    L27:
        if (this.overrideSinceId == r101.overrideSinceId) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.localMsgId, r101.localMsgId) == true) goto L32;
        return false;
    L32:
        return true;
    }

    public int hashCode() {
        String r100 = this.fromScene;
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
        NestedFileContent r107 = this.nestedFileContent;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        int r110 = 1231;
        if (this.isSkipUpload == false) goto L17;
        int r111 = 1231;
    L18:
        int r112 = (r109 + r111) * 31;
        if (this.preHandleV2Check == false) goto L21;
        int r113 = 1231;
    L22:
        int r114 = (r112 + r113) * 31;
        if (this.onlyRegisterCheck == false) goto L25;
        int r115 = 1231;
    L26:
        int r116 = (r114 + r115) * 31;
        if (this.overrideSinceId == true) goto L30;
        r110 = 1237;
    L30:
        int r117 = (r116 + r110) * 31;
        String r118 = this.localMsgId;
        if (r118 == null) goto L35;
        r101 = r118.hashCode();
    L35:
        return r117 + r101;
    L25:
        r115 = 1237;
        goto L26
    L21:
        r113 = 1237;
        goto L22
    L17:
        r111 = 1237;
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
        return "CustomMultiAttachmentInfo(fromScene=" + this.fromScene + ", enterMethod=" + this.enterMethod + ", nestedFileContent=" + this.nestedFileContent + ", isSkipUpload=" + this.isSkipUpload + ", preHandleV2Check=" + this.preHandleV2Check + ", onlyRegisterCheck=" + this.onlyRegisterCheck + ", overrideSinceId=" + this.overrideSinceId + ", localMsgId=" + this.localMsgId + ')';
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public final String getFromScene() {
        return this.fromScene;
    }

    public final String getLocalMsgId() {
        return this.localMsgId;
    }

    public final NestedFileContent getNestedFileContent() {
        return this.nestedFileContent;
    }

    public final boolean getOnlyRegisterCheck() {
        return this.onlyRegisterCheck;
    }

    public final boolean getOverrideSinceId() {
        return this.overrideSinceId;
    }

    public final boolean getPreHandleV2Check() {
        return this.preHandleV2Check;
    }

    public final boolean isSkipUpload() {
        return this.isSkipUpload;
    }

    public CustomMultiAttachmentInfo(String r100, String r101, NestedFileContent r102, boolean r103, boolean r104, boolean r105, boolean r106, String r107) {
        this.fromScene = r100;
        this.enterMethod = r101;
        this.nestedFileContent = r102;
        this.isSkipUpload = r103;
        this.preHandleV2Check = r104;
        this.onlyRegisterCheck = r105;
        this.overrideSinceId = r106;
        this.localMsgId = r107;
    }

    public /* synthetic */ CustomMultiAttachmentInfo(String r110, String r111, NestedFileContent r112, boolean r113, boolean r114, boolean r115, boolean r116, String r210, int r211, DefaultConstructorMarker r212) {
        if ((r211 & 8) == 0) goto L5;
        boolean r100 = false;
    L7:
        if ((r211 & 16) == 0) goto L9;
        boolean r101 = false;
    L11:
        if ((r211 & 32) == 0) goto L13;
        boolean r102 = false;
    L15:
        if ((r211 & 64) == 0) goto L17;
        boolean r117 = false;
    L19:
        if ((r211 & 128) == 0) goto L21;
        String r118 = null;
    L22:
        this(r110, r111, r112, r100, r101, r102, r117, r118);
        return;
    L21:
        r118 = r210;
        goto L22
    L17:
        r117 = r116;
        goto L19
    L13:
        r102 = r115;
        goto L15
    L9:
        r101 = r114;
        goto L11
    L5:
        r100 = r113;
        goto L7
    }
}
