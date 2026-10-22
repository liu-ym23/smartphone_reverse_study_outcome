package com.bytedance.android.livesdk.ktvimpl.ktvroom.view.previewsongs;

import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.ktv.common.util.j;
import com.bytedance.android.live.liveinteract.api.utils.m;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdk.chatroom.u;
import com.bytedance.android.livesdk.chatroom.viewmodel.f;
import com.bytedance.android.livesdk.chatroom.viewmodel.g;
import com.bytedance.android.livesdk.ktvimpl.base.logger.KtvLoggerHelper;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.previewsongs.KtvPreviewSongsViewModel;
import com.bytedance.android.livesdk.message.model.KtvMusic;
import com.bytedance.android.livesdk.message.model.MusicPanel;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.bytedance.ies.sdk.widgets.Widget;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/previewsongs/KtvPreviewSongsViewModel$b;", "p1", "", "invoke", "(Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/previewsongs/KtvPreviewSongsViewModel$b;)V", "<anonymous>"}, k = 3, mv = {1, 5, 1})
final /* synthetic */ class KtvPreviewSongsWidget$initData$1 extends FunctionReferenceImpl implements Function1<KtvPreviewSongsViewModel.b, Unit> {
    public KtvPreviewSongsWidget$initData$1(KtvPreviewSongsWidget r8) {
        super(1, r8, KtvPreviewSongsWidget.class, "onRefreshEvent", "onRefreshEvent(Lcom/bytedance/android/livesdk/ktvimpl/ktvroom/previewsongs/KtvPreviewSongsViewModel$RefreshPreviewCard;)V", 0);
    }

    public final void invoke(KtvPreviewSongsViewModel.b r30) {
        Intrinsics.checkNotNullParameter(r30, "p1");
        KtvPreviewSongsWidget r2 = (KtvPreviewSongsWidget) ((CallableReference) this).receiver;
        int r3 = KtvPreviewSongsWidget.k;
        r2.getClass();
        ALogger.d(KtvPreviewSongsViewModel.TAG, "onRefreshEvent: " + r30);
        if (((Boolean) r2.g.getNeedDelayToShow().getValue()).booleanValue() == true) goto L84;
        RecyclerView.ViewHolder r6 = null;
        if ((r30 instanceof KtvPreviewSongsViewModel.b.a) == false) goto L59;
        StringBuilder r4 = new StringBuilder("new round isContentViewNeedShown:isContentViewNeedShown, list size:");
        KtvPreviewSongsViewModel.b.a r0 = (KtvPreviewSongsViewModel.b.a) r30;
        r4.append(r0.a.size());
        ALogger.d(KtvPreviewSongsViewModel.TAG, r4.toString());
        List<MusicPanel> r5 = r0.a;
        r2.e = r5;
        KtvPreviewSongsAdapter r7 = r2.c;
        if (r7 == null) goto L10;
        r7.y2(CollectionsKt.take(r5, r2.d));
    L10:
        List<MusicPanel> r1 = r0.a;
        o r8 = m.i();
        if (r8 == null) goto L85;
        Intrinsics.checkNotNullParameter(r8, "$this$liveTypeStr");
        com.bytedance.live.datacontext.m r9 = r8.getRoom();
        if (r9 == null) goto L18;
        IRoom r10 = (IRoom) r9.getValue();
        if (r10 == null) goto L18;
        String r11 = j.f(r10);
    L19:
        String r26 = j.a(null);
        String r12 = j.h(r8);
        u r13 = m.d();
        Intrinsics.checkNotNullParameter(r13, "$this$functionTypeStr");
        com.bytedance.live.datacontext.j r14 = r13.s();
        char r15 = 1;
        if (r14 == null) goto L26;
        f r16 = (f) r14.getValue();
        if (r16 == null) goto L26;
        if (g.b(r16) != true) goto L26;
        String r17 = "ktv";
    L27:
        String r27 = r17;
        Iterator<MusicPanel> r18 = r1.iterator();
    L29:
        if (r18.hasNext() == false) goto L87;
        MusicPanel r19 = r18.next();
        KtvLoggerHelper r20 = KtvLoggerHelper.d;
        String r110 = r19.d;
        long r111 = r19.a.getMId();
        String r21 = r19.a.getMTitle();
        if (r21 != null) goto L33;
        String r112 = "";
    L34:
        long r113 = r19.a.getMId();
        Pair[] r22 = new Pair[4];
        r22[0] = TuplesKt.to("song_type", com.bytedance.android.live.ktv.common.util.a.b(r19.a));
        r22[r15] = TuplesKt.to("artist_id", r19.b());
        String r114 = r19.a.getMAuthor();
        if (r114 != null) goto L37;
        r114 = "";
    L37:
        r22[2] = TuplesKt.to("artist_name", r114);
        List r115 = r19.a.getTags();
        if (r115 != null) goto L40;
    L42:
        String r116 = BDLocationException.ERROR_TIMEOUT;
    L43:
        r22[3] = TuplesKt.to("is_original_flag", r116);
        HashMap r117 = MapsKt.hashMapOf(r22);
        KtvMusic r23 = r19.a;
        if (r23 == null) goto L52;
        String r24 = r23.getMidiUrl();
        if (r24 == null) goto L52;
        if (r24.length() <= 0) goto L50;
        boolean r25 = true;
    L51:
        Boolean r28 = Boolean.valueOf(r25);
    L53:
        String r29 = r19.a.getMAuthor();
        if (r29 != null) goto L56;
        String r210 = "";
    L57:
        r20.h0(r19, r11, r26, r110, r111, r27, r12, r112, r113, r117, null, null, null, null, r28, r210);
        r15 = 1;
        goto L29
    L56:
        r210 = r29;
        goto L57
    L50:
        r25 = false;
    L52:
        r28 = null;
        goto L53
    L40:
        if (r115.contains("原唱") != r15) goto L42;
        r116 = "1";
        goto L43
    L33:
        r112 = r21;
        goto L34
    L87:
        return;
    L26:
        r17 = j.a(null);
    L18:
        r11 = "";
        goto L19
    L85:
        return;
    L59:
        if ((r30 instanceof KtvPreviewSongsViewModel.b.c) == false) goto L72;
        RecyclerView r31 = r2.b;
        if (r31 == null) goto L63;
        RecyclerView.ViewHolder r32 = r31.findViewHolderForAdapterPosition(0);
    L65:
        if ((r32 instanceof KtvPreviewSongsViewHolder) == false) goto L68;
        r6 = r32;
    L68:
        KtvPreviewSongsViewHolder r33 = (KtvPreviewSongsViewHolder) r6;
        if (r33 == null) goto L81;
        ((KtvPreviewSongsViewModel.b.c) r30).getClass();
        r33.U3(false);
        return;
    L81:
        return;
    L63:
        r32 = null;
        goto L65
    L72:
        if ((r30 instanceof KtvPreviewSongsViewModel.b.C0027b) == true) goto L74;
        return;
    L74:
        if (((Boolean) r2.g.getShowPreviewCard().getValue()).booleanValue() == false) goto L86;
        ScaleAnimation r34 = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        r34.setDuration(667);
        AlphaAnimation r35 = new AlphaAnimation(1.0f, 0.0f);
        r35.setDuration(217);
        AnimationSet r36 = new AnimationSet(false);
        r36.addAnimation(r34);
        r36.addAnimation(r35);
        r36.setAnimationListener(new a(r2));
        ((Widget) r2).contentView.startAnimation(r36);
        return;
    L86:
        return;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1) {
        invoke((KtvPreviewSongsViewModel.b) r1);
        return Unit.INSTANCE;
    }
}
