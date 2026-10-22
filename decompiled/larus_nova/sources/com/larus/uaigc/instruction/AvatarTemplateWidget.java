package com.larus.uaigc.instruction;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.keva.Keva;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.larus.bmhome.instruction.base.AbsInstructionWidget;
import com.larus.network.http.HttpExtKt;
import com.larus.nova.R;
import com.larus.uaigc.createpage.component.digitalavatar.DigitalAvatarInfoManager;
import com.larus.uaigc.impl.databinding.LarusItemActionBarAvatarInstructionBinding;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.route_monitor.impl.route_out.control.bean.RuleConditionBean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.z0;
import wa8.n0;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 =2\u00020\u00012\u00020\u0002:\u0002=>B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010#\u001a\u00020$2\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010'\u001a\u00020$H\u0016J\b\u0010(\u001a\u00020$H\u0002J\b\u0010)\u001a\u00020$H\u0002J\b\u0010*\u001a\u00020$H\u0002J\b\u0010+\u001a\u00020$H\u0002J\b\u0010,\u001a\u00020$H\u0002J\n\u0010-\u001a\u0004\u0018\u00010\u001aH\u0016J\u000f\u0010.\u001a\u0004\u0018\u00010/H\u0016¢\u0006\u0002\u00100J\b\u00101\u001a\u00020/H\u0016J\b\u00105\u001a\u000206H\u0002J\b\u00107\u001a\u00020$H\u0002J\b\u00108\u001a\u000209H\u0002J\u0012\u0010:\u001a\u00020$2\b\b\u0002\u0010;\u001a\u000209H\u0002J\b\u0010<\u001a\u000209H\u0002R#\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R#\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\r\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\r\u001a\u0004\b \u0010!R\u0012\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0004\n\u0002\u00104¨\u0006?"}, d2 = {"Lcom/larus/uaigc/instruction/AvatarTemplateWidget;", "Lcom/larus/bmhome/instruction/base/AbsInstructionWidget;", "Lcom/larus/uaigc/creation/IReportInstructionWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "cache", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getCache", "()Lcom/bytedance/keva/Keva;", "cache$delegate", "Lkotlin/Lazy;", "binding", "Lcom/larus/uaigc/impl/databinding/LarusItemActionBarAvatarInstructionBinding;", "controller", "Lcom/larus/uaigc/instruction/AvatarTemplateController;", "getController", "()Lcom/larus/uaigc/instruction/AvatarTemplateController;", "currentBindData", "Lcom/larus/bmhome/actionbar/model/ActionBarAvatarInstructionItem;", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/ActionBarAvatarInstructionItem;", "avatarUrl", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "getAvatarUrl", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "avatarUrl$delegate", "frescoCloseableHolder", "Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/FrescoCloseableHolder;", "getFrescoCloseableHolder", "()Lcom/larus/uaigc/createpage/component/mediaselector/imageselector/FrescoCloseableHolder;", "frescoCloseableHolder$delegate", "init", "", "attrs", "Landroid/util/AttributeSet;", "onBindView", "initView", "mobButtonShow", "bindObserver", "observeReplicaInfoIfInitialNull", "createDigitalAvatar", "getButtonName", "getImageEditFunctionId", "", "()Ljava/lang/Integer;", "getMultiItemType", "memoryRedDotVersion", "", "Ljava/lang/Long;", "getRedDotFromLocalCache", "Lcom/larus/uaigc/instruction/AvatarTemplateWidget$AvatarTemplateRedDot;", "tryToShowRedDot", "shouldShowRedDotByCheckVersion", "", "updateRedDotVersion", "updateMemoryVersion", "shouldPropagateAICreationHostSource", "Companion", "AvatarTemplateRedDot", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AvatarTemplateWidget extends AbsInstructionWidget implements com.larus.uaigc.creation.e {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int[] f373285k = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f373286f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LarusItemActionBarAvatarInstructionBinding f373287g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f373288h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f373289i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Long f373290j;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\t\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/larus/uaigc/instruction/AvatarTemplateWidget$AvatarTemplateRedDot;", "", RuleConditionBean.VERSION_CODE_KEY, "", "<init>", "(J)V", "getVersionCode", "()J", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a {

        @SerializedName("version_code")
        private final long versionCode;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.versionCode == ((a) r100).versionCode) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r100 = this.versionCode;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "AvatarTemplateRedDot(versionCode=" + this.versionCode + ')';
        }

        public final long a() {
            return this.versionCode;
        }

        public /* synthetic */ a(int r100) {
            this(0);
        }

        public a(long r100) {
            this.versionCode = r100;
        }
    }

    public static final class b {
    }

    @Metadata(d1 = {"\u0000\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"com/larus/uaigc/instruction/AvatarTemplateWidget$getRedDotFromLocalCache$1", "Lcom/google/gson/reflect/TypeToken;", "Lcom/larus/uaigc/instruction/AvatarTemplateWidget$AvatarTemplateRedDot;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class c extends TypeToken<a> {
        public c() {
        }
    }

    private final a getRedDotFromLocalCache() {
        int r100 = 0;
        a r101 = (a) HttpExtKt.f360123f.fromJson(getCache().getString("red_dot_cache_key", SliceInitService.DEFAULT_SWITCH), new c().getType());     // Catch: Exception -> L7
        if (r101 != null) goto L12;
        return new a(r100);
    L12:
        return r101;
    L7:
        e = move-exception;
        FLogger.f375446a.e("AvatarTemplateWidget", "save cache error=" + e.getMessage());
        return new a(r100);
    }

    static {
        int[] r100 = new int[2];
        Result.Companion r101 = Result.Companion;     // Catch: Throwable -> L5
        Object r102 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor("#FFAC57")));     // Catch: Throwable -> L5
    L7:
        Object r103 = null;
        if (Result.m9455isFailureimpl(r102) == false) goto L10;
        r102 = null;
    L10:
        Integer r104 = (Integer) r102;
        int r105 = -16777216;
        if (r104 == null) goto L13;
        int r106 = r104.intValue();
    L14:
        r100[0] = r106;
        Object r107 = Result.m9449constructorimpl(Integer.valueOf(Color.parseColor("#F467C9")));     // Catch: Throwable -> L17
    L20:
        if (Result.m9455isFailureimpl(r107) == true) goto L23;
        r103 = r107;
    L23:
        Integer r108 = (Integer) r103;
        if (r108 == null) goto L26;
        r105 = r108.intValue();
    L26:
        r100[1] = r105;
        f373285k = r100;
        return;
    L17:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L20
    L13:
        r106 = -16777216;
    L5:
        th = move-exception;
        Result.Companion r110 = Result.Companion;
        r102 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L7
    }

    private final z0<String> getAvatarUrl() {
        return (z0) this.f373288h.getValue();
    }

    private final Keva getCache() {
        return (Keva) this.f373286f.getValue();
    }

    private final com.larus.uaigc.createpage.component.mediaselector.imageselector.c getFrescoCloseableHolder() {
        return (com.larus.uaigc.createpage.component.mediaselector.imageselector.c) this.f373289i.getValue();
    }

    @Override // com.larus.uaigc.creation.e
    public String getButtonName() {
        DigitalAvatarInfoManager.f371542a.getClass();
        if (DigitalAvatarInfoManager.g() == true) goto L7;
        wa8.a r100 = getCurrentBindData();
        if (r100 != null) goto L12;
    L10:
        return null;
    L12:
        return r100.f558826b;
    L7:
        wa8.a r101 = getCurrentBindData();
        if (r101 == null) goto L10;
        return r101.f558827c;
    }

    private final com.larus.uaigc.instruction.a getController() {
        return (com.larus.uaigc.instruction.a) getController();
    }

    private final wa8.a getCurrentBindData() {
        com.larus.uaigc.instruction.a r100 = getController();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f373334l;
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void Y5() {
        CoroutineScope r100 = getComponentScope();
        if (r100 == null) goto L5;
        BuildersKt.launch$default(r100, null, null, new AvatarTemplateWidget$initView$1(this, null), 3, null);
    L5:
        LarusItemActionBarAvatarInstructionBinding r101 = this.f373287g;
        if (r101 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r101 = null;
    L8:
        e1.d(r101.f373157a, new com.larus.uaigc.instruction.b(this));
        getViewTreeObserver().addOnDrawListener(new o(this));
        CoroutineScope r102 = getComponentScope();
        if (r102 == null) goto L11;
        BuildersKt.launch$default(r102, null, null, new AvatarTemplateWidget$bindObserver$1(this, null), 3, null);
    L11:
        DigitalAvatarInfoManager.f371542a.getClass();
        if (DigitalAvatarInfoManager.f371552k.getValue() != null) goto L16;
        CoroutineScope r103 = getComponentScope();
        if (r103 == null) goto L16;
        BuildersKt.launch$default(r103, null, null, new AvatarTemplateWidget$observeReplicaInfoIfInitialNull$1(this, null), 3, null);
    L16:
        com.larus.bmhome.view.actionbar.edit.c r104 = getViewModel();
        if (r104 == null) goto L24;
        Integer r105 = r104.getInstructionType();
        if (r105 == null) goto L24;
        if (r105.intValue() != 28) goto L24;
        boolean r106 = true;
    L25:
        if (r106 == false) goto L30;
        com.larus.bmhome.view.actionbar.edit.c r107 = getViewModel();
        if (r107 == null) goto L31;
        r107.onComponentVisibilityChanged(this, true);
        return;
    L31:
        return;
    L30:
        return;
    L24:
        r106 = false;
        goto L25
    }

    @Override // com.larus.uaigc.creation.e
    public Integer getImageEditFunctionId() {
        wa8.a r100 = getCurrentBindData();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f558825a;
    }

    @Override // com.larus.uaigc.creation.e
    public int getMultiItemType() {
        if (getController() == null) goto L5;
        return 8;
    L5:
        return 0;
    }

    public AvatarTemplateWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        super(r100, r101, 6, 0);
        this.f373286f = LazyKt.lazy(new com.larus.uaigc.instruction.c());
        this.f373288h = LazyKt.lazy(new d());
        this.f373289i = LazyKt.lazy(new e());
    }

    public static final /* synthetic */ z0 i6(AvatarTemplateWidget r100) {
        return r100.getAvatarUrl();
    }

    public static final /* synthetic */ wa8.a k6(AvatarTemplateWidget r100) {
        return r100.getCurrentBindData();
    }

    public static final /* synthetic */ com.larus.uaigc.createpage.component.mediaselector.imageselector.c n6(AvatarTemplateWidget r100) {
        return r100.getFrescoCloseableHolder();
    }

    public static final void o6(AvatarTemplateWidget r110) {
        com.larus.uaigc.instruction.a r100 = r110.getController();
        boolean r101 = true;
        if (r100 == null) goto L12;
        up8.b r102 = r100.f551066f;
        if (r102 == null) goto L12;
        Integer r103 = r102.f551067g;
        if (r103 == null) goto L12;
        if (r103.intValue() != 18) goto L12;
        boolean r104 = true;
    L13:
        DigitalAvatarInfoManager.f371542a.getClass();
        boolean r105 = DigitalAvatarInfoManager.j();
        LarusItemActionBarAvatarInstructionBinding r106 = null;
        if (r104 == false) goto L41;
        if (r105 == false) goto L41;
        Long r107 = r110.f373290j;
        if (r107 == null) goto L19;
        long r108 = r107.longValue();
    L20:
        wa8.a r109 = r110.getCurrentBindData();
        if (r109 == null) goto L25;
        Long r111 = r109.f558828d;
        if (r111 == null) goto L25;
        long r112 = r111.longValue();
    L27:
        if (r108 < r112) goto L30;
        r101 = false;
    L30:
        if (r101 == false) goto L41;
        if (o0.d(n0.a()) == false) goto L41;
        LarusItemActionBarAvatarInstructionBinding r113 = r110.f373287g;
        if (r113 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r113 = null;
    L36:
        r113.f373160d.setText(n0.a());
        LarusItemActionBarAvatarInstructionBinding r114 = r110.f373287g;
        if (r114 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L40:
        e1.x(r106.f373160d);
        r110.s6(false);
        return;
    L39:
        r106 = r114;
    L25:
        r112 = 0;
        goto L27
    L19:
        r108 = r110.getRedDotFromLocalCache().a();
        r110.f373290j = Long.valueOf(r108);
    L41:
        LarusItemActionBarAvatarInstructionBinding r115 = r110.f373287g;
        if (r115 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L45:
        e1.o(r106.f373160d);
        return;
    L44:
        r106 = r115;
    L12:
        r104 = false;
        goto L13
    }

    public final void s6(boolean r100) {
        wa8.a r101 = getCurrentBindData();
        if (r101 == null) goto L7;
        Long r102 = r101.f558828d;
        if (r102 == null) goto L7;
        long r103 = r102.longValue();
    L8:
        getRedDotFromLocalCache().getClass();
        a r104 = new a(r103);
        if (r100 == false) goto L16;
        this.f373290j = Long.valueOf(r103);
    L16:
        String r105 = HttpExtKt.f360123f.toJson(r104);     // Catch: Exception -> L13
        getCache().storeString("red_dot_cache_key", r105);     // Catch: Exception -> L13
        FLogger.f375446a.i("AvatarTemplateWidget", "setItemHasClicked save cache newEntityString=" + r105);     // Catch: Exception -> L13
        return;
    L13:
        e = move-exception;
        FLogger.f375446a.e("AvatarTemplateWidget", "setItemHasClicked save cache error=" + e.getMessage());
        return;
    L7:
        r103 = 0;
        goto L8
    }

    @Override // com.larus.bmhome.instruction.base.AbsInstructionWidget
    public final void V5(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LayoutInflater.from(r100).inflate(R.layout.larus_item_action_bar_avatar_instruction, this);
        int r102 = R.id.display_text;
        TextView r103 = (TextView) ViewBindings.findChildViewById(this, R.id.display_text);
        if (r103 == null) goto L13;
        r102 = R.id.icon;
        ImageView r104 = (ImageView) ViewBindings.findChildViewById(this, R.id.icon);
        if (r104 == null) goto L13;
        r102 = R.id.icon_container;
        if (((CardView) ViewBindings.findChildViewById(this, R.id.icon_container)) == null) goto L13;
        r102 = R.id.tv_item_update_dot;
        TextView r105 = (TextView) ViewBindings.findChildViewById(this, R.id.tv_item_update_dot);
        if (r105 == null) goto L13;
        LarusItemActionBarAvatarInstructionBinding r106 = new LarusItemActionBarAvatarInstructionBinding(this, r103, r104, r105);
        setBackground(ContextCompat.getDrawable(r100, v19.c.b(R.attr.larus_bg_action_bar_instruction_widget_item, r100, R.drawable.larus_bg_action_bar_instruction_widget_item)));
        this.f373287g = r106;
        return;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }
}
