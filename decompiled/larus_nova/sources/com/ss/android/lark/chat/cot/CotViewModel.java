package com.ss.android.lark.chat.cot;

import com.ss.android.lark.chat.entity.message.CotStatus;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012$\b\u0002\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\u0019\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\tHÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003J%\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u000eHÆ\u0003Jg\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2$\b\u0002\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u000eHÆ\u0001J\u0013\u0010!\u001a\u00020\u000b2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R-\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\rj\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003`\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001a¨\u0006'"}, d2 = {"Lcom/ss/android/lark/chat/cot/CotViewModel;", "Ljava/io/Serializable;", "cotId", "", "blocks", "Ljava/util/ArrayList;", "Lcom/ss/android/lark/chat/cot/CotViewBlock;", "Lkotlin/collections/ArrayList;", "overallStatus", "Lcom/ss/android/lark/chat/entity/message/CotStatus;", "violated", "", "runStatusText", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "<init>", "(Ljava/lang/String;Ljava/util/ArrayList;Lcom/ss/android/lark/chat/entity/message/CotStatus;ZLjava/util/HashMap;)V", "getCotId", "()Ljava/lang/String;", "getBlocks", "()Ljava/util/ArrayList;", "getOverallStatus", "()Lcom/ss/android/lark/chat/entity/message/CotStatus;", "getViolated", "()Z", "getRunStatusText", "()Ljava/util/HashMap;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "", "hashCode", "", "toString", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CotViewModel implements Serializable {
    private final ArrayList<CotViewBlock> blocks;
    private final String cotId;
    private final CotStatus overallStatus;
    private final HashMap<String, String> runStatusText;
    private final boolean violated;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CotViewModel copy$default(CotViewModel r100, String r101, ArrayList r102, CotStatus r103, boolean r104, HashMap r105, int r106, Object r110) {
        if ((r106 & 1) == 0) goto L6;
        r101 = r100.cotId;
    L6:
        if ((r106 & 2) == 0) goto L8;
        r102 = r100.blocks;
    L8:
        ArrayList r111 = r102;
        if ((r106 & 4) == 0) goto L11;
        r103 = r100.overallStatus;
    L11:
        CotStatus r107 = r103;
        if ((r106 & 8) == 0) goto L14;
        r104 = r100.violated;
    L14:
        boolean r108 = r104;
        if ((r106 & 16) == 0) goto L17;
        r105 = r100.runStatusText;
    L17:
        String r109 = r101;
        return r100.copy(r109, r111, r107, r108, r105);
    }

    public final String component1() {
        return this.cotId;
    }

    public final ArrayList<CotViewBlock> component2() {
        return this.blocks;
    }

    public final CotStatus component3() {
        return this.overallStatus;
    }

    public final boolean component4() {
        return this.violated;
    }

    public final HashMap<String, String> component5() {
        return this.runStatusText;
    }

    public final CotViewModel copy(String r100, ArrayList<CotViewBlock> r101, CotStatus r110, boolean r111, HashMap<String, String> r112) {
        Intrinsics.checkNotNullParameter(r100, "cotId");
        Intrinsics.checkNotNullParameter(r101, "blocks");
        Intrinsics.checkNotNullParameter(r110, "overallStatus");
        Intrinsics.checkNotNullParameter(r112, "runStatusText");
        return new CotViewModel(r100, r101, r110, r111, r112);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CotViewModel) == true) goto L8;
        return false;
    L8:
        CotViewModel r101 = (CotViewModel) r100;
        if (Intrinsics.areEqual(this.cotId, r101.cotId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.blocks, r101.blocks) == true) goto L15;
        return false;
    L15:
        if (this.overallStatus == r101.overallStatus) goto L18;
        return false;
    L18:
        if (this.violated == r101.violated) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.runStatusText, r101.runStatusText) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = ((((this.cotId.hashCode() * 31) + this.blocks.hashCode()) * 31) + this.overallStatus.hashCode()) * 31;
        if (this.violated == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r100 + r101) * 31) + this.runStatusText.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "CotViewModel(cotId=" + this.cotId + ", blocks=" + this.blocks + ", overallStatus=" + this.overallStatus + ", violated=" + this.violated + ", runStatusText=" + this.runStatusText + ')';
    }

    public final ArrayList<CotViewBlock> getBlocks() {
        return this.blocks;
    }

    public final String getCotId() {
        return this.cotId;
    }

    public final CotStatus getOverallStatus() {
        return this.overallStatus;
    }

    public final HashMap<String, String> getRunStatusText() {
        return this.runStatusText;
    }

    public final boolean getViolated() {
        return this.violated;
    }

    public CotViewModel(String r100, ArrayList<CotViewBlock> r101, CotStatus r102, boolean r103, HashMap<String, String> r104) {
        Intrinsics.checkNotNullParameter(r100, "cotId");
        Intrinsics.checkNotNullParameter(r101, "blocks");
        Intrinsics.checkNotNullParameter(r102, "overallStatus");
        Intrinsics.checkNotNullParameter(r104, "runStatusText");
        this.cotId = r100;
        this.blocks = r101;
        this.overallStatus = r102;
        this.violated = r103;
        this.runStatusText = r104;
    }

    public /* synthetic */ CotViewModel(String r100, ArrayList r101, CotStatus r102, boolean r110, HashMap r111, int r112, DefaultConstructorMarker r113) {
        if ((r112 & 8) == 0) goto L5;
        boolean r103 = false;
    L7:
        if ((r112 & 16) == 0) goto L9;
        r111 = new HashMap();
    L9:
        this(r100, r101, r102, r103, r111);
        return;
    L5:
        r103 = r110;
        goto L7
    }
}
