package jd0;

import com.bytedance.android.live.liveinteract.plantform.model.IMessageBoardInfo;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f498193a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f498194b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f498195c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f498196d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f498197e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final IMessageBoardInfo f498198f;

    public c() {
        this(0);
    }

    public /* synthetic */ c(int r100) {
        this("", "", false, false, false, (IMessageBoardInfo) vh7.f.c(IMessageBoardInfo.class));
    }

    public c(String r100, String r101, boolean r102, boolean r103, boolean r104, IMessageBoardInfo r105) {
        Intrinsics.checkNotNullParameter(r100, "uid");
        Intrinsics.checkNotNullParameter(r101, "secUid");
        Intrinsics.checkNotNullParameter(r105, "messageBoardInfo");
        this.f498193a = r100;
        this.f498194b = r101;
        this.f498195c = r102;
        this.f498196d = r103;
        this.f498197e = r104;
        this.f498198f = r105;
    }
}
