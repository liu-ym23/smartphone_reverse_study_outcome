package com.larksuite.component.card.component;

import androidx.collection.LruCache;
import com.larksuite.component.card.component.res.ComponentISettings;
import com.larksuite.component.card.utils.NetUtils;
import com.larksuite.framework.utils.s;
import com.ss.android.lark.appsetting.api.SettingManager;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.vfs.VFSPath;
import com.suite.lark.platform.component.storage.file.LarkFileStorage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import okio.BufferedSource;
import okio.Okio;
import znc.h;
import znc.i;

/* JADX INFO: loaded from: classes24.dex */
public final class CardDynamicComponentFetcher implements k7a.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f283257a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Object f283258b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final LruCache<String, byte[]> f283259c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final VFSPath f283260d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Lazy<h> f283261e = null;

    public static final class a implements CoroutineScope {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CoroutineScope f283262a;

        @Override // kotlinx.coroutines.CoroutineScope
        public final CoroutineContext getCoroutineContext() {
            return this.f283262a.getCoroutineContext();
        }

        public a() {
            this.f283262a = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        }

        public static final Object a(a r100, String r101) {
            r100.getClass();
            ComponentISettings r102 = (ComponentISettings) SettingManager.getInstance().get(ComponentISettings.class);     // Catch: Throwable -> L28
            byte[] r103 = null;
            if (r102 == null) goto L10;
            HashMap<String, ComponentISettings.a> r104 = r102.getDynamicComponents();     // Catch: Throwable -> L28
            if (r104 == null) goto L10;
            ComponentISettings.a r105 = r104.get(r101);     // Catch: Throwable -> L28
            if (r105 == null) goto L10;
            String r106 = r105.b();     // Catch: Throwable -> L28
        L11:
            if (r106 != null) goto L13;
            Result.Companion r107 = Result.Companion;     // Catch: Throwable -> L28
            return Result.m9449constructorimpl(ResultKt.createFailure(new RuntimeException("load file from cdn, cannot find url")));
        L13:
            int r108 = NetUtils.f283948a;     // Catch: Throwable -> L28
            Intrinsics.checkNotNullParameter(r106, "url");     // Catch: Throwable -> L28
            Response r109 = new OkHttpClient.Builder().build().newCall(new Request.Builder().url(r106).build()).execute();     // Catch: Throwable -> L28
            if (r109.isSuccessful() == false) goto L26;
            ResponseBody r110 = r109.body();     // Catch: Throwable -> L28
            if (r110 == null) goto L18;
            r103 = r110.bytes();     // Catch: Throwable -> L28
        L18:
            if (r103 != null) goto L20;
            Result.Companion r111 = Result.Companion;     // Catch: Throwable -> L28
            return Result.m9449constructorimpl(ResultKt.createFailure(new RuntimeException("load file from cdn response body is null")));
        L20:
            CardDynamicComponentFetcher.f283259c.put(r101, r103);     // Catch: Throwable -> L28
            String r112 = s.b(r101);     // Catch: Throwable -> L23
            Lazy<h> r113 = CardDynamicComponentFetcher.f283261e;     // Catch: Throwable -> L23
            h r114 = r113.getValue();     // Catch: Throwable -> L23
            ByteArrayInputStream r115 = new ByteArrayInputStream(r103);     // Catch: Throwable -> L23
            Intrinsics.checkNotNullParameter(r114, "<this>");     // Catch: Throwable -> L23
            Intrinsics.checkNotNullParameter(r112, "key");     // Catch: Throwable -> L23
            Intrinsics.checkNotNullParameter(r115, "inputStream");     // Catch: Throwable -> L23
            r114.d(r112, new i(r115));     // Catch: Throwable -> L23
            r113.getValue().flush();     // Catch: Throwable -> L23
        L36:
            return Result.m9449constructorimpl(r103);
        L23:
            th = move-exception;
            Log.e("CardDynamicComponentFetcher", "save file to diskCache failed", th);     // Catch: Throwable -> L28
            goto L36
        L26:
            Result.Companion r116 = Result.Companion;     // Catch: Throwable -> L28
            return Result.m9449constructorimpl(ResultKt.createFailure(new RuntimeException("load file from cdn response is not successful, code: " + r109.code())));
        L10:
            r106 = null;
        L28:
            th = move-exception;
            Result.Companion r117 = Result.Companion;
            return Result.m9449constructorimpl(ResultKt.createFailure(th));
        }

        public static final Object b(a r100, String r101) {
            r100.getClass();
            File r102 = CardDynamicComponentFetcher.f283261e.getValue().a(s.b(r101));     // Catch: Throwable -> L29
            if (r102 != null) goto L6;
            Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L29
            return Result.m9449constructorimpl(ResultKt.createFailure(new RuntimeException("file not in diskCache")));
        L6:
            BufferedSource r104 = Okio.buffer(Okio.source(r102));     // Catch: Throwable -> L29
            byte[] r105 = r104.readByteArray();     // Catch: Throwable -> L24
            CardDynamicComponentFetcher.f283257a.getClass();     // Catch: Throwable -> L24
            CardDynamicComponentFetcher.f283259c.put(r101, r105);     // Catch: Throwable -> L24
            String r106 = null;
            CloseableKt.closeFinally(r104, null);     // Catch: Throwable -> L29
            ComponentISettings r107 = (ComponentISettings) SettingManager.getInstance().get(ComponentISettings.class);     // Catch: Throwable -> L29
            if (r107 == null) goto L16;
            HashMap<String, ComponentISettings.a> r108 = r107.getDynamicComponents();     // Catch: Throwable -> L29
            if (r108 == null) goto L16;
            ComponentISettings.a r109 = r108.get(r101);     // Catch: Throwable -> L29
            if (r109 == null) goto L16;
            r106 = r109.a();     // Catch: Throwable -> L29
        L16:
            String r110 = s.a(r105);     // Catch: Throwable -> L29
            if (Intrinsics.areEqual(r106, r110) == true) goto L19;
            Log.e("CardDynamicComponentFetcher", "file md5 " + r110 + ", setting md5 " + r106);     // Catch: Throwable -> L29
            boolean r111 = false;
        L20:
            if (r111 == true) goto L39;
            Result.Companion r112 = Result.Companion;     // Catch: Throwable -> L29
            return Result.m9449constructorimpl(ResultKt.createFailure(new RuntimeException("file in diskCache but invalid")));
        L39:
            return Result.m9449constructorimpl(r105);
        L19:
            r111 = true;
            goto L20
        L24:
            th = move-exception;
            throw th;     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            CloseableKt.closeFinally(r104, th);     // Catch: Throwable -> L29
            throw th;     // Catch: Throwable -> L29
        L29:
            th = move-exception;
            Result.Companion r113 = Result.Companion;
            return Result.m9449constructorimpl(ResultKt.createFailure(th));
        }

        public static final Object c(a r100, String r101, Continuation r102) {
            r100.getClass();
            if ((r102 instanceof CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$1) == false) goto L7;
            CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$1 r103 = (CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$1) r102;
            int r104 = r103.label;
            if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
            r103.label = r104 - Integer.MIN_VALUE;
        L8:
            Object r105 = r103.result;
            Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r107 = r103.label;
            if (r107 == 0) goto L14;
            if (r107 != 1) goto L13;
            ResultKt.throwOnFailure(r105);
        L18:
            return ((Result) r105).m9458unboximpl();
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r105);
            Log.i("CardDynamicComponentFetcher", "load from net");
            CoroutineDispatcher r108 = Dispatchers.getIO();
            CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$2 r109 = new CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$2(r101, null);
            r103.label = 1;
            r105 = BuildersKt.withContext(r108, r109, r103);
            if (r105 != r106) goto L18;
            return r106;
        L7:
            r103 = new CardDynamicComponentFetcher$Fetcher$loadFromNetSuspend$1(r100, r102);
            goto L8
        }

        public static final Object d(a r100, String r101, Continuation r102) {
            r100.getClass();
            if ((r102 instanceof CardDynamicComponentFetcher$Fetcher$loadFromPathSuspend$1) == false) goto L7;
            CardDynamicComponentFetcher$Fetcher$loadFromPathSuspend$1 r103 = (CardDynamicComponentFetcher$Fetcher$loadFromPathSuspend$1) r102;
            int r104 = r103.label;
            if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
            r103.label = r104 - Integer.MIN_VALUE;
        L8:
            Object r105 = r103.result;
            Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r107 = r103.label;
            if (r107 == 0) goto L14;
            if (r107 != 1) goto L13;
            ResultKt.throwOnFailure(r105);
        L18:
            return ((Result) r105).m9458unboximpl();
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r105);
            Log.i("CardDynamicComponentFetcher", "load from path");
            CoroutineDispatcher r108 = Dispatchers.getIO();
            CardDynamicComponentFetcher$Fetcher$loadFromPathSuspend$2 r109 = new CardDynamicComponentFetcher$Fetcher$loadFromPathSuspend$2(r101, null);
            r103.label = 1;
            r105 = BuildersKt.withContext(r108, r109, r103);
            if (r105 != r106) goto L18;
            return r106;
        L7:
            r103 = new CardDynamicComponentFetcher$Fetcher$loadFromPathSuspend$1(r100, r102);
            goto L8
        }
    }

    static {
        f283257a = new a();
        f283258b = new Object();
        f283259c = new LruCache(1);
        f283260d = LarkFileStorage.b().b(com.ss.android.lark.storage.f.f440957d, new com.ss.android.lark.storage.d(new String[]{"open_platform", "card_dynamic_components"}));
        f283261e = LazyKt.lazy(CardDynamicComponentFetcher$Fetcher$diskCache$2.INSTANCE);
    }
}
