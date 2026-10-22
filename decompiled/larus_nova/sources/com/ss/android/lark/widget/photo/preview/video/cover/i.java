package com.ss.android.lark.widget.photo.preview.video.cover;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.transition.TransitionManager;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larksuite.component.universe_design.icon.UDIconUtils;
import com.larksuite.framework.callback.Entity.ErrorResult;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.appreciablelib.AppreciableKit;
import com.ss.android.lark.appreciablelib.Biz;
import com.ss.android.lark.appreciablelib.Event;
import com.ss.android.lark.appreciablelib.Scene;
import com.ss.android.lark.image.api.DataSource;
import com.ss.android.lark.image.api.IRequestCreator;
import com.ss.android.lark.image.api.Target;
import com.ss.android.lark.image.entity.EncryptImage;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.widget.photo.preview.callback.OperateListener;
import com.ss.android.lark.widget.photo.preview.video.online.f0;
import com.ss.android.lark.widget.photo.preview.video.online.h0;
import com.ss.android.lark.widget.photo.preview.video.online.k0;
import com.ss.android.lark.widget.photopicker.entity.PhotoItem;
import com.ss.android.lark.widget.photopicker.statistics.PerfPhotoViewMonitor;
import java.util.HashMap;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class i extends vcc.a {
    public final h A;
    public final b B;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final IRequestCreator f447190e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PhotoItem f447191f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public ViewGroup f447192g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View f447193h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public ImageView f447194i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public y0c.b.a f447195j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public View f447196k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public ImageView f447197l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public ImageView f447198m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f447199n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f447200o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f447201p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public SeekBar f447202q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public TextView f447203r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public int f447204s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public int f447205t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public String f447206u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f447207v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final OperateListener f447208w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final vcc.b f447209x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f447210y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final a f447211z;

    public class a extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f447212a;

        @Override // android.os.Handler
        public final void handleMessage(Message r100) {
            super.handleMessage(r100);
            if (r100.what != 101) goto L7;
            this.f447212a.w(false);
            return;
        }

        public a(i r100, Looper r101) {
            this.f447212a = r100;
            super(r101);
        }
    }

    public class b implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ i f447213a;

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r100) {
        }

        public b(i r100) {
            this.f447213a = r100;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r100) {
            if (((f0.d) this.f447213a.f447209x).f447350a.f447325f.e() == true) goto L5;
            this.f447213a.G(Integer.valueOf(r100.getProgress()));
            return;
        L5:
            i r101 = this.f447213a;
            int r102 = r100.getProgress();
            r101.f447207v = false;
            r101.f447205t = r102;
            r101.f447211z.removeCallbacks(r101.A);
            r101.f447211z.postDelayed(r101.A, 300);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
            if (r102 == false) goto L5;
            this.f447213a.I(r101, r100.getMax());
            return;
        }
    }

    public class c implements rkb.g {
        public c() {
        }

        @Override // rkb.g
        public final boolean onLoadFailed(Exception r100, Object r101, Target r102, boolean r103) {
            ErrorResult r104 = new ErrorResult(PerfPhotoViewMonitor.ErrorReason.PIC_LOAD_MEDIA_COVER_FAILED);
            if ((r101 instanceof EncryptImage) == false) goto L5;
            r104 = ((EncryptImage) r101).getErrorResult();
        L5:
            PerfPhotoViewMonitor.f447616a.getClass();
            PerfPhotoViewMonitor.c(r104);
            return false;
        }

        @Override // rkb.g
        public final boolean onResourceReady(Object r100, Object r101, Target r102, DataSource r103, boolean r104) {
            PerfPhotoViewMonitor.f447616a.getClass();
            PerfPhotoViewMonitor.d(2);
            PerfPhotoViewMonitor.c(null);
            return false;
        }
    }

    @Override // vcc.a, y0c.b
    public final void onDoubleTap(MotionEvent r100) {
    }

    @Override // vcc.a
    public final void t() {
    }

    @Override // vcc.a
    public final void z(k0 r100) {
    }

    public final void F() {
        String r100 = this.f447191f.getMiddlePicInfo().key;
        if (TextUtils.isEmpty(r100) == false) goto L6;
        r100 = this.f447191f.getOriginPicInfo().key;
    L6:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        r100 = this.f447191f.getImageKey();
    L8:
        if (r100 == null) goto L13;
        if (r100.isEmpty() == true) goto L13;
        Object r101 = new EncryptImage(r100);
    L18:
        this.f447190e.load(r101).error(R.drawable.__picker_ic_broken_image_black_48dp).listener(new c()).into(this.f447194i);
        return;
    L13:
        if (this.f447191f.getPaths().isEmpty() == false) goto L15;
    L17:
        r101 = "";
        goto L18
    L15:
        if (((String) ListProtector.get(this.f447191f.getPaths(), 0)).isEmpty() == true) goto L17;
        r101 = ListProtector.get(this.f447191f.getPaths(), 0);
        goto L18
    }

    public final void H() {
        I(0, this.f447202q.getMax());
        C(true);
        this.f447194i.setVisibility(0);
        v(true);
    }

    @Override // vcc.a
    public final Drawable r() {
        return this.f447194i.getDrawable();
    }

    @Override // vcc.a
    public final void s() {
        a r100 = this.f447211z;
        if (r100 == null) goto L5;
        r100.removeMessages(101);
    L5:
        a r101 = this.f447211z;
        if (r101 == null) goto L8;
        r101.removeCallbacks(this.A);
    L8:
        a0b.h.e();
    }

    @Override // v0c.o
    public final void g() {
        n();
        this.f447193h = this.f447192g.findViewById(R.id.play_label);
        this.f447194i = (ImageView) this.f447192g.findViewById(R.id.video_cover);
        this.f447196k = this.f447192g.findViewById(R.id.controller_top_layout);
        this.f447199n = this.f447192g.findViewById(R.id.ctrl_close);
        this.f447200o = this.f447192g.findViewById(R.id.controller_bottom_layout);
        this.f447201p = (TextView) this.f447192g.findViewById(R.id.current_play_time);
        this.f447203r = (TextView) this.f447192g.findViewById(R.id.video_duration);
        this.f447202q = (SeekBar) this.f447192g.findViewById(R.id.video_seek);
        ImageView r100 = (ImageView) this.f447192g.findViewById(R.id.video_menu);
        this.f447197l = r100;
        r100.setImageDrawable(UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_more_bold_outlined, this.f447192g.getContext().getResources().getColor(R.color.lkui_N00)));
        ImageView r101 = (ImageView) this.f447192g.findViewById(R.id.iv_view_chat_album_from_video);
        this.f447198m = r101;
        if (((f0.d) this.f447209x).f447350a.f447322c == true) goto L5;
    L7:
        r101.setVisibility(8);
    L8:
        C(true);
        PhotoItem r102 = this.f447191f;
        if (r102 != null) goto L11;
    L17:
        B(false, false);
        this.f447197l.setOnClickListener(new e(this));
        View.OnClickListener r103 = new f(this);
        this.f447193h.setOnClickListener(r103);
        this.f447199n.setOnClickListener(new g(this));
        this.f447202q.setOnSeekBarChangeListener(this.B);
        this.f447200o.setOnTouchListener(new k(this));
        this.f447198m.setOnClickListener(new j(this));
        F();
        return;
    L11:
        if (r102.isVideo() == false) goto L17;
        if (this.f447191f.getMediaExtra() == null) goto L17;
        int r104 = (int) this.f447191f.getMediaExtra().getDuration();
        if (r104 <= 0) goto L17;
        I(0, r104);
        goto L17
    L5:
        if (this.f447208w == null) goto L7;
        r101.setVisibility(0);
        this.f447198m.setImageDrawable(UDIconUtils.getIconDrawable(getContext(), R.drawable.ud_icon_photo_album_filled, this.f447192g.getContext().getResources().getColor(R.color.lkui_N00)));
        goto L8
    }

    @Override // vcc.a
    public final void C(boolean r100) {
        if (r100 == false) goto L4;
        this.f447193h.setVisibility(0);
        return;
    L4:
        this.f447193h.setVisibility(8);
    }

    @Override // vcc.a
    public final void D(boolean r100) {
        ImageView r101 = this.f447197l;
        if (r100 == false) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        return;
    L5:
        r102 = 8;
        goto L6
    }

    @Override // vcc.a
    public final void E(boolean r100) {
        this.f447194i.setVisibility(0);
        p();
        this.f447202q.setVisibility(4);
        this.f447203r.setVisibility(4);
        this.f447201p.setVisibility(4);
        if (r100 == false) goto L5;
        this.f447197l.setVisibility(8);
    L5:
        this.f447193h.setVisibility(8);
    }

    public final void G(Integer r100) {
        if (fdc.a.c(this.f447191f) == false) goto L6;
        Log.i("OnlineControllerCover", "playVideoIfNeed return as media was cleaned.");
        w(true);
        return;
    L6:
        vcc.b r101 = this.f447209x;
        int r102 = r100.intValue();
        ((f0.d) r101).f447350a.s(Integer.valueOf(r102));
        w(true);
    }

    @Override // v0c.b, v0c.o
    public final void d(int r100) {
        switch(r100) {
            case -66018: goto L6;
            case -66017: goto L5;
            default: goto L13;
        };
    L5:
        w(false);
        UIUtils.display(this.f447193h, false);
        return;
    L6:
        q(0);
        w(true);
        if (fdc.a.c(this.f447191f) == false) goto L9;
        Log.i("OnlineControllerCover", "showPlayLabelIfNeed return as media was cleaned.");
        return;
    L9:
        UIUtils.display(this.f447193h, true);
        return;
    }

    @Override // v0c.a
    public final View m(Context r100) {
        ViewGroup r101 = (ViewGroup) LayoutInflater.from(r100).inflate(R.layout.online_controller_cover_new, null);
        this.f447192g = r101;
        return r101;
    }

    @Override // vcc.a, y0c.b
    public final void onLongPress(MotionEvent r100) {
        y0c.b.a r101 = this.f447195j;
        if (r101 == null) goto L6;
        ((h0) r101).a();
        return;
    }

    @Override // vcc.a, y0c.b
    public final void onSingleTapUp(MotionEvent r100) {
        G(0);
    }

    @Override // vcc.a
    public final void v(boolean r100) {
        if (r100 == true) goto L5;
        this.f447193h.setVisibility(8);
        w(false);
        return;
    L5:
        if (this.f447210y == true) goto L7;
        this.f447193h.setVisibility(0);
    L7:
        w(true);
    }

    @Override // vcc.a
    public final void w(boolean r100) {
        if (this.f447191f.isOriginal() == false) goto L6;
        r100 = false;
    L6:
        if (r100 == false) goto L11;
        a r101 = this.f447211z;
        if (r101 == null) goto L10;
        r101.removeMessages(101);
    L10:
        this.f447211z.sendEmptyMessageDelayed(101, 5000);
    L15:
        if (r100 == false) goto L17;
        this.f447196k.setVisibility(0);
    L18:
        if (r100 == false) goto L20;
        this.f447200o.setVisibility(0);
    L21:
        if (r100 == false) goto L23;
        n();
        return;
    L23:
        j(-66016, null);
        return;
    L20:
        this.f447200o.setVisibility(8);
        goto L21
    L17:
        this.f447196k.setVisibility(8);
        goto L18
    L11:
        a r102 = this.f447211z;
        if (r102 == null) goto L15;
        r102.removeMessages(101);
        goto L15
    }

    @Override // vcc.a
    public final void x(int r100) {
        this.f447194i.setBackgroundColor(r100);
    }

    @Override // vcc.a
    public final void y(h0 r100) {
        this.f447195j = r100;
    }

    @Override // vcc.a
    public final void B(boolean r100, boolean r101) {
        UIUtils.display(this.f447196k, r100);
        UIUtils.display(this.f447200o, r100);
    }

    public final void I(int r100, int r101) {
        this.f447202q.setMax(r101);
        this.f447202q.setProgress(r100);
        this.f447202q.setSecondaryProgress((int) (((this.f447204s * 1.0f) / 100.0f) * r101));
        if (r100 <= 0) goto L5;
        r100 = r100 + 500;
    L5:
        this.f447201p.setText(com.larksuite.framework.utils.e.f(r100));
        if (r101 <= 0) goto L8;
        r101 = r101 + 500;
    L8:
        this.f447203r.setText(com.larksuite.framework.utils.e.f(r101));
    }

    @Override // v0c.b, v0c.o
    public final void a(int r110, Bundle r111) {
        switch(r110) {
            case -99031: goto L10;
            case -99016: goto L9;
            case -99015: goto L8;
            case -99014: goto L7;
            case -99010: goto L6;
            case -99004: goto L5;
            default: goto L23;
        };
    L5:
        this.f447191f.setLoadStatus(PhotoItem.LOAD_STATUS.SUCCESS);
        com.ss.android.lark.widget.photopicker.utils.b.f447647a.b(this.f447191f);
        boolean r112 = jdc.d.f498782a;
        Log.i("PerfVideoViewMonitor", "videoPlayLoadStart, isSeek: false");
        jdc.d.f498782a = false;
        jdc.d.f498784c = System.currentTimeMillis();
        this.f447206u = AppreciableKit.Companion.getInstance().start(Biz.Messenger, Scene.Chat, Event.video_play, "", true);
        goto L23
    L6:
        UIUtils.display(this.f447193h, false);
        goto L23
    L7:
        this.f447207v = true;
        w(true);
        goto L23
    L8:
        TransitionManager.beginDelayedTransition(this.f447192g);
        this.f447194i.setVisibility(8);
        TransitionManager.endTransitions(this.f447192g);
        this.f447207v = true;
        String r100 = this.f447206u;
        boolean r113 = jdc.d.f498782a;
        Intrinsics.checkNotNullParameter(r100, "key");
        Log.i("PerfVideoViewMonitor", "videoPlayLoadEnd, key: " + r100);
        AppreciableKit r101 = AppreciableKit.Companion.getInstance();
        HashMap r102 = new HashMap();
        r102.put("is_seek", Boolean.valueOf(jdc.d.f498782a));
        r102.put("has_video_cache", Boolean.valueOf(jdc.d.f498783b));
        AppreciableKit.end$default(r101, r100, null, null, null, r102, 14, null);
        goto L23
    L9:
        p();
        H();
        goto L23
    L10:
        int r114 = r111.getInt("int_data");
        if (r114 != 3) goto L13;
        boolean r103 = true;
    L14:
        this.f447210y = r103;
        if (r114 != 4) goto L20;
        this.f447193h.setSelected(true);
        if (fdc.a.c(this.f447191f) == false) goto L19;
        Log.i("OnlineControllerCover", "showPlayLabelIfNeed return as media was cleaned.");
        goto L23
    L19:
        UIUtils.display(this.f447193h, true);
        goto L23
    L20:
        if (r114 != 3) goto L23;
        C(false);
        goto L23
    L13:
        r103 = false;
    L23:
        if (this.f447210y == false) goto L25;
        n();
        return;
    L25:
        j(-66016, null);
    }

    @Override // v0c.b, v0c.o
    public final void h(int r100, Bundle r101) {
        Log.e("play video eventCode: " + r100);
        if (r100 == (-88019)) goto L5;
        p();
        H();
        F();
    L10:
        this.f447191f.setLoadStatus(PhotoItem.LOAD_STATUS.FAILED);
        com.ss.android.lark.widget.photopicker.utils.b.f447647a.b(this.f447191f);
        return;
    L5:
        String r102 = r101.getString("string_data");
        if (TextUtils.isEmpty(r102) == false) goto L8;
    L9:
        p();
        H();
        F();
        goto L10
    L8:
        if (r102.contains("HTTP/1.1 410 Gone") == true) goto L10;
        goto L9
    }

    @Override // com.ss.android.lark.player.player.o
    public final void e(int r100, int r101, int r102) {
        if (this.f447207v == true) goto L5;
        return;
    L5:
        this.f447204s = r102;
        I(r100, r101);
    }

    /* JADX WARN: Type inference failed for: r2v5, types: [com.ss.android.lark.widget.photo.preview.video.cover.h] */
    public i(FragmentActivity r100, IRequestCreator r101, PhotoItem r102, OperateListener r103, f0.d r104) {
        super(r100);
        this.f447205t = -1;
        this.f447207v = true;
        this.f447210y = false;
        this.f447211z = new a(this, Looper.getMainLooper());
        this.A = new h(this);
        this.B = new b(this);
        this.f447190e = r101;
        this.f447191f = r102;
        this.f447208w = r103;
        this.f447209x = r104;
    }
}
