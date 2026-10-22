package com.larus.bmhome.share.network;

import android.content.Context;
import android.view.View;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import com.larus.bmhome.share.ShareScene;
import com.larus.bmhome.share.api.IShareService;
import com.larus.bmhome.share.api.ShareServiceDelegate;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
import com.larus.network.http.ServiceType;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: classes26.dex */
public final class SharePanelShowHelper {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f313838d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f313839a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Deferred<BizResponse<SaveMessageShareInfo>> f313840b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Deferred<BizResponse<g>> f313841c;

    public static final class a {
    }

    public static final class b implements com.larus.bmhome.share.panel.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ boolean f313842a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ SharePanelShowHelper f313843b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ j f313844c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ com.larus.bmhome.share.panel.b f313845d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ Function1<i, Unit> f313846e;

        @Override // com.larus.bmhome.share.panel.d
        public final boolean d(String r100, String r101, Boolean r102) {
            return true;
        }

        @Override // com.larus.bmhome.share.panel.d
        public final void f() {
        }

        @Override // com.larus.bmhome.share.panel.d
        public final void onDismiss() {
        }

        @Override // com.larus.bmhome.share.panel.d
        public final void e(Function0<Unit> r100) {
            Intrinsics.checkNotNullParameter(r100, "callback");
        }

        @Override // com.larus.bmhome.share.panel.d
        public final boolean b(Context r110, DialogFragment r111, View r210, jr9.a r211) {
            Intrinsics.checkNotNullParameter(r211, "shareItemConfig");
            if (this.f313842a == false) goto L6;
            SharePanelShowHelper r100 = this.f313843b;
            j r101 = this.f313844c;
            com.larus.bmhome.share.panel.b r102 = this.f313845d;
            Function1<i, Unit> r103 = this.f313846e;
            BuildersKt.launch$default(r100.f313839a, null, null, new SharePanelShowHelper$interceptItemClickForCodePreviewShare$1(r100, r103, r211, r102, r111, r101, null), 3, null);
            return true;
        L6:
            SharePanelShowHelper r104 = this.f313843b;
            j r105 = this.f313844c;
            com.larus.bmhome.share.panel.b r106 = this.f313845d;
            Function1<i, Unit> r107 = this.f313846e;
            BuildersKt.launch$default(r104.f313839a, null, null, new SharePanelShowHelper$interceptItemClick$1(r104, r107, r211, r106, r111, r105, null), 3, null);
            return true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(boolean r100, SharePanelShowHelper r101, j r102, com.larus.bmhome.share.panel.b r103, Function1<? super i, Unit> r104) {
            this.f313842a = r100;
            this.f313843b = r101;
            this.f313844c = r102;
            this.f313845d = r103;
            this.f313846e = r104;
        }
    }

    static {
    }

    public SharePanelShowHelper(CoroutineScope r100) {
        Intrinsics.checkNotNullParameter(r100, "lifecycleScope");
        this.f313839a = r100;
    }

