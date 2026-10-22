package z42;

import com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.f;
import com.bytedance.android.livesdk.sharedpref.e;
import d52.b;
import d52.c;
import r52.q;

/* JADX INFO: loaded from: classes9.dex */
public final class a extends BaseStyleSettingModel<b> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f569929b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f569930c = null;

    static {
        f569930c = new a();
        f569929b = "public_screen_style_audience_height";
    }

    public final b e() {
        int r100 = f.f133636a;
        if (((Boolean) new e("audience_public_screen_setting_saved", Boolean.FALSE).getValue()).booleanValue() == true) goto L28;
        String r101 = l42.a.f507315b.getValue().get("public_screen_operate_freq");
        if (r101 != null) goto L7;
        r101 = "0";
    L7:
        int r102 = r101.hashCode();
        if (r102 == 49) goto L16;
        if (r102 == 51) goto L13;
    L18:
        int r103 = q.f536241a.getValue().normaFreq;
    L20:
        if (r103 == 1) goto L26;
        if (r103 == 2) goto L30;
        return b.C5636b.f466974a;
    L30:
        return b.a.f466973b;
    L26:
        return b.c.f466976b;
    L13:
        if (r101.equals("3") == false) goto L18;
        r103 = q.f536241a.getValue().highFreq;
        goto L20
    L16:
        if (r101.equals("1") == false) goto L18;
        r103 = q.f536241a.getValue().lowFreq;
        goto L20
    L28:
        return (b) super.b();
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel
    public final /* bridge */ /* synthetic */ c b() {
        return e();
    }

    public a() {
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel
    public final c a() {
        return b.c.f466976b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel
    public final String c() {
        return f569929b;
    }

    @Override // com.bytedance.android.livesdk.interactivity.api.publicscreen.stylesetting.model.BaseStyleSettingModel
    public final c d(int r100) {
        if (r100 == 1) goto L9;
        if (r100 == 2) goto L11;
        return b.C5636b.f466974a;
    L11:
        return b.a.f466973b;
    L9:
        return b.c.f466976b;
    }
}
