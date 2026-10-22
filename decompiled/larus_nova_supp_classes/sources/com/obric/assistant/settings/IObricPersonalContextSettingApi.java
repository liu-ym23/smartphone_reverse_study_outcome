package com.obric.assistant.settings;

import android.app.Activity;
import android.util.EventsUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.coroutines.Continuation;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0006H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u0006H&J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\u0006H&J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0013H&J\u000e\u0010\u0014\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0015J\u001e\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u0006H¦@¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u0006H'J\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0006H&J\b\u0010\u001c\u001a\u00020\u0006H&J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0006H&J\b\u0010\u001e\u001a\u00020\u0006H&J\b\u0010\u001f\u001a\u00020\u0006H&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0006H&J\u0010\u0010!\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\"\u001a\u00020#H&J\u0010\u0010$\u001a\u00020\u00032\u0006\u0010%\u001a\u00020#H&J\u0018\u0010&\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010'2\u0006\u0010(\u001a\u00020)H&J8\u0010*\u001a\u001c\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u0006\u0012\n\u0012\b\u0012\u0004\u0012\u00020-0,0+\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,H&J\u0010\u0010/\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH&J\u0010\u00100\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH&J\u0012\u00101\u001a\f\u0012\u0006\b\u0001\u0012\u000203\u0018\u000102H&J\b\u00104\u001a\u00020\u0001H&¨\u00065"}, d2 = {"Lcom/obric/assistant/settings/IObricPersonalContextSettingApi;", XmlPullParser.NO_NAMESPACE, "initReferenceMemorySync", XmlPullParser.NO_NAMESPACE, "registerMessageExt", "isPersonalContextOpened", XmlPullParser.NO_NAMESPACE, "personalContextOn", "personalContextOff", "turnOnToggle", "toggleName", "Lcom/obric/assistant/settings/ToggleName;", "turnOffToggle", "isToggleOn", "defVal", "isReferenceMemoryToggleEnabled", "key", XmlPullParser.NO_NAMESPACE, "getReferenceMemorySyncSnapshot", "Lcom/obric/assistant/settings/ReferenceMemorySyncSnapshot;", "updateReferenceMemoryCloudConfig", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setReferenceMemoryToggleEnabledWithSync", "enabled", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isUseDataOnLockScreenEnabled", "setUseDataOnLockScreen", "enable", "isDataDomainDialogAlreadyShown", "setDataDomainDialogAlreadyShown", "isHideEventMemory", "isLocalDataSearchEnabled", "setLocalDataSearchEnabled", "getLocalDataSearchSwitchReportValue", "getLastLocalDataSearchInitPermissionRequestTimestamp", XmlPullParser.NO_NAMESPACE, "setLastLocalDataSearchInitPermissionRequestTimestamp", "timestamp", "showLocalDataSearchConfirmFragment", "Landroidx/lifecycle/LiveData;", "activity", "Landroidx/fragment/app/FragmentActivity;", "showLocalDataSearchSelectFragment", "Lkotlin/Pair;", XmlPullParser.NO_NAMESPACE, "Lcom/obric/assistant/settings/SelectableToggleItem;", "toggleList", "isGovernedByNewGlobalMemorySwitch", "isGovernedBySystemPermission", "getObricPersonalContextSettingsClassName", "Ljava/lang/Class;", "Landroid/app/Activity;", "getKevaRepo", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public interface IObricPersonalContextSettingApi {
    Object a();

    void b(long r1);

    boolean c();

    Object d(String r1, boolean r2, Continuation<? super Boolean> r3);

    long e();

    d1 f();

    void g();

    Class<? extends Activity> h();

    boolean i(String r1, boolean r2);

    boolean j(ToggleName r1, boolean r2);

    LiveData<Pair<Boolean, List<SelectableToggleItem>>> k(FragmentActivity r1, List<SelectableToggleItem> r2);

    boolean l(ToggleName r1);

    void m(boolean r1);

    void n(ToggleName r1);

    boolean o(ToggleName r1);

    void p(ToggleName r1);

    boolean q();

    Object r(Continuation<? super Boolean> r1);

    String s(ToggleName r1);

    boolean t();

    void u();
}
