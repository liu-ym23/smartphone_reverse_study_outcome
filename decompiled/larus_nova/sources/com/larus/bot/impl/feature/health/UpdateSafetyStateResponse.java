package com.larus.bot.impl.feature.health;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/larus/bot/impl/feature/health/UpdateSafetyStateResponse;", "Ljava/io/Serializable;", "success", "", "<init>", "(Ljava/lang/Boolean;)V", "getSuccess", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/larus/bot/impl/feature/health/UpdateSafetyStateResponse;", "equals", "other", "", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UpdateSafetyStateResponse implements Serializable {

    @SerializedName("success")
    private final Boolean success;

    /* JADX WARN: Multi-variable type inference failed */
    public UpdateSafetyStateResponse() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ UpdateSafetyStateResponse copy$default(UpdateSafetyStateResponse r100, Boolean r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.success;
    L6:
        return r100.copy(r101);
    }

    public final Boolean component1() {
        return this.success;
    }

    public final UpdateSafetyStateResponse copy(Boolean r100) {
        return new UpdateSafetyStateResponse(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UpdateSafetyStateResponse) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.success, ((UpdateSafetyStateResponse) r100).success) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Boolean r100 = this.success;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "UpdateSafetyStateResponse(success=" + this.success + ')';
    }

    public final Boolean getSuccess() {
        return this.success;
    }

    public UpdateSafetyStateResponse(Boolean r100) {
        this.success = r100;
    }

    public /* synthetic */ UpdateSafetyStateResponse(Boolean r100, int r101, DefaultConstructorMarker r102) {
        if ((r101 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100);
    }
}