    public static final Object a(SharePanelShowHelper r110, h r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof SharePanelShowHelper$doRequestCodePreviewShareApi$1) == false) goto L7;
        SharePanelShowHelper$doRequestCodePreviewShareApi$1 r100 = (SharePanelShowHelper$doRequestCodePreviewShareApi$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        SharePanelShowHelper$doRequestCodePreviewShareApi$1 r102 = r100;
        Object r113 = r102.result;
        Object r114 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r102.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        ResultKt.throwOnFailure(r113);
    L17:
        dm9.a r115 = (dm9.a) r113;
        if ((r115 instanceof dm9.a.b) == false) goto L22;
        Object r116 = ((dm9.a.b) r115).f469231a;
    L24:
        return r116;
    L22:
        if ((r115 instanceof dm9.a.C5690a) == false) goto L26;
        FLogger.f375446a.i("SharePanelShowHelper", String.valueOf(((dm9.a.C5690a) r115).f469230c));
        r116 = new BizResponse(-1, null, null, null, 14, null);
        goto L24
    L26:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r113);
        ShareCodePreviewApi.a r117 = ShareCodePreviewApi.f313836a;
        SharePanelShowHelper$doRequestCodePreviewShareApi$result$1 r104 = new SharePanelShowHelper$doRequestCodePreviewShareApi$result$1(r111, null);
        r102.label = 1;
        r117.getClass();
        FlowHttpConnection r118 = FlowHttpConnection.f359975a;
        r113 = FlowHttpConnection.g(ServiceType.BASIC_SERVICE, ShareCodePreviewApi.class, r104, false, null, null, null, r102, 248);
        if (r113 != r114) goto L17;
        return r114;
    L7:
        r100 = new SharePanelShowHelper$doRequestCodePreviewShareApi$1(r110, r112);
        goto L8
    }

    public static final Object b(SharePanelShowHelper r110, String r111, String r112, Continuation r113) {
        r110.getClass();
        if ((r113 instanceof SharePanelShowHelper$doRequestMessageShareApi$1) == false) goto L7;
        SharePanelShowHelper$doRequestMessageShareApi$1 r100 = (SharePanelShowHelper$doRequestMessageShareApi$1) r113;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        ResultKt.throwOnFailure(r102);
    L28:
        dm9.a r105 = (dm9.a) r102;
        if ((r105 instanceof dm9.a.b) == false) goto L32;
        Object r106 = ((dm9.a.b) r105).f469231a;
    L38:
        return r106;
    L32:
        if ((r105 instanceof dm9.a.C5690a) == false) goto L35;
        FLogger.f375446a.i("SharePanelShowHelper", String.valueOf(((dm9.a.C5690a) r105).f469230c));
        r106 = new BizResponse(-1, null, null, null, 14, null);
        goto L38
    L35:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        if (r111.length() != 0) goto L17;
        boolean r107 = true;
    L18:
        if (r107 == false) goto L20;
    L36:
        r106 = new BizResponse(-1, null, null, new SaveMessageShareInfo(null, null, null, null, null, 31, null), 6, null);
        goto L38
    L20:
        if (r112.length() != 0) goto L22;
        boolean r108 = true;
    L23:
        if (r108 == true) goto L36;
        MessageShareApi.Companion r109 = MessageShareApi.f313833a;
        f r114 = new f(r111, CollectionsKt.listOf(r112), Boxing.boxBoolean(z2.f365865a.getShareConfig().g()), Boxing.boxBoolean(false), null, 16);
        r100.label = 1;
        r109.getClass();
        r102 = MessageShareApi.Companion.a(r114, r100);
        if (r102 != r103) goto L28;
        return r103;
    L22:
        r108 = false;
        goto L23
    L17:
        r107 = false;
    L7:
        r100 = new SharePanelShowHelper$doRequestMessageShareApi$1(r110, r113);
        goto L8
    }

    public final void c(FragmentActivity r210, j r211, ShareScene r212, com.larus.bmhome.share.panel.h r213, com.larus.bmhome.share.panel.b r214, String r215, String r216, by7.e r217, boolean r218, h r219, Function1<? super i, Unit> r310) {
        Intrinsics.checkNotNullParameter(r210, "activity");
        Intrinsics.checkNotNullParameter(r211, "loadingAbility");
        Intrinsics.checkNotNullParameter(r212, "shareScene");
        Intrinsics.checkNotNullParameter(r213, "eventParam");
        Intrinsics.checkNotNullParameter(r214, "shareContent");
        Intrinsics.checkNotNullParameter(r215, "conversationId");
        Intrinsics.checkNotNullParameter(r216, "messageId");
        Intrinsics.checkNotNullParameter(r217, "node");
        Intrinsics.checkNotNullParameter(r310, "continueShareCallback");
        if (r219 == null) goto L5;
        boolean r100 = true;
    L6:
        IShareService.a.g(ShareServiceDelegate.f313831b, r210, r212, r214, r213, new b(r100, this, r211, r214, r310), r217, r218, 128);
        if (r219 == null) goto L10;
        BuildersKt.launch$default(this.f313839a, null, null, new SharePanelShowHelper$tryShowSharePanel$2$1(this, r219, null), 3, null);
        return;
    L10:
        BuildersKt.launch$default(this.f313839a, null, null, new SharePanelShowHelper$tryShowSharePanel$3(this, r215, r216, null), 3, null);
        return;
    L5:
        r100 = false;
        goto L6
    }
}
