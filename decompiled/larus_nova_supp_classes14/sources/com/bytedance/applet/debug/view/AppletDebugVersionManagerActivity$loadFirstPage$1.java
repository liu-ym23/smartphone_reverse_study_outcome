package com.bytedance.applet.debug.view;

import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfo;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppInfoList;
import com.larus.common.apphost.AppHost;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.bytedance.applet.debug.view.AppletDebugVersionManagerActivity$loadFirstPage$1", f = "AppletDebugVersionManagerActivity.kt", i = {}, l = {126}, m = "invokeSuspend", n = {}, s = {})
public final class AppletDebugVersionManagerActivity$loadFirstPage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppletDebugVersionManagerActivity this$0;

    public AppletDebugVersionManagerActivity$loadFirstPage$1(AppletDebugVersionManagerActivity r1, Continuation<? super AppletDebugVersionManagerActivity$loadFirstPage$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        AppletDebugVersionManagerActivity$loadFirstPage$1 r0 = new AppletDebugVersionManagerActivity$loadFirstPage$1(this.this$0, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r15) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        AppletDebugVersionAdapter r2 = null;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L15
    L13:
        Object r16 = Result.constructor-impl((OpenPlatformPreviewAppInfoList) r15);     // Catch: Throwable -> L15
    L17:
        AppletDebugVersionManagerActivity r3 = this.this$0;
        if (Result.isSuccess-impl(r16) == false) goto L76;
        OpenPlatformPreviewAppInfoList r4 = (OpenPlatformPreviewAppInfoList) r16;
        AppletDebugVersionManagerActivity.O1(r3);
        String r6 = r4.getNextCursor();
        if (r6 != null) goto L22;
        r6 = "";
    L22:
        r3.k = r6;
        r3.l = r4.getHasMore();
        List r7 = r4.getApps();
        if (r7 != null) goto L25;
        r7 = CollectionsKt.emptyList();
    L25:
        List r8 = r4.getScanSelectedApps();
        if (r8 != null) goto L29;
        r8 = CollectionsKt.emptyList();
    L29:
        if (r8.isEmpty() == true) goto L61;
        ArrayList r10 = new ArrayList();
        Iterator r9 = r8.iterator();
    L33:
        if (r9.hasNext() == false) goto L42;
        String r11 = ((OpenPlatformPreviewAppInfo) r9.next()).getAppKey();
        if (r11 != null) goto L37;
    L39:
        r11 = null;
    L40:
        if (r11 == null) goto L33;
        r10.add(r11);
        goto L33
    L37:
        if ((!StringsKt.isBlank(r11)) == false) goto L39;
    L42:
        Set r12 = CollectionsKt.toSet(r10);
        List r13 = r8;
        ArrayList r14 = new ArrayList();
        Iterator r17 = r7.iterator();
    L44:
        if (r17.hasNext() == false) goto L60;
        Object r18 = r17.next();
        String r19 = ((OpenPlatformPreviewAppInfo) r18).getAppKey();
        if (r19 != null) goto L48;
    L51:
        boolean r110 = true;
    L52:
        if (r110 == false) goto L54;
    L57:
        boolean r111 = true;
    L58:
        if (r111 == false) goto L44;
        r14.add(r18);
        goto L44
    L54:
        if (r12.contains(r19) == false) goto L57;
        r111 = false;
        goto L58
    L48:
        if (StringsKt.isBlank(r19) == true) goto L51;
        r110 = false;
        goto L52
    L60:
        r7 = CollectionsKt.plus(r13, r14);
    L61:
        AppletDebugVersionAdapter r5 = r3.h;
        if (r5 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L65:
        Map r20 = AppletDebugVersionManagerActivity.R1(r4);
        r2.getClass();
        Intrinsics.checkNotNullParameter(r7, "apps");
        Intrinsics.checkNotNullParameter(r20, "selectedVersions");
        ((ArrayList) r2.c).clear();
        List<AppletDebugVersionAdapter.b> r21 = r2.c;
        List r22 = r7;
        ArrayList r112 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r22, 10));
        Iterator r23 = r22.iterator();
    L67:
        if (r23.hasNext() == false) goto L72;
        OpenPlatformPreviewAppInfo r113 = (OpenPlatformPreviewAppInfo) r23.next();
        String r114 = r113.getAppKey();
        if (r114 != null) goto L71;
        r114 = "";
    L71:
        r112.add(AppletDebugVersionAdapter.A2(r113, (String) r20.get(r114)));
        goto L67
    L72:
        ((ArrayList) r21).addAll(r112);
        r2.notifyDataSetChanged();
        r3.T1();
        r3.S1();
        com.bytedance.ai.utils.g r24 = com.bytedance.ai.utils.g.a;
        StringBuilder r25 = new StringBuilder("bindFirstPage size=");
        r25.append(r7.size());
        r25.append(", scanSelectedSize=");
        List r26 = r4.getScanSelectedApps();
        if (r26 != null) goto L75;
        r26 = CollectionsKt.emptyList();
    L75:
        r25.append(r26.size());
        r25.append(", hasMore=");
        r25.append(r3.l);
        r24.i("AppletDebugVersionManager", r25.toString());
        goto L76
    L64:
        r2 = r5;
    L76:
        AppletDebugVersionManagerActivity r27 = this.this$0;
        Throwable r115 = Result.exceptionOrNull-impl(r16);
        if (r115 == null) goto L80;
        AppletDebugVersionManagerActivity.O1(r27);
        com.bytedance.ai.utils.g.a.e("AppletDebugVersionManager", "loadFirstPage failed: " + ExceptionsKt.stackTraceToString(r115));
        t19.s.a.g(AppHost.a.getApplication(), 2131894351, false);
        r27.T1();
    L80:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r15);
        CoroutineScope r116 = (CoroutineScope) this.L$0;
        AppletDebugVersionManagerActivity.P1(this.this$0);
        AppletDebugVersionManagerActivity r117 = this.this$0;
        Result.Companion r28 = Result.Companion;     // Catch: Throwable -> L15
        CoroutineDispatcher r29 = Dispatchers.getIO();     // Catch: Throwable -> L15
        AppletDebugVersionManagerActivity$loadFirstPage$1$1$1 r30 = new AppletDebugVersionManagerActivity$loadFirstPage$1$1$1(r117, null);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r15 = BuildersKt.withContext(r29, r30, this);     // Catch: Throwable -> L15
        if (r15 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r31 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
