package com.obric.miniapp.request;

import com.bytedance.ai.bridge.protocol.model.ProtocolMessage;
import com.bytedance.ai.bridge.protocol.model.TargetEntity;
import com.google.gson.JsonObject;
import d3.w;
import kotlinx.coroutines.CompletableDeferred;

/* JADX INFO: loaded from: classes33.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f398393a;

    public static final class a {
    }

    static {
    }

    public i() {
        this.f398393a = 2;
    }

    public static final void a(final i r100, final w r101, final CompletableDeferred r110) {
        r100.getClass();
        r101.c(new ProtocolMessage("applet.queryImportSetting", new JsonObject(), null, new TargetEntity(TargetEntity.Scope.Main, TargetEntity.Target.Self, 4), ProtocolMessage.Type.Call, 36), new QueryImportSettingsRequest$executeFunction$1(r110), new QueryImportSettingsRequest$executeFunction$2(r100, r101, r110), null);
    }
}
