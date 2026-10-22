package mx;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.simple.SimpleViewHolder;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
public class m extends me.drakeet.multitype.b<o, RecyclerView.ViewHolder> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f516151b;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ m f516152a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f516153b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ o f516154c;

        public a(m r100, RecyclerView.ViewHolder r101, o r102) {
            this.f516152a = r100;
            this.f516153b = r101;
            this.f516154c = r102;
        }

        @Override // java.lang.Runnable
        public final void run() {
            m r100 = this.f516152a;     // Catch: Throwable -> L4
            RecyclerView.ViewHolder r101 = this.f516153b;     // Catch: Throwable -> L4
            o r102 = this.f516154c;     // Catch: Throwable -> L4
            r100.getClass();     // Catch: Throwable -> L4
            m.i(r101, r102);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public m(boolean r100) {
        this.f516151b = r100;
    }

    public static void i(RecyclerView.ViewHolder r100, o r101) {
        View r102 = r100.itemView;
        ViewGroup.LayoutParams r103 = r102.getLayoutParams();
        if (r103 != null) goto L5;
        return;
    L5:
        if ((r103 instanceof ViewGroup.MarginLayoutParams) == true) goto L7;
        ViewGroup.LayoutParams r104 = null;
    L8:
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
        if (r105 == null) goto L11;
        r105.setMargins(s1.f(r101.f516158d.left), s1.f(r101.f516158d.top), s1.f(r101.f516158d.right), s1.f(r101.f516158d.bottom));
    L11:
        r102.setLayoutParams(r103);
        return;
    L7:
        r104 = r103;
        goto L8
    }

    @Override // me.drakeet.multitype.b
    public /* bridge */ /* synthetic */ void b(RecyclerView.ViewHolder r100, o r101) {
        h(r100, r101);
    }

    @Override // me.drakeet.multitype.b
    public final RecyclerView.ViewHolder d(LayoutInflater r100, ViewGroup r101) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        Intrinsics.checkNotNullParameter(r101, "parent");
        return new SimpleViewHolder(new TextView(r101.getContext()));
    }

    public void h(RecyclerView.ViewHolder r100, o r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        View r102 = r100.itemView;
        if (r102 == null) goto L14;
        TextView r103 = (TextView) r102;
        if (this.f516151b == false) goto L7;
        r103.setTextColor(s1.h(R.color.ttlive_dialog_sub_content_text));
    L8:
        r103.setTextSize(1, r101.f516157c);
        r103.setText(r101.f516155a);
        if (r103.getLayoutParams() == null) goto L11;
        i(r100, r101);
        return;
    L11:
        r103.post(new a(this, r100, r101));
        return;
    L7:
        r103.setTextColor(s1.h(r101.f516156b));
        goto L8
    L14:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
    }
}
