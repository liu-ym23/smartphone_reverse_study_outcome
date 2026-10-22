package y42;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.q;
import d52.c;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends BaseStyleSettingModel<d52.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f565986b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f565987c = null;

    static {
        f565987c = new a();
        f565986b = "public_screen_style_audience_font_size";
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel
    public final c a() {
        float r100 = q.i();
        if (r100 != 1.15f) goto L6;
        return d52.a.C5635a.f466968b;
    L6:
        if (r100 != 1.3f) goto L9;
        return d52.a.b.f466970b;
    L9:
        return d52.a.c.f466971a;
    }

    public a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel
    public final String c() {
        return f565986b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel
    public final c d(int r100) {
        if (r100 == 1) goto L9;
        if (r100 == 2) goto L11;
        return d52.a.c.f466971a;
    L11:
        return d52.a.b.f466970b;
    L9:
        return d52.a.C5635a.f466968b;
    }
}
