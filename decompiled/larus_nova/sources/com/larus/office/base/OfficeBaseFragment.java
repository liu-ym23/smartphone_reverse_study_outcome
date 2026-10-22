package com.larus.office.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBinding;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.bmhome.chat.api.AuthModelDelegate;
import com.larus.trace.tracknode.TraceFragment;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes29.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H$¢\u0006\u0002\u0010\u001aJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH$J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH$J\b\u0010 \u001a\u00020\u0014H$J\b\u0010!\u001a\u00020\"H$J\b\u0010#\u001a\u00020$H$J\b\u0010%\u001a\u00020\u0014H$J\b\u0010&\u001a\u00020$H$J\u001c\u0010'\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010\u00142\b\u0010)\u001a\u0004\u0018\u00010\u0014H$J\b\u0010*\u001a\u00020\u001cH\u0016J\b\u0010+\u001a\u00020\u001cH\u0016J&\u0010,\u001a\u0004\u0018\u00010-2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010.\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010/\u001a\u00020\u001c2\u0006\u00100\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\"H\u0016J\b\u00101\u001a\u000202H\u0016J\b\u00103\u001a\u00020\u001cH\u0016J0\u00104\u001a\u00020\u001c2\b\u0010(\u001a\u0004\u0018\u00010\u00142\b\u0010)\u001a\u0004\u0018\u00010\u00142\b\u00105\u001a\u0004\u0018\u00010\u00142\b\u00106\u001a\u0004\u0018\u00010\u0014H&J \u00107\u001a\u0004\u0018\u00010\u000e2\u0006\u00108\u001a\u00020\u000e2\u0006\u00109\u001a\u00020\"H\u0082@¢\u0006\u0002\u0010:J\u0018\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010=\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010>J4\u0010?\u001a\u0004\u0018\u00010@2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010A\u001a\u00020<2\b\u0010B\u001a\u0004\u0018\u00010$2\u0006\u0010C\u001a\u00020\u0014H\u0082@¢\u0006\u0002\u0010DR\u001e\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0084\u000e¢\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/larus/office/base/OfficeBaseFragment;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/larus/trace/tracknode/TraceFragment;", "Lcom/larus/bmhome/ability/FloatChatFoldStatusChangeListener;", "<init>", "()V", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "setBinding", "(Landroidx/viewbinding/ViewBinding;)V", "Landroidx/viewbinding/ViewBinding;", "chatInputFragment", "Landroidx/fragment/app/Fragment;", "getChatInputFragment", "()Landroidx/fragment/app/Fragment;", "setChatInputFragment", "(Landroidx/fragment/app/Fragment;)V", "tag", "", "getViewBinding", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroidx/viewbinding/ViewBinding;", "onInitHostFragment", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "initChameleonFragment", "getLogTag", "getParamsBundle", "Landroid/os/Bundle;", "getFloatChatFragmentContainerId", "", "getLocalConvIdSuffix", "getResourceType", "refreshArtifactInfo", "artifactMetaId", "artifactVersionId", "onFloatChatFragmentInited", "initFloatChatFragment", "onCreateView", "Landroid/view/View;", "savedInstanceState", "onViewCreated", "view", "autoLogEnterPage", "", LiveCommonConstants.REASON_ON_DEDTROY, "updateArtifactInfo", "conversationId", "boundMessageId", "createFloatChatFragment", "parentFragment", "bundleParams", "(Landroidx/fragment/app/Fragment;Landroid/os/Bundle;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getBotModel", "Lcom/larus/im/bean/bot/BotModel;", "botId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createLocalSubCov", "Lcom/larus/im/bean/conversation/Conversation;", "botModel", "inputLeftActionStyle", "customSuffix", "(Landroid/content/Context;Lcom/larus/im/bean/bot/BotModel;Ljava/lang/Integer;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class OfficeBaseFragment<VB extends ViewBinding> extends TraceFragment implements va8.d {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f360438h = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public VB f360439e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public Fragment f360440f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f360441g;

    public abstract void D8(String r100, String r101);

    public abstract void F8(String r100, String r101, String r102, String r103);

    @Override // com.larus.trace.tracknode.TraceFragment
    public boolean S90() {
        return false;
    }

    public abstract int V90();

    public abstract String W90();

    public abstract Bundle X90();

    public abstract int Y90();

    public abstract VB Z90(LayoutInflater r100, ViewGroup r101);

    public abstract Fragment aa0(Context r100);

    public void ca0() {
    }

    public abstract void da0(Context r100);

    public abstract String getLogTag();

    public final void ba0() {
        FLogger.f375446a.i(this.f360441g, "Init float chat fragment");
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L5
        Result.m9449constructorimpl(BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new OfficeBaseFragment$initFloatChatFragment$1$1(this, null), 3, null));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r101 = Result.Companion;
        Result.m9449constructorimpl(ResultKt.createFailure(th));
    }

    public OfficeBaseFragment() {
        this.f360441g = getLogTag();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        this.f360439e = null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        Context r102 = getContext();
        if (r102 == null) goto L6;
        da0(r102);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        VB r103 = (VB) Z90(r100, r101);
        this.f360439e = r103;
        if (r103 != null) goto L7;
        return null;
    L7:
        return r103.getRoot();
    }

    public static final <VB extends ViewBinding> void U90(OfficeBaseFragment<VB> r110, Fragment r111, CompletableDeferred<Fragment> r112, Bundle r113) {
        FLogger.f375446a.i(r110.f360441g, "integrateFloatChatFragment, withLocalConv");
        if (com.larus.platform.exp.o.a() == false) goto L12;
        LifecycleOwner r114 = r111.getViewLifecycleOwnerLiveData().getValue();
        if (r114 == null) goto L10;
        LifecycleCoroutineScope r100 = LifecycleOwnerKt.getLifecycleScope(r114);
        if (r100 == null) goto L10;
        if (BuildersKt.launch$default(r100, null, null, new OfficeBaseFragment$createFloatChatFragment$withLocalConv$1(r112, r113, null), 3, null) == null) goto L10;
        return;
    L10:
        r112.complete(null);
        return;
    L12:
        wc9.e r101 = AuthModelDelegate.f297134b.y().getValue();
        if (r101 == null) goto L21;
        String r102 = r101.f559198a;
        LifecycleOwner r103 = r111.getViewLifecycleOwnerLiveData().getValue();
        if (r103 == null) goto L19;
        LifecycleCoroutineScope r104 = LifecycleOwnerKt.getLifecycleScope(r103);
        if (r104 == null) goto L19;
        Job r115 = BuildersKt.launch$default(r104, null, null, new OfficeBaseFragment$createFloatChatFragment$withLocalConv$2$1$1(r102, r110, r111, r113, r112, null), 3, null);
    L20:
        if (r115 == null) goto L21;
        return;
    L19:
        r115 = null;
    L21:
        r112.complete(null);
    }
}
