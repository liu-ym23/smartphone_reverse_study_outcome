package yj0;

import com.bytedance.android.live.liveinteract.chatroom.chatroom.list.BaseTalkApplyListContract$View;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes46.dex */
public final class f extends com.bytedance.android.live.liveinteract.chatroom.chatroom.list.b {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final IRoom f568055i;

    public f(IRoom r100, BaseTalkApplyListContract$View r101) {
        Intrinsics.checkNotNullParameter(r101, "view");
        super(r100, r101);
        this.f568055i = r100;
    }
}
