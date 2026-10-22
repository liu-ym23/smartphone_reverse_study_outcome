package zf0;

import com.bytedance.android.livesdk.chatroom.model.k1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class i extends a {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final k1 f571611d;

    public i(String r100, py.k r101, k1 r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "icon");
        Intrinsics.checkNotNullParameter(r102, "interactItem");
        super(r100, r101, r102.getType());
        this.f571611d = r102;
    }
}
