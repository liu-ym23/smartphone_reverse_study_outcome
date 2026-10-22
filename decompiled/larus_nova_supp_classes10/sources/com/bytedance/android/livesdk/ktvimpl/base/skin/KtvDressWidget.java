package com.bytedance.android.livesdk.ktvimpl.base.skin;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.tetris.widgets.LiveRecyclableWidget;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.model.api.h0;
import com.bytedance.android.live.ktv.common.model.api.x0;
import com.bytedance.android.livesdk.chatroom.ui.SSGridLayoutManager;
import com.bytedance.android.livesdk.chatroom.ui.SSLinearLayoutManager;
import com.bytedance.android.livesdk.ktvimpl.base.KtvContext;
import com.bytedance.android.livesdk.ktvimpl.base.skin.viewHolder.KtvHonorTagViewBinder;
import com.bytedance.android.livesdk.ktvimpl.base.skin.viewHolder.KtvMidiSkinViewBinder;
import com.bytedance.android.livesdkapi.depend.message.GetDressPageListMode;
import com.bytedance.android.livesdkapi.depend.message.KTVDressType;
import com.bytedance.android.livesdkapi.depend.message.MidiSkinDressPageItem;
import com.bytedance.android.livesdkapi.depend.message.TagDressPageItem;
import com.bytedance.ies.sdk.widgets.Widget;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import me.drakeet.multitype.MultiTypeAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/skin/KtvDressWidget;", "Lcom/bytedance/android/live/core/tetris/widgets/LiveRecyclableWidget;", "", "a", "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvDressWidget extends LiveRecyclableWidget {
    public RecyclerView a;
    public final MultiTypeAdapter b;
    public TextView c;
    public View d;
    public View e;
    public TextView f;
    public ImageView g;
    public int h;
    public View i;
    public RecyclerView j;
    public final MultiTypeAdapter k;
    public TextView l;
    public View m;
    public TextView n;
    public ImageView o;
    public int p;
    public final yd2.a q;
    public final com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r;

    public static final class a {
    }

    public static final class b<T> implements Observer {
        public final /* synthetic */ KtvDressWidget a;

        public b(KtvDressWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            KtvDressWidget r0 = this.a;
            r0.wq((x0) r3, r0.h);
        }
    }

    public static final class c<T> implements Observer {
        public final /* synthetic */ KtvDressWidget a;

        public c(KtvDressWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            KtvDressWidget r0 = this.a;
            r0.xq((h0) r3, r0.p);
        }
    }

    public static final class d<T> implements Observer {
        public final /* synthetic */ KtvDressWidget a;

        public d(KtvDressWidget r1) {
            this.a = r1;
        }

        public final void onChanged(Object r3) {
            Pair r4 = (Pair) r3;
            if (r4 != null) goto L6;
            return;
        L6:
            if (((Number) r4.getFirst()).intValue() != KTVDressType.KTV_DRESS_TYPE_TAG.getValue()) goto L9;
            this.a.b.notifyDataSetChanged();
            return;
        L9:
            if (((Number) r4.getFirst()).intValue() != KTVDressType.KTV_DRESS_TYPE_MIDI_SKIN.getValue()) goto L13;
            this.a.k.notifyDataSetChanged();
            return;
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131566493;
    }

    public final void onUnload() {
        ALogger.i("KtvDressWidget", "onUnload");
    }

    public KtvDressWidget(com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r2) {
        this.r = r2;
        this.b = new MultiTypeAdapter();
        GetDressPageListMode r3 = GetDressPageListMode.LIST_MODE_PREVIEW;
        this.h = r3.getValue();
        this.k = new MultiTypeAdapter();
        this.p = r3.getValue();
        this.q = new yd2.a();
    }

    public final void onInit(Object[] r2) {
        ALogger.i("KtvDressWidget", "onInit");
        if (((Widget) this).containerView == null) goto L19;
        this.a = findViewById(2131377029);
        this.c = (TextView) findViewById(2131377016);
        this.d = findViewById(2131377028);
        this.e = findViewById(2131377025);
        this.f = (TextView) findViewById(2131377027);
        this.g = (ImageView) findViewById(2131377026);
        View r3 = this.d;
        if (r3 == null) goto L7;
        r3.setOnClickListener(new com.bytedance.android.livesdk.ktvimpl.base.skin.a(this));
    L7:
        View r4 = this.e;
        if (r4 == null) goto L10;
        r4.setOnClickListener(new com.bytedance.android.livesdk.ktvimpl.base.skin.b(this));
    L10:
        KtvContext.Companion.getClass();
        if (KtvContext.a.k() == false) goto L20;
        View r5 = findViewById(2131377017);
        this.i = r5;
        if (r5 == null) goto L15;
        r5.setVisibility(0);
    L15:
        this.j = findViewById(2131377022);
        this.l = (TextView) findViewById(2131377018);
        this.m = findViewById(2131377019);
        this.n = (TextView) findViewById(2131377021);
        this.o = (ImageView) findViewById(2131377020);
        View r6 = this.m;
        if (r6 == null) goto L21;
        r6.setOnClickListener(new com.bytedance.android.livesdk.ktvimpl.base.skin.c(this));
        return;
    L21:
        return;
    L20:
        return;
    }

    public final void onLoad(Object[] r6) {
        ALogger.i("KtvDressWidget", "onLoad");
        RecyclerView r7 = this.a;
        if (r7 == null) goto L5;
        r7.setLayoutManager(new SSLinearLayoutManager(((Widget) this).context, 0));
    L5:
        this.b.z2(KtvHonorTagViewBinder.a.class, new KtvHonorTagViewBinder(this.r, this.q));
        RecyclerView r8 = this.a;
        if (r8 == null) goto L8;
        r8.setAdapter(this.b);
    L8:
        RecyclerView r9 = this.j;
        if (r9 == null) goto L11;
        r9.setLayoutManager(new SSLinearLayoutManager(((Widget) this).context, 0));
    L11:
        this.k.z2(KtvMidiSkinViewBinder.a.class, new KtvMidiSkinViewBinder(this.r, this.q));
        RecyclerView r10 = this.j;
        if (r10 == null) goto L14;
        r10.setAdapter(this.k);
    L14:
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r11 = this.r;
        if (r11 == null) goto L17;
        r11.observeHonorTagList(this, new b(this));
    L17:
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r12 = this.r;
        h0 r0 = null;
        if (r12 == null) goto L20;
        x0 r13 = r12.obtainHonorTagList();
    L21:
        GetDressPageListMode r1 = GetDressPageListMode.LIST_MODE_PREVIEW;
        wq(r13, r1.getValue());
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r14 = this.r;
        if (r14 == null) goto L24;
        r14.observeMidiSkinList(this, new c(this));
    L24:
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r15 = this.r;
        if (r15 == null) goto L27;
        r0 = r15.obtainMidiSkinList();
    L27:
        xq(r0, r1.getValue());
        com.bytedance.android.livesdk.ktvimpl.base.skin.viewmodel.a r16 = this.r;
        if (r16 == null) goto L31;
        r16.observeKtvDressChangedState(this, new d(this));
        return;
    L31:
        return;
    L20:
        r13 = null;
        goto L21
    }

    public final void wq(x0 r7, int r8) {
        StringBuilder r0 = new StringBuilder("handleHonorTagChangeList， tag size: ");
        if (r7 == null) goto L7;
        List r1 = r7.b();
        if (r1 == null) goto L7;
        Integer r2 = Integer.valueOf(r1.size());
    L8:
        r0.append(r2);
        ALogger.i("KtvDressWidget", r0.toString());
        int r3 = 0;
        if (r7 == null) goto L61;
        List r4 = r7.b();
        if (r4 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == true) goto L61;
        RecyclerView r6 = this.a;
        if (r6 != null) goto L22;
    L26:
        TextView r9 = this.c;
        if (r9 == null) goto L29;
        r9.setVisibility(8);
    L29:
        View r10 = this.e;
        if (r10 == null) goto L40;
        List r11 = r7.b();
        if (r11 == null) goto L34;
        int r12 = r11.size();
    L35:
        if (r12 >= 4) goto L38;
        r3 = 8;
    L38:
        r10.setVisibility(r3);
        goto L40
    L34:
        r12 = 0;
    L40:
        if (r8 != GetDressPageListMode.LIST_MODE_FULL.getValue()) goto L47;
        TextView r13 = this.f;
        if (r13 == null) goto L44;
        r13.setText(s1.B(2131918377));
    L44:
        ImageView r14 = this.g;
        if (r14 == null) goto L53;
        r14.setImageResource(2131252065);
    L53:
        this.h = r8;
        ArrayList r15 = new ArrayList();
        List r16 = r7.b();
        if (r16 == null) goto L59;
        Iterator r17 = r16.iterator();
    L57:
        if (r17.hasNext() == false) goto L59;
        TagDressPageItem r18 = (TagDressPageItem) r17.next();
        r15.add(new KtvHonorTagViewBinder.a(r7.a(), r18, r8));
    L59:
        MultiTypeAdapter r19 = this.b;
        r19.a = r15;
        r19.notifyDataSetChanged();
        return;
    L47:
        TextView r20 = this.f;
        if (r20 == null) goto L50;
        r20.setText(s1.B(2131918378));
    L50:
        ImageView r21 = this.g;
        if (r21 == null) goto L53;
        r21.setImageResource(2131252064);
        goto L53
    L22:
        if (r8 != GetDressPageListMode.LIST_MODE_FULL.getValue()) goto L24;
        SSGridLayoutManager r22 = new SSGridLayoutManager(((Widget) this).context, 4, 1);
    L25:
        r6.setLayoutManager(r22);
        goto L26
    L24:
        r22 = new SSLinearLayoutManager(((Widget) this).context, 0);
        goto L25
    L13:
        if (r4.isEmpty() == true) goto L16;
        r5 = false;
    L61:
        TextView r23 = this.c;
        if (r23 == null) goto L66;
        r23.setVisibility(0);
        return;
    L66:
        return;
    L7:
        r2 = null;
        goto L8
    }

    public final void xq(h0 r7, int r8) {
        StringBuilder r0 = new StringBuilder("handleMidiSkinChangeList， midiSkinList size: ");
        if (r7 == null) goto L7;
        List r1 = r7.a();
        if (r1 == null) goto L7;
        Integer r2 = Integer.valueOf(r1.size());
    L8:
        r0.append(r2);
        ALogger.i("KtvDressWidget", r0.toString());
        int r3 = 0;
        if (r7 == null) goto L61;
        List r4 = r7.a();
        if (r4 != null) goto L13;
    L16:
        boolean r5 = true;
    L17:
        if (r5 == true) goto L61;
        RecyclerView r6 = this.j;
        if (r6 != null) goto L22;
    L26:
        TextView r9 = this.l;
        if (r9 == null) goto L29;
        r9.setVisibility(8);
    L29:
        View r10 = this.m;
        if (r10 == null) goto L40;
        List r11 = r7.a();
        if (r11 == null) goto L34;
        int r12 = r11.size();
    L35:
        if (r12 >= 2) goto L38;
        r3 = 8;
    L38:
        r10.setVisibility(r3);
        goto L40
    L34:
        r12 = 0;
    L40:
        if (r8 != GetDressPageListMode.LIST_MODE_FULL.getValue()) goto L47;
        TextView r13 = this.n;
        if (r13 == null) goto L44;
        r13.setText(s1.B(2131918377));
    L44:
        ImageView r14 = this.o;
        if (r14 == null) goto L53;
        r14.setImageResource(2131252065);
    L53:
        this.p = r8;
        ArrayList r15 = new ArrayList();
        List r16 = r7.a();
        if (r16 == null) goto L59;
        Iterator r17 = r16.iterator();
    L57:
        if (r17.hasNext() == false) goto L59;
        r15.add(new KtvMidiSkinViewBinder.a((MidiSkinDressPageItem) r17.next(), r8));
    L59:
        MultiTypeAdapter r18 = this.k;
        r18.a = r15;
        r18.notifyDataSetChanged();
        return;
    L47:
        TextView r19 = this.n;
        if (r19 == null) goto L50;
        r19.setText(s1.B(2131918378));
    L50:
        ImageView r20 = this.o;
        if (r20 == null) goto L53;
        r20.setImageResource(2131252064);
        goto L53
    L22:
        if (r8 != GetDressPageListMode.LIST_MODE_FULL.getValue()) goto L24;
        SSGridLayoutManager r21 = new SSGridLayoutManager(((Widget) this).context, 2, 1);
    L25:
        r6.setLayoutManager(r21);
        goto L26
    L24:
        r21 = new SSLinearLayoutManager(((Widget) this).context, 0);
        goto L25
    L13:
        if (r4.isEmpty() == true) goto L16;
        r5 = false;
    L61:
        TextView r22 = this.l;
        if (r22 == null) goto L66;
        r22.setVisibility(0);
        return;
    L66:
        return;
    L7:
        r2 = null;
        goto L8
    }
}
