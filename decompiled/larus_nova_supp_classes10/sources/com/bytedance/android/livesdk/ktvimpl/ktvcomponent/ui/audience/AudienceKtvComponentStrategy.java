package com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.audience;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.live.core.tetris.widgets.LiveWidget;
import com.bytedance.android.live.core.utils.StateMachine;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.ktv.common.karaokestation.model.FirstLevelTab;
import com.bytedance.android.live.ktv.common.karaokestation.model.y;
import com.bytedance.android.live.liveinteract.api.IInteractService;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import com.bytedance.android.livesdk.chatroom.utils.o3;
import com.bytedance.android.livesdk.chatroom.viewmodel.k;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.KtvComponentOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.chorus.ChorusContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.core.KtvComponentContext;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.viewmodel.KtvComponentUIContext;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.KtvRoomLyricsStateMachineConfig;
import com.bytedance.android.livesdk.ktvimpl.multichorus.MultiChorusContext;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.KVData;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.j;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.mt.protector.impl.UriProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.controller.AbstractDraweeController;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\bB\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/ui/audience/AudienceKtvComponentStrategy;", "Lcom/bytedance/android/livesdk/ktvimpl/ktvcomponent/ui/a;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "Lcom/bytedance/ies/sdk/widgets/KVData;", "Landroid/content/Context;", "getContext", "<init>", "()V", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AudienceKtvComponentStrategy implements com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a, Observer<KVData> {
    public static final /* synthetic */ int w = 0;
    public com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b a;
    public KtvComponentUIContext b;
    public ViewGroup c;
    public View d;
    public HSImageView e;
    public TextView f;
    public TextView g;
    public TextView h;
    public TextView i;
    public View j;
    public final CompositeDisposable k;
    public LiveWidget l;
    public String m;
    public boolean n;
    public boolean o;
    public Integer p;
    public Integer q;
    public boolean r;
    public long s;
    public boolean t;
    public int u;
    public Function1<? super Long, Unit> v;

    public static final class a {
    }

    public static final class b<T> implements Consumer {
        public final /* synthetic */ AudienceKtvComponentStrategy a;
        public final /* synthetic */ LiveWidget b;

        public b(AudienceKtvComponentStrategy r1, LiveWidget r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            k r6 = (k) r5;
            DataCenter r0 = ((Widget) this.b).dataCenter;
            if (r0 == null) goto L7;
            Boolean r1 = (Boolean) r0.get("cmd_end_live", Boolean.FALSE);
            if (r1 == null) goto L7;
            boolean r2 = r1.booleanValue();
        L8:
            AudienceKtvComponentStrategy r3 = this.a;
            if (r3.t == false) goto L17;
            if (r2 == false) goto L12;
            return;
        L12:
            if (r6.c == false) goto L14;
            Integer r7 = r3.p;
            Integer r4 = r3.q;
        L15:
            this.a.o(r7, r4);
            return;
        L14:
            Integer r8 = Integer.valueOf(r6.a);
            r4 = Integer.valueOf(r6.b);
            r7 = r8;
            goto L15
        L17:
            return;
        L7:
            r2 = false;
            goto L8
        }
    }

    public static final class c<T> implements Consumer {
        public final /* synthetic */ AudienceKtvComponentStrategy a;
        public final /* synthetic */ LiveWidget b;

        public c(AudienceKtvComponentStrategy r1, LiveWidget r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            k r6 = (k) r5;
            DataCenter r0 = ((Widget) this.b).dataCenter;
            boolean r1 = false;
            if (r0 == null) goto L7;
            Boolean r2 = (Boolean) r0.get("cmd_end_live", Boolean.FALSE);
            if (r2 == null) goto L7;
            boolean r3 = r2.booleanValue();
        L8:
            AudienceKtvComponentStrategy r4 = this.a;
            if (r4.t == false) goto L26;
            if (r3 == true) goto L27;
            r4.n(Integer.valueOf(r6.a), Integer.valueOf(r6.b));
            AudienceKtvComponentStrategy r7 = this.a;
            r7.p = Integer.valueOf(r6.a);
            AudienceKtvComponentStrategy r8 = this.a;
            r8.q = Integer.valueOf(r6.b);
            AudienceKtvComponentStrategy r9 = this.a;
            Integer r10 = r9.p;
            if (r10 != null) goto L15;
        L24:
            r9.r = r1;
            return;
        L15:
            if (r10.intValue() != 8) goto L24;
            Integer r11 = this.a.q;
            if (r11 == null) goto L24;
            if (r11.intValue() != 7) goto L24;
            if (jc1.k.n(IInteractService.class).dynamicFromAudience() == false) goto L24;
            r1 = true;
            goto L24
        L27:
            return;
        L26:
            return;
        L7:
            r3 = false;
            goto L8
        }
    }

    public static final class d<T> implements Consumer {
        public final /* synthetic */ AudienceKtvComponentStrategy a;
        public final /* synthetic */ LiveWidget b;

        public d(AudienceKtvComponentStrategy r1, LiveWidget r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r4) {
            com.bytedance.android.livesdk.chatroom.viewmodel.i r5 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r4;
            DataCenter r0 = ((Widget) this.b).dataCenter;
            if (r0 == null) goto L7;
            Boolean r1 = (Boolean) r0.get("cmd_end_live", Boolean.FALSE);
            if (r1 == null) goto L7;
            boolean r2 = r1.booleanValue();
        L8:
            AudienceKtvComponentStrategy r3 = this.a;
            if (r3.t == false) goto L13;
            if (r2 == true) goto L14;
            r3.o(Integer.valueOf(r5.a), Integer.valueOf(r5.b));
            return;
        L14:
            return;
        L13:
            return;
        L7:
            r2 = false;
            goto L8
        }
    }

    public static final class e<T> implements Consumer {
        public final /* synthetic */ AudienceKtvComponentStrategy a;
        public final /* synthetic */ LiveWidget b;

        public e(AudienceKtvComponentStrategy r1, LiveWidget r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void accept(Object r5) {
            com.bytedance.android.livesdk.chatroom.viewmodel.i r6 = (com.bytedance.android.livesdk.chatroom.viewmodel.i) r5;
            DataCenter r0 = ((Widget) this.b).dataCenter;
            boolean r1 = false;
            if (r0 == null) goto L7;
            Boolean r2 = (Boolean) r0.get("cmd_end_live", Boolean.FALSE);
            if (r2 == null) goto L7;
            boolean r3 = r2.booleanValue();
        L8:
            AudienceKtvComponentStrategy r4 = this.a;
            if (r4.t == false) goto L26;
            if (r3 == true) goto L27;
            r4.n(Integer.valueOf(r6.a), Integer.valueOf(r6.b));
            AudienceKtvComponentStrategy r7 = this.a;
            r7.p = Integer.valueOf(r6.a);
            AudienceKtvComponentStrategy r8 = this.a;
            r8.q = Integer.valueOf(r6.b);
            AudienceKtvComponentStrategy r9 = this.a;
            Integer r10 = r9.p;
            if (r10 != null) goto L15;
        L24:
            r9.r = r1;
            return;
        L15:
            if (r10.intValue() != 8) goto L24;
            Integer r11 = this.a.q;
            if (r11 == null) goto L24;
            if (r11.intValue() != 7) goto L24;
            if (jc1.k.n(IInteractService.class).dynamicFromAudience() == false) goto L24;
            r1 = true;
            goto L24
        L27:
            return;
        L26:
            return;
        L7:
            r3 = false;
            goto L8
        }
    }

    public static final class f<T> implements Consumer {
        public final /* synthetic */ AudienceKtvComponentStrategy a;

        public f(AudienceKtvComponentStrategy r1) {
            this.a = r1;
        }

        public final void accept(Object r2) {
            if (((List) r2) != null) goto L5;
            return;
        L5:
            if (ChorusContext.Companion.c() == true) goto L9;
            ke2.b.a = 1;
            AudienceKtvComponentStrategy r3 = this.a;
            KtvContext.Companion.getClass();
            com.bytedance.android.livesdk.ktvimpl.base.orderedsong.d.b(KtvContext.a.g());
            AudienceKtvComponentStrategy.m(r3);
            return;
        }
    }

    public static final class g<T> implements Observer {
        public final /* synthetic */ AudienceKtvComponentStrategy a;

        public g(AudienceKtvComponentStrategy r1) {
            this.a = r1;
        }

        public final void onChanged(Object r1) {
            Integer r2 = (Integer) r1;
            AudienceKtvComponentStrategy.l(this.a);
        }
    }

    public static final class h<T> implements Consumer {
        public final /* synthetic */ AudienceKtvComponentStrategy a;

        public h(AudienceKtvComponentStrategy r1) {
            this.a = r1;
        }

        public final void accept(Object r1) {
            sh6.b r2 = (sh6.b) r1;
            AudienceKtvComponentStrategy.l(this.a);
        }
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void a() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final int getLayoutId() {
        return 2131566476;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void j() {
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void c() {
        if (this.n == false) goto L5;
        ke2.a.f();
    L5:
        this.n = false;
        TextView r0 = this.f;
        if (r0 == null) goto L8;
        r0.setVisibility(8);
    L8:
        TextView r1 = this.g;
        if (r1 == null) goto L12;
        r1.setVisibility(8);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public Context getContext() {
        LiveWidget r0 = this.l;
        if (r0 != null) goto L7;
        return null;
    L7:
        return ((Widget) r0).context;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final DataCenter getDataCenter() {
        LiveWidget r0 = this.l;
        if (r0 != null) goto L7;
        return null;
    L7:
        return ((Widget) r0).dataCenter;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void onDestroy() {
        boolean r1 = false;
        if (jc1.k.n(IInteractService.class).getCurrentScene() != 0) goto L10;
        Integer r0 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r0 != null) goto L8;
    L9:
        boolean r2 = true;
    L11:
        KtvComponentOrderedSongDataContext r3 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r3 == null) goto L23;
        List<SongUniqueInfo> r4 = r3.m201getKtvSongUniqueInfoList();
        if (r4 == null) goto L23;
        Iterator<T> r5 = r4.iterator();
    L17:
        if (r5.hasNext() == false) goto L21;
        Object r6 = r5.next();
        if ((!((SongUniqueInfo) r6).isPublic()) == false) goto L17;
    L22:
        SongUniqueInfo r7 = (SongUniqueInfo) r6;
    L24:
        if (r7 == null) goto L26;
        r1 = true;
    L26:
        if (r1 == true) goto L28;
    L29:
        if (r2 == false) goto L37;
    L30:
        KtvContext.Companion.getClass();
        KtvContext r8 = KtvContext.a.g();
        if (r8 == null) goto L37;
        m<com.bytedance.android.livesdk.ktvimpl.base.util.e> r9 = r8.getKtvRoomStrategy();
        if (r9 == null) goto L37;
        com.bytedance.android.livesdk.ktvimpl.base.util.e r10 = (com.bytedance.android.livesdk.ktvimpl.base.util.e) r9.getValue();
        if (r10 == null) goto L37;
        r10.cancelApply(null);
    L37:
        MultiChorusContext.a r11 = MultiChorusContext.Companion;
        if (r11.c() == false) goto L51;
        Integer r12 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r12 == null) goto L51;
        if (r12.intValue() != 1) goto L51;
        MultiChorusContext r13 = r11.getContext();
        if (r13 == null) goto L51;
        j<com.bytedance.android.livesdk.ktvapi.util.a> r14 = r13.m441getService();
        if (r14 == null) goto L51;
        com.bytedance.android.livesdk.ktvapi.util.a r15 = (com.bytedance.android.livesdk.ktvapi.util.a) r14.getValue();
        if (r15 == null) goto L51;
        r15.z9(null);
    L51:
        LiveWidget r16 = this.l;
        if (r16 == null) goto L56;
        DataCenter r17 = ((Widget) r16).dataCenter;
        if (r17 == null) goto L56;
        r17.removeObserver(this);
    L56:
        this.k.dispose();
        return;
    L28:
        if (((Boolean) vm2.h.x4.getValue(null, vm2.h.a[282(0x11a, float:3.95E-43)])).booleanValue() == false) goto L30;
    L21:
        r6 = null;
    L23:
        r7 = null;
        goto L24
    L8:
        if (r0.intValue() != 0) goto L9;
    L10:
        r2 = false;
        goto L11
    }

    public AudienceKtvComponentStrategy() {
        Unit r0 = Unit.INSTANCE;
        this.k = new CompositeDisposable();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void g() {
        String r0 = ke2.a.b();
        int r1 = ke2.b.a;
        boolean r2 = this.n;
        KtvComponentUIContext r3 = this.b;
        if (r3 == null) goto L7;
        NextLiveData<Integer> r4 = r3.getOrderSongUnReadNum();
        if (r4 == null) goto L7;
        Integer r5 = (Integer) r4.getValue();
    L8:
        ke2.b.d(r0, r2, null, r5, 8);
        return;
    L7:
        r5 = null;
        goto L8
    }

    public static final void l(AudienceKtvComponentStrategy r4) {
        r4.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.util.j.l.getClass();
        if (com.bytedance.android.livesdk.ktvimpl.base.util.j.i() == true) goto L56;
        KtvContext.Companion.getClass();
        if (KtvContext.a.i() == false) goto L16;
        View r0 = r4.j;
        if (r0 == null) goto L10;
        r0.setVisibility(0);
    L10:
        TextView r1 = r4.i;
        if (r1 == null) goto L13;
        r1.setVisibility(8);
    L13:
        TextView r5 = r4.h;
        if (r5 == null) goto L52;
        r5.setVisibility(8);
        return;
    L52:
        return;
    L16:
        View r2 = r4.j;
        if (r2 == null) goto L19;
        r2.setVisibility(8);
    L19:
        KtvComponentUIContext r3 = r4.b;
        if (r3 == null) goto L25;
        NextLiveData<Integer> r6 = r3.getOrderSongUnReadNum();
        if (r6 == null) goto L25;
        Integer r7 = (Integer) r6.getValue();
        if (r7 == null) goto L25;
    L26:
        int r8 = r7.intValue();
        if (r8 != 0) goto L34;
        TextView r9 = r4.i;
        if (r9 == null) goto L31;
        r9.setVisibility(8);
    L31:
        TextView r10 = r4.h;
        if (r10 == null) goto L46;
        r10.setVisibility(8);
    L46:
        LiveWidget r11 = r4.l;
        if (r11 == null) goto L54;
        DataCenter r12 = ((Widget) r11).dataCenter;
        if (r12 == null) goto L55;
        r12.put("data_ksong_unread_count", Integer.valueOf(r8));
        return;
    L55:
        return;
    L54:
        return;
    L34:
        TextView r13 = r4.i;
        if (r13 == null) goto L37;
        r13.setText(String.valueOf(r8));
    L37:
        TextView r14 = r4.h;
        if (r14 == null) goto L40;
        r14.setText(String.valueOf(r8));
    L40:
        TextView r15 = r4.i;
        if (r15 == null) goto L43;
        r15.setVisibility(0);
    L43:
        TextView r16 = r4.h;
        if (r16 == null) goto L46;
        r16.setVisibility(0);
    L25:
        r7 = 0;
        goto L26
    }

    public static final void m(AudienceKtvComponentStrategy r8) {
        r8.getClass();
        ArrayList r0 = new ArrayList();
        KtvComponentOrderSongDataContext.Companion.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r1 = KtvComponentOrderSongDataContext.Companion.a();
        if (r1 == null) goto L9;
        MutableLiveData<vb0.a> r2 = r1.getOrderSongUiState();
        if (r2 == null) goto L9;
        vb0.a r3 = (vb0.a) r2.getValue();
        if (r3 == null) goto L9;
        boolean r4 = r3.j;
    L10:
        if (r4 == false) goto L33;
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r5 = KtvComponentOrderSongDataContext.Companion.b();
        if (r5 == null) goto L18;
        Pair r6 = r5.getSelectedFirstLevelTabValue();
        if (r6 == null) goto L18;
        Integer r7 = (Integer) r6.getFirst();
        if (r7 == null) goto L18;
        int r9 = r7.intValue();
    L19:
        FirstLevelTab r10 = FirstLevelTab.OrderedSongTab;
        boolean r11 = true;
        if (r9 != r10.getValue()) goto L22;
        boolean r12 = true;
    L23:
        com.bytedance.android.live.ktv.common.karaokestation.viewmodel.b r13 = KtvComponentOrderSongDataContext.Companion.b();
        if (r13 == null) goto L28;
        y r14 = r13.getSelectedSecondLevelTabData(r10.getValue());
        if (r14 == null) goto L28;
        String r15 = r14.c;
    L29:
        boolean r16 = Intrinsics.areEqual(r15, "play_list");
        if (r12 == false) goto L33;
        if (r16 == false) goto L33;
    L34:
        if (r11 == false) goto L36;
        ke2.a.a(false);
        return;
    L36:
        KtvComponentUIContext r17 = r8.b;
        if (r17 == null) goto L40;
        List<Pair<Long, String>> r18 = r17.getOrderSongReadList();
        if (r18 == null) goto L40;
    L41:
        KtvComponentOrderedSongDataContext r19 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r19 == null) goto L49;
        List<SongUniqueInfo> r20 = r19.getKtvPublicSongUniqueInfoList();
        if (r20 == null) goto L49;
        Iterator<T> r21 = r20.iterator();
    L47:
        if (r21.hasNext() == false) goto L49;
        SongUniqueInfo r22 = (SongUniqueInfo) r21.next();
        r0.add(new Pair(Long.valueOf(r22.getSongId()), r22.getUserId()));
    L49:
        Iterator<Pair<Long, String>> r23 = r18.iterator();
    L51:
        if (r23.hasNext() == false) goto L55;
        if (r0.contains(r23.next()) == true) goto L51;
        r23.remove();
        goto L51
    L55:
        KtvComponentUIContext r24 = r8.b;
        if (r24 == null) goto L58;
        r24.setOrderSongReadList(r18);
    L58:
        int r25 = r0.size() - r18.size();
        KtvComponentUIContext r26 = r8.b;
        if (r26 == null) goto L64;
        NextLiveData<Integer> r27 = r26.getOrderSongUnReadNum();
        if (r27 == null) goto L64;
        Integer r28 = (Integer) r27.getValue();
        if (r28 == null) goto L64;
    L65:
        int r29 = r28.intValue();
        if (r29 != 0) goto L68;
        if (r25 == 0) goto L68;
    L70:
        KtvComponentUIContext r30 = r8.b;
        if (r30 == null) goto L75;
        NextLiveData<Integer> r31 = r30.getOrderSongUnReadNum();
        if (r31 == null) goto L75;
        r31.setValue(Integer.valueOf(r25));
    L75:
        ke2.a.f();
    L76:
        KtvComponentUIContext r32 = r8.b;
        if (r32 == null) goto L89;
        NextLiveData<Integer> r33 = r32.getOrderSongUnReadNum();
        if (r33 == null) goto L90;
        r33.setValue(Integer.valueOf(r25));
        return;
    L90:
        return;
    L89:
        return;
    L68:
        if (r29 == 0) goto L76;
        if (r25 != 0) goto L76;
    L64:
        r28 = 0;
    L40:
        r18 = new ArrayList();
    L28:
        r15 = null;
        goto L29
    L22:
        r12 = false;
    L18:
        r9 = FirstLevelTab.Unknown.getValue();
    L33:
        r11 = false;
    L9:
        r4 = false;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void b(Function1<? super Long, Unit> r1) {
        this.v = r1;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void d(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "valid");
        Intrinsics.checkNotNullParameter(r3, "valid");
        this.o = true;
        if (com.bytedance.android.livesdk.ktvimpl.ktvroom.viewmodel.f.a(r3) == false) goto L9;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r0 = this.a;
        if (r0 == null) goto L9;
        HSImageView r1 = r0.j;
        if (r1 == null) goto L9;
        r1.setVisibility(0);
    L9:
        MusicPanel r4 = ((KtvRoomLyricsStateMachineConfig.d) r3.c).b();
        if (r4 == null) goto L14;
        KtvMusic r5 = r4.a;
        if (r5 == null) goto L14;
        String r6 = r5.getCoverUrl();
    L15:
        p(r6);
        return;
    L14:
        r6 = null;
        goto L15
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void e(int r3) {
        if (this.n == true) goto L5;
        this.n = true;
        ke2.a.f();
    L5:
        TextView r0 = this.f;
        if (r0 == null) goto L8;
        r0.setVisibility(0);
    L8:
        TextView r1 = this.f;
        if (r1 == null) goto L11;
        r1.setText(String.valueOf(r3));
    L11:
        ViewGroup r4 = this.c;
        if (r4 != null) goto L14;
    L23:
        TextView r5 = this.g;
        if (r5 == null) goto L31;
        r5.setVisibility(8);
        return;
    L31:
        return;
    L14:
        if (r4.getVisibility() != 0) goto L23;
        if (this.n == false) goto L20;
        TextView r6 = this.g;
        if (r6 == null) goto L27;
        r6.setVisibility(0);
        return;
    L27:
        return;
    L20:
        TextView r7 = this.g;
        if (r7 == null) goto L29;
        r7.setVisibility(8);
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void f(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "valid");
        Intrinsics.checkNotNullParameter(r2, "valid");
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r3 = this.a;
        if (r3 == null) goto L7;
        HSImageView r4 = r3.j;
        if (r4 == null) goto L7;
        r4.setVisibility(8);
    L7:
        HSImageView r5 = this.e;
        if (r5 == null) goto L10;
        r5.setActualImageResource(2131252067);
    L10:
        this.m = null;
        this.o = false;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void h(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r3) {
        Intrinsics.checkNotNullParameter(r3, "valid");
        Intrinsics.checkNotNullParameter(r3, "valid");
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r0 = this.a;
        if (r0 == null) goto L7;
        HSImageView r1 = r0.j;
        if (r1 == null) goto L7;
        r1.setVisibility(0);
    L7:
        com.bytedance.android.livesdk.ktvimpl.base.sei.k r4 = ((KtvRoomLyricsStateMachineConfig.d) r3.c).c();
        if (r4 == null) goto L10;
        String r5 = r4.g();
    L11:
        p(r5);
        return;
    L10:
        r5 = null;
        goto L11
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void i(StateMachine.c.b<? extends KtvRoomLyricsStateMachineConfig.d, ? extends KtvRoomLyricsStateMachineConfig.a, ? extends KtvRoomLyricsStateMachineConfig.b> r2) {
        Intrinsics.checkNotNullParameter(r2, "valid");
        Intrinsics.checkNotNullParameter(r2, "valid");
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r3 = this.a;
        if (r3 == null) goto L7;
        HSImageView r4 = r3.j;
        if (r4 == null) goto L7;
        r4.setVisibility(8);
    L7:
        this.o = false;
    }

    public final void onChanged(Object r4) {
        KVData r5 = (KVData) r4;
        if (r5 == null) goto L5;
        String r0 = r5.getKey();
    L6:
        if (r0 != null) goto L9;
        return;
    L9:
        if (r0.hashCode() == 1987819643) goto L12;
        return;
    L12:
        if (r0.equals("paid_live_hidden_link_multi_view") == false) goto L34;
        Boolean r6 = (Boolean) r5.getData();
        if (r6 != null) goto L16;
        return;
    L16:
        if (r6.booleanValue() == false) goto L18;
        this.u++;
    L20:
        if (r6.booleanValue() == false) goto L27;
        LiveWidget r7 = this.l;
        if (r7 == null) goto L36;
        ViewGroup r8 = ((Widget) r7).containerView;
        if (r8 == null) goto L37;
        r8.setVisibility(8);
        return;
    L37:
        return;
    L36:
        return;
    L27:
        if (this.u > 0) goto L39;
        LiveWidget r9 = this.l;
        if (r9 == null) goto L40;
        ViewGroup r10 = ((Widget) r9).containerView;
        if (r10 == null) goto L41;
        r10.setVisibility(0);
        return;
    L41:
        return;
    L40:
        return;
    L39:
        return;
    L18:
        this.u--;
        goto L20
    L34:
        return;
    L5:
        r0 = null;
        goto L6
    }

    public final void p(String r6) {
        ViewGroup r0 = this.c;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0.getVisibility() != 0) goto L24;
        if (r6 == null) goto L12;
        if (Intrinsics.areEqual(r6, this.m) == false) goto L12;
        return;
    L12:
        if (TextUtils.isEmpty(r6) == true) goto L16;
        HSImageView r1 = this.e;
        if (r1 == null) goto L22;
        int r2 = s1.f(25.0f);
        int r3 = s1.f(25.0f);
        a1.x(r1, qy.a.a(r6), r2, r3, 0);
        this.m = r6;
        return;
    L22:
        return;
    L16:
        HSImageView r7 = this.e;
        if (r7 == null) goto L19;
        r7.setActualImageResource(2131252067);
    L19:
        this.m = null;
        return;
    }

    public final void n(Integer r4, Integer r5) {
        if (this.r == false) goto L5;
        String r0 = "new_audience";
    L8:
        String r6 = KtvLoggerHelper.D(r4, r5);
        boolean r7 = Intrinsics.areEqual(r0, r6);
        boolean r1 = true;
        if ((!r7) == false) goto L30;
        long r2 = System.currentTimeMillis();
        this.s = r2;
        Function1<? super Long, Unit> r8 = this.v;
        if (r8 == null) goto L13;
        Unit r9 = (Unit) r8.invoke(Long.valueOf(r2));
    L13:
        KtvComponentContext r10 = KtvComponentContext.Companion.getContext();
        String r3 = null;
        if (r10 == null) goto L18;
        n<Integer> r11 = r10.getOpenSource();
        if (r11 == null) goto L18;
        Integer r12 = (Integer) r11.getValue();
    L19:
        if (r12 != null) goto L22;
    L24:
        r1 = false;
    L25:
        int r13 = ke2.b.a;
        if (r1 == false) goto L28;
        r3 = "auto";
    L28:
        ke2.b.g(r6, r6, r3);
        ke2.a.f();
        return;
    L22:
        if (r12.intValue() != 2) goto L24;
    L18:
        r12 = null;
        goto L19
    L30:
        return;
    L5:
        r0 = KtvLoggerHelper.D(this.p, this.q);
        if (r0 != null) goto L8;
        r0 = "";
        goto L8
    }

    public final void o(Integer r7, Integer r8) {
        String r3 = KtvLoggerHelper.D(r7, r8);
        long r0 = (System.currentTimeMillis() - this.s) / 1000;
        if (r0 <= 0) goto L22;
        KtvComponentContext r9 = KtvComponentContext.Companion.getContext();
        if (r9 == null) goto L9;
        n<Integer> r10 = r9.getOpenSource();
        if (r10 == null) goto L9;
        Integer r11 = (Integer) r10.getValue();
    L10:
        if (r11 != null) goto L13;
    L15:
        boolean r12 = false;
    L16:
        int r2 = ke2.b.a;
        if (r12 == false) goto L19;
        String r4 = "auto";
    L20:
        ke2.b.h(r0, r3, r3, r4, 16);
        return;
    L19:
        r4 = null;
        goto L20
    L13:
        if (r11.intValue() != 2) goto L15;
        r12 = true;
    L9:
        r11 = null;
        goto L10
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.a
    public final void k(LiveWidget r7, KtvComponentUIContext r8, com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r9, Function2<? super String, ? super JSONObject, Unit> r10) {
        Intrinsics.checkNotNullParameter(r7, "widget");
        Intrinsics.checkNotNullParameter(r9, "ktvComponentCommonUIViewHolder");
        Intrinsics.checkNotNullParameter(r10, "seiSender");
        this.s = System.currentTimeMillis();
        this.l = r7;
        this.b = r8;
        this.a = r9;
        this.i = (TextView) r7.findViewById(2131377036);
        this.j = r7.findViewById(2131376928);
        this.h = (TextView) r7.findViewById(2131364159);
        this.c = (ViewGroup) r7.findViewById(2131364156);
        this.d = r7.findViewById(2131364157);
        this.e = r7.findViewById(2131364158);
        this.f = (TextView) r7.findViewById(2131364160);
        this.g = (TextView) r7.findViewById(2131385177);
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r11 = this.a;
        if (r11 == null) goto L7;
        ImageView r12 = r11.h;
        if (r12 == null) goto L7;
        r12.setImageResource(2131252047);
    L7:
        ViewGroup r13 = this.c;
        if (r13 == null) goto L10;
        r13.setVisibility(8);
    L10:
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r14 = this.a;
        boolean r0 = false;
        if (r14 == null) goto L15;
        ViewGroup r15 = r14.f;
        if (r15 == null) goto L15;
        r15.setVisibility(0);
    L15:
        Integer r3 = null;
        AbstractDraweeController r16 = Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse(com.bytedance.android.live.ktv.common.util.n.a((String) vm2.h.m1.getValue(null, vm2.h.a[115(0x73, float:1.61E-43)])))).setAutoPlayAnimations(true).build();
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r2 = this.a;
        if (r2 == null) goto L21;
        HSImageView r4 = r2.j;
        if (r4 == null) goto L21;
        r4.setController(r16);
    L21:
        if (this.o == false) goto L27;
        com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.b r17 = this.a;
        if (r17 == null) goto L27;
        HSImageView r18 = r17.j;
        if (r18 == null) goto L27;
        r18.setVisibility(0);
    L27:
        RxUtilKt.c(Observable.timer(5000, TimeUnit.MILLISECONDS).subscribeOn(AndroidSchedulers.mainThread()).subscribe(com.bytedance.android.livesdk.ktvimpl.ktvcomponent.ui.audience.a.a), this.k);
        com.bytedance.android.livesdk.ktvimpl.base.util.j r19 = com.bytedance.android.livesdk.ktvimpl.base.util.j.l;
        TextView r5 = this.i;
        r19.getClass();
        com.bytedance.android.livesdk.ktvimpl.base.util.j.h(r5);
        com.bytedance.android.livesdk.ktvimpl.base.util.j.h(this.j);
        KtvContext.Companion.getClass();
        if (KtvContext.a.m() == false) goto L51;
        u r20 = o3.d();
        if (r20 == null) goto L40;
        j r21 = r20.getVideoTalkRoomSubScene();
        if (r21 == null) goto L40;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r22 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r21.getValue();
        if (r22 == null) goto L40;
        BehaviorSubject r23 = r22.i();
        if (r23 == null) goto L40;
        Disposable r24 = r23.subscribe(new b(this, r7));
        if (r24 == null) goto L40;
        RxUtilKt.c(r24, this.k);
    L40:
        u r25 = o3.d();
        if (r25 == null) goto L73;
        j r26 = r25.getVideoTalkRoomSubScene();
        if (r26 == null) goto L73;
        com.bytedance.android.livesdk.chatroom.viewmodel.e r27 = (com.bytedance.android.livesdk.chatroom.viewmodel.e) r26.getValue();
        if (r27 == null) goto L73;
        BehaviorSubject r28 = r27.d();
        if (r28 == null) goto L73;
        Disposable r29 = r28.subscribe(new c(this, r7));
        if (r29 == null) goto L73;
        RxUtilKt.c(r29, this.k);
    L73:
        if (r8 == null) goto L75;
        r8.setOrderSongReadList(new ArrayList());
    L75:
        KtvComponentOrderedSongDataContext r30 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r30 == null) goto L80;
        Disposable r31 = com.bytedance.android.livesdk.ktvimpl.base.orderedsong.c.a.a(r30, null, new f(this), 3);
        if (r31 == null) goto L80;
        RxUtilKt.c(r31, this.k);
    L80:
        ChorusContext r32 = ChorusContext.Companion.getContext();
        if (r32 == null) goto L85;
        n<List<MusicPanel>> r33 = r32.getChorusSelectedSongList();
        if (r33 == null) goto L85;
        i80.a.b(r33, new AudienceKtvComponentStrategy$onWidgetCreate$6(this));
    L85:
        if (r8 == null) goto L89;
        NextLiveData<Integer> r34 = r8.getOrderSongUnReadNum();
        if (r34 == null) goto L89;
        r34.observe(r7, new g(this));
    L89:
        KtvContext r35 = KtvContext.a.g();
        if (r35 == null) goto L96;
        n<Long> r36 = r35.getKtvAddDressVersion();
        if (r36 == null) goto L96;
        Observable r37 = r36.a();
        if (r37 == null) goto L96;
        r37.subscribe(new h(this));
    L96:
        ((Widget) r7).dataCenter.observe("paid_live_hidden_link_multi_view", this, true);
        Observable r38 = xs2.b.a().b(zg1.j.class);
        if (r38 == null) goto L103;
        Observable r39 = r38.observeOn(AndroidSchedulers.mainThread());
        if (r39 == null) goto L103;
        final AudienceKtvComponentStrategy$onWidgetCreate$9 r40 = new AudienceKtvComponentStrategy$onWidgetCreate$9(this);
        Disposable r41 = r39.subscribe(new i(r40));
        if (r41 == null) goto L103;
        RxUtilKt.c(r41, this.k);
    L103:
        IInteractService r42 = jc1.k.f(IInteractService.class);
        if (r42 == null) goto L106;
        Integer r43 = Integer.valueOf(r42.getCurrentScene());
    L107:
        this.p = r43;
        IInteractService r44 = jc1.k.f(IInteractService.class);
        if (r44 == null) goto L110;
        r3 = Integer.valueOf(r44.getCurrentUiLayout());
    L110:
        this.q = r3;
        Integer r45 = this.p;
        if (r45 != null) goto L114;
    L123:
        this.r = r0;
        this.t = true;
        return;
    L114:
        if (r45.intValue() != 8) goto L123;
        Integer r46 = this.q;
        if (r46 == null) goto L123;
        if (r46.intValue() != 7) goto L123;
        if (jc1.k.n(IInteractService.class).dynamicFromAudience() == false) goto L123;
        r0 = true;
        goto L123
    L106:
        r43 = null;
        goto L107
    L51:
        u r47 = o3.d();
        if (r47 == null) goto L62;
        j r48 = r47.s();
        if (r48 == null) goto L62;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r49 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r48.getValue();
        if (r49 == null) goto L62;
        BehaviorSubject r50 = r49.b();
        if (r50 == null) goto L62;
        Disposable r51 = r50.subscribe(new d(this, r7));
        if (r51 == null) goto L62;
        RxUtilKt.c(r51, this.k);
    L62:
        u r52 = o3.d();
        if (r52 == null) goto L73;
        j r53 = r52.s();
        if (r53 == null) goto L73;
        com.bytedance.android.livesdk.chatroom.viewmodel.f r54 = (com.bytedance.android.livesdk.chatroom.viewmodel.f) r53.getValue();
        if (r54 == null) goto L73;
        BehaviorSubject r55 = r54.a();
        if (r55 == null) goto L73;
        Disposable r56 = r55.subscribe(new e(this, r7));
        if (r56 == null) goto L73;
        RxUtilKt.c(r56, this.k);
        goto L73
    }
}
