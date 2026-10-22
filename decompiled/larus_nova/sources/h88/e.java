package h88;

import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.nova.R;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import v19.h;

/* JADX INFO: loaded from: classes24.dex */
public final class e extends d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f484293e;

    @Override // h88.d
    public final void d(boolean r100) {
    }

    @Override // h88.d
    public final void c() {
        b(this.f484291c);
    }

    public final AppCompatImageView e() {
        View r100 = this.f484289a;
        if ((r100 instanceof AppCompatImageView) == true) goto L7;
        return null;
    L7:
        return (AppCompatImageView) r100;
    }

    public e() {
        this.f484293e = "LLMVideoButtonState";
    }

    @Override // h88.d
    public String getType() {
        return this.f484293e;
    }

    @Override // h88.d
    public final void a(boolean r100) {
        if (this.f484291c == false) goto L7;
        if (r100 == true) goto L7;
        FLogger.f375446a.w(getType(), "llm video btn is selected, can't not set disabled");
        return;
    L7:
        super.a(r100);
    }

    @Override // h88.d
    public final void b(boolean r100) {
        super.b(r100);
        b r101 = null;
        if (r100 == false) goto L27;
        AppCompatImageView r102 = e();
        if (r102 == null) goto L7;
        int r103 = j0.f375426a;
        r102.setContentDescription(j0.d(R.string.larus_call_accessibility_turnOffVideoHint));
    L7:
        boolean r104 = h.f552477a;
        if (h.a(null) == false) goto L12;
        AppCompatImageView r105 = e();
        if (r105 == null) goto L15;
        r105.setImageResource(R.drawable.larus_ic_real_call_llm_video_dark_selected);
    L15:
        Function0<? extends b> r106 = this.f484292d;
        if (r106 == null) goto L18;
        r101 = r106.invoke();
    L18:
        if (r101 == null) goto L22;
        boolean r107 = r101.f484277r;
        boolean r108 = true;
        if (r107 != true) goto L22;
    L23:
        if (r108 == false) goto L39;
        AppCompatImageView r109 = e();
        if (r109 == null) goto L40;
        r109.setImageResource(R.drawable.larus_ic_video_call_open_full);
        return;
    L40:
        return;
    L39:
        return;
    L22:
        r108 = false;
        goto L23
    L12:
        AppCompatImageView r110 = e();
        if (r110 == null) goto L15;
        r110.setImageResource(R.drawable.larus_ic_real_call_llm_video_light);
        goto L15
    L27:
        AppCompatImageView r111 = e();
        if (r111 == null) goto L30;
        int r112 = j0.f375426a;
        r111.setContentDescription(j0.d(R.string.larus_call_accessibility_turnOnVideoHint));
    L30:
        boolean r113 = h.f552477a;
        if (h.a(null) == false) goto L35;
        AppCompatImageView r114 = e();
        if (r114 == null) goto L42;
        r114.setImageResource(R.drawable.larus_ic_vlm_video_unselected_dark);
        return;
    L42:
        return;
    L35:
        AppCompatImageView r115 = e();
        if (r115 == null) goto L44;
        r115.setImageResource(R.drawable.larus_ic_video_call_unselected);
        return;
    }
}
