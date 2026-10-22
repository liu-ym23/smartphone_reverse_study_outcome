package com.bytedance.ee.bear.document.member;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.facade.common.BaseFragment;
import com.bytedance.ee.bear.l;
import com.bytedance.ee.bear.widgets.BaseTitleBar;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import rcb.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J&\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/bytedance/ee/bear/document/member/DocumentMemberFragment;", "Lcom/bytedance/ee/bear/facade/common/BaseFragment;", "Lcom/bytedance/ee/bear/IFullScreenPage;", "<init>", "()V", "viewModel", "Lcom/bytedance/ee/bear/document/member/DocumentMemberViewModel;", "getViewModel", "()Lcom/bytedance/ee/bear/document/member/DocumentMemberViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "onDestroyView", "onBackPressed", "", "docs-document-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DocumentMemberFragment extends BaseFragment implements l {
    public static final /* synthetic */ int f = 0;
    public final Lazy e;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ DocumentMemberFragment a;

        public a(DocumentMemberFragment r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            DocumentMemberFragment r3 = this.a;
            int r0 = DocumentMemberFragment.f;
            ((DocumentMemberViewModel) r3.e.getValue()).closeMemberList();
        }
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment, sa5.d
    public final boolean onBackPressed() {
        ((DocumentMemberViewModel) this.e.getValue()).closeMemberList();
        return true;
    }

    public DocumentMemberFragment() {
        this.e = LazyKt.lazy(new DocumentMemberFragment$viewModel$2(this));
    }

    public final void onDestroyView() {
        super.onDestroyView();
        ((DocumentMemberViewModel) this.e.getValue()).reset();
    }

    @Override // com.bytedance.ee.bear.facade.common.BaseFragment
    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super.onViewCreated(r4, r5);
        c.c(getContext());
        BaseTitleBar r6 = r4.findViewById(2131379855);
        r6.setLeftClickListener(new a(this));
        RecyclerView r0 = r4.findViewById(2131379847);
        r0.setLayoutManager(new LinearLayoutManager(r4.getContext()));
        DocumentMemberListAdapter r1 = new DocumentMemberListAdapter(r4.getContext());
        r0.setAdapter(r1);
        MemberListData r7 = (MemberListData) ((DocumentMemberViewModel) this.e.getValue()).getMemberListData().getValue();
        if (r7 != null) goto L5;
        return;
    L5:
        if (r7.getTitle().length() <= 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == false) goto L10;
        r6.setTitle(r7.getTitle());
    L10:
        List<MemberListData.MemberData> r8 = r7.getData();
        if (r8 == null) goto L15;
        Intrinsics.checkNotNullParameter(r8, "value");
        r1.b = r8;
        r1.notifyDataSetChanged();
        return;
    L15:
        return;
    L7:
        r2 = false;
        goto L8
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return r2.inflate(2131563627, r3, false);
    }
}
