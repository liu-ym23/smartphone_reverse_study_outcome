package com.larus.dora.impl.noti_v3.social_message.viewmodel;

import androidx.lifecycle.ViewModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.common.apphost.AppHost;
import com.larus.dora.impl.nl.DoraUserSettingsManager;
import com.larus.nova.R;
import com.larus.utils.j0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0010\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u0010\u0010\u0012\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fJ\u001a\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0014\u001a\u0004\u0018\u00010\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/larus/dora/impl/noti_v3/social_message/viewmodel/NotificationBroadcastV3SocialMessageViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "gson", "Lcom/google/gson/Gson;", "settingsState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/larus/dora/impl/noti_v3/common/model/NotificationBroadcastV3DeviceSettings;", "getSettingsState", "()Lkotlinx/coroutines/flow/StateFlow;", "syncSettings", "", "updateMessageMode", "key", "", "mode", "resolveSingleMessageSummary", "resolveGroupMessageSummary", "resolveSpecialMessageSummary", "listJson", "countSelectedSpecialTargets", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NotificationBroadcastV3SocialMessageViewModel extends ViewModel {
    private final Gson gson;
    private final i1<q59.a> settingsState;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/dora/impl/noti_v3/social_message/viewmodel/NotificationBroadcastV3SocialMessageViewModel$countSelectedSpecialTargets$1$type$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/dora/impl/noti_v3/special_contacts/model/NotificationBroadcastV3SpecialContact;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends y59.a>> {
        public a() {
        }
    }

    public final void syncSettings() {
        DoraUserSettingsManager r100 = DoraUserSettingsManager.f336185a;
        DoraUserSettingsManager.i("NotificationBroadcastV3SocialMessageViewModel");
    }

    public NotificationBroadcastV3SocialMessageViewModel() {
        this.gson = new Gson();
        this.settingsState = DoraUserSettingsManager.f336197m;
    }

    public final i1<q59.a> getSettingsState() {
        return this.settingsState;
    }

    private final int countSelectedSpecialTargets(String r100) {
        if (r100 != null) goto L30;
        return 0;
    L30:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L23
        List r102 = (List) this.gson.fromJson(r100, new a().getType());     // Catch: Throwable -> L23
        if (r102 == null) goto L20;
        List r103 = r102;     // Catch: Throwable -> L23
        if ((r103 instanceof Collection) == true) goto L10;
    L12:
        Iterator r104 = r103.iterator();     // Catch: Throwable -> L23
        int r105 = 0;
    L14:
        if (r104.hasNext() == false) goto L21;
        if (Intrinsics.areEqual(((y59.a) r104.next()).e(), Boolean.TRUE) == false) goto L14;
        r105 = r105 + 1;     // Catch: Throwable -> L23
        if (r105 >= 0) goto L14;
        CollectionsKt.throwCountOverflow();     // Catch: Throwable -> L23
    L21:
        Object r106 = Result.m9449constructorimpl(Integer.valueOf(r105));     // Catch: Throwable -> L23
    L26:
        if (Result.m9455isFailureimpl(r106) == false) goto L29;
        r106 = 0;
    L29:
        return ((Number) r106).intValue();
    L10:
        if (r103.isEmpty() == false) goto L12;
    L20:
        r105 = 0;
    L23:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    }

    public final String resolveGroupMessageSummary(String r100) {
        if (r100 != null) goto L6;
        r100 = "1";
    L6:
        switch(r100.hashCode()) {
            case 48: goto L17;
            case 49: goto L13;
            case 50: goto L9;
            default: goto L20;
        };
    L20:
        int r101 = j0.f375426a;
        return j0.d(R.string.larus_dora_broadcast_v3_social_mode_important_cn);
    L9:
        if (r100.equals("2") == false) goto L20;
        int r102 = j0.f375426a;
        return j0.d(R.string.larus_dora_broadcast_v3_social_mode_off_cn);
    L13:
        if (r100.equals("1") == false) goto L20;
        int r103 = j0.f375426a;
        return j0.d(R.string.larus_dora_broadcast_v3_social_mode_important_cn);
    L17:
        if (r100.equals("0") == false) goto L20;
        int r104 = j0.f375426a;
        return j0.d(R.string.larus_dora_broadcast_v3_social_mode_all_cn);
    }

    public final String resolveSingleMessageSummary(String r100) {
        if (r100 != null) goto L6;
        r100 = "1";
    L6:
        switch(r100.hashCode()) {
            case 48: goto L17;
            case 49: goto L13;
            case 50: goto L9;
            default: goto L20;
        };
    L20:
        int r101 = j0.f375426a;
        return j0.d(R.string.larus_dora_broadcast_v3_social_mode_important_cn);
    L9:
        if (r100.equals("2") == false) goto L20;
        int r102 = j0.f375426a;
        return j0.d(R.string.larus_dora_broadcast_v3_social_mode_off_cn);
    L13:
        if (r100.equals("1") == false) goto L20;
        int r103 = j0.f375426a;
        return j0.d(R.string.larus_dora_broadcast_v3_social_mode_important_cn);
    L17:
        if (r100.equals("0") == false) goto L20;
        int r104 = j0.f375426a;
        return j0.d(R.string.larus_dora_broadcast_v3_social_mode_all_cn);
    }

    public final String resolveSpecialMessageSummary(String r100, String r101) {
        int r102 = countSelectedSpecialTargets(r101);
        if (r102 <= 0) goto L5;
        String r103 = AppHost.f326268a.getApplication().getString(R.string.larus_dora_broadcast_v3_special_chat_count_cn, new Object[]{Integer.valueOf(r102)});
        Intrinsics.checkNotNull(r103);
        return r103;
    L5:
        return "";
    }

    public final void updateMessageMode(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "mode");
        DoraUserSettingsManager r102 = DoraUserSettingsManager.f336185a;
        DoraUserSettingsManager.k(r100, r101, null);
    }
}
