package com.ss.android.ugc.aweme.feed.viewmodel;

import com.bytedance.android.livesdkapi.feed.ILivePreviewMultiLinkCommonWidget;
import com.bytedance.android.livesdkapi.feed.IPreviewMultiLinkEffectService;
import com.bytedance.android.livesdkapi.feed.IRevenueFeedGameEffectServiceContainer;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b%\u0010&R$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\n\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0018\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR!\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/ss/android/ugc/aweme/feed/viewmodel/PreviewMultiLinkContext;", "Lcom/bytedance/live/datacontext/DataContext;", "Lcom/bytedance/android/livesdkapi/feed/ILivePreviewMultiLinkCommonWidget$IEnterBundleExtraParamsProvider;", "enterBundleExtraParamsProvider", "Lcom/bytedance/android/livesdkapi/feed/ILivePreviewMultiLinkCommonWidget$IEnterBundleExtraParamsProvider;", "getEnterBundleExtraParamsProvider", "()Lcom/bytedance/android/livesdkapi/feed/ILivePreviewMultiLinkCommonWidget$IEnterBundleExtraParamsProvider;", "setEnterBundleExtraParamsProvider", "(Lcom/bytedance/android/livesdkapi/feed/ILivePreviewMultiLinkCommonWidget$IEnterBundleExtraParamsProvider;)V", "Lcom/bytedance/android/livesdkapi/feed/ILivePreviewMultiLinkCommonWidget$IKtvComponentExtraParamsProvider;", "ktvComponentExtraParamsProvider", "Lcom/bytedance/android/livesdkapi/feed/ILivePreviewMultiLinkCommonWidget$IKtvComponentExtraParamsProvider;", "getKtvComponentExtraParamsProvider", "()Lcom/bytedance/android/livesdkapi/feed/ILivePreviewMultiLinkCommonWidget$IKtvComponentExtraParamsProvider;", "setKtvComponentExtraParamsProvider", "(Lcom/bytedance/android/livesdkapi/feed/ILivePreviewMultiLinkCommonWidget$IKtvComponentExtraParamsProvider;)V", "Lcom/bytedance/android/livesdkapi/feed/IRevenueFeedGameEffectServiceContainer;", "mRevenueFeedGameEffectService", "Lcom/bytedance/android/livesdkapi/feed/IRevenueFeedGameEffectServiceContainer;", "getMRevenueFeedGameEffectService", "()Lcom/bytedance/android/livesdkapi/feed/IRevenueFeedGameEffectServiceContainer;", "setMRevenueFeedGameEffectService", "(Lcom/bytedance/android/livesdkapi/feed/IRevenueFeedGameEffectServiceContainer;)V", "Lcom/bytedance/android/livesdkapi/feed/IPreviewMultiLinkEffectService;", "mMultiLinkEffectService", "Lcom/bytedance/android/livesdkapi/feed/IPreviewMultiLinkEffectService;", "getMMultiLinkEffectService", "()Lcom/bytedance/android/livesdkapi/feed/IPreviewMultiLinkEffectService;", "setMMultiLinkEffectService", "(Lcom/bytedance/android/livesdkapi/feed/IPreviewMultiLinkEffectService;)V", "Lcom/bytedance/live/datacontext/m;", "", "enterRoomClickEvent$delegate", "Lcom/bytedance/live/datacontext/p;", "getEnterRoomClickEvent", "()Lcom/bytedance/live/datacontext/m;", "enterRoomClickEvent", "<init>", "()V", "livepreview-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PreviewMultiLinkContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private ILivePreviewMultiLinkCommonWidget.IEnterBundleExtraParamsProvider enterBundleExtraParamsProvider;
    private final p enterRoomClickEvent$delegate;
    private ILivePreviewMultiLinkCommonWidget.IKtvComponentExtraParamsProvider ktvComponentExtraParamsProvider;
    private IPreviewMultiLinkEffectService mMultiLinkEffectService;
    private IRevenueFeedGameEffectServiceContainer mRevenueFeedGameEffectService;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(PreviewMultiLinkContext.class, "enterRoomClickEvent", "getEnterRoomClickEvent()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
    }

    public final m<Boolean> getEnterRoomClickEvent() {
        return (m) this.enterRoomClickEvent$delegate.a(this, $$delegatedProperties[0]);
    }

    public PreviewMultiLinkContext() {
        this.enterRoomClickEvent$delegate = q.d(this, Boolean.FALSE);
    }

    public final ILivePreviewMultiLinkCommonWidget.IEnterBundleExtraParamsProvider getEnterBundleExtraParamsProvider() {
        return this.enterBundleExtraParamsProvider;
    }

    public final ILivePreviewMultiLinkCommonWidget.IKtvComponentExtraParamsProvider getKtvComponentExtraParamsProvider() {
        return this.ktvComponentExtraParamsProvider;
    }

    public final IPreviewMultiLinkEffectService getMMultiLinkEffectService() {
        return this.mMultiLinkEffectService;
    }

    public final IRevenueFeedGameEffectServiceContainer getMRevenueFeedGameEffectService() {
        return this.mRevenueFeedGameEffectService;
    }

    public final void setEnterBundleExtraParamsProvider(ILivePreviewMultiLinkCommonWidget.IEnterBundleExtraParamsProvider r100) {
        this.enterBundleExtraParamsProvider = r100;
    }

    public final void setKtvComponentExtraParamsProvider(ILivePreviewMultiLinkCommonWidget.IKtvComponentExtraParamsProvider r100) {
        this.ktvComponentExtraParamsProvider = r100;
    }

    public final void setMMultiLinkEffectService(IPreviewMultiLinkEffectService r100) {
        this.mMultiLinkEffectService = r100;
    }

    public final void setMRevenueFeedGameEffectService(IRevenueFeedGameEffectServiceContainer r100) {
        this.mRevenueFeedGameEffectService = r100;
    }
}
