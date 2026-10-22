package lm3;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class d extends Dialog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f509868a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f509869b;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public String f509870a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f509871b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f509872c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public View f509873d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public List<? extends c> f509874e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public Float f509875f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public Float f509876g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public Float f509877h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public boolean f509878i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        public boolean f509879j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public Integer f509880k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public boolean f509881l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public Function2<? super SimpleDraweeView, ? super String, Unit> f509882m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public int f509883n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        public final Context f509884o;

        public final d a() {
            if (this.f509881l == false) goto L5;
            this.f509883n = R.layout.uicomponent_strong_guide_common_alert_dialog;
        L5:
            d r100 = new d(this.f509884o, this);
            if (DialogLancet.shouldBlockDialogShow(r100) == false) goto L12;
            DialogLancet.handleBlockedDialogShow(r100);
        L10:
            return r100;
        L12:
            DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L11
        L9:
            DialogLancet.beforeDialogShow(r100);
            r100.show();
            DialogLancet.afterDialogShow(r100);
            goto L10
        }

        public a(Context r100) {
            Intrinsics.checkNotNullParameter(r100, "mContext");
            this.f509884o = r100;
            this.f509878i = true;
            this.f509879j = true;
            this.f509883n = R.layout.uicomponent_common_alert_dialog;
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // android.app.Dialog
    public final void show() {
        if (DialogLancet.shouldBlockDialogShow(this) == false) goto L24;
        DialogLancet.handleBlockedDialogShow(this);
    L8:
        if (getWindow() == null) goto L26;
        Window r100 = getWindow();
        if (r100 == null) goto L12;
        WindowManager.LayoutParams r101 = r100.getAttributes();
    L13:
        if (r101 == null) goto L15;
        r101.width = (int) fm3.e.a(getContext(), 280);
    L15:
        if (r101 == null) goto L17;
        r101.height = -2;
    L17:
        if (r101 == null) goto L19;
        r101.gravity = 17;
    L19:
        Window r102 = getWindow();
        if (r102 == null) goto L27;
        r102.setAttributes(r101);
        return;
    L27:
        return;
    L12:
        r101 = null;
        goto L13
    L26:
        return;
    L24:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L23
    L6:
        DialogLancet.beforeDialogShow(this);
        super.show();
        DialogLancet.afterDialogShow(this);
        goto L8
    }

    public final void a(CharSequence r100) {
        View r101 = this.f509868a;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L5:
        LinearLayout r102 = (LinearLayout) r101.findViewById(R.id.action_container);
        if (r102 == null) goto L13;
        View r103 = r102.getChildAt(0);
        if (r103 != null) goto L10;
        return;
    L10:
        if ((r103 instanceof TextView) == false) goto L15;
        ((TextView) r103).setText(r100);
        return;
    L15:
        return;
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r110) {
        super.onCreate(r110);
        ViewParent r100 = null;
        View r101 = LayoutInflater.from(getContext()).inflate(this.f509869b.f509883n, null);
        this.f509868a = r101;
        if (r101 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L5:
        setContentView(r101);
        int r102 = 1;
        setCancelable(true);
        View r103 = this.f509868a;
        if (r103 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("view");
    L8:
        Float r104 = this.f509869b.f509875f;
        if (r104 == null) goto L15;
        float r105 = r104.floatValue();
        ViewGroup.LayoutParams r106 = ((LinearLayout) r103.findViewById(R.id.content_container)).getLayoutParams();
        if (r106 == null) goto L14;
        int r107 = (int) fm3.e.a(getContext(), r105);
        ((LinearLayout.LayoutParams) r106).topMargin = r107;
        goto L15
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    L15:
        Float r108 = this.f509869b.f509876g;
        if (r108 == null) goto L20;
        float r109 = r108.floatValue();
        Float r111 = this.f509869b.f509877h;
        if (r111 == null) goto L20;
        float r112 = r111.floatValue();
        ((LinearLayout) r103.findViewById(R.id.content_container)).setPadding((int) fm3.e.a(getContext(), r109), 0, (int) fm3.e.a(getContext(), r112), 0);
    L20:
        a r113 = this.f509869b;
        View r114 = r113.f509873d;
        if (r114 == null) goto L32;
        ((LinearLayout) r103.findViewById(R.id.content_container)).removeAllViews();
        if (r114.getParent() == null) goto L31;
        ViewParent r115 = r114.getParent();
        if ((r115 instanceof ViewGroup) == false) goto L28;
        r100 = r115;
    L28:
        ViewGroup r116 = (ViewGroup) r100;
        if (r116 == null) goto L31;
        r116.removeView(r114);
    L31:
        ((LinearLayout) r103.findViewById(R.id.content_container)).addView(r114);
    L63:
        List<? extends c> r117 = this.f509869b.f509874e;
        if (r117 == null) goto L103;
        if (r117.isEmpty() == true) goto L108;
        int r118 = r117.size();
        int r119 = 17;
        int r120 = R.dimen.uicomponent_common_alert_dialog_action_height;
        int r121 = R.style.uicomponent_common_alert_dialog_main_action;
        int r122 = R.id.action_container;
        if (r118 != 2) goto L76;
        ((LinearLayout) r103.findViewById(R.id.action_container)).setOrientation(0);
        TextView r123 = new TextView(getContext());
        r123.setTextAppearance(getContext(), R.style.uicomponent_common_alert_dialog_normal_action);
        r123.setText(((c) ListProtector.get(r117, 0)).f509864b);
        r123.setOnClickListener(new e(this, r117));
        r123.setGravity(17);
        ((LinearLayout) r103.findViewById(R.id.action_container)).addView(r123);
        View r124 = new View(getContext());
        r124.setLayoutParams(new LinearLayout.LayoutParams((int) Math.floor(((double) getContext().getResources().getDimension(R.dimen.uicomponent_common_alert_dialog_action_divider_width)) + 0.5d), (int) getContext().getResources().getDimension(R.dimen.uicomponent_common_alert_dialog_action_height)));
        r124.setBackgroundColor(getContext().getResources().getColor(R.color.ttlive_std_line_modal));
        ((LinearLayout) r103.findViewById(R.id.action_container)).addView(r124);
        TextView r125 = new TextView(getContext());
        r125.setTextAppearance(getContext(), R.style.uicomponent_common_alert_dialog_main_action);
        r125.setText(((c) ListProtector.get(r117, 1)).f509864b);
        r125.setTypeface(Typeface.defaultFromStyle(1));
        r125.setOnClickListener(new f(this, r117));
        r125.setGravity(17);
        ((LinearLayout) r103.findViewById(R.id.action_container)).addView(r125);
        LinearLayout.LayoutParams r126 = new LinearLayout.LayoutParams(0, (int) getContext().getResources().getDimension(R.dimen.uicomponent_common_alert_dialog_action_height), 1.0f);
        LinearLayout.LayoutParams r127 = new LinearLayout.LayoutParams(0, (int) getContext().getResources().getDimension(R.dimen.uicomponent_common_alert_dialog_action_height), 1.0f);
        r123.setPadding((int) getContext().getResources().getDimension(R.dimen.uicomponent_common_alert_dialog_padding_left_right), 0, (int) getContext().getResources().getDimension(R.dimen.uicomponent_common_alert_dialog_padding_left_right), 0);
        r125.setPadding((int) getContext().getResources().getDimension(R.dimen.uicomponent_common_alert_dialog_padding_left_right), 0, (int) getContext().getResources().getDimension(R.dimen.uicomponent_common_alert_dialog_padding_left_right), 0);
        r125.setLayoutParams(r127);
        r123.setLayoutParams(r126);
        Typeface r128 = ((c) ListProtector.get(r117, 0)).f509866d;
        if (r128 == null) goto L73;
        r123.setTypeface(r128);
    L73:
        Typeface r129 = ((c) ListProtector.get(r117, 1)).f509866d;
        if (r129 == null) goto L103;
        r125.setTypeface(r129);
        goto L103
    L76:
        ((LinearLayout) r103.findViewById(R.id.action_container)).setOrientation(1);
        int r130 = r117.size();
        int r131 = 0;
    L77:
        if (r131 >= r130) goto L103;
        TextView r132 = new TextView(getContext());
        Context r133 = getContext();
        if (r131 == 0) goto L82;
        r121 = R.style.uicomponent_common_alert_dialog_normal_action;
    L82:
        r132.setTextAppearance(r133, r121);
        if (r131 != 0) goto L85;
        r132.setTypeface(Typeface.defaultFromStyle(r102));
    L85:
        String r134 = ((c) ListProtector.get(r117, r131)).f509864b;
        if (r134 != null) goto L88;
    L91:
        boolean r135 = true;
    L92:
        if (r135 == true) goto L101;
        r132.setText(((c) ListProtector.get(r117, r131)).f509864b);
        r132.setOnClickListener(new g(this, r117, r131));
        LinearLayout.LayoutParams r136 = new LinearLayout.LayoutParams(-1, (int) getContext().getResources().getDimension(r120));
        r136.setMargins((int) getContext().getResources().getDimension(R.dimen.uicomponent_common_alert_dialog_padding_left_right), 0, (int) getContext().getResources().getDimension(R.dimen.uicomponent_common_alert_dialog_padding_left_right), 0);
        r132.setLayoutParams(r136);
        r132.setGravity(r119);
        ((LinearLayout) r103.findViewById(r122)).addView(r132);
        if (r131 == CollectionsKt.getLastIndex(r117)) goto L98;
        View r137 = new View(getContext());
        r137.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) Math.floor(((double) getContext().getResources().getDimension(R.dimen.uicomponent_common_alert_dialog_divider_height)) + 0.5d)));
        r137.setBackgroundColor(getContext().getResources().getColor(R.color.ttlive_std_line_modal));
        ((LinearLayout) r103.findViewById(R.id.action_container)).addView(r137);
    L98:
        Typeface r138 = ((c) ListProtector.get(r117, r131)).f509866d;
        if (r138 == null) goto L101;
        r132.setTypeface(r138);
    L101:
        r131 = r131 + 1;
        r102 = 1;
        r119 = 17;
        r120 = R.dimen.uicomponent_common_alert_dialog_action_height;
        r121 = R.style.uicomponent_common_alert_dialog_main_action;
        r122 = R.id.action_container;
        goto L77
    L88:
        if (r134.length() == 0) goto L91;
        r135 = false;
    L108:
        setCanceledOnTouchOutside(this.f509869b.f509879j);
        return;
    L103:
        if (this.f509869b.f509878i == true) goto L105;
        r103.findViewById(R.id.divider).setVisibility(4);
    L105:
        Integer r139 = this.f509869b.f509880k;
        if (r139 == null) goto L108;
        int r140 = r139.intValue();
        ((LinearLayout) r103.findViewById(R.id.root_container)).setBackground(getContext().getDrawable(r140));
        goto L108
    L32:
        String r141 = r113.f509870a;
        if (r141 == null) goto L35;
        ((TextView) r103.findViewById(R.id.title)).setText(r141);
    L35:
        String r142 = this.f509869b.f509871b;
        if (r142 == null) goto L38;
        ((TextView) r103.findViewById(R.id.content)).setText(r142);
    L38:
        a r143 = this.f509869b;
        String r144 = r143.f509872c;
        if (r144 == null) goto L44;
        Function2<? super SimpleDraweeView, ? super String, Unit> r145 = r143.f509882m;
        if (r145 == null) goto L43;
        Unit r146 = r145.invoke(r103.findViewById(R.id.icon), r144);
    L43:
        ((SimpleDraweeView) r103.findViewById(R.id.icon)).setVisibility(0);
    L44:
        String r147 = this.f509869b.f509870a;
        if (r147 != null) goto L47;
    L50:
        boolean r148 = true;
    L52:
        if (r148 == false) goto L54;
        ((TextView) r103.findViewById(R.id.title)).setVisibility(8);
    L54:
        String r149 = this.f509869b.f509872c;
        if (r149 != null) goto L57;
    L60:
        boolean r150 = true;
    L61:
        if (r150 == false) goto L63;
        ((SimpleDraweeView) r103.findViewById(R.id.icon)).setVisibility(8);
        goto L63
    L57:
        if (r149.length() == 0) goto L60;
        r150 = false;
        goto L61
    L47:
        if (r147.length() == 0) goto L50;
        r148 = false;
        goto L52
    }

    public d(Context r100, a r101) {
        super(r100, R.style.uicomponent_custom_dialog);
        this.f509869b = r101;
    }
}
