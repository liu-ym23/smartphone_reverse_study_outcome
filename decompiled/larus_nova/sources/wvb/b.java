package wvb;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.larksuite.component.universe_design.color.UDColorUtils;

/* JADX INFO: loaded from: classes37.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f561601a = 0;

    static {
    }

    public static void a(ImageView r100, int r101, int r102) {
        if (r100 == null) goto L7;
        r100.setImageResource(r101);
        Drawable r103 = r100.getDrawable();
        if (r103 == null) goto L8;
        r103.setTint(UDColorUtils.getColor(r100.getContext(), r102));
        return;
    L8:
        return;
    }
}
