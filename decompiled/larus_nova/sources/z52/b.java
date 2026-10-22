package z52;

import am2.x;
import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;
import androidx.core.view.GravityCompat;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.matchroom.MatchRoomLandScapeAnimUtil;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSetting;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.bytedance.android.livesdk.interactivity.api.q;
import com.bytedance.android.livesdk.interactivity.common.InterceptLinearLayout;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.x8;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.common.utility.UIUtils;
import com.larus.nova.R;
import com.lynx.canvas.KryptonCamera;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.disposables.Disposable;
import java.util.HashMap;
import java.util.Map;
import r52.h0;

/* JADX INFO: loaded from: classes9.dex */
public final class b extends Dialog implements com.bytedance.android.live.matchroom.b, n22.c {
    public static final /* synthetic */ int K = 0;
    public BarrageSetting A;
    public boolean B;
    public final float C;
    public final float D;
    public final float E;
    public final int F;
    public final float G;
    public Disposable H;
    public boolean I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final a f570059J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f570060a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f570061b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public RadioGroup f570062c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public RadioGroup f570063d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public RadioButton f570064e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public RadioButton f570065f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public RadioButton f570066g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RadioButton f570067h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public RadioButton f570068i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public RadioButton f570069j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public RadioButton f570070k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public TextView f570071l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f570072m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public TextView f570073n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public TextView f570074o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public TextView f570075p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public TextView f570076q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public Button f570077r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public SeekBar f570078s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public ToggleButton f570079t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public ToggleButton f570080u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public InterceptLinearLayout f570081v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public View f570082w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f570083x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public BarrageSetting f570084y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public BarrageSettingArea f570085z;

    public class a implements SeekBar.OnSeekBarChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f570086a;

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStartTrackingTouch(SeekBar r100) {
        }

