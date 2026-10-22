package com.bytedance.dux.avatar;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/dux/avatar/DuxAvatarQueueShape;", "", "Queue", "Group", "dux_release"}, k = 1, mv = {1, 7, 1})
public final enum DuxAvatarQueueShape extends Enum<DuxAvatarQueueShape> {
    public static final DuxAvatarQueueShape Group = null;
    public static final DuxAvatarQueueShape Queue = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ DuxAvatarQueueShape[] f204824a = null;

    public static DuxAvatarQueueShape valueOf(String r100) {
        return (DuxAvatarQueueShape) a.a(DuxAvatarQueueShape.class, r100);
    }

    public static DuxAvatarQueueShape[] values() {
        return (DuxAvatarQueueShape[]) f204824a.clone();
    }

    static {
        DuxAvatarQueueShape r100 = new DuxAvatarQueueShape("Queue", 0);
        Queue = r100;
        DuxAvatarQueueShape r101 = new DuxAvatarQueueShape("Group", 1);
        Group = r101;
        f204824a = new DuxAvatarQueueShape[]{r100, r101};
    }

    public DuxAvatarQueueShape(String r100, int r101) {
        super(r100, r101);
    }
}
