package hy3;

import android.view.View;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b f487630a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c f487631b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f487632c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, View> f487633d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a f487634e;

    public b(com.bytedance.awemeopen.apps.framework.feed.pages.recommend.model.b r100, c r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "mPageOwner");
        Intrinsics.checkNotNullParameter(r101, "dependency");
        Intrinsics.checkNotNullParameter(r102, "publishScene");
        this.f487630a = r100;
        this.f487631b = r101;
        this.f487632c = r102;
        this.f487633d = new LinkedHashMap();
        this.f487634e = new a();
    }
}
