package com.suite.lark.platform.component.widget_biz_billingtips;

import com.squareup.wire.ProtoAdapter;
import com.ss.android.lark.pb.role.GetAdminPermissionInfoResponse;
import com.ss.android.lark.sdk.SdkSender;

/* JADX INFO: loaded from: classes36.dex */
public final /* synthetic */ class d implements SdkSender.IParser {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ProtoAdapter f460795a;

    public /* synthetic */ d(ProtoAdapter r100) {
        this.f460795a = r100;
    }

    @Override // com.ss.android.lark.sdk.SdkSender.IParser
    public final Object parse(byte[] r100) {
        return (GetAdminPermissionInfoResponse) this.f460795a.decode(r100);
    }
}
