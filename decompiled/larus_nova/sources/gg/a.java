package gg;

import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class a implements of.a {
    public a() {
    }

    @Override // of.a
    public final void a(String r100, PostActionType r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "action");
        Intrinsics.checkNotNullParameter(r101, "type");
        Intrinsics.checkNotNullParameter(r102, "pageId");
    }
}
