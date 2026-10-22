package t92;

import aa2.w;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import ec2.o;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends s92.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Integer f545075h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f545076i;

    public a(IRoom r100, w r101, boolean r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "room");
        Intrinsics.checkNotNullParameter(r101, "widget");
        super(r100, r101, r102, r103);
        this.f545075h = o.f472042a.getValue();
        this.f545076i = -1;
    }
}
