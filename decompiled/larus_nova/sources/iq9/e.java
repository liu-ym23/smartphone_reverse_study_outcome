package iq9;

import com.google.gson.annotations.SerializedName;
import com.larus.platform.model.action.SuggestedActionScene;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003\u0012\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0013\u0010\f\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003HÆ\u0003J\u0013\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003HÆ\u0003J1\u0010\u000e\u001a\u00020\u00002\u0012\b\u0002\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00032\u0012\b\u0002\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R \u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR \u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/larus/platform/model/action/SuggestedActionOperations;", "", "scene", "", "Lcom/larus/platform/model/action/SuggestedActionScene;", "operations", "Lcom/larus/platform/model/action/SuggestedActionOperation;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getScene", "()Ljava/util/List;", "getOperations", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class e {

    @SerializedName("ops")
    private final List<com.larus.platform.model.action.a> operations;

    @SerializedName("scene")
    private final List<SuggestedActionScene> scene;

    public e() {
        this(null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.scene, r101.scene) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.operations, r101.operations) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        List<SuggestedActionScene> r100 = this.scene;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        List<com.larus.platform.model.action.a> r104 = this.operations;
        if (r104 == null) goto L11;
        r101 = r104.hashCode();
    L11:
        return r103 + r101;
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "SuggestedActionOperations(scene=" + this.scene + ", operations=" + this.operations + ')';
    }

    public final List<com.larus.platform.model.action.a> a() {
        return this.operations;
    }

    public final List<SuggestedActionScene> b() {
        return this.scene;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public e(List<? extends SuggestedActionScene> r100, List<? extends com.larus.platform.model.action.a> r101) {
        this.scene = r100;
        this.operations = r101;
    }
}
