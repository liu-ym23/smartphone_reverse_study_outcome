package com.bytedance.timon.result;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes22.dex */
public final class d {
    public static final void startActivityForResult(Fragment r100, Intent r101, String r102, a<Pair<Integer, Intent>> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "intent");
        Intrinsics.checkNotNullParameter(r103, "callback");
        int r104 = TimonResultFragment.f270678i;
        TimonResultFragment.a.a(r100.getChildFragmentManager(), false).T90(r101, r102, r103);
    }

    public static final void startActivityForResult(FragmentActivity r100, Intent r101, String r102, a<Pair<Integer, Intent>> r103) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "intent");
        Intrinsics.checkNotNullParameter(r103, "callback");
        int r104 = TimonResultFragment.f270678i;
        TimonResultFragment.a.a(r100.getSupportFragmentManager(), false).T90(r101, r102, r103);
    }
}
