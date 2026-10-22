package com.bytedance.ee.bear.bitable.document;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ee.bear.container.ContainerFragment;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.lark.insets.WindowInsetsUtils;
import com.ss.android.lark.passportc.convention.PassportcConvention;
import com.ss.android.lark.utils.LarkContext;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f*\u0002\u0019\u001c\u0018\u0000 52\u00020\u00012\u00020\u0002:\u00015B\u0007¢\u0006\u0004\b\u0003\u0010\u0004JF\u0010\u001e\u001a\u00020\u00142\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u00132\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0017J$\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010'\u001a\u00020\u00142\u0006\u0010(\u001a\u00020 2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0014H\u0016J\b\u0010,\u001a\u00020\u0014H\u0016J\b\u0010-\u001a\u00020\fH\u0002J\b\u0010.\u001a\u00020\u0014H\u0002J\u0010\u0010/\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u0001H\u0002J\u0010\u00101\u001a\u00020\u00142\u0006\u00100\u001a\u00020\u0001H\u0002J\b\u00102\u001a\u00020\u0014H\u0002J\u0010\u00103\u001a\u00020\u00142\u0006\u0010(\u001a\u00020 H\u0002J\b\u00104\u001a\u00020\u0014H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00060\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001aR\u0010\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001d¨\u00066"}, d2 = {"Lcom/bytedance/ee/bear/bitable/document/LinkedDocxContainerFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "<init>", "()V", "callbackKey", "", "getCallbackKey", "()Ljava/lang/String;", "callbackKey$delegate", "Lkotlin/Lazy;", "containerFragment", "Lcom/bytedance/ee/bear/container/ContainerFragment;", "contentFragment", "aiChatVisibilityAbility", "Lcom/bytedance/ee/bear/bitable/ai/BaseMainAIChatVisibilityAbility;", "aiChatHiddenReasons", "", "onContentAttached", "Lkotlin/Function1;", "", "onContentDetached", "onFinish", "Lkotlin/Function0;", "embeddedDocumentAbility", "com/bytedance/ee/bear/bitable/document/LinkedDocxContainerFragment$embeddedDocumentAbility$1", "Lcom/bytedance/ee/bear/bitable/document/LinkedDocxContainerFragment$embeddedDocumentAbility$1;", "fragmentLifecycleCallbacks", "com/bytedance/ee/bear/bitable/document/LinkedDocxContainerFragment$fragmentLifecycleCallbacks$1", "Lcom/bytedance/ee/bear/bitable/document/LinkedDocxContainerFragment$fragmentLifecycleCallbacks$1;", "configure", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onBackPressed", "", "onResume", "onDestroyView", "createContainerFragment", "registerPluginHostCallback", "attachContent", WidgetService.PARAM_FRAGMENT, "detachContent", "requestFinish", "configureContainerView", "resetContainerInsets", "Companion", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LinkedDocxContainerFragment extends Fragment implements sa5.d {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f211094n = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Lazy f211095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ContainerFragment f211096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Fragment f211097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public do4.a f211098g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Set<String> f211099h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function1<? super Fragment, Unit> f211100i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Function1<? super Fragment, Unit> f211101j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public Function0<Unit> f211102k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final b f211103l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final LinkedDocxContainerFragment$fragmentLifecycleCallbacks$1 f211104m;

    public static final class a {
    }

    public static final class b implements do4.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LinkedDocxContainerFragment f211105a;

        @Override // do4.b
        public final void xk() {
        }

        @Override // do4.b
        public final void V6() {
            this.f211105a.f211099h.clear();
            do4.a r100 = this.f211105a.f211098g;
            if (r100 == null) goto L6;
            r100.xg(false);
            return;
        }

        public b(LinkedDocxContainerFragment r100) {
            this.f211105a = r100;
        }

        @Override // do4.b
        public final void T5(String r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            if (r101 == false) goto L5;
            this.f211105a.f211099h.add(r100);
        L6:
            LinkedDocxContainerFragment r102 = this.f211105a;
            do4.a r103 = r102.f211098g;
            if (r103 == null) goto L10;
            r103.xg(!r102.f211099h.isEmpty());
            return;
        L10:
            return;
        L5:
            this.f211105a.f211099h.remove(r100);
            goto L6
        }
    }

    static {
    }

    public final void S90() {
        ContainerFragment r100 = this.f211096e;
        if (r100 == null) goto L6;
        com.ss.android.lark.insets.f r101 = WindowInsetsUtils.b(r100);
        r101.c(false);
        r101.o(false);
        return;
    }

    @Override // sa5.d
    public final boolean onBackPressed() {
        ContainerFragment r100 = this.f211096e;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.onBackPressed() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        this.f211103l.V6();
        Fragment r100 = this.f211097f;
        if (r100 == null) goto L7;
        this.f211097f = null;
        Function1<? super Fragment, Unit> r101 = this.f211101j;
        if (r101 == null) goto L7;
        r101.invoke(r100);
    L7:
        getChildFragmentManager().unregisterFragmentLifecycleCallbacks(this.f211104m);
        ConcurrentHashMap<String, hk5.a> r102 = hk5.b.f485570a;
        hk5.b.a((String) this.f211095d.getValue());
        this.f211096e = null;
        super.onDestroyView();
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.bytedance.ee.bear.bitable.document.LinkedDocxContainerFragment$fragmentLifecycleCallbacks$1] */
    public LinkedDocxContainerFragment() {
        this.f211095d = LazyKt.lazy(LazyThreadSafetyMode.NONE, new LinkedDocxContainerFragment$callbackKey$2(this));
        this.f211099h = new LinkedHashSet();
        this.f211103l = new b(this);
        this.f211104m = new LinkedDocxContainerFragment$fragmentLifecycleCallbacks$1(this);
    }

    @Override // androidx.fragment.app.Fragment
    public final void onResume() {
        super.onResume();
        S90();
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        getChildFragmentManager().registerFragmentLifecycleCallbacks(this.f211104m, true);
        ConcurrentHashMap<String, hk5.a> r102 = hk5.b.f485570a;
        hk5.b.b((String) this.f211095d.getValue(), new d(this));
        Fragment r103 = getChildFragmentManager().findFragmentByTag("bitable_linked_docx_container");
        if ((r103 instanceof ContainerFragment) == false) goto L5;
        ContainerFragment r104 = (ContainerFragment) r103;
    L7:
        if (r104 == null) goto L14;
        this.f211096e = r104;
        View r105 = r104.getView();
        if (r105 == null) goto L23;
        View r106 = r105.findViewById(R.id.container_title_bar);
        if (r106 == null) goto L13;
        r106.setVisibility(8);
        ViewGroup.LayoutParams r107 = r106.getLayoutParams();
        r107.height = 0;
        r106.setLayoutParams(r107);
    L13:
        S90();
        return;
    L23:
        return;
    L14:
        Bundle r108 = new Bundle(requireArguments());
        ContainerFragment r109 = new ContainerFragment();
        String r110 = r108.getString("url");
        if (r110 != null) goto L17;
        r110 = "";
    L17:
        r108.putString("url", r110);
        r108.putString("plugin_host_callback_key", (String) this.f211095d.getValue());
        PassportcConvention.f(r108, LarkContext.getApplication());
        r109.setArguments(r108);
        r109.f216730s = new c(this);
        com.ss.android.lark.insets.f r111 = WindowInsetsUtils.b(r109);
        r111.c(false);
        r111.o(false);
        this.f211096e = r109;
        FragmentTransaction r112 = getChildFragmentManager().beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r112, r109, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, "bitable_linked_docx_container", R.id.bitable_linked_docx_document_container) == true) goto L21;
        r112 = r112.replace(R.id.bitable_linked_docx_document_container, r109, "bitable_linked_docx_container");
    L21:
        r112.commitNowAllowingStateLoss();
        return;
    L5:
        r104 = null;
        goto L7
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        return r100.inflate(R.layout.bitable_linked_docx_container, r101, false);
    }
}
