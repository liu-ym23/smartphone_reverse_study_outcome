package com.larus.bmhome.view.actionbar.edit.kmp.widget;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import bt8.q;
import bt8.r;
import bt8.s;
import com.larus.bmhome.actionbar.model.h;
import com.larus.bmhome.actionbar.model.i;
import com.larus.bmhome.actionbar.model.w;
import com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.bmhome.view.actionbar.edit.kmp.p;
import com.larus.doc.sdk.api.VoiceInputFrom;
import com.larus.instruction.impl.databinding.LarusLayoutActionBarEditorWidgetDropdownSelectorBinding;
import com.larus.utils.e1;
import com.ss.android.lark.utils.statistics.PerfLog;
import cq8.a0;
import cq8.m;
import cq8.z0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 >2\u00060\u0001j\u0002`\u0002:\u0004;<=>B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0019H\u0014J\u000e\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\n\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002J \u0010!\u001a\u00020\u00172\b\u0010\"\u001a\u0004\u0018\u00010 2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\u0010\u0010$\u001a\u00020\u00172\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J$\u0010%\u001a\u00020\u00172\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J*\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u00122\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012H\u0002J\b\u0010)\u001a\u00020\u0017H\u0002J \u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\bH\u0002J0\u0010/\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\b2\u0006\u00100\u001a\u00020\b2\u0006\u00101\u001a\u000202H\u0002J\b\u00103\u001a\u000202H\u0002J\b\u00104\u001a\u000205H\u0002J \u00106\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u00132\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\bH\u0002J\u0010\u00107\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0013H\u0002J\u0010\u00108\u001a\u00020\u00132\u0006\u0010+\u001a\u00020\u0013H\u0002J\f\u00109\u001a\u000202*\u00020\u0013H\u0002J\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e*\u00020\u0013H\u0002¢\u0006\u0002\u0010:R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpDropdownListSelectorWidget;", "Lcom/larus/bmhome/instruction/kmp/AbsKmpInstructionWidget;", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/AbsKmpInstructionWidget;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "binding", "Lcom/larus/instruction/impl/databinding/LarusLayoutActionBarEditorWidgetDropdownSelectorBinding;", "adapter", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/DropdownBoxListAdapter;", "descriptor", "Lcom/larus/bmhome/instruction/core/model/widget/DropdownListSelectorDescriptor;", "dropdownBoxList", "", "Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;", "pendingOriginalSelection", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpDropdownListSelectorWidget$PendingSelection;", "init", "", "onDescriptorChanged", "Lcom/larus/bmhome/instruction/core/model/widget/InstructionWidgetDescriptor;", "bind", "applySelection", "dropdownId", "selectedOptionId", "", "captureScrollAnchor", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpDropdownListSelectorWidget$ScrollAnchor;", "restoreScrollAnchor", "scrollAnchor", "newDropdownBoxList", "renderWidgetChrome", "reportDescriptorDrivenSelectionChanges", "previousDropdownBoxList", "findSelectionChanges", "Lcom/larus/bmhome/view/actionbar/edit/kmp/widget/KmpDropdownListSelectorWidget$SelectionChange;", "consumePendingOriginalSelectionIfNeeded", "reportOptionShow", "dropdown", "option", "Lcom/larus/bmhome/actionbar/model/ActionBarInstructionOption;", "optionPosition", "reportOptionClick", "showPosition", "optionSource", "", "currentPageForTrace", "buildMusicAppletOptionParams", "Lorg/json/JSONObject;", "calculateIsDefault", "calculateIsChooseRequired", "deepCopyDropdownBox", "trackKey", "(Lcom/larus/bmhome/actionbar/model/ActionBarDropdownBox;)Ljava/lang/Long;", "PendingSelection", "SelectionChange", "ScrollAnchor", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KmpDropdownListSelectorWidget extends AbsKmpInstructionWidget {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f316618k = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LarusLayoutActionBarEditorWidgetDropdownSelectorBinding f316619f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public DropdownBoxListAdapter f316620g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public m f316621h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public List<h> f316622i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public b f316623j;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f316624a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f316625b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f316624a == r101.f316624a) goto L12;
            return false;
        L12:
            if (this.f316625b == r101.f316625b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f316624a * 31;
            long r101 = this.f316625b;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "PendingSelection(dropdownId=" + this.f316624a + ", optionId=" + this.f316625b + ')';
        }

        public b(int r100, long r101) {
            this.f316624a = r100;
            this.f316625b = r101;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f316626a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f316627b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f316628c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f316626a, r101.f316626a) == true) goto L12;
            return false;
        L12:
            if (this.f316627b == r101.f316627b) goto L15;
            return false;
        L15:
            if (this.f316628c == r101.f316628c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f316626a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (((r101 * 31) + this.f316627b) * 31) + this.f316628c;
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "ScrollAnchor(dropdownKey=" + this.f316626a + ", position=" + this.f316627b + ", offset=" + this.f316628c + ')';
        }

        public c(String r100, int r101, int r102) {
            this.f316626a = r100;
            this.f316627b = r101;
            this.f316628c = r102;
        }
    }

    public static final class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final h f316629a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final w f316630b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f316631c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f316632d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.f316629a, r101.f316629a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f316630b, r101.f316630b) == true) goto L15;
            return false;
        L15:
            if (this.f316631c == r101.f316631c) goto L18;
            return false;
        L18:
            if (this.f316632d == r101.f316632d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f316629a.hashCode() * 31) + this.f316630b.hashCode()) * 31) + this.f316631c) * 31) + this.f316632d;
        }

        public final String toString() {
            return "SelectionChange(dropdown=" + this.f316629a + ", option=" + this.f316630b + ", optionPosition=" + this.f316631c + ", dropdownPosition=" + this.f316632d + ')';
        }

        public d(h r100, w r101, int r102, int r103) {
            Intrinsics.checkNotNullParameter(r100, "dropdown");
            Intrinsics.checkNotNullParameter(r101, "option");
            this.f316629a = r100;
            this.f316630b = r101;
            this.f316631c = r102;
            this.f316632d = r103;
        }
    }

    static {
    }

    public KmpDropdownListSelectorWidget(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public KmpDropdownListSelectorWidget(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    public final c Y5() {
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r100 = this.f316619f;
        String r101 = null;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L5:
        RecyclerView.LayoutManager r102 = r100.f351568c.getLayoutManager();
        if ((r102 instanceof LinearLayoutManager) == false) goto L8;
        LinearLayoutManager r103 = (LinearLayoutManager) r102;
    L9:
        if (r103 != null) goto L11;
        return null;
    L11:
        int r104 = r103.findFirstVisibleItemPosition();
        if (r104 != (-1)) goto L14;
        return null;
    L14:
        View r105 = r103.findViewByPosition(r104);
        if (r105 == null) goto L17;
        int r106 = r105.getLeft();
    L21:
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r107 = this.f316619f;
        if (r107 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r107 = null;
    L24:
        int r108 = r106 - r107.f351568c.getPaddingLeft();
        h r109 = (h) CollectionsKt.getOrNull(this.f316622i, r104);
        if (r109 == null) goto L28;
        r101 = i6(r109);
    L28:
        return new c(r101, r104, r108);
    L17:
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r110 = this.f316619f;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r110 = null;
    L20:
        r106 = r110.f351568c.getPaddingLeft();
        goto L21
    L8:
        r103 = null;
        goto L9
    }

    public final JSONObject V5() {
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

    public static Long c6(h r100) {
        List<w> r101 = r100.f295167e;
        if (r101 != null) goto L5;
        r101 = CollectionsKt.emptyList();
    L5:
        Iterator<T> r102 = r101.iterator();
    L7:
        if (r102.hasNext() == false) goto L17;
        Object r103 = r102.next();
        Integer r104 = ((w) r103).f295528s;
        if (r104 == null) goto L14;
        boolean r105 = true;
        if (r104.intValue() != 1) goto L14;
    L15:
        if (r105 == false) goto L7;
    L18:
        w r106 = (w) r103;
        if (r106 != null) goto L21;
        return null;
    L21:
        return r106.f295510a;
    L14:
        r105 = false;
        goto L15
    L17:
        r103 = null;
        goto L18
    }

    public static String i6(h r100) {
        String r101 = r100.f295163a;
        String r102 = null;
        if (r101 != null) goto L5;
    L12:
        Integer r103 = r100.f295164b;
        if (r103 == null) goto L15;
        r102 = r103.toString();
    L15:
        if (r102 != null) goto L18;
        return "";
    L18:
        return r102;
    L5:
        if (r101.length() <= 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L11;
        r101 = null;
    L11:
        if (r101 == null) goto L12;
        return r101;
    L7:
        r104 = false;
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r12v4 */
    /* JADX WARN: Type inference failed for: r12v5, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v0 */
    /* JADX WARN: Type inference failed for: r4v1 */
    /* JADX WARN: Type inference failed for: r4v12, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v13, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.util.List, java.util.List<com.larus.bmhome.actionbar.model.h>] */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void T5(a0 r210) {
        a0 r100 = r210;
        Intrinsics.checkNotNullParameter(r100, "descriptor");
        if ((r100 instanceof m) == true) goto L5;
        r100 = null;
    L5:
        m r101 = (m) r100;
        if (r101 == null) goto L200;
        Intrinsics.checkNotNullParameter(r101, "descriptor");
        List<h> r102 = this.f316622i;
        i r103 = r101.f464892f;
        if (r103 == null) goto L25;
        List<h> r104 = r103.f295193a;
        if (r104 == null) goto L25;
        List<h> r105 = r104;
        ?? r106 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r105, 10));
        Iterator r107 = r105.iterator();
    L14:
        if (r107.hasNext() == false) goto L26;
        h r108 = (h) r107.next();
        List<w> r109 = r108.f295167e;
        if (r109 == null) goto L21;
        List<w> r110 = r109;
        ?? r111 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r110, 10));
        Iterator r112 = r110.iterator();
    L19:
        if (r112.hasNext() == false) goto L22;
        r111.add(w.a((w) r112.next(), null, null, null, null, null, null, 8388607));
    L22:
        if (r111 != 0) goto L24;
        r111 = CollectionsKt.emptyList();
    L24:
        r106.add(h.a(r108, null, null, null, r111, null, null, 4079));
        goto L14
    L21:
        r111 = 0;
    L26:
        if (r106 != 0) goto L28;
        r106 = CollectionsKt.emptyList();
    L28:
        ?? r113 = r106;
        final c r114 = Y5();
        this.f316621h = r101;
        String r115 = r101.f464895i;
        boolean r116 = true;
        if (r115 != null) goto L31;
    L33:
        r115 = null;
    L35:
        if (r115 != null) goto L40;
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r117 = this.f316619f;
        if (r117 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r117 = null;
    L39:
        e1.o(r117.f351569d);
    L48:
        if (r101.f464896j == false) goto L53;
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r118 = this.f316619f;
        if (r118 != null) goto L52;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r118 = null;
    L52:
        e1.x(r118.f351567b);
    L58:
        if (r102.isEmpty() == false) goto L60;
    L140:
        this.f316622i = r113;
        DropdownBoxListAdapter r119 = this.f316620g;
        if (r119 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r119 = null;
    L143:
        r119.submitList(this.f316622i, new bt8.p(this, r114));
        b r120 = this.f316623j;
        if (r120 == null) goto L201;
        Iterator r121 = this.f316622i.iterator();
    L148:
        if (r121.hasNext() == false) goto L158;
        Object r122 = r121.next();
        Integer r123 = ((h) r122).f295164b;
        int r124 = r120.f316624a;
        if (r123 != null) goto L153;
    L155:
        boolean r125 = false;
    L156:
        if (r125 == false) goto L148;
    L159:
        h r126 = (h) r122;
        if (r126 == null) goto L167;
        Long r127 = c6(r126);
        long r128 = r120.f316625b;
        if (r127 == null) goto L167;
        if (r127.longValue() != r128) goto L167;
    L168:
        if (r116 == false) goto L199;
        this.f316623j = null;
        return;
    L199:
        return;
    L167:
        r116 = false;
        goto L168
    L153:
        if (r123.intValue() != r124) goto L155;
        r125 = true;
        goto L156
    L158:
        r122 = null;
        goto L159
    L201:
        return;
    L60:
        if (r113.isEmpty() == true) goto L140;
        ArrayList r129 = new ArrayList();
        Iterator r130 = ((Iterable) r113).iterator();
        int r131 = 0;
    L64:
        if (r130.hasNext() == false) goto L123;
        Object r132 = r130.next();
        int r133 = r131 + 1;
        if (r131 >= 0) goto L68;
        CollectionsKt.throwIndexOverflow();
    L68:
        h r134 = (h) r132;
        String r135 = i6(r134);
        Iterator r136 = r102.iterator();
    L70:
        if (r136.hasNext() == false) goto L74;
        Object r137 = r136.next();
        if (Intrinsics.areEqual(i6((h) r137), r135) == false) goto L70;
    L75:
        h r138 = (h) r137;
        if (r138 == null) goto L119;
        List<w> r139 = r138.f295167e;
        if (r139 != null) goto L81;
        r139 = CollectionsKt.emptyList();
    L81:
        List<w> r140 = r139;
        ArrayList r141 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r140, 10));
        Iterator r142 = r140.iterator();
    L83:
        if (r142.hasNext() == false) goto L85;
        r141.add(((w) r142.next()).f295510a);
        goto L83
    L85:
        List<w> r143 = r134.f295167e;
        if (r143 != null) goto L88;
        r143 = CollectionsKt.emptyList();
    L88:
        List<w> r144 = r143;
        ArrayList r145 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r144, 10));
        Iterator r146 = r144.iterator();
    L90:
        if (r146.hasNext() == false) goto L93;
        r145.add(((w) r146.next()).f295510a);
        goto L90
    L93:
        if (Intrinsics.areEqual(r141, r145) == false) goto L119;
        Long r147 = c6(r138);
        Long r148 = c6(r134);
        if (Intrinsics.areEqual(r147, r148) == true) goto L119;
        if (r148 == null) goto L119;
        List<w> r149 = r134.f295167e;
        if (r149 != null) goto L102;
        r149 = CollectionsKt.emptyList();
    L102:
        Iterator<w> r150 = r149.iterator();
        int r151 = 0;
    L104:
        if (r150.hasNext() == false) goto L109;
        if (Intrinsics.areEqual(r150.next().f295510a, r148) == true) goto L110;
        r151 = r151 + 1;
    L110:
        if (r151 < 0) goto L119;
        List<w> r152 = r134.f295167e;
        if (r152 != null) goto L115;
        r152 = CollectionsKt.emptyList();
    L115:
        w r153 = (w) CollectionsKt.getOrNull(r152, r151);
        if (r153 == null) goto L119;
        d r154 = new d(r134, r153, r151, r131);
    L120:
        if (r154 == null) goto L122;
        r129.add(r154);
    L122:
        r131 = r133;
        goto L64
    L109:
        r151 = -1;
    L119:
        r154 = null;
        goto L120
    L74:
        r137 = null;
        goto L75
    L123:
        Iterator r155 = r129.iterator();
    L125:
        if (r155.hasNext() == false) goto L140;
        d r156 = (d) r155.next();
        b r157 = this.f316623j;
        if (r157 == null) goto L139;
        int r158 = r157.f316624a;
        Integer r159 = r156.f316629a.f295164b;
        if (r159 == null) goto L139;
        if (r158 != r159.intValue()) goto L139;
        long r160 = r157.f316625b;
        Long r161 = r156.f316630b.f295510a;
        if (r161 == null) goto L139;
        if (r160 == r161.longValue()) goto L125;
    L139:
        Z5(r156.f316629a, r156.f316630b, r156.f316631c, r156.f316632d + 1, "use_template");
        goto L125
    L53:
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r162 = this.f316619f;
        if (r162 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r162 = null;
    L56:
        e1.o(r162.f351567b);
        goto L58
    L40:
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r163 = this.f316619f;
        if (r163 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r163 = null;
    L43:
        r163.f351569d.setText(r115);
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r164 = this.f316619f;
        if (r164 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r164 = null;
    L46:
        e1.x(r164.f351569d);
        goto L48
    L31:
        if ((!StringsKt.isBlank(r115)) == false) goto L33;
    L25:
        r106 = 0;
        goto L26
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [bt8.r] */
    /* JADX WARN: Type inference failed for: r1v0, types: [bt8.s] */
    /* JADX WARN: Type inference failed for: r4v2, types: [bt8.q] */
    @Override // com.larus.bmhome.instruction.kmp.AbsKmpInstructionWidget
    public final void S5(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f316619f = LarusLayoutActionBarEditorWidgetDropdownSelectorBinding.a(LayoutInflater.from(r100), this);
        this.f316620g = new DropdownBoxListAdapter(new q(this), new r(this), new s(this));
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r102 = this.f316619f;
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r103 = null;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r102 = null;
    L5:
        RecyclerView r104 = r102.f351568c;
        DropdownBoxListAdapter r105 = this.f316620g;
        if (r105 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r105 = null;
    L8:
        r104.setAdapter(r105);
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r106 = this.f316619f;
        if (r106 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L11:
        r106.f351568c.setItemAnimator(null);
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r107 = this.f316619f;
        if (r107 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L15:
        r103.f351568c.addItemDecoration(new KmpDropdownListSelectorWidget$init$4());
        return;
    L14:
        r103 = r107;
        goto L15
    }

    public final void b6(c r100, List<h> r110) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r110.isEmpty() == true) goto L47;
        LarusLayoutActionBarEditorWidgetDropdownSelectorBinding r101 = this.f316619f;
        Integer r102 = null;
        if (r101 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r101 = null;
    L9:
        RecyclerView.LayoutManager r103 = r101.f351568c.getLayoutManager();
        if ((r103 instanceof LinearLayoutManager) == false) goto L12;
        LinearLayoutManager r104 = (LinearLayoutManager) r103;
    L13:
        if (r104 != null) goto L15;
        return;
    L15:
        String r105 = r100.f316626a;
        boolean r106 = true;
        int r107 = 0;
        if (r105 == null) goto L34;
        Iterator<h> r108 = r110.iterator();
        int r109 = 0;
    L19:
        if (r108.hasNext() == false) goto L24;
        if (Intrinsics.areEqual(i6(r108.next()), r105) == true) goto L25;
        r109 = r109 + 1;
    L25:
        Integer r111 = Integer.valueOf(r109);
        if (r111.intValue() < 0) goto L28;
        boolean r112 = true;
    L29:
        if (r112 == false) goto L31;
        r102 = r111;
    L31:
        if (r102 == null) goto L34;
        r107 = r102.intValue();
    L42:
        r104.scrollToPositionWithOffset(r107, r100.f316628c);
        return;
    L28:
        r112 = false;
        goto L29
    L24:
        r109 = -1;
    L34:
        if (r100.f316626a != null) goto L42;
        int r113 = r110.size();
        int r114 = r100.f316627b;
        if (r114 < 0) goto L39;
        if (r114 >= r113) goto L39;
    L40:
        if (r106 == false) goto L42;
        r107 = r114;
    L39:
        r106 = false;
        goto L40
    L12:
        r104 = null;
        goto L13
    }

    public KmpDropdownListSelectorWidget(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f316622i = CollectionsKt.emptyList();
    }

    public /* synthetic */ KmpDropdownListSelectorWidget(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }

    public final void Z5(h r410, w r411, int r412, int r413, String r414) {
        m r100 = this.f316621h;
        if (r100 != null) goto L5;
        return;
    L5:
        z0 r101 = r100.f464897k;
        String r102 = r101.f465007a;
        String r103 = r101.f465009c;
        String r104 = r101.f465010d;
        String r105 = r101.f465012f;
        String r106 = r101.f465013g;
        String r107 = r101.f465016j;
        String r110 = r410.f295165c;
        String r111 = r411.f295511b;
        String r112 = String.valueOf(r411.f295510a);
        Boolean r108 = r410.f295170h;
        Boolean r113 = Boolean.TRUE;
        if (Intrinsics.areEqual(r108, r113) == true) goto L14;
        Integer r109 = r410.f295168f;
        if (r109 == null) goto L14;
        if (r109.intValue() != r412) goto L14;
        int r114 = 1;
    L15:
        int r115 = !Intrinsics.areEqual(r410.f295170h, r113) ? 1 : 0;
        String r116 = r101.f465014h;
        Boolean r117 = r101.f465015i;
        if (p.a(getVContext()) == false) goto L18;
        String r118 = "template_page";
    L19:
        String r210 = r118;
        JSONObject r211 = V5();
        tx9.b.e(r102, r103, r104, r105, r106, r107, r110, r111, r112, Integer.valueOf(r114), Integer.valueOf(r115), Integer.valueOf(r413), "select", null, null, null, r211, r414, null, null, null, null, r210, r116, r117, null, null, null, null, null, null, null, null, null, null, null, null, -59056128, 127);
        return;
    L18:
        r118 = "chat";
    L14:
        r114 = 0;
        goto L15
    }
}
