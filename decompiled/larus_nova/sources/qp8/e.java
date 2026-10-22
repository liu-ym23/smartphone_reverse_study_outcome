package qp8;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f534371a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f534372b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f534373c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<String> f534374d;

    public e(String r100, boolean r101, boolean r102, Function0<String> r103) {
        Intrinsics.checkNotNullParameter(r100, "appId");
        Intrinsics.checkNotNullParameter(r103, "conversationIdProvider");
        this.f534371a = r100;
        this.f534372b = r101;
        this.f534373c = r102;
        this.f534374d = r103;
    }
}
