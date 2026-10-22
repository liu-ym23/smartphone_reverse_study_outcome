package com.bytedance.android.livesdk.ktvimpl.base.controlnode;

import android.content.Context;
import android.graphics.Rect;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.live.core.utils.rxutils.RxUtil;
import com.bytedance.android.live.core.utils.rxutils.RxUtilKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.karaokestation.model.g;
import com.bytedance.android.live.ktv.common.model.bean.DownloadResourceType;
import com.bytedance.android.live.ktv.common.music.download.KtvMusicManager;
import com.bytedance.android.live.ktv.common.music.download.m;
import com.bytedance.android.live.ktv.common.music.download.p;
import com.bytedance.android.live.ktv.common.util.KtvUtilsKt;
import com.bytedance.android.live.ktv.common.util.i;
import com.bytedance.android.live.multilink.ktv.SongUniqueInfo;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.efffectselect.EffectMusicSelectDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvcomponent.KtvComponentOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.KtvModeOrderSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.base.orderedsong.OrderedSongDataContext;
import com.bytedance.android.livesdk.ktvimpl.base.util.e;
import com.bytedance.android.livesdk.ktvimpl.ktvcomponent.api.KtvComponentApi;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.view.previewsongs.KtvPreviewSongsViewHolder;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdk.message.model.WantListenInfo;
import com.bytedance.android.livesdk.utils.r2;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.model.ModeType;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.bytedance.live.datacontext.j;
import com.bytedance.livesdk.ktvcommon.download.model.DownloadPriority;
import com.bytedance.livesdk.ktvcommon.download.model.l;
import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mb0.f;
import vm2.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class AddMusicControlNode extends com.bytedance.android.live.ktv.common.music.control.b {
    public static final /* synthetic */ int q = 0;
    public final Map<String, Long> l;
    public final Map<String, Long> m;
    public final b n;
    public final c o;
    public final RecyclerView.ViewHolder p;

    public static final class a {
    }

    public static final class b implements p.a {
        public final /* synthetic */ AddMusicControlNode a;
        public final /* synthetic */ MusicPanel b;

        public b(AddMusicControlNode r1, MusicPanel r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void c(MusicPanel r3, int r4) {
            if (r3 != null) goto L4;
            return;
        L4:
            r3.b = 2;
            r3.s = r4;
            this.a.j(1, r3);
            i.a(r3.a.getMId(), r4);
        }

        public final void a(MusicPanel r2, String r3, String r4) {
            if (r2 != null) goto L4;
            return;
        L4:
            pd2.d.n.getClass();
            pd2.d.B("choose_download_success", r2, null);
            int r5 = f.a;
            f.i(this.b);
            AddMusicControlNode.l(this.a, r2);
            i.a(r2.a.getMId(), 100);
            Long r6 = KtvLoggerHelper.a;
            KtvLoggerHelper.O(r2, "1", AddMusicControlNode.k(this.a, r2));
        }

        public final void b(MusicPanel r6, int r7, String r8) {
            if (r6 != null) goto L4;
            return;
        L4:
            r6.s = 0;
            pd2.d r1 = pd2.d.n;
            HashMap r2 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(LocationMonitorConst.ERR_CODE, String.valueOf(r7))});
            r1.getClass();
            pd2.d.B("choose_download_fail", r6, r2);
            int r3 = f.a;
            MusicPanel r4 = this.b;
            if (r8 != null) goto L7;
            String r5 = "";
        L8:
            f.h(r4, r7, r5);
            Function1 r9 = KtvMusicManager.j;
            if (r8 != null) goto L12;
            r8 = "";
        L12:
            if (((Boolean) r9.invoke(r8)).booleanValue() == false) goto L14;
            f2.b(2131918481, 0);
        L15:
            this.a.g(r6);
            i.a(r6.a.getMId(), -1);
            Long r10 = KtvLoggerHelper.a;
            KtvLoggerHelper.O(r6, BDLocationException.ERROR_TIMEOUT, AddMusicControlNode.k(this.a, r6));
            return;
        L14:
            f2.b(2131918370, 0);
            goto L15
        L7:
            r5 = r8;
            goto L8
        }
    }

    public static final class c implements p.a {
        public final /* synthetic */ AddMusicControlNode a;
        public final /* synthetic */ MusicPanel b;

        public c(AddMusicControlNode r1, MusicPanel r2) {
            this.a = r1;
            this.b = r2;
        }

        public final void c(MusicPanel r3, int r4) {
            Intrinsics.checkNotNullParameter(r3, "panel");
            r3.b = 2;
            r3.s = r4;
            this.a.j(1, r3);
            i.a(r3.a.getMId(), r4);
        }

        public final void a(MusicPanel r11, String r12, String r13) {
            if (r11 != null) goto L4;
            return;
        L4:
            Long r14 = (Long) ((LinkedHashMap) this.a.l).get(String.valueOf(r11.a.getId()));
            long r0 = 0;
            if (r14 == null) goto L7;
            long r15 = r14.longValue();
        L8:
            Object r5 = null;
            if (r15 != 0) goto L98;
            ALogger.i("ktv_music_resource_download_opt_tag", "repeat main_resource success callback ;; songName == " + r11.a.getMTitle() + ' ');
            KtvComponentOrderSongDataContext.Companion.getClass();
            KtvComponentOrderSongDataContext r16 = KtvComponentOrderSongDataContext.Companion.d();
            if (r16 == null) goto L15;
            j<com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d> r17 = r16.m58getBusinessOrderSongViewModel();
            if (r17 == null) goto L15;
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r18 = (com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d) r17.getValue();
        L16:
            KtvModeOrderSongDataContext.Companion.getClass();
            KtvModeOrderSongDataContext r19 = KtvModeOrderSongDataContext.Companion.d();
            if (r19 == null) goto L21;
            j<com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d> r110 = r19.m102getBusinessOrderSongViewModel();
            if (r110 == null) goto L21;
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r111 = (com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d) r110.getValue();
        L22:
            EffectMusicSelectDataContext.Companion.getClass();
            EffectMusicSelectDataContext r1 = EffectMusicSelectDataContext.Companion.d();
            if (r1 == null) goto L27;
            j<com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d> r2 = r1.m49getBusinessOrderSongViewModel();
            if (r2 == null) goto L27;
            com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d r3 = (com.bytedance.android.livesdk.ktvimpl.base.karaokestation.d) r2.getValue();
        L28:
            if (r18 == null) goto L51;
            OrderedSongDataContext r112 = r18.getOrderedSongDataContext();
            if (r112 == null) goto L45;
            List<SongUniqueInfo> r113 = r112.m201getKtvSongUniqueInfoList();
            if (r113 == null) goto L45;
            Iterator<T> r114 = r113.iterator();
        L35:
            if (r114.hasNext() == false) goto L44;
            Object r4 = r114.next();
            SongUniqueInfo r6 = (SongUniqueInfo) r4;
            if (r6.getSongId() == r11.c()) goto L39;
        L41:
            boolean r7 = false;
        L42:
            if (r7 == false) goto L35;
            r5 = r4;
            goto L44
        L39:
            if (Intrinsics.areEqual(r6.getUserId(), r11.a.getOrderUserIdString()) == false) goto L41;
            r7 = true;
        L44:
            r5 = (SongUniqueInfo) r5;
        L45:
            if (r5 == null) goto L47;
            return;
        L47:
            if (KtvUtilsKt.m(r11) == true) goto L49;
            return;
        L49:
            if (r18.inSelfDownloadMusicById(r11.a.getMIdStr()) == false) goto L128;
            AddMusicControlNode.l(this.a, r11);
            r18.deleteSelfDownloadMusicById(r11.a.getMIdStr());
            return;
        L128:
            return;
        L51:
            if (r111 == null) goto L74;
            OrderedSongDataContext r115 = r111.getOrderedSongDataContext();
            if (r115 == null) goto L68;
            List<SongUniqueInfo> r116 = r115.m201getKtvSongUniqueInfoList();
            if (r116 == null) goto L68;
            Iterator<T> r117 = r116.iterator();
        L58:
            if (r117.hasNext() == false) goto L67;
            Object r8 = r117.next();
            SongUniqueInfo r9 = (SongUniqueInfo) r8;
            if (r9.getSongId() == r11.c()) goto L62;
        L64:
            boolean r10 = false;
        L65:
            if (r10 == false) goto L58;
            r5 = r8;
            goto L67
        L62:
            if (Intrinsics.areEqual(r9.getUserId(), r11.a.getOrderUserIdString()) == false) goto L64;
            r10 = true;
        L67:
            r5 = (SongUniqueInfo) r5;
        L68:
            if (r5 == null) goto L70;
            return;
        L70:
            if (KtvUtilsKt.m(r11) == true) goto L72;
            return;
        L72:
            if (r111.inSelfDownloadMusicById(r11.a.getMIdStr()) == false) goto L132;
            AddMusicControlNode.l(this.a, r11);
            r111.deleteSelfDownloadMusicById(r11.a.getMIdStr());
            return;
        L132:
            return;
        L74:
            if (r3 == null) goto L134;
            OrderedSongDataContext r118 = r3.getOrderedSongDataContext();
            if (r118 == null) goto L91;
            List<SongUniqueInfo> r119 = r118.m201getKtvSongUniqueInfoList();
            if (r119 == null) goto L91;
            Iterator<T> r120 = r119.iterator();
        L81:
            if (r120.hasNext() == false) goto L90;
            Object r121 = r120.next();
            SongUniqueInfo r20 = (SongUniqueInfo) r121;
            if (r20.getSongId() == r11.c()) goto L85;
        L87:
            boolean r21 = false;
        L88:
            if (r21 == false) goto L81;
            r5 = r121;
            goto L90
        L85:
            if (Intrinsics.areEqual(r20.getUserId(), r11.a.getOrderUserIdString()) == false) goto L87;
            r21 = true;
        L90:
            r5 = (SongUniqueInfo) r5;
        L91:
            if (r5 == null) goto L93;
            return;
        L93:
            if (KtvUtilsKt.m(r11) == true) goto L95;
            return;
        L95:
            if (r3.inSelfDownloadMusicById(r11.a.getMIdStr()) == false) goto L137;
            AddMusicControlNode.l(this.a, r11);
            r3.deleteSelfDownloadMusicById(r11.a.getMIdStr());
            return;
        L137:
            return;
        L134:
            return;
        L27:
            r3 = null;
        L21:
            r111 = null;
        L15:
            r18 = null;
            goto L16
        L98:
            pd2.d.n.getClass();
            pd2.d.B("choose_download_success", r11, null);
            int r122 = f.a;
            f.i(this.b);
            AddMusicControlNode.l(this.a, r11);
            i.a(r11.a.getMId(), 100);
            Long r123 = KtvLoggerHelper.a;
            KtvLoggerHelper.O(r11, "1", AddMusicControlNode.k(this.a, r11));
            StringBuilder r124 = new StringBuilder("main_resource download success duration == ");
            long r22 = System.currentTimeMillis();
            Long r125 = (Long) ((LinkedHashMap) this.a.l).get(String.valueOf(r11.a.getId()));
            if (r125 == null) goto L101;
            long r23 = r125.longValue();
        L102:
            r124.append(r22 - r23);
            r124.append(" ;; songName == ");
            r124.append(r11.a.getMTitle());
            ALogger.i("ktv_music_resource_download_opt_tag", r124.toString());
            this.a.l.remove(String.valueOf(r11.a.getId()));
            this.a.m.put(String.valueOf(r11.a.getId()), Long.valueOf(System.currentTimeMillis()));
            if (KtvUtilsKt.E(r11) == true) goto L109;
            StringBuilder r126 = new StringBuilder("other_resource not need download duration == ");
            long r24 = System.currentTimeMillis();
            Long r25 = (Long) ((LinkedHashMap) this.a.m).get(String.valueOf(r11.a.getId()));
            if (r25 == null) goto L107;
            r0 = r25.longValue();
        L107:
            r126.append(r24 - r0);
            r126.append(" ;; songName == ");
            r126.append(r11.a.getMTitle());
            ALogger.i("ktv_music_resource_download_opt_tag", r126.toString());
            AddMusicControlNode r127 = this.a;
            com.bytedance.android.live.ktv.common.model.bean.f r128 = new com.bytedance.android.live.ktv.common.model.bean.f(DownloadResourceType.OTHER_RESOURCE, false);
            r127.getClass();
            AddMusicControlNode.n(r11, r128);
            this.a.m.remove(String.valueOf(r11.a.getId()));
            return;
        L109:
            AddMusicControlNode r129 = this.a;
            com.bytedance.android.live.ktv.common.model.bean.f r130 = new com.bytedance.android.live.ktv.common.model.bean.f(DownloadResourceType.OTHER_RESOURCE, true);
            r129.getClass();
            AddMusicControlNode.n(r11, r130);
            AddMusicControlNode r131 = this.a;
            r131.getClass();
            KtvMusicManager.e(KtvMusicManager.m, r11, new com.bytedance.android.livesdk.ktvimpl.base.controlnode.c(r131), false, null, false, 28);
            return;
        L101:
            r23 = 0;
            goto L102
        L7:
            r15 = 0;
            goto L8
        }

        public final void b(MusicPanel r6, int r7, String r8) {
            Intrinsics.checkNotNullParameter(r8, "errorMsg");
            if (r6 != null) goto L5;
            return;
        L5:
            r6.s = 0;
            pd2.d r1 = pd2.d.n;
            HashMap r2 = MapsKt.hashMapOf(new Pair[]{TuplesKt.to(LocationMonitorConst.ERR_CODE, String.valueOf(r7))});
            r1.getClass();
            pd2.d.B("choose_download_fail", r6, r2);
            int r3 = f.a;
            f.h(this.b, r7, r8);
            if (((Boolean) KtvMusicManager.j.invoke(r8)).booleanValue() == false) goto L8;
            f2.b(2131918481, 0);
        L9:
            this.a.g(r6);
            i.a(r6.a.getMId(), -1);
            Long r9 = KtvLoggerHelper.a;
            KtvLoggerHelper.O(r6, BDLocationException.ERROR_TIMEOUT, AddMusicControlNode.k(this.a, r6));
            StringBuilder r10 = new StringBuilder("main_resource download fail duration == ");
            long r4 = System.currentTimeMillis();
            Long r11 = (Long) ((LinkedHashMap) this.a.l).get(String.valueOf(r6.a.getId()));
            if (r11 == null) goto L12;
            long r5 = r11.longValue();
        L13:
            r10.append(r4 - r5);
            r10.append(" ;; songName == ");
            r10.append(r6.a.getMTitle());
            ALogger.i("ktv_music_resource_download_opt_tag", r10.toString());
            AddMusicControlNode r12 = this.a;
            com.bytedance.android.live.ktv.common.model.bean.f r13 = new com.bytedance.android.live.ktv.common.model.bean.f(DownloadResourceType.OTHER_RESOURCE, false);
            r12.getClass();
            AddMusicControlNode.n(r6, r13);
            this.a.l.remove(String.valueOf(r6.a.getId()));
            this.a.m.remove(String.valueOf(r6.a.getId()));
            return;
        L12:
            r5 = 0;
            goto L13
        L8:
            f2.b(2131918370, 0);
            goto L9
        }
    }

    public static final class d implements rj0.b {
        public final /* synthetic */ AddMusicControlNode a;
        public final /* synthetic */ MusicPanel b;

        public final void onSuccess() {
            this.a.m(this.b);
        }

        public final void onFailed(Exception r4) {
            ALogger.i(bb0.b.b(), "selectMultiKtvMusicPanel checkPermision fail, invoke class :".concat(d.class.getSimpleName()));
            AddMusicControlNode r5 = this.a;
            MusicPanel r0 = this.b;
            int r1 = AddMusicControlNode.q;
            r5.g(r0);
            pd2.d.n.b("choose_check_permission_fail", this.b, null);
        }

        public d(AddMusicControlNode r1, MusicPanel r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    static {
    }

    public final void a() {
        super/*com.bytedance.android.live.ktv.common.music.control.d*/.a();
        KtvContext.Companion.getClass();
        KtvContext.a.g().getMusicDownloadResourceMap().setValue(new LinkedHashMap());
    }

    public final void d() {
        super/*com.bytedance.android.live.ktv.common.music.control.d*/.d();
        pd2.d r0 = pd2.d.n;
        MusicPanel r1 = ((com.bytedance.android.live.ktv.common.music.control.d) this).d;
        r0.getClass();
        pd2.d.s(r1, pd2.d.i);
    }

    public final void f(MusicPanel r12) {
        Intrinsics.checkNotNullParameter(r12, "panel");
        boolean r2 = true;
        if (h.a() == false) goto L13;
        b r0 = this.n;
        r12.s = 0;
        r12.b = 2;
        j(1, r12);
        boolean r1 = com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt.a(r12, true);
        n(r12, new com.bytedance.android.live.ktv.common.model.bean.f(DownloadResourceType.MAIN_RESOURCE, true));
        com.bytedance.android.livesdk.ktvimpl.base.controlnode.b r4 = new com.bytedance.android.livesdk.ktvimpl.base.controlnode.b(this, r12, r0);
        com.bytedance.livesdk.ktvimpl.base.download.a r3 = com.bytedance.livesdk.ktvimpl.base.download.a.c;
        KtvMusic r5 = r12.a;
        if (((com.bytedance.android.live.ktv.common.music.control.d) this).e == ModeType.MUSIC_EFFECT) goto L8;
        r2 = false;
    L8:
        l r6 = new l(r1, r2, 60);
        DownloadPriority r7 = DownloadPriority.NORMAL;
        r3.getClass();
        com.bytedance.livesdk.ktvimpl.base.download.a.c(r5, r6, r4, r7, "AddMusicNode");
        if (h.o() == false) goto L11;
        pd2.d.n.getClass();
        pd2.d.l.f("download", new pd2.b(r12, null));
        return;
    L11:
        pd2.d.n.getClass();
        pd2.d.t("download", r12, null);
        return;
    L13:
        r12.b = 2;
        j(1, r12);
        this.l.put(String.valueOf(r12.a.getId()), Long.valueOf(System.currentTimeMillis()));
        boolean r8 = com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt.a(r12, true);
        n(r12, new com.bytedance.android.live.ktv.common.model.bean.f(DownloadResourceType.MAIN_RESOURCE, true));
        if (((com.bytedance.android.live.ktv.common.music.control.d) this).e != ModeType.MUSIC_EFFECT) goto L16;
        KtvMusicManager.e(KtvMusicManager.m, r12, this.o, false, null, false, 28);
    L18:
        if (h.o() == false) goto L20;
        pd2.d.n.getClass();
        pd2.d.l.f("download", new pd2.b(r12, null));
        return;
    L20:
        pd2.d.n.getClass();
        pd2.d.t("download", r12, null);
        return;
    L16:
        KtvMusicManager.e(KtvMusicManager.m, r12, this.o, false, new m(r8, !r8, 57), false, 20);
        goto L18
    }

    public final void i(MusicPanel r5) {
        Intrinsics.checkNotNullParameter(r5, "panel");
        if (getContext() != null) goto L5;
    L28:
        ALogger.i(bb0.b.b(), "selectMultiKtvMusicPanel fail, context or room is null, invoke class :".concat(AddMusicControlNode.class.getSimpleName()));
        g(r5);
        pd2.d r6 = pd2.d.n;
        MusicPanel r0 = ((com.bytedance.android.live.ktv.common.music.control.d) this).d;
        r6.getClass();
        pd2.d.s(r0, pd2.d.j);
        return;
    L5:
        if (((com.bytedance.android.live.ktv.common.music.control.b) this).k == null) goto L28;
        if (com.bytedance.android.live.ktv.common.util.j.i() == true) goto L26;
        Integer r1 = (Integer) ((ge1.a) hd0.c.f()).b;
        if (r1 == null) goto L26;
        if (r1.intValue() != 0) goto L26;
        IRoom r2 = ((com.bytedance.android.live.ktv.common.music.control.b) this).k;
        if (r2 != null) goto L18;
        return;
    L18:
        KtvContext.Companion.getClass();
        KtvContext r3 = KtvContext.a.g();
        if (r3 == null) goto L23;
        com.bytedance.live.datacontext.m<e> r4 = r3.getKtvRoomStrategy();
        if (r4 == null) goto L23;
        e r7 = (e) r4.getValue();
    L24:
        if (r7 == null) goto L30;
        Context r8 = getContext();
        Intrinsics.checkNotNull(r8);
        r7.checkPermision(r8, r2, new d(this, r5));
        return;
    L30:
        return;
    L23:
        r7 = null;
    L26:
        m(r5);
    }

    public final void m(final MusicPanel r22) {
        Intrinsics.checkNotNullParameter(r22, "panel");
        if (((com.bytedance.android.live.ktv.common.music.control.b) this).k == null) goto L68;
        String r2 = ((com.bytedance.android.live.ktv.common.music.control.b) this).i;
        boolean r3 = true;
        if (r2 != null) goto L7;
    L10:
        boolean r4 = true;
    L11:
        if (r4 == true) goto L68;
        long r6 = System.currentTimeMillis();
        String r5 = bb0.b.b();
        ALogger.i(r5, ("addMusic, panel=" + r22) + ", invoke class :" + AddMusicControlNode.class.getSimpleName());
        Disposable r8 = null;
        if (((com.bytedance.android.live.ktv.common.music.control.d) this).e != ModeType.MUSIC_EFFECT) goto L29;
        int r7 = rd2.a.a;
        rd2.a r9 = rd2.a.b.a;
        IRoom r10 = ((com.bytedance.android.live.ktv.common.music.control.b) this).k;
        if (r10 == null) goto L18;
        Long r11 = Long.valueOf(r10.getId());
    L19:
        long r12 = r11.longValue();
        long r13 = r22.c();
        Function1<com.bytedance.android.live.network.response.e<Object>, Unit> r14 = new AddMusicControlNode$addMusic$1(this, r22);
        Function1<Throwable, Unit> r15 = new AddMusicControlNode$addMusic$2(this, r22);
        r9.getClass();
        Intrinsics.checkNotNullParameter(r14, "successCallBack");
        Intrinsics.checkNotNullParameter(r15, "failCallBack");
        KtvComponentApi r16 = (KtvComponentApi) com.bytedance.android.live.network.c.b().e(KtvComponentApi.class);
        if (r16 == null) goto L26;
        Observable<com.bytedance.android.live.network.response.e<Object>> r1 = r16.chooseSong(r12, r13, 7);
        if (r1 == null) goto L26;
        Observable r17 = r1.compose(RxUtil.rxSchedulerHelper());
        if (r17 == null) goto L26;
        r8 = r17.subscribe(new rd2.d(r6, r14), new rd2.e(r6, r15));
    L26:
        if (r8 == null) goto L70;
        RxUtilKt.c(r8, ((com.bytedance.android.live.ktv.common.music.control.d) this).a);
        return;
    L70:
        return;
    L18:
        r11 = null;
        goto L19
    L29:
        String r18 = com.bytedance.android.live.ktv.common.util.a.b(r22.a);
        u r19 = com.bytedance.android.live.liveinteract.api.utils.m.d();
        if (r19 == null) goto L32;
        String r20 = r19.w();
    L33:
        r22.g = r20;
        int r21 = g.a;
        g r23 = g.b.a;
        IRoom r24 = ((com.bytedance.android.live.ktv.common.music.control.b) this).k;
        if (r24 == null) goto L36;
        Long r25 = Long.valueOf(r24.getId());
    L37:
        long r26 = r25.longValue();
        IRoom r27 = ((com.bytedance.android.live.ktv.common.music.control.b) this).k;
        if (r27 == null) goto L40;
        r8 = Long.valueOf(r27.getId());
    L40:
        long r110 = r8.longValue();
        long r111 = r22.a.getMId();
        int r28 = r22.a.getSongType();
        if (com.bytedance.android.live.ktv.common.util.j.i() == false) goto L49;
        WantListenInfo r29 = r22.a.getWantListenInfo();
        if (r29 == null) goto L45;
        long r112 = r29.getWantListenCount().longValue();
    L47:
        if (r112 <= 0) goto L49;
    L50:
        if (r3 == false) goto L54;
        String r30 = "permit_want_to_listen";
    L52:
        String r113 = r30;
    L64:
        Disposable r31 = r23.b(r6, r26, r110, r111, r28, r113, r22.b(), r18, null, new AddMusicControlNode$addMusic$3(this, r22), new AddMusicControlNode$addMusic$4(this, r22));
        if (r31 == null) goto L71;
        RxUtilKt.c(r31, ((com.bytedance.android.live.ktv.common.music.control.d) this).a);
        return;
    L71:
        return;
    L54:
        if (r2.a(r22.y) == false) goto L59;
        if (r2.a(r22.z) == false) goto L59;
        r30 = "search";
    L59:
        if (Intrinsics.areEqual(r22.d, "冷启推荐") == false) goto L61;
        r113 = "冷启推荐";
        goto L64
    L61:
        r30 = ((com.bytedance.android.live.ktv.common.music.control.b) this).i;
        if (r30 != null) goto L52;
        r30 = "";
        goto L52
    L45:
        r112 = 0;
    L49:
        r3 = false;
        goto L50
    L36:
        r25 = null;
        goto L37
    L32:
        r20 = null;
        goto L33
    L7:
        if (r2.length() == 0) goto L10;
        r4 = false;
    L68:
        ALogger.i(bb0.b.b(), "selectMultiKtvMusicPanel fail, songSource or room is null, invoke class :".concat(AddMusicControlNode.class.getSimpleName()));
        g(r22);
        pd2.d r32 = pd2.d.n;
        MusicPanel r33 = ((com.bytedance.android.live.ktv.common.music.control.d) this).d;
        r32.getClass();
        pd2.d.s(r33, pd2.d.j);
    }

    public static final long k(AddMusicControlNode r4, MusicPanel r5) {
        r4.getClass();
        long r0 = System.currentTimeMillis();
        Map<String, Long> r6 = r4.l;
        LinkedHashMap r7 = (LinkedHashMap) r6;
        Long r8 = (Long) r7.get(String.valueOf(r5.a.getId()));
        if (r8 == null) goto L5;
        long r9 = r8.longValue();
    L7:
        return r0 - r9;
    L5:
        r9 = 0;
        goto L7
    }

    public static final void l(AddMusicControlNode r1, MusicPanel r2) {
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "panel");
        r1.i(r2);
    }

    public static void n(MusicPanel r1, com.bytedance.android.live.ktv.common.model.bean.f r2) {
        KtvContext.Companion.getClass();
        Map r0 = (Map) KtvContext.a.g().getMusicDownloadResourceMap().getValue();
        r0.put(com.bytedance.android.livesdk.ktvimpl.base.util.KtvUtilsKt.c(r1), r2);
        ALogger.i("ktv_music_resource_download_opt_tag", r2.toString());
        KtvContext.a.g().getMusicDownloadResourceMap().setValue(r0);
    }

    public final void j(int r6, MusicPanel r7) {
        Intrinsics.checkNotNullParameter(r7, "panel");
        RecyclerView.ViewHolder r0 = this.p;
        if ((r0 instanceof KtvPreviewSongsViewHolder) == false) goto L18;
        if (((KtvPreviewSongsViewHolder) r0).d == r7.a.getMId()) goto L8;
        return;
    L8:
        if (r6 != 0) goto L10;
        KtvPreviewSongsViewHolder r8 = (KtvPreviewSongsViewHolder) this.p;
        r8.c.setText(s1.B(2131918626));
        r8.c.setClickable(false);
        return;
    L10:
        if (r6 != 1) goto L12;
        KtvPreviewSongsViewHolder r9 = (KtvPreviewSongsViewHolder) this.p;
        r9.c.setText(s1.C(2131918371, new Object[]{Integer.valueOf(r7.s)}));
        r9.c.setClickable(false);
        return;
    L12:
        if (r6 != 2) goto L27;
        ((KtvPreviewSongsViewHolder) this.p).T3();
        return;
    L27:
        return;
    L18:
        if ((r0 instanceof com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.f) == false) goto L26;
        if (r6 != 0) goto L21;
        Rect r10 = ((com.bytedance.android.livesdk.ktvimpl.base.karaokestation.ktvmode.view.secondleveltab.f) r0).J3();
        r7.getClass();
        Intrinsics.checkNotNullParameter(r10, "<set-?>");
        r7.v = r10;
        String r11 = "toggleSelected true:" + r7.a.getMTitle() + ", state = " + r7.b + ", progress = " + r7.s;
        ALogger.i(bb0.b.b(), r11 + ", invoke class :" + AddMusicControlNode.class.getSimpleName());
    L21:
        this.p.v0(r7);
        return;
    }

    public AddMusicControlNode(MusicPanel r2, RecyclerView.ViewHolder r3, ModeType r4) {
        Intrinsics.checkNotNullParameter(r2, "musicPanel");
        Intrinsics.checkNotNullParameter(r4, "modeType");
        super(r2, r4);
        this.p = r3;
        this.l = new LinkedHashMap();
        this.m = new LinkedHashMap();
        this.n = new b(this, r2);
        this.o = new c(this, r2);
    }

    public /* synthetic */ AddMusicControlNode(MusicPanel r3, KtvPreviewSongsViewHolder r4, int r5) {
        ModeType r1 = null;
        if ((r5 & 2) == 0) goto L6;
        r4 = null;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r1 = ModeType.KTV_MODE;
    L8:
        this(r3, r4, r1);
    }
}
