package com.larus.bmhome.view.actionbar.gaokao;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.doubao.relax.profile.edit.ProfileEditRelaxPage;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ixigua.lib.track.TrackParams;
import com.larus.bmhome.databinding.LarusDialogGaokaoPreferenceBinding;
import com.larus.bmhome.view.actionbar.gaokao.adapter.GaokaoPreferenceAdapter;
import com.larus.bmhome.view.actionbar.gaokao.adapter.GaokaoPreferenceItemDecoration;
import com.larus.bmhome.view.actionbar.gaokao.adapter.GaokaoProvinceAdapter;
import com.larus.bmhome.view.actionbar.gaokao.model.GaokaoProvince;
import com.larus.bmhome.view.actionbar.gaokao.model.GaokaoType;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.widget.MaxHeightScrollView;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000e\u0018\u0000 S2\u00020\u00012\u00020\u0002:\u0001SB\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001b2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010%\u001a\u00020#H\u0016J\u0012\u0010&\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u001bH\u0002J\b\u0010'\u001a\u00020#H\u0002J\u001c\u0010(\u001a\u00020#2\b\u0010)\u001a\u0004\u0018\u00010\r2\b\u0010*\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010+\u001a\u00020#H\u0003J\b\u0010,\u001a\u00020\rH\u0002J\b\u0010-\u001a\u00020#H\u0002J\b\u0010.\u001a\u00020\rH\u0002J\b\u0010/\u001a\u00020\rH\u0002J\b\u00102\u001a\u00020#H\u0002J\u0018\u00103\u001a\u0004\u0018\u00010\r2\f\u00104\u001a\b\u0012\u0004\u0012\u00020\r0\bH\u0002J\b\u00105\u001a\u00020#H\u0002J\b\u00107\u001a\u00020#H\u0002J\b\u00108\u001a\u00020#H\u0002J\b\u00109\u001a\u00020#H\u0002J\b\u0010:\u001a\u00020\u0015H\u0002J\u001c\u0010;\u001a\u00020\u00152\b\u0010<\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010=\u001a\u00020\u0015H\u0002J\b\u0010>\u001a\u00020\u0015H\u0002J\b\u0010?\u001a\u00020#H\u0002J\u0012\u0010@\u001a\u00020#2\b\u0010A\u001a\u0004\u0018\u00010BH\u0002J\u0010\u0010C\u001a\u00020\t2\u0006\u0010D\u001a\u00020\rH\u0002J\b\u0010E\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u00020\r2\u0006\u0010H\u001a\u00020FH\u0002J\b\u0010N\u001a\u00020FH\u0002J\u0014\u0010O\u001a\u0004\u0018\u00010\r2\b\u0010P\u001a\u0004\u0018\u00010\rH\u0002J\b\u0010Q\u001a\u00020\u0015H\u0002J\b\u0010R\u001a\u00020#H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u000201X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010I\u001a\u00020F8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bL\u0010M\u001a\u0004\bJ\u0010K¨\u0006T"}, d2 = {"Lcom/larus/bmhome/view/actionbar/gaokao/GaokaoPreferenceDialog;", "Landroidx/fragment/app/Fragment;", "Lcom/ixigua/lib/track/ITrackNode;", "<init>", "()V", "binding", "Lcom/larus/bmhome/databinding/LarusDialogGaokaoPreferenceBinding;", "mTypeList", "", "Lcom/larus/bmhome/view/actionbar/gaokao/model/GaokaoType;", "mProvinceList", "Lcom/larus/bmhome/view/actionbar/gaokao/model/GaokaoProvince;", "mPostGradPreferenceList", "", "mProvinceAdapter", "Lcom/larus/bmhome/view/actionbar/gaokao/adapter/GaokaoProvinceAdapter;", "mSingleSelectAdapter", "Lcom/larus/bmhome/view/actionbar/gaokao/adapter/GaokaoPreferenceAdapter;", "mMultiSelectAdapter", "mPostGradPreferenceAdapter", "mIsReadyForRank", "", "mIsValid", "mCurrentRankJob", "Lkotlinx/coroutines/Job;", "isFinishing", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "startSlideInBottom", "initView", "refreshView", "provinceKey", "provinceName", "initViewClickListener", "getTextToSend", "clearInputFocus", "getSelectedSubjectString", "getSelectedPreferencesString", "calculator", "Lcom/larus/bmhome/view/actionbar/gaokao/GaokaoRankCalculator;", "tryCalculateRank", "getSubjectForRank", "singleSelectSubject", "setupDialogWindow", "mHasInitImeInsetsListener", "initImeInsetsListener", "updatePreferenceScrollMaxHeight", com.alipay.sdk.m.l.c.f25505j, "isReadyForRank", "isScoreValid", "scoreStr", "showToast", "isGaokaoScoreProvided", ProfileEditRelaxPage.METHOD_HIDE_KEYBOARD, "scrollToBottom", "scrollView", "Landroid/widget/ScrollView;", "getGaokaoType", "gaokaoProvinceKey", "getScreenHeight", "", "getStringByResId", "resId", "navBarHeight", "getNavBarHeight", "()I", "navBarHeight$delegate", "Lkotlin/Lazy;", "getNavigationBarHeight", "trimScore", com.bytedance.android.ec.core.event.a.KEY_SCORE, "isProvinceRankDisabled", "finishDialog", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class GaokaoPreferenceDialog extends Fragment implements by7.e {

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ int f316735s = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public LarusDialogGaokaoPreferenceBinding f316736d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<GaokaoType> f316737e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<GaokaoProvince> f316738f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public List<String> f316739g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public GaokaoProvinceAdapter f316740h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public GaokaoPreferenceAdapter f316741i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public GaokaoPreferenceAdapter f316742j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public GaokaoPreferenceAdapter f316743k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f316744l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public boolean f316745m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public Job f316746n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f316747o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final GaokaoRankCalculator f316748p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f316749q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f316750r;

    public static final class a {
    }

    static {
    }

    public final void T90() {
        this.f316747o = true;
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L6;
        r100.finish();
        return;
    }

    @Override // by7.e, by7.d
    public final void fillTrackParams(TrackParams r100) {
    }

    public final void S90() {
        LarusDialogGaokaoPreferenceBinding r100 = this.f316736d;
        EditText r101 = null;
        if (r100 == null) goto L5;
        EditText r102 = r100.f310850r;
    L6:
        if (r100 == null) goto L8;
        r101 = r100.f310849q;
    L8:
        boolean r103 = false;
        if (r102 != null) goto L11;
    L13:
        boolean r104 = false;
    L14:
        if (r104 == true) goto L21;
        if (r101 != null) goto L17;
    L19:
        if (r103 == true) goto L21;
        return;
    L17:
        if (r101.hasFocus() != true) goto L19;
        r103 = true;
    L21:
        hideKeyboard();
        if (r102 == null) goto L24;
        r102.clearFocus();
    L24:
        if (r101 == null) goto L27;
        r101.clearFocus();
        return;
    L27:
        return;
    L11:
        if (r102.hasFocus() != true) goto L13;
        r104 = true;
        goto L14
    L5:
        r102 = null;
        goto L6
    }

    public final int V90() {
        return ((Number) this.f316750r.getValue()).intValue();
    }

    public final int W90() {
        Resources r100 = AppHost.f326268a.getApplication().getResources();
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics()).heightPixels;
    }

    public final boolean Y90() {
        GaokaoProvinceAdapter r100 = this.f316740h;
        if (r100 == null) goto L7;
        GaokaoProvince r101 = r100.f316771g;
        if (r101 == null) goto L7;
        String r102 = r101.getDisableRank();
    L9:
        return Intrinsics.areEqual(r102, "1");
    L7:
        r102 = null;
        goto L9
    }

    public final boolean Z90() {
        LarusDialogGaokaoPreferenceBinding r100 = this.f316736d;
        if (r100 == null) goto L9;
        RecyclerView r101 = r100.f310851s;
        if (r101 == null) goto L9;
        if (r101.getVisibility() != 0) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L19;
        GaokaoPreferenceAdapter r103 = this.f316741i;
        if (r103 != null) goto L14;
    L16:
        boolean r104 = false;
    L17:
        if (r104 == true) goto L19;
        return false;
    L14:
        if (((ArrayList) r103.y2()).size() != 1) goto L16;
        r104 = true;
    L19:
        LarusDialogGaokaoPreferenceBinding r105 = this.f316736d;
        if (r105 == null) goto L26;
        RecyclerView r106 = r105.f310834b;
        if (r106 == null) goto L26;
        if (r106.getVisibility() != 0) goto L26;
        boolean r107 = true;
    L27:
        if (r107 == false) goto L38;
        GaokaoPreferenceAdapter r108 = this.f316742j;
        Integer r109 = null;
        if (r108 == null) goto L31;
        Integer r110 = Integer.valueOf(((ArrayList) r108.y2()).size());
    L32:
        GaokaoPreferenceAdapter r111 = this.f316742j;
        if (r111 == null) goto L36;
        r109 = Integer.valueOf(r111.f316756b);
    L36:
        if (Intrinsics.areEqual(r110, r109) == true) goto L38;
        return false;
    L31:
        r110 = null;
    L38:
        LarusDialogGaokaoPreferenceBinding r112 = this.f316736d;
        if (r112 == null) goto L53;
        EditText r113 = r112.f310850r;
        if (r113 == null) goto L53;
        Editable r114 = r113.getText();
        if (r114 == null) goto L53;
        if (r114.length() != 0) goto L47;
        boolean r115 = true;
    L48:
        if (r115 == false) goto L51;
        return false;
    L51:
        if (aa0(this, r114.toString()) == true) goto L53;
        return false;
    L47:
        r115 = false;
    L53:
        return true;
    L26:
        r107 = false;
    L9:
        r102 = false;
        goto L10
    }

    public final void da0() {
        if (this.f316747o == false) goto L6;
        return;
    L6:
        if (Y90() == false) goto L9;
        return;
    L9:
        if (Z90() == true) goto L11;
        return;
    L11:
        Context r100 = getContext();
        if (r100 == null) goto L24;
        LarusDialogGaokaoPreferenceBinding r101 = this.f316736d;
        if (r101 == null) goto L18;
        EditText r102 = r101.f310850r;
        if (r102 == null) goto L18;
        Editable r103 = r102.getText();
    L19:
        String r104 = String.valueOf(r103);
        Job r105 = this.f316746n;
        if (r105 == null) goto L22;
        Job.DefaultImpls.cancel$default(r105, null, 1, null);
    L22:
        this.f316746n = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), Dispatchers.getIO(), null, new GaokaoPreferenceDialog$tryCalculateRank$1$1(this, r100, r104, null), 2, null);
        return;
    L18:
        r103 = null;
        goto L19
    }

    public final void ea0() {
        if (this.f316747o == false) goto L5;
        return;
    L5:
        boolean r100 = Z90();
        boolean r101 = Y90();
        boolean r102 = false;
        if (r100 == false) goto L23;
        LarusDialogGaokaoPreferenceBinding r103 = this.f316736d;
        if (r103 == null) goto L12;
        EditText r104 = r103.f310850r;
        if (r104 == null) goto L12;
        Editable r105 = r104.getText();
    L13:
        if (r105 != null) goto L15;
    L18:
        boolean r106 = true;
    L20:
        if ((!r106) == false) goto L23;
        r102 = true;
        goto L23
    L15:
        if (StringsKt.isBlank(r105) == true) goto L18;
        r106 = false;
    L12:
        r105 = null;
    L23:
        if (r100 == this.f316744l) goto L37;
        this.f316744l = r100;
        if (r100 == true) goto L37;
        Job r107 = this.f316746n;
        if (r107 == null) goto L29;
        Job.DefaultImpls.cancel$default(r107, null, 1, null);
    L29:
        this.f316746n = null;
        if (r101 == true) goto L37;
        LarusDialogGaokaoPreferenceBinding r108 = this.f316736d;
        if (r108 == null) goto L37;
        EditText r109 = r108.f310849q;
        if (r109 == null) goto L37;
        r109.setText(null);
    L37:
        if (r102 == this.f316745m) goto L48;
        this.f316745m = r102;
        if (r102 == false) goto L41;
        int r110 = v19.c.b(R.attr.larus_bg_gaokao_confirm_button_ready, getContext(), R.drawable.larus_bg_gaokao_confirm_button_ready);
    L42:
        LarusDialogGaokaoPreferenceBinding r111 = this.f316736d;
        if (r111 == null) goto L49;
        TextView r112 = r111.f310839g;
        if (r112 == null) goto L50;
        r112.setBackgroundResource(r110);
        return;
    L50:
        return;
    L49:
        return;
    L41:
        r110 = v19.c.b(R.attr.larus_bg_gaokao_confirm_button_not_ready, getContext(), R.drawable.larus_bg_gaokao_confirm_button_not_ready);
        goto L42
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        Job r100 = this.f316746n;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f316746n = null;
        super.onDestroyView();
    }

    public GaokaoPreferenceDialog() {
        this.f316748p = new GaokaoRankCalculator();
        this.f316750r = LazyKt.lazy(new j(this));
    }

    public final void hideKeyboard() {
        FragmentActivity r100 = getActivity();
        if (r100 == null) goto L17;
        View r101 = r100.getCurrentFocus();
        if (r101 == null) goto L19;
        FragmentActivity r102 = getActivity();
        InputMethodManager r103 = null;
        if (r102 == null) goto L10;
        Object r104 = r102.getSystemService("input_method");
    L12:
        if ((r104 instanceof InputMethodManager) == false) goto L14;
        r103 = (InputMethodManager) r104;
    L14:
        if (r103 == null) goto L18;
        r103.hideSoftInputFromWindow(r101.getWindowToken(), 0);
        return;
    L18:
        return;
    L10:
        r104 = null;
        goto L12
    L19:
        return;
    }

    @Override // by7.e
    public final by7.e parentTrackNode() {
        return by7.i.c(this);
    }

    @Override // by7.e
    public final by7.e referrerTrackNode() {
        return by7.e.a.a(this);
    }

    public static String X90(int r100) {
        return AppHost.f326268a.getApplication().getString(r100);
    }

    public static String ca0(String r100) {
        if (r100 != null) goto L6;
        return null;
    L6:
        if (r100.length() > 1) goto L8;
        return r100;
    L8:
        if (StringsKt.startsWith$default(r100, "0", false, 2, null) == true) goto L10;
        return r100;
    L10:
        return ca0(StringsKt.removeRange(r100, 0, 1).toString());
    }

    public final GaokaoType U90(String r110) {
        List<GaokaoProvince> r100 = this.f316738f;
        if (r100 == null) goto L27;
        Iterator<T> r101 = r100.iterator();
    L5:
        Object r102 = null;
        if (r101.hasNext() == false) goto L10;
        Object r103 = r101.next();
        if (Intrinsics.areEqual(((GaokaoProvince) r103).getKey(), r110) == false) goto L5;
    L11:
        GaokaoProvince r104 = (GaokaoProvince) r103;
        if (r104 == null) goto L27;
        List<GaokaoType> r111 = this.f316737e;
        if (r111 == null) goto L25;
        Iterator<T> r112 = r111.iterator();
    L18:
        if (r112.hasNext() == false) goto L22;
        Object r105 = r112.next();
        if (Intrinsics.areEqual(((GaokaoType) r105).getCode(), r104.getTypeCode()) == false) goto L18;
        r102 = r105;
    L22:
        GaokaoType r106 = (GaokaoType) r102;
        if (r106 == null) goto L25;
        return r106;
    L25:
        return new GaokaoType(null, null, null, null, null, null, 63, null);
    L10:
        r103 = null;
    L27:
        return new GaokaoType(null, null, null, null, null, null, 63, null);
    }

    public static boolean aa0(GaokaoPreferenceDialog r110, String r111) {
        if (r111 != null) goto L5;
        r110.getClass();
        return false;
    L5:
        GaokaoProvinceAdapter r100 = r110.f316740h;
        if (r100 == null) goto L19;
        GaokaoProvince r101 = r100.f316771g;
        if (r101 == null) goto L19;
        String r102 = r101.getMaxScore();
        if (r102 == null) goto L19;
        int r112 = CastIntegerProtector.parseInt(r111);     // Catch: NumberFormatException -> L21
        if (r112 > CastIntegerProtector.parseInt(r102)) goto L15;
        if (r112 < 0) goto L15;
        boolean r113 = true;
    L16:
        if (r113 == true) goto L25;
        String r103 = X90(R.string.larus_volunteer_pad_score_toast);
        t19.s r104 = t19.s.f544207a;
        Context r105 = r110.getContext();
        StringCompanionObject r114 = StringCompanionObject.INSTANCE;
        t19.s.j(r104, r105, String.format(r103, Arrays.copyOf(new Object[]{r102}, 1)), null, false, 28);
    L25:
        return r113;
    L15:
        r113 = false;
    L19:
        return true;
    }

    public final void ba0(String r110, String r111) {
        if (r110 != null) goto L4;
        return;
    L4:
        if (r111 != null) goto L6;
        return;
    L6:
        List<GaokaoProvince> r100 = this.f316738f;
        if (r100 == null) goto L18;
        Iterator<T> r101 = r100.iterator();
    L10:
        if (r101.hasNext() == false) goto L14;
        Object r102 = r101.next();
        if (Intrinsics.areEqual(((GaokaoProvince) r102).getKey(), r110) == false) goto L10;
    L15:
        GaokaoProvince r103 = (GaokaoProvince) r102;
        if (r103 == null) goto L18;
        String r104 = r103.getDisableRank();
    L19:
        boolean r105 = true;
        if (Intrinsics.areEqual(r104, "1") == false) goto L26;
        LarusDialogGaokaoPreferenceBinding r106 = this.f316736d;
        if (r106 == null) goto L31;
        EditText r107 = r106.f310849q;
        if (r107 == null) goto L31;
        r107.setEnabled(true);
        r107.setHint(X90(R.string.larus_gaokao_rank_hint));
    L31:
        GaokaoType r112 = U90(r110);
        LarusDialogGaokaoPreferenceBinding r108 = this.f316736d;
        if (r108 == null) goto L36;
        TextView r109 = r108.f310842j;
        if (r109 == null) goto L36;
        r109.setText(r111);
    L36:
        LarusDialogGaokaoPreferenceBinding r113 = this.f316736d;
        if (r113 == null) goto L57;
        TextView r114 = r113.f310852t;
        if (r114 == null) goto L57;
        String r115 = r112.getCode();
        if (r115 != null) goto L43;
    L56:
        r114.setVisibility(0);
        r114.setText(X90(R.string.larus_volunteer_pad_subject_4));
        goto L57
    L43:
        switch(r115.hashCode()) {
            case 49: goto L53;
            case 50: goto L49;
            case 51: goto L46;
            default: goto L56;
        };
    L46:
        if (r115.equals("3") == false) goto L56;
    L51:
        r114.setVisibility(8);
        goto L57
    L49:
        if (r115.equals("2") == true) goto L51;
    L53:
        if (r115.equals("1") == false) goto L56;
        r114.setVisibility(0);
        r114.setText(X90(R.string.larus_volunteer_pad_subject_1));
    L57:
        LarusDialogGaokaoPreferenceBinding r116 = this.f316736d;
        if (r116 == null) goto L78;
        TextView r117 = r116.f310835c;
        if (r117 == null) goto L78;
        String r118 = r112.getCode();
        if (r118 != null) goto L64;
    L77:
        r117.setVisibility(8);
        goto L78
    L64:
        switch(r118.hashCode()) {
            case 49: goto L74;
            case 50: goto L70;
            case 51: goto L67;
            default: goto L77;
        };
    L67:
        if (r118.equals("3") == false) goto L77;
    L72:
        r117.setVisibility(0);
        StringCompanionObject r119 = StringCompanionObject.INSTANCE;
        r117.setText(String.format(X90(R.string.larus_volunteer_pad_subject_3), Arrays.copyOf(new Object[]{r112.getName()}, 1)));
        goto L78
    L70:
        if (r118.equals("2") == true) goto L72;
    L74:
        if (r118.equals("1") == false) goto L77;
        r117.setVisibility(0);
        r117.setText(X90(R.string.larus_volunteer_pad_subject_2));
    L78:
        LarusDialogGaokaoPreferenceBinding r120 = this.f316736d;
        if (r120 == null) goto L113;
        RecyclerView r121 = r120.f310851s;
        if (r121 == null) goto L113;
        String r122 = r112.getCode();
        if (r122 != null) goto L85;
    L99:
        List<String> r123 = r112.getSelectedMajor();
        if (r123 == null) goto L102;
        List r124 = CollectionsKt.filterNotNull(r123);
    L103:
        List r125 = r124;
        if (r125 != null) goto L106;
    L109:
        boolean r126 = true;
    L110:
        if (r126 == false) goto L112;
        r121.setVisibility(8);
        this.f316741i = null;
        goto L113
    L112:
        r121.setVisibility(0);
        GaokaoPreferenceAdapter r127 = new GaokaoPreferenceAdapter(r124, 1, new e(this));
        this.f316741i = r127;
        r121.setAdapter(r127);
        goto L113
    L106:
        if (r125.isEmpty() == true) goto L109;
        r126 = false;
    L102:
        r124 = null;
        goto L103
    L85:
        switch(r122.hashCode()) {
            case 49: goto L94;
            case 50: goto L91;
            case 51: goto L88;
            default: goto L99;
        };
    L88:
        if (r122.equals("3") == true) goto L102;
    L91:
        if (r122.equals("2") == true) goto L102;
    L94:
        if (r122.equals("1") == false) goto L99;
        List<String> r128 = r112.getSelectedMajor();
        if (r128 == null) goto L102;
        r124 = CollectionsKt.filterNotNull(r128);
    L113:
        LarusDialogGaokaoPreferenceBinding r129 = this.f316736d;
        if (r129 == null) goto L157;
        RecyclerView r130 = r129.f310834b;
        if (r130 == null) goto L158;
        String r131 = r112.getCode();
        int r132 = 3;
        if (r131 != null) goto L120;
        List r133 = null;
    L138:
        List r134 = r133;
        if (r134 != null) goto L141;
    L144:
        if (r105 == false) goto L146;
        r130.setVisibility(8);
        this.f316742j = null;
        return;
    L146:
        r130.setVisibility(0);
        GaokaoPreferenceAdapter r135 = new GaokaoPreferenceAdapter(r133, r132, new f(this));
        this.f316742j = r135;
        r130.setAdapter(r135);
        return;
    L141:
        if (r134.isEmpty() == true) goto L144;
        r105 = false;
        goto L144
    L120:
        switch(r131.hashCode()) {
            case 49: goto L132;
            case 50: goto L126;
            case 51: goto L123;
            default: goto L153;
        };
    L153:
        r133 = null;
        goto L138
    L123:
        if (r131.equals("3") == false) goto L154;
    L128:
        List<String> r136 = r112.getSelectedMajor();
        if (r136 == null) goto L151;
        r133 = CollectionsKt.filterNotNull(r136);
        goto L138
    L151:
        r133 = null;
        goto L138
    L154:
        r133 = null;
        goto L138
    L126:
        if (r131.equals("2") == true) goto L128;
        r133 = null;
        goto L138
    L132:
        if (r131.equals("1") == false) goto L156;
        List<String> r137 = r112.getReselectedMajor();
        r132 = 2;
        if (r137 == null) goto L152;
        r133 = CollectionsKt.filterNotNull(r137);
        goto L138
    L152:
        r133 = null;
        goto L138
    L156:
        r133 = null;
        goto L138
    L158:
        return;
    L157:
        return;
    L26:
        LarusDialogGaokaoPreferenceBinding r138 = this.f316736d;
        if (r138 == null) goto L31;
        EditText r139 = r138.f310849q;
        if (r139 == null) goto L31;
        r139.setEnabled(false);
        r139.setHint(X90(R.string.larus_volunteer_pad_ranking_hint));
        goto L31
    L14:
        r102 = null;
    L18:
        r104 = null;
        goto L19
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        LarusDialogGaokaoPreferenceBinding r102 = this.f316736d;
        if (r102 == null) goto L7;
        AppCompatImageView r103 = r102.f310838f;
        if (r103 == null) goto L7;
        e1.d(r103, new k(this));
    L7:
        LarusDialogGaokaoPreferenceBinding r104 = this.f316736d;
        if (r104 == null) goto L12;
        ConstraintLayout r105 = r104.f310833a;
        if (r105 == null) goto L12;
        e1.d(r105, new m(this));
    L12:
        LarusDialogGaokaoPreferenceBinding r106 = this.f316736d;
        if (r106 == null) goto L17;
        AppCompatImageView r107 = r106.f310845m;
        if (r107 == null) goto L17;
        e1.d(r107, new n(this));
    L17:
        LarusDialogGaokaoPreferenceBinding r108 = this.f316736d;
        if (r108 == null) goto L22;
        View r109 = r108.f310846n;
        if (r109 == null) goto L22;
        e1.d(r109, new o(this));
    L22:
        LarusDialogGaokaoPreferenceBinding r110 = this.f316736d;
        if (r110 == null) goto L27;
        ConstraintLayout r111 = r110.f310841i;
        if (r111 == null) goto L27;
        e1.d(r111, new p(this));
    L27:
        LarusDialogGaokaoPreferenceBinding r112 = this.f316736d;
        if (r112 == null) goto L32;
        EditText r113 = r112.f310850r;
        if (r113 == null) goto L32;
        r113.setOnTouchListener(new q(this));
    L32:
        LarusDialogGaokaoPreferenceBinding r114 = this.f316736d;
        if (r114 == null) goto L37;
        EditText r115 = r114.f310849q;
        if (r115 == null) goto L37;
        r115.setOnTouchListener(new r(this));
    L37:
        LarusDialogGaokaoPreferenceBinding r116 = this.f316736d;
        if (r116 == null) goto L42;
        EditText r117 = r116.f310850r;
        if (r117 == null) goto L42;
        r117.addTextChangedListener(new s(this));
    L42:
        LarusDialogGaokaoPreferenceBinding r118 = this.f316736d;
        if (r118 == null) goto L47;
        EditText r119 = r118.f310850r;
        if (r119 == null) goto L47;
        r119.setOnFocusChangeListener(new b(this));
    L47:
        LarusDialogGaokaoPreferenceBinding r120 = this.f316736d;
        if (r120 == null) goto L52;
        TextView r121 = r120.f310839g;
        if (r121 == null) goto L52;
        e1.d(r121, new c(this));
    L52:
        LarusDialogGaokaoPreferenceBinding r122 = this.f316736d;
        if (r122 == null) goto L57;
        LinearLayout r123 = r122.f310853u;
        if (r123 == null) goto L57;
        e1.d(r123, new d(this));
    L57:
        LarusDialogGaokaoPreferenceBinding r124 = this.f316736d;
        if (r124 == null) goto L62;
        LinearLayout r125 = r124.f310844l;
        if (r125 == null) goto L62;
        e1.d(r125, new l(this));
    L62:
        FragmentActivity r126 = requireActivity();
        if (r126 == null) goto L78;
        Window r127 = r126.getWindow();
        if (r127 == null) goto L78;
        WindowManager.LayoutParams r128 = r127.getAttributes();
        r127.setLayout(-1, -1);
        r127.setBackgroundDrawable(new ColorDrawable(0));
        r127.clearFlags(2);
        View r129 = r127.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L72;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r130 = ThreadMethodProxy.currentThread();
        if (r130 == com.larus.home.impl.utils.c.f346341a) goto L72;
        com.larus.home.impl.utils.c.a(r130, "getDecorView");
    L72:
        r129.setPadding(0, 0, 0, 0);
        int r131 = Build.VERSION.SDK_INT;
        if (r131 < 29) goto L75;
        r127.setNavigationBarContrastEnforced(false);
    L75:
        r127.addFlags(Integer.MIN_VALUE);
        if (r131 <= 28) goto L78;
        r128.layoutInDisplayCutoutMode = 1;
    L78:
        LarusDialogGaokaoPreferenceBinding r132 = this.f316736d;
        LinearLayout r133 = null;
        if (r132 == null) goto L87;
        MaxHeightScrollView r134 = r132.f310843k;
        if (r134 == null) goto L87;
        int r135 = RangesKt.coerceAtLeast(((W90() - V90()) - getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_56, null, R.dimen.larus_dp_56))) - getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_112, null, R.dimen.larus_dp_112)), 0);
        if (r135 > getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_586, null, R.dimen.larus_dp_586))) goto L87;
        r134.setMaxHeight(r135);
    L87:
        LarusDialogGaokaoPreferenceBinding r136 = this.f316736d;
        if (r136 == null) goto L90;
        r133 = r136.f310853u;
    L90:
        if (r133 == null) goto L94;
        Animation r137 = AnimationUtils.loadAnimation(getActivity(), R.anim.larus_slide_in_bottom_300);
        r137.setAnimationListener(new t(r133));
        r133.startAnimation(r137);
        return;
    }

    /* JADX WARN: Type inference failed for: r10v10, types: [com.larus.bmhome.view.actionbar.gaokao.a] */
    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r210, ViewGroup r310, Bundle r311) {
        Intrinsics.checkNotNullParameter(r210, "inflater");
        View r100 = r210.inflate(R.layout.larus_dialog_gaokao_preference, r310, false);
        int r101 = R.id.gaokao_multi_select_recycler;
        RecyclerView r102 = (RecyclerView) ViewBindings.findChildViewById(r100, R.id.gaokao_multi_select_recycler);
        if (r102 == null) goto L159;
        r101 = R.id.gaokao_multi_select_title;
        TextView r103 = (TextView) ViewBindings.findChildViewById(r100, R.id.gaokao_multi_select_title);
        if (r103 == null) goto L159;
        r101 = R.id.gaokao_post_grad_preference_recycler;
        RecyclerView r104 = (RecyclerView) ViewBindings.findChildViewById(r100, R.id.gaokao_post_grad_preference_recycler);
        if (r104 == null) goto L159;
        r101 = R.id.gaokao_post_grad_preference_title;
        TextView r110 = (TextView) ViewBindings.findChildViewById(r100, R.id.gaokao_post_grad_preference_title);
        if (r110 == null) goto L159;
        r101 = R.id.gaokao_preference_close;
        AppCompatImageView r111 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.gaokao_preference_close);
        if (r111 == null) goto L159;
        r101 = R.id.gaokao_preference_confirm_button;
        TextView r112 = (TextView) ViewBindings.findChildViewById(r100, R.id.gaokao_preference_confirm_button);
        if (r112 == null) goto L159;
        r101 = R.id.gaokao_preference_container;
        LinearLayout r113 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.gaokao_preference_container);
        if (r113 == null) goto L159;
        r101 = R.id.gaokao_preference_province;
        ConstraintLayout r114 = (ConstraintLayout) ViewBindings.findChildViewById(r100, R.id.gaokao_preference_province);
        if (r114 == null) goto L159;
        r101 = R.id.gaokao_preference_province_text;
        TextView r115 = (TextView) ViewBindings.findChildViewById(r100, R.id.gaokao_preference_province_text);
        if (r115 == null) goto L159;
        r101 = R.id.gaokao_preference_right_arrow;
        if (((AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.gaokao_preference_right_arrow)) == null) goto L159;
        r101 = R.id.gaokao_preference_scroll;
        MaxHeightScrollView r116 = (MaxHeightScrollView) ViewBindings.findChildViewById(r100, R.id.gaokao_preference_scroll);
        if (r116 == null) goto L159;
        r101 = R.id.gaokao_preference_scroll_body;
        LinearLayout r117 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.gaokao_preference_scroll_body);
        if (r117 == null) goto L159;
        r101 = R.id.gaokao_province_close;
        AppCompatImageView r118 = (AppCompatImageView) ViewBindings.findChildViewById(r100, R.id.gaokao_province_close);
        if (r118 == null) goto L159;
        r101 = R.id.gaokao_province_container;
        if (((LinearLayout) ViewBindings.findChildViewById(r100, R.id.gaokao_province_container)) == null) goto L159;
        r101 = R.id.gaokao_province_cover;
        View r119 = ViewBindings.findChildViewById(r100, R.id.gaokao_province_cover);
        if (r119 == null) goto L159;
        r101 = R.id.gaokao_province_recycler;
        RecyclerView r211 = (RecyclerView) ViewBindings.findChildViewById(r100, R.id.gaokao_province_recycler);
        if (r211 == null) goto L159;
        r101 = R.id.gaokao_province_root_container;
        LinearLayout r212 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.gaokao_province_root_container);
        if (r212 == null) goto L159;
        r101 = R.id.gaokao_rank_input;
        EditText r213 = (EditText) ViewBindings.findChildViewById(r100, R.id.gaokao_rank_input);
        if (r213 == null) goto L159;
        r101 = R.id.gaokao_score_input;
        EditText r214 = (EditText) ViewBindings.findChildViewById(r100, R.id.gaokao_score_input);
        if (r214 == null) goto L159;
        r101 = R.id.gaokao_single_select_recycler;
        RecyclerView r215 = (RecyclerView) ViewBindings.findChildViewById(r100, R.id.gaokao_single_select_recycler);
        if (r215 == null) goto L159;
        r101 = R.id.gaokao_single_select_title;
        TextView r216 = (TextView) ViewBindings.findChildViewById(r100, R.id.gaokao_single_select_title);
        if (r216 == null) goto L159;
        r101 = R.id.root_container;
        LinearLayout r217 = (LinearLayout) ViewBindings.findChildViewById(r100, R.id.root_container);
        if (r217 == null) goto L159;
        this.f316736d = new LarusDialogGaokaoPreferenceBinding((ConstraintLayout) r100, r102, r103, r104, r110, r111, r112, r113, r114, r115, r116, r117, r118, r119, r211, r212, r213, r214, r215, r216, r217);
        Bundle r105 = getArguments();
        if (r105 == null) goto L49;
        String r106 = r105.getString("current_province_key");
    L50:
        Bundle r107 = getArguments();
        if (r107 == null) goto L53;
        String r108 = r107.getString("current_province_name");
    L54:
        boolean r109 = true;
        if (r106 != null) goto L57;
    L60:
        boolean r120 = true;
    L160:
        Bundle r121 = getArguments();     // Catch: Throwable -> L152
        if (r121 == null) goto L64;
        ArrayList r122 = r121.getParcelableArrayList("type_list");     // Catch: Throwable -> L152
    L65:
        this.f316737e = r122;     // Catch: Throwable -> L152
        Bundle r123 = getArguments();     // Catch: Throwable -> L152
        if (r123 == null) goto L68;
        ArrayList r124 = r123.getParcelableArrayList("province_list");     // Catch: Throwable -> L152
    L69:
        this.f316738f = r124;     // Catch: Throwable -> L152
        Bundle r125 = getArguments();     // Catch: Throwable -> L152
        if (r125 == null) goto L72;
        ArrayList<String> r126 = r125.getStringArrayList("post_grad_preference_list");     // Catch: Throwable -> L152
    L73:
        this.f316739g = r126;     // Catch: Throwable -> L152
        if (r120 == false) goto L86;
        List<GaokaoProvince> r127 = this.f316738f;
        if (r127 == null) goto L78;
        GaokaoProvince r128 = (GaokaoProvince) CollectionsKt.firstOrNull(r127);
    L79:
        if (r128 == null) goto L81;
        String r129 = r128.getKey();
    L82:
        if (r128 == null) goto L84;
        String r130 = r128.getProvince();
    L85:
        String r218 = r129;
        r108 = r130;
        r106 = r218;
        goto L86
    L84:
        r130 = null;
        goto L85
    L81:
        r129 = null;
        goto L82
    L78:
        r128 = null;
    L86:
        LarusDialogGaokaoPreferenceBinding r131 = this.f316736d;
        if (r131 == null) goto L96;
        LinearLayout r132 = r131.f310840h;
        if (r132 == null) goto L96;
        ViewGroup.LayoutParams r133 = r132.getLayoutParams();
        if ((r133 instanceof LinearLayout.LayoutParams) == false) goto L93;
        LinearLayout.LayoutParams r134 = (LinearLayout.LayoutParams) r133;
    L94:
        if (r134 == null) goto L96;
        r134.bottomMargin = V90();
        goto L96
    L93:
        r134 = null;
    L96:
        LarusDialogGaokaoPreferenceBinding r135 = this.f316736d;
        if (r135 == null) goto L109;
        RecyclerView r136 = r135.f310847o;
        if (r136 == null) goto L109;
        r136.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        List<GaokaoProvince> r137 = this.f316738f;
        if (r137 != null) goto L103;
        T90();
        goto L109
    L103:
        GaokaoProvinceAdapter r138 = new GaokaoProvinceAdapter(r137, r106, r120, new com.larus.bmhome.view.actionbar.gaokao.a(this));
        this.f316740h = r138;
        r136.setAdapter(r138);
        ViewGroup.LayoutParams r139 = r136.getLayoutParams();
        if ((r139 instanceof LinearLayout.LayoutParams) == false) goto L106;
        LinearLayout.LayoutParams r140 = (LinearLayout.LayoutParams) r139;
    L107:
        if (r140 == null) goto L109;
        r140.bottomMargin = V90();
        goto L109
    L106:
        r140 = null;
    L109:
        LarusDialogGaokaoPreferenceBinding r141 = this.f316736d;
        if (r141 == null) goto L114;
        RecyclerView r142 = r141.f310851s;
        if (r142 == null) goto L114;
        r142.setLayoutManager(new GridLayoutManager(getContext(), 2));
        r142.addItemDecoration(new GaokaoPreferenceItemDecoration(2, getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_8, null, R.dimen.larus_dp_8))));
    L114:
        LarusDialogGaokaoPreferenceBinding r143 = this.f316736d;
        if (r143 == null) goto L119;
        RecyclerView r144 = r143.f310834b;
        if (r144 == null) goto L119;
        r144.setLayoutManager(new GridLayoutManager(getContext(), 3));
        r144.addItemDecoration(new GaokaoPreferenceItemDecoration(3, getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_8, null, R.dimen.larus_dp_8))));
    L119:
        List<String> r145 = this.f316739g;
        if (r145 != null) goto L122;
    L125:
        if (r109 == false) goto L136;
        LarusDialogGaokaoPreferenceBinding r146 = this.f316736d;
        if (r146 == null) goto L131;
        TextView r147 = r146.f310837e;
        if (r147 == null) goto L131;
        r147.setVisibility(8);
    L131:
        LarusDialogGaokaoPreferenceBinding r148 = this.f316736d;
        if (r148 == null) goto L151;
        RecyclerView r149 = r148.f310836d;
        if (r149 == null) goto L151;
        r149.setVisibility(8);
    L151:
        ba0(r106, r108);
    L154:
        LarusDialogGaokaoPreferenceBinding r150 = this.f316736d;
        if (r150 != null) goto L157;
        return null;
    L157:
        return r150.f310833a;
    L136:
        LarusDialogGaokaoPreferenceBinding r151 = this.f316736d;
        if (r151 == null) goto L141;
        TextView r152 = r151.f310837e;
        if (r152 == null) goto L141;
        r152.setVisibility(0);
    L141:
        LarusDialogGaokaoPreferenceBinding r153 = this.f316736d;
        if (r153 == null) goto L146;
        RecyclerView r154 = r153.f310836d;
        if (r154 == null) goto L146;
        r154.setVisibility(0);
    L146:
        LarusDialogGaokaoPreferenceBinding r155 = this.f316736d;
        if (r155 == null) goto L151;
        RecyclerView r156 = r155.f310836d;
        if (r156 == null) goto L151;
        r156.setLayoutManager(new GridLayoutManager(getContext(), 3));
        r156.addItemDecoration(new GaokaoPreferenceItemDecoration(3, getResources().getDimensionPixelSize(v19.c.b(R.attr.larus_dp_8, null, R.dimen.larus_dp_8))));
        GaokaoPreferenceAdapter r157 = new GaokaoPreferenceAdapter(r145, r145.size(), null);
        this.f316743k = r157;
        r156.setAdapter(r157);
        goto L151
    L122:
        if (r145.isEmpty() == true) goto L125;
        r109 = false;
        goto L125
    L72:
        r126 = null;
        goto L73
    L68:
        r124 = null;
        goto L69
    L64:
        r122 = null;
    L152:
        th = move-exception;
        FLogger.f375446a.e("GaokaoPreferenceDialog", "wrong typeList or provinceList format", th);
        T90();
        goto L154
    L57:
        if (StringsKt.isBlank(r106) == true) goto L60;
        r120 = false;
        goto L160
    L53:
        r108 = null;
        goto L54
    L49:
        r106 = null;
    L159:
        throw new NullPointerException("Missing required view with ID: ".concat(r100.getResources().getResourceName(r101)));
    }
}
