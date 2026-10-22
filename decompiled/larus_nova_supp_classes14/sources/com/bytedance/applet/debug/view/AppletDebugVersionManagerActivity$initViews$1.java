package com.bytedance.applet.debug.view;

import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
final /* synthetic */ class AppletDebugVersionManagerActivity$initViews$1 extends FunctionReferenceImpl implements Function2<String, String, Unit> {
    public AppletDebugVersionManagerActivity$initViews$1(Object r8) {
        super(2, r8, AppletDebugVersionManagerActivity.class, "loadMoreVersions", "loadMoreVersions(Ljava/lang/String;Ljava/lang/String;)V", 0);
    }

    public final void invoke(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "p0");
        Intrinsics.checkNotNullParameter(r12, "p1");
        AppletDebugVersionManagerActivity r0 = (AppletDebugVersionManagerActivity) ((CallableReference) this).receiver;
        int r1 = AppletDebugVersionManagerActivity.q;
        r0.getClass();
        if (StringsKt.isBlank(r11) == true) goto L7;
        com.bytedance.ai.utils.g.a.i("AppletDebugVersionManager", "loadMoreVersions appKey=" + r11 + " cursor=" + r12);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r0), null, null, new AppletDebugVersionManagerActivity$loadMoreVersions$1(r11, r0, r12, null), 3, null);
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        invoke((String) r1, (String) r2);
        return Unit.INSTANCE;
    }
}
