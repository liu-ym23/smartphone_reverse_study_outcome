package com.obric.assistant.util;

import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.account.base.api.ILoginService;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.impl.MessageApiImpl;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.assistant.permission.IObricPermissionService;
import com.obric.assistant.settings.Domain;
import com.obric.assistant.settings.IObricPersonalContextSettingApi;
import com.obric.assistant.settings.LocalDataSearchSelectFragment;
import com.obric.assistant.settings.SelectableToggleItem;
import com.obric.assistant.settings.ToggleName;
import com.obric.assistant.settings.memory.ObricPersonalContextSettingActivity;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONArray;
import v19.i5;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000¡\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0016\b\u0007\u0018\u0000 f2\u00020\u0001:\u0001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\u0018\u0010 \u001a\u0004\u0018\u00010\u001c2\u0006\u0010!\u001a\u00020\"H\u0082@¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\u001cH\u0016J\b\u0010%\u001a\u00020\u0019H\u0016J\b\u0010&\u001a\u00020\u0019H\u0016J\u0010\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010+\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)2\u0006\u0010,\u001a\u00020\u001cH\u0016J\u0018\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/2\u0006\u0010,\u001a\u00020\u001cH\u0016J\n\u00100\u001a\u0004\u0018\u000101H\u0016J\u000e\u00102\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u00103J\u0010\u00104\u001a\u0004\u0018\u000105H\u0082@¢\u0006\u0002\u00103J\u001e\u00106\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/2\u0006\u00107\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u00108J\u001a\u00109\u001a\u00020\u00192\u0006\u0010:\u001a\u0002052\b\b\u0002\u0010;\u001a\u00020\u001cH\u0002J\b\u0010<\u001a\u000205H\u0002J\f\u0010=\u001a\u00020\u001c*\u000205H\u0002J\u0018\u0010>\u001a\u0002052\u0006\u0010.\u001a\u00020/2\u0006\u00107\u001a\u00020\u001cH\u0002J(\u0010?\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/2\u0006\u0010,\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020\u001cH\u0002J\u0010\u0010B\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020/H\u0002J\b\u0010E\u001a\u00020\u0019H\u0002J\b\u0010F\u001a\u00020\u0019H\u0002J\b\u0010G\u001a\u00020\u001cH\u0016J\u0010\u0010H\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u001cH\u0016J\b\u0010J\u001a\u00020\u001cH\u0016J\u0010\u0010K\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u001cH\u0016J\b\u0010L\u001a\u00020\u0019H\u0002J\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020\u001cH\u0016J\b\u0010P\u001a\u00020\u001cH\u0016J\u0010\u0010Q\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u001cH\u0016J\u0010\u0010R\u001a\u00020/2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010S\u001a\u00020\"H\u0016J\u0010\u0010T\u001a\u00020\u00192\u0006\u0010U\u001a\u00020\"H\u0016J\u0018\u0010V\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010W2\u0006\u0010X\u001a\u00020YH\u0016J8\u0010Z\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020]0\\0[\u0018\u00010W2\u0006\u0010X\u001a\u00020Y2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020]0\\H\u0016J\u0010\u0010_\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010`\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)H\u0016J\u0012\u0010a\u001a\f\u0012\u0006\b\u0001\u0012\u00020c\u0018\u00010bH\u0016J\u0010\u0010d\u001a\u00020e2\u0006\u0010(\u001a\u00020)H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006g"}, d2 = {"Lcom/obric/assistant/util/ObricPersonalContextSettingServiceImpl;", "Lcom/obric/assistant/settings/IObricPersonalContextSettingApi;", "<init>", "()V", "keva", "Lcom/bytedance/keva/Keva;", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "Lkotlin/Lazy;", "referenceMemoryKeva", "getReferenceMemoryKeva", "aiLabService", "Lcom/obric/assistant/settings/IAILabService;", "getAiLabService", "()Lcom/obric/assistant/settings/IAILabService;", "aiLabService$delegate", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "referenceMemoryAccountListenerRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "referenceMemoryAccountListener", "com/obric/assistant/util/ObricPersonalContextSettingServiceImpl$referenceMemoryAccountListener$1", "Lcom/obric/assistant/util/ObricPersonalContextSettingServiceImpl$referenceMemoryAccountListener$1;", "initReferenceMemorySync", "", "registerMessageExt", "shouldCarryDomain", "", "domain", "Lcom/obric/assistant/settings/Domain;", "queryScreenMemoryEnabledWithTimeout", "queryScreenMemoryEnabledSuspend", "timeoutMillis", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPersonalContextOpened", "personalContextOn", "personalContextOff", "turnOnToggle", "toggleName", "Lcom/obric/assistant/settings/ToggleName;", "turnOffToggle", "isToggleOn", "defVal", "isReferenceMemoryToggleEnabled", "key", "", "getReferenceMemorySyncSnapshot", "Lcom/obric/assistant/settings/ReferenceMemorySyncSnapshot;", "updateReferenceMemoryCloudConfig", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestReferenceMemoryCloudConfigWithRetry", "Lcom/obric/assistant/network/api/bean/ObricReferenceMemoryConfig;", "setReferenceMemoryToggleEnabledWithSync", "enabled", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncReferenceMemoryLocalCache", "config", "notifyChanged", "getDefaultReferenceMemoryConfig", "isEmpty", "buildReferenceMemoryConfig", "getReferenceMemoryValue", "overrideKey", "overrideValue", "isReferenceMemoryKey", "isSameLoginUser", "requestUserId", "registerReferenceMemoryAccountListener", "notifyReferenceMemorySyncChanged", "isUseDataOnLockScreenEnabled", "setUseDataOnLockScreen", "enable", "isDataDomainDialogAlreadyShown", "setDataDomainDialogAlreadyShown", "addAllDataSourceToggles", "getKevaRepo", "", "isHideEventMemory", "isLocalDataSearchEnabled", "setLocalDataSearchEnabled", "getLocalDataSearchSwitchReportValue", "getLastLocalDataSearchInitPermissionRequestTimestamp", "setLastLocalDataSearchInitPermissionRequestTimestamp", "timestamp", "showLocalDataSearchConfirmFragment", "Landroidx/lifecycle/LiveData;", "activity", "Landroidx/fragment/app/FragmentActivity;", "showLocalDataSearchSelectFragment", "Lkotlin/Pair;", "", "Lcom/obric/assistant/settings/SelectableToggleItem;", "toggleList", "isGovernedByNewGlobalMemorySwitch", "isGovernedBySystemPermission", "getObricPersonalContextSettingsClassName", "Ljava/lang/Class;", "Landroid/app/Activity;", "checkSystemPermissionByToggle", "Lcom/obric/assistant/permission/IObricPermissionService$Companion$ObricPermissionStatus;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPersonalContextSettingServiceImpl implements IObricPersonalContextSettingApi {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Uri f393628f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f393629a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f393630b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final CoroutineScope f393631c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final AtomicBoolean f393632d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final ObricPersonalContextSettingServiceImpl$referenceMemoryAccountListener$1 f393633e;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes33.dex */
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f393634a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f393635b = null;

        static {
            int[] r100 = new int[ToggleName.values().length];
            r100[ToggleName.AI_DIARY.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            r100[ToggleName.COLLECTION_MEMORY.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L33:
            r100[ToggleName.PERSONAL_INFO_MEMORY.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L25:
            r100[ToggleName.SCREEN_MEMORY.ordinal()] = 4;     // Catch: NoSuchFieldError -> L17
        L27:
            r100[ToggleName.HEARING_MEMORY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L18
        L9:
            f393634a = r100;
            int[] r101 = new int[IObricPermissionService.Companion.ObricPermissionStatus.values().length];
            r101[IObricPermissionService.Companion.ObricPermissionStatus.GRANTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L19
        L21:
            r101[IObricPermissionService.Companion.ObricPermissionStatus.LIMITED_GRANTED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L20
        L12:
            f393635b = r101;
        }
    }

    /* JADX INFO: loaded from: classes5.dex */
    public static final class c implements bda.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObricPersonalContextSettingServiceImpl f393636a;

        @Override // bda.b
        public final String getScene() {
            return "Personal_Context_Setting";
        }

        public c(ObricPersonalContextSettingServiceImpl r100) {
            this.f393636a = r100;
        }

        @Override // bda.b
        public final Map<String, String> getExt(Map<String, String> r110, bda.b.a r111) {
            Intrinsics.checkNotNullParameter(r110, "originExt");
            if (this.f393636a.q() == false) goto L5;
            String r100 = "1";
        L6:
            String r101 = r100;
            JSONArray r102 = new JSONArray();
            ObricPersonalContextSettingServiceImpl r103 = this.f393636a;
            Object[] r104 = Domain.getEntries().toArray(new Domain[0]);
            int r105 = r104.length;
            int r106 = 0;
        L8:
            if (r106 >= r105) goto L37;
            Domain r112 = (Domain) r104[r106];
            r103.getClass();
            ToggleName r113 = com.obric.assistant.settings.i.b(r112);
            if (b.f393634a[r113.ordinal()] == 1) goto L12;
            boolean r114 = r103.o(r113);
        L34:
            if (r114 == false) goto L36;
            r102.put(r112.getName());
        L36:
            r106 = r106 + 1;
            goto L8
        L12:
            if (Build.VERSION.SDK_INT >= 24) goto L39;
            boolean r107 = r103.o(ToggleName.AI_DIARY);
        L30:
            if (r107 == false) goto L32;
            r114 = r103.o(r113);
            goto L34
        L32:
            r114 = true;
            goto L34
        L39:
            Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L17
            Object r109 = Result.m9449constructorimpl((Boolean) BuildersKt.runBlocking$default(null, new ObricPersonalContextSettingServiceImpl$queryScreenMemoryEnabledWithTimeout$result$1$1(r103, null), 1, null));     // Catch: Throwable -> L17
        L19:
            Throwable r115 = Result.m9452exceptionOrNullimpl(r109);
            if (r115 == null) goto L23;
            FLogger.f375446a.w("ObricPersonalContextSettingKevaUtils", "queryScreenMemoryEnabledWithTimeout failed: " + r115.getMessage(), r115);
        L23:
            if (Result.m9455isFailureimpl(r109) == false) goto L25;
            Object r116 = null;
        L26:
            Boolean r117 = (Boolean) r116;
            if (r117 == null) goto L29;
            r107 = r117.booleanValue();
            goto L30
        L29:
            r107 = r103.o(ToggleName.AI_DIARY);
            goto L30
        L25:
            r116 = r109;
        L17:
            th = move-exception;
            Result.Companion r118 = Result.Companion;
            r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L19
        L37:
            Map<String, String> r119 = MapsKt.mapOf(new Pair[]{TuplesKt.to("o_local_global_search", r101), TuplesKt.to("o_data_source_permission", r102.toString())});
            FLogger.f375446a.i("ObricPersonalContextSettingKevaUtils", "getExt called, scene = Personal_Context_Setting, return map = " + r119);
            return r119;
        L5:
            r100 = "0";
            goto L6
        }
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final boolean t() {
        return true;
    }

    static {
        f393628f = UriProtector.parse("content://com.obric.assistant.provider.ObricPersonalContextProvider/memory_sync");
    }

    public static void A() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L4
        gd9.i r101 = com.larus.im.b.f346407a;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r101);     // Catch: Throwable -> L4
        r101.getApplication().getContentResolver().notifyChange(f393628f, null);     // Catch: Throwable -> L4
        Object r102 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r103 = Result.m9452exceptionOrNullimpl(r102);
        if (r103 == null) goto L12;
        FLogger.f375446a.w("ObricPersonalContextSettingKevaUtils", "notifyReferenceMemorySyncChanged failed: " + r103.getMessage(), r103);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r104 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static Keva y() {
        return Keva.getRepo("obric_settings_" + ILoginService.f286097a.getAccountInfo().f531530c, 0);
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final com.obric.assistant.settings.d1 f() {
        if (ILoginService.f286097a.getAccountInfo().f531528a == true) goto L6;
        return null;
    L6:
        if (y().getBoolean("reference_memory_initialized", false) == true) goto L9;
        return null;
    L9:
        return new com.obric.assistant.settings.d1(i("reference_memory", false), i("reference_memory_personal_info", false));
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final void g() {
        IObricChatService.f386556a.getClass();
        IObricChatService r100 = IObricChatService.a.a();
        if (r100 == null) goto L6;
        r100.g();
        MessageApiImpl.f386895a.g(new c(this));
        return;
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final void u() {
        if (this.f393632d.compareAndSet(false, true) == true) goto L5;
        FLogger.f375446a.i("ObricPersonalContextSettingKevaUtils", "registerReferenceMemoryAccountListener ignored, already registered");
        return;
    L5:
        ILoginService.f286097a.f(this.f393633e, Boolean.TRUE);
    }

    public final Keva x() {
        return (Keva) this.f393629a.getValue();
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.obric.assistant.util.ObricPersonalContextSettingServiceImpl$referenceMemoryAccountListener$1] */
    public ObricPersonalContextSettingServiceImpl() {
        this.f393629a = LazyKt.lazy(new c2());
        this.f393630b = LazyKt.lazy(new d2());
        Boolean r100 = null;
        boolean r101 = true;
        this.f393631c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.f393632d = new AtomicBoolean(false);
        this.f393633e = new ObricPersonalContextSettingServiceImpl$referenceMemoryAccountListener$1(this);
        FLogger r102 = FLogger.f375446a;
        r102.i("ObricPersonalContextSettingKevaUtils", "addAllDataSourceToggles");
        Keva r103 = x();
        ToggleName r104 = ToggleName.MAIN_TOGGLE;
        Boolean r105 = Boolean.valueOf(r103.contains(r104.getToggleName()));
        if ((!r105.booleanValue()) == true) goto L6;
        r105 = null;
    L6:
        if (r105 == null) goto L8;
        r105.booleanValue();
        r103.storeBoolean(r104.getToggleName(), false);
    L8:
        ToggleName r106 = ToggleName.USE_DATA_ON_LOCK_SCREEN;
        Boolean r107 = Boolean.valueOf(r103.contains(r106.getToggleName()));
        if ((!r107.booleanValue()) == true) goto L12;
        r107 = null;
    L12:
        if (r107 == null) goto L17;
        r107.booleanValue();
        boolean r108 = r103.getBoolean(r104.getToggleName(), false);
        r102.i("ObricPersonalContextSettingKevaUtils", "addAllDataSourceToggles, for USE_DATA_ON_LOCK_SCREEN, MAIN_TOGGLE: " + r108);
        if (r108 == false) goto L16;
        r103.storeBoolean(r106.getToggleName(), true);
        goto L17
    L16:
        r103.storeBoolean(r106.getToggleName(), false);
    L17:
        ToggleName r109 = ToggleName.CALL_LOGS;
        Boolean r110 = Boolean.valueOf(r103.contains(r109.getToggleName()));
        if ((!r110.booleanValue()) == true) goto L21;
        r110 = null;
    L21:
        if (r110 == null) goto L23;
        r110.booleanValue();
        r103.storeBoolean(r109.getToggleName(), false);
    L23:
        ToggleName r111 = ToggleName.CONTACTS;
        Boolean r112 = Boolean.valueOf(r103.contains(r111.getToggleName()));
        if ((!r112.booleanValue()) == true) goto L27;
        r112 = null;
    L27:
        if (r112 == null) goto L29;
        r112.booleanValue();
        r103.storeBoolean(r111.getToggleName(), false);
    L29:
        ToggleName r113 = ToggleName.MESSAGE;
        Boolean r114 = Boolean.valueOf(r103.contains(r113.getToggleName()));
        if ((!r114.booleanValue()) == true) goto L33;
        r114 = null;
    L33:
        if (r114 == null) goto L35;
        r114.booleanValue();
        r103.storeBoolean(r113.getToggleName(), false);
    L35:
        ToggleName r115 = ToggleName.CLOCK;
        Boolean r116 = Boolean.valueOf(r103.contains(r115.getToggleName()));
        if ((!r116.booleanValue()) == true) goto L39;
        r116 = null;
    L39:
        if (r116 == null) goto L41;
        r116.booleanValue();
        r103.storeBoolean(r115.getToggleName(), false);
    L41:
        ToggleName r117 = ToggleName.NOTES;
        Boolean r118 = Boolean.valueOf(r103.contains(r117.getToggleName()));
        if ((!r118.booleanValue()) == true) goto L45;
        r118 = null;
    L45:
        if (r118 == null) goto L47;
        r118.booleanValue();
        r103.storeBoolean(r117.getToggleName(), false);
    L47:
        ToggleName r119 = ToggleName.ALBUM;
        Boolean r120 = Boolean.valueOf(r103.contains(r119.getToggleName()));
        if ((!r120.booleanValue()) == true) goto L51;
        r120 = null;
    L51:
        if (r120 == null) goto L53;
        r120.booleanValue();
        r103.storeBoolean(r119.getToggleName(), false);
    L53:
        ToggleName r121 = ToggleName.RECORD;
        Boolean r122 = Boolean.valueOf(r103.contains(r121.getToggleName()));
        if ((!r122.booleanValue()) == true) goto L57;
        r122 = null;
    L57:
        if (r122 == null) goto L59;
        r122.booleanValue();
        r103.storeBoolean(r121.getToggleName(), false);
    L59:
        ToggleName r123 = ToggleName.MEMORY;
        Boolean r124 = Boolean.valueOf(r103.contains(r123.getToggleName()));
        if ((!r124.booleanValue()) == true) goto L63;
        r124 = null;
    L63:
        if (r124 == null) goto L65;
        r124.booleanValue();
        r103.storeBoolean(r123.getToggleName(), false);
    L65:
        ToggleName r125 = ToggleName.FILE_MANAGEMENT;
        Boolean r126 = Boolean.valueOf(r103.contains(r125.getToggleName()));
        if ((!r126.booleanValue()) == true) goto L69;
        r126 = null;
    L69:
        if (r126 == null) goto L71;
        r126.booleanValue();
        r103.storeBoolean(r125.getToggleName(), false);
    L71:
        ToggleName r127 = ToggleName.CALENDAR;
        Boolean r128 = Boolean.valueOf(r103.contains(r127.getToggleName()));
        if ((!r128.booleanValue()) == true) goto L75;
        r128 = null;
    L75:
        if (r128 == null) goto L77;
        r128.booleanValue();
        r103.storeBoolean(r127.getToggleName(), false);
    L77:
        ToggleName r129 = ToggleName.ASSISTANT_ACTIVE_DATA;
        Boolean r130 = Boolean.valueOf(r103.contains(r129.getToggleName()));
        if ((!r130.booleanValue()) == true) goto L81;
        r130 = null;
    L81:
        if (r130 == null) goto L83;
        r130.booleanValue();
        r103.storeBoolean(r129.getToggleName(), false);
    L83:
        Boolean r131 = Boolean.valueOf(r103.contains("obric_personal_context_data_domain_dialog_shown"));
        if ((!r131.booleanValue()) == true) goto L87;
        r131 = null;
    L87:
        if (r131 == null) goto L89;
        r131.booleanValue();
        r103.storeBoolean("obric_personal_context_data_domain_dialog_shown", false);
    L89:
        ToggleName r132 = ToggleName.AI_DIARY;
        Boolean r133 = Boolean.valueOf(r103.contains(r132.getToggleName()));
        if ((!r133.booleanValue()) == true) goto L93;
        r133 = null;
    L93:
        if (r133 == null) goto L95;
        r133.booleanValue();
        r102.i("ObricPersonalContextSettingKevaUtils", "addAllDataSourceToggles， init local data search, AI_DIARY");
        r103.storeBoolean(r132.getToggleName(), false);
    L95:
        ToggleName r134 = ToggleName.HEARING_MEMORY;
        Boolean r135 = Boolean.valueOf(r103.contains(r134.getToggleName()));
        if ((!r135.booleanValue()) == true) goto L99;
        r135 = null;
    L99:
        if (r135 == null) goto L101;
        r135.booleanValue();
        r102.i("ObricPersonalContextSettingKevaUtils", "addAllDataSourceToggles， init local data search, HEARING_MEMORY");
        r103.storeBoolean(r134.getToggleName(), false);
    L101:
        ToggleName r136 = ToggleName.SCREEN_MEMORY;
        Boolean r137 = Boolean.valueOf(r103.contains(r136.getToggleName()));
        if ((!r137.booleanValue()) == true) goto L105;
        r137 = null;
    L105:
        if (r137 == null) goto L107;
        r137.booleanValue();
        r102.i("ObricPersonalContextSettingKevaUtils", "addAllDataSourceToggles， init local data search, SCREEN_MEMORY");
        r103.storeBoolean(r136.getToggleName(), false);
    L107:
        ToggleName r138 = ToggleName.PERSONAL_INFO_MEMORY;
        Boolean r139 = Boolean.valueOf(r103.contains(r138.getToggleName()));
        if ((!r139.booleanValue()) == true) goto L111;
        r139 = null;
    L111:
        if (r139 == null) goto L113;
        r139.booleanValue();
        r102.i("ObricPersonalContextSettingKevaUtils", "addAllDataSourceToggles， init local data search, PERSONAL_INFO_MEMORY");
        r103.storeBoolean(r138.getToggleName(), false);
    L113:
        ToggleName r140 = ToggleName.COLLECTION_MEMORY;
        Boolean r141 = Boolean.valueOf(r103.contains(r140.getToggleName()));
        if ((!r141.booleanValue()) == true) goto L117;
        r141 = null;
    L117:
        if (r141 == null) goto L119;
        r141.booleanValue();
        r102.i("ObricPersonalContextSettingKevaUtils", "addAllDataSourceToggles， init local data search, COLLECTION_MEMORY");
        r103.storeBoolean(r140.getToggleName(), false);
    L119:
        Boolean r142 = Boolean.valueOf(r103.contains("obric_local_data_search_enable"));
        if ((!r142.booleanValue()) == true) goto L123;
        r142 = null;
    L123:
        if (r142 == null) goto L141;
        r142.booleanValue();
        EnumEntries<ToggleName> r143 = ToggleName.getEntries();
        ArrayList r144 = new ArrayList();
        Iterator<ToggleName> r145 = r143.iterator();
    L126:
        if (r145.hasNext() == false) goto L131;
        ToggleName r146 = r145.next();
        if ((!r146.isDeprecated()) == false) goto L126;
        r144.add(r146);
        goto L126
    L131:
        if (r144.isEmpty() == true) goto L139;
        Iterator r147 = r144.iterator();
    L135:
        if (r147.hasNext() == false) goto L139;
        if (r103.getBoolean(((ToggleName) r147.next()).getToggleName(), false) == false) goto L135;
        boolean r148 = true;
    L140:
        FLogger.f375446a.i("ObricPersonalContextSettingKevaUtils", "addAllDataSourceToggles， init local data search, historicalEnable: " + r148);
        r103.storeBoolean("obric_local_data_search_enable", r148);
    L139:
        r148 = false;
    L141:
        Boolean r149 = Boolean.valueOf(r103.contains("obric_local_data_search_init_permission_request_timestamp"));
        if ((!r149.booleanValue()) == true) goto L145;
        r149 = null;
    L145:
        if (r149 == null) goto L147;
        r149.booleanValue();
        r103.storeLong("obric_local_data_search_init_permission_request_timestamp", 0);
    L147:
        Boolean r150 = Boolean.valueOf(r103.contains(ToggleName.GLOBAL_MEMORY.getToggleName()));
        if ((!r150.booleanValue()) == false) goto L150;
        r100 = r150;
    L150:
        if (r100 == null) goto L181;
        r100.booleanValue();
        List r151 = CollectionsKt.listOf(new ToggleName[]{ToggleName.HEARING_MEMORY, ToggleName.SCREEN_MEMORY, ToggleName.COLLECTION_MEMORY, ToggleName.PERSONAL_INFO_MEMORY});
        List r152 = r151;
        if ((r152 instanceof Collection) == true) goto L154;
    L156:
        Iterator r153 = r152.iterator();
    L158:
        if (r153.hasNext() == false) goto L162;
        if (r103.getBoolean(((ToggleName) r153.next()).getToggleName(), false) == false) goto L158;
    L163:
        Iterator r154 = CollectionsKt.plus(r151, ToggleName.GLOBAL_MEMORY).iterator();
    L165:
        if (r154.hasNext() == false) goto L167;
        r103.storeBoolean(((ToggleName) r154.next()).getToggleName(), r101);
        goto L165
    L167:
        FLogger.f375446a.i("ObricPersonalContextSettingKevaUtils", "addAllDataSourceToggles， init global memory, anyOriginalSwitchOpen: " + r101);
        return;
    L162:
        r101 = false;
        goto L163
    L154:
        if (r152.isEmpty() == false) goto L156;
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final Object a() {
        return x();
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final boolean c() {
        boolean r100 = x().getBoolean(ToggleName.MAIN_TOGGLE.getToggleName(), false);
        FLogger.f375446a.i("ObricPersonalContextSettingKevaUtils", "isPersonalContextOpened: " + r100);
        return r100;
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final long e() {
        long r100 = x().getLong("obric_local_data_search_init_permission_request_timestamp", 0);
        FLogger.f375446a.i("ObricPersonalContextSettingKevaUtils", "getLastLocalDataSearchInitPermissionRequestTimestamp, " + r100);
        return r100;
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final boolean q() {
        boolean r100 = x().getBoolean("obric_local_data_search_enable", false);
        FLogger.f375446a.i("ObricPersonalContextSettingKevaUtils", "isLocalDataSearchEnabled, " + r100);
        return r100;
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final Class<? extends Activity> h() {
        return ObricPersonalContextSettingActivity.class;
    }

    public static IObricPermissionService.Companion.ObricPermissionStatus w(ToggleName r100) {
        boolean r101 = true;
        if (r100 != ToggleName.ALBUM) goto L12;
        IObricPermissionService r102 = (IObricPermissionService) ServiceManager.get().getService(IObricPermissionService.class);
        if (r102 == null) goto L7;
        IObricPermissionService.Companion.ObricPermissionStatus r103 = r102.h();
    L9:
        if (r103 != IObricPermissionService.Companion.ObricPermissionStatus.DENIED) goto L24;
        r101 = false;
    L24:
        if (r101 == false) goto L27;
        return IObricPermissionService.Companion.ObricPermissionStatus.GRANTED;
    L27:
        return IObricPermissionService.Companion.ObricPermissionStatus.DENIED;
    L7:
        r103 = null;
        goto L9
    L12:
        Iterator<T> r104 = com.obric.assistant.settings.i.a(r100).iterator();
        boolean r105 = true;
    L14:
        if (r104.hasNext() == false) goto L23;
        String r106 = (String) r104.next();
        IObricPermissionService r107 = (IObricPermissionService) ServiceManager.get().getService(IObricPermissionService.class);
        if (r107 != null) goto L18;
    L20:
        boolean r108 = false;
    L21:
        if (r108 == false) goto L14;
        r105 = false;
        goto L14
    L18:
        if (r107.checkPermission(r106) == true) goto L20;
        r108 = true;
        goto L21
    L23:
        r101 = r105;
        goto L24
    }

    public static boolean z(String r100) {
        if ((!StringsKt.isBlank(r100)) == false) goto L9;
        ILoginService.Companion r101 = ILoginService.f286097a;
        if (r101.getAccountInfo().f531528a == false) goto L9;
        if (Intrinsics.areEqual(r101.getAccountInfo().f531530c, r100) == false) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x009a -> B:48:0x00ad). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00ab -> B:47:0x00ac). Please report as a decompilation issue!!! */
    public final Object B(Continuation<? super vea.m> r110) {
        if ((r110 instanceof ObricPersonalContextSettingServiceImpl$requestReferenceMemoryCloudConfigWithRetry$1) == false) goto L7;
        ObricPersonalContextSettingServiceImpl$requestReferenceMemoryCloudConfigWithRetry$1 r100 = (ObricPersonalContextSettingServiceImpl$requestReferenceMemoryCloudConfigWithRetry$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L22;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        int r104 = r100.I$1;
        int r105 = r100.I$0;
        ResultKt.throwOnFailure(r111);
    L47:
        int r106 = r105;
    L48:
        int r107 = r104 + 1;
    L23:
        if (r107 >= r106) goto L50;
        int r108 = r107 + 1;
        IObricNetworkService r112 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);     // Catch: CancellationException -> L20 Exception -> L34
        if (r112 == null) goto L33;
        r100.I$0 = r106;     // Catch: CancellationException -> L20 Exception -> L34
        r100.I$1 = r107;     // Catch: CancellationException -> L20 Exception -> L34
        r100.I$2 = r107;     // Catch: CancellationException -> L20 Exception -> L34
        r100.I$3 = r108;     // Catch: CancellationException -> L20 Exception -> L34
        r100.label = 1;     // Catch: CancellationException -> L20 Exception -> L34
        r111 = r112.i(r100);     // Catch: CancellationException -> L20 Exception -> L34
        if (r111 != r102) goto L30;
        return r102;
    L30:
        int r109 = r107;
    L31:
        vea.m r113 = (vea.m) r111;     // Catch: Exception -> L18 CancellationException -> L20
    L39:
        r104 = r109;
        if (r113 == null) goto L42;
        return r113;
    L42:
        if (r107 >= 2) goto L48;
        r100.I$0 = r106;
        r100.I$1 = r104;
        r100.label = 2;
        if (DelayKt.delay(1000, r100) != r102) goto L46;
        return r102;
    L46:
        r105 = r106;
    L18:
        Exception e100 = e;
    L36:
        if (r108 != 3) goto L38;
        FLogger.f375446a.w("ObricPersonalContextSettingKevaUtils", "requestReferenceMemoryCloudConfigWithRetry failed, attempt=" + r108, e100);
    L38:
        r113 = null;
        goto L39
    L33:
        r113 = null;
        r109 = r107;
    L20:
        e = move-exception;
        throw e;
    L34:
        e100 = e;
        r109 = r107;
        goto L36
    L50:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r108 = r100.I$3;
        r107 = r100.I$2;
        r109 = r100.I$1;
        r106 = r100.I$0;
        ResultKt.throwOnFailure(r111);     // Catch: Exception -> L18 CancellationException -> L20
        goto L31
    L22:
        ResultKt.throwOnFailure(r111);
        r107 = 0;
        r106 = 3;
    L7:
        r100 = new ObricPersonalContextSettingServiceImpl$requestReferenceMemoryCloudConfigWithRetry$1(this, r110);
        goto L8
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final void b(long r100) {
        FLogger.f375446a.i("ObricPersonalContextSettingKevaUtils", "setLastLocalDataSearchInitPermissionRequestTimestamp, " + r100);
        x().storeLong("obric_local_data_search_init_permission_request_timestamp", r100);
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final boolean l(ToggleName r100) {
        Intrinsics.checkNotNullParameter(r100, "toggleName");
        int r101 = b.f393634a[r100.ordinal()];
        if (r101 != 2) goto L5;
    L11:
        return true;
    L5:
        if (r101 == 3) goto L11;
        if (r101 == 4) goto L11;
        if (r101 == 5) goto L11;
        return false;
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final void m(boolean r100) {
        FLogger.f375446a.i("ObricPersonalContextSettingKevaUtils", "setLocalDataSearchEnabled, " + r100);
        x().storeBoolean("obric_local_data_search_enable", r100);
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final void n(ToggleName r100) {
        Intrinsics.checkNotNullParameter(r100, "toggleName");
        if (q() == true) goto L5;
        return;
    L5:
        x().storeBoolean(r100.getToggleName(), true);
        FLogger.f375446a.i("ObricPersonalContextSettingKevaUtils", "addTurnOnSwitch: " + r100);
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final boolean o(ToggleName r100) {
        Intrinsics.checkNotNullParameter(r100, "toggleName");
        if (q() == true) goto L5;
        return false;
    L5:
        Intrinsics.checkNotNullParameter(r100, "toggleName");
        if ((!com.obric.assistant.settings.i.a(r100).isEmpty()) == false) goto L12;
        if (w(r100) == IObricPermissionService.Companion.ObricPermissionStatus.DENIED) goto L17;
        return true;
    L17:
        return false;
    L12:
        if (l(r100) == false) goto L16;
        return x().getBoolean(ToggleName.GLOBAL_MEMORY.getToggleName(), false);
    L16:
        return x().getBoolean(r100.getToggleName(), false);
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final void p(ToggleName r100) {
        Intrinsics.checkNotNullParameter(r100, "toggleName");
        if (q() == true) goto L5;
        return;
    L5:
        x().storeBoolean(r100.getToggleName(), false);
        FLogger.f375446a.i("ObricPersonalContextSettingKevaUtils", "removeTurnOffSwitch: " + r100);
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final Object r(Continuation<? super Boolean> r100) {
        if ((r100 instanceof ObricPersonalContextSettingServiceImpl$updateReferenceMemoryCloudConfig$1) == false) goto L7;
        ObricPersonalContextSettingServiceImpl$updateReferenceMemoryCloudConfig$1 r101 = (ObricPersonalContextSettingServiceImpl$updateReferenceMemoryCloudConfig$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        boolean r106 = true;
        if (r105 == 0) goto L16;
        if (r105 != 1) goto L15;
        String r107 = (String) r101.L$0;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L42 CancellationException -> L46
    L25:
        vea.m r108 = (vea.m) r103;     // Catch: Exception -> L42 CancellationException -> L46
        if (z(r107) == true) goto L29;
        FLogger.f375446a.i("ObricPersonalContextSettingKevaUtils", "updateReferenceMemoryCloudConfig ignored, account changed");     // Catch: Exception -> L42 CancellationException -> L46
        return Boxing.boxBoolean(false);
    L29:
        if (r108 != null) goto L33;
        FLogger.f375446a.i("ObricPersonalContextSettingKevaUtils", "updateReferenceMemoryCloudConfig failed after retry");     // Catch: Exception -> L42 CancellationException -> L46
        return Boxing.boxBoolean(false);
    L33:
        if (r108.a() == null) goto L35;
    L37:
        boolean r109 = false;
    L38:
        if (r109 == false) goto L40;
        Boolean r110 = Boolean.FALSE;     // Catch: Exception -> L42 CancellationException -> L46
        C(this, new vea.m(r110, r110));     // Catch: Exception -> L42 CancellationException -> L46
    L45:
        return Boxing.boxBoolean(r106);
    L40:
        C(this, r108);     // Catch: Exception -> L42 CancellationException -> L46
        goto L45
    L35:
        if (r108.b() != null) goto L37;
        r109 = true;
        goto L38
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r103);
        ILoginService.Companion r111 = ILoginService.f286097a;
        String r112 = r111.getAccountInfo().f531530c;
        if (StringsKt.isBlank(r112) == false) goto L19;
    L48:
        FLogger.f375446a.i("ObricPersonalContextSettingKevaUtils", "updateReferenceMemoryCloudConfig ignored, not login");
        return Boxing.boxBoolean(false);
    L19:
        if (r111.getAccountInfo().f531528a == false) goto L48;
        r101.L$0 = r112;     // Catch: Exception -> L42 CancellationException -> L46
        r101.label = 1;     // Catch: Exception -> L42 CancellationException -> L46
        r103 = B(r101);     // Catch: Exception -> L42 CancellationException -> L46
        if (r103 != r104) goto L24;
        return r104;
    L24:
        r107 = r112;
    L46:
        e = move-exception;
        throw e;
    L42:
        e = move-exception;
        FLogger.f375446a.e("ObricPersonalContextSettingKevaUtils", "updateReferenceMemoryCloudConfig failed", e);
        r106 = false;
    L7:
        r101 = new ObricPersonalContextSettingServiceImpl$updateReferenceMemoryCloudConfig$1(this, r100);
        goto L8
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final String s(ToggleName r100) {
        Intrinsics.checkNotNullParameter(r100, "toggleName");
        if (q() == true) goto L7;
        return "unavailable";
    L7:
        if (r100 != ToggleName.ALBUM) goto L23;
        IObricPermissionService r101 = (IObricPermissionService) ServiceManager.get().getService(IObricPermissionService.class);
        if (r101 == null) goto L11;
        IObricPermissionService.Companion.ObricPermissionStatus r102 = r101.h();
    L12:
        if (r102 != null) goto L14;
        int r103 = -1;
    L16:
        if (r103 != 1) goto L18;
        return "allow";
    L18:
        if (r103 != 2) goto L28;
        return "limited";
    L28:
        return "reject";
    L14:
        r103 = b.f393635b[r102.ordinal()];
        goto L16
    L11:
        r102 = null;
        goto L12
    L23:
        if (o(r100) == false) goto L26;
        return "allow";
    L26:
        return "reject";
    }

    public static void C(ObricPersonalContextSettingServiceImpl r100, vea.m r101) {
        r100.getClass();
        Boolean r102 = r101.a();
        boolean r103 = false;
        if (r102 == null) goto L5;
        boolean r104 = r102.booleanValue();
    L6:
        Boolean r105 = Boolean.valueOf(r104);
        Boolean r106 = r101.b();
        if (r106 == null) goto L9;
        r103 = r106.booleanValue();
    L9:
        vea.m r107 = new vea.m(r105, Boolean.valueOf(r103));
        Keva r108 = y();
        Boolean r109 = r107.a();
        Boolean r110 = Boolean.TRUE;
        r108.storeBoolean("reference_memory", Intrinsics.areEqual(r109, r110));
        y().storeBoolean("reference_memory_personal_info", Intrinsics.areEqual(r107.b(), r110));
        y().storeBoolean("reference_memory_initialized", true);
        A();
        return;
    L5:
        r104 = false;
        goto L6
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final boolean i(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        if (Intrinsics.areEqual(r100, "reference_memory") == false) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == true) goto L12;
        return r101;
    L12:
        return y().getBoolean(r100, r101);
    L5:
        if (Intrinsics.areEqual(r100, "reference_memory_personal_info") == true) goto L8;
        r102 = false;
        goto L9
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final boolean j(ToggleName r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "toggleName");
        if (q() == true) goto L5;
        return r101;
    L5:
        Intrinsics.checkNotNullParameter(r100, "toggleName");
        if ((!com.obric.assistant.settings.i.a(r100).isEmpty()) == false) goto L13;
        if (w(r100) != IObricPermissionService.Companion.ObricPermissionStatus.DENIED) goto L18;
        return false;
    L18:
        return true;
    L13:
        if (l(r100) == false) goto L17;
        return x().getBoolean(ToggleName.GLOBAL_MEMORY.getToggleName(), r101);
    L17:
        return x().getBoolean(r100.getToggleName(), r101);
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final LiveData<Pair<Boolean, List<SelectableToggleItem>>> k(FragmentActivity r100, final List<SelectableToggleItem> r101) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "toggleList");
        int r102 = LocalDataSearchSelectFragment.f391702a;
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, "toggleList");
        final MutableLiveData r103 = new MutableLiveData();     // Catch: Exception -> L10
        final RecyclerView r104 = new RecyclerView(r100);     // Catch: Exception -> L10
        r104.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));     // Catch: Exception -> L10
        r104.setClipToPadding(false);     // Catch: Exception -> L10
        r104.setPadding(i5.r0(), 0, i5.r0(), i5.E());     // Catch: Exception -> L10
        r104.setLayoutManager(new LinearLayoutManager(r104.getContext(), 1, false));     // Catch: Exception -> L10
        r104.setAdapter(new LocalDataSearchSelectFragment.Adapter(r101));     // Catch: Exception -> L10
        r104.addItemDecoration(new LocalDataSearchSelectFragment.Decoration(r104.getContext()));     // Catch: Exception -> L10
        com.obric.oui.dialog.v2.alert.g r105 = new com.obric.oui.dialog.v2.alert.g(r100);     // Catch: Exception -> L10
        r105.f400759w = false;     // Catch: Exception -> L10
        String r106 = r100.getString(R.string.obric_local_data_search_select_title);     // Catch: Exception -> L10
        r105.f400746j = false;     // Catch: Exception -> L10
        r105.f400744h = r106;     // Catch: Exception -> L10
        zla.g r107 = new zla.g(new com.obric.assistant.settings.n(r104));     // Catch: Exception -> L10
        Intrinsics.checkNotNullParameter(r107, "controller");     // Catch: Exception -> L10
        r105.f400760x = r107;     // Catch: Exception -> L10
        com.obric.oui.dialog.v2.alert.g.c(r105);     // Catch: Exception -> L10
        r105.e(r100.getString(R.string.obric_local_data_search_select_btn_cancel), new com.obric.assistant.settings.o(r103));     // Catch: Exception -> L10
        r105.h(r100.getString(R.string.obric_local_data_search_select_btn_confirm), new com.obric.assistant.settings.p(r103, r101));     // Catch: Exception -> L10
        com.obric.oui.dialog.v2.alert.c r108 = r105.a();     // Catch: Exception -> L10
        if (DialogLancet.shouldBlockDialogShow(r108) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r108);     // Catch: Exception -> L10
    L14:
        return r103;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L8:
        DialogLancet.beforeDialogShow(r108);     // Catch: Exception -> L10
        r108.show();     // Catch: Exception -> L10
        DialogLancet.afterDialogShow(r108);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        FLogger.f375446a.e("LocalDataSearchSelectFragment", "find LocalDataSearchSelectFragment exception: " + e);
        return null;
    }

    public final vea.m v(String r100, boolean r101) {
        boolean r102 = false;
        boolean r103 = i("reference_memory", false);
        if (Intrinsics.areEqual("reference_memory", r100) == false) goto L5;
        boolean r104 = r101;
    L6:
        boolean r105 = Intrinsics.areEqual(r100, "reference_memory");
        if (r105 == true) goto L11;
        r103 = r104;
    L11:
        if (r105 == false) goto L15;
        if (r101 == false) goto L15;
        r100 = "reference_memory_personal_info";
    L15:
        if (Intrinsics.areEqual("reference_memory_personal_info", r100) == true) goto L18;
        r101 = i("reference_memory_personal_info", r103);
    L18:
        if (r105 == false) goto L20;
        r102 = r104;
    L24:
        return new vea.m(Boolean.valueOf(r102), Boolean.valueOf(r101));
    L20:
        if (r104 == false) goto L24;
        if (r101 == false) goto L24;
        r102 = true;
        goto L24
    L5:
        r104 = i("reference_memory", false);
        goto L6
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final Object d(String r110, boolean r111, Continuation<? super Boolean> r112) {
        if ((r112 instanceof ObricPersonalContextSettingServiceImpl$setReferenceMemoryToggleEnabledWithSync$1) == false) goto L7;
        ObricPersonalContextSettingServiceImpl$setReferenceMemoryToggleEnabledWithSync$1 r100 = (ObricPersonalContextSettingServiceImpl$setReferenceMemoryToggleEnabledWithSync$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r113 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        boolean r105 = false;
        if (r103 == 0) goto L20;
        if (r103 != 1) goto L19;
        boolean r114 = r100.Z$0;
        vea.m r115 = (vea.m) r100.L$2;
        String r106 = (String) r100.L$1;
        String r107 = (String) r100.L$0;
        ResultKt.throwOnFailure(r113);     // Catch: Exception -> L14 CancellationException -> L16
        r111 = r114;
        r110 = r107;
        Object r108 = r113;
        vea.m r116 = r115;
    L67:
        if (((Boolean) r108).booleanValue() == true) goto L48;
        String r109 = r106;
    L47:
        r106 = r109;
        r104 = false;
    L48:
        if (r104 == true) goto L50;
    L54:
        r105 = r104;
    L59:
        return Boxing.boxBoolean(r105);
    L50:
        if (z(r106) == true) goto L53;
        FLogger.f375446a.i("ObricPersonalContextSettingKevaUtils", "setReferenceMemoryToggleEnabledWithSync ignored, account changed");     // Catch: CancellationException -> L16 Exception -> L55
        return Boxing.boxBoolean(false);
    L53:
        C(this, r116);     // Catch: CancellationException -> L16 Exception -> L55
    L45:
        e = move-exception;
        r107 = r110;
        r114 = r111;
        Exception e100 = e;
    L57:
        FLogger.f375446a.e("ObricPersonalContextSettingKevaUtils", "setReferenceMemoryToggleEnabledWithSync failed, key=" + r107 + ", enabled=" + r114, e100);
    L14:
        e100 = e;
        goto L57
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r113);
        if (Intrinsics.areEqual(r110, "reference_memory") == false) goto L23;
    L26:
        boolean r117 = true;
    L27:
        if (r117 == false) goto L29;
        ILoginService.Companion r118 = ILoginService.f286097a;
        r109 = r118.getAccountInfo().f531530c;
        if (StringsKt.isBlank(r109) == false) goto L33;
    L61:
        FLogger.f375446a.w("ObricPersonalContextSettingKevaUtils", "setReferenceMemoryToggleEnabledWithSync ignored, not login");
        return Boxing.boxBoolean(false);
    L33:
        if (r118.getAccountInfo().f531528a == false) goto L61;
        r116 = v(r110, r111);     // Catch: CancellationException -> L16 Exception -> L55
        IObricNetworkService r119 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);     // Catch: CancellationException -> L16 Exception -> L55
        if (r119 == null) goto L47;
        r100.L$0 = r110;     // Catch: CancellationException -> L16 Exception -> L55
        r100.L$1 = r109;     // Catch: CancellationException -> L16 Exception -> L55
        r100.L$2 = r116;     // Catch: CancellationException -> L16 Exception -> L55
        r100.Z$0 = r111;     // Catch: CancellationException -> L16 Exception -> L55
        r100.label = 1;     // Catch: CancellationException -> L16 Exception -> L55
        r108 = r119.j(r116, r100);     // Catch: CancellationException -> L16 Exception -> L55
        if (r108 != r102) goto L40;
        return r102;
    L40:
        r106 = r109;
    L55:
        e = move-exception;
        e100 = e;
        r107 = r110;
        r114 = r111;
        goto L57
    L29:
        return Boxing.boxBoolean(false);
    L23:
        if (Intrinsics.areEqual(r110, "reference_memory_personal_info") == true) goto L26;
        r117 = false;
    L16:
        e = move-exception;
        throw e;
    L7:
        r100 = new ObricPersonalContextSettingServiceImpl$setReferenceMemoryToggleEnabledWithSync$1(this, r112);
        goto L8
    }
}
