package tjb;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.lang.ref.WeakReference;
import kotlin.jvm.internal.Intrinsics;
import rjb.g;
import ujb.f;

/* JADX INFO: loaded from: classes36.dex */
public final class c extends tjb.a {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final ujb.d f546449i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final ujb.d f546450j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final Boolean f546451k;

    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ g f546452a;

        @Override // ujb.f
        public final void close() {
            this.f546452a.close();
        }

        @Override // ujb.f
        public final boolean d() {
            return this.f546452a.isShowing();
        }

        public a(g r100) {
            this.f546452a = r100;
        }
    }

    public static final class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ujb.d f546453a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f546454b;

        public b(ujb.d r100, f r101) {
            this.f546453a = r100;
            this.f546454b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ujb.d.a r101 = this.f546453a.f550462b;
            Intrinsics.checkNotNull(r100);
            r101.a(r100, this.f546454b);
        }
    }

    /* JADX INFO: renamed from: tjb.c$c, reason: collision with other inner class name */
    public static final class ViewOnClickListenerC7737c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ c f546455a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ f f546456b;

        public ViewOnClickListenerC7737c(c r100, f r101) {
            this.f546455a = r100;
            this.f546456b = r101;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            ujb.d.a r101 = this.f546455a.f546450j.f550462b;
            Intrinsics.checkNotNull(r100);
            r101.a(r100, this.f546456b);
        }
    }

    @Override // tjb.a
    public final void h() {
    }

    @Override // tjb.a
    public final boolean i() {
        Boolean r100 = this.f546451k;
        if (r100 != null) goto L7;
        return false;
    L7:
        return r100.booleanValue();
    }

    @Override // tjb.a
    public final f m(g r100) {
        Intrinsics.checkNotNullParameter(r100, "guide");
        return new a(r100);
    }

    public c(WeakReference<Activity> r100, ujb.c r110) {
        Intrinsics.checkNotNullParameter(r100, "activityRef");
        Intrinsics.checkNotNullParameter(r110, "config");
        super(r100, r110.f550457f, r110.f550458g, r110.f550456e, r110.f550455d, r110);
        this.f546449i = r110.f550459h;
        this.f546450j = r110.f550460i;
        this.f546451k = r110.f550452a;
    }

    @Override // tjb.a
    public final View n(Context r100, f r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "bubbleDelegate");
        boolean r102 = true;
        View r103 = LayoutInflater.from(r100).cloneInContext(r100).inflate(R.layout.guide_ui_button_bubble, new FrameLayout(r100), true);
        Intrinsics.checkNotNull(r103);
        FrameLayout r104 = (FrameLayout) r103.findViewById(R.id.image_container);
        if (r104 == null) goto L5;
        r104.setVisibility(8);
    L5:
        TextView r105 = (TextView) r103.findViewById(R.id.title);
        String r106 = null;
        if (r105 == null) goto L19;
        String r107 = this.f546440b;
        if (r107 != null) goto L10;
    L18:
        r105.setVisibility(8);
        goto L19
    L10:
        if (r107.length() <= 0) goto L12;
        boolean r108 = true;
    L13:
        if (r108 == true) goto L16;
        r107 = null;
    L16:
        if (r107 == null) goto L18;
        r105.setText(r107);
        goto L19
    L12:
        r108 = false;
    L19:
        View r109 = r103.findViewById(R.id.scrollable_detail);
        if (r109 == null) goto L22;
        r109.setVisibility(8);
    L22:
        TextView r110 = (TextView) r103.findViewById(R.id.detail);
        if (r110 == null) goto L35;
        r110.setVisibility(0);
        String r111 = this.f546441c;
        if (r111 != null) goto L27;
    L34:
        r110.setVisibility(8);
        goto L35
    L27:
        if (r111.length() > 0) goto L30;
        r102 = false;
    L30:
        if (r102 == false) goto L32;
        r106 = r111;
    L32:
        if (r106 == null) goto L34;
        r110.setText(r106);
    L35:
        ((TextView) r103.findViewById(R.id.step_info)).setVisibility(8);
        TextView r112 = (TextView) r103.findViewById(R.id.left_button);
        if (r112 == null) goto L41;
        ujb.d r113 = this.f546449i;
        if (r113 == null) goto L40;
        r112.setText(r113.f550461a);
        r112.setOnClickListener(new b(r113, r101));
        r112.setVisibility(0);
        goto L41
    L40:
        r112.setVisibility(8);
    L41:
        TextView r114 = (TextView) r103.findViewById(R.id.right_button);
        if (r114 == null) goto L44;
        r114.setText(this.f546450j.f550461a);
        r114.setOnClickListener(new ViewOnClickListenerC7737c(this, r101));
    L44:
        return r103;
    }
}
