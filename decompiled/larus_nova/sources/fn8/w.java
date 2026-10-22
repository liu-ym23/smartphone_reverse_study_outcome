package fn8;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.GravityCompat;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.bmhome.chat.markdown.imagegroup.view.MarkdownSourceImageView;
import com.larus.bmhome.chat.standarduikit.richmedia.view.RichMediaOverlayAlignment;
import com.larus.common_ui.video.VideoPlayView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: classes26.dex */
public final class w extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SimpleDraweeView f478003a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public VideoPlayView f478004b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public MarkdownSourceImageView f478005c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public AppCompatImageView f478006d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public AppCompatTextView f478007e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public LinearLayout f478008f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public LinearLayout f478009g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f478010h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public c0 f478011i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public o f478012j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public e f478013k;

    public static final class a extends ViewOutlineProvider {
        public a() {
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r100, Outline r101) {
            Intrinsics.checkNotNullParameter(r100, "view");
            Intrinsics.checkNotNullParameter(r101, "outline");
            r101.setRoundRect(0, 0, r100.getWidth(), r100.getHeight(), i5.r0());
        }
    }

    public static final class b {
    }

    static {
    }

    public static GradientDrawable a() {
        GradientDrawable r100 = new GradientDrawable();
        r100.setShape(0);
        r100.setCornerRadius(i5.r0());
        r100.setColor(Color.argb(77, 0, 0, 0));
        return r100;
    }

    public w(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        SimpleDraweeView r101 = new SimpleDraweeView(r100);
        ((GenericDraweeHierarchy) r101.getHierarchy()).setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        GradientDrawable r102 = new GradientDrawable();
        r102.setCornerRadius(i5.r0());
        r102.setColor(ColorUtils.setAlphaComponent(ContextCompat.getColor(r100, v19.c.b(R.attr.larus_neutral_100, r100, R.color.larus_neutral_100)), 10));
        r101.setBackground(r102);
        this.f478003a = r101;
        setOutlineProvider(new a());
        setClipToOutline(true);
        addView(r101, new FrameLayout.LayoutParams(-1, -1));
    }

    public static FrameLayout.LayoutParams b(int r100) {
        FrameLayout.LayoutParams r101 = new FrameLayout.LayoutParams(-2, i5.O(), r100 | 80);
        if (r100 != 8388611) goto L5;
        r101.setMarginStart(i5.r0());
    L6:
        r101.bottomMargin = i5.r0();
        return r101;
    L5:
        r101.setMarginEnd(i5.r0());
        goto L6
    }

    public static FrameLayout.LayoutParams e(RichMediaOverlayAlignment r100) {
        int r101 = i5.q();
        int r102 = i5.q();
        RichMediaOverlayAlignment r103 = RichMediaOverlayAlignment.START;
        if (r100 != r103) goto L5;
        int r104 = GravityCompat.START;
    L6:
        FrameLayout.LayoutParams r105 = new FrameLayout.LayoutParams(r101, r102, r104 | 48);
        if (r100 != r103) goto L9;
        r105.setMarginStart(i5.j0());
        r105.topMargin = i5.j0();
    L10:
        return r105;
    L9:
        r105.setMarginEnd(i5.r0());
        r105.topMargin = i5.r0();
        goto L10
    L5:
        r104 = GravityCompat.END;
        goto L6
    }

    public final void c(boolean r100) {
        if (r100 == false) goto L7;
        AppCompatImageView r101 = this.f478006d;
        if (r101 != null) goto L6;
        r101 = new AppCompatImageView(getContext());
        r101.setImageResource(R.drawable.larus_md_video_group_play_ic);
        this.f478006d = r101;
        FrameLayout.LayoutParams r102 = new FrameLayout.LayoutParams(i5.A(), i5.A(), 8388661);
        r102.setMarginEnd(i5.j0());
        r102.topMargin = i5.j0();
        Unit r103 = Unit.INSTANCE;
        addView(r101, r102);
    L6:
        r101.setVisibility(0);
        return;
    L7:
        AppCompatImageView r104 = this.f478006d;
        if (r104 == null) goto L12;
        r104.setVisibility(8);
        return;
    }

    public final void d(boolean r100) {
        String r101 = this.f478010h;
        if (r101 == null) goto L7;
        c0 r102 = this.f478011i;
        if (r102 == null) goto L7;
        r102.h(r101);
    L7:
        VideoPlayView r103 = this.f478004b;
        if (r103 == null) goto L10;
        r103.setOnClickListener(null);
        r103.setOnLongClickListener(null);
        r103.setVisibility(8);
    L10:
        if (r100 == false) goto L15;
        VideoPlayView r104 = this.f478004b;
        if (r104 == null) goto L14;
        removeView(r104);
    L14:
        this.f478004b = null;
    L15:
        this.f478003a.setVisibility(0);
    }
}
