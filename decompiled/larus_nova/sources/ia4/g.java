package ia4;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.larus.nova.R;
import kotlin.TypeCastException;

/* JADX INFO: loaded from: classes11.dex */
public final class g extends Dialog {
    public g(Context r100) {
        super(r100, R.style.microapp_m_BottomOptionDialog);
    }

    @Override // android.app.Dialog
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        View r101 = LayoutInflater.from(getContext()).inflate(R.layout.bdp_bottom_menu_dialog, null, false);
        if (r101 == null) goto L5;
        ViewGroup r102 = (ViewGroup) r101;
        r102.findViewById(R.id.bdp_bottom_menu_cancel).setOnClickListener(new f(this));
        r102.findViewById(R.id.bdp_bottom_menu_line);
        throw null;
    L5:
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }
}
