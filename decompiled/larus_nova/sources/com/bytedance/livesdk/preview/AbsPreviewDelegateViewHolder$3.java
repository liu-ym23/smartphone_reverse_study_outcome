package com.bytedance.livesdk.preview;

import android.os.Bundle;
import com.bytedance.android.live.core.utils.v;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0015\u0010\u0007\u001a\u00110\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0015\u0010\n\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0017\u0010\f\u001a\u0013\u0018\u00010\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2%\u0010\u000e\u001a!\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u000f¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0002\b\u0011"}, d2 = {"<anonymous>", "", "p1", "", "Lkotlin/ParameterName;", "name", "businesskey", "p2", "Landroid/os/Bundle;", "businessBundle", "p3", "clickMethod", "p4", "firstRoomLogParams", "p5", "", "commonLogParams", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class AbsPreviewDelegateViewHolder$3 extends FunctionReferenceImpl implements Function5<String, Bundle, String, Bundle, Map<String, ? extends String>, Unit> {
    public AbsPreviewDelegateViewHolder$3(a r100) {
        super(5, r100, a.class, "mergeEnterRoomWithAction", "mergeEnterRoomWithAction(Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;Landroid/os/Bundle;Ljava/util/Map;)V", 0);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String r100, Bundle r101, String r102, Bundle r103, Map<String, String> r104) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        Intrinsics.checkNotNullParameter(r101, "p2");
        Intrinsics.checkNotNullParameter(r102, "p3");
        ((a) this.receiver).getClass();
        Intrinsics.checkNotNullParameter(r100, "businesskey");
        Intrinsics.checkNotNullParameter(r101, "businessBundle");
        Intrinsics.checkNotNullParameter(r102, "clickMethod");
        if (r100.length() != 0) goto L5;
        boolean r105 = true;
    L6:
        if (r105 == false) goto L12;
        if (v.a() == false) goto L12;
        throw new Throwable("businesskey canot be empty");
    L12:
        throw null;
    L5:
        r105 = false;
        goto L6
    }

    @Override // kotlin.jvm.functions.Function5
    public /* bridge */ /* synthetic */ Unit invoke(String r100, Bundle r101, String r102, Bundle r110, Map<String, ? extends String> r111) {
        invoke2(r100, r101, r102, r110, r111);
        return Unit.INSTANCE;
    }
}
