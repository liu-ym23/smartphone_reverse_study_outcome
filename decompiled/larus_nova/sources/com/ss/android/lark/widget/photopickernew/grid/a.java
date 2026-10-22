package com.ss.android.lark.widget.photopickernew.grid;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.larksuite.component.ui.button.LKUICheckBox;
import com.larksuite.framework.utils.UIUtils;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import com.ss.android.lark.widget.photopicker.s;
import com.ss.android.lark.widget.photopickerimpl.view.grid.GridComponent;
import com.ss.android.lark.widget.photopickernew.PhotoInsertToInputView;
import com.ss.android.lark.widget.photopickernew.PhotoPickerFrameFragment2;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import rdc.k;
import rdc.l;
import rdc.t;

/* JADX INFO: loaded from: classes38.dex */
public final class a implements ldc.f<List<t>, GridComponent.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f447894a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final InterfaceC5425a f447895b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final rdc.c f447896c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final rdc.a f447897d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public ViewGroup f447898e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LKUICheckBox f447899f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public TextView f447900g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public TextView f447901h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public View f447902i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public TextView f447903j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public PhotoInsertToInputView f447904k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public View f447905l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public View f447906m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public View f447907n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f447908o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f447909p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public boolean f447910q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public GridComponent.b f447911r;

    /* JADX INFO: renamed from: com.ss.android.lark.widget.photopickernew.grid.a$a, reason: collision with other inner class name */
    public interface InterfaceC5425a {
    }

    public static final class b implements CompoundButton.OnCheckedChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f447912a;

        public b(a r100) {
            this.f447912a = r100;
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public final void onCheckedChanged(CompoundButton r100, boolean r101) {
            InterfaceC5425a r102 = this.f447912a.f447895b;
            boolean r103 = r100.isPressed();
            rdc.e r104 = (rdc.e) r102;
            PhotoPickerFrameFragment2.W90(r104.f537351b, r104.f537350a, r101, r103);
        }
    }

    public static final class c extends OnSingleClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f447913a;

        public c(a r100) {
            this.f447913a = r100;
        }

        @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
        public final void onSingleClick(View r100) {
            ((k) this.f447913a.f447896c).a("album");
        }
    }

    public static final class d extends OnSingleClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f447914a;

        public d(a r100) {
            this.f447914a = r100;
        }

        @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
        public final void onSingleClick(View r100) {
            ((l) this.f447914a.f447897d).a("album");
        }
    }

    public static final class e extends OnSingleClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f447915a;

        public e(a r100) {
            this.f447915a = r100;
        }

        @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
        public final void onSingleClick(View r100) {
            ((l) this.f447915a.f447897d).a("album");
        }
    }

    public static final class f extends OnSingleClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f447916a;

        public f(a r100) {
            this.f447916a = r100;
        }

        @Override // com.ss.android.lark.widget.listener.OnSingleClickListener
        public final void onSingleClick(View r100) {
            GridComponent.b r101 = this.f447916a.f447911r;
            if (r101 == null) goto L6;
            KClass<? extends odc.a<?>> r102 = Reflection.getOrCreateKotlinClass(com.ss.android.lark.widget.photopickerimpl.view.large.a.class);
            com.ss.android.lark.widget.photopickerimpl.bean.c r103 = new com.ss.android.lark.widget.photopickerimpl.bean.c();
            a r104 = this.f447916a;
            r103.b("isSelectMode", Boolean.TRUE);
            r103.b("showData", ((rdc.e) r104.f447895b).f537350a.a());
            Unit r105 = Unit.INSTANCE;
            r101.a(r102, r103);
            return;
        }
    }

    @Override // ldc.f
    public final void c(Map<Integer, com.ss.android.lark.widget.photopickerimpl.bean.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "dirInfos");
    }

    @Override // ldc.f
    public final boolean onActivityResult(int r100, int r101, Intent r102) {
        Intrinsics.checkNotNullParameter(r102, "data");
        return false;
    }

    @Override // ldc.f
    public final void onStop() {
    }

    @Override // ldc.f
    public final void onResume() {
        LKUICheckBox r100 = this.f447899f;
        if (r100 == null) goto L6;
        r100.setChecked(((rdc.e) this.f447895b).f537350a.f537382d);
        return;
    }

    @Override // ldc.f
    public final void a(List<t> r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        LKUICheckBox r101 = this.f447899f;
        if (r101 == null) goto L5;
        r101.setChecked(((rdc.e) this.f447895b).f537350a.f537382d);
    L5:
        int r102 = ((ArrayList) ((rdc.e) this.f447895b).f537350a.a()).size();
        if (r102 <= 0) goto L8;
        boolean r103 = true;
    L9:
        View r104 = this.f447902i;
        if (r104 == null) goto L12;
        r104.setEnabled(r103);
    L12:
        TextView r105 = this.f447903j;
        if (r105 == null) goto L16;
        r105.setEnabled(r103);
    L16:
        if (this.f447909p == false) goto L19;
        if (r103 == false) goto L19;
        boolean r106 = true;
    L20:
        PhotoInsertToInputView r107 = this.f447904k;
        if (r107 == null) goto L23;
        r107.a(r106, this.f447910q);
    L23:
        this.f447910q = true;
        PhotoInsertToInputView r108 = this.f447904k;
        if (r108 == null) goto L26;
        r108.setEnabled(r103);
    L26:
        TextView r109 = this.f447901h;
        if (r109 == null) goto L32;
        if (r102 <= 0) goto L30;
        int r110 = 0;
    L31:
        r109.setVisibility(r110);
        goto L32
    L30:
        r110 = 8;
    L32:
        TextView r111 = this.f447900g;
        if (r111 == null) goto L35;
        r111.setVisibility(0);
    L35:
        if (r102 <= 0) goto L48;
        TextView r112 = this.f447901h;
        if (r112 == null) goto L39;
        r112.setText(R.string.Lark_Legacy_ImagePreview);
    L39:
        TextView r113 = this.f447901h;
        if (r113 == null) goto L42;
        r113.setOnClickListener(new com.ss.android.lark.widget.photopickernew.grid.b(this));
    L42:
        TextView r114 = this.f447900g;
        if (r114 == null) goto L45;
        r114.setText(this.f447894a + '(' + r102 + ')');
    L45:
        TextView r115 = this.f447900g;
        if (r115 == null) goto L55;
        r115.setEnabled(true);
        return;
    L55:
        return;
    L48:
        TextView r116 = this.f447900g;
        if (r116 == null) goto L51;
        r116.setText(this.f447894a);
    L51:
        TextView r117 = this.f447900g;
        if (r117 == null) goto L57;
        r117.setEnabled(false);
        return;
    L57:
        return;
    L19:
        r106 = false;
        goto L20
    L8:
        r103 = false;
        goto L9
    }

    @Override // ldc.f
    public final View b(ViewGroup r100) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        View r101 = LayoutInflater.from(r100.getContext()).inflate(R.layout.photo_picker_new_grid_bottom_tool, r100, false);
        this.f447898e = (ViewGroup) r101.findViewById(R.id.origin_zone);
        this.f447899f = (LKUICheckBox) r101.findViewById(R.id.cb_original_photo);
        this.f447900g = (TextView) r101.findViewById(R.id.btn_photo_send);
        this.f447901h = (TextView) r101.findViewById(R.id.btn_photo_preview);
        this.f447902i = r101.findViewById(R.id.layout_photo_insert_message);
        this.f447903j = (TextView) r101.findViewById(R.id.btn_photo_insert_message);
        this.f447904k = (PhotoInsertToInputView) r101.findViewById(R.id.layout_photo_insert_message_new);
        this.f447905l = r101.findViewById(R.id.layout_photo_preview_spacer);
        this.f447906m = r101.findViewById(R.id.layout_photo_insert_spacer);
        this.f447907n = r101.findViewById(R.id.layout_photo_send);
        ViewGroup r102 = this.f447898e;
        if (r102 != null) goto L5;
    L9:
        s r103 = ((rdc.e) this.f447895b).f537351b.f447877f;
        boolean r104 = r103.A;
        this.f447908o = r104;
        if (r104 == true) goto L12;
    L14:
        boolean r105 = false;
    L15:
        this.f447909p = r105;
        r101.setTag(R.id.layout_photo_insert_message_new, Boolean.valueOf(r105));
        this.f447910q = false;
        PhotoInsertToInputView r106 = this.f447904k;
        if (r106 == null) goto L18;
        r106.a(false, false);
    L18:
        View r107 = this.f447902i;
        if (r107 == null) goto L28;
        if (this.f447908o == true) goto L23;
    L25:
        int r108 = 8;
    L26:
        r107.setVisibility(r108);
        goto L28
    L23:
        if (this.f447909p == true) goto L25;
        r108 = 0;
    L28:
        if (this.f447908o == true) goto L30;
    L72:
        LKUICheckBox r109 = this.f447899f;
        if (r109 == null) goto L75;
        r109.setOnCheckedChangeListener(new b(this));
    L75:
        TextView r110 = this.f447900g;
        if (r110 == null) goto L78;
        r110.setOnClickListener(new c(this));
    L78:
        View r111 = this.f447902i;
        if (r111 == null) goto L81;
        r111.setOnClickListener(new d(this));
    L81:
        PhotoInsertToInputView r112 = this.f447904k;
        if (r112 == null) goto L84;
        r112.setOnInsertClickListener(new e(this));
    L84:
        TextView r113 = this.f447901h;
        if (r113 == null) goto L87;
        r113.setOnClickListener(new f(this));
    L87:
        Intrinsics.checkNotNull(r101);
        return r101;
    L30:
        if (this.f447909p == true) goto L72;
        ViewGroup r114 = this.f447898e;
        LinearLayout.LayoutParams r115 = null;
        if (r114 == null) goto L34;
        ViewGroup.LayoutParams r116 = r114.getLayoutParams();
    L36:
        if ((r116 instanceof LinearLayout.LayoutParams) == false) goto L38;
        LinearLayout.LayoutParams r117 = (LinearLayout.LayoutParams) r116;
    L40:
        if (r117 == null) goto L44;
        r117.width = -2;
        r117.weight = 0.0f;
        ViewGroup r118 = this.f447898e;
        if (r118 == null) goto L44;
        r118.setLayoutParams(r117);
    L44:
        View r119 = this.f447905l;
        if (r119 == null) goto L49;
        ViewGroup.LayoutParams r120 = r119.getLayoutParams();
        if (r120 == null) goto L49;
        r120.width = UIUtils.dp2px(r119.getContext(), 12.0f);
        r119.setLayoutParams(r120);
    L49:
        View r121 = this.f447906m;
        if (r121 == null) goto L52;
        ViewGroup.LayoutParams r122 = r121.getLayoutParams();
    L54:
        if ((r122 instanceof LinearLayout.LayoutParams) == false) goto L56;
        LinearLayout.LayoutParams r123 = (LinearLayout.LayoutParams) r122;
    L57:
        if (r123 == null) goto L61;
        r123.width = 0;
        r123.weight = 1.0f;
        View r124 = this.f447906m;
        if (r124 == null) goto L61;
        r124.setLayoutParams(r123);
    L61:
        View r125 = this.f447907n;
        if (r125 == null) goto L64;
        ViewGroup.LayoutParams r126 = r125.getLayoutParams();
    L66:
        if ((r126 instanceof LinearLayout.LayoutParams) == false) goto L68;
        r115 = (LinearLayout.LayoutParams) r126;
    L68:
        if (r115 == null) goto L72;
        r115.width = -2;
        r115.weight = 0.0f;
        View r127 = this.f447907n;
        if (r127 == null) goto L72;
        r127.setLayoutParams(r115);
        goto L72
    L64:
        r126 = null;
        goto L66
    L56:
        r123 = null;
        goto L57
    L52:
        r122 = null;
        goto L54
    L38:
        r117 = null;
        goto L40
    L34:
        r116 = null;
        goto L36
    L12:
        if (r103.B == false) goto L14;
        r105 = true;
        goto L15
    L5:
        if (((rdc.e) this.f447895b).f537351b.f447877f.f447568m == false) goto L7;
        int r128 = 0;
    L8:
        r102.setVisibility(r128);
        goto L9
    L7:
        r128 = 4;
        goto L8
    }

    @Override // ldc.f
    public final void d(GridComponent.b r100) {
        GridComponent.b r101 = r100;
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f447911r = r101;
    }

    public a(String r100, rdc.e r101, k r102, l r103) {
        Intrinsics.checkNotNullParameter(r100, "actionTxt");
        Intrinsics.checkNotNullParameter(r101, "support");
        Intrinsics.checkNotNullParameter(r102, "sendListener");
        Intrinsics.checkNotNullParameter(r103, "insertListener");
        this.f447894a = r100;
        this.f447895b = r101;
        this.f447896c = r102;
        this.f447897d = r103;
    }
}
