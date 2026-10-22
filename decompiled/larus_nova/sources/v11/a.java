package v11;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import kotlin.Unit;
import qr2.c;

/* JADX INFO: loaded from: classes47.dex */
public final class a {

    /* JADX INFO: renamed from: v11.a$a, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC7955a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f552398a;

        public ViewOnClickListenerC7955a(TextView r100) {
            this.f552398a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            c r101 = (c) vh6.c.b(c.class);
            if (r101 == null) goto L6;
            r101.openMockLinkDialog(this.f552398a.getContext());
            return;
        }
    }

    public static final void a(ViewGroup r100) {
        if (r100 == null) goto L5;
        TextView r101 = new TextView(r100.getContext());
        r101.setText("连");
        r101.setTextSize(UtilityKotlinExtentionsKt.h(12));
        r101.setGravity(17);
        r101.setBackgroundColor(ColorProtector.parseColor("#33ffffff"));
        r101.setOnClickListener(new ViewOnClickListenerC7955a(r101));
        Unit r102 = Unit.INSTANCE;
        FrameLayout.LayoutParams r103 = new FrameLayout.LayoutParams(UtilityKotlinExtentionsKt.i(48), UtilityKotlinExtentionsKt.i(48));
        r103.gravity = 21;
        r103.rightMargin = UtilityKotlinExtentionsKt.i(16);
        r100.addView(r101, r103);
        return;
    }
}
