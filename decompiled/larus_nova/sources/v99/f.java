package v99;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.biz.im.api.extension.keyboard.attachment.UplinkFileEntity;
import com.ss.android.lark.keyboard.editor.input.BaseRichTextInputPlugin;
import java.util.List;
import kotlin.Lazy;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;

/* JADX INFO: loaded from: classes29.dex */
public final class f implements wxa.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f553851a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ViewGroup f553852b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Lazy<w99.a> f553853c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Fragment f553854d;

    @Override // wxa.a
    public final ViewGroup q2() {
        this.f553852b = null;
        w99.a r100 = g.b(this.f553853c);
        if (r100 == null) goto L5;
        ViewGroup r101 = r100.q2();
    L6:
        w99.a r102 = g.b(this.f553853c);
        if (r102 == null) goto L9;
        View r103 = r102.yr();
    L10:
        w99.a r104 = g.b(this.f553853c);
        if (r104 == null) goto L13;
        View r105 = r104.y8();
    L14:
        if (r101 != null) goto L17;
        if (r103 != null) goto L17;
        return null;
    L17:
        Context r106 = this.f553854d.requireContext();
        LinearLayout r107 = new LinearLayout(r106);
        r107.setOrientation(1);
        r107.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (r101 == null) goto L20;
        r107.addView(r101);
    L20:
        if (r103 == null) goto L30;
        LinearLayout r108 = new LinearLayout(r106);
        r108.setOrientation(1);
        r108.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
        if (this.f553851a == false) goto L24;
        int r109 = 0;
    L25:
        r108.setVisibility(r109);
        if (r101 == null) goto L29;
        if (r105 == null) goto L29;
        r108.addView(r105);
    L29:
        r108.addView(r103);
        this.f553852b = r108;
        r107.addView(r108);
        goto L30
    L24:
        r109 = 8;
    L30:
        return r107;
    L13:
        r105 = null;
        goto L14
    L9:
        r103 = null;
        goto L10
    L5:
        r101 = null;
        goto L6
    }

    @Override // wxa.a
    public final void W0() {
        w99.a r100 = g.b(this.f553853c);
        if (r100 == null) goto L6;
        r100.W0();
        return;
    }

    @Override // wxa.a
    public final i1<List<UplinkFileEntity>> k1() {
        w99.a r100 = g.b(this.f553853c);
        if (r100 == null) goto L7;
        i1<List<UplinkFileEntity>> r101 = r100.k1();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return j1.a(CollectionsKt.emptyList());
    }

    @Override // wxa.a
    public final List<UplinkFileEntity> q1() {
        w99.a r100 = g.b(this.f553853c);
        if (r100 == null) goto L7;
        List<UplinkFileEntity> r101 = r100.q1();
        if (r101 == null) goto L7;
        return r101;
    L7:
        return CollectionsKt.emptyList();
    }

    @Override // wxa.a
    public final boolean Y5(List<? extends Uri> r100) {
        Intrinsics.checkNotNullParameter(r100, "uris");
        w99.a r101 = g.b(this.f553853c);
        if (r101 != null) goto L5;
    L7:
        return false;
    L5:
        if (r101.Y5(r100) != true) goto L7;
        return true;
    }

    @Override // wxa.a
    public final void a(boolean r100) {
        this.f553851a = r100;
        ViewGroup r101 = this.f553852b;
        if (r101 == null) goto L9;
        if (r100 == false) goto L6;
        int r102 = 0;
    L7:
        r101.setVisibility(r102);
        return;
    L6:
        r102 = 8;
        goto L7
    }

    @Override // wxa.a
    public final void o3(BaseRichTextInputPlugin.n r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        w99.a r101 = g.b(this.f553853c);
        if (r101 == null) goto L6;
        r101.o3(r100);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f(Lazy<? extends w99.a> r100, Fragment r101) {
        this.f553853c = r100;
        this.f553854d = r101;
        this.f553851a = true;
    }
}
