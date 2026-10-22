package com.larus.dispatcher.api;

import com.android.ttcjpaysdk.base.ui.dialog.CJPayLynxStandardKeepActivity;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ\u0019\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007HÆ\u0003J@\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u0007HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\f\u0010\rR&\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0001\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lcom/larus/dispatcher/api/UploadAskHumanWarnResultRequest;", "", "callbackId", "", "scene", "", "params", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)V", "getCallbackId", "()Ljava/lang/String;", "getScene", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getParams", "()Ljava/util/Map;", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/util/Map;)Lcom/larus/dispatcher/api/UploadAskHumanWarnResultRequest;", "equals", "", "other", "hashCode", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class UploadAskHumanWarnResultRequest {

    @SerializedName(CJPayLynxStandardKeepActivity.INTENT_CALLBACK_ID)
    private final String callbackId;

    @SerializedName("params")
    private final Map<String, Object> params;

    @SerializedName("scene")
    private final Integer scene;

    public UploadAskHumanWarnResultRequest() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ UploadAskHumanWarnResultRequest copy$default(UploadAskHumanWarnResultRequest r100, String r101, Integer r102, Map r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.callbackId;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.scene;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.params;
    L12:
        return r100.copy(r101, r102, r103);
    }

    public final String component1() {
        return this.callbackId;
    }

    public final Integer component2() {
        return this.scene;
    }

    public final Map<String, Object> component3() {
        return this.params;
    }

    public final UploadAskHumanWarnResultRequest copy(String r100, Integer r101, Map<String, ? extends Object> r102) {
        return new UploadAskHumanWarnResultRequest(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UploadAskHumanWarnResultRequest) == true) goto L8;
        return false;
    L8:
        UploadAskHumanWarnResultRequest r101 = (UploadAskHumanWarnResultRequest) r100;
        if (Intrinsics.areEqual(this.callbackId, r101.callbackId) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.callbackId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.scene;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, Object> r107 = this.params;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "UploadAskHumanWarnResultRequest(callbackId=" + this.callbackId + ", scene=" + this.scene + ", params=" + this.params + ')';
    }

    public final String getCallbackId() {
        return this.callbackId;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    public final Integer getScene() {
        return this.scene;
    }

    public UploadAskHumanWarnResultRequest(String r100, Integer r101, Map<String, ? extends Object> r102) {
        this.callbackId = r100;
        this.scene = r101;
        this.params = r102;
    }

    public /* synthetic */ UploadAskHumanWarnResultRequest(String r100, Integer r101, Map r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
