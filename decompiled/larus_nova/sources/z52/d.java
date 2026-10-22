package z52;

import android.widget.RadioGroup;
import com.bytedance.android.livesdk.interactivity.api.barrage.model.BarrageSettingArea;
import com.larus.nova.R;
import zg1.e3;

/* JADX INFO: loaded from: classes9.dex */
public final class d implements RadioGroup.OnCheckedChangeListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ b f570091a;

    public d(b r100) {
        this.f570091a = r100;
    }

    @Override // android.widget.RadioGroup.OnCheckedChangeListener
    public final void onCheckedChanged(RadioGroup r100, int r101) {
        if (r101 != R.id.live_barrage_setting_close) goto L5;
        this.f570091a.a(true);
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r102 = l42.a.f507320g;
        Boolean r103 = Boolean.TRUE;
        r102.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r102, r103);
        xs2.b.a().post(new e3(true, 0, "setting_landscape_dialog"));
    L15:
        b r104 = this.f570091a;
        r104.e(r104.f570084y);
        xs2.b.a().post(new q22.b(this.f570091a.f570084y));
        return;
    L5:
        this.f570091a.b();
        com.bytedance.android.livesdk.sharedpref.e<Boolean> r105 = l42.a.f507320g;
        Boolean r106 = Boolean.FALSE;
        r105.getClass();
        com.bytedance.android.livesdk.sharedpref.f.d(r105, r106);
        xs2.b.a().post(new e3(false, 0, "setting_landscape_dialog"));
        this.f570091a.f570084y.setNeedRollback(false);
        if (r101 != R.id.live_barrage_setting_top) goto L9;
        this.f570091a.f570084y.setBarrageArea(BarrageSettingArea.TOP);
    L14:
        b r107 = this.f570091a;
        r107.d(r107.f570084y);
        goto L15
    L9:
        if (r101 != R.id.live_barrage_setting_half) goto L12;
        this.f570091a.f570084y.setBarrageArea(BarrageSettingArea.HALF);
        goto L14
    L12:
        if (r101 != R.id.live_barrage_setting_full) goto L14;
        this.f570091a.f570084y.setBarrageArea(BarrageSettingArea.FULL);
        goto L14
    }
}
