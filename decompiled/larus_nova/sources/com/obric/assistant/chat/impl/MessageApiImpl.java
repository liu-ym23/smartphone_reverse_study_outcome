package com.obric.assistant.chat.impl;

import android.os.Build;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.utils.i;
import com.larus.im.bean.message.Message;
import com.larus.im.d;
import com.larus.im.internal.jni.bean.OmniBreakReason;
import com.larus.im.service.r;
import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.idl.IAgentMessageIDL;
import com.obric.aiagent.assistant.idl.bean.PicInfo;
import com.obric.aiagent.assistant.idl.h;
import com.obric.aiagent.ipc.utils.g;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import wc9.e;

/* JADX INFO: loaded from: classes4.dex */
public final class MessageApiImpl implements com.obric.assistant.chat.api.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final MessageApiImpl f386895a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f386896b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final CopyOnWriteArrayList<bda.b> f386897c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Message f386898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Message f386899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Message f386900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static Job f386901g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static Job f386902h;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f386903a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f386904b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Deferred<b> f386905c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f386903a, r101.f386903a) == true) goto L12;
            return false;
        L12:
            if (this.f386904b == r101.f386904b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f386905c, r101.f386905c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f386903a.hashCode() * 31;
            long r101 = this.f386904b;
            return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f386905c.hashCode();
        }

        public final String toString() {
            return "GetExtTask(scene=" + this.f386903a + ", startTime=" + this.f386904b + ", deferred=" + this.f386905c + ')';
        }

        public a(String r100, long r101, Deferred<b> r102) {
            Intrinsics.checkNotNullParameter(r100, "scene");
            Intrinsics.checkNotNullParameter(r102, "deferred");
            this.f386903a = r100;
            this.f386904b = r101;
            this.f386905c = r102;
        }
    }

    /* JADX INFO: loaded from: classes32.dex */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Map<String, String> f386909a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f386910b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f386909a, r101.f386909a) == true) goto L12;
            return false;
        L12:
            if (this.f386910b == r101.f386910b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            Map<String, String> r100 = this.f386909a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            long r102 = this.f386910b;
            return (r101 * 31) + ((int) (r102 ^ (r102 >>> 32)));
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "GetExtTaskResult(ext=" + this.f386909a + ", endTime=" + this.f386910b + ')';
        }

        public b(Map<String, String> r100, long r101) {
            this.f386909a = r100;
            this.f386910b = r101;
        }
    }

    public MessageApiImpl() {
    }

    static {
        f386895a = new MessageApiImpl();
        f386896b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f386897c = new CopyOnWriteArrayList();
    }

    public static Message c() {
        FLogger.f375446a.i("MessageApiImpl", "getLatestSendMessage, " + f386898d);
        return f386898d;
    }

    public final Message i() {
        FLogger.f375446a.i("MessageApiImpl", "tryGetLatestAnswer, null, " + f386900f);
        Message r100 = f386900f;
        if (r100 == null) goto L11;
        String r101 = r100.getConversationId();
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        if (i.g(r101) == true) goto L10;
        return null;
    L10:
        return f386900f;
    L11:
        return null;
    }

    public static void k(Message r100) {
        FLogger.f375446a.i("MessageApiImpl", "updateLatestSendMessage, " + r100);
        f386898d = r100;
        if (r100 == null) goto L9;
        String r101 = r100.getConversationId();
        if (r101 == null) goto L9;
        boolean r102 = true;
        if (i.g(r101) != true) goto L9;
    L10:
        if (r102 == false) goto L13;
        f386899e = r100;
        return;
    L13:
        return;
    L9:
        r102 = false;
        goto L10
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.obric.assistant.chat.impl.a] */
    @Override // com.obric.assistant.chat.api.a
    public final void a(final String r100) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        if (Build.VERSION.SDK_INT < 24) goto L5;
        CopyOnWriteArrayList<bda.b> r101 = f386897c;
        final ?? r102 = new com.obric.assistant.chat.impl.a(r100);
        r101.removeIf(new com.obric.assistant.chat.impl.b(r102));
        return;
    L5:
        CopyOnWriteArrayList<bda.b> r103 = f386897c;
        ArrayList r104 = new ArrayList();
        Iterator<bda.b> r105 = r103.iterator();
    L7:
        if (r105.hasNext() == false) goto L12;
        bda.b r106 = r105.next();
        bda.b r107 = r106;
        FLogger.f375446a.i("MessageApiImpl", "unregisterSendMessageExtCallback, " + r100 + ", " + r107.getScene());
        if (Intrinsics.areEqual(r107.getScene(), r100) == false) goto L7;
        r104.add(r106);
        goto L7
    L12:
        if ((!r104.isEmpty()) == false) goto L21;
        f386897c.removeAll(r104);
        return;
    }

    public final com.obric.assistant.chat.api.a.C4595a d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        e r101 = com.obric.assistant.chat.internal.e.b();
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("getScreenPicInfo: called, main conversationId= ");
        Integer r104 = null;
        if (r101 == null) goto L5;
        String r105 = r101.f559198a;
    L6:
        r103.append(r105);
        r103.append(", current conversationId = ");
        r103.append(r100);
        r102.i("MessageApiImpl", r103.toString());
        if (r101 == null) goto L9;
        String r106 = r101.f559198a;
    L11:
        if (Intrinsics.areEqual(r106, r100) == false) goto L32;
        KClass r107 = Reflection.getOrCreateKotlinClass(IAgentMessageIDL.class);
        int r108 = h.f384528a;
        Intrinsics.checkNotNullParameter(r107, "<this>");
        g.f384740a.getClass();
        IAgentMessageIDL r109 = (IAgentMessageIDL) g.b(IAgentMessageIDL.class);
        if (r109 == null) goto L15;
        PicInfo r110 = r109.getScreenPicInfo();
    L16:
        if (r110 == null) goto L18;
        com.obric.assistant.chat.api.a.C4595a r111 = new com.obric.assistant.chat.api.a.C4595a(r110.getTosKey(), r110.getResId(), r110.getWidth(), r110.getHeight());
    L19:
        StringBuilder r112 = new StringBuilder("getScreenPicInfo tosKey=");
        if (r110 == null) goto L22;
        String r113 = r110.getTosKey();
    L23:
        r112.append(r113);
        r112.append(" width=");
        if (r110 == null) goto L26;
        Integer r114 = r110.getWidth();
    L27:
        r112.append(r114);
        r112.append(" height=");
        if (r110 == null) goto L30;
        r104 = r110.getHeight();
    L30:
        r112.append(r104);
        r102.i("MessageApiImpl", r112.toString());
        return r111;
    L26:
        r114 = null;
        goto L27
    L22:
        r113 = null;
        goto L23
    L18:
        r111 = null;
        goto L19
    L15:
        r110 = null;
        goto L16
    L32:
        return null;
    L9:
        r106 = null;
        goto L11
    L5:
        r105 = null;
        goto L6
    }

    public final void g(bda.b r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        CopyOnWriteArrayList<bda.b> r101 = f386897c;
        r101.add(r100);
        FLogger.f375446a.i("MessageApiImpl", "registerSendMessageExtCallback," + r100.getScene() + ", totalCount: " + r101.size());
    }

    public final void h(String r110) {
        FLogger.f375446a.i("MessageApiImpl", "tryBreakLatestAnswer, " + r110 + ", " + f386898d);
        Message r100 = f386898d;
        if (r100 != null) goto L5;
        return;
    L5:
        if (Intrinsics.areEqual(r110, r100.getConversationId()) == false) goto L9;
        ArrayList r101 = new ArrayList();
        r101.add(r100);
        r.a.d(d.d(), r110, RepoDispatcherDelegate.f307737b.f().x(r110), r101, true, OmniBreakReason.OmniBreakReason_CLICK_ASR, 64);
        return;
    }

    public final Message j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        FLogger.f375446a.i("MessageApiImpl", "tryGetLatestSendMessage, cvsId: " + r100 + ", " + f386899e);
        Message r101 = f386899e;
        if (r101 != null) goto L5;
        return null;
    L5:
        if (Intrinsics.areEqual(r100, r101.getConversationId()) == true) goto L7;
        return null;
    L7:
        if (i.g(r100) == false) goto L12;
        return r101;
    L12:
        return null;
    }

    public static Map e(Map r100, e r101, bda.b.a r102) {
        Intrinsics.checkNotNullParameter(r100, "originExt");
        long r103 = System.currentTimeMillis();
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("getSendMessageExt: called, conversationId= ");
        if (r101 == null) goto L5;
        String r106 = r101.f559198a;
    L6:
        r105.append(r106);
        r104.i("MessageApiImpl", r105.toString());
        LinkedHashMap r107 = new LinkedHashMap();
        BuildersKt.runBlocking$default(null, new MessageApiImpl$getSendMessageExt$1(r107, r100, r102, null), 1, null);
        LinkedHashMap r108 = new LinkedHashMap();
        r108.put("o_did", o.f365780a.getDeviceId());
        r107.putAll(r108);
        r104.i("MessageApiImpl", "getSendMessageExt: called, return: " + r107);
        r104.i("MessageApiImpl", "getSendMessageExt: called, getSendMessageExt total cost time = " + (System.currentTimeMillis() - r103));
        return r107;
    L5:
        r106 = null;
        goto L6
    }

    public final zca.a f(Map<String, String> r100, e r101, bda.b.a r102) {
        Intrinsics.checkNotNullParameter(r100, "originExt");
        Map r103 = e(r100, r101, r102);
        return new zca.a(r103, Intrinsics.areEqual(((LinkedHashMap) r103).get("o_agent_ext_completed"), "1"));
    }

    public final void b(Message r110, String r111, Map r112, com.obric.assistant.chat.api.a.C4595a r113) {
        Intrinsics.checkNotNullParameter(r110, "message");
        BuildersKt.launch$default(f386896b, null, null, new MessageApiImpl$addFilesOnModify$1(r110, r112, r113, r111, true, null), 3, null);
    }
}
