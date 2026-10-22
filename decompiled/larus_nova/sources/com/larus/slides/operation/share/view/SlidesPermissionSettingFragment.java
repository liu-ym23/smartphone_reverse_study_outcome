package com.larus.slides.operation.share.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.bmhome.view.item.CustomSwitchCompat;
import com.larus.bmhome.view.item.ItemGroup;
import com.larus.bmhome.view.item.ItemTextToggle;
import com.larus.nova.R;
import com.larus.slides.biz.impl.databinding.LarusPageSlidesPermissionSettingsBinding;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tx9.a1;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\n\u0018\u0000 %2\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\u001a\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00142\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\b\u0010 \u001a\u00020\u001cH\u0002J\b\u0010!\u001a\u00020\u001cH\u0002J\b\u0010\"\u001a\u00020\u0007H\u0016J\b\u0010#\u001a\u00020\tH\u0016J\b\u0010$\u001a\u00020\u001cH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/slides/operation/share/view/SlidesPermissionSettingFragment;", "Lcom/larus/trace/tracknode/TraceFragment;", "<init>", "()V", "binding", "Lcom/larus/slides/biz/impl/databinding/LarusPageSlidesPermissionSettingsBinding;", "currentPrivacyStatus", "", "currentSlidesToken", "", "aipptTaskId", "presentationId", "resourceId", "resourceType", "", "Ljava/lang/Integer;", "artifactMetaId", "artifactType", "isUpdatingFromCode", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", WidgetCostModule.TYPE_ON_CREATE, "", "onViewCreated", "view", "setupViews", "updatePermissionPublic", "updatePermissionPrivate", "autoLogEnterPage", "getCurrentPageName", "logEnterPage", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SlidesPermissionSettingFragment extends TraceFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f369737o = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public LarusPageSlidesPermissionSettingsBinding f369738e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f369739f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f369740g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f369741h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f369742i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public String f369743j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Integer f369744k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public String f369745l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public Integer f369746m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f369747n;

    public static final class a {
    }

    static {
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final boolean S90() {
        return false;
    }

    @Override // com.larus.trace.tracknode.TraceFragment
    public final void T90() {
    }

    @Override // com.larus.trace.tracknode.a
    public final String k() {
        return "aippt_permission_setting";
    }

    public SlidesPermissionSettingFragment() {
        this.f369740g = "";
        this.f369741h = "";
        this.f369742i = "";
        this.f369743j = "";
        this.f369745l = "";
    }

    @Override // com.larus.trace.tracknode.TraceFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r610) {
        super.onCreate(r610);
        Bundle r100 = getArguments();
        if (r100 == null) goto L7;
        boolean r101 = true;
        if (r100.getBoolean("slides_permission") != true) goto L7;
    L8:
        this.f369739f = r101;
        Bundle r102 = getArguments();
        String r103 = "";
        if (r102 == null) goto L12;
        String r104 = r102.getString("slides_token");
        if (r104 == null) goto L12;
    L13:
        this.f369740g = r104;
        Bundle r105 = getArguments();
        if (r105 == null) goto L17;
        String r106 = r105.getString("aippt_task_id");
        if (r106 == null) goto L17;
    L18:
        this.f369741h = r106;
        Bundle r107 = getArguments();
        if (r107 == null) goto L22;
        String r108 = r107.getString("presentation_id");
        if (r108 == null) goto L22;
    L23:
        this.f369742i = r108;
        Bundle r109 = getArguments();
        if (r109 == null) goto L27;
        String r110 = r109.getString("resource_id");
        if (r110 == null) goto L27;
    L28:
        this.f369743j = r110;
        Bundle r111 = getArguments();
        Integer r112 = null;
        if (r111 == null) goto L31;
        Integer r113 = Integer.valueOf(r111.getInt("resource_type"));
    L32:
        this.f369744k = r113;
        Bundle r114 = getArguments();
        if (r114 == null) goto L38;
        String r115 = r114.getString("artifact_meta_id");
        if (r115 == null) goto L38;
        r103 = r115;
    L38:
        this.f369745l = r103;
        Bundle r116 = getArguments();
        if (r116 == null) goto L41;
        r112 = Integer.valueOf(r116.getInt("artifact_type"));
    L41:
        this.f369746m = r112;
        a1.c(null, null, null, null, null, "aippt_permission_setting", null, null, "aippt_new_detail_share_panel", null, null, null, null, null, null, null, "aippt_new_detail", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, this.f369745l, r112, null, null, null, null, this.f369741h, this.f369742i, this.f369743j, this.f369744k, null, null, null, null, null, null, null, null, null, -1049729, -7876609, 7);
        return;
    L31:
        r113 = null;
    L27:
        r110 = "";
    L22:
        r108 = "";
    L17:
        r106 = "";
    L12:
        r104 = "";
    L7:
        r101 = false;
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusPageSlidesPermissionSettingsBinding r102 = this.f369738e;
        if (r102 == null) goto L7;
        NovaTitleBarEx r103 = r102.f369339c;
        if (r103 == null) goto L7;
        NovaTitleBarEx.Y5(r103, r103.getResources().getString(R.string.larus_slides_header_permission), Integer.valueOf(R.color.larus_neutral_100), null, 4);
        NovaTitleBarEx.b6(r103, R.drawable.larus_ic_left_back, false, null, null, new com.larus.slides.operation.share.view.a(this), 14);
    L7:
        LarusPageSlidesPermissionSettingsBinding r104 = this.f369738e;
        if (r104 == null) goto L14;
        ItemTextToggle r105 = r104.f369338b;
        if (r105 == null) goto L14;
        CustomSwitchCompat r106 = r105.getToggleView();
        if (r106 == null) goto L14;
        r106.setChecked(this.f369739f);
    L14:
        LarusPageSlidesPermissionSettingsBinding r107 = this.f369738e;
        if (r107 == null) goto L22;
        ItemTextToggle r108 = r107.f369338b;
        if (r108 == null) goto L23;
        CustomSwitchCompat r109 = r108.getToggleView();
        if (r109 == null) goto L24;
        r109.setOnCheckedChangeListener(new b(this));
        return;
    L24:
        return;
    L23:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        FLogger.f375446a.i("SlidesPermissionSettingFragment", "[onCreateView]");
        View r103 = r100.inflate(R.layout.larus_page_slides_permission_settings, r101, false);
        int r104 = R.id.slides_permission_settings;
        ItemTextToggle r105 = (ItemTextToggle) ViewBindings.findChildViewById(r103, R.id.slides_permission_settings);
        if (r105 == null) goto L11;
        r104 = R.id.theme_group;
        if (((ItemGroup) ViewBindings.findChildViewById(r103, R.id.theme_group)) == null) goto L11;
        r104 = R.id.title_bar;
        NovaTitleBarEx r106 = (NovaTitleBarEx) ViewBindings.findChildViewById(r103, R.id.title_bar);
        if (r106 == null) goto L11;
        ConstraintLayout r107 = (ConstraintLayout) r103;
        this.f369738e = new LarusPageSlidesPermissionSettingsBinding(r107, r105, r106);
        return r107;
    L11:
        throw new NullPointerException("Missing required view with ID: ".concat(r103.getResources().getResourceName(r104)));
    }
}
