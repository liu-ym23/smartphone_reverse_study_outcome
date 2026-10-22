package com.bytedance.ee.bear.middleground.comment.performance;

import com.bytedance.ee.bear.at.AtConstant$Zone;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f232068a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f232069b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f232070c;

    public final String getType() {
        return this.f232068a;
    }

    public e(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        Intrinsics.checkNotNullParameter(AtConstant$Zone.PART_COMMENT, "domain");
        this.f232068a = r100;
        this.f232069b = AtConstant$Zone.PART_COMMENT;
        this.f232070c = System.currentTimeMillis();
    }
}
