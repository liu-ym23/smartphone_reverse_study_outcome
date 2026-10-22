package kh2;

import com.bytedance.android.livesdkapi.room.state.RoomState;

/* JADX INFO: loaded from: classes10.dex */
public final class i implements e<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f503454a;

    @Override // kh2.e
    public final Integer getValue() {
        return Integer.valueOf(this.f503454a);
    }

    public i(com.bytedance.android.ec.adapter.api.state.a r100) {
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        this.f503454a = r101;
        return;
    L5:
        r101 = r100.f42699n.getInt(RoomState.EXTRA_INT_SHOW_CART);
        goto L6
    }
}
