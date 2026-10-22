package nu0;

import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.ui.c9;
import kotlin.Unit;

/* JADX INFO: loaded from: classes47.dex */
public final class a implements DialogInterface.OnShowListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f520575a = null;

    static {
        f520575a = new a();
    }

    public a() {
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface r100) {
        if ((r100 instanceof c9) == true) goto L5;
        r100 = null;
    L5:
        c9 r101 = (c9) r100;
        if (r101 == null) goto L11;
        View r102 = r101.f112670e;
        if (r102 == null) goto L12;
        GradientDrawable r103 = new GradientDrawable();
        r103.setColor(-1);
        r103.setCornerRadius(s1.f(16.0f));
        Unit r104 = Unit.INSTANCE;
        r102.setBackground(r103);
        return;
    L12:
        return;
    }
}
