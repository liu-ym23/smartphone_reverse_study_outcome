package z52;

import android.widget.RadioGroup;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingFont;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes9.dex */
public final class e implements RadioGroup.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f570092a;

    public e(b r100) {
        this.f570092a = r100;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup r100, int r101) {
        if (r101 != R.id.live_barrage_font_small) goto L6;
        this.f570092a.f570084y.setFontSize(BarrageSettingFont.SMALL);
    L11:
        b r102 = this.f570092a;
        r102.e(r102.f570084y);
        xs2.b.a().post(new q22.b(this.f570092a.f570084y));
        return;
    L6:
        if (r101 != R.id.live_barrage_font_mid) goto L9;
        this.f570092a.f570084y.setFontSize(BarrageSettingFont.MID);
        goto L11
    L9:
        if (r101 != R.id.live_barrage_font_big) goto L11;
        this.f570092a.f570084y.setFontSize(BarrageSettingFont.BIG);
        goto L11
    }
}
