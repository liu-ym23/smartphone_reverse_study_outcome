package com.larus.community.impl.publish;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.doubao.relax.profile.edit.ProfileEditRelaxPage;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.chat.model.repo.IChatRepoService;
import com.larus.bmhome.chat.model.repo.RepoDispatcherDelegate;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.community.impl.databinding.LarusCommunityCreationPublishFragmentLayoutBinding;
import com.larus.community.impl.publish.viewmodel.CreationPublishViewModel;
import com.larus.nova.R;
import com.larus.platform.api.creation.PublisherCreation;
import com.larus.platform.api.creation.PublisherTrackParams;
import com.larus.platform.api.creation.UserCreationFromIM;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.uaigc.utils.DataConverterKt;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u0010H\u0002J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\"H\u0016J\b\u0010#\u001a\u00020\u0010H\u0016J\b\u0010$\u001a\u00020\u0010H\u0016J\u0010\u0010%\u001a\u0004\u0018\u00010\u001fH\u0082@¢\u0006\u0002\u0010&J\u0012\u0010'\u001a\u00020\u00102\b\u0010(\u001a\u0004\u0018\u00010)H\u0002J\u0012\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-H\u0002J\u0012\u0010.\u001a\u00020\u00102\b\u0010/\u001a\u0004\u0018\u00010-H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/larus/community/impl/publish/CreationPublishFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/community/impl/publish/ability/ICreationPublishAbility;", "<init>", "()V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreationPublishFragmentLayoutBinding;", "viewModel", "Lcom/larus/community/impl/publish/viewmodel/CreationPublishViewModel;", "getViewModel", "()Lcom/larus/community/impl/publish/viewmodel/CreationPublishViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "publisherTrackParams", "Lcom/larus/platform/api/creation/PublisherTrackParams;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "initView", "autoLogEnterPage", "", "getCurrentPageName", "", "fillTrackParams", "params", "Lcom/ixigua/lib/track/TrackParams;", "updateInset", "publish", "getCreationTaskId", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "handlePublishSuccess", "it", "Lcom/larus/platform/api/creation/UserCreation;", "findRouteActivityBelowPublish", "Landroidx/fragment/app/FragmentActivity;", "currentActivity", "Landroid/app/Activity;", ProfileEditRelaxPage.METHOD_HIDE_KEYBOARD, "activity", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationPublishFragment extends TraceFragment implements n29.a {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f329619h = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusCommunityCreationPublishFragmentLayoutBinding f329620e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f329621f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public PublisherTrackParams f329622g;

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return true;
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "publish_creation_page";
    }

    @Override // n29.a
    public final void Hb() {
        LarusCommunityCreationPublishFragmentLayoutBinding r100 = this.f329620e;
        if (r100 == null) goto L8;
        ChatConstraintLayout r101 = r100.f329098b;
        if (r101 == null) goto L9;
        r101.post(new e(this));
        return;
    L9:
        return;
    }

    public final CreationPublishViewModel V90() {
        return (CreationPublishViewModel) this.f329621f.getValue();
    }

    public CreationPublishFragment() {
        final Function0<Fragment> r100 = new CreationPublishFragment$special$$inlined$viewModels$default$1(this);
        this.f329621f = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection.getOrCreateKotlinClass(CreationPublishViewModel.class), new CreationPublishFragment$special$$inlined$viewModels$default$2(r100), new CreationPublishFragment$special$$inlined$viewModels$default$3(r100, this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v2 */
    @Override // n29.a
    public final void JM() {
        n29.c r100 = (n29.c) s1a.a.g(this).getAbility(n29.c.class);
        int r101 = 1;
        if (r100 == null) goto L5;
        ?? r102 = r100.d30();
    L6:
        n29.c r103 = (n29.c) s1a.a.g(this).getAbility(n29.c.class);
        String r104 = null;
        if (r103 == null) goto L9;
        Integer r105 = r103.o30();
    L10:
        n29.b r106 = (n29.b) s1a.a.g(this).getAbility(n29.b.class);
        if (r106 == null) goto L14;
        String r107 = r106.CY();
        if (r107 == null) goto L14;
    L15:
        String r108 = r107;
        n29.b r109 = (n29.b) s1a.a.g(this).getAbility(n29.b.class);
        if (r109 == null) goto L18;
        int r110 = r109.Uy();
    L19:
        FragmentActivity r111 = getActivity();
        if (r111 == null) goto L30;
        View r112 = r111.getCurrentFocus();
        if (r112 == null) goto L30;
        Object r113 = r111.getSystemService("input_method");
        if ((r113 instanceof InputMethodManager) == false) goto L27;
        InputMethodManager r114 = (InputMethodManager) r113;
    L28:
        if (r114 == null) goto L30;
        r114.hideSoftInputFromWindow(r112.getWindowToken(), 0);
        goto L30
    L27:
        r114 = null;
    L30:
        V90().publish(r102, r108);
        com.larus.community.impl.publish.viewmodel.h r115 = V90().getPublisherCreationFlow().getValue();
        if (r115 == null) goto L33;
        PublisherCreation r116 = r115.f329701a;
    L34:
        if (r116 == null) goto L38;
        Integer r117 = r116.getCreationType();
        if (r117 == null) goto L38;
        String r118 = zp9.y.a(r117.intValue());
    L39:
        if (r116 == null) goto L41;
        String r119 = r116.getCreationId();
    L42:
        if (r116 == null) goto L44;
        boolean r120 = Intrinsics.areEqual(r116.getCanvasMode(), Boolean.TRUE);
    L45:
        if (r120 == false) goto L47;
        String r121 = String.valueOf(r116.getCanvasSubId());
    L50:
        if (r116 == null) goto L54;
        Integer r122 = r116.getCreationType();
        if (r122 == null) goto L54;
        r104 = zp9.y.b(r122.intValue());
    L54:
        boolean r123 = o0.d(r108);
        Integer r124 = Integer.valueOf(r110);
        JSONObject r125 = new JSONObject();
        Intrinsics.checkNotNullParameter(r125, "params");
        r125.putOpt("sub_type", r118);     // Catch: JSONException -> L63
        r125.putOpt("creation_id", r119);     // Catch: JSONException -> L63
        r125.putOpt(MusicAppletPage.KEY_MESSAGE_ID, r121);     // Catch: JSONException -> L63
        r125.putOpt("type", r104);     // Catch: JSONException -> L63
        if (r123 == true) goto L59;
        r101 = 0;
    L59:
        r125.putOpt("is_has_caption", Integer.valueOf(r101));     // Catch: JSONException -> L63
        r125.putOpt("caption_length", r124);     // Catch: JSONException -> L63
        r125.putOpt("is_image_reference_public", Integer.valueOf(r102));     // Catch: JSONException -> L63
        if (r105 == null) goto L65;
        r125.put("image_reference_cnt", r105.intValue());     // Catch: JSONException -> L63
    L65:
        TrackParams r126 = new TrackParams().merge(r125);
        by7.a r127 = new by7.a("complete_public_creation");
        r127.f21463a.merge(r126);
        r127.b();
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationPublishFragment$publish$1(this, r116, r108, r102, r110, r105, null), 3, null);
        return;
    L63:
        e = move-exception;
        FLogger.f375446a.e("CommunityEventHelper", "error in CommunityEventHelper mobCompletePublicCreation " + e.getLocalizedMessage());
        goto L65
    L47:
        if (r116 == null) goto L49;
        r121 = r116.getMessageId();
        goto L50
    L49:
        r121 = null;
        goto L50
    L44:
        r120 = false;
        goto L45
    L41:
        r119 = null;
    L38:
        r118 = null;
        goto L39
    L33:
        r116 = null;
        goto L34
    L18:
        r110 = 0;
    L14:
        r107 = "";
        goto L15
    L9:
        r105 = null;
        goto L10
    L5:
        r102 = 1;
        goto L6
    }

    @Override // com.larus.trace.tracknode.TraceFragment, by7.e, by7.d
    public final void fillTrackParams(TrackParams r100) {
        Intrinsics.checkNotNullParameter(r100, "params");
        com.larus.trace.tracknode.a.C4500a.a(this, r100);
        PublisherTrackParams r101 = this.f329622g;
        if (r101 == null) goto L5;
        String r102 = r101.a();
    L6:
        r100.put("previous_page", r102);
        return;
    L5:
        r102 = null;
        goto L6
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r210) {
        super.onCreate(r210);
        CreationPublishViewModel r100 = V90();
        Bundle r101 = getArguments();
        if (r101 == null) goto L6;
        PublisherCreation r102 = (PublisherCreation) r101.getParcelable("key_publish_creation");
        if (r102 == null) goto L6;
    L7:
        r100.initialize(r102);
        Bundle r103 = getArguments();
        if (r103 == null) goto L10;
        PublisherTrackParams r104 = (PublisherTrackParams) r103.getParcelable("key_publish_tracker_params");
    L11:
        this.f329622g = r104;
        return;
    L10:
        r104 = null;
    L6:
        r102 = new PublisherCreation(null, null, null, null, null, null, null, null, null, false, null, null, null, null, 16383, null);
        goto L7
    }

    public static final Object U90(CreationPublishFragment r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof CreationPublishFragment$getCreationTaskId$1) == false) goto L7;
        CreationPublishFragment$getCreationTaskId$1 r102 = (CreationPublishFragment$getCreationTaskId$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        String r107 = "";
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        PublisherCreation r108 = (PublisherCreation) r102.L$0;
        ResultKt.throwOnFailure(r104);
    L37:
        String r109 = (String) r104;
        if (r109 == null) goto L41;
        r107 = r109;
    L41:
        Iterator r110 = ((LinkedHashMap) DataConverterKt.d(r107)).entrySet().iterator();
    L43:
        if (r110.hasNext() == false) goto L51;
        Object r111 = r110.next();
        String r112 = ((UserCreationFromIM) ((Map.Entry) r111).getValue()).getCreationId();
        if (r108 == null) goto L47;
        String r113 = r108.getCreationId();
    L49:
        if (Intrinsics.areEqual(r112, r113) == false) goto L43;
    L52:
        Map.Entry r114 = (Map.Entry) r111;
        if (r114 == null) goto L56;
        return (String) r114.getKey();
    L56:
        return null;
    L47:
        r113 = null;
        goto L49
    L51:
        r111 = null;
        goto L52
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        com.larus.community.impl.publish.viewmodel.h r115 = r100.V90().getPublisherCreationFlow().getValue();
        if (r115 == null) goto L17;
        r108 = r115.f329701a;
    L18:
        if (r108 == null) goto L20;
        String r116 = r108.getTaskId();
    L21:
        if (r116 != null) goto L23;
    L26:
        boolean r117 = true;
    L27:
        if (r117 == false) goto L60;
        IChatRepoService r118 = RepoDispatcherDelegate.f307737b.e();
        if (r108 == null) goto L33;
        String r119 = r108.getMessageId();
        if (r119 == null) goto L33;
    L34:
        r102.L$0 = r108;
        r102.label = 1;
        r104 = r118.w1(r119, r102);
        if (r104 != r105) goto L37;
        return r105;
    L33:
        r119 = "";
        goto L34
    L60:
        return r108.getTaskId();
    L23:
        if (r116.length() == 0) goto L26;
        r117 = false;
        goto L27
    L20:
        r116 = null;
        goto L21
    L17:
        r108 = null;
    L7:
        r102 = new CreationPublishFragment$getCreationTaskId$1(r100, r101);
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Context r102 = getContext();
        if (r102 == null) goto L19;
        LarusCommunityCreationPublishFragmentLayoutBinding r103 = this.f329620e;
        if (r103 == null) goto L9;
        ChatConstraintLayout r104 = r103.f329097a;
        if (r104 == null) goto L9;
        r104.setDisableTopPadding(true);
    L9:
        LarusCommunityCreationPublishFragmentLayoutBinding r105 = this.f329620e;
        if (r105 == null) goto L14;
        ChatConstraintLayout r106 = r105.f329097a;
        if (r106 == null) goto L14;
        r106.setDisableBottomPadding(true);
    L14:
        LarusCommunityCreationPublishFragmentLayoutBinding r107 = this.f329620e;
        if (r107 == null) goto L19;
        ChatConstraintLayout r108 = r107.f329097a;
        if (r108 == null) goto L19;
        r108.k6(r102);
    L19:
        s1a.a.a(this, this, n29.a.class);
        k1a.b.a(this, new c(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new CreationPublishFragment$initView$2(this, null), 3, null);
        LarusCommunityCreationPublishFragmentLayoutBinding r109 = this.f329620e;
        if (r109 == null) goto L25;
        ChatConstraintLayout r110 = r109.f329098b;
        if (r110 == null) goto L26;
        e1.d(r110, new d());
        return;
    L26:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = getLayoutInflater().inflate(R.layout.larus_community_creation_publish_fragment_layout, r101, false);
        int r104 = R.id.bottom_layout;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r103, R.id.bottom_layout)) == null) goto L22;
        ChatConstraintLayout r105 = (ChatConstraintLayout) r103;
        FrameLayout r106 = (FrameLayout) ViewBindings.findChildViewById(r103, R.id.creation_desc_input_layout);
        if (r106 == null) goto L20;
        FrameLayout r107 = (FrameLayout) ViewBindings.findChildViewById(r103, R.id.creation_publish_set_layout);
        if (r107 != null) goto L9;
        r104 = R.id.creation_publish_set_layout;
        goto L22
    L9:
        if (((ImageAdjustView) ViewBindings.findChildViewById(r103, R.id.creation_show_component_layout)) != null) goto L11;
        r104 = R.id.creation_show_component_layout;
        goto L22
    L11:
        if (((ConstraintLayout) ViewBindings.findChildViewById(r103, R.id.publish_button_layout)) != null) goto L13;
        r104 = R.id.publish_button_layout;
        goto L22
    L13:
        if (((NovaTitleBarEx) ViewBindings.findChildViewById(r103, R.id.title_layout)) == null) goto L16;
        this.f329620e = new LarusCommunityCreationPublishFragmentLayoutBinding(r105, r105, r106, r107);
        return r105;
    L16:
        r104 = R.id.title_layout;
        goto L22
    L20:
        r104 = R.id.creation_desc_input_layout;
    L22:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
