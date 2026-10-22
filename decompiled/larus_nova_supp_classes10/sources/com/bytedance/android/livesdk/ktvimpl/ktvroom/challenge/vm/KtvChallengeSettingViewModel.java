package com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.model.api.c0;
import com.bytedance.android.live.liveinteract.api.fulllink.LinkMonitorData;
import com.bytedance.android.live.network.response.ExtraResponse;
import com.bytedance.android.live.network.response.e;
import com.bytedance.android.livesdk.ktvimpl.base.api.KtvRoomApi;
import com.bytedance.android.livesdk.message.model.KtvChallengeType;
import com.bytedance.android.livesdk.message.model.id;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import pd2.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 02\u00020\u0001:\u00011B\u0007¢\u0006\u0004\b.\u0010/J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0014\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\bJ\u0016\u0010\r\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\tJ\u0016\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u0006J\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0006\u0010\u0016\u001a\u00020\u000fJ\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\bJ\u0006\u0010\u0019\u001a\u00020\tJ\u0006\u0010\u001a\u001a\u00020\u000fJ\b\u0010\u001b\u001a\u00020\u0006H\u0014R4\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b0\u001c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R$\u0010%\u001a\u0012\u0012\u0004\u0012\u00020\u00140#j\b\u0012\u0004\u0012\u00020\u0014`$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R$\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000f\u0018\u00010\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0014\u0010,\u001a\u00020+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b,\u0010-¨\u00062"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/vm/KtvChallengeSettingViewModel;", "Landroidx/lifecycle/ViewModel;", "", "calculateCustomTargetResult", "Lcom/bytedance/android/live/ktv/common/model/api/c0;", "option", "", "updateDefaultConfigIndex", "Lkotlin/Pair;", "", "getCurrentChallengeConfigIndex", "index", LocationMonitorConst.TYPE, "updateChallengeConfigIndex", "challengeType", "", "target", "updateChallengeTargetValue", "getSingingChallengeOption", "", "Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/challenge/vm/a;", "getChallengeTypeList", "getChallengeDuration", "getChallengeTargetList", "currentTargetRange", "currentChallengeType", "currentChallengeTarget", "onCleared", "Landroidx/lifecycle/MutableLiveData;", "challengeConfigIndexPair", "Landroidx/lifecycle/MutableLiveData;", "getChallengeConfigIndexPair", "()Landroidx/lifecycle/MutableLiveData;", "setChallengeConfigIndexPair", "(Landroidx/lifecycle/MutableLiveData;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "challengeTypeList", "Ljava/util/ArrayList;", "challengeCustomTarget", "Lkotlin/Pair;", "challengeOption", "Lcom/bytedance/android/live/ktv/common/model/api/c0;", "Lio/reactivex/disposables/CompositeDisposable;", "compositeDispose", "Lio/reactivex/disposables/CompositeDisposable;", "<init>", "()V", "Companion", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvChallengeSettingViewModel extends ViewModel {
    public static final int CHALLENGE_TARGET = 2;
    public static final int CHALLENGE_TYPE = 1;
    public static final int CUSTOM_POSITION = 3;
    public static final a Companion = null;
    public static final long DURATION_DEFAULT = 90;
    public static final String TAG = "KtvChallengeSettingViewModel";
    private MutableLiveData<Pair<Integer, Integer>> challengeConfigIndexPair;
    private Pair<Integer, Long> challengeCustomTarget;
    private c0 challengeOption;
    private final ArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a> challengeTypeList;
    private final CompositeDisposable compositeDispose;

    public static final class a {
        public a() {
        }
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ KtvChallengeSettingViewModel a;
        public final /* synthetic */ long b;

        public b(KtvChallengeSettingViewModel r1, long r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r7) {
            e r8 = (e) r7;
            c0 r0 = (c0) ((ExtraResponse) r8).data;
            KtvChallengeSettingViewModel.access$setChallengeOption$p(this.a, r0);
            KtvChallengeSettingViewModel r1 = this.a;
            KtvChallengeSettingViewModel.access$updateDefaultConfigIndex(r1, KtvChallengeSettingViewModel.access$getChallengeOption$p(r1));
            mb0.c.a.b(d.n, LinkMonitorData.ApiGetSingingChallengeOption, System.currentTimeMillis() - this.b, ((ExtraResponse) r8).logId);
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ long a;

        public c(long r1) {
            this.a = r1;
        }

        public final void accept(Object r7) {
            d r0 = d.n;
            LinkMonitorData r1 = LinkMonitorData.ApiGetSingingChallengeOption;
            long r2 = System.currentTimeMillis() - this.a;
            mb0.c.a.a(r0, r1, r2, (Throwable) r7);
        }
    }

    static {
        Companion = new a();
    }

    public final int currentChallengeType() {
        Pair r0 = (Pair) this.challengeConfigIndexPair.getValue();
        int r1 = KtvChallengeType.KTV_CHALLENGE_TYPE_GIFT.getValue();
        if (r0 == null) goto L5;
        Integer r2 = (Integer) r0.getFirst();
    L6:
        if (r2 != null) goto L8;
        return r1;
    L8:
        if (((Number) r0.getFirst()).intValue() >= 0) goto L10;
        return r1;
    L10:
        if (((Number) r0.getFirst()).intValue() >= this.challengeTypeList.size()) goto L18;
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a r3 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a) CollectionsKt.getOrNull(this.challengeTypeList, ((Number) r0.getFirst()).intValue());
        if (r3 == null) goto L15;
        return r3.a;
    L15:
        return 0;
    L18:
        return r1;
    L5:
        r2 = null;
        goto L6
    }

    public final long getChallengeDuration() {
        c0 r0 = this.challengeOption;
        if (r0 == null) goto L7;
        Long r1 = r0.c();
        if (r1 == null) goto L7;
        return r1.longValue();
    L7:
        return 90;
    }

    public final List<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a> getChallengeTargetList() {
        ArrayList r0 = new ArrayList();
        int r1 = currentChallengeType();
        c0 r2 = this.challengeOption;
        if (r2 == null) goto L20;
        List r3 = r2.a();
        if (r3 == null) goto L20;
        Iterator r4 = r3.iterator();
    L8:
        if (r4.hasNext() == false) goto L20;
        id r5 = (id) r4.next();
        Integer r6 = r5.b();
        if (r6 == null) goto L8;
        if (r6.intValue() != r1) goto L8;
        List r7 = r5.a();
        if (r7 == null) goto L8;
        Iterator r8 = r7.iterator();
    L18:
        if (r8.hasNext() == false) goto L8;
        r0.add(new com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a(r1, String.valueOf(((Number) r8.next()).longValue()), 2, false));
    L20:
        Pair<Integer, Long> r9 = this.challengeCustomTarget;
        if (r9 != null) goto L23;
    L29:
        String r10 = s1.B(2131918233);
    L30:
        r0.add(new com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a(r1, r10, 2, true));
        return r0;
    L23:
        if (((Number) r9.getFirst()).intValue() != r1) goto L29;
        Pair r11 = (Pair) this.challengeConfigIndexPair.getValue();
        if (r11 == null) goto L29;
        if (3 != ((Number) r11.getSecond()).intValue()) goto L29;
        r10 = calculateCustomTargetResult();
        goto L30
    }

    public final Pair<Integer, Integer> getCurrentChallengeConfigIndex() {
        return (Pair) this.challengeConfigIndexPair.getValue();
    }

    public KtvChallengeSettingViewModel() {
        this.challengeConfigIndexPair = new MutableLiveData(new Pair(0, 0));
        ArrayList<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a> r0 = new ArrayList();
        this.challengeTypeList = r0;
        this.compositeDispose = new CompositeDisposable();
        r0.add(new com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a(KtvChallengeType.KTV_CHALLENGE_TYPE_GIFT.getValue(), s1.B(2131918240), 1, false));
        r0.add(new com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a(KtvChallengeType.KTV_CHALLENGE_TYPE_MIDI.getValue(), s1.B(2131918255), 1, false));
        r0.add(new com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a(KtvChallengeType.KTV_CHALLENGE_TYPE_LIKE.getValue(), s1.B(2131918241), 1, false));
    }

    private final String calculateCustomTargetResult() {
        String r0 = s1.B(2131918233);
        Pair<Integer, Long> r1 = this.challengeCustomTarget;
        if (r1 == null) goto L11;
        Long r2 = (Long) r1.getSecond();
        if (r2 == null) goto L12;
        long r3 = r2.longValue();
        if (r3 < 10000) goto L10;
        StringBuilder r4 = new StringBuilder();
        StringCompanionObject r5 = StringCompanionObject.INSTANCE;
        r4.append(String.format("%.1f", Arrays.copyOf(new Object[]{Float.valueOf(r3 / 10000.0f)}, 1)));
        r4.append(19975);
        return r4.toString();
    L10:
        return String.valueOf(r3);
    L12:
        return r0;
    L11:
        return r0;
    }

    public final long currentChallengeTarget() {
        int r0 = currentChallengeType();
        Pair r1 = (Pair) this.challengeConfigIndexPair.getValue();
        if (r1 != null) goto L5;
    L16:
        c0 r4 = this.challengeOption;
        if (r4 == null) goto L65;
        List r5 = r4.a();
        if (r5 == null) goto L66;
        Iterator r6 = r5.iterator();
    L21:
        long r7 = 100;
    L23:
        if (r6.hasNext() == false) goto L46;
        id r8 = (id) r6.next();
        if (r8.b() == null) goto L23;
        Integer r9 = r8.b();
        if (r9 == null) goto L23;
        if (r0 != r9.intValue()) goto L23;
        if (r1 == null) goto L33;
        Integer r10 = (Integer) r1.getSecond();
    L34:
        if (r10 == null) goto L23;
        int r11 = ((Number) r1.getSecond()).intValue();
        List r12 = r8.a();
        if (r12 == null) goto L38;
        int r13 = r12.size();
    L39:
        if (r11 >= r13) goto L23;
        List r14 = r8.a();
        if (r14 == null) goto L21;
        Long r15 = (Long) ListProtector.get(r14, ((Number) r1.getSecond()).intValue());
        if (r15 == null) goto L21;
        r7 = r15.longValue();
        goto L23
    L38:
        r13 = 0;
        goto L39
    L33:
        r10 = null;
        goto L34
    L46:
        return r7;
    L66:
        return 100;
    L65:
        return 100;
    L5:
        if (((Number) r1.getSecond()).intValue() != 3) goto L16;
        Pair<Integer, Long> r16 = this.challengeCustomTarget;
        if (r16 == null) goto L16;
        if (((Number) r16.getFirst()).intValue() != r0) goto L16;
        Pair<Integer, Long> r2 = this.challengeCustomTarget;
        if (r2 == null) goto L63;
        Long r3 = (Long) r2.getSecond();
        if (r3 != null) goto L15;
        return 100;
    L15:
        return r3.longValue();
    L63:
        return 100;
    }

    public final Pair<Long, Long> currentTargetRange() {
        int r0 = currentChallengeType();
        Pair<Long, Long> r3 = TuplesKt.to(1L, 100L);
        c0 r6 = this.challengeOption;
        if (r6 == null) goto L23;
        List r7 = r6.a();
        if (r7 == null) goto L23;
        Iterator r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L23;
        id r9 = (id) r8.next();
        Integer r10 = r9.b();
        if (r10 == null) goto L8;
        if (r10.intValue() != r0) goto L8;
        Long r4 = r9.c();
        if (r4 == null) goto L17;
        long r11 = r4.longValue();
    L18:
        Long r5 = Long.valueOf(r11);
        Long r12 = r9.d();
        if (r12 == null) goto L21;
        long r13 = r12.longValue();
    L22:
        r3 = TuplesKt.to(r5, Long.valueOf(r13));
        goto L8
    L21:
        r13 = 100;
        goto L22
    L17:
        r11 = 1;
    L23:
        return r3;
    }

    public final void getSingingChallengeOption() {
        long r0 = System.currentTimeMillis();
        RxUtilKt.c(((KtvRoomApi) com.bytedance.android.live.network.c.b().e(KtvRoomApi.class)).getSingingChallengeOptionParams(com.bytedance.android.live.ktv.common.util.a.c().getRoomId()).compose(RxUtil.rxSchedulerHelper()).subscribe(new b(this, r0), new c(r0)), this.compositeDispose);
    }

    public void onCleared() {
        super.onCleared();
        this.compositeDispose.clear();
        ALogger.i(TAG, "onCleared");
    }

    public final MutableLiveData<Pair<Integer, Integer>> getChallengeConfigIndexPair() {
        return this.challengeConfigIndexPair;
    }

    public final List<com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a> getChallengeTypeList() {
        return this.challengeTypeList;
    }

    public static final /* synthetic */ c0 access$getChallengeOption$p(KtvChallengeSettingViewModel r0) {
        return r0.challengeOption;
    }

    private final void updateDefaultConfigIndex(c0 r13) {
        Long r0 = null;
        if (r13 == null) goto L7;
        id r1 = r13.b();
        if (r1 == null) goto L7;
        Integer r2 = r1.b();
    L8:
        if (r13 == null) goto L14;
        id r3 = r13.b();
        if (r3 == null) goto L14;
        List r4 = r3.a();
        if (r4 == null) goto L14;
        r0 = (Long) CollectionsKt.firstOrNull(r4);
    L14:
        Iterator<T> r5 = this.challengeTypeList.iterator();
        int r6 = 0;
        int r7 = 0;
        int r8 = 0;
    L16:
        if (r5.hasNext() == false) goto L27;
        Object r9 = r5.next();
        int r10 = r7 + 1;
        if (r7 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a r11 = (com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.a) r9;
        if (r2 == null) goto L25;
        if (r11.a != r2.intValue()) goto L25;
        r8 = r7;
    L25:
        r7 = r10;
        goto L16
    L27:
        if (r13 == null) goto L46;
        id r14 = r13.b();
        if (r14 == null) goto L46;
        List r15 = r14.a();
        if (r15 == null) goto L46;
        Iterator r16 = r15.iterator();
        int r12 = -1;
    L34:
        if (r16.hasNext() == false) goto L47;
        Object r17 = r16.next();
        int r18 = r6 + 1;
        if (r6 >= 0) goto L38;
        CollectionsKt.throwIndexOverflow();
    L38:
        long r19 = ((Number) r17).longValue();
        if (r2 == null) goto L45;
        if (r0 == null) goto L45;
        if (r19 != r0.longValue()) goto L45;
        r12 = r6;
    L45:
        r6 = r18;
    L47:
        if (r12 != (-1)) goto L52;
        if (r2 == null) goto L51;
        if (r0 == null) goto L51;
        this.challengeCustomTarget = TuplesKt.to(Integer.valueOf(r2.intValue()), Long.valueOf(r0.longValue()));
    L51:
        r12 = 3;
    L52:
        this.challengeConfigIndexPair.setValue(TuplesKt.to(Integer.valueOf(r8), Integer.valueOf(r12)));
        return;
    L46:
        r12 = -1;
    L7:
        r2 = null;
        goto L8
    }

    public final void setChallengeConfigIndexPair(MutableLiveData<Pair<Integer, Integer>> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.challengeConfigIndexPair = r2;
    }

    public static final /* synthetic */ void access$setChallengeOption$p(KtvChallengeSettingViewModel r0, c0 r1) {
        r0.challengeOption = r1;
    }

    public static final /* synthetic */ void access$updateDefaultConfigIndex(KtvChallengeSettingViewModel r0, c0 r1) {
        r0.updateDefaultConfigIndex(r1);
    }

    public final void updateChallengeConfigIndex(int r4, int r5) {
        int r1 = 0;
        if (r5 != 1) goto L6;
        this.challengeConfigIndexPair.setValue(new Pair(Integer.valueOf(r4), 0));
        return;
    L6:
        if (r5 != 2) goto L15;
        MutableLiveData<Pair<Integer, Integer>> r6 = this.challengeConfigIndexPair;
        Pair r2 = (Pair) r6.getValue();
        if (r2 == null) goto L12;
        Integer r3 = (Integer) r2.getFirst();
        if (r3 == null) goto L12;
        r1 = r3.intValue();
    L12:
        r6.setValue(new Pair(Integer.valueOf(r1), Integer.valueOf(r4)));
        return;
    }

    public final void updateChallengeTargetValue(int r1, long r2) {
        this.challengeCustomTarget = TuplesKt.to(Integer.valueOf(r1), Long.valueOf(r2));
        updateChallengeConfigIndex(3, 2);
    }
}
