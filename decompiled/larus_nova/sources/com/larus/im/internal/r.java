package com.larus.im.internal;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.im.constant.CompensateScene;
import com.larus.im.internal.core.conversation.ConversationLocalManager;
import com.larus.im.internal.database.entity.MessageEntity;
import com.larus.im.internal.database.slowtask.DBSlowTaskManager;
import com.larus.im.internal.delegate.d0;
import com.larus.im.internal.delegate.d1;
import com.larus.im.internal.legacy.NativeCmdServiceImpl;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import nuc.v2;
import ouc.e0;

/* JADX INFO: loaded from: classes4.dex */
public final class r implements hd9.l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final gd9.r f349793a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f349794b;

    /* JADX INFO: loaded from: classes29.dex */
    public static final class a implements hd9.i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f349795a = null;

        static {
            f349795a = new a();
        }

        public a() {
        }

        @Override // hd9.i
        public final void a(Throwable r100, long r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "e");
            int r103 = ce9.a.f23485a;
            Intrinsics.checkNotNullParameter(r100, "e");
            d1 r104 = d1.f348206b;
            e0 r105 = new e0();
            int r106 = com.larus.im.internal.tracking.c.f350315a;
            com.larus.im.internal.tracking.c.e(r105, ce9.a.a());
            ouc.j.c(r105, "db_name", r102);
            ouc.j.c(r105, LocationMonitorConst.ERR_MSG, String.valueOf(r100));
            ouc.j.b(r105, "duration", Long.valueOf(fuc.a.a().a() - r101));
            ouc.j.a(r105, "is_wcdb", Boolean.valueOf(d0.f348204b.isWCDBEnable()));
            Unit r107 = Unit.INSTANCE;
            r104.a("room_db_build_err", r105.a());
        }
    }

    /* JADX INFO: loaded from: classes29.dex */
    public static final class b implements hd9.m {
        public b() {
        }

        @Override // hd9.m
        public final Map<String, String> a(MessageEntity r100) {
            Intrinsics.checkNotNullParameter(r100, "entity");
            String r101 = r100.getExt();
            StringCompanionObject r102 = StringCompanionObject.INSTANCE;
            kuc.a.f(r102);
            v2 r103 = v2.f520790a;
            Intrinsics.checkNotNullParameter(r102, "<this>");
            Map<String, String> r104 = (Map) zd9.i.a(r101, kuc.a.c(r103, r103));
            if (r104 == null) goto L5;
            return r104;
        L5:
            return MapsKt.emptyMap();
        }
    }

    public static final class c implements hd9.k {
        public c() {
        }

        @Override // hd9.k
        public final void a() {
            Lazy r100 = com.larus.im.internal.memory.c.f348938a;
        }

        @Override // hd9.k
        public final void b() {
            Lazy r100 = com.larus.im.internal.memory.c.f348938a;
        }

        @Override // hd9.k
        public final void c() {
            Lazy r100 = com.larus.im.internal.memory.c.f348938a;
        }

        @Override // hd9.k
        public final void d() {
            Lazy r100 = com.larus.im.internal.memory.c.f348938a;
        }
    }

    @Override // hd9.l
    public final String c() {
        this.f349793a.b().getClass();
        return "im_database_";
    }

    @Override // hd9.l
    public final hd9.m e() {
        return (hd9.m) this.f349794b.getValue();
    }

    @Override // hd9.l
    public final hd9.k f() {
        return new c();
    }

    @Override // hd9.l
    public final hd9.i d() {
        return a.f349795a;
    }

    public r(gd9.r r100) {
        Intrinsics.checkNotNullParameter(r100, "dependency");
        this.f349793a = r100;
        this.f349794b = LazyKt.lazy(new q());
    }

    @Override // hd9.l
    public final String a(MessageEntity r100) {
        Intrinsics.checkNotNullParameter(r100, "messageEntity");
        int r101 = com.larus.im.internal.database.utils.h.f348163a;
        String r102 = r100.getMessageId();
        if (r102 != null) goto L5;
        r102 = "";
    L5:
        int r103 = com.larus.im.internal.database.utils.k.e(r100);
        String r104 = r100.getContent();
        if (r104 != null) goto L8;
        r104 = "";
    L8:
        String r105 = r100.getThinkingContent();
        if (r105 != null) goto L11;
        r105 = "";
    L11:
        String r106 = r102;
        return com.larus.im.internal.database.utils.h.a("MessageEntity.increaseBy", r106, r103, r104, r105, com.larus.im.internal.database.utils.k.b(r100));
    }

    @Override // hd9.l
    public final void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dbName");
        ConversationLocalManager.INSTANCE.saveConversationVersion(0);
        int r101 = com.larus.im.internal.core.conversation.group.j.f347627a;
        CompensateScene r102 = CompensateScene.ON_DATABASE_CORRUPTED;
        com.larus.im.internal.core.conversation.group.j.b(r102);
        NativeCmdServiceImpl.Companion.getClass();
        NativeCmdServiceImpl.a.a().fetchCmdChain(r102);
    }

    @Override // hd9.l
    public final void g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "dbName");
        DBSlowTaskManager.f348138a.getClass();
        DBSlowTaskManager.c(r100);
    }
}
