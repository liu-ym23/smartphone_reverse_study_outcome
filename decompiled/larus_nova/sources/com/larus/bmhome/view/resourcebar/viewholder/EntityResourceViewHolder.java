package com.larus.bmhome.view.resourcebar.viewholder;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.larus.bmhome.view.resourcebar.bean.ItemStatus;
import com.larus.bmhome.view.resourcebar.bean.Mode;
import com.larus.bmhome.view.resourcebar.bean.ResourceBarConfig;
import com.larus.bmhome.view.resourcebar.bean.ResourceItemBean;
import com.larus.bmhome.view.resourcebar.bean.ResourceType;
import com.larus.chat.common.databinding.LarusFileResourceInspectFailedLayoutBinding;
import com.larus.chat.common.databinding.LarusFileResourceItemViewBinding;
import com.larus.chat.common.databinding.LarusFileResourceParseFailedLayoutBinding;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.view.b0;
import com.larus.nova.R;
import com.larus.platform.model.chat.UploadFilePolicy;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\b&\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dH\u0016J\u001a\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010 \u001a\u00020!H\u0004J\u0010\u0010(\u001a\u00020'2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010)\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010*\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0016J\u001a\u0010+\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000bX\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR&\u0010\u000e\u001a\r\u0012\t\u0012\u00070\u0010¢\u0006\u0002\b\u00110\u000f8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R&\u0010\u0016\u001a\r\u0012\t\u0012\u00070\u0017¢\u0006\u0002\b\u00110\u000f8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0015\u001a\u0004\b\u0018\u0010\u0013¨\u0006-"}, d2 = {"Lcom/larus/bmhome/view/resourcebar/viewholder/EntityResourceViewHolder;", "Lcom/larus/bmhome/view/resourcebar/viewholder/PayloadResourceViewHolder;", "config", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;", "viewBinding", "Lcom/larus/chat/common/databinding/LarusFileResourceItemViewBinding;", "<init>", "(Lcom/larus/bmhome/view/resourcebar/bean/ResourceBarConfig;Lcom/larus/chat/common/databinding/LarusFileResourceItemViewBinding;)V", "getViewBinding", "()Lcom/larus/chat/common/databinding/LarusFileResourceItemViewBinding;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "parseFailedStub", "Lcom/larus/common_ui/view/ViewStubManager;", "Lcom/larus/chat/common/databinding/LarusFileResourceParseFailedLayoutBinding;", "Lkotlin/jvm/internal/EnhancedNullability;", "getParseFailedStub", "()Lcom/larus/common_ui/view/ViewStubManager;", "parseFailedStub$delegate", "Lkotlin/Lazy;", "inspectFailedStub", "Lcom/larus/chat/common/databinding/LarusFileResourceInspectFailedLayoutBinding;", "getInspectFailedStub", "inspectFailedStub$delegate", "bindPayloads", "", "payloads", "", "", "bind", "data", "Lcom/larus/bmhome/view/resourcebar/bean/ResourceItemBean;", "callback", "Lcom/larus/bmhome/view/resourcebar/viewholder/BaseResourceViewHolder$Callback;", "setElementsVisibility", "setContentBackground", "shouldShowParseFailedUI", "", "isErrorStatus", "setContentInfo", "onClickOpen", "setListeners", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class EntityResourceViewHolder extends PayloadResourceViewHolder {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f317160f = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarusFileResourceItemViewBinding f317161b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f317162c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f317163d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Lazy f317164e;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f317165a = null;

        static {
            int[] r100 = new int[ItemStatus.values().length];
            r100[ItemStatus.UPLINKING.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L11:
            r100[ItemStatus.UPLINK_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L15:
            r100[ItemStatus.PARSE_FAILED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L6:
            f317165a = r100;
        }
    }

    static {
    }

    public void Y3(ResourceItemBean r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public final b0<LarusFileResourceInspectFailedLayoutBinding> V3() {
        return (b0) this.f317164e.getValue();
    }

    public final b0<LarusFileResourceParseFailedLayoutBinding> W3() {
        return (b0) this.f317163d.getValue();
    }

    public final Context getContext() {
        return this.f317162c;
    }

    public static boolean X3(ResourceItemBean r100) {
        ItemStatus r101 = r100.getStatus();
        if (r101 != ItemStatus.UPLINK_FAILED) goto L5;
        boolean r102 = true;
    L7:
        if (r101 != ItemStatus.INSPECT_FAILED) goto L9;
        boolean r103 = true;
    L11:
        if (r101 != ItemStatus.PARSE_FAILED) goto L13;
        boolean r104 = true;
    L14:
        if (r102 == true) goto L19;
        if (r103 == true) goto L20;
        if (r104 == true) goto L21;
        return true;
    L21:
        return false;
    L20:
        return false;
    L19:
        return false;
    L13:
        r104 = false;
        goto L14
    L9:
        r103 = false;
        goto L11
    L5:
        r102 = false;
        goto L7
    }

    public static boolean b4(ResourceItemBean r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (r100.getStatus() != ItemStatus.PARSE_FAILED) goto L9;
        boolean r101 = UploadFilePolicy.f365565a;
        if (UploadFilePolicy.f365565a == true) goto L7;
    L8:
        return true;
    L7:
        if (r100.getResourceType() != ResourceType.FILE) goto L8;
    L9:
        return false;
    }

    @Override // com.larus.bmhome.view.resourcebar.viewholder.PayloadResourceViewHolder
    public final void U3(List<Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "payloads");
        Object r101 = CollectionsKt.firstOrNull(r100);
        if ((r101 instanceof Integer) == false) goto L5;
        Integer r102 = (Integer) r101;
    L6:
        if (r102 == null) goto L8;
        long r103 = r102.intValue();
    L9:
        this.f317161b.f323970o.setProgress(r103);
        FLogger.f375446a.i("EntityResourceViewHolder", "bindPayloads, linkProgress:" + r103);
        return;
    L8:
        r103 = 0;
        goto L9
    L5:
        r102 = null;
        goto L6
    }

    public void Z3(ResourceItemBean r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        if (X3(r100) == true) goto L5;
    L9:
        ItemStatus r101 = r100.getStatus();
        View r102 = this.f317161b.f323959d;
        int r103 = b.f317165a[r101.ordinal()];
        if (r103 == 1) goto L22;
        if (r103 != 2) goto L14;
        int r104 = R.drawable.larus_bg_resource_uplink_failed;
    L25:
        r102.setBackgroundResource(r104);
        return;
    L14:
        if (r103 == 3) goto L17;
        r104 = v19.c.b(R.attr.larus_bg_resource_success_border, this.f317162c, R.drawable.larus_bg_resource_success_border);
        goto L25
    L17:
        if (b4(r100) == false) goto L19;
        r104 = R.drawable.larus_bg_resource_failed_border;
        goto L25
    L19:
        r104 = v19.c.b(R.attr.larus_bg_resource_success_border, this.f317162c, R.drawable.larus_bg_resource_success_border);
        goto L25
    L22:
        if (Intrinsics.areEqual(r100.getExt().get("ext_silent_upload"), Boolean.TRUE) == false) goto L24;
        r104 = v19.c.b(R.attr.larus_bg_resource_success_border, this.f317162c, R.drawable.larus_bg_resource_success_border);
        goto L25
    L24:
        r104 = v19.c.b(R.attr.larus_bg_resource_uplinking, this.f317162c, R.drawable.larus_bg_resource_uplinking);
        goto L25
    L5:
        if (Intrinsics.areEqual(r100.getExt().get("ext_show_re_select_layout"), Boolean.TRUE) == false) goto L9;
        View r105 = this.f317161b.f323959d;
        if (r105 == null) goto L27;
        r105.setBackgroundResource(v19.c.b(R.attr.larus_bg_resource_success_border, r105.getContext(), R.drawable.larus_bg_resource_success_border));
        return;
    }

    public void a4(ResourceItemBean r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        ConstraintLayout r100 = this.f317161b.f323956a;
        ViewGroup.LayoutParams r101 = r100.getLayoutParams();
        if (r101 == null) goto L43;
        r101.width = r110.getItemWidth();
        r101.height = r110.getItemHeight();
        r100.setLayoutParams(r101);
        int r102 = 0;
        this.f317161b.f323956a.setPadding(0, r110.getPaddingTop(), i5.r0(), r110.getPaddingBottom());
        if (r110.getStatus() != ItemStatus.UPLINKING) goto L11;
        if (Intrinsics.areEqual(r110.getExt().get("ext_spring_review_mode"), Boolean.TRUE) == false) goto L9;
        this.f317161b.f323966k.a(12.0f, 2.5f);
        this.f317161b.f323966k.setProgress(25);
        return;
    L9:
        this.f317161b.f323970o.a(12.0f, 2.5f);
        this.f317161b.f323970o.setProgress(r110.getUpLinkProgress());
        return;
    L11:
        if (b4(r110) == false) goto L37;
        W3().b();
        LarusFileResourceParseFailedLayoutBinding r111 = (LarusFileResourceParseFailedLayoutBinding) W3().f328321c;
        if (r111 == null) goto L48;
        AppCompatTextView r112 = r111.f323980d;
        if (r112 == null) goto L49;
        int r103 = nt8.a.f520534a;
        CharSequence r104 = r112.getText();
        int r105 = ((Number) i5.R0.getValue()).intValue();
        float[] r106 = {12.0f, 11.0f, 10.0f};
        Intrinsics.checkNotNullParameter(r104, "text");
        Intrinsics.checkNotNullParameter(r106, "spSizes");
        ArraysKt.sortDescending(r106);
    L17:
        if (r102 >= 3) goto L22;
        float r107 = r106[r102];
        Paint r108 = new Paint();
        float r109 = Float.valueOf(r107).floatValue();
        Resources r113 = AppHost.f326268a.getApplication().getResources();
        r108.setTextSize(TypedValue.applyDimension(2, r109, WindowDisplayMetricsOverride.apply(r113, r113.getDisplayMetrics())));
        if (r108.measureText(r104.toString()) <= r105) goto L20;
        r102 = r102 + 1;
        goto L17
    L20:
        Float r114 = Float.valueOf(r107);
    L23:
        if (r114 == null) goto L30;
        LarusFileResourceParseFailedLayoutBinding r115 = (LarusFileResourceParseFailedLayoutBinding) W3().f328321c;
        if (r115 == null) goto L29;
        AppCompatImageView r116 = r115.f323979c;
        if (r116 == null) goto L29;
        e1.x(r116);
    L29:
        r112.setTextSize(r114.floatValue());
        return;
    L30:
        LarusFileResourceParseFailedLayoutBinding r117 = (LarusFileResourceParseFailedLayoutBinding) W3().f328321c;
        if (r117 == null) goto L35;
        AppCompatImageView r118 = r117.f323979c;
        if (r118 == null) goto L35;
        e1.o(r118);
    L35:
        r112.setTextSize(10.0f);
        return;
    L22:
        r114 = null;
        goto L23
    L49:
        return;
    L48:
        return;
    L37:
        if (r110.getStatus() == ItemStatus.UPLINK_SUCCESS) goto L39;
        return;
    L39:
        if (Intrinsics.areEqual(r110.getExt().get("ext_spring_review_mode"), Boolean.TRUE) == false) goto L53;
        this.f317161b.f323966k.a(12.0f, 2.5f);
        this.f317161b.f323966k.setProgress(25);
        return;
    L53:
        return;
    L43:
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.LayoutParams");
    }

    public EntityResourceViewHolder(ResourceBarConfig r100, LarusFileResourceItemViewBinding r101) {
        Intrinsics.checkNotNullParameter(r100, "config");
        Intrinsics.checkNotNullParameter(r101, "viewBinding");
        super(r100, r101.f323956a);
        this.f317161b = r101;
        this.f317162c = r101.f323956a.getContext();
        this.f317163d = LazyKt.lazy(new g(this));
        this.f317164e = LazyKt.lazy(new h(this));
    }

    @Override // com.larus.bmhome.view.resourcebar.viewholder.BaseResourceViewHolder
    public final void T3(final ResourceItemBean r110, final lt8.a r111) {
        Intrinsics.checkNotNullParameter(r110, "data");
        FLogger r100 = FLogger.f375446a;
        r100.i("EntityResourceViewHolder", "bind, type=" + r110.getResourceType() + ", status=" + r110.getStatus() + ", progress=" + r110.getUpLinkProgress());
        ItemStatus r101 = r110.getStatus();
        boolean r102 = b4(r110);
        ItemStatus r103 = ItemStatus.UPLINKING;
        if (r101 != r103) goto L5;
        r100.i("EntityResourceViewHolder", "[setElementsVisibility] status" + r101);
    L5:
        AppCompatImageView r104 = this.f317161b.f323965j;
        Mode r105 = this.f317159a.getMode();
        Mode r106 = Mode.SHOW;
        if (r105 != r106) goto L8;
        int r107 = 8;
    L9:
        r104.setVisibility(r107);
        Object r108 = r110.getExt().get("ext_silent_upload");
        Boolean r109 = Boolean.TRUE;
        boolean r112 = Intrinsics.areEqual(r108, r109);
        FrameLayout r113 = this.f317161b.f323971p;
        if (r112 == true) goto L13;
        if (r101 != r103) goto L13;
        int r114 = 0;
    L14:
        r113.setVisibility(r114);
        FrameLayout r115 = this.f317161b.f323964i;
        if (r101 != ItemStatus.UPLINK_FAILED) goto L17;
        int r116 = 0;
    L18:
        r115.setVisibility(r116);
        boolean r117 = Intrinsics.areEqual(r110.getExt().get("local_item_attachment"), "1");
        ConstraintLayout r118 = this.f317161b.f323960e;
        if (r117 == false) goto L21;
        float r119 = 0.5f;
    L22:
        r118.setAlpha(r119);
        if (r101 != ItemStatus.INSPECT_FAILED) goto L25;
        V3().b();
    L25:
        if (r102 == false) goto L27;
        W3().b();
    L28:
        AppCompatImageView r120 = this.f317161b.f323968m;
        if (r102 == false) goto L31;
        int r121 = 8;
    L32:
        r120.setVisibility(r121);
        AppCompatTextView r122 = this.f317161b.f323969n;
        if (r102 == false) goto L35;
        int r123 = 8;
    L36:
        r122.setVisibility(r123);
        if (X3(r110) == true) goto L39;
    L41:
        e1.o(this.f317161b.f323963h);
        this.f317161b.f323973r.setContentDescription(this.f317162c.getString(R.string.larus_accessibility_message_photo));
    L43:
        if (r101 == r103) goto L45;
    L50:
        ItemStatus r124 = ItemStatus.UPLINK_SUCCESS;
        if (r101 == r124) goto L53;
    L55:
        if (r101 == r124) goto L59;
        if (r101 == ItemStatus.SUCCESS) goto L59;
    L61:
        this.f317161b.f323957b.setBackgroundColor(0);
        this.f317161b.f323957b.setBackgroundColor(0);
    L62:
        Z3(r110);
        a4(r110);
        e1.d(this.f317161b.f323965j, new com.larus.bmhome.view.resourcebar.viewholder.b(r111, r110));
        e1.d(this.f317161b.f323964i, new c(r111, r110));
        e1.d(this.f317161b.f323960e, new d(r110, this, r111));
        if (this.f317159a.getMode() != r106) goto L65;
        this.f317161b.f323960e.setOnLongClickListener(new e(r111, r110));
    L66:
        LarusFileResourceInspectFailedLayoutBinding r125 = (LarusFileResourceInspectFailedLayoutBinding) V3().f328321c;
        if (r125 == null) goto L71;
        FrameLayout r126 = r125.f323953a;
        if (r126 == null) goto L71;
        e1.d(r126, new f(r111, r110));
    L71:
        this.f317161b.f323974s.setActionListener(new i(r111, r110, this));
        return;
    L65:
        this.f317161b.f323960e.setOnLongClickListener(null);
    L59:
        if (Intrinsics.areEqual(r110.getExt().get("ext_spring_review_mode"), r109) == true) goto L61;
        this.f317161b.f323957b.setBackgroundResource(R.drawable.larus_bg_resource_view_holder_bottom_mask);
        this.f317161b.f323975t.setBackgroundResource(R.drawable.larus_bg_resource_view_holder_bottom_mask);
        goto L62
    L53:
        if (Intrinsics.areEqual(r110.getExt().get("ext_spring_review_mode"), r109) == false) goto L55;
        this.f317161b.f323971p.setVisibility(8);
        this.f317161b.f323972q.setVisibility(0);
        goto L55
    L45:
        if (Intrinsics.areEqual(r110.getExt().get("ext_spring_review_mode"), r109) == false) goto L47;
        this.f317161b.f323971p.setVisibility(8);
        this.f317161b.f323972q.setVisibility(0);
        goto L50
    L47:
        if (r112 == false) goto L49;
        this.f317161b.f323971p.setVisibility(8);
        goto L50
    L49:
        this.f317161b.f323971p.setVisibility(0);
        goto L50
    L39:
        if (Intrinsics.areEqual(r110.getExt().get("ext_show_re_select_layout"), r109) == false) goto L41;
        e1.x(this.f317161b.f323963h);
        e1.o(this.f317161b.f323971p);
        this.f317161b.f323973r.setContentDescription(this.f317162c.getString(R.string.larus_accessibility_replace_image));
        goto L43
    L35:
        r123 = 0;
        goto L36
    L31:
        r121 = 0;
        goto L32
    L27:
        W3().a();
        goto L28
    L21:
        r119 = 1.0f;
        goto L22
    L17:
        r116 = 8;
    L13:
        r114 = 8;
        goto L14
    L8:
        r107 = 0;
        goto L9
    }
}
