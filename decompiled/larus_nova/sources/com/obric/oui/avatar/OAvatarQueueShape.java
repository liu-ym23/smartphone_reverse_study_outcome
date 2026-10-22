package com.obric.oui.avatar;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/obric/oui/avatar/OAvatarQueueShape;", "", "Queue", "Group", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final enum OAvatarQueueShape extends Enum<OAvatarQueueShape> {
    public static final OAvatarQueueShape Group = null;
    public static final OAvatarQueueShape Queue = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ OAvatarQueueShape[] f398764a = null;

    public static OAvatarQueueShape valueOf(String r100) {
        return (OAvatarQueueShape) a.a(OAvatarQueueShape.class, r100);
    }

    public static OAvatarQueueShape[] values() {
        return (OAvatarQueueShape[]) f398764a.clone();
    }

    static {
        OAvatarQueueShape r100 = new OAvatarQueueShape("Queue", 0);
        Queue = r100;
        OAvatarQueueShape r101 = new OAvatarQueueShape("Group", 1);
        Group = r101;
        f398764a = new OAvatarQueueShape[]{r100, r101};
    }

    public OAvatarQueueShape(String r100, int r101) {
        super(r100, r101);
    }
}
