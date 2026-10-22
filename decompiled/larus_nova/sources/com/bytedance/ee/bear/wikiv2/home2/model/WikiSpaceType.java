package com.bytedance.ee.bear.wikiv2.home2.model;

import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpaceType;", "Lcom/bytedance/ee/util/io/NonProguard;", "spaceTypeId", "", "spaceTypeName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSpaceTypeId", "()Ljava/lang/String;", "getSpaceTypeName", "Companion", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSpaceType implements NonProguard {
    public static final a Companion = null;
    public static final String PERSONAL = "personal";
    public static final String TEAM = "team";
    private final String spaceTypeId;
    private final String spaceTypeName;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public final String getSpaceTypeId() {
        return this.spaceTypeId;
    }

    public final String getSpaceTypeName() {
        return this.spaceTypeName;
    }

    public WikiSpaceType(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "spaceTypeId");
        Intrinsics.checkNotNullParameter(r101, "spaceTypeName");
        this.spaceTypeId = r100;
        this.spaceTypeName = r101;
    }
}
