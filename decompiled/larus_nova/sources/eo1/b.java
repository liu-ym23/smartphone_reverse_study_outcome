package eo1;

import android.content.DialogInterface;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.android.live.room.h;
import com.bytedance.ies.sdk.widgets.api.WidgetService;
import hh1.v0;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import nz.r;

/* JADX INFO: loaded from: classes8.dex */
public final class b extends com.bytedance.android.livesdk.chatroom.ui.framework.base.a {
    public final PropertyOwner<Boolean> A;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public r f473258s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public com.bytedance.android.live.pushstream.d f473259t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public v0 f473260u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public h.a f473261v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final List<View.OnTouchListener> f473262w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final List<DialogInterface.OnKeyListener> f473263x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f473264y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final PropertyOwner<Boolean> f473265z;

    public static final class a {
    }

    static {
    }

    public b(Fragment r100) {
        Intrinsics.checkNotNullParameter(r100, WidgetService.PARAM_FRAGMENT);
        super(r100, false);
        this.f473262w = new ArrayList();
        this.f473263x = new ArrayList();
        Boolean r101 = Boolean.FALSE;
        this.f473265z = new PropertyOwner(r101);
        this.A = new PropertyOwner(r101);
    }
}
