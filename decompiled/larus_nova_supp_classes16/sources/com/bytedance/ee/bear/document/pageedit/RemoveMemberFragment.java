package com.bytedance.ee.bear.document.pageedit;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.util.ui.n;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.checkbox.UDCheckBox;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.image.ImageLoader;
import com.ss.android.lark.passportc.api.m;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.passportc.entity.UserSession;
import dagger.hilt.android.dwarf.DwarfComponentProvider;
import dagger.hilt.android.dwarf.DwarfInjectPoint;
import e0c.l;
import f0c.h;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@DwarfInjectPoint(parent = l.class)
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 12\u00020\u00012\u00020\u0002:\u0003123B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J(\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\b\u0010\u001c\u001a\u00020\u0015H\u0016J\u001a\u0010\u001d\u001a\u00020\u00152\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!H\u0014J&\u0010\"\u001a\u0004\u0018\u00010\u00112\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00112\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010+\u001a\u00020\u00152\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010.\u001a\u00020!H\u0016J\b\u0010/\u001a\u000200H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\fj\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/bytedance/ee/bear/document/pageedit/RemoveMemberFragment;", "Lcom/bytedance/ee/bear/bizwidget/dialogfragment/OrientationBaseDialogFragment;", "Lcom/ss/android/lark/passportc/convention/view/UserScopeView;", "<init>", "()V", "callBack", "Lcom/bytedance/ee/bear/document/pageedit/SelectUserCallBack;", "selectResult", "Ljava/util/HashSet;", "Lcom/bytedance/ee/bear/document/pageedit/PageEditPlugin$UserInfo;", "Lkotlin/collections/HashSet;", "dataSource", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "save", "Landroid/widget/TextView;", "cancel", "Landroid/view/View;", "userList", "Landroidx/recyclerview/widget/RecyclerView;", "show", "", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "sourceFragment", "Landroidx/fragment/app/Fragment;", "onStart", "adjustWindowHeight", "attributes", "Landroid/view/WindowManager$LayoutParams;", "isLandscape", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onCancel", "dialog", "Landroid/content/DialogInterface;", "isSupportScreenLandscape", "provideUserSession", "Lcom/ss/android/lark/passportc/entity/UserSession;", "Companion", "UserListAdapter", "UserItemViewHodler", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RemoveMemberFragment extends Hilt_RemoveMemberFragment implements d0c.c {
    public static final int q = 0;
    public g k;
    public final HashSet<PageEditPlugin.UserInfo> l;
    public ArrayList<PageEditPlugin.UserInfo> m;
    public TextView n;
    public View o;
    public RecyclerView p;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/bytedance/ee/bear/document/pageedit/RemoveMemberFragment$UserItemViewHodler;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "avatar", "Landroid/widget/ImageView;", "getAvatar", "()Landroid/widget/ImageView;", "checkBox", "Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "getCheckBox", "()Lcom/larksuite/component/universe_design/checkbox/UDCheckBox;", "name", "Landroid/widget/TextView;", "getName", "()Landroid/widget/TextView;", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class UserItemViewHodler extends RecyclerView.ViewHolder {
        public final ImageView a;
        public final UDCheckBox b;
        public final TextView c;

        public UserItemViewHodler(View r2) {
            Intrinsics.checkNotNullParameter(r2, "itemView");
            super(r2);
            this.a = (ImageView) r2.findViewById(2131375773);
            this.b = r2.findViewById(2131365629);
            this.c = (TextView) r2.findViewById(2131375800);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0086\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001f\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0018\u0010\u000b\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u000fH\u0016R!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ee/bear/document/pageedit/RemoveMemberFragment$UserListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/bytedance/ee/bear/document/pageedit/RemoveMemberFragment$UserItemViewHodler;", "userInfos", "Ljava/util/ArrayList;", "Lcom/bytedance/ee/bear/document/pageedit/PageEditPlugin$UserInfo;", "Lkotlin/collections/ArrayList;", "<init>", "(Lcom/bytedance/ee/bear/document/pageedit/RemoveMemberFragment;Ljava/util/ArrayList;)V", "getUserInfos", "()Ljava/util/ArrayList;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "onBindViewHolder", "", "holder", "position", "getItemCount", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public final class UserListAdapter extends RecyclerView.Adapter<UserItemViewHodler> {
        public final ArrayList<PageEditPlugin.UserInfo> a;
        public final /* synthetic */ RemoveMemberFragment b;

        public final int getItemCount() {
            return this.a.size();
        }

        public UserListAdapter(RemoveMemberFragment r2, ArrayList<PageEditPlugin.UserInfo> r3) {
            Intrinsics.checkNotNullParameter(r3, "userInfos");
            this.b = r2;
            this.a = r3;
        }

        public final void onBindViewHolder(RecyclerView.ViewHolder r5, int r6) {
            UserItemViewHodler r7 = (UserItemViewHodler) r5;
            Intrinsics.checkNotNullParameter(r7, "holder");
            if (r6 >= 0) goto L5;
            return;
        L5:
            if (r6 >= this.a.size()) goto L23;
            PageEditPlugin.UserInfo r8 = (PageEditPlugin.UserInfo) ListProtector.get(this.a, r6);
            ((RecyclerView.ViewHolder) r7).itemView.setOnClickListener(new e(r7, this.b, r8));
            UDCheckBox r0 = r7.b;
            Iterator<PageEditPlugin.UserInfo> r1 = this.b.l.iterator();
        L9:
            if (r1.hasNext() == false) goto L13;
            PageEditPlugin.UserInfo r2 = r1.next();
            if (r2.equals(r8) == false) goto L9;
        L14:
            if (r2 == null) goto L16;
            boolean r3 = true;
        L17:
            r0.setChecked(r3);
            r7.c.setText(r8.getUsername());
            ImageLoader.with(((RecyclerView.ViewHolder) r7).itemView.getContext()).load(r8.getAvatarUrl()).into(r7.a);
            return;
        L16:
            r3 = false;
            goto L17
        L13:
            r2 = null;
            goto L14
        }

        public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "parent");
            return new UserItemViewHodler(LayoutInflater.from(r3.getContext()).inflate(2131564280, r3, false));
        }
    }

    public static final class a {
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ RemoveMemberFragment a;

        public b(RemoveMemberFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r3) {
            tt5.a.h("RemoveMemberFragment", "click confirm");
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
        L9:
            g r4 = this.a.k;
            if (r4 == null) goto L15;
            r4.a(PageEditPlugin.REMOVE, new ArrayList(this.a.l));
            return;
        L15:
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r5 = DialogFragmentLancet.sLastShowStack;
            if (r5 == null) goto L9;
            com.bytedance.crash.d.d(r5, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L9
        }
    }

    public static final class c implements View.OnClickListener {
        public final /* synthetic */ RemoveMemberFragment a;

        public c(RemoveMemberFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            tt5.a.h("RemoveMemberFragment", "click cancel");
            this.a.dismissAllowingStateLoss();     // Catch: Exception -> L5
        L9:
            g r3 = this.a.k;
            if (r3 == null) goto L15;
            r3.onCancel();
            return;
        L15:
            return;
        L5:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
            Throwable r4 = DialogFragmentLancet.sLastShowStack;
            if (r4 == null) goto L9;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
            goto L9
        }
    }

    public final void afterUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void afterUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.OrientationBaseDialogFragment
    public final boolean da0() {
        return true;
    }

    public final /* synthetic */ Object generatedComponent() {
        return DwarfComponentProvider.-CC.$default$generatedComponent(this);
    }

    public final /* synthetic */ m getPassport() {
        return d0c.b.a(this);
    }

    public final void onUserOffline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final void onUserOnline(h r2) {
        Intrinsics.checkNotNullParameter(r2, "state");
    }

    public final /* synthetic */ l provideComponent() {
        return d0c.b.b(this);
    }

    static {
        q = n.d(12);
    }

    public RemoveMemberFragment() {
        this.l = new HashSet();
        this.m = new ArrayList();
    }

    public final UserSession e9() {
        return PassportcConvention.b(this);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.OrientationBaseDialogFragment, com.bytedance.ee.bear.bizwidget.dialogfragment.antiscreenshots.BaseAntiScreenshotsDialogFragment
    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        WindowManager.LayoutParams r2 = r1.getAttributes();
    L8:
        if (r2 == null) goto L10;
        r2.windowAnimations = 2131951623;
    L10:
        TypedValue r3 = new TypedValue();
        FragmentActivity r4 = getActivity();
        if (r4 == null) goto L17;
        Resources r5 = r4.getResources();
        if (r5 == null) goto L15;
        r5.getValue(2131169371, r3, true);
    L15:
        if (r2 == null) goto L17;
        r2.dimAmount = r3.getFloat();
    L17:
        Dialog r6 = getDialog();
        if (r6 == null) goto L23;
        Window r7 = r6.getWindow();
        if (r7 == null) goto L24;
        r7.setAttributes(r2);
        return;
    L24:
        return;
    L23:
        return;
    L7:
        r2 = null;
        goto L8
    }

    /* JADX INFO: renamed from: provideComponent, reason: collision with other method in class */
    public final /* bridge */ /* synthetic */ Object m233provideComponent() {
        return provideComponent();
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super.onCancel(r2);
        tt5.a.h("RemoveMemberFragment", "on cancel");
        g r3 = this.k;
        if (r3 == null) goto L6;
        r3.onCancel();
        return;
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.OrientationBaseDialogFragment
    public final void ba0(WindowManager.LayoutParams r3, boolean r4) {
        r3.gravity = 81;     // Catch: Throwable -> L5
        r3.height = (int) (n.p(getContext()) * 0.95f);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        tt5.a.e("RemoveMemberFragment", "init peek height", th, false);
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super.onViewCreated(r3, r4);
        this.n = (TextView) r3.findViewById(2131385084);
        this.o = r3.findViewById(2131365114);
        this.p = r3.findViewById(2131392039);
        Bundle r5 = getArguments();
        if (r5 == null) goto L5;
        Serializable r6 = r5.getSerializable("DATA_SOURCE");
    L7:
        if ((r6 instanceof ArrayList) == false) goto L9;
        ArrayList<PageEditPlugin.UserInfo> r7 = (ArrayList) r6;
    L10:
        this.m = r7;
        TextView r8 = this.n;
        if (r8 == null) goto L13;
        r8.setOnClickListener(new b(this));
    L13:
        View r9 = this.o;
        if (r9 == null) goto L16;
        r9.setOnClickListener(new c(this));
    L16:
        RecyclerView r10 = this.p;
        if (r10 == null) goto L19;
        r10.setLayoutManager(new LinearLayoutManager(getActivity()));
    L19:
        ArrayList<PageEditPlugin.UserInfo> r11 = this.m;
        if (r11 == null) goto L25;
        UserListAdapter r0 = new UserListAdapter(this, r11);
        RecyclerView r12 = this.p;
        if (r12 == null) goto L24;
        r12.setAdapter(r0);
    L24:
        r0.notifyDataSetChanged();
    L25:
        RecyclerView r13 = this.p;
        if (r13 == null) goto L28;
        r13.addItemDecoration(new AnonymousClass4(this));
    L28:
        ((zo5.b) org.koin.java.a.c(zo5.b.class, null, null, 6)).d(getDialog());
        return;
    L9:
        r7 = null;
        goto L10
    L5:
        r6 = null;
        goto L7
    }

    @Override // com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.BaseForsetiCompatDialogFragment
    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        ForsetiHelper.w(getActivity(), 0.9f);
        return r2.inflate(2131564279, r3, false);
    }
}
