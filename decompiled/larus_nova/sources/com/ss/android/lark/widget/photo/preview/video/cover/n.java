package com.ss.android.lark.widget.photo.preview.video.cover;

import androidx.fragment.app.FragmentActivity;
import com.ss.android.lark.player.entity.DataSource;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class n {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f447227c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FragmentActivity f447228a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final DataSource f447229b;

    public static final class a {
    }

    static {
    }

    public final FragmentActivity getActivity() {
        return this.f447228a;
    }

    public n(FragmentActivity r100, DataSource r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "dataSource");
        this.f447228a = r100;
        this.f447229b = r101;
    }
}
