package com.bytedance.awemeopen.domain.report;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bR*\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\f"}, d2 = {"Lcom/bytedance/awemeopen/domain/report/f;", "Ln14/a;", "", "Lcom/bytedance/awemeopen/domain/report/d;", "reasons", "Ljava/util/List;", "e", "()Ljava/util/List;", "setReasons", "(Ljava/util/List;)V", "<init>", "()V", "ao_domain_release"}, k = 1, mv = {1, 7, 1})
public final class f extends n14.a {

    @SerializedName("reasons")
    private List<d> reasons;

    public f() {
    }

    public final List<d> e() {
        return this.reasons;
    }
}
