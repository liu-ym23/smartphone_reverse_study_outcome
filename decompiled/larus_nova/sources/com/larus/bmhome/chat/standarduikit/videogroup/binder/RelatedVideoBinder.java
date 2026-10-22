package com.larus.bmhome.chat.standarduikit.videogroup.binder;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.text.Spanned;
import android.util.Size;
import android.view.View;
import android.widget.TextView;
import com.bytedance.android.ec.slice.SliceInitService;
import com.larus.bmhome.chat.standarduikit.videogroup.view.RelatedVideoView;
import com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.RelatedVideoViewModel;
import com.larus.im.bean.message.Message;
import com.larus.list.exposex.ExposeXTrackerExtKt;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.json.JSONObject;
import usc.f;
import zn8.l;
import zn8.p;
import zn8.q;

/* JADX INFO: loaded from: classes26.dex */
public final class RelatedVideoBinder implements f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Job f309826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f309827b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Integer f309828c;

    @Override // usc.f
    public final void a() {
    }

    @Override // usc.f
    public final Integer b(Size r100, TextView r101, Canvas r102, Paint r103) {
        return null;
    }

    @Override // usc.f
    public final Size c(TextView r100, usc.e r101, Map<String, ? extends Object> r102) {
        return null;
    }

    @Override // usc.f
    public final void e() {
    }

    @Override // usc.f
    public final View asView() {
        return ((wn8.c) this.f309827b.getValue()).b();
    }

    @Override // usc.f
    public final void f() {
        Job r100 = this.f309826a;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        wn8.c r101 = (wn8.c) this.f309827b.getValue();
        ((RelatedVideoViewModel) r101.f560480b.getValue()).f309848c = null;
        ExposeXTrackerExtKt.e(r101.b().getCoverView());
    }

    public RelatedVideoBinder(final Context r100, final boolean r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f309827b = LazyKt.lazy(new a(r100, r101));
    }

    @Override // usc.f
    public final Size d(TextView r110, Spanned r111, usc.e r112, int r210, Map<String, ? extends Object> r211) {
        Intrinsics.checkNotNullParameter(r110, "textView");
        Intrinsics.checkNotNullParameter(r111, "text");
        Intrinsics.checkNotNullParameter(r112, "span");
        int r100 = 0;
        if (r111.getSpanStart(r112) != 0) goto L5;
        boolean r101 = true;
    L7:
        if (r111.getSpanEnd(r112) != r111.length()) goto L9;
        boolean r102 = true;
    L27:
        String r103 = r112.l();     // Catch: Exception -> L15
        if (r103 != null) goto L13;
        r103 = SliceInitService.DEFAULT_SWITCH;
    L13:
        JSONObject r104 = new JSONObject(r103);     // Catch: Exception -> L15
    L16:
        l r113 = new l(r101, r102, r104.optBoolean("video_title_show"), r210);
        Job r105 = this.f309826a;
        if (r105 == null) goto L19;
        Job.DefaultImpls.cancel$default(r105, null, 1, null);
    L19:
        this.f309826a = BuildersKt.launch$default(CoroutineScopeKt.MainScope(), null, null, new RelatedVideoBinder$bindData$1(r211, this, r111, r112, r113, r110, null), 3, null);
        wn8.c r106 = (wn8.c) this.f309827b.getValue();
        com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.a r107 = new com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.a(r113, CollectionsKt.emptyList(), null, null, false);
        r106.getClass();
        Intrinsics.checkNotNullParameter(r107, "vmData");
        RelatedVideoView r108 = r106.b();
        l r109 = r107.f309851a;
        q r114 = new q(0);
        p r115 = new p(null);
        Intrinsics.checkNotNullParameter(r109, "sizeData");
        Intrinsics.checkNotNullParameter(r114, "videoData");
        Intrinsics.checkNotNullParameter(r115, "trackData");
        r108.getClass();
        if (r109 != null) goto L23;
        return new Size(0, 0);
    L23:
        if (r109.f572964c == false) goto L25;
        r100 = r108.f309844b;
    L25:
        Pair r116 = RelatedVideoView.a(r109);
        int r117 = (((Number) r116.component1()).intValue() + ((Number) r116.component2()).intValue()) + r100;
        return new Size(r109.f572965d, r108.getWidgetHeight() + r117);
    L15:
        r104 = new JSONObject();
        goto L16
    L9:
        r102 = false;
        goto L27
    L5:
        r101 = false;
        goto L7
    }

    public static final Object g(RelatedVideoBinder r100, Spanned r110, usc.e r111, fh8.f r112, l r113, Continuation r114) {
        r100.getClass();
        if ((r114 instanceof RelatedVideoBinder$generateVMData$1) == false) goto L7;
        RelatedVideoBinder$generateVMData$1 r101 = (RelatedVideoBinder$generateVMData$1) r114;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L18;
        if (r105 != 1) goto L17;
        Message r106 = (Message) r101.L$3;
        l r107 = (l) r101.L$2;
        usc.e r108 = (usc.e) r101.L$1;
        Spanned r109 = (Spanned) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Throwable -> L14
        Object r115 = r103;
        Message r116 = r106;
        usc.e r117 = r108;
    L51:
        Object r118 = Result.m9449constructorimpl((List) r115);     // Catch: Throwable -> L28
    L33:
        Throwable r119 = Result.m9452exceptionOrNullimpl(r118);
        if (r119 == null) goto L37;
        r119.printStackTrace();
    L37:
        if (Result.m9455isFailureimpl(r118) == false) goto L39;
        r118 = null;
    L39:
        List r120 = (List) r118;
        if (r120 == null) goto L57;
        Integer r121 = r100.f309828c;
        if (r121 == null) goto L45;
        Integer r122 = r121;
    L46:
        if (r116 == null) goto L48;
        boolean r123 = com.larus.bmhome.chat.bean.d.x(r116).getEnableVideoRecommend();
    L50:
        return new com.larus.bmhome.chat.standarduikit.videogroup.viewmodel.a(r107, r120, r116, r122, r123);
    L48:
        r123 = false;
        goto L50
    L45:
        ri8.c r124 = ri8.c.f537890a;
        r122 = ri8.c.k(r109, r117);
        r100.f309828c = r122;
        goto L46
    L57:
        return null;
    L28:
        th = th;
    L32:
        Result.Companion r125 = Result.Companion;
        r118 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L14:
        th = th;
        r116 = r106;
        r117 = r108;
        goto L32
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r103);
        if (r112 == null) goto L21;
        r116 = r112.f477072b;
    L53:
        Result.Companion r126 = Result.Companion;     // Catch: Throwable -> L30
        r101.L$0 = r110;     // Catch: Throwable -> L30
        r101.L$1 = r111;     // Catch: Throwable -> L30
        r101.L$2 = r113;     // Catch: Throwable -> L30
        r101.L$3 = r116;     // Catch: Throwable -> L30
        r101.label = 1;     // Catch: Throwable -> L30
        r115 = BuildersKt.withContext(Dispatchers.getIO(), new RelatedVideoBinder$parseGetVideoDataList$2(r111, r100, r116, null), r101);     // Catch: Throwable -> L30
        if (r115 == r104) goto L58;
        r109 = r110;
        r117 = r111;
        r107 = r113;
        goto L51
    L58:
        return r104;
    L30:
        th = th;
        r109 = r110;
        r117 = r111;
        r107 = r113;
        goto L32
    L21:
        r116 = null;
    L7:
        r101 = new RelatedVideoBinder$generateVMData$1(r100, r114);
        goto L8
    }
}
