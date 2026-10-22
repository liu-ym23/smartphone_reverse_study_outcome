package com.ss.android.lark.chat.api.service.impl.usergroup;

import a2b.o;
import android.content.Context;
import com.bytedance.lark.pb.im.v1.UserGroupEntity;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.s;
import com.ss.android.lark.chat.entity.message.Message;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.api.ContainerConstsKt;
import com.ss.android.lark.passportc.api.j;
import com.ss.android.lark.passportc.entity.UserSession;
import com.ss.android.lark.passportc.internal.v;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.richtext.RichText;
import com.ss.android.lark.widget.span.AtUserGroupInfo;
import e0c.k;
import f0c.g;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class f extends c0c.b implements o {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ o f411689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f411690c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final com.ss.android.lark.passportc.convention.b<o> f411691d;

    public static final class a {
    }

    static {
    }

    @Override // a2b.o
    public final void H8(Context r100, AtUserGroupInfo r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "info");
        this.f411689b.H8(r100, r101);
    }

    @Override // a2b.o
    public final void La(Message r100) {
        this.f411689b.La(r100);
    }

    @Override // a2b.o
    public final void c6(RichText r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "richText");
        this.f411689b.c6(r100, r101);
    }

    @Override // a2b.o
    public final boolean isEnabled() {
        return this.f411689b.isEnabled();
    }

    @Override // a2b.o
    public final void pe(Map<Long, UserGroupEntity> r100) {
        Intrinsics.checkNotNullParameter(r100, "userGroups");
        this.f411689b.pe(r100);
    }

    @Override // a2b.o
    public final void w9(s.c r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f411689b.w9(r100);
    }

    @Override // a2b.o
    public final void z1(s.c r100) {
        Intrinsics.checkNotNullParameter(r100, "observer");
        this.f411689b.z1(r100);
    }

    public f(j r100, v r101) {
        UserSession r102 = r100.b();
        if (r102 != null) goto L5;
        r102 = ContainerConstsKt.a();
    L5:
        com.ss.android.lark.passportc.convention.b<o> r103 = new com.ss.android.lark.passportc.convention.b(k.b(r101.c(r102), o.class), o.class);
        Intrinsics.checkNotNullParameter(r100, "passport");
        Intrinsics.checkNotNullParameter(r101, "accessor");
        Intrinsics.checkNotNullParameter(r103, "instanceHolder");
        super(r100);
        this.f411689b = r103.b();
        this.f411690c = r101;
        this.f411691d = r103;
    }

    @Override // c0c.b
    public final void qf(g r100, g r101) {
        Log.i("UserGroupRepositoryProxy", "preparing IUserGroupRepository");
        v r102 = this.f411690c;
        if (r101 == null) goto L6;
        UserSession r103 = r101.f475034b;
        if (r103 == null) goto L6;
    L7:
        o r104 = (o) k.b(r102.c(r103), o.class);
        this.f411691d.e(r104);
        return;
    L6:
        r103 = ContainerConstsKt.a();
        goto L7
    }
}
