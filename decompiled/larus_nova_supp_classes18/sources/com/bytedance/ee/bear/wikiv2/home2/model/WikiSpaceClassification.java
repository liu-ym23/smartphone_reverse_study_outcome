package com.bytedance.ee.bear.wikiv2.home2.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.bytedance.ee.util.io.NonProguard;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/ee/bear/wikiv2/home2/model/WikiSpaceClassification;", "Lcom/bytedance/ee/util/io/NonProguard;", "spaceClassId", "", "spaceClassName", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getSpaceClassId", "()Ljava/lang/String;", "getSpaceClassName", "contentmanager-wiki-impl-v2_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WikiSpaceClassification implements NonProguard {
    private final String spaceClassId;
    private final String spaceClassName;

    public final String getSpaceClassId() {
        return this.spaceClassId;
    }

    public final String getSpaceClassName() {
        return this.spaceClassName;
    }

    public WikiSpaceClassification(@JSONField(name = "space_class_id") String r2, @JSONField(name = "space_class_name") String r3) {
        Intrinsics.checkNotNullParameter(r2, "spaceClassId");
        Intrinsics.checkNotNullParameter(r3, "spaceClassName");
        this.spaceClassId = r2;
        this.spaceClassName = r3;
    }
}
