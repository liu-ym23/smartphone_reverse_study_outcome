package com.ss.android.lark.contact.customized.externalcontact.repository;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.bytedance.lark.pb.contact.v2.GetContactsDoubaoRequest;
import com.bytedance.lark.pb.contact.v2.GetContactsDoubaoResponse;
import com.bytedance.lark.pb.contact.v2.GetContactsScene;
import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.sdk.SdkSender;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class OfficeExternalContactRepository {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f419134a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Lazy f419135b = null;

    static {
        f419134a = LazyKt.lazy(OfficeExternalContactRepository$pushNewContactBadgeListeners$2.INSTANCE);
        f419135b = LazyKt.lazy(OfficeExternalContactRepository$pushContactListeners$2.INSTANCE);
    }

    public static SdkSender.d a(boolean r100, GetContactsScene r101) {
        Intrinsics.checkNotNullParameter(r101, "scene");
        GetContactsDoubaoRequest.Builder r102 = new GetContactsDoubaoRequest.Builder();
        if (r100 == false) goto L5;
        r102.strategy(SyncDataStrategy.LOCAL);
    L6:
        r102.scene(r101);
        Command r103 = Command.GET_CONTACTS_DOUBAO;
        final ProtoAdapter<GetContactsDoubaoResponse> r104 = GetContactsDoubaoResponse.ADAPTER;
        return SdkSender.syncSendMayError(r103, r102, new a(r104));
    L5:
        r102.strategy(SyncDataStrategy.FORCE_SERVER);
        goto L6
    }
}
