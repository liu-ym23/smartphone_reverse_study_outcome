package com.ss.android.ugc.aweme.search.filter;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import com.bytedance.lighten.loader.SmartImageView;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import com.ss.android.ugc.aweme.discover.model.commodity.select.BaseSelectItemView;
import com.ss.android.ugc.aweme.discover.model.commodity.select.IconStruct;
import com.ss.android.ugc.aweme.discover.model.commodity.select.RenderItem;
import com.ss.android.ugc.aweme.discover.model.commodity.select.SelectItemStatus;
import com.ss.android.ugc.aweme.search.filter.utils.ECSearchSelectStatusHelper;
import com.ss.android.ugc.aweme.search.utils.extensions.DimenExtensionsKt;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import df6.q;
import df6.u;
import ef6.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u00012\u00020\u0002¨\u0006\u0003"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/ECSearchBaseFilterViewHolder;", "Lcom/ss/android/ugc/aweme/discover/model/commodity/select/BaseSelectItemView;", "Landroid/view/View$OnClickListener;", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class ECSearchBaseFilterViewHolder extends BaseSelectItemView implements View.OnClickListener {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ECSearchFilterViewModel f452777e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f452778f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f452779g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Animator f452780h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public AnimatorSet f452781i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final View f452782j;

    public void n(ECSearchFilterViewModel r100, RenderItem r101) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "renderItem");
    }

    public void o() {
        this.f450505a = null;
        h(false);
        this.f450507c = 0;
        ((ArrayList) this.f450508d).clear();
        this.f452782j.setMinimumWidth(0);
        this.f452778f = false;
    }

    @Override // com.ss.android.ugc.aweme.discover.model.commodity.select.BaseSelectItemView
    public final void k() {
        RenderItem r100 = this.f450505a;
        String r101 = null;
        if (r100 == null) goto L5;
        List<RenderItem> r102 = r100.getChildrenComponent();
    L6:
        RenderItem r103 = this.f450505a;
        if (r103 == null) goto L9;
        r101 = r103.getStatusPath();
    L9:
        if (r102 != null) goto L15;
        ECSearchFilterViewModel r104 = this.f452777e;
        if (r104 == null) goto L21;
        ECSearchSelectStatusHelper r105 = r104.getSelectStatusHelper();
        if (r105 == null) goto L27;
        SelectItemStatus r106 = m();
        int r107 = ECSearchSelectStatusHelper.f452969i;
        r105.n(r101, r106, false);
        return;
    L27:
        return;
    L21:
        return;
    L15:
        Iterator<T> r108 = r102.iterator();
    L17:
        if (r108.hasNext() == false) goto L29;
        BaseSelectItemView r109 = ((RenderItem) r108.next()).getRenderView();
        if (r109 == null) goto L17;
        r109.k();
        goto L17
    L29:
        return;
    L5:
        r102 = null;
        goto L6
    }

    public SelectItemStatus m() {
        RenderItem r100 = this.f450505a;
        if (r100 != null) goto L6;
        return null;
    L6:
        if (this.f450506b == false) goto L13;
        ECSearchFilterViewModel r101 = this.f452777e;
        if (r101 == null) goto L14;
        ECSearchSelectStatusHelper r102 = r101.getSelectStatusHelper();
        if (r102 != null) goto L12;
        return null;
    L12:
        return r102.a(r100);
    L14:
        return null;
    L13:
        return null;
    }

    public ECSearchBaseFilterViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "itemView");
        this.f452782j = r100;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r100) {
        Animator r101 = this.f452780h;
        if (r101 == null) goto L15;
        if (Intrinsics.areEqual(ThreadMethodProxy.getLooperThread(Looper.getMainLooper()), ThreadMethodProxy.currentThread()) == true) goto L7;
    L9:
        boolean r102 = false;
    L10:
        if (r102 == false) goto L15;
        if (r101.isRunning() == false) goto L15;
        r101.end();
        goto L15
    L7:
        if (Looper.myLooper() == null) goto L9;
        r102 = true;
    L15:
        if (this.f452778f == false) goto L18;
        g();
        return;
    L18:
        if (this.f450506b == false) goto L20;
        i();
        return;
    L20:
        g();
    }

    public static void p(EditText r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setTextSafeDouble");
        if (r101 != null) goto L6;
        r100.setText("");     // Catch: Exception -> L11
        return;
    L6:
        double r102 = CastDoubleProtector.parseDouble(r101);     // Catch: Exception -> L11
        if ((r102 % ((double) 1)) != AudioStats.AUDIO_AMPLITUDE_NONE) goto L9;
        r100.setText(String.valueOf((long) r102));     // Catch: Exception -> L11
        return;
    L9:
        r100.setText(r101);     // Catch: Exception -> L11
        return;
    L11:
        r100.setText("");
    }

    public static void q(View r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$setVisible");
        if (r101 == false) goto L5;
        int r102 = 0;
    L6:
        r100.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public static void r(SmartImageView r100, IconStruct r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$updateImage");
        if (r101 == null) goto L5;
        String r102 = r101.getIcon();
    L7:
        if (r102 != null) goto L11;
        q(r100, false);
        return;
    L11:
        if (StringsKt.endsWith$default(r102, EffectConstants.GIF_FILE_SUFFIX, false, 2, null) == false) goto L13;
        u r103 = q.c(new a(CollectionsKt.arrayListOf(new String[]{r102})));
        r103.f468287m = Bitmap.Config.ARGB_8888;
        r103.f468278d = true;
        r103.f468294t = r100;
        r103.c();
    L14:
        v(r100, r101.getWidth(), r101.getHeight());
        q(r100, true);
        return;
    L13:
        u r104 = q.c(new a(CollectionsKt.arrayListOf(new String[]{r102})));
        r104.f468294t = r100;
        r104.c();
        goto L14
    L5:
        r102 = null;
        goto L7
    }

    public static void t(TextView r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "$this$updateText");
        if (r101 != null) goto L5;
    L8:
        boolean r102 = true;
    L9:
        if (r102 == false) goto L11;
        q(r100, false);
        return;
    L11:
        r100.setText(r101);
        q(r100, true);
        return;
    L5:
        if (StringsKt.isBlank(r101) == true) goto L8;
        r102 = false;
        goto L9
    }

    public void l(ECSearchFilterViewModel r100, RenderItem r101) {
        Intrinsics.checkNotNullParameter(r100, "viewModel");
        Intrinsics.checkNotNullParameter(r101, "renderItem");
        this.f452777e = r100;
        this.f450505a = r101;
        n(r100, r101);
        if (Intrinsics.areEqual(r101.getDisableSelected(), Boolean.FALSE) == false) goto L6;
        this.f452782j.setOnClickListener(this);
    L6:
        if (r101.getCurrentStatus() == null) goto L8;
        boolean r102 = true;
    L9:
        h(r102);
        f(r101);
        return;
    L8:
        r102 = false;
        goto L9
    }

    public static void s(ECSearchBaseFilterViewHolder r100, TextView r101, Integer r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$updateMargin");
        if (r102 == null) goto L16;
        ViewGroup.LayoutParams r103 = r101.getLayoutParams();     // Catch: Exception -> L13
        if (r103 == null) goto L11;
        LinearLayout.LayoutParams r104 = (LinearLayout.LayoutParams) r103;     // Catch: Exception -> L13
        if (r102 == null) goto L12;
        int r105 = r102.intValue();     // Catch: Exception -> L13
        r104.setMarginEnd(r105);     // Catch: Exception -> L13
        r104.rightMargin = r105;     // Catch: Exception -> L13
        return;
    L12:
        return;
    L11:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");     // Catch: Exception -> L13
    L17:
        return;
    }

    public static void u(ECSearchBaseFilterViewHolder r100, TextView r101, String r102) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "$this$updateTextColor");
        if (r102 == null) goto L8;
        StringsKt.isBlank(r102);
    L8:
        r101.setTextColor(Color.parseColor(r102));     // Catch: Exception -> L7
        return;
    }

    public static void v(View r100, Float r101, Float r102) {
        Intrinsics.checkNotNullParameter(r100, "$this$updateWH");
        if (r100.getLayoutParams() != null) goto L5;
        return;
    L5:
        ViewGroup.LayoutParams r103 = null;
        if (r101 == null) goto L8;
        Integer r104 = Integer.valueOf(DimenExtensionsKt.a(r101));
    L9:
        if (r102 == null) goto L11;
        Integer r105 = Integer.valueOf(DimenExtensionsKt.a(r102));
    L12:
        if (r104 == null) goto L20;
        if (r105 == null) goto L21;
        ViewGroup.LayoutParams r106 = r100.getLayoutParams();
        if (r106 == null) goto L18;
        r106.width = r104.intValue();
        r106.height = r105.intValue();
        Unit r107 = Unit.INSTANCE;
        r103 = r106;
    L18:
        r100.setLayoutParams(r103);
        return;
    L21:
        return;
    L20:
        return;
    L11:
        r105 = null;
        goto L12
    L8:
        r104 = null;
        goto L9
    }
}
