package com.larus.bmhome.actionbar.model;

import com.larus.dora.obric.device_management.device_home.DoraObricDeviceHomeViewModel;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\b\u0086\b\u0018\u0000 \u001d2\u00060\u0001j\u0002`\u0002:\u0001\u001dB#\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nJ\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0096\u0002J\b\u0010\u0016\u001a\u00020\bH\u0016J\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0010J0\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001bJ\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/larus/bmhome/actionbar/model/ReplyOption;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL, "Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;", "modeId", "", "reasoningEffort", "", "<init>", "(Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;Ljava/lang/String;Ljava/lang/Integer;)V", "getModel", "()Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;", "getModeId", "()Ljava/lang/String;", "getReasoningEffort", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "equals", "", "other", "", "hashCode", "component1", "component2", "component3", "copy", "(Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/bmhome/actionbar/model/ReplyOption;", "toString", "Companion", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReplyOption implements Serializable {
    public static final a Companion = null;
    private final String modeId;
    private final ModelItemIdentity model;
    private final Integer reasoningEffort;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ ReplyOption copy$default(ReplyOption r100, ModelItemIdentity r101, String r102, Integer r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.model;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.modeId;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.reasoningEffort;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final ModelItemIdentity component1() {
        return this.model;
    }

    public final String component2() {
        return this.modeId;
    }

    public final Integer component3() {
        return this.reasoningEffort;
    }

    public final ReplyOption copy(ModelItemIdentity r100, String r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        return new ReplyOption(r100, r101, r102);
    }

    public String toString() {
        return "ReplyOption(model=" + this.model + ", modeId=" + this.modeId + ", reasoningEffort=" + this.reasoningEffort + ')';
    }

    public int hashCode() {
        String r100 = this.model.getKey();
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.modeId;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Integer r107 = this.reasoningEffort;
        if (r107 == null) goto L14;
        r101 = r107.hashCode();
    L14:
        return r106 + r101;
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String getModeId() {
        return this.modeId;
    }

    public final ModelItemIdentity getModel() {
        return this.model;
    }

    public final Integer getReasoningEffort() {
        return this.reasoningEffort;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if ((r100 instanceof ReplyOption) == true) goto L11;
        return false;
    L11:
        ReplyOption r101 = (ReplyOption) r100;
        if (Intrinsics.areEqual(this.model.getKey(), r101.model.getKey()) == true) goto L14;
    L18:
        return false;
    L14:
        if (Intrinsics.areEqual(this.modeId, r101.modeId) == false) goto L18;
        if (Intrinsics.areEqual(this.reasoningEffort, r101.reasoningEffort) == false) goto L18;
        return true;
    }

    public ReplyOption(ModelItemIdentity r100, String r101, Integer r102) {
        Intrinsics.checkNotNullParameter(r100, DoraObricDeviceHomeViewModel.PARAM_PRODUCT_MODEL);
        this.model = r100;
        this.modeId = r101;
        this.reasoningEffort = r102;
    }
}
