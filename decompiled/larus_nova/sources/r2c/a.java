package r2c;

import android.os.SystemClock;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.ss.android.lark.log.Log;
import com.ss.android.lark.newemoji.emoji_panel.DefaultEmojiPanelData;
import com.ss.android.lark.reaction.widget.panel.ReactionPanelFacade;
import com.ss.android.lark.reaction.widget.panel.c;
import com.ss.android.lark.statistics.Statistics;
import kotlin.jvm.internal.Intrinsics;
import s5c.d;
import z5c.z0;

/* JADX INFO: loaded from: classes37.dex */
public abstract class a implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f535848a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f535849b;

    public a() {
        this.f535848a = 500;
        this.f535848a = 500;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r100) {
        long r101 = SystemClock.uptimeMillis();
        long r102 = r101 - this.f535849b;
        this.f535849b = r101;
        if (r102 >= this.f535848a) goto L6;
        Log.i("OnSingleClickListener", "elapsedTime is short than LENGTH_SHORT");
        return;
    L6:
        c r103 = (c) this;
        r103.f439492c.f439463n.setVisibility(8);
        ReactionPanelFacade r104 = r103.f439492c;
        ImageView r105 = r104.f439465p;
        TransitionManager.beginDelayedTransition((ViewGroup) r104.f439460k, new AutoTransition().setOrdering(0).setDuration(100).setInterpolator(PathInterpolatorCompat.create(0.4f, 0.8f, 0.74f, 1.0f)));
        int r106 = com.ss.android.lark.reaction.widget.panel.a.f439490a;
        ReactionPanelFacade r107 = r103.f439492c;
        d r108 = r107.f439473x.value;
        DefaultEmojiPanelData r109 = r107.f439475z;
        if (r109 != null) goto L9;
    L11:
        s5c.a r110 = z0.f570428d;
    L12:
        d r111 = r108.plus(r110);
        Intrinsics.checkNotNullParameter(r111, "extraParams");
        Statistics.sendEvent("public_reaction_panel_select_view", r111.toJson());
        r103.f439492c.f439462m.setVisibility(0);
        r103.f439492c.f439461l.setVisibility(8);
        ReactionPanelFacade.b r112 = r103.f439492c.f439451b;
        if (r112 == null) goto L16;
        r112.b();
        return;
    L16:
        return;
    L9:
        if (r109.c() == false) goto L11;
        r110 = z0.f570427c;
        goto L12
    }
}
