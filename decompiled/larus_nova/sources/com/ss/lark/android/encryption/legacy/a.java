package com.ss.lark.android.encryption.legacy;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.security.v1.OpenOptions;
import com.bytedance.lark.pb.security.v1.OpenRequest;
import com.bytedance.lark.pb.security.v1.OpenResponse;
import com.bytedance.lark.pb.security.v1.SelfHelpContext;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.lark.android.encryption.utils.SCMonitorKt;
import com.ss.lark.android.encryption.utils.b;
import ikc.f;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes40.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, kkc.a> f456803a = null;

    /* JADX INFO: renamed from: com.ss.lark.android.encryption.legacy.a$a, reason: collision with other inner class name */
    public static final class C5465a<T> implements SdkSender.IParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C5465a<T> f456804a = null;

        static {
            f456804a = new C5465a();
        }

        public C5465a() {
        }

        @Override // com.ss.android.lark.sdk.SdkSender.IParser
        public final Object parse(byte[] r100) {
            return OpenResponse.ADAPTER.decode(r100);
        }
    }

    public a() {
    }

    static {
        f456803a = new ConcurrentHashMap();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final kkc.a a(String r100, boolean r101, boolean r102) {
        Log.i("ScsFileLock", "openFileInternal: " + r100 + ", encrypt: " + r101);
        f.f490295a.f490292a.a();
        SdkSender.d r103 = c(r100, r101, r102, false);     // Catch: Exception -> L6
        OpenResponse r104 = null;
        if (r103 == null) goto L9;
        OpenResponse r105 = (OpenResponse) r103.f439867a;     // Catch: Exception -> L6
    L9:
        if (r103 == null) goto L11;
        r104 = (OpenResponse) r103.f439867a;     // Catch: Exception -> L6
    L11:
        if (r104 != null) goto L13;
        b.b(r100, new ErrorResult("rust response null"), -1);     // Catch: Exception -> L6
        throw new IOException("rust response null");     // Catch: Exception -> L6
    L13:
        return b(r100, (OpenResponse) r103.f439867a, r103.f439868b);
    L6:
        e = move-exception;
        Log.e("ScsFileLock", "openFileInternal: error: " + e);
        throw new IOException(e);
    }

    public static kkc.a b(String r100, OpenResponse r101, ErrorResult r102) {
        SelfHelpContext r103 = r101.selfhelp_context;
        Integer r104 = r101.err_code;
        kkc.a r105 = new kkc.a();
        if (r104 != null) goto L6;
    L12:
        if (r104 != null) goto L15;
    L18:
        Intrinsics.checkNotNull(r104);
        b.b(r100, r102, r104.intValue());
        return r105;
    L15:
        if (r104.intValue() != 0) goto L18;
        if (r103 != null) goto L18;
        r104 = -1;
        goto L18
    L6:
        if (r104.intValue() != 0) goto L12;
        if (r103 == null) goto L12;
        if (r103.encrypted.booleanValue() == false) goto L11;
        Log.i("ScsFileLock", r100 + " get encrypted params success");
        r105.f503831a = true;
        ByteString r106 = r103.key;
        ByteString r107 = r103.nonce;
        r105.f503832b = r106.toByteArray();
        r105.f503833c = r107.toByteArray();
        r105.f503834d = r103.header_len.intValue();
        goto L12
    L11:
        Log.i("ScsFileLock", r100 + " get encrypted params: false");
        r105.f503831a = false;
        goto L12
    }

    public static SdkSender.d c(String r100, boolean r101, boolean r102, boolean r103) throws Exception {
        OpenOptions.Builder r104 = new OpenOptions.Builder();     // Catch: Exception -> L7
        Boolean r105 = Boolean.TRUE;     // Catch: Exception -> L7
        OpenOptions.Builder r106 = r104.create(r105).read(r105).write(r105).selfhelp_mode(r105).truncate(Boolean.valueOf(r102));     // Catch: Exception -> L7
        if (r101 == true) goto L5;
        r106.load_only(r105);     // Catch: Exception -> L7
    L5:
        return SdkSender.syncSendMayError(Command.SECURITY_FILE_OPEN, new OpenRequest.Builder().options(r106.build()).path(r100), C5465a.f456804a);
    L7:
        e = move-exception;
        Log.e("ScsFileLock", "openFile: " + r100 + ", error: " + e + ", retry: " + r103);
        SCMonitorKt.a(r102, r101, e);
        b.a(e);
        throw e;
    }
}
