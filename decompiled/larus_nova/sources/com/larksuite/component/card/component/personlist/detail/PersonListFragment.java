package com.larksuite.component.card.component.personlist.detail;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.larksuite.component.card.component.personlist.PersonInfo;
import com.larksuite.component.card.component.personlist.avatar.SimpleUserLoader;
import com.larksuite.component.card.utils.k;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.ui.CommonTitleBar;
import com.ss.android.lark.widget.recyclerview.CommonRecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000 !2\u00020\u0001:\u0001!B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u001a\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u001b\u001a\u00020\u0019H\u0002J\u0018\u0010\u001c\u001a\u00020\u00192\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001eH\u0002J\b\u0010 \u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0084.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/larksuite/component/card/component/personlist/detail/PersonListFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "personListRecyclerView", "Lcom/ss/android/lark/widget/recyclerview/CommonRecyclerView;", "personListAdapter", "Lcom/larksuite/component/card/component/personlist/detail/PersonListAdapter;", "titleBar", "Lcom/ss/android/lark/ui/CommonTitleBar;", "getTitleBar", "()Lcom/ss/android/lark/ui/CommonTitleBar;", "setTitleBar", "(Lcom/ss/android/lark/ui/CommonTitleBar;)V", "canLoadMore", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initViews", "loadAvatarIfNeed", "personList", "Ljava/util/ArrayList;", "Lcom/larksuite/component/card/component/personlist/PersonInfo;", "initListener", "Companion", "universalcard_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class PersonListFragment extends BaseFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public CommonRecyclerView f283502d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public PersonListAdapter f283503e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public CommonTitleBar f283504f;

    public static final class a {
    }

    static {
    }

    public PersonListFragment() {
    }

    public static final /* synthetic */ String S90(PersonListFragment r100) {
        return r100.PARENT_TAG;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r110) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r110);
        LinearLayoutManager r101 = new LinearLayoutManager(requireContext(), 1, false);
        CommonRecyclerView r111 = this.f283502d;
        CommonRecyclerView r102 = null;
        if (r111 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("personListRecyclerView");
        r111 = null;
    L5:
        r111.setLayoutManager(r101);
        this.f283503e = new PersonListAdapter();
        Bundle r103 = getArguments();
        if (r103 == null) goto L47;
        ArrayList r104 = r103.getParcelableArrayList("person_list");
        PersonListAdapter r105 = this.f283503e;
        if (r105 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("personListAdapter");
        r105 = null;
    L10:
        r105.getClass();
        StringBuilder r106 = new StringBuilder("setDataList newData:");
        if (r104 == null) goto L13;
        Integer r107 = Integer.valueOf(r104.size());
    L14:
        r106.append(r107);
        r106.append(", ");
        r106.append(((ArrayList) r105.f283496a).size());
        Log.i("PersonListAdapter", r106.toString());
        if (r104 != null) goto L17;
    L20:
        boolean r108 = true;
    L21:
        if (r108 == true) goto L24;
        ((ArrayList) r105.f283496a).clear();
        int r109 = ((ArrayList) r105.f283496a).size();
        ((ArrayList) r105.f283496a).addAll(r104);
        r105.notifyItemRangeInserted(r109, r104.size());
    L24:
        if (r104 == null) goto L47;
        ArrayList r112 = new ArrayList();
        Iterator r113 = r104.iterator();
    L27:
        if (r113.hasNext() == false) goto L42;
        Object r114 = r113.next();
        PersonInfo r115 = (PersonInfo) r114;
        String r116 = r115.getAvatarKey();
        if (r116 != null) goto L31;
    L34:
        boolean r117 = true;
    L35:
        if (r117 == true) goto L37;
    L39:
        boolean r118 = false;
    L40:
        if (r118 == false) goto L27;
        r112.add(r114);
        goto L27
    L37:
        if (k.b(r115.getId()) == false) goto L39;
        r118 = true;
        goto L40
    L31:
        if (r116.length() == 0) goto L34;
        r117 = false;
        goto L35
    L42:
        ArrayList r119 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r112, 10));
        Iterator r120 = r112.iterator();
    L44:
        if (r120.hasNext() == false) goto L46;
        r119.add(((PersonInfo) r120.next()).getId());
        goto L44
    L46:
        Lazy<SimpleUserLoader> r121 = SimpleUserLoader.f283460d;
        SimpleUserLoader.a.a().b(r119, new wy7.a(this));
        goto L47
    L17:
        if (r104.isEmpty() == true) goto L20;
        r108 = false;
        goto L21
    L13:
        r107 = null;
    L47:
        CommonTitleBar r122 = this.f283504f;
        if (r122 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        r122 = null;
    L51:
        r122.setTitle(UIUtils.getString(getContext(), R.string.Lark_Groups_member));
        CommonRecyclerView r123 = this.f283502d;
        if (r123 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("personListRecyclerView");
        r123 = null;
    L54:
        PersonListAdapter r124 = this.f283503e;
        if (r124 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("personListAdapter");
        r124 = null;
    L57:
        r123.setAdapter(r124);
        PersonListAdapter r125 = this.f283503e;
        if (r125 != null) goto L60;
        Intrinsics.throwUninitializedPropertyAccessException("personListAdapter");
        r125 = null;
    L60:
        com.larksuite.component.card.component.personlist.detail.a r126 = new com.larksuite.component.card.component.personlist.detail.a(this);
        r125.getClass();
        Intrinsics.checkNotNullParameter(r126, "itemClickListener");
        r125.f283497b = r126;
        CommonRecyclerView r127 = this.f283502d;
        if (r127 != null) goto L63;
        Intrinsics.throwUninitializedPropertyAccessException("personListRecyclerView");
    L64:
        r102.addOnScrollListener(new PersonListFragment$initListener$2(this));
        return;
    L63:
        r102 = r127;
        goto L64
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        View r103 = r100.inflate(R.layout.fragment_card_person_list, r101, false);
        this.f283502d = (CommonRecyclerView) r103.findViewById(R.id.rv_person_list);
        CommonTitleBar r104 = (CommonTitleBar) r103.findViewById(R.id.title_bar);
        Intrinsics.checkNotNullParameter(r104, "<set-?>");
        this.f283504f = r104;
        return r103;
    }
}
