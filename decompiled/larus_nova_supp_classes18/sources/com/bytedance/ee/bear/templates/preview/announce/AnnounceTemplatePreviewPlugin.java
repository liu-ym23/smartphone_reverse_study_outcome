package com.bytedance.ee.bear.templates.preview.announce;

import android.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.browser.plugin.PluginHost;
import com.bytedance.ee.bear.browser.plugin.t;
import com.bytedance.ee.bear.document.DocumentPlugin;
import com.bytedance.ee.bear.document.DocumentPluginHost;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\bH\u0002J\n\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplatePreviewPlugin;", "Lcom/bytedance/ee/bear/document/DocumentPlugin;", "Lcom/bytedance/ee/bear/facade/common/BackPressHandler;", "<init>", "()V", "templateViewModel", "Lcom/bytedance/ee/bear/templates/preview/announce/AnnounceTemplateViewModel;", "onAttachToUIContainer", "", "host", "Lcom/bytedance/ee/bear/document/DocumentPluginHost;", "uiContainer", "Lcom/bytedance/ee/bear/browser/plugin/UIContainer;", "ensurePreviewFragment", "getTemplateView", "Landroid/view/ViewGroup;", "onLoadingFinish", "onBackPressed", "", "features-templates-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AnnounceTemplatePreviewPlugin extends DocumentPlugin implements sa5.d {
    private AnnounceTemplateViewModel templateViewModel;

    public static final class a<T> implements Observer {
        public final /* synthetic */ AnnounceTemplatePreviewPlugin a;

        public a(AnnounceTemplatePreviewPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            if (Intrinsics.areEqual((Boolean) r2, Boolean.FALSE) == false) goto L6;
            AnnounceTemplatePreviewPlugin.access$onLoadingFinish(this.a);
            return;
        }
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ AnnounceTemplatePreviewPlugin a;

        public b(AnnounceTemplatePreviewPlugin r1) {
            this.a = r1;
        }

        public final void onChanged(Object r2) {
            Integer r3 = (Integer) r2;
            AnnounceTemplateViewModel r0 = AnnounceTemplatePreviewPlugin.access$getTemplateViewModel$p(this.a);
            if (r0 == null) goto L8;
            d r1 = r0.getPreviewTemplateView();
            if (r1 == null) goto L9;
            Intrinsics.checkNotNull(r3);
            r1.a(r3.intValue());
            return;
        L9:
            return;
        }
    }

    public static final class c implements Runnable {
        public final /* synthetic */ t a;

        public c(t r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r0 = this.a.findView(2131367799);     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.setPadding(0, this.a.findView(2131369266).getHeight(), 0, y9c.d.a(165));     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public /* bridge */ /* synthetic */ void onPause(PluginHost r1) {
    }

    public boolean onBackPressed() {
        AnnounceTemplateViewModel r0 = this.templateViewModel;
        if (r0 == null) goto L5;
        r0.setTemplateData(null);
    L5:
        ViewGroup r1 = getTemplateView();
        if (r1 == null) goto L10;
        r1.setVisibility(8);
        return false;
    L10:
        return false;
    }

    private final void ensurePreviewFragment() {
        ViewGroup r0 = (ViewGroup) getHost().getActivity().getWindow().findViewById(R.id.content);
        ViewGroup r1 = getTemplateView();
        AnnounceTemplateViewModel r2 = this.templateViewModel;
        if (r2 == null) goto L5;
        d r3 = r2.getPreviewTemplateView();
    L6:
        View r4 = r0.findViewById(2131391146);
        int r5 = 0;
        if (r4 == null) goto L10;
        r4.setVisibility(0);
    L10:
        if (r3 != null) goto L14;
        LayoutInflater.from(getContext()).inflate(2131558574, r0, true);
        r3 = new d();
        AnnounceTemplateViewModel r6 = this.templateViewModel;
        if (r6 == null) goto L14;
        r6.setPreviewTemplateView(r3);
    L14:
        if (r1 != null) goto L34;
        FragmentActivity r7 = getActivity();
        Intrinsics.checkNotNull(r0);
        AnnounceTemplateViewModel r8 = this.templateViewModel;
        Intrinsics.checkNotNullParameter(r7, "context");
        Intrinsics.checkNotNullParameter(r0, "parent");
        r3.g = r8;
        View r9 = LayoutInflater.from(r7).inflate(2131558573, r0, true);
        Intrinsics.checkNotNull(r9);
        r3.c = (ImageView) r9.findViewById(2131388825);
        r3.a = (FrameLayout) r9.findViewById(2131372817);
        r3.b = (FrameLayout) r9.findViewById(2131372796);
        r3.d = (ImageView) r9.findViewById(2131388824);
        TextView r10 = (TextView) r9.findViewById(2131381895);
        r3.e = r10;
        if (r10 == null) goto L18;
        r10.setCompoundDrawablesRelativeWithIntrinsicBounds(kac.a.b(2131254431), 0, 0, 0);
    L18:
        r3.f = (TextView) r9.findViewById(2131391666);
        AnnounceTemplateViewModel r11 = r3.g;
        if (r11 == null) goto L25;
        MutableLiveData<Integer> r12 = r11.getCurrTemplatePos();
        if (r12 == null) goto L25;
        Integer r13 = (Integer) r12.getValue();
        if (r13 == null) goto L25;
        r5 = r13.intValue();
    L25:
        r3.a(r5);
        TextView r14 = r3.f;
        if (r14 == null) goto L28;
        r14.setOnClickListener(new com.bytedance.ee.bear.templates.preview.announce.a(r3));
    L28:
        FrameLayout r15 = r3.a;
        if (r15 == null) goto L31;
        r15.setOnClickListener(new com.bytedance.ee.bear.templates.preview.announce.b(r3));
    L31:
        FrameLayout r16 = r3.b;
        if (r16 == null) goto L35;
        r16.setOnClickListener(new com.bytedance.ee.bear.templates.preview.announce.c(r3));
    L35:
        AnnounceTemplateViewModel r17 = this.templateViewModel;
        if (r17 == null) goto L40;
        LiveData<Boolean> r18 = r17.getPreviewActive();
        if (r18 == null) goto L40;
        r18.observe(getLifecycleOwner(), new a(this));
    L40:
        AnnounceTemplateViewModel r19 = this.templateViewModel;
        if (r19 == null) goto L46;
        MutableLiveData<Integer> r20 = r19.getCurrTemplatePos();
        if (r20 == null) goto L47;
        r20.observe(getLifecycleOwner(), new b(this));
        return;
    L47:
        return;
    L46:
        return;
    L34:
        r1.setVisibility(0);
        goto L35
    L5:
        r3 = null;
        goto L6
    }

    private final ViewGroup getTemplateView() {
        return (ViewGroup) ((ViewGroup) getHost().getActivity().getWindow().findViewById(R.id.content)).findViewById(2131377419);
    }

    private final void onLoadingFinish() {
        ViewGroup r0 = getTemplateView();
        if (r0 == null) goto L5;
        r0.setVisibility(8);
    L5:
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L8;
        r1.onBackPressed();
    L8:
        AnnounceTemplateViewModel r2 = this.templateViewModel;
        if (r2 == null) goto L11;
        r2.onRefreshUI();
    L11:
        Lazy r3 = AnnounceTemplateAnalytic.a;
        Intrinsics.checkNotNullParameter("use_template", "action");
        JSONObject r4 = AnnounceTemplateAnalytic.b;
        r4.put("action", "use_template");
        r4.put("source", "from_im_chat_announcement");
        ((com.bytedance.ee.bear.contract.d) AnnounceTemplateAnalytic.a.getValue()).n("docs_toggle_attribute", r4);
    }

    public AnnounceTemplatePreviewPlugin() {
    }

    public static final /* synthetic */ AnnounceTemplateViewModel access$getTemplateViewModel$p(AnnounceTemplatePreviewPlugin r0) {
        return r0.templateViewModel;
    }

    public static final /* synthetic */ void access$onLoadingFinish(AnnounceTemplatePreviewPlugin r0) {
        r0.onLoadingFinish();
    }

    public void onAttachToUIContainer(DocumentPluginHost r2, t r3) {
        super/*com.bytedance.ee.bear.browser.plugin.BasePlugin*/.onAttachToUIContainer(r2, r3);
        AnnounceTemplateViewModel r4 = (AnnounceTemplateViewModel) new ViewModelProvider(getActivity()).get(AnnounceTemplateViewModel.class);
        this.templateViewModel = r4;
        if (r4 == null) goto L5;
        r4.setPreviewActive(Boolean.TRUE);
    L5:
        if (r3 == null) goto L9;
        View r5 = r3.findView(2131369266);
        if (r5 == null) goto L9;
        r5.post(new c(r3));
    L9:
        ensurePreviewFragment();
    }

    public /* bridge */ /* synthetic */ void onAttachToUIContainer(PluginHost r1, t r2) {
        onAttachToUIContainer((DocumentPluginHost) r1, r2);
    }
}
