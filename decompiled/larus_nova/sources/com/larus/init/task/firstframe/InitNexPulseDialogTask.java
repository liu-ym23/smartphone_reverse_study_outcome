package com.larus.init.task.firstframe;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.network.http.ServiceType;
import com.larus.suggest.api.INexPulseDialogService;
import com.larus.suggest.api.NexPulseDialogRequestScene;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lcom/larus/init/task/firstframe/InitNexPulseDialogTask;", "Lcom/larus/init/task/firstframe/IFirstFrameTask;", "<init>", "()V", "scene", "", "getScene", "()Ljava/lang/String;", "runInternal", "", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InitNexPulseDialogTask implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f351293a;

    public static final class a {
    }

    static {
    }

    @Override // bg9.i
    public final String v() {
        return "normal";
    }

    @Override // bg9.i
    public final void runInternal() {
        INexPulseDialogService r100 = (INexPulseDialogService) ServiceManager.get().getService(INexPulseDialogService.class);
        if (r100 != null) goto L5;
        return;
    L5:
        gd9.i r101 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r101);
        Activity r102 = r101.a().e();
        String r103 = null;
        if (r102 == null) goto L8;
        Intent r104 = r102.getIntent();
    L9:
        if (r104 == null) goto L11;
        String r105 = r104.getAction();
    L12:
        boolean r106 = false;
        if (Intrinsics.areEqual(r105, CommonConstant.ACTION.HWID_SCHEME_URL) == false) goto L26;
        Uri r107 = r104.getData();
        if (r107 == null) goto L18;
        r103 = UriProtector.getQueryParameter(r107, "pc_activity");
    L18:
        if (r103 != null) goto L20;
    L23:
        boolean r108 = true;
    L24:
        if (r108 == true) goto L26;
        r106 = true;
        goto L26
    L20:
        if (StringsKt.isBlank(r103) == true) goto L23;
        r108 = false;
    L26:
        if (r106 == false) goto L28;
        NexPulseDialogRequestScene r109 = NexPulseDialogRequestScene.PC_GUIDE_SCHEMA;
    L29:
        r100.a(r109);
        return;
    L28:
        r109 = NexPulseDialogRequestScene.DEFAULT;
        goto L29
    L11:
        r105 = null;
        goto L12
    L8:
        r104 = null;
        goto L9
    }

    public InitNexPulseDialogTask() {
        this.f351293a = ServiceType.BASIC_SERVICE;
    }

    @Override // bg9.i
    public final String getScene() {
        return this.f351293a;
    }

    @Override // bg9.i, java.lang.Runnable
    public final void run() {
        bg9.i.a.a(this);
    }
}
