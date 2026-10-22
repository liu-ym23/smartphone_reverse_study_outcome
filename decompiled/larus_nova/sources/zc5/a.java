package zc5;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import y9c.d;

/* JADX INFO: loaded from: classes18.dex */
public final class a extends LinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final TextView f571268a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TextView f571269b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ImageView f571270c;

    /* JADX INFO: renamed from: zc5.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC8441a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f571271a;

        public ViewOnClickListenerC8441a(Function0<Unit> r100) {
            this.f571271a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            Function0<Unit> r101 = this.f571271a;
            if (r101 == null) goto L6;
            r101.invoke();
            return;
        }
    }

    public final TextView getLeftTitle() {
        return this.f571268a;
    }

    public a(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setLeftTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f571268a.setText(r100);
        this.f571268a.setVisibility(0);
    }

    public final void setMoreVisible(boolean r100) {
        TextView r101 = this.f571269b;
        int r102 = 0;
        if (r100 == false) goto L5;
        int r103 = 0;
    L6:
        r101.setVisibility(r103);
        ImageView r104 = this.f571270c;
        if (r100 == true) goto L10;
        r102 = 8;
    L10:
        r104.setVisibility(r102);
        return;
    L5:
        r103 = 8;
        goto L6
    }

    public final void setRightTitle(String r100) {
        Intrinsics.checkNotNullParameter(r100, "text");
        this.f571269b.setText(r100);
        this.f571269b.setVisibility(0);
    }

    public a(Context r110, Function0<Unit> r111) {
        Intrinsics.checkNotNullParameter(r110, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r110);
        int r100 = d.a(2);
        int r101 = d.a(14);
        int r102 = d.a(16);
        setOrientation(0);
        setBackgroundColor(r110.getResources().getColor(R.color.bg_body));
        TextView r103 = new TextView(r110);
        LinearLayout.LayoutParams r104 = new LinearLayout.LayoutParams(-2, -2, 1.0f);
        r104.setMarginStart(d.a(16));
        r104.topMargin = d.a(18);
        r104.bottomMargin = d.a(8);
        r103.setLayoutParams(r104);
        r103.setTextSize(16.0f);
        r103.setTextColor(r110.getResources().getColor(R.color.text_title));
        r103.setTypeface(Typeface.defaultFromStyle(1));
        r103.setSingleLine();
        r103.setEllipsize(TextUtils.TruncateAt.END);
        this.f571268a = r103;
        addView(r103);
        TextView r105 = new TextView(r110);
        r105.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r105.setTextSize(12.0f);
        r105.setTextColor(r110.getResources().getColor(R.color.text_placeholder));
        this.f571269b = r105;
        ImageView r106 = new ImageView(r110);
        LinearLayout.LayoutParams r107 = new LinearLayout.LayoutParams(r101, r101);
        r107.setMarginStart(r100);
        r106.setLayoutParams(r107);
        r106.setImageResource(R.drawable.ud_icon_right_outlined);
        r106.setImageTintList(AppCompatResources.getColorStateList(r110, R.color.icon_n3));
        this.f571270c = r106;
        LinearLayout r108 = new LinearLayout(r110);
        r108.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        r108.setOrientation(0);
        r108.setGravity(16);
        r108.addView(r105);
        r108.addView(r106);
        FrameLayout r109 = new FrameLayout(r110);
        r109.setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
        r109.setPadding(d.a(20), d.a(20), r102, 0);
        r109.setOnClickListener(new ViewOnClickListenerC8441a(r111));
        r109.addView(r108);
        addView(r109);
    }
}
