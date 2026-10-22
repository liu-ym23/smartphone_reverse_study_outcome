package com.bytedance.ee.larkwebview.quality.stable;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes19.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/ss/android/lark/officesdk/di/core/deps/webview/BlankDetectResultWrapper;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {2, 1, 0}, xi = 48)
final class BlankChecker$checkBlank$1 extends Lambda implements Function1<otb.a, Unit> {
    final /* synthetic */ Ref.ObjectRef<b.a> $blankResult;
    final /* synthetic */ b $result;
    final /* synthetic */ a this$0;

    public BlankChecker$checkBlank$1(Ref.ObjectRef<b.a> r100, a r101, b r102) {
        this.$blankResult = r100;
        this.this$0 = r101;
        super(1);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, com.bytedance.ee.larkwebview.quality.stable.b$a] */
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(otb.a r100) {
        Intrinsics.checkNotNullParameter(r100, "it");
        Ref.ObjectRef<b.a> r101 = this.$blankResult;
        a r102 = this.this$0;
        int r103 = a.f242935a;
        r102.getClass();
        ?? r104 = new b.a();
        int r105 = 0;
        if (r100 == null) goto L5;
        boolean r106 = r100.c();
    L6:
        r104.f242937b = r106;
        if (r100 == null) goto L9;
        String r107 = r100.b();
    L33:
        JSONObject r108 = new JSONObject(r107);     // Catch: Exception -> L18
        Iterator<String> r109 = r108.keys();     // Catch: Exception -> L18
        int r110 = 0;
        int r111 = 0;
    L12:
        if (r109.hasNext() == false) goto L17;
        int r112 = JSONObjectProtectorUtils.getInt(r108, r109.next());     // Catch: Exception -> L18
        r111 = r111 + r112;
        if (r112 <= r110) goto L12;
        r110 = r112;
        goto L12
    L17:
        float r113 = r110 / r111;
    L20:
        r104.f242940e = (int) (r113 * 1000);
        if (r100 == null) goto L23;
        boolean r114 = r100.isSuccess();
    L24:
        r104.f242936a = r114;
        if (r100 == null) goto L27;
        boolean r115 = r100.a();
    L28:
        r104.f242938c = r115;
        if (r100 == null) goto L31;
        r105 = r100.d();
    L31:
        r104.f242939d = r105;
        r104.f242941f = true;
        r101.element = r104;
        return;
    L27:
        r115 = false;
        goto L28
    L23:
        r114 = false;
    L18:
        e = move-exception;
        e.printStackTrace();
        r113 = 0.0f;
        goto L20
    L9:
        r107 = null;
        goto L33
    L5:
        r106 = false;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(otb.a r100) {
        invoke2(r100);
        return Unit.INSTANCE;
    }
}
