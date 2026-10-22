package com.larus.dora.o.impl.health;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.crash.d;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.web.AiChatHostWebService;
import com.larus.dora.o.impl.health.calendar.OHealthCalendarDialog;
import com.larus.nova.R;
import com.larus.platform.model.webview.AbsWebFragment;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import zt8.b;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000M\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006*\u0001\u000b\u0018\u0000  2\u00020\u0001:\u0001 B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\u001a\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0016J\u0018\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001bH\u0002J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006!"}, d2 = {"Lcom/larus/dora/o/impl/health/OHealthTabFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "webFragment", "Lcom/larus/platform/model/webview/AbsWebFragment;", "calendarDialog", "Lcom/larus/dora/o/impl/health/calendar/OHealthCalendarDialog;", "receiverRegistered", "", "openCalendarReceiver", "com/larus/dora/o/impl/health/OHealthTabFragment$openCalendarReceiver$1", "Lcom/larus/dora/o/impl/health/OHealthTabFragment$openCalendarReceiver$1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "mountWeb", "url", "", "buildUrl", "showCalendar", "date", "notifyDateSelected", "Companion", "dora_o_impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OHealthTabFragment extends Fragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f338679h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AbsWebFragment f338680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public OHealthCalendarDialog f338681e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f338682f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final OHealthTabFragment$openCalendarReceiver$1 f338683g;

    public static final class a {
    }

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        OHealthCalendarDialog r100 = this.f338681e;
        if (r100 != null) goto L16;
    L10:
        this.f338681e = null;
        Context r101 = getContext();
        if (this.f338682f == false) goto L14;
        if (r101 == null) goto L14;
        LocalBroadcastManager.getInstance(r101).unregisterReceiver(this.f338683g);
    L14:
        this.f338682f = false;
        this.f338680d = null;
        super.onDestroyView();
        return;
    L16:
        r100.dismissAllowingStateLoss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r102 = DialogFragmentLancet.sLastShowStack;
        if (r102 == null) goto L10;
        d.d(r102, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        goto L10
    }

    public OHealthTabFragment() {
        this.f338683g = new OHealthTabFragment$openCalendarReceiver$1(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        String r101 = r100.getString("dora_o_health_url");
    L6:
        if (r101 != null) goto L8;
        r101 = "";
    L8:
        String r102 = r101;
        if (StringsKt.isBlank(r102) == false) goto L12;
        FLogger.f375446a.w("OHealthH5", "health url empty, nothing to mount");
        return;
    L12:
        ViewGroup r103 = (ViewGroup) r110.findViewById(R.id.dora_o_health_tab_container);
        ViewCompat.setOnApplyWindowInsetsListener(r103, new x69.a());
        ViewCompat.requestApplyInsets(r103);
        Intrinsics.checkNotNull(r103);
        AbsWebFragment r104 = AiChatHostWebService.f317594a.a(null);
        if (r104 != null) goto L37;
        FLogger.f375446a.e("OHealthH5", "host web fragment unavailable");
    L26:
        boolean r105 = false;
    L32:
        if (r105 == true) goto L35;
        FLogger.f375446a.e("OHealthH5", "mount health h5 failed, leave empty");
        return;
    L35:
        LocalBroadcastManager.getInstance(r110.getContext()).registerReceiver(this.f338683g, new IntentFilter("com.larus.dora.health.OPEN_CALENDAR"));
        this.f338682f = true;
        return;
    L37:
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L17
        Object r107 = Result.m9449constructorimpl(UriProtector.parse(r102).buildUpon().appendQueryParameter("embedded", "1").appendQueryParameter("bottom_reserve", "100").build().toString());     // Catch: Throwable -> L17
    L20:
        if (Result.m9452exceptionOrNullimpl(r107) != null) goto L22;
        Object r108 = r107;
    L23:
        String r109 = (String) r108;
        Bundle r112 = AiChatHostWebService.f317594a.c(new b(r109, false, false, Integer.valueOf(ContextCompat.getColor(r103.getContext(), R.color.dora_o_bg_page)), false, 100));
        if (r112 != null) goto L27;
        FLogger.f375446a.e("OHealthH5", "web fragment arguments null");
        goto L26
    L27:
        r112.putString("enable_error_view", "1");
        r104.setArguments(r112);
        this.f338680d = r104;
        FragmentTransaction r113 = getChildFragmentManager().beginTransaction();
        int r114 = r103.getId();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r113, r104, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "dora_o_health_web", r114) == true) goto L31;
        r113.replace(r114, r104, "dora_o_health_web");
    L31:
        r113.commit();
        FLogger.f375446a.i("OHealthH5", "mount url=".concat(r109));
        r105 = true;
        goto L32
    L22:
        FLogger.f375446a.w("OHealthH5", "build url failed, use raw url");
        r108 = r102;
    L17:
        th = move-exception;
        Result.Companion r115 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L5:
        r101 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.larus_dora_o_fragment_health_tab, r101, false);
    }
}
