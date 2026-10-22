package j45;

import androidx.fragment.app.FragmentActivity;
import bb5.h;
import com.bytedance.ee.bear.facade.common.BaseCommonActivity;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f497360a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ FragmentActivity f497361b;

    public /* synthetic */ a(c r100, FragmentActivity r101) {
        this.f497360a = r100;
        this.f497361b = r101;
    }

    @Override // bb5.h
    public final void onDismiss() {
        c r100 = this.f497360a;
        FragmentActivity r101 = this.f497361b;
        r100.getClass();
        if ((r101 instanceof BaseCommonActivity) == false) goto L9;
        b r102 = r100.f497365b;
        if (r102 == null) goto L10;
        ((ArrayList) ((BaseCommonActivity) r101).f226395b.f226398a).remove(r102);
        r100.f497365b = null;
        return;
    L10:
        return;
    }
}
