package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import bt8.u;
import bt8.v;
import bt8.x;
import bt8.y;
import com.larus.bmhome.actionbar.model.h;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.view.actionbar.edit.component.DropdownItemAdapter;
import com.larus.bmhome.view.actionbar.edit.component.b1;
import com.larus.bmhome.view.actionbar.edit.kmp.p;
import com.larus.bmhome.view.screenmenu.d;
import com.larus.doc.sdk.api.VoiceInputFrom;
import com.larus.instruction.impl.databinding.LarusItemActionbarDropdownListBinding;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.skydoves.balloon.Balloon;
import com.ss.android.lark.utils.statistics.PerfLog;
import cq8.a0;
import cq8.n;
import cq8.o;
import cq8.z;
import cq8.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;
import v19.c7;
import v19.i5;
import v19.y6;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u009f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001.\u0018\u0000 P2\u00060\u0001j\u0002`\u0002:\u0001PB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u00100\u001a\u0002012\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u00102\u001a\u0002012\u0006\u0010 \u001a\u000203H\u0014J\u000e\u00104\u001a\u0002012\u0006\u0010 \u001a\u00020!J\b\u00105\u001a\u000201H\u0002J\u0017\u00106\u001a\u0002012\b\u00107\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u00108J\b\u00109\u001a\u000201H\u0002J\b\u0010:\u001a\u000201H\u0002J$\u0010;\u001a\u0002012\f\u0010<\u001a\b\u0012\u0004\u0012\u00020%0$2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020%0$H\u0002J\b\u0010>\u001a\u000201H\u0002J\u0018\u0010?\u001a\u0002012\u0006\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020\bH\u0002J \u0010B\u001a\u0002012\u0006\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020\b2\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u0002012\u0006\u0010F\u001a\u00020GH\u0002J\u0010\u0010H\u001a\u0002012\u0006\u0010F\u001a\u00020GH\u0002J\b\u0010I\u001a\u00020DH\u0002J\b\u0010J\u001a\u00020KH\u0002J\u0018\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020G2\u0006\u0010A\u001a\u00020\bH\u0002J\u0010\u0010N\u001a\u00020\b2\u0006\u0010M\u001a\u00020GH\u0002J\u0019\u00107\u001a\u0004\u0018\u00010\u0010*\b\u0012\u0004\u0012\u00020%0$H\u0002¢\u0006\u0002\u0010OR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001a\u001a\u0004\b\u001d\u0010\u001eR\u0010\u0010 \u001a\u0004\u0018\u00010!X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010(\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0004\n\u0002\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0004\n\u0002\u0010/¨\u0006Q"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpDropdownSelectorWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/AbsKmpInstructionWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/instruction/impl/databinding/LarusItemActionbarDropdownListBinding;", "balloon", "Lcom/skydoves/balloon/Balloon;", "dismissTimeMs", "", "spinnerLocation", "", "displayFrame", "Landroid/graphics/Rect;", "popupView", "Landroid/view/View;", "getPopupView", "()Landroid/view/View;", "popupView$delegate", "Lkotlin/Lazy;", "popupList", "Landroidx/recyclerview/widget/RecyclerView;", "getPopupList", "()Landroidx/recyclerview/widget/RecyclerView;", "popupList$delegate", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/DropdownSelectorDescriptor;", "dropdownBoxId", "optionList", "", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "buttonShowReported", "", "pendingOriginalSelection", "Ljava/lang/Long;", "popupItemAdapter", "Lcom/larus/bmhome/view/actionbar/edit/component/DropdownItemAdapter;", "popupTrackingBound", "itemSelectedCallback", "com/larus/bmhome/view/actionbar/edit/kmp/widget/KmpDropdownSelectorWidget$itemSelectedCallback$1", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpDropdownSelectorWidget$itemSelectedCallback$1;", "init", "", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "bind", "showPopupIfNeeded", "applySelection", "selectedOptionId", "(Ljava/lang/Long;)V", "renderSelectedText", "ensurePopupTracking", "reportDescriptorDrivenSelectionChange", "previousOptionList", "newOptionList", "consumePendingOriginalSelectionIfNeeded", "reportOptionShow", "option", "optionPosition", "reportOptionClick", "optionSource", "", "trackButtonShow", "data", "Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "trackButtonClick", "currentPageForTrace", "buildMusicAppletOptionParams", "Lorg/json/JSONObject;", "calculateIsDefault", "dropdown", "calculateIsChooseRequired", "(Ljava/util/List;)Ljava/lang/Long;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpDropdownSelectorWidget extends AbsKmpInstructionWidget {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public static final /* synthetic */ int f316633u = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusItemActionbarDropdownListBinding f316634f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Balloon f316635g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f316636h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int[] f316637i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Rect f316638j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Lazy f316639k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f316640l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public o f316641m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f316642n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public List<w> f316643o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f316644p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public Long f316645q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public DropdownItemAdapter f316646r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f316647s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final b f316648t;

    public static final class a {
    }

    public static final class b implements b1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KmpDropdownSelectorWidget f316649a;

        public b(KmpDropdownSelectorWidget r100) {
            this.f316649a = r100;
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void b(int r100, w r101) {
            Intrinsics.checkNotNullParameter(r101, "selectedSpinnerItem");
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final void a(int r100, w r110, int r111) {
            Intrinsics.checkNotNullParameter(r110, "selectedSpinnerItem");
            Long r101 = r110.f295510a;
            if (r101 == null) goto L5;
            long r102 = r101.longValue();
        L6:
            FLogger.f375446a.i("KmpDropdownSelectorWidget", "[onItemSelected] selectedDropdownId:" + r100 + ", selectedId:" + r102);
            Iterator<w> r103 = this.f316649a.f316643o.iterator();
            boolean r104 = false;
            int r105 = 0;
        L8:
            if (r103.hasNext() == false) goto L19;
            Long r106 = r103.next().f295510a;
            if (r106 != null) goto L13;
        L15:
            boolean r107 = false;
        L16:
            if (r107 == true) goto L20;
            r105 = r105 + 1;
        L20:
            Integer r108 = Integer.valueOf(r105);
            if (r108.intValue() < 0) goto L23;
            r104 = true;
        L23:
            if (r104 == true) goto L26;
            r108 = null;
        L26:
            if (r108 == null) goto L28;
            r111 = r108.intValue();
        L28:
            this.f316649a.f316645q = Long.valueOf(r102);
            this.f316649a.n6(r110, r111, "original");
            Balloon r109 = this.f316649a.f316635g;
            if (r109 == null) goto L31;
            r109.h();
        L31:
            o r112 = this.f316649a.f316641m;
            if (r112 == null) goto L39;
            z r113 = r112.f464907d;
            if (r113 == null) goto L39;
            String r114 = r112.f464906c;
            if (r114 != null) goto L38;
            r114 = "";
        L38:
            r113.a(new n(r114, r102));
        L39:
            this.f316649a.b6(Long.valueOf(r102));
            return;
        L13:
            if (r106.longValue() != r102) goto L15;
            r107 = true;
            goto L16
        L19:
            r105 = -1;
            goto L20
        L5:
            r102 = 0;
            goto L6
        }

        @Override // com.larus.bmhome.view.actionbar.edit.component.b1
        public final boolean c(int r100, w r101, int r102) {
            Intrinsics.checkNotNullParameter(r101, "selectedSpinnerItem");
            return false;
        }
    }

    static {
    }

    public KmpDropdownSelectorWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KmpDropdownSelectorWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final RecyclerView getPopupList() {
        return (RecyclerView) this.f316640l.getValue();
    }

    private final View getPopupView() {
        return (View) this.f316639k.getValue();
    }

    public final void k6() {
        Iterator<T> r100 = this.f316643o.iterator();
    L3:
        LarusItemActionbarDropdownListBinding r101 = null;
        if (r100.hasNext() == false) goto L14;
        Object r102 = r100.next();
        Integer r103 = ((w) r102).f295528s;
        if (r103 == null) goto L11;
        boolean r104 = true;
        if (r103.intValue() != 1) goto L11;
    L12:
        if (r104 == false) goto L3;
    L15:
        w r105 = (w) r102;
        if (r105 != null) goto L22;
        LarusItemActionbarDropdownListBinding r106 = this.f316634f;
        if (r106 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L21:
        e1.o(r101.f351550d);
        return;
    L20:
        r101 = r106;
        goto L21
    L22:
        LarusItemActionbarDropdownListBinding r107 = this.f316634f;
        if (r107 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L25:
        AppCompatTextView r108 = r107.f351550d;
        String r109 = r105.b();
        if (r109 != null) goto L28;
        r109 = "";
    L28:
        r108.setText(r109);
        LarusItemActionbarDropdownListBinding r110 = this.f316634f;
        if (r110 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L32:
        e1.x(r101.f351550d);
        return;
    L31:
        r101 = r110;
    L11:
        r104 = false;
        goto L12
    L14:
        r102 = null;
        goto L15
    }

    public final JSONObject c6() {
        if (p.a(getVContext()) == false) goto L5;
        Fragment r100 = getFragment();
        String r101 = null;
        if (r100 == null) goto L9;
        Bundle r102 = r100.getArguments();
    L10:
        JSONObject r103 = new JSONObject();
        r103.put("app_enter_method", VoiceInputFrom.ACTION_BAR);
        if (r102 == null) goto L14;
        String r104 = r102.getString(com.bytedance.android.ec.core.event.a.KEY_FROM_ENTRANCE);
        if (r104 == null) goto L14;
    L15:
        r103.put(com.bytedance.android.ec.core.event.a.KEY_FROM_ENTRANCE, r104);
        if (r102 == null) goto L19;
        String r105 = r102.getString("app_key");
        if (r105 == null) goto L19;
    L20:
        r103.put("app_key", r105);
        if (r102 == null) goto L24;
        String r106 = r102.getString("app_name");
        if (r106 == null) goto L24;
    L25:
        r103.put("app_name", r106);
        if (r102 == null) goto L34;
        String r107 = r102.getString(MusicAppletPage.KEY_MESSAGE_ID);
        if (r107 == null) goto L34;
        if ((!StringsKt.isBlank(r107)) == false) goto L32;
        r101 = r107;
    L32:
        if (r101 == null) goto L34;
        r103.put("doubao_apps_message_id", r101);
    L34:
        return r103;
    L24:
        r106 = "AI 写歌";
    L19:
        r105 = MusicAppletPage.APP_ID;
    L14:
        r104 = "self";
        goto L15
    L9:
        r102 = null;
        goto L10
    L5:
        return new JSONObject();
    }

    public final String i6() {
        if (p.a(getVContext()) == false) goto L5;
        return "template_page";
    L5:
        return "chat";
    }

    public static RecyclerView Y5(KmpDropdownSelectorWidget r100) {
        return (RecyclerView) r100.getPopupView().findViewById(R.id.pop_list);
    }

    public static Unit Z5(KmpDropdownSelectorWidget r100) {
        r100.f316636h = SystemClock.elapsedRealtime();
        y6.i(r100.getPopupList());
        return Unit.INSTANCE;
    }

    public static Long o6(List r100) {
        Iterator r101 = r100.iterator();
    L4:
        if (r101.hasNext() == false) goto L14;
        Object r102 = r101.next();
        Integer r103 = ((w) r102).f295528s;
        if (r103 == null) goto L11;
        boolean r104 = true;
        if (r103.intValue() != 1) goto L11;
    L12:
        if (r104 == false) goto L4;
    L15:
        w r105 = (w) r102;
        if (r105 != null) goto L18;
        return null;
    L18:
        return r105.f295510a;
    L11:
        r104 = false;
        goto L12
    L14:
        r102 = null;
        goto L15
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v0 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.util.List, java.util.List<com.larus.bmhome.actionbar.model.w>] */
    /* JADX WARN: Type inference failed for: r6v20, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r6v21, types: [java.util.ArrayList] */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r310) {
        a0 r100 = r310;
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        FLogger.f375446a.i("KmpDropdownSelectorWidget", "[onDescriptorChanged] descriptor:" + r100);
        if ((r100 instanceof o) == true) goto L5;
        r100 = null;
    L5:
        o r101 = (o) r100;
        if (r101 == null) goto L112;
        Intrinsics.checkNotNullParameter(r101, "descriptor");
        List<w> r102 = this.f316643o;
        this.f316641m = r101;
        h r103 = r101.f464909f;
        if (r103 == null) goto L13;
        Integer r104 = r103.f295164b;
        if (r104 == null) goto L13;
        int r105 = r104.intValue();
    L14:
        this.f316642n = r105;
        h r106 = r101.f464909f;
        if (r106 == null) goto L22;
        List<w> r107 = r106.f295167e;
        if (r107 == null) goto L22;
        List<w> r108 = r107;
        ?? r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator r110 = r108.iterator();
    L20:
        if (r110.hasNext() == false) goto L23;
        r109.add(w.a((w) r110.next(), null, null, null, null, null, null, 8388607));
    L23:
        if (r109 != 0) goto L26;
        r109 = CollectionsKt.emptyList();
    L26:
        if (r102.isEmpty() == false) goto L28;
    L51:
        this.f316643o = r109;
        LarusItemActionbarDropdownListBinding r111 = this.f316634f;
        if (r111 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r111 = null;
    L54:
        AppCompatTextView r112 = r111.f351549c;
        h r113 = r101.f464909f;
        if (r113 == null) goto L57;
        String r114 = r113.f295165c;
    L58:
        if (r114 != null) goto L60;
        r114 = "";
    L60:
        r112.setText(r114);
        LarusItemActionbarDropdownListBinding r115 = this.f316634f;
        if (r115 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r115 = null;
    L63:
        e1.x(r115.f351549c);
        h r116 = r101.f464909f;
        if (r116 != null) goto L66;
    L74:
        Long r117 = r101.f464911h;
        if (r117 != null) goto L93;
        Iterator r118 = this.f316643o.iterator();
    L78:
        if (r118.hasNext() == false) goto L88;
        Object r119 = r118.next();
        Integer r120 = ((w) r119).f295528s;
        if (r120 != null) goto L83;
    L85:
        boolean r121 = false;
    L86:
        if (r121 == false) goto L78;
    L89:
        w r122 = (w) r119;
        if (r122 == null) goto L92;
        r117 = r122.f295510a;
        goto L93
    L92:
        r117 = null;
        goto L93
    L83:
        if (r120.intValue() != 1) goto L85;
        r121 = true;
        goto L86
    L88:
        r119 = null;
    L93:
        b6(r117);
        Long r123 = this.f316645q;
        if (r123 == null) goto L110;
        long r124 = r123.longValue();
        Long r125 = o6(this.f316643o);
        if (r125 != null) goto L99;
        return;
    L99:
        if (r125.longValue() != r124) goto L111;
        this.f316645q = null;
        return;
    L111:
        return;
    L110:
        return;
    L66:
        if (this.f316644p == true) goto L74;
        this.f316644p = true;
        o r126 = this.f316641m;
        if (r126 == null) goto L74;
        z0 r127 = r126.f464912i;
        if (r127 == null) goto L74;
        String r128 = r127.f465007a;
        String r129 = r127.f465009c;
        String r210 = i6();
        String r130 = r127.f465010d;
        String r131 = r127.f465012f;
        String r132 = r127.f465013g;
        String r133 = r116.f295165c;
        String r134 = String.valueOf(r116.f295164b);
        int r135 = !Intrinsics.areEqual(r116.f295170h, Boolean.TRUE) ? 1 : 0;
        String r136 = r127.f465014h;
        Boolean r137 = r127.f465015i;
        tx9.b.f(r128, r129, r130, r131, r132, null, null, r133, r134, 0, Integer.valueOf(r135), null, null, null, c6(), "chat", null, null, null, r210, r136, r137, 964704);
        goto L74
    L57:
        r114 = null;
        goto L58
    L28:
        if (r109.isEmpty() == true) goto L51;
        Long r138 = o6(r102);
        Long r139 = o6(r109);
        if (Intrinsics.areEqual(r138, r139) == true) goto L51;
        if (r139 == null) goto L51;
        if (Intrinsics.areEqual(this.f316645q, r139) == true) goto L51;
        Iterator r140 = r109.iterator();
        int r141 = 0;
    L39:
        if (r140.hasNext() == false) goto L44;
        if (Intrinsics.areEqual(((w) r140.next()).f295510a, r139) == true) goto L45;
        r141 = r141 + 1;
    L45:
        if (r141 < 0) goto L51;
        w r142 = (w) CollectionsKt.getOrNull(r109, r141);
        if (r142 == null) goto L51;
        n6(r142, r141, "use_template");
        goto L51
    L44:
        r141 = -1;
    L22:
        r109 = 0;
    L13:
        r105 = 0;
        goto L14
    }

    public final void b6(Long r110) {
        if (r110 != null) goto L5;
        k6();
        return;
    L5:
        List<w> r100 = this.f316643o;
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        w r103 = (w) r102.next();
        r101.add(w.a(r103, null, null, Integer.valueOf(Intrinsics.areEqual(r103.f295510a, r110) ? 1 : 0), null, null, null, 8126463));
        goto L7
    L9:
        this.f316643o = r101;
        k6();
    }

    public static Unit V5(final KmpDropdownSelectorWidget r410, ConstraintLayout r411) {
        Intrinsics.checkNotNullParameter(r411, "it");
        if (r410.f316643o.isEmpty() == true) goto L57;
        if ((SystemClock.elapsedRealtime() - r410.f316636h) <= 500) goto L57;
        DropdownItemAdapter r100 = new DropdownItemAdapter(Integer.valueOf(r410.f316642n), r410.f316648t, null);
        r410.f316646r = r100;
        r410.getPopupList().setAdapter(r100);
        if (r410.f316647s == true) goto L12;
        r410.f316647s = true;
        y6.d(r410.getPopupList(), new bt8.z(r410), null, null, new bt8.a0(r410), 13);
    L12:
        r100.submitList(r410.f316643o);
        Iterator<w> r101 = r410.f316643o.iterator();
        int r102 = 0;
    L14:
        if (r101.hasNext() == false) goto L25;
        Integer r103 = r101.next().f295528s;
        if (r103 != null) goto L19;
    L21:
        boolean r104 = false;
    L22:
        if (r104 == true) goto L26;
        r102 = r102 + 1;
    L26:
        if (r102 < 0) goto L28;
        r410.getPopupList().scrollToPosition(r102);
    L28:
        r410.getLocationOnScreen(r410.f316637i);
        r410.getRootView().getWindowVisibleDisplayFrame(r410.f316638j);
        int r105 = r410.f316643o.size() * i5.d0();
        Rect r106 = r410.f316638j;
        int r107 = (r106.bottom - r106.top) - i5.d0();
        int r108 = r410.f316638j.bottom - r410.f316637i[1];
        if (r105 >= r107) goto L31;
        Integer r109 = null;
    L32:
        final boolean r110 = p.a(r410.getVContext());
        d r111 = d.f317270a;
        LarusItemActionbarDropdownListBinding r112 = r410.f316634f;
        if (r112 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r112 = null;
    L35:
        ConstraintLayout r113 = r112.f351547a;
        View r114 = r410.getPopupView();
        if (r109 == null) goto L38;
        int r115 = r108;
    L40:
        if (r109 != null) goto L42;
    L47:
        Integer r116 = null;
    L48:
        r410.f316635g = r111.f(r113, r114, r115, false, r116, new x(r110), new y(r410));
        o r117 = r410.f316641m;
        if (r117 == null) goto L57;
        h r118 = r117.f464909f;
        if (r118 == null) goto L57;
        z0 r119 = r117.f464912i;
        if (r119 == null) goto L57;
        String r120 = r119.f465007a;
        String r121 = r119.f465009c;
        String r210 = r410.i6();
        String r122 = r119.f465010d;
        String r123 = r119.f465012f;
        String r124 = r119.f465013g;
        String r125 = r118.f295165c;
        String r126 = String.valueOf(r118.f295164b);
        int r127 = 1 ^ (Intrinsics.areEqual(r118.f295170h, Boolean.TRUE) ? 1 : 0);
        String r128 = r119.f465014h;
        Boolean r129 = r119.f465015i;
        tx9.b.e(r120, r121, r122, r123, r124, null, null, r125, r126, 0, Integer.valueOf(r127), null, "select", null, null, null, r410.c6(), null, "chat", null, null, null, r210, r128, r129, null, null, null, null, null, null, null, null, null, null, null, null, -59316128, 127);
        goto L57
    L42:
        if (r109.intValue() <= 0) goto L44;
        boolean r130 = true;
    L45:
        if (r130 == false) goto L47;
        r116 = r109;
        goto L48
    L44:
        r130 = false;
        goto L45
    L38:
        r115 = 0;
        goto L40
    L31:
        r109 = Integer.valueOf((int) c7.d(Integer.valueOf(r107)));
        goto L32
    L19:
        if (r103.intValue() != 1) goto L21;
        r104 = true;
        goto L22
    L25:
        r102 = -1;
    L57:
        return Unit.INSTANCE;
    }

    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        LarusItemActionbarDropdownListBinding r102 = LarusItemActionbarDropdownListBinding.b(LayoutInflater.from(r100), this, true);
        this.f316634f = r102;
        e1.d(r102.f351547a, new u(this));
    }

    public KmpDropdownSelectorWidget(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f316637i = new int[2];
        this.f316638j = new Rect();
        LazyThreadSafetyMode r103 = LazyThreadSafetyMode.NONE;
        this.f316639k = LazyKt.lazy(r103, new v(r100));
        this.f316640l = LazyKt.lazy(r103, new bt8.w(this));
        this.f316643o = CollectionsKt.emptyList();
        this.f316648t = new b(this);
    }

    public final void n6(w r410, int r411, String r412) {
        o r100 = this.f316641m;
        if (r100 != null) goto L5;
        return;
    L5:
        h r101 = r100.f464909f;
        if (r101 != null) goto L8;
        return;
    L8:
        z0 r102 = r100.f464912i;
        String r103 = r102.f465007a;
        String r104 = r102.f465009c;
        String r210 = i6();
        String r105 = r102.f465010d;
        String r106 = r102.f465012f;
        String r107 = r102.f465013g;
        String r110 = r102.f465016j;
        String r111 = r101.f295165c;
        String r112 = r410.f295511b;
        String r113 = String.valueOf(r410.f295510a);
        Boolean r108 = r101.f295170h;
        Boolean r114 = Boolean.TRUE;
        int r115 = 0;
        if (Intrinsics.areEqual(r108, r114) == true) goto L17;
        Integer r109 = r101.f295168f;
        if (r109 == null) goto L17;
        if (r109.intValue() != r411) goto L17;
        r115 = 1;
    L17:
        int r116 = !Intrinsics.areEqual(r101.f295170h, r114) ? 1 : 0;
        String r117 = r102.f465014h;
        Boolean r118 = r102.f465015i;
        JSONObject r211 = c6();
        tx9.b.e(r103, r104, r105, r106, r107, r110, r111, r112, r113, Integer.valueOf(r115), Integer.valueOf(r116), Integer.valueOf(r411 + 1), "select", null, null, null, r211, r412, "chat", null, null, null, r210, r117, r118, null, null, null, null, null, null, null, null, null, null, null, null, -59580416, 127);
    }

    public /* synthetic */ KmpDropdownSelectorWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
