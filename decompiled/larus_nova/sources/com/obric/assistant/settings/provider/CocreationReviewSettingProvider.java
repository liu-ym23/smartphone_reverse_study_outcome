package com.obric.assistant.settings.provider;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.cocreationreview.IObricCocreationReviewService;
import com.obric.assistant.settings.spi.IObricSettingProvider;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002¨\u0006\u0016"}, d2 = {"Lcom/obric/assistant/settings/provider/CocreationReviewSettingProvider;", "Lcom/obric/assistant/settings/spi/IObricSettingProvider;", "<init>", "()V", "getSettingGroups", "", "Lcom/obric/assistant/settings/spi/ObricSettingGroup;", "host", "Lcom/obric/assistant/settings/spi/IObricSettingHost;", "getSettingItems", "Lcom/obric/assistant/settings/spi/ObricSettingItem;", "(Lcom/obric/assistant/settings/spi/IObricSettingHost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isCocreationReviewEntryEnabled", "", "startCocreationReview", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "showJumpFailedToast", "activity", "Landroid/app/Activity;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CocreationReviewSettingProvider implements IObricSettingProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f392253a = 0;

    public static final class a {
    }

    static {
    }

    public CocreationReviewSettingProvider() {
    }

    public static void c(Activity r100) {
        if (r100 != null) goto L4;
        gd9.i r101 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r101);
        r100 = r101.a().e();
    L4:
        if (r100 == null) goto L7;
        Handler r102 = com.obric.oui.toast.f.f403695n;
        com.obric.oui.toast.f.a.a(r100, r100.getString(R.string.obric_block_jump_url_failed));
        return;
    }

    public static void d(Context r100) {
        Activity r101 = null;
        if ((r100 instanceof Activity) == false) goto L5;
        Activity r102 = (Activity) r100;
    L6:
        if (r102 == null) goto L8;
    L7:
        r100 = r102;
    L11:
        IObricCocreationReviewService.f387144a.getClass();
        IObricCocreationReviewService r103 = (IObricCocreationReviewService) ServiceManager.get().getService(IObricCocreationReviewService.class, false, false);
        if (r103 != null) goto L18;
        FLogger.f375446a.e("CocreationReviewSettingProvider", "Cocreation review service is unavailable");
        if ((r100 instanceof Activity) == false) goto L16;
        r101 = (Activity) r100;
    L16:
        c(r101);
        return;
    L18:
        r103.a(r100);
        return;
    L8:
        gd9.i r104 = com.larus.im.b.f346407a;
        Intrinsics.checkNotNull(r104);
        r102 = r104.a().e();
        if (r102 == null) goto L11;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final List<com.obric.assistant.settings.spi.c> a(com.obric.assistant.settings.spi.b r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        if (r100.getHostContext() != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (Build.VERSION.SDK_INT < 23) goto L9;
        com.obric.assistant.settings.h.f392071a.getClass();
        if (com.obric.assistant.settings.h.a().f392075a == true) goto L15;
        return CollectionsKt.emptyList();
    L15:
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.c("group_cocreation_review"));
    L9:
        return CollectionsKt.emptyList();
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final Object b(com.obric.assistant.settings.spi.b r110, Continuation<? super List<? extends com.obric.assistant.settings.spi.e>> r111) {
        final Context r100 = r110.getHostContext();
        if (r100 != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        return CollectionsKt.emptyList();
    L11:
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.a("group_cocreation_review", "cocreation_review", r100.getString(R.string.obric_setting_cocreation_review), 100, new n(this), new o(r100), null, new CocreationReviewSettingProvider$getSettingItems$4(this, null), null, true, null, null, 6976));
    }
}
