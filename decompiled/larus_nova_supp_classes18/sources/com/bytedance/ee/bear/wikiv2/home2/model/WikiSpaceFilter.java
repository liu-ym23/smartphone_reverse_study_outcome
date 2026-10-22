package com.bytedance.ee.bear.wikiv2.home2.model;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\r"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpaceFilter;", "Lcom/bytedance/ee/util/io/NonProguard;", "spaceTypeId", "", "spaceClassId", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSpaceTypeId", "()Ljava/lang/String;", "getSpaceClassId", "isEmptyFilter", "", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSpaceFilter implements NonProguard {
    public static final a Companion = null;
    public static final String filterDefaultIdValue = "all";
    private final String spaceClassId;
    private final String spaceTypeId;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final boolean isEmptyFilter() {
        if (Intrinsics.areEqual(this.spaceTypeId, "all") == true) goto L5;
    L7:
        return false;
    L5:
        if (Intrinsics.areEqual(this.spaceClassId, "all") == false) goto L7;
        return true;
    }

    public final String getSpaceClassId() {
        return this.spaceClassId;
    }

    public final String getSpaceTypeId() {
        return this.spaceTypeId;
    }

    public WikiSpaceFilter(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "spaceTypeId");
        Intrinsics.checkNotNullParameter(r3, "spaceClassId");
        this.spaceTypeId = r2;
        this.spaceClassId = r3;
    }
}
