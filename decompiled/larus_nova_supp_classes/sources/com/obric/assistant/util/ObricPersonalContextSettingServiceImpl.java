package com.obric.assistant.util;

import android.app.Activity;
import android.net.Uri;
import android.util.EventsUtils;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.account.base.api.ILoginService;
import com.larus.im.b;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.impl.MessageApiImpl;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.network.api.IObricNetworkService;
import com.obric.assistant.permission.IObricPermissionService;
import com.obric.assistant.settings.IObricPersonalContextSettingApi;
import com.obric.assistant.settings.LocalDataSearchSelectFragment;
import com.obric.assistant.settings.SelectableToggleItem;
import com.obric.assistant.settings.ToggleName;
import com.obric.assistant.settings.d1;
import com.obric.assistant.settings.memory.ObricPersonalContextSettingActivity;
import com.obric.assistant.settings.n;
import com.obric.assistant.settings.o;
import com.obric.assistant.settings.p;
import com.obric.oui.dialog.v2.alert.c;
import com.obric.oui.dialog.v2.alert.g;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import gd9.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.xmlpull.v1.XmlPullParser;
import v19.i5;
import vea.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000¡\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0016\b\u0007\u0018\u0000 f2\u00020\u0001:\u0001fB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\u0018\u0010 \u001a\u0004\u0018\u00010\u001c2\u0006\u0010!\u001a\u00020\"H\u0082@¢\u0006\u0002\u0010#J\b\u0010$\u001a\u00020\u001cH\u0016J\b\u0010%\u001a\u00020\u0019H\u0016J\b\u0010&\u001a\u00020\u0019H\u0016J\u0010\u0010'\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020\u00192\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010+\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)H\u0016J\u0018\u0010+\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)2\u0006\u0010,\u001a\u00020\u001cH\u0016J\u0018\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/2\u0006\u0010,\u001a\u00020\u001cH\u0016J\n\u00100\u001a\u0004\u0018\u000101H\u0016J\u000e\u00102\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u00103J\u0010\u00104\u001a\u0004\u0018\u000105H\u0082@¢\u0006\u0002\u00103J\u001e\u00106\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/2\u0006\u00107\u001a\u00020\u001cH\u0096@¢\u0006\u0002\u00108J\u001a\u00109\u001a\u00020\u00192\u0006\u0010:\u001a\u0002052\b\b\u0002\u0010;\u001a\u00020\u001cH\u0002J\b\u0010<\u001a\u000205H\u0002J\f\u0010=\u001a\u00020\u001c*\u000205H\u0002J\u0018\u0010>\u001a\u0002052\u0006\u0010.\u001a\u00020/2\u0006\u00107\u001a\u00020\u001cH\u0002J(\u0010?\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/2\u0006\u0010,\u001a\u00020\u001c2\u0006\u0010@\u001a\u00020/2\u0006\u0010A\u001a\u00020\u001cH\u0002J\u0010\u0010B\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020/H\u0002J\u0010\u0010C\u001a\u00020\u001c2\u0006\u0010D\u001a\u00020/H\u0002J\b\u0010E\u001a\u00020\u0019H\u0002J\b\u0010F\u001a\u00020\u0019H\u0002J\b\u0010G\u001a\u00020\u001cH\u0016J\u0010\u0010H\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u001cH\u0016J\b\u0010J\u001a\u00020\u001cH\u0016J\u0010\u0010K\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u001cH\u0016J\b\u0010L\u001a\u00020\u0019H\u0002J\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020\u001cH\u0016J\b\u0010P\u001a\u00020\u001cH\u0016J\u0010\u0010Q\u001a\u00020\u00192\u0006\u0010I\u001a\u00020\u001cH\u0016J\u0010\u0010R\u001a\u00020/2\u0006\u0010(\u001a\u00020)H\u0016J\b\u0010S\u001a\u00020\"H\u0016J\u0010\u0010T\u001a\u00020\u00192\u0006\u0010U\u001a\u00020\"H\u0016J\u0018\u0010V\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010W2\u0006\u0010X\u001a\u00020YH\u0016J8\u0010Z\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u00020]0\\0[\u0018\u00010W2\u0006\u0010X\u001a\u00020Y2\f\u0010^\u001a\b\u0012\u0004\u0012\u00020]0\\H\u0016J\u0010\u0010_\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010`\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020)H\u0016J\u0012\u0010a\u001a\f\u0012\u0006\b\u0001\u0012\u00020c\u0018\u00010bH\u0016J\u0010\u0010d\u001a\u00020e2\u0006\u0010(\u001a\u00020)H\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\n\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007R\u001d\u0010\f\u001a\u0004\u0018\u00010\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\t\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006g"}, d2 = {"Lcom/obric/assistant/util/ObricPersonalContextSettingServiceImpl;", "Lcom/obric/assistant/settings/IObricPersonalContextSettingApi;", "<init>", "()V", "keva", "Lcom/bytedance/keva/Keva;", "getKeva", "()Lcom/bytedance/keva/Keva;", "keva$delegate", "Lkotlin/Lazy;", "referenceMemoryKeva", "getReferenceMemoryKeva", "aiLabService", "Lcom/obric/assistant/settings/IAILabService;", "getAiLabService", "()Lcom/obric/assistant/settings/IAILabService;", "aiLabService$delegate", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "referenceMemoryAccountListenerRegistered", "Ljava/util/concurrent/atomic/AtomicBoolean;", "referenceMemoryAccountListener", "com/obric/assistant/util/ObricPersonalContextSettingServiceImpl$referenceMemoryAccountListener$1", "Lcom/obric/assistant/util/ObricPersonalContextSettingServiceImpl$referenceMemoryAccountListener$1;", "initReferenceMemorySync", XmlPullParser.NO_NAMESPACE, "registerMessageExt", "shouldCarryDomain", XmlPullParser.NO_NAMESPACE, "domain", "Lcom/obric/assistant/settings/Domain;", "queryScreenMemoryEnabledWithTimeout", "queryScreenMemoryEnabledSuspend", "timeoutMillis", XmlPullParser.NO_NAMESPACE, "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isPersonalContextOpened", "personalContextOn", "personalContextOff", "turnOnToggle", "toggleName", "Lcom/obric/assistant/settings/ToggleName;", "turnOffToggle", "isToggleOn", "defVal", "isReferenceMemoryToggleEnabled", "key", XmlPullParser.NO_NAMESPACE, "getReferenceMemorySyncSnapshot", "Lcom/obric/assistant/settings/ReferenceMemorySyncSnapshot;", "updateReferenceMemoryCloudConfig", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestReferenceMemoryCloudConfigWithRetry", "Lcom/obric/assistant/network/api/bean/ObricReferenceMemoryConfig;", "setReferenceMemoryToggleEnabledWithSync", "enabled", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncReferenceMemoryLocalCache", "config", "notifyChanged", "getDefaultReferenceMemoryConfig", "isEmpty", "buildReferenceMemoryConfig", "getReferenceMemoryValue", "overrideKey", "overrideValue", "isReferenceMemoryKey", "isSameLoginUser", "requestUserId", "registerReferenceMemoryAccountListener", "notifyReferenceMemorySyncChanged", "isUseDataOnLockScreenEnabled", "setUseDataOnLockScreen", "enable", "isDataDomainDialogAlreadyShown", "setDataDomainDialogAlreadyShown", "addAllDataSourceToggles", "getKevaRepo", XmlPullParser.NO_NAMESPACE, "isHideEventMemory", "isLocalDataSearchEnabled", "setLocalDataSearchEnabled", "getLocalDataSearchSwitchReportValue", "getLastLocalDataSearchInitPermissionRequestTimestamp", "setLastLocalDataSearchInitPermissionRequestTimestamp", "timestamp", "showLocalDataSearchConfirmFragment", "Landroidx/lifecycle/LiveData;", "activity", "Landroidx/fragment/app/FragmentActivity;", "showLocalDataSearchSelectFragment", "Lkotlin/Pair;", XmlPullParser.NO_NAMESPACE, "Lcom/obric/assistant/settings/SelectableToggleItem;", "toggleList", "isGovernedByNewGlobalMemorySwitch", "isGovernedBySystemPermission", "getObricPersonalContextSettingsClassName", "Ljava/lang/Class;", "Landroid/app/Activity;", "checkSystemPermissionByToggle", "Lcom/obric/assistant/permission/IObricPermissionService$Companion$ObricPermissionStatus;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ObricPersonalContextSettingServiceImpl implements IObricPersonalContextSettingApi {
    public static final Uri f = null;
    public final Lazy a;
    public final Lazy b;
    public final CoroutineScope c;
    public final AtomicBoolean d;
    public final ObricPersonalContextSettingServiceImpl$referenceMemoryAccountListener$1 e;

    public static final class a {
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final boolean t() {
        return true;
    }

    static {
        f = UriProtector.parse("content://com.obric.assistant.provider.ObricPersonalContextProvider/memory_sync");
    }

    public static void A() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L4
        i r1 = b.a;     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r1);     // Catch: Throwable -> L4
        r1.getApplication().getContentResolver().notifyChange(f, null);     // Catch: Throwable -> L4
        Object r2 = Result.m49constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L4
    L6:
        Throwable r3 = Result.m52exceptionOrNullimpl(r2);
        if (r3 == null) goto L12;
        FLogger.a.w("ObricPersonalContextSettingKevaUtils", "notifyReferenceMemorySyncChanged failed: " + r3.getMessage(), r3);
        return;
    L12:
        return;
    L4:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r2 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L6
    }

    public static Keva y() {
        return Keva.getRepo("obric_settings_" + ILoginService.a.getAccountInfo().c, 0);
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final d1 f() {
        if (ILoginService.a.getAccountInfo().a == true) goto L6;
        return null;
    L6:
        if (y().getBoolean("reference_memory_initialized", false) == true) goto L9;
        return null;
    L9:
        return new d1(i("reference_memory", false), i("reference_memory_personal_info", false));
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final void g() {
        IObricChatService.a.getClass();
        IObricChatService r0 = IObricChatService.a.a();
        if (r0 == null) goto L6;
        r0.g();
        MessageApiImpl.a.g(new c(this));
        return;
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final void u() {
        if (this.d.compareAndSet(false, true) == true) goto L5;
        FLogger.a.i("ObricPersonalContextSettingKevaUtils", "registerReferenceMemoryAccountListener ignored, already registered");
        return;
    L5:
        ILoginService.a.f(this.e, Boolean.TRUE);
    }

    public final Keva x() {
        return (Keva) this.a.getValue();
    }

    /* JADX WARN: Type inference failed for: r2v4, types: [com.obric.assistant.util.ObricPersonalContextSettingServiceImpl$referenceMemoryAccountListener$1] */
    public ObricPersonalContextSettingServiceImpl() {
        this.a = LazyKt.lazy(new c2());
        this.b = LazyKt.lazy(new d2());
        Boolean r0 = null;
        boolean r1 = true;
        this.c = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        this.d = new AtomicBoolean(false);
        this.e = new ObricPersonalContextSettingServiceImpl$referenceMemoryAccountListener$1(this);
        FLogger r2 = FLogger.a;
        r2.i("ObricPersonalContextSettingKevaUtils", "addAllDataSourceToggles");
        Keva r5 = x();
        ToggleName r6 = ToggleName.MAIN_TOGGLE;
        Boolean r7 = Boolean.valueOf(r5.contains(r6.getToggleName()));
        if ((!r7.booleanValue()) == true) goto L6;
        r7 = null;
    L6:
        if (r7 == null) goto L8;
        r7.booleanValue();
        r5.storeBoolean(r6.getToggleName(), false);
    L8:
        ToggleName r8 = ToggleName.USE_DATA_ON_LOCK_SCREEN;
        Boolean r9 = Boolean.valueOf(r5.contains(r8.getToggleName()));
        if ((!r9.booleanValue()) == true) goto L12;
        r9 = null;
    L12:
        if (r9 == null) goto L17;
        r9.booleanValue();
        boolean r10 = r5.getBoolean(r6.getToggleName(), false);
        r2.i("ObricPersonalContextSettingKevaUtils", "addAllDataSourceToggles, for USE_DATA_ON_LOCK_SCREEN, MAIN_TOGGLE: " + r10);
        if (r10 == false) goto L16;
        r5.storeBoolean(r8.getToggleName(), true);
        goto L17
    L16:
        r5.storeBoolean(r8.getToggleName(), false);
    L17:
        ToggleName r11 = ToggleName.CALL_LOGS;
        Boolean r12 = Boolean.valueOf(r5.contains(r11.getToggleName()));
        if ((!r12.booleanValue()) == true) goto L21;
        r12 = null;
    L21:
        if (r12 == null) goto L23;
        r12.booleanValue();
        r5.storeBoolean(r11.getToggleName(), false);
    L23:
        ToggleName r13 = ToggleName.CONTACTS;
        Boolean r14 = Boolean.valueOf(r5.contains(r13.getToggleName()));
        if ((!r14.booleanValue()) == true) goto L27;
        r14 = null;
    L27:
        if (r14 == null) goto L29;
        r14.booleanValue();
        r5.storeBoolean(r13.getToggleName(), false);
    L29:
        ToggleName r15 = ToggleName.MESSAGE;
        Boolean r16 = Boolean.valueOf(r5.contains(r15.getToggleName()));
        if ((!r16.booleanValue()) == true) goto L33;
        r16 = null;
    L33:
        if (r16 == null) goto L35;
        r16.booleanValue();
        r5.storeBoolean(r15.getToggleName(), false);
    L35:
        ToggleName r17 = ToggleName.CLOCK;
        Boolean r18 = Boolean.valueOf(r5.contains(r17.getToggleName()));
        if ((!r18.booleanValue()) == true) goto L39;
        r18 = null;
    L39:
        if (r18 == null) goto L41;
        r18.booleanValue();
        r5.storeBoolean(r17.getToggleName(), false);
    L41:
        ToggleName r19 = ToggleName.NOTES;
        Boolean r20 = Boolean.valueOf(r5.contains(r19.getToggleName()));
        if ((!r20.booleanValue()) == true) goto L45;
        r20 = null;
    L45:
        if (r20 == null) goto L47;
        r20.booleanValue();
        r5.storeBoolean(r19.getToggleName(), false);
    L47:
        ToggleName r21 = ToggleName.ALBUM;
        Boolean r22 = Boolean.valueOf(r5.contains(r21.getToggleName()));
        if ((!r22.booleanValue()) == true) goto L51;
        r22 = null;
    L51:
        if (r22 == null) goto L53;
        r22.booleanValue();
        r5.storeBoolean(r21.getToggleName(), false);
    L53:
        ToggleName r23 = ToggleName.RECORD;
        Boolean r24 = Boolean.valueOf(r5.contains(r23.getToggleName()));
        if ((!r24.booleanValue()) == true) goto L57;
        r24 = null;
    L57:
        if (r24 == null) goto L59;
        r24.booleanValue();
        r5.storeBoolean(r23.getToggleName(), false);
    L59:
        ToggleName r25 = ToggleName.MEMORY;
        Boolean r26 = Boolean.valueOf(r5.contains(r25.getToggleName()));
        if ((!r26.booleanValue()) == true) goto L63;
        r26 = null;
    L63:
        if (r26 == null) goto L65;
        r26.booleanValue();
        r5.storeBoolean(r25.getToggleName(), false);
    L65:
        ToggleName r28 = ToggleName.FILE_MANAGEMENT;
        Boolean r29 = Boolean.valueOf(r5.contains(r28.getToggleName()));
        if ((!r29.booleanValue()) == true) goto L69;
        r29 = null;
    L69:
        if (r29 == null) goto L71;
        r29.booleanValue();
        r5.storeBoolean(r28.getToggleName(), false);
    L71:
        ToggleName r30 = ToggleName.CALENDAR;
        Boolean r31 = Boolean.valueOf(r5.contains(r30.getToggleName()));
        if ((!r31.booleanValue()) == true) goto L75;
        r31 = null;
    L75:
        if (r31 == null) goto L77;
        r31.booleanValue();
        r5.storeBoolean(r30.getToggleName(), false);
    L77:
        ToggleName r32 = ToggleName.ASSISTANT_ACTIVE_DATA;
        Boolean r33 = Boolean.valueOf(r5.contains(r32.getToggleName()));
        if ((!r33.booleanValue()) == true) goto L81;
        r33 = null;
    L81:
        if (r33 == null) goto L83;
        r33.booleanValue();
        r5.storeBoolean(r32.getToggleName(), false);
    L83:
        Boolean r34 = Boolean.valueOf(r5.contains("obric_personal_context_data_domain_dialog_shown"));
        if ((!r34.booleanValue()) == true) goto L87;
        r34 = null;
    L87:
        if (r34 == null) goto L89;
        r34.booleanValue();
        r5.storeBoolean("obric_personal_context_data_domain_dialog_shown", false);
    L89:
        ToggleName r35 = ToggleName.AI_DIARY;
        Boolean r36 = Boolean.valueOf(r5.contains(r35.getToggleName()));
        if ((!r36.booleanValue()) == true) goto L93;
        r36 = null;
    L93:
        if (r36 == null) goto L95;
        r36.booleanValue();
        r2.i("ObricPersonalContextSettingKevaUtils", "addAllDataSourceToggles， init local data search, AI_DIARY");
        r5.storeBoolean(r35.getToggleName(), false);
    L95:
        ToggleName r37 = ToggleName.HEARING_MEMORY;
        Boolean r38 = Boolean.valueOf(r5.contains(r37.getToggleName()));
        if ((!r38.booleanValue()) == true) goto L99;
        r38 = null;
    L99:
        if (r38 == null) goto L101;
        r38.booleanValue();
        r2.i("ObricPersonalContextSettingKevaUtils", "addAllDataSourceToggles， init local data search, HEARING_MEMORY");
        r5.storeBoolean(r37.getToggleName(), false);
    L101:
        ToggleName r39 = ToggleName.SCREEN_MEMORY;
        Boolean r40 = Boolean.valueOf(r5.contains(r39.getToggleName()));
        if ((!r40.booleanValue()) == true) goto L105;
        r40 = null;
    L105:
        if (r40 == null) goto L107;
        r40.booleanValue();
        r2.i("ObricPersonalContextSettingKevaUtils", "addAllDataSourceToggles， init local data search, SCREEN_MEMORY");
        r5.storeBoolean(r39.getToggleName(), false);
    L107:
        ToggleName r41 = ToggleName.PERSONAL_INFO_MEMORY;
        Boolean r42 = Boolean.valueOf(r5.contains(r41.getToggleName()));
        if ((!r42.booleanValue()) == true) goto L111;
        r42 = null;
    L111:
        if (r42 == null) goto L113;
        r42.booleanValue();
        r2.i("ObricPersonalContextSettingKevaUtils", "addAllDataSourceToggles， init local data search, PERSONAL_INFO_MEMORY");
        r5.storeBoolean(r41.getToggleName(), false);
    L113:
        ToggleName r43 = ToggleName.COLLECTION_MEMORY;
        Boolean r44 = Boolean.valueOf(r5.contains(r43.getToggleName()));
        if ((!r44.booleanValue()) == true) goto L117;
        r44 = null;
    L117:
        if (r44 == null) goto L119;
        r44.booleanValue();
        r2.i("ObricPersonalContextSettingKevaUtils", "addAllDataSourceToggles， init local data search, COLLECTION_MEMORY");
        r5.storeBoolean(r43.getToggleName(), false);
    L119:
        Boolean r45 = Boolean.valueOf(r5.contains("obric_local_data_search_enable"));
        if ((!r45.booleanValue()) == true) goto L123;
        r45 = null;
    L123:
        if (r45 == null) goto L141;
        r45.booleanValue();
        EnumEntries<ToggleName> r46 = ToggleName.getEntries();
        ArrayList r47 = new ArrayList();
        Iterator<ToggleName> r48 = r46.iterator();
    L126:
        if (r48.hasNext() == false) goto L131;
        ToggleName r49 = r48.next();
        if ((!r49.isDeprecated()) == false) goto L126;
        r47.add(r49);
        goto L126
    L131:
        if (r47.isEmpty() == true) goto L139;
        Iterator r50 = r47.iterator();
    L135:
        if (r50.hasNext() == false) goto L139;
        if (r5.getBoolean(((ToggleName) r50.next()).getToggleName(), false) == false) goto L135;
        boolean r51 = true;
    L140:
        FLogger.a.i("ObricPersonalContextSettingKevaUtils", "addAllDataSourceToggles， init local data search, historicalEnable: " + r51);
        r5.storeBoolean("obric_local_data_search_enable", r51);
    L139:
        r51 = false;
    L141:
        Boolean r52 = Boolean.valueOf(r5.contains("obric_local_data_search_init_permission_request_timestamp"));
        if ((!r52.booleanValue()) == true) goto L145;
        r52 = null;
    L145:
        if (r52 == null) goto L147;
        r52.booleanValue();
        r5.storeLong("obric_local_data_search_init_permission_request_timestamp", 0);
    L147:
        Boolean r3 = Boolean.valueOf(r5.contains(ToggleName.GLOBAL_MEMORY.getToggleName()));
        if ((!r3.booleanValue()) == false) goto L150;
        r0 = r3;
    L150:
        if (r0 == null) goto L181;
        r0.booleanValue();
        List r4 = CollectionsKt.listOf(new ToggleName[]{ToggleName.HEARING_MEMORY, ToggleName.SCREEN_MEMORY, ToggleName.COLLECTION_MEMORY, ToggleName.PERSONAL_INFO_MEMORY});
        List r53 = r4;
        if ((r53 instanceof Collection) == true) goto L154;
    L156:
        Iterator r54 = r53.iterator();
    L158:
        if (r54.hasNext() == false) goto L162;
        if (r5.getBoolean(((ToggleName) r54.next()).getToggleName(), false) == false) goto L158;
    L163:
        Iterator r55 = CollectionsKt.plus(r4, ToggleName.GLOBAL_MEMORY).iterator();
    L165:
        if (r55.hasNext() == false) goto L167;
        r5.storeBoolean(((ToggleName) r55.next()).getToggleName(), r1);
        goto L165
    L167:
        FLogger.a.i("ObricPersonalContextSettingKevaUtils", "addAllDataSourceToggles， init global memory, anyOriginalSwitchOpen: " + r1);
        return;
    L162:
        r1 = false;
        goto L163
    L154:
        if (r53.isEmpty() == false) goto L156;
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final Object a() {
        return x();
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final boolean c() {
        boolean r0 = x().getBoolean(ToggleName.MAIN_TOGGLE.getToggleName(), false);
        FLogger.a.i("ObricPersonalContextSettingKevaUtils", "isPersonalContextOpened: " + r0);
        return r0;
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final long e() {
        long r0 = x().getLong("obric_local_data_search_init_permission_request_timestamp", 0);
        FLogger.a.i("ObricPersonalContextSettingKevaUtils", "getLastLocalDataSearchInitPermissionRequestTimestamp, " + r0);
        return r0;
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final boolean q() {
        boolean r0 = x().getBoolean("obric_local_data_search_enable", false);
        FLogger.a.i("ObricPersonalContextSettingKevaUtils", "isLocalDataSearchEnabled, " + r0);
        return r0;
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final Class<? extends Activity> h() {
        return ObricPersonalContextSettingActivity.class;
    }

    public static IObricPermissionService.Companion.ObricPermissionStatus w(ToggleName r6) {
        boolean r1 = true;
        if (r6 != ToggleName.ALBUM) goto L12;
        IObricPermissionService r7 = (IObricPermissionService) ServiceManager.get().getService(IObricPermissionService.class);
        if (r7 == null) goto L7;
        IObricPermissionService.Companion.ObricPermissionStatus r8 = r7.h();
    L9:
        if (r8 != IObricPermissionService.Companion.ObricPermissionStatus.DENIED) goto L24;
        r1 = false;
    L24:
        if (r1 == false) goto L27;
        return IObricPermissionService.Companion.ObricPermissionStatus.GRANTED;
    L27:
        return IObricPermissionService.Companion.ObricPermissionStatus.DENIED;
    L7:
        r8 = null;
        goto L9
    L12:
        Iterator r9 = com.obric.assistant.settings.i.a(r6).iterator();
        boolean r0 = true;
    L14:
        if (r9.hasNext() == false) goto L23;
        String r3 = (String) r9.next();
        IObricPermissionService r4 = (IObricPermissionService) ServiceManager.get().getService(IObricPermissionService.class);
        if (r4 != null) goto L18;
    L20:
        boolean r5 = false;
    L21:
        if (r5 == false) goto L14;
        r0 = false;
        goto L14
    L18:
        if (r4.checkPermission(r3) == true) goto L20;
        r5 = true;
        goto L21
    L23:
        r1 = r0;
        goto L24
    }

    public static boolean z(String r3) {
        if ((!StringsKt.isBlank(r3)) == false) goto L9;
        ILoginService.Companion r0 = ILoginService.a;
        if (r0.getAccountInfo().a == false) goto L9;
        if (Intrinsics.areEqual(r0.getAccountInfo().c, r3) == false) goto L9;
        return true;
    L9:
        return false;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:42:0x009a -> B:48:0x00ad). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x00ab -> B:47:0x00ac). Please report as a decompilation issue!!! */
    public final Object B(Continuation<? super m> r14) {
        if ((r14 instanceof requestReferenceMemoryCloudConfigWithRetry.1) == false) goto L7;
        requestReferenceMemoryCloudConfigWithRetry.1 r0 = (requestReferenceMemoryCloudConfigWithRetry.1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L22;
        if (r3 == 1) goto L15;
        if (r3 != 2) goto L14;
        int r4 = r0.I$1;
        int r7 = r0.I$0;
        ResultKt.throwOnFailure(r15);
    L47:
        int r9 = r7;
    L48:
        int r8 = r4 + 1;
    L23:
        if (r8 >= r9) goto L50;
        int r5 = r8 + 1;
        IObricNetworkService r16 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);     // Catch: CancellationException -> L20 Exception -> L34
        if (r16 == null) goto L33;
        r0.I$0 = r9;     // Catch: CancellationException -> L20 Exception -> L34
        r0.I$1 = r8;     // Catch: CancellationException -> L20 Exception -> L34
        r0.I$2 = r8;     // Catch: CancellationException -> L20 Exception -> L34
        r0.I$3 = r5;     // Catch: CancellationException -> L20 Exception -> L34
        r0.label = 1;     // Catch: CancellationException -> L20 Exception -> L34
        r15 = r16.i(r0);     // Catch: CancellationException -> L20 Exception -> L34
        if (r15 != r2) goto L30;
        return r2;
    L30:
        int r10 = r8;
    L31:
        m r17 = (m) r15;     // Catch: Exception -> L18 CancellationException -> L20
    L39:
        r4 = r10;
        if (r17 == null) goto L42;
        return r17;
    L42:
        if (r8 >= 2) goto L48;
        r0.I$0 = r9;
        r0.I$1 = r4;
        r0.label = 2;
        if (DelayKt.delay(1000, r0) != r2) goto L46;
        return r2;
    L46:
        r7 = r9;
    L18:
        Exception e = e;
    L36:
        if (r5 != 3) goto L38;
        FLogger.a.w("ObricPersonalContextSettingKevaUtils", "requestReferenceMemoryCloudConfigWithRetry failed, attempt=" + r5, e);
    L38:
        r17 = null;
        goto L39
    L33:
        r17 = null;
        r10 = r8;
    L20:
        e = move-exception;
        throw e;
    L34:
        e = e;
        r10 = r8;
        goto L36
    L50:
        return null;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        r5 = r0.I$3;
        r8 = r0.I$2;
        r10 = r0.I$1;
        r9 = r0.I$0;
        ResultKt.throwOnFailure(r15);     // Catch: Exception -> L18 CancellationException -> L20
        goto L31
    L22:
        ResultKt.throwOnFailure(r15);
        r8 = 0;
        r9 = 3;
    L7:
        r0 = new requestReferenceMemoryCloudConfigWithRetry.1(this, r14);
        goto L8
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final void b(long r4) {
        FLogger.a.i("ObricPersonalContextSettingKevaUtils", "setLastLocalDataSearchInitPermissionRequestTimestamp, " + r4);
        x().storeLong("obric_local_data_search_init_permission_request_timestamp", r4);
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final boolean l(ToggleName r2) {
        Intrinsics.checkNotNullParameter(r2, "toggleName");
        int r3 = b.a[r2.ordinal()];
        if (r3 != 2) goto L5;
    L11:
        return true;
    L5:
        if (r3 == 3) goto L11;
        if (r3 == 4) goto L11;
        if (r3 == 5) goto L11;
        return false;
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final void m(boolean r4) {
        FLogger.a.i("ObricPersonalContextSettingKevaUtils", "setLocalDataSearchEnabled, " + r4);
        x().storeBoolean("obric_local_data_search_enable", r4);
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final void n(ToggleName r4) {
        Intrinsics.checkNotNullParameter(r4, "toggleName");
        if (q() == true) goto L5;
        return;
    L5:
        x().storeBoolean(r4.getToggleName(), true);
        FLogger.a.i("ObricPersonalContextSettingKevaUtils", "addTurnOnSwitch: " + r4);
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final boolean o(ToggleName r4) {
        Intrinsics.checkNotNullParameter(r4, "toggleName");
        if (q() == true) goto L5;
        return false;
    L5:
        Intrinsics.checkNotNullParameter(r4, "toggleName");
        if ((!com.obric.assistant.settings.i.a(r4).isEmpty()) == false) goto L12;
        if (w(r4) == IObricPermissionService.Companion.ObricPermissionStatus.DENIED) goto L17;
        return true;
    L17:
        return false;
    L12:
        if (l(r4) == false) goto L16;
        return x().getBoolean(ToggleName.GLOBAL_MEMORY.getToggleName(), false);
    L16:
        return x().getBoolean(r4.getToggleName(), false);
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final void p(ToggleName r4) {
        Intrinsics.checkNotNullParameter(r4, "toggleName");
        if (q() == true) goto L5;
        return;
    L5:
        x().storeBoolean(r4.getToggleName(), false);
        FLogger.a.i("ObricPersonalContextSettingKevaUtils", "removeTurnOffSwitch: " + r4);
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final Object r(Continuation<? super Boolean> r8) {
        if ((r8 instanceof updateReferenceMemoryCloudConfig.1) == false) goto L7;
        updateReferenceMemoryCloudConfig.1 r0 = (updateReferenceMemoryCloudConfig.1) r8;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r9 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        if (r3 == 0) goto L16;
        if (r3 != 1) goto L15;
        String r5 = (String) r0.L$0;
        ResultKt.throwOnFailure(r9);     // Catch: Exception -> L42 CancellationException -> L46
    L25:
        m r10 = (m) r9;     // Catch: Exception -> L42 CancellationException -> L46
        if (z(r5) == true) goto L29;
        FLogger.a.i("ObricPersonalContextSettingKevaUtils", "updateReferenceMemoryCloudConfig ignored, account changed");     // Catch: Exception -> L42 CancellationException -> L46
        return Boxing.boxBoolean(false);
    L29:
        if (r10 != null) goto L33;
        FLogger.a.i("ObricPersonalContextSettingKevaUtils", "updateReferenceMemoryCloudConfig failed after retry");     // Catch: Exception -> L42 CancellationException -> L46
        return Boxing.boxBoolean(false);
    L33:
        if (r10.a() == null) goto L35;
    L37:
        boolean r6 = false;
    L38:
        if (r6 == false) goto L40;
        Boolean r7 = Boolean.FALSE;     // Catch: Exception -> L42 CancellationException -> L46
        C(this, new m(r7, r7));     // Catch: Exception -> L42 CancellationException -> L46
    L45:
        return Boxing.boxBoolean(r4);
    L40:
        C(this, r10);     // Catch: Exception -> L42 CancellationException -> L46
        goto L45
    L35:
        if (r10.b() != null) goto L37;
        r6 = true;
        goto L38
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r9);
        ILoginService.Companion r11 = ILoginService.a;
        String r12 = r11.getAccountInfo().c;
        if (StringsKt.isBlank(r12) == false) goto L19;
    L48:
        FLogger.a.i("ObricPersonalContextSettingKevaUtils", "updateReferenceMemoryCloudConfig ignored, not login");
        return Boxing.boxBoolean(false);
    L19:
        if (r11.getAccountInfo().a == false) goto L48;
        r0.L$0 = r12;     // Catch: Exception -> L42 CancellationException -> L46
        r0.label = 1;     // Catch: Exception -> L42 CancellationException -> L46
        r9 = B(r0);     // Catch: Exception -> L42 CancellationException -> L46
        if (r9 != r2) goto L24;
        return r2;
    L24:
        r5 = r12;
    L46:
        e = move-exception;
        throw e;
    L42:
        e = move-exception;
        FLogger.a.e("ObricPersonalContextSettingKevaUtils", "updateReferenceMemoryCloudConfig failed", e);
        r4 = false;
    L7:
        r0 = new updateReferenceMemoryCloudConfig.1(this, r8);
        goto L8
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final String s(ToggleName r4) {
        Intrinsics.checkNotNullParameter(r4, "toggleName");
        if (q() == true) goto L7;
        return "unavailable";
    L7:
        if (r4 != ToggleName.ALBUM) goto L23;
        IObricPermissionService r5 = (IObricPermissionService) ServiceManager.get().getService(IObricPermissionService.class);
        if (r5 == null) goto L11;
        IObricPermissionService.Companion.ObricPermissionStatus r6 = r5.h();
    L12:
        if (r6 != null) goto L14;
        int r7 = -1;
    L16:
        if (r7 != 1) goto L18;
        return "allow";
    L18:
        if (r7 != 2) goto L28;
        return "limited";
    L28:
        return "reject";
    L14:
        r7 = b.b[r6.ordinal()];
        goto L16
    L11:
        r6 = null;
        goto L12
    L23:
        if (o(r4) == false) goto L26;
        return "allow";
    L26:
        return "reject";
    }

    public static void C(ObricPersonalContextSettingServiceImpl r3, m r4) {
        r3.getClass();
        Boolean r0 = r4.a();
        boolean r1 = false;
        if (r0 == null) goto L5;
        boolean r2 = r0.booleanValue();
    L6:
        Boolean r5 = Boolean.valueOf(r2);
        Boolean r6 = r4.b();
        if (r6 == null) goto L9;
        r1 = r6.booleanValue();
    L9:
        m r7 = new m(r5, Boolean.valueOf(r1));
        Keva r8 = y();
        Boolean r9 = r7.a();
        Boolean r10 = Boolean.TRUE;
        r8.storeBoolean("reference_memory", Intrinsics.areEqual(r9, r10));
        y().storeBoolean("reference_memory_personal_info", Intrinsics.areEqual(r7.b(), r10));
        y().storeBoolean("reference_memory_initialized", true);
        A();
        return;
    L5:
        r2 = false;
        goto L6
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final boolean i(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "key");
        if (Intrinsics.areEqual(r2, "reference_memory") == false) goto L5;
    L8:
        boolean r0 = true;
    L9:
        if (r0 == true) goto L12;
        return r3;
    L12:
        return y().getBoolean(r2, r3);
    L5:
        if (Intrinsics.areEqual(r2, "reference_memory_personal_info") == true) goto L8;
        r0 = false;
        goto L9
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final boolean j(ToggleName r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "toggleName");
        if (q() == true) goto L5;
        return r4;
    L5:
        Intrinsics.checkNotNullParameter(r3, "toggleName");
        if ((!com.obric.assistant.settings.i.a(r3).isEmpty()) == false) goto L13;
        if (w(r3) != IObricPermissionService.Companion.ObricPermissionStatus.DENIED) goto L18;
        return false;
    L18:
        return true;
    L13:
        if (l(r3) == false) goto L17;
        return x().getBoolean(ToggleName.GLOBAL_MEMORY.getToggleName(), r4);
    L17:
        return x().getBoolean(r3.getToggleName(), r4);
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final LiveData<Pair<Boolean, List<SelectableToggleItem>>> k(FragmentActivity r7, List<SelectableToggleItem> r8) {
        Intrinsics.checkNotNullParameter(r7, "activity");
        Intrinsics.checkNotNullParameter(r8, "toggleList");
        int r2 = LocalDataSearchSelectFragment.a;
        Intrinsics.checkNotNullParameter(r7, "activity");
        Intrinsics.checkNotNullParameter(r8, "toggleList");
        MutableLiveData r0 = new MutableLiveData();     // Catch: Exception -> L10
        RecyclerView r1 = new RecyclerView(r7);     // Catch: Exception -> L10
        r1.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));     // Catch: Exception -> L10
        r1.setClipToPadding(false);     // Catch: Exception -> L10
        r1.setPadding(i5.r0(), 0, i5.r0(), i5.E());     // Catch: Exception -> L10
        r1.setLayoutManager(new LinearLayoutManager(r1.getContext(), 1, false));     // Catch: Exception -> L10
        r1.setAdapter(new LocalDataSearchSelectFragment.Adapter(r8));     // Catch: Exception -> L10
        r1.addItemDecoration(new LocalDataSearchSelectFragment.Decoration(r1.getContext()));     // Catch: Exception -> L10
        g r3 = new g(r7);     // Catch: Exception -> L10
        r3.w = false;     // Catch: Exception -> L10
        String r4 = r7.getString(2131912238);     // Catch: Exception -> L10
        r3.j = false;     // Catch: Exception -> L10
        r3.h = r4;     // Catch: Exception -> L10
        zla.g r5 = new zla.g(new n(r1));     // Catch: Exception -> L10
        Intrinsics.checkNotNullParameter(r5, "controller");     // Catch: Exception -> L10
        r3.x = r5;     // Catch: Exception -> L10
        g.c(r3);     // Catch: Exception -> L10
        r3.e(r7.getString(2131912236), new o(r0));     // Catch: Exception -> L10
        r3.h(r7.getString(2131912237), new p(r0, r8));     // Catch: Exception -> L10
        c r9 = r3.a();     // Catch: Exception -> L10
        if (DialogLancet.shouldBlockDialogShow(r9) == false) goto L17;
        DialogLancet.handleBlockedDialogShow(r9);     // Catch: Exception -> L10
    L14:
        return r0;
    L17:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L8:
        DialogLancet.beforeDialogShow(r9);     // Catch: Exception -> L10
        r9.show();     // Catch: Exception -> L10
        DialogLancet.afterDialogShow(r9);     // Catch: Exception -> L10
    L10:
        e = move-exception;
        FLogger.a.e("LocalDataSearchSelectFragment", "find LocalDataSearchSelectFragment exception: " + e);
        return null;
    }

    public final m v(String r6, boolean r7) {
        boolean r1 = false;
        boolean r2 = i("reference_memory", false);
        if (Intrinsics.areEqual("reference_memory", r6) == false) goto L5;
        boolean r3 = r7;
    L6:
        boolean r0 = Intrinsics.areEqual(r6, "reference_memory");
        if (r0 == true) goto L11;
        r2 = r3;
    L11:
        if (r0 == false) goto L15;
        if (r7 == false) goto L15;
        r6 = "reference_memory_personal_info";
    L15:
        if (Intrinsics.areEqual("reference_memory_personal_info", r6) == true) goto L18;
        r7 = i("reference_memory_personal_info", r2);
    L18:
        if (r0 == false) goto L20;
        r1 = r3;
    L24:
        return new m(Boolean.valueOf(r1), Boolean.valueOf(r7));
    L20:
        if (r3 == false) goto L24;
        if (r7 == false) goto L24;
        r1 = true;
        goto L24
    L5:
        r3 = i("reference_memory", false);
        goto L6
    }

    @Override // com.obric.assistant.settings.IObricPersonalContextSettingApi
    public final Object d(String r10, boolean r11, Continuation<? super Boolean> r12) {
        if ((r12 instanceof setReferenceMemoryToggleEnabledWithSync.1) == false) goto L7;
        setReferenceMemoryToggleEnabledWithSync.1 r0 = (setReferenceMemoryToggleEnabledWithSync.1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r13 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        boolean r4 = true;
        boolean r5 = false;
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L19;
        boolean r14 = r0.Z$0;
        m r15 = (m) r0.L$2;
        String r6 = (String) r0.L$1;
        String r7 = (String) r0.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Exception -> L14 CancellationException -> L16
        r11 = r14;
        r10 = r7;
        Object r8 = r13;
        m r16 = r15;
    L67:
        if (((Boolean) r8).booleanValue() == true) goto L48;
        String r9 = r6;
    L47:
        r6 = r9;
        r4 = false;
    L48:
        if (r4 == true) goto L50;
    L54:
        r5 = r4;
    L59:
        return Boxing.boxBoolean(r5);
    L50:
        if (z(r6) == true) goto L53;
        FLogger.a.i("ObricPersonalContextSettingKevaUtils", "setReferenceMemoryToggleEnabledWithSync ignored, account changed");     // Catch: CancellationException -> L16 Exception -> L55
        return Boxing.boxBoolean(false);
    L53:
        C(this, r16);     // Catch: CancellationException -> L16 Exception -> L55
    L45:
        e = move-exception;
        r7 = r10;
        r14 = r11;
        Exception e = e;
    L57:
        FLogger.a.e("ObricPersonalContextSettingKevaUtils", "setReferenceMemoryToggleEnabledWithSync failed, key=" + r7 + ", enabled=" + r14, e);
    L14:
        e = e;
        goto L57
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ResultKt.throwOnFailure(r13);
        if (Intrinsics.areEqual(r10, "reference_memory") == false) goto L23;
    L26:
        boolean r17 = true;
    L27:
        if (r17 == false) goto L29;
        ILoginService.Companion r18 = ILoginService.a;
        r9 = r18.getAccountInfo().c;
        if (StringsKt.isBlank(r9) == false) goto L33;
    L61:
        FLogger.a.w("ObricPersonalContextSettingKevaUtils", "setReferenceMemoryToggleEnabledWithSync ignored, not login");
        return Boxing.boxBoolean(false);
    L33:
        if (r18.getAccountInfo().a == false) goto L61;
        r16 = v(r10, r11);     // Catch: CancellationException -> L16 Exception -> L55
        IObricNetworkService r19 = (IObricNetworkService) ServiceManager.get().getService(IObricNetworkService.class);     // Catch: CancellationException -> L16 Exception -> L55
        if (r19 == null) goto L47;
        r0.L$0 = r10;     // Catch: CancellationException -> L16 Exception -> L55
        r0.L$1 = r9;     // Catch: CancellationException -> L16 Exception -> L55
        r0.L$2 = r16;     // Catch: CancellationException -> L16 Exception -> L55
        r0.Z$0 = r11;     // Catch: CancellationException -> L16 Exception -> L55
        r0.label = 1;     // Catch: CancellationException -> L16 Exception -> L55
        r8 = r19.j(r16, r0);     // Catch: CancellationException -> L16 Exception -> L55
        if (r8 != r2) goto L40;
        return r2;
    L40:
        r6 = r9;
    L55:
        e = move-exception;
        e = e;
        r7 = r10;
        r14 = r11;
        goto L57
    L29:
        return Boxing.boxBoolean(false);
    L23:
        if (Intrinsics.areEqual(r10, "reference_memory_personal_info") == true) goto L26;
        r17 = false;
    L16:
        e = move-exception;
        throw e;
    L7:
        r0 = new setReferenceMemoryToggleEnabledWithSync.1(this, r12);
        goto L8
    }
}
