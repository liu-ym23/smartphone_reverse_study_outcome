package com.ss.android.lark.chat.api.service.impl;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v1.GetUserPrivateDescriptionsRequest;
import com.bytedance.lark.pb.contact.v1.GetUserPrivateDescriptionsResponse;
import com.ss.android.lark.chat.api.service.PrivateDescriptionSource;
import com.ss.android.lark.chat.api.service.Strategy;
import com.ss.android.lark.passportc.dwarf.UserScope;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes35.dex */
@UserScope
public final class e1 implements a2b.g {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f411584b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.lark.rustclient.api.l f411585a;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f411586a = null;

        static {
            int[] r100 = new int[Strategy.values().length];
            r100[Strategy.LOCAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[Strategy.TRY_LOCAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[Strategy.FORCE_SERVER.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f411586a = r100;
        }
    }

    static {
    }

    @Inject
    public e1(com.bytedance.lark.rustclient.api.l r100) {
        Intrinsics.checkNotNullParameter(r100, "rustClient");
        this.f411585a = r100;
    }

    @Override // a2b.g
    public final Object a(List r110, PrivateDescriptionSource r111, Strategy r112) {
        ArrayList r100 = new ArrayList();
        Iterator r113 = r110.iterator();
    L4:
        if (r113.hasNext() == false) goto L8;
        Long r101 = StringsKt.toLongOrNull((String) r113.next());
        if (r101 == null) goto L4;
        r100.add(r101);
        goto L4
    L8:
        int r114 = b.f411586a[r112.ordinal()];
        if (r114 != 1) goto L11;
        SyncDataStrategy r115 = SyncDataStrategy.LOCAL;
    L19:
        GetUserPrivateDescriptionsRequest.Builder r102 = new GetUserPrivateDescriptionsRequest.Builder().user_ids(r100).source(GetUserPrivateDescriptionsRequest.Source.fromValue(r111.getRustValue())).sync_data_strategy(r115);
        Intrinsics.checkNotNull(r102);
        com.bytedance.lark.rustclient.api.d r116 = new com.bytedance.lark.rustclient.api.d(r102, GetUserPrivateDescriptionsResponse.ADAPTER, Command.GET_USER_PRIVATE_DESCRIPTIONS, null, null, null, null, 248);
        return ((com.bytedance.lark.rustclient.api.x) com.bytedance.lark.rustclient.api.t.b(this.f411585a.h(r116).a().map(new f1(this))).blockingFirst()).f253935c;
    L11:
        if (r114 != 2) goto L13;
        r115 = SyncDataStrategy.TRY_LOCAL;
        goto L19
    L13:
        if (r114 != 3) goto L16;
        r115 = SyncDataStrategy.FORCE_SERVER;
        goto L19
    L16:
        throw new NoWhenBranchMatchedException();
    }
}
