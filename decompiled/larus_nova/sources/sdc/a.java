package sdc;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.larksuite.component.ui.button.LKUICheckBox;
import com.larus.nova.R;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.utils.ImageUtils;
import com.ss.android.lark.utils.rxjava.RxScheduledExecutor;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.vfs.VFSFiles;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.ss.android.lark.widget.photopicker.s;
import com.ss.android.lark.widget.photopickerimpl.model.i;
import com.ss.android.lark.widget.photopickernew.PhotoInsertToInputView;
import com.ss.android.lark.widget.photopickernew.PhotoPickerFrameFragment2;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledExecutorService;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import rdc.g;
import rdc.j;
import rdc.k;
import rdc.l;
import rdc.t;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements ldc.f<t, com.ss.android.lark.widget.photopickerimpl.view.large.a.b<t>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f541495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f541496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f541497c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rdc.d f541498d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final rdc.c f541499e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final rdc.a f541500f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public com.ss.android.lark.widget.photopickerimpl.view.large.a.b<t> f541501g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public RelativeLayout f541502h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public LKUICheckBox f541503i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f541504j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public TextView f541505k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f541506l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public TextView f541507m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public PhotoInsertToInputView f541508n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public View f541509o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public View f541510p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f541511q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public boolean f541512r;

    /* JADX INFO: renamed from: sdc.a$a, reason: collision with other inner class name */
    public static final class C7598a {
    }

    public interface b {
    }

    public static final class c implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f541513a;

        public c(a r100) {
            this.f541513a = r100;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r100, boolean r101) {
            b r102 = this.f541513a.f541497c;
            boolean r103 = r100.isPressed();
            g r104 = (g) r102;
            PhotoPickerFrameFragment2.W90(r104.f537355c, r104.f537353a, r101, r103);
        }
    }

    public static final class d extends OnSingleClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f541514a;

        public d(a r100) {
            this.f541514a = r100;
        }

        @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
        public final void onSingleClick(View r100) {
            if (((ArrayList) ((g) this.f541514a.f541497c).f537353a.a()).isEmpty() == false) goto L9;
            a r101 = this.f541514a;
            com.ss.android.lark.widget.photopickerimpl.view.large.a.b<t> r102 = r101.f541501g;
            if (r102 == null) goto L9;
            t r103 = (t) r102.a();
            if (r103 == null) goto L9;
            rdc.d r104 = r101.f541498d;
            j r105 = (j) r104;
            r105.b(r103, r103.a());
            String r106 = "preview-unselect";
        L10:
            ((k) this.f541514a.f541499e).a(r106);
            return;
        L9:
            r106 = "preview-select";
            goto L10
        }
    }

    public static final class e extends OnSingleClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f541515a;

        public e(a r100) {
            this.f541515a = r100;
        }

        @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
        public final void onSingleClick(View r100) {
            a r101 = this.f541515a;
            rdc.a r102 = r101.f541500f;
            l r103 = (l) r102;
            r103.a(a.e(r101));
        }
    }

    public static final class f extends OnSingleClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f541516a;

        public f(a r100) {
            this.f541516a = r100;
        }

        @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
        public final void onSingleClick(View r100) {
            a r101 = this.f541516a;
            rdc.a r102 = r101.f541500f;
            l r103 = (l) r102;
            r103.a(a.e(r101));
        }
    }

    static {
    }

    @Override // ldc.f
    public final void c(Map<Integer, com.ss.android.lark.widget.photopickerimpl.bean.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "dirInfos");
    }

    @Override // ldc.f
    public final void onStop() {
    }

    @Override // ldc.f
    public final void onResume() {
        LKUICheckBox r100 = this.f541503i;
        if (r100 == null) goto L6;
        r100.setChecked(((g) this.f541497c).f537353a.f537382d);
        return;
    }

    public static final String e(a r100) {
        if ((!((ArrayList) ((g) r100.f541497c).f537353a.a()).isEmpty()) == true) goto L10;
        com.ss.android.lark.widget.photopickerimpl.view.large.a.b<t> r101 = r100.f541501g;
        if (r101 == null) goto L10;
        t r102 = (t) r101.a();
        if (r102 == null) goto L10;
        ((j) r100.f541498d).b(r102, r102.a());
        return "preview-unselect";
    L10:
        return "preview-select";
    }

    @Override // ldc.f
    public final void a(t r100) {
        t r101 = r100;
        Intrinsics.checkNotNullParameter(r101, "data");
        RelativeLayout r102 = this.f541502h;
        int r103 = 4;
        boolean r104 = false;
        if (r102 != null) goto L5;
    L9:
        LKUICheckBox r105 = this.f541503i;
        if (r105 == null) goto L13;
        r105.setChecked(((g) this.f541497c).f537353a.f537382d);
    L13:
        if (r101.a() == true) goto L15;
    L17:
        int r106 = 0;
    L18:
        String r107 = r101.f447737b;
        if (r107 != null) goto L21;
    L27:
        TextView r108 = this.f541505k;
        if (r108 == null) goto L30;
        r108.setVisibility(r106);
    L30:
        TextView r109 = this.f541505k;
        if (r109 == null) goto L33;
        r109.setOnClickListener(new sdc.b(r101, this));
    L33:
        int r110 = ((ArrayList) ((g) this.f541497c).f537353a.a()).size();
        TextView r111 = this.f541504j;
        if (r111 == null) goto L36;
        r111.setVisibility(0);
    L36:
        TextView r112 = this.f541504j;
        if (r112 == null) goto L39;
        r112.setEnabled(!r101.f537389n);
    L39:
        View r113 = this.f541506l;
        if (r113 == null) goto L42;
        r113.setEnabled(!r101.f537389n);
    L42:
        TextView r114 = this.f541507m;
        if (r114 == null) goto L46;
        r114.setEnabled(!r101.f537389n);
    L46:
        if (this.f541511q == false) goto L49;
        if (r110 <= 0) goto L49;
        r104 = true;
    L49:
        PhotoInsertToInputView r115 = this.f541508n;
        if (r115 == null) goto L52;
        r115.a(r104, this.f541512r);
    L52:
        this.f541512r = true;
        PhotoInsertToInputView r116 = this.f541508n;
        if (r116 == null) goto L55;
        r116.setEnabled(!r101.f537389n);
    L55:
        if (r110 <= 0) goto L59;
        TextView r117 = this.f541504j;
        if (r117 == null) goto L63;
        r117.setText(this.f541496b + '(' + r110 + ')');
        return;
    L63:
        return;
    L59:
        TextView r118 = this.f541504j;
        if (r118 == null) goto L65;
        r118.setText(this.f541496b);
        return;
    L65:
        return;
    L21:
        if (r101.a() == false) goto L23;
    L25:
        r103 = r106;
    L26:
        r106 = r103;
        goto L27
    L23:
        if (ImageUtils.e(VFSFiles.f444819b.i(r107)) == false) goto L25;
    L15:
        if (com.ss.android.lark.widget.photopicker.f.a().i() == true) goto L17;
        r106 = 4;
        goto L18
    L5:
        if (((g) this.f541497c).f537355c.f447877f.f447568m == true) goto L7;
        int r119 = 4;
    L8:
        r102.setVisibility(r119);
        goto L9
    L7:
        r119 = 0;
        goto L8
    }

    @Override // ldc.f
    public final View b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.photo_picker_new_large_bottom_tool, r100, false);
        this.f541502h = (RelativeLayout) r101.findViewById(R.id.origin_zone);
        this.f541503i = (LKUICheckBox) r101.findViewById(R.id.cb_original_photo);
        this.f541504j = (TextView) r101.findViewById(R.id.btn_photo_send);
        this.f541505k = (TextView) r101.findViewById(R.id.btn_photo_edit);
        this.f541506l = r101.findViewById(R.id.layout_photo_insert_message);
        this.f541507m = (TextView) r101.findViewById(R.id.btn_photo_insert_message);
        this.f541508n = (PhotoInsertToInputView) r101.findViewById(R.id.layout_photo_insert_message_new);
        this.f541509o = r101.findViewById(R.id.layout_photo_insert_spacer);
        this.f541510p = r101.findViewById(R.id.layout_photo_send);
        s r102 = ((g) this.f541497c).f537355c.f447877f;
        boolean r103 = r102.A;
        if (r103 == true) goto L5;
    L7:
        boolean r104 = false;
    L8:
        this.f541511q = r104;
        r101.setTag(R.id.layout_photo_insert_message_new, Boolean.valueOf(r104));
        this.f541512r = false;
        View r105 = this.f541506l;
        if (r105 == null) goto L16;
        if (r103 == true) goto L12;
    L14:
        int r106 = 8;
    L15:
        r105.setVisibility(r106);
        goto L16
    L12:
        if (this.f541511q == true) goto L14;
        r106 = 0;
    L16:
        PhotoInsertToInputView r107 = this.f541508n;
        if (r107 == null) goto L19;
        r107.a(false, false);
    L19:
        if (r103 == true) goto L21;
    L45:
        LKUICheckBox r108 = this.f541503i;
        if (r108 == null) goto L48;
        r108.setOnCheckedChangeListener(new c(this));
    L48:
        TextView r109 = this.f541504j;
        if (r109 == null) goto L51;
        r109.setOnClickListener(new d(this));
    L51:
        View r110 = this.f541506l;
        if (r110 == null) goto L54;
        r110.setOnClickListener(new e(this));
    L54:
        PhotoInsertToInputView r111 = this.f541508n;
        if (r111 == null) goto L57;
        r111.setOnInsertClickListener(new f(this));
    L57:
        Intrinsics.checkNotNull(r101);
        return r101;
    L21:
        if (this.f541511q == true) goto L45;
        View r112 = this.f541509o;
        LinearLayout.LayoutParams r113 = null;
        if (r112 == null) goto L25;
        ViewGroup.LayoutParams r114 = r112.getLayoutParams();
    L27:
        if ((r114 instanceof LinearLayout.LayoutParams) == false) goto L29;
        LinearLayout.LayoutParams r115 = (LinearLayout.LayoutParams) r114;
    L30:
        if (r115 == null) goto L34;
        r115.width = 0;
        r115.weight = 1.0f;
        View r116 = this.f541509o;
        if (r116 == null) goto L34;
        r116.setLayoutParams(r115);
    L34:
        View r117 = this.f541510p;
        if (r117 == null) goto L37;
        ViewGroup.LayoutParams r118 = r117.getLayoutParams();
    L39:
        if ((r118 instanceof LinearLayout.LayoutParams) == false) goto L41;
        r113 = (LinearLayout.LayoutParams) r118;
    L41:
        if (r113 == null) goto L45;
        r113.width = -2;
        r113.weight = 0.0f;
        View r119 = this.f541510p;
        if (r119 == null) goto L45;
        r119.setLayoutParams(r113);
        goto L45
    L37:
        r118 = null;
        goto L39
    L29:
        r115 = null;
        goto L30
    L25:
        r114 = null;
        goto L27
    L5:
        if (r102.B == false) goto L7;
        r104 = true;
        goto L8
    }

    @Override // ldc.f
    public final void d(com.ss.android.lark.widget.photopickerimpl.view.large.a.b<t> r100) {
        com.ss.android.lark.widget.photopickerimpl.view.large.a.b<t> r101 = r100;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f541501g = r101;
    }

    @Override // ldc.f
    public final boolean onActivityResult(int r110, int r111, Intent r112) {
        Intrinsics.checkNotNullParameter(r112, "data");
        if (r110 != 2) goto L5;
        if (r111 != (-1)) goto L5;
    L6:
        String r113 = r112.getStringExtra("key_result_path_decrypt");
        if (r113 != null) goto L9;
        r113 = r112.getStringExtra("key_result_path");
    L9:
        int r100 = r112.getIntExtra("key_editor_width", -1);
        int r101 = r112.getIntExtra("key_editor_height", -1);
        long r102 = r112.getLongExtra("key_result_duration", 0);
        com.ss.android.lark.widget.photopickerimpl.view.large.a.b<t> r114 = this.f541501g;
        if (r114 == null) goto L17;
        t r115 = (t) r114.a();
        if (r115 == null) goto L17;
        Integer r116 = r115.f447736a;
        if (r116 == null) goto L17;
        String r117 = r116.toString();
        if (r117 == null) goto L17;
    L18:
        if (r111 != 20001) goto L20;
        String r118 = ", duration=" + r102;
    L21:
        Log.i("PP_LargeBottomToolPlugin", "onActivityResult: id=" + r117 + ", path=" + r113 + r118);
        b r119 = this.f541497c;
        if (r113 != null) goto L24;
        r113 = "";
    L24:
        g r120 = (g) r119;
        rdc.s r103 = r120.f537353a;
        r103.getClass();
        Intrinsics.checkNotNullParameter(r117, "id");
        Intrinsics.checkNotNullParameter(r113, "editPath");
        ((ConcurrentHashMap) r103.f537384f).put(r117, r113);
        if (r100 == (-1)) goto L29;
        if (r101 == (-1)) goto L29;
        rdc.s r121 = r120.f537353a;
        r121.getClass();
        Intrinsics.checkNotNullParameter(r117, "id");
        ((ConcurrentHashMap) r121.f537385g).put(r117, new Pair(Integer.valueOf(r100), Integer.valueOf(r101)));
    L29:
        if (r102 <= 0) goto L31;
        rdc.s r122 = r120.f537353a;
        r122.getClass();
        Intrinsics.checkNotNullParameter(r117, "id");
        ((ConcurrentHashMap) r122.f537386h).put(r117, Integer.valueOf((int) r102));
    L31:
        com.ss.android.lark.widget.photopickerimpl.model.c r123 = r120.f537354b;
        r123.getClass();
        i r124 = new i(r123);
        com.ss.android.lark.widget.photopickerimpl.model.j r125 = new com.ss.android.lark.widget.photopickerimpl.model.j(r123);
        RxScheduledExecutor.Consumer r104 = com.ss.android.lark.widget.photopickerimpl.model.k.f447817a;
        ScheduledExecutorService r105 = com.ss.android.lark.widget.photopickerimpl.model.c.f447781m;
        if (r105 == null) goto L38;
        r105.execute(new com.ss.android.lark.widget.photopickerimpl.model.d(r124, r123, r125, r104));
        return true;
    L38:
        return true;
    L20:
        r118 = "";
    L17:
        r117 = "";
    L5:
        if (r111 == 20001) goto L6;
        return false;
    }

    public a(Context r100, String r101, g r102, j r103, k r104, l r105) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "actionTxt");
        Intrinsics.checkNotNullParameter(r102, "support");
        Intrinsics.checkNotNullParameter(r103, "selectedChangedListener");
        Intrinsics.checkNotNullParameter(r104, "sendListener");
        Intrinsics.checkNotNullParameter(r105, "insertListener");
        this.f541495a = r100;
        this.f541496b = r101;
        this.f541497c = r102;
        this.f541498d = r103;
        this.f541499e = r104;
        this.f541500f = r105;
    }
}
