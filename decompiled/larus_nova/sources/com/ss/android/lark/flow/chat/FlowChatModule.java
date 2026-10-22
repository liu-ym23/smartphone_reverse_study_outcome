package com.ss.android.lark.flow.chat;

import a2b.f;
import android.content.Context;
import androidx.fragment.app.Fragment;
import com.bytedance.lark.pb.basic.v1.SyncDataStrategy;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larksuite.framework.callback.UIGetDataCallback;
import com.larksuite.framework.utils.KeyboardUtils;
import com.ss.android.lark.biz.im.api.bundle.ChatBundle;
import com.ss.android.lark.biz.im.api.bundle.v2.base.input.ChatBundleInput;
import com.ss.android.lark.biz.im.api.l1;
import com.ss.android.lark.chat.chatwindow.chat.v2.push.ChatAppContainerV1;
import com.ss.android.lark.chat.entity.preview.UrlPreViewEntries;
import com.ss.android.lark.chat.utils.UserStatusParseUrlPreViewUtils;
import com.ss.android.lark.chat.utils.UserStatusParseUrlPreViewUtils$getRecogniseSpansResult$1;
import com.ss.android.lark.chat.utils.o1;
import com.ss.android.lark.chatwindow.launcher.c;
import com.ss.android.lark.flow.group.page.FlowQRCodeGroupCardActivity$onCreate$1$onJoinGroupButtonClick$1$joinGroupChatSuccess$1;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.officesdk.manager.OfficeSDKManager;
import com.ss.android.lark.statistics.chat.ChatHitPointExtraParams$UrlAnalysisScene;
import com.ss.android.lark.utils.LarkContext;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.span.RecogniseSpansResult;
import com.ss.android.lark.widget.span.f0;
import dagger.hilt.android.EntryPointAccessors;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import whb.d;

/* JADX INFO: loaded from: classes36.dex */
public final class FlowChatModule {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f422022d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f422023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Inject
    public uza.a f422024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f422025c;

    public static final class a {
        public static FlowChatModule a() {
            return ((b) EntryPointAccessors.fromApplication(LarkContext.getApplication(), b.class)).k();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0006À\u0006\u0001"}, d2 = {"Lcom/ss/android/lark/flow/chat/FlowChatModule$FlowChatModuleEntryPoint;", "", "flowChatModule", "Lcom/ss/android/lark/flow/chat/FlowChatModule;", "getFlowChatModule", "()Lcom/ss/android/lark/flow/chat/FlowChatModule;", "flow-chat_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface b {
        FlowChatModule k();
    }

    static {
    }

    public final egb.b a() {
        return (egb.b) this.f422025c.getValue();
    }

    @Inject
    public FlowChatModule(c r100) {
        Intrinsics.checkNotNullParameter(r100, "chatLauncherV2");
        this.f422023a = r100;
        this.f422025c = LazyKt.lazy(FlowChatModule$dependency$2.INSTANCE);
    }

    public static boolean c(String r100) {
        if (r100 == null) goto L12;
        gza.b r101 = (gza.b) OfficeSDKManager.getHostGlobalService(gza.b.class);
        if (r101 != null) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L12;
        return true;
    L7:
        if (r101.k0(r100) != true) goto L9;
        r102 = true;
    L12:
        return false;
    }

    public static void g(Context r100, l1 r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bundle");
        KeyboardUtils.hideKeyboard(r100);
        if (r101.B == true) goto L5;
    L7:
        d.a(r100, r101);
        return;
    L5:
        if (c(r101.f410268a) == false) goto L7;
    }

    public final void e(Context r100, ChatBundle r101, IGetDataCallback<Unit> r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "chatBundle");
        KeyboardUtils.hideKeyboard(r100);
        if (r101.G == true) goto L5;
    L7:
        c r103 = this.f422023a;
        int r104 = ChatBundleInput.f409974j;
        r103.U7(r100, null, ChatBundleInput.Companion.a(r101), r102);
        return;
    L5:
        if (c(r101.f409908a) == false) goto L7;
    }

