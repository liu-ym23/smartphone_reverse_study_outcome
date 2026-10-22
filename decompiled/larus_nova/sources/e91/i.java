package e91;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class i extends a<AnchorTabLabel> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f471446c;

    @Override // e91.a
    public final void c() {
        super.c();
        ViewGroup r100 = this.f471424b.getContainer();
        if (r100 == null) goto L20;
        ViewGroup r101 = this.f471424b.getContainer();
        View r102 = null;
        if (r101 == null) goto L9;
        Context r103 = r101.getContext();
        if (r103 == null) goto L9;
        Object r104 = r103.getSystemService("layout_inflater");
    L11:
        if ((r104 instanceof LayoutInflater) == true) goto L13;
        r104 = null;
    L13:
        LayoutInflater r105 = (LayoutInflater) r104;
        if (r105 == null) goto L18;
        View r106 = r105.inflate(R.layout.ttlive_user_info_text_label_view, r100, false);
        if (r106 == null) goto L18;
        r100.addView(r106);
        Unit r107 = Unit.INSTANCE;
        r102 = r106;
    L18:
        this.f471446c = r102;
        return;
    L9:
        r104 = null;
        goto L11
    }

    public i(com.bytedance.android.live.room.navi.userinfo_p.presenter.h r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        super(r100);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.d
    public final void a(AnchorTabLabel r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
        String r101 = r100.getContent();
        if (r101 != null) goto L5;
    L10:
        ViewGroup r102 = this.f471424b.getContainer();
        if (r102 == null) goto L19;
        View r103 = this.f471446c;
        if (r103 == null) goto L17;
        TextView r104 = (TextView) r103.findViewById(R.id.label_text);
        if (r104 == null) goto L17;
        r104.setText(r100.getContent());
    L17:
        r102.setVisibility(0);
        return;
    L19:
        return;
    L5:
        if (r101.length() != 0) goto L7;
        boolean r105 = true;
    L8:
        if (r105 != true) goto L10;
        return;
    L7:
        r105 = false;
        goto L8
    }
}
