package com.larus.doc.impl;

import android.os.Handler;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import com.larus.bmhome.chat.layout.widget.ShimmerTextView;
import com.larus.doc.api.IDocService;
import com.larus.doc.biz.impl.databinding.LarusLayoutDocDetailFragmentBinding;
import com.larus.doc.impl.viewmodel.DocDetailViewModel;
import com.larus.doc.sdk.api.IDocSdkBaseService;
import com.larus.nova.R;
import com.larus.office.base.view.TextLoadingView;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.chameleon.container.webcontainer.util.ChameleonContainerUtils;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: classes27.dex */
public final class DocFragment$initChatService$1 implements n39.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f331026a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DocFragment f331027b;

    @Override // n39.c
    public final boolean isEnableVoiceInput() {
        return true;
    }

    @Override // n39.c
    public final void setToAiEdit() {
        boolean r100 = true;
        this.f331026a = true;
        Fragment r101 = this.f331027b.f330991h;
        if (r101 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L28;
        Fragment r103 = this.f331027b.f330991h;
        if (r103 == null) goto L29;
        t1a.b r104 = s1a.a.g(r103);
        if (r104 == null) goto L30;
        va8.o r105 = (va8.o) r104.getAbility(va8.o.class);
        va8.g0 r106 = (va8.g0) r104.getAbility(va8.g0.class);
        if (r105 != null) goto L16;
    L18:
        boolean r107 = false;
    L19:
        if (r107 == false) goto L31;
        if (r106 != null) goto L22;
    L24:
        r100 = false;
    L25:
        if (r100 == false) goto L32;
        r105.Yv();
        return;
    L32:
        return;
    L22:
        if (r106.YC() == true) goto L24;
    L31:
        return;
    L16:
        if (r105.hh() != true) goto L18;
        r107 = true;
        goto L19
    L30:
        return;
    L29:
        return;
    L28:
        return;
    L5:
        if (r101.isAdded() != true) goto L7;
        r102 = true;
        goto L8
    }

    @Override // n39.c
    public final boolean consumeToAiEdit() {
        boolean r100 = this.f331026a;
        this.f331026a = false;
        return r100;
    }

    @Override // n39.c
    public final int getChatInputHeight() {
        return this.f331027b.aa0();
    }

    @Override // com.larus.office.base.service.a
    public final Function0<String> getIdGetter() {
        return new DocFragment$initChatService$1$getIdGetter$1(this.f331027b);
    }

    @Override // n39.c
    public final kotlinx.coroutines.flow.i1<Boolean> getVoiceInputStatus() {
        f39.g r100 = (f39.g) s1a.a.g(this.f331027b).getAbility(f39.g.class);
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getVoiceInputStatus();
    }

    @Override // n39.c
    public final boolean isChatInputVisible() {
        Fragment r100 = this.f331027b.f330991h;
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.isAdded() != true) goto L9;
        return true;
    L9:
        return false;
    }

    @Override // n39.c
    public final void onDocDeleted() {
        DocFragment r100 = this.f331027b;
        if (r100.f331013v1 == true) goto L30;
        r100.f331013v1 = true;
        if (r100.isAdded() == false) goto L26;
        n39.c.a.a(this, "DocFragment", false, false, 12);
        DocFragment r101 = this.f331027b;
        LarusLayoutDocDetailFragmentBinding r102 = r101.f330988g;
        if (r102 == null) goto L11;
        ShimmerTextView r103 = r102.f330965r;
        if (r103 == null) goto L11;
        r103.setTextColor(r101.getResources().getColor(R.color.larus_neutral_50));
    L11:
        LarusLayoutDocDetailFragmentBinding r104 = this.f331027b.f330988g;
        if (r104 == null) goto L16;
        ShimmerTextView r105 = r104.f330965r;
        if (r105 == null) goto L16;
        r105.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    L16:
        LarusLayoutDocDetailFragmentBinding r106 = this.f331027b.f330988g;
        if (r106 == null) goto L21;
        ShimmerTextView r107 = r106.f330965r;
        if (r107 == null) goto L21;
        r107.setText("");
    L21:
        LarusLayoutDocDetailFragmentBinding r108 = this.f331027b.f330988g;
        if (r108 == null) goto L26;
        ImageView r109 = r108.f330961n;
        if (r109 == null) goto L26;
        com.larus.utils.e1.o(r109);
    L26:
        IDocSdkBaseService r110 = (IDocSdkBaseService) ServiceManager.get().getService(IDocSdkBaseService.class);
        if (r110 == null) goto L31;
        r110.reportDocPageExit("delete");
        return;
    L31:
        return;
    }

    @Override // n39.c
    public final void onDocNeedUpdate() {
        if (this.f331027b.isAdded() == false) goto L20;
        FLogger.f375446a.i("DocFragment", "The doc has been migrate to fusion doc");
        String r100 = this.f331027b.H;
        if (r100 != null) goto L7;
    L10:
        boolean r101 = true;
    L11:
        if (r101 == true) goto L13;
        this.f331027b.I = true;
    L13:
        FragmentActivity r102 = this.f331027b.getActivity();
        if ((r102 instanceof DocActivity) == false) goto L16;
        DocActivity r103 = (DocActivity) r102;
    L17:
        if (r103 == null) goto L21;
        r103.y1(this.f331027b.f330987f, 10);
        return;
    L21:
        return;
    L16:
        r103 = null;
        goto L17
    L7:
        if (StringsKt.isBlank(r100) == true) goto L10;
        r101 = false;
        goto L11
    }

    @Override // n39.c
    public final void onLoadFinishEventReported() {
        if (this.f331027b.isAdded() == true) goto L5;
        return;
    L5:
        if ((this.f331027b.getActivity() instanceof DocActivity) == false) goto L11;
        FragmentActivity r100 = this.f331027b.getActivity();
        Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larus.doc.impl.DocActivity");
        DocDetailViewModel r101 = ((DocActivity) r100).f330981b;
        if (r101 == null) goto L12;
        r101.setHasReportLoadEvent(true);
        return;
    L12:
        return;
    }

    @Override // n39.c
    public final void requestChatInputFocus() {
        ViewGroup r100 = this.f331027b.f331010t;
        boolean r101 = false;
        if (r100 != null) goto L5;
    L7:
        boolean r102 = false;
    L8:
        if (r102 == false) goto L29;
        Fragment r103 = this.f331027b.f330991h;
        if (r103 != null) goto L12;
    L14:
        boolean r104 = false;
    L15:
        if (r104 == false) goto L30;
        Fragment r105 = this.f331027b.f330991h;
        if (r105 == null) goto L21;
        t1a.b r106 = s1a.a.g(r105);
        if (r106 == null) goto L21;
        va8.o r107 = (va8.o) r106.getAbility(va8.o.class);
    L22:
        if (r107 != null) goto L24;
    L26:
        if (r101 == false) goto L31;
        va8.o.a.a(r107, true);
        r107.i00();
        return;
    L31:
        return;
    L24:
        if (r107.hh() == true) goto L26;
        r101 = true;
    L21:
        r107 = null;
        goto L22
    L30:
        return;
    L12:
        if (r103.isAdded() != true) goto L14;
        r104 = true;
        goto L15
    L29:
        return;
    L5:
        if (r100.getVisibility() != 0) goto L7;
        r102 = true;
        goto L8
    }

    @Override // n39.c
    public final void selectCurrentSentenceOrParagraph() {
        if (this.f331027b.isAdded() == false) goto L12;
        Fragment r100 = this.f331027b.f330991h;
        if (r100 != null) goto L7;
        return;
    L7:
        if (r100.isAdded() == false) goto L14;
        va8.l0 r101 = (va8.l0) s1a.a.g(r100).getAbility(va8.l0.class);
        if (r101 == null) goto L15;
        r101.A90();
        return;
    L15:
        return;
    L14:
        return;
    }

    public DocFragment$initChatService$1(DocFragment r100) {
        this.f331027b = r100;
    }

    @Override // n39.c
    public final Object getAppIconUrl(Continuation<? super String> r100) {
        if ((r100 instanceof DocFragment$initChatService$1$getAppIconUrl$1) == false) goto L7;
        DocFragment$initChatService$1$getAppIconUrl$1 r101 = (DocFragment$initChatService$1$getAppIconUrl$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r103);
    L19:
        String r106 = (String) r103;
        if (r106 == null) goto L25;
        return r106;
    L25:
        return "";
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r103);
        IDocService r107 = (IDocService) ServiceManager.get().getService(IDocService.class);
        if (r107 == null) goto L23;
        r101.label = 1;
        r103 = r107.getAppIconUrl(r101);
        if (r103 != r104) goto L19;
        return r104;
    L23:
        return "";
    L7:
        r101 = new DocFragment$initChatService$1$getAppIconUrl$1(this, r100);
        goto L8
    }

    @Override // n39.c
    public final void getLatestMessageId(Function1<? super String, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        String r101 = this.f331027b.ea0();
        if (r101 != null) goto L5;
        r101 = "";
    L5:
        r100.invoke(r101);
    }

    @Override // n39.c
    public final void onDocStateChanged(boolean r100) {
        FLogger.f375446a.i("DocFragment", "[onDocStateChanged] isEmpty:" + r100);
        if (this.f331027b.isAdded() == false) goto L6;
        DocFragment r101 = this.f331027b;
        r101.M = r100;
        r101.va0(false);
        return;
    }

    @Override // n39.c
    public final void setChatInputVisibility(boolean r100) {
        FLogger.f375446a.i("DocFragment", "setChatInputVisibility, isHidden = " + r100);
        DocFragment r101 = this.f331027b;
        r101.J2 = r100;
        if (r100 == false) goto L8;
        TextLoadingView r102 = r101.f331011u;
        if (r102 == null) goto L12;
        com.larus.utils.e1.o(r102);
    L12:
        boolean r103 = !r100;
        this.f331027b.Ba0(r103);
        DocFragment.za0(this.f331027b, r103, 2);
        this.f331027b.ka0(r103);
        this.f331027b.la0();
        return;
    L8:
        if (r101.f330983J == 0) goto L12;
        TextLoadingView r104 = r101.f331011u;
        if (r104 == null) goto L12;
        com.larus.utils.e1.x(r104);
        goto L12
    }

    @Override // n39.c
    public final void notifyInitChatInput(ViewGroup r100, FragmentManager r101) {
        int r102 = m39.b.f511804a;
        m39.b.a("文档渲染完毕, onLoadSuccess");
        FLogger r103 = FLogger.f375446a;
        r103.i("[doc_input_focus]", "notifyInitChatInput called container=" + r100 + " prev=" + this.f331027b.f331009s);
        if (r100 == null) goto L5;
        this.f331027b.f331009s = r100;
    L5:
        this.f331027b.ra0();
        DocFragment r104 = this.f331027b;
        r104.getClass();
        r103.i(ChameleonContainerUtils.DOC_TRACER_TAG, "DocFragment, integrateFloatChatFragment");
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L8
        Result.m9449constructorimpl(BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r104), null, null, new DocFragment$integrateFloatChatFragment$1$1(r104, r101, null), 3, null));     // Catch: Throwable -> L8
    L10:
        DocFragment.za0(this.f331027b, false, 3);
        return;
    L8:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // n39.c
    public final void setEnableVoiceInput(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "from");
        if (this.f331027b.isAdded() == false) goto L8;
        f39.g r102 = (f39.g) s1a.a.g(this.f331027b).getAbility(f39.g.class);
        if (r102 == null) goto L9;
        r102.Qe(r100, r101);
        return;
    L9:
        return;
    }

    @Override // n39.c
    public final void setChatInputVisible(String r100, final boolean r101, final boolean r102, boolean r103) {
        Intrinsics.checkNotNullParameter(r100, "from");
        FLogger.f375446a.i("DocFragment", "setChatInputVisible, from = " + r100 + ", visible = " + r101 + ", aiEditMode = " + r102 + ", normalMode = " + r103);
        if (r101 == false) goto L10;
        DocFragment r104 = this.f331027b;
        if (r104.B == false) goto L10;
        if (r104.J2 == false) goto L10;
        return;
    L10:
        if (this.f331027b.isAdded() == false) goto L13;
        Handler r105 = com.larus.utils.t0.f375468a;
        final DocFragment r106 = this.f331027b;
        r105.post(new w0(r101, r106, r102));
        return;
    }
}
