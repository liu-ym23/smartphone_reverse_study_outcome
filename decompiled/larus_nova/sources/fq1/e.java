package fq1;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.annie.api.container.HybridDialog;
import com.bytedance.android.annie.api.container.HybridFragment;
import com.bytedance.android.live.core.tetris.widgets.VSRecyclableWidgetManager;
import com.bytedance.android.livesdkapi.hybridapi.BaseJsBridgeMethodFactory;
import com.ss.android.lark.utils.statistics.PerfLog;
import io.reactivex.Observable;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes8.dex */
public final class e implements com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c, com.bytedance.android.scope.o {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c f478402a;

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final DialogFragment a(Context r100, Uri r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        return this.f478402a.a(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final String appendCommonParams(String r100) {
        Intrinsics.checkNotNullParameter(r100, "url");
        return this.f478402a.appendCommonParams(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final void c(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("https://www.cac.gov.cn/2017-08/25/c_1121541842.htm", "url");
        this.f478402a.c(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final Uri d(Uri r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        Intrinsics.checkNotNullParameter("url", "key");
        Intrinsics.checkNotNullParameter(r101, "value");
        return this.f478402a.d(r100, r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final void dismissAllWebDialogs(Activity r100) {
        this.f478402a.dismissAllWebDialogs(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final void f(VSRecyclableWidgetManager r100) {
        this.f478402a.f(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final HybridCard getHybridCard(Context r100, Uri r101, b7.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        return this.f478402a.getHybridCard(r100, r101, r102);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final HybridFragment getHybridFragment(Context r100, Uri r101, b7.a r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        return this.f478402a.getHybridFragment(r100, r101, r102);
    }

    @Override // com.bytedance.android.scope.o
    public final void onStart() {
    }

    @Override // com.bytedance.android.scope.o
    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final Observable<Unit> registerExternalMethodFactory(BaseJsBridgeMethodFactory r100) {
        Intrinsics.checkNotNullParameter(r100, "factory");
        return this.f478402a.registerExternalMethodFactory(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final Observable<Pair<String, Map<String, Object>>> registerJsEventSubscriber(String r100) {
        Intrinsics.checkNotNullParameter(r100, "eventName");
        return this.f478402a.registerJsEventSubscriber(r100);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final void sendJsEvent(String r100, JSONObject r101) {
        Intrinsics.checkNotNullParameter("ticket_unpaid", "eventName");
        Intrinsics.checkNotNullParameter(r101, "param");
        this.f478402a.sendJsEvent("ticket_unpaid", r101);
    }

    @Override // com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c
    public final HybridDialog showHybridDialog(Context r100, Uri r101, b7.a r102, Bundle r110, DialogInterface.OnDismissListener r111) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "uri");
        return this.f478402a.showHybridDialog(r100, r101, r102, null, r111);
    }

    public e(com.bytedance.android.livesdk.chatroom.vs_inject_api.service.inject.foundation.c r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridService");
        this.f478402a = r100;
    }
}
