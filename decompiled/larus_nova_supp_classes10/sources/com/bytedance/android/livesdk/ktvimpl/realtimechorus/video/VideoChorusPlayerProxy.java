package com.bytedance.android.livesdk.ktvimpl.realtimechorus.video;

import android.text.TextUtils;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import com.bytedance.android.live.GsonHelper;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.live.ktv.common.util.KtvSettingHelper;
import com.bytedance.android.livesdk.chatroom.widget.j1;
import com.bytedance.android.livesdk.ktvapi.model.PanelType;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.KtvComponentOrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt;
import com.bytedance.android.livesdk.ktvimpl.crossplatform.earmonitor.KtvEarMonitor;
import com.bytedance.android.livesdk.ktvimpl.crossplatform.midi.KtvMidiController;
import com.bytedance.android.livesdk.ktvimpl.crossplatform.player.KtvMusicPlayer;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class VideoChorusPlayerProxy implements com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c, com.bytedance.android.livesdk.ktvimpl.crossplatform.player.d {
    public final MutableLiveData<Boolean> a;
    public final MutableLiveData<jd2.c> b;
    public final MutableLiveData<jd2.a> c;
    public KtvMusicPlayer d;
    public final KtvEarMonitor e;
    public fe2.b f;
    public KtvMidiController g;
    public final nd2.d h;
    public final List<MusicPanel> i;
    public final b j;
    public final VideoChorusPlayerProxy$musicDownloadCallback$1 k;
    public final String l;
    public final j1 m;

    public static final class a {
    }

    public static final class b extends vb6.a {
        public final /* synthetic */ VideoChorusPlayerProxy a;

        public final void s1() {
            this.a.h();
        }

        public b(VideoChorusPlayerProxy r1) {
            this.a = r1;
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ Ref.ObjectRef a;
        public final /* synthetic */ Observer b;

        public c(Ref.ObjectRef r1, Observer r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r6) {
            jd2.c r7 = (jd2.c) r6;
            if (r7 == null) goto L15;
            Long r0 = (Long) this.a.element;
            if (r0 == null) goto L12;
            long r1 = r7.b;
            if (r0 == null) goto L12;
            if (r1 != r0.longValue()) goto L12;
            return;
        L12:
            Ref.ObjectRef r2 = this.a;
            r2.element = Long.valueOf(r7.b);
            this.b.onChanged(r7);
            return;
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ Ref.ObjectRef a;
        public final /* synthetic */ Observer b;

        public d(Ref.ObjectRef r1, Observer r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void onChanged(Object r3) {
            jd2.c r4 = (jd2.c) r3;
            if (r4 == null) goto L15;
            Integer r0 = (Integer) this.a.element;
            if (r0 == null) goto L12;
            int r1 = r4.a;
            if (r0 == null) goto L12;
            if (r1 != r0.intValue()) goto L12;
            return;
        L12:
            Ref.ObjectRef r2 = this.a;
            r2.element = Integer.valueOf(r4.a);
            this.b.onChanged(r4);
            return;
        }
    }

    static {
    }

    public static MusicPanel t() {
        KtvComponentOrderedSongDataContext r0 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.getKtvPublicFirstOrderedSong();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c
    public final String b() {
        KtvComponentOrderedSongDataContext r0 = KtvComponentOrderedSongDataContext.Companion.getContext();
        if (r0 == null) goto L14;
        MusicPanel r1 = r0.getKtvPublicFirstOrderedSong();
        if (r1 == null) goto L15;
        KtvMusic r2 = r1.a;
        if (r2 == null) goto L16;
        String r3 = GsonProtectorUtils.toJson(GsonHelper.getDefault(), CollectionsKt.listOf(r2));
        if (r3 != null) goto L13;
        return "";
    L13:
        return r3;
    L16:
        return "";
    L15:
        return "";
    L14:
        return "";
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c
    public final jd2.c f() {
        return (jd2.c) this.b.getValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c
    public final void h() {
        UtilityKotlinExtentionsKt.b(this, VideoChorusPlayerProxy$destroyMusicPlayer$1.INSTANCE);
        this.e.p(false, false);
        KtvMusicPlayer r0 = this.d;
        if (r0 == null) goto L5;
        r0.release();
    L5:
        this.d = null;
        this.g = null;
        this.f = null;
        this.a.setValue(Boolean.FALSE);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c
    public final boolean i() {
        Boolean r0 = (Boolean) this.a.getValue();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.booleanValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c
    public final void j() {
        this.d = new KtvMusicPlayer(this, this.m);
        this.f = new fe2.b(this.m);
        this.g = new KtvMidiController();
        this.e.f(true);
        this.a.setValue(Boolean.TRUE);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.d
    public final com.bytedance.live.datacontext.m<Map<String, com.bytedance.android.live.ktv.common.model.bean.f>> n() {
        KtvContext.Companion.getClass();
        return KtvContext.a.g().getMusicDownloadResourceMap();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c
    public final jd2.a o() {
        return (jd2.a) this.c.getValue();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.d
    public final MusicPanel a() {
        return t();
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c
    public final void s() {
        xs2.b.a().post(new jd2.f(PanelType.ORDER_SONG_PANEL.getValue(), 14));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c
    public final fe2.a c() {
        return this.f;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c
    public final com.bytedance.android.livesdk.ktvimpl.crossplatform.midi.a d() {
        return this.g;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c
    public final KtvEarMonitor g() {
        return this.e;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c
    public final com.bytedance.android.livesdk.ktvimpl.crossplatform.player.b k() {
        return this.d;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c
    public final void m(JsonObject r5) {
        Intrinsics.checkNotNullParameter(r5, "extraData");
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.b.b("VideoChorusPlayerProxy", "downloadMusic ;; extraData == " + r5);
        MusicPanel r6 = t();
        if (r6 != null) goto L6;
        return;
    L6:
        if (((Boolean) KtvSettingHelper.o.getValue()).booleanValue() == false) goto L21;
        Iterator r0 = ((ArrayList) this.i).iterator();
    L9:
        if (r0.hasNext() == false) goto L13;
        Object r1 = r0.next();
        if ((!((MusicPanel) r1).a.isSameKtvMusic(r6.a)) == false) goto L9;
    L15:
        if (((MusicPanel) r1) == null) goto L20;
        Iterator r2 = ((ArrayList) this.i).iterator();
    L18:
        if (r2.hasNext() == false) goto L20;
        MusicPanel r3 = (MusicPanel) r2.next();
        com.bytedance.android.live.ktv.common.music.download.m r4 = KtvMusicManager.a;
        KtvMusicManager.a(r3);
    L20:
        ((ArrayList) this.i).add(r6);
        goto L21
    L13:
        r1 = null;
    L21:
        nd2.d.a(this.h, r6, this.k, ((Boolean) KtvSettingHelper.o.getValue()).booleanValue());
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c
    public final Pair<Boolean, Boolean> p(String r4) {
        MusicPanel r0 = t();
        if (r0 != null) goto L6;
        Boolean r1 = Boolean.FALSE;
        return new Pair(r1, r1);
    L6:
        boolean r2 = KtvUtilsKt.h(r0);
        if (r4 != null) goto L10;
    L28:
        Boolean r3 = Boolean.FALSE;
        return new Pair(r3, r3);
    L10:
        switch(r4.hashCode()) {
            case -1834375653: goto L25;
            case 3351329: goto L21;
            case 103457887: goto L17;
            case 1379043793: goto L13;
            default: goto L28;
        };
    L13:
        if (r4.equals("original") == false) goto L28;
        return new Pair(Boolean.valueOf(com.bytedance.android.live.ktv.common.util.KtvUtilsKt.F(r0)), Boolean.valueOf(r2));
    L17:
        if (r4.equals("lyric") == false) goto L28;
        Lazy r5 = com.bytedance.android.live.ktv.common.util.KtvUtilsKt.a;
        Intrinsics.checkNotNullParameter(r0, "$this$isSupportLyricWithPath");
        return new Pair(Boolean.valueOf(!TextUtils.isEmpty(r0.l)), Boolean.valueOf(r2));
    L21:
        if (r4.equals("midi") == false) goto L28;
        return new Pair(Boolean.valueOf(com.bytedance.android.live.ktv.common.util.KtvUtilsKt.B(r0)), Boolean.valueOf(r2));
    L25:
        if (r4.equals("accompany") == false) goto L28;
        return new Pair(Boolean.valueOf(com.bytedance.android.live.ktv.common.util.KtvUtilsKt.y(r0)), Boolean.valueOf(r2));
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c
    public final void q(jd2.c r5) {
        Intrinsics.checkNotNullParameter(r5, "data");
        if (((Boolean) KtvSettingHelper.Y0.getValue()).booleanValue() == false) goto L17;
        String r0 = r5.e;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L10:
        boolean r2 = true;
    L11:
        if (r2 == false) goto L13;
    L16:
        r1 = true;
    L18:
        if (r1 == false) goto L21;
        this.b.setValue(r5);
        return;
    L21:
        return;
    L13:
        if (Intrinsics.areEqual(r5.e, BDLocationException.ERROR_TIMEOUT) == true) goto L16;
        if (Intrinsics.areEqual(this.l, r5.e) == false) goto L18;
    L7:
        if (StringsKt.isBlank(r0) == true) goto L10;
        r2 = false;
        goto L11
    L17:
        r1 = Intrinsics.areEqual(this.l, r5.e);
        goto L18
    }

    public final void u(jd2.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        this.c.setValue(r2);
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.bytedance.android.livesdk.ktvimpl.realtimechorus.video.VideoChorusPlayerProxy$musicDownloadCallback$1] */
    public VideoChorusPlayerProxy(String r2, j1 r3) {
        Intrinsics.checkNotNullParameter(r2, "roomId");
        this.l = r2;
        this.m = r3;
        MutableLiveData<Boolean> r4 = new MutableLiveData();
        r4.setValue(Boolean.FALSE);
        Unit r0 = Unit.INSTANCE;
        this.a = r4;
        this.b = new MutableLiveData();
        this.c = new MutableLiveData();
        KtvEarMonitor r5 = new KtvEarMonitor(r3);
        r5.init();
        this.e = r5;
        this.h = new nd2.d();
        this.i = new ArrayList();
        b r6 = new b(this);
        this.j = r6;
        this.k = new VideoChorusPlayerProxy$musicDownloadCallback$1(this);
        if (r3 == null) goto L10;
        cg6.a r7 = r3.getScopeServiceOrNullInMultiLinkRoom(cg6.a.class);
        if (r7 == null) goto L11;
        vb6.g r8 = r7.O5();
        if (r8 == null) goto L12;
        r8.X0(r6, true);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c
    public final void e(LifecycleOwner r3, Observer<jd2.c> r4) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        Intrinsics.checkNotNullParameter(r4, "observer");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = null;
        c r1 = new c(r0, r4);
        this.b.observe(r3, r1);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c
    public final void l(LifecycleOwner r3, Observer<jd2.c> r4) {
        Intrinsics.checkNotNullParameter(r3, "owner");
        Intrinsics.checkNotNullParameter(r4, "observer");
        Ref.ObjectRef r0 = new Ref.ObjectRef();
        r0.element = null;
        d r1 = new d(r0, r4);
        this.b.observe(r3, r1);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c
    public final void observeMusicPlayerState(LifecycleOwner r2, com.ss.android.ugc.aweme.compat.nullable.Observer<Boolean> r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.a.observe(r2, r3);
    }

    @Override // com.bytedance.android.livesdk.ktvimpl.crossplatform.player.c
    public final void r(LifecycleOwner r2, Observer<jd2.a> r3) {
        Intrinsics.checkNotNullParameter(r2, "owner");
        Intrinsics.checkNotNullParameter(r3, "observer");
        this.c.observe(r2, r3);
    }
}
