package com.larus.api.serviceimpl;

import android.app.Activity;
import com.bytedance.awemeopen.share.serviceapi.AoSharePanelService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import n48.e;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0084\u0001\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u001426\u0010\u0015\u001a2\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0013\u0012\u00110\u001b¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00070\u0016H\u0016J \u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0014H\u0002¨\u0006\""}, d2 = {"Lcom/larus/api/serviceimpl/AoSharePanelServiceImpl;", "Lcom/bytedance/awemeopen/share/serviceapi/AoSharePanelService;", "<init>", "()V", "isSharePanelAvailable", "", "showSharePanel", "", "activity", "Landroid/app/Activity;", "aid", "", "shareTitle", "", "shareDesc", "shareUrl", "coverUrl", "shareHelper", "Lcom/bytedance/awemeopen/share/serviceapi/IAoShareHelper;", "eventParams", "Lorg/json/JSONObject;", "dismissCallback", "Lkotlin/Function2;", "Lcom/bytedance/awemeopen/share/serviceapi/AoShareResult;", "Lkotlin/ParameterName;", "name", "result", "Lcom/bytedance/awemeopen/share/serviceapi/AoShareChannel;", "channel", "replaceItemKey", "key", "newKey", "params", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AoSharePanelServiceImpl implements AoSharePanelService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f286932a = 0;

    /* JADX INFO: loaded from: classes3.dex */
    public static final class a {
    }

    static {
    }

    public AoSharePanelServiceImpl() {
    }

    @Override // com.bytedance.awemeopen.share.serviceapi.AoSharePanelService
    public final boolean l() {
        return z2.f365865a.getShareConfig().q();
    }

    public static void E2(String r100, String r101, JSONObject r102) {
        Object r103 = r102.get(r100);     // Catch: Exception -> L4
        r102.remove(r100);     // Catch: Exception -> L4
        r102.put(r101, r103);     // Catch: Exception -> L4
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v8, types: [n48.e] */
    @Override // com.bytedance.awemeopen.share.serviceapi.AoSharePanelService
    public final void Z1(final Activity r110, final String r111, final String r112, final String r113, final String r114, com.bytedance.awemeopen.domain.share.a r115, final JSONObject r116, Function2 r117) {
        Intrinsics.checkNotNullParameter(r110, "activity");
        Intrinsics.checkNotNullParameter(r111, "shareTitle");
        Intrinsics.checkNotNullParameter(r112, "shareDesc");
        Intrinsics.checkNotNullParameter(r113, "shareUrl");
        Intrinsics.checkNotNullParameter(r115, "shareHelper");
        Intrinsics.checkNotNullParameter(r117, "dismissCallback");
        FLogger.f375446a.i("AoSharePanelServiceImpl", "showSharePanel");
        r115.a(new e(r110, r113, r114, r111, r112, r116, this));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("AoSharePanelServiceImpl", "showSharePanel error: " + e);
    }
}
