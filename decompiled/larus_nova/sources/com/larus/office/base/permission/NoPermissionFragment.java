package com.larus.office.base.permission;

import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larus.office.base.preview.DocMeta;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 92\u00020\u0001:\u00029:B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0002J \u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0082@¢\u0006\u0002\u0010\u001bJ>\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010\u001a2\u0012\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00100!H\u0002J$\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%2\b\u0010\u0004\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020#2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010+\u001a\u00020\u0010H\u0016J\u0006\u0010,\u001a\u00020\u0010J\u0010\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u001aH\u0002J\u0010\u0010/\u001a\u00020\u00102\u0006\u00100\u001a\u000201H\u0002J\u0010\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u000201H\u0002J0\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\n2\u0016\u00108\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\n\u0018\u00010\tj\n\u0012\u0004\u0012\u00020\n\u0018\u0001`\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/larus/office/base/permission/NoPermissionFragment;", "Landroidx/fragment/app/Fragment;", "<init>", "()V", KtvSubElement.CONTAINER, "Landroid/widget/FrameLayout;", "currentStateView", "Lcom/larus/office/base/permission/INoPermissionStateView;", "docListToApplyPermission", "Ljava/util/ArrayList;", "Lcom/larus/office/base/preview/DocMeta;", "Lkotlin/collections/ArrayList;", "uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/office/base/permission/NoPermissionViewInput;", "jumpToNextDoc", "", "delay", "", "viewOutput", "Lcom/larus/office/base/permission/NoPermissionViewOutput;", "applyPermission", "Lcom/larus/office/base/permission/NoPermissionFragment$ApplyPermissionResult;", "permissionType", "", "remark", "", "(ILjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "token", "objType", "permission", "message", "callback", "Lkotlin/Function1;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onDestroyView", "updateState", "ensureStateView", "permissionStatus", "showRealView", "needReviewFailView", "", "updateApplying", "isApplying", "jumpToNextDocByType", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "nextDoc", "restDocList", "Companion", "ApplyPermissionResult", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NoPermissionFragment extends Fragment {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Set<Integer> f360616i = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public FrameLayout f360617d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ConstraintLayout f360618e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public ArrayList<DocMeta> f360619f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final StateFlowImpl f360620g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final NoPermissionFragment$viewOutput$1 f360621h;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f360622a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Integer f360623b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f360624c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f360622a == r101.f360622a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f360623b, r101.f360623b) == true) goto L15;
            return false;
        L15:
            if (this.f360624c == r101.f360624c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f360622a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            Integer r103 = this.f360623b;
            if (r103 != null) goto L9;
            int r104 = 0;
        L10:
            int r105 = (r102 + r104) * 31;
            if (this.f360624c == true) goto L15;
            r100 = 1237;
        L15:
            return r105 + r100;
        L9:
            r104 = r103.hashCode();
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "ApplyPermissionResult(success=" + this.f360622a + ", errorCode=" + this.f360623b + ", isNetworkError=" + this.f360624c + ')';
        }

        public a(boolean r100, Integer r101, boolean r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r101 = null;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = false;
        L8:
            this.f360622a = r100;
            this.f360623b = r101;
            this.f360624c = r102;
        }
    }

    public static final class b {
    }

    static {
        f360616i = SetsKt.setOf(new Integer[]{0, 1});
    }

    public final void V90() {
        Bundle r100 = getArguments();
        String r101 = "NO_PERMISSION";
        if (r100 == null) goto L8;
        String r102 = r100.getString("KEY_PERMISSION_STATUS", "NO_PERMISSION");
        if (r102 == null) goto L8;
        r101 = r102;
    L8:
        Bundle r103 = getArguments();
        if (r103 == null) goto L11;
        ArrayList<DocMeta> r104 = com.larus.office.base.preview.a.a(r103, "key_doc_list_to_apply_permission");
    L12:
        this.f360619f = r104;
        Bundle r105 = getArguments();
        if (r105 == null) goto L16;
        String r106 = r105.getString("KEY_USER_NAME");
        if (r106 == null) goto L16;
    L17:
        String r107 = r106;
        Bundle r108 = getArguments();
        if (r108 == null) goto L20;
        String r109 = r108.getString("KEY_OWNER_NAME");
    L21:
        Fragment r110 = getParentFragment();
        if (r110 == null) goto L27;
        Bundle r111 = r110.getArguments();
        if (r111 == null) goto L27;
        String r112 = r111.getString("argPreviousPage");
        if (r112 == null) goto L27;
    L30:
        String r113 = r112;
    L32:
        boolean r114 = false;
        String r115 = null;
        ArrayList<DocMeta> r116 = this.f360619f;
        if (r116 != null) goto L35;
    L38:
        boolean r117 = true;
    L39:
        NoPermissionViewInput r118 = new NoPermissionViewInput(r101, r114, r107, r109, r115, r113, !r117, 2, null);
        FLogger r119 = FLogger.f375446a;
        StringBuilder r120 = new StringBuilder("updateState: permissionStatus=");
        r120.append(r101);
        r120.append(", canApply=");
        Bundle r121 = getArguments();
        if (r121 == null) goto L42;
        Boolean r122 = Boolean.valueOf(r121.getBoolean("key_can_apply_permission"));
    L43:
        r120.append(r122);
        r120.append(", ownerName=");
        r120.append(r109);
        r120.append(", shouldJumpToNext=");
        ArrayList<DocMeta> r123 = this.f360619f;
        if (r123 != null) goto L46;
    L49:
        boolean r124 = true;
    L50:
        r120.append(!r124);
        r120.append(", docListSize=");
        ArrayList<DocMeta> r125 = this.f360619f;
        if (r125 == null) goto L53;
        int r126 = r125.size();
    L54:
        r120.append(r126);
        r119.i(com.ss.android.lark.widget.photopicker.gallery.NoPermissionFragment.TAG, r120.toString());
        if (Intrinsics.areEqual(r101, "REVIEW_FAIL") == false) goto L57;
        U90(true);
    L64:
        this.f360620g.setValue(r118);
        return;
    L57:
        Bundle r127 = getArguments();
        if (r127 == null) goto L60;
        boolean r128 = r127.getBoolean("key_can_apply_permission");
    L61:
        if (r128 == true) goto L63;
        U90(true);
        goto L64
    L63:
        U90(false);
        goto L64
    L60:
        r128 = false;
        goto L61
    L53:
        r126 = 0;
        goto L54
    L46:
        if (r123.isEmpty() == true) goto L49;
        r124 = false;
        goto L50
    L42:
        r122 = null;
        goto L43
    L35:
        if (r116.isEmpty() == true) goto L38;
        r117 = false;
    L27:
        Bundle r129 = getArguments();
        if (r129 == null) goto L31;
        r112 = r129.getString("argPreviousPage");
        goto L30
    L31:
        r113 = null;
        goto L32
    L20:
        r109 = null;
    L16:
        r106 = AccountService.f365697a.getNickname();
        goto L17
    L11:
        r104 = null;
        goto L12
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.larus.office.base.permission.NoPermissionFragment$viewOutput$1] */
    public NoPermissionFragment() {
        this.f360620g = j1.a(null);
        this.f360621h = new NoPermissionFragment$viewOutput$1(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        this.f360617d = null;
        this.f360618e = null;
    }

    public final void T90(long r100) {
        ArrayList<DocMeta> r101 = this.f360619f;
        if (r101 == null) goto L5;
        final DocMeta r102 = (DocMeta) CollectionsKt.firstOrNull(r101);
    L6:
        if (r102 == null) goto L15;
        ArrayList<DocMeta> r103 = this.f360619f;
        if (r103 == null) goto L12;
        List r104 = CollectionsKt.drop(r103, 1);
        if (r104 == null) goto L12;
        final ArrayList r105 = new ArrayList(r104);
    L13:
        FLogger r106 = FLogger.f375446a;
        StringBuilder r107 = new StringBuilder("jumpToNextDoc: delay=");
        r107.append(r100);
        r107.append(", nextDocType=");
        r107.append(r102.getType());
        r107.append(", nextToken=");
        int r108 = com.larus.office.base.utils.f.f361173a;
        r107.append(com.larus.office.base.utils.f.b(r102.getToken()));
        r107.append(", restDocsSize=");
        r107.append(r105.size());
        r106.i(com.ss.android.lark.widget.photopicker.gallery.NoPermissionFragment.TAG, r107.toString());
        SoftReference<Handler> r109 = com.larus.utils.y.f375498a;
        Runnable r110 = new p(this, r102, r105);
        Intrinsics.checkNotNullParameter(r110, "action");
        com.larus.utils.y.d(r110, r100);
        return;
    L12:
        r105 = new ArrayList();
        goto L13
    L15:
        return;
    L5:
        r102 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.constraintlayout.widget.ConstraintLayout, com.larus.office.base.permission.o] */
    /* JADX WARN: Type inference failed for: r5v4 */
    /* JADX WARN: Type inference failed for: r5v5 */
    public final void U90(boolean r100) {
        ConstraintLayout r101 = this.f360618e;
        boolean r102 = r101 instanceof ReviewFailAndNoPermissionDefaultView;
        if (r101 == null) goto L5;
        if (r100 != r102) goto L5;
        return;
    L5:
        int r103 = 0;
        int r104 = 6;
        AttributeSet r105 = null;
        if (r100 == false) goto L8;
        ?? r106 = new ReviewFailAndNoPermissionDefaultView(requireContext(), r105, r104, r103);
    L9:
        FrameLayout r107 = this.f360617d;
        if (r107 == null) goto L12;
        r107.removeAllViews();
        r107.addView(r106.getViewRoot());
    L12:
        r106.L(this.f360620g, this.f360621h);
        this.f360618e = r106;
        return;
    L8:
        r106 = new ApplyPermissionView(requireContext(), r105, r104, r103);
        goto L9
    }

    public static final void S90(NoPermissionFragment r110, boolean r111) {
        NoPermissionViewInput r100 = (NoPermissionViewInput) r110.f360620g.getValue();
        if (r100 == null) goto L7;
        r110.f360620g.setValue(NoPermissionViewInput.copy$default(r100, null, r111, null, null, null, null, false, 125, null));
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        V90();
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        FrameLayout r103 = new FrameLayout(requireContext());
        r103.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f360617d = r103;
        return r103;
    }
}
