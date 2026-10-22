package com.ss.android.lark.chat.cot;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u000e\u0010\u000fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\tHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003JU\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010#\u001a\u00020\u000b2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006)"}, d2 = {"Lcom/ss/android/lark/chat/cot/CotViewBlock;", "Ljava/io/Serializable;", "stableId", "", "type", "Lcom/ss/android/lark/chat/cot/CotViewBlockType;", "title", ContainerPosition.BODY, "status", "Lcom/ss/android/lark/chat/cot/CotBlockStatus;", "isStreaming", "", "cotBlockExtra", "Lcom/ss/android/lark/chat/cot/CotBlockExtra;", "<init>", "(Ljava/lang/String;Lcom/ss/android/lark/chat/cot/CotViewBlockType;Ljava/lang/String;Ljava/lang/String;Lcom/ss/android/lark/chat/cot/CotBlockStatus;ZLcom/ss/android/lark/chat/cot/CotBlockExtra;)V", "getStableId", "()Ljava/lang/String;", "getType", "()Lcom/ss/android/lark/chat/cot/CotViewBlockType;", "getTitle", "getBody", "getStatus", "()Lcom/ss/android/lark/chat/cot/CotBlockStatus;", "()Z", "getCotBlockExtra", "()Lcom/ss/android/lark/chat/cot/CotBlockExtra;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "", "hashCode", "", "toString", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CotViewBlock implements Serializable {
    private final String body;
    private final CotBlockExtra cotBlockExtra;
    private final boolean isStreaming;
    private final String stableId;
    private final CotBlockStatus status;
    private final String title;
    private final CotViewBlockType type;

    public static /* synthetic */ CotViewBlock copy$default(CotViewBlock r100, String r101, CotViewBlockType r102, String r103, String r104, CotBlockStatus r110, boolean r111, CotBlockExtra r112, int r113, Object r114) {
        if ((r113 & 1) == 0) goto L6;
        r101 = r100.stableId;
    L6:
        if ((r113 & 2) == 0) goto L8;
        r102 = r100.type;
    L8:
        CotViewBlockType r115 = r102;
        if ((r113 & 4) == 0) goto L11;
        r103 = r100.title;
    L11:
        String r105 = r103;
        if ((r113 & 8) == 0) goto L14;
        r104 = r100.body;
    L14:
        String r106 = r104;
        if ((r113 & 16) == 0) goto L17;
        r110 = r100.status;
    L17:
        CotBlockStatus r107 = r110;
        if ((r113 & 32) == 0) goto L20;
        r111 = r100.isStreaming;
    L20:
        boolean r108 = r111;
        if ((r113 & 64) == 0) goto L23;
        r112 = r100.cotBlockExtra;
    L23:
        String r109 = r101;
        return r100.copy(r109, r115, r105, r106, r107, r108, r112);
    }

    public final String component1() {
        return this.stableId;
    }

    public final CotViewBlockType component2() {
        return this.type;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.body;
    }

    public final CotBlockStatus component5() {
        return this.status;
    }

    public final boolean component6() {
        return this.isStreaming;
    }

    public final CotBlockExtra component7() {
        return this.cotBlockExtra;
    }

    public final CotViewBlock copy(String r110, CotViewBlockType r111, String r112, String r113, CotBlockStatus r114, boolean r115, CotBlockExtra r116) {
        Intrinsics.checkNotNullParameter(r110, "stableId");
        Intrinsics.checkNotNullParameter(r111, "type");
        Intrinsics.checkNotNullParameter(r114, "status");
        return new CotViewBlock(r110, r111, r112, r113, r114, r115, r116);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CotViewBlock) == true) goto L8;
        return false;
    L8:
        CotViewBlock r101 = (CotViewBlock) r100;
        if (Intrinsics.areEqual(this.stableId, r101.stableId) == true) goto L12;
        return false;
    L12:
        if (this.type == r101.type) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.body, r101.body) == true) goto L21;
        return false;
    L21:
        if (this.status == r101.status) goto L24;
        return false;
    L24:
        if (this.isStreaming == r101.isStreaming) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.cotBlockExtra, r101.cotBlockExtra) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public int hashCode() {
        int r100 = ((this.stableId.hashCode() * 31) + this.type.hashCode()) * 31;
        String r101 = this.title;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.body;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (((r104 + r106) * 31) + this.status.hashCode()) * 31;
        if (this.isStreaming == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        CotBlockExtra r110 = this.cotBlockExtra;
        if (r110 == null) goto L19;
        r102 = r110.hashCode();
    L19:
        return r109 + r102;
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public String toString() {
        return "CotViewBlock(stableId=" + this.stableId + ", type=" + this.type + ", title=" + this.title + ", body=" + this.body + ", status=" + this.status + ", isStreaming=" + this.isStreaming + ", cotBlockExtra=" + this.cotBlockExtra + ')';
    }

    public final String getBody() {
        return this.body;
    }

    public final CotBlockExtra getCotBlockExtra() {
        return this.cotBlockExtra;
    }

    public final String getStableId() {
        return this.stableId;
    }

    public final CotBlockStatus getStatus() {
        return this.status;
    }

    public final String getTitle() {
        return this.title;
    }

    public final CotViewBlockType getType() {
        return this.type;
    }

    public final boolean isStreaming() {
        return this.isStreaming;
    }

    public CotViewBlock(String r100, CotViewBlockType r101, String r102, String r103, CotBlockStatus r104, boolean r105, CotBlockExtra r106) {
        Intrinsics.checkNotNullParameter(r100, "stableId");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r104, "status");
        this.stableId = r100;
        this.type = r101;
        this.title = r102;
        this.body = r103;
        this.status = r104;
        this.isStreaming = r105;
        this.cotBlockExtra = r106;
    }

    public /* synthetic */ CotViewBlock(String r110, CotViewBlockType r111, String r112, String r113, CotBlockStatus r114, boolean r115, CotBlockExtra r116, int r117, DefaultConstructorMarker r118) {
        if ((r117 & 64) == 0) goto L5;
        CotBlockExtra r100 = NoExtra.INSTANCE;
    L6:
        this(r110, r111, r112, r113, r114, r115, r100);
        return;
    L5:
        r100 = r116;
        goto L6
    }
}
