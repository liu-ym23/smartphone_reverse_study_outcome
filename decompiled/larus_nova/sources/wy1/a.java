package wy1;

import com.bytedance.android.livesdk.gift.grouplive.component.GroupComponentDataStore;
import com.bytedance.android.livesdk.gift.grouplive.component.k;
import com.bytedance.android.livesdk.gift.grouplive.component.repo.GroupComponentRepo;
import com.bytedance.android.scope.m;

/* JADX INFO: loaded from: classes9.dex */
public final class a {
    public a() {
    }

    public final boolean a(int r100) {
        m r101 = m.f163449e;
        r101.getClass();
        k r102 = (k) r101.a(m.f163448d, k.class);
        if (r102 == null) goto L17;
        GroupComponentRepo r103 = (GroupComponentRepo) r101.d(r102, GroupComponentRepo.class);
        if (r103 == null) goto L18;
        GroupComponentDataStore r104 = r103.f126328e;
        if (r104.A.f552073d == null) goto L9;
        boolean r105 = true;
    L10:
        if (r105 == false) goto L19;
        ty1.b r106 = r104.L();
        if (r106 != null) goto L14;
        return false;
    L14:
        if (r106.getType() != r100) goto L21;
        return true;
    L21:
        return false;
    L19:
        return false;
    L9:
        r105 = false;
        goto L10
    L18:
        return false;
    L17:
        return false;
    }
}
