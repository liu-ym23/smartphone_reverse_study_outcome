package com.larus.ugc.perf.impl;

import android.text.TextUtils;
import android.util.LruCache;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.larus.bmhome.chat.trace.j;
import com.larus.bmhome.creative.CreativeScene;
import com.larus.im.bean.message.Message;
import com.larus.im.depend.ISDKPointCallback;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.ugc.perf.impl.genimg.OldUgcGenImgPerfMonitor;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: loaded from: classes31.dex */
public final class h implements nq9.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f375124a = null;

    public h() {
    }

    static {
        f375124a = new h();
        int r100 = f1a.a.f475089a;
        FLogger.f375446a.i("UgcPerfConfig", "init with img, and lyrics to song observer. ");
    }

    @Override // nq9.f
    public final void b() {
        i1a.a r100 = i1a.a.f488015a;
    }

    @Override // nq9.f
    public final OldUgcGenImgPerfMonitor a(boolean r100) {
        if (r100 == false) goto L5;
        return com.larus.ugc.perf.impl.genimg.d.f375121d;
    L5:
        return com.larus.ugc.perf.impl.genimg.e.f375123d;
    }

    @Override // nq9.f
    public final void d(j r100) {
        Intrinsics.checkNotNullParameter("MusicCreateMob", "key");
        Intrinsics.checkNotNullParameter(r100, "listener");
        f.f375107a.getClass();
        Intrinsics.checkNotNullParameter("MusicCreateMob", "key");
        Intrinsics.checkNotNullParameter(r100, "listener");
        f.f375110d.put("MusicCreateMob", r100);
    }

    @Override // nq9.f
    public final void o4(Message r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        f.f375107a.getClass();
        Intrinsics.checkNotNullParameter(r100, "msg");
        String r101 = r100.getReplyId();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        e r102 = f.b(r101);
        if (r102 == null) goto L35;
        r102.k(r100.getMessageId());
        r102.j(r100.getContentType());
        r102.f375104a = r100;
        if (com.larus.im.bean.message.a.r0(r100) == true) goto L10;
    L29:
        d r103 = f.f375109c.get(Integer.valueOf(r100.getContentType()));
        if (r103 == null) goto L38;
        r103.a(r102);
        return;
    L38:
        return;
    L10:
        if (CollectionsKt.contains(CollectionsKt.listOf(new String[]{"image", CreativeScene.AVATAR_IMAGE, CreativeScene.AI_BEAUTIFY_IMAGE}), ap8.a.b(r100)) == false) goto L29;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Result.Companion r104 = Result.Companion;     // Catch: Throwable -> L20
        Map<String, String> r105 = r100.getExt();     // Catch: Throwable -> L20
        if (r105 == null) goto L17;
        String r106 = r105.get("creativity_resp_num");     // Catch: Throwable -> L20
        if (r106 == null) goto L17;
        int r107 = CastIntegerProtector.parseInt(r106);     // Catch: Throwable -> L20
    L18:
        Object r108 = Result.m9449constructorimpl(Integer.valueOf(r107));     // Catch: Throwable -> L20
    L23:
        if (Result.m9452exceptionOrNullimpl(r108) == null) goto L26;
        r108 = 0;
    L26:
        r102.h(((Number) r108).intValue());
        d r109 = f.f375109c.get(6);
        if (r109 == null) goto L36;
        r109.h(r102);
        return;
    L36:
        return;
    L17:
        r107 = 0;
    L20:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L23
    }

    @Override // nq9.f
    public final void e(String r100, ISDKPointCallback.EndMsg r101) {
        Intrinsics.checkNotNullParameter(r101, "endMsg");
        f.f375107a.getClass();
        Intrinsics.checkNotNullParameter(r101, "endMsg");
        e r102 = f.b(r100);
        if (r102 == null) goto L11;
        d r103 = f.f375109c.get(Integer.valueOf(r101.getContentType()));
        if (r103 == null) goto L7;
        r103.d(r102);
    L7:
        Iterator<T> r104 = f.f375110d.values().iterator();
    L9:
        if (r104.hasNext() == false) goto L13;
        ((Function2) r104.next()).invoke(r101.getId(), Integer.valueOf(r101.getContentType()));
        goto L9
    L13:
        return;
    }

    @Override // nq9.f
    public final void f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "localSendMsgId");
        f.f375107a.getClass();
        Intrinsics.checkNotNullParameter(r100, "localSendMsgId");
        boolean r102 = true;
        if ((!StringsKt.isBlank(r100)) == false) goto L18;
        if (r101 != null) goto L6;
    L9:
        if (r102 == true) goto L19;
        LruCache<String, e> r103 = f.f375108b;
        e r104 = r103.remove(r100);
        if (r104 == null) goto L20;
        r103.put(r101, r104);
        long r105 = System.currentTimeMillis();
        r104.n(Long.valueOf(r105));
        Long r106 = r104.d();
        if (r106 == null) goto L15;
        long r107 = r106.longValue();
    L16:
        r104.l(Long.valueOf(r105 - r107));
        return;
    L15:
        r107 = 0;
        goto L16
    L20:
        return;
    L19:
        return;
    L6:
        if (StringsKt.isBlank(r101) == true) goto L9;
        r102 = false;
        goto L9
    }

    @Override // nq9.f
    public final void c(String r100, String r101, int r102) {
        f.f375107a.getClass();
        e r103 = f.b(r100);
        if (r103 == null) goto L8;
        r103.k(r101);
        r103.j(r102);
        d r104 = f.f375109c.get(Integer.valueOf(r102));
        if (r104 == null) goto L9;
        r104.c(r103);
        return;
    L9:
        return;
    }

    @Override // nq9.f
    public final void g(String r100, String r101, String r102, int r110, String r111, String r112, List<Message> r113, long r114) {
        Intrinsics.checkNotNullParameter(r100, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r101, "cvsId");
        Intrinsics.checkNotNullParameter(r102, "scene");
        Intrinsics.checkNotNullParameter(r111, "botId");
        Intrinsics.checkNotNullParameter(r112, "convType");
        f.f375107a.getClass();
        Intrinsics.checkNotNullParameter(r100, "localSendMsgId");
        Intrinsics.checkNotNullParameter(r102, "scene");
        Intrinsics.checkNotNullParameter(r111, "botId");
        Intrinsics.checkNotNullParameter(r112, "convType");
        if (StringsKt.isBlank(r100) == true) goto L108;
        boolean r103 = Intrinsics.areEqual("regen", r102);
        e r104 = new e(null);
        r104.p(Long.valueOf(r114));
        r104.e(r111);
        String r115 = "1";
        if (Intrinsics.areEqual("group", r112) == false) goto L8;
        String r116 = "1";
    L9:
        r104.g(r116);
        int r117 = 6;
        if (Intrinsics.areEqual(OPTrace.BATCH_DATA_KEY, r102) == false) goto L79;
        boolean r105 = false;
        if (r113 == null) goto L30;
        List<Message> r118 = r113;
        if ((r118 instanceof Collection) == true) goto L16;
    L18:
        Iterator<T> r119 = r118.iterator();
    L20:
        if (r119.hasNext() == false) goto L30;
        Message r106 = (Message) r119.next();
        if (r106.getContentType() != 6) goto L24;
    L27:
        boolean r107 = true;
    L28:
        if (r107 == false) goto L20;
        boolean r120 = true;
    L31:
        if (r113 == null) goto L54;
        List<Message> r108 = r113;
        if ((r108 instanceof Collection) == true) goto L35;
    L37:
        Iterator<T> r109 = r108.iterator();
    L39:
        if (r109.hasNext() == false) goto L54;
        Message r121 = (Message) r109.next();
        if (r121.getContentType() != 1) goto L51;
        String r122 = r121.getContent();
        if (r122 != null) goto L45;
    L48:
        boolean r123 = true;
    L49:
        if (r123 == true) goto L51;
        boolean r124 = true;
    L52:
        if (r124 == false) goto L39;
        boolean r125 = true;
    L55:
        if (r113 == null) goto L72;
        List<Message> r126 = r113;
        if ((r126 instanceof Collection) == true) goto L59;
    L61:
        Iterator<T> r127 = r126.iterator();
    L63:
        if (r127.hasNext() == false) goto L72;
        Message r128 = (Message) r127.next();
        if (r128.getContentType() == 6) goto L67;
    L69:
        boolean r129 = false;
    L70:
        if (r129 == false) goto L63;
        r105 = true;
        goto L72
    L67:
        if (IAIChatControlTraceService.f365889a.ib(r128.getExt()) == false) goto L69;
        r129 = true;
        goto L70
    L59:
        if (r126.isEmpty() == false) goto L61;
    L72:
        if (r105 == false) goto L76;
        if (r125 == true) goto L82;
        r117 = 4;
    L82:
        r104.i(Integer.valueOf(r117));
        if (r103 == true) goto L86;
        r115 = "0";
    L86:
        r104.o(r115);
        if (TextUtils.isEmpty(r100) == true) goto L91;
        if (r100 == null) goto L91;
        e r130 = f.f375108b.put(r100, r104);
    L91:
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new MessageLruSourceImpl$onStartSendMsg$1(r104, r111, null), 3, null);
        return;
    L76:
        if (r120 == false) goto L81;
        if (r125 == false) goto L80;
        r117 = 3;
    L80:
        r117 = 1;
    L81:
        r117 = 2;
        goto L82
    L45:
        if (StringsKt.isBlank(r122) == true) goto L48;
        r123 = false;
    L51:
        r124 = false;
        goto L52
    L35:
        if (r108.isEmpty() == false) goto L37;
    L54:
        r125 = false;
        goto L55
    L24:
        if (Intrinsics.areEqual(r106.getBizContentType(), "flow_nested") == true) goto L27;
        r107 = false;
        goto L28
    L16:
        if (r118.isEmpty() == false) goto L18;
    L30:
        r120 = false;
        goto L31
    L79:
        if (r110 != 6) goto L81;
    L8:
        r116 = "0";
        goto L9
    }
}