    public final void f(Context r100, String r101, FlowQRCodeGroupCardActivity$onCreate$1$onJoinGroupButtonClick$1$joinGroupChatSuccess$1 r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "chatId");
        KeyboardUtils.hideKeyboard(r100);
        this.f422023a.U7(r100, null, com.ss.android.lark.biz.im.api.bundle.v2.base.input.a.a(r101), r102);
    }

    public final void d(Context r100, Fragment r101, ChatBundle r102, IGetDataCallback<Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r102, "chatBundle");
        KeyboardUtils.hideKeyboard(r100);
        c r104 = this.f422023a;
        int r105 = ChatBundleInput.f409974j;
        r104.U7(r100, r101, ChatBundleInput.Companion.a(r102), r103);
    }

    public static void b(final String r110, final String r111, SyncDataStrategy r112, final ChatHitPointExtraParams$UrlAnalysisScene r113, final Long r210, final hpc.a r211) {
        Intrinsics.checkNotNullParameter(r112, "syncDataStrategy");
        Intrinsics.checkNotNullParameter(r211, "callBack");
        f r100 = ChatAppContainerV1.f414510a.P();
        int r101 = UserStatusParseUrlPreViewUtils.f416638a;
        Intrinsics.checkNotNullParameter(r100, "previewService");
        Intrinsics.checkNotNullParameter(r112, "syncDataStrategy");
        Intrinsics.checkNotNullParameter(r211, "callback");
        boolean r102 = true;
        if (r111 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == false) goto L11;
        Log.i("[URLPreview]UserStatusParseUtils", "userID is null, abnormal data ");
        return;
    L11:
        if (r110 != null) goto L13;
    L16:
        boolean r104 = true;
    L17:
        if (r104 == false) goto L19;
    L35:
        Log.i("[URLPreview]UserStatusParseUtils", "personal sign is null or not contains http,request return");
        f0 r105 = f0.a.f448675a;
        String r106 = r111 + UrlPreViewEntries.UrlPreViewSourceType.PERSONAL_SIG.getValue();
        monitor-enter(r105);
    L44:
        th = move-exception;
        throw th;
    L38:
        if (r106.isEmpty() == false) goto L41;
        monitor-exit(r105);
        return;
    L41:
        RecogniseSpansResult r107 = r105.f448674a.remove(Integer.valueOf(r106.hashCode()));     // Catch: Throwable -> L44
        monitor-exit(r105);
        return;
    L19:
        if (StringsKt.contains$default(r110, "http", false, 2, null) == false) goto L35;
        long r108 = System.currentTimeMillis();
        ConcurrentHashMap<Integer, Long> r114 = o1.f416713a;
        o1.d(r111, Long.valueOf(r108));
        final String r109 = new String(w28.a.a(x28.a.a(r110)));
        if (r210 != null) goto L24;
    L26:
        r102 = false;
    L27:
        if (r102 == false) goto L29;
        UrlPreViewEntries.UrlPreViewSourceType r115 = UrlPreViewEntries.UrlPreViewSourceType.PRIVATE_DESCRIPTION;
    L30:
        UrlPreViewEntries.UrlPreViewSourceType r116 = r115;
        if (r102 == false) goto L33;
        List<Long> r117 = CollectionsKt.listOf(r210);
    L34:
        r100.r4(CollectionsKt.listOf(r111), CollectionsKt.listOf(r109), r112, r116, r117, new UIGetDataCallback(new UserStatusParseUrlPreViewUtils$getRecogniseSpansResult$1(r110, r111, r109, r210, r113, r211)));
        return;
    L33:
        r117 = null;
        goto L34
    L29:
        r115 = UrlPreViewEntries.UrlPreViewSourceType.PERSONAL_SIG;
        goto L30
    L24:
        if (r210.longValue() <= 0) goto L26;
    L13:
        if (r110.length() == 0) goto L16;
        r104 = false;
        goto L17
    L5:
        if (r111.length() == 0) goto L8;
        r103 = false;
        goto L9
    }
}
