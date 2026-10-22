package vf1;

import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList<String> f554575a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<String> f554576b;

    public c(ArrayList<String> r100, ArrayList<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "nearUpRoomIdList");
        Intrinsics.checkNotNullParameter(r101, "nearDownRoomIdList");
        this.f554575a = r100;
        this.f554576b = r101;
    }
}
