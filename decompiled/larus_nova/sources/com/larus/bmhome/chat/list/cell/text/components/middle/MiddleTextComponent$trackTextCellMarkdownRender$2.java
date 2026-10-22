package com.larus.bmhome.chat.list.cell.text.components.middle;

import com.ixigua.lib.track.TrackParams;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.chat.list.cell.text.components.middle.MiddleTextComponent$trackTextCellMarkdownRender$2", f = "MiddleTextComponent.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MiddleTextComponent$trackTextCellMarkdownRender$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enableDataTagOptimize;
    final /* synthetic */ Long $getContentDuration;
    final /* synthetic */ List<String> $nodeTypeList;
    final /* synthetic */ Long $prepareDuration;
    final /* synthetic */ Long $renderDuration;
    final /* synthetic */ Long $renderOptimizeMode;
    final /* synthetic */ Boolean $useCache;
    int label;

    public MiddleTextComponent$trackTextCellMarkdownRender$2(List<String> r100, Long r101, Long r102, Long r103, Boolean r104, Long r105, boolean r106, Continuation<? super MiddleTextComponent$trackTextCellMarkdownRender$2> r107) {
        this.$nodeTypeList = r100;
        this.$prepareDuration = r101;
        this.$getContentDuration = r102;
        this.$renderDuration = r103;
        this.$useCache = r104;
        this.$renderOptimizeMode = r105;
        this.$enableDataTagOptimize = r106;
        super(2, r107);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r110, Continuation<?> r111) {
        return new MiddleTextComponent$trackTextCellMarkdownRender$2(this.$nodeTypeList, this.$prepareDuration, this.$getContentDuration, this.$renderDuration, this.$useCache, this.$renderOptimizeMode, this.$enableDataTagOptimize, r111);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
        return invoke2(r100, r101);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
        return ((MiddleTextComponent$trackTextCellMarkdownRender$2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r110) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r110);
        String r111 = this.$nodeTypeList.toString();
        Long r100 = this.$prepareDuration;
        Long r101 = this.$getContentDuration;
        Long r102 = this.$renderDuration;
        Boolean r103 = this.$useCache;
        Long r104 = this.$renderOptimizeMode;
        Boolean r105 = Boxing.boxBoolean(this.$enableDataTagOptimize);
        JSONObject r106 = new JSONObject();
        Intrinsics.checkNotNullParameter(r106, "params");
        if (r100 != null) goto L27;
    L9:
        if (r101 == null) goto L11;
        r106.put("get_content_duration", r101.longValue());     // Catch: JSONException -> L7
    L11:
        if (r102 == null) goto L13;
        r106.put("render_duration", r102.longValue());     // Catch: JSONException -> L7
    L13:
        if (r103 == null) goto L15;
        r106.put("use_cache", r103.booleanValue());     // Catch: JSONException -> L7
    L15:
        if (r104 == null) goto L17;
        r106.put("render_optimize_mode", r104.longValue());     // Catch: JSONException -> L7
    L17:
        if (r105 == null) goto L19;
        r106.put("enable_datatag_optimize", r105.booleanValue());     // Catch: JSONException -> L7
    L19:
        if (r111 == null) goto L23;
        r106.put("node_type_list", r111);     // Catch: JSONException -> L7
    L7:
        e = move-exception;
        FLogger.f375446a.e("MarkdownSpanEventHelper", "error in MarkdownSpanEventHelper mobTextcellMarkdownRender " + e.getLocalizedMessage());
    L23:
        TrackParams r112 = new TrackParams().merge(r106);
        by7.a r107 = new by7.a("flow_textcell_markdown_render");
        r107.f21463a.merge(r112);
        r107.b();
        return Unit.INSTANCE;
    L27:
        r106.put("prepare_duration", r100.longValue());     // Catch: JSONException -> L7
        goto L9
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
