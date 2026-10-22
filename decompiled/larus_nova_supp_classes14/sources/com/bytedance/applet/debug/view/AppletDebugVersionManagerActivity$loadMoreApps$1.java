package com.bytedance.applet.debug.view;

import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfo;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfoList;
import com.bytedance.applet.databinding.LarusAppletDebugVersionManagerActivityBinding;
import com.larus.common.apphost.AppHost;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.ExceptionsKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debug.view.AppletDebugVersionManagerActivity$loadMoreApps$1", f = "AppletDebugVersionManagerActivity.kt", i = {}, l = {154}, m = "invokeSuspend", n = {}, s = {})
final class AppletDebugVersionManagerActivity$loadMoreApps$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppletDebugVersionManagerActivity this$0;

    public AppletDebugVersionManagerActivity$loadMoreApps$1(AppletDebugVersionManagerActivity r1, Continuation<? super AppletDebugVersionManagerActivity$loadMoreApps$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        AppletDebugVersionManagerActivity$loadMoreApps$1 r0 = new AppletDebugVersionManagerActivity$loadMoreApps$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r18) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L9;
        if (r2 != 1) goto L8;
        ResultKt.throwOnFailure(r18);     // Catch: Throwable -> L15
        Object r3 = r18;
    L13:
        Object r1 = Result.constructor-impl((OpenPlatformPreviewAppInfoList) r3);     // Catch: Throwable -> L15
    L17:
        AppletDebugVersionManagerActivity r4 = this.this$0;
        if (Result.isSuccess-impl(r1) == false) goto L43;
        OpenPlatformPreviewAppInfoList r5 = (OpenPlatformPreviewAppInfoList) r1;
        r4.m = false;
        LarusAppletDebugVersionManagerActivityBinding r9 = r4.g;
        if (r9 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L22:
        r9.g.setVisibility(8);
        String r10 = r5.getNextCursor();
        if (r10 != null) goto L25;
        r10 = "";
    L25:
        r4.k = r10;
        r4.l = r5.getHasMore();
        AppletDebugVersionAdapter r11 = r4.h;
        if (r11 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r11 = null;
    L28:
        List r12 = r5.getApps();
        if (r12 != null) goto L31;
        r12 = CollectionsKt.emptyList();
    L31:
        Map r13 = AppletDebugVersionManagerActivity.R1(r5);
        r11.getClass();
        Intrinsics.checkNotNullParameter(r12, "apps");
        Intrinsics.checkNotNullParameter(r13, "selectedVersions");
        int r14 = ((ArrayList) r11.c).size();
        List<AppletDebugVersionAdapter.b> r15 = r11.c;
        List r16 = r12;
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r16, 10));
        Iterator r7 = r16.iterator();
    L33:
        if (r7.hasNext() == false) goto L39;
        OpenPlatformPreviewAppInfo r17 = (OpenPlatformPreviewAppInfo) r7.next();
        String r19 = r17.getAppKey();
        if (r19 != null) goto L37;
        String r8 = "";
    L38:
        r6.add(AppletDebugVersionAdapter.A2(r17, (String) r13.get(r8)));
        goto L33
    L37:
        r8 = r19;
        goto L38
    L39:
        ((ArrayList) r15).addAll(r6);
        r11.notifyItemRangeInserted(r14, r12.size());
        r4.T1();
        com.bytedance.ai.utils.g r20 = com.bytedance.ai.utils.g.a;
        StringBuilder r21 = new StringBuilder("appendAppPage size=");
        List r22 = r5.getApps();
        if (r22 != null) goto L42;
        r22 = CollectionsKt.emptyList();
    L42:
        r21.append(r22.size());
        r21.append(", hasMore=");
        r21.append(r4.l);
        r20.i("AppletDebugVersionManager", r21.toString());
    L43:
        AppletDebugVersionManagerActivity r23 = this.this$0;
        Throwable r24 = Result.exceptionOrNull-impl(r1);
        if (r24 == null) goto L51;
        r23.m = false;
        LarusAppletDebugVersionManagerActivityBinding r25 = r23.g;
        if (r25 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        LarusAppletDebugVersionManagerActivityBinding r26 = null;
    L49:
        r26.g.setVisibility(8);
        com.bytedance.ai.utils.g.a.e("AppletDebugVersionManager", "loadMoreApps failed: " + ExceptionsKt.stackTraceToString(r24));
        t19.s.a.g(AppHost.a.getApplication(), 2131894353, false);
        goto L51
    L48:
        r26 = r25;
    L51:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r18);
        CoroutineScope r27 = (CoroutineScope) this.L$0;
        AppletDebugVersionManagerActivity r28 = this.this$0;
        Result.Companion r29 = Result.Companion;     // Catch: Throwable -> L15
        CoroutineDispatcher r30 = Dispatchers.getIO();     // Catch: Throwable -> L15
        AppletDebugVersionManagerActivity$loadMoreApps$1$1$1 r31 = new AppletDebugVersionManagerActivity$loadMoreApps$1$1$1(r28, null);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r3 = BuildersKt.withContext(r30, r31, this);     // Catch: Throwable -> L15
        if (r3 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r32 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
