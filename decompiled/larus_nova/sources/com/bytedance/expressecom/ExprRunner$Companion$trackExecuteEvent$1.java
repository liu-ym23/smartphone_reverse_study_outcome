package com.bytedance.expressecom;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0004\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lcom/bytedance/expressecom/util/b;", "", AbsMethodDelegate.TAG_INVOKE, "(Lcom/bytedance/expressecom/util/b;)V", "<anonymous>"}, k = 3, mv = {1, 4, 0})
final class ExprRunner$Companion$trackExecuteEvent$1 extends Lambda implements Function1<com.bytedance.expressecom.util.b, Unit> {
    final /* synthetic */ String $abTag;
    final /* synthetic */ String $expr;
    final /* synthetic */ int $isFromCache;
    final /* synthetic */ int $isILCache;
    final /* synthetic */ int $isQuickExecutor;
    final /* synthetic */ x97.a $response;
    final /* synthetic */ b $runtimeInfo;

    public ExprRunner$Companion$trackExecuteEvent$1(x97.a r100, int r101, int r102, int r103, String r104, String r105, b r106) {
        this.$response = r100;
        this.$isFromCache = r101;
        this.$isILCache = r102;
        this.$isQuickExecutor = r103;
        this.$abTag = r104;
        this.$expr = r105;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(com.bytedance.expressecom.util.b r100) {
        r100.getClass();
        JSONObject r101 = new JSONObject();
        r101.put("code", this.$response.f562983b);
        r101.put("cache", this.$isFromCache);
        r101.put("is_il_cache", this.$isILCache);
        r101.put("is_quick_executor", this.$isQuickExecutor);
        String r102 = this.$abTag;
        if (r102 != null) goto L5;
    L8:
        boolean r103 = true;
    L9:
        if (r103 == true) goto L11;
        r101.put("ab_tag", this.$abTag);
    L11:
        JSONObject r104 = new JSONObject();
        String r105 = this.$expr;
        if (r105 == null) goto L14;
        r104.put("cel", StringsKt.trim(r105).toString());
        new JSONObject();
        throw null;
    L14:
        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    L5:
        if (r102.length() == 0) goto L8;
        r103 = false;
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(com.bytedance.expressecom.util.b r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
