package com.bytedance.ee.bear.wikiv2.home2.model;

import com.bytedance.ee.util.io.NonProguard;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\n¨\u0006\f"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpaceFilterOption;", "Lcom/bytedance/ee/util/io/NonProguard;", "spaceTypes", "", "Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpaceType;", "spaceClassifications", "Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpaceClassification;", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "getSpaceTypes", "()Ljava/util/List;", "getSpaceClassifications", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSpaceFilterOption implements NonProguard {
    private final List<WikiSpaceClassification> spaceClassifications;
    private final List<WikiSpaceType> spaceTypes;

    public final List<WikiSpaceClassification> getSpaceClassifications() {
        return this.spaceClassifications;
    }

    public final List<WikiSpaceType> getSpaceTypes() {
        return this.spaceTypes;
    }

    public WikiSpaceFilterOption(List<WikiSpaceType> r100, List<WikiSpaceClassification> r101) {
        Intrinsics.checkNotNullParameter(r100, "spaceTypes");
        Intrinsics.checkNotNullParameter(r101, "spaceClassifications");
        this.spaceTypes = r100;
        this.spaceClassifications = r101;
    }
}
