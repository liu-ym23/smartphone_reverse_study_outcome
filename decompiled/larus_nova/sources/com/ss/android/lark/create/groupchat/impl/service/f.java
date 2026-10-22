package com.ss.android.lark.create.groupchat.impl.service;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.larksuite.framework.callback.IGetDataCallback;
import com.ss.android.lark.chat.entity.chat.Chat;
import com.ss.android.lark.create.groupchat.dto.CreateGroupScene;
import com.ss.android.lark.create.groupchat.dto.GroupCreateInfo;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.search.dto.info.SearchBaseInfo;
import com.ss.android.lark.utils.statistics.PerfLog;
import e0c.k;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f extends c0c.b implements h {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ h f420212b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f420213c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<h> f420214d;

    public static final class a {
    }

    static {
    }

    @Override // com.ss.android.lark.create.groupchat.impl.service.h
    public final void Da(Context r110, GroupCreateInfo r111, List<? extends SearchBaseInfo> r112, IGetDataCallback<Chat> r113, CreateGroupScene r114, IGetDataCallback<w5b.a> r115, Fragment r116, hab.b r117) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "groupCreateInfo");
        Intrinsics.checkNotNullParameter(r112, "searchInfos");
        Intrinsics.checkNotNullParameter(r114, "source");
        Intrinsics.checkNotNullParameter(r117, "chatDependency");
        this.f420212b.Da(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    public f(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<h> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), h.class), h.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f420212b = r103.b();
        this.f420213c = r101;
        this.f420214d = r103;
    }

    @Override // c0c.b
    public final void qf(f0c.g r100, f0c.g r101) {
        Log.i("CreateChatGroupServiceProxy", "preparing ICreateGroupServiceApi");
        v r102 = this.f420213c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        h r104 = (h) k.b(r102.c(r103), h.class);
        this.f420214d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
