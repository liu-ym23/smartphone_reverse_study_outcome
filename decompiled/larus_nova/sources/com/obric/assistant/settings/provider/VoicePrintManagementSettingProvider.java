package com.obric.assistant.settings.provider;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Build;
import com.larus.nova.R;
import com.obric.assistant.settings.spi.IObricSettingProvider;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u001c\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002¨\u0006\u0011"}, d2 = {"Lcom/obric/assistant/settings/provider/VoicePrintManagementSettingProvider;", "Lcom/obric/assistant/settings/spi/IObricSettingProvider;", "<init>", "()V", "getSettingGroups", "", "Lcom/obric/assistant/settings/spi/ObricSettingGroup;", "host", "Lcom/obric/assistant/settings/spi/IObricSettingHost;", "getSettingItems", "Lcom/obric/assistant/settings/spi/ObricSettingItem;", "(Lcom/obric/assistant/settings/spi/IObricSettingHost;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handleVoicePrintManagementClick", "", "view", "Landroid/view/View;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoicePrintManagementSettingProvider implements IObricSettingProvider {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f392266a = 0;

    public static final class a {
    }

    static {
    }

    public VoicePrintManagementSettingProvider() {
    }

    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final List<com.obric.assistant.settings.spi.c> a(com.obric.assistant.settings.spi.b r100) {
        Intrinsics.checkNotNullParameter(r100, "host");
        if (r100.getHostContext() != null) goto L7;
        return CollectionsKt.emptyList();
    L7:
        if (Build.VERSION.SDK_INT >= 23) goto L11;
        return CollectionsKt.emptyList();
    L11:
        if (ega.a.a() == true) goto L15;
        return CollectionsKt.emptyList();
    L15:
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.c("group_voice"));
    }

    /* JADX WARN: Type inference failed for: r5v1, types: [com.obric.assistant.settings.provider.w1] */
    @Override // com.obric.assistant.settings.spi.IObricSettingProvider
    public final Object b(com.obric.assistant.settings.spi.b r310, Continuation<? super List<? extends com.obric.assistant.settings.spi.e>> r311) {
        if ((r311 instanceof VoicePrintManagementSettingProvider$getSettingItems$1) == false) goto L7;
        VoicePrintManagementSettingProvider$getSettingItems$1 r100 = (VoicePrintManagementSettingProvider$getSettingItems$1) r311;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L17;
        if (r104 != 1) goto L12;
        Context r105 = (Context) r100.L$0;
        ResultKt.throwOnFailure(r102);
    L33:
        final Context r110 = r105;
        final boolean r111 = ((Boolean) r102).booleanValue();
        final BluetoothDevice r112 = null;
        final Boolean r113 = null;
        int r106 = 0;
    L34:
        if (r106 == 0) goto L42;
        if (r111 == false) goto L42;
        if (com.obric.assistant.t1.f393353a.u() == false) goto L42;
        if (r112 == null) goto L42;
        if (Intrinsics.areEqual(r113, Boxing.boxBoolean(true)) == true) goto L42;
        final boolean r107 = true;
    L43:
        String r114 = r110.getString(R.string.obric_setting_voice_print_management);
        Function1 r108 = new u1(this);
        if (r106 == 0) goto L46;
        final boolean r109 = true;
    L48:
        return CollectionsKt.listOf(new com.obric.assistant.settings.spi.a("group_voice", "voice_print_management", r114, 95, r108, null, new v1(r109, r112, r113, r111, r110), new VoicePrintManagementSettingProvider$getSettingItems$4(null), new w1(r107), false, null, null, 7456));
    L46:
        r109 = false;
    L42:
        r107 = false;
        goto L43
    L12:
        if (r104 != 2) goto L15;
        r106 = r100.I$0;
        boolean r115 = r100.Z$0;
        BluetoothDevice r116 = (BluetoothDevice) r100.L$1;
        Context r117 = (Context) r100.L$0;
        ResultKt.throwOnFailure(r102);
        r113 = (Boolean) r102;
        r110 = r117;
        r111 = r115;
        r112 = r116;
        goto L34
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        ResultKt.throwOnFailure(r102);
        Context r118 = r310.getHostContext();
        if (r118 != null) goto L22;
        return CollectionsKt.emptyList();
    L22:
        if (Build.VERSION.SDK_INT >= 23) goto L26;
        return CollectionsKt.emptyList();
    L26:
        if (ega.a.a() == false) goto L28;
        CoroutineDispatcher r119 = Dispatchers.getIO();
        VoicePrintManagementSettingProvider$getSettingItems$isVoicePrintExisted$1 r120 = new VoicePrintManagementSettingProvider$getSettingItems$isVoicePrintExisted$1(null);
        r100.L$0 = r118;
        r100.label = 1;
        Object r121 = BuildersKt.withContext(r119, r120, r100);
        if (r121 != r103) goto L32;
        return r103;
    L32:
        r105 = r118;
        r102 = r121;
        goto L33
    L28:
        return CollectionsKt.emptyList();
    L7:
        r100 = new VoicePrintManagementSettingProvider$getSettingItems$1(this, r311);
        goto L8
    }
}
