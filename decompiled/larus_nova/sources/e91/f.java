package e91;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.android.livehostapi.foundation.IHostFrescoHelper;
import com.bytedance.android.livesdkapi.depend.model.live.AnchorTabLabel;
import com.larus.nova.R;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: classes47.dex */
public final class f extends a<AnchorTabLabel> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public View f471442c;

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
        View r106 = r105.inflate(R.layout.ttlive_user_info_img_and_text_label_view, r100, false);
        if (r106 == null) goto L18;
        r100.addView(r106);
        Unit r107 = Unit.INSTANCE;
        r102 = r106;
    L18:
        this.f471442c = r102;
        return;
    L9:
        r104 = null;
        goto L11
    }

    public f(com.bytedance.android.live.room.navi.userinfo_p.presenter.h r100) {
        Intrinsics.checkNotNullParameter(r100, "callback");
        super(r100);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo.cert.d
    public final void a(AnchorTabLabel r100) {
        Intrinsics.checkNotNullParameter(r100, "tabLabel");
        if (this.f471423a == true) goto L24;
        ViewGroup r101 = this.f471424b.getContainer();
        if (r101 == null) goto L23;
        this.f471423a = true;
        View r102 = this.f471442c;
        TextView r103 = null;
        if (r102 == null) goto L10;
        ImageView r104 = (ImageView) r102.findViewById(R.id.label_img);
    L11:
        View r105 = this.f471442c;
        if (r105 == null) goto L14;
        r103 = (TextView) r105.findViewById(R.id.label_text);
    L14:
        k r106 = r100.getIcon();
        if (r106 == null) goto L17;
        ((IHostFrescoHelper) jc1.k.n(IHostFrescoHelper.class)).loadFirstAvailableImageBitmap(r106, new e(this, r104));
    L17:
        String r107 = r100.getContent();
        if (r107 == null) goto L21;
        if (r103 == null) goto L21;
        r103.setText(r107);
    L21:
        r101.setVisibility(0);
        return;
    L10:
        r104 = null;
        goto L11
    L23:
        return;
    }
}
