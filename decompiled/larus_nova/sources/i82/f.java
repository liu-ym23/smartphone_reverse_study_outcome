package i82;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import com.bytedance.android.livesdk.chatroom.msgboard.VSMsgBoardDress;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
public abstract class f<T, VH extends RecyclerView.ViewHolder> extends me.drakeet.multitype.b<T, VH> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final CopyOnWriteArrayList<String> f488595b;

    public abstract void i(View r100, VSMsgBoardDress r101);

    public f() {
        this.f488595b = new CopyOnWriteArrayList();
    }

    public final int h(VSMsgBoardDress r100) {
        Intrinsics.checkNotNullParameter(r100, "itemData");
        int r101 = this.f513439a.f513437a.size();
        int r102 = 0;
    L3:
        if (r102 >= r101) goto L8;
        if (Intrinsics.areEqual(ListProtector.get(this.f513439a.f513437a, r102), r100) == true) goto L6;
        r102 = r102 + 1;
        goto L3
    L6:
        return r102;
    L8:
        return -1;
    }
}
