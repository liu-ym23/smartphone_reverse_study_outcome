package com.larus.community.impl.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBindings;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.ixigua.lib.track.TrackParams;
import com.larus.common_ui.widget.roundlayout.RoundLinearLayout;
import com.larus.community.impl.databinding.LarusCommunityCreateButtonBinding;
import com.larus.nova.R;
import com.larus.utils.CubicBezierInterpolator;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;
import r29.b;
import r29.d;
import r29.e;
import v19.i5;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000  2\u00020\u0001:\u0001 B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\u0006\u0010\u0018\u001a\u00020\u0016J\b\u0010\u0019\u001a\u00020\u0016H\u0002J\u001a\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001d\u001a\u00020\u000eH\u0002J\u0012\u0010\u001e\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\f\u0010\u001f\u001a\u00020\u0016*\u00020\u001cH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006!"}, d2 = {"Lcom/larus/community/impl/view/CommunityCreateButton;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "binding", "Lcom/larus/community/impl/databinding/LarusCommunityCreateButtonBinding;", "showAnimator", "Landroid/animation/AnimatorSet;", "hideAnimator", "totalY", "", "value", "", "isShow", "()Z", "setShow", "(Z)V", "show", "", "hide", "renderGradientStyle", "gradientTextTask", "zoomOutAnimation", "view", "Landroid/view/View;", "scaleSize", "zoomInAnimation", "bounceWhenPressedItem", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommunityCreateButton extends FrameLayout {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f329928f = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LarusCommunityCreateButtonBinding f329929a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnimatorSet f329930b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public AnimatorSet f329931c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f329932d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f329933e;

    public static final class a {
    }

    static {
    }

    public final void a() {
        TextView r100 = this.f329929a.f329018b;
        r100.getPaint().setShader(new LinearGradient(0.0f, 0.0f, r100.getWidth(), r100.getHeight(), new int[]{ColorProtector.parseColor("#FF9851"), ColorProtector.parseColor("#FF6C55"), ColorProtector.parseColor("#BC72FF"), ColorProtector.parseColor("#5083E5")}, null, Shader.TileMode.CLAMP));
        FLogger.f375446a.i("CommunityCreateButton", "width:" + r100.getWidth() + ", height:" + r100.getHeight());
        setAlpha(1.0f);
        r100.setAlpha(1.0f);
        r100.invalidate();
    }

    public final void b() {
        TextView r100 = this.f329929a.f329018b;
        if (r100.getWidth() != 0) goto L5;
    L8:
        r100.post(new r29.a(this));
        return;
    L5:
        if (r100.getHeight() == 0) goto L8;
        a();
    }

    public CommunityCreateButton(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, null);
    }

    public final void setShow(boolean r110) {
        if (r110 != this.f329933e) goto L5;
        return;
    L5:
        this.f329933e = r110;
        if (r110 == false) goto L16;
        JSONObject r100 = new JSONObject();
        Intrinsics.checkNotNullParameter(r100, "params");
        r100.put("current_page", "ai_generate");     // Catch: JSONException -> L10
    L12:
        TrackParams r111 = new TrackParams().merge(r100);
        by7.a r101 = new by7.a("show_create_button");
        r101.f21463a.merge(r111);
        r101.b();
        AnimatorSet r112 = this.f329931c;
        if (r112 == null) goto L15;
        r112.cancel();
    L15:
        this.f329931c = null;
        ObjectAnimator r113 = ObjectAnimator.ofFloat(this, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{this.f329932d, 0.0f});
        r113.setInterpolator(new CubicBezierInterpolator(0.38f, 1.35f, 0.8f));
        ObjectAnimator r102 = ObjectAnimator.ofFloat(this, "alpha", new float[]{getAlpha(), 1.0f});
        AnimatorSet r103 = new AnimatorSet();
        r103.play(r113).with(r102);
        r103.setDuration((long) ((1 - getAlpha()) * 300));
        r103.addListener(new e(this));
        r103.start();
        this.f329930b = r103;
        return;
    L10:
        e = move-exception;
        FLogger.f375446a.e("CommunityEventHelper", "error in CommunityEventHelper mobShowCreateButton " + e.getLocalizedMessage());
        goto L12
    L16:
        AnimatorSet r114 = this.f329930b;
        if (r114 == null) goto L19;
        r114.cancel();
    L19:
        this.f329930b = null;
        ObjectAnimator r115 = ObjectAnimator.ofFloat(this, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, this.f329932d});
        ObjectAnimator r104 = ObjectAnimator.ofFloat(this, "alpha", new float[]{getAlpha(), 0.0f});
        AnimatorSet r105 = new AnimatorSet();
        r105.play(r115).with(r104);
        r105.setDuration((long) (getAlpha() * 300));
        r105.addListener(new d(this));
        r105.start();
        this.f329931c = r105;
    }

    public CommunityCreateButton(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        LayoutInflater.from(r100).inflate(R.layout.larus_community_create_button, this);
        int r102 = R.id.community_create_btn;
        if (((RoundLinearLayout) ViewBindings.findChildViewById(this, R.id.community_create_btn)) == null) goto L9;
        r102 = R.id.community_create_btn_text;
        TextView r103 = (TextView) ViewBindings.findChildViewById(this, R.id.community_create_btn_text);
        if (r103 == null) goto L9;
        LarusCommunityCreateButtonBinding r104 = new LarusCommunityCreateButtonBinding(this, r103);
        setOnTouchListener(new b(this, this));
        this.f329929a = r104;
        this.f329932d = i5.u0();
        return;
    L9:
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(r102)));
    }
}
