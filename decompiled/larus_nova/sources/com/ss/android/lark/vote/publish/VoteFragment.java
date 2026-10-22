package com.ss.android.lark.vote.publish;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larksuite.component.universe_design.toast.UDToast;
import com.larksuite.component.universe_design.udswitch.UDSwitch;
import com.larksuite.framework.utils.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import com.ss.android.lark.base.fragment.BaseFragment;
import com.ss.android.lark.ui.CommonTitleBar;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes38.dex */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007*\u00016\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010$\u001a\u0004\u0018\u00010\u00072\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u001a\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00072\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\u0010\u0010.\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0007H\u0002J\b\u0010/\u001a\u00020,H\u0002J\b\u00100\u001a\u00020,H\u0002J\u000e\u00101\u001a\b\u0012\u0004\u0012\u00020302H\u0002J\b\u00104\u001a\u00020,H\u0002J\b\u00108\u001a\u00020,H\u0002J\b\u00109\u001a\u00020,H\u0002J\b\u0010:\u001a\u00020,H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u001d\u001a\u00020\u001e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b!\u0010\u0019\u001a\u0004\b\u001f\u0010 R\u000e\u0010\"\u001a\u00020#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u000206X\u0082\u0004¢\u0006\u0004\n\u0002\u00107¨\u0006<"}, d2 = {"Lcom/ss/android/lark/vote/publish/VoteFragment;", "Lcom/ss/android/lark/base/fragment/BaseFragment;", "<init>", "()V", "voteViewModel", "Lcom/ss/android/lark/vote/publish/VoteViewModel;", "rootView", "Landroid/view/View;", "bottomArea", "voteTitleBar", "Lcom/ss/android/lark/ui/CommonTitleBar;", "multipleChoice", "Lcom/larksuite/component/universe_design/udswitch/UDSwitch;", "anonymous", "btnPublish", "Landroid/widget/TextView;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Lcom/ss/android/lark/vote/publish/VoteRecycleAdapter;", "chatId", "", "getChatId", "()Ljava/lang/String;", "chatId$delegate", "Lkotlin/Lazy;", "isMultipleChoice", "", "isAnonymous", "keyboardObserver", "Lcom/ss/android/lark/vote/utils/KeyboardObserver;", "getKeyboardObserver", "()Lcom/ss/android/lark/vote/utils/KeyboardObserver;", "keyboardObserver$delegate", "optionsMaxHeight", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "initView", "initListener", "initRecycleView", "getInitData", "", "Lcom/ss/android/lark/vote/publish/VoteItemData;", "initOptionsHeight", "adapterDependency", "com/ss/android/lark/vote/publish/VoteFragment$adapterDependency$1", "Lcom/ss/android/lark/vote/publish/VoteFragment$adapterDependency$1;", "publishVote", "sendData", LiveCommonConstants.REASON_ON_DEDTROY, "Companion", "vote_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class VoteFragment extends BaseFragment {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public VoteViewModel f445262d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public View f445263e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public View f445264f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public CommonTitleBar f445265g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public UDSwitch f445266h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public UDSwitch f445267i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f445268j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RecyclerView f445269k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public VoteRecycleAdapter f445270l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Lazy f445271m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f445272n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f445273o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f445274p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public int f445275q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final b f445276r;

    public static final class a {
    }

    public static final class b implements VoteRecycleAdapter.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ VoteFragment f445277a;

        public static final class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ VoteFragment f445278a;

            public a(VoteFragment r100) {
                this.f445278a = r100;
            }

            @Override // java.lang.Runnable
            public final void run() {
                RecyclerView r100 = this.f445278a.f445269k;     // Catch: Throwable -> L13
                VoteRecycleAdapter r101 = null;
                if (r100 != null) goto L5;
                Intrinsics.throwUninitializedPropertyAccessException("recyclerView");     // Catch: Throwable -> L13
                r100 = null;
            L5:
                RecyclerView.LayoutManager r102 = r100.getLayoutManager();     // Catch: Throwable -> L13
                if ((r102 instanceof LinearLayoutManager) == false) goto L16;
                LinearLayoutManager r103 = (LinearLayoutManager) r102;     // Catch: Throwable -> L13
                VoteRecycleAdapter r104 = this.f445278a.f445270l;     // Catch: Throwable -> L13
                if (r104 != null) goto L10;
                Intrinsics.throwUninitializedPropertyAccessException("adapter");     // Catch: Throwable -> L13
            L11:
                r103.scrollToPositionWithOffset(r101.getItemCount() - 1, Integer.MIN_VALUE);     // Catch: Throwable -> L13
                return;
            L10:
                r101 = r104;
                goto L11
            L16:
                return;
            L13:
                th = move-exception;
                if (RunnableProtector.intercept(th) == true) goto L20;
                throw th;
            }
        }

        @Override // com.ss.android.lark.vote.publish.VoteRecycleAdapter.b
        public final void a() {
            RecyclerView r100 = this.f445277a.f445269k;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
            r100 = null;
        L5:
            r100.post(new a(this.f445277a));
        }

        @Override // com.ss.android.lark.vote.publish.VoteRecycleAdapter.b
        public final void b() {
            VoteRecycleAdapter r100 = this.f445277a.f445270l;
            TextView r101 = null;
            if (r100 != null) goto L5;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            r100 = null;
        L5:
            g r102 = (g) CollectionsKt.firstOrNull(r100.f445284a);
            if (r102 == null) goto L11;
            String r103 = r102.f445297b;
            if (r103 == null) goto L11;
            String r104 = StringsKt.trim(r103).toString();
            if (r104 == null) goto L11;
        L12:
            boolean r105 = true;
            if (r104.length() <= 0) goto L15;
            boolean r106 = true;
        L16:
            if (r106 == false) goto L23;
            VoteRecycleAdapter r107 = this.f445277a.f445270l;
            if (r107 != null) goto L21;
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            r107 = null;
        L21:
            if (r107.z2() == false) goto L23;
        L25:
            if (r105 == false) goto L31;
            TextView r108 = this.f445277a.f445268j;
            if (r108 != null) goto L29;
            Intrinsics.throwUninitializedPropertyAccessException("btnPublish");
        L30:
            r101.setBackground(AppCompatResources.getDrawable(this.f445277a.requireContext(), R.drawable.lark_vote_button_publish_blue));
            return;
        L29:
            r101 = r108;
            goto L30
        L31:
            TextView r109 = this.f445277a.f445268j;
            if (r109 != null) goto L34;
            Intrinsics.throwUninitializedPropertyAccessException("btnPublish");
        L35:
            r101.setBackground(AppCompatResources.getDrawable(this.f445277a.requireContext(), R.drawable.lark_vote_button_publish_gray));
            return;
        L34:
            r101 = r109;
        L23:
            r105 = false;
            goto L25
        L15:
            r106 = false;
        L11:
            r104 = "";
            goto L12
        }

        public b(VoteFragment r100) {
            this.f445277a = r100;
        }

        @Override // com.ss.android.lark.vote.publish.VoteRecycleAdapter.b
        public final void showToast(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            UDToast.show(this.f445277a.requireContext(), r100);
        }
    }

    static {
    }

    public VoteFragment() {
        this.f445271m = LazyKt.lazy(new VoteFragment$chatId$2(this));
        this.f445274p = LazyKt.lazy(new VoteFragment$keyboardObserver$2(this));
        this.f445276r = new b(this);
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        ubc.a r100 = (ubc.a) this.f445274p.getValue();
        View r101 = r100.f549417c;
        if (r101 == null) goto L7;
        ViewTreeObserver r102 = r101.getViewTreeObserver();
        if (r102 == null) goto L7;
        r102.removeOnGlobalLayoutListener(r100);
    L7:
        r100.f549417c = null;
    }

    @Override // com.ss.android.lark.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        this.f445262d = (VoteViewModel) new ViewModelProvider(this).get(VoteViewModel.class);
        this.f445263e = r100.findViewById(R.id.vote_fragment_container);
        this.f445264f = r100.findViewById(R.id.bottom_area);
        this.f445265g = (CommonTitleBar) r100.findViewById(R.id.title_bar);
        this.f445268j = (TextView) r100.findViewById(R.id.btn_publish);
        this.f445266h = (UDSwitch) r100.findViewById(R.id.vote_Multi);
        this.f445267i = (UDSwitch) r100.findViewById(R.id.vote_Anon);
        this.f445269k = (RecyclerView) r100.findViewById(R.id.my_recycler_view);
        CommonTitleBar r102 = this.f445265g;
        if (r102 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("voteTitleBar");
        r102 = null;
    L5:
        r102.setLeftClickListener(new com.ss.android.lark.vote.publish.a(this));
        TextView r103 = this.f445268j;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("btnPublish");
        r103 = null;
    L8:
        r103.setOnClickListener(new com.ss.android.lark.vote.publish.b(this));
        UDSwitch r104 = this.f445266h;
        if (r104 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("multipleChoice");
        r104 = null;
    L11:
        r104.setOnClickListener(new c(this));
        UDSwitch r105 = this.f445267i;
        if (r105 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("anonymous");
        r105 = null;
    L14:
        r105.setOnClickListener(new d(this));
        RecyclerView r106 = this.f445269k;
        if (r106 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r106 = null;
    L17:
        LinearLayoutManager r107 = new LinearLayoutManager(r106.getContext());
        RecyclerView r108 = this.f445269k;
        if (r108 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r108 = null;
    L20:
        r108.setLayoutManager(r107);
        ArrayList r109 = new ArrayList();
        r109.add(new g(VoteItemType.TOPIC.ordinal()));
        int r110 = 0;
    L22:
        if (r110 >= 2) goto L24;
        r109.add(new g(VoteItemType.OPTION.ordinal()));
        r110 = r110 + 1;
        goto L22
    L24:
        r109.add(new g(VoteItemType.ADD.ordinal()));
        this.f445270l = new VoteRecycleAdapter(r109, this.f445276r);
        RecyclerView r111 = this.f445269k;
        if (r111 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r111 = null;
    L27:
        VoteRecycleAdapter r112 = this.f445270l;
        if (r112 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        r112 = null;
    L30:
        r111.setAdapter(r112);
        RecyclerView r113 = this.f445269k;
        if (r113 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("recyclerView");
        r113 = null;
    L33:
        r113.setItemAnimator(null);
        this.f445275q = UIUtils.dp2px(getContext(), 480.0f);
        View r114 = this.f445263e;
        if (r114 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
        r114 = null;
    L36:
        r114.getViewTreeObserver().addOnGlobalLayoutListener(new e(this));
        ((ubc.a) this.f445274p.getValue()).f549418d = new f(this);
        ubc.a r115 = (ubc.a) this.f445274p.getValue();
        View r116 = r115.f549417c;
        if (r116 == null) goto L41;
        ViewTreeObserver r117 = r116.getViewTreeObserver();
        if (r117 == null) goto L41;
        r117.removeOnGlobalLayoutListener(r115);
    L41:
        r115.f549417c = null;
        ViewGroup r118 = (ViewGroup) r115.f549415a.findViewById(android.R.id.content);
        if (r118.getChildCount() <= 0) goto L46;
        View r119 = r118.getChildAt(0);
        r115.f549417c = r119;
        Intrinsics.checkNotNull(r119);
        r119.getViewTreeObserver().addOnGlobalLayoutListener(r115);
        return;
    }

    @Override // com.ss.android.lark.desktopmode.app.DesktopCompatFragment, androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.lark_vote_fragment_vote, r101, false);
    }
}
