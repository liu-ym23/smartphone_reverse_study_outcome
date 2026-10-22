package com.bytedance.android.shopping.store.viewmodel;

import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.arch.viewmodel.QStateViewModel;
import com.bytedance.android.ec.core.async.DisposableScope;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u001b\u0012\b\b\u0002\u0010,\u001a\u00020+\u0012\b\b\u0002\u0010.\u001a\u00020\u0004¢\u0006\u0004\b0\u00101J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0011\u0010\t\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J\t\u0010\n\u001a\u00020\u0005H\u0096\u0001J\t\u0010\f\u001a\u00020\u000bH\u0096\u0001J\u0011\u0010\r\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0096\u0001J@\u0010\u0012\u001a\u00020\u00052.\u0010\u0011\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f0\u000e\"\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0096\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0012\u001a\u00020\u00052\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014H\u0096\u0001J\u001a\u0010\u0018\u001a\u00020\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0096\u0001¢\u0006\u0004\b\u0018\u0010\u0019J\t\u0010\u001a\u001a\u00020\u0005H\u0096\u0001J`\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00102\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u00142.\u0010\u0011\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u000f0\u000e\"\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u000fH\u0096\u0001¢\u0006\u0004\b\u001d\u0010\u001eJp\u0010\"\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010!\u001a\u00020 2\u0006\u0010\u001b\u001a\u00020\u00102\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c\u0018\u00010\u00142.\u0010\u0011\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u000f0\u000e\"\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001c0\u000fH\u0096\u0001¢\u0006\u0004\b\"\u0010#JH\u0010$\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00102.\u0010\u0011\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f0\u000e\"\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0096\u0001¢\u0006\u0004\b$\u0010%J\\\u0010$\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u00102\b\u0010!\u001a\u0004\u0018\u00010 2.\u0010\u0011\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f0\u000e\"\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0096\u0001¢\u0006\u0004\b$\u0010&J;\u0010$\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00102\b\u0010\u001f\u001a\u0004\u0018\u00010\u00102\b\u0010!\u001a\u0004\u0018\u00010 2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014H\u0096\u0001J`\u0010$\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u00102\u0016\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u00142.\u0010\u0011\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f0\u000e\"\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0096\u0001¢\u0006\u0004\b$\u0010\u001eJ\u0017\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014H\u0096\u0001J\t\u0010)\u001a\u00020\u0010H\u0096\u0001J@\u0010*\u001a\u00020\u00052.\u0010\u0011\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f0\u000e\"\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000fH\u0096\u0001¢\u0006\u0004\b*\u0010\u0013J\u001f\u0010*\u001a\u00020\u00052\u0014\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0014H\u0096\u0001R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b.\u0010/¨\u00062"}, d2 = {"Lcom/bytedance/android/shopping/store/viewmodel/ECStoreBaseViewModel;", "Lcom/bytedance/android/ec/core/arch/viewmodel/QStateViewModel;", "Lcom/bytedance/android/shopping/store/viewmodel/j;", "Lcom/bytedance/android/ec/core/async/b;", "Lcom/bytedance/android/ec/core/event/c;", "", "onCleared", "Lio/reactivex/disposables/Disposable;", "disposable", "add", "clearDisposable", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDisposable", "remove", "", "Lkotlin/Pair;", "", "params", "appendEventParams", "([Lkotlin/Pair;)V", "", "paramsMap", "", "monitorId", "bindMonitorId", "(Ljava/lang/Long;)V", "clearEventParams", "actionName", "", "doAnyEventAction", "(Ljava/lang/String;Ljava/util/Map;[Lkotlin/Pair;)V", "btm", "Lcom/bytedance/android/btm/api/model/PageFinder;", "pageFinder", "doAnyEventActionWithBtm", "(Ljava/lang/String;Lcom/bytedance/android/btm/api/model/PageFinder;Ljava/lang/String;Ljava/util/Map;[Lkotlin/Pair;)V", "doEventAction", "(Ljava/lang/String;[Lkotlin/Pair;)V", "(Ljava/lang/String;Ljava/lang/String;Lcom/bytedance/android/btm/api/model/PageFinder;[Lkotlin/Pair;)V", "paramMap", "getBaseParams", "getBaseParamsJson", "initEventContext", "Lcom/bytedance/android/ec/core/async/DisposableScope;", "disposableContext", "Lcom/bytedance/android/ec/core/async/DisposableScope;", "eventAction", "Lcom/bytedance/android/ec/core/event/c;", "<init>", "(Lcom/bytedance/android/ec/core/async/DisposableScope;Lcom/bytedance/android/ec/core/event/c;)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public class ECStoreBaseViewModel extends QStateViewModel<j> implements com.bytedance.android.ec.core.async.b, com.bytedance.android.ec.core.event.c {
    private final DisposableScope disposableContext;
    private final com.bytedance.android.ec.core.event.c eventAction;

    public ECStoreBaseViewModel() {
        DisposableScope r0 = null;
        this(r0, r0, 3, r0);
    }

    public Disposable add(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.disposableContext.add(r2);
        return r2;
    }

    public void appendEventParams(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "paramsMap");
        this.eventAction.appendEventParams(r2);
    }

    public void appendEventParams(Pair<String, String>... r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.eventAction.appendEventParams(r2);
    }

    public void bindMonitorId(Long r2) {
        this.eventAction.bindMonitorId(r2);
    }

    public void clearDisposable() {
        this.disposableContext.clearDisposable();
    }

    public void clearEventParams() {
        this.eventAction.clearEventParams();
    }

    public void doAnyEventAction(String r2, Map<String, ? extends Object> r3, Pair<String, ? extends Object>... r4) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.eventAction.doAnyEventAction(r2, r3, r4);
    }

    public void doAnyEventActionWithBtm(String r8, PageFinder r9, String r10, Map<String, ? extends Object> r11, Pair<String, ? extends Object>... r12) {
        Intrinsics.checkNotNullParameter(r8, "btm");
        Intrinsics.checkNotNullParameter(r9, "pageFinder");
        Intrinsics.checkNotNullParameter(r10, "actionName");
        Intrinsics.checkNotNullParameter(r12, "params");
        this.eventAction.doAnyEventActionWithBtm(r8, r9, r10, r11, r12);
    }

    public void doEventAction(String r2, String r3, PageFinder r4, Map<String, String> r5) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r5, "paramMap");
        this.eventAction.doEventAction(r2, r3, r4, r5);
    }

    public void doEventAction(String r2, String r3, PageFinder r4, Pair<String, String>... r5) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r5, "params");
        this.eventAction.doEventAction(r2, r3, r4, r5);
    }

    public void doEventAction(String r2, Map<String, String> r3, Pair<String, String>... r4) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r4, "params");
        this.eventAction.doEventAction(r2, r3, r4);
    }

    public void doEventAction(String r2, Pair<String, String>... r3) {
        Intrinsics.checkNotNullParameter(r2, "actionName");
        Intrinsics.checkNotNullParameter(r3, "params");
        this.eventAction.doEventAction(r2, r3);
    }

    public Map<String, String> getBaseParams() {
        return this.eventAction.getBaseParams();
    }

    public String getBaseParamsJson() {
        return this.eventAction.getBaseParamsJson();
    }

    public void initEventContext(Map<String, String> r2) {
        Intrinsics.checkNotNullParameter(r2, "paramsMap");
        this.eventAction.initEventContext(r2);
    }

    public void initEventContext(Pair<String, String>... r2) {
        Intrinsics.checkNotNullParameter(r2, "params");
        this.eventAction.initEventContext(r2);
    }

    public void remove(Disposable r2) {
        Intrinsics.checkNotNullParameter(r2, "disposable");
        this.disposableContext.remove(r2);
    }

    public CompositeDisposable compositeDisposable() {
        return this.disposableContext.a();
    }

    public void onCleared() {
        super/*com.ss.android.ugc.aweme.kiwi.viewmodel.QViewModel*/.onCleared();
        clearDisposable();
    }

    public ECStoreBaseViewModel(DisposableScope r2, com.bytedance.android.ec.core.event.c r3) {
        Intrinsics.checkNotNullParameter(r2, "disposableContext");
        Intrinsics.checkNotNullParameter(r3, "eventAction");
        super(new j());
        this.disposableContext = r2;
        this.eventAction = r3;
    }

    public /* synthetic */ ECStoreBaseViewModel(DisposableScope r1, com.bytedance.android.ec.core.event.c r2, int r3, DefaultConstructorMarker r4) {
        if ((r3 & 1) == 0) goto L6;
        r1 = new DisposableScope();
    L6:
        if ((r3 & 2) == 0) goto L8;
        r2 = new ui3.f();
    L8:
        this(r1, r2);
    }
}
