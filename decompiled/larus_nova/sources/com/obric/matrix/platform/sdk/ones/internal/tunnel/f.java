package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.database.ContentObserver;
import android.net.Uri;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public abstract class f extends ContentObserver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f397002a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f397003b;

    public static final class a {
    }

    static {
    }

    public f() {
        Intrinsics.checkNotNullParameter("/location/status", "myPath");
        super(null);
        this.f397002a = "/location/status";
        this.f397003b = LazyKt.lazy(new MatrixEventObserver$myUri$2(this));
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean r100, Uri r101) {
        super.onChange(r100, r101);
        String r102 = "onChange, ignore! uri: [" + r101 + "], registered: [false]";
        int r103 = gka.b.f481577a;
        Intrinsics.checkNotNullParameter("MatrixEventObserver", "tag");
        Intrinsics.checkNotNullParameter(r102, "msg");
        bka.a r104 = bka.a.f19387a;
    }
}
