package t94;

import android.location.Location;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.bytedance.bdp.appbase.locate.map.BdpMapActivity;
import com.larus.nova.R;
import java.util.Objects;

/* JADX INFO: loaded from: classes11.dex */
public final class g implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BdpMapActivity f545086a;

    public g(BdpMapActivity r100) {
        this.f545086a = r100;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        BdpMapActivity r101 = this.f545086a;
        r101.f200810m = true;
        if (r101.f200811n == null) goto L15;
        Location r102 = r101.f200815r;
        if (r102 == null) goto L7;
        r101.f200817t.showLocateBluePoint(r102);
    L7:
        BdpMapActivity r103 = this.f545086a;
        r103.f200817t.moveCameraToLatLng(r103.f200811n);
        BdpMapActivity r104 = this.f545086a;
        r104.f200817t.setScale(r104.f200816s);
        if (Objects.equals(this.f545086a.f200799b.getDrawable().getCurrent().getConstantState(), ContextCompat.getDrawable(this.f545086a, R.drawable.bdpapp_m_map_sentinel_select).getConstantState()) == true) goto L15;
        this.f545086a.f200799b.setImageResource(R.drawable.bdpapp_m_map_sentinel_select);
    L15:
        this.f545086a.f200817t.startLocation();     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
    }
}
