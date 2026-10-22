package t88;

import com.android.ttcjpaysdk.integrated.sign.counter.activity.SignCounterLaunchArgs;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001BI\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u0015\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0006HÆ\u0003JK\u0010\u001a\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\tHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0006HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010¨\u0006 "}, d2 = {"Lcom/larus/avlink/aiproactive/model/UserAonTaskDraft;", "", "draftSlotList", "", "Lcom/larus/avlink/aiproactive/model/AonTaskDescriptionSlot;", "rawText", "", "polishedText", SignCounterLaunchArgs.EXTRA_SCENE_TYPE, "", "taskAdjustmentNotice", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getDraftSlotList", "()Ljava/util/List;", "getRawText", "()Ljava/lang/String;", "getPolishedText", "getSceneType", "()I", "getTaskAdjustmentNotice", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class o {

    @SerializedName("draft_slot_list")
    private final List<b> draftSlotList;

    @SerializedName("polished_text")
    private final String polishedText;

    @SerializedName("raw_text")
    private final String rawText;

    @SerializedName("scene_type")
    private final int sceneType;

    @SerializedName("task_adjustment_notice")
    private final String taskAdjustmentNotice;

    /* JADX WARN: Multi-variable type inference failed */
    public o() {
        Object[] r100 = 0 == true ? 1 : 0;
        Object[] r101 = 0 == true ? 1 : 0;
        this(null, r100, r101, 31);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.draftSlotList, r101.draftSlotList) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.rawText, r101.rawText) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.polishedText, r101.polishedText) == true) goto L18;
        return false;
    L18:
        if (this.sceneType == r101.sceneType) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.taskAdjustmentNotice, r101.taskAdjustmentNotice) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        List<b> r100 = this.draftSlotList;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.rawText;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.polishedText;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (((r106 + r108) * 31) + this.sceneType) * 31;
        String r110 = this.taskAdjustmentNotice;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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

    public final String toString() {
        return "UserAonTaskDraft(draftSlotList=" + this.draftSlotList + ", rawText=" + this.rawText + ", polishedText=" + this.polishedText + ", sceneType=" + this.sceneType + ", taskAdjustmentNotice=" + this.taskAdjustmentNotice + ')';
    }

    public final List<b> b() {
        return this.draftSlotList;
    }

    public final String c() {
        return this.rawText;
    }

    public final int d() {
        return this.sceneType;
    }

    public final String e() {
        return this.taskAdjustmentNotice;
    }

    public static o a(o r100, List r101) {
        return new o(r101, r100.rawText, r100.polishedText, r100.sceneType, r100.taskAdjustmentNotice);
    }

    public /* synthetic */ o(List r100, String r110, String r111, int r112) {
        if ((r112 & 1) == 0) goto L5;
        List r101 = null;
    L7:
        if ((r112 & 2) == 0) goto L9;
        String r102 = null;
    L11:
        if ((r112 & 4) == 0) goto L13;
        String r103 = null;
    L14:
        this(r101, r102, r103, 0, null);
        return;
    L13:
        r103 = r111;
        goto L14
    L9:
        r102 = r110;
        goto L11
    L5:
        r101 = r100;
        goto L7
    }

    public o(List<b> r100, String r101, String r102, int r103, String r104) {
        this.draftSlotList = r100;
        this.rawText = r101;
        this.polishedText = r102;
        this.sceneType = r103;
        this.taskAdjustmentNotice = r104;
    }
}
