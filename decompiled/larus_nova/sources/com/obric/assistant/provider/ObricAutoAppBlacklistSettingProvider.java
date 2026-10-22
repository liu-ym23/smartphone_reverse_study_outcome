package com.obric.assistant.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.obric.assistant.settings.IObricAutoGuiSettingsApi;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 52\u00020\u0001:\u00015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016JO\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0010\u0010\f\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u000eH\u0016¢\u0006\u0002\u0010\u0012J7\u0010\u0013\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0014\u001a\u00020\u000e2\u001e\u0010\u0015\u001a\u001a\b\u0001\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0016H\u0002¢\u0006\u0002\u0010\u0019J \u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010 \u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J1\u0010#\u001a\u00020$2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\rH\u0016¢\u0006\u0002\u0010%J;\u0010&\u001a\u00020$2\u0006\u0010\n\u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\u0010\u0010\u0010\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u000e\u0018\u00010\rH\u0016¢\u0006\u0002\u0010'J&\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020\u000e2\b\u0010+\u001a\u0004\u0018\u00010\u000e2\b\u0010,\u001a\u0004\u0018\u00010)H\u0016J\u000e\u0010-\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010.J\u000e\u0010/\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010.J\u000e\u00100\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010.J\u000e\u00101\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010.J\u0010\u00102\u001a\u0004\u0018\u00010\tH\u0082@¢\u0006\u0002\u0010.J\u0010\u00103\u001a\u0004\u0018\u00010\tH\u0082@¢\u0006\u0002\u0010.J\u001c\u00104\u001a\u00020\u001b2\b\u0010+\u001a\u0004\u0018\u00010\u000e2\b\u0010,\u001a\u0004\u0018\u00010)H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/obric/assistant/provider/ObricAutoAppBlacklistSettingProvider;", "Landroid/content/ContentProvider;", "<init>", "()V", "scope", "Lkotlinx/coroutines/CoroutineScope;", WidgetCostModule.TYPE_ON_CREATE, "", "query", "Landroid/database/Cursor;", "uri", "Landroid/net/Uri;", "projection", "", "", "selection", "selectionArgs", "sortOrder", "(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "queryWithTimeTrace", "methodName", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Landroid/database/Cursor;", "reportQueryDuration", "", "duration", "", "success", "getType", "insert", "values", "Landroid/content/ContentValues;", "delete", "", "(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I", "update", "(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I", NotificationCompat.CATEGORY_CALL, "Landroid/os/Bundle;", com.alipay.sdk.m.p.e.f25671s, "arg", "extras", "queryAppsStatus", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryBlockedApps", "queryWhiteListApps", "queryClientOnlyWhiteListApps", "queryA17MergedBlacklist", "queryA17UserAvailableApps", "updateAppPermissionOnAutoAction", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAutoAppBlacklistSettingProvider extends ContentProvider {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<k> f391174b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final UriMatcher f391175c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final List<Uri> f391176d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CoroutineScope f391177a;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider$query$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Landroid/database/Cursor;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider$query$1", f = "ObricAutoAppBlacklistSettingProvider.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function1<Continuation<? super Cursor>, Object> {
        int label;
        final /* synthetic */ ObricAutoAppBlacklistSettingProvider this$0;

        public AnonymousClass1(ObricAutoAppBlacklistSettingProvider r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(1, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new AnonymousClass1(this.this$0, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Cursor> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Cursor> r100) {
            return ((AnonymousClass1) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            return r100;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            ObricAutoAppBlacklistSettingProvider r103 = this.this$0;
            this.label = 1;
            List<k> r104 = ObricAutoAppBlacklistSettingProvider.f391174b;
            r103.getClass();
            r100 = BuildersKt.withContext(Dispatchers.getIO(), new ObricAutoAppBlacklistSettingProvider$queryAppsStatus$2(null), this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider$query$2, reason: invalid class name */
    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Landroid/database/Cursor;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider$query$2", f = "ObricAutoAppBlacklistSettingProvider.kt", i = {}, l = {115}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function1<Continuation<? super Cursor>, Object> {
        int label;
        final /* synthetic */ ObricAutoAppBlacklistSettingProvider this$0;

        public AnonymousClass2(ObricAutoAppBlacklistSettingProvider r100, Continuation<? super AnonymousClass2> r101) {
            this.this$0 = r100;
            super(1, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new AnonymousClass2(this.this$0, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Cursor> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Cursor> r100) {
            return ((AnonymousClass2) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            return r100;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            ObricAutoAppBlacklistSettingProvider r103 = this.this$0;
            this.label = 1;
            List<k> r104 = ObricAutoAppBlacklistSettingProvider.f391174b;
            r103.getClass();
            r100 = BuildersKt.withContext(Dispatchers.getIO(), new ObricAutoAppBlacklistSettingProvider$queryBlockedApps$2(null), this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider$query$3, reason: invalid class name */
    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Landroid/database/Cursor;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider$query$3", f = "ObricAutoAppBlacklistSettingProvider.kt", i = {}, l = {118}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function1<Continuation<? super Cursor>, Object> {
        int label;
        final /* synthetic */ ObricAutoAppBlacklistSettingProvider this$0;

        public AnonymousClass3(ObricAutoAppBlacklistSettingProvider r100, Continuation<? super AnonymousClass3> r101) {
            this.this$0 = r100;
            super(1, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new AnonymousClass3(this.this$0, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Cursor> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Cursor> r100) {
            return ((AnonymousClass3) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            return r100;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            ObricAutoAppBlacklistSettingProvider r103 = this.this$0;
            this.label = 1;
            List<k> r104 = ObricAutoAppBlacklistSettingProvider.f391174b;
            r103.getClass();
            r100 = BuildersKt.withContext(Dispatchers.getIO(), new ObricAutoAppBlacklistSettingProvider$queryWhiteListApps$2(null), this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider$query$4, reason: invalid class name */
    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Landroid/database/Cursor;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider$query$4", f = "ObricAutoAppBlacklistSettingProvider.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function1<Continuation<? super Cursor>, Object> {
        int label;
        final /* synthetic */ ObricAutoAppBlacklistSettingProvider this$0;

        public AnonymousClass4(ObricAutoAppBlacklistSettingProvider r100, Continuation<? super AnonymousClass4> r101) {
            this.this$0 = r100;
            super(1, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new AnonymousClass4(this.this$0, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Cursor> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Cursor> r100) {
            return ((AnonymousClass4) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            return r100;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            ObricAutoAppBlacklistSettingProvider r103 = this.this$0;
            this.label = 1;
            List<k> r104 = ObricAutoAppBlacklistSettingProvider.f391174b;
            r103.getClass();
            r100 = BuildersKt.withContext(Dispatchers.getIO(), new ObricAutoAppBlacklistSettingProvider$queryClientOnlyWhiteListApps$2(null), this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider$query$5, reason: invalid class name */
    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Landroid/database/Cursor;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider$query$5", f = "ObricAutoAppBlacklistSettingProvider.kt", i = {}, l = {124}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends SuspendLambda implements Function1<Continuation<? super Cursor>, Object> {
        int label;
        final /* synthetic */ ObricAutoAppBlacklistSettingProvider this$0;

        public AnonymousClass5(ObricAutoAppBlacklistSettingProvider r100, Continuation<? super AnonymousClass5> r101) {
            this.this$0 = r100;
            super(1, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new AnonymousClass5(this.this$0, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Cursor> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Cursor> r100) {
            return ((AnonymousClass5) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            return r100;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            ObricAutoAppBlacklistSettingProvider r103 = this.this$0;
            this.label = 1;
            List<k> r104 = ObricAutoAppBlacklistSettingProvider.f391174b;
            r103.getClass();
            r100 = BuildersKt.withContext(Dispatchers.getIO(), new ObricAutoAppBlacklistSettingProvider$queryA17MergedBlacklist$2(null), this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider$query$6, reason: invalid class name */
    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n"}, d2 = {"<anonymous>", "Landroid/database/Cursor;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider$query$6", f = "ObricAutoAppBlacklistSettingProvider.kt", i = {}, l = {127}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass6 extends SuspendLambda implements Function1<Continuation<? super Cursor>, Object> {
        int label;
        final /* synthetic */ ObricAutoAppBlacklistSettingProvider this$0;

        public AnonymousClass6(ObricAutoAppBlacklistSettingProvider r100, Continuation<? super AnonymousClass6> r101) {
            this.this$0 = r100;
            super(1, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Continuation<?> r100) {
            return new AnonymousClass6(this.this$0, r100);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Continuation<? super Cursor> r100) {
            return invoke2(r100);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(Continuation<? super Cursor> r100) {
            return ((AnonymousClass6) create(r100)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            return r100;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            ObricAutoAppBlacklistSettingProvider r103 = this.this$0;
            this.label = 1;
            List<k> r104 = ObricAutoAppBlacklistSettingProvider.f391174b;
            r103.getClass();
            r100 = BuildersKt.withContext(Dispatchers.getIO(), new ObricAutoAppBlacklistSettingProvider$queryA17UserAvailableApps$2(null), this);
            if (r100 != r101) goto L11;
            return r101;
        }
    }

    @Override // android.content.ContentProvider
    public int delete(Uri r100, String r101, String[] r102) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri r100, ContentValues r101) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri r100, ContentValues r101, String r102, String[] r103) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        return 0;
    }

    static {
        List<k> r100 = CollectionsKt.listOf(new k[]{new k("settings/app_list_status", 1), new k("settings/user_blacklist", 2), new k("settings/user_whitelist", 3), new k("settings/user_whitelist_only_client", 4), new k("settings/a17_automatable_blocklist", 5), new k("settings/a17_user_available_apps", 6)});
        f391174b = r100;
        UriMatcher r101 = new UriMatcher(-1);
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        k r103 = (k) r102.next();
        r101.addURI("com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider", r103.f391203a, r103.f391204b);
        goto L4
    L6:
        f391175c = r101;
        List<k> r104 = f391174b;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L8:
        if (r106.hasNext() == false) goto L10;
        r105.add(UriProtector.parse("content://com.obric.assistant.provider.ObricAutoAppBlacklistSettingProvider/" + ((k) r106.next()).f391203a));
        goto L8
    L10:
        f391176d = r105;
    }

    @Override // android.content.ContentProvider
    public final boolean onCreate() {
        FLogger.f375446a.d("ObricAutoAppBlacklistSettingProvider", WidgetCostModule.TYPE_ON_CREATE);
        return true;
    }

    public ObricAutoAppBlacklistSettingProvider() {
        this.f391177a = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
    }

    public final Cursor a(String r110, Function1<? super Continuation<? super Cursor>, ? extends Object> r111) {
        CompletableDeferred r100 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        BuildersKt.launch$default(this.f391177a, null, null, new ObricAutoAppBlacklistSettingProvider$queryWithTimeTrace$1(r110, r111, r100, this, null), 3, null);
        return (Cursor) BuildersKt.runBlocking$default(null, new ObricAutoAppBlacklistSettingProvider$queryWithTimeTrace$2(r100, null), 1, null);
    }

    @Override // android.content.ContentProvider
    public Bundle call(String r100, String r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, com.alipay.sdk.m.p.e.f25671s);
        FLogger r103 = FLogger.f375446a;
        r103.i("ObricAutoAppBlacklistSettingProvider", "call: method = " + r100 + ", arg = " + r101 + ", callingUid = " + Binder.getCallingUid() + ", callingPid = " + Binder.getCallingPid());
        if (Intrinsics.areEqual(r100, "update_app_permission_on_auto_action") == false) goto L31;
        String r104 = "";
        if (r102 == null) goto L11;
        String r105 = r102.getString("package_name", "");
        if (r105 == null) goto L11;
        r104 = r105;
    L11:
        if (r102 == null) goto L13;
        Integer r106 = Integer.valueOf(r102.getInt("app_permission_status", -1));
    L14:
        r103.i("ObricAutoAppBlacklistSettingProvider", "updateAppPermissionOnAutoAction, packageName: " + r104 + ", appAvailableStatus: " + r106);
        if (r106 == null) goto L20;
        if (r106.intValue() == (-1)) goto L31;
    L20:
        if (o0.d(r104) == false) goto L31;
        IObricAutoGuiSettingsApi r107 = (IObricAutoGuiSettingsApi) ServiceManager.get().getService(IObricAutoGuiSettingsApi.class);
        if (r107 == null) goto L31;
        int r108 = AppPermissionOnAutoActionStatus.AVAILABLE_ALWAYS.getValue();
        if (r106 != null) goto L27;
    L29:
        boolean r109 = false;
    L30:
        r107.h(r104, r109);
        goto L31
    L27:
        if (r106.intValue() != r108) goto L29;
        r109 = true;
        goto L30
    L13:
        r106 = null;
    L31:
        return null;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri r100, String[] r101, String r102, String[] r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "uri");
        switch(f391175c.match(r100)) {
            case 1: goto L11;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            default: goto L4;
        };
    L4:
        FLogger.f375446a.e("ObricAutoAppBlacklistSettingProvider", "query, unknown uri = " + r100);
        return null;
    L13:
        return a("CODE_QUERY_A17_USER_AVAILABLE", new AnonymousClass6(this, null));
    L14:
        return a("CODE_QUERY_A17_MERGED_BLACKLIST", new AnonymousClass5(this, null));
    L15:
        return a("CODE_QUERY_APPS_ENABLED_BY_CLIENT_ONLY", new AnonymousClass4(this, null));
    L16:
        return a("CODE_QUERY_APPS_ENABLED_BY_USER", new AnonymousClass3(this, null));
    L17:
        return a("CODE_QUERY_APPS_BLOCKED_BY_USER", new AnonymousClass2(this, null));
    L11:
        return a("CODE_QUERY_APPS_STATUS", new AnonymousClass1(this, null));
    }
}
