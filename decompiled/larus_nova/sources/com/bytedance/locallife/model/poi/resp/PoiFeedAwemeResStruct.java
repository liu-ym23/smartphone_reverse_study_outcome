package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/PoiFeedAwemeResStruct;", "Ljava/io/Serializable;", "noVideoDesc", "", "(Ljava/lang/String;)V", "getNoVideoDesc", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class PoiFeedAwemeResStruct implements Serializable {

    @SerializedName("nothing_todo_desc")
    private final String noVideoDesc;

    public static /* synthetic */ PoiFeedAwemeResStruct copy$default(PoiFeedAwemeResStruct r100, String r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.noVideoDesc;
    L6:
        return r100.copy(r101);
    }

    public final String component1() {
        return this.noVideoDesc;
    }

    public final PoiFeedAwemeResStruct copy(String r100) {
        return new PoiFeedAwemeResStruct(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof PoiFeedAwemeResStruct) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.noVideoDesc, ((PoiFeedAwemeResStruct) r100).noVideoDesc) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        String r100 = this.noVideoDesc;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "PoiFeedAwemeResStruct(noVideoDesc=" + this.noVideoDesc + ')';
    }

    public final String getNoVideoDesc() {
        return this.noVideoDesc;
    }

    public PoiFeedAwemeResStruct(String r100) {
        this.noVideoDesc = r100;
    }
}
