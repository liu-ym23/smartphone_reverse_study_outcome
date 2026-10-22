package com.larus.uaigc.music.template.kmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.bmhome.actionbar.model.d0;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.uaigc.impl.databinding.LarusItemActionbarImageTemplateCoverHolderBinding;
import com.larus.uaigc.impl.databinding.LarusLayoutActionBarEditorWidgetImageSelectorBinding;
import com.larus.uaigc.instruction.widget.ImageSelectorWidgetAdapter;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import cq8.a0;
import cq8.m0;
import cq8.o0;
import cq8.z;
import cq8.z0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import v19.y6;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000o\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0016\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014J\u0010\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u001bH\u0014J\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u001f\u001a\u00020\u0019H\u0002J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0002J\u0018\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\n\u0010(\u001a\u0004\u0018\u00010)H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0017¨\u0006*"}, d2 = {"Lcom/larus/uaigc/music/template/kmp/KmpMusicTemplateSelectorWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/uaigc/impl/databinding/LarusLayoutActionBarEditorWidgetImageSelectorBinding;", "adapter", "Lcom/larus/uaigc/instruction/widget/ImageSelectorWidgetAdapter;", "coverBinding", "Lcom/larus/uaigc/impl/databinding/LarusItemActionbarImageTemplateCoverHolderBinding;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/MusicTemplateSelectorDescriptor;", "localImageList", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "itemClickCallback", "com/larus/uaigc/music/template/kmp/KmpMusicTemplateSelectorWidget$itemClickCallback$1", "Lcom/larus/uaigc/music/template/kmp/KmpMusicTemplateSelectorWidget$itemClickCallback$1;", "init", "", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "bind", "setupAdapter", "renderWidgetChrome", "requestTemplateList", "goToMusicTemplateList", "data", "Lcom/larus/uaigc/music/template/MusicTemplateModel;", "selectMusicTemplateInternal", MapController.ITEM_LAYER_TAG, "Lcom/larus/bmhome/instruction/core/model/music/MusicGenTemplate;", "enterFrom", "", "getScope", "Lkotlinx/coroutines/CoroutineScope;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpMusicTemplateSelectorWidget extends AbsKmpInstructionWidget {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f373787l = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusLayoutActionBarEditorWidgetImageSelectorBinding f373788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ImageSelectorWidgetAdapter f373789g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public LarusItemActionbarImageTemplateCoverHolderBinding f373790h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public o0 f373791i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public List<w> f373792j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final a f373793k;

    public static final class a implements vz9.d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KmpMusicTemplateSelectorWidget f373794a;

        @Override // vz9.d
        public final void b(w r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        }

        public a(KmpMusicTemplateSelectorWidget r100) {
            this.f373794a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1 */
        /* JADX WARN: Type inference failed for: r3v2, types: [int] */
        /* JADX WARN: Type inference failed for: r3v5 */
        @Override // vz9.d
        public final void a(w r410, int r510) {
            Intrinsics.checkNotNullParameter(r410, MapController.ITEM_LAYER_TAG);
            o0 r100 = this.f373794a.f373791i;
            if (r100 != null) goto L5;
            return;
        L5:
            d0 r101 = r100.f464916f;
            if (r101 == null) goto L8;
            ?? r102 = Intrinsics.areEqual(r101.f295061c, Boolean.TRUE);
        L9:
            Iterator r103 = this.f373794a.f373792j.iterator();
        L10:
            Integer r104 = null;
            if (r103.hasNext() == false) goto L15;
            Object r105 = r103.next();
            if (Intrinsics.areEqual(((w) r105).f295510a, r410.f295510a) == false) goto L10;
        L16:
            w r106 = (w) r105;
            if (r106 == null) goto L20;
            r104 = r106.f295528s;
        L20:
            if (r102 != 0) goto L26;
            if (r104 == null) goto L26;
            if (r104.intValue() != 1) goto L26;
            boolean r107 = true;
        L27:
            FLogger.f375446a.i("ImageSelectorWidgetAdapter", "item name:" + r410.f295511b + " isDeselect:" + r107);
            z r108 = r100.f464914d;
            String r109 = r100.f464913c;
            Long r110 = r410.f295510a;
            if (r110 == null) goto L51;
            r108.a(new m0(r109, r110.longValue(), r107));
            if (r100.f464919i == false) goto L32;
            int r111 = r510 - 1;
        L33:
            z0 r112 = r100.f464921k;
            String r113 = r112.f465007a;
            String r114 = r112.f465009c;
            String r115 = r112.f465010d;
            String r116 = r112.f465012f;
            String r117 = r112.f465013g;
            String r118 = r112.f465016j;
            String r119 = r410.f295511b;
            String r120 = String.valueOf(r410.f295510a);
            d0 r121 = r100.f464916f;
            if (r121 == null) goto L41;
            Integer r122 = r121.f295060b;
            if (r122 == null) goto L41;
            if (r111 != r122.intValue()) goto L41;
            int r123 = 1;
        L42:
            Integer r124 = Integer.valueOf(r123);
            Integer r125 = Integer.valueOf(r102);
            Integer r210 = Integer.valueOf(r510 + 1);
            if (r107 == true) goto L45;
            String r126 = "select";
        L46:
            tx9.b.e(r113, r114, r115, r116, r117, r118, null, r119, r120, r124, r125, r210, r126, null, null, null, null, "original", null, null, null, null, null, null, r112.f465015i, null, null, null, null, null, null, null, null, null, null, null, null, -33824704, 127);
            return;
        L45:
            r126 = "cancel";
        L41:
            r123 = 0;
            goto L42
        L32:
            r111 = r510;
            goto L33
        L51:
            return;
        L26:
            r107 = false;
            goto L27
        L15:
            r105 = null;
            goto L16
        L8:
            r102 = 0;
            goto L9
        }
    }

    public KmpMusicTemplateSelectorWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KmpMusicTemplateSelectorWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final CoroutineScope getScope() {
        return CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
    }

    public final void V5() {
        CoroutineScope r100 = getScope();
        if (r100 != null) goto L5;
        return;
    L5:
        BuildersKt.launch$default(r100, null, null, new KmpMusicTemplateSelectorWidget$requestTemplateList$1(this, r100, null), 3, null);
    }

    private final void setupAdapter(final o0 r110) {
        LarusLayoutActionBarEditorWidgetImageSelectorBinding r100 = null;
        if (r110.f464919i == false) goto L5;
        this.f373789g = new ImageSelectorWidgetAdapter(this.f373793k, new com.larus.uaigc.music.template.kmp.a(this));
    L6:
        LarusLayoutActionBarEditorWidgetImageSelectorBinding r101 = this.f373788f;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r101 = null;
    L9:
        y6.d(r101.f373201c, null, null, null, new b(r110, this), 15);
        LarusLayoutActionBarEditorWidgetImageSelectorBinding r111 = this.f373788f;
        if (r111 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L12:
        r111.f373201c.setAdapter(this.f373789g);
        LarusLayoutActionBarEditorWidgetImageSelectorBinding r112 = this.f373788f;
        if (r112 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L16:
        r100.f373201c.addItemDecoration(new AnonymousClass3());
        return;
    L15:
        r100 = r112;
        goto L16
    L5:
        this.f373789g = new ImageSelectorWidgetAdapter(this.f373793k, null);
        goto L6
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r210) {
        Intrinsics.checkNotNullParameter(r210, "descriptor");
        LarusLayoutActionBarEditorWidgetImageSelectorBinding r100 = null;
        if ((r210 instanceof o0) == false) goto L5;
        o0 r101 = (o0) r210;
    L6:
        if (r101 != null) goto L8;
        return;
    L8:
        Intrinsics.checkNotNullParameter(r101, "descriptor");
        this.f373791i = r101;
        String r102 = r101.f464921k.f465016j;
        if (r102 != null) goto L11;
    L13:
        r102 = null;
    L15:
        if (r102 != null) goto L20;
        LarusLayoutActionBarEditorWidgetImageSelectorBinding r103 = this.f373788f;
        if (r103 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L19:
        e1.o(r103.f373203e);
    L27:
        LarusLayoutActionBarEditorWidgetImageSelectorBinding r104 = this.f373788f;
        if (r104 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r104 = null;
    L30:
        e1.o(r104.f373200b);
        d0 r105 = r101.f464916f;
        if (r105 == null) goto L33;
        List<w> r106 = r105.f295059a;
    L34:
        if (r106 != null) goto L36;
        r106 = CollectionsKt.emptyList();
    L36:
        d0 r107 = r101.f464916f;
        int r108 = -1;
        if (r107 == null) goto L41;
        Integer r109 = r107.f295060b;
        if (r109 == null) goto L41;
        int r110 = r109.intValue();
    L42:
        List<w> r111 = r106;
        if ((r111 instanceof Collection) == true) goto L45;
    L47:
        Iterator<T> r112 = r111.iterator();
    L49:
        if (r112.hasNext() == false) goto L59;
        Integer r113 = ((w) r112.next()).f295528s;
        if (r113 != null) goto L54;
    L56:
        boolean r114 = false;
    L57:
        if (r114 == false) goto L49;
        boolean r115 = true;
    L60:
        ArrayList r116 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r111, 10));
        Iterator<T> r117 = r111.iterator();
        int r118 = 0;
    L62:
        if (r117.hasNext() == false) goto L72;
        Object r119 = r117.next();
        int r120 = r118 + 1;
        if (r118 >= 0) goto L66;
        CollectionsKt.throwIndexOverflow();
    L66:
        w r121 = (w) r119;
        if (r115 == true) goto L70;
        if (r118 != r110) goto L70;
        w r122 = w.a(r121, null, null, 1, null, null, null, 8126463);
    L71:
        r116.add(r122);
        r118 = r120;
    L70:
        r122 = w.a(r121, null, null, null, null, null, null, 8388607);
        goto L71
    L72:
        List<w> r123 = CollectionsKt.toMutableList(r116);
        if (this.f373789g != null) goto L75;
        setupAdapter(r101);
    L75:
        ImageSelectorWidgetAdapter r124 = this.f373789g;
        if (r124 == null) goto L79;
        r124.submitList(r123);
    L79:
        if (r101.f464922l == false) goto L104;
        Iterator<w> r125 = r123.iterator();
        int r126 = 0;
    L82:
        if (r125.hasNext() == false) goto L93;
        Integer r127 = r125.next().f295528s;
        if (r127 != null) goto L87;
    L89:
        boolean r128 = false;
    L90:
        if (r128 == true) goto L91;
        r126 = r126 + 1;
        goto L82
    L91:
        r108 = r126;
        goto L93
    L87:
        if (r127.intValue() != 1) goto L89;
        r128 = true;
    L93:
        if (r108 < 0) goto L104;
        if (r101.f464919i == false) goto L97;
        r108 = r108 + 1;
    L97:
        LarusLayoutActionBarEditorWidgetImageSelectorBinding r129 = this.f373788f;
        if (r129 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L101:
        RecyclerView.LayoutManager r130 = r100.f373201c.getLayoutManager();
        if (r130 == null) goto L104;
        r130.scrollToPosition(r108);
        goto L104
    L100:
        r100 = r129;
    L104:
        this.f373792j = r123;
        return;
    L54:
        if (r113.intValue() != 1) goto L56;
        r114 = true;
    L59:
        r115 = false;
        goto L60
    L45:
        if (r111.isEmpty() == false) goto L47;
    L41:
        r110 = -1;
        goto L42
    L33:
        r106 = null;
        goto L34
    L20:
        LarusLayoutActionBarEditorWidgetImageSelectorBinding r131 = this.f373788f;
        if (r131 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r131 = null;
    L23:
        r131.f373203e.setText(r102);
        LarusLayoutActionBarEditorWidgetImageSelectorBinding r132 = this.f373788f;
        if (r132 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r132 = null;
    L26:
        e1.x(r132.f373203e);
        goto L27
    L11:
        if ((!StringsKt.isBlank(r102)) == false) goto L13;
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f373788f = LarusLayoutActionBarEditorWidgetImageSelectorBinding.a(LayoutInflater.from(r100), this);
    }

    public KmpMusicTemplateSelectorWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f373792j = CollectionsKt.emptyList();
        this.f373793k = new a(this);
    }

    public /* synthetic */ KmpMusicTemplateSelectorWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
