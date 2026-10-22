package com.larus.avlink.simulInterpret.page.model;

import com.baidu.platform.comapi.map.MapController;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.dtf.face.config.IConstValues;
import com.larus.dora.api.DoraConfig;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.platform.service.z2;
import com.larus.ui.arch.vm.ComponentViewModel;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ea8.c;
import ea8.e;
import ea8.f;
import ea8.g;
import ea8.h;
import ea8.i;
import ea8.j;
import ea8.k;
import ea8.l;
import ea8.m;
import ea8.n;
import ea8.o;
import ea8.p;
import ea8.q;
import ea8.r;
import ea8.s;
import ea8.t;
import ea8.u;
import ea8.v;
import ea8.w;
import ea8.x;
import ha8.d;
import hq9.z0;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0002J\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u0006\u0010\u0011\u001a\u00020\fJ\u001e\u0010\u0012\u001a\u00020\n2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0014J\b\u0010\u0016\u001a\u00020\fH\u0002J\u000e\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u0019J\u0016\u0010\u001a\u001a\u00020\f2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u0007J\u0016\u0010\u001f\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u001cJ\u0006\u0010 \u001a\u00020\fJ\u000e\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\nJ\u0006\u0010#\u001a\u00020\u0014J\u0006\u0010$\u001a\u00020\u0014R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/larus/avlink/simulInterpret/page/model/SimultaneousInterpretViewModel;", "Lcom/larus/ui/arch/vm/ComponentViewModel;", "Lcom/larus/avlink/simulInterpret/page/model/SimultaneousInterpretState;", "<init>", "()V", "topTranslationResultWorkList", "", "Lcom/larus/avlink/simulInterpret/page/model/TranslationResultItem;", "bottomTranslationResultWorkList", "languagesLoaded", "", "loadLanguagesFromConfigIfNeeded", "", "loadHistoryResult", "updateScreenMode", "mode", "Lcom/larus/avlink/simulInterpret/page/model/ScreenMode;", "clear", "switchLanguage", "dstLanguage", "Lcom/larus/avlink/simulInterpret/page/model/Language;", "srcLanguage", "swapLanguages", "updateTopTranslationResult", "sentence", "Lcom/larus/avlink/simulInterpret/page/model/TranslationResultSentence;", "updateBottomTranslationResult", IConstValues.DEVICE_TYPE, "Lcom/larus/avlink/simulInterpret/page/model/DoraDeviceType;", "forceReplaceTopTranslationResult", MapController.ITEM_LAYER_TAG, "forceReplaceBottomTranslationResult", "toggleMuteState", "setRotatedStatus", "isRotated", "getTopLanguage", "getBottomLanguage", "dora_avlink_impl_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class SimultaneousInterpretViewModel extends ComponentViewModel<SimultaneousInterpretState> {
    public static final int $stable = 8;
    private final List<w> bottomTranslationResultWorkList;
    private boolean languagesLoaded;
    private final List<w> topTranslationResultWorkList;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f294486a = null;

        static {
            int[] r100 = new int[TextType.values().length];
            r100[TextType.ORIGINAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[TextType.TRANSLATION.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f294486a = r100;
        }
    }

    public static /* synthetic */ SimultaneousInterpretState No(com.larus.avlink.simulInterpret.page.model.a r100, com.larus.avlink.simulInterpret.page.model.a r101, SimultaneousInterpretState r102) {
        return swapLanguages$lambda$12$lambda$11(r100, r101, r102);
    }

    public static /* synthetic */ SimultaneousInterpretState Oo(com.larus.avlink.simulInterpret.page.model.a r100, com.larus.avlink.simulInterpret.page.model.a r101, SimultaneousInterpretState r102) {
        return loadLanguagesFromConfigIfNeeded$lambda$1$lambda$0(r100, r101, r102);
    }

    public static /* synthetic */ SimultaneousInterpretState Po(com.larus.avlink.simulInterpret.page.model.a r100, com.larus.avlink.simulInterpret.page.model.a r101, SimultaneousInterpretState r102) {
        return switchLanguage$lambda$10$lambda$5(r100, r101, r102);
    }

    public static /* synthetic */ SimultaneousInterpretState Qo(List r100, SimultaneousInterpretState r101) {
        return forceReplaceBottomTranslationResult$lambda$20(r100, r101);
    }

    public static /* synthetic */ Unit So(b r100, SimultaneousInterpretViewModel r101, SimultaneousInterpretState r102) {
        return updateScreenMode$lambda$4(r100, r101, r102);
    }

    public static /* synthetic */ SimultaneousInterpretState To(List r100, SimultaneousInterpretState r101) {
        return updateTopTranslationResult$lambda$14(r100, r101);
    }

    public static /* synthetic */ SimultaneousInterpretState Wo(com.larus.avlink.simulInterpret.page.model.a r100, SimultaneousInterpretState r101) {
        return switchLanguage$lambda$10$lambda$7(r100, r101);
    }

    public static /* synthetic */ Unit Yo(SimultaneousInterpretViewModel r100, SimultaneousInterpretState r101) {
        return toggleMuteState$lambda$22(r100, r101);
    }

    public static /* synthetic */ Unit Zo(com.larus.avlink.simulInterpret.page.model.a r100, com.larus.avlink.simulInterpret.page.model.a r101, SimultaneousInterpretViewModel r102, Ref.BooleanRef r103, SimultaneousInterpretState r104) {
        return switchLanguage$lambda$10(r100, r101, r102, r103, r104);
    }

    public static /* synthetic */ Unit ap(com.larus.avlink.simulInterpret.page.model.a r100, com.larus.avlink.simulInterpret.page.model.a r101, SimultaneousInterpretViewModel r102, SimultaneousInterpretState r103) {
        return loadLanguagesFromConfigIfNeeded$lambda$1(r100, r101, r102, r103);
    }

    public static /* synthetic */ SimultaneousInterpretState bp(boolean r100, SimultaneousInterpretState r101) {
        return toggleMuteState$lambda$22$lambda$21(r100, r101);
    }

    public static /* synthetic */ SimultaneousInterpretState cp(b r100, SimultaneousInterpretState r101) {
        return updateScreenMode$lambda$4$lambda$3(r100, r101);
    }

    public static /* synthetic */ SimultaneousInterpretState dp(List r100, SimultaneousInterpretState r101) {
        return forceReplaceTopTranslationResult$lambda$18(r100, r101);
    }

    public static /* synthetic */ Unit ep(SimultaneousInterpretViewModel r100, SimultaneousInterpretState r101) {
        return swapLanguages$lambda$12(r100, r101);
    }

    public static /* synthetic */ SimultaneousInterpretState hp(SimultaneousInterpretViewModel r100, SimultaneousInterpretState r101) {
        return loadHistoryResult$lambda$2(r100, r101);
    }

    public static /* synthetic */ SimultaneousInterpretState ip(List r100, SimultaneousInterpretState r101) {
        return updateBottomTranslationResult$lambda$16(r100, r101);
    }

    public static /* synthetic */ SimultaneousInterpretState kp(com.larus.avlink.simulInterpret.page.model.a r100, SimultaneousInterpretState r101) {
        return switchLanguage$lambda$10$lambda$8(r100, r101);
    }

    public static /* synthetic */ SimultaneousInterpretState lp(com.larus.avlink.simulInterpret.page.model.a r100, SimultaneousInterpretState r101) {
        return switchLanguage$lambda$10$lambda$9(r100, r101);
    }

    public static /* synthetic */ SimultaneousInterpretState np(boolean r100, SimultaneousInterpretState r101) {
        return setRotatedStatus$lambda$23(r100, r101);
    }

    public static /* synthetic */ SimultaneousInterpretState pp(com.larus.avlink.simulInterpret.page.model.a r100, SimultaneousInterpretState r101) {
        return switchLanguage$lambda$10$lambda$6(r100, r101);
    }

    private final void loadLanguagesFromConfigIfNeeded() {
        if (this.languagesLoaded == false) goto L5;
        return;
    L5:
        boolean r100 = true;
        this.languagesLoaded = true;
        List<z0> r101 = z2.f365865a.getDoraSimulSupportLangConfigList();
        IDoraService r102 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r102 == null) goto L12;
        DeviceService r103 = r102.device();
        if (r103 == null) goto L12;
        if (r103.b0() != true) goto L12;
        boolean r104 = true;
    L13:
        if (r104 == false) goto L15;
        String r105 = DoraConfig.d();
    L16:
        IDoraService r106 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r106 == null) goto L23;
        DeviceService r107 = r106.device();
        if (r107 == null) goto L23;
        if (r107.b0() != true) goto L23;
    L24:
        if (r100 == false) goto L26;
        String r108 = DoraConfig.c();
    L27:
        com.larus.avlink.simulInterpret.page.model.a r109 = com.larus.avlink.simulInterpret.page.model.a.f294491e;
        final com.larus.avlink.simulInterpret.page.model.a r110 = com.larus.avlink.simulInterpret.page.model.a.C4011a.a(r105, r101);
        if (r110 != null) goto L30;
        r110 = com.larus.avlink.simulInterpret.page.model.a.f294492f;
    L30:
        final com.larus.avlink.simulInterpret.page.model.a r111 = com.larus.avlink.simulInterpret.page.model.a.C4011a.a(r108, r101);
        if (r111 != null) goto L33;
        r111 = com.larus.avlink.simulInterpret.page.model.a.f294491e;
    L33:
        withState(new s(r110, r111, this));
        return;
    L26:
        r108 = DoraConfig.a();
    L23:
        r100 = false;
        goto L24
    L15:
        r105 = DoraConfig.b();
    L12:
        r104 = false;
        goto L13
    }

    private final void swapLanguages() {
        withState(new n(this));
    }

    public final void clear() {
        this.topTranslationResultWorkList.clear();
        this.bottomTranslationResultWorkList.clear();
    }

    public final void toggleMuteState() {
        withState(new u(this));
    }

    public SimultaneousInterpretViewModel() {
        this.topTranslationResultWorkList = new ArrayList();
        this.bottomTranslationResultWorkList = new ArrayList();
    }

    public final com.larus.avlink.simulInterpret.page.model.a getBottomLanguage() {
        loadLanguagesFromConfigIfNeeded();
        return getState().getBottomTranslateLanguage();
    }

    public final com.larus.avlink.simulInterpret.page.model.a getTopLanguage() {
        loadLanguagesFromConfigIfNeeded();
        return getState().getTopTranslateLanguage();
    }

    public final void loadHistoryResult() {
        loadLanguagesFromConfigIfNeeded();
        boolean r100 = d.f484397a;
        CopyOnWriteArrayList<w> r101 = d.f484399c;
        if (r101.isEmpty() == true) goto L5;
        this.topTranslationResultWorkList.addAll(r101);
    L5:
        CopyOnWriteArrayList<w> r102 = d.f484400d;
        if (r102.isEmpty() == true) goto L8;
        this.bottomTranslationResultWorkList.addAll(r102);
    L8:
        setState(new t(this));
    }

    public final void forceReplaceTopTranslationResult(w r100) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        List<w> r101 = this.topTranslationResultWorkList;
        ListIterator<w> r102 = r101.listIterator(r101.size());
    L4:
        if (r102.hasPrevious() == false) goto L8;
        if (Intrinsics.areEqual(r102.previous().f471658a, r100.f471658a) == false) goto L4;
        int r103 = r102.nextIndex();
    L9:
        if (r103 == (-1)) goto L15;
        ListProtector.set(this.topTranslationResultWorkList, r103, r100);
        final List r104 = CollectionsKt.toList(this.topTranslationResultWorkList);
        setState(new l(r104));
        return;
    L15:
        return;
    L8:
        r103 = -1;
        goto L9
    }

    public final void setRotatedStatus(final boolean r100) {
        setState(new j(r100));
    }

    public final void updateScreenMode(final b r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        withState(new q(r100, this));
    }

    public final void updateTopTranslationResult(x r100) {
        Intrinsics.checkNotNullParameter(r100, "sentence");
        List<w> r101 = this.topTranslationResultWorkList;
        ListIterator<w> r102 = r101.listIterator(r101.size());
    L4:
        if (r102.hasPrevious() == false) goto L8;
        if (Intrinsics.areEqual(r102.previous().f471658a, r100.f471662b) == false) goto L4;
        int r103 = r102.nextIndex();
    L10:
        if (r103 == (-1)) goto L19;
        w r104 = (w) ListProtector.get(this.topTranslationResultWorkList, r103);
        int r105 = a.f294486a[r100.getType().ordinal()];
        if (r105 == 1) goto L17;
        if (r105 != 2) goto L16;
        w r106 = w.a(r104, null, StringsKt.trim(r104.f471660c + r100.f471663c).toString(), 3);
    L18:
        ListProtector.set(this.topTranslationResultWorkList, r103, r106);
    L27:
        final List r107 = CollectionsKt.toList(this.topTranslationResultWorkList);
        setState(new v(r107));
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        r106 = w.a(r104, StringsKt.trim(r104.f471659b + r100.f471663c).toString(), null, 5);
        goto L18
    L19:
        int r108 = a.f294486a[r100.getType().ordinal()];
        if (r108 == 1) goto L25;
        if (r108 != 2) goto L24;
        w r109 = new w(r100.f471662b, "", StringsKt.trim(r100.f471663c).toString());
    L26:
        this.topTranslationResultWorkList.add(r109);
        goto L27
    L24:
        throw new NoWhenBranchMatchedException();
    L25:
        r109 = new w(r100.f471662b, StringsKt.trim(r100.f471663c).toString(), "");
        goto L26
    L8:
        r103 = -1;
        goto L10
    }

    private static final SimultaneousInterpretState forceReplaceBottomTranslationResult$lambda$20(List r110, SimultaneousInterpretState r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$setState");
        return SimultaneousInterpretState.copy$default(r111, null, null, null, false, null, r110, null, 95, null);
    }

    private static final SimultaneousInterpretState forceReplaceTopTranslationResult$lambda$18(List r110, SimultaneousInterpretState r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$setState");
        return SimultaneousInterpretState.copy$default(r111, null, null, null, false, r110, null, null, 111, null);
    }

    private static final SimultaneousInterpretState loadHistoryResult$lambda$2(SimultaneousInterpretViewModel r110, SimultaneousInterpretState r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$setState");
        return SimultaneousInterpretState.copy$default(r111, null, null, null, false, CollectionsKt.toList(r110.topTranslationResultWorkList), CollectionsKt.toList(r110.bottomTranslationResultWorkList), null, 79, null);
    }

    private static final SimultaneousInterpretState setRotatedStatus$lambda$23(boolean r110, SimultaneousInterpretState r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$setState");
        return SimultaneousInterpretState.copy$default(r111, null, null, null, false, null, null, Boolean.valueOf(r110), 63, null);
    }

    private static final Unit swapLanguages$lambda$12(SimultaneousInterpretViewModel r100, SimultaneousInterpretState r101) {
        Intrinsics.checkNotNullParameter(r101, "it");
        final com.larus.avlink.simulInterpret.page.model.a r102 = r101.getTopTranslateLanguage();
        final com.larus.avlink.simulInterpret.page.model.a r103 = r101.getBottomTranslateLanguage();
        IDoraService r104 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r104 == null) goto L9;
        DeviceService r105 = r104.device();
        if (r105 == null) goto L9;
        boolean r106 = true;
        if (r105.b0() != true) goto L9;
    L10:
        if (r106 == false) goto L12;
        Keva r107 = DoraConfig.f331707a;
        DoraConfig.k(r103.f294494b);
        DoraConfig.j(r102.f294494b);
    L13:
        r100.setState(new r(r103, r102));
        return Unit.INSTANCE;
    L12:
        Keva r108 = DoraConfig.f331707a;
        DoraConfig.i(r103.f294494b);
        DoraConfig.h(r102.f294494b);
    L9:
        r106 = false;
        goto L10
    }

    private static final SimultaneousInterpretState switchLanguage$lambda$10$lambda$6(com.larus.avlink.simulInterpret.page.model.a r110, SimultaneousInterpretState r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$setState");
        com.larus.avlink.simulInterpret.page.model.a r100 = com.larus.avlink.simulInterpret.page.model.a.f294491e;
        return SimultaneousInterpretState.copy$default(r111, null, r110, com.larus.avlink.simulInterpret.page.model.a.f294491e, false, null, null, null, 121, null);
    }

    private static final SimultaneousInterpretState switchLanguage$lambda$10$lambda$7(com.larus.avlink.simulInterpret.page.model.a r110, SimultaneousInterpretState r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$setState");
        return SimultaneousInterpretState.copy$default(r111, null, r110, null, false, null, null, null, 125, null);
    }

    private static final SimultaneousInterpretState switchLanguage$lambda$10$lambda$8(com.larus.avlink.simulInterpret.page.model.a r110, SimultaneousInterpretState r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$setState");
        com.larus.avlink.simulInterpret.page.model.a r100 = com.larus.avlink.simulInterpret.page.model.a.f294491e;
        return SimultaneousInterpretState.copy$default(r111, null, com.larus.avlink.simulInterpret.page.model.a.f294491e, r110, false, null, null, null, 121, null);
    }

    private static final SimultaneousInterpretState switchLanguage$lambda$10$lambda$9(com.larus.avlink.simulInterpret.page.model.a r110, SimultaneousInterpretState r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$setState");
        return SimultaneousInterpretState.copy$default(r111, null, null, r110, false, null, null, null, 123, null);
    }

    private static final Unit toggleMuteState$lambda$22(SimultaneousInterpretViewModel r100, SimultaneousInterpretState r101) {
        Intrinsics.checkNotNullParameter(r101, "it");
        final boolean r102 = !r101.isSiMute();
        DoraConfig.f331707a.storeBoolean("key_si_mute", r102);
        r100.setState(new c(r102));
        return Unit.INSTANCE;
    }

    private static final SimultaneousInterpretState toggleMuteState$lambda$22$lambda$21(boolean r110, SimultaneousInterpretState r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$setState");
        return SimultaneousInterpretState.copy$default(r111, null, null, null, r110, null, null, null, 119, null);
    }

    private static final SimultaneousInterpretState updateBottomTranslationResult$lambda$16(List r110, SimultaneousInterpretState r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$setState");
        return SimultaneousInterpretState.copy$default(r111, null, null, null, false, null, r110, null, 95, null);
    }

    private static final SimultaneousInterpretState updateScreenMode$lambda$4$lambda$3(b r110, SimultaneousInterpretState r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$setState");
        return SimultaneousInterpretState.copy$default(r111, r110, null, null, false, null, null, null, 126, null);
    }

    private static final SimultaneousInterpretState updateTopTranslationResult$lambda$14(List r110, SimultaneousInterpretState r111) {
        Intrinsics.checkNotNullParameter(r111, "$this$setState");
        return SimultaneousInterpretState.copy$default(r111, null, null, null, false, r110, null, null, 111, null);
    }

    public final void forceReplaceBottomTranslationResult(w r100, DoraDeviceType r101) {
        Intrinsics.checkNotNullParameter(r100, MapController.ITEM_LAYER_TAG);
        Intrinsics.checkNotNullParameter(r101, IConstValues.DEVICE_TYPE);
        List<w> r102 = this.bottomTranslationResultWorkList;
        ListIterator<w> r103 = r102.listIterator(r102.size());
    L4:
        if (r103.hasPrevious() == false) goto L8;
        if (Intrinsics.areEqual(r103.previous().f471658a, r100.f471658a) == false) goto L4;
        int r104 = r103.nextIndex();
    L9:
        if (r104 != (-1)) goto L11;
        return;
    L11:
        if (r101 != DoraDeviceType.DEVICE_LITE) goto L13;
        ListProtector.set(this.bottomTranslationResultWorkList, r104, r100);
    L14:
        final List r105 = CollectionsKt.toList(this.bottomTranslationResultWorkList);
        setState(new k(r105));
        return;
    L13:
        w r106 = w.a((w) ListProtector.get(this.bottomTranslationResultWorkList, r104), null, StringsKt.trim(r100.f471660c).toString(), 3);
        ListProtector.set(this.bottomTranslationResultWorkList, r104, r106);
        goto L14
    L8:
        r104 = -1;
        goto L9
    }

    public final boolean switchLanguage(final com.larus.avlink.simulInterpret.page.model.a r100, final com.larus.avlink.simulInterpret.page.model.a r101) {
        final Ref.BooleanRef r102 = new Ref.BooleanRef();
        withState(new o(r100, r101, this, r102));
        return r102.element;
    }

    public final void updateBottomTranslationResult(x r100, DoraDeviceType r101) {
        Intrinsics.checkNotNullParameter(r100, "sentence");
        Intrinsics.checkNotNullParameter(r101, IConstValues.DEVICE_TYPE);
        List<w> r102 = this.bottomTranslationResultWorkList;
        ListIterator<w> r103 = r102.listIterator(r102.size());
    L4:
        if (r103.hasPrevious() == false) goto L8;
        if (Intrinsics.areEqual(r103.previous().f471658a, r100.f471662b) == false) goto L4;
        int r104 = r103.nextIndex();
    L10:
        if (r104 == (-1)) goto L19;
        w r105 = (w) ListProtector.get(this.bottomTranslationResultWorkList, r104);
        int r106 = a.f294486a[r100.getType().ordinal()];
        if (r106 == 1) goto L17;
        if (r106 != 2) goto L16;
        w r107 = w.a(r105, null, StringsKt.trim(r105.f471660c + r100.f471663c).toString(), 3);
    L18:
        ListProtector.set(this.bottomTranslationResultWorkList, r104, r107);
    L27:
        final List r108 = CollectionsKt.toList(this.bottomTranslationResultWorkList);
        setState(new p(r108));
        return;
    L16:
        throw new NoWhenBranchMatchedException();
    L17:
        r107 = w.a(r105, StringsKt.trim(r105.f471659b + r100.f471663c).toString(), null, 5);
        goto L18
    L19:
        int r109 = a.f294486a[r100.getType().ordinal()];
        if (r109 == 1) goto L25;
        if (r109 != 2) goto L24;
        w r110 = new w(r100.f471662b, "", StringsKt.trim(r100.f471663c).toString());
    L26:
        this.bottomTranslationResultWorkList.add(r110);
        goto L27
    L24:
        throw new NoWhenBranchMatchedException();
    L25:
        r110 = new w(r100.f471662b, StringsKt.trim(r100.f471663c).toString(), "");
        goto L26
    L8:
        r104 = -1;
        goto L10
    }

    private static final SimultaneousInterpretState loadLanguagesFromConfigIfNeeded$lambda$1$lambda$0(com.larus.avlink.simulInterpret.page.model.a r110, com.larus.avlink.simulInterpret.page.model.a r111, SimultaneousInterpretState r112) {
        Intrinsics.checkNotNullParameter(r112, "$this$setState");
        return SimultaneousInterpretState.copy$default(r112, null, r110, r111, false, null, null, null, 121, null);
    }

    private static final SimultaneousInterpretState swapLanguages$lambda$12$lambda$11(com.larus.avlink.simulInterpret.page.model.a r110, com.larus.avlink.simulInterpret.page.model.a r111, SimultaneousInterpretState r112) {
        Intrinsics.checkNotNullParameter(r112, "$this$setState");
        return SimultaneousInterpretState.copy$default(r112, null, r110, r111, false, null, null, null, 121, null);
    }

    private static final SimultaneousInterpretState switchLanguage$lambda$10$lambda$5(com.larus.avlink.simulInterpret.page.model.a r110, com.larus.avlink.simulInterpret.page.model.a r111, SimultaneousInterpretState r112) {
        Intrinsics.checkNotNullParameter(r112, "$this$setState");
        return SimultaneousInterpretState.copy$default(r112, null, r110, r111, false, null, null, null, 121, null);
    }

    private static final Unit updateScreenMode$lambda$4(final b r100, SimultaneousInterpretViewModel r101, SimultaneousInterpretState r102) {
        Intrinsics.checkNotNullParameter(r102, "it");
        if (Intrinsics.areEqual(r102.getScreenMode(), r100) == true) goto L6;
        r101.setState(new m(r100));
    L6:
        return Unit.INSTANCE;
    }

    private static final Unit loadLanguagesFromConfigIfNeeded$lambda$1(final com.larus.avlink.simulInterpret.page.model.a r100, final com.larus.avlink.simulInterpret.page.model.a r101, SimultaneousInterpretViewModel r102, SimultaneousInterpretState r103) {
        Intrinsics.checkNotNullParameter(r103, "state");
        if (Intrinsics.areEqual(r103.getTopTranslateLanguage().f294494b, r100.f294494b) == true) goto L5;
    L6:
        r102.setState(new i(r100, r101));
    L8:
        return Unit.INSTANCE;
    L5:
        if (Intrinsics.areEqual(r103.getBottomTranslateLanguage().f294494b, r101.f294494b) == true) goto L8;
        goto L6
    }

    public static /* synthetic */ boolean switchLanguage$default(SimultaneousInterpretViewModel r100, com.larus.avlink.simulInterpret.page.model.a r101, com.larus.avlink.simulInterpret.page.model.a r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r102 = null;
    L9:
        return r100.switchLanguage(r101, r102);
    }

    private static final Unit switchLanguage$lambda$10(final com.larus.avlink.simulInterpret.page.model.a r100, final com.larus.avlink.simulInterpret.page.model.a r101, SimultaneousInterpretViewModel r102, Ref.BooleanRef r103, SimultaneousInterpretState r104) {
        Intrinsics.checkNotNullParameter(r104, "state");
        if (r100 != null) goto L6;
        if (r101 != null) goto L6;
        r102.swapLanguages();
    L84:
        return Unit.INSTANCE;
    L6:
        boolean r105 = true;
        boolean r106 = false;
        if (r100 == null) goto L21;
        if (r101 == null) goto L21;
        IDoraService r107 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r107 == null) goto L16;
        DeviceService r108 = r107.device();
        if (r108 == null) goto L16;
        if (r108.b0() != true) goto L16;
    L17:
        if (r105 == false) goto L19;
        Keva r109 = DoraConfig.f331707a;
        DoraConfig.k(r100.f294494b);
        DoraConfig.j(r101.f294494b);
    L20:
        r102.setState(new ea8.d(r100, r101));
        goto L84
    L19:
        Keva r110 = DoraConfig.f331707a;
        DoraConfig.i(r100.f294494b);
        DoraConfig.h(r101.f294494b);
    L16:
        r105 = false;
    L21:
        if (r100 != null) goto L23;
        if (r101 == null) goto L84;
        if (Intrinsics.areEqual(r101.f294494b, r104.getTopTranslateLanguage().f294494b) == false) goto L57;
        r102.swapLanguages();
        goto L84
    L57:
        if (r101.f294496d == false) goto L59;
    L71:
        IDoraService r111 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r111 == null) goto L78;
        DeviceService r112 = r111.device();
        if (r112 == null) goto L78;
        if (r112.b0() != true) goto L78;
    L79:
        if (r105 == false) goto L81;
        Keva r113 = DoraConfig.f331707a;
        DoraConfig.j(r101.f294494b);
    L82:
        r102.setState(new h(r101));
        goto L84
    L81:
        Keva r114 = DoraConfig.f331707a;
        DoraConfig.h(r101.f294494b);
    L78:
        r105 = false;
        goto L79
    L59:
        if (r104.getTopTranslateLanguage().f294496d == true) goto L71;
        IDoraService r115 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r115 == null) goto L67;
        DeviceService r116 = r115.device();
        if (r116 == null) goto L67;
        if (r116.b0() != true) goto L67;
        r106 = true;
    L67:
        if (r106 == false) goto L69;
        Keva r117 = DoraConfig.f331707a;
        DoraConfig.j(r101.f294494b);
        DoraConfig.k(com.larus.avlink.simulInterpret.page.model.a.f294491e.f294494b);
    L70:
        r102.setState(new g(r101));
        r103.element = true;
        goto L84
    L69:
        Keva r118 = DoraConfig.f331707a;
        DoraConfig.h(r101.f294494b);
        DoraConfig.i(com.larus.avlink.simulInterpret.page.model.a.f294491e.f294494b);
        goto L70
    L23:
        if (Intrinsics.areEqual(r100.f294494b, r104.getBottomTranslateLanguage().f294494b) == false) goto L26;
        r102.swapLanguages();
        goto L84
    L26:
        if (r100.f294496d == false) goto L28;
    L40:
        IDoraService r119 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r119 == null) goto L47;
        DeviceService r120 = r119.device();
        if (r120 == null) goto L47;
        if (r120.b0() != true) goto L47;
    L48:
        if (r105 == false) goto L50;
        Keva r121 = DoraConfig.f331707a;
        DoraConfig.k(r100.f294494b);
    L51:
        r102.setState(new f(r100));
        goto L84
    L50:
        Keva r122 = DoraConfig.f331707a;
        DoraConfig.i(r100.f294494b);
    L47:
        r105 = false;
        goto L48
    L28:
        if (r104.getBottomTranslateLanguage().f294496d == true) goto L40;
        IDoraService r123 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r123 == null) goto L36;
        DeviceService r124 = r123.device();
        if (r124 == null) goto L36;
        if (r124.b0() != true) goto L36;
        r106 = true;
    L36:
        if (r106 == false) goto L38;
        Keva r125 = DoraConfig.f331707a;
        DoraConfig.k(r100.f294494b);
        DoraConfig.j(com.larus.avlink.simulInterpret.page.model.a.f294491e.f294494b);
    L39:
        r102.setState(new e(r100));
        r103.element = true;
        goto L84
    L38:
        Keva r126 = DoraConfig.f331707a;
        DoraConfig.i(r100.f294494b);
        DoraConfig.h(com.larus.avlink.simulInterpret.page.model.a.f294491e.f294494b);
        goto L39
    }
}
