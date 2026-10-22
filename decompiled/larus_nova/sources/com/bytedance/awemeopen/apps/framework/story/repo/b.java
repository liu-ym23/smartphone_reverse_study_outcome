package com.bytedance.awemeopen.apps.framework.story.repo;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final /* synthetic */ int f197640g = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Activity f197641a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f197642b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Long f197643c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<r14.c> f197644d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f197645e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f197646f;

    public static final class a {
    }

    static {
    }

    public final Activity getActivity() {
        return this.f197641a;
    }

    public b(Activity r100, String r101, Long r102) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "openId");
        this.f197641a = r100;
        this.f197642b = r101;
        this.f197643c = r102;
        this.f197644d = new ArrayList();
        this.f197646f = true;
    }
}