        public a(b r100) {
            this.f570086a = r100;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onStopTrackingTouch(SeekBar r100) {
            b r101 = this.f570086a;
            r101.e(r101.f570084y);
            xs2.b.a().post(new q22.b(this.f570086a.f570084y));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public final void onProgressChanged(SeekBar r100, int r101, boolean r102) {
            TextView r103 = this.f570086a.f570076q;
            StringBuilder r104 = new StringBuilder();
            b r105 = this.f570086a;
            float r106 = r101;
            r104.append((int) ((((r105.F - 20) / r105.G) * r106) + 20.0f));
            r104.append(GXTemplateKey.GAIAX_PE);
            r103.setText(r104.toString());
            b r107 = this.f570086a;
            r107.f570084y.setAlpha((((r107.F - 20) / r107.G) * r106) + 20.0f);
        }
    }

    /* JADX INFO: renamed from: z52.b$b, reason: collision with other inner class name */
    public class ViewOnClickListenerC8417b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ b f570087a;

        public ViewOnClickListenerC8417b(b r100) {
            this.f570087a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            b r101 = this.f570087a;
            Handler r102 = DialogLancet.resolveDialogHandler(r101);
            if (r102 != null) goto L5;
        L7:
            DialogLancet.beforeDialogDismiss(r101);
            r101.dismiss();     // Catch: Throwable -> L10 Exception -> L12
        L16:
            DialogLancet.afterDialogDismiss(r101);
            return;
        L10:
            th = move-exception;
            DialogLancet.afterDialogDismiss(r101);
            throw th;
        L12:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L10
            Throwable r103 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L10
            if (r103 == null) goto L16;
            com.bytedance.crash.d.d(r103, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L10
            goto L16
        L5:
            if (Looper.myLooper() == r102.getLooper()) goto L7;
            r102.post(DialogLancet.createDismissRunnable(r101));
        }
    }

    public static /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f570088a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f570089b = null;

        static {
            int[] r100 = new int[BarrageSettingFont.values().length];
            f570089b = r100;
            r100[BarrageSettingFont.SMALL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L14
        L23:
            f570089b[BarrageSettingFont.MID.ordinal()] = 2;     // Catch: NoSuchFieldError -> L15
        L27:
            f570089b[BarrageSettingFont.BIG.ordinal()] = 3;     // Catch: NoSuchFieldError -> L16
        L8:
            int[] r101 = new int[BarrageSettingArea.values().length];
            f570088a = r101;
            r101[BarrageSettingArea.CLOSE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L33:
            f570088a[BarrageSettingArea.TOP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L21:
            f570088a[BarrageSettingArea.HALF.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L25:
            f570088a[BarrageSettingArea.FULL.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
            return;
        }
    }

    public final void b() {
        if (this.I == false) goto L5;
        return;
    L5:
        int r100 = 0;
        this.f570081v.setIsIntercept(false);
        this.f570072m.setAlpha(this.E);
        this.f570073n.setAlpha(this.E);
        this.f570074o.setAlpha(this.E);
        this.f570075p.setAlpha(this.E);
        this.f570076q.setAlpha(this.E);
        this.f570078s.setAlpha(this.E);
        this.f570062c.setEnabled(true);
        this.f570079t.setAlpha(this.E);
        this.f570080u.setAlpha(this.E);
    L7:
        if (r100 >= this.f570062c.getChildCount()) goto L9;
        this.f570062c.getChildAt(r100).setEnabled(true);
        r100 = r100 + 1;
        goto L7
    }

    @Override // android.app.Dialog, android.content.DialogInterface, n22.c
    public final void dismiss() {
        MatchRoomLandScapeAnimUtil.E.j("LandscapeBarrageSettingDialog");
        com.bytedance.android.livesdk.f.d().f();
        Disposable r100 = this.H;
        if (r100 == null) goto L5;
        r100.dispose();
    L5:
        Handler r101 = DialogLancet.resolveDialogHandler(this);
        if (r101 != null) goto L8;
    L10:
        DialogLancet.beforeDialogDismiss(this);
        super.dismiss();     // Catch: Throwable -> L13 Exception -> L15
    L19:
        DialogLancet.afterDialogDismiss(this);
        return;
    L13:
        th = move-exception;
        DialogLancet.afterDialogDismiss(this);
        throw th;
    L15:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r102 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r102 == null) goto L19;
        com.bytedance.crash.d.d(r102, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
        goto L19
    L8:
        if (Looper.myLooper() == r101.getLooper()) goto L10;
        r101.post(DialogLancet.createDismissRunnable(this));
    }

    @Override // com.bytedance.android.live.matchroom.b
    public final int getActualContentWidth() {
        return s1.f(248.0f);
    }

    @Override // android.app.Dialog
    public final void onStop() {
        if (this.f570084y.getBarrageArea() == this.A.getBarrageArea()) goto L5;
    L14:
        this.B = true;
    L15:
        BarrageSetting r100 = this.f570084y;
        j0.l().sendLog("livesdk_landscape_barrage_settings_change", c(r100), new Object[]{new x(), IRoom.class});
        e(this.f570084y);
        super.onStop();
        return;
    L5:
        if (this.f570084y.getFontSize() != this.A.getFontSize()) goto L14;
        if (this.f570084y.getAlpha() != this.A.getAlpha()) goto L14;
        if (this.f570084y.isGiftOpen() != this.A.isGiftOpen()) goto L14;
        if (this.f570084y.isNeedRollback() != this.A.isNeedRollback()) goto L14;
        this.B = false;
        goto L15
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L26;
        DialogLancet.handleBlockedDialogShow(this);
    L7:
        BarrageSetting r100 = l42.a.f507317d.getValue();
        this.f570084y = r100;
        if (r100 != null) goto L10;
    L13:
        BarrageSetting r101 = new BarrageSetting();
        r101.setBarrageArea(BarrageSettingArea.HALF);
        r101.setFontSize(BarrageSettingFont.MID);
        r101.setAlpha(75.0f);
        r101.setGiftOpen(true);
        r101.setChatChannelOpen(true);
        this.f570084y = r101;
    L14:
        BarrageSetting r102 = this.f570084y;
        BarrageSetting r103 = new BarrageSetting();
        r103.setBarrageArea(r102.getBarrageArea());
        r103.setFontSize(r102.getFontSize());
        r103.setAlpha(r102.getAlpha());
        r103.setGiftOpen(r102.isGiftOpen());
        r103.setChatChannelOpen(r102.isChatChannelOpen());
        r103.setNeedRollback(r102.isNeedRollback());
        this.A = r103;
        if (l42.a.f507320g.getValue().booleanValue() == false) goto L18;
        this.f570085z = this.f570084y.getBarrageArea();
        this.f570084y.setBarrageArea(BarrageSettingArea.CLOSE);
    L20:
        com.bytedance.android.livesdk.interactivity.api.publicscreen.b r104 = q.b();
        if (r104 == null) goto L23;
        this.I = r104.isCarnivalStarted().getValue().booleanValue();
        this.H = r104.isCarnivalStarted().a().subscribe(new z52.a(this));
    L23:
        d(this.f570084y);
        this.f570077r.setOnClickListener(new z52.c(this));
        this.f570063d.setOnCheckedChangeListener(new d(this));
        this.f570062c.setOnCheckedChangeListener(new e(this));
        this.f570078s.setOnSeekBarChangeListener(this.f570059J);
        this.f570079t.setOnCheckedChangeListener(new f(this));
        this.f570080u.setOnCheckedChangeListener(new g(this));
        boolean r105 = MatchRoomLandScapeAnimUtil.f82832a;
        MatchRoomLandScapeAnimUtil.x("LandscapeBarrageSettingDialog", this, -1);
        com.bytedance.android.livesdk.f.d().a();
        BarrageSetting r106 = this.f570084y;
        j0.l().sendLog("livesdk_landscape_barrage_settings_panel_show", c(r106), new Object[]{x.class, IRoom.class});
        return;
    L18:
        if (this.f570084y.getBarrageArea().equals(BarrageSettingArea.CLOSE) == false) goto L20;
        this.f570084y.setBarrageArea(BarrageSettingArea.HALF);
        goto L20
    L10:
        if (r100.getBarrageArea() == null) goto L13;
        if (this.f570084y.getFontSize() != null) goto L14;
    L26:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L25
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L7
    }

    public b(Context r100) {
        super(r100, R.style.ttlive_barrage_setting_dialog);
        this.f570061b = 340;
        this.f570083x = h0.f536188a.getValue().booleanValue();
        this.B = false;
        this.C = 0.5f;
        this.D = 0.34f;
        this.E = 1.0f;
        this.F = 100;
        this.G = 100.0f;
        this.f570059J = new a(this);
    }

    public final void a(boolean r100) {
        if (r100 == false) goto L4;
        this.f570084y.setBarrageArea(BarrageSettingArea.CLOSE);
    L4:
        this.f570081v.setIsIntercept(true);
        this.f570062c.clearCheck();
        this.f570072m.setAlpha(this.D);
        this.f570073n.setAlpha(this.D);
        this.f570074o.setAlpha(this.D);
        this.f570075p.setAlpha(this.D);
        this.f570076q.setAlpha(this.D);
        this.f570078s.setAlpha(this.C);
        this.f570062c.setEnabled(false);
        this.f570079t.setAlpha(this.C);
        this.f570080u.setAlpha(this.C);
        int r101 = 0;
    L6:
        if (r101 >= this.f570062c.getChildCount()) goto L8;
        this.f570062c.getChildAt(r101).setEnabled(false);
        r101 = r101 + 1;
        goto L6
    }

    public final Map<String, String> c(BarrageSetting r100) {
        HashMap r101 = new HashMap();
        if (this.f570084y != null) goto L5;
        return r101;
    L5:
        int r102 = c.f570088a[r100.getBarrageArea().ordinal()];
        String r103 = "null";
        String r104 = "close";
        if (r102 == 1) goto L15;
        if (r102 == 2) goto L14;
        if (r102 != 3) goto L10;
        String r105 = "half";
    L16:
        r101.put("barrage_position", r105);
        int r106 = c.f570089b[r100.getFontSize().ordinal()];
        if (r106 == 1) goto L23;
        if (r106 == 2) goto L22;
        if (r106 != 3) goto L24;
        r103 = "large";
    L24:
        r101.put("barrage_size", r103);
        r101.put(GXTemplateKey.STYLE_OPACITY, r100.getAlpha() + "");
        if (r100.isGiftOpen() == false) goto L27;
        Object r107 = "open";
    L28:
        r101.put("gift_message", r107);
        if (this.B == false) goto L31;
        String r108 = "1";
    L32:
        r101.put("is_change", r108);
        if (this.f570083x == true) goto L35;
    L38:
        return r101;
    L35:
        if (r100.isLotteryOpen() == false) goto L37;
        r104 = "open";
    L37:
        r101.put("lottery_message", r104);
        goto L38
    L31:
        r108 = "0";
        goto L32
    L27:
        r107 = "close";
        goto L28
    L22:
        r103 = KryptonCamera.Config.RESOLUTION_MEDIUM;
        goto L24
    L23:
        r103 = "small";
        goto L24
    L10:
        if (r102 == 4) goto L12;
        r105 = "null";
        goto L16
    L12:
        r105 = "full_screen";
        goto L16
    L14:
        r105 = "top";
        goto L16
    L15:
        r105 = "close";
        goto L16
    }

    public final void d(BarrageSetting r100) {
        BarrageSettingArea r101 = r100.getBarrageArea();
        int r102 = c.f570088a[r101.ordinal()];
        boolean r103 = true;
        if (r102 == 1) goto L12;
        if (r102 == 2) goto L11;
        if (r102 != 3) goto L7;
        this.f570068i.setChecked(true);
    L13:
        int r104 = c.f570089b[r100.getFontSize().ordinal()];
        if (r104 == 1) goto L20;
        if (r104 == 2) goto L19;
        if (r104 != 3) goto L21;
        this.f570064e.setChecked(true);
    L21:
        float r105 = r100.getAlpha();
        this.f570078s.setProgress((int) ((r105 - 20.0f) / ((this.F - 20) / this.G)));
        this.f570076q.setText(((int) r105) + GXTemplateKey.GAIAX_PE);
        this.f570079t.setChecked(r100.isGiftOpen());
        ToggleButton r106 = this.f570080u;
        if (p61.a.a() == false) goto L24;
    L26:
        r103 = false;
    L27:
        r106.setChecked(r103);
        BarrageSettingArea r107 = BarrageSettingArea.CLOSE;
        if (r101.equals(r107) == false) goto L30;
    L33:
        a(r101.equals(r107));
    L34:
        xs2.b.a().post(new q22.b(r100));
        return;
    L30:
        if (this.I == true) goto L33;
        b();
        goto L34
    L24:
        if (r100.isLotteryOpen() == false) goto L26;
    L19:
        this.f570065f.setChecked(true);
        goto L21
    L20:
        this.f570066g.setChecked(true);
        goto L21
    L7:
        if (r102 != 4) goto L13;
        this.f570070k.setChecked(true);
        goto L13
    L11:
        this.f570069j.setChecked(true);
        goto L13
    L12:
        this.f570067h.setChecked(true);
        goto L13
    }

    public final void e(BarrageSetting r100) {
        if (r100.isNeedRollback() == false) goto L7;
        BarrageSettingArea r101 = this.f570085z;
        if (r101 == null) goto L7;
        r100.setBarrageArea(r101);
    L7:
        com.bytedance.android.livesdk.sharedpref.e<BarrageSetting> r102 = l42.a.f507317d;
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r100);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (this.f570083x == false) goto L5;
        ScrollView r101 = new ScrollView(getContext());
        r101.addView(LayoutInflater.from(getContext()).inflate(R.layout.ttlive_layout_barrage_setting_dialog, null));
        this.f570060a = r101;
    L7:
        if (Build.VERSION.SDK_INT <= 23) goto L9;
        this.f570060a.setBackgroundResource(R.drawable.ttlive_barrage_setting_bg);
    L10:
        setContentView(this.f570060a);
        getWindow().setLayout((int) UIUtils.dip2Px(getContext(), this.f570061b), -1);
        getWindow().setGravity(GravityCompat.END);
        this.f570062c = (RadioGroup) findViewById(R.id.live_font_radiobutton);
        this.f570063d = (RadioGroup) findViewById(R.id.live_area_radiobutton);
        this.f570077r = (Button) findViewById(R.id.live_barrage_setting_default);
        this.f570078s = (SeekBar) findViewById(R.id.live_barrage_alpha_seekbar);
        this.f570079t = (ToggleButton) findViewById(R.id.live_barrage_giftmessage);
        this.f570080u = (ToggleButton) findViewById(R.id.live_barrage_lottery);
        this.f570064e = (RadioButton) findViewById(R.id.live_barrage_font_big);
        this.f570065f = (RadioButton) findViewById(R.id.live_barrage_font_mid);
        this.f570066g = (RadioButton) findViewById(R.id.live_barrage_font_small);
        this.f570067h = (RadioButton) findViewById(R.id.live_barrage_setting_close);
        this.f570069j = (RadioButton) findViewById(R.id.live_barrage_setting_top);
        this.f570068i = (RadioButton) findViewById(R.id.live_barrage_setting_half);
        this.f570070k = (RadioButton) findViewById(R.id.live_barrage_setting_full);
        this.f570081v = (InterceptLinearLayout) findViewById(R.id.ttlive_half_panel);
        this.f570071l = (TextView) findViewById(R.id.ttlive_barrage_setting_blank_area);
        this.f570076q = (TextView) findViewById(R.id.live_barrage_alpha_seekbar_process);
        this.f570072m = (TextView) findViewById(R.id.ttlive_barrage_setting_fontsize_text);
        this.f570073n = (TextView) findViewById(R.id.ttlive_barrage_setting_alpha_text);
        this.f570074o = (TextView) findViewById(R.id.ttlive_barrage_setting_gift_text);
        this.f570075p = (TextView) findViewById(R.id.ttlive_barrage_setting_lottery_text);
        View r102 = findViewById(R.id.ttlive_barrage_setting_lottery);
        this.f570082w = r102;
        if (this.f570083x == true) goto L13;
        r102.setVisibility(8);
    L13:
        this.f570071l.setOnClickListener(new ViewOnClickListenerC8417b(this));
        x8.b(this);
        return;
    L9:
        this.f570060a.setBackgroundResource(R.drawable.ttlive_bg_more_many_icon_dialog_gradient);
        goto L10
    L5:
        this.f570060a = LayoutInflater.from(getContext()).inflate(R.layout.ttlive_layout_barrage_setting_dialog, null);
        goto L7
    }
}
