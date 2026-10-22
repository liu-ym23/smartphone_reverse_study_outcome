package fz8;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.larus.chat.job.impl.ui.ChatJobTimePickerViewKt$createTimeWheelColumn$2$1;
import com.larus.chat.job.impl.ui.TimeWheelAdapter;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes26.dex */
public final class u {
    public static final RecyclerView a(Context r110, List r111, Object r112, boolean r113, int r114, ViewGroup.LayoutParams r210, int r211, float r212, Function1 r213, final Function1 r214) {
        Integer r100 = Integer.valueOf(r111.indexOf(r112));
        if (r100.intValue() < 0) goto L5;
        boolean r101 = true;
    L7:
        if (r101 == true) goto L10;
        r100 = null;
    L10:
        if (r100 == null) goto L12;
        final int r102 = r100.intValue();
    L13:
        if (r113 == true) goto L15;
    L18:
        final TimeWheelAdapter r103 = new TimeWheelAdapter(r111, r102, r113, r114, r212, gz8.g.b(r110), gz8.g.c(r110), r213);
        final LinearLayoutManager r104 = new LinearLayoutManager(r110, 1, false);
        final LinearSnapHelper r105 = new LinearSnapHelper();
        RecyclerView r106 = new RecyclerView(r110);
        r106.setLayoutManager(r104);
        r106.setAdapter(r103);
        r106.setItemAnimator(null);
        r106.setOverScrollMode(2);
        r106.setClipToPadding(false);
        r106.setPadding(0, r211, 0, r211);
        r106.setLayoutParams(r210);
        r105.attachToRecyclerView(r106);
        r106.addOnScrollListener(new ChatJobTimePickerViewKt$createTimeWheelColumn$2$1(r105, r103, r214));
        r106.post(new t(r104, r102, r103));
        return r106;
    L15:
        if (r111.size() <= 1) goto L18;
        r102 = r102 + (1073741823 - (1073741823 % r111.size()));
        goto L18
    L12:
        r102 = 0;
        goto L13
    L5:
        r101 = false;
        goto L7
    }
}
