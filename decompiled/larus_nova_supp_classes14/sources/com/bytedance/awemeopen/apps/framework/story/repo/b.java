package com.bytedance.awemeopen.apps.framework.story.repo;

import android.app.Activity;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final /* synthetic */ int g = 0;
    public final Activity a;
    public final String b;
    public final Long c;
    public final List<r14.c> d;
    public long e;
    public boolean f;

    public static final class a {
    }

    static {
    }

    public final Activity getActivity() {
        return this.a;
    }

    public b(Activity r2, String r3, Long r4) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "openId");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = new ArrayList();
        this.f = true;
    }
}
