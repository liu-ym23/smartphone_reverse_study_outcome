package wj0;

import com.bytedance.android.live.base.model.message.m0;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.liveinteract.videotalk.emoji.model.TalkRoomBaseDynamicEmoji;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes46.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final IBaseUser f559921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TalkRoomBaseDynamicEmoji f559922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final k f559923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m0 f559924d;

    public b(IBaseUser r100, TalkRoomBaseDynamicEmoji r101, k r102, m0 r103) {
        Intrinsics.checkNotNullParameter(r100, "fromUser");
        Intrinsics.checkNotNullParameter(r101, "dynamicEmoji");
        this.f559921a = r100;
        this.f559922b = r101;
        this.f559923c = r102;
        this.f559924d = r103;
    }
}
