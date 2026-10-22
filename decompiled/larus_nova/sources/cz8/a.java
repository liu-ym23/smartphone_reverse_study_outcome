package cz8;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.larus.bmhome.view.ChatConstraintLayout;
import com.larus.nova.R;
import kotlin.jvm.internal.Intrinsics;
import va8.l;

/* JADX INFO: loaded from: classes26.dex */
public final class a implements l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ChatConstraintLayout f466057a;

    @Override // va8.l
    public final FrameLayout e() {
        return null;
    }

    @Override // va8.l
    public final RecyclerView getMessageList() {
        return null;
    }

    @Override // va8.l
    public final GridLayout a() {
        return (GridLayout) this.f466057a.findViewById(R.id.bottom_menu);
    }

    @Override // va8.l
    public final View b() {
        return this.f466057a.findViewById(R.id.splitter);
    }

    @Override // va8.l
    public final View c() {
        return this.f466057a.findViewById(R.id.input_intercept_view);
    }

    @Override // va8.l
    public final FrameLayout getInput() {
        return (FrameLayout) this.f466057a.findViewById(R.id.input);
    }

    @Override // va8.l
    public final FrameLayout getTitleContainer() {
        return (FrameLayout) this.f466057a.findViewById(R.id.larus_chat_job_main_title_container);
    }

    @Override // va8.l
    public final FrameLayout z8() {
        return (FrameLayout) this.f466057a.findViewById(R.id.bottom_layout);
    }

    @Override // va8.l
    public final ViewGroup d() {
        return this.f466057a;
    }

    @Override // va8.l
    public final ConstraintLayout getRootView() {
        return this.f466057a;
    }

    public a(ChatConstraintLayout r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        this.f466057a = r100;
    }
}
