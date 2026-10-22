package wia;

import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import com.obric.capabilitykit.ErrorCodeCallback;
import com.obric.capabilitykit.TaskStateChangeCallback;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.IMAppAction;
import com.obric.capabilitykit.common.TaskStateInfo;
import com.obric.capabilitykit.common.execution.fileaccess.IUriFileReceiver;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.obric.capabilitykit.logger.Logger;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class q implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final q f559889a = null;

    static {
        f559889a = new q();
    }

    public q() {
    }

    @Override // wia.n
    public final void a(long r100) {
        Logger.INSTANCE.w("EmptyCapabilityManager", "hideIntentResultCard");
    }

    @Override // wia.n
    public final void a(String r100, TaskStateInfo r101, TaskStateChangeCallback r102, Long r103) {
        Intrinsics.checkNotNullParameter(r100, "id");
        Intrinsics.checkNotNullParameter(r101, "stateInfo");
        Logger.INSTANCE.w("EmptyCapabilityManager", "requestStateChanged");
    }

    @Override // wia.n
    public final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "implClassName");
        Logger.INSTANCE.w("EmptyCapabilityManager", "unregisterIntent");
    }

    @Override // wia.n
    public final void a(String r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "implClassName");
        Logger.INSTANCE.w("EmptyCapabilityManager", "registerIntent");
    }

    @Override // wia.n
    public final boolean a() {
        Logger.INSTANCE.w("EmptyCapabilityManager", "isKeyguardReallyLocked");
        return true;
    }

    @Override // wia.n
    public final void b(long r100) {
        Logger.INSTANCE.w("EmptyCapabilityManager", "finishFloatingActivity");
    }

    @Override // wia.n
    public final void b(IMAppAction r100) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Logger.INSTANCE.w("EmptyCapabilityManager", "sendActionExecuteResult");
    }

    @Override // wia.n
    public final Boolean c(long r100) {
        Logger.INSTANCE.w("EmptyCapabilityManager", "isCardViewVisible");
        return null;
    }

    @Override // wia.n
    public final void c(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "packageName");
        Logger.INSTANCE.w("EmptyCapabilityManager", "stopUriFileAccess");
    }

    @Override // wia.n
    public final void d(Uri r100, String r101, IUriFileReceiver r102) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter(r101, "packageName");
        Intrinsics.checkNotNullParameter(r102, "requester");
        Logger.INSTANCE.w("EmptyCapabilityManager", "requestUriFileAccess");
    }

    @Override // wia.n
    public final PendingIntent e(long r100, Intent r101, FloatingIntentParams r102) {
        Intrinsics.checkNotNullParameter(r101, "intent");
        Intrinsics.checkNotNullParameter(r102, "params");
        Logger.INSTANCE.w("EmptyCapabilityManager", "getFloatingPendingIntent");
        return null;
    }

    @Override // wia.n
    public final void f(IntentResult<?> r100, long r101, boolean r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "result");
        Logger.INSTANCE.w("EmptyCapabilityManager", "updateIntentResult");
    }

    @Override // wia.n
    public final void g(ErrorCodeCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Logger.INSTANCE.w("EmptyCapabilityManager", "registerResultCallback");
    }

    @Override // wia.n
    public final void h(ErrorCodeCallback r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        Logger.INSTANCE.w("EmptyCapabilityManager", "unregisterResultCallback");
    }

    @Override // wia.n
    public final void i(IntentResult<?> r100, IMAppAction r101) {
        Intrinsics.checkNotNullParameter(r100, "intentResult");
        Intrinsics.checkNotNullParameter(r101, "oldResult");
        Logger.INSTANCE.w("EmptyCapabilityManager", "sendActionExecuteResult");
    }
}
