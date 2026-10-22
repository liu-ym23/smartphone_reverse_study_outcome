package com.larus.uaigc.instruction.kmp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.fragment.app.Fragment;
import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.chat.component.bottom.core.ICoreInputAbility;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.platform.api.creation.UserCreation;
import com.larus.platform.api.creation.UserCreationTrackParams;
import com.larus.platform.kmp.chat.TemplateInfo$TemplateInfo;
import com.larus.uaigc.impl.databinding.LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding;
import com.larus.uaigc.instruction.DropFeatureSelectorFragment;
import com.larus.uaigc.instruction.p;
import com.larus.utils.e1;
import com.larus.utils.o0;
import com.ss.android.lark.utils.statistics.PerfLog;
import cq8.a0;
import cq8.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t*\u0001\u001e\u0018\u0000 =2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001=B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020\"2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010(H\u0002J\u0012\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u000100H\u0002J\u001a\u00101\u001a\u00020*2\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0014J\u0012\u00102\u001a\u00020*2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u00103\u001a\u00020*H\u0014J\u0010\u00104\u001a\u00020*2\u0006\u0010\u0010\u001a\u000205H\u0014J\b\u00106\u001a\u00020*H\u0002J\b\u00107\u001a\u00020*H\u0002J\b\u00108\u001a\u00020*H\u0002J\b\u00109\u001a\u00020*H\u0002J\u000f\u0010:\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0002\u0010;J\n\u0010<\u001a\u0004\u0018\u00010&H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\u0004\u0018\u00010\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001fRW\u0010 \u001aK\u0012\u0013\u0012\u00110\"¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b(%\u0012\u0015\u0012\u0013\u0018\u00010&¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b('\u0012\u0015\u0012\u0013\u0018\u00010(¢\u0006\f\b#\u0012\b\b$\u0012\u0004\b\b()\u0012\u0004\u0012\u00020*0!X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/larus/uaigc/instruction/kmp/KmpDropFeatureSelectorWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/instruction/kmp/IKmpInstructionViewModelAware;", "Lcom/larus/uaigc/creation/IReportInstructionWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding;", "dropFeatureSelectorFragment", "Lcom/larus/uaigc/instruction/DropFeatureSelectorFragment;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/DropFeatureSelectorDescriptor;", "isBound", "", "viewModel", "Lcom/larus/bmhome/view/actionbar/edit/IInstructionEditorViewModel;", "widgetScope", "Lkotlinx/coroutines/CoroutineScope;", "localBindData", "Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "currentBindData", "getCurrentBindData", "()Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "dropFeatureItemSelectorCallback", "com/larus/uaigc/instruction/kmp/KmpDropFeatureSelectorWidget$dropFeatureItemSelectorCallback$1", "Lcom/larus/uaigc/instruction/kmp/KmpDropFeatureSelectorWidget$dropFeatureItemSelectorCallback$1;", "imageTemplateChoose", "Lkotlin/Function3;", "Lcom/larus/platform/kmp/chat/TemplateInfo$TemplateInfo;", "Lkotlin/ParameterName;", "name", "templateInfo", "", "conversationId", "Landroid/net/Uri;", "localImagePath", "", "selectImageTemplateInternal", MapController.ITEM_LAYER_TAG, "getSendMessageTrackExtMap", "Lcom/larus/bmhome/chat/component/bottom/core/ICoreInputAbility$SendMessageTrackExtMap;", "userCreation", "Lcom/larus/platform/api/creation/UserCreation;", "init", "bindInstructionViewModel", "onDetachedFromWindow", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "syncToCore", "showDropFeatureSelectorFragment", "bindObservers", "onBindView", "getImageEditFunctionId", "()Ljava/lang/Integer;", "getButtonName", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpDropFeatureSelectorWidget extends AbsKmpInstructionWidget implements com.larus.bmhome.instruction.kmp.b, com.larus.uaigc.creation.e {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f373352o = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding f373353f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DropFeatureSelectorFragment f373354g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public cq8.k f373355h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f373356i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.larus.bmhome.view.actionbar.edit.c f373357j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final CoroutineScope f373358k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public com.larus.bmhome.actionbar.model.h f373359l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final b f373360m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final com.larus.uaigc.instruction.kmp.b f373361n;

    public static final class a {
    }

    public static final class b implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KmpDropFeatureSelectorWidget f373362a;

        public b(KmpDropFeatureSelectorWidget r100) {
            this.f373362a = r100;
        }

        @Override // com.larus.uaigc.instruction.p
        public final void a(w r100) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
            com.larus.bmhome.actionbar.model.h r101 = KmpDropFeatureSelectorWidget.Y5(this.f373362a);
            LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r102 = null;
            boolean r103 = false;
            if (r101 == null) goto L20;
            List<w> r104 = r101.f295167e;
            if (r104 == null) goto L20;
            Iterator<T> r105 = r104.iterator();
        L8:
            if (r105.hasNext() == false) goto L18;
            Object r106 = r105.next();
            Integer r107 = ((w) r106).f295528s;
            if (r107 != null) goto L13;
        L15:
            boolean r108 = false;
        L16:
            if (r108 == false) goto L8;
        L19:
            w r109 = (w) r106;
        L21:
            KmpDropFeatureSelectorWidget r110 = this.f373362a;
            cq8.k r111 = r110.f373355h;
            if (r111 != null) goto L24;
        L26:
            boolean r112 = false;
        L27:
            if (r112 == false) goto L34;
            com.larus.bmhome.view.actionbar.edit.c r113 = r110.f373357j;
            if (r113 == null) goto L34;
            if (r109 == null) goto L32;
            boolean r114 = true;
        L33:
            r113.setImageStyleRadioSelected(r114);
            goto L34
        L32:
            r114 = false;
        L34:
            cq8.k r115 = this.f373362a.f373355h;
            if (r115 == null) goto L42;
            Integer r116 = r115.f464868i;
            if (r116 == null) goto L42;
            if (r116.intValue() != 18) goto L42;
            r103 = true;
        L42:
            if (r103 == false) goto L57;
            Integer r117 = r100.f295528s;
            if (r117 != null) goto L47;
        L49:
            Long r118 = r100.f295510a;
            if (r118 == null) goto L52;
            long r119 = r118.longValue();
        L53:
            com.larus.bmhome.view.actionbar.edit.c r120 = this.f373362a.f373357j;
            if (r120 == null) goto L57;
            r120.selectedVideoStyleItem(r119);
        L52:
            r119 = 0;
            goto L53
        L47:
            if (r117.intValue() != 1) goto L49;
        L57:
            if (r109 == null) goto L66;
            LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r121 = this.f373362a.f373353f;
            if (r121 != null) goto L61;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            r121 = null;
        L61:
            e1.x(r121.f373198f);
            LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r122 = this.f373362a.f373353f;
            if (r122 != null) goto L64;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L65:
            r102.f373198f.setText(r109.f295511b);
        L71:
            this.f373362a.Z5();
            return;
        L64:
            r102 = r122;
            goto L65
        L66:
            LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r123 = this.f373362a.f373353f;
            if (r123 != null) goto L69;
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        L70:
            e1.o(r102.f373198f);
            goto L71
        L69:
            r102 = r123;
            goto L70
        L24:
            if (r111.f464867h != true) goto L26;
            r112 = true;
            goto L27
        L13:
            if (r107.intValue() != 1) goto L15;
            r108 = true;
            goto L16
        L18:
            r106 = null;
        L20:
            r109 = null;
            goto L21
        }

        @Override // com.larus.uaigc.instruction.p
        public final void b(w r410, int r411) {
            Intrinsics.checkNotNullParameter(r410, MapController.ITEM_LAYER_TAG);
            KmpDropFeatureSelectorWidget r100 = this.f373362a;
            cq8.k r101 = r100.f373355h;
            if (r101 == null) goto L5;
            z0 r102 = r101.f464869j;
        L6:
            if (r102 == null) goto L8;
            String r103 = r102.f465007a;
        L9:
            if (r102 == null) goto L11;
            String r104 = r102.f465009c;
        L12:
            if (r102 == null) goto L14;
            String r105 = r102.f465010d;
        L15:
            if (r102 == null) goto L17;
            String r110 = r102.f465012f;
        L18:
            if (r102 == null) goto L20;
            String r111 = r102.f465013g;
        L21:
            if (r102 == null) goto L23;
            String r112 = r102.f465016j;
        L24:
            com.larus.bmhome.actionbar.model.h r106 = KmpDropFeatureSelectorWidget.Y5(r100);
            if (r106 == null) goto L27;
            String r113 = r106.f295165c;
        L28:
            String r114 = r410.f295511b;
            String r115 = String.valueOf(r410.f295510a);
            com.larus.bmhome.actionbar.model.h r107 = KmpDropFeatureSelectorWidget.Y5(this.f373362a);
            boolean r108 = false;
            if (r107 == null) goto L36;
            Integer r109 = r107.f295168f;
            if (r109 == null) goto L36;
            if (r411 != r109.intValue()) goto L36;
            int r116 = 1;
        L37:
            Integer r117 = Integer.valueOf(r116);
            Integer r118 = Integer.valueOf(r411 + 1);
            Integer r119 = r410.f295528s;
            if (r119 != null) goto L41;
        L43:
            String r120 = "cancel";
        L44:
            String r121 = r120;
            if (r102 == null) goto L47;
            String r310 = r102.f465014h;
        L48:
            if (r102 == null) goto L50;
            Boolean r311 = r102.f465015i;
        L51:
            tx9.b.e(r103, r104, r105, r110, r111, r112, r113, r114, r115, r117, 1, r118, r121, null, null, null, null, "original", null, null, null, null, null, r310, r311, null, null, null, null, null, null, null, null, null, null, null, null, -50601984, 127);
            com.larus.bmhome.actionbar.model.h r122 = KmpDropFeatureSelectorWidget.Y5(this.f373362a);
            if (r122 == null) goto L69;
            List<w> r123 = r122.f295167e;
            if (r123 == null) goto L69;
            Iterator<T> r124 = r123.iterator();
        L57:
            if (r124.hasNext() == false) goto L67;
            Object r125 = r124.next();
            Integer r126 = ((w) r125).f295528s;
            if (r126 != null) goto L62;
        L64:
            boolean r127 = false;
        L65:
            if (r127 == false) goto L57;
            Object r412 = r125;
        L68:
            w r413 = (w) r412;
        L70:
            com.larus.bmhome.view.actionbar.edit.c r128 = this.f373362a.f373357j;
            if (r128 == null) goto L75;
            if (r413 == null) goto L74;
            r108 = true;
        L74:
            r128.setImageStyleRadioSelected(r108);
        L75:
            this.f373362a.Z5();
            return;
        L62:
            if (r126.intValue() != 1) goto L64;
            r127 = true;
            goto L65
        L67:
            r412 = null;
        L69:
            r413 = null;
            goto L70
        L50:
            r311 = null;
            goto L51
        L47:
            r310 = null;
            goto L48
        L41:
            if (r119.intValue() != 1) goto L43;
            r120 = "select";
        L36:
            r116 = 0;
            goto L37
        L27:
            r113 = null;
            goto L28
        L23:
            r112 = null;
            goto L24
        L20:
            r111 = null;
            goto L21
        L17:
            r110 = null;
            goto L18
        L14:
            r105 = null;
            goto L15
        L11:
            r104 = null;
            goto L12
        L8:
            r103 = null;
            goto L9
        L5:
            r102 = null;
            goto L6
        }

        @Override // com.larus.uaigc.instruction.p
        public final void c(w r310, int r311) {
            Intrinsics.checkNotNullParameter(r310, MapController.ITEM_LAYER_TAG);
            KmpDropFeatureSelectorWidget r100 = this.f373362a;
            cq8.k r101 = r100.f373355h;
            Boolean r102 = null;
            if (r101 == null) goto L5;
            z0 r103 = r101.f464869j;
        L6:
            if (r103 == null) goto L8;
            String r104 = r103.f465007a;
        L9:
            if (r103 == null) goto L11;
            String r105 = r103.f465009c;
        L12:
            if (r103 == null) goto L14;
            String r106 = r103.f465010d;
        L15:
            if (r103 == null) goto L17;
            String r110 = r103.f465012f;
        L18:
            if (r103 == null) goto L20;
            String r111 = r103.f465013g;
        L21:
            if (r103 == null) goto L23;
            String r112 = r103.f465016j;
        L24:
            com.larus.bmhome.actionbar.model.h r107 = KmpDropFeatureSelectorWidget.Y5(r100);
            if (r107 == null) goto L27;
            String r113 = r107.f295165c;
        L28:
            String r114 = r310.f295511b;
            String r115 = String.valueOf(r310.f295510a);
            com.larus.bmhome.actionbar.model.h r108 = KmpDropFeatureSelectorWidget.Y5(this.f373362a);
            if (r108 == null) goto L36;
            Integer r109 = r108.f295168f;
            if (r109 == null) goto L36;
            if (r311 != r109.intValue()) goto L36;
            int r116 = 1;
        L37:
            Integer r117 = Integer.valueOf(r116);
            Integer r118 = Integer.valueOf(r311 + 1);
            if (r103 == null) goto L40;
            String r210 = r103.f465014h;
        L41:
            if (r103 == null) goto L43;
            r102 = r103.f465015i;
        L43:
            tx9.b.f(r104, r105, r106, r110, r111, r112, r113, r114, r115, r117, 1, r118, null, null, null, null, null, null, null, null, r210, r102, 2093056);
            return;
        L40:
            r210 = null;
        L36:
            r116 = 0;
            goto L37
        L27:
            r113 = null;
            goto L28
        L23:
            r112 = null;
            goto L24
        L20:
            r111 = null;
            goto L21
        L17:
            r110 = null;
            goto L18
        L14:
            r106 = null;
            goto L15
        L11:
            r105 = null;
            goto L12
        L8:
            r104 = null;
            goto L9
        L5:
            r103 = null;
            goto L6
        }
    }

    static {
    }

    public KmpDropFeatureSelectorWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KmpDropFeatureSelectorWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // com.larus.uaigc.creation.e
    public int getMultiItemType() {
        return 0;
    }

    public final void Z5() {
        cq8.k r100 = this.f373355h;
        if (r100 != null) goto L5;
        return;
    L5:
        com.larus.bmhome.actionbar.model.h r101 = this.f373359l;
        if (r101 == null) goto L16;
        List<w> r102 = r101.f295167e;
        if (r102 == null) goto L17;
        List<w> r103 = r102;
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r103, 10));
        Iterator<T> r105 = r103.iterator();
    L11:
        if (r105.hasNext() == false) goto L13;
        r104.add(w.a((w) r105.next(), null, null, null, null, null, null, 8388607));
        goto L11
    L13:
        r100.f464863d.a(new cq8.j(r100.f464862c, r104));
        return;
    L17:
        return;
    }

    @Override // com.larus.uaigc.creation.e
    public String getButtonName() {
        com.larus.bmhome.actionbar.model.h r100 = getCurrentBindData();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f295165c;
    }

    @Override // com.larus.uaigc.creation.e
    public Integer getImageEditFunctionId() {
        com.larus.bmhome.actionbar.model.h r100 = getCurrentBindData();
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.f295164b;
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        CoroutineScopeKt.cancel$default(this.f373358k, null, 1, null);
    }

    private final com.larus.bmhome.actionbar.model.h getCurrentBindData() {
        return this.f373359l;
    }

    public static final /* synthetic */ com.larus.bmhome.actionbar.model.h Y5(KmpDropFeatureSelectorWidget r100) {
        return r100.getCurrentBindData();
    }

    @Override // com.larus.bmhome.instruction.kmp.b
    public final void L4(com.larus.bmhome.view.actionbar.edit.c r100) {
        this.f373357j = r100;
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r210) {
        Intrinsics.checkNotNullParameter(r210, "descriptor");
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r100 = null;
        if ((r210 instanceof cq8.k) == false) goto L5;
        cq8.k r101 = (cq8.k) r210;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        this.f373355h = r101;
        if (this.f373356i == true) goto L92;
        this.f373356i = true;
        com.larus.bmhome.actionbar.model.h r102 = r101.f464865f;
        if (r102 == null) goto L20;
        List<w> r103 = r102.f295167e;
        if (r103 == null) goto L18;
        List<w> r104 = r103;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L16:
        if (r106.hasNext() == false) goto L19;
        r105.add(w.a((w) r106.next(), null, null, null, null, null, null, 8388607));
    L19:
        com.larus.bmhome.actionbar.model.h r107 = com.larus.bmhome.actionbar.model.h.a(r102, null, null, null, r105, null, null, 4079);
    L21:
        this.f373359l = r107;
        BuildersKt.launch$default(this.f373358k, null, null, new KmpDropFeatureSelectorWidget$bindObservers$1(this, null), 3, null);
        BuildersKt.launch$default(this.f373358k, null, null, new KmpDropFeatureSelectorWidget$bindObservers$2(this, null), 3, null);
        BuildersKt.launch$default(this.f373358k, null, null, new KmpDropFeatureSelectorWidget$bindObservers$3(this, null), 3, null);
        BuildersKt.launch$default(this.f373358k, null, null, new KmpDropFeatureSelectorWidget$bindObservers$4(this, null), 3, null);
        cq8.k r108 = this.f373355h;
        if (r108 == null) goto L24;
        String r109 = r108.f464866g;
    L26:
        if (o0.d(r109) == false) goto L34;
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r110 = this.f373353f;
        if (r110 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L30:
        r110.f373196d.setText(r109);
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r111 = this.f373353f;
        if (r111 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L33:
        e1.x(r111.f373196d);
    L34:
        com.larus.bmhome.actionbar.model.h r112 = getCurrentBindData();
        if (r112 == null) goto L43;
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r113 = this.f373353f;
        if (r113 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r113 = null;
    L39:
        r113.f373197e.setText(r112.f295165c);
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r114 = this.f373353f;
        if (r114 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r114 = null;
    L42:
        e1.x(r114.f373197e);
    L43:
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r115 = this.f373353f;
        if (r115 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r115 = null;
    L46:
        e1.d(r115.f373195c, new com.larus.uaigc.instruction.kmp.a(this));
        DropFeatureSelectorFragment r116 = new DropFeatureSelectorFragment();
        com.larus.bmhome.actionbar.model.h r117 = getCurrentBindData();
        if (r117 == null) goto L49;
        b r118 = this.f373360m;
        Intrinsics.checkNotNullParameter(r117, "currentBindData");
        Intrinsics.checkNotNullParameter(r118, "dropFeatureSelectorCallback");
        r116.f373298g = r117;
        r116.f373299h = r118;
    L49:
        this.f373354g = r116;
        com.larus.bmhome.actionbar.model.h r119 = getCurrentBindData();
        if (r119 == null) goto L67;
        List<w> r120 = r119.f295167e;
        if (r120 == null) goto L67;
        Iterator<T> r121 = r120.iterator();
    L55:
        if (r121.hasNext() == false) goto L65;
        Object r122 = r121.next();
        Integer r123 = ((w) r122).f295528s;
        if (r123 != null) goto L60;
    L62:
        boolean r124 = false;
    L63:
        if (r124 == false) goto L55;
    L66:
        w r125 = (w) r122;
    L68:
        if (r125 == null) goto L77;
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r126 = this.f373353f;
        if (r126 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r126 = null;
    L72:
        e1.x(r126.f373198f);
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r127 = this.f373353f;
        if (r127 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L76:
        r100.f373198f.setText(r125.f295511b);
    L82:
        com.larus.bmhome.view.actionbar.edit.c r128 = this.f373357j;
        if (r128 == null) goto L93;
        r128.onComponentVisibilityChanged(this, true);
        return;
    L93:
        return;
    L75:
        r100 = r127;
        goto L76
    L77:
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r129 = this.f373353f;
        if (r129 != null) goto L80;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L81:
        e1.o(r100.f373198f);
        goto L82
    L80:
        r100 = r129;
        goto L81
    L60:
        if (r123.intValue() != 1) goto L62;
        r124 = true;
        goto L63
    L65:
        r122 = null;
    L67:
        r125 = null;
        goto L68
    L24:
        r109 = null;
        goto L26
    L18:
        r105 = null;
        goto L19
    L20:
        r107 = null;
        goto L21
    L92:
        return;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f373353f = LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding.a(LayoutInflater.from(r100), this);
    }

    public KmpDropFeatureSelectorWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f373358k = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
        this.f373360m = new b(this);
        this.f373361n = new com.larus.uaigc.instruction.kmp.b(this);
    }

    public static Unit V5(KmpDropFeatureSelectorWidget r110, TemplateInfo$TemplateInfo r111, Uri r112) {
        Intrinsics.checkNotNullParameter(r111, "templateInfo");
        com.larus.bmhome.actionbar.model.h r100 = r110.getCurrentBindData();
        String r101 = null;
        if (r100 == null) goto L20;
        List<w> r102 = r100.f295167e;
        if (r102 == null) goto L20;
        Iterator<T> r103 = r102.iterator();
    L8:
        if (r103.hasNext() == false) goto L18;
        Object r104 = r103.next();
        Long r105 = ((w) r104).f295510a;
        long r106 = r111.f365423h;
        if (r105 != null) goto L13;
    L15:
        boolean r107 = false;
    L16:
        if (r107 == false) goto L8;
    L19:
        w r108 = (w) r104;
    L21:
        if (r108 == null) goto L43;
        com.larus.bmhome.actionbar.model.h r109 = r110.getCurrentBindData();
        if (r109 == null) goto L36;
        List<w> r113 = r109.f295167e;
        if (r113 == null) goto L36;
        Iterator<T> r114 = r113.iterator();
    L28:
        if (r114.hasNext() == false) goto L36;
        w r115 = (w) r114.next();
        Long r116 = r115.f295510a;
        long r117 = r111.f365423h;
        if (r116 == null) goto L35;
        if (r116.longValue() != r117) goto L35;
        r115.f295528s = 1;
    L35:
        r115.f295528s = 0;
    L36:
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r118 = r110.f373353f;
        if (r118 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r118 = null;
    L39:
        e1.x(r118.f373198f);
        LarusLayoutActionBarEditorWidgetDropFeatureSelectorBinding r119 = r110.f373353f;
        if (r119 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r119 = null;
    L42:
        r119.f373198f.setText(r108.f295511b);
    L43:
        Fragment r120 = r110.getFragment();
        if (r120 == null) goto L69;
        Bundle r121 = r120.getArguments();
        if (r121 == null) goto L69;
        UserCreation r122 = r111.f365425j;
        Pair[] r123 = new Pair[6];
        if (r122 == null) goto L50;
        String r124 = r122.f364987a;
    L51:
        r123[0] = TuplesKt.to("from_template_id", r124);
        if (r122 == null) goto L54;
        String r125 = zp9.d.d(r122);
    L55:
        r123[1] = TuplesKt.to("from_template_type", r125);
        if (r122 == null) goto L60;
        UserCreationTrackParams r126 = r122.f365000n;
        if (r126 == null) goto L60;
        String r127 = r126.f365040a;
    L61:
        r123[2] = TuplesKt.to("template_rec_req_id", r127);
        if (r122 == null) goto L64;
        String r128 = zp9.d.b(r122);
    L65:
        r123[3] = TuplesKt.to("from_template_source", r128);
        r123[4] = TuplesKt.to("is_from_template", "1");
        if (r122 == null) goto L68;
        r101 = r122.f364995i;
    L68:
        r123[5] = TuplesKt.to("template_rec_extra", r101);
        r121.putParcelable("actionbar_instruction_send_message_track_ext_map", new ICoreInputAbility.SendMessageTrackExtMap(MapsKt.mapOf(r123)));
        goto L69
    L64:
        r128 = null;
    L60:
        r127 = null;
        goto L61
    L54:
        r125 = null;
        goto L55
    L50:
        r124 = null;
    L69:
        com.larus.bmhome.actionbar.model.h r129 = r110.getCurrentBindData();
        if (r129 == null) goto L76;
        List<w> r130 = r129.f295167e;
        if (r130 == null) goto L76;
        DropFeatureSelectorFragment r131 = r110.f373354g;
        if (r131 == null) goto L76;
        int r132 = DropFeatureSelectorFragment.f373294l;
        r131.S90(r130, true);
    L76:
        r110.Z5();
        com.larus.bmhome.view.actionbar.edit.c r133 = r110.f373357j;
        if (r133 == null) goto L80;
        r133.onInstructionImageTemplateSelected(r111, r112);
    L80:
        return Unit.INSTANCE;
    L13:
        if (r105.longValue() != r106) goto L15;
        r107 = true;
        goto L16
    L18:
        r104 = null;
    L20:
        r108 = null;
        goto L21
    }

    public /* synthetic */ KmpDropFeatureSelectorWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
