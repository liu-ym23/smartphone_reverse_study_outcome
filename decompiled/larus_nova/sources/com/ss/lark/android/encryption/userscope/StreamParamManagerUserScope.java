package com.ss.lark.android.encryption.userscope;

import com.bytedance.lark.pb.basic.v1.Command;
import com.bytedance.lark.pb.security.v1.OpenOptions;
import com.bytedance.lark.pb.security.v1.OpenRequest;
import com.bytedance.lark.pb.security.v1.OpenResponse;
import com.bytedance.lark.pb.security.v1.SelfHelpContext;
import com.bytedance.lark.rustclient.api.l;
import com.bytedance.lark.rustclient.api.p;
import com.bytedance.lark.rustclient.api.s;
import com.bytedance.lark.rustclient.api.x;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.passportc.dwarf.UserScope;
import com.ss.android.lark.sdk.SdkSender;
import com.ss.lark.android.encryption.utils.SCMonitorKt;
import com.ss.lark.android.encryption.utils.c;
import ikc.f;
import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import jkc.d;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import okio.ByteString;

/* JADX INFO: loaded from: classes40.dex */
@UserScope
public final class StreamParamManagerUserScope implements d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final l f456811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ConcurrentHashMap<String, kkc.a> f456812b;

    @Inject
    public StreamParamManagerUserScope(l r100) {
        Intrinsics.checkNotNullParameter(r100, "userClient");
        this.f456811a = r100;
        this.f456812b = new ConcurrentHashMap();
    }

    @Override // jkc.d
    public final void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "path");
        this.f456812b.remove(r100);
    }

    @Override // jkc.d
    public final kkc.a c(final String r100) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "path");
        Log.i("ScsFileLock", "cacheDecryptParams: " + r100);
        return (kkc.a) c.a(this.f456812b, r100, new StreamParamManagerUserScope$cacheDecryptParams$1(this, r100));
    }

    @Override // jkc.d
    public final kkc.a b(final String r100, final boolean r101) throws IOException {
        Intrinsics.checkNotNullParameter(r100, "path");
        StringBuilder r102 = new StringBuilder("cacheEncryptParams: ");
        r102.append(r100);
        r102.append(", append: ");
        r102.append(!r101);
        Log.i("ScsFileLock", r102.toString());
        return (kkc.a) c.a(this.f456812b, r100, new StreamParamManagerUserScope$cacheEncryptParams$1(this, r100, r101));
    }

    public static kkc.a e(String r100, OpenResponse r101, ErrorResult r102) {
        SelfHelpContext r103 = r101.selfhelp_context;
        Integer r104 = r101.err_code;
        kkc.a r105 = new kkc.a();
        if (r104 != null) goto L6;
    L12:
        if (r104 != null) goto L15;
    L18:
        Intrinsics.checkNotNull(r104);
        com.ss.lark.android.encryption.utils.b.b(r100, r102, r104.intValue());
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

    public static final kkc.a d(StreamParamManagerUserScope r100, String r101, boolean r102, boolean r103) {
        r100.getClass();
        Log.i("ScsFileLock", "openFileInternal: " + r101 + ", encrypt: " + r102);
        f.f490295a.f490292a.a();
        SdkSender.d<OpenResponse> r104 = r100.f(r101, r102, r103, false);     // Catch: Exception -> L9
        OpenResponse r105 = r104.f439867a;     // Catch: Exception -> L9
        OpenResponse r106 = r105;     // Catch: Exception -> L9
        if (r105 != null) goto L6;
        com.ss.lark.android.encryption.utils.b.b(r101, new ErrorResult("rust response null"), -1);     // Catch: Exception -> L9
        throw new IOException("rust response null");     // Catch: Exception -> L9
    L6:
        return e(r101, r105, r104.f439868b);
    L9:
        e = move-exception;
        Log.e("ScsFileLock", "openFileInternal: error: " + e);
        throw new IOException(e);
    }

    /* JADX WARN: Type inference failed for: r0v14, types: [DATA, T] */
    public final SdkSender.d<OpenResponse> f(String r110, boolean r111, boolean r112, boolean r113) throws Exception {
        OpenOptions.Builder r100 = new OpenOptions.Builder();     // Catch: Exception -> L14
        Boolean r101 = Boolean.TRUE;     // Catch: Exception -> L14
        OpenOptions.Builder r102 = r100.create(r101).read(r101).write(r101).selfhelp_mode(r101).truncate(Boolean.valueOf(r112));     // Catch: Exception -> L14
        if (r111 == true) goto L5;
        r102.load_only(r101);     // Catch: Exception -> L14
    L5:
        OpenRequest.Builder r103 = new OpenRequest.Builder().options(r102.build()).path(r110);     // Catch: Exception -> L14
        l r104 = this.f456811a;     // Catch: Exception -> L14
        Intrinsics.checkNotNull(r103);     // Catch: Exception -> L14
        s r105 = r104.h(new com.bytedance.lark.rustclient.api.d(r103, OpenResponse.ADAPTER, Command.SECURITY_FILE_OPEN, null, null, null, null, 248)).execute();     // Catch: Exception -> L14
        if ((r105 instanceof com.bytedance.lark.rustclient.api.c) == false) goto L9;
        SdkSender.d<OpenResponse> r106 = new SdkSender.d();     // Catch: Exception -> L14
        r106.f439867a = null;     // Catch: Exception -> L14
        r106.f439868b = p.a(((com.bytedance.lark.rustclient.api.c) r105).f253907c);     // Catch: Exception -> L14
        return r106;
    L9:
        if ((r105 instanceof x) == false) goto L13;
        SdkSender.d<OpenResponse> r107 = new SdkSender.d();     // Catch: Exception -> L14
        r107.f439867a = ((x) r105).f253935c;     // Catch: Exception -> L14
        r107.f439868b = null;     // Catch: Exception -> L14
        return r107;
    L13:
        throw new NoWhenBranchMatchedException();     // Catch: Exception -> L14
    L14:
        e = move-exception;
        Log.e("ScsFileLock", "openFile: " + r110 + ", error: " + e + ", retry: " + r113);
        SCMonitorKt.a(r112, r111, e);
        com.ss.lark.android.encryption.utils.b.a(e);
        throw e;
    }
}
