package com.ss.android.lark.videosend.abtest;

import com.ss.android.lark.abtest.api.ABTestExperimentPlugin;
import java.util.List;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: classes38.dex */
@ABTestExperimentPlugin
public final class b implements hua.a {
    public b() {
    }

    @Override // hua.a
    public final List<iua.a<Boolean>> a() {
        return CollectionsKt.mutableListOf(new iua.a[]{new a()});
    }

    @Override // hua.a
    public final String getBizName() {
        return "LarkVideo";
    }
}
