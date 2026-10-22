package com.larus.aweme.impl.video;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.bytedance.router.SmartRouter;
import com.bytedance.router.i;
import com.larus.aweme.api.video.service.AwemeVideoFeedDelegate;
import com.larus.aweme.impl.main_bot.e;
import com.larus.bmhome.chat.require.IMainBotService;
import com.larus.minor.api.IMinorService;
import com.ss.android.lark.utils.statistics.PerfLog;
import ic8.l0;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016¨\u0006\u000f"}, d2 = {"Lcom/larus/aweme/impl/video/MainBotServiceImpl;", "Lcom/larus/bmhome/chat/require/IMainBotService;", "<init>", "()V", "openMainBot", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "param", "Lcom/larus/bmhome/chat/require/IMainBotService$MainBotParam;", "isEnableDouYinSdk", "", "getSearchSceneId", "", "isEnableDouyinFeedCocoEntrance", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainBotServiceImpl implements IMainBotService {
    public MainBotServiceImpl() {
    }

    @Override // com.larus.bmhome.chat.require.IMainBotService
    public final String a() {
        return AwemeVideoFeedDelegate.f294745b.a();
    }

    @Override // com.larus.bmhome.chat.require.IMainBotService
    public final boolean b() {
        return AwemeVideoFeedDelegate.f294745b.b();
    }

    @Override // com.larus.bmhome.chat.require.IMainBotService
    public final void c(Context r100, IMainBotService.a r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "param");
        int r102 = e.f294808a;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Intrinsics.checkNotNullParameter(r101, "param");
        if (IMinorService.f359156a.a() == false) goto L11;
        i r103 = SmartRouter.buildRoute(r100, "//flow/chat_page");
        Bundle r104 = r101.f308537a;
        r104.putInt("argBotConversationType", 1);
        r103.f267554c.putExtras(r104);
        int r105 = r101.f308541e;
        int r106 = r101.f308542f;
        r103.f267555d = r105;
        r103.f267556e = r106;
        r103.f267554c.addFlags(268468224);
        r103.d();
        if ((r100 instanceof Activity) == false) goto L7;
        Activity r107 = (Activity) r100;
    L8:
        if (r107 == null) goto L20;
        r107.finish();
        return;
    L20:
        return;
    L7:
        r107 = null;
        goto L8
    L11:
        if (l0.a(r101.f308539c) == false) goto L13;
        i r108 = SmartRouter.buildRoute(r100, "//flow/chat_multi_tab");
        Bundle r109 = r101.f308537a;
        ArrayList<Integer> r110 = new ArrayList();
        r110.addAll(r101.f308539c);
        Unit r111 = Unit.INSTANCE;
        r109.putIntegerArrayList("argument_multi_tab_list", r110);
        r109.putInt("argument_multi_tab_default_tab", r101.f308538b);
        r109.putInt("argument_multi_tab_title_style", r101.f308540d);
        r108.f267554c.putExtras(r109);
        int r112 = r101.f308541e;
        int r113 = r101.f308542f;
        r108.f267555d = r112;
        r108.f267556e = r113;
        r108.d();
        return;
    L13:
        i r114 = SmartRouter.buildRoute(r100, "//flow/chat_page");
        Bundle r115 = r101.f308537a;
        r115.putInt("argBotConversationType", 1);
        r114.f267554c.putExtras(r115);
        int r116 = r101.f308541e;
        int r117 = r101.f308542f;
        r114.f267555d = r116;
        r114.f267556e = r117;
        if (Intrinsics.areEqual(r101.f308537a.getString("is_side_bar"), "1") == false) goto L18;
        Integer r118 = r101.f308543g;
        if (r118 == null) goto L18;
        r114.a(r118.intValue());
    L18:
        r114.d();
    }
}
