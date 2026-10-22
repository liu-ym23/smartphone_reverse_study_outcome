package com.larus.im.internal.database;

import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.larus.im.internal.database.dao.BotDao;
import com.larus.im.internal.database.dao.ConversationDao;
import com.larus.im.internal.database.dao.DBIndexDAO;
import com.larus.im.internal.database.dao.MessageDao;
import com.larus.im.internal.database.dao.ParticipantDao;
import com.larus.im.internal.delegate.g1;
import com.larus.im.internal.jni.NativeIMDatabase;
import com.larus.im.internal.jni.OmniSDKHelper;
import com.larus.im.internal.utils.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;

/* JADX INFO: loaded from: classes4.dex */
public interface b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f347916a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ a f347917a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final vt7.a<String, b> f347918b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final Lazy<CoroutineDispatcher> f347919c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final Object f347920d = null;

        public a() {
        }

        static {
            f347917a = new a();
            f347918b = new vt7.a();
            f347919c = LazyKt.lazy(new com.larus.im.internal.database.a());
            f347920d = new Object();
        }

        public static b b() {
            com.larus.im.internal.delegate.b r100 = com.larus.im.internal.delegate.b.f348193b;
            String r101 = r100.getUserId();
            if (r101.length() != 0) goto L5;
            boolean r102 = true;
        L7:
            if (r102 == false) goto L9;
            com.larus.im.internal.delegate.a.f348188b.e("IMDatabase", "UserId can't be empty");
        L9:
            int r103 = i.f350541a;
            i.a r104 = i.a(r101, r100.a());
            String r105 = r104.f350547f;
            com.larus.im.internal.delegate.c r106 = com.larus.im.internal.delegate.c.f348197a;
            if (r106.isDebug() == false) goto L12;
            com.larus.im.internal.delegate.a.f348188b.d("IMDatabase", "getDatabase: " + r105);
        L12:
            String r107 = r104.f350546e;
            b r108 = f347918b.get(r105);
            if (r108 != null) goto L19;
            long r109 = r106.currentTimeMillis();
            b r110 = a(r105, r101);     // Catch: Exception -> L17
        L22:
            return r110;
        L17:
            e = move-exception;
            g1.f348229b.d().a(e, r109, r107);
            r110 = a(r105, r101);
            goto L22
        L19:
            return r108;
        L5:
            r102 = false;
            goto L7
        }

        public static void c(String r100) {
            Intrinsics.checkNotNullParameter(r100, LocationMonitorConst.IDENTIFIER);
            com.larus.im.internal.delegate.a r101 = com.larus.im.internal.delegate.a.f348188b;
            r101.w("IMDatabase_Release", "start releaseNativeDatabase, identifier: " + r100);
            vt7.a<String, b> r102 = f347918b;
            b r103 = r102.get(r100);
            if ((r103 instanceof NativeIMDatabase) == false) goto L6;
            r101.w("IMDatabase_Release", "release native database");
            r102.remove(r100);
            ((NativeIMDatabase) r103).release(false);
            return;
        }

        public static b a(String r100, String r101) {
            vt7.a<String, b> r102 = f347918b;
            b r103 = r102.get(r100);
            if (r103 == null) goto L5;
            return r103;
        L5:
            Object r104 = f347920d;
            monitor-enter(r104);
            b r105 = r102.get(r100);     // Catch: Throwable -> L14
            if (r105 == null) goto L11;
            monitor-exit(r104);
            return r105;
        L11:
            com.larus.im.internal.delegate.a.f348188b.i("IMDatabase", "buildOmniDatabase: " + r100 + ", " + r101);     // Catch: Throwable -> L14
            b r106 = OmniSDKHelper.getOmniSDK$default(OmniSDKHelper.INSTANCE, r101, false, 2, null).getNativeDatabase$omnisdk_release();     // Catch: Throwable -> L14
            r102.put(r100, r106);     // Catch: Throwable -> L14
            monitor-exit(r104);
            return r106;
        L14:
            th = move-exception;
            throw th;
        }
    }

    static {
        f347916a = a.f347917a;
    }

    BotDao botDao();

    ConversationDao conversationDao();

    DBIndexDAO indexDao();

    MessageDao messageDao();

    ParticipantDao participantDao();
}
