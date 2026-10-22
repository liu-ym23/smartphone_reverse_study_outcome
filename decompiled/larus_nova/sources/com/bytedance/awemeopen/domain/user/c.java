package com.bytedance.awemeopen.domain.user;

import com.bytedance.awemeopen.bizmodels.user.j;
import java.util.HashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class c {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f198483d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final UserInfoDomain f198484a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile boolean f198485b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final HashSet<j> f198486c;

    public static final class a {
    }

    static {
    }

    public c(UserInfoDomain r100) {
        Intrinsics.checkNotNullParameter(r100, "userInfoDomain");
        this.f198484a = r100;
        this.f198486c = new HashSet();
    }
}
