package kh2;

import com.bytedance.android.livesdkapi.room.state.RoomState;

/* JADX INFO: loaded from: classes10.dex */
public final class j implements e<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f503455a;

    @Override // kh2.e
    public final Integer getValue() {
        return Integer.valueOf(this.f503455a);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v3, types: [int] */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v5 */
    public j(com.bytedance.android.ec.adapter.api.state.a r100) {
        if (r100 != null) goto L5;
        ?? r101 = 0;
    L6:
        this.f503455a = r101;
        return;
    L5:
        r101 = r100.f42699n.getBoolean(RoomState.EXTRA_BOOL_ROOM_HAS_CART_INFO);
        goto L6
    }
}
