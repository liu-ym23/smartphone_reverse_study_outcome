package com.larus.uaigc.music.applet;

import android.content.Context;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ee.bear.thumbnail.ThumbGlideUrl;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.chat.ChatParam;
import com.larus.bmhome.chat.actionbar.IActionBarService;
import com.larus.bmhome.chat.component.bottom.core.InputViewCreatorDelegate;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.nova.R;
import com.larus.uaigc.applet.IMusicAppletHostService;
import com.larus.uaigc.impl.databinding.LarusFragmentMusicTemplateAppletBinding;
import com.larus.uaigc.music.template.MusicTemplateListFragment;
import com.larus.ui.arch.component.internal.attach.FragmentAttachExtKt;
import com.larus.ui.arch.modulizer.di.ContainerFilter;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONObject;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0016\u0018\u0000 Z2\u00020\u0001:\u0001ZB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J&\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u001a\u0010%\u001a\u00020\u00192\u0006\u0010&\u001a\u00020 2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010'\u001a\u00020\u0019H\u0016J\b\u0010(\u001a\u00020\u0019H\u0016J\b\u0010)\u001a\u00020\u0019H\u0016J\b\u0010*\u001a\u00020\u0019H\u0002J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020-H\u0002J \u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\u0006\u00101\u001a\u00020/2\u0006\u00102\u001a\u00020\u000fH\u0002J\f\u00102\u001a\u00020\u000f*\u00020 H\u0002J\b\u00103\u001a\u00020\u0019H\u0002J\b\u00104\u001a\u00020\u000fH\u0002J\u0014\u00105\u001a\u00020\u00192\n\b\u0002\u00106\u001a\u0004\u0018\u00010\tH\u0002J\b\u00107\u001a\u00020\u0019H\u0002J\b\u00108\u001a\u00020\u0019H\u0002J\b\u00109\u001a\u00020\u0019H\u0002J\b\u0010:\u001a\u00020\u0019H\u0002J\u0012\u0010;\u001a\u00020\u000f2\b\u0010<\u001a\u0004\u0018\u00010=H\u0002J\b\u0010>\u001a\u00020\u0019H\u0002J\b\u0010?\u001a\u00020\u001eH\u0002J\u0012\u0010@\u001a\u00020\u001e2\b\u00106\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010A\u001a\u00020\u0019H\u0002J\b\u0010B\u001a\u00020\u0019H\u0002J\n\u0010C\u001a\u0004\u0018\u00010DH\u0002J\b\u0010E\u001a\u00020\u0019H\u0002J\u001c\u0010F\u001a\u00020\u00192\b\b\u0002\u0010G\u001a\u00020\u000f2\b\b\u0002\u0010H\u001a\u00020\u000fH\u0002J\u0012\u0010I\u001a\u00020\u00192\b\b\u0002\u0010G\u001a\u00020\u000fH\u0002J\"\u0010J\u001a\u00020\u00192\u0006\u0010K\u001a\u00020D2\u0006\u0010L\u001a\u00020=2\b\b\u0002\u0010M\u001a\u00020\u000fH\u0002J\u0018\u0010N\u001a\u00020\u00192\u0006\u0010K\u001a\u00020D2\u0006\u0010L\u001a\u00020=H\u0002J\b\u0010O\u001a\u00020\u0019H\u0002J\b\u0010P\u001a\u00020\u0019H\u0002J\b\u0010Q\u001a\u00020\u0019H\u0002J\n\u0010R\u001a\u0004\u0018\u00010\tH\u0002J\n\u0010S\u001a\u0004\u0018\u00010\u000bH\u0002J\n\u0010T\u001a\u0004\u0018\u00010\rH\u0002J\n\u0010U\u001a\u0004\u0018\u00010VH\u0002J\b\u0010W\u001a\u00020=H\u0002J\b\u0010X\u001a\u00020=H\u0002J\b\u0010Y\u001a\u00020=H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006["}, d2 = {"Lcom/larus/uaigc/music/applet/MusicTemplateAppletFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusFragmentMusicTemplateAppletBinding;", "instructionArgumentData", "Lcom/larus/uaigc/bean/createpage/InstructionArgumentData;", "musicActionBarItem", "Lcom/larus/bmhome/actionbar/model/CustomActionBarItem;", "editorAbility", "Lcom/larus/uaigc/music/applet/MusicAppletInstructionEditorAbility;", "instructionPanelAbility", "Lcom/larus/uaigc/music/applet/MusicTemplateAppletInstructionPanelAbility;", "hasAutoOpenedInputPanel", "", "hasReportedStartCreate", "templatePageEnterTime", "", "appletContainer", "Lcom/larus/ui/arch/component/external/api/receiver/Container;", "appletLifecycleCallback", "com/larus/uaigc/music/applet/MusicTemplateAppletFragment$appletLifecycleCallback$1", "Lcom/larus/uaigc/music/applet/MusicTemplateAppletFragment$appletLifecycleCallback$1;", "onAttach", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", WidgetCostModule.TYPE_ON_CREATE, "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "onResume", "onDestroyView", LiveCommonConstants.REASON_ON_DEDTROY, "initBackIcon", "adaptHostBottomPadding", RootDescription.ROOT_ELEMENT, "Lcom/larus/bmhome/view/ChatConstraintLayout;", "adaptBottomPadding", "", "bottomPadding", "safeBottomPadding", "hasBottomNavigationBar", "updateBackIconVisibility", "canNavigateBackInMusicApplet", "bindAppletData", "actionBarItem", "attachComponents", "showMusicTemplateFragment", "observeUseTemplateEvent", "observeSendFinishedEvent", "openProfileSourceChatPage", "sendConversationId", "", "moveMusicAppletTaskToBackground", "buildTemplateArguments", "buildArgumentsWithMusicInstruction", "ensureMusicInstructionEditorOpened", "tryAutoOpenInputPanel", "resolveDoSameTemplate", "Lcom/larus/bmhome/instruction/core/model/music/MusicGenTemplate;", "initStartWriteEntry", "showMusicInputPanel", "clearInput", "requestFocus", "focusMusicInput", "useMusicTemplate", ThumbGlideUrl.SOURCE_TEMPLATE, "enterFrom", "reportEvent", "reportUseTemplate", "reportTemplatePageEnter", "reportTemplatePageExit", "reportMusicStartCreateIfNeeded", "resolveMusicActionBarItem", "resolveMusicInstructionEditorAbility", "resolveInstructionPanelAbility", "resolveChatParam", "Lcom/larus/bmhome/chat/ChatParam;", "resolveBotId", "resolveChatType", "resolvePreviousPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MusicTemplateAppletFragment extends Fragment {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f373560m = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusFragmentMusicTemplateAppletBinding f373561d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ny9.s f373562e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.z0 f373563f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public f f373564g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public u1 f373565h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f373566i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f373567j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f373568k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f373569l;

    public static final class a {
    }

    public static final class b implements ir8.c.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ MusicTemplateAppletFragment f373570a;

        @Override // ir8.c.a
        public final void a() {
            Intrinsics.checkNotNullParameter(MusicAppletPage.APP_ID, "appId");
            if (Intrinsics.areEqual(MusicAppletPage.APP_ID, MusicAppletPage.APP_ID) == true) goto L5;
            return;
        L5:
            if (ir8.c.a(this) == false) goto L9;
            MusicTemplateAppletFragment r100 = this.f373570a;
            int r101 = MusicTemplateAppletFragment.f373560m;
            r100.W90();
            return;
        }

        public b(MusicTemplateAppletFragment r100) {
            this.f373570a = r100;
        }
    }

    static {
    }

    public final void W90() {
        long r100 = this.f373568k;
        if (r100 > 0) goto L5;
        return;
    L5:
        this.f373568k = 0;
        kr8.n r101 = kr8.n.f505865a;
        kr8.o r102 = kr8.n.a(getArguments(), null, null, null, null, null, 62);
        long r103 = SystemClock.elapsedRealtime() - r100;
        Intrinsics.checkNotNullParameter(r102, PerfLog.PARAM_KEY_CONTEXT_ID);
        JSONObject r104 = kr8.n.k(r102, "template_page");
        r104.put("duration", r103);
        Unit r105 = Unit.INSTANCE;
        kr8.n.g("music_app_page_exit", r104);
    }

    public final com.larus.bmhome.actionbar.model.z0 aa0() {
        com.larus.bmhome.actionbar.model.z0 r100 = this.f373563f;
        if (r100 == null) goto L5;
        return r100;
    L5:
        ny9.s r101 = this.f373562e;
        if (r101 == null) goto L11;
        com.larus.bmhome.actionbar.model.z0 r102 = r101.f();
        if (r102 == null) goto L11;
        this.f373563f = r102;
        return r102;
    L11:
        Bundle r103 = getArguments();
        if (r103 == null) goto L17;
        com.larus.bmhome.actionbar.model.z0 r104 = new ny9.s(r103).f();
        if (r104 == null) goto L17;
        this.f373563f = r104;
        return r104;
    L17:
        IActionBarService r105 = (IActionBarService) ServiceManager.get().getService(IActionBarService.class);
        if (r105 == null) goto L22;
        com.larus.bmhome.actionbar.model.z0 r106 = r105.e(1);
        if (r106 == null) goto L22;
        this.f373563f = r106;
        return r106;
    L22:
        return null;
    }

    public final f ba0() {
        f r100 = this.f373564g;
        if (r100 == null) goto L5;
        return r100;
    L5:
        f r101 = (f) s1a.a.g(this).getAbility(f.class);
        if (r101 == null) goto L8;
        this.f373564g = r101;
        return r101;
    L8:
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroy() {
        CopyOnWriteArraySet<ir8.c.a> r100 = ir8.c.f495501a;
        ir8.c.c(this.f373569l);
        super.onDestroy();
    }

    public MusicTemplateAppletFragment() {
        this.f373569l = new b(this);
    }

    public final void U90() {
        FragmentActivity r100 = getActivity();
        if (r100 != null) goto L17;
        FLogger.f375446a.e("MusicTemplateAppletFragment", "move music applet task to background failed, activity is null");
        return;
    L17:
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L8
        Object r102 = Result.m9449constructorimpl(Boolean.valueOf(r100.moveTaskToBack(true)));     // Catch: Throwable -> L8
    L11:
        if (Result.m9456isSuccessimpl(r102) == false) goto L13;
        boolean r103 = ((Boolean) r102).booleanValue();
        FLogger.f375446a.i("MusicTemplateAppletFragment", "move music applet task to background result=" + r103);
    L13:
        Throwable r104 = Result.m9452exceptionOrNullimpl(r102);
        if (r104 == null) goto L19;
        FLogger.f375446a.e("MusicTemplateAppletFragment", "move music applet task to background failed", r104);
        return;
    L19:
        return;
    L8:
        th = move-exception;
        Result.Companion r105 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    public final void V90() {
        this.f373568k = SystemClock.elapsedRealtime();
        kr8.n r100 = kr8.n.f505865a;
        kr8.o r101 = kr8.n.a(getArguments(), null, null, null, null, null, 62);
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        kr8.n.g("music_app_page_enter", kr8.n.k(r101, "template_page"));
    }

    public final String X90() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L6;
        String r101 = r100.getString("argBotId");
        if (r101 == null) goto L6;
        return r101;
    L6:
        ChatParam r102 = Y90();
        if (r102 == null) goto L9;
        String r103 = r102.f296890b;
    L10:
        if (r103 != null) goto L14;
        return "";
    L14:
        return r103;
    L9:
        r103 = null;
        goto L10
    }

    public final ChatParam Y90() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        ChatParam r101 = (ChatParam) r100.getParcelable("chat_param");
    L7:
        if ((r101 instanceof ChatParam) == true) goto L9;
        return null;
    L9:
        return r101;
    L5:
        r101 = null;
        goto L7
    }

    public final String Z90() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L6;
        String r101 = r100.getString("arg_chat_type");
        if (r101 == null) goto L6;
        return r101;
    L6:
        ChatParam r102 = Y90();
        if (r102 == null) goto L9;
        String r103 = r102.f296893e;
    L10:
        if (r103 != null) goto L14;
        return "other_default";
    L14:
        return r103;
    L9:
        r103 = null;
        goto L10
    }

    public final String ca0() {
        Bundle r100 = getArguments();
        if (r100 == null) goto L6;
        String r101 = r100.getString("argPreviousPage");
        if (r101 == null) goto L6;
        return r101;
    L6:
        ChatParam r102 = Y90();
        if (r102 == null) goto L9;
        String r103 = r102.f296891c;
    L10:
        if (r103 != null) goto L14;
        return "";
    L14:
        return r103;
    L9:
        r103 = null;
        goto L10
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        W90();
        super.onDestroyView();
        this.f373561d = null;
        this.f373564g = null;
        this.f373565h = null;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        if (this.f373568k > 0) goto L6;
        V90();
        return;
    }

    public static boolean T90(ChatConstraintLayout r100) {
        WindowInsetsCompat r101 = ViewCompat.getRootWindowInsets(r100);
        if (r101 != null) goto L6;
        return false;
    L6:
        if (r101.getInsets(WindowInsetsCompat.Type.tappableElement()).bottom <= 0) goto L8;
        return true;
    L8:
        int r102 = r101.getInsets(WindowInsetsCompat.Type.navigationBars()).bottom;
        int r103 = r101.getInsets(WindowInsetsCompat.Type.mandatorySystemGestures()).bottom;
        if (r102 <= 0) goto L13;
        if (r103 > r102) goto L14;
        return true;
    L14:
        return false;
    L13:
        return false;
    }

    public final void S90(com.larus.bmhome.actionbar.model.z0 r100) {
        Bundle r101 = new Bundle(getArguments());
        if (r100 == null) goto L5;
        this.f373563f = r100;
        r101.putString("custom_action_bar_item", xt7.d.f565073b.a(com.larus.bmhome.actionbar.model.z0.Companion.serializer(), r100));
    L6:
        setArguments(r101);
        t1a.b r102 = s1a.a.g(this);
        de8.c r103 = de8.c.f468084s;
        r102.n(de8.c.a.a(r101), de8.c.class);
        ny9.s r104 = new ny9.s(r101);
        s1a.a.g(this).n(r104, ny9.s.class);
        this.f373562e = r104;
        ny9.u r105 = new ny9.u(r104);
        s1a.a.g(this).n(r105, ny9.u.class);
        return;
    L5:
        FLogger.f375446a.e("MusicTemplateAppletFragment", "music action bar item is null when bind applet data");
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public final void onAttach(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super.onAttach(r100);
        S90(aa0());
    }

    @Override // androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        CopyOnWriteArraySet<ir8.c.a> r101 = ir8.c.f495501a;
        b r102 = this.f373569l;
        Intrinsics.checkNotNullParameter(r102, "callback");
        ir8.c.f495501a.add(r102);
        FragmentAttachExtKt.b(this, ContainerFilter.INPUT_ONLY);
        k1a.b.a(this, new i0(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v3, types: [com.larus.uaigc.music.applet.g0] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r110);
        CopyOnWriteArraySet<ir8.c.a> r101 = ir8.c.f495501a;
        ir8.c.b(this.f373569l);
        LarusFragmentMusicTemplateAppletBinding r102 = this.f373561d;
        if (r102 == null) goto L7;
        final ChatConstraintLayout r103 = r102.f373143d;
        if (r103 == null) goto L7;
        final int r111 = c7.b(16);
        final Function2<Integer, String, Boolean> r104 = r103.getInterruptBottomPaddingUpdate();
        r103.setInterruptBottomPaddingUpdate(new j0(this, r111, r103, r104));
        r103.post(new k0(this, r103, r111));
    L7:
        V90();
        boolean r105 = true;
        if (getChildFragmentManager().findFragmentById(R.id.template_container) != null) goto L15;
        MusicTemplateListFragment r106 = new MusicTemplateListFragment();
        Bundle r107 = new Bundle(getArguments());
        r107.putString("argBotId", X90());
        r107.putString("arg_chat_type", Z90());
        r107.putString("argPreviousPage", ca0());
        r107.putBoolean("compatDoubleTabMargin", true);
        r107.putBoolean("argument_hide_title_bar", true);
        r107.putBoolean("argument_is_music_applet_template", true);
        r106.setArguments(r107);
        r106.f373741d = new c0(this);
        FragmentTransaction r108 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r108, r106, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.template_container) == true) goto L14;
        r108 = r108.replace(R.id.template_container, r106);
    L14:
        r108.commitAllowingStateLoss();
    L15:
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new MusicTemplateAppletFragment$observeUseTemplateEvent$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new MusicTemplateAppletFragment$observeSendFinishedEvent$1(this, null), 3, null);
        if (this.f373566i == true) goto L32;
        Bundle r109 = getArguments();
        if (r109 != null) goto L21;
    L23:
        r105 = false;
    L24:
        if (r105 == false) goto L33;
        t1 r112 = (t1) s1a.a.g(this).getAbility(t1.class);
        if (r112 != 0) goto L29;
        FLogger.f375446a.e("MusicTemplateAppletFragment", "auto open music input failed, input ready ability is null");
        return;
    L29:
        r112.kK(new g0(this));
        return;
    L33:
        return;
    L21:
        if (r109.getBoolean("auto_open_input_panel") != true) goto L23;
    }

    public static void da0(MusicTemplateAppletFragment r110, boolean r111, int r112) {
        boolean r100 = false;
        if ((r112 & 1) == 0) goto L6;
        r111 = false;
    L6:
        if ((r112 & 2) == 0) goto L8;
        boolean r113 = true;
    L9:
        LarusFragmentMusicTemplateAppletBinding r101 = r110.f373561d;
        if (r101 == null) goto L49;
        com.larus.utils.e1.o(r101.f373144e);
        com.larus.utils.e1.x(r101.f373142c);
        if (r110.f373567j == true) goto L16;
        r110.f373567j = true;
        kr8.n r102 = kr8.n.f505865a;
        kr8.o r103 = kr8.n.a(r110.getArguments(), null, null, null, null, null, 62);
        Intrinsics.checkNotNullParameter(r103, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter("template_page", "currentPage");
        kr8.n.g("music_start_create", kr8.n.k(r103, "template_page"));
    L16:
        u1 r104 = r110.f373565h;
        if (r104 != null) goto L23;
        r104 = (u1) s1a.a.g(r110).getAbility(u1.class);
        if (r104 == null) goto L22;
        r110.f373565h = r104;
        goto L23
    L22:
        r104 = null;
    L23:
        if (r104 == null) goto L25;
        r104.yD();
    L25:
        f r105 = r110.ba0();
        if (r105 != null) goto L28;
    L30:
        if (r100 == true) goto L39;
        com.larus.bmhome.actionbar.model.z0 r106 = r110.aa0();
        if (r106 != null) goto L35;
        FLogger.f375446a.e("MusicTemplateAppletFragment", "open music instruction editor failed, actionBarItem is null");
        goto L39
    L35:
        r110.S90(r106);
        f r107 = r110.ba0();
        if (r107 != null) goto L38;
        FLogger.f375446a.e("MusicTemplateAppletFragment", "open music instruction editor failed, editorAbility is null");
        goto L39
    L38:
        r107.ov(r106);
    L39:
        if (r113 == false) goto L46;
        LarusFragmentMusicTemplateAppletBinding r114 = r110.f373561d;
        if (r114 == null) goto L47;
        FrameLayout r115 = r114.f373142c;
        if (r115 == null) goto L48;
        r115.post(new h0(r111, r110));
        return;
    L48:
        return;
    L47:
        return;
    L46:
        return;
    L28:
        if (r105.Q1() != 1) goto L30;
        r100 = true;
        goto L30
    L49:
        return;
    L8:
        r113 = false;
        goto L9
    }

    public final void ea0(bq8.a r110, String r111, boolean r112) {
        FLogger.f375446a.i("MusicTemplateAppletFragment", "use music template, templateId=" + r110.f20048a + ", enterFrom=" + r111);
        Bundle r100 = getArguments();
        if (r100 == null) goto L5;
        r100.putString(com.bytedance.android.ec.core.event.a.KEY_FROM_ENTRANCE, "similar");
    L5:
        boolean r101 = false;
        if (r112 == true) goto L8;
    L12:
        da0(this, false, 1);
        f r113 = ba0();
        if (r113 == null) goto L15;
        r113.mZ(r110);
    L15:
        LarusFragmentMusicTemplateAppletBinding r114 = this.f373561d;
        if (r114 == null) goto L21;
        FrameLayout r115 = r114.f373142c;
        if (r115 == null) goto L22;
        r115.post(new h0(r101, this));
        return;
    L22:
        return;
    L21:
        return;
    L8:
        if (Intrinsics.areEqual(r111, "template_detail_button") == false) goto L10;
        String r116 = "music_template_detail";
    L11:
        kr8.b0 r102 = new kr8.b0(r111, String.valueOf(r110.f20048a), "music", X90(), Z90(), 1);
        kr8.n r117 = kr8.n.f505865a;
        kr8.l.a.b(r102, kr8.n.c(kr8.n.a(getArguments(), null, r110, null, "similar", r116, 10), r116, false), 1);
        goto L12
    L10:
        r116 = "template_page";
        goto L11
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        int r100 = 0;
        View r113 = r110.inflate(R.layout.larus_fragment_music_template_applet, r111, false);
        int r114 = R.id.back_icon;
        AppCompatImageView r101 = (AppCompatImageView) ViewBindings.findChildViewById(r113, R.id.back_icon);
        if (r101 == null) goto L78;
        r114 = R.id.chat_input;
        FrameLayout r102 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.chat_input);
        if (r102 == null) goto L78;
        r114 = R.id.input_delegate;
        ViewStub r115 = (ViewStub) ViewBindings.findChildViewById(r113, R.id.input_delegate);
        if (r115 == null) goto L78;
        ChatConstraintLayout r103 = (ChatConstraintLayout) r113;
        FrameLayout r104 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.start_write_entry_container);
        if (r104 == null) goto L76;
        FrameLayout r105 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.template_container);
        if (r105 != null) goto L13;
        r114 = R.id.template_container;
        goto L78
    L13:
        if (((AppCompatTextView) ViewBindings.findChildViewById(r113, R.id.title)) == null) goto L74;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.title_bar);
        if (r106 == null) goto L73;
        this.f373561d = new LarusFragmentMusicTemplateAppletBinding(r103, r101, r102, r115, r103, r104, r105, r106);
        InputViewCreatorDelegate.f298409b.a(r115, Integer.valueOf(R.id.input_delegate));
        LarusFragmentMusicTemplateAppletBinding r116 = this.f373561d;
        if (r116 == null) goto L21;
        ChatConstraintLayout r117 = r116.f373143d;
        if (r117 == null) goto L21;
        com.larus.uaigc.createpage.utils.p.a(r117);
    L21:
        LarusFragmentMusicTemplateAppletBinding r118 = this.f373561d;
        if (r118 == null) goto L30;
        FrameLayout r119 = r118.f373146g;
        if (r119 == null) goto L30;
        ViewGroup.LayoutParams r120 = r119.getLayoutParams();
        if (r120 == null) goto L29;
        ViewGroup.MarginLayoutParams r121 = (ViewGroup.MarginLayoutParams) r120;
        com.larus.utils.i0.f375410a.getClass();
        r121.topMargin = com.larus.utils.i0.g() + i5.r0();
        r119.setLayoutParams(r121);
        goto L30
    L29:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L30:
        LarusFragmentMusicTemplateAppletBinding r122 = this.f373561d;
        if (r122 == null) goto L35;
        AppCompatImageView r123 = r122.f373141b;
        if (r123 == null) goto L35;
        com.larus.utils.e1.d(r123, new f0(this));
    L35:
        boolean r124 = IMusicAppletHostService.f370279a.c();
        LarusFragmentMusicTemplateAppletBinding r125 = this.f373561d;
        if (r125 == null) goto L43;
        AppCompatImageView r126 = r125.f373141b;
        if (r126 == null) goto L43;
        if (r124 == true) goto L42;
        r100 = 8;
    L42:
        r126.setVisibility(r100);
    L43:
        if (r124 == false) goto L53;
        LarusFragmentMusicTemplateAppletBinding r127 = this.f373561d;
        if (r127 == null) goto L53;
        AppCompatImageView r128 = r127.f373141b;
        if (r128 == null) goto L53;
        ViewGroup.LayoutParams r129 = r128.getLayoutParams();
        if (r129 == null) goto L52;
        ViewGroup.MarginLayoutParams r130 = (ViewGroup.MarginLayoutParams) r129;
        com.larus.utils.i0.f375410a.getClass();
        r130.topMargin = com.larus.utils.i0.g() + i5.Y();
        r128.setLayoutParams(r130);
        goto L53
    L52:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
    L53:
        LarusFragmentMusicTemplateAppletBinding r131 = this.f373561d;
        if (r131 == null) goto L58;
        FrameLayout r132 = r131.f373142c;
        if (r132 == null) goto L58;
        com.larus.utils.e1.o(r132);
    L58:
        LarusFragmentMusicTemplateAppletBinding r133 = this.f373561d;
        if (r133 == null) goto L63;
        FrameLayout r134 = r133.f373144e;
        if (r134 == null) goto L63;
        com.larus.utils.e1.x(r134);
    L63:
        LarusFragmentMusicTemplateAppletBinding r135 = this.f373561d;
        if (r135 == null) goto L68;
        FrameLayout r136 = r135.f373144e;
        if (r136 == null) goto L68;
        com.larus.utils.e1.d(r136, new l0(this));
    L68:
        LarusFragmentMusicTemplateAppletBinding r137 = this.f373561d;
        if (r137 != null) goto L79;
        return null;
    L79:
        return r137.f373143d;
    L73:
        r114 = R.id.title_bar;
        goto L78
    L74:
        r114 = R.id.title;
        goto L78
    L76:
        r114 = R.id.start_write_entry_container;
    L78:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
