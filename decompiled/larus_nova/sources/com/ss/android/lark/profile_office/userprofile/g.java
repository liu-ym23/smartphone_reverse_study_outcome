package com.ss.android.lark.profile_office.userprofile;

import android.content.Context;
import com.ss.android.lark.utils.UIHelper;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f438929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f438930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f438931c;

    public static final class a {
    }

    static {
    }

    public g(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f438929a = r100;
        this.f438930b = UIHelper.dp2px(640.0f);
        this.f438931c = UIHelper.dp2px(160.0f);
    }
}
