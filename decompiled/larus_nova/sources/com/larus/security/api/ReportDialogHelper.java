package com.larus.security.api;

import android.content.ClipData;
import android.content.Context;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.larus.bmhome.share.network.MessageShareApi;
import com.larus.bmhome.share.network.SaveMessageShareInfo;
import com.larus.common_ui.dialog.CommonDialog;
import com.larus.common_ui.dialog.f0;
import com.larus.home.impl.sdk.i1;
import com.larus.im.bean.message.Message;
import com.larus.im.callback.IIMCallback;
import com.larus.im.callback.IIMError;
import com.larus.network.bean.BizResponse;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.z2;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import t19.s;

/* JADX INFO: loaded from: classes31.dex */
public final class ReportDialogHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ReportDialogHelper f367840a = null;

    public static final class a<T> implements Comparator {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((Message) r100).getLocalIndex()), Long.valueOf(((Message) r101).getLocalIndex()));
        }
    }

    public static final class b implements IIMCallback<Message> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f367841a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ String f367842b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f367843c;

        @Override // com.larus.im.callback.IIMCallback
        public final boolean mustInMain() {
            return true;
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onFailure(IIMError r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
        }

        @Override // com.larus.im.callback.IIMCallback
        public final void onSuccess(Message r100) {
            Message r101 = r100;
            Intrinsics.checkNotNullParameter(r101, "result");
            ReportDialogHelper.d(ReportDialogHelper.f367840a, this.f367841a, CollectionsKt.listOf(r101), this.f367842b, null, this.f367843c, 8);
        }

        public b(FragmentActivity r100, String r101, Function0<Unit> r102) {
            this.f367841a = r100;
            this.f367842b = r101;
            this.f367843c = r102;
        }
    }

    static {
        f367840a = new ReportDialogHelper();
    }

    public ReportDialogHelper() {
    }

    public final Object b(List<Message> r210, Continuation<? super BizResponse<SaveMessageShareInfo>> r211) {
        if ((r211 instanceof ReportDialogHelper$doRequestMessageShareApi$1) == false) goto L7;
        ReportDialogHelper$doRequestMessageShareApi$1 r100 = (ReportDialogHelper$doRequestMessageShareApi$1) r211;
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
        return ((dm9.a.b) r105).f469231a;
    L32:
        if ((r105 instanceof dm9.a.C5690a) == false) goto L36;
        FLogger.f375446a.i("ReportDialogHelper", String.valueOf(((dm9.a.C5690a) r105).f469230c));
        return new BizResponse(-1, null, null, null, 14, null);
    L36:
        throw new NoWhenBranchMatchedException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r102);
        List r106 = CollectionsKt.sortedWith(r210, new a());
        List r107 = r106;
        ArrayList r108 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r107, 10));
        Iterator r109 = r107.iterator();
    L16:
        if (r109.hasNext() == false) goto L22;
        String r110 = ((Message) r109.next()).getMessageId();
        if (r110 != null) goto L20;
        r110 = "";
    L20:
        r108.add(r110);
        goto L16
    L22:
        if (r106.isEmpty() == true) goto L24;
        String r111 = ((Message) CollectionsKt.last(r106)).getConversationId();
        MessageShareApi.Companion r112 = MessageShareApi.f313833a;
        com.larus.bmhome.share.network.f r113 = new com.larus.bmhome.share.network.f(r111, r108, Boxing.boxBoolean(z2.f365865a.getShareConfig().g()), Boxing.boxBoolean(false), null, 16);
        r100.label = 1;
        r112.getClass();
        r102 = MessageShareApi.Companion.a(r113, r100);
        if (r102 != r103) goto L28;
        return r103;
    L24:
        return new BizResponse(-1, null, null, new SaveMessageShareInfo(null, null, null, null, null, 31, null), 6, null);
    L7:
        r100 = new ReportDialogHelper$doRequestMessageShareApi$1(this, r211);
        goto L8
    }

    public static void a(Context r100, String r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        StringBuilder r103 = new StringBuilder("");
        if (o0.d(r101) == false) goto L6;
        r103.append(r100.getString(R.string.larus_feedback_share_report_copy_messages));
        r103.append("：" + r101 + '\n');
    L6:
        if (o0.d(r102) == false) goto L8;
        r103.append(r100.getString(R.string.larus_feedback_share_report_copy_logID));
        r103.append("：" + r102);
    L8:
        String r104 = r103.toString();
        if (StringsKt.isBlank(r104) == false) goto L12;
        s r105 = s.f544207a;
        String r106 = r100.getString(R.string.larus_aiDoc_copyFailed_errorMsg);
        r105.getClass();
        s.t(r100, r106);
        return;
    L12:
        ClipData r107 = ClipData.newPlainText("text", r104);
        IFlowSdkDepend r108 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
        if (r108 == null) goto L15;
        r108.d0();
        i1 r109 = i1.f346188a;
        Intrinsics.checkNotNull(r107);
        r109.i(r100, r107, "bpea-user-report-message");
    L15:
        s r110 = s.f544207a;
        String r111 = r100.getString(R.string.larus_feedback_submit_toast_copied);
        r110.getClass();
        s.p(r100, r111);
    }

    public static void c(FragmentActivity r100, String r101, String r102, Function0 r103) {
        Intrinsics.checkNotNullParameter(r103, "confirmUnit");
        if (r101 != null) goto L5;
    L8:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L11;
        return;
    L11:
        com.larus.im.d.e().m(r101, new b(r100, r102, r103));
        return;
    L5:
        if (r101.length() == 0) goto L8;
        r104 = false;
        goto L9
    }

    public static void d(ReportDialogHelper r100, final FragmentActivity r101, final List r102, final String r103, final List r104, final Function0 r105, int r106) {
        if ((r106 & 4) == 0) goto L6;
        r103 = null;
    L6:
        if ((r106 & 8) == 0) goto L8;
        r104 = r102;
    L8:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r102, "msgList");
        Intrinsics.checkNotNullParameter(r104, "shareMsgList");
        Intrinsics.checkNotNullParameter(r105, "confirmUnit");
        if (r101 == null) goto L24;
        CommonDialog.a r107 = new CommonDialog.a();
        int r108 = j0.f375426a;
        r107.i(j0.d(R.string.larus_feedback_share_report_header));
        r107.g(j0.d(R.string.larus_feedback_share_report_desc));
        CommonDialog.a.f(r107, new ReportDialogHelper$showReportDialogByMessage$1$dialog$1(r105, r102), j0.d(R.string.larus_feedback_share_report_btn_continue), false, 12);
        r107.f327184m = true;
        f0 r109 = new f0(null, Integer.valueOf(ContextCompat.getColor(r101, v19.c.b(R.attr.larus_neutral_100, null, R.color.larus_neutral_100))), null, 5);
        Intrinsics.checkNotNullParameter(r109, "commonDialogTextStyleConfig");
        r107.D = r109;
        CommonDialog.a.e(r107, new ReportDialogHelper$showReportDialogByMessage$1$dialog$2(r104, r102, r103, r101), j0.d(R.string.larus_feedback_share_report_btn_copy), 4);
        r107.f327191t = true;
        CommonDialog r110 = r107.a();
        if (r101.isFinishing() == false) goto L13;
        return;
    L13:
        if (r101.isDestroyed() == true) goto L26;
        FragmentManager r111 = r101.getSupportFragmentManager();
        LandscapeRestrictionOperation r112 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r110, null, r112);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r111, r110, r112) == true) goto L27;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L21
    L19:
        r110.show(r111, null);
        return;
    L27:
        return;
    L26:
        return;
    }
}
