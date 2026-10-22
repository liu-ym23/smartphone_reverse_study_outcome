package z72;

import android.widget.TextView;
import com.bytedance.android.live.base.model.data.d;
import com.bytedance.android.livesdk.interactivity.grouplive.CollaborateWidget;
import com.bytedance.android.livesdkapi.depend.room.EnterRoomRedirect;
import io.reactivex.functions.Consumer;
import java.util.Map;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes9.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f570637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f570638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Map f570639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ CollaborateWidget f570640d;

    public a(Ref.LongRef r100, d r101, Map r102, CollaborateWidget r103) {
        this.f570637a = r100;
        this.f570638b = r101;
        this.f570639c = r102;
        this.f570640d = r103;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r110) {
        Long r111 = (Long) r110;
        Ref.LongRef r112 = this.f570637a;
        long r100 = r112.element;
        if (r100 <= 1) goto L7;
        long r101 = r100 - 1;
        r112.element = r101;
        TextView r113 = this.f570640d.f136879a;
        if (r113 == null) goto L9;
        r113.setText(String.valueOf(r101));
        return;
    L9:
        return;
    L7:
        CollaborateWidget.xq(this.f570640d, this.f570638b.d(), this.f570639c, null, null, false, EnterRoomRedirect.REDIRECT_FROM_COLLABORATE_MESSAGE, false, 92);
    }
}
