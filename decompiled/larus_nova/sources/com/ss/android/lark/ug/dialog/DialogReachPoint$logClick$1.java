package com.ss.android.lark.ug.dialog;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.ss.android.lark.pb.ug_reach.DialogMaterial;
import com.ss.android.lark.pb.ug_reach.MaterialBase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Lorg/json/JSONObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class DialogReachPoint$logClick$1 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ String $clickType;
    final /* synthetic */ a this$0;

    public DialogReachPoint$logClick$1(a r100, String r101) {
        this.this$0 = r100;
        this.$clickType = r101;
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(JSONObject r100) {
        Intrinsics.checkNotNullParameter(r100, "$this$sendEvent");
        a r101 = this.this$0;
        int r102 = a.f444437g;
        DialogMaterial r103 = (DialogMaterial) r101.f508140c;
        if (r103 == null) goto L8;
        MaterialBase r104 = r103.mbase;
        if (r104 == null) goto L8;
        Object r105 = r104.mtask_id;
        if (r105 == null) goto L8;
    L9:
        r100.put("popup_id", r105);
        r100.put("click", this.$clickType);
        return;
    L8:
        r105 = "";
        goto L9
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(JSONObject r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
