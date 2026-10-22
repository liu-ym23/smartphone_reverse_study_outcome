package lib;

import android.app.Activity;
import android.content.DialogInterface;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;

/* JADX INFO: loaded from: classes36.dex */
public final class n implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f509480a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Activity f509481b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ KeyboardFunctionEditText f509482c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ q f509483d;

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(final DialogInterface r100, int r101) {
        final boolean r102 = this.f509480a;
        final Activity r103 = this.f509481b;
        final KeyboardFunctionEditText r104 = this.f509482c;
        final q r105 = this.f509483d;
        qqb.c.c(new m(r100, r102, r103, r104, r105));
    }

    public n(boolean r100, Activity r101, KeyboardFunctionEditText r102, com.ss.android.lark.forwardv2.impl.view.h r103) {
        this.f509480a = r100;
        this.f509481b = r101;
        this.f509482c = r102;
        this.f509483d = r103;
    }
}
