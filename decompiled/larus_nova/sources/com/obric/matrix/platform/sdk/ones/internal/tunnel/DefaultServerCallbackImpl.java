package com.obric.matrix.platform.sdk.ones.internal.tunnel;

import android.util.Log;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.obric.matrix.platform.server.IServerCallback;
import com.obric.matrix.proto.Response;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Iterator;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\f"}, d2 = {"Lcom/obric/matrix/platform/sdk/ones/internal/tunnel/DefaultServerCallbackImpl;", "Lcom/obric/matrix/platform/server/IServerCallback$Stub;", "", "cmd", "", HTTP.CONTENT_RANGE_BYTES, "", "onResult", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "sdk_platform_ones_release"}, k = 1, mv = {1, 6, 0})
public final class DefaultServerCallbackImpl extends IServerCallback.Stub {
    public static final a Companion = null;
    private static final String TAG = "DefaultServerCallbackImpl";

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public DefaultServerCallbackImpl() {
    }

    @Override // com.obric.matrix.platform.server.IServerCallback
    public void onResult(int r100, byte[] r101) {
        gka.b.a(TAG, "onResult(cmd: " + r100 + ", bytes: " + r101 + ").");
        Iterator<b> r102 = e.f397001d.iterator();
    L4:
        if (r102.hasNext() == false) goto L16;
        b r103 = r102.next();
        gka.b.a(TAG, "notification start");     // Catch: Exception -> L14
        if (r101 == null) goto L9;
        boolean r104 = true;
    L10:
        if (r104 == true) goto L11;
        throw new IllegalStateException("result bytes is null".toString());     // Catch: Exception -> L14
    L11:
        Response r105 = Response.ADAPTER.decode(r101);     // Catch: Exception -> L14
        r103.a();     // Catch: Exception -> L14
        goto L4
    L9:
        r104 = false;
    L14:
        e = move-exception;
        gka.b.a(TAG, "on notification exception " + Log.getStackTraceString(e));
        goto L4
    }
}
