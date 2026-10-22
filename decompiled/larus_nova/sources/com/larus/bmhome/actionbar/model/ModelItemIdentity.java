package com.larus.bmhome.actionbar.model;

import java.io.Serializable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000b\u001a\u0004\u0018\u00010\u0004J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u0006H\u0007J\b\u0010\u000f\u001a\u00020\u0004H\u0016J\u0013\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0006H\u0016J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0004HÂ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0006HÂ\u0003¢\u0006\u0002\u0010\u0016J&\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006HÆ\u0001¢\u0006\u0002\u0010\u0018R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;", "Ljava/io/Serializable;", "Lcom/flow/kmp/common/SerializableIO;", "modelItemKey", "", "itemId", "", "<init>", "(Ljava/lang/String;Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "TASK_MODEL_FROM_GATEWAY", "getKey", "isCustomModel", "", "getDeprecatedItemId", "toString", "equals", "other", "", "hashCode", "component1", "component2", "()Ljava/lang/Integer;", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lcom/larus/bmhome/actionbar/model/ModelItemIdentity;", "instruction_core_api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModelItemIdentity implements Serializable {
    private final int TASK_MODEL_FROM_GATEWAY;
    private final Integer itemId;
    private final String modelItemKey;

    public static /* synthetic */ ModelItemIdentity copy$default(ModelItemIdentity r100, String r101, Integer r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.modelItemKey;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.itemId;
    L9:
        return r100.copy(r101, r102);
    }

    public final ModelItemIdentity copy(String r100, Integer r101) {
        return new ModelItemIdentity(r100, r101);
    }

    @Deprecated(message = "use getKey() instead")
    public final int getDeprecatedItemId() {
        Integer r100 = this.itemId;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.intValue();
    }

    public final String getKey() {
        String r100 = this.modelItemKey;
        if (r100 != null) goto L5;
    L14:
        Integer r101 = this.itemId;
        if (r101 != null) goto L17;
        return null;
    L17:
        return r101.toString();
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r102 = true;
    L8:
        if (r102 == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L14;
        return r100;
    L7:
        r102 = false;
        goto L8
    }

    public final boolean isCustomModel() {
        Integer r100 = this.itemId;
        if (r100 == null) goto L5;
        int r101 = r100.intValue();
    L7:
        if (r101 < this.TASK_MODEL_FROM_GATEWAY) goto L10;
        return true;
    L10:
        return false;
    L5:
        r101 = 0;
        goto L7
    }

    public int hashCode() {
        String r100 = getKey();
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public String toString() {
        String r100 = getKey();
        if (r100 != null) goto L6;
        return "";
    L6:
        return r100;
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ModelItemIdentity) == true) goto L10;
        return false;
    L10:
        return Intrinsics.areEqual(getKey(), ((ModelItemIdentity) r100).getKey());
    }

    public ModelItemIdentity(String r100, Integer r101) {
        this.modelItemKey = r100;
        this.itemId = r101;
        this.TASK_MODEL_FROM_GATEWAY = 10001;
    }

    public /* synthetic */ ModelItemIdentity(String r100, Integer r101, int r102, DefaultConstructorMarker r103) {
        if ((r102 & 1) == 0) goto L5;
        r100 = null;
    L5:
        this(r100, r101);
    }
}
