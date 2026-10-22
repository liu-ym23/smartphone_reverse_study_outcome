package i62;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.live.base.model.user.User;
import com.bytedance.android.live.base.model.user.q0;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.user.IUserService;
import com.bytedance.android.livesdk.interactivity.api.chatchannel.utils.o;
import com.bytedance.android.livesdk.interactivity.chatchannel.messagelist.viewholder.ChatChannelGiftViewHolder;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.r;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.w;
import com.bytedance.android.livesdk.interactivity.service.textrender.core.x;
import com.bytedance.android.livesdkapi.message.CommonMessageData;
import com.bytedance.android.livesdkapi.message.Text;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import java.util.Iterator;
import jc1.k;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements com.bytedance.android.livesdk.interactivity.service.messagelist.c, View.OnClickListener, View.OnLongClickListener, wb2.d.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final yb2.a f488391i = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f488392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final tb2.d f488393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageModel f488394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f488395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f488396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f488397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f488398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final com.bytedance.android.livesdk.interactivity.api.chatchannel.message.h f488399h;

    public static final class a {
    }

    public static final class b extends me.drakeet.multitype.b<e, ChatChannelGiftViewHolder> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final g52.e f488400b;

        public b(g52.e r100) {
            Intrinsics.checkNotNullParameter(r100, "config");
            this.f488400b = r100;
        }

        @Override // me.drakeet.multitype.b
        public final void b(RecyclerView.ViewHolder r100, e r101) {
            ChatChannelGiftViewHolder r102 = (ChatChannelGiftViewHolder) r100;
            e r103 = r101;
            Intrinsics.checkNotNullParameter(r102, "holder");
            Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
            r102.getClass();
            Intrinsics.checkNotNullParameter(r103, MapController.ITEM_LAYER_TAG);
            r102.f134335c = r103;
            r102.f134336d = r103;
            r102.f134334b.setOnLongClickListener(r103);
            r102.f134334b.setPadding(s1.f(6.0f), s1.f(5.0f), s1.f(6.0f), s1.f(5.0f));
            UtilityKotlinExtentionsKt.w(r102.f134333a);
            ImageLoader.bindImage(r102.f134333a, r103.f488394c);
            TextView r104 = r102.f134334b;
            qb2.c.b(r103.f488393b, new k62.d(r102, r104), null, 28);
            r102.f134334b.setBackground(s1.m(R.drawable.ttlive_chat_channel_item_chat_bg));
        }

        @Override // me.drakeet.multitype.b
        public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
            Intrinsics.checkNotNullParameter(r100, "inflater");
            Intrinsics.checkNotNullParameter(r101, "parent");
            ChatChannelGiftViewHolder r102 = new ChatChannelGiftViewHolder(r100.inflate(R.layout.ttlive_item_room_channel_gift_message, r101, false));
            g52.e r103 = this.f488400b;
            Intrinsics.checkNotNullParameter(r103, "textConfig");
            r102.f134334b.setTextSize(0, r103.f480021a);
            return r102;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean c() {
        return false;
    }

    @Override // wb2.d.a
    public final boolean d(View r100, wb2.d r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        Intrinsics.checkNotNullParameter(r101, "span");
        return false;
    }

    static {
        yb2.a r100 = w.a();
        r100.f567065d = ColorProtector.parseColor("#FACE15");
        r100.f567062a = ColorProtector.parseColor("#b2FFFFFF");
        f488391i = r100;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean a() {
        return this.f488398g;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean b() {
        return this.f488396e;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final long getId() {
        return this.f488395d;
    }

    @Override // com.bytedance.android.livesdk.interactivity.service.messagelist.c
    public final boolean isFromFirstRequest() {
        return this.f488397f;
    }

    public e(com.bytedance.android.livesdk.interactivity.api.chatchannel.message.h r100) {
        Intrinsics.checkNotNullParameter(r100, "message");
        this.f488399h = r100;
        User r101 = r100.getUser();
        if (r101 == null) goto L6;
        String r102 = r101.getIdString();
        if (r102 == null) goto L6;
    L7:
        String r103 = null;
        if (q0.a(r102) == false) goto L18;
        IUserService r104 = (IUserService) k.f(IUserService.class);
        if (r104 == null) goto L14;
        com.bytedance.android.livesdk.user.f r105 = r104.user();
        if (r105 == null) goto L14;
        String r106 = r105.n();
    L16:
        if (Intrinsics.areEqual(r102, r106) == false) goto L18;
        boolean r107 = true;
    L19:
        this.f488392a = r107;
        User r108 = r100.getUser();
        if (r108 == null) goto L22;
        ImageModel r109 = r108.getAvatarThumb();
    L24:
        if ((r109 instanceof ImageModel) == true) goto L26;
        r109 = null;
    L26:
        this.f488394c = r109;
        this.f488395d = r100.getMessageId();
        this.f488396e = r107;
        r100.getReceiveTime();
        this.f488397f = r100.isFromFirstRequest();
        this.f488398g = !r100.isFirstRequest;
        CommonMessageData r110 = r100.baseMessage;
        if (r110 == null) goto L29;
        Text r111 = r110.getDisplayText();
    L30:
        User r112 = r100.getUser();
        Text r113 = r100.G();
        if (r111 == null) goto L37;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.f141015a.getClass();
        x r114 = r.f141030b;
        yb2.a r115 = f488391i;
        Intrinsics.checkNotNullParameter(r111, "text");
        tb2.d r116 = r.a(r111, r115);
        r116.f545244c = null;
        Iterator<T> r117 = r116.f545242a.iterator();
    L34:
        if (r117.hasNext() == false) goto L36;
        ((tb2.c) r117.next()).setFormat(null);
        goto L34
    L36:
        Unit r118 = Unit.INSTANCE;
        r116.f545243b = f488391i;
    L48:
        this.f488393b = r116;
        return;
    L37:
        if (r112 == null) goto L47;
        if (r113 == null) goto L47;
        com.bytedance.android.livesdk.interactivity.service.textrender.core.f.f141015a.getClass();
        x r119 = r.f141030b;
        yb2.a r120 = f488391i;
        Intrinsics.checkNotNullParameter(r113, "text");
        tb2.d r121 = r.a(r113, r120);
        r121.f545244c = null;
        Iterator<T> r122 = r121.f545242a.iterator();
    L41:
        if (r122.hasNext() == false) goto L43;
        ((tb2.c) r122.next()).setFormat(null);
        goto L41
    L43:
        Unit r123 = Unit.INSTANCE;
        tb2.d r124 = new tb2.d();
        r124.f545243b = f488391i;
        if (this.f488392a == false) goto L46;
        r103 = "我";
    L46:
        r124.c(com.bytedance.android.livesdk.interactivity.service.textrender.utils.c.h(r112, r103, true, false));
        r124.b(r121.f545242a);
        r116 = r124;
    L47:
        r116 = new tb2.d();
        goto L48
    L29:
        r111 = null;
        goto L30
    L22:
        r109 = null;
    L14:
        r106 = null;
    L18:
        r107 = false;
    L6:
        r102 = "0";
        goto L7
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        User r101 = this.f488399h.getUser();
        if (r101 != null) goto L5;
        return;
    L5:
        e62.d.d(r101);
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r100) {
        User r101 = this.f488399h.getUser();
        if (r101 != null) goto L6;
        return false;
    L6:
        int r102 = e62.d.f471125a;
        e62.d.c(r101, this.f488399h.getMessageId(), o.a(this.f488399h));
        return true;
    }
}
