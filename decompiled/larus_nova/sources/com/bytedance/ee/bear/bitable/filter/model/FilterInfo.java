package com.bytedance.ee.bear.bitable.filter.model;

import android.text.TextUtils;
import com.bytedance.ee.util.io.NonProguard;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0096\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0011\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0007\"\u0004\b\u0014\u0010\tR\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0007\"\u0004\b\u0017\u0010\tR\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\t¨\u0006\u001e"}, d2 = {"Lcom/bytedance/ee/bear/bitable/filter/model/FilterInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "<init>", "()V", "conjunction", "", "getConjunction", "()Ljava/lang/String;", "setConjunction", "(Ljava/lang/String;)V", "conditions", "", "Lcom/bytedance/ee/bear/bitable/filter/model/FilterCondition;", "getConditions", "()[Lcom/bytedance/ee/bear/bitable/filter/model/FilterCondition;", "setConditions", "([Lcom/bytedance/ee/bear/bitable/filter/model/FilterCondition;)V", "[Lcom/bytedance/ee/bear/bitable/filter/model/FilterCondition;", "notice", "getNotice", "setNotice", "schemaVersion", "getSchemaVersion", "setSchemaVersion", "isRowLimit", "setRowLimit", "equals", "", "other", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FilterInfo implements NonProguard {
    private FilterCondition[] conditions;
    private String conjunction;
    private String isRowLimit;
    private String notice;
    private String schemaVersion;

    public FilterInfo() {
    }

    public final FilterCondition[] getConditions() {
        return this.conditions;
    }

    public final String getConjunction() {
        return this.conjunction;
    }

    public final String getNotice() {
        return this.notice;
    }

    public final String getSchemaVersion() {
        return this.schemaVersion;
    }

    public final String isRowLimit() {
        return this.isRowLimit;
    }

    public boolean equals(Object r100) {
        if (r100 == null) goto L5;
        Class<?> r101 = r100.getClass();
    L7:
        if (Intrinsics.areEqual(FilterInfo.class, r101) == true) goto L9;
        return false;
    L9:
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.bytedance.ee.bear.bitable.filter.model.FilterInfo");
        FilterInfo r102 = (FilterInfo) r100;
        if (TextUtils.equals(this.conjunction, r102.conjunction) == true) goto L13;
        return false;
    L13:
        if (Arrays.equals(this.conditions, r102.conditions) == true) goto L16;
        return false;
    L16:
        if (TextUtils.equals(this.notice, r102.notice) == true) goto L19;
        return false;
    L19:
        if (TextUtils.equals(this.schemaVersion, r102.schemaVersion) == true) goto L22;
        return false;
    L22:
        if (TextUtils.equals(this.isRowLimit, r102.isRowLimit) == true) goto L24;
        return false;
    L24:
        return true;
    L5:
        r101 = null;
        goto L7
    }

    public final void setConditions(FilterCondition[] r100) {
        this.conditions = r100;
    }

    public final void setConjunction(String r100) {
        this.conjunction = r100;
    }

    public final void setNotice(String r100) {
        this.notice = r100;
    }

    public final void setRowLimit(String r100) {
        this.isRowLimit = r100;
    }

    public final void setSchemaVersion(String r100) {
        this.schemaVersion = r100;
    }
}
