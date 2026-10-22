package com.bytedance.applet.debug.view;

import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewAppVersionList;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewVersion;
import com.bytedance.ai.resource.core.bean.OpenPlatformPreviewVersionPage;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common.apphost.AppHost;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
@DebugMetadata(c = "com.bytedance.applet.debug.view.AppletDebugVersionManagerActivity$loadMoreVersions$1", f = "AppletDebugVersionManagerActivity.kt", i = {}, l = {181}, m = "invokeSuspend", n = {}, s = {})
final class AppletDebugVersionManagerActivity$loadMoreVersions$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $appKey;
    final /* synthetic */ String $cursor;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AppletDebugVersionManagerActivity this$0;

    public AppletDebugVersionManagerActivity$loadMoreVersions$1(String r1, AppletDebugVersionManagerActivity r2, String r3, Continuation<? super AppletDebugVersionManagerActivity$loadMoreVersions$1> r4) {
        this.$appKey = r1;
        this.this$0 = r2;
        this.$cursor = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        AppletDebugVersionManagerActivity$loadMoreVersions$1 r0 = new AppletDebugVersionManagerActivity$loadMoreVersions$1(this.$appKey, this.this$0, this.$cursor, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        AppletDebugVersionAdapter r2 = null;
        boolean r3 = true;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L15
    L13:
        Object r15 = Result.constructor-impl((OpenPlatformPreviewAppVersionList) r14);     // Catch: Throwable -> L15
    L17:
        AppletDebugVersionManagerActivity r4 = this.this$0;
        String r5 = this.$appKey;
        int r6 = -1;
        if (Result.isSuccess-impl(r15) == false) goto L49;
        OpenPlatformPreviewVersionPage r7 = ((OpenPlatformPreviewAppVersionList) r15).getFormalVersions();
        AppletDebugVersionAdapter r8 = r4.h;
        if (r8 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r8 = null;
    L22:
        if (r7 == null) goto L24;
        List r9 = r7.getItems();
    L25:
        if (r9 != null) goto L27;
        r9 = CollectionsKt.emptyList();
    L27:
        if (r7 == null) goto L29;
        String r10 = r7.getNextCursor();
    L30:
        if (r7 != null) goto L32;
    L34:
        r3 = false;
    L35:
        r8.getClass();
        Intrinsics.checkNotNullParameter(r5, "appKey");
        Intrinsics.checkNotNullParameter(r9, "versions");
        Iterator r11 = ((ArrayList) r8.c).iterator();
        int r12 = 0;
    L37:
        if (r11.hasNext() == false) goto L42;
        if (Intrinsics.areEqual(((AppletDebugVersionAdapter.b) r11.next()).a, r5) == true) goto L43;
        r12 = r12 + 1;
    L43:
        if (r12 < 0) goto L49;
        AppletDebugVersionAdapter.b r13 = (AppletDebugVersionAdapter.b) ListProtector.get(r8.c, r12);
        r13.o = false;
        if (r10 != null) goto L48;
        r10 = "";
    L48:
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r13.l = r10;
        r13.m = r3;
        List<OpenPlatformPreviewVersion> r16 = CollectionsKt.plus(r13.k, AppletDebugVersionAdapter.y2(r9, r13.j));
        Intrinsics.checkNotNullParameter(r16, "<set-?>");
        r13.k = r16;
        r8.notifyItemChanged(r12);
        goto L49
    L42:
        r12 = -1;
        goto L43
    L32:
        if (r7.getHasMore() != true) goto L34;
    L29:
        r10 = null;
        goto L30
    L24:
        r9 = null;
    L49:
        AppletDebugVersionManagerActivity r17 = this.this$0;
        String r18 = this.$appKey;
        Throwable r19 = Result.exceptionOrNull-impl(r15);
        if (r19 == null) goto L67;
        com.bytedance.ai.utils.g.a.e("AppletDebugVersionManager", "loadMoreVersions failed: " + ExceptionsKt.stackTraceToString(r19));
        AppletDebugVersionAdapter r110 = r17.h;
        if (r110 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
    L55:
        r2.getClass();
        Intrinsics.checkNotNullParameter(r18, "appKey");
        Iterator r111 = ((ArrayList) r2.c).iterator();
        int r20 = 0;
    L57:
        if (r111.hasNext() == false) goto L62;
        if (Intrinsics.areEqual(((AppletDebugVersionAdapter.b) r111.next()).a, r18) == true) goto L60;
        r20 = r20 + 1;
        goto L57
    L60:
        r6 = r20;
    L62:
        if (r6 < 0) goto L65;
        ((AppletDebugVersionAdapter.b) ListProtector.get(r2.c, r6)).o = false;
        r2.notifyItemChanged(r6);
    L65:
        t19.s.a.g(AppHost.a.getApplication(), 2131894354, false);
        goto L67
    L54:
        r2 = r110;
    L67:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r14);
        CoroutineScope r112 = (CoroutineScope) this.L$0;
        String r113 = this.$appKey;
        AppletDebugVersionManagerActivity r21 = this.this$0;
        String r22 = this.$cursor;
        Result.Companion r23 = Result.Companion;     // Catch: Throwable -> L15
        CoroutineDispatcher r24 = Dispatchers.getIO();     // Catch: Throwable -> L15
        AppletDebugVersionManagerActivity$loadMoreVersions$1$1$1 r25 = new AppletDebugVersionManagerActivity$loadMoreVersions$1$1$1(r113, r21, r22, null);     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        r14 = BuildersKt.withContext(r24, r25, this);     // Catch: Throwable -> L15
        if (r14 != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r26 = Result.Companion;
        r15 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }
}
