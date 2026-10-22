package com.larus.dora.o.impl.album;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.dora.api.IDoraService;
import com.larus.dora.o.impl.databinding.DoraOViewAlbumCardBinding;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.oui.button.OButtonLink;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import t39.n;
import w88.i;

/* JADX INFO: loaded from: classes27.dex */
public final class ODoraAlbumCardView extends FrameLayout {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final /* synthetic */ int f338312m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LifecycleOwner f338313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function0<Unit> f338314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<Unit> f338315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final DoraOViewAlbumCardBinding f338316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<b> f338317e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f338318f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public i f338319g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f338320h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.larus.dora.o.impl.album.a f338321i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final d f338322j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ODoraAlbumCardView$lifecycleObserver$1 f338323k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final c f338324l;

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FrameLayout f338325a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final SimpleDraweeView f338326b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final TextView f338327c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final View f338328d;

        public b(FrameLayout r100, SimpleDraweeView r101, TextView r102, View r103) {
            Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
            Intrinsics.checkNotNullParameter(r101, "imageView");
            Intrinsics.checkNotNullParameter(r102, "durationView");
            Intrinsics.checkNotNullParameter(r103, "progressMask");
            this.f338325a = r100;
            this.f338326b = r101;
            this.f338327c = r102;
            this.f338328d = r103;
        }
    }

    public static final class c implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ODoraAlbumCardView f338329a;

        public c(ODoraAlbumCardView r100) {
            this.f338329a = r100;
        }

        @Override // t39.n
        public final void e(int r100, int r101, String r102, String r103) {
            Intrinsics.checkNotNullParameter(r102, "productName");
            if (r100 != 2) goto L6;
            final ODoraAlbumCardView r104 = this.f338329a;
            r104.post(new f(r104));
            return;
        }
    }

    public static final class d implements w88.f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ODoraAlbumCardView f338330a;

        @Override // w88.f
        public final void a() {
            ODoraAlbumCardView r100 = this.f338330a;
            r100.removeCallbacks(r100.f338321i);
            ODoraAlbumCardView r101 = this.f338330a;
            r101.postDelayed(r101.f338321i, 300);
        }

        public d(ODoraAlbumCardView r100) {
            this.f338330a = r100;
        }
    }

    static {
    }

    public final void d() {
        Intent r100 = new Intent("gallery3d.intent.appintent.albumcommon");
        r100.setPackage("com.android.gallery3d");
        r100.putExtra("app_intent_param_album_key", "dorag");
        r100.putExtra("finish_host_activity_on_exit", true);
        r100.addCategory("android.intent.category.DEFAULT");
        getContext().startActivity(r100);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        FLogger.f375446a.e("ODoraAlbumCardView", "openSystemAlbum failed: " + e.getMessage());
    }

    public final void e() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f338313a), null, null, new ODoraAlbumCardView$refresh$1(this, null), 3, null);
    }

    public static String c(i r100) {
        if ((r100 instanceof i.c) == false) goto L6;
        return "Idle";
    L6:
        if ((r100 instanceof i.e) == false) goto L9;
        return "WifiConnecting";
    L9:
        if ((r100 instanceof i.d) == false) goto L12;
        return "Transferring(progress=" + ((i.d) r100).f558680a + ')';
    L12:
        if ((r100 instanceof i.a) == false) goto L15;
        return "Completed";
    L15:
        if ((r100 instanceof i.b) == false) goto L19;
        return "Error(message=" + ((i.b) r100).f558678a + ')';
    L19:
        throw new NoWhenBranchMatchedException();
    }

    public final int a(int r100) {
        Resources r101 = getResources();
        return (int) ((WindowDisplayMetricsOverride.apply(r101, r101.getDisplayMetrics()).density * r100) + 0.5f);
    }

    public final i b(i r100) {
        if ((r100 instanceof i.c) == false) goto L15;
        IDoraAVLinkService r101 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r101 == null) goto L9;
        boolean r102 = true;
        if (r101.R0() != true) goto L9;
    L11:
        if (this.f338320h == true) goto L13;
        if (r102 == true) goto L13;
        return r100;
    L13:
        FLogger.f375446a.i("ODoraAlbumCardView", "getDisplaySyncState fallback Idle -> Transferring, hasInProgressPreview=" + this.f338320h + ", isMediaTransferOrProcessing=" + r102);
        return new i.d(0);
    L9:
        r102 = false;
        goto L11
    L15:
        return r100;
    }

    public final void f(i r100) {
        DoraOViewAlbumCardBinding r101 = this.f338316d;
        LinearLayout r102 = r101.f338430h;
        ProgressBar r103 = r101.f338429g;
        ImageView r104 = r101.f338428f;
        TextView r105 = r101.f338431i;
        TextView r106 = r101.f338427e;
        if ((r100 instanceof i.c) == false) goto L9;
        if (this.f338318f <= 0) goto L7;
        r102.setVisibility(0);
        r103.setVisibility(8);
        r104.setVisibility(8);
        r105.setText(getContext().getString(R.string.larus_dora_o_album_pending_sync, new Object[]{Integer.valueOf(this.f338318f)}));
        r106.setVisibility(0);
        return;
    L7:
        r102.setVisibility(8);
        return;
    L9:
        if ((r100 instanceof i.e) == false) goto L12;
        r102.setVisibility(0);
        r103.setVisibility(0);
        r104.setVisibility(8);
        r105.setText(getContext().getString(R.string.larus_dora_o_album_wifi_connecting));
        r106.setVisibility(8);
        return;
    L12:
        if ((r100 instanceof i.d) == false) goto L15;
        r102.setVisibility(0);
        r103.setVisibility(0);
        r104.setVisibility(8);
        r105.setText(getContext().getString(R.string.larus_dora_album_trans_ing));
        r106.setVisibility(8);
        return;
    L15:
        if ((r100 instanceof i.a) == false) goto L18;
        r102.setVisibility(0);
        r103.setVisibility(8);
        r104.setVisibility(0);
        r104.setImageResource(R.drawable.dora_o_ic_checkmark_circle);
        r105.setText(getContext().getString(R.string.larus_dora_album_trans_complete));
        r106.setVisibility(8);
        return;
    L18:
        if ((r100 instanceof i.b) == false) goto L59;
        r102.setVisibility(0);
        r103.setVisibility(8);
        r104.setVisibility(0);
        r104.setImageResource(R.drawable.dora_o_ic_exclamation_mark_circle);
        String r107 = ((i.b) r100).f558678a;
        if (r107 != null) goto L22;
    L55:
        int r108 = R.string.larus_dora_o_album_transfer_error;
    L56:
        r105.setText(getContext().getString(r108));
        r106.setVisibility(8);
        return;
    L22:
        switch(r107.hashCode()) {
            case -1704747215: goto L52;
            case -1584470938: goto L48;
            case -687751078: goto L45;
            case 252770929: goto L41;
            case 473727070: goto L37;
            case 993558001: goto L33;
            case 993676552: goto L29;
            case 1670563574: goto L25;
            default: goto L55;
        };
    L25:
        if (r107.equals("vpn_enabled") == false) goto L55;
        r108 = R.string.larus_dora_album_close_vpn_cn;
        goto L56
    L29:
        if (r107.equals("no_space") == false) goto L55;
        r108 = R.string.larus_dora_album_no_space;
        goto L56
    L33:
        if (r107.equals("recording") == false) goto L55;
        r108 = R.string.larus_dora_g_record_sync_forbidden_cn;
        goto L56
    L37:
        if (r107.equals("wifi_error") == false) goto L55;
        r108 = R.string.larus_dora_album_connection_lost_cn;
        goto L56
    L41:
        if (r107.equals("gps_disabled") == false) goto L55;
        r108 = R.string.larus_dora_album_gps_off;
        goto L56
    L45:
        if (r107.equals("low_power") == false) goto L55;
        r108 = R.string.larus_dora_album_lowpower_cn;
        goto L56
    L48:
        if (r107.equals("wifi_disabled") == false) goto L55;
        r108 = R.string.larus_dora_album_enable_wifi_cn;
        goto L56
    L52:
        if (r107.equals("ap_enabled") == false) goto L55;
        r108 = R.string.larus_dora_album_close_ap_cn;
        goto L56
    L59:
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Type inference failed for: r11v10, types: [com.larus.dora.o.impl.album.ODoraAlbumCardView$lifecycleObserver$1] */
    /* JADX WARN: Type inference failed for: r11v8, types: [com.larus.dora.o.impl.album.a] */
    public ODoraAlbumCardView(Context r110, LifecycleOwner r111, Function0<Unit> r112, Function0<Unit> r113) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r111, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r112, "onAlbumEntryClick");
        Intrinsics.checkNotNullParameter(r113, "onSyncRequiresConnection");
        super(r110);
        this.f338313a = r111;
        this.f338314b = r112;
        this.f338315c = r113;
        View r114 = LayoutInflater.from(r110).inflate(R.layout.dora_o_view_album_card, this, false);
        addView(r114);
        int r115 = R.id.album_empty;
        TextView r100 = (TextView) ViewBindings.findChildViewById(r114, R.id.album_empty);
        if (r100 == null) goto L38;
        r115 = R.id.album_images_row;
        LinearLayout r116 = (LinearLayout) ViewBindings.findChildViewById(r114, R.id.album_images_row);
        if (r116 == null) goto L38;
        r115 = R.id.album_title;
        if (((TextView) ViewBindings.findChildViewById(r114, R.id.album_title)) == null) goto L38;
        r115 = R.id.album_view_all;
        OButtonLink r101 = (OButtonLink) ViewBindings.findChildViewById(r114, R.id.album_view_all);
        if (r101 == null) goto L38;
        r115 = R.id.sync_action_btn;
        TextView r102 = (TextView) ViewBindings.findChildViewById(r114, R.id.sync_action_btn);
        if (r102 == null) goto L38;
        r115 = R.id.sync_status_icon;
        ImageView r103 = (ImageView) ViewBindings.findChildViewById(r114, R.id.sync_status_icon);
        if (r103 == null) goto L38;
        r115 = R.id.sync_status_loading;
        ProgressBar r104 = (ProgressBar) ViewBindings.findChildViewById(r114, R.id.sync_status_loading);
        if (r104 == null) goto L38;
        r115 = R.id.sync_status_row;
        LinearLayout r105 = (LinearLayout) ViewBindings.findChildViewById(r114, R.id.sync_status_row);
        if (r105 == null) goto L38;
        r115 = R.id.sync_status_text;
        TextView r106 = (TextView) ViewBindings.findChildViewById(r114, R.id.sync_status_text);
        if (r106 == null) goto L38;
        this.f338316d = new DoraOViewAlbumCardBinding((LinearLayout) r114, r100, r116, r101, r102, r103, r104, r105, r106);
        this.f338317e = new ArrayList();
        this.f338319g = i.c.f558679a;
        this.f338321i = new com.larus.dora.o.impl.album.a(this);
        this.f338322j = new d(this);
        this.f338323k = new ODoraAlbumCardView$lifecycleObserver$1(this);
        this.f338324l = new c(this);
        int r117 = 0;
    L22:
        if (r117 >= 5) goto L30;
        FrameLayout r118 = new FrameLayout(getContext());
        SimpleDraweeView r107 = new SimpleDraweeView(getContext());
        GenericDraweeHierarchy r108 = r107.getHierarchy();
        if (r108 == null) goto L26;
        r108.setRoundingParams(RoundingParams.fromCornersRadius(a(8)));
    L26:
        r118.addView(r107, new FrameLayout.LayoutParams(-1, -1));
        TextView r109 = new TextView(getContext());
        r109.setTextColor(ContextCompat.getColor(r109.getContext(), R.color.dora_o_day_selected_text));
        r109.setTextSize(10.0f);
        r109.setVisibility(8);
        FrameLayout.LayoutParams r119 = new FrameLayout.LayoutParams(-2, -2);
        r119.gravity = VideoPlayDataContext.PLAYING_GRAVITY;
        r119.rightMargin = a(4);
        r119.bottomMargin = a(4);
        Unit r120 = Unit.INSTANCE;
        r118.addView(r109, r119);
        View r121 = new View(getContext());
        r121.setBackgroundResource(R.drawable.dora_o_bg_album_progress_mask);
        r121.setVisibility(8);
        r118.addView(r121, new FrameLayout.LayoutParams(-1, -1));
        LinearLayout.LayoutParams r122 = new LinearLayout.LayoutParams(0, a(55), 1.0f);
        if (r117 <= 0) goto L29;
        r122.setMarginStart(a(6));
    L29:
        r116.addView(r118, r122);
        ((ArrayList) this.f338317e).add(new b(r118, r107, r109, r121));
        r117 = r117 + 1;
        goto L22
    L30:
        this.f338316d.f338423a.setOnClickListener(new com.larus.dora.o.impl.album.b(this));
        this.f338316d.f338426d.setOnTouchListener(new com.larus.dora.o.impl.album.c(this));
        this.f338316d.f338427e.setOnClickListener(new com.larus.dora.o.impl.album.d(this));
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f338313a), null, null, new ODoraAlbumCardView$observeSyncState$1(this, null), 3, null);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this.f338313a), null, null, new ODoraAlbumCardView$observeAlbumCountChange$1(this, null), 3, null);
        this.f338313a.getLifecycle().addObserver(this.f338323k);
        IDoraService r123 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r123 == null) goto L33;
        r123.G(this.f338324l);
    L33:
        IDoraAVLinkService r124 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r124 == null) goto L42;
        r124.q1(this.f338322j);
        return;
    L42:
        return;
    L38:
        throw new NullPointerException("Missing required view with ID: ".concat(r114.getResources().getResourceName(r115)));
    }
}
