package h8;

import android.view.View;
import com.bytedance.android.annie.Annie;
import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.api.resource.AnnieResType;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import k9.e;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public final class c extends b7.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b7.b f484052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<? extends b7.a> f484053b;

    public c() {
        this(null);
    }

    @Override // b7.a, b7.b
    public final void onBeforeGlobalPropsInitialize() {
        b7.b r100 = this.f484052a;
        if (r100 == null) goto L5;
        r100.onBeforeGlobalPropsInitialize();
    L5:
        Iterator<T> r101 = this.f484053b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((b7.a) r101.next()).onBeforeGlobalPropsInitialize();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onBeforeInitialPropsInitialize() {
        b7.b r100 = this.f484052a;
        if (r100 == null) goto L5;
        r100.onBeforeInitialPropsInitialize();
    L5:
        Iterator<T> r101 = this.f484053b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((b7.a) r101.next()).onBeforeInitialPropsInitialize();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onBeforeJsbRegister() {
        b7.b r100 = this.f484052a;
        if (r100 == null) goto L5;
        r100.onBeforeJsbRegister();
    L5:
        Iterator<T> r101 = this.f484053b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((b7.a) r101.next()).onBeforeJsbRegister();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onBeforeOpenContainer() {
        b7.b r100 = this.f484052a;
        if (r100 == null) goto L5;
        r100.onBeforeOpenContainer();
    L5:
        Iterator<T> r101 = this.f484053b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((b7.a) r101.next()).onBeforeOpenContainer();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onCardLoadStart() {
        b7.b r100 = this.f484052a;
        if (r100 == null) goto L5;
        r100.onCardLoadStart();
    L5:
        Iterator<T> r101 = this.f484053b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((b7.a) r101.next()).onCardLoadStart();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onContainerInitEnd() {
        b7.b r100 = this.f484052a;
        if (r100 == null) goto L5;
        r100.onContainerInitEnd();
    L5:
        Iterator<T> r101 = this.f484053b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((b7.a) r101.next()).onContainerInitEnd();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onContainerInitStart() {
        b7.b r100 = this.f484052a;
        if (r100 == null) goto L5;
        r100.onContainerInitStart();
    L5:
        Iterator<T> r101 = this.f484053b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((b7.a) r101.next()).onContainerInitStart();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onEngineLoadEnd() {
        b7.b r100 = this.f484052a;
        if (r100 == null) goto L5;
        r100.onEngineLoadEnd();
    L5:
        Iterator<T> r101 = this.f484053b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((b7.a) r101.next()).onEngineLoadEnd();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onEngineLoadStart() {
        b7.b r100 = this.f484052a;
        if (r100 == null) goto L5;
        r100.onEngineLoadStart();
    L5:
        Iterator<T> r101 = this.f484053b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((b7.a) r101.next()).onEngineLoadStart();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onGlobalPropsInitialized() {
        b7.b r100 = this.f484052a;
        if (r100 == null) goto L5;
        r100.onGlobalPropsInitialized();
    L5:
        Iterator<T> r101 = this.f484053b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((b7.a) r101.next()).onGlobalPropsInitialized();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onInitialPropsInitialized() {
        b7.b r100 = this.f484052a;
        if (r100 == null) goto L5;
        r100.onInitialPropsInitialized();
    L5:
        Iterator<T> r101 = this.f484053b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((b7.a) r101.next()).onInitialPropsInitialized();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onJsbRegistered() {
        b7.b r100 = this.f484052a;
        if (r100 == null) goto L5;
        r100.onJsbRegistered();
    L5:
        Iterator<T> r101 = this.f484053b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((b7.a) r101.next()).onJsbRegistered();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onLynxEnvInitialized() {
        b7.b r100 = this.f484052a;
        if (r100 == null) goto L5;
        r100.onLynxEnvInitialized();
    L5:
        Iterator<T> r101 = this.f484053b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((b7.a) r101.next()).onLynxEnvInitialized();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onLynxFirstScreen() {
        b7.b r100 = this.f484052a;
        if (r100 == null) goto L5;
        r100.onLynxFirstScreen();
    L5:
        Iterator<T> r101 = this.f484053b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((b7.a) r101.next()).onLynxFirstScreen();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onPrepareComponentEnd() {
        b7.b r100 = this.f484052a;
        if (r100 == null) goto L5;
        r100.onPrepareComponentEnd();
    L5:
        Iterator<T> r101 = this.f484053b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((b7.a) r101.next()).onPrepareComponentEnd();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onPrepareComponentStart() {
        b7.b r100 = this.f484052a;
        if (r100 == null) goto L5;
        r100.onPrepareComponentStart();
    L5:
        Iterator<T> r101 = this.f484053b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((b7.a) r101.next()).onPrepareComponentStart();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onPrepareInitDataEnd() {
        b7.b r100 = this.f484052a;
        if (r100 == null) goto L5;
        r100.onPrepareInitDataEnd();
    L5:
        Iterator<T> r101 = this.f484053b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((b7.a) r101.next()).onPrepareInitDataEnd();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onPrepareTemplateStart() {
        b7.b r100 = this.f484052a;
        if (r100 == null) goto L5;
        r100.onPrepareTemplateStart();
    L5:
        Iterator<T> r101 = this.f484053b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((b7.a) r101.next()).onPrepareTemplateStart();
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onRelease() {
        b7.b r100 = this.f484052a;
        if (r100 == null) goto L5;
        r100.onRelease();
    L5:
        Iterator<T> r101 = this.f484053b.iterator();
    L7:
        if (r101.hasNext() == false) goto L9;
        ((b7.a) r101.next()).onRelease();
        goto L7
    }

    public c(b7.b r100) {
        this.f484052a = r100;
        int r101 = j9.c.f497759a;
        this.f484053b = ((e) Annie.getService$default(e.class, null, 2, null)).T();
    }

    @Override // b7.a, b7.b
    public final void onAttachedToWindow(String r100) {
        b7.b r101 = this.f484052a;
        if (r101 == null) goto L5;
        r101.onAttachedToWindow(r100);
    L5:
        Iterator<T> r102 = this.f484053b.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((b7.a) r102.next()).onAttachedToWindow(r100);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onBeforeCreateRenderData(View r100) {
        Intrinsics.checkNotNullParameter(r100, "hybridView");
        b7.b r101 = this.f484052a;
        if (r101 == null) goto L5;
        r101.onBeforeCreateRenderData(r100);
    L5:
        Iterator<T> r102 = this.f484053b.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((b7.a) r102.next()).onBeforeCreateRenderData(r100);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onBeforeLynxEnvInitialize(boolean r100) {
        b7.b r101 = this.f484052a;
        if (r101 == null) goto L5;
        r101.onBeforeLynxEnvInitialize(r100);
    L5:
        Iterator<T> r102 = this.f484053b.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((b7.a) r102.next()).onBeforeLynxEnvInitialize(r100);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onInit(c7.a r100) {
        Intrinsics.checkNotNullParameter(r100, "annieContext");
        b7.b r101 = this.f484052a;
        if (r101 == null) goto L5;
        r101.onInit(r100);
    L5:
        Iterator<T> r102 = this.f484053b.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((b7.a) r102.next()).onInit(r100);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onLoadSuccess(View r100) {
        b7.b r101 = this.f484052a;
        if (r101 == null) goto L5;
        r101.onLoadSuccess(r100);
    L5:
        Iterator<T> r102 = this.f484053b.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((b7.a) r102.next()).onLoadSuccess(r100);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onPrepareTemplateEnd(boolean r100) {
        b7.b r101 = this.f484052a;
        if (r101 == null) goto L5;
        r101.onPrepareTemplateEnd(r100);
    L5:
        Iterator<T> r102 = this.f484053b.iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((b7.a) r102.next()).onPrepareTemplateEnd(r100);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onCreateRenderData(View r100, Set<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "hybridView");
        Intrinsics.checkNotNullParameter(r101, "stateKeys");
        b7.b r102 = this.f484052a;
        if (r102 == null) goto L5;
        r102.onCreateRenderData(r100, r101);
    L5:
        Iterator<T> r103 = this.f484053b.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        ((b7.a) r103.next()).onCreateRenderData(r100, r101);
        goto L7
    }

    @Override // b7.a, b7.b
    public final boolean onFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        Iterator<T> r102 = this.f484053b.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((b7.a) r102.next()).onFallback(r100, r101);
        goto L4
    L6:
        b7.b r103 = this.f484052a;
        if (r103 == null) goto L10;
        return r103.onFallback(r100, r101);
    L10:
        return super.onFallback(r100, r101);
    }

    @Override // b7.a, b7.b
    public final void onInnerFallback(int r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "errorMessage");
        b7.b r102 = this.f484052a;
        if (r102 == null) goto L5;
        r102.onInnerFallback(r100, r101);
    L5:
        Iterator<T> r103 = this.f484053b.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        ((b7.a) r103.next()).onInnerFallback(r100, r101);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onLoadStart(View r100, boolean r101) {
        b7.b r102 = this.f484052a;
        if (r102 == null) goto L5;
        r102.onLoadStart(r100, r101);
    L5:
        Iterator<T> r103 = this.f484053b.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        ((b7.a) r103.next()).onLoadStart(r100, r101);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onPrepareTemplateEnd(boolean r100, String r101) {
        Intrinsics.checkNotNullParameter(r101, "resFrom");
        b7.b r102 = this.f484052a;
        if (r102 == null) goto L5;
        r102.onPrepareTemplateEnd(r100, r101);
    L5:
        Iterator<T> r103 = this.f484053b.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        ((b7.a) r103.next()).onPrepareTemplateEnd(r100, r101);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onAttachView(View r100, IHybridComponent.HybridType r101, String r102) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "hybridType");
        b7.b r103 = this.f484052a;
        if (r103 == null) goto L5;
        r103.onAttachView(r100, r101, r102);
    L5:
        Iterator<T> r104 = this.f484053b.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        ((b7.a) r104.next()).onAttachView(r100, r101, r102);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onContainerError(View r100, int r101, String r102) {
        Intrinsics.checkNotNullParameter(r102, "errorMessage");
        b7.b r103 = this.f484052a;
        if (r103 == null) goto L5;
        r103.onContainerError(r100, r101, r102);
    L5:
        Iterator<T> r104 = this.f484053b.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        ((b7.a) r104.next()).onContainerError(r100, r101, r102);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onLoadFail(View r100, String r101, String r102) {
        b7.b r103 = this.f484052a;
        if (r103 == null) goto L5;
        r103.onLoadFail(r100, r101, r102);
    L5:
        Iterator<T> r104 = this.f484053b.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        ((b7.a) r104.next()).onLoadFail(r100, r101, r102);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onPrepareInitDataStart(String r100, String r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, "scheme");
        Intrinsics.checkNotNullParameter(r101, "fallbackUrl");
        b7.b r103 = this.f484052a;
        if (r103 == null) goto L5;
        r103.onPrepareInitDataStart(r100, r101, r102);
    L5:
        Iterator<T> r104 = this.f484053b.iterator();
    L7:
        if (r104.hasNext() == false) goto L9;
        ((b7.a) r104.next()).onPrepareInitDataStart(r100, r101, r102);
        goto L7
    }

    @Override // b7.a, b7.b
    public final void onBeforeLoadRequest(String r100, AnnieResType r101, IHybridComponent.HybridType r102, Map<String, Object> r103) {
        Intrinsics.checkNotNullParameter(r100, "url");
        Intrinsics.checkNotNullParameter(r101, "resType");
        Intrinsics.checkNotNullParameter(r102, "type");
        b7.b r104 = this.f484052a;
        if (r104 == null) goto L5;
        r104.onBeforeLoadRequest(r100, r101, r102, r103);
    L5:
        Iterator<T> r105 = this.f484053b.iterator();
    L7:
        if (r105.hasNext() == false) goto L9;
        ((b7.a) r105.next()).onBeforeLoadRequest(r100, r101, r102, r103);
        goto L7
    }
}
