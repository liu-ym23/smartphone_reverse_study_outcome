package com.obric.capabilitykit.entity.search.global;

import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.search.InAppSearchEntityParam;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/obric/capabilitykit/entity/search/global/GlobalSearchEntity;", "", "appEntity", "Lcom/obric/capabilitykit/entity/app/AppEntity;", "params", "", "Lcom/obric/capabilitykit/entity/search/InAppSearchEntityParam;", "(Lcom/obric/capabilitykit/entity/app/AppEntity;Ljava/util/List;)V", "getAppEntity", "()Lcom/obric/capabilitykit/entity/app/AppEntity;", "getParams", "()Ljava/util/List;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class GlobalSearchEntity {
    private final AppEntity appEntity;
    private final List<InAppSearchEntityParam> params;

    public GlobalSearchEntity(AppEntity r100, List<InAppSearchEntityParam> r101) {
        Intrinsics.checkNotNullParameter(r100, "appEntity");
        Intrinsics.checkNotNullParameter(r101, "params");
        this.appEntity = r100;
        this.params = r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GlobalSearchEntity copy$default(GlobalSearchEntity r100, AppEntity r101, List r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = r100.appEntity;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = r100.params;
    L9:
        return r100.copy(r101, r102);
    }

    public final AppEntity component1() {
        return this.appEntity;
    }

    public final List<InAppSearchEntityParam> component2() {
        return this.params;
    }

    public final GlobalSearchEntity copy(AppEntity r100, List<InAppSearchEntityParam> r101) {
        Intrinsics.checkNotNullParameter(r100, "appEntity");
        Intrinsics.checkNotNullParameter(r101, "params");
        return new GlobalSearchEntity(r100, r101);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof GlobalSearchEntity) == true) goto L8;
        return false;
    L8:
        GlobalSearchEntity r101 = (GlobalSearchEntity) r100;
        if (Intrinsics.areEqual(this.appEntity, r101.appEntity) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.params, r101.params) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final AppEntity getAppEntity() {
        return this.appEntity;
    }

    public final List<InAppSearchEntityParam> getParams() {
        return this.params;
    }

    public int hashCode() {
        return (this.appEntity.hashCode() * 31) + this.params.hashCode();
    }

    public String toString() {
        return "GlobalSearchEntity(appEntity=" + this.appEntity + ", params=" + this.params + ')';
    }
}
