package com.larus.uaigc.createpage.utils;

import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.social.userchat.model.LocalSubConvHelper;
import com.larus.platform.service.z2;
import com.larus.platform.spi.IAIChatControlTraceService;
import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.sync.MutexImpl;

/* JADX INFO: loaded from: classes31.dex */
public final class CreationRemoteConversationHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CreationRemoteConversationHelper f372613a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutexImpl f372614b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final ConcurrentHashMap<String, String> f372615c = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f372616a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f372617b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f372616a, r101.f372616a) == true) goto L12;
            return false;
        L12:
            if (this.f372617b == r101.f372617b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f372616a.hashCode() * 31;
            if (this.f372617b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "ResolveResult(conversationId=" + this.f372616a + ", replacedWithRemote=" + this.f372617b + ')';
        }

        public a(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "conversationId");
            this.f372616a = r100;
            this.f372617b = r101;
        }
    }

    public CreationRemoteConversationHelper() {
    }

    static {
        f372613a = new CreationRemoteConversationHelper();
        f372614b = kotlinx.coroutines.sync.b.a();
        f372615c = new ConcurrentHashMap();
    }

    public final Object a(String r100, String r101, Continuation<? super a> r102) {
        if ((r102 instanceof CreationRemoteConversationHelper$resolveBeforeUpload$1) == false) goto L7;
        CreationRemoteConversationHelper$resolveBeforeUpload$1 r103 = (CreationRemoteConversationHelper$resolveBeforeUpload$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L16;
        if (r107 != 1) goto L15;
        r100 = (String) r103.L$0;
        ResultKt.throwOnFailure(r105);     // Catch: Throwable -> L22 CancellationException -> L25
    L20:
    L29:
        return (a) r105;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r105);
        r103.L$0 = r100;     // Catch: Throwable -> L22 CancellationException -> L25
        r103.label = 1;     // Catch: Throwable -> L22 CancellationException -> L25
        r105 = b(r100, r101, r103);     // Catch: Throwable -> L22 CancellationException -> L25
        if (r105 != r106) goto L20;
        return r106;
    L25:
        e = move-exception;
        throw e;
    L22:
        th = move-exception;
        FLogger.f375446a.e("CreationRemoteConversation", "resolve conversation before upload failed, localCvsId=" + r100 + ", error=" + th);
        return new a(r100, false);
    L7:
        r103 = new CreationRemoteConversationHelper$resolveBeforeUpload$1(this, r102);
        goto L8
    }

    public final Object b(String r100, String r110, Continuation<? super a> r111) {
        if ((r111 instanceof CreationRemoteConversationHelper$resolveBeforeUploadInternal$1) == false) goto L7;
        CreationRemoteConversationHelper$resolveBeforeUploadInternal$1 r101 = (CreationRemoteConversationHelper$resolveBeforeUploadInternal$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L20;
        if (r104 == 1) goto L19;
        if (r104 != 2) goto L18;
        kotlinx.coroutines.sync.a r105 = (kotlinx.coroutines.sync.a) r101.L$1;
        String r113 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);     // Catch: Throwable -> L15
    L49:
        a r114 = (a) r112;     // Catch: Throwable -> L15
        if (r114 == null) goto L52;
        f372615c.put(r113, r114.f372616a);     // Catch: Throwable -> L15
    L53:
        a r106 = r114;
        kotlinx.coroutines.sync.a r115 = r105;
        a r107 = r106;
    L54:
        r115.unlock(null);
        return r107;
    L52:
        r114 = new a(r113, false);     // Catch: Throwable -> L15
    L15:
        Throwable th10 = th;
        r115 = r105;
    L59:
        r115.unlock(null);
        throw th10;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        kotlinx.coroutines.sync.a r108 = (kotlinx.coroutines.sync.a) r101.L$2;
        r110 = (String) r101.L$1;
        String r109 = (String) r101.L$0;
        ResultKt.throwOnFailure(r112);
        r115 = r108;
        r100 = r109;
    L62:
        String r116 = f372615c.get(r100);     // Catch: Throwable -> L57
        if (r116 == null) goto L45;
        r107 = new a(r116, true);     // Catch: Throwable -> L57
        goto L54
    L45:
        CreationRemoteConversationHelper r117 = f372613a;     // Catch: Throwable -> L57
        r101.L$0 = r100;     // Catch: Throwable -> L57
        r101.L$1 = r115;     // Catch: Throwable -> L57
        r101.L$2 = null;     // Catch: Throwable -> L57
        r101.label = 2;     // Catch: Throwable -> L57
        Object r118 = r117.c(r100, r110, r101);     // Catch: Throwable -> L57
        if (r118 != r103) goto L48;
        return r103;
    L48:
        r113 = r100;
        r105 = r115;
        r112 = r118;
    L57:
        th = move-exception;
        th10 = th;
        goto L59
    L20:
        ResultKt.throwOnFailure(r112);
        if (r100.length() != 0) goto L23;
        boolean r119 = true;
    L24:
        if (r119 == false) goto L28;
        return new a(r100, false);
    L28:
        if (com.larus.im.j.f(r100) == true) goto L32;
        return new a(r100, false);
    L32:
        if (Intrinsics.areEqual(z2.f365865a.getImageInstantUploadConfig().e(), Boxing.boxBoolean(true)) == false) goto L34;
        String r120 = f372615c.get(r100);
        if (r120 != null) goto L38;
        r115 = f372614b;
        r101.L$0 = r100;
        r101.L$1 = r110;
        r101.L$2 = r115;
        r101.label = 1;
        if (r115.a(null, r101) != r103) goto L62;
        return r103;
    L38:
        return new a(r120, true);
    L34:
        return new a(r100, false);
    L23:
        r119 = false;
    L7:
        r101 = new CreationRemoteConversationHelper$resolveBeforeUploadInternal$1(this, r111);
        goto L8
    }

    public final Object c(String r210, String r211, Continuation<? super a> r212) {
        if ((r212 instanceof CreationRemoteConversationHelper$resolveRemoteIfLocalSubConversation$1) == false) goto L7;
        CreationRemoteConversationHelper$resolveRemoteIfLocalSubConversation$1 r100 = (CreationRemoteConversationHelper$resolveRemoteIfLocalSubConversation$1) r212;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        CreationRemoteConversationHelper$resolveRemoteIfLocalSubConversation$1 r110 = r100;
        Object r102 = r110.result;
        Object r111 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r110.label;
        boolean r104 = false;
        int r112 = 2;
        if (r103 == 0) goto L18;
        if (r103 == 1) goto L17;
        if (r103 == 2) goto L16;
        if (r103 != 3) goto L15;
        String r105 = (String) r110.L$0;
        ResultKt.throwOnFailure(r102);
        Object r106 = r102;
        String r107 = r105;
        boolean r108 = true;
    L61:
        wc9.e r109 = (wc9.e) r106;
        if (r109 == null) goto L64;
        FLogger.f375446a.i("CreationRemoteConversation", "create remote conversation before upload success, localCvsId=" + r107 + ", remoteCvsId=" + r109.f559198a);
        return new a(r109.f559198a, r108);
    L64:
        FLogger.f375446a.e(r12, "create remote conversation before upload failed, localCvsId=" + r107);
        return null;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        wc9.e r113 = (wc9.e) r110.L$2;
        String r114 = (String) r110.L$1;
        String r115 = (String) r110.L$0;
        ResultKt.throwOnFailure(r102);
        String r116 = r114;
        r107 = r115;
    L41:
        String r117 = (String) r102;
        if (r117 != null) goto L44;
        r117 = r116;
    L44:
        if (r117 != null) goto L46;
    L47:
        r104 = true;
    L48:
        if (r104 == false) goto L51;
        FLogger.f375446a.e("CreationRemoteConversation", "create remote conversation before upload failed, botId is empty, localCvsId=" + r107);
        return null;
    L51:
        IConversationRepoService r118 = RepoDispatcherDelegate.f307737b.f();
        Integer r119 = r113.f559219v;
        if (r119 == null) goto L54;
        r112 = r119.intValue();
    L54:
        wc9.e r120 = AuthModelDelegate.f297134b.y().getValue();
        if (r120 == null) goto L57;
        String r121 = r120.f559198a;
    L58:
        r110.L$0 = r107;
        r110.L$1 = null;
        r110.L$2 = null;
        r110.label = 3;
        r108 = true;
        r106 = IConversationRepoService.a.a(r118, r117, r112, r121, null, false, null, null, null, null, r110, 504);
        if (r106 != r111) goto L61;
        return r111;
    L57:
        r121 = null;
        goto L58
    L46:
        if (r117.length() != 0) goto L48;
    L17:
        String r122 = (String) r110.L$1;
        r107 = (String) r110.L$0;
        ResultKt.throwOnFailure(r102);
    L24:
        wc9.e r123 = (wc9.e) r102;
    L26:
        if (r123 != null) goto L29;
        FLogger.f375446a.w("CreationRemoteConversation", "skip create remote conversation before upload, local conversation not found: " + r107);
        return null;
    L29:
        LocalSubConvHelper r124 = LocalSubConvHelper.f314106a;
        if (LocalSubConvHelper.h(r107, r123) == false) goto L34;
        return new a(r107, false);
    L34:
        if (ic8.n.D(r123) == true) goto L37;
        FLogger.f375446a.i("CreationRemoteConversation", "skip create remote conversation before upload, target is not sub conversation: " + r107);
        return null;
    L37:
        r110.L$0 = r107;
        r110.L$1 = r122;
        r110.L$2 = r123;
        r110.label = 2;
        Object r125 = r124.f(r123, r110);
        if (r125 != r111) goto L40;
        return r111;
    L40:
        String r213 = r122;
        r113 = r123;
        r102 = r125;
        r116 = r213;
        goto L41
    L18:
        ResultKt.throwOnFailure(r102);
        r123 = IAIChatControlTraceService.a.h(IAIChatControlTraceService.f365889a, r210);
        if (r123 != null) goto L25;
        IConversationRepoService r126 = RepoDispatcherDelegate.f307737b.f();
        r110.L$0 = r210;
        r110.L$1 = r211;
        r110.label = 1;
        r102 = IConversationRepoService.a.c(r126, r210, true, null, r110, 4);
        if (r102 != r111) goto L23;
        return r111;
    L23:
        r122 = r211;
        r107 = r210;
        goto L24
    L25:
        r122 = r211;
        r107 = r210;
    L7:
        r100 = new CreationRemoteConversationHelper$resolveRemoteIfLocalSubConversation$1(this, r212);
        goto L8
    }
}
