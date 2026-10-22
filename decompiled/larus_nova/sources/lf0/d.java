package lf0;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.live.liveinteract.api.utils.g;
import com.bytedance.android.live.liveinteract.interact.audience.ui.StarView;
import com.bytedance.android.live.ui.PingFangSCTextView;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes46.dex */
public final class d extends FrameLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Map<Integer, View> f509037a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Integer[] f509038b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public k f509039c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public k f509040d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f509041e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f509042f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public View.OnClickListener f509043g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public View.OnClickListener f509044h;

    public static final class a {
    }

    static {
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent r100) {
        return true;
    }

    public final k getAvatar() {
        return this.f509040d;
    }

    public final k getLabel() {
        return this.f509039c;
    }

    public final long getNumOfLink() {
        return this.f509041e;
    }

    public final View.OnClickListener getOnCloseClickListener() {
        return this.f509044h;
    }

    public final View.OnClickListener getOnConfirmClickListener() {
        return this.f509043g;
    }

    public final float getScore() {
        return this.f509042f;
    }

    public final Integer[] getStarsId() {
        return this.f509038b;
    }

    public d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        this.f509037a = new LinkedHashMap();
        LayoutInflater.from(r100).inflate(R.layout.ttlive_interact_profile_card, this);
        this.f509038b = new Integer[]{Integer.valueOf(R.id.star1), Integer.valueOf(R.id.star2), Integer.valueOf(R.id.star3), Integer.valueOf(R.id.star4), Integer.valueOf(R.id.star5)};
    }

    public final View a(int r100) {
        if (this.f509037a != null) goto L5;
        this.f509037a = new LinkedHashMap();
    L5:
        View r101 = this.f509037a.get(Integer.valueOf(r100));
        if (r101 != null) goto L12;
        View r102 = findViewById(r100);
        if (r102 == null) goto L10;
        this.f509037a.put(Integer.valueOf(r100), r102);
        return r102;
    L10:
        return null;
    L12:
        return r101;
    }

    public final void setAnchor(boolean r100) {
        PingFangSCTextView r101 = (PingFangSCTextView) a(R.id.tv_confirm);
        Resources r102 = getContext().getResources();
        if (r100 == false) goto L5;
        int r103 = R.string.ttlive_interact_profile_card_status_opened;
    L6:
        r101.setText(r102.getString(r103));
        return;
    L5:
        r103 = R.string.ttlive_interact_profile_card_apply;
        goto L6
    }

    public final void setAvatar(k r100) {
        this.f509040d = r100;
        HSImageView r101 = (HSImageView) a(R.id.image_avatar);
        if (r100 == null) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        if (r100 == null) goto L10;
        ImageLoader.load(r100).a((HSImageView) a(R.id.image_avatar));
        return;
    L10:
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setLabel(k r100) {
        this.f509039c = r100;
        HSImageView r101 = (HSImageView) a(R.id.profile_label);
        if (r100 == null) goto L5;
        int r102 = 0;
    L6:
        r101.setVisibility(r102);
        if (r100 == null) goto L10;
        ImageLoader.load(r100).a((HSImageView) a(R.id.profile_label));
        return;
    L10:
        return;
    L5:
        r102 = 8;
        goto L6
    }

    public final void setNumOfLink(long r100) {
        if (r100 >= 0) goto L5;
        return;
    L5:
        this.f509041e = r100;
        PingFangSCTextView r101 = (PingFangSCTextView) a(R.id.tv_content);
        if (r100 == 0) goto L8;
        String r102 = getContext().getResources().getString(R.string.ttlive_interact_profile_card_content, new Object[]{Long.valueOf(r100)});
    L9:
        r101.setText(r102);
        return;
    L8:
        r102 = getContext().getResources().getString(R.string.ttlive_interact_profile_card_content_when_no_link_num);
        goto L9
    }

    public final void setOnCloseClickListener(View.OnClickListener r100) {
        this.f509044h = r100;
        ((HSImageView) a(R.id.image_close)).setOnClickListener(r100);
    }

    public final void setOnConfirmClickListener(View.OnClickListener r100) {
        this.f509043g = r100;
        ((PingFangSCTextView) a(R.id.tv_confirm)).setOnClickListener(r100);
    }

    public final void setScore(float r100) {
        if (r100 >= 0.0f) goto L5;
    L18:
        HashMap r101 = new HashMap();
        r101.put("log", "score set not within boundary, score " + r100);
        g.s("ProfileCard", r101);
        return;
    L5:
        if (r100 > 5.0f) goto L18;
        this.f509042f = r100;
        Integer[] r102 = this.f509038b;
        int r103 = r102.length;
        int r104 = 0;
    L8:
        if (r104 >= r103) goto L17;
        int r105 = r102[r104].intValue();
        if (r100 <= 0.0f) goto L24;
        if (r100 >= 1.0f) goto L15;
        ((StarView) findViewById(r105)).setPercent(r100);
        r100 = 0.0f;
    L16:
        r104 = r104 + 1;
        goto L8
    L15:
        ((StarView) findViewById(r105)).setPercent(1.0f);
        r100 = r100 - 1.0f;
        goto L16
    L24:
        return;
    }
}
