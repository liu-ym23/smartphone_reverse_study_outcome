package mx8;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f516334a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final float f516335b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final float f516336c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Paint f516337d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Paint f516338e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final float f516339f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final float f516340g;

    public e(Context r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r101, "text");
        this.f516334a = r101;
        float r102 = r100.getResources().getDimension(R.dimen.larus_edu_clip_number_min_width);
        this.f516335b = r102;
        float r103 = r100.getResources().getDimension(R.dimen.larus_edu_clip_number_text_padding_hor);
        this.f516336c = r100.getResources().getDimension(R.dimen.larus_edu_clip_number_text_margin_end);
        Paint r104 = new Paint();
        r104.setTextSize(r100.getResources().getDimension(R.dimen.larus_edu_clip_number_text_size));
        r104.setTypeface(Typeface.DEFAULT_BOLD);
        r104.setColor(-1);
        this.f516337d = r104;
        Paint r105 = new Paint();
        r105.setColor(ColorProtector.parseColor("#88191919"));
        this.f516338e = r105;
        float r106 = r104.measureText(r101);
        this.f516339f = r106;
        this.f516340g = Math.max(r102, r106 + (2 * r103));
    }
}
