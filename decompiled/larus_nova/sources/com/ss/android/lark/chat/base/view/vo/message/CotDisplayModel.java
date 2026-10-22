package com.ss.android.lark.chat.base.view.vo.message;

import com.ss.android.lark.chat.cot.CotViewModel;
import com.ss.android.lark.chat.entity.message.CotStatus;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0018\u001a\u00020\tHÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\r¨\u0006 "}, d2 = {"Lcom/ss/android/lark/chat/base/view/vo/message/CotDisplayModel;", "Ljava/io/Serializable;", "titleText", "", "isRunning", "", "overallStatus", "Lcom/ss/android/lark/chat/entity/message/CotStatus;", "detailViewModel", "Lcom/ss/android/lark/chat/cot/CotViewModel;", "<init>", "(Ljava/lang/String;ZLcom/ss/android/lark/chat/entity/message/CotStatus;Lcom/ss/android/lark/chat/cot/CotViewModel;)V", "getTitleText", "()Ljava/lang/String;", "()Z", "getOverallStatus", "()Lcom/ss/android/lark/chat/entity/message/CotStatus;", "getDetailViewModel", "()Lcom/ss/android/lark/chat/cot/CotViewModel;", "cotId", "getCotId", "component1", "component2", "component3", "component4", "copy", "equals", "other", "", "hashCode", "", "toString", "chat-export_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CotDisplayModel implements Serializable {
    private final CotViewModel detailViewModel;
    private final boolean isRunning;
    private final CotStatus overallStatus;
    private final String titleText;

    public static /* synthetic */ CotDisplayModel copy$default(CotDisplayModel r100, String r101, boolean r102, CotStatus r103, CotViewModel r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.titleText;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.isRunning;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.overallStatus;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.detailViewModel;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final String component1() {
        return this.titleText;
    }

    public final boolean component2() {
        return this.isRunning;
    }

    public final CotStatus component3() {
        return this.overallStatus;
    }

    public final CotViewModel component4() {
        return this.detailViewModel;
    }

    public final CotDisplayModel copy(String r100, boolean r101, CotStatus r102, CotViewModel r103) {
        Intrinsics.checkNotNullParameter(r100, "titleText");
        Intrinsics.checkNotNullParameter(r102, "overallStatus");
        Intrinsics.checkNotNullParameter(r103, "detailViewModel");
        return new CotDisplayModel(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CotDisplayModel) == true) goto L8;
        return false;
    L8:
        CotDisplayModel r101 = (CotDisplayModel) r100;
        if (Intrinsics.areEqual(this.titleText, r101.titleText) == true) goto L12;
        return false;
    L12:
        if (this.isRunning == r101.isRunning) goto L15;
        return false;
    L15:
        if (this.overallStatus == r101.overallStatus) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.detailViewModel, r101.detailViewModel) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        int r100 = this.titleText.hashCode() * 31;
        if (this.isRunning == false) goto L5;
        int r101 = 1231;
    L7:
        return ((((r100 + r101) * 31) + this.overallStatus.hashCode()) * 31) + this.detailViewModel.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    public String toString() {
        return "CotDisplayModel(titleText=" + this.titleText + ", isRunning=" + this.isRunning + ", overallStatus=" + this.overallStatus + ", detailViewModel=" + this.detailViewModel + ')';
    }

    public final String getCotId() {
        return this.detailViewModel.getCotId();
    }

    public final CotViewModel getDetailViewModel() {
        return this.detailViewModel;
    }

    public final CotStatus getOverallStatus() {
        return this.overallStatus;
    }

    public final String getTitleText() {
        return this.titleText;
    }

    public final boolean isRunning() {
        return this.isRunning;
    }

    public CotDisplayModel(String r100, boolean r101, CotStatus r102, CotViewModel r103) {
        Intrinsics.checkNotNullParameter(r100, "titleText");
        Intrinsics.checkNotNullParameter(r102, "overallStatus");
        Intrinsics.checkNotNullParameter(r103, "detailViewModel");
        this.titleText = r100;
        this.isRunning = r101;
        this.overallStatus = r102;
        this.detailViewModel = r103;
    }
}
